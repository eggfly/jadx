package groovyjarjarantlr.debug;

public class ParserTokenEvent extends Event {
    public static int DW;
    public static int j6;
    private int FH;
    private int Hw;

    static {
        j6 = 0;
        DW = 1;
    }

    public int DW() {
        return this.Hw;
    }

    public int FH() {
        return this.FH;
    }

    void FH(int i) {
        this.Hw = i;
    }

    void Hw(int i) {
        this.FH = i;
    }

    void j6(int i, int i2, int i3) {
        super.DW(i);
        FH(i2);
        Hw(i3);
    }

    public String toString() {
        if (j6() == j6) {
            return new StringBuffer().append("ParserTokenEvent [LA,").append(DW()).append(",").append(FH()).append("]").toString();
        }
        return new StringBuffer().append("ParserTokenEvent [consume,1,").append(FH()).append("]").toString();
    }
}
