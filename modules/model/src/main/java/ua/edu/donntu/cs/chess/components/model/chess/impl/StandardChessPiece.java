/*
 * StandardPiece.java
 */

package ua.edu.donntu.cs.chess.components.model.chess.impl;

import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.AbstractPiece;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardChessPiece
	extends AbstractPiece<ChessPieceName>
{
// Constructors --------------------------------------------------------------------------------------------------------

	public StandardChessPiece(ChessPieceName name, Color color)
	{
		super (name, color);
	}
}
