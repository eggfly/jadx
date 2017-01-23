public abstract class aiu<C extends aie, T> extends aie<T> {
    protected atn DW;
    protected int FH;
    protected aiv Hw;

    protected aiu(aoh aoh) {
        super(aoh);
    }

    public C j6(atn atn) {
        this.DW = atn;
        return FH();
    }

    public C j6(int i) {
        this.FH = i;
        return FH();
    }

    public C j6(aiv aiv) {
        this.Hw = aiv;
        return FH();
    }

    protected final C FH() {
        return this;
    }

    protected C j6(avd avd) {
        if (this.DW != null) {
            avd.j6(this.DW);
        }
        avd.j6(this.FH);
        if (this.Hw != null) {
            this.Hw.j6(avd);
        }
        return FH();
    }

    protected C j6(aiu aiu) {
        aiu.j6(this.DW);
        aiu.j6(this.FH);
        aiu.j6(this.Hw);
        return FH();
    }
}
