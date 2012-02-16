/*
 * BoardRenderer.java
 */

package ua.edu.donntu.cs.chess.components.swing_gui;

import java.awt.Component;
import java.awt.Graphics2D;

import ua.edu.donntu.cs.chess.components.model.Area;
import ua.edu.donntu.cs.chess.components.model.Board;
import ua.edu.donntu.cs.chess.components.model.Piece;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface BoardRenderer
{
	void renderBoard(Component component, Graphics2D g, Board board);
	void renderPieceSet(Component component, Graphics2D g, Board board, Area area, Piece piece);
	void renderPieceMove(Component component, Graphics2D g, Board board, Area from, Area to, Piece movedPiece, Piece takenPiece, Area castlingFrom, Area castlingTo, Piece castlingPiece, Piece promotionPiece);
}
