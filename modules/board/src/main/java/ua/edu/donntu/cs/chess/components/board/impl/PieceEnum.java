package ua.edu.donntu.cs.chess.components.board.impl;

import ua.edu.donntu.cs.chess.components.board.Constants;
import ua.edu.donntu.cs.chess.components.generic.chess.Color;
import ua.edu.donntu.cs.chess.components.generic.chess.Piece;
import ua.edu.donntu.cs.chess.components.generic.chess.PieceName;
import ua.edu.donntu.cs.chess.components.generic.chess.impl.StandardPiece;

/**
 * Created by IntelliJ IDEA.
 * User: Ferrari
 * Date: 22.11.11
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
public enum PieceEnum {
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

    public RenderablePiece getPiece() {
        return piece;
    }

    private RenderablePiece piece;
}

