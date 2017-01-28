public abstract class aal extends aba {
    private abj DW;
    private final abj j6;

    aal(abf abf, abc abc) {
        super(abf, abc);
        this.j6 = abj.j6(J8().DW().tp());
        this.DW = null;
    }

    public final abj u7() {
        return this.j6;
    }

    public final abj j6(boolean z) {
        if (z) {
            return this.j6;
        }
        if (this.DW == null) {
            this.DW = this.j6.j6(J0().u7());
        }
        return this.DW;
    }

    protected final int DW(aah aah) {
        int DW = super.DW(aah);
        if (DW != 0) {
            return DW;
        }
        return this.j6.j6(((aal) aah).j6);
    }

    public final abl j6() {
        return this.j6.DW();
    }

    public final int DW(boolean z) {
        return j6(z).FH().v5();
    }

    public final boolean tp() {
        return J8().v5();
    }

    public final boolean EQ() {
        return J8().Zo();
    }
}
