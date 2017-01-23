package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;
import java.util.Hashtable;

public class CppCodeGenerator extends CodeGenerator {
    private static String er;
    private static NameSpace gW;
    protected static final String lg;
    private static String yS;
    protected int DW;
    protected boolean FH;
    protected boolean Hw;
    Hashtable U2;
    boolean VH;
    protected boolean Zo;
    int a8;
    String gn;
    boolean j6;
    private Vector rN;
    Hashtable tp;
    RuleBlock u7;
    protected boolean v5;

    static {
        lg = new String();
        er = "ANTLR_USE_NAMESPACE(std)";
        yS = "ANTLR_USE_NAMESPACE(antlr)";
        gW = null;
    }

    public CppCodeGenerator() {
        this.j6 = false;
        this.DW = 0;
        this.FH = false;
        this.Hw = false;
        this.v5 = true;
        this.Zo = false;
        this.VH = false;
        this.tp = new Hashtable();
        this.U2 = new Hashtable();
        this.a8 = 1;
        this.Ws = new CppCharFormatter();
    }

    public String j6(String str) {
        if (!this.VH) {
            return str;
        }
        if (((this.J0 instanceof TreeWalkerGrammar) || (this.J0 instanceof ParserGrammar)) && !this.J0.Hw.DW(str)) {
            return new StringBuffer().append(yS).append("RefAST(").append(str).append(")").toString();
        }
        return str;
    }

    public String j6(Vector vector) {
        if (vector.DW() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append(this.gn).append("(astFactory->make((new ").append(yS).append("ASTArray(").append(vector.DW()).append("))").toString());
        for (int i = 0; i < vector.DW(); i++) {
            stringBuffer.append(new StringBuffer().append("->add(").append(vector.j6(i)).append(")").toString());
        }
        stringBuffer.append("))");
        return stringBuffer.toString();
    }

    public String j6(GrammarAtom grammarAtom, String str) {
        int i = 0;
        if (grammarAtom == null || grammarAtom.v5() == null) {
            if (str.indexOf(44) != -1) {
                i = this.J0.Hw.DW(str.substring(0, str.indexOf(44)));
            }
            if (this.VH && (this.J0 instanceof TreeWalkerGrammar) && !this.J0.Hw.DW(str) && r0 == 0) {
                return new StringBuffer().append("astFactory->create(").append(yS).append("RefAST(").append(str).append("))").toString();
            }
            return new StringBuffer().append("astFactory->create(").append(str).append(")").toString();
        }
        this.rN.DW(grammarAtom.Hw());
        String str2 = (String) this.rN.j6(grammarAtom.Hw());
        if (str2 == null) {
            this.rN.j6(grammarAtom.v5(), grammarAtom.Hw());
        } else if (grammarAtom.v5().equals(str2)) {
            this.rN.j6(grammarAtom.v5(), grammarAtom.Hw());
        } else {
            this.EQ.DW(new StringBuffer().append("Attempt to redefine AST type for ").append(grammarAtom.FH()).toString(), this.J0.j6(), grammarAtom.Zo(), grammarAtom.VH());
            this.EQ.DW(new StringBuffer().append(" from \"").append(str2).append("\" to \"").append(grammarAtom.v5()).append("\" sticking to \"").append(str2).append("\"").toString(), this.J0.j6(), grammarAtom.Zo(), grammarAtom.VH());
        }
        return new StringBuffer().append("astFactory->create(").append(str).append(")").toString();
    }

    public String j6(String str, ActionTransInfo actionTransInfo) {
        int i = 1;
        int i2 = 0;
        if (this.u7 == null) {
            return str;
        }
        if (this.J0 instanceof TreeWalkerGrammar) {
            int i3;
            if (this.J0.FH) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if (str.length() <= 3 || str.lastIndexOf("_in") != str.length() - 3) {
                i = i3;
            } else {
                str = str.substring(0, str.length() - 3);
            }
        } else {
            i = 0;
        }
        while (i2 < this.u7.J8.DW()) {
            if (!((AlternativeElement) this.u7.J8.j6(i2)).j6().equals(str)) {
                i2++;
            } else if (i == 0) {
                return new StringBuffer().append(str).append("_AST").toString();
            } else {
                return str;
            }
        }
        String str2 = (String) this.tp.get(str);
        if (str2 != null) {
            if (str2 == lg) {
                this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.u7.FH()).toString());
                return null;
            } else if (str2.equals(this.u7.FH())) {
                this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.u7.FH()).toString());
                return null;
            } else {
                if (i != 0) {
                    str2 = new StringBuffer().append(str2).append("_in").toString();
                }
                return str2;
            }
        } else if (!str.equals(this.u7.FH())) {
            return str;
        } else {
            str = i != 0 ? new StringBuffer().append(str).append("_AST_in").toString() : new StringBuffer().append(str).append("_AST").toString();
            if (actionTransInfo == null || i != 0) {
                return str;
            }
            actionTransInfo.DW = str;
            return str;
        }
    }
}
