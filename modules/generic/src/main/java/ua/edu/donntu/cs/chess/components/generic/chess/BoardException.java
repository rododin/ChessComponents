/*
 * BoardException.java
 */

package ua.edu.donntu.cs.chess.components.generic.chess;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class BoardException
	extends Exception
{
	public BoardException()
	{
	}

	public BoardException(String message)
	{
		super(message);
	}

	public BoardException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public BoardException(Throwable cause)
	{
		super(cause);
	}

}
