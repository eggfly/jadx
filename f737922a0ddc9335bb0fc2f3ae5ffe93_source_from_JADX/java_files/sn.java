public final class sn extends adm {
    private final adg DW;
    private int FH;
    private final adg j6;

    public sn(int i) {
        super(true);
        this.j6 = new adg(i);
        this.DW = new adg(i + 1);
        this.FH = i;
    }

    public void l_() {
        this.j6.l_();
        this.DW.l_();
        super.l_();
    }

    public int j6() {
        return this.FH;
    }

    public int j6(int i) {
        return this.j6.DW(i);
    }

    public int DW(int i) {
        return this.DW.DW(i);
    }

    public int DW() {
        return this.DW.DW(this.FH);
    }

    public adg Hw() {
        return this.DW;
    }

    public adg v5() {
        return this.j6;
    }

    public void FH(int i) {
        we();
        if (i < 0) {
            throw new IllegalArgumentException("target < 0");
        } else if (this.DW.DW() != this.FH) {
            throw new RuntimeException("non-default elements not all set");
        } else {
            this.DW.FH(i);
        }
    }

    public void j6(int i, int i2) {
        we();
        if (i2 < 0) {
            throw new IllegalArgumentException("target < 0");
        }
        this.j6.FH(i);
        this.DW.FH(i2);
    }

    public void Zo() {
        int i = 0;
        we();
        int i2 = this.FH;
        if (i2 != this.DW.DW() - 1) {
            throw new IllegalArgumentException("incomplete instance");
        }
        int DW = this.DW.DW(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int DW2 = this.DW.DW(i3);
            if (DW2 != DW) {
                if (i3 != i) {
                    this.DW.DW(i, DW2);
                    this.j6.DW(i, this.j6.DW(i3));
                }
                i++;
            }
        }
        if (i != i2) {
            this.j6.v5(i);
            this.DW.DW(i, DW);
            this.DW.v5(i + 1);
            this.FH = i;
        }
    }
}
