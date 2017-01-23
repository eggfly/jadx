package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;

public class RuleBlock extends AlternativeBlock {
    protected RuleEndElement J0;
    Vector J8;
    protected Lookahead[] QX;
    protected boolean[] Ws;
    protected String we;

    public String FH() {
        return this.we;
    }

    public Lookahead j6(int i) {
        return this.u7.j6.j6(i, this);
    }

    public String toString() {
        String str;
        Object obj = 1;
        String str2 = " FOLLOW={";
        Lookahead[] lookaheadArr = this.J0.FH;
        int i = this.u7.VH;
        int i2 = 1;
        while (i2 <= i) {
            if (lookaheadArr[i2] != null) {
                str2 = new StringBuffer().append(str2).append(lookaheadArr[i2].j6(",", this.u7.Hw.j6())).toString();
                obj = null;
                if (i2 < i && lookaheadArr[i2 + 1] != null) {
                    str2 = new StringBuffer().append(str2).append(";").toString();
                }
            }
            i2++;
        }
        str2 = new StringBuffer().append(str2).append("}").toString();
        if (obj != null) {
            str = "";
        } else {
            str = str2;
        }
        return new StringBuffer().append(this.we).append(": ").append(super.toString()).append(" ;").append(str).toString();
    }
}
