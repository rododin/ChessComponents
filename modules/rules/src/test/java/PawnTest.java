/*
 * PawnTest.java
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

public class PawnTest
{
	@Before
	public void SetUp()
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

	@Test
	public void testPawnFightsAnotherPawn()
	{
		TestUtils.getAreaAt(game, "b3").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.BLACK));

		assertTrue(rules.checkMove(game, "a2b3"));
		assertTrue(rules.checkMove(game, "c2b3"));
		assertTrue(rules.checkMove(game, "b3a2"));
		assertTrue(rules.checkMove(game, "b3c2"));
	}

	@Test
	public void testPawnCantMoveOverAnotherPawn()
	{
		TestUtils.getAreaAt(game, "b3").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.BLACK));

		assertFalse(rules.checkMove(game, "b2b3"));
		assertFalse(rules.checkMove(game, "b3b2"));
	}

	@Test
	public void testPawnCantMoveBack()
	{
		TestUtils.getAreaAt(game, "a5").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.BLACK));
		TestUtils.getAreaAt(game, "a4").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.WHITE));

		assertFalse(rules.checkMove(game, "a4a3"));
		assertFalse(rules.checkMove(game, "a4a2"));
		assertFalse(rules.checkMove(game, "a5a6"));
		assertFalse(rules.checkMove(game, "a5a7"));
	}

	@Test
	public void testPawnCantJumpOverAnotherPiece()
	{
		TestUtils.getAreaAt(game, "a3").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.BLACK));

		assertFalse(rules.checkMove(game, "a2a4"));
	}

	@Test
	public void testCorrectEnPassant()
	{
		TestUtils.getAreaAt(game, "b4").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.BLACK));
		TestUtils.getAreaAt(game, "a4").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.WHITE));
		TestUtils.getAreaAt(game, "a2").setPiece(null);

		game.addMove("a2a4");
		assertTrue(rules.checkMove(game, "b4a3"));
	}

	@Test
	public void testWrongEnPassantBadDistance()
	{
		TestUtils.getAreaAt(game, "b4").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.BLACK));
		TestUtils.getAreaAt(game, "a4").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.WHITE));
		TestUtils.getAreaAt(game, "a2").setPiece(null);

		game.addMove("a3a4");
		assertFalse(rules.checkMove(game, "b4a3"));
	}

	@Test
	public void testWrongEnPassantWrongFigure()
	{
		TestUtils.getAreaAt(game, "b4").setPiece(new StandardChessPiece(ChessPieceName.PAWN, Color.BLACK));
		TestUtils.getAreaAt(game, "a4").setPiece(new StandardChessPiece(ChessPieceName.KNIGHT, Color.WHITE));
		TestUtils.getAreaAt(game, "a2").setPiece(null);

		game.addMove("a2a4");
		assertFalse(rules.checkMove(game, "b4a3"));
	}

	private Rules rules;
	private Game game;
}
