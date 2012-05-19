import java.util.*;

public class FullNotation implements Notation {
    protected String _startPos      = null;
    protected String _endPos        = null;
    protected String _Figure        = null;
    protected String _moveType      = null;
    protected String _moveResult    = null;
    protected String _transformed   = null;
    
    // this maps can be replaced with constants or something other
    protected Map<String, String> _Figures   = new HashMap<String, String>();
    protected Map<String, String> _MoveTypes = new HashMap<String, String>();

    public FullNotation(String start, String end, String figure, String type, String result, String transformed) {
        this._initFigures();
        this._initMoveTypes();
        
        this._startPos       = start;
        this._endPos         = end;
        this._Figure         = this.getFigureSign(figure);
        this._transformed    = (transformed.equals("") || transformed.isEmpty()) ? "" : this.getFigureSign(transformed);
        this._moveType       = this.getMoveTypeSign(type);
        this._moveResult     = this.getMoveTypeSign(result);
    }

    @Override
    public String makeNotation() {
        return this._makeNotation();
    }
    
    protected String _makeNotation() {
        return this._Figure + this._startPos + this._moveType + this._endPos + this._transformed + this._moveResult;
    }
    
    protected void _initFigures() {
        this._Figures.put("King",   "K");
        this._Figures.put("Queen",  "Q");
        this._Figures.put("Rook",   "R");
        this._Figures.put("Knight", "N");
        this._Figures.put("Bishop", "B");
        this._Figures.put("Pawn",   "");
    }
    
    protected void _initMoveTypes() {
        this._MoveTypes.put("silent",     "-");
        this._MoveTypes.put("capture",    "x");
        this._MoveTypes.put("move",       "+");
        this._MoveTypes.put("doubleMove", "++");
        this._MoveTypes.put("mate",       "#");
        this._MoveTypes.put("transform",  ""); // for pawn transformation
    }

    public String getFigureSign(String figure) {
        return this._Figures.get(figure);
    }
    
    public String getMoveTypeSign(String type) {
        return (type.equals("") || type.isEmpty()) ? "" : this._MoveTypes.get(type);
    }
}
