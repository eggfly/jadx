package groovyjarjarantlr;

import groovyjarjarantlr.ASdebug.IASDebugStream;
import groovyjarjarantlr.collections.impl.BitSet;

public class TokenStreamBasicFilter implements IASDebugStream, TokenStream {
    protected TokenStream DW;
    protected BitSet j6;

    public Token j6() {
        Token j6 = this.DW.j6();
        while (j6 != null && this.j6.Hw(j6.Hw())) {
            j6 = this.DW.j6();
        }
        return j6;
    }
}
