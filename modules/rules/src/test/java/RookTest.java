/*
 * RookTest.java
 */

import static org.junit.Assert.*;
import org.junit.*;

import ua.edu.donntu.cs.chess.components.model.*;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.chess.impl.StandardChessPiece;
import ua.edu.donntu.cs.chess.components.rules.Game;
import ua.edu.donntu.cs.chess.components.rules.Rules;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.GameImpl;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.RulesImpl;

public class RookTest
{
	@BeforeClass
	public static void SetUp()
	{
		rules = new RulesImpl();
		game = new GameImpl();
		TestUtils.getAreaAt(game, "d4").setPiece(new StandardChessPiece(ChessPieceName.ROOK, Color.WHITE));
	}

	@Test
	public void testAllowedMoves()
	{
		assertTrue(rules.checkMove(game, "d4d3"));
		assertTrue(rules.checkMove(game, "d4d5"));
		assertTrue(rules.checkMove(game, "d4c4"));
		assertTrue(rules.checkMove(game, "d4e4"));
	}

	@Test
	public void testForbiddenMoves()
	{
		assertFalse(rules.checkMove(game, "d4c3"));
		assertFalse(rules.checkMove(game, "d4c5"));
		assertFalse(rules.checkMove(game, "d4e3"));
		assertFalse(rules.checkMove(game, "d4e5"));
	}

	@Test
	public void testTwoStepAllowedMoves()
	{
		assertTrue(rules.checkMove(game, "d4d6"));
		assertTrue(rules.checkMove(game, "d4b4"));
		assertTrue(rules.checkMove(game, "d4f4"));
	}

	@Test
	public void testTwoStepForbiddenMoves()
	{
		assertFalse(rules.checkMove(game, "d4b6"));
		assertFalse(rules.checkMove(game, "d4f6"));
	}

	@Test
	public void testFightFriends()
	{
		assertFalse(rules.checkMove(game, "d4d2"));
	}

	@Test
	public void testFightEnemies()
	{
		assertTrue(rules.checkMove(game, "d4d7"));
	}

	@Test
	public void testPiecesOnTheWay()
	{
		assertFalse(rules.checkMove(game, "d4d8"));
		assertFalse(rules.checkMove(game, "d4d1"));
	}

	private static Rules rules;
	private static Game game;
}
