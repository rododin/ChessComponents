/*
 * KnightTest.java
 */

import static org.junit.Assert.*;
import org.junit.*;

import ua.edu.donntu.cs.chess.components.rules.Game;
import ua.edu.donntu.cs.chess.components.rules.Rules;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.GameImpl;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.RulesImpl;

public class KnightTest
{
	@BeforeClass
	public static void SetUp()
	{
		rules = new RulesImpl();
		game = new GameImpl();
	}

	@Test
	public void testToRightByWhite()
	{
		assertTrue(rules.checkMove(game, "b1c3"));
		assertTrue(rules.checkMove(game, "g1h3"));
	}

	@Test
	public void testToLeftByWhite()
	{
		assertTrue(rules.checkMove(game, "b1a3"));
		assertTrue(rules.checkMove(game, "g1f3"));
	}

	@Test
	public void testWhiteWontFightWhite()
	{
		assertFalse(rules.checkMove(game, "b1d2"));
		assertFalse(rules.checkMove(game, "g1e2"));
	}

	@Test
	public void testToRightByBlack()
	{
		assertTrue(rules.checkMove(game, "b8c6"));
		assertTrue(rules.checkMove(game, "g8h6"));
	}

	@Test
	public void testToLeftByBlack()
	{
		assertTrue(rules.checkMove(game, "b8a6"));
		assertTrue(rules.checkMove(game, "g8f6"));
	}

	@Test
	public void testBlackWontFightBlack()
	{
		assertFalse(rules.checkMove(game, "b8d7"));
		assertFalse(rules.checkMove(game, "g8e7"));
	}

	private static Rules rules;
	private static Game game;
}
