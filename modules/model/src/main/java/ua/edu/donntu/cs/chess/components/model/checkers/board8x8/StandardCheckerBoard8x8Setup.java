/*
 * StandardCheckerBoard8x8Setup.java
 */

package ua.edu.donntu.cs.chess.components.model.checkers.board8x8;

import ua.edu.donntu.cs.chess.components.model.Board;
import ua.edu.donntu.cs.chess.components.model.BoardSetup;
import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.model.checkers.CheckerPieceName;
import ua.edu.donntu.cs.chess.components.model.checkers.impl.StandardCheckerPiece;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardCheckerBoard8x8Setup
implements BoardSetup
{
	public void setup(Board board)
	{
		// TODO: Implement default board setup, i.e. put all standard checker pieces to their initial standard positions
		//       (the white pieces are on the bottom, the black ones are on the top)
		board.getAreaAt(0, 0).setPiece(new StandardCheckerPiece(CheckerPieceName.DRAUGHT, Color.WHITE));
	}
}
