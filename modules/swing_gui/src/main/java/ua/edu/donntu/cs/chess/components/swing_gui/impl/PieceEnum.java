package ua.edu.donntu.cs.chess.components.swing_gui.impl;

import ua.edu.donntu.cs.chess.components.swing_gui.Constants;
import ua.edu.donntu.cs.chess.components.model.chess.Color;
import ua.edu.donntu.cs.chess.components.model.chess.PieceName;

public enum PieceEnum
{
	//QUEEN, ROOK, BISHOP, KNIGHT, PAWN
	WHITE_KING(PieceName.KING, Color.WHITE, Constants.WHITE_KING_IMAGE_PATH),
	BLACK_KING(PieceName.KING, Color.BLACK, Constants.BLACK_KING_IMAGE_PATH),
	WHITE_QUEEN(PieceName.QUEEN, Color.WHITE, Constants.WHITE_QUEEN_IMAGE_PATH),
	BLACK_QUEEN(PieceName.QUEEN, Color.BLACK, Constants.BLACK_QUEEN_IMAGE_PATH),
	WHITE_ROOK(PieceName.ROOK, Color.WHITE, Constants.WHITE_ROOK_IMAGE_PATH),
	BLACK_ROOK(PieceName.ROOK, Color.BLACK, Constants.BLACK_ROOK_IMAGE_PATH),
	WHITE_BISHOP(PieceName.BISHOP, Color.WHITE, Constants.WHITE_BISHOP_IMAGE_PATH),
	BLACK_BISHOP(PieceName.BISHOP, Color.BLACK, Constants.BLACK_BISHOP_IMAGE_PATH),
	WHITE_KNIGHT(PieceName.KNIGHT, Color.WHITE, Constants.WHITE_KNIGHT_IMAGE_PATH),
	BLACK_KNIGHT(PieceName.KNIGHT, Color.BLACK, Constants.BLACK_KNIGHT_IMAGE_PATH),
	WHITE_PAWN(PieceName.PAWN, Color.WHITE, Constants.WHITE_PAWN_IMAGE_PATH),
	BLACK_PAWN(PieceName.PAWN, Color.BLACK, Constants.BLACK_PAWN_IMAGE_PATH);

	PieceEnum(PieceName pieceName, Color color, String path)
	{
			piece = new RenderablePiece(pieceName, color, path);
	}

	public RenderablePiece getPiece()
	{
		return piece;
	}

	private RenderablePiece piece;
}

