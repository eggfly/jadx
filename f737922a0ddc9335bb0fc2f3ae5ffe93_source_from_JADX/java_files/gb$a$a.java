class gb$a$a {
    private ce DW;
    private dm<ce> EQ;
    private bp FH;
    private bp Hw;
    private dr<bs> J0;
    private dm<bp> J8;
    private dm<co> Mr;
    private do QX;
    private do U2;
    private dk<co> VH;
    private dr<bp> Ws;
    private do XL;
    private dl Zo;
    private do a8;
    private dm<bp> aM;
    private int er;
    private do gW;
    private dl gn;
    private dm<bp> j3;
    final /* synthetic */ gb$a j6;
    private int lg;
    private do rN;
    private dr<bp> tp;
    private du u7;
    private int v5;
    private dm<bp> we;
    private int yS;

    public gb$a$a(gb$a gb_a, bt btVar) {
        this.j6 = gb_a;
        this.Zo = new dl();
        this.gn = new dl();
        this.u7 = new du();
        this.QX = new do();
        this.XL = new do();
        this.U2 = new do();
        this.a8 = new do();
        this.rN = new do();
        this.gW = new do();
        this.VH = new dk(btVar);
        this.VH = new dk(btVar);
        this.tp = new dr(btVar);
        this.EQ = new dm(btVar);
        this.we = new dm(btVar);
        this.J0 = new dr(btVar);
        this.J8 = new dm(btVar);
        this.Ws = new dr(btVar);
        this.aM = new dm(btVar);
        this.j3 = new dm(btVar);
        this.Mr = new dm(btVar);
        this.U2 = new do();
    }

    public void j6() {
        this.lg = 0;
        this.rN.j6();
        this.j6.VH.j6();
        this.er = 0;
        this.yS = 0;
        this.gW.j6();
        this.v5 = 0;
        this.FH = null;
        this.DW = null;
        this.tp.DW();
        this.Ws.DW();
        this.EQ.j6();
        this.we.j6();
        this.J0.DW();
        this.J8.j6();
        this.U2.j6();
        this.j3.j6();
        this.aM.j6();
        this.Mr.j6();
        this.a8.j6();
        this.Zo.j6();
        this.VH.j6();
        this.gn.j6();
        this.u7.j6();
    }

    public boolean j6(co coVar) {
        bs a_;
        try {
            a_ = coVar.a_();
        } catch (ej e) {
            a_ = coVar;
        }
        if (this.a8.Hw() > 0 && cd.aM(this.a8.FH())) {
            return false;
        }
        if (a_ != Mr()) {
            return this.j6.Hw.DW(this.j6.v5.we(), (bp) a_, Mr());
        }
        if (this.aM.FH() == a_) {
            return false;
        }
        return true;
    }

    public boolean DW(co coVar) {
        bs a_;
        try {
            a_ = coVar.a_();
        } catch (ej e) {
            a_ = coVar;
        }
        if (this.a8.Hw() > 0 && cd.aM(this.a8.FH())) {
            return false;
        }
        if (a_ != Mr()) {
            return this.j6.Hw.j6(this.j6.v5.we(), (bp) a_, Mr());
        }
        if (this.aM.FH() == a_) {
            return false;
        }
        return true;
    }

    public boolean FH(co coVar) {
        co a_;
        try {
            a_ = coVar.a_();
        } catch (ej e) {
            a_ = coVar;
        }
        if (this.a8.Hw() > 0 && cd.aM(this.a8.FH())) {
            return false;
        }
        if (a_ == Mr()) {
            return true;
        }
        return this.j6.Hw.j6(this.j6.v5.we(), (bp) a_, Mr());
    }

    public void j6(ce ceVar) {
        this.DW = ceVar;
    }

    public void j6(bp bpVar) {
        this.Hw = bpVar;
        this.a8.j6(0);
    }

    public void DW() {
        this.a8.DW();
    }

    public void DW(bp bpVar) {
        this.gW.j6(this.er);
        this.er = 0;
        this.rN.j6(this.lg);
        this.Hw = null;
        this.FH = bpVar;
        this.j3.DW((bs) bpVar);
        this.Mr.DW(bpVar.j3());
        this.U2.j6(-1);
        this.gn.FH();
    }

    public void FH() {
        this.er = this.gW.DW();
        this.lg = this.rN.DW();
        this.U2.DW();
        this.j3.DW();
        this.Mr.DW();
        int Hw = this.j3.Hw() - 1;
        while (Hw >= 0 && this.j3.j6(Hw) == null) {
            Hw--;
        }
        if (Hw >= 0) {
            this.FH = (bp) this.j3.j6(Hw);
        } else {
            this.FH = null;
        }
        this.gn.Hw();
    }

    public void Hw() {
        we();
        this.j3.DW(null);
        this.Mr.DW(null);
        do doVar = this.U2;
        int i = this.v5 + 1;
        this.v5 = i;
        doVar.j6(i);
    }

    public void v5() {
        this.U2.DW();
        this.j3.DW();
        this.Mr.DW();
        this.v5--;
        J0();
    }

    public void j6(int i, boolean z, boolean z2) {
        int i2;
        int i3 = 1;
        we();
        if (!cd.aM(i)) {
            FH(1);
        }
        this.j3.DW(null);
        this.Mr.DW(null);
        do doVar = this.U2;
        int i4 = this.v5 + 1;
        this.v5 = i4;
        doVar.j6(i4);
        this.a8.j6(i);
        do doVar2 = this.QX;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        doVar2.j6(i2);
        doVar = this.XL;
        if (!z2) {
            i3 = 0;
        }
        doVar.j6(i3);
    }

    public void Zo() {
        this.U2.DW();
        this.j3.DW();
        this.Mr.DW();
        this.a8.DW();
        this.v5--;
        J0();
        this.QX.DW();
        this.XL.DW();
    }

    public void VH() {
        this.aM.DW(Mr());
    }

    public void gn() {
        this.aM.DW();
    }

    public void u7() {
        this.Zo.DW();
    }

    public void tp() {
        this.Zo.Hw();
    }

    public void EQ() {
        this.er = this.yS;
    }

    public void we() {
        this.gW.j6(this.er);
        this.rN.j6(this.lg);
        this.Zo.DW();
        this.VH.DW();
        this.gn.DW();
    }

    public void J0() {
        this.er = this.gW.DW();
        this.lg = this.rN.DW();
        this.Zo.Hw();
        this.VH.FH();
        this.gn.Hw();
    }

    public void j6(int i, int i2) {
        if (this.Zo.DW(i, this.v5)) {
            throw new eh();
        }
        this.Zo.j6(i, i2, this.v5);
    }

    public int j6(int i) {
        if (this.Zo.DW(i, this.v5)) {
            return this.Zo.j6(i, this.v5);
        }
        throw new ej();
    }

    public void DW(int i) {
        this.j6.v5.DW(i, lg());
    }

    public int FH(int i) {
        int lg = lg();
        for (int i2 = 1; i2 < i; i2++) {
            lg();
        }
        return lg;
    }

    private int lg() {
        if (this.er + 1 > this.yS) {
            this.yS = this.er + 1;
        }
        int i = this.er;
        this.er = i + 1;
        return i;
    }

    public void j6(int i, long j) {
        this.u7.j6(i, j);
    }

    public boolean J8() {
        return cd.aM(this.a8.FH());
    }

    public boolean Ws() {
        return this.QX.FH() > 0;
    }

    public boolean QX() {
        return this.QX.FH() > 0 && this.a8.Hw() > 0 && cd.aM(this.a8.FH());
    }

    public boolean XL() {
        return this.QX.FH() > 0 || this.XL.FH() > 0;
    }

    public boolean Hw(int i) {
        return this.u7.j6(i);
    }

    public long v5(int i) {
        return this.u7.FH(i);
    }

    public int aM() {
        if (this.lg + 1 > this.j6.Zo) {
            this.j6.Zo = this.lg + 1;
        }
        int i = this.lg;
        this.lg = i + 1;
        return i;
    }

    public void j6(int i, bz bzVar) {
        this.j6.v5.j6(i, aM());
        this.j6.VH.j6(bzVar.v5(), i);
    }

    public void j6(int i, int i2, co coVar) {
        this.j6.v5.j6(i2, aM());
        boolean DW = this.gn.DW(i, this.v5);
        this.gn.j6(i, i2, this.v5);
        int lg = lg();
        if (coVar == this.j6.Hw.aM() || coVar == this.j6.Hw.j3()) {
            lg();
        }
        if (this.j6.a8) {
            this.j6.v5.DW(i2, lg);
        }
        if (DW) {
            throw new eh();
        }
    }

    public void j6(int i, bp bpVar) {
        if (this.VH.DW(i, this.v5)) {
            throw new eh();
        }
        this.VH.j6(i, bpVar.j3(), this.v5);
    }

    public void j6(int i, co coVar) {
        if (this.VH.DW(i, this.v5)) {
            throw new eh();
        }
        this.VH.j6(i, coVar, this.v5);
    }

    public void DW(ce ceVar) {
        this.EQ.FH(ceVar);
    }

    public void FH(bp bpVar) {
        this.J8.FH(bpVar);
    }

    public void Hw(bp bpVar) {
        this.we.FH(bpVar);
    }

    public void j6(int i, bs bsVar) {
        if (this.Ws.j6(i)) {
            throw new eh();
        } else if (!this.J0.j6(i)) {
            this.J0.j6(i, bsVar);
        } else if (this.J0.FH(i) != bsVar) {
            throw new eh();
        }
    }

    public void DW(int i, bp bpVar) {
        if (this.J0.j6(i)) {
            throw new eh();
        } else if (!this.Ws.j6(i)) {
            this.Ws.j6(i, (bs) bpVar);
        } else if (this.Ws.FH(i) != bpVar) {
            throw new eh();
        }
    }

    public bs j3() {
        if (this.FH != null) {
            return this.FH;
        }
        return this.DW;
    }

    public bp Mr() {
        return this.FH;
    }

    public co U2() {
        return this.FH.j3();
    }

    public ce a8() {
        return this.DW;
    }

    public void j6(int i, int i2, int i3, co coVar) {
        gb$a gb_a;
        int i4;
        int gW = this.j6.v5.gW(i2);
        int Hw = this.Mr.Hw() - 1;
        while (Hw >= 0) {
            if (this.j3.j6(Hw) == null || ((bp) this.j3.j6(Hw)).DW(this.j6.v5.we(), this.j6.v5.tp(), gW, true, Mr(), this.j6.tp) == null) {
                Hw--;
            } else {
                boolean z;
                gb_a = this.j6;
                co coVar2 = (co) this.Mr.j6(Hw);
                if (this.a8.Hw() <= 0 || !cd.aM(this.a8.FH())) {
                    z = false;
                } else {
                    z = true;
                }
                gb_a.j6(i, i2, i3, -1, coVar2, false, z, coVar);
                if (this.j6.a8 && this.j6.v5.J8(i2) == 20 && !((bz) this.j6.v5.QX(i2)).I() && !DW((co) this.j3.j6(Hw))) {
                    this.j6.Zo(i2, "This method can not be referenced from a static-context");
                    return;
                }
                return;
            }
        }
        if (this.J0.j6(gW)) {
            bs FH = this.J0.FH(gW);
            if (FH.zh() && ((bz) FH).gn()) {
                this.j6.j6(i, i2, i3, -1, ((bz) FH).Xa(), false, false, coVar);
                return;
            }
        }
        if (this.j6.DW.DW) {
            bz bzVar = null;
            i4 = 0;
            while (i4 < this.J8.Hw()) {
                bz bzVar2;
                if (((bp) this.J8.j6(i4)).DW(this.j6.v5.we(), this.j6.v5.tp(), gW, true, Mr(), this.j6.tp) != null) {
                    this.j6.tp.j6.j6();
                    bzVar2 = bzVar;
                    while (this.j6.tp.j6.DW()) {
                        if (((bz) this.j6.tp.j6.FH()).I()) {
                            if (bzVar2 == null || bzVar2.Xa() == ((bz) this.j6.tp.j6.FH()).Xa()) {
                                bzVar2 = (bz) this.j6.tp.j6.FH();
                            } else {
                                this.j6.Hw(i2, "Ambiguous method </C>" + this.j6.v5.BT(i2) + "<//C>");
                                return;
                            }
                        }
                    }
                    continue;
                } else {
                    bzVar2 = bzVar;
                }
                i4++;
                bzVar = bzVar2;
            }
            if (bzVar != null && bzVar.gn()) {
                this.j6.j6(i, i2, i3, -1, bzVar.Xa(), false, false, coVar);
                return;
            }
        }
        int lg = this.j6.v5.lg(i3);
        i4 = 0;
        if (lg > 2) {
            for (int i5 = 1; i5 < lg; i5 += 2) {
                this.j6.FH(this.j6.v5.Hw(i3, i5), null);
                if (this.j6.v5.J0(this.j6.v5.Hw(i3, i5))) {
                    if (this.j6.Ws.length <= this.j6.j3) {
                        co[] coVarArr = new co[((this.j6.Ws.length * 2) + 1)];
                        System.arraycopy(this.j6.Ws, 0, coVarArr, 0, this.j6.Ws.length);
                        this.j6.Ws = coVarArr;
                    }
                    this.j6.Ws[this.j6.j3] = this.j6.v5.we(this.j6.v5.Hw(i3, i5));
                } else {
                    this.j6.Ws[this.j6.j3] = null;
                }
                i4++;
                this.j6.j3 = this.j6.j3 + 1;
            }
        }
        this.j6.Hw(i2, "Unknown method </C>" + this.j6.v5.BT(i2) + "<//C>");
        gb_a = this.j6;
        boolean z2 = this.a8.Hw() > 0 && cd.aM(this.a8.FH());
        gb_a.j6(i2, i3, z2, Mr(), coVar, this.j6.Ws, this.j6.j3 - i4, i4);
        this.j6.j3 = this.j6.j3 - i4;
    }

    private boolean j6(int i, boolean z) {
        int gW = this.j6.v5.gW(i);
        int Hw = this.Mr.Hw() - 1;
        while (Hw >= 0) {
            if (((co) this.Mr.j6(Hw)) == null) {
                int FH = this.U2.FH(Hw);
                if (this.gn.DW(gW, FH)) {
                    int j6 = this.gn.j6(gW, FH);
                    if (this.j6.v5.J0(j6)) {
                        co we = this.j6.v5.we(j6);
                        if (FH == this.v5) {
                            this.j6.v5.j6(i, 2, j6);
                            if (this.j6.a8) {
                                this.j6.v5.DW(i, this.j6.v5.v5(j6));
                            }
                            this.j6.v5.j6(i, this.j6.v5.FH(j6));
                        } else {
                            this.j6.v5.j6(i, 3, j6);
                            this.j6.v5.j6(i, this.j6.v5.FH(j6));
                            if (this.j6.a8 && !((ha) this.j6.v5.tp().Hw()).lg(this.j6.v5, j6)) {
                                this.j6.Zo(i, "This variable must be final to be used in a local class");
                                this.j6.CU(j6);
                            }
                        }
                        this.j6.v5.j6(i, we);
                        return true;
                    }
                    if (this.j6.a8) {
                        this.j6.Hw(i, "Unknown type of variable </C>" + this.j6.v5.BT(i) + "<//C>");
                    }
                    return false;
                }
            } else {
                this.j6.EQ.j6();
                if (((bp) this.j3.j6(Hw)).j6(this.j6.v5.we(), this.j6.v5.tp(), gW, true, Mr(), this.j6.EQ) != null) {
                    if (this.j6.EQ.Hw() == 1) {
                        bs bsVar = (bz) this.j6.EQ.DW();
                        this.j6.v5.j6(i, 16, bsVar);
                        this.j6.v5.DW(i, (co) this.Mr.j6(Hw));
                        if (bsVar.Xa() == this.FH && (((!bsVar.I() && XL()) || (bsVar.I() && QX())) && bsVar.Mr())) {
                            this.j6.v5.j6(i, this.j6.v5.FH(this.j6.VH.FH(bsVar.v5())));
                        }
                        try {
                            co j62 = bsVar.j6((co) this.Mr.j6(Hw), z);
                            this.j6.QX(i, j62);
                            this.j6.v5.j6(i, j62);
                        } catch (ej e) {
                            this.j6.Hw(i, "Unknown type of field </C>" + this.j6.v5.BT(i) + "<//C>");
                        }
                        if (!this.j6.a8 || bsVar.I() || DW((co) this.j3.j6(Hw))) {
                            return true;
                        }
                        this.j6.Zo(i, "This field can not be referenced from a static-context");
                        return true;
                    }
                    this.j6.Hw(i, "Ambiguous field </C>" + this.j6.v5.BT(i) + "<//C>");
                    return false;
                }
            }
            Hw--;
        }
        return false;
    }

    public void j6(int i, co coVar, boolean z) {
        boolean z2 = true;
        int gW = this.j6.v5.gW(i);
        if (!j6(i, z)) {
            bs FH;
            co j6;
            if (this.J0.j6(gW)) {
                FH = this.J0.FH(gW);
                if (FH.zh() && ((bz) FH).u7()) {
                    co Xa = ((bz) FH).Xa();
                    this.j6.v5.DW(i, Xa);
                    try {
                        j6 = ((bz) FH).j6(Xa, z);
                        this.j6.QX(i, j6);
                        this.j6.v5.j6(i, j6);
                    } catch (ej e) {
                        this.j6.Hw(i, "Unknown type of field </C>" + this.j6.v5.BT(i) + "<//C>");
                    }
                    this.j6.v5.j6(i, 16, FH);
                    return;
                }
            }
            if (this.j6.DW.DW) {
                bs bsVar = null;
                int i2 = 0;
                while (i2 < this.J8.Hw()) {
                    bp bpVar = (bp) this.J8.j6(i2);
                    this.j6.EQ.j6();
                    if (bpVar.j6(this.j6.v5.we(), this.j6.v5.tp(), gW, true, Mr(), this.j6.EQ) != null) {
                        this.j6.EQ.j6.j6();
                        FH = bsVar;
                        while (this.j6.EQ.j6.DW()) {
                            if (((bz) this.j6.EQ.j6.FH()).I()) {
                                if (FH == null || FH == this.j6.EQ.j6.FH()) {
                                    FH = (bz) this.j6.EQ.j6.FH();
                                } else {
                                    this.j6.Hw(i, "Ambiguous field </C>" + this.j6.v5.BT(i) + "<//C>");
                                    return;
                                }
                            }
                        }
                        continue;
                    } else {
                        FH = bsVar;
                    }
                    i2++;
                    bsVar = FH;
                }
                if (bsVar != null) {
                    j6 = bsVar.Xa();
                    if (bsVar.u7()) {
                        this.j6.v5.DW(i, j6);
                        this.j6.v5.j6(i, 16, bsVar);
                        try {
                            j6 = bsVar.j6(j6, true);
                            this.j6.QX(i, j6);
                            this.j6.v5.j6(i, j6);
                            return;
                        } catch (ej e2) {
                            this.j6.Hw(i, "Unknown type of field </C>" + this.j6.v5.BT(i) + "<//C>");
                            return;
                        }
                    }
                }
            }
            if (this.j6.a8) {
                this.j6.Hw(i, "Unknown variable or field </C>" + this.j6.v5.BT(i) + "<//C>");
                this.j6.aM(i, coVar);
                this.j6.XL(i, coVar);
                gb$a gb_a = this.j6;
                if (this.a8.Hw() <= 0 || !cd.aM(this.a8.FH())) {
                    z2 = false;
                }
                gb_a.j6(i, z2, Mr(), coVar);
            }
        }
    }

    public void DW(int i, int i2, co coVar) {
        if (!j6(i, true)) {
            try {
                bs j6 = j6(i, i2, true, coVar);
                if (!j6.qp()) {
                    this.j6.v5.j6(i, (co) j6);
                }
            } catch (ej e) {
            }
        }
    }

    public bs j6(int i, int i2, boolean z, co coVar) {
        bs FH;
        co Xa;
        int i3;
        int gW;
        int max;
        bs bsVar;
        try {
            int Hw;
            int FH2;
            gW = this.j6.v5.gW(i);
            max = Math.max(0, (this.j6.v5.lg(i2) - 2) / 3);
            for (Hw = this.Mr.Hw() - 1; Hw >= 0; Hw--) {
                if (((co) this.Mr.j6(Hw)) == null) {
                    FH2 = this.U2.FH(Hw);
                    if (this.VH.DW(gW, FH2)) {
                        bsVar = (co) this.VH.j6(gW, FH2);
                        this.j6.j6(i, bsVar);
                        if (!this.j6.a8 || !bsVar.q7()) {
                            return bsVar;
                        }
                        co gn = ((cg) bsVar).gn();
                        if (this.Hw == gn) {
                            return bsVar;
                        }
                        if (this.Hw != null && FH(gn) && this.Hw.J0()) {
                            return bsVar;
                        }
                        if (this.Hw == null && FH(gn)) {
                            return bsVar;
                        }
                        this.j6.Zo(i, "This parametertype can not be referenced from a static context");
                        return bsVar;
                    }
                } else if (((bp) this.j3.j6(Hw)).j6(gW, true)) {
                    try {
                        bsVar = ((co) this.Mr.j6(Hw)).j6(gW, true, max, this.j6.gn.j3(), this.j6.v5.we(), this.j6.v5.tp());
                        this.j6.j6(i, bsVar);
                        return bsVar;
                    } catch (ej e) {
                    }
                } else {
                    continue;
                }
            }
            FH2 = this.tp.DW(gW);
            if (FH2 > 1) {
                throw new eg();
            } else if (FH2 == 1) {
                bsVar = (co) this.tp.FH(gW);
                this.j6.v5.j6(i, 8, bsVar);
                return bsVar;
            } else {
                FH2 = this.Ws.DW(gW);
                if (FH2 > 1) {
                    throw new eg();
                } else if (FH2 == 1) {
                    bsVar = (co) this.Ws.FH(gW);
                    this.j6.v5.j6(i, 17, bsVar);
                    return bsVar;
                } else {
                    if (this.J0.j6(gW)) {
                        FH = this.J0.FH(gW);
                        if (z && FH.zh()) {
                            if (((bz) FH).u7()) {
                                Xa = ((bz) FH).Xa();
                                this.j6.v5.DW(i, Xa);
                                this.j6.v5.j6(i, 16, FH);
                                Xa = ((bz) FH).j6(Xa, true);
                                this.j6.QX(i, Xa);
                                return Xa;
                            }
                        }
                        if (FH.cT()) {
                            this.j6.v5.j6(i, 8, FH);
                            return FH;
                        }
                    }
                    if (this.DW.FH(this.j6.v5.we(), this.j6.v5.tp(), gW, true, max, this.DW)) {
                        try {
                            bsVar = this.DW.DW(this.j6.v5.we(), this.j6.v5.tp(), gW, true, max, this.DW);
                            this.j6.v5.j6(i, 9, bsVar);
                            return bsVar;
                        } catch (ej e2) {
                        }
                    }
                    Hw = 0;
                    while (Hw < this.we.Hw()) {
                        if (((bp) this.we.j6(Hw)).j6(gW, true)) {
                            try {
                                bsVar = ((bp) this.we.j6(Hw)).DW(gW, true, max, j3(), this.j6.v5.we(), this.j6.v5.tp());
                                this.j6.v5.j6(i, 17, bsVar);
                                return bsVar;
                            } catch (ej e3) {
                            }
                        } else {
                            Hw++;
                        }
                    }
                    Object obj = null;
                    FH = null;
                    int i4 = 0;
                    while (i4 < this.EQ.Hw()) {
                        Object obj2;
                        if (((ce) this.EQ.j6(i4)).FH(this.j6.v5.we(), this.j6.v5.tp(), gW, true, max, this.DW)) {
                            try {
                                bsVar = ((ce) this.EQ.j6(i4)).DW(this.j6.v5.we(), this.j6.v5.tp(), gW, true, max, this.j6.gn.a8());
                                if (FH == null || FH == bsVar) {
                                    try {
                                        this.j6.v5.j6(i, 10, bsVar);
                                        obj2 = obj;
                                    } catch (ej e4) {
                                        obj2 = obj;
                                    }
                                } else if (bsVar.ye() || !FH.ye()) {
                                    try {
                                        this.j6.Hw(i, "Ambiguous imported type </C>" + this.j6.v5.BT(i) + "<//C>: </C>" + FH.iW() + "<//C> or </C>" + bsVar.iW() + "<//C>");
                                        bsVar = FH;
                                        i3 = 1;
                                    } catch (ej e5) {
                                        bsVar = FH;
                                        i3 = 1;
                                    }
                                } else {
                                    obj2 = obj;
                                }
                            } catch (ej e6) {
                                bsVar = FH;
                                obj2 = obj;
                            }
                        } else {
                            bsVar = FH;
                            obj2 = obj;
                        }
                        i4++;
                        obj = obj2;
                        FH = bsVar;
                    }
                    if (obj != null) {
                        this.j6.v5.j6(i, 0, 0);
                        throw new ej();
                    } else if (FH != null) {
                        return FH;
                    } else {
                        bsVar = this.j6.Hw.Mr().j6(this.j6.v5.we(), gW, true);
                        this.j6.v5.j6(i, 6, bsVar);
                        return bsVar;
                    }
                }
            }
        } catch (ej e7) {
            this.j6.Hw(i, "Unknown type of field </C>" + this.j6.v5.BT(i) + "<//C>");
            throw new ej();
        } catch (ej e8) {
            if (this.j6.DW.DW) {
                FH = null;
                int i5 = 0;
                while (i5 < this.J8.Hw()) {
                    bs bsVar2;
                    bp bpVar = (bp) this.J8.j6(i5);
                    this.j6.EQ.j6();
                    if (z) {
                        if (bpVar.j6(this.j6.v5.we(), this.j6.v5.tp(), gW, true, Mr(), this.j6.EQ) != null) {
                            this.j6.EQ.j6.j6();
                            bsVar2 = FH;
                            while (this.j6.EQ.j6.DW()) {
                                if (((bz) this.j6.EQ.j6.FH()).I()) {
                                    if (bsVar2 == null || bsVar2 == this.j6.EQ.j6.FH()) {
                                        bsVar2 = (bz) this.j6.EQ.j6.FH();
                                    } else {
                                        throw new eg();
                                    }
                                }
                            }
                            if (bsVar2 == null) {
                                try {
                                    bsVar = bpVar.DW(gW, true, max, this.j6.gn.a8(), this.j6.v5.we(), this.j6.v5.tp());
                                    if (bsVar.Ws()) {
                                        this.j6.v5.j6(i, 8, bsVar);
                                        return bsVar;
                                    }
                                } catch (eg e9) {
                                } catch (ej e10) {
                                }
                            }
                            i5++;
                            FH = bsVar2;
                        }
                    }
                    bsVar2 = FH;
                    if (bsVar2 == null) {
                        bsVar = bpVar.DW(gW, true, max, this.j6.gn.a8(), this.j6.v5.we(), this.j6.v5.tp());
                        if (bsVar.Ws()) {
                            this.j6.v5.j6(i, 8, bsVar);
                            return bsVar;
                        }
                    }
                    i5++;
                    FH = bsVar2;
                }
                if (FH != null) {
                    Xa = FH.Xa();
                    if (FH.u7()) {
                        this.j6.v5.DW(i, Xa);
                        this.j6.v5.j6(i, 16, FH);
                        Xa = FH.j6(Xa, true);
                        this.j6.QX(i, Xa);
                        return Xa;
                    }
                }
            }
            String str = "Unknown entity </C>" + this.j6.v5.BT(i) + "<//C>";
            i3 = this.j6.v5.lg(i2);
            if (i3 == 0) {
                i3 = 0;
            } else {
                i3 = (i3 - 1) / 2;
            }
            ec FH3 = this.j6.FH.FH(gW, i3, this.j6.v5.we(), this.j6.v5.tp());
            if (FH3.Hw() > 0) {
                FH3.j6.j6();
                while (FH3.j6.DW()) {
                    str = str + ". Maybe a reference to " + this.j6.DW.Zo.VH(FH3.j6.FH()) + " is missing";
                }
            }
            this.j6.Hw(i, str);
            if (z) {
                this.j6.j3(i, coVar);
            } else {
                this.j6.Xa(i);
            }
            throw new ej();
        } catch (ej e11) {
            this.j6.Hw(i, "Unknown type of field </C>" + this.j6.v5.BT(i) + "<//C>");
            throw new ej();
        } catch (eg e12) {
            this.j6.Hw(i, "Ambiguous type </C>" + this.j6.v5.BT(i) + "<//C>");
            throw new ej();
        }
    }
}
