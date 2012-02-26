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
		if ((startPosition.getX() != endPosition.getX()) && (startPosition.getY() != endPosition.getY()))
			return false;// Rook goes only horizontally and vertically

		final Map<Position,Area> areaMap = board.getAreaMap();

		for (Map.Entry<Position, Area> areaEntry : areaMap.entrySet())
		{
			final Position position = areaEntry.getKey();
			final Area area = areaEntry.getValue();
			if ((position.getX() == endPosition.getX()) || (position.getY() == endPosition.getY())) // compare only Horizontal and Vertical cells
				if ((area.getPiece() != null) &&
					(position.hashCode() != endPosition.hashCode()) &&
					(position.hashCode() != startPosition.hashCode()))
					return false;
				else
					if (((area.getPiece() == null)||(area.getPiece() != null && area.getPiece().getColor() == opponentColor)) &&
						(position.hashCode() == endPosition.hashCode())) // If this move take piece
						return true;
		}
		return true;
	}
}
