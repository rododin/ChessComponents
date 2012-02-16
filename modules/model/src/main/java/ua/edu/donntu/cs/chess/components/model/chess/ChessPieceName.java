/*
 * PieceType.java
 */

package ua.edu.donntu.cs.chess.components.model.chess;

import ua.edu.donntu.cs.chess.components.model.Constants;
import ua.edu.donntu.cs.chess.components.model.PieceName;

/**
 * Description.
 *
 * @author Rod Odin
 */
public enum ChessPieceName
	implements Constants, PieceName
{
	KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN;

	public String getLocalizedName()
	{
		// TODO: Implement localization support
		return toString();
	}
}

