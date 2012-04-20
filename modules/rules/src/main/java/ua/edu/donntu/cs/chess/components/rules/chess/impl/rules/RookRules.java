/*
 * RookRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;

import java.util.Map;

/**
 * Description.
 */
public class RookRules
	extends PieceRules
{
	public boolean isMovePossible()
	{
		// check move direction
		final int yDiff = endPosition.getY() - startPosition.getY();
		final int xDiff = endPosition.getX() - startPosition.getX();
		if (yDiff != 0 && xDiff != 0)
		{
			return false;
		}

		// check move with fight
		final Piece endPiece = getPiece(board, endPosition);
		if (endPiece != null && endPiece.getColor() != opponentColor)
		{
			return false;
		}

		// check pieces on the way
		if (arePiecesOnTheWay())
		{
			return false;
		}

		return true;
	}
}
