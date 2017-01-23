class apa$a extends apc {
    private final awb VH;
    private final ako gn;
    private ans tp;
    private akq u7;

    apa$a(aoh aoh) {
        super(aoh);
        this.VH = new awb(this.DW);
        this.gn = ako.j6();
    }

    protected boolean FH() {
        this.VH.j6(u7());
        this.VH.DW(this.Zo[0]);
        this.VH.DW(this.Zo[1]);
        this.u7 = this.gn.DW();
        boolean z = false;
        while (this.VH.EQ()) {
            int j6 = this.VH.j6(1);
            int j62 = this.VH.j6(2);
            if (j6 == j62 && this.VH.j6(1, 2)) {
                FH(1, 0);
            } else {
                int j63 = this.VH.j6(0);
                if (j63 == j6 && this.VH.j6(0, 1)) {
                    FH(2, 0);
                } else if (j63 == j62 && this.VH.j6(0, 2)) {
                    FH(1, 0);
                } else {
                    if (j6(j63)) {
                        FH(0, 1);
                        z = true;
                    }
                    if (j6(j6)) {
                        FH(1, 2);
                        z = true;
                    }
                    if (j6(j62)) {
                        FH(2, 3);
                        z = true;
                    }
                    if (this.VH.Ws()) {
                        this.VH.QX();
                    }
                }
            }
        }
        this.u7.DW();
        this.u7 = null;
        if (z) {
            return false;
        }
        try {
            anw DW = DW();
            this.tp = this.gn.j6(DW);
            DW.FH();
            return true;
        } catch (amc e) {
            this.tp = null;
            return false;
        }
    }

    private static boolean j6(int i) {
        return (i == 0 || anl.j6.DW(i)) ? false : true;
    }

    private void FH(int i, int i2) {
        avx DW = DW(i);
        if (DW == null) {
            return;
        }
        if (anl.j6.DW(this.VH.j6(i))) {
            this.u7.j6(this.VH.J0(), i2, this.DW, this.VH.FH(i));
            return;
        }
        akt akt = new akt(this.VH.J0(), i2);
        akt.j6(DW.v5(), DW.Zo());
        akt.j6(this.VH.DW(i));
        this.u7.DW(akt);
    }

    private avx DW(int i) {
        return this.VH.j6(i, avx.class);
    }

    public ans Hw() {
        return this.tp;
    }
}
