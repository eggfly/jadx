public final class rt implements adi {
    private final int DW;
    private final int FH;
    private final adg Hw;
    private final int j6;
    private final rv v5;

    public rt(int i, int i2, int i3, adg adg, rv rvVar) {
        if (i < 0) {
            throw new IllegalArgumentException("label < 0");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("start < 0");
        } else if (i3 <= i2) {
            throw new IllegalArgumentException("end <= start");
        } else if (adg == null) {
            throw new NullPointerException("targets == null");
        } else {
            int DW = adg.DW();
            for (int i4 = 0; i4 < DW; i4++) {
                if (adg.DW(i4) < 0) {
                    throw new IllegalArgumentException("successors[" + i4 + "] == " + adg.DW(i4));
                }
            }
            if (rvVar == null) {
                throw new NullPointerException("catches == null");
            }
            this.j6 = i;
            this.DW = i2;
            this.FH = i3;
            this.Hw = adg;
            this.v5 = rvVar;
        }
    }

    public String toString() {
        return '{' + add.FH(this.j6) + ": " + add.FH(this.DW) + ".." + add.FH(this.FH) + '}';
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public int FH() {
        return this.FH;
    }

    public adg Hw() {
        return this.Hw;
    }

    public rv v5() {
        return this.v5;
    }
}
