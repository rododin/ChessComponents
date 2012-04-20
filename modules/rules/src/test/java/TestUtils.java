/*
 * TestUtils.java
 */

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.rules.Game;

// this class is abstract just to don't let build system treat it like a test
public abstract class TestUtils
{
	public static Area getAreaAt(Game game, String position)
	{
		final int x = position.charAt(0) - 'a';
		final int y = position.charAt(1) - '1';

		Board board = game.getBoard();
		return board.getAreaAt(x, y);
	}
}
