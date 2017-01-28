class gz$a$a {
    private ce DW;
    private dm<bp> EQ;
    private bp FH;
    private int Hw;
    private do J0;
    private do J8;
    private dm<ce> VH;
    private dr<bp> Zo;
    private dm<bp> gn;
    final /* synthetic */ gz$a j6;
    private dm<bp> tp;
    private dr<bs> u7;
    private dk<co> v5;
    private dm<co> we;

    public gz$a$a(gz$a gz_a, bt btVar) {
        this.j6 = gz_a;
        this.v5 = new dk(btVar);
        this.Zo = new dr(btVar);
        this.VH = new dm(btVar);
        this.gn = new dm(btVar);
        this.u7 = new dr(btVar);
        this.tp = new dm(btVar);
        this.EQ = new dm(btVar);
        this.we = new dm(btVar);
        this.J0 = new do();
        this.J8 = new do();
    }

    public void j6() {
        this.Hw = 0;
        this.FH = null;
        this.DW = null;
        this.Zo.DW();
        this.VH.j6();
        this.gn.j6();
        this.u7.DW();
        this.tp.j6();
        this.J0.j6();
        this.EQ.j6();
        this.we.j6();
        this.J8.j6();
    }

    public void j6(ce ceVar) {
        this.DW = ceVar;
    }

    public void j6(bp bpVar) {
        this.FH = bpVar;
        this.EQ.DW((bs) bpVar);
        this.we.DW(bpVar.j3());
        this.J0.j6(-1);
    }

    public void DW() {
        this.J0.DW();
        this.EQ.DW();
        this.we.DW();
        int Hw = this.EQ.Hw() - 1;
        while (Hw >= 0 && this.EQ.j6(Hw) == null) {
            Hw--;
        }
        if (Hw >= 0) {
            this.FH = (bp) this.EQ.j6(Hw);
        } else {
            this.FH = null;
        }
    }

    public void FH() {
        u7();
        this.EQ.DW(null);
        this.we.DW(null);
        do doVar = this.J0;
        int i = this.Hw + 1;
        this.Hw = i;
        doVar.j6(i);
    }

    public void Hw() {
        this.J0.DW();
        this.EQ.DW();
        this.we.DW();
        this.Hw--;
        tp();
    }

    public void j6(int i) {
        this.J8.j6(i);
    }

    public void v5() {
        this.J8.DW();
    }

    public boolean Zo() {
        return cd.aM(this.J8.FH());
    }

    public void VH() {
        u7();
        this.EQ.DW(null);
        this.we.DW(null);
        do doVar = this.J0;
        int i = this.Hw + 1;
        this.Hw = i;
        doVar.j6(i);
    }

    public void gn() {
        this.J0.DW();
        this.EQ.DW();
        this.we.DW();
        this.Hw--;
        tp();
    }

    public void u7() {
        this.v5.DW();
    }

    public void tp() {
        this.v5.FH();
    }

    public void j6(int i, bp bpVar) {
        if (!this.v5.DW(i, this.Hw)) {
            this.v5.j6(i, bpVar, this.Hw);
        }
    }

    public void DW(int i, bp bpVar) {
        if (!this.v5.DW(i, this.Hw)) {
            this.v5.j6(i, bpVar.j3(), this.Hw);
        }
    }

    public void j6(int i, co coVar) {
        if (!this.v5.DW(i, this.Hw)) {
            this.v5.j6(i, coVar, this.Hw);
        }
    }

    public void DW(ce ceVar) {
        this.VH.FH(ceVar);
    }

    public void DW(bp bpVar) {
        this.tp.FH(bpVar);
    }

    public void FH(bp bpVar) {
        this.gn.FH(bpVar);
    }

    public void FH(int i, bp bpVar) {
        if (!this.Zo.j6(i)) {
            this.Zo.j6(i, (bs) bpVar);
        }
    }

    public void j6(int i, bs bsVar) {
        if (!this.u7.j6(i)) {
            this.u7.j6(i, bsVar);
        }
    }

    public void Hw(int i, bp bpVar) {
        if (!this.Zo.j6(i)) {
            this.Zo.j6(i, (bs) bpVar);
        }
    }

    public bs EQ() {
        if (this.FH != null) {
            return this.FH;
        }
        return this.DW;
    }

    public bp we() {
        return this.FH;
    }

    public ce J0() {
        return this.DW;
    }

    public bs j6(int i, int i2) {
        for (int Hw = this.we.Hw() - 1; Hw >= 0; Hw--) {
            if (((co) this.we.j6(Hw)) == null) {
                int FH = this.J0.FH(Hw);
                if (this.v5.DW(i, FH)) {
                    return this.v5.j6(i, FH);
                }
            } else if (((bp) this.EQ.j6(Hw)).j6(i, true)) {
                try {
                    return ((co) this.we.j6(Hw)).j6(i, true, i2, this.j6.j6.EQ(), this.j6.FH.we(), this.j6.FH.tp());
                } catch (ej e) {
                }
            } else {
                continue;
            }
        }
        return FH(i, i2);
    }

    public bs DW(int i, int i2) {
        for (int Hw = this.EQ.Hw() - 1; Hw >= 0; Hw--) {
            if (((bp) this.EQ.j6(Hw)) == null) {
                int FH = this.J0.FH(Hw);
                if (this.v5.DW(i, FH)) {
                    return this.v5.j6(i, FH);
                }
            } else if (((bp) this.EQ.j6(Hw)).j6(i, true)) {
                try {
                    return ((bp) this.EQ.j6(Hw)).DW(i, true, i2, we(), this.j6.FH.we(), this.j6.FH.tp());
                } catch (ej e) {
                }
            } else {
                continue;
            }
        }
        return FH(i, i2);
    }

    public bs FH(int i, int i2) {
        int DW = this.Zo.DW(i);
        if (DW == 1) {
            return this.Zo.FH(i);
        }
        if (DW > 1) {
            throw new eg();
        }
        bs FH;
        if (this.u7.j6(i)) {
            FH = this.u7.FH(i);
            if (FH.cT()) {
                return FH;
            }
        }
        if (this.DW.FH(this.j6.FH.we(), this.j6.FH.tp(), i, true, i2, this.DW)) {
            try {
                return this.DW.DW(this.j6.FH.we(), this.j6.FH.tp(), i, true, i2, this.DW);
            } catch (ej e) {
            }
        }
        int i3 = 0;
        while (i3 < this.gn.Hw()) {
            if (((bp) this.gn.j6(i3)).j6(i, true)) {
                try {
                    return ((bp) this.gn.j6(i3)).DW(i, true, i2, EQ(), this.j6.FH.we(), this.j6.FH.tp());
                } catch (ej e2) {
                }
            } else {
                i3++;
            }
        }
        FH = null;
        int i4 = 0;
        while (i4 < this.VH.Hw()) {
            bs DW2;
            if (((ce) this.VH.j6(i4)).FH(this.j6.FH.we(), this.j6.FH.tp(), i, true, i2, this.DW)) {
                try {
                    DW2 = ((ce) this.VH.j6(i4)).DW(this.j6.FH.we(), this.j6.FH.tp(), i, true, i2, this.DW);
                } catch (ej e3) {
                    DW2 = FH;
                }
            } else {
                DW2 = FH;
            }
            i4++;
            FH = DW2;
        }
        if (FH != null) {
            return FH;
        }
        try {
            return this.j6.v5.Mr().j6(this.j6.FH.we(), i, true);
        } catch (ej e4) {
            i3 = 0;
            while (i3 < this.tp.Hw()) {
                bp bpVar = (bp) this.tp.j6(i3);
                try {
                    DW2 = bpVar.DW(i, true, i2, this.j6.j6.J0(), this.j6.FH.we(), this.j6.FH.tp());
                    if (DW2.Ws()) {
                        return DW2;
                    }
                    i3++;
                } catch (eg e5) {
                } catch (ej e6) {
                }
            }
            throw new ej();
        }
    }
}
