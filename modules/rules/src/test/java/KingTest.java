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
	public static void SetUpClass()
	{
		rules = new RulesImpl();
	}

	@Before
	public void SetUp()
	{
		game = new GameImpl();
		TestUtils.getAreaAt(game, "d4").setPiece(new StandardChessPiece(ChessPieceName.KING, Color.WHITE));
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
		TestUtils.getAreaAt(game, "e7").setPiece(new StandardChessPiece(ChessPieceName.KING, Color.WHITE));
		assertTrue(rules.checkMove(game, "e7e8"));
		assertTrue(rules.checkMove(game, "e8e7"));
	}

	@Test
	public void testKingVSItsFriends()
	{
		assertFalse(rules.checkMove(game, "e8d8"));
		assertFalse(rules.checkMove(game, "e1d2"));
	}

	@Test
	public void testWhiteLeftCastlingOk()
	{
		prepareForCastling("1");
		assertTrue(rules.checkMove(game, "e1a1"));
	}

	@Test
	public void testWhiteRightCastlingOk()
	{
		prepareForCastling("1");
		assertTrue(rules.checkMove(game, "e1h1"));
	}

	@Test
	public void testBlackLeftCastlingOk()
	{
		prepareForCastling("8");
		assertTrue(rules.checkMove(game, "e8a8"));
	}

	@Test
	public void testBlackRightCastlingOk()
	{
		prepareForCastling("8");
		assertTrue(rules.checkMove(game, "e8h8"));
	}

	@Test
	public void testCastlingAfterKingsMoveFalse()
	{
		// put move of king to the list of moves
		game.addMove("e1e2");
		game.addMove("e2e1");

		prepareForCastling("1");
		assertFalse(rules.checkMove(game, "e1a1"));
	}

	@Test
	public void testCastlingAfterRooksMoveFalse()
	{
		// put move of rook to the list of moves
		game.addMove("a1a2");
		game.addMove("a2a1");

		prepareForCastling("1");
		assertFalse(rules.checkMove(game, "e1a1"));
	}

	@Test
	public void testCastlingPiecesOnTheWayFalse()
	{
		assertFalse(rules.checkMove(game, "e1a1"));
	}

	@Test
	public void testCastlingPiecesOnTheFireFalse()
	{
		TestUtils.getAreaAt(game, "f2").setPiece(null);
		Piece piece = new StandardChessPiece(ChessPieceName.ROOK, Color.BLACK);
		TestUtils.getAreaAt(game, "f3").setPiece(piece);

		prepareForCastling("1");
		assertFalse(rules.checkMove(game, "e1h1"));
	}

	@Test
	public void testCastlingKingUnderFireFalse()
	{
		TestUtils.getAreaAt(game, "e2").setPiece(null);
		Piece piece = new StandardChessPiece(ChessPieceName.ROOK, Color.BLACK);
		TestUtils.getAreaAt(game, "e3").setPiece(piece);

		prepareForCastling("1");
		assertFalse(rules.checkMove(game, "e1h1"));
	}

	private static void prepareForCastling(String line)
	{
		TestUtils.getAreaAt(game, "b" + line).setPiece(null);
		TestUtils.getAreaAt(game, "c" + line).setPiece(null);
		TestUtils.getAreaAt(game, "d" + line).setPiece(null);
		TestUtils.getAreaAt(game, "f" + line).setPiece(null);
		TestUtils.getAreaAt(game, "g" + line).setPiece(null);
	}

	private static Rules rules;
	private static Game game;
}
