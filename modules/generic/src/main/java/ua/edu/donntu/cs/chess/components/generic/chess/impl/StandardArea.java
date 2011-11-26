/*
 * StandardArea.java
 */

package ua.edu.donntu.cs.chess.components.generic.chess.impl;

import java.util.concurrent.atomic.AtomicReference;

import ua.edu.donntu.cs.chess.components.generic.Constants;
import ua.edu.donntu.cs.chess.components.generic.chess.Area;
import ua.edu.donntu.cs.chess.components.generic.chess.Color;
import ua.edu.donntu.cs.chess.components.generic.chess.Piece;
import ua.edu.donntu.cs.chess.components.generic.chess.Position;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardArea
	implements Constants, Area
{
// Constructors --------------------------------------------------------------------------------------------------------

	public StandardArea(int x, int y, Color color)
	{
		this (new StandardPosition(x, y), color);
	}

	public StandardArea(int x, int y, Color color, Piece piece)
	{
		this (new StandardPosition(x, y), color, piece);
	}

	public StandardArea(Position position, Color color)
	{
		this (position, color, null);
	}

	public StandardArea(Position position, Color color, Piece piece)
	{
		this.position = position;
		this.color = color;
		this.piece.set(piece);
	}

// Area Implementation -------------------------------------------------------------------------------------------------

	public Position getPosition()
	{
		return position;
	}

	public Color getColor()
	{
		return color;
	}

	public Piece getPiece()
	{
		return piece.get();
	}

	public Piece setPiece(Piece piece)
	{
		return this.piece.getAndSet(piece);
	}

// Overridden Methods --------------------------------------------------------------------------------------------------

	public String toString()
	{
		final StringBuilder rv = new StringBuilder(getClass().getSimpleName());
		rv.append("{position=").append(position);
		rv.append(", color=").append(color);
		rv.append(", piece=").append(piece);
		rv.append('}');
		return rv.toString();
	}

// Attributes ----------------------------------------------------------------------------------------------------------

	final Position position;
	final Color color;
	final AtomicReference<Piece> piece = new AtomicReference<>();
}
