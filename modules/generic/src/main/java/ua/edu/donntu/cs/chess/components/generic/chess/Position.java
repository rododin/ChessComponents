/*
 * Position.java
 */

package ua.edu.donntu.cs.chess.components.generic.chess;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface Position
{
	int getX();
	int getY();
	String getXLabel();
	String getYLabel();

	String toString();
	boolean equals(Object o);
	int hashCode();
}
