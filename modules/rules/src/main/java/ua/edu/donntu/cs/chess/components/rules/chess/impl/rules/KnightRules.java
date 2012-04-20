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
		return (((yAbsDiff == 2 && xAbsDiff == 1 || yAbsDiff == 1 && xAbsDiff == 2)) &&
				checkFight());
	}
}
