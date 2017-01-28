public final class aas extends aaw {
    public static final aas DW;
    public static final aas FH;
    public static final aas j6;

    static {
        j6 = j6(Float.floatToIntBits(0.0f));
        DW = j6(Float.floatToIntBits(1.0f));
        FH = j6(Float.floatToIntBits(2.0f));
    }

    public static aas j6(int i) {
        return new aas(i);
    }

    private aas(int i) {
        super(i);
    }

    public String toString() {
        int tp = tp();
        return "float{0x" + add.j6(tp) + " / " + Float.intBitsToFloat(tp) + '}';
    }

    public abl j6() {
        return abl.v5;
    }

    public String gn() {
        return "float";
    }

    public String Hw() {
        return Float.toString(Float.intBitsToFloat(tp()));
    }
}
