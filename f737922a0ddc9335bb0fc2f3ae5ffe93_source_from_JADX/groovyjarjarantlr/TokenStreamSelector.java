package groovyjarjarantlr;

import groovyjarjarantlr.ASdebug.IASDebugStream;
import groovyjarjarantlr.collections.Stack;
import groovyjarjarantlr.collections.impl.LList;
import java.util.Hashtable;

public class TokenStreamSelector implements IASDebugStream, TokenStream {
    protected TokenStream DW;
    protected Stack FH;
    protected Hashtable j6;

    public TokenStreamSelector() {
        this.FH = new LList();
        this.j6 = new Hashtable();
    }

    public Token j6() {
        while (true) {
            try {
                break;
            } catch (TokenStreamRetryException e) {
            }
        }
        return this.DW.j6();
    }
}
