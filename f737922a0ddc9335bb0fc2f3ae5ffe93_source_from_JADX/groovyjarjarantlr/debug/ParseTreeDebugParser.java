package groovyjarjarantlr.debug;

import groovyjarjarantlr.CommonToken;
import groovyjarjarantlr.LLkParser;
import groovyjarjarantlr.ParseTreeRule;
import groovyjarjarantlr.ParseTreeToken;
import groovyjarjarantlr.collections.AST;
import groovyjarjarantlr.collections.impl.BitSet;
import java.util.Stack;

public class ParseTreeDebugParser extends LLkParser {
    protected Stack j6;

    public void FH(int i) {
        VH();
        super.FH(i);
    }

    public void j6(BitSet bitSet) {
        VH();
        super.j6(bitSet);
    }

    public void Hw(int i) {
        VH();
        super.Hw(i);
    }

    protected void VH() {
        if (this.Ws.DW <= 0) {
            AST parseTreeToken;
            ParseTreeRule parseTreeRule = (ParseTreeRule) this.j6.peek();
            if (j6(1) == 1) {
                parseTreeToken = new ParseTreeToken(new CommonToken("EOF"));
            } else {
                parseTreeToken = new ParseTreeToken(DW(1));
            }
            parseTreeRule.j6(parseTreeToken);
        }
    }
}
