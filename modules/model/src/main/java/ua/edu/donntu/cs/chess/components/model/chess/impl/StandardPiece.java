/*
 * StandardPiece.java
 */

package ua.edu.donntu.cs.chess.components.model.chess.impl;

import ua.edu.donntu.cs.chess.components.model.chess.Color;
import ua.edu.donntu.cs.chess.components.model.chess.Piece;
import ua.edu.donntu.cs.chess.components.model.chess.PieceName;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardPiece
	implements Piece
{
// Constructors --------------------------------------------------------------------------------------------------------

	public StandardPiece(PieceName name, Color color)
	{
		this.name = name;
		this.color = color;
		string = color.getLocalizedColor() + ' ' + name.getLocalizedName();
	}

// Piece Implementation ------------------------------------------------------------------------------------------------

	public PieceName getName()
	{
		return name;
	}

	public Color getColor()
	{
		return color;
	}

	@Override
	public String toString()
	{
		return string;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final StandardPiece that = (StandardPiece) o;
		return color == that.color && name == that.name;
	}

	@Override
	public int hashCode()
	{
		int result = name.hashCode();
		result = 31 * result + color.hashCode();
		return result;
	}

// Attributes ----------------------------------------------------------------------------------------------------------

	private final PieceName name;
	private final Color color;
	private final String string;
}
