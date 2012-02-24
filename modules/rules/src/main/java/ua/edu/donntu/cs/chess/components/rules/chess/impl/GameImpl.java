/*
 * GameImpl.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl;

import ua.edu.donntu.cs.chess.components.model.Board;
import ua.edu.donntu.cs.chess.components.model.board8x8.Board8x8;
import ua.edu.donntu.cs.chess.components.model.chess.board8x8.StandardChessBoard8x8Setup;
import ua.edu.donntu.cs.chess.components.rules.Game;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class GameImpl
	implements Game
{
	private Board8x8 board;
	private String moves;
	private String lastMove;

	public GameImpl()
	{
		board = new Board8x8();
		StandardChessBoard8x8Setup standardBoardSetup = new StandardChessBoard8x8Setup();
		standardBoardSetup.setup(board);
		moves = "";
		lastMove = "";
	}

	@Override
	public Board getBoard()
	{
		return board;
	}

	@Override
	public String getMoves()
	{
		return moves;
	}

	@Override
	public String getLastMove()
	{
		return lastMove;
	}

	@Override
	public void addMove(String move)
	{
		lastMove = move;
		moves += move;
	}
}
