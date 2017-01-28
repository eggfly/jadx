public class sb$a {
    private final int DW;
    private final int j6;

    public sb$a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("startPc < 0");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("lineNumber < 0");
        } else {
            this.j6 = i;
            this.DW = i2;
        }
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }
}
