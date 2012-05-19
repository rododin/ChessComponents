public class ShortNotation implements Notation {
    protected String _startPos      = null;
    protected String _endPos        = null;
    protected String _moveType      = null;
    protected String _moveResult    = null;

    public ShortNotation(String start, String end, String type, String result) {
        this._startPos      = start;
        this._endPos        = end;
        this._moveType      = this.getMoveTypeSign(type);
        this._moveResult    = (result.equals("") || result.isEmpty()) ? "" : this.getMoveTypeSign(result);
    }

    @Override
    public String makeNotation() {
        return this._makeNotation();
    }
    
    public String getMoveTypeSign(String type) {
        if (type.equals("capture"))
            return "x";
        if (type.equals("mate"))
            return "#";
        else
            return "";
    }

    protected String _makeNotation() {
        return this._startPos + this._moveType + this._endPos + this._moveResult;
    }
}
