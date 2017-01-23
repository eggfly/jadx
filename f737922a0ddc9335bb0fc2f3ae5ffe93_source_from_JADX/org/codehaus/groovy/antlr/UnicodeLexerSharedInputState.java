package org.codehaus.groovy.antlr;

import groovyjarjarantlr.LexerSharedInputState;

public class UnicodeLexerSharedInputState extends LexerSharedInputState {
    private final UnicodeEscapingReader gn;
    private int u7;

    public int Hw() {
        this.u7 = this.gn.j6();
        return super.Hw() + this.u7;
    }

    public int DW() {
        if (this.DW == this.Hw) {
            return super.DW() + this.gn.j6();
        }
        return super.DW() + this.u7;
    }
}
