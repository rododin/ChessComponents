package ua.edu.donntu.cs.chess.components.swing_gui.impl;

import ua.edu.donntu.cs.chess.components.model.chess.Color;
import ua.edu.donntu.cs.chess.components.model.chess.PieceName;
import ua.edu.donntu.cs.chess.components.model.chess.impl.StandardPiece;

/**
 * Created by IntelliJ
 * Date: 22.11.11
 * Time: 10:28IDEA.
 * User: Ferrari
 * To change this template use File | Settings | File Templates.
 */
public class RenderablePiece
  extends StandardPiece
{
	public RenderablePiece(PieceName name, Color color, String path)
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
