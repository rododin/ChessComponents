/*
 * CheckerPieceName.java
 */

package ua.edu.donntu.cs.chess.components.model.checkers;

import ua.edu.donntu.cs.chess.components.model.Constants;
import ua.edu.donntu.cs.chess.components.model.PieceName;

/**
 * Description.
 *
 * @author Rod Odin
 */
public enum CheckerPieceName
	implements Constants, PieceName
{
	DRAUGHT, KING;

	public String getLocalizedName()
	{
		// TODO: Implement localization support
		return toString();
	}
}
