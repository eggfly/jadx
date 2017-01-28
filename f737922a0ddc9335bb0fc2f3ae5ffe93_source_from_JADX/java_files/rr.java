import java.util.ArrayList;

public abstract class rr implements sf {
    private abm[] DW;
    private boolean EQ;
    private int FH;
    private abl Hw;
    private abm[] J0;
    private int J8;
    private int VH;
    private aah Zo;
    private sn gn;
    private final abj j6;
    private int tp;
    private ArrayList<aah> u7;
    private int v5;
    private zw we;

    public rr(abj abj) {
        if (abj == null) {
            throw new NullPointerException("prototype == null");
        }
        this.j6 = abj;
        this.DW = new abm[10];
        this.J0 = new abm[6];
        DW();
    }

    public abj j6() {
        return this.j6;
    }

    public final void DW() {
        this.FH = 0;
        this.Hw = null;
        this.v5 = 0;
        this.Zo = null;
        this.VH = 0;
        this.gn = null;
        this.u7 = null;
        this.tp = -1;
        this.EQ = false;
        this.we = null;
        this.J8 = -1;
    }

    public final void j6(sa saVar, int i) {
        rz Hw = saVar.Hw();
        DW();
        if (i > this.DW.length) {
            this.DW = new abm[(i + 10)];
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            this.DW[i2] = Hw.v5();
        }
        this.FH = i;
    }

    public void j6(sa saVar, abj abj) {
        abk FH = abj.FH();
        int m_ = FH.m_();
        j6(saVar, m_);
        int i = 0;
        while (i < m_) {
            if (sg.DW(FH.j6(i), this.DW[i])) {
                i++;
            } else {
                throw new sl("at stack depth " + ((m_ - 1) - i) + ", expected type " + FH.j6(i).Hw() + " but found " + this.DW[i].j6().Hw());
            }
        }
    }

    public final void j6(sa saVar, abl abl) {
        j6(saVar, 1);
        if (!sg.DW(abl, this.DW[0])) {
            throw new sl("expected type " + abl.Hw() + " but found " + this.DW[0].j6().Hw());
        }
    }

    public final void j6(sa saVar, abl abl, abl abl2) {
        j6(saVar, 2);
        if (!sg.DW(abl, this.DW[0])) {
            throw new sl("expected type " + abl.Hw() + " but found " + this.DW[0].j6().Hw());
        } else if (!sg.DW(abl2, this.DW[1])) {
            throw new sl("expected type " + abl2.Hw() + " but found " + this.DW[1].j6().Hw());
        }
    }

    public final void j6(sa saVar, abl abl, abl abl2, abl abl3) {
        j6(saVar, 3);
        if (!sg.DW(abl, this.DW[0])) {
            throw new sl("expected type " + abl.Hw() + " but found " + this.DW[0].j6().Hw());
        } else if (!sg.DW(abl2, this.DW[1])) {
            throw new sl("expected type " + abl2.Hw() + " but found " + this.DW[1].j6().Hw());
        } else if (!sg.DW(abl3, this.DW[2])) {
            throw new sl("expected type " + abl3.Hw() + " but found " + this.DW[2].j6().Hw());
        }
    }

    public final void DW(sa saVar, int i) {
        DW();
        this.DW[0] = saVar.FH().j6(i);
        this.FH = 1;
        this.tp = i;
    }

    public final void j6(boolean z) {
        this.EQ = z;
    }

    public final void j6(abl abl) {
        this.Hw = abl;
    }

    public final void j6(int i) {
        this.v5 = i;
    }

    public final void j6(aah aah) {
        if (aah == null) {
            throw new NullPointerException("cst == null");
        }
        this.Zo = aah;
    }

    public final void DW(int i) {
        this.VH = i;
    }

    public final void j6(sn snVar) {
        if (snVar == null) {
            throw new NullPointerException("cases == null");
        }
        this.gn = snVar;
    }

    public final void j6(ArrayList<aah> arrayList) {
        this.u7 = arrayList;
    }

    public final void j6(int i, abl abl, zq zqVar) {
        this.we = zw.DW(i, abl, zqVar);
    }

    protected final int FH() {
        return this.FH;
    }

    protected final abm FH(int i) {
        if (i >= this.FH) {
            throw new IllegalArgumentException("n >= argCount");
        }
        try {
            return this.DW[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("n < 0");
        }
    }

    protected final abl Hw() {
        return this.Hw;
    }

    protected final int v5() {
        return this.v5;
    }

    protected final aah Zo() {
        return this.Zo;
    }

    protected final int VH() {
        return this.VH;
    }

    protected final sn gn() {
        return this.gn;
    }

    protected final ArrayList<aah> u7() {
        return this.u7;
    }

    protected final int tp() {
        return this.tp;
    }

    protected final zw DW(boolean z) {
        if (this.we == null) {
            return null;
        }
        if (this.J8 != 1) {
            throw new sl("local target with " + (this.J8 == 0 ? "no" : "multiple") + " results");
        }
        abm abm = this.J0[0];
        abm j6 = abm.j6();
        abm j62 = this.we.j6();
        if (j6 == j62) {
            if (z) {
                return this.we.j6(abm);
            }
            return this.we;
        } else if (sg.DW(j62, j6)) {
            if (j62 == abl.Ws) {
                this.we = this.we.j6(abm);
            }
            return this.we;
        } else {
            j6(j6, j62);
            return null;
        }
    }

    protected final void EQ() {
        this.J8 = 0;
    }

    protected final void j6(abm abm) {
        if (abm == null) {
            throw new NullPointerException("result == null");
        }
        this.J0[0] = abm;
        this.J8 = 1;
    }

    protected final void DW(abm abm) {
        if (abm == null) {
            throw new NullPointerException("result == null");
        }
        this.J0[this.J8] = abm;
        this.J8++;
    }

    protected final int we() {
        if (this.J8 >= 0) {
            return this.J8;
        }
        throw new sl("results never set");
    }

    protected final abm Hw(int i) {
        if (i >= this.J8) {
            throw new IllegalArgumentException("n >= resultCount");
        }
        try {
            return this.J0[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("n < 0");
        }
    }

    protected final void j6(sa saVar) {
        int i = 0;
        if (this.J8 < 0) {
            throw new sl("results never set");
        } else if (this.J8 != 0) {
            if (this.we != null) {
                saVar.FH().j6(DW(false));
                return;
            }
            rz Hw = saVar.Hw();
            while (i < this.J8) {
                if (this.EQ) {
                    Hw.Hw();
                }
                Hw.j6(this.J0[i]);
                i++;
            }
        }
    }

    public static void j6(abm abm, abm abm2) {
        throw new sl("local variable type mismatch: attempt to set or access a value of type " + abm.Hw() + " using a local variable of type " + abm2.Hw() + ". This is symptomatic of .class transformation tools " + "that ignore local variable information.");
    }
}
