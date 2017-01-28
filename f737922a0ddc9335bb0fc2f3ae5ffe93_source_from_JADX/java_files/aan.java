public final class aan extends aaw {
    public static final aan j6;

    static {
        j6 = j6((byte) 0);
    }

    public static aan j6(byte b) {
        return new aan(b);
    }

    public static aan j6(int i) {
        byte b = (byte) i;
        if (b == i) {
            return j6(b);
        }
        throw new IllegalArgumentException("bogus byte value: " + i);
    }

    private aan(byte b) {
        super(b);
    }

    public String toString() {
        int tp = tp();
        return "byte{0x" + add.v5(tp) + " / " + tp + '}';
    }

    public abl j6() {
        return abl.DW;
    }

    public String gn() {
        return "byte";
    }

    public String Hw() {
        return Integer.toString(tp());
    }
}
