/*
 * PieceRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;
import ua.edu.donntu.cs.chess.components.rules.*;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.*;

import java.util.Map;

/**
 * Description.
 */
public abstract class PieceRules
{
	public void setRules(RulesImpl rules)
	{
		this.rules = rules;
	}

	public void setColor(Color color)
	{
		ourColor = color;
		opponentColor = (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	public void setCurrentMove(Position startPosition, Position endPosition)
	{
		this.startPosition = startPosition;
		this.endPosition = endPosition;

		yDiff = endPosition.getY() - startPosition.getY();
		xDiff = endPosition.getX() - startPosition.getX();

		yAbsDiff = Math.abs(yDiff);
		xAbsDiff = Math.abs(xDiff);
	}

	public void setGame(Game game)
	{
		this.game = game;

		board = game.getBoard();

		moves = game.getMoves();

		String lastMove = game.getLastMove();
		previousMoveExists = !lastMove.isEmpty();
		if (previousMoveExists)
		{
			prevStartPosition = parsePosition(lastMove.substring(0, 2));
			prevEndPosition = parsePosition(lastMove.substring(2, 4));
		}
	}

	public static Position parsePosition(String position)
	{
		final int x = position.charAt(0) - 'a';
		final int y = position.charAt(1) - '1';
		return new StandardPosition(x, y);
	}

	public abstract boolean isMovePossible();

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

	protected boolean fieldsOnFire()
	{
		final int yDelta = yDiff/((yDiff != 0) ? yAbsDiff : 1);
		final int xDelta = xDiff/((xDiff != 0) ? xAbsDiff : 1);

		Position runner = startPosition;
		while (true)
		{
			if (fieldOnFire(runner))
			{
				return true;
			}
			if (runner.equals(endPosition))
			{
				break;
			}
			runner = new StandardPosition(runner.getX() + xDelta,
					runner.getY() + yDelta);
		}
		return false;
	}

	protected Piece getPiece(Position position)
	{
		final Area endArea = board.getAreaAt(position.getX(), position.getY());
		return endArea.getPiece();
	}

	private boolean fieldOnFire(Position fieldPosition)
	{
		final Map<Position, Area> areaMap = board.getAreaMap();
		for (Map.Entry<Position, Area> areaEntry : areaMap.entrySet())
		{
			final Position position = areaEntry.getKey();
			final Area area = areaEntry.getValue();

			final Piece piece = area.getPiece();
			if (piece == null || piece.getColor() != opponentColor)
			{
				continue;
			}

			if (rules.checkMove(game, position, fieldPosition))
			{
				return true;
			}
		}
		return false;
	}

	protected String moves;
	protected RulesImpl rules;
	protected Board board;
	protected Color opponentColor;

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

	private Game game;
}
