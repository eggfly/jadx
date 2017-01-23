public class rv$a {
    private final int DW;
    private final int FH;
    private final abf Hw;
    private final int j6;

    public rv$a(int i, int i2, int i3, abf abf) {
        if (i < 0) {
            throw new IllegalArgumentException("startPc < 0");
        } else if (i2 < i) {
            throw new IllegalArgumentException("endPc < startPc");
        } else if (i3 < 0) {
            throw new IllegalArgumentException("handlerPc < 0");
        } else {
            this.j6 = i;
            this.DW = i2;
            this.FH = i3;
            this.Hw = abf;
        }
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public int FH() {
        return this.FH;
    }

    public abf Hw() {
        return this.Hw != null ? this.Hw : abf.j6;
    }

    public boolean j6(int i) {
        return i >= this.j6 && i < this.DW;
    }
}
