/*
 * Constants.java
 */

package ua.edu.donntu.cs.chess.components.swing_gui;

import java.util.ResourceBundle;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface Constants
	extends ua.edu.donntu.cs.chess.components.model.Constants
{
	public static final ResourceBundle BOARD_BUNDLE = ResourceBundle.getBundle(Constants.class.getPackage().getName() + ".swing_gui");

	// Chess Pieces
	public static final String WHITE_KING_IMAGE_PATH = BOARD_BUNDLE.getString("piece.white.king");
	public static final String BLACK_KING_IMAGE_PATH = BOARD_BUNDLE.getString("piece.black.king");
	public static final String WHITE_QUEEN_IMAGE_PATH = BOARD_BUNDLE.getString("piece.white.queen");
	public static final String BLACK_QUEEN_IMAGE_PATH = BOARD_BUNDLE.getString("piece.black.queen");
	public static final String WHITE_ROOK_IMAGE_PATH = BOARD_BUNDLE.getString("piece.white.rook");
	public static final String BLACK_ROOK_IMAGE_PATH = BOARD_BUNDLE.getString("piece.black.rook");
	public static final String WHITE_BISHOP_IMAGE_PATH = BOARD_BUNDLE.getString("piece.white.bishop");
	public static final String BLACK_BISHOP_IMAGE_PATH = BOARD_BUNDLE.getString("piece.black.bishop");
	public static final String WHITE_KNIGHT_IMAGE_PATH = BOARD_BUNDLE.getString("piece.white.knight");
	public static final String BLACK_KNIGHT_IMAGE_PATH = BOARD_BUNDLE.getString("piece.black.knight");
	public static final String WHITE_PAWN_IMAGE_PATH = BOARD_BUNDLE.getString("piece.white.pawn");
	public static final String BLACK_PAWN_IMAGE_PATH = BOARD_BUNDLE.getString("piece.black.pawn");

	// Checker Pieces
	public static final String CHECKER_WHITE_DRAUGHT_IMAGE_PATH = BOARD_BUNDLE.getString("piece.checker.white.draught");
	public static final String CHECKER_BLACK_DRAUGHT_IMAGE_PATH = BOARD_BUNDLE.getString("piece.checker.black.draught");
	public static final String CHECKER_WHITE_KING_IMAGE_PATH    = BOARD_BUNDLE.getString("piece.checker.white.king");
	public static final String CHECKER_BLACK_KING_IMAGE_PATH    = BOARD_BUNDLE.getString("piece.checker.black.king");
}
