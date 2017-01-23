package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;
import java.util.Hashtable;

public class PythonCodeGenerator extends CodeGenerator {
    protected static final String u7;
    protected boolean DW;
    protected boolean FH;
    String Hw;
    Hashtable VH;
    Hashtable Zo;
    int gn;
    protected int j6;
    RuleBlock v5;

    static {
        u7 = new String();
    }

    public PythonCodeGenerator() {
        this.j6 = 0;
        this.DW = false;
        this.FH = false;
        this.Zo = new Hashtable();
        this.VH = new Hashtable();
        this.gn = 1;
        this.Ws = new PythonCharFormatter();
        this.QX = true;
    }

    public String j6(Vector vector) {
        if (vector.DW() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("antlr.make(");
        for (int i = 0; i < vector.DW(); i++) {
            stringBuffer.append(vector.j6(i));
            if (i + 1 < vector.DW()) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public String j6(GrammarAtom grammarAtom, String str) {
        if (grammarAtom == null || grammarAtom.v5() == null) {
            return DW(str);
        }
        return new StringBuffer().append("self.astFactory.create(").append(str).append(", ").append(grammarAtom.v5()).append(")").toString();
    }

    public String DW(String str) {
        int i;
        if (str == null) {
            str = "";
        }
        int i2 = 0;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                i2++;
            }
        }
        if (i2 >= 2) {
            return new StringBuffer().append("self.astFactory.create(").append(str).append(")").toString();
        }
        String substring;
        i = str.indexOf(44);
        str.lastIndexOf(44);
        if (i2 > 0) {
            substring = str.substring(0, i);
        } else {
            substring = str;
        }
        TokenSymbol j6 = this.J0.Hw.j6(substring);
        if (j6 != null) {
            String j62 = j6.j6();
            substring = "";
            if (i2 == 0) {
                substring = ", \"\"";
            }
            if (j62 != null) {
                return new StringBuffer().append("self.astFactory.create(").append(str).append(substring).append(", ").append(j62).append(")").toString();
            }
        }
        if (this.Hw.equals("AST")) {
            return new StringBuffer().append("self.astFactory.create(").append(str).append(")").toString();
        }
        return new StringBuffer().append("self.astFactory.create(").append(str).append(")").toString();
    }

    public String j6(String str, ActionTransInfo actionTransInfo) {
        int i = 0;
        if (this.v5 == null) {
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
            while (i < this.v5.J8.DW()) {
                if (((AlternativeElement) this.v5.J8.j6(i)).j6().equals(str)) {
                    i++;
                } else if (i2 != 0) {
                    return new StringBuffer().append(str).append("_AST").toString();
                } else {
                    return str;
                }
            }
            str2 = (String) this.Zo.get(str);
            if (str2 == null) {
                if (str2 == u7) {
                    this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.v5.FH()).toString());
                    return null;
                } else if (str2.equals(this.v5.FH())) {
                    if (i2 != 0) {
                        str2 = new StringBuffer().append(str2).append("_in").toString();
                    }
                    return str2;
                } else {
                    this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.v5.FH()).toString());
                    return null;
                }
            } else if (str.equals(this.v5.FH())) {
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
        while (i < this.v5.J8.DW()) {
            if (((AlternativeElement) this.v5.J8.j6(i)).j6().equals(str)) {
                i++;
            } else if (i2 != 0) {
                return str;
            } else {
                return new StringBuffer().append(str).append("_AST").toString();
            }
        }
        str2 = (String) this.Zo.get(str);
        if (str2 == null) {
            if (str.equals(this.v5.FH())) {
                return str;
            }
            if (i2 == 0) {
            }
            return actionTransInfo == null ? str : str;
        } else if (str2 == u7) {
            this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.v5.FH()).toString());
            return null;
        } else if (str2.equals(this.v5.FH())) {
            if (i2 != 0) {
                str2 = new StringBuffer().append(str2).append("_in").toString();
            }
            return str2;
        } else {
            this.EQ.j6(new StringBuffer().append("Ambiguous reference to AST element ").append(str).append(" in rule ").append(this.v5.FH()).toString());
            return null;
        }
    }
}
