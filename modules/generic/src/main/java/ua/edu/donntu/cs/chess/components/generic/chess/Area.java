/*
 * Area.java
 */

package ua.edu.donntu.cs.chess.components.generic.chess;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface Area
{
	Position getPosition();
	Color getColor();
	Piece getPiece();
	Piece setPiece(Piece piece);

	String toString();
	boolean equals(Object o);
	int hashCode();
}
