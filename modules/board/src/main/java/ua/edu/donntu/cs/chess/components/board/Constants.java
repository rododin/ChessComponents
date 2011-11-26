/*
 * Constants.java
 */

package ua.edu.donntu.cs.chess.components.board;

import java.util.ResourceBundle;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface Constants
	extends ua.edu.donntu.cs.chess.components.generic.Constants
{
    public static final ResourceBundle BOARD_BUNDLE = ResourceBundle.getBundle(Constants.class.getPackage().getName() + ".board");

    public static final String WHITE_KING_IMAGE_PATH = BOARD_BUNDLE.getString("piece.white.king");
}
