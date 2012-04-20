/*
 * KingTest.java
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

public class KingTest
{
	@BeforeClass
	public static void SetUp()
	{
		rules = new RulesImpl();
		game = new GameImpl();
		TestUtils.getAreaAt(game, "d4").setPiece(new StandardChessPiece(ChessPieceName.KING, Color.WHITE));
		TestUtils.getAreaAt(game, "e7").setPiece(new StandardChessPiece(ChessPieceName.KING, Color.WHITE));
	}

	@Test
	public void testAllowedMoves()
	{
		assertTrue(rules.checkMove(game, "d4d3"));
		assertTrue(rules.checkMove(game, "d4d5"));
		assertTrue(rules.checkMove(game, "d4c4"));
		assertTrue(rules.checkMove(game, "d4e4"));
		assertTrue(rules.checkMove(game, "d4c3"));
		assertTrue(rules.checkMove(game, "d4c5"));
		assertTrue(rules.checkMove(game, "d4e3"));
		assertTrue(rules.checkMove(game, "d4e5"));
	}

	@Test
	public void testTwoStepMoves()
	{
		assertFalse(rules.checkMove(game, "d4d2"));
		assertFalse(rules.checkMove(game, "d4d6"));
		assertFalse(rules.checkMove(game, "d4b4"));
		assertFalse(rules.checkMove(game, "d4f4"));
	}

	@Test
	public void testKingVSKing()
	{
		assertTrue(rules.checkMove(game, "e7e8"));
		assertTrue(rules.checkMove(game, "e8e7"));
	}

	@Test
	public void testKingVSItsFriends()
	{
		assertFalse(rules.checkMove(game, "e8d8"));
		assertFalse(rules.checkMove(game, "e1d2"));
	}

	private static Rules rules;
	private static Game game;
}
