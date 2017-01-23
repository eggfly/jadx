final class bt$a {
    private final bw DW;
    private boolean EQ;
    private bv FH;
    private int Hw;
    private boolean J0;
    private dg J8;
    private ec Mr;
    private dg QX;
    private ec U2;
    private long VH;
    private dg Ws;
    private dg XL;
    private long Zo;
    private ea<ce> a8;
    private ec aM;
    private dt er;
    private int gW;
    private long gn;
    private ec j3;
    private final bt j6;
    private dq<bp, ce> lg;
    private bp rN;
    private boolean tp;
    private boolean u7;
    private long v5;
    private boolean we;
    private ec yS;

    public bt$a(bw bwVar, bt btVar, bv bvVar, bj bjVar) {
        this.j6 = btVar;
        this.DW = bwVar;
        this.FH = bvVar;
        this.Hw = bwVar.j6(bjVar);
        if (this.Hw == -1) {
            System.out.println(this.Hw);
        }
        this.VH = -1;
        this.gn = -1;
        this.v5 = -1;
        this.a8 = new ea(btVar);
        this.lg = new dq(btVar);
        this.er = new dt();
        this.yS = new ec();
    }

    public bt$a(bw bwVar, bt btVar, ee eeVar) {
        this.j6 = btVar;
        this.DW = bwVar;
        this.FH = btVar.Hw.gn(eeVar.readInt());
        this.Hw = eeVar.readInt();
        if (eeVar.readBoolean()) {
            this.J8 = new dg(eeVar);
        }
        if (eeVar.readBoolean()) {
            this.Ws = new dg(eeVar);
        }
        if (eeVar.readBoolean()) {
            this.QX = new dg(eeVar);
        }
        if (eeVar.readBoolean()) {
            this.XL = new dg(eeVar);
        }
        this.we = eeVar.readBoolean();
        this.a8 = new ea(btVar, eeVar);
        this.lg = new dq(btVar, eeVar);
        this.er = new dt(eeVar);
        int readInt = eeVar.readInt();
        if (readInt != 0) {
            this.rN = (bp) btVar.FH(readInt);
        }
        this.VH = eeVar.readLong();
        this.gn = eeVar.readLong();
        this.v5 = eeVar.readLong();
        this.Zo = eeVar.readLong();
        this.u7 = eeVar.readBoolean();
        this.tp = eeVar.readBoolean();
        this.EQ = eeVar.readBoolean();
        this.J0 = eeVar.readBoolean();
        this.yS = new ec(eeVar);
        if (eeVar.readBoolean()) {
            this.aM = new ec(eeVar);
        }
        if (eeVar.readBoolean()) {
            this.j3 = new ec(eeVar);
        }
        if (eeVar.readBoolean()) {
            this.Mr = new ec(eeVar);
        }
        if (eeVar.readBoolean()) {
            this.U2 = new ec(eeVar);
        }
        if (this.aM != null) {
            DW(this.aM.Hw() * 200);
        }
        if (this.U2 != null) {
            DW(this.U2.Hw() * 500);
        }
    }

    public void j6(ef efVar) {
        boolean z;
        boolean z2 = true;
        efVar.writeInt(this.FH.vy());
        efVar.writeInt(this.Hw);
        efVar.writeBoolean(this.J8 != null);
        if (this.J8 != null) {
            this.J8.j6(efVar);
        }
        if (this.Ws != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.Ws != null) {
            this.Ws.j6(efVar);
        }
        if (this.QX != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.QX != null) {
            this.QX.j6(efVar);
        }
        if (this.XL != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.XL != null) {
            this.XL.j6(efVar);
        }
        efVar.writeBoolean(this.we);
        this.a8.j6(efVar);
        this.lg.j6(efVar);
        this.er.j6(efVar);
        if (this.rN == null) {
            efVar.writeInt(0);
        } else {
            efVar.writeInt(this.rN.v5());
        }
        efVar.writeLong(this.VH);
        efVar.writeLong(this.gn);
        efVar.writeLong(this.v5);
        efVar.writeLong(this.Zo);
        efVar.writeBoolean(this.u7);
        efVar.writeBoolean(this.tp);
        efVar.writeBoolean(this.EQ);
        efVar.writeBoolean(this.J0);
        this.yS.j6(efVar);
        efVar.writeBoolean(this.aM != null);
        if (this.aM != null) {
            this.aM.j6(efVar);
        }
        if (this.j3 != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.j3 != null) {
            this.j3.j6(efVar);
        }
        if (this.Mr != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.Mr != null) {
            this.Mr.j6(efVar);
        }
        if (this.U2 == null) {
            z2 = false;
        }
        efVar.writeBoolean(z2);
        if (this.U2 != null) {
            this.U2.j6(efVar);
        }
    }

    public void j6(ce ceVar) {
        this.a8.j6((bs) ceVar);
    }

    public void j6(ce ceVar, bp bpVar, int i) {
        if (this.rN == null) {
            this.rN = bpVar;
        } else if (this.rN.aq() != this.FH.Zo() && bpVar.aq() == this.FH.Zo()) {
            this.rN = bpVar;
        }
        this.lg.j6((bs) bpVar, (bs) ceVar);
        this.er.j6(bpVar.v5(), i);
    }

    public bj j6() {
        if (this.Hw == -1) {
            System.out.println(this.Hw);
        }
        return this.DW.DW(this.Hw);
    }

    public bv DW() {
        return this.FH;
    }

    public ec FH() {
        return this.yS;
    }

    public long Hw() {
        if (this.XL == null) {
            return 0;
        }
        this.XL.j6.j6();
        long j = 0;
        while (this.XL.j6.DW()) {
            long j6 = ((bp) this.j6.FH(this.XL.j6.Hw())).j6();
            if (j6 < j) {
                j6 = j;
            }
            j = j6;
        }
        return j;
    }

    protected void j6(int i) {
        this.gW -= i;
        this.j6.j6(i);
    }

    protected void DW(int i) {
        this.gW += i;
        this.j6.DW(i);
    }

    public int v5() {
        return this.gW;
    }

    public int j6(bp bpVar) {
        return this.er.Hw(bpVar.v5());
    }

    public void j6(long j) {
        this.VH = j;
    }

    public void DW(long j) {
        this.gn = j;
    }

    public void FH(long j) {
        this.v5 = j;
    }

    public void Zo() {
        this.J0 = true;
    }

    public void VH() {
        this.EQ = false;
    }

    public void gn() {
        this.Zo = 0;
        this.we = false;
        this.a8.j6();
        this.lg.j6();
        this.rN = null;
        this.er.DW();
        this.yS.j6();
    }

    public void u7() {
        this.J0 = false;
        this.tp = false;
        this.u7 = false;
        if (this.aM != null) {
            j6(this.aM.Hw() * 200);
            this.aM.j6();
        }
        if (this.j3 != null) {
            this.j3.j6();
        }
        if (this.Mr != null) {
            this.Mr.j6();
        }
        if (this.U2 != null) {
            j6(this.U2.Hw() * 500);
            this.U2.j6();
        }
        if (this.J8 != null) {
            this.J8.j6.j6();
            while (this.J8.j6.DW()) {
                ((bz) this.j6.FH(this.J8.j6.Hw())).j6();
            }
        }
        if (this.Ws != null) {
            this.Ws.j6.j6();
            while (this.Ws.j6.DW()) {
                ((cg) this.j6.FH(this.Ws.j6.Hw())).j6();
            }
        }
        if (this.QX != null) {
            this.QX.j6.j6();
            while (this.QX.j6.DW()) {
                ((ca) this.j6.FH(this.QX.j6.Hw())).j6();
            }
        }
        if (this.XL != null) {
            this.XL.j6.j6();
            while (this.XL.j6.DW()) {
                ((bp) this.j6.FH(this.XL.j6.Hw())).DW();
            }
        }
    }

    public void tp() {
        this.J0 = false;
        this.tp = false;
        this.u7 = false;
        if (this.aM != null) {
            j6(this.aM.Hw() * 200);
            this.aM.j6();
        }
        if (this.j3 != null) {
            this.j3.j6();
        }
        if (this.Mr != null) {
            this.Mr.j6();
        }
        if (this.U2 != null) {
            j6(this.U2.Hw() * 500);
            this.U2.j6();
        }
        if (this.J8 != null) {
            this.J8.j6.j6();
            while (this.J8.j6.DW()) {
                ((bz) this.j6.FH(this.J8.j6.Hw())).DW();
            }
        }
        if (this.Ws != null) {
            this.Ws.j6.j6();
            while (this.Ws.j6.DW()) {
                ((cg) this.j6.FH(this.Ws.j6.Hw())).j6();
            }
        }
        if (this.QX != null) {
            this.QX.j6.j6();
            while (this.QX.j6.DW()) {
                ((ca) this.j6.FH(this.QX.j6.Hw())).j6();
            }
        }
        if (this.XL != null) {
            this.XL.j6.j6();
            while (this.XL.j6.DW()) {
                ((bp) this.j6.FH(this.XL.j6.Hw())).FH();
            }
        }
    }

    public bp EQ() {
        this.j6.u7();
        if (this.rN != null) {
            return this.rN;
        }
        throw new ej();
    }

    public dq<bp, ce> we() {
        this.j6.u7();
        return this.lg;
    }

    public ea<ce> J0() {
        this.j6.u7();
        return this.a8;
    }

    public long J8() {
        return this.Zo;
    }

    public long Ws() {
        return this.v5;
    }

    public long QX() {
        return this.VH;
    }

    public long XL() {
        return this.gn;
    }

    public ea<bs> aM() {
        ea<bs> eaVar = new ea(this.j6);
        a8();
        if (this.J8 != null) {
            this.J8.j6.j6();
            while (this.J8.j6.DW()) {
                if (this.aM.FH(this.J8.j6.FH())) {
                    eaVar.j6(this.j6.FH(this.J8.j6.Hw()));
                }
            }
        }
        if (this.XL != null) {
            this.XL.j6.j6();
            while (this.XL.j6.DW()) {
                if (this.U2.FH(this.XL.j6.FH())) {
                    eaVar.j6(this.j6.FH(this.XL.j6.Hw()));
                }
            }
        }
        return eaVar;
    }

    public bz FH(int i) {
        a8();
        if (this.J8 == null) {
            throw new ej();
        } else if (!this.J8.DW(i)) {
            throw new ej();
        } else if (this.aM.FH(i)) {
            return (bz) this.j6.FH(this.J8.FH(i));
        } else {
            throw new ej();
        }
    }

    public bp j6(int i, ce ceVar, int i2) {
        if (i == 0) {
            return DW(0, ceVar, i2);
        }
        a8();
        if (this.XL == null) {
            throw new ej();
        } else if (!this.XL.DW(i)) {
            throw new ej();
        } else if (this.U2.FH(i)) {
            return (bp) this.j6.FH(this.XL.FH(i));
        } else {
            throw new ej();
        }
    }

    public bp Hw(int i) {
        a8();
        if (this.XL == null) {
            throw new ej();
        } else if (!this.XL.DW(i)) {
            throw new ej();
        } else if (this.U2.FH(i)) {
            return (bp) this.j6.FH(this.XL.FH(i));
        } else {
            throw new ej();
        }
    }

    public cg v5(int i) {
        a8();
        if (this.Ws == null) {
            throw new ej();
        } else if (!this.Ws.DW(i)) {
            throw new ej();
        } else if (this.j3.FH(i)) {
            return (cg) this.j6.FH(this.Ws.FH(i));
        } else {
            throw new ej();
        }
    }

    public ca Zo(int i) {
        a8();
        if (this.QX == null) {
            throw new ej();
        } else if (!this.QX.DW(i)) {
            throw new ej();
        } else if (this.Mr.FH(i)) {
            return (ca) this.j6.FH(this.QX.FH(i));
        } else {
            throw new ej();
        }
    }

    public ca VH(int i) {
        if (this.QX == null) {
            this.QX = new dg();
        }
        if (this.Mr == null) {
            this.Mr = new ec();
        }
        this.Mr.j6(i);
        if (!this.QX.DW(i)) {
            this.QX.j6(i, new ca(this.j6, this.j6.Zo, this.j6.Hw, this.FH, j6(), i).v5());
        }
        return (ca) this.j6.FH(this.QX.FH(i));
    }

    public cg gn(int i) {
        if (this.Ws == null) {
            this.Ws = new dg();
        }
        if (this.j3 == null) {
            this.j3 = new ec();
        }
        this.j3.j6(i);
        if (!this.Ws.DW(i)) {
            this.Ws.j6(i, new cg(this.j6, this.j6.Zo, this.j6.Hw, this.FH, j6(), i).v5());
        }
        return (cg) this.j6.FH(this.Ws.FH(i));
    }

    public bp DW(int i, ce ceVar, int i2) {
        if (this.XL == null) {
            this.XL = new dg();
        }
        if (this.U2 == null) {
            this.U2 = new ec();
        }
        if (!this.U2.FH(i)) {
            DW(500);
        }
        this.U2.j6(i);
        if (!this.XL.DW(i)) {
            this.XL.j6(i, new bp(this.j6, this.j6.Hw, this.j6.Zo, this.FH, j6(), i, j6().VH().j6(ceVar, i2)).v5());
        }
        return (bp) this.j6.FH(this.XL.FH(i));
    }

    public bz u7(int i) {
        if (this.J8 == null) {
            this.J8 = new dg();
        }
        if (this.aM == null) {
            this.aM = new ec();
        }
        if (!this.aM.FH(i)) {
            DW(200);
        }
        this.aM.j6(i);
        if (!this.J8.DW(i)) {
            this.J8.j6(i, new bz(this.j6, this.j6.Zo, this.j6.Hw, this.FH, j6(), i).v5());
        }
        return (bz) this.j6.FH(this.J8.FH(i));
    }

    public void j3() {
        a8();
        if (!this.EQ) {
            this.EQ = true;
            if (j6().Zo() != null) {
                j6().Zo().DW(this.FH);
            }
        }
    }

    public boolean Mr() {
        return !this.u7;
    }

    public void U2() {
        if (!this.we) {
            this.we = true;
            this.v5 = this.FH.QX();
            this.Zo = this.FH.Ws();
            this.VH = 0;
            this.gn = 0;
            if (j6().Zo() != null) {
                j6().Zo().j6(this.FH);
            }
        }
    }

    public void a8() {
        if (!this.u7) {
            this.u7 = true;
            this.EQ = true;
            if (j6().Zo() != null) {
                j6().Zo().Hw(this.FH);
            }
            cj DW = this.j6.v5.DW(this.FH, j6());
            this.v5 = DW.J0();
            this.VH = DW.gn();
            this.gn = DW.v5();
            this.j6.v5.j6(DW);
        }
    }

    private void lg() {
        if (!this.tp) {
            this.tp = true;
            if (j6().Zo() != null) {
                j6().Zo().FH(this.FH);
            }
        }
    }
}
