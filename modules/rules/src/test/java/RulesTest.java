/*
 * RulesTest.java
 */

import static org.junit.Assert.*;
import org.junit.*;

import ua.edu.donntu.cs.chess.components.rules.Game;
import ua.edu.donntu.cs.chess.components.rules.Rules;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.GameImpl;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.RulesImpl;

public class RulesTest
{
	@BeforeClass
	public static void SetUp()
	{
		rules = new RulesImpl();
		game = new GameImpl();
	}

	@Test
	public void testMoveOfNoPiece()
	{
		assertFalse(rules.checkMove(game, "a3a4"));
	}

	@Test
	public void testNoMove()
	{
		assertFalse(rules.checkMove(game, "a1a1"));
	}

	private static Rules rules;
	private static Game game;
}
