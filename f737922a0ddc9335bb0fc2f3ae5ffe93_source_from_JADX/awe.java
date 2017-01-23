public class awe {
    public static final ani$b<awe> j6;
    private final boolean DW;
    private final ank$a FH;

    static {
        j6 = new awe$1();
    }

    private awe(ani ani) {
        this.DW = ani.j6("core", "filemode", true);
        this.FH = (ank$a) ani.j6("core", null, "autocrlf", ank$a.FALSE);
    }

    public boolean j6() {
        return this.DW;
    }

    public ank$a DW() {
        return this.FH;
    }
}
