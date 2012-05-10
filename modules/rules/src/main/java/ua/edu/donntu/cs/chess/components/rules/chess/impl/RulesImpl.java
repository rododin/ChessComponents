/*
 * RulesImpl.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;
import ua.edu.donntu.cs.chess.components.rules.*;
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
		{
			return false;
		}

		// Initial and target coordinates of the piece to be moved
		final int startX = move.charAt(0) - 'a';
		final int startY = move.charAt(1) - '1';
		final int endX = move.charAt(2) - 'a';
		final int endY = move.charAt(3) - '1';

		final Position startPosition = PieceRules.parsePosition(move.substring(0, 2));
		final Position endPosition = PieceRules.parsePosition(move.substring(2, 4));

		if (startPosition == endPosition)
		{
			return false;
		}

		return checkMove(game, startPosition, endPosition);
	}

	public boolean checkMove(Game game, Position startPosition,
			Position endPosition)
	{
		final Board board = game.getBoard();
		final Area area = board.getAreaAt(startPosition.getX(), startPosition.getY());
		final Piece piece = area.getPiece();

		if (piece == null)
			return false;

		PieceRules pieceRules;
		switch ((ChessPieceName)piece.getName())
		{
			case PAWN:
				pieceRules = new PawnRules();
				break;
			case ROOK:
				pieceRules = new RookRules();
				break;
			case KNIGHT:
				pieceRules = new KnightRules();
				break;
			case BISHOP:
				pieceRules = new BishopRules();
				break;
			case KING:
				pieceRules = new KingRules();
				break;
			case QUEEN:
				pieceRules = new QueenRules();
				break;
			default:
				pieceRules = null;
				break;
		}
		pieceRules.setRules(this);
		pieceRules.setGame(game);
		pieceRules.setColor(piece.getColor());
		pieceRules.setCurrentMove(startPosition, endPosition);
		return pieceRules.isMovePossible();
	}
}
