/*
 * StandardCheckerPiece.java
 */

package ua.edu.donntu.cs.chess.components.model.checkers.impl;

import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.model.checkers.CheckerPieceName;
import ua.edu.donntu.cs.chess.components.model.impl.AbstractPiece;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardCheckerPiece
extends AbstractPiece<CheckerPieceName>
{
// Constructors --------------------------------------------------------------------------------------------------------

public StandardCheckerPiece(CheckerPieceName name, Color color)
{
	super (name, color);
}
}
