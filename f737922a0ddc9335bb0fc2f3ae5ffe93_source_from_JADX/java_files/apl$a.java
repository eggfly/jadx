final class apl$a {
    final aqg[] DW;
    int FH;
    int Hw;
    apl$a j6;

    apl$a() {
        this.DW = new aqg[256];
    }

    boolean j6() {
        return this.Hw == 256;
    }

    boolean DW() {
        return this.FH == this.Hw;
    }

    void j6(aqg aqg) {
        aqg[] aqgArr = this.DW;
        int i = this.Hw;
        this.Hw = i + 1;
        aqgArr[i] = aqg;
    }

    aqg FH() {
        aqg[] aqgArr = this.DW;
        int i = this.FH;
        this.FH = i + 1;
        return aqgArr[i];
    }

    void Hw() {
        this.j6 = null;
        this.FH = 0;
        this.Hw = 0;
    }
}
