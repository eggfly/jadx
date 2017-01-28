public final class xn extends xb {
    private final abe DW;
    private xw FH;
    private final abj j6;

    public xn(abj abj) {
        if (abj == null) {
            throw new NullPointerException("prototype == null");
        }
        this.j6 = abj;
        this.DW = j6(abj);
        abn FH = abj.FH();
        this.FH = FH.m_() == 0 ? null : new xw(FH);
    }

    private static abe j6(abj abj) {
        abk FH = abj.FH();
        int m_ = FH.m_();
        StringBuilder stringBuilder = new StringBuilder(m_ + 1);
        stringBuilder.append(j6(abj.DW()));
        for (int i = 0; i < m_; i++) {
            stringBuilder.append(j6(FH.j6(i)));
        }
        return new abe(stringBuilder.toString());
    }

    private static char j6(abl abl) {
        char charAt = abl.gn().charAt(0);
        if (charAt == '[') {
            return 'L';
        }
        return charAt;
    }

    public xd j6() {
        return xd.TYPE_PROTO_ID_ITEM;
    }

    public int n_() {
        return 12;
    }

    public void j6(wq wqVar) {
        xt VH = wqVar.VH();
        xv tp = wqVar.tp();
        xk v5 = wqVar.v5();
        tp.j6(this.j6.DW());
        VH.j6(this.DW);
        if (this.FH != null) {
            this.FH = (xw) v5.DW(this.FH);
        }
    }

    public void j6(wq wqVar, acr acr) {
        int DW = wqVar.VH().DW(this.DW);
        int DW2 = wqVar.tp().DW(this.j6.DW());
        int DW3 = xl.DW(this.FH);
        if (acr.j6()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.j6.DW().Hw());
            stringBuilder.append(" proto(");
            abk FH = this.j6.FH();
            int m_ = FH.m_();
            for (int i = 0; i < m_; i++) {
                if (i != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(FH.j6(i).Hw());
            }
            stringBuilder.append(")");
            acr.j6(0, gn() + ' ' + stringBuilder.toString());
            acr.j6(4, "  shorty_idx:      " + add.j6(DW) + " // " + this.DW.u7());
            acr.j6(4, "  return_type_idx: " + add.j6(DW2) + " // " + this.j6.DW().Hw());
            acr.j6(4, "  parameters_off:  " + add.j6(DW3));
        }
        acr.Hw(DW);
        acr.Hw(DW2);
        acr.Hw(DW3);
    }
}
