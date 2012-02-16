/*
 * AbstractPiece.java
 */

package ua.edu.donntu.cs.chess.components.model.impl;

import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.model.Piece;
import ua.edu.donntu.cs.chess.components.model.PieceName;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class AbstractPiece <PN extends PieceName>
	implements Piece
{
// Constructors --------------------------------------------------------------------------------------------------------

	protected AbstractPiece(PN name, Color color)
	{
		this.name = name;
		this.color = color;
		string = color.getLocalizedColor() + ' ' + name.getLocalizedName();
	}

// Piece Implementation ------------------------------------------------------------------------------------------------

	public PN getName()
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
		final AbstractPiece that = (AbstractPiece) o;
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

	private final PN name;
	private final Color color;
	private final String string;
}
