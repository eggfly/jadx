public class cp {
    private final bj DW;
    private final int FH;
    private final int Hw;
    private final co VH;
    private final int Zo;
    private final bv j6;
    private final int v5;

    public cp(bv bvVar, bj bjVar, int i, int i2, int i3, int i4, co coVar) {
        this.j6 = bvVar;
        this.DW = bjVar;
        this.FH = i;
        this.Hw = i2;
        this.v5 = i3;
        this.Zo = i4;
        this.VH = coVar;
    }

    public bj j6() {
        return this.DW;
    }

    public String DW() {
        if (this.DW.gn() != null) {
            return this.DW.gn().j6(this);
        }
        return "";
    }

    public bv FH() {
        return this.j6;
    }

    public int Hw() {
        return this.FH;
    }

    public int v5() {
        return this.Hw;
    }

    public int Zo() {
        return this.v5;
    }

    public int VH() {
        return this.Zo;
    }

    public co gn() {
        return this.VH;
    }
}
