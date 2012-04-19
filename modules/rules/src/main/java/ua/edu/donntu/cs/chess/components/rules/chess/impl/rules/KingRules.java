/*
 * KingRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;

/**
 * Description.
 */
public class KingRules
	extends PieceRules
{
	public boolean isMovePossible()
	{
		// check move distance
		final int yAbsDiff = Math.abs(endPosition.getY() - startPosition.getY());
		final int xAbsDiff = Math.abs(endPosition.getX() - startPosition.getX());
		if (yAbsDiff > 1 || xAbsDiff > 1)
		{
			return false;
		}

		// check move with fight
		final Piece endPiece = getPiece(board, endPosition);
		if (endPiece != null && endPiece.getColor() != opponentColor)
		{
			return false;
		}

		return true;
	}
}
