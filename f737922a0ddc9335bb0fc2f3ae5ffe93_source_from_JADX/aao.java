public final class aao extends aaw {
    public static final aao j6;

    static {
        j6 = j6('\u0000');
    }

    public static aao j6(char c) {
        return new aao(c);
    }

    public static aao j6(int i) {
        char c = (char) i;
        if (c == i) {
            return j6(c);
        }
        throw new IllegalArgumentException("bogus char value: " + i);
    }

    private aao(char c) {
        super(c);
    }

    public String toString() {
        int tp = tp();
        return "char{0x" + add.FH(tp) + " / " + tp + '}';
    }

    public abl j6() {
        return abl.FH;
    }

    public String gn() {
        return "char";
    }

    public String Hw() {
        return Integer.toString(tp());
    }
}
