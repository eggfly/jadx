package groovyjarjarantlr.collections.impl;

import groovyjarjarantlr.collections.AST;

public class ASTArray {
    public AST[] DW;
    public int j6;

    public ASTArray(int i) {
        this.j6 = 0;
        this.DW = new AST[i];
    }

    public ASTArray j6(AST ast) {
        AST[] astArr = this.DW;
        int i = this.j6;
        this.j6 = i + 1;
        astArr[i] = ast;
        return this;
    }
}
