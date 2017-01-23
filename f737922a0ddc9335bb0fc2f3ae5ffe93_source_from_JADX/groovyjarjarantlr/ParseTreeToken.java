package groovyjarjarantlr;

public class ParseTreeToken extends ParseTree {
    protected Token FH;

    public ParseTreeToken(Token token) {
        this.FH = token;
    }

    public String toString() {
        if (this.FH != null) {
            return this.FH.FH();
        }
        return "<missing token>";
    }
}
