/*
 * StandardBoardSetup.java
 */

package ua.edu.donntu.cs.chess.components.model.chess.board8x8;

import ua.edu.donntu.cs.chess.components.model.Board;
import ua.edu.donntu.cs.chess.components.model.BoardSetup;
import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.chess.impl.StandardChessPiece;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardChessBoard8x8Setup
	implements BoardSetup
{
	public void setup(Board board)
	{
		// White pieces:
		board.getAreaAt(0, 0).setPiece(new StandardChessPiece(ChessPieceName.ROOK, Color.WHITE));
		board.getAreaAt(1, 0).setPiece(new StandardChessPiece(ChessPieceName.KNIGHT, Color.WHITE));
		board.getAreaAt(2, 0).setPiece(new StandardChessPiece(ChessPieceName.BISHOP, Color.WHITE));
		board.getAreaAt(3, 0).setPiece(new StandardChessPiece(ChessPieceName.QUEEN, Color.WHITE));
		board.getAreaAt(4, 0).setPiece(new StandardChessPiece(ChessPieceName.KING, Color.WHITE));
		board.getAreaAt(5, 0).setPiece(new StandardChessPiece(ChessPieceName.BISHOP, Color.WHITE));
		board.getAreaAt(6, 0).setPiece(new StandardChessPiece(ChessPieceName.KNIGHT, Color.WHITE));
		board.getAreaAt(7, 0).setPiece(new StandardChessPiece(ChessPieceName.ROOK, Color.WHITE));

		for (int i = 0; i < 8; i++) {
			board.getAreaAt(i, 1).setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.WHITE));
		}

		// Black pieces:
		board.getAreaAt(0, 7).setPiece(new StandardChessPiece(ChessPieceName.ROOK, Color.BLACK));
		board.getAreaAt(1, 7).setPiece(new StandardChessPiece(ChessPieceName.KNIGHT, Color.BLACK));
		board.getAreaAt(2, 7).setPiece(new StandardChessPiece(ChessPieceName.BISHOP, Color.BLACK));
		board.getAreaAt(3, 7).setPiece(new StandardChessPiece(ChessPieceName.QUEEN, Color.BLACK));
		board.getAreaAt(4, 7).setPiece(new StandardChessPiece(ChessPieceName.KING, Color.BLACK));
		board.getAreaAt(5, 7).setPiece(new StandardChessPiece(ChessPieceName.BISHOP, Color.BLACK));
		board.getAreaAt(6, 7).setPiece(new StandardChessPiece(ChessPieceName.KNIGHT, Color.BLACK));
		board.getAreaAt(7, 7).setPiece(new StandardChessPiece(ChessPieceName.ROOK, Color.BLACK));

		for (int i = 0; i < 8; i++) {
			board.getAreaAt(i, 6).setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.BLACK));
		}
	}
}
