public class fs {
    private dt DW;
    private cc FH;
    private cj Hw;
    private ec VH;
    private ec Zo;
    private ec gn;
    private dt j6;
    private ec u7;
    private boolean v5;

    public fs(cc ccVar, cj cjVar, boolean z) {
        this.j6 = new dt();
        this.DW = new dt();
        this.Zo = new ec();
        this.VH = new ec();
        this.gn = new ec();
        this.u7 = new ec();
        this.FH = ccVar;
        this.Hw = cjVar;
        this.v5 = z;
        j6();
        this.Hw = null;
    }

    public void j6(ec ecVar) {
        this.u7.j6();
        this.u7.j6(this.gn);
        this.gn.j6.j6();
        while (this.gn.j6.DW()) {
            int FH = this.gn.j6.FH();
            if (this.VH.FH(FH)) {
                j6(FH);
            }
        }
        if (!this.v5) {
            this.u7.j6.j6();
            while (this.u7.j6.DW()) {
                ecVar.j6(this.FH.ro.Hw(this.u7.j6.FH()));
            }
        }
    }

    public void j6(int i, ec ecVar) {
        int i2;
        this.u7.j6();
        if (this.v5) {
            i2 = i;
        } else {
            i2 = this.FH.ro.FH(i);
        }
        j6(i2);
        if (this.v5 || i == this.FH.ro.FH(i)) {
            ecVar.j6(this.u7);
            return;
        }
        this.u7.j6.j6();
        while (this.u7.j6.DW()) {
            ecVar.j6(this.FH.ro.Hw(this.u7.j6.FH()));
        }
    }

    public void DW(int i, ec ecVar) {
        this.u7.j6();
        dt$a j6 = this.DW.j6();
        j6.j6(this.v5 ? i : this.FH.ro.FH(i));
        while (j6.DW()) {
            this.u7.j6(j6.Hw());
        }
        if (this.v5 || i == this.FH.ro.FH(i)) {
            ecVar.j6(this.u7);
            return;
        }
        this.u7.j6.j6();
        while (this.u7.j6.DW()) {
            ecVar.j6(this.FH.ro.Hw(this.u7.j6.FH()));
        }
    }

    private void j6() {
        DW(this.Hw.Ws());
        this.j6.j6.j6();
        ec ecVar = new ec();
        while (this.j6.j6.DW()) {
            this.gn.j6(this.j6.j6.FH());
            ecVar.j6(this.j6.j6.Hw());
        }
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            this.gn.DW(ecVar.j6.FH());
        }
    }

    private void j6(int i) {
        dt$a j6 = this.j6.j6();
        j6.j6(i);
        while (j6.DW()) {
            int Hw = j6.Hw();
            if (!this.VH.FH(Hw) || this.u7.FH(Hw)) {
                this.u7.j6(Hw);
            } else {
                this.u7.j6(Hw);
                j6(Hw);
            }
        }
    }

    private void DW(int i) {
        int i2 = 2;
        switch (this.Hw.rN(i)) {
            case 207:
                this.Zo.j6();
                FH(this.Hw.Hw(i, 1));
                Hw(this.Hw.Hw(i, 2));
                break;
            case 208:
                this.Zo.j6();
                FH(this.Hw.Hw(i, 1));
                Hw(this.Hw.Hw(i, 4));
                if (this.Hw.lg(i) > 6) {
                    switch (this.Hw.rN(this.Hw.Hw(i, this.Hw.lg(i) - 3))) {
                        case 22:
                            v5(this.Hw.Hw(i, this.Hw.lg(i) - 2));
                            break;
                        case 37:
                            Hw(this.Hw.Hw(i, this.Hw.lg(i) - 2));
                            break;
                    }
                }
                if (this.Hw.rN(this.Hw.Hw(i, 2)) == 30 && this.Hw.rN(this.Hw.Hw(i, 3)) == 30) {
                    if (!this.v5) {
                        this.Zo.j6.j6();
                        while (this.Zo.j6.DW()) {
                            this.VH.j6(this.FH.ro.FH(this.Zo.j6.FH()));
                        }
                        break;
                    }
                    this.VH.j6(this.Zo);
                    break;
                }
            case 215:
                this.Zo.j6();
                FH(this.Hw.Hw(i, 1));
                while (i2 < this.Hw.lg(i) - 1) {
                    int gW = this.Hw.gW(this.Hw.Hw(this.Hw.Hw(i, i2), 0));
                    this.Zo.j6.j6();
                    while (this.Zo.j6.DW()) {
                        int FH = this.Zo.j6.FH();
                        if (this.v5) {
                            this.DW.DW(FH, gW);
                        } else {
                            this.DW.DW(this.FH.ro.FH(FH), this.FH.ro.FH(gW));
                        }
                    }
                    i2++;
                }
                break;
        }
        for (i2 = 0; i2 < this.Hw.lg(i); i2++) {
            DW(this.Hw.Hw(i, i2));
        }
    }

    private void FH(int i) {
        if (this.Hw.rN(i) == 30) {
            this.Zo.j6(this.Hw.gW(i));
            return;
        }
        for (int i2 = 0; i2 < this.Hw.lg(i); i2++) {
            FH(this.Hw.Hw(i, i2));
        }
    }

    private void Hw(int i) {
        int FH;
        if (this.Hw.rN(i) == 30) {
            this.Zo.j6.j6();
            while (this.Zo.j6.DW()) {
                FH = this.Zo.j6.FH();
                if (this.v5) {
                    this.j6.DW(FH, this.Hw.gW(i));
                } else {
                    this.j6.DW(this.FH.ro.FH(FH), this.FH.ro.FH(this.Hw.gW(i)));
                }
            }
            return;
        }
        for (FH = 0; FH < this.Hw.lg(i); FH++) {
            Hw(this.Hw.Hw(i, FH));
        }
    }

    private void v5(int i) {
        int FH;
        if (this.Hw.rN(i) == 30) {
            this.Zo.j6.j6();
            while (this.Zo.j6.DW()) {
                FH = this.Zo.j6.FH();
                if (this.v5) {
                    this.j6.FH(FH, this.Hw.gW(i));
                } else {
                    this.j6.FH(this.FH.ro.FH(FH), this.FH.ro.FH(this.Hw.gW(i)));
                }
            }
            return;
        }
        for (FH = 0; FH < this.Hw.lg(i); FH++) {
            v5(this.Hw.Hw(i, FH));
        }
    }
}
