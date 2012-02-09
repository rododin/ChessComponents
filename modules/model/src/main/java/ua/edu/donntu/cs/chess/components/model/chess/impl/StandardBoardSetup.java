/*
 * StandardBoardSetup.java
 */

package ua.edu.donntu.cs.chess.components.model.chess.impl;

import ua.edu.donntu.cs.chess.components.model.chess.Board;
import ua.edu.donntu.cs.chess.components.model.chess.BoardSetup;
import ua.edu.donntu.cs.chess.components.model.chess.Color;
import ua.edu.donntu.cs.chess.components.model.chess.PieceName;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardBoardSetup
	implements BoardSetup
{
	public void setup(Board board)
	{
		// TODO: Implement default board setup, i.e. put all standard chess pieces to their initial standard positions
		//       (the white pieces are on the bottom, the black ones are on the top)
		board.getAreaAt(4, 0).setPiece(new StandardPiece(PieceName.KING, Color.WHITE));
	}
}
