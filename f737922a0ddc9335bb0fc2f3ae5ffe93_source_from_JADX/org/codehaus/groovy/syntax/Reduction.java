package org.codehaus.groovy.syntax;

import java.util.Collections;
import java.util.List;

public class Reduction extends CSTNode {
    public static final Reduction j6;
    private List DW;
    private boolean FH;

    static {
        j6 = new Reduction();
    }

    private Reduction() {
        this.DW = null;
        this.FH = false;
        this.DW = Collections.EMPTY_LIST;
    }

    public boolean FH() {
        return Hw() == 0;
    }

    public int Hw() {
        return this.DW.size();
    }

    public CSTNode j6(int i) {
        if (i < Hw()) {
            return (CSTNode) this.DW.get(i);
        }
        return null;
    }

    public Token Zo() {
        if (Hw() > 0) {
            return (Token) this.DW.get(0);
        }
        return null;
    }
}
