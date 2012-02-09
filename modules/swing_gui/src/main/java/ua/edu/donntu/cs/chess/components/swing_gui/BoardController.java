/*
 * BoardController.java
 */

package ua.edu.donntu.cs.chess.components.swing_gui;

import ua.edu.donntu.cs.chess.components.model.chess.Board;

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
