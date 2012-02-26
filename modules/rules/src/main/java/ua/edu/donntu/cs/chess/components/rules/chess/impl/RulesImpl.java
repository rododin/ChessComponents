/*
 * RulesImpl.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;
import ua.edu.donntu.cs.chess.components.rules.Game;
import ua.edu.donntu.cs.chess.components.rules.Rules;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.rules.*;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class RulesImpl
	implements Rules
{
	@Override
	public boolean checkMove(Game game, String move)
	{
		final Board board = game.getBoard();
		if (board == null)
			return false;

		// Initial and target coordinates of the piece to be moved
		final int startX = move.charAt(0) - 'a';
		final int startY = move.charAt(1) - '1';
		final int endX = move.charAt(2) - 'a';
		final int endY = move.charAt(3) - '1';

		final Position startPosition = new StandardPosition(startX, startY);
		final Position endPosition = new StandardPosition(endX, endY);

		if (startPosition == endPosition)
			return false;

		final Area area = board.getAreaAt(startPosition.getX(), startPosition.getY());
		final Piece piece = area.getPiece();

		if (piece == null)
			return false;

		PieceRules rules;
		switch ((ChessPieceName)piece.getName())
		{
			case PAWN:
				rules = new PawnRules();
				break;
			case ROOK:
				rules = new RookRules();
				break;
			case KNIGHT:
				rules = new KnightRules();
				break;
			case BISHOP:
				rules = new BishopRules();
				break;
			case KING:
				rules = new KingRules();
				break;
			case QUEEN:
				rules = new QueenRules();
				break;
			default:
				rules = null;
				break;
		}
		rules.setBoard(board);
		rules.setColor(piece.getColor());
		rules.setCurrentMove(move);
		rules.setPreviousMove(game.getLastMove());
		return rules.isMovePossible();
	}
}
