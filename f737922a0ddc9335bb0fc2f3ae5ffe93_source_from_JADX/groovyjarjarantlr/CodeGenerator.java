package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.BitSet;
import groovyjarjarantlr.collections.impl.Vector;

public abstract class CodeGenerator {
    public static String Mr;
    public static String j3;
    private static boolean j6;
    protected Tool EQ;
    protected Grammar J0;
    protected Vector J8;
    protected boolean QX;
    protected CharFormatter Ws;
    protected int XL;
    protected int aM;
    protected int we;

    public abstract String j6(GrammarAtom grammarAtom, String str);

    public abstract String j6(Vector vector);

    public abstract String j6(String str, ActionTransInfo actionTransInfo);

    static {
        j6 = true;
        j3 = "TokenTypes";
        Mr = ".txt";
    }

    public CodeGenerator() {
        this.we = 0;
        this.J0 = null;
        this.QX = false;
        this.XL = 2;
        this.aM = 4;
    }

    public String j6(String str) {
        return str;
    }

    protected String j6(int i) {
        return new StringBuffer().append("_tokenSet_").append(i).toString();
    }

    public static String FH(String str) {
        return new StringBuffer().append("m").append(str).toString();
    }

    protected int j6(BitSet bitSet) {
        for (int i = 0; i < this.J8.DW(); i++) {
            if (bitSet.equals((BitSet) this.J8.j6(i))) {
                return i;
            }
        }
        this.J8.j6(bitSet.clone());
        return this.J8.DW() - 1;
    }

    public String j6(String str, int i) {
        GrammarSymbol j6 = this.J0.j6(str);
        if (!(j6 instanceof RuleSymbol)) {
            return null;
        }
        return j6(j6(this.J0.j6.j6(i, ((RuleSymbol) j6).j6().J0).j6));
    }

    public String DW(String str, int i) {
        GrammarSymbol j6 = this.J0.j6(str);
        if (!(j6 instanceof RuleSymbol)) {
            return null;
        }
        return j6(j6(this.J0.j6.j6(i, ((RuleSymbol) j6).j6()).j6));
    }
}
