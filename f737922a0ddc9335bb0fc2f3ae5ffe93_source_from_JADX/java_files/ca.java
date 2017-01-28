public final class ca extends co {
    private final bt DW;
    private bz EQ;
    private final by FH;
    private final bw Hw;
    private dm<co> J0;
    private boolean J8;
    private int VH;
    private int Zo;
    private int gn;
    private int j6;
    private int tp;
    private int u7;
    private bv v5;
    private int we;

    protected ca(bt btVar, by byVar, bw bwVar) {
        super(bwVar, btVar, 16);
        this.DW = btVar;
        this.FH = byVar;
        this.Hw = bwVar;
    }

    protected ca(bt btVar, by byVar, bw bwVar, bv bvVar, bj bjVar, int i) {
        super(bwVar, btVar, 16);
        this.DW = btVar;
        this.FH = byVar;
        this.Hw = bwVar;
        this.j6 = btVar.DW((bs) this);
        this.v5 = bvVar;
        this.Zo = i;
        this.J0 = null;
        this.J8 = false;
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
        this.tp = eeVar.readInt();
        this.EQ = (bz) this.DW.FH(eeVar.readInt());
        this.we = eeVar.readInt();
        this.J8 = eeVar.readBoolean();
        if (eeVar.readBoolean()) {
            this.J0 = new dm(this.DW, eeVar);
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
        efVar.writeInt(this.tp);
        efVar.writeInt(this.DW.j6(this.EQ));
        efVar.writeInt(this.we);
        efVar.writeBoolean(this.J8);
        efVar.writeBoolean(this.J0 != null);
        if (this.J0 != null) {
            this.J0.j6(efVar);
        }
    }

    protected void j6() {
        if (this.J0 != null) {
            this.J0.j6();
        }
        this.J8 = false;
    }

    protected void j6(co coVar) {
        if (coVar != this) {
            this.J0.FH(coVar);
        }
        this.J8 = true;
    }

    protected void j6(int i, int i2, int i3) {
        this.VH = i;
        this.gn = i2;
        this.u7 = i3;
    }

    protected void j6(int i, bz bzVar, int i2) {
        this.tp = i;
        this.EQ = bzVar;
        this.we = i2;
        if (this.J0 == null) {
            this.J0 = new dm(this.DW);
        } else {
            this.J0.j6();
        }
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

    public bz DW() {
        return this.EQ;
    }

    public int FH() {
        return this.we;
    }

    public bv tp() {
        return this.v5;
    }

    public int EQ() {
        return this.Zo;
    }

    public int Zo() {
        gn();
        return (this.J0 == null || this.J0.Hw() == 0) ? 1 : this.J0.Hw();
    }

    public co j6(co coVar, int i) {
        co j6 = j6(i);
        co DW;
        if (coVar.cT()) {
            DW = ((bp) coVar).DW(this.EQ);
            if (DW.n5()) {
                return ((cf) DW).j6(j6);
            }
            return j6;
        }
        DW = ((cf) coVar).gn().DW(this.EQ);
        if (DW.n5()) {
            return ((cf) coVar).j6(((cf) DW).j6(j6));
        }
        return ((cf) coVar).j6(j6);
    }

    public co j6(int i) {
        gn();
        if (this.J0 == null || this.J0.Hw() <= 0) {
            return this.DW.v5(tp(), Hw());
        }
        return (co) this.J0.j6(i);
    }

    public co a_() {
        gn();
        if (this.J0 == null || this.J0.Hw() <= 0) {
            return this.DW.v5(tp(), Hw());
        }
        return (co) this.J0.j6(0);
    }

    public bp Xa() {
        return this.EQ.Xa();
    }

    public bp CU() {
        return this.EQ.Xa().CU();
    }

    public int aq() {
        return this.tp;
    }

    public int v5() {
        return this.j6;
    }

    public ca j6(bz bzVar) {
        if (bzVar.OW() > this.we) {
            return bzVar.gn(this.we);
        }
        throw new ej();
    }

    public ca DW(bz bzVar) {
        if (bzVar.OW() > this.we) {
            return bzVar.gn(this.we);
        }
        throw new ej();
    }

    private void gn() {
        if (!this.J8) {
            this.J8 = true;
            if (!Hw().VH().DW() || this.EQ.cb().Hw() <= 0) {
                this.DW.VH(tp(), Hw());
                return;
            }
            try {
                bz bzVar = (bz) this.EQ.cb().DW();
                ca j6 = j6(bzVar);
                int Zo = j6.Zo();
                for (int i = 0; i < Zo; i++) {
                    j6(j6.j6(this.EQ.Xa().j3(), i).j6(this.EQ, bzVar));
                }
            } catch (ej e) {
            }
        }
    }
}
