package groovyjarjarantlr.debug;

public class ParserMatchEvent extends GuessingEvent {
    public static int DW;
    public static int FH;
    public static int Hw;
    public static int Zo;
    public static int j6;
    public static int v5;
    private String EQ;
    private boolean VH;
    private boolean gn;
    private int tp;
    private Object u7;

    static {
        j6 = 0;
        DW = 1;
        FH = 2;
        Hw = 3;
        v5 = 4;
        Zo = 5;
    }

    public Object FH() {
        return this.u7;
    }

    public int Hw() {
        return this.tp;
    }

    public boolean v5() {
        return this.VH;
    }

    public boolean Zo() {
        return this.gn;
    }

    void j6(boolean z) {
        this.VH = z;
    }

    void DW(boolean z) {
        this.gn = z;
    }

    void j6(Object obj) {
        this.u7 = obj;
    }

    void j6(String str) {
        this.EQ = str;
    }

    void Hw(int i) {
        this.tp = i;
    }

    void j6(int i, int i2, Object obj, String str, int i3, boolean z, boolean z2) {
        super.j6(i, i3);
        Hw(i2);
        j6(obj);
        j6(z);
        DW(z2);
        j6(str);
    }

    public String toString() {
        return new StringBuffer().append("ParserMatchEvent [").append(Zo() ? "ok," : "bad,").append(v5() ? "NOT " : "").append(j6() == j6 ? "token," : "bitset,").append(Hw()).append(",").append(FH()).append(",").append(DW()).append("]").toString();
    }
}
