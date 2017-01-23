package org.codehaus.groovy.syntax;

import org.codehaus.groovy.GroovyBugError;

public class Token extends CSTNode {
    public static final Token DW;
    public static final Token j6;
    private int FH;
    private int Hw;
    private int VH;
    private int Zo;
    private String v5;

    static {
        j6 = new Token();
        DW = new Token(-1, "", -1, -1);
    }

    public Token(int i, String str, int i2, int i3) {
        this.FH = 0;
        this.Hw = 0;
        this.v5 = "";
        this.Zo = -1;
        this.VH = -1;
        this.FH = i;
        this.Hw = i;
        this.v5 = str;
        this.Zo = i2;
        this.VH = i3;
    }

    private Token() {
        this.FH = 0;
        this.Hw = 0;
        this.v5 = "";
        this.Zo = -1;
        this.VH = -1;
    }

    public int j6() {
        return this.Hw;
    }

    public int DW() {
        return this.FH;
    }

    public int Hw() {
        return 1;
    }

    public CSTNode j6(int i) {
        if (i <= 0) {
            return this;
        }
        throw new GroovyBugError("attempt to access Token element other than root");
    }

    public Token Zo() {
        return this;
    }

    public String u7() {
        return this.v5;
    }

    public int VH() {
        return this.Zo;
    }

    public int gn() {
        return this.VH;
    }

    public static Token j6(int i, int i2, int i3) {
        return new Token(i, Types.j6(i), i2, i3);
    }

    public static Token j6(String str, int i, int i2) {
        return new Token(Types.j6(str), str, i, i2);
    }
}
