/*
 * QueenRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;

import java.util.Map;

/**
 * Description.
 */
public class QueenRules
	extends PieceRules
{
	public boolean isMovePossible()
	{
		if ((board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece() == null)||
			(board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece().getColor() == opponentColor))
		{
			// check diagonally moves
			if (Math.abs(startPosition.getX() - endPosition.getX()) != Math.abs(startPosition.getY() - endPosition.getY()))
			{
				final Map<Position,Area> areaMap = board.getAreaMap();
				for (Map.Entry<Position, Area> areaEntry : areaMap.entrySet())
				{
					final Position position = areaEntry.getKey();
					final Area area = areaEntry.getValue();
					if ((position.getX() == endPosition.getX()) || (position.getY() == endPosition.getY())) // compare only Horizontal and Vertical cells
					{
						if ((area.getPiece() != null) &&
							(position.hashCode() != endPosition.hashCode()) &&
							(position.hashCode() != startPosition.hashCode()))
							return false;
						else
							if (((area.getPiece() == null)||(area.getPiece() != null && area.getPiece().getColor() == opponentColor)) &&
								(position.hashCode() == endPosition.hashCode())) // If this move take piece
							return true;
					}
				}
			}
			else
				return true;
		}
		else
			return false;

		return false;
	}
}
