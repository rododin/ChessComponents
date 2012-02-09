/*
 * PieceType.java
 */

package ua.edu.donntu.cs.chess.components.model.chess;

/**
 * Description.
 *
 * @author Rod Odin
 */
public enum PieceName
{
	KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN;

	public String getLocalizedName()
	{
		// TODO: Implement localization support
		return toString();
	}
}

