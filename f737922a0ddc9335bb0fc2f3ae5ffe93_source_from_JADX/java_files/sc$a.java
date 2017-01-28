public class sc$a {
    private final int DW;
    private final abe FH;
    private final abe Hw;
    private final int Zo;
    private final int j6;
    private final abe v5;

    public sc$a(int i, int i2, abe abe, abe abe2, abe abe3, int i3) {
        if (i < 0) {
            throw new IllegalArgumentException("startPc < 0");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("length < 0");
        } else if (abe == null) {
            throw new NullPointerException("name == null");
        } else if (abe2 == null && abe3 == null) {
            throw new NullPointerException("(descriptor == null) && (signature == null)");
        } else if (i3 < 0) {
            throw new IllegalArgumentException("index < 0");
        } else {
            this.j6 = i;
            this.DW = i2;
            this.FH = abe;
            this.Hw = abe2;
            this.v5 = abe3;
            this.Zo = i3;
        }
    }

    public zq j6() {
        return zq.j6(this.FH, this.v5);
    }

    private abe FH() {
        return this.v5;
    }

    public abl DW() {
        return abl.j6(this.Hw.tp());
    }

    public sc$a j6(abe abe) {
        return new sc$a(this.j6, this.DW, this.FH, this.Hw, abe, this.Zo);
    }

    public boolean j6(int i, int i2) {
        return i2 == this.Zo && i >= this.j6 && i < this.j6 + this.DW;
    }

    public boolean j6(sc$a sc_a) {
        return this.j6 == sc_a.j6 && this.DW == sc_a.DW && this.Zo == sc_a.Zo && this.FH.equals(sc_a.FH);
    }
}
