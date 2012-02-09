/*
 * Piece.java
 */

package ua.edu.donntu.cs.chess.components.model.chess;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface Piece
{
	PieceName getName();
	Color getColor();

	String toString();
	boolean equals(Object o);
	int hashCode();
}
