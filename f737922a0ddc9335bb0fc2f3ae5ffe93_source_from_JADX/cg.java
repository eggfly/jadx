public final class cg extends co {
    private final bt DW;
    private dm<co> EQ;
    private final by FH;
    private final bw Hw;
    private int J0;
    private bp J8;
    private int VH;
    private int Zo;
    private int gn;
    private int j6;
    private boolean tp;
    private int u7;
    private bv v5;
    private int we;

    protected cg(bt btVar, by byVar, bw bwVar) {
        super(bwVar, btVar, 16);
        this.DW = btVar;
        this.FH = byVar;
        this.Hw = bwVar;
    }

    protected cg(bt btVar, by byVar, bw bwVar, bv bvVar, bj bjVar, int i) {
        super(bwVar, btVar, 16);
        this.DW = btVar;
        this.FH = byVar;
        this.Hw = bwVar;
        this.j6 = btVar.DW((bs) this);
        this.v5 = bvVar;
        this.Zo = i;
        this.tp = false;
        j6(bjVar);
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.VH = eeVar.readInt();
        this.gn = eeVar.readInt();
        this.u7 = eeVar.readInt();
        this.j6 = eeVar.readInt();
        this.v5 = this.Hw.gn(eeVar.readInt());
        this.Zo = eeVar.readInt();
        this.J0 = eeVar.readInt();
        this.we = eeVar.readInt();
        this.J8 = (bp) this.DW.FH(eeVar.readInt());
        this.tp = eeVar.readBoolean();
        if (eeVar.readBoolean()) {
            this.EQ = new dm(this.DW, eeVar);
        }
    }

    protected void j6(ef efVar) {
        super.j6(efVar);
        efVar.writeInt(this.VH);
        efVar.writeInt(this.gn);
        efVar.writeInt(this.u7);
        efVar.writeInt(this.j6);
        efVar.writeInt(this.v5.vy());
        efVar.writeInt(this.Zo);
        efVar.writeInt(this.J0);
        efVar.writeInt(this.we);
        efVar.writeInt(this.DW.j6(this.J8));
        efVar.writeBoolean(this.tp);
        efVar.writeBoolean(this.EQ != null);
        if (this.EQ != null) {
            this.EQ.j6(efVar);
        }
    }

    protected void j6() {
        if (this.EQ != null) {
            this.EQ.j6();
        }
        this.tp = false;
    }

    protected void j6(int i, int i2, int i3) {
        this.VH = i;
        this.gn = i2;
        this.u7 = i3;
    }

    protected void j6(int i, bp bpVar, int i2) {
        this.J0 = i2;
        this.we = i;
        this.J8 = bpVar;
        if (this.EQ == null) {
            this.EQ = new dm(this.DW);
        } else {
            this.EQ.j6();
        }
    }

    protected void j6(co coVar) {
        if (coVar != this) {
            this.EQ.FH(coVar);
        }
        this.tp = true;
    }

    public bv tp() {
        return this.v5;
    }

    public int EQ() {
        return this.Zo;
    }

    public bp Xa() {
        return this.J8;
    }

    public bp CU() {
        return this.J8.CU();
    }

    public int er() {
        this.DW.Zo(tp(), Hw());
        return this.VH;
    }

    public int yS() {
        this.DW.Zo(tp(), Hw());
        return this.u7;
    }

    public int gW() {
        this.DW.Zo(tp(), Hw());
        return this.gn;
    }

    public int DW() {
        we();
        return (this.EQ == null || this.EQ.Hw() == 0) ? 1 : this.EQ.Hw();
    }

    public int FH() {
        return this.J0;
    }

    public int Zo() {
        return (this.J8.kQ() - this.J8.XX()) + FH();
    }

    public co j6(int i) {
        we();
        if (this.EQ == null || this.EQ.Hw() <= 0) {
            return this.DW.v5(tp(), Hw());
        }
        return (co) this.EQ.j6(i);
    }

    public co a_() {
        we();
        if (this.EQ == null || this.EQ.Hw() <= 0) {
            return this.DW.v5(tp(), Hw());
        }
        return (co) this.EQ.j6(0);
    }

    public bp gn() {
        return this.J8;
    }

    public int aq() {
        return this.we;
    }

    public int v5() {
        return this.j6;
    }

    private void u7() {
        if (!this.tp) {
            this.tp = true;
            if (this.EQ != null) {
                this.DW.v5(this.J8);
            }
        }
    }

    private void we() {
        if (!this.tp) {
            this.J8.FN();
            if (this.J8.yO()) {
                u7();
            }
        }
    }
}
