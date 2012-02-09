/*
 * BoardListener.java
 */

package ua.edu.donntu.cs.chess.components.model.chess;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface BoardListener
{
	void onBoardInitialized(Board board);
	void onPieceSet(Board board, Area area, Piece piece);
	void onPieceMoved(Board board, Area from, Area to, Piece movedPiece, Piece takenPiece, boolean castling, boolean promotion);
}
