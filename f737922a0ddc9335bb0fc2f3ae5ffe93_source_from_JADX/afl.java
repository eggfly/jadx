public class afl {
    static int j6;
    private int DW;

    static {
        j6 = 31;
    }

    public afl() {
        this.DW = 1;
    }

    public int j6() {
        return this.DW;
    }

    public afl j6(Object obj) {
        this.DW = (obj == null ? 0 : obj.hashCode()) + (this.DW * j6);
        return this;
    }

    public afl j6(boolean z) {
        this.DW = (z ? 1 : 0) + (this.DW * j6);
        return this;
    }
}
