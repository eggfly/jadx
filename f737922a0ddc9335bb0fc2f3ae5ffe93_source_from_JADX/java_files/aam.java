public final class aam extends aaw {
    public static final aam DW;
    public static final aam j6;

    static {
        j6 = new aam(false);
        DW = new aam(true);
    }

    public static aam j6(int i) {
        if (i == 0) {
            return j6;
        }
        if (i == 1) {
            return DW;
        }
        throw new IllegalArgumentException("bogus value: " + i);
    }

    private aam(boolean z) {
        super(z ? 1 : 0);
    }

    public String toString() {
        return q_() ? "boolean{true}" : "boolean{false}";
    }

    public abl j6() {
        return abl.j6;
    }

    public String gn() {
        return "boolean";
    }

    public String Hw() {
        return q_() ? "true" : "false";
    }

    public boolean q_() {
        return tp() != 0;
    }
}
