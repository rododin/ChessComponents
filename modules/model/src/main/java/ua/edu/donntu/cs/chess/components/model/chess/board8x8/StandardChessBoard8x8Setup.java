/*
 * StandardBoardSetup.java
 */

package ua.edu.donntu.cs.chess.components.model.chess.board8x8;

import ua.edu.donntu.cs.chess.components.model.Board;
import ua.edu.donntu.cs.chess.components.model.BoardSetup;
import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.chess.impl.StandardChessPiece;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardChessBoard8x8Setup
	implements BoardSetup
{
	public void setup(Board board)
	{
		// TODO: Implement default board setup, i.e. put all standard chess pieces to their initial standard positions
		//       (the white pieces are on the bottom, the black ones are on the top)
		board.getAreaAt(4, 0).setPiece(new StandardChessPiece(ChessPieceName.KING, Color.WHITE));
	}
}
