/*
 * BoardController.java
 */

package ua.edu.donntu.cs.chess.components.board;

import ua.edu.donntu.cs.chess.components.generic.chess.Board;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface BoardController
{
	Board getBoard();
	void setBoard(Board board);

	BoardView getBoardView();
	void setBoardView(BoardView boardView);
}
