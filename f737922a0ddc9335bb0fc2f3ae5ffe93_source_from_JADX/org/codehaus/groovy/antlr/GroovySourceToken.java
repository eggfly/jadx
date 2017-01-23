package org.codehaus.groovy.antlr;

import groovyjarjarantlr.Token;

public class GroovySourceToken extends Token implements SourceInfo {
    protected String DW;
    protected int FH;
    protected int Hw;
    protected int j6;
    protected int v5;

    public GroovySourceToken(int i) {
        super(i);
        this.DW = "";
    }

    public int v5() {
        return this.j6;
    }

    public String FH() {
        return this.DW;
    }

    public void j6(int i) {
        this.j6 = i;
    }

    public void j6(String str) {
        this.DW = str;
    }

    public String toString() {
        return "[\"" + FH() + "\",<" + this.Zo + ">," + "line=" + this.j6 + ",col=" + this.FH + ",lineLast=" + this.Hw + ",colLast=" + this.v5 + "]";
    }

    public int Zo() {
        return this.FH;
    }

    public void DW(int i) {
        this.FH = i;
    }

    public int gn() {
        return this.Hw;
    }

    public void Hw(int i) {
        this.Hw = i;
    }

    public int u7() {
        return this.v5;
    }

    public void v5(int i) {
        this.v5 = i;
    }
}
