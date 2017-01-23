public class ank {
    public static final ani$b<ank> j6;
    private final int DW;
    private final int FH;
    private final boolean Hw;
    private final String v5;

    static {
        j6 = new ank$1();
    }

    private ank(ani ani) {
        this.DW = ani.j6("core", "compression", -1);
        this.FH = ani.j6("pack", "indexversion", 2);
        this.Hw = ani.j6("core", "logallrefupdates", true);
        this.v5 = ani.j6("core", null, "excludesfile");
    }

    public int j6() {
        return this.DW;
    }

    public int DW() {
        return this.FH;
    }

    public boolean FH() {
        return this.Hw;
    }

    public String Hw() {
        return this.v5;
    }
}
