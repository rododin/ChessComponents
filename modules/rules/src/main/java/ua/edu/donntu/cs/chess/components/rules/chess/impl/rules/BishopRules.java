/*
 * BishopRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;

/**
 * Description.
 */
public class BishopRules
	extends PieceRules
{
	public boolean isMovePossible()
	{
		if ((board.getAreaAt(endPosition.getX(), endPosition.getY()).getPiece() == null)||
				(board.getAreaAt(endPosition.getX(), endPosition.getY()).getPiece().getColor() == opponentColor))
		{
			if (Math.abs(startPosition.getX() - endPosition.getX()) != Math.abs(startPosition.getY() - endPosition.getY()))
				return false;
			else
				return true;
		}
		else
			return false;
	}
}
