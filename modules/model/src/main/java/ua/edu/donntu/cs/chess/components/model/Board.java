/*
 * Board.java
 */

package ua.edu.donntu.cs.chess.components.model;

import java.util.Map;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface Board
	extends Constants
{
	int getWidth();
	int getHeight();
	Map<Position, Area> getAreaMap();
	Area getAreaAt(int x, int y);

	long getWhiteClock();
	long setWhiteClock(long newValue);
	long countDownWhiteClockBy(long difference);
	long getBlackClock();
	long setBlackClock(long newValue);
	long countDownBlackClockBy(long difference);

	void initBoard();
	void setPiece(Area area, Piece piece);
	void movePiece(Area from, Area to) throws BoardException;

	boolean isListenerSet(BoardListener listener);
	void addListener(BoardListener listener);
	void removeListener(BoardListener listener);
	void removeAllListeners();
}
