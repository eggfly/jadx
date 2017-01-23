public final class bz extends bs {
    private final bt DW;
    private final by FH;
    private int Hw;
    private bp VH;
    private int Zo;
    private bz$a gn;
    private final bw j6;
    private bv v5;

    private bz$a XX() {
        if (this.gn != null) {
            return this.gn;
        }
        this.gn = new bz$a();
        return this.gn;
    }

    protected bz(bt btVar, by byVar, bw bwVar) {
        super(bwVar, btVar);
        this.DW = btVar;
        this.FH = byVar;
        this.j6 = bwVar;
    }

    protected bz(bt btVar, by byVar, bw bwVar, bv bvVar, bj bjVar, int i) {
        super(bwVar, btVar);
        this.DW = btVar;
        this.FH = byVar;
        this.j6 = bwVar;
        this.Hw = btVar.DW((bs) this);
        this.v5 = bvVar;
        this.Zo = i;
        j6(bjVar);
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.Hw = eeVar.readInt();
        this.v5 = this.j6.gn(eeVar.readInt());
        this.Zo = eeVar.readInt();
        this.VH = (bp) this.DW.FH(eeVar.readInt());
        if (eeVar.readBoolean()) {
            this.gn = new bz$a();
            this.gn.gn = eeVar.readInt();
            this.gn.tp = eeVar.readInt();
            this.gn.u7 = eeVar.readInt();
            this.gn.EQ = eeVar.readInt();
            this.gn.we = eeVar.readInt();
            this.gn.J0 = eeVar.readInt();
            this.gn.J8 = eeVar.readInt();
            this.gn.Ws = eeVar.readInt();
            this.gn.v5 = eeVar.readInt();
            this.gn.Zo = eeVar.readInt();
            this.gn.VH = eeVar.readInt();
            this.gn.gW = (co) this.DW.FH(eeVar.readInt());
            this.gn.BT = eeVar.readInt();
            this.gn.vy = eeVar.readBoolean();
            this.gn.FH = eeVar.readBoolean();
            this.gn.DW = eeVar.readBoolean();
            this.gn.P8 = eeVar.readInt();
            if (eeVar.readBoolean()) {
                this.gn.KD = eeVar.readUTF();
            }
            this.gn.ro = eeVar.readBoolean();
            this.gn.nw = eeVar.readLong();
            this.gn.SI = eeVar.readBoolean();
            this.gn.Hw = eeVar.readBoolean();
            this.gn.cn = eeVar.readBoolean();
            if (eeVar.readBoolean()) {
                this.gn.sh = new dm(this.DW, eeVar);
                this.gn.cb = new do(eeVar);
            }
            this.gn.ei = eeVar.readInt();
            this.gn.QX = eeVar.readInt();
            this.gn.XL = eeVar.readBoolean();
            this.gn.aM = eeVar.readBoolean();
            if (eeVar.readBoolean()) {
                this.gn.Mr = new dm(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.gn.U2 = new do(eeVar);
            }
            if (eeVar.readBoolean()) {
                this.gn.a8 = new do(eeVar);
            }
            if (eeVar.readBoolean()) {
                this.gn.j3 = new dm(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.gn.lg = new ea(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.gn.rN = new dr(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.gn.er = new ea(this.DW, eeVar);
            }
            if (eeVar.readBoolean()) {
                this.gn.yS = new dm(this.DW, eeVar);
            }
        }
    }

    protected void j6(ef efVar) {
        boolean z = true;
        super.j6(efVar);
        efVar.writeInt(this.Hw);
        efVar.writeInt(this.v5.vy());
        efVar.writeInt(this.Zo);
        efVar.writeInt(this.DW.j6(this.VH));
        efVar.writeBoolean(this.gn != null);
        if (this.gn != null) {
            boolean z2;
            efVar.writeInt(this.gn.gn);
            efVar.writeInt(this.gn.tp);
            efVar.writeInt(this.gn.u7);
            efVar.writeInt(this.gn.EQ);
            efVar.writeInt(this.gn.we);
            efVar.writeInt(this.gn.J0);
            efVar.writeInt(this.gn.J8);
            efVar.writeInt(this.gn.Ws);
            efVar.writeInt(this.gn.v5);
            efVar.writeInt(this.gn.Zo);
            efVar.writeInt(this.gn.VH);
            efVar.writeInt(this.DW.j6(this.gn.gW));
            efVar.writeInt(this.gn.BT);
            efVar.writeBoolean(this.gn.vy);
            efVar.writeBoolean(this.gn.FH);
            efVar.writeBoolean(this.gn.DW);
            efVar.writeInt(this.gn.P8);
            efVar.writeBoolean(this.gn.KD != null);
            if (this.gn.KD != null) {
                efVar.writeUTF(this.gn.KD);
            }
            efVar.writeBoolean(this.gn.ro);
            efVar.writeLong(this.gn.nw);
            efVar.writeBoolean(this.gn.SI);
            efVar.writeBoolean(this.gn.Hw);
            efVar.writeBoolean(this.gn.cn);
            if (this.gn.sh != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.gn.sh != null) {
                this.gn.sh.j6(efVar);
                this.gn.cb.j6(efVar);
            }
            efVar.writeInt(this.gn.ei);
            efVar.writeInt(this.gn.QX);
            efVar.writeBoolean(this.gn.XL);
            efVar.writeBoolean(this.gn.aM);
            efVar.writeBoolean(this.gn.Mr != null);
            if (this.gn.Mr != null) {
                this.gn.Mr.j6(efVar);
            }
            if (this.gn.U2 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.gn.U2 != null) {
                this.gn.U2.j6(efVar);
            }
            if (this.gn.a8 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.gn.a8 != null) {
                this.gn.a8.j6(efVar);
            }
            if (this.gn.j3 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.gn.j3 != null) {
                this.gn.j3.j6(efVar);
            }
            if (this.gn.lg != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.gn.lg != null) {
                this.gn.lg.j6(efVar);
            }
            if (this.gn.rN != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.gn.rN != null) {
                this.gn.rN.j6(efVar);
            }
            if (this.gn.er != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            efVar.writeBoolean(z2);
            if (this.gn.er != null) {
                this.gn.er.j6(efVar);
            }
            if (this.gn.yS == null) {
                z = false;
            }
            efVar.writeBoolean(z);
            if (this.gn.yS != null) {
                this.gn.yS.j6(efVar);
            }
        }
    }

    protected void j6(bp bpVar, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.VH = bpVar;
        XX().vy = z;
        XX().BT = i;
        XX().P8 = i2;
        XX().ei = 0;
        bz$a XX = XX();
        XX.ei |= 32;
        if (z2) {
            XX = XX();
            XX.ei |= 1;
        }
        if (z3) {
            XX = XX();
            XX.ei |= 4;
        }
        if (z4) {
            XX = XX();
            XX.ei |= 2;
        }
    }

    protected void j6(bp bpVar, int i, int i2, int i3, boolean z, boolean z2, int i4, int i5, boolean z3, boolean z4, boolean z5, int i6) {
        int i7;
        this.VH = bpVar;
        XX().FH = false;
        XX().XL = z;
        XX().aM = z2;
        XX().BT = i;
        XX().P8 = i5;
        XX().QX = i4;
        XX().ei = 0;
        bz$a XX = XX();
        XX.ei |= 64;
        if (z5) {
            XX = XX();
            XX.ei |= 128;
        }
        if (z3) {
            XX = XX();
            XX.ei |= 8;
        }
        if (z4) {
            XX = XX();
            XX.ei |= 16;
        }
        if (XX().j3 != null) {
            XX().j3.DW(i6);
            for (i7 = 0; i7 < i6; i7++) {
                XX().j3.j6(i7, null);
            }
        } else if (i6 > 0) {
            XX().j3 = new dm(this.DW, i6);
            for (i7 = 0; i7 < i6; i7++) {
                XX().j3.j6(i7, null);
            }
        }
        if (XX().U2 != null) {
            XX().U2.Hw(i3);
            for (i7 = 0; i7 < i3; i7++) {
                XX().U2.j6(i7, 0);
            }
        } else if (i3 > 0) {
            XX().U2 = new do(i3);
            for (i7 = 0; i7 < i3; i7++) {
                XX().U2.j6(i7, 0);
            }
        }
        if (XX().a8 != null) {
            XX().a8.Hw(i3);
            for (i7 = 0; i7 < i3; i7++) {
                XX().a8.j6(i7, 0);
            }
        } else if (i3 > 0) {
            XX().a8 = new do(i3);
            for (i7 = 0; i7 < i3; i7++) {
                XX().a8.j6(i7, 0);
            }
        }
        if (XX().Mr != null) {
            XX().Mr.DW(i3);
            for (i7 = 0; i7 < i3; i7++) {
                XX().Mr.j6(i7, null);
            }
        } else if (i3 > 0) {
            XX().Mr = new dm(this.DW, i3);
            for (i7 = 0; i7 < i3; i7++) {
                XX().Mr.j6(i7, null);
            }
        }
        if (XX().rN == null) {
            XX().rN = new dr(this.DW);
        } else {
            XX().rN.DW();
        }
        if (i2 == 0) {
            XX().er = null;
        } else {
            XX().er = new ea(this.DW);
        }
        if (i2 == 0) {
            XX().yS = null;
            return;
        }
        XX().yS = new dm(this.DW, i2);
    }

    protected void j6(String str) {
        XX().KD = str;
        XX().ro = true;
        XX().Hw = true;
    }

    protected void j6(long j) {
        XX().nw = j;
        XX().SI = true;
        XX().Hw = true;
    }

    protected void j6() {
        this.VH = null;
        this.gn = null;
    }

    protected void DW() {
        this.gn = null;
    }

    protected void j6(int i) {
        XX().j6 = i;
    }

    protected void j6(co coVar, int i) {
        XX().j3.j6(i, coVar);
    }

    protected void j6(int i, int i2, int i3) {
        XX().U2.j6(i3, i);
        XX().a8.j6(i3, i2);
    }

    protected void DW(co coVar, int i) {
        XX().Mr.j6(i, coVar);
    }

    protected void j6(bz bzVar) {
        if (bzVar != this) {
            if (XX().lg == null) {
                XX().lg = new ea(this.DW);
            }
            XX().lg.j6((bs) bzVar);
        }
    }

    protected void j6(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        XX().v5 = i;
        XX().Zo = i2;
        XX().VH = i3;
        XX().gn = i4;
        XX().tp = i5;
        XX().u7 = i6;
        XX().EQ = i7;
        XX().we = i8;
        XX().J0 = i9;
        XX().J8 = i10;
        XX().Ws = i11;
    }

    protected void j6(int i, int i2, ca caVar) {
        XX().rN.j6(i2, (bs) caVar);
        XX().er.j6((bs) caVar);
        XX().yS.j6(i, caVar);
    }

    protected void j6(co coVar) {
        XX().gW = coVar;
    }

    public boolean FH() {
        if (!j3()) {
            return false;
        }
        if (!XX().Hw) {
            XX().Hw = true;
            this.DW.j6(this);
        }
        return XX().ro;
    }

    public String Zo() {
        if (FH()) {
            return XX().KD;
        }
        return null;
    }

    public boolean VH() {
        if (vJ()) {
            return false;
        }
        dr cb = Xa().cb();
        cb.j6.j6(aq());
        while (cb.j6.DW()) {
            bz bzVar = (bz) cb.j6.Hw();
            if (bzVar != this && !bzVar.vJ()) {
                return true;
            }
        }
        return false;
    }

    public boolean gn() {
        yO();
        return (XX().ei & 64) != 0;
    }

    public boolean u7() {
        yO();
        return (XX().ei & 32) != 0;
    }

    public boolean we() {
        return cd.we(Ev());
    }

    public boolean J0() {
        yO();
        return (XX().ei & 1) != 0;
    }

    public boolean J8() {
        yO();
        return (XX().ei & 128) != 0;
    }

    public boolean Ws() {
        yO();
        if ((XX().ei & 2) != 0) {
            return true;
        }
        ea cb = cb();
        cb.j6.j6();
        while (cb.j6.DW()) {
            if (((bz) cb.j6.FH()).Ws()) {
                return true;
            }
        }
        return false;
    }

    public boolean QX() {
        yO();
        if ((XX().ei & 4) != 0) {
            return true;
        }
        ea cb = cb();
        cb.j6.j6();
        while (cb.j6.DW()) {
            if (((bz) cb.j6.FH()).QX()) {
                return true;
            }
        }
        return false;
    }

    public boolean XL() {
        if (!j3()) {
            return false;
        }
        if (!XX().Hw) {
            XX().Hw = true;
            this.DW.j6(this);
        }
        return XX().SI;
    }

    public long aM() {
        if (XL()) {
            return XX().nw;
        }
        return 0;
    }

    public boolean j3() {
        yO();
        return (XX().BT & 512) != 0 && XX().vy;
    }

    public boolean Mr() {
        yO();
        return ((XX().BT & 256) == 0 || XX().vy) ? false : true;
    }

    public boolean U2() {
        return (XX().BT & 256) != 0;
    }

    public boolean kf() {
        if (Xa().ef()) {
            return false;
        }
        if (sG()) {
            return false;
        }
        if (Q6()) {
            return true;
        }
        for (bp Xa = Xa(); !Xa.hz(); Xa = Xa.Xa()) {
            if (Xa.Q6()) {
                return true;
            }
        }
        return false;
    }

    public co j6(co coVar, boolean z) {
        co DW;
        co Mz = Mz();
        if (coVar.cT()) {
            DW = ((bp) coVar).DW(this);
        } else {
            DW = ((cf) coVar).gn().DW(this);
        }
        co j6;
        if (z) {
            if (Mz.q7() && DW.n5() && coVar.n5()) {
                j6 = ((cf) DW).j6(Mz, true);
                if (j6.q7() && ((cg) j6).gn() == ((cf) coVar).gn() && ((cf) coVar).FH()[((cg) j6).Zo()] == 3) {
                    return Mz.a_();
                }
            }
        } else if (Mz.q7() && DW.n5() && coVar.n5()) {
            j6 = ((cf) DW).j6(Mz, true);
            if (j6.q7() && ((((cg) j6).gn() == ((cf) coVar).gn() && ((cf) coVar).FH()[((cg) j6).Zo()] == 2) || ((cf) coVar).FH()[((cg) j6).Zo()] == 1)) {
                throw new ej();
            }
        }
        if (coVar.cT()) {
            if ((coVar.e3() || DW.e3()) && !I()) {
                return Mz.a_();
            }
            return DW.n5() ? ((cf) DW).j6(Mz, z) : Mz;
        } else if ((coVar.e3() || DW.e3()) && !I()) {
            return ((cf) coVar).j6(Mz.a_(), z);
        } else {
            if (DW.n5()) {
                return ((cf) coVar).j6(((cf) DW).j6(Mz, z), z);
            }
            return ((cf) coVar).j6(Mz, z);
        }
    }

    public boolean a8() {
        return (Ev() & 16384) != 0;
    }

    public int lg() {
        yO();
        return XX().j6;
    }

    public co DW(int i) {
        kQ();
        if (XX().j3.j6(i) != null) {
            return (co) XX().j3.j6(i);
        }
        throw new ej();
    }

    public co j6(int i, co coVar) {
        co DW = DW(i);
        co DW2;
        if (coVar.cT()) {
            DW2 = ((bp) coVar).DW(this);
            if ((coVar.e3() || DW2.e3()) && !I()) {
                return DW.a_();
            }
            return DW2.n5() ? ((cf) DW2).j6(DW) : DW;
        } else {
            DW2 = ((cf) coVar).gn().DW(this);
            if ((coVar.e3() || DW2.e3()) && !I()) {
                return ((cf) coVar).j6(DW.a_());
            }
            if (DW2.n5()) {
                return ((cf) coVar).j6(((cf) DW2).j6(DW));
            }
            return ((cf) coVar).j6(DW);
        }
    }

    public int rN() {
        if (XX().j3 == null) {
            return 0;
        }
        return XX().j3.Hw();
    }

    public bp CU() {
        return Xa().CU();
    }

    public boolean cn() {
        yO();
        return XX().aM;
    }

    public boolean sh() {
        yO();
        return XX().XL;
    }

    public int er() {
        this.DW.Zo(tp(), Hw());
        return XX().v5;
    }

    public int yS() {
        this.DW.Zo(tp(), Hw());
        return XX().VH;
    }

    public int gW() {
        this.DW.Zo(tp(), Hw());
        return XX().Zo;
    }

    public int BT() {
        this.DW.Zo(tp(), Hw());
        return XX().gn;
    }

    public int vy() {
        this.DW.Zo(tp(), Hw());
        return XX().u7;
    }

    public int P8() {
        this.DW.Zo(tp(), Hw());
        return XX().EQ;
    }

    public int ei() {
        this.DW.Zo(tp(), Hw());
        return XX().tp;
    }

    public int nw() {
        this.DW.Zo(tp(), Hw());
        return XX().Ws;
    }

    public int SI() {
        this.DW.Zo(tp(), Hw());
        return XX().J8;
    }

    public int KD() {
        this.DW.Zo(tp(), Hw());
        return XX().J0;
    }

    public int ro() {
        this.DW.Zo(tp(), Hw());
        return XX().we;
    }

    public boolean j6(bp bpVar, bp bpVar2) {
        int Ev = Ev();
        co Xa = Xa();
        if (cd.J0(Ev)) {
            return true;
        }
        if (cd.Ws(Ev) && (bpVar2.FH((bp) Xa) || bpVar2.DW((bp) Xa))) {
            return true;
        }
        if (cd.QX(Ev) && Xa.CU() == bpVar2.CU()) {
            return true;
        }
        if (cd.DW(Ev) && (bpVar2.a8() == Xa.a8() || this.DW.j6(Xa.a8(), bpVar2.a8()))) {
            return true;
        }
        if (cd.j6(Ev) && bpVar2.rN() == Xa.rN()) {
            return true;
        }
        if (cd.J8(Ev)) {
            if (Xa == bpVar2) {
                return true;
            }
            if (Xa.rN() == bpVar2.rN() && Xa.aq() == bpVar2.aq() && Xa.ef() && bpVar2.ef()) {
                return true;
            }
            if (!bpVar2.FH(Xa)) {
                while (!bpVar2.hz()) {
                    bpVar2 = bpVar2.Xa();
                    if (bpVar2.FH(Xa)) {
                        return true;
                    }
                }
            } else if (cd.aM(Ev) || bpVar.FH((co) bpVar2)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public ea<bz> cb() {
        Xa().lp();
        if (XX().lg == null) {
            return new ea(this.DW);
        }
        return XX().lg;
    }

    public boolean dx() {
        Xa().lp();
        if (XX().lg == null) {
            return false;
        }
        XX().lg.j6.j6();
        while (XX().lg.j6.DW()) {
            if (!((bz) XX().lg.j6.FH()).Xa().g3()) {
                return true;
            }
        }
        return false;
    }

    public boolean sG() {
        Xa().lp();
        if (XX().lg == null || XX().lg.Hw() == 0) {
            return false;
        }
        return true;
    }

    public ea<bz> ef() {
        ea eaVar = new ea(this.DW);
        ea eaVar2 = new ea(this.DW);
        eaVar2.j6((bs) this);
        while (true) {
            eaVar2.j6.j6();
            while (eaVar2.j6.DW()) {
                bs bsVar = (bz) eaVar2.j6.FH();
                eaVar.j6(bsVar);
                eaVar.j6(bsVar.cb());
            }
            if (eaVar2.Hw() == eaVar.Hw()) {
                return eaVar;
            }
            eaVar2.j6();
            eaVar2.j6(eaVar);
        }
    }

    public boolean Sf() {
        kQ();
        return XX().cn;
    }

    public boolean vJ() {
        kQ();
        return XX().sh != null && XX().sh.Hw() > 0;
    }

    public int g3() {
        kQ();
        if (XX().sh == null) {
            return 0;
        }
        return XX().sh.Hw();
    }

    public co FH(int i) {
        kQ();
        return (co) XX().sh.j6(i);
    }

    public int Hw(int i) {
        kQ();
        return XX().cb.FH(i);
    }

    public co DW(co coVar) {
        co DW;
        co Mz = Mz();
        if (coVar.cT()) {
            DW = ((bp) coVar).DW(this);
        } else {
            DW = ((cf) coVar).gn().DW(this);
        }
        if (Mz.q7() && DW.n5() && coVar.n5()) {
            co j6 = ((cf) DW).j6(Mz, true);
            if (j6.q7() && ((cg) j6).gn() == ((cf) coVar).gn() && ((cf) coVar).FH()[((cg) j6).Zo()] == 3) {
                return Mz.a_();
            }
        }
        if (coVar.cT()) {
            if ((coVar.e3() || DW.e3()) && !I()) {
                return Mz.a_();
            }
            return DW.n5() ? ((cf) DW).j6(Mz) : Mz;
        } else if ((coVar.e3() || DW.e3()) && !I()) {
            return ((cf) coVar).j6(Mz.a_());
        } else {
            if (DW.n5()) {
                return ((cf) coVar).j6(((cf) DW).j6(Mz));
            }
            return ((cf) coVar).j6(Mz);
        }
    }

    public co Mz() {
        kQ();
        if (XX().gW != null) {
            return XX().gW;
        }
        throw new ej();
    }

    public co FH(co coVar, int i) {
        co Xa;
        if (coVar == null) {
            Xa = Xa();
        } else {
            Xa = coVar;
        }
        if (i >= lp()) {
            throw new ej();
        }
        co v5 = v5(i);
        co DW;
        if (Xa.cT()) {
            DW = ((bp) Xa).DW(this);
            if ((Xa.e3() || DW.e3()) && !I()) {
                return v5.a_();
            }
            return DW.n5() ? ((cf) DW).j6(v5) : v5;
        } else {
            DW = ((cf) Xa).gn().DW(this);
            if ((Xa.e3() || DW.e3()) && !I()) {
                return ((cf) Xa).j6(v5.a_());
            }
            if (DW.n5()) {
                return ((cf) Xa).j6(((cf) DW).j6(v5));
            }
            return ((cf) Xa).j6(v5);
        }
    }

    public co v5(int i) {
        kQ();
        if (XX().Mr.j6(i) != null) {
            return (co) XX().Mr.j6(i);
        }
        throw new ej();
    }

    public int Zo(int i) {
        yO();
        if (XX().a8.FH(i) == 0) {
            return this.FH.j6("p" + i);
        }
        return XX().a8.FH(i);
    }

    public int VH(int i) {
        yO();
        return XX().U2.FH(i);
    }

    public boolean I() {
        yO();
        return (XX().BT & 64) != 0;
    }

    public String x9() {
        return super.x9();
    }

    public boolean ca() {
        return false;
    }

    public boolean Qq() {
        bz bzVar;
        if (sy()) {
            ea dx = Xa().dx();
            dx.j6.j6();
            while (dx.j6.DW()) {
                bzVar = (bz) dx.j6.FH();
                if (bzVar != this && j6(this, bzVar)) {
                    return true;
                }
            }
            return false;
        } else if (vJ()) {
            return false;
        } else {
            dr sh = Xa().sh();
            sh.j6.j6(aq());
            while (sh.j6.DW()) {
                bzVar = (bz) sh.j6.Hw();
                if (bzVar != this && !bzVar.vJ() && j6(this, bzVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean j6(bz bzVar, bz bzVar2) {
        if (bzVar.lp() != bzVar2.lp() || bzVar.OW() != bzVar2.OW()) {
            return false;
        }
        int lp = bzVar.lp();
        int i = 0;
        while (i < lp) {
            try {
                if (bzVar.VH(i) != bzVar2.VH(i) || bzVar.v5(i) != bzVar2.v5(i)) {
                    return false;
                }
                i++;
            } catch (ej e) {
            }
        }
        return true;
    }

    public int Ev() {
        yO();
        return XX().BT;
    }

    private void kQ() {
        yO();
        if (!XX().FH) {
            XX().FH = true;
            this.DW.VH(tp(), Hw());
        }
    }

    private void yO() {
        if (!XX().DW) {
            XX().DW = true;
            this.DW.gn(tp(), Hw());
        }
    }

    public boolean sy() {
        yO();
        return (XX().ei & 8) != 0;
    }

    public boolean aj() {
        yO();
        return (XX().ei & 16) != 0;
    }

    public int aq() {
        yO();
        return XX().P8;
    }

    public int lp() {
        yO();
        if (XX().Mr == null) {
            return 0;
        }
        return XX().Mr.Hw();
    }

    public ca gn(int i) {
        return (ca) XX().yS.j6(i);
    }

    public int FH(co coVar) {
        co DW;
        yO();
        if (coVar.cT()) {
            DW = ((bp) coVar).DW(this);
        } else {
            DW = ((cf) coVar).gn().DW(this);
        }
        if ((DW.e3() || coVar.e3()) && !I()) {
            return 0;
        }
        return OW();
    }

    public int OW() {
        yO();
        if (XX().yS == null) {
            return 0;
        }
        return XX().yS.Hw();
    }

    public ea<ca> br() {
        if (OW() == 0) {
            return new ea(this.DW);
        }
        return XX().er;
    }

    public bp Xa() {
        if (this.VH == null) {
            yO();
        }
        return this.VH;
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

    public co j6(bv bvVar, bj bjVar, int i, co coVar, co[] coVarArr, int i2, int i3, co[] coVarArr2, int i4, int i5) {
        co sg = coVar.sg();
        if (FH(sg) != 0) {
            return this.DW.j6.j6(bvVar, bjVar, this, i, sg, coVarArr, i2, i3, coVarArr2, i4, i5);
        }
        return j6(i, sg);
    }

    public co j6(bv bvVar, bj bjVar, co coVar, co[] coVarArr, int i, int i2, co[] coVarArr2, int i3, int i4) {
        if (coVar == null) {
            coVar = Xa();
        }
        co sg = coVar.sg();
        if (FH(sg) == 0) {
            return DW(sg);
        }
        if (!sh() || (i2 == lp() && coVarArr[i2 - 1] != null && j6(bvVar, bjVar, coVarArr[i2 - 1], v5(i2 - 1)))) {
            return this.DW.j6.j6(bvVar, bjVar, this, sg, coVarArr, i, i2, coVarArr2, i3, i4);
        }
        return DW(sg).a_();
    }

    private boolean j6(bv bvVar, bj bjVar, co coVar, co coVar2) {
        if (coVar.AL() && coVar2.AL() && (coVar.FH(bvVar, bjVar, coVar2) || ((bo) coVar2).FH().Z1())) {
            return true;
        }
        return false;
    }

    public co DW(bv bvVar, bj bjVar, int i, co coVar, co[] coVarArr, int i2, int i3, co[] coVarArr2, int i4, int i5) {
        if (coVar == null) {
            coVar = Xa();
        }
        co sg = coVar.sg();
        if (FH(sg) != 0) {
            return this.DW.j6.DW(bvVar, bjVar, this, i, sg, coVarArr, i2, i3, coVarArr2, i4, i5);
        }
        return FH(sg, i);
    }

    public boolean DW(bv bvVar, bj bjVar, co coVar, co[] coVarArr, int i, int i2, co[] coVarArr2, int i3, int i4) {
        return this.DW.j6.DW(bvVar, bjVar, this, coVar, coVarArr, i, i2, coVarArr2, i3, i4);
    }

    public String mb() {
        try {
            String str = "";
            if (gn()) {
                str = str + "(";
                int i = 0;
                while (i < lp()) {
                    if (i > 0) {
                        str = str + ", ";
                    }
                    String str2 = str + v5(i).iW();
                    i++;
                    str = str2;
                }
                str = str + ")";
            }
            return Xa().mb() + "#" + eU() + str;
        } catch (ej e) {
            return null;
        }
    }
}
