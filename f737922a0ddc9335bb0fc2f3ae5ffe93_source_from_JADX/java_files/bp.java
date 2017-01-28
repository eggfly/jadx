public final class bp extends co {
    private final bt DW;
    private int EQ;
    private final by FH;
    private int Hw;
    private boolean J0;
    private boolean J8;
    private bp$a QX;
    private boolean VH;
    private int Ws;
    private long XL;
    private int Zo;
    private ce gn;
    private final bw j6;
    private bp tp;
    private bp u7;
    private bv v5;
    private boolean we;

    protected long j6() {
        return this.XL;
    }

    private bp$a Cz() {
        this.XL = ew.j6();
        if (this.QX != null) {
            return this.QX;
        }
        this.QX = new bp$a();
        this.QX.ro = new dm(this.DW);
        this.QX.Mr = new dm(this.DW);
        this.QX.lg = new dm(this.DW);
        this.QX.KD = new dm(this.DW);
        this.QX.SI = new dm(this.DW);
        this.QX.ei = new dr(this.DW);
        this.QX.cn = new dr(this.DW);
        this.QX.Mz = new dr(this.DW);
        this.QX.P8 = new dr(this.DW);
        this.QX.cb = new ea(this.DW);
        this.QX.sh = new dr(this.DW);
        this.QX.g3 = new dq(this.DW);
        this.QX.I = new dr(this.DW);
        this.QX.sG = new dr(this.DW);
        this.QX.dx = new ea(this.DW);
        this.QX.ef = new dr(this.DW);
        this.QX.Sf = new dr(this.DW);
        this.QX.vJ = new dr(this.DW);
        return this.QX;
    }

    protected bp(bt btVar, bw bwVar, by byVar) {
        super(bwVar, btVar);
        this.j6 = bwVar;
        this.DW = btVar;
        this.FH = byVar;
    }

    protected bp(bt btVar, bw bwVar, by byVar, bv bvVar, bj bjVar, int i, int i2) {
        super(bwVar, btVar, i2);
        this.j6 = bwVar;
        this.DW = btVar;
        this.FH = byVar;
        this.Hw = btVar.DW((bs) this);
        this.v5 = bvVar;
        this.Zo = i;
        j6(bjVar);
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.gn = (ce) this.DW.FH(eeVar.readInt());
        this.Hw = eeVar.readInt();
        this.v5 = this.j6.gn(eeVar.readInt());
        this.Zo = eeVar.readInt();
        this.u7 = (bp) this.DW.FH(eeVar.readInt());
        this.tp = (bp) this.DW.FH(eeVar.readInt());
        this.EQ = eeVar.readInt();
        this.we = eeVar.readBoolean();
        this.J0 = eeVar.readBoolean();
        this.J8 = eeVar.readBoolean();
        this.Ws = eeVar.readInt();
        this.VH = eeVar.readBoolean();
        if (eeVar.readBoolean()) {
            this.QX = new bp$a();
            this.QX.j6 = eeVar.readBoolean();
            this.QX.DW = eeVar.readBoolean();
            this.QX.Zo = eeVar.readInt();
            this.QX.gn = eeVar.readInt();
            this.QX.VH = eeVar.readInt();
            this.QX.u7 = eeVar.readInt();
            this.QX.tp = eeVar.readInt();
            this.QX.EQ = eeVar.readInt();
            this.QX.we = eeVar.readInt();
            this.QX.J0 = eeVar.readInt();
            this.QX.FH = eeVar.readInt();
            this.QX.Hw = eeVar.readInt();
            this.QX.v5 = eeVar.readInt();
            this.QX.J8 = eeVar.readInt();
            this.QX.XL = eeVar.readBoolean();
            this.QX.Ws = eeVar.readBoolean();
            this.QX.QX = eeVar.readBoolean();
            this.QX.aM = eeVar.readBoolean();
            this.QX.j3 = eeVar.readBoolean();
            this.QX.U2 = eeVar.readBoolean();
            this.QX.a8 = eeVar.readBoolean();
            this.QX.yS = eeVar.readBoolean();
            this.QX.gW = eeVar.readBoolean();
            this.QX.nw = eeVar.readInt();
            this.QX.ca = (co) this.DW.FH(eeVar.readInt());
            if (eeVar.readBoolean()) {
                this.QX.Mr = new dm(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.lg = new dm(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.rN = new ea(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.er = new ea(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.BT = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.vy = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.P8 = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.ei = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.SI = new dm(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.KD = new dm(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.Mz = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.cn = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.sh = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.cb = new ea(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.g3 = new dq(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.sG = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.dx = new ea(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.ef = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.Sf = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.vJ = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.I = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.ro = new dm(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.x9 = new dm(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.Qq = new do(eeVar);
            }
            if (eeVar.readBoolean()) {
                this.QX.sy = new do(eeVar);
            }
        }
    }

    protected void j6(ef efVar) {
        boolean z = true;
        super.j6(efVar);
        efVar.writeInt(this.DW.j6(this.gn));
        efVar.writeInt(this.Hw);
        efVar.writeInt(this.v5.vy());
        efVar.writeInt(this.Zo);
        efVar.writeInt(this.DW.j6(this.u7));
        efVar.writeInt(this.DW.j6(this.tp));
        efVar.writeInt(this.EQ);
        efVar.writeBoolean(this.we);
        efVar.writeBoolean(this.J0);
        efVar.writeBoolean(this.J8);
        efVar.writeInt(this.Ws);
        efVar.writeBoolean(this.VH);
        efVar.writeBoolean(this.QX != null);
        if (this.QX != null) {
            boolean z2;
            efVar.writeBoolean(this.QX.j6);
            efVar.writeBoolean(this.QX.DW);
            efVar.writeInt(this.QX.Zo);
            efVar.writeInt(this.QX.gn);
            efVar.writeInt(this.QX.VH);
            efVar.writeInt(this.QX.u7);
            efVar.writeInt(this.QX.tp);
            efVar.writeInt(this.QX.EQ);
            efVar.writeInt(this.QX.we);
            efVar.writeInt(this.QX.J0);
            efVar.writeInt(this.QX.FH);
            efVar.writeInt(this.QX.Hw);
            efVar.writeInt(this.QX.v5);
            efVar.writeInt(this.QX.J8);
            efVar.writeBoolean(this.QX.XL);
            efVar.writeBoolean(this.QX.Ws);
            efVar.writeBoolean(this.QX.QX);
            efVar.writeBoolean(this.QX.aM);
            efVar.writeBoolean(this.QX.j3);
            efVar.writeBoolean(this.QX.U2);
            efVar.writeBoolean(this.QX.a8);
            efVar.writeBoolean(this.QX.yS);
            efVar.writeBoolean(this.QX.gW);
            efVar.writeInt(this.QX.nw);
            efVar.writeInt(this.DW.j6(this.QX.ca));
            efVar.writeBoolean(this.QX.Mr != null);
            if (this.QX.Mr != null) {
                this.QX.Mr.j6(efVar);
            }
            if (this.QX.lg != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.lg != null) {
                this.QX.lg.j6(efVar);
            }
            if (this.QX.rN != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.rN != null) {
                this.QX.rN.j6(efVar);
            }
            if (this.QX.er != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.er != null) {
                this.QX.er.j6(efVar);
            }
            if (this.QX.BT != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.BT != null) {
                this.QX.BT.j6(efVar);
            }
            if (this.QX.vy != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.vy != null) {
                this.QX.vy.j6(efVar);
            }
            if (this.QX.P8 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.P8 != null) {
                this.QX.P8.j6(efVar);
            }
            if (this.QX.ei != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.ei != null) {
                this.QX.ei.j6(efVar);
            }
            if (this.QX.SI != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.SI != null) {
                this.QX.SI.j6(efVar);
            }
            if (this.QX.KD != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.KD != null) {
                this.QX.KD.j6(efVar);
            }
            if (this.QX.Mz != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.Mz != null) {
                this.QX.Mz.j6(efVar);
            }
            if (this.QX.cn != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.cn != null) {
                this.QX.cn.j6(efVar);
            }
            if (this.QX.sh != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.sh != null) {
                this.QX.sh.j6(efVar);
            }
            if (this.QX.cb != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.cb != null) {
                this.QX.cb.j6(efVar);
            }
            if (this.QX.g3 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.g3 != null) {
                this.QX.g3.j6(efVar);
            }
            if (this.QX.sG != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.sG != null) {
                this.QX.sG.j6(efVar);
            }
            if (this.QX.dx != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.dx != null) {
                this.QX.dx.j6(efVar);
            }
            if (this.QX.ef != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.ef != null) {
                this.QX.ef.j6(efVar);
            }
            if (this.QX.Sf != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.Sf != null) {
                this.QX.Sf.j6(efVar);
            }
            if (this.QX.vJ != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.vJ != null) {
                this.QX.vJ.j6(efVar);
            }
            if (this.QX.I != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.I != null) {
                this.QX.I.j6(efVar);
            }
            if (this.QX.ro != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.ro != null) {
                this.QX.ro.j6(efVar);
            }
            if (this.QX.x9 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.x9 != null) {
                this.QX.x9.j6(efVar);
            }
            if (this.QX.Qq != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.QX.Qq != null) {
                this.QX.Qq.j6(efVar);
            }
            if (this.QX.sy == null) {
                z = false;
            }
            efVar.writeBoolean(z);
            if (this.QX.sy != null) {
                this.QX.sy.j6(efVar);
            }
        }
    }

    protected void DW() {
        this.VH = false;
        this.QX = null;
    }

    protected void FH() {
        this.QX = null;
    }

    protected void j6(int i, int i2, ce ceVar, int i3, int i4, bp bpVar, bp bpVar2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        int i5;
        this.gn = ceVar;
        this.EQ = i;
        this.u7 = bpVar;
        this.tp = bpVar2;
        this.we = z5;
        this.J0 = z3;
        this.J8 = z2;
        this.Ws = i3;
        Cz().XL = z6;
        Cz().QX = z4;
        Cz().Ws = z;
        Cz().J8 = i2;
        if (bpVar2 == this) {
            Cz().nw = i3;
        } else {
            Cz().nw = bpVar2.kQ() + i3;
            int kQ = bpVar2.kQ();
            Cz().KD.DW(Cz().nw);
            for (i5 = 0; i5 < kQ; i5++) {
                try {
                    Cz().KD.j6(i5, bpVar2.DW(i5));
                } catch (ej e) {
                }
            }
        }
        Cz().Mz.DW();
        Cz().cb.j6();
        Cz().cn.DW();
        Cz().sh.DW();
        Cz().P8.DW();
        Cz().ei.DW();
        if (Cz().Qq != null) {
            Cz().Qq.Hw(i4);
            for (i5 = 0; i5 < i4; i5++) {
                Cz().Qq.j6(i5, 0);
            }
        } else if (i4 > 0) {
            Cz().Qq = new do(i4);
            for (i5 = 0; i5 < i4; i5++) {
                Cz().Qq.j6(i5, 0);
            }
        }
        if (Cz().sy != null) {
            Cz().sy.Hw(i4);
            for (i5 = 0; i5 < i4; i5++) {
                Cz().sy.j6(i5, 0);
            }
        } else if (i4 > 0) {
            Cz().sy = new do(i4);
            for (i5 = 0; i5 < i4; i5++) {
                Cz().sy.j6(i5, 0);
            }
        }
        if (Cz().x9 == null && i4 > 0) {
            Cz().x9 = new dm(this.DW, i4);
            for (i5 = 0; i5 < i4; i5++) {
                Cz().x9.j6(i5, null);
            }
        }
    }

    protected void j6(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        Cz().FH = i;
        Cz().Hw = i2;
        Cz().v5 = i3;
        Cz().Zo = i4;
        Cz().gn = i5;
        Cz().VH = i6;
        Cz().u7 = i7;
        Cz().tp = i8;
        Cz().EQ = i9;
        Cz().we = i10;
        Cz().J0 = i11;
    }

    protected void Zo() {
        Cz().gW = true;
    }

    protected void VH() {
        Cz().aM = true;
        Cz().j3 = false;
        QO();
    }

    protected void gn() {
        Cz().aM = false;
        Cz().j3 = true;
    }

    protected void u7() {
        Cz().yS = true;
    }

    protected void j6(co coVar) {
        Cz().ca = coVar;
    }

    protected void j6(ce ceVar, int i, boolean z, int i2) {
        this.EQ = i;
        this.gn = ceVar;
        this.u7 = this;
        this.tp = this;
        this.we = z;
        this.Ws = i2;
    }

    protected void j6(int i, bz bzVar) {
        Cz().sh.DW(i, (bs) bzVar);
    }

    protected void DW(int i, bz bzVar) {
        Cz().cn.DW(i, (bs) bzVar);
    }

    protected void j6(bp bpVar) {
        Cz().Mr.FH(bpVar);
    }

    protected void j6(bz bzVar) {
        Cz().cb.j6((bs) bzVar);
    }

    protected void j6(int i, int i2, cg cgVar) {
        Cz().ei.j6(i2, (bs) cgVar);
        Cz().SI.j6(i, cgVar);
        Cz().KD.j6((Cz().nw - XX()) + i, cgVar);
    }

    protected void DW(co coVar) {
        if (coVar.n5()) {
            bs gn = ((cf) coVar).gn();
        } else {
            bp bpVar = (bp) coVar;
        }
        if (Cz().rN.FH(gn)) {
            Cz().lg.FH(coVar);
        }
    }

    protected void j6(int i, bp bpVar) {
        Cz().P8.DW(i, (bs) bpVar);
    }

    public bv tp() {
        return this.v5;
    }

    public int EQ() {
        return this.Zo;
    }

    public int v5() {
        return this.Hw;
    }

    public boolean we() {
        return Hw().VH().j6() || J0();
    }

    public boolean J0() {
        return (hz() || Ws() || Cz().QX) ? false : true;
    }

    public boolean J8() {
        sM();
        return this.J8;
    }

    public boolean Ws() {
        return (Ev() & 64) != 0;
    }

    public boolean QX() {
        return cd.XL(Ev());
    }

    public boolean XL() {
        return (Cz().J8 & 128) != 0;
    }

    public ea<bp> aM() {
        return rN().j6(tp(), Hw(), aq());
    }

    public co j3() {
        co j6;
        int kQ = kQ();
        if (kQ != 0) {
            try {
                co[] coVarArr = new co[kQ];
                int[] iArr = new int[kQ];
                for (int i = 0; i < kQ; i++) {
                    coVarArr[i] = DW(i);
                    iArr[i] = 0;
                }
                j6 = this.DW.j6(this, coVarArr, iArr);
            } catch (ej e) {
            }
        }
        return j6;
    }

    public boolean Mr() {
        if (!hz()) {
            dr et = Xa().et();
            et.j6.j6(aq());
            while (et.j6.DW()) {
                if (et.j6.Hw() != this) {
                    return true;
                }
            }
        }
        return false;
    }

    public co j6(bv bvVar) {
        this.DW.VH(tp(), Hw());
        if (Cz().ca != null) {
            return Cz().ca;
        }
        throw new ej();
    }

    public co U2() {
        this.DW.VH(tp(), Hw());
        if (Cz().ca != null) {
            return Cz().ca;
        }
        throw new ej();
    }

    public int a8() {
        return tp().gn();
    }

    public bs lg() {
        if (hz()) {
            return rN();
        }
        return Xa();
    }

    public ce rN() {
        sM();
        return this.gn;
    }

    public int er() {
        this.DW.Zo(tp(), Hw());
        return Cz().FH;
    }

    public int yS() {
        this.DW.Zo(tp(), Hw());
        return Cz().v5;
    }

    public int gW() {
        this.DW.Zo(tp(), Hw());
        return Cz().Hw;
    }

    public int BT() {
        this.DW.Zo(tp(), Hw());
        return Cz().Zo;
    }

    public int vy() {
        this.DW.Zo(tp(), Hw());
        return Cz().VH;
    }

    public int P8() {
        this.DW.Zo(tp(), Hw());
        return Cz().u7;
    }

    public int ei() {
        this.DW.Zo(tp(), Hw());
        return Cz().gn;
    }

    public int nw() {
        this.DW.Zo(tp(), Hw());
        return Cz().J0;
    }

    public int SI() {
        this.DW.Zo(tp(), Hw());
        return Cz().we;
    }

    public int KD() {
        this.DW.Zo(tp(), Hw());
        return Cz().EQ;
    }

    public int ro() {
        this.DW.Zo(tp(), Hw());
        return Cz().tp;
    }

    public dr<bz> cn() {
        pN();
        return Cz().I;
    }

    public dr<bz> sh() {
        a5();
        return Cz().sh;
    }

    public dr<bz> cb() {
        a5();
        return Cz().cn;
    }

    public ea<bz> dx() {
        a5();
        return Cz().cb;
    }

    public co j6(bv bvVar, bj bjVar, int i, boolean z, bp bpVar, ea<bz> eaVar) {
        pN();
        eaVar.j6();
        dr drVar = Cz().sG;
        drVar.j6.j6(i);
        while (drVar.j6.DW()) {
            bs bsVar = (bz) drVar.j6.Hw();
            if (bsVar.j6(this, bpVar)) {
                eaVar.j6(bsVar);
            }
        }
        if (!eaVar.FH()) {
            return this;
        }
        if (!z) {
            if (Cz().aj == null) {
                Cz().aj = new dr(this.DW);
                Cz().sG.j6.j6();
                while (Cz().sG.j6.DW()) {
                    Cz().aj.DW(this.FH.FH(Cz().sG.j6.FH()), (bz) Cz().sG.j6.Hw());
                }
            }
            int FH = this.FH.FH(i);
            drVar = Cz().aj;
            drVar.j6.j6(FH);
            while (drVar.j6.DW()) {
                bsVar = (bz) drVar.j6.Hw();
                if (bsVar.j6(this, bpVar)) {
                    eaVar.j6(bsVar);
                }
            }
        }
        if (eaVar.FH()) {
            return null;
        }
        return this;
    }

    public co DW(bv bvVar, bj bjVar, int i, boolean z, bp bpVar, ea<bz> eaVar) {
        pN();
        eaVar.j6();
        dr drVar = Cz().ef;
        drVar.j6.j6(i);
        while (drVar.j6.DW()) {
            bs bsVar = (bz) drVar.j6.Hw();
            if (bsVar.j6(this, bpVar)) {
                eaVar.j6(bsVar);
            }
        }
        if (!eaVar.FH()) {
            return this;
        }
        if (!z) {
            if (Cz().lp == null) {
                Cz().lp = new dr(this.DW);
                Cz().ef.j6.j6();
                while (Cz().ef.j6.DW()) {
                    Cz().lp.DW(this.FH.FH(Cz().ef.j6.FH()), (bz) Cz().ef.j6.Hw());
                }
            }
            int FH = this.FH.FH(i);
            drVar = Cz().lp;
            drVar.j6.j6(FH);
            while (drVar.j6.DW()) {
                bsVar = (bz) drVar.j6.Hw();
                if (bsVar.j6(this, bpVar)) {
                    eaVar.j6(bsVar);
                }
            }
        }
        if (eaVar.FH()) {
            return null;
        }
        return this;
    }

    public co j6(bp bpVar, ea<bz> eaVar) {
        pN();
        eaVar.j6();
        Cz().dx.j6.j6();
        while (Cz().dx.j6.DW()) {
            bs bsVar = (bz) Cz().dx.j6.FH();
            if (bsVar.j6(bpVar, bpVar)) {
                eaVar.j6(bsVar);
            }
        }
        if (eaVar.FH()) {
            return null;
        }
        return this;
    }

    public co j6(co[] coVarArr, int[] iArr) {
        int XX = XX();
        int kQ = kQ();
        if (kQ == 0) {
            return this;
        }
        if (XX < kQ) {
            try {
                int i;
                co[] coVarArr2 = new co[kQ];
                int[] iArr2 = new int[kQ];
                for (i = 0; i < kQ - XX; i++) {
                    coVarArr2[i] = DW(i).a_().a_();
                    iArr2[i] = 0;
                }
                for (i = kQ - XX; i < kQ; i++) {
                    coVarArr2[i] = coVarArr[(i - kQ) + XX];
                    iArr2[i] = iArr[(i - kQ) + XX];
                }
                iArr = iArr2;
                coVarArr = coVarArr2;
            } catch (ej e) {
                return this;
            }
        }
        return this.DW.j6(this, coVarArr, iArr);
    }

    public co sG() {
        if (Cz().a8) {
            throw new ej();
        }
        e9();
        if (g3()) {
            throw new ej();
        } else if (Cz().lg.Hw() != 0) {
            return (co) Cz().lg.j6(0);
        } else {
            throw new ej();
        }
    }

    public boolean ef() {
        a5();
        return (Cz().J8 & 2097152) != 0;
    }

    public boolean Sf() {
        a5();
        return Cz().XL;
    }

    public boolean vJ() {
        a5();
        return (Cz().J8 & 128) != 0;
    }

    public boolean g3() {
        a5();
        return (Cz().J8 & 134217728) != 0;
    }

    public boolean Mz() {
        a5();
        return (Cz().J8 & 268435456) != 0;
    }

    public boolean I() {
        a5();
        return (Cz().J8 & 33554432) != 0;
    }

    public boolean ca() {
        a5();
        return (Cz().J8 & 67108864) != 0;
    }

    public String x9() {
        return super.x9();
    }

    public bp Qq() {
        aX();
        if (g3()) {
            throw new ej();
        } else if (Cz().Mr.Hw() != 0) {
            return (bp) Cz().Mr.j6(0);
        } else {
            throw new ej();
        }
    }

    public dr<bz> sy() {
        pN();
        return Cz().sG;
    }

    public dr<bz> aj() {
        pN();
        return Cz().Sf;
    }

    public dr<bz> lp() {
        pN();
        return Cz().ef;
    }

    public dr<bz> OW() {
        pN();
        return Cz().vJ;
    }

    public String br() {
        sM();
        if (J8()) {
            return "(anonymous)";
        }
        return this.FH.j6(this.EQ);
    }

    public int XX() {
        sM();
        if (this.Ws == -1) {
            a5();
        }
        return this.Ws;
    }

    public cg j6(int i) {
        a5();
        if (this.Ws > i) {
            return (cg) Cz().SI.j6(i);
        }
        throw new ej();
    }

    public int kQ() {
        a5();
        return Cz().nw;
    }

    public cg DW(int i) {
        a5();
        if (Cz().nw > i) {
            return (cg) Cz().KD.j6(i);
        }
        throw new ej();
    }

    public boolean yO() {
        return Cz().aM;
    }

    public boolean XG() {
        if (Cz().j3) {
            return false;
        }
        aX();
        return Cz().yS;
    }

    public boolean jJ() {
        aX();
        return Cz().gW;
    }

    public int wc() {
        pN();
        return Cz().ro.Hw() / 2;
    }

    public bz FH(int i) {
        return (bz) Cz().ro.j6(i * 2);
    }

    public bz Hw(int i) {
        return (bz) Cz().ro.j6((i * 2) + 1);
    }

    public dr<bp> et() {
        a5();
        return Cz().P8;
    }

    public co DW(bz bzVar) {
        if (Cz().g3.DW((bs) bzVar)) {
            return (co) Cz().g3.Hw((bs) bzVar);
        }
        return bzVar.Xa();
    }

    public boolean DW(bp bpVar) {
        if (rN() == bpVar.rN() && ef() && bpVar.ef() && hz() && bpVar.hz() && aq() == bpVar.aq()) {
            return true;
        }
        if (hz()) {
            return false;
        }
        return Xa().DW(bpVar);
    }

    public boolean FH(bp bpVar) {
        if (this == bpVar) {
            return true;
        }
        if (hz()) {
            return false;
        }
        return Xa().FH(bpVar);
    }

    public bp CU() {
        sM();
        return this.u7;
    }

    public bp Xa() {
        sM();
        return this.tp;
    }

    public boolean Eq() {
        sM();
        return this.J0;
    }

    public boolean hz() {
        return Xa() == this;
    }

    public int aq() {
        sM();
        return this.EQ;
    }

    public ea<co> FN() {
        if (Cz().a8) {
            return new ea(this.DW);
        }
        e9();
        return Cz().er;
    }

    public ea<bp> jO() {
        aX();
        return Cz().rN;
    }

    public dr<co> oY() {
        e9();
        return Cz().vy;
    }

    public dr<bp> ko() {
        aX();
        return Cz().BT;
    }

    public co j6(int i, boolean z, int i2, bs bsVar, bv bvVar, bj bjVar) {
        if (Cz().a8) {
            return DW(i, z, i2, bsVar, bvVar, bjVar);
        }
        dr drVar;
        e9();
        dr drVar2 = Cz().vy;
        if (z) {
            drVar = drVar2;
        } else {
            if (Cz().OW == null) {
                Cz().OW = new dr(this.DW);
                Cz().vy.j6.j6();
                while (Cz().vy.j6.DW()) {
                    Cz().OW.DW(this.FH.FH(Cz().vy.j6.FH()), (co) Cz().vy.j6.Hw());
                }
            }
            i = this.FH.FH(i);
            drVar = Cz().OW;
        }
        co coVar = null;
        drVar.j6.j6(i);
        while (drVar.j6.DW()) {
            bp gn;
            co coVar2 = (co) drVar.j6.Hw();
            if (coVar2.n5()) {
                gn = ((cf) coVar2).gn();
            } else {
                gn = (bp) coVar2;
            }
            if (!gn.j6(bsVar)) {
                coVar2 = coVar;
            } else if (coVar != null) {
                throw new eg();
            }
            coVar = coVar2;
        }
        if (coVar != null) {
            return coVar;
        }
        throw new ej();
    }

    public boolean j6(int i, boolean z) {
        dr drVar;
        if (Cz().j3) {
            drVar = Cz().P8;
            if (!z) {
                if (Cz().br == null) {
                    Cz().br = new dr(this.DW);
                    Cz().P8.j6.j6();
                    while (Cz().P8.j6.DW()) {
                        Cz().br.DW(this.FH.FH(Cz().P8.j6.FH()), (bp) Cz().P8.j6.Hw());
                    }
                }
                i = this.FH.FH(i);
                drVar = Cz().br;
            }
            return drVar.j6(i);
        }
        aX();
        drVar = Cz().BT;
        if (!z) {
            if (Cz().XX == null) {
                Cz().XX = new dr(this.DW);
                Cz().BT.j6.j6();
                while (Cz().BT.j6.DW()) {
                    Cz().XX.DW(this.FH.FH(Cz().BT.j6.FH()), (bp) Cz().BT.j6.Hw());
                }
            }
            i = this.FH.FH(i);
            drVar = Cz().XX;
        }
        return drVar.j6(i);
    }

    public bp DW(int i, boolean z, int i2, bs bsVar, bv bvVar, bj bjVar) {
        bp bpVar = null;
        dr drVar;
        dr drVar2;
        bp bpVar2;
        if (Cz().j3) {
            drVar = Cz().P8;
            if (z) {
                drVar2 = drVar;
            } else {
                if (Cz().br == null) {
                    Cz().br = new dr(this.DW);
                    Cz().P8.j6.j6();
                    while (Cz().P8.j6.DW()) {
                        Cz().br.DW(this.FH.FH(Cz().P8.j6.FH()), (bp) Cz().P8.j6.Hw());
                    }
                }
                i = this.FH.FH(i);
                drVar2 = Cz().br;
            }
            drVar2.j6.j6(i);
            while (drVar2.j6.DW()) {
                bpVar2 = (bp) drVar2.j6.Hw();
                if (!bpVar2.j6(bsVar)) {
                    bpVar2 = bpVar;
                } else if (bpVar != null) {
                    throw new eg();
                }
                bpVar = bpVar2;
            }
            if (bpVar == null) {
                throw new ej();
            }
        }
        aX();
        drVar = Cz().BT;
        if (z) {
            drVar2 = drVar;
        } else {
            if (Cz().XX == null) {
                Cz().XX = new dr(this.DW);
                Cz().BT.j6.j6();
                while (Cz().BT.j6.DW()) {
                    Cz().XX.DW(this.FH.FH(Cz().BT.j6.FH()), (bp) Cz().BT.j6.Hw());
                }
            }
            i = this.FH.FH(i);
            drVar2 = Cz().XX;
        }
        drVar2.j6.j6(i);
        while (drVar2.j6.DW()) {
            bpVar2 = (bp) drVar2.j6.Hw();
            if (!bpVar2.j6(bsVar)) {
                bpVar2 = bpVar;
            } else if (bpVar != null) {
                throw new eg();
            }
            bpVar = bpVar2;
        }
        if (bpVar == null) {
            throw new ej();
        }
        return bpVar;
    }

    public int Ev() {
        a5();
        return Cz().J8;
    }

    public boolean j6(bs bsVar) {
        if (this.Zo == 0) {
            return true;
        }
        a5();
        int Ev = Ev();
        bp Xa = Xa();
        if (cd.J0(Ev)) {
            return true;
        }
        if (cd.Ws(Ev) && bsVar.cT()) {
            if (((bp) bsVar).FH(Xa)) {
                return true;
            }
            if (((bp) bsVar).DW(Xa)) {
                return true;
            }
        }
        if (cd.QX(Ev) && bsVar.cT() && CU() == ((bp) bsVar).CU()) {
            return true;
        }
        if (cd.DW(Ev)) {
            if (bsVar.cT()) {
                if (((bp) bsVar).a8() == a8()) {
                    return true;
                }
                if (this.DW.j6(a8(), ((bp) bsVar).a8())) {
                    return true;
                }
            } else if (bsVar == this.DW.Zo()) {
                return true;
            } else {
                ec we = ((ce) bsVar).we();
                we.j6.j6();
                while (we.j6.DW()) {
                    int FH = we.j6.FH();
                    if (FH == a8()) {
                        return true;
                    }
                    if (this.DW.j6(a8(), FH)) {
                        return true;
                    }
                }
            }
        }
        if (cd.j6(Ev)) {
            if (bsVar.cT()) {
                if (((bp) bsVar).rN() == rN()) {
                    return true;
                }
            } else if (bsVar == rN()) {
                return true;
            }
        }
        if (cd.J8(Ev)) {
            if (bsVar.qp()) {
                if (rN() == bsVar) {
                    return true;
                }
            } else if (this == bsVar) {
                return true;
            } else {
                bsVar = (bp) bsVar;
                co Xa2 = Xa();
                if (bsVar.FH(Xa2)) {
                    return true;
                }
                while (!bsVar.hz()) {
                    bsVar = bsVar.Xa();
                    if (bsVar.FH(Xa2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean ye() {
        a5();
        return cd.j6(Cz().J8);
    }

    public boolean FH(co coVar) {
        if (Cz().j3) {
            return false;
        }
        aX();
        return Cz().rN.FH((bs) coVar);
    }

    public int WB() {
        if (Cz().a8) {
            return 0;
        }
        e9();
        return Cz().lg.Hw();
    }

    public co v5(int i) {
        e9();
        return (co) Cz().lg.j6(i);
    }

    private void pN() {
        a5();
        if (!Cz().DW) {
            Cz().DW = true;
            e9();
            oy();
        }
    }

    private void oy() {
        int i;
        ea aM;
        dr cb;
        int FH;
        int i2;
        co DW;
        int i3;
        bs j3 = j3();
        Cz().I.DW();
        Cz().Mz.j6.j6();
        while (Cz().Mz.j6.DW()) {
            Cz().I.DW(Cz().Mz.j6.FH(), Cz().Mz.j6.Hw());
        }
        for (i = 0; i < Cz().lg.Hw(); i++) {
            bp gn;
            co coVar = (co) Cz().lg.j6(i);
            if (coVar.n5()) {
                gn = ((cf) coVar).gn();
            } else {
                gn = (bp) coVar;
            }
            dr cn = gn.cn();
            cn.j6.j6();
            while (cn.j6.DW()) {
                Cz().I.DW(cn.j6.FH(), cn.j6.Hw());
            }
        }
        Cz().sG.DW();
        Cz().cn.j6.j6();
        while (Cz().cn.j6.DW()) {
            i = Cz().cn.j6.FH();
            bs bsVar = (bz) Cz().cn.j6.Hw();
            if (cd.j3(bsVar.Ev())) {
                try {
                    if (Qq().sy().j6(i)) {
                    }
                } catch (ej e) {
                }
                Cz().sG.DW(i, bsVar);
            } else if (bsVar.vJ() && bsVar.Hw().VH().Hw()) {
                Cz().Sf.DW(i, bsVar);
            } else if (!(bsVar.Sf() && bsVar.Hw().VH().Hw())) {
                Cz().sG.DW(i, bsVar);
            }
            if (j3 != this) {
                Cz().g3.j6(bsVar, j3);
            }
        }
        if (ef()) {
            aM = aM();
            if (aM != null) {
                aM.j6.j6();
                while (aM.j6.DW()) {
                    bsVar = (bp) aM.j6.FH();
                    if (bsVar != this) {
                        this.DW.j6(this.v5, bsVar);
                        cb = bsVar.cb();
                        cb.j6.j6();
                        while (cb.j6.DW()) {
                            FH = cb.j6.FH();
                            bsVar = (bz) cb.j6.Hw();
                            if (!bsVar.Sf()) {
                                if (cd.j3(bsVar.Ev())) {
                                    try {
                                        if (Qq().sy().j6(FH)) {
                                        }
                                    } catch (ej e2) {
                                    }
                                }
                                Cz().sG.DW(FH, bsVar);
                            }
                            if (bsVar.Xa() != j3) {
                                Cz().g3.j6(bsVar, j3);
                            }
                        }
                    }
                }
            }
        }
        for (i2 = 0; i2 < Cz().lg.Hw(); i2++) {
            bs gn2;
            int i4;
            co coVar2;
            bp gn3;
            coVar = (co) Cz().lg.j6(i2);
            if (coVar.n5()) {
                gn2 = ((cf) coVar).gn();
            } else {
                gn2 = (bp) coVar;
            }
            if (gn2.g3()) {
                for (i4 = 0; i4 < Cz().lg.Hw(); i4++) {
                    if (i2 != i4) {
                        coVar2 = (co) Cz().lg.j6(i4);
                        if (coVar2.n5()) {
                            gn3 = ((cf) coVar2).gn();
                        } else {
                            gn3 = (bp) coVar2;
                        }
                        if (gn3.jO().FH(gn2)) {
                            break;
                        }
                    }
                }
            }
            dr aj = gn2.aj();
            aj.j6.j6();
            while (aj.j6.DW()) {
                bs gn4;
                int FH2 = aj.j6.FH();
                bs bsVar2 = (bz) aj.j6.Hw();
                if (!cd.QX(bsVar2.Ev())) {
                    DW = gn2.DW((bz) bsVar2);
                    if (DW.cT()) {
                        if (bsVar2.Xa() != DW) {
                            Cz().g3.j6(bsVar2, (bs) DW);
                        }
                    } else if (coVar.cT()) {
                        if (coVar.e3()) {
                            gn4 = ((cf) DW).gn();
                        }
                        if (bsVar2.Xa() != gn4) {
                            Cz().g3.j6(bsVar2, gn4);
                        }
                    } else {
                        try {
                            gn4 = ((cf) coVar).j6(DW);
                            if (bsVar2.Xa() != gn4) {
                                Cz().g3.j6(bsVar2, gn4);
                            }
                        } catch (ej e3) {
                        }
                    }
                    Cz().Sf.DW(FH2, bsVar2);
                }
            }
            dr sy = gn2.sy();
            sy.j6.j6();
            while (sy.j6.DW()) {
                bz bzVar;
                int FH3 = sy.j6.FH();
                bsVar2 = (bz) sy.j6.Hw();
                if (!cd.QX(bsVar2.Ev())) {
                    DW = gn2.DW((bz) bsVar2);
                    if (DW.cT()) {
                        if (bsVar2.Xa() != DW) {
                            Cz().g3.j6(bsVar2, (bs) DW);
                        }
                    } else if (coVar.cT()) {
                        if (coVar.e3()) {
                            gn4 = ((cf) DW).gn();
                        }
                        if (bsVar2.Xa() != gn4) {
                            Cz().g3.j6(bsVar2, gn4);
                        }
                    } else {
                        try {
                            gn4 = ((cf) coVar).j6(DW);
                            if (bsVar2.Xa() != gn4) {
                                Cz().g3.j6(bsVar2, gn4);
                            }
                        } catch (ej e4) {
                        }
                    }
                    Cz().cn.j6.j6();
                    while (Cz().cn.j6.DW()) {
                        bzVar = (bz) Cz().cn.j6.Hw();
                        if (bzVar.vJ()) {
                            i3 = 0;
                            while (i3 < bzVar.g3()) {
                                if (bzVar.Hw(i3) == FH3 && bzVar.FH(i3).cT() && ((bp) bzVar.FH(i3)).FH(DW((bz) bsVar2))) {
                                    bzVar.j6((bz) bsVar2);
                                    break;
                                }
                                i3++;
                            }
                            continue;
                        }
                    }
                    if (Hw().VH().Hw() || !bsVar2.Xa().g3() || Xa().g3()) {
                        if (Cz().cn.j6(FH3)) {
                            Cz().cn.j6.j6(FH3);
                            while (Cz().cn.j6.DW()) {
                                bzVar = (bz) Cz().cn.j6.Hw();
                                if (!(bzVar.Sf() || cd.j3(bzVar.Ev()))) {
                                    if (FH(bzVar, bsVar2)) {
                                        bzVar.j6((bz) bsVar2);
                                        break;
                                    } else if (Hw(bzVar, bsVar2)) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (Cz().sG.j6(FH3)) {
                            Cz().sG.j6.j6(FH3);
                            while (Cz().sG.j6.DW()) {
                                if (bsVar2 != ((bz) Cz().sG.j6.Hw())) {
                                    break;
                                }
                            }
                        }
                        if (bsVar2.Xa().g3() && Cz().Sf.j6(FH3)) {
                            Cz().Sf.j6.j6(FH3);
                            while (Cz().Sf.j6.DW()) {
                                if (bsVar2 != ((bz) Cz().Sf.j6.Hw())) {
                                    break;
                                }
                            }
                        }
                        Cz().sG.DW(FH3, bsVar2);
                    }
                }
            }
        }
        Cz().dx.j6();
        Cz().cb.j6.j6();
        while (Cz().cb.j6.DW()) {
            bsVar = (bz) Cz().cb.j6.FH();
            Cz().dx.j6(bsVar);
            if (j3 != this) {
                Cz().g3.j6(bsVar, j3);
            }
        }
        if (ef()) {
            ea aM2 = aM();
            if (aM2 != null) {
                aM2.j6.j6();
                while (aM2.j6.DW()) {
                    bsVar = (bp) aM2.j6.FH();
                    if (bsVar != this) {
                        this.DW.j6(this.v5, bsVar);
                        ea dx = bsVar.dx();
                        dx.j6.j6();
                        while (dx.j6.DW()) {
                            bsVar = (bz) dx.j6.FH();
                            if (bsVar.lp() == 0) {
                                Cz().dx.j6.j6();
                                while (Cz().dx.j6.DW()) {
                                    if (((bz) Cz().dx.j6.FH()).lp() == 0) {
                                        break;
                                    }
                                }
                            }
                            Cz().dx.j6(bsVar);
                            if (bsVar.Xa() != j3) {
                                Cz().g3.j6(bsVar, j3);
                            }
                        }
                    }
                }
            }
        }
        Cz().ef.DW();
        Cz().sh.j6.j6();
        while (Cz().sh.j6.DW()) {
            i = Cz().sh.j6.FH();
            bsVar = (bz) Cz().sh.j6.Hw();
            if (bsVar.vJ() && bsVar.Hw().VH().Hw()) {
                Cz().vJ.DW(i, bsVar);
            } else if (bsVar.Sf() && bsVar.Hw().VH().Hw()) {
                Cz().vJ.DW(i, bsVar);
            } else {
                Cz().ef.DW(i, bsVar);
            }
            if (j3 != this) {
                Cz().g3.j6(bsVar, j3);
            }
        }
        if (ef()) {
            aM = aM();
            if (aM != null) {
                aM.j6.j6();
                while (aM.j6.DW()) {
                    bsVar = (bp) aM.j6.FH();
                    if (bsVar != this) {
                        this.DW.j6(this.v5, bsVar);
                        cb = bsVar.sh();
                        cb.j6.j6();
                        while (cb.j6.DW()) {
                            FH = cb.j6.FH();
                            bsVar = (bz) cb.j6.Hw();
                            if (!bsVar.Sf()) {
                                Cz().ef.DW(FH, bsVar);
                            }
                            if (bsVar.Xa() != j3) {
                                Cz().g3.j6(bsVar, j3);
                            }
                        }
                    }
                }
            }
        }
        i2 = 0;
        while (i2 < Cz().lg.Hw()) {
            coVar = (co) Cz().lg.j6(i2);
            if (coVar.n5()) {
                gn2 = ((cf) coVar).gn();
            } else {
                gn2 = (bp) coVar;
            }
            if (gn2.g3()) {
                for (i4 = 0; i4 < Cz().lg.Hw(); i4++) {
                    if (i2 != i4) {
                        coVar2 = (co) Cz().lg.j6(i4);
                        if (coVar2.n5()) {
                            gn3 = ((cf) coVar2).gn();
                        } else {
                            gn3 = (bp) coVar2;
                        }
                        if (gn3.jO().FH(gn2)) {
                            break;
                        }
                    }
                }
            }
            aj = gn2.OW();
            aj.j6.j6();
            while (aj.j6.DW()) {
                FH2 = aj.j6.FH();
                bsVar2 = (bz) aj.j6.Hw();
                try {
                    if (!((g3() && i2 != Cz().lg.Hw() - 1 && bsVar2.Xa() == this.DW.v5(tp(), Hw())) || cd.QX(bsVar2.Ev()))) {
                        DW = gn2.DW((bz) bsVar2);
                        if (DW.cT()) {
                            if (bsVar2.Xa() != DW) {
                                Cz().g3.j6(bsVar2, (bs) DW);
                            }
                        } else if (coVar.cT()) {
                            if (coVar.e3()) {
                                gn4 = ((cf) DW).gn();
                            }
                            if (bsVar2.Xa() != gn4) {
                                Cz().g3.j6(bsVar2, gn4);
                            }
                        } else {
                            try {
                                gn4 = ((cf) coVar).j6(DW);
                                if (bsVar2.Xa() != gn4) {
                                    Cz().g3.j6(bsVar2, gn4);
                                }
                            } catch (ej e5) {
                            }
                        }
                        Cz().vJ.DW(FH2, bsVar2);
                    }
                } catch (ej e6) {
                }
            }
            sy = gn2.lp();
            sy.j6.j6();
            while (sy.j6.DW()) {
                FH3 = sy.j6.FH();
                bsVar2 = (bz) sy.j6.Hw();
                try {
                    if (!((g3() && i2 != Cz().lg.Hw() - 1 && bsVar2.Xa() == this.DW.v5(tp(), Hw())) || cd.QX(bsVar2.Ev()))) {
                        DW = gn2.DW((bz) bsVar2);
                        if (DW.cT()) {
                            if (bsVar2.Xa() != DW) {
                                Cz().g3.j6(bsVar2, (bs) DW);
                            }
                        } else if (coVar.cT()) {
                            if (coVar.e3()) {
                                gn4 = ((cf) DW).gn();
                            }
                            if (bsVar2.Xa() != gn4) {
                                Cz().g3.j6(bsVar2, gn4);
                            }
                        } else {
                            try {
                                gn4 = ((cf) coVar).j6(DW);
                                if (bsVar2.Xa() != gn4) {
                                    Cz().g3.j6(bsVar2, gn4);
                                }
                            } catch (ej e7) {
                            }
                        }
                        Cz().sh.j6.j6();
                        while (Cz().sh.j6.DW()) {
                            bzVar = (bz) Cz().sh.j6.Hw();
                            if (FH(j3, bzVar, bsVar2) && bzVar.vJ()) {
                                i3 = 0;
                                while (i3 < bzVar.g3()) {
                                    if (bzVar.Hw(i3) == FH3 && bzVar.FH(i3).cT() && ((bp) bzVar.FH(i3)).FH(DW((bz) bsVar2))) {
                                        bzVar.j6((bz) bsVar2);
                                        break;
                                    }
                                    i3++;
                                }
                                continue;
                            }
                        }
                        if (Hw().VH().Hw() || !bsVar2.Xa().g3() || Xa().g3()) {
                            if (Cz().sh.j6(FH3)) {
                                Cz().sh.j6.j6(FH3);
                                while (Cz().sh.j6.DW()) {
                                    bzVar = (bz) Cz().sh.j6.Hw();
                                    if (FH(j3, bzVar, bsVar2) && !bzVar.Sf()) {
                                        if (FH(bzVar, bsVar2)) {
                                            bzVar.j6((bz) bsVar2);
                                            break;
                                        } else if (DW(bzVar, (bz) bsVar2)) {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (Cz().ef.j6(FH3)) {
                                Cz().ef.j6.j6(FH3);
                                while (Cz().ef.j6.DW()) {
                                    bzVar = (bz) Cz().ef.j6.Hw();
                                    if (bsVar2 != bzVar && FH(j3, bzVar, bsVar2)) {
                                        break;
                                    }
                                }
                            }
                            if (bsVar2.Xa().g3() && Cz().vJ.j6(FH3)) {
                                Cz().vJ.j6.j6(FH3);
                                while (Cz().vJ.j6.DW()) {
                                    bzVar = (bz) Cz().vJ.j6.Hw();
                                    if (bsVar2 != bzVar && FH(j3, bzVar, bsVar2)) {
                                        break;
                                    }
                                }
                            }
                            Cz().ef.DW(FH3, bsVar2);
                        }
                    }
                } catch (ej e8) {
                }
            }
            i2++;
        }
    }

    private boolean FH(co coVar, bz bzVar, bz bzVar2) {
        try {
            if (bzVar.lp() != bzVar2.lp() || bzVar.FH(coVar) != bzVar2.FH(coVar)) {
                return false;
            }
            int i;
            int i2;
            if (bzVar.FH(coVar) > 0) {
                if (!Hw().VH().DW()) {
                    int FH = bzVar.FH(coVar);
                    for (i = 0; i < FH; i++) {
                        ca gn = bzVar.gn(i);
                        ca gn2 = bzVar2.gn(i);
                        int Zo = gn.Zo();
                        if (Zo != gn2.Zo()) {
                            return false;
                        }
                        for (i2 = 0; i2 < Zo; i2++) {
                            if (!gn.j6(coVar, i2).DW(gn2.j6(coVar, i2), bzVar, bzVar2)) {
                                return false;
                            }
                        }
                    }
                }
                i = bzVar.lp();
                i2 = 0;
                while (i2 < i) {
                    if (bzVar.VH(i2) != bzVar2.VH(i2) || !bzVar.FH(coVar, i2).DW(bzVar2.FH(coVar, i2), bzVar, bzVar2)) {
                        return false;
                    }
                    i2++;
                }
            } else {
                i = bzVar.lp();
                for (i2 = 0; i2 < i; i2++) {
                    if (bzVar.VH(i2) != bzVar2.VH(i2)) {
                        return false;
                    }
                    co FH2 = bzVar.FH(coVar, i2);
                    co FH3 = bzVar2.FH(coVar, i2);
                    if (!FH2.DW(FH3, bzVar, bzVar2)) {
                        if (FH2.n5() && FH3.n5()) {
                            return false;
                        }
                        if (!(FH2.a_().Hw(FH3.a_()) || FH3.a_().Hw(FH2.a_()))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (ej e) {
            return false;
        }
    }

    private boolean DW(bz bzVar, bz bzVar2) {
        return !FH(bzVar, bzVar2);
    }

    private boolean FH(bz bzVar, bz bzVar2) {
        if (bzVar2.Xa().g3()) {
            if (!bzVar.Xa().g3()) {
                return true;
            }
            if (cd.FH(bzVar.Ev())) {
                return false;
            }
            return true;
        } else if (cd.FH(bzVar.Ev())) {
            return false;
        } else {
            if (!cd.XL(bzVar2.Ev()) && !cd.v5(bzVar2.Ev()) && !cd.VH(bzVar2.Ev())) {
                return false;
            }
            if (cd.XL(bzVar.Ev()) || cd.v5(bzVar.Ev())) {
                return true;
            }
            return false;
        }
    }

    private boolean Hw(bz bzVar, bz bzVar2) {
        return !FH(bzVar, bzVar2);
    }

    private void aX() {
        a5();
        if (!Cz().aM) {
            if (Cz().Ws) {
                Cz().j3 = true;
                this.DW.Zo(this);
                Cz().j3 = false;
                return;
            }
            this.DW.j6(tp(), Hw(), this);
        }
    }

    private void e9() {
        aX();
        if (!Cz().U2) {
            boolean z;
            Cz().rN.j6.j6();
            while (Cz().rN.j6.DW()) {
                if (((bp) Cz().rN.j6.FH()).kQ() > 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z && Cz().Ws) {
                Cz().a8 = true;
                this.DW.Hw(this);
                Cz().a8 = false;
                Cz().U2 = true;
            } else {
                Cz().U2 = true;
                for (int i = 0; i < Cz().Mr.Hw(); i++) {
                    Cz().lg.j6(i, Cz().Mr.j6(i));
                }
            }
            ys();
        }
    }

    private void QO() {
        ea aM;
        bp bpVar;
        bs bsVar;
        int i = 0;
        if (Cz().rN == null) {
            Cz().rN = new ea(this.DW);
        }
        if (Cz().BT == null) {
            Cz().BT = new dr(this.DW);
        }
        Cz().BT.DW();
        Cz().P8.j6.j6();
        while (Cz().P8.j6.DW()) {
            Cz().BT.j6(Cz().P8.j6.FH(), (bp) Cz().P8.j6.Hw());
        }
        if (ef()) {
            aM = aM();
            if (aM != null) {
                aM.j6.j6();
                while (aM.j6.DW()) {
                    bpVar = (bp) aM.j6.FH();
                    if (bpVar != this) {
                        bpVar.aX();
                        dm dmVar = bpVar.Cz().Mr;
                        if (dmVar != null && dmVar.Hw() > 0) {
                            try {
                                if (!((bp) dmVar.j6(0)).g3() && Cz().Mr.Hw() > 0 && Cz().Mr.j6(0) == this.DW.v5(tp(), Hw())) {
                                    Cz().Mr.j6(0, dmVar.j6(0));
                                }
                            } catch (ej e) {
                            }
                            for (int i2 = 0; i2 < dmVar.Hw(); i2++) {
                                if (!Cz().Mr.j6(dmVar.j6(i2))) {
                                    Cz().Mr.FH(dmVar.j6(i2));
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i3 = 0; i3 < Cz().Mr.Hw(); i3++) {
            Cz().rN.j6(((bp) Cz().Mr.j6(i3)).jO());
        }
        Cz().rN.j6((bs) this);
        if (ef()) {
            aM = aM();
            if (aM != null) {
                aM.j6.j6();
                while (aM.j6.DW()) {
                    bsVar = (bp) aM.j6.FH();
                    if (bsVar != this) {
                        Cz().rN.j6(bsVar);
                    }
                }
            }
        }
        Cz().BT.DW();
        while (i < Cz().Mr.Hw()) {
            dr ko = ((bp) Cz().Mr.j6(i)).ko();
            ko.j6.j6();
            while (ko.j6.DW()) {
                int FH = ko.j6.FH();
                bsVar = (bp) ko.j6.Hw();
                if (!cd.QX(bsVar.Ev())) {
                    Cz().BT.DW(FH, bsVar);
                }
            }
            i++;
        }
        if (ef()) {
            ea aM2 = aM();
            if (aM2 != null) {
                aM2.j6.j6();
                while (aM2.j6.DW()) {
                    bpVar = (bp) aM2.j6.FH();
                    if (bpVar != this) {
                        ko = bpVar.ko();
                        if (ko != null) {
                            ko.j6.j6();
                            while (ko.j6.DW()) {
                                Cz().BT.j6(ko.j6.FH(), (bp) ko.j6.Hw());
                            }
                        }
                    }
                }
            }
        }
        Cz().P8.j6.j6();
        while (Cz().P8.j6.DW()) {
            Cz().BT.j6(Cz().P8.j6.FH(), (bp) Cz().P8.j6.Hw());
        }
        Cz().rN.j6.j6();
        while (Cz().rN.j6.DW()) {
            this.DW.j6(this.v5, Cz().rN.j6.FH());
        }
    }

    private void sM() {
        if (this.Zo == 0) {
            this.DW.u7();
        } else if (!this.VH) {
            this.VH = true;
            a5();
        }
    }

    private void a5() {
        if (!Cz().j6) {
            Cz().j6 = true;
            this.DW.gn(tp(), Hw());
        }
    }

    private void ys() {
        ea aM;
        bp bpVar;
        int i = 0;
        if (Cz().vy == null) {
            Cz().vy = new dr(this.DW);
        } else {
            Cz().vy.DW();
        }
        Cz().P8.j6.j6();
        while (Cz().P8.j6.DW()) {
            Cz().vy.j6(Cz().P8.j6.FH(), ((bp) Cz().P8.j6.Hw()).j3());
        }
        if (ef()) {
            aM = aM();
            if (aM != null) {
                aM.j6.j6();
                while (aM.j6.DW()) {
                    bpVar = (bp) aM.j6.FH();
                    if (bpVar != this) {
                        bpVar.e9();
                        dm dmVar = bpVar.Cz().lg;
                        if (dmVar != null && dmVar.Hw() > 0) {
                            try {
                                if (!((co) dmVar.j6(0)).g3() && Cz().lg.Hw() > 0 && !((co) Cz().lg.j6(0)).g3() && Cz().lg.j6(0) == this.DW.v5(tp(), Hw())) {
                                    Cz().lg.j6(0, dmVar.j6(0));
                                }
                            } catch (ej e) {
                            }
                            for (int i2 = 0; i2 < dmVar.Hw(); i2++) {
                                if (!Cz().Mr.j6(dmVar.j6(i2))) {
                                    Cz().lg.FH(dmVar.j6(i2));
                                }
                            }
                        }
                    }
                }
            }
        }
        if (Cz().er == null) {
            Cz().er = new ea(this.DW);
        }
        for (int i3 = 0; i3 < Cz().lg.Hw(); i3++) {
            co coVar = (co) Cz().lg.j6(i3);
            if (coVar.n5()) {
                ea FN = ((cf) coVar).gn().FN();
                FN.j6.j6();
                while (FN.j6.DW()) {
                    try {
                        Cz().er.j6(((cf) coVar).j6((co) FN.j6.FH()));
                    } catch (ej e2) {
                    }
                }
            } else if (((bp) coVar).e3()) {
                Cz().er.j6(((bp) coVar).jO());
            } else {
                Cz().er.j6(((bp) coVar).FN());
            }
        }
        Cz().er.j6(j3());
        if (ef()) {
            aM = aM();
            if (aM != null) {
                aM.j6.j6();
                while (aM.j6.DW()) {
                    bpVar = (bp) aM.j6.FH();
                    if (bpVar != this) {
                        Cz().er.j6(bpVar.j3());
                    }
                }
            }
        }
        Cz().vy.DW();
        while (i < Cz().lg.Hw()) {
            bp gn;
            coVar = (co) Cz().lg.j6(i);
            if (coVar.n5()) {
                gn = ((cf) coVar).gn();
            } else {
                gn = (bp) coVar;
            }
            dr oY = gn.oY();
            oY.j6.j6();
            while (oY.j6.DW()) {
                int FH = oY.j6.FH();
                bs bsVar = (co) oY.j6.Hw();
                if (bsVar.n5()) {
                    bs gn2 = ((cf) bsVar).gn();
                } else {
                    bp bpVar2 = (bp) bsVar;
                }
                if (!cd.QX(gn.Ev())) {
                    if (coVar.n5()) {
                        try {
                            Cz().vy.DW(FH, ((cf) coVar).j6((co) bsVar));
                        } catch (ej e3) {
                        }
                    } else if (bsVar.e3()) {
                        Cz().vy.DW(FH, bsVar);
                    } else {
                        Cz().vy.DW(FH, gn2);
                    }
                }
            }
            i++;
        }
        if (ef()) {
            aM = aM();
            if (aM != null) {
                aM.j6.j6();
                while (aM.j6.DW()) {
                    bpVar = (bp) aM.j6.FH();
                    if (bpVar != this) {
                        dr oY2 = bpVar.oY();
                        if (oY2 != null) {
                            oY2.j6.j6();
                            while (oY2.j6.DW()) {
                                Cz().vy.j6(oY2.j6.FH(), (co) oY2.j6.Hw());
                            }
                        }
                    }
                }
            }
        }
        Cz().P8.j6.j6();
        while (Cz().P8.j6.DW()) {
            Cz().vy.j6(Cz().P8.j6.FH(), ((bp) Cz().P8.j6.Hw()).j3());
        }
    }

    public String mb() {
        String str = "";
        bp bpVar = this;
        while (true) {
            String str2 = bpVar.br() + str;
            bp Xa = bpVar.Xa();
            if (Xa == bpVar) {
                return rN().iW().replace('.', '/') + "/" + str2 + ".html";
            }
            bp bpVar2 = Xa;
            str = "." + str2;
            bpVar = bpVar2;
        }
    }
}
