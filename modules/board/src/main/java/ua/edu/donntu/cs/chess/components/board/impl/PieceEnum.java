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

    WHITE_KING(PieceName.KING, Color.WHITE, Constants.WHITE_KING_IMAGE_PATH),
    BLACK_KING(PieceName.KING, Color.BLACK, "");

    PieceEnum(PieceName pieceName, Color color, String path)
    {
        piece = new RenderablePiece(pieceName, color, path);
    }

    public RenderablePiece getPiece() {
        return piece;
    }

    private RenderablePiece piece;
}

