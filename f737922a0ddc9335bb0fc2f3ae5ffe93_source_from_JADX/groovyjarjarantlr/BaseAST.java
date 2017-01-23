package groovyjarjarantlr;

import groovyjarjarantlr.collections.AST;
import java.io.Serializable;

public abstract class BaseAST implements AST, Serializable {
    private static boolean FH;
    private static String[] Hw;
    protected BaseAST DW;
    protected BaseAST j6;

    static {
        FH = false;
        Hw = null;
    }

    public void j6(AST ast) {
        if (ast != null) {
            BaseAST baseAST = this.j6;
            if (baseAST != null) {
                while (baseAST.DW != null) {
                    baseAST = baseAST.DW;
                }
                baseAST.DW = (BaseAST) ast;
                return;
            }
            this.j6 = (BaseAST) ast;
        }
    }

    public int VH() {
        BaseAST baseAST = this.j6;
        int i = 0;
        if (baseAST != null) {
            i = 1;
            while (baseAST.DW != null) {
                baseAST = baseAST.DW;
                i++;
            }
        }
        return i;
    }

    public AST j6() {
        return this.j6;
    }

    public AST DW() {
        return this.DW;
    }

    public String FH() {
        return "";
    }

    public int Hw() {
        return 0;
    }

    public int v5() {
        return 0;
    }

    public int Zo() {
        return 0;
    }

    public void FH(AST ast) {
        this.j6 = (BaseAST) ast;
    }

    public void Hw(AST ast) {
        this.DW = (BaseAST) ast;
    }

    public void j6(String str) {
    }

    public void j6(int i) {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!FH || FH() == null || FH().equalsIgnoreCase(Hw[Hw()]) || FH().equalsIgnoreCase(StringUtils.j6(Hw[Hw()], "\"", "\""))) {
            return FH();
        }
        stringBuffer.append('[');
        stringBuffer.append(FH());
        stringBuffer.append(",<");
        stringBuffer.append(Hw[Hw()]);
        stringBuffer.append(">]");
        return stringBuffer.toString();
    }
}
