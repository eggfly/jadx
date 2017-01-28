import java.util.Iterator;

public final class wn extends xl {
    private final ue DW;
    private wj FH;
    private final boolean Hw;
    private wp Zo;
    private final abb j6;
    private final abn v5;

    public wn(abb abb, ue ueVar, boolean z, abn abn) {
        super(4, -1);
        if (abb == null) {
            throw new NullPointerException("ref == null");
        } else if (ueVar == null) {
            throw new NullPointerException("code == null");
        } else if (abn == null) {
            throw new NullPointerException("throwsList == null");
        } else {
            this.j6 = abb;
            this.DW = ueVar;
            this.Hw = z;
            this.v5 = abn;
            this.FH = null;
            this.Zo = null;
        }
    }

    public xd j6() {
        return xd.TYPE_CODE_ITEM;
    }

    public void j6(wq wqVar) {
        xk J8 = wqVar.J8();
        xv tp = wqVar.tp();
        if (this.DW.j6() || this.DW.DW()) {
            this.Zo = new wp(this.DW, this.Hw, this.j6);
            J8.j6(this.Zo);
        }
        if (this.DW.FH()) {
            Iterator it = this.DW.Hw().iterator();
            while (it.hasNext()) {
                tp.j6((abl) it.next());
            }
            this.FH = new wj(this.DW);
        }
        Iterator it2 = this.DW.v5().iterator();
        while (it2.hasNext()) {
            wqVar.j6((aah) it2.next());
        }
    }

    public String toString() {
        return "CodeItem{" + DW() + "}";
    }

    public String DW() {
        return this.j6.Hw();
    }

    protected void j6(xp xpVar, int i) {
        int DW;
        wq v5 = xpVar.v5();
        this.DW.j6(new wn$1(this, v5));
        if (this.FH != null) {
            this.FH.j6(v5);
            DW = this.FH.DW();
        } else {
            DW = 0;
        }
        int v52 = this.DW.Zo().v5();
        if ((v52 & 1) != 0) {
            v52++;
        }
        j6(DW + ((v52 * 2) + 16));
    }

    protected void a_(wq wqVar, acr acr) {
        boolean j6 = acr.j6();
        int gn = gn();
        int Hw = Hw();
        int FH = FH();
        int v5 = this.DW.Zo().v5();
        int i = (v5 & 1) != 0 ? 1 : 0;
        int j62 = this.FH == null ? 0 : this.FH.j6();
        int v52 = this.Zo == null ? 0 : this.Zo.v5();
        if (j6) {
            acr.j6(0, VH() + ' ' + this.j6.Hw());
            acr.j6(2, "  registers_size: " + add.FH(gn));
            acr.j6(2, "  ins_size:       " + add.FH(FH));
            acr.j6(2, "  outs_size:      " + add.FH(Hw));
            acr.j6(2, "  tries_size:     " + add.FH(j62));
            acr.j6(4, "  debug_off:      " + add.j6(v52));
            acr.j6(4, "  insns_size:     " + add.j6(v5));
            if (this.v5.m_() != 0) {
                acr.j6(0, "  throws " + abk.j6(this.v5));
            }
        }
        acr.DW(gn);
        acr.DW(FH);
        acr.DW(Hw);
        acr.DW(j62);
        acr.Hw(v52);
        acr.Hw(v5);
        DW(wqVar, acr);
        if (this.FH != null) {
            if (i != 0) {
                if (j6) {
                    acr.j6(2, "  padding: 0");
                }
                acr.DW(0);
            }
            this.FH.j6(wqVar, acr);
        }
        if (j6 && this.Zo != null) {
            acr.j6(0, "  debug info");
            this.Zo.j6(wqVar, acr, "    ");
        }
    }

    private void DW(wq wqVar, acr acr) {
        try {
            this.DW.Zo().j6(acr);
        } catch (Throwable e) {
            throw ada.j6(e, "...while writing instructions for " + this.j6.Hw());
        }
    }

    private int FH() {
        return this.j6.DW(this.Hw);
    }

    private int Hw() {
        return this.DW.Zo().VH();
    }

    private int gn() {
        return this.DW.Zo().Zo();
    }
}
