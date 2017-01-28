public final class aaa {
    private final int DW;
    private adg[] FH;
    private adg Hw;
    private final zj j6;

    public aaa(zj zjVar, int i) {
        if (zjVar == null) {
            throw new NullPointerException("blocks == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("firstLabel < 0");
        } else {
            this.j6 = zjVar;
            this.DW = i;
            this.FH = null;
            this.Hw = null;
        }
    }

    public zj j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public adg j6(int i) {
        if (this.Hw == null) {
            FH();
        }
        adg adg = this.FH[i];
        if (adg != null) {
            return adg;
        }
        throw new RuntimeException("no such block: " + add.FH(i));
    }

    private void FH() {
        int tp = this.j6.tp();
        adg[] adgArr = new adg[tp];
        adg adg = new adg(10);
        int m_ = this.j6.m_();
        for (int i = 0; i < m_; i++) {
            zi j6 = this.j6.j6(i);
            int j62 = j6.j6();
            adg FH = j6.FH();
            int DW = FH.DW();
            if (DW == 0) {
                adg.FH(j62);
            } else {
                for (int i2 = 0; i2 < DW; i2++) {
                    int DW2 = FH.DW(i2);
                    adg adg2 = adgArr[DW2];
                    if (adg2 == null) {
                        adg2 = new adg(10);
                        adgArr[DW2] = adg2;
                    }
                    adg2.FH(j62);
                }
            }
        }
        for (int i3 = 0; i3 < tp; i3++) {
            adg adg3 = adgArr[i3];
            if (adg3 != null) {
                adg3.VH();
                adg3.l_();
            }
        }
        adg.VH();
        adg.l_();
        if (adgArr[this.DW] == null) {
            adgArr[this.DW] = adg.j6;
        }
        this.FH = adgArr;
        this.Hw = adg;
    }
}
