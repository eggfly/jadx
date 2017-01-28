public class ut$a {
    private final aac DW;
    private final int j6;

    public ut$a(int i, aac aac) {
        if (i < 0) {
            throw new IllegalArgumentException("address < 0");
        } else if (aac == null) {
            throw new NullPointerException("position == null");
        } else {
            this.j6 = i;
            this.DW = aac;
        }
    }

    public int j6() {
        return this.j6;
    }

    public aac DW() {
        return this.DW;
    }
}
