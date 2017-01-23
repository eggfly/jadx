package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;
import java.util.Hashtable;

public class CSharpCodeGenerator extends CodeGenerator {
    private static CSharpNameSpace U2;
    protected static final String tp;
    protected boolean DW;
    protected boolean FH;
    boolean Hw;
    Hashtable VH;
    RuleBlock Zo;
    Hashtable gn;
    protected int j6;
    int u7;
    String v5;

    static {
        tp = new String();
        U2 = null;
    }

    public CSharpCodeGenerator() {
        this.j6 = 0;
        this.DW = false;
        this.FH = false;
        this.Hw = false;
        this.VH = new Hashtable();
        this.gn = new Hashtable();
        this.u7 = 1;
        this.Ws = new CSharpCharFormatter();
    }

    protected String j6(int i) {
        return new StringBuffer().append("tokenSet_").append(i).append("_").toString();
    }

    public String j6(String str) {
        if (!this.Hw) {
            return str;
        }
        if (((this.J0 instanceof TreeWalkerGrammar) || (this.J0 instanceof ParserGrammar)) && !this.J0.Hw.DW(str)) {
            return new StringBuffer().append("(AST)").append(str).toString();
        }
        return str;
    }

    public String j6(Vector vector) {
        if (vector.DW() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("(").append(this.v5).append(") astFactory.make(").toString());
        stringBuffer.append(vector.j6(0));
        for (int i = 1; i < vector.DW(); i++) {
            stringBuffer.append(new StringBuffer().append(", ").append(vector.j6(i)).toString());
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public String j6(GrammarAtom grammarAtom, String str) {
        String stringBuffer = new StringBuffer().append("astFactory.create(").append(str).append(")").toString();
        if (grammarAtom == null) {
            return DW(str);
        }
        if (grammarAtom.v5() != null) {
            TokenSymbol j6 = this.J0.Hw.j6(grammarAtom.FH());
            if (j6 == null || j6.j6() != grammarAtom.v5()) {
                return new StringBuffer().append("(").append(grammarAtom.v5()).append(") astFactory.create(").append(str).append(", \"").append(grammarAtom.v5()).append("\")").toString();
            }
            if (j6 == null || j6.j6() == null) {
                return stringBuffer;
            }
            return new StringBuffer().append("(").append(j6.j6()).append(") ").append(stringBuffer).toString();
        } else if (this.Hw) {
            return new StringBuffer().append("(").append(this.v5).append(") ").append(stringBuffer).toString();
        } else {
            return stringBuffer;
        }
    }

    public String DW(String str) {
        if (str == null) {
            str = "";
        }
        String stringBuffer = new StringBuffer().append("astFactory.create(").append(str).append(")").toString();
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            if (str.substring(indexOf + 1, str.length()).indexOf(44) != -1) {
                str = substring;
            } else {
                str = substring;
            }
        }
        TokenSymbol j6 = this.J0.Hw.j6(str);
        if (j6 == null || j6.j6() == null) {
            return this.Hw ? new StringBuffer().append("(").append(this.v5).append(") ").append(stringBuffer).toString() : stringBuffer;
        } else {
            return new StringBuffer().append("(").append(j6.j6()).append(") ").append(stringBuffer).toString();
        }
    }

    public String j6(String str, ActionTransInfo actionTransInfo) {
        int i = 0;
        if (this.Zo == null) {
            return str;
        }
        int i2;
        String str2;
        if (this.J0 instanceof TreeWalkerGrammar) {
            if (!this.J0.FH) {
                i2 = 1;
            } else if (str.length() > 3 && str.lastIndexOf("_in") == str.length() - 3) {
                str = str.substring(0, str.length() - 3);
                i2 = 1;
            }
            while (i < this.Zo.J8.DW()) {
                if (((AlternativeElement) this.Zo.J8.j6(i)).j6().equals(str)) {
                    i++;
                } else if (i2 != 0) {
                    return new StringBuffer().append(str).append("_AST").toString();
                } else {
                    return str;
                }
            }
            str2 = (String) this.VH.get(str);
            if (str2 == null) {
                if (str2 == tp) {
                    this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.Zo.FH()).toString());
                    return null;
                } else if (str2.equals(this.Zo.FH())) {
                    if (i2 != 0) {
                        str2 = new StringBuffer().append(str2).append("_in").toString();
                    }
                    return str2;
                } else {
                    this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.Zo.FH()).toString());
                    return null;
                }
            } else if (str.equals(this.Zo.FH())) {
                return str;
            } else {
                str = i2 == 0 ? new StringBuffer().append(str).append("_AST_in").toString() : new StringBuffer().append(str).append("_AST").toString();
                if (actionTransInfo == null && i2 == 0) {
                    actionTransInfo.DW = str;
                    return str;
                }
            }
        }
        i2 = 0;
        while (i < this.Zo.J8.DW()) {
            if (((AlternativeElement) this.Zo.J8.j6(i)).j6().equals(str)) {
                i++;
            } else if (i2 != 0) {
                return str;
            } else {
                return new StringBuffer().append(str).append("_AST").toString();
            }
        }
        str2 = (String) this.VH.get(str);
        if (str2 == null) {
            if (str.equals(this.Zo.FH())) {
                return str;
            }
            if (i2 == 0) {
            }
            return actionTransInfo == null ? str : str;
        } else if (str2 == tp) {
            this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.Zo.FH()).toString());
            return null;
        } else if (str2.equals(this.Zo.FH())) {
            if (i2 != 0) {
                str2 = new StringBuffer().append(str2).append("_in").toString();
            }
            return str2;
        } else {
            this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.Zo.FH()).toString());
            return null;
        }
    }
}
