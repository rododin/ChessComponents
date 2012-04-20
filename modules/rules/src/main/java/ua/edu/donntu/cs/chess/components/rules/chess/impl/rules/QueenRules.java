/*
 * QueenRules.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl.rules;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;

/**
 * Description.
 */
public class QueenRules
	extends PieceRules
{
	public boolean isMovePossible()
	{
		return ((yAbsDiff == xAbsDiff || (yAbsDiff == 0 || xAbsDiff == 0)) &&
				checkFight() &&
				!arePiecesOnTheWay());
	}
}
