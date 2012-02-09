/*
 * RulesImpl.java
 */

package ua.edu.donntu.cs.chess.components.rules.impl;

import ua.edu.donntu.cs.chess.components.rules.Game;
import ua.edu.donntu.cs.chess.components.rules.Rules;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class RulesImpl
  implements Rules
{
  public RulesImpl()
  {
  }

  @Override
  public boolean checkMove(Game game, String move)
  {
    return false;
  }
}

