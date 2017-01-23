package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.BitSet;
import groovyjarjarantlr.collections.impl.Vector;

public class Lookahead implements Cloneable {
    String DW;
    BitSet FH;
    boolean Hw;
    BitSet j6;

    public Lookahead() {
        this.Hw = false;
        this.j6 = new BitSet();
    }

    public Lookahead(BitSet bitSet) {
        this.Hw = false;
        this.j6 = bitSet;
    }

    public Lookahead(String str) {
        this();
        this.DW = str;
    }

    public Object clone() {
        try {
            Lookahead lookahead = (Lookahead) super.clone();
            lookahead.j6 = (BitSet) this.j6.clone();
            lookahead.DW = this.DW;
            if (this.FH != null) {
                lookahead.FH = (BitSet) this.FH.clone();
            }
            return lookahead;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public void j6(Lookahead lookahead) {
        if (this.DW == null) {
            this.DW = lookahead.DW;
        }
        if (lookahead.j6()) {
            this.Hw = true;
        }
        if (this.FH != null) {
            if (lookahead.FH != null) {
                this.FH.j6(lookahead.FH);
            }
        } else if (lookahead.FH != null) {
            this.FH = (BitSet) lookahead.FH.clone();
        }
        this.j6.j6(lookahead.j6);
    }

    public boolean j6() {
        return this.Hw;
    }

    public static Lookahead j6(int i) {
        Lookahead lookahead = new Lookahead();
        lookahead.j6.j6(i);
        return lookahead;
    }

    public void DW() {
        this.Hw = false;
    }

    public void FH() {
        this.Hw = true;
    }

    public String toString() {
        String str = "";
        String str2 = "";
        String str3 = "";
        String j6 = this.j6.j6(",");
        if (j6()) {
            str = "+<epsilon>";
        }
        if (this.DW != null) {
            str2 = new StringBuffer().append("; FOLLOW(").append(this.DW).append(")").toString();
        }
        if (this.FH != null) {
            str3 = new StringBuffer().append("; depths=").append(this.FH.j6(",")).toString();
        }
        return new StringBuffer().append(j6).append(str).append(str2).append(str3).toString();
    }

    public String j6(String str, CharFormatter charFormatter) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String j6 = this.j6.j6(str, charFormatter);
        if (j6()) {
            str2 = "+<epsilon>";
        }
        if (this.DW != null) {
            str3 = new StringBuffer().append("; FOLLOW(").append(this.DW).append(")").toString();
        }
        if (this.FH != null) {
            str4 = new StringBuffer().append("; depths=").append(this.FH.j6(",")).toString();
        }
        return new StringBuffer().append(j6).append(str2).append(str3).append(str4).toString();
    }

    public String j6(String str, CharFormatter charFormatter, Grammar grammar) {
        if (grammar instanceof LexerGrammar) {
            return j6(str, charFormatter);
        }
        return j6(str, grammar.Hw.j6());
    }

    public String j6(String str, Vector vector) {
        String str2 = "";
        String str3 = "";
        String j6 = this.j6.j6(str, vector);
        if (this.DW != null) {
            str2 = new StringBuffer().append("; FOLLOW(").append(this.DW).append(")").toString();
        }
        if (this.FH != null) {
            str3 = new StringBuffer().append("; depths=").append(this.FH.j6(",")).toString();
        }
        return new StringBuffer().append(j6).append(str2).append(str3).toString();
    }
}
