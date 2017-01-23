package groovyjarjarantlr;

import groovyjarjarantlr.collections.AST;

public class NoViableAltException extends RecognitionException {
    public AST DW;
    public Token j6;

    public NoViableAltException(Token token, String str) {
        super("NoViableAlt", str, token.v5(), token.Zo());
        this.j6 = token;
    }

    public String getMessage() {
        if (this.j6 != null) {
            return new StringBuffer().append("unexpected token: ").append(this.j6.FH()).toString();
        }
        if (this.DW == TreeParser.j6) {
            return "unexpected end of subtree";
        }
        return new StringBuffer().append("unexpected AST node: ").append(this.DW.toString()).toString();
    }
}
