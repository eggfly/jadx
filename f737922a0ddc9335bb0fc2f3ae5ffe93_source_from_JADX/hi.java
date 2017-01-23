public class hi implements be {
    private final cc j6;

    public hi(cc ccVar) {
        this.j6 = ccVar;
    }

    public String j6(int i) {
        return "";
    }

    public String j6(cp cpVar) {
        return ((cpVar.j6().j6() + "<br>") + "<code>") + this.j6.ro.j6(cpVar.VH()) + "</code>";
    }

    public String j6(bs bsVar) {
        return this.j6.ro.j6(bsVar.aq());
    }

    public String DW(bs bsVar) {
        return this.j6.ro.j6(bsVar.aq());
    }

    public String FH(bs bsVar) {
        String str = "";
        if (bsVar.zh() && ((bz) bsVar).gn()) {
            str = (((str + bsVar.Hw().j6() + "<br>") + "<code>") + "<b><font color=\"#2A50D0\">function</font></b> " + j6(bsVar)) + "<font color=\"#0000EE\">(</font>";
            int lp = ((bz) bsVar).lp();
            String str2 = str;
            for (int i = 0; i < lp; i++) {
                str2 = str2 + this.j6.ro.j6(((bz) bsVar).Zo(i));
                if (i < lp - 1) {
                    str2 = str2 + "<font color=\"#0000EE\">, </font>";
                }
            }
            return (str2 + "<font color=\"#0000EE\">) </font>") + "<p>";
        } else if (!bsVar.zh() || !((bz) bsVar).u7()) {
            return str;
        } else {
            return (((str + bsVar.Hw().j6() + "<br>") + "<code>") + "<b><font color=\"#2A50D0\">var</font></b> " + j6(bsVar)) + "<p>";
        }
    }

    public String j6(co coVar) {
        return "";
    }
}
