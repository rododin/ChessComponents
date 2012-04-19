/*
 * BishopTest.java
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

public class BishopTest
{
	@BeforeClass
	public static void SetUp()
	{
		rules = new RulesImpl();
		game = new GameImpl();
		getAreaAt("d4").setPiece(new StandardChessPiece(ChessPieceName.BISHOP, Color.WHITE));
	}

	@Test
	public void testForbiddenMoves()
	{
		assertFalse(rules.checkMove(game, "d4d3"));
		assertFalse(rules.checkMove(game, "d4d5"));
		assertFalse(rules.checkMove(game, "d4c4"));
		assertFalse(rules.checkMove(game, "d4e4"));
	}

	@Test
	public void testAllowedMoves()
	{
		assertTrue(rules.checkMove(game, "d4c3"));
		assertTrue(rules.checkMove(game, "d4c5"));
		assertTrue(rules.checkMove(game, "d4e3"));
		assertTrue(rules.checkMove(game, "d4e5"));
	}

	@Test
	public void testTwoStepForbiddenMoves()
	{
		assertFalse(rules.checkMove(game, "d4d2"));
		assertFalse(rules.checkMove(game, "d4d6"));
		assertFalse(rules.checkMove(game, "d4b4"));
		assertFalse(rules.checkMove(game, "d4f4"));
	}

	@Test
	public void testTwoStepAllowedMoves()
	{
		assertTrue(rules.checkMove(game, "d4b6"));
		assertTrue(rules.checkMove(game, "d4f6"));
	}

	@Test
	public void testFightFriends()
	{
		assertFalse(rules.checkMove(game, "d4f2"));
		assertFalse(rules.checkMove(game, "d4b2"));
	}

	@Test
	public void testFightEnemies()
	{
		assertTrue(rules.checkMove(game, "d4a7"));
		assertTrue(rules.checkMove(game, "d4g7"));
	}

	@Test
	public void testPiecesOnTheWay()
	{
		assertFalse(rules.checkMove(game, "d4h8"));
	}

	private static Area getAreaAt(String position)
	{
		final int x = position.charAt(0) - 'a';
		final int y = position.charAt(1) - '1';

		Board board = game.getBoard();
		return board.getAreaAt(x, y);
	}

	private static Rules rules;
	private static Game game;
}
