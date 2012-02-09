/*
 * AbstractBoard.java
 */

package ua.edu.donntu.cs.chess.components.model.chess.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

import ua.edu.donntu.cs.chess.components.model.chess.Area;
import ua.edu.donntu.cs.chess.components.model.chess.Board;
import ua.edu.donntu.cs.chess.components.model.chess.BoardException;
import ua.edu.donntu.cs.chess.components.model.chess.BoardListener;
import ua.edu.donntu.cs.chess.components.model.chess.Color;
import ua.edu.donntu.cs.chess.components.model.chess.Piece;
import ua.edu.donntu.cs.chess.components.model.chess.Position;

/**
 * Description.
 *
 * @author Rod Odin
 */
public abstract class AbstractBoard
	implements Board
{
// Constructors --------------------------------------------------------------------------------------------------------

	protected AbstractBoard(int width, int height)
	{
		this (width, height, 0L, 0L);
	}

	protected AbstractBoard(int width, int height, long whiteClock, long blackClock)
	{
		this.width = width;
		this.height = height;

		for (int x = 0; x < width; x++)
		{
			boolean white = x % 2 != 0;
			for (int y = 0; y < height; y++, white = !white)
			{
				final Position position = new StandardPosition(x, y);
				areaMap.put(position, new StandardArea(position, white ? Color.WHITE : Color.BLACK));
			}
		}

		this.whiteClock.set(whiteClock);
		this.blackClock.set(blackClock);
	}

// Board Implementation ------------------------------------------------------------------------------------------------

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public Map<Position, Area> getAreaMap()
	{
		return Collections.unmodifiableMap(areaMap);
	}

	public Area getAreaAt(int x, int y)
	{
		return getAreaAt(new StandardPosition(x, y));
	}

	public Area getAreaAt(Position position)
	{
		return areaMap.get(position);
	}

	public long getWhiteClock()
	{
		return whiteClock.get();
	}

	public long setWhiteClock(long newValue)
	{
		return whiteClock.getAndSet(newValue);
	}

	public long countDownWhiteClockBy(long difference)
	{
		return whiteClock.addAndGet(-difference);
	}

	public long getBlackClock()
	{
		return blackClock.get();
	}

	public long setBlackClock(long newValue)
	{
		return blackClock.getAndSet(newValue);
	}

	public long countDownBlackClockBy(long difference)
	{
		return blackClock.addAndGet(-difference);
	}

	public void initBoard()
	{
		// TODO: Implement the method

		for (BoardListener listener : boardListeners)
			listener.onBoardInitialized(this);
	}

	public void setPiece(Area area, Piece piece)
	{
		// TODO: Implement the method
		throw new UnsupportedOperationException("Still not implemented");
	}

	public void movePiece(Area from, Area to) throws BoardException
	{
		// TODO: Implement the method
		throw new UnsupportedOperationException("Still not implemented");
	}

	public boolean isListenerSet(BoardListener listener)
	{
		return boardListeners.contains(listener);
	}

	public void addListener(BoardListener listener)
	{
		boardListeners.add(listener);
	}

	public void removeListener(BoardListener listener)
	{
		boardListeners.remove(listener);
	}

	public void removeAllListeners()
	{
		boardListeners.clear();
	}

// Attributes ----------------------------------------------------------------------------------------------------------

	private final int width;
	private final int height;
	private final LinkedHashMap<Position, Area> areaMap = new LinkedHashMap<Position, Area>();
	private final AtomicLong whiteClock = new AtomicLong();
	private final AtomicLong blackClock = new AtomicLong();
	private final Collection<BoardListener> boardListeners = new ConcurrentLinkedQueue<BoardListener>();
}
