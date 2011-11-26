/*
 * SimpleBoardController.java
 */

package ua.edu.donntu.cs.chess.components.board.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;

import ua.edu.donntu.cs.chess.components.board.BoardController;
import ua.edu.donntu.cs.chess.components.board.BoardView;
import ua.edu.donntu.cs.chess.components.generic.chess.Board;
import ua.edu.donntu.cs.chess.components.generic.chess.Color;
import ua.edu.donntu.cs.chess.components.generic.chess.PieceName;
import ua.edu.donntu.cs.chess.components.generic.chess.board8x8.Board8x8;
import ua.edu.donntu.cs.chess.components.generic.chess.impl.StandardPiece;

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
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
            {
                board.get().getAreaAt(i, j).setPiece(PieceEnum.BLACK_KING.getPiece());
            }
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
