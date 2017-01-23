package org.codehaus.groovy.syntax;

import org.codehaus.groovy.GroovyException;

public class SyntaxException extends GroovyException {
    private final int DW;
    private final int FH;
    private final int Hw;
    private final int j6;
    private String v5;

    public SyntaxException(String str, int i, int i2, int i3, int i4) {
        super(str, false);
        this.j6 = i;
        this.FH = i2;
        this.DW = i3;
        this.Hw = i4;
    }

    public void j6(String str) {
        this.v5 = str;
    }

    public String getMessage() {
        return super.getMessage() + " @ line " + this.j6 + ", column " + this.FH + ".";
    }
}
