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
		if (isSimpleMove() && checkFight())
		{
			return true;
		}
		if (isCastling() && isCastlingPossible())
		{
			return true;
		}
		return false;
	}

	private boolean isSimpleMove()
	{
		return yAbsDiff <= 1 && xAbsDiff <= 1;
	}

	private boolean isCastlingPossible()
	{
		return !arePiecesOnTheWay() && !figuresWereMoved() && !fieldsOnFire();
	}

	private boolean isCastling()
	{
		Piece endPiece = getPiece(endPosition);
		if (endPiece == null || endPiece.getColor() != ourColor)
		{
			return false;
		}

		if (startPosition.getX() != 4)
		{
			return false;
		}

		final int startRow = (ourColor == Color.WHITE) ? 0 : 7;
		if (startPosition.getY() != startRow || endPosition.getY() != startRow)
		{
			return false;
		}

		if (endPosition.getX() != 0 && endPosition.getX() != 7)
		{
			return false;
		}

		return true;
	}

	private boolean figuresWereMoved()
	{
		return figureWasMoved(startPosition) || figureWasMoved(endPosition);
	}

	private boolean figureWasMoved(Position position)
	{
		String positionName = "";
		positionName += (char)('a' + position.getX());
		positionName += (char)('1' + position.getY());

		for (int i = 0; i < moves.length(); i += 4)
		{
			if (moves.substring(i, i + 2).equals(positionName))
			{
				return true;
			}
		}
		return false;
	}
}
