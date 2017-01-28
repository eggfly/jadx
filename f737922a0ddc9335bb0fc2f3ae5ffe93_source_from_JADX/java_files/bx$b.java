class bx$b {
    private dg DW;
    private dy FH;
    private dy Hw;
    private int VH;
    private int Zo;
    private int gn;
    private dj<dj<do>> j6;
    private int v5;

    public bx$b(cc ccVar) {
        this.j6 = new dj();
        this.DW = new dg();
        this.FH = new dy();
        this.Hw = new dy();
        this.v5 = ccVar.ro.j6("prototype");
        this.Zo = ccVar.ro.j6("()");
        this.gn = ccVar.ro.j6("function");
        this.VH = ccVar.ro.j6("[]");
    }

    public void j6(bx$a bx_a) {
        System.currentTimeMillis();
        this.FH.j6();
        this.FH.j6(bx_a.Hw());
        this.j6.j6();
        this.DW.j6();
        this.DW.j6(bx_a.FH());
        this.DW.j6.j6();
        while (this.DW.j6.DW()) {
            int Hw = this.DW.j6.Hw();
            int FH = this.DW.j6.FH();
            if (!this.j6.j6(Hw)) {
                this.j6.j6(Hw, new dj());
            }
            dj djVar = (dj) this.j6.FH(Hw);
            int EQ = bx_a.EQ(FH);
            j6(djVar, FH, EQ, bx_a);
            if (!djVar.j6(EQ)) {
                djVar.j6(EQ, new do());
            }
            ((do) djVar.FH(EQ)).DW(FH);
        }
        Object obj;
        do {
            this.Hw.j6();
            this.Hw.j6(this.FH);
            this.FH.j6();
            this.Hw.j6.j6();
            obj = null;
            while (this.Hw.j6.DW()) {
                int FH2 = this.DW.FH(this.Hw.j6.FH());
                int FH3 = this.DW.FH(this.Hw.j6.Hw());
                if (!(FH2 == FH3 || FH2 == -1 || FH3 == -1)) {
                    int FH4;
                    do doVar;
                    djVar = (dj) this.j6.FH(FH2);
                    dj djVar2 = (dj) this.j6.FH(FH3);
                    djVar.j6.j6();
                    while (djVar.j6.DW()) {
                        FH4 = djVar.j6.FH();
                        doVar = (do) djVar.j6.Hw();
                        for (int i = 0; i < doVar.Hw(); i++) {
                            j6(djVar2, doVar.FH(i), FH4, bx_a);
                        }
                    }
                    djVar.j6.j6();
                    while (djVar.j6.DW()) {
                        EQ = djVar.j6.FH();
                        if (!djVar2.j6(EQ)) {
                            djVar2.j6(EQ, new do());
                        }
                        doVar = (do) djVar2.FH(EQ);
                        do doVar2 = (do) djVar.j6.Hw();
                        for (FH4 = 0; FH4 < doVar2.Hw(); FH4++) {
                            int FH5 = doVar2.FH(FH4);
                            doVar.DW(FH5);
                            this.DW.j6(FH5, FH3);
                        }
                    }
                    this.j6.DW(FH2);
                    obj = 1;
                }
            }
        } while (obj != null);
        bx_a.j6(this.DW);
    }

    private void j6(dj<do> djVar, int i, int i2, bx$a bx_a) {
        do doVar;
        int i3;
        int i4 = 0;
        if (!(i2 == -1 || i2 == this.gn)) {
            doVar = (do) djVar.FH(i2);
            if (doVar != null) {
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    this.FH.DW(bx_a.VH(i), bx_a.VH(doVar.FH(i3)));
                }
            }
        }
        if (i2 == this.Zo) {
            doVar = (do) djVar.FH(this.gn);
            if (doVar != null) {
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    DW(doVar.FH(i3), i, bx_a);
                }
            }
        }
        if (i2 == this.gn) {
            doVar = (do) djVar.FH(this.Zo);
            if (doVar != null) {
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    DW(i, doVar.FH(i3), bx_a);
                }
            }
        }
        if (i2 == this.v5) {
            doVar = (do) djVar.FH(this.gn);
            if (doVar != null) {
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    j6(doVar.FH(i3), i, bx_a);
                }
            }
        }
        if (i2 == this.gn) {
            doVar = (do) djVar.FH(this.v5);
            if (doVar != null) {
                while (i4 < doVar.Hw()) {
                    j6(i, doVar.FH(i4), bx_a);
                    i4++;
                }
            }
        }
    }

    private void j6(int i, int i2, bx$a bx_a) {
        this.FH.DW(bx_a.Zo(i), bx_a.VH(i2));
    }

    private void DW(int i, int i2, bx$a bx_a) {
        int i3;
        int i4 = 0;
        int v5 = bx_a.v5(i);
        for (i3 = 0; i3 < v5; i3++) {
            this.FH.j6(bx_a.FH(i2), bx_a.v5(i, i3));
        }
        i3 = Math.min(bx_a.Hw(i), bx_a.DW(i2));
        while (i4 < i3) {
            this.FH.j6(bx_a.Hw(i, i4), bx_a.FH(i2, i4));
            i4++;
        }
        if (bx_a.j6(i2) != -1) {
            this.FH.j6(bx_a.j6(i2), bx_a.Zo(i));
        }
    }
}
