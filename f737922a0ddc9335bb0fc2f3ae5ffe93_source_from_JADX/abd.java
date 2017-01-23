public final class abd extends aaw {
    public static final abd j6;

    static {
        j6 = j6((short) 0);
    }

    public static abd j6(short s) {
        return new abd(s);
    }

    public static abd j6(int i) {
        short s = (short) i;
        if (s == i) {
            return j6(s);
        }
        throw new IllegalArgumentException("bogus short value: " + i);
    }

    private abd(short s) {
        super(s);
    }

    public String toString() {
        int tp = tp();
        return "short{0x" + add.FH(tp) + " / " + tp + '}';
    }

    public abl j6() {
        return abl.gn;
    }

    public String gn() {
        return "short";
    }

    public String Hw() {
        return Integer.toString(tp());
    }
}
