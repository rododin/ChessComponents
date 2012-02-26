/*
 * PawnRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;

/**
 * Description.
 */
public class PawnRules
	extends PieceRules
{
	public boolean isMovePossible()
	{
		int maxStep = 1;
		if (ourColor == Color.WHITE && startPosition.getY() == 1)
			maxStep = 2;
		else if (ourColor == Color.BLACK && startPosition.getY() == 6)
			maxStep = 2;

		// check move distance
		final int yDiff = endPosition.getY() - startPosition.getY();
		final int yAbsDiff = Math.abs(yDiff);
		final int xAbsDiff = Math.abs(endPosition.getX() - startPosition.getX());
		if (yAbsDiff > maxStep)
			return false;

		// check move direction
		final int allowed = (ourColor == Color.WHITE) ? +1 : -1;
		if (yDiff*allowed < 0)
			return false;

		final Piece endPiece = getPiece(board, endPosition);

		// check simple move
		if (endPiece == null)
		{
			if (yAbsDiff == 2)
			{
				// check long move
				final int middleY = startPosition.getY() + (int)Math.signum(yDiff);
				Position middlePosition = new StandardPosition(startPosition.getX(), middleY);
				Piece middlePiece = getPiece(board, middlePosition);
				if (middlePiece != null)
					return false;
			}
			else if (xAbsDiff == 1)
			{
				// check En Passant
				if (isEnPassant())
					return true;
			}
			return xAbsDiff == 0;
		}

		// check move with fight
		if (endPiece.getColor() == opponentColor)
			return xAbsDiff == 1;

		return false;
	}

	private boolean isEnPassant()
	{
		if (!previousMoveExists)
			return false;

		if (getPiece(board, prevEndPosition).getName() != ChessPieceName.PAWN)
			return false;

		if (Math.abs(prevEndPosition.getY() - prevStartPosition.getY()) != 2)
			return false;

		if (prevEndPosition.getX() != endPosition.getX())
			return false;

		return true;
	}
}
