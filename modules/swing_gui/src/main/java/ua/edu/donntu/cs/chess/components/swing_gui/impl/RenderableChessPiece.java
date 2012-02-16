package ua.edu.donntu.cs.chess.components.swing_gui.impl;

import ua.edu.donntu.cs.chess.components.model.Color;
import ua.edu.donntu.cs.chess.components.model.chess.ChessPieceName;
import ua.edu.donntu.cs.chess.components.model.chess.impl.StandardChessPiece;

/**
 * Created by IntelliJ
 * Date: 22.11.11
 * Time: 10:28IDEA.
 * User: Ferrari
 * To change this template use File | Settings | File Templates.
 */
public class RenderableChessPiece
  extends StandardChessPiece
{
	public RenderableChessPiece(ChessPieceName name, Color color, String path)
	{
		super(name, color);
		this.path = path;
	}

	public String getPath()
	{
		return path;
	}

	private final String path;
}
