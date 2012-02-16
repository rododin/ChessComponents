package ua.edu.donntu.cs.chess.components.swing_gui.impl;

import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.swing_gui.Constants;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;

public enum ChessPieceEnum
{
	//QUEEN, ROOK, BISHOP, KNIGHT, PAWN
	WHITE_KING(ChessPieceName.KING, Color.WHITE, Constants.WHITE_KING_IMAGE_PATH),
	BLACK_KING(ChessPieceName.KING, Color.BLACK, Constants.BLACK_KING_IMAGE_PATH),
	WHITE_QUEEN(ChessPieceName.QUEEN, Color.WHITE, Constants.WHITE_QUEEN_IMAGE_PATH),
	BLACK_QUEEN(ChessPieceName.QUEEN, Color.BLACK, Constants.BLACK_QUEEN_IMAGE_PATH),
	WHITE_ROOK(ChessPieceName.ROOK, Color.WHITE, Constants.WHITE_ROOK_IMAGE_PATH),
	BLACK_ROOK(ChessPieceName.ROOK, Color.BLACK, Constants.BLACK_ROOK_IMAGE_PATH),
	WHITE_BISHOP(ChessPieceName.BISHOP, Color.WHITE, Constants.WHITE_BISHOP_IMAGE_PATH),
	BLACK_BISHOP(ChessPieceName.BISHOP, Color.BLACK, Constants.BLACK_BISHOP_IMAGE_PATH),
	WHITE_KNIGHT(ChessPieceName.KNIGHT, Color.WHITE, Constants.WHITE_KNIGHT_IMAGE_PATH),
	BLACK_KNIGHT(ChessPieceName.KNIGHT, Color.BLACK, Constants.BLACK_KNIGHT_IMAGE_PATH),
	WHITE_PAWN(ChessPieceName.PAWN, Color.WHITE, Constants.WHITE_PAWN_IMAGE_PATH),
	BLACK_PAWN(ChessPieceName.PAWN, Color.BLACK, Constants.BLACK_PAWN_IMAGE_PATH);

	ChessPieceEnum(ChessPieceName pieceName, Color color, String path)
	{
			piece = new RenderableChessPiece(pieceName, color, path);
	}

	public RenderableChessPiece getPiece()
	{
		return piece;
	}

	private RenderableChessPiece piece;
}

