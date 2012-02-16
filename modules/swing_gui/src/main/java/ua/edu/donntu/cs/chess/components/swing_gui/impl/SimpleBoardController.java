/*
 * SimpleBoardController.java
 */

package ua.edu.donntu.cs.chess.components.swing_gui.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;

import ua.edu.donntu.cs.chess.components.model.Board;
import ua.edu.donntu.cs.chess.components.model.board8x8.Board8x8;
import ua.edu.donntu.cs.chess.components.swing_gui.BoardController;
import ua.edu.donntu.cs.chess.components.swing_gui.BoardView;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class SimpleBoardController
	implements BoardController
{
// Constructors --------------------------------------------------------------------------------------------------------

	public SimpleBoardController()
	{
		Board8x8 board8x8 = new Board8x8(3000L, 3000L);
		for (int x = 0; x < board8x8.getWidth(); x++)
			for (int y = 0; y < board8x8.getHeight(); y++)
			{ //QUEEN, ROOK, BISHOP, KNIGHT, PAWN
				/*if(x==5 && y==1)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.WHITE_KING.getPiece());
				if(x==5 && y==8)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.BLACK_KING.getPiece());
				if(x==4 && y==1)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.WHITE_QUEEN.getPiece());
				if(x==4 && y==8)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.BLACK_QUEEN.getPiece());
				if((x==3 || x==6) && y==1)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.WHITE_ROOK.getPiece());
				if((x==3 || x==6) && y==8)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.BLACK_ROOK.getPiece());
				if((x==2 || x==7) && y==1)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.WHITE_BISHOP.getPiece());
				if((x==2 || x==7) && y==8)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.BLACK_BISHOP.getPiece());
				if((x==1 || x==8) && y==1)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.WHITE_KNIGHT.getPiece());
				if((x==1 || x==8) && y==8)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.BLACK_KNIGHT.getPiece());
				if(y==2)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.WHITE_PAWN.getPiece());
				if(y==7)
					board.get().getAreaAt(x, y).setPiece(ChessPieceEnum.BLACK_PAWN.getPiece());
			*/}
		board.set(board8x8);
		boardView.set(new SimpleBoardView());
		board.get().addListener(boardView.get().getBoardListener());
		boardView.get().addInitBoardListener(new InitBoardListener());
	}

// BoardController Implementation --------------------------------------------------------------------------------------

	public Board getBoard()
	{
		return board.get();
	}

	public void setBoard(Board board)
	{
		this.board.set(board);
	}

	public BoardView getBoardView()
	{
		return boardView.get();
	}

	public void setBoardView(BoardView boardView)
	{
		this.boardView.set(boardView);
	}

	private class InitBoardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			board.get().initBoard();
		}
	}

// Attributes ----------------------------------------------------------------------------------------------------------

	private final AtomicReference<Board> board = new AtomicReference<Board>();
	private final AtomicReference<BoardView> boardView  = new AtomicReference<BoardView>();
}
