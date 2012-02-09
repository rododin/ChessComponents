/*
 * SimpleBoardView.java
 */

package ua.edu.donntu.cs.chess.components.swing_gui.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JButton;
import javax.swing.JPanel;

import ua.edu.donntu.cs.chess.components.swing_gui.BoardRenderer;
import ua.edu.donntu.cs.chess.components.swing_gui.BoardView;
import ua.edu.donntu.cs.chess.components.swing_gui.Constants;
import ua.edu.donntu.cs.chess.components.model.chess.Area;
import ua.edu.donntu.cs.chess.components.model.chess.Board;
import ua.edu.donntu.cs.chess.components.model.chess.BoardListener;
import ua.edu.donntu.cs.chess.components.model.chess.Piece;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class SimpleBoardView
	extends JPanel
	implements BoardView, BoardListener, Constants
{
// Constructors --------------------------------------------------------------------------------------------------------

	public SimpleBoardView()
	{
		super(new BorderLayout(5, 5));
		boardPanel.setPreferredSize(new Dimension(600, 400));

		boardRenderer.set(new SimpleBoardRenderer());

		add(boardPanel, BorderLayout.CENTER);
		add(initBoardButton, BorderLayout.SOUTH);
	}

// BoardView Implementation --------------------------------------------------------------------------------------------

	public BoardListener getBoardListener()
	{
		return this;
	}

	public BoardRenderer getBoardRenderer()
	{
		return boardRenderer.get();
	}

	public void setBoardRenderer(BoardRenderer boardRenderer)
	{
		this.boardRenderer.set(boardRenderer);
	}

	public void addInitBoardListener(ActionListener listener)
	{
		initBoardButton.addActionListener(listener);
	}

	class BoardPanel extends JPanel
	{
		BoardPanel()
		{
			super();
		}

		public void update(Graphics g)
		{
			super.update(g);
		}

		public void paint(Graphics g)
		{
			super.paint(g);

			final Board board = SimpleBoardView.this.board.get();

			//LOG.info("BoardPanel.paint: board=" + board);

			if (board != null)
			{
				boardRenderer.get().renderBoard(boardPanel, (Graphics2D)g, board);
			}
		}
	}

// BoardListener Implementation ----------------------------------------------------------------------------------------

	public void onBoardInitialized(Board board)
	{
		LOG.info("onBoardInitialized: board=" + board);
		this.board.set(board);
		//boardRenderer.get().renderBoard(boardPanel, board);
		//boardPanel.update(boardPanel.getGraphics());
		boardPanel.repaint();
	}

	public void onPieceSet(Board board, Area area, Piece piece)
	{
		this.board.set(board);
		// TODO: Implement the method properly
		//boardRenderer.get().renderPieceSet(boardPanel, (Graphics2D)getGraphics(), board, area, piece);
		boardPanel.repaint();
	}

	public void onPieceMoved(Board board, Area from, Area to, Piece movedPiece, Piece takenPiece, boolean castling, boolean promotion)
	{
		this.board.set(board);
		// TODO: Implement the method properly
		//boardRenderer.get().renderPieceMove(boardPanel, (Graphics2D)getGraphics(), board, from, to, movedPiece, takenPiece, null, null, null, null);
		boardPanel.repaint();
	}

// Attributes ----------------------------------------------------------------------------------------------------------

	private final AtomicReference<Board> board = new AtomicReference<Board>();
	private final AtomicReference<BoardRenderer> boardRenderer = new AtomicReference<BoardRenderer>();
	private final JPanel boardPanel = new BoardPanel();
	private final JButton initBoardButton = new JButton("Init Board");
}
