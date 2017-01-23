public final class wl extends xb {
    private final int DW;
    private final abf FH;
    private xw Hw;
    private wr VH;
    private final wk Zo;
    private wi gn;
    private final abf j6;
    private final abe v5;

    public wl(abf abf, int i, abf abf2, abn abn, abe abe) {
        if (abf == null) {
            throw new NullPointerException("thisClass == null");
        } else if (abn == null) {
            throw new NullPointerException("interfaces == null");
        } else {
            this.j6 = abf;
            this.DW = i;
            this.FH = abf2;
            this.Hw = abn.m_() == 0 ? null : new xw(abn);
            this.v5 = abe;
            this.Zo = new wk(abf);
            this.VH = null;
            this.gn = new wi();
        }
    }

    public xd j6() {
        return xd.TYPE_CLASS_DEF_ITEM;
    }

    public int n_() {
        return 32;
    }

    public void j6(wq wqVar) {
        xv tp = wqVar.tp();
        xk J8 = wqVar.J8();
        xk Hw = wqVar.Hw();
        xk v5 = wqVar.v5();
        xt VH = wqVar.VH();
        tp.j6(this.j6);
        if (!this.Zo.FH()) {
            wqVar.u7().j6(this.Zo);
            aak Hw2 = this.Zo.Hw();
            if (Hw2 != null) {
                this.VH = (wr) J8.DW(new wr(Hw2));
            }
        }
        if (this.FH != null) {
            tp.j6(this.FH);
        }
        if (this.Hw != null) {
            this.Hw = (xw) v5.DW(this.Hw);
        }
        if (this.v5 != null) {
            VH.j6(this.v5);
        }
        if (!this.gn.FH()) {
            if (this.gn.Hw()) {
                this.gn = (wi) Hw.DW(this.gn);
            } else {
                Hw.j6(this.gn);
            }
        }
    }

    public void j6(wq wqVar, acr acr) {
        boolean j6 = acr.j6();
        xv tp = wqVar.tp();
        int DW = tp.DW(this.j6);
        int DW2 = this.FH == null ? -1 : tp.DW(this.FH);
        int DW3 = xl.DW(this.Hw);
        int v5 = this.gn.FH() ? 0 : this.gn.v5();
        int DW4 = this.v5 == null ? -1 : wqVar.VH().DW(this.v5);
        int v52 = this.Zo.FH() ? 0 : this.Zo.v5();
        int DW5 = xl.DW(this.VH);
        if (j6) {
            String str;
            acr.j6(0, gn() + ' ' + this.j6.Hw());
            acr.j6(4, "  class_idx:           " + add.j6(DW));
            acr.j6(4, "  access_flags:        " + zh.j6(this.DW));
            StringBuilder append = new StringBuilder().append("  superclass_idx:      ").append(add.j6(DW2)).append(" // ");
            if (this.FH == null) {
                str = "<none>";
            } else {
                str = this.FH.Hw();
            }
            acr.j6(4, append.append(str).toString());
            acr.j6(4, "  interfaces_off:      " + add.j6(DW3));
            if (DW3 != 0) {
                abn FH = this.Hw.FH();
                int m_ = FH.m_();
                for (int i = 0; i < m_; i++) {
                    acr.j6(0, "    " + FH.j6(i).Hw());
                }
            }
            acr.j6(4, "  source_file_idx:     " + add.j6(DW4) + " // " + (this.v5 == null ? "<none>" : this.v5.Hw()));
            acr.j6(4, "  annotations_off:     " + add.j6(v5));
            acr.j6(4, "  class_data_off:      " + add.j6(v52));
            acr.j6(4, "  static_values_off:   " + add.j6(DW5));
        }
        acr.Hw(DW);
        acr.Hw(this.DW);
        acr.Hw(DW2);
        acr.Hw(DW3);
        acr.Hw(DW4);
        acr.Hw(v5);
        acr.Hw(v52);
        acr.Hw(DW5);
    }

    public abf FH() {
        return this.j6;
    }

    public abf Hw() {
        return this.FH;
    }

    public abn v5() {
        if (this.Hw == null) {
            return abk.j6;
        }
        return this.Hw.FH();
    }

    public void j6(ws wsVar, aah aah) {
        this.Zo.j6(wsVar, aah);
    }

    public void j6(ws wsVar) {
        this.Zo.j6(wsVar);
    }

    public void j6(wu wuVar) {
        this.Zo.j6(wuVar);
    }

    public void DW(wu wuVar) {
        this.Zo.DW(wuVar);
    }

    public void j6(ze zeVar) {
        this.gn.j6(zeVar);
    }

    public void j6(aar aar, ze zeVar) {
        this.gn.j6(aar, zeVar);
    }

    public void j6(abb abb, ze zeVar) {
        this.gn.j6(abb, zeVar);
    }

    public void j6(abb abb, zf zfVar) {
        this.gn.j6(abb, zfVar);
    }
}
