/*
 * Game.java
 */

package ua.edu.donntu.cs.chess.components.rules;

import ua.edu.donntu.cs.chess.components.model.Board;

/**
 * Description.
 *
 * @author Rod Odin
 */
public interface Game
{
  Board getBoard();
  String getMoves();
  void addMove(String lastMove);
  //...
}

