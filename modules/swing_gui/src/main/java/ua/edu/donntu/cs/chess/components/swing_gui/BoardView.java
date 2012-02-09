/*
 * BoardView.java
 */

package ua.edu.donntu.cs.chess.components.swing_gui;

import java.awt.event.ActionListener;

import ua.edu.donntu.cs.chess.components.model.chess.BoardListener;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface BoardView
{
	BoardListener getBoardListener();

	BoardRenderer getBoardRenderer();
	void setBoardRenderer(BoardRenderer boardRenderer);

	void addInitBoardListener(ActionListener listener);
	// TODO: addPieceSetListener();
	// TODO: addPieceMovedListener();
}
