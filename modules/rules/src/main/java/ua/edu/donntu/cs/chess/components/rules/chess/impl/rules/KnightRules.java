/*
 * KnightRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;

/**
 * Description.
 */
public class KnightRules
	extends PieceRules
{
	public boolean isMovePossible()
	{
		final int yAbsDiff = Math.abs(endPosition.getY() - startPosition.getY());
		final int xAbsDiff = Math.abs(endPosition.getX() - startPosition.getX());

		// check move distances
		if (!(yAbsDiff == 2 && xAbsDiff == 1 || yAbsDiff == 1 && xAbsDiff == 2))
			return false;

		final Piece endPiece = getPiece(board, endPosition);

		// check simple move
		if (endPiece == null)
			return true;

		// check simple move
		return endPiece.getColor() == opponentColor;
	}
}
