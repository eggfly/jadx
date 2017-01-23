package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;

class AlternativeBlock extends AlternativeElement {
    protected Vector DW;
    protected String FH;
    protected int Hw;
    protected String j6;
    boolean v5;

    public Alternative DW(int i) {
        return (Alternative) this.DW.j6(i);
    }

    public String j6() {
        return this.FH;
    }

    public Lookahead j6(int i) {
        return this.u7.j6.j6(i, this);
    }

    public String toString() {
        String str = " (";
        if (this.j6 != null) {
            str = new StringBuffer().append(str).append(this.j6).toString();
        }
        String str2 = str;
        for (int i = 0; i < this.DW.DW(); i++) {
            Alternative DW = DW(i);
            Lookahead[] lookaheadArr = DW.Zo;
            int i2 = DW.VH;
            if (i2 != -1) {
                if (i2 == Integer.MAX_VALUE) {
                    str2 = new StringBuffer().append(str2).append("{?}:").toString();
                } else {
                    str2 = new StringBuffer().append(str2).append(" {").toString();
                    int i3 = 1;
                    while (i3 <= i2) {
                        str2 = new StringBuffer().append(str2).append(lookaheadArr[i3].j6(",", this.u7.Hw.j6())).toString();
                        if (i3 < i2 && lookaheadArr[i3 + 1] != null) {
                            str2 = new StringBuffer().append(str2).append(";").toString();
                        }
                        i3++;
                    }
                    str2 = new StringBuffer().append(str2).append("}:").toString();
                }
            }
            AlternativeElement alternativeElement = DW.j6;
            String str3 = DW.Hw;
            if (str3 != null) {
                str2 = new StringBuffer().append(str2).append(str3).toString();
            }
            while (alternativeElement != null) {
                str3 = new StringBuffer().append(str2).append(alternativeElement).toString();
                alternativeElement = alternativeElement.Zo;
                str2 = str3;
            }
            if (i < this.DW.DW() - 1) {
                str2 = new StringBuffer().append(str2).append(" |").toString();
            }
        }
        return new StringBuffer().append(str2).append(" )").toString();
    }
}
