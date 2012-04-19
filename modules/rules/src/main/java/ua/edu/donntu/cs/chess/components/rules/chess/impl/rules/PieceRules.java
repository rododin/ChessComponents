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

	protected Piece getPiece(Board board, Position position)
	{
		final Area endArea = board.getAreaAt(position.getX(), position.getY());
		return endArea.getPiece();
	}

	protected boolean arePiecesOnTheWay()
	{
		final int yDiff = endPosition.getY() - startPosition.getY();
		final int xDiff = endPosition.getX() - startPosition.getX();
		final int yDelta = yDiff/Math.abs(yDiff);
		final int xDelta = xDiff/Math.abs(xDiff);

		Position runner = new StandardPosition(startPosition.getX() + xDelta,
				startPosition.getY() + yDelta);
		while (!runner.equals(endPosition))
		{
			final Piece piece = getPiece(board, runner);
			if (piece != null)
			{
				return true;
			}
			runner = new StandardPosition(runner.getX() + xDelta,
					runner.getY() + yDelta);
		}
		return false;
	}

	protected Board board;
	protected Color ourColor;
	protected Color opponentColor;
	protected boolean previousMoveExists;

	// positions of current move
	protected Position startPosition;
	protected Position endPosition;

	// positions of previous move
	protected Position prevStartPosition;
	protected Position prevEndPosition;
}
