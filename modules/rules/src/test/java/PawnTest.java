/*
 * PawnTest.java
 */

import static org.junit.Assert.*;
import org.junit.*;

import ua.edu.donntu.cs.chess.components.rules.Game;
import ua.edu.donntu.cs.chess.components.rules.Rules;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.GameImpl;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.RulesImpl;

public class PawnTest
{
	@BeforeClass
	public static void SetUp()
	{
		rules = new RulesImpl();
		game = new GameImpl();
	}

	@Test
	public void testOnePieceByWhite()
	{
		assertTrue(rules.checkMove(game, "a2a3"));
	}

	@Test
	public void testTwoPiecesByWhite()
	{
		assertTrue(rules.checkMove(game, "a2a4"));
	}

	@Test
	public void testThreePiecesByWhite()
	{
		assertFalse(rules.checkMove(game, "a2a5"));
	}

	@Test
	public void testSideMovesByWhite()
	{
		assertFalse(rules.checkMove(game, "d2c3"));
		assertFalse(rules.checkMove(game, "d2e3"));
	}

	@Test
	public void testOnePieceByBlack()
	{
		assertTrue(rules.checkMove(game, "a7a6"));
	}

	@Test
	public void testTwoPiecesByBlack()
	{
		assertTrue(rules.checkMove(game, "a7a5"));
	}

	@Test
	public void testThreePiecesByBlack()
	{
		assertFalse(rules.checkMove(game, "a7a4"));
	}

	@Test
	public void testSideMovesByBlack()
	{
		assertFalse(rules.checkMove(game, "d7c6"));
		assertFalse(rules.checkMove(game, "d7e6"));
	}

	private static Rules rules;
	private static Game game;
}
