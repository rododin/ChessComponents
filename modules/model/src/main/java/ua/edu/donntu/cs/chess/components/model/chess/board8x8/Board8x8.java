/*
 * Board8x8.java
 */

package ua.edu.donntu.cs.chess.components.model.chess.board8x8;

import ua.edu.donntu.cs.chess.components.model.chess.impl.AbstractBoard;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class Board8x8
	extends AbstractBoard
{
// Constructors --------------------------------------------------------------------------------------------------------

	public Board8x8()
	{
		this (0L, 0L);
	}

	public Board8x8(long whiteClock, long blackClock)
	{
		super (8, 8, whiteClock, blackClock);
	}
}
