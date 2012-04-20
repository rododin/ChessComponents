/*
 * PieceRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;

/**
 * Description.
 */
public abstract class PieceRules
{
	public void setBoard(Board board)
	{
		this.board = board;
	}

	public void setColor(Color color)
	{
		ourColor = color;
		opponentColor = (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	public void setCurrentMove(String move)
	{
		startPosition = parsePosition(move.substring(0, 2));
		endPosition = parsePosition(move.substring(2, 4));

		yDiff = endPosition.getY() - startPosition.getY();
		xDiff = endPosition.getX() - startPosition.getX();

		yAbsDiff = Math.abs(yDiff);
		xAbsDiff = Math.abs(xDiff);
	}

	public void setPreviousMove(String move)
	{
		previousMoveExists = !move.isEmpty();
		if (previousMoveExists)
		{
			prevStartPosition = parsePosition(move.substring(0, 2));
			prevEndPosition = parsePosition(move.substring(2, 4));
		}
	}

	private Position parsePosition(String position)
	{
		final int x = position.charAt(0) - 'a';
		final int y = position.charAt(1) - '1';
		return new StandardPosition(x, y);
	}

	public abstract boolean isMovePossible();

	protected Piece getPiece(Position position)
	{
		final Area endArea = board.getAreaAt(position.getX(), position.getY());
		return endArea.getPiece();
	}

	protected boolean checkFight()
	{
		final Piece endPiece = getPiece(endPosition);
		return (endPiece == null || endPiece.getColor() == opponentColor);
    }

	protected boolean arePiecesOnTheWay()
	{
		final int yDelta = yDiff/((yDiff != 0) ? yAbsDiff : 1);
		final int xDelta = xDiff/((xDiff != 0) ? xAbsDiff : 1);

		Position runner = new StandardPosition(startPosition.getX() + xDelta,
				startPosition.getY() + yDelta);
		while (!runner.equals(endPosition))
		{
			final Piece piece = getPiece(runner);
			if (piece != null)
			{
				return true;
			}
			runner = new StandardPosition(runner.getX() + xDelta,
					runner.getY() + yDelta);
		}
		return false;
	}

	protected Color ourColor;
	protected boolean previousMoveExists;

    protected int yDiff, xDiff;
    protected int yAbsDiff, xAbsDiff;

	// positions of current move
	protected Position startPosition;
	protected Position endPosition;

	// positions of previous move
	protected Position prevStartPosition;
	protected Position prevEndPosition;

	private Board board;
	private Color opponentColor;
}
