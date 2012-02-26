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
		if ((board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece() == null)||
				(board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece().getColor() == opponentColor))
		{
			if (((startPosition.getX() - 1 	== endPosition.getX()) && (startPosition.getY() - 1 == endPosition.getY())) ||
				((startPosition.getX() 		== endPosition.getX()) && (startPosition.getY() - 1 == endPosition.getY())) ||
				((startPosition.getX() + 1 	== endPosition.getX()) && (startPosition.getY() - 1 == endPosition.getY())) ||
				((startPosition.getX() + 1 	== endPosition.getX()) && (startPosition.getY() 	== endPosition.getY())) ||
				((startPosition.getX() + 1 	== endPosition.getX()) && (startPosition.getY() + 1 == endPosition.getY())) ||
				((startPosition.getX() 		== endPosition.getX()) && (startPosition.getY() + 1 == endPosition.getY())) ||
				((startPosition.getX() - 1 	== endPosition.getX()) && (startPosition.getY() + 1 == endPosition.getY())) ||
				((startPosition.getX() - 1 	== endPosition.getX()) && (startPosition.getY() 	== endPosition.getY()))    )
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
