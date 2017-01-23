final class apm$a {
    final aqc[] DW;
    int FH;
    int Hw;
    apm$a j6;

    apm$a() {
        this.DW = new aqc[256];
    }

    boolean j6() {
        return this.Hw == 256;
    }

    boolean DW() {
        return this.FH == this.Hw;
    }

    boolean FH() {
        return this.FH > 0;
    }

    void j6(aqc aqc) {
        aqc[] aqcArr = this.DW;
        int i = this.Hw;
        this.Hw = i + 1;
        aqcArr[i] = aqc;
    }

    void DW(aqc aqc) {
        aqc[] aqcArr = this.DW;
        int i = this.FH - 1;
        this.FH = i;
        aqcArr[i] = aqc;
    }

    aqc Hw() {
        aqc[] aqcArr = this.DW;
        int i = this.FH;
        this.FH = i + 1;
        return aqcArr[i];
    }

    void v5() {
        this.j6 = null;
        this.FH = 0;
        this.Hw = 0;
    }

    void Zo() {
        this.Hw = 128;
        this.FH = 128;
    }

    void VH() {
        this.Hw = 256;
        this.FH = 256;
    }
}
