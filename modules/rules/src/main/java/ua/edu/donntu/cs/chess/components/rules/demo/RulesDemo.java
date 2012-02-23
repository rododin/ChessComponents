/*
 * RulesDemo.java
 */

package ua.edu.donntu.cs.chess.components.rules.demo;

import ua.edu.donntu.cs.chess.components.rules.Constants;
import ua.edu.donntu.cs.chess.components.rules.Game;
import ua.edu.donntu.cs.chess.components.rules.Rules;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.GameImpl;
import ua.edu.donntu.cs.chess.components.rules.chess.impl.RulesImpl;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class RulesDemo
	implements Constants
{
	public static void main(String[] args)
	{
		Rules rules = new RulesImpl();
		Game game = new GameImpl();
		LOG.info(rules.checkMove(game, "a1a3"));
	}

}
