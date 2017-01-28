public final class aat extends aaw {
    public static final aat DW;
    public static final aat FH;
    public static final aat Hw;
    public static final aat VH;
    public static final aat Zo;
    private static final aat[] gn;
    public static final aat j6;
    public static final aat v5;

    static {
        gn = new aat[511];
        j6 = j6(-1);
        DW = j6(0);
        FH = j6(1);
        Hw = j6(2);
        v5 = j6(3);
        Zo = j6(4);
        VH = j6(5);
    }

    public static aat j6(int i) {
        int length = (Integer.MAX_VALUE & i) % gn.length;
        aat aat = gn[length];
        if (aat != null && aat.r_() == i) {
            return aat;
        }
        aat = new aat(i);
        gn[length] = aat;
        return aat;
    }

    private aat(int i) {
        super(i);
    }

    public String toString() {
        int tp = tp();
        return "int{0x" + add.j6(tp) + " / " + tp + '}';
    }

    public abl j6() {
        return abl.Zo;
    }

    public String gn() {
        return "int";
    }

    public String Hw() {
        return Integer.toString(tp());
    }

    public int r_() {
        return tp();
    }
}
