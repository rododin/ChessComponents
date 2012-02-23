/*
 * RulesImpl.java
 */

package ua.edu.donntu.cs.chess.components.rules.chess.impl;

import ua.edu.donntu.cs.chess.components.model.Area;
import ua.edu.donntu.cs.chess.components.model.Board;
import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.model.Position;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.StandardPosition;
import ua.edu.donntu.cs.chess.components.rules.Game;
import ua.edu.donntu.cs.chess.components.rules.Rules;

import java.util.Map;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class RulesImpl
  implements Rules
{
  public RulesImpl()
  {
  }
@Override
public boolean checkMove(Game game, String move)
{
	Color colorOpponent;
	final Board board = game.getBoard();
	if (board == null)
		return false;
	final String moves = game.getMoves(); // All moves already done, e.g.: e2e4 g7g6 ...
	// move - the move to be done next after the already done ones
	// We should check whether the move is correct or not

	final String startPositionLabel = move.substring(0, 2); // first 2 characters identify the initial position of the piece to be moved
	final String endPositionLabel   = move.substring(2, 4); // last 2 characters identify the target position of the piece to be moved

	// Initial and target coordinates of the piece to be moved

	final int startX = move.charAt(0) - 'a';
	final int startY = move.charAt(1) - '1';
	final int endX = move.charAt(2) - 'a';
	final int endY = move.charAt(3) - '1';

	final Position startPosition = new StandardPosition(startX, startY);
	final Position endPosition = new StandardPosition(endX, endY);
//	LOG.info("S:"+startPosition.getXLabel()+startPosition.getYLabel());
//	LOG.info("E:"+endPosition.getXLabel()+endPosition.getYLabel());

	final Map<Position,Area> areaMap = board.getAreaMap();
	for (Map.Entry<Position, Area> areaEntry : areaMap.entrySet())
	{
		final Position position = areaEntry.getKey();
		LOG.info(position.getXLabel()+position.getYLabel());

		final Area area = areaEntry.getValue();

		if (area.getPiece().getColor() == Color.WHITE)// set colorFrag, as inverse of color
			colorOpponent = Color.BLACK;              // moved piece
		else                                          //
			colorOpponent = Color.WHITE;              //

		if((position.hashCode() == startPosition.hashCode())&&(area.getPiece() != null))
		{
			switch ((ChessPieceName)area.getPiece().getName())
			{
				case PAWN:{
					return checkPawn(board, startPosition, endPosition, colorOpponent);
				}
				case ROOK:{
					return checkRook(board, startPosition, endPosition, colorOpponent);
				}
				case KNIGHT:{
					return checkKnight(board, startPosition, endPosition, colorOpponent);
				}
				case BISHOP:{
					return checkBishop(board, startPosition, endPosition, colorOpponent);
				}
				case KING:{
					return checkKing(board, startPosition, endPosition, colorOpponent);
				}
				case QUEEN:{
					return checkQueen(board, startPosition, endPosition, colorOpponent);
				}
				default:{
					break;
				}
			}
		}
	}
	return false;
  }

private boolean checkRook(Board board, Position startPosition, Position endPosition, Color colorOpponent) {
	if ((startPosition.getX() != endPosition.getX()) && (startPosition.getY() != endPosition.getY()))
		return false;// Rook goes only horizontally and vertically

	final Map<Position,Area> areaMap = board.getAreaMap();

	for (Map.Entry<Position, Area> areaEntry : areaMap.entrySet())
	{
		final Position position = areaEntry.getKey();
		final Area area = areaEntry.getValue();
		if ((position.getX() == endPosition.getX()) || (position.getY() == endPosition.getY())) // compare only Horizontal and Vertical cells
			if ((area.getPiece() != null) &&
				(position.hashCode() != endPosition.hashCode()) &&
				(position.hashCode() != startPosition.hashCode()))
				return false;
			else
				if (((area.getPiece() == null)||(area.getPiece() != null && area.getPiece().getColor() == colorOpponent)) &&
					(position.hashCode() == endPosition.hashCode())) // If this move take piece
					return true;
	}
	return true;
}
private boolean checkBishop(Board board, Position startPosition, Position endPosition, Color colorOpponent) {
	if ((board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece() == null)||
			(board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece().getColor() == colorOpponent))
	{
		if (Math.abs(startPosition.getX() - endPosition.getX()) != Math.abs(startPosition.getY() - endPosition.getY()))
			return false;
		else
			return true;
	}
	else
		return false;
	}
private boolean checkQueen(Board board, Position startPosition, Position endPosition, Color colorOpponent) {
	if ((board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece() == null)||
		(board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece().getColor() == colorOpponent))
	{
		// check diagonally moves
		if (Math.abs(startPosition.getX() - endPosition.getX()) != Math.abs(startPosition.getY() - endPosition.getY()))
		{
			final Map<Position,Area> areaMap = board.getAreaMap();
			for (Map.Entry<Position, Area> areaEntry : areaMap.entrySet())
			{
				final Position position = areaEntry.getKey();
				final Area area = areaEntry.getValue();
				if ((position.getX() == endPosition.getX()) || (position.getY() == endPosition.getY())) // compare only Horizontal and Vertical cells
				{
					if ((area.getPiece() != null) &&
						(position.hashCode() != endPosition.hashCode()) &&
						(position.hashCode() != startPosition.hashCode()))
						return false;
					else
						if (((area.getPiece() == null)||(area.getPiece() != null && area.getPiece().getColor() == colorOpponent)) &&
							(position.hashCode() == endPosition.hashCode())) // If this move take piece
						return true;
				}
			}
		}
		else
			return true;
	}
	else
		return false;

	return false;
}

private boolean checkKnight(Board board, Position startPosition, Position endPosition, Color colorOpponent) {
	if ((board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece() == null)||
		(board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece().getColor() == colorOpponent))
	{
		if (((startPosition.getX() + 1 == endPosition.getX()) && (startPosition.getY() + 2 == endPosition.getY())) ||
			((startPosition.getX() + 2 == endPosition.getX()) && (startPosition.getY() + 1 == endPosition.getY())) ||
			((startPosition.getX() + 2 == endPosition.getX()) && (startPosition.getY() - 1 == endPosition.getY())) ||
			((startPosition.getX() + 1 == endPosition.getX()) && (startPosition.getY() - 2 == endPosition.getY())) ||
			((startPosition.getX() - 1 == endPosition.getX()) && (startPosition.getY() - 2 == endPosition.getY())) ||
			((startPosition.getX() - 2 == endPosition.getX()) && (startPosition.getY() - 1 == endPosition.getY())) ||
			((startPosition.getX() - 2 == endPosition.getX()) && (startPosition.getY() + 1 == endPosition.getY())) ||
			((startPosition.getX() - 1 == endPosition.getX()) && (startPosition.getY() + 2 == endPosition.getY()))    )
			return true;
		else
			return false;
	}
	else
		return false;
}
private boolean checkKing(Board board, Position startPosition, Position endPosition, Color colorOpponent) {
		if ((board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece() == null)||
				(board.getAreaAt(endPosition.getX(),endPosition.getY()).getPiece().getColor() == colorOpponent))
		{
			if (((startPosition.getX() - 1 	== endPosition.getX()) && (startPosition.getY() - 1 == endPosition.getY())) ||
				((startPosition.getX() 		== endPosition.getX()) && (startPosition.getY() - 1 == endPosition.getY())) ||
				((startPosition.getX() + 1 	== endPosition.getX()) && (startPosition.getY() - 1 == endPosition.getY())) ||
				((startPosition.getX() + 1 	== endPosition.getX()) && (startPosition.getY() 	== endPosition.getY())) ||
				((startPosition.getX() + 1 	== endPosition.getX()) && (startPosition.getY() + 1 == endPosition.getY())) ||
				((startPosition.getX() 		== endPosition.getX()) && (startPosition.getY() + 1 == endPosition.getY())) ||
				((startPosition.getX() - 1 	== endPosition.getX()) && (startPosition.getY() + 1 == endPosition.getY())) ||
				((startPosition.getX() - 1 	== endPosition.getX()) && (startPosition.getY() 	== endPosition.getY()))    )
				return true;
			else
				return false;
		}
		else
			return false;
	}
private boolean checkPawn(Board board, Position startPosition, Position endPosition, Color colorOponent) {
	int firstStep = 1; // if this pawn never went, then firstStep = 2;
	if (startPosition.getY() == 1)
		firstStep = 2;

	if (startPosition.getY() + firstStep < endPosition.getY())
		return false;

	final Map<Position,Area> areaMap = board.getAreaMap();

	for (Map.Entry<Position, Area> areaEntry : areaMap.entrySet())
	{
		final Position position = areaEntry.getKey();

		final Area area = areaEntry.getValue();

		// check simple move
		if (((startPosition.getY() != endPosition.getY()) &&
			(startPosition.getX() == endPosition.getX())) ||
			((startPosition.getY() == endPosition.getY()) &&
			(startPosition.getX() != endPosition.getX())) &&
			(area.getPiece() != null))
			return false;

		// check move with fight
		if ((position.getY() == startPosition.getY() + 1)&&
			(position.getY() == endPosition.getY()) &&
			(position.getX() == endPosition.getX()) &&
			((startPosition.getX() - 1 == endPosition.getX())||(startPosition.getX() +1 == endPosition.getX())) &&
			((area.getPiece() == null) || (area.getPiece().getColor() !=colorOponent)))
			return false;
	}
	return true;
}
}
