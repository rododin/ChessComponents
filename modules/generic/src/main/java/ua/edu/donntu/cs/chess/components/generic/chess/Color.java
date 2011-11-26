/*
 * Color.java
 */

package ua.edu.donntu.cs.chess.components.generic.chess;

/**
 * Description.
 *
 * @author Rod Odin
 */
public enum Color
{
	WHITE, BLACK;

	public String getLocalizedColor()
	{
		// TODO: Implement localization support
		return toString();
	}
}
