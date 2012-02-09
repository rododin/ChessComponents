/*
 * Rules.java
 */

package ua.edu.donntu.cs.chess.components.rules;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface Rules
	extends Constants
{
  boolean checkMove(Game game, String lastMove);
}
