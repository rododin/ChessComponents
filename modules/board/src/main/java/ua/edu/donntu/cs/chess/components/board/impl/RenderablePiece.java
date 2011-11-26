package ua.edu.donntu.cs.chess.components.board.impl;

import ua.edu.donntu.cs.chess.components.generic.chess.Color;
import ua.edu.donntu.cs.chess.components.generic.chess.PieceName;
import ua.edu.donntu.cs.chess.components.generic.chess.impl.StandardPiece;

import java.util.LinkedHashMap;
import java.util.Map;

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
    public RenderablePiece(PieceName name, Color color, String path) {
        super(name, color);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    private final String path;

}
