package groovyjarjarantlr;

import groovyjarjarantlr.collections.AST;

public class CommonAST extends BaseAST {
    int FH;
    String Hw;

    public String FH() {
        return this.Hw;
    }

    public int Hw() {
        return this.FH;
    }

    public void j6(int i, String str) {
        j6(i);
        j6(str);
    }

    public void DW(AST ast) {
        j6(ast.FH());
        j6(ast.Hw());
    }

    public CommonAST() {
        this.FH = 0;
    }

    public void j6(Token token) {
        j6(token.FH());
        j6(token.Hw());
    }

    public void j6(String str) {
        this.Hw = str;
    }

    public void j6(int i) {
        this.FH = i;
    }
}
