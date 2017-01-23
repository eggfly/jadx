package org.codehaus.groovy.ast;

import org.codehaus.groovy.util.ListHashMap;

public class ASTNode {
    private int DW;
    private int FH;
    private int Hw;
    private int j6;
    private ListHashMap v5;

    public ASTNode() {
        this.j6 = -1;
        this.DW = -1;
        this.FH = -1;
        this.Hw = -1;
        this.v5 = null;
    }

    public String j6() {
        return "<not implemented yet for class: " + getClass().getName() + ">";
    }

    public int DW() {
        return this.j6;
    }

    public int FH() {
        return this.DW;
    }

    public int Hw() {
        return this.FH;
    }

    public int v5() {
        return this.Hw;
    }
}
