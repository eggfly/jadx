public class aop {
    public static final ani$b<aop> j6;
    private String DW;
    private String FH;
    private String Hw;
    private boolean VH;
    private boolean Zo;
    private boolean gn;
    private boolean u7;
    private String v5;

    static {
        j6 = new aop$1();
    }

    private aop(ani ani) {
        this.DW = j6(ani, "GIT_AUTHOR_NAME");
        if (this.DW == null) {
            this.DW = FH();
            this.Zo = true;
        }
        this.FH = DW(ani, "GIT_AUTHOR_EMAIL");
        if (this.FH == null) {
            this.FH = Hw();
            this.VH = true;
        }
        this.Hw = j6(ani, "GIT_COMMITTER_NAME");
        if (this.Hw == null) {
            this.Hw = FH();
            this.gn = true;
        }
        this.v5 = DW(ani, "GIT_COMMITTER_EMAIL");
        if (this.v5 == null) {
            this.v5 = Hw();
            this.u7 = true;
        }
    }

    public String j6() {
        return this.Hw;
    }

    public String DW() {
        return this.v5;
    }

    private static String j6(ani ani, String str) {
        String j6 = ani.j6("user", null, "name");
        if (j6 == null) {
            return v5().j6(str);
        }
        return j6;
    }

    private static String FH() {
        String DW = v5().DW("user.name");
        if (DW == null) {
            return "unknown-user";
        }
        return DW;
    }

    private static String DW(ani ani, String str) {
        String j6 = ani.j6("user", null, "email");
        if (j6 == null) {
            return v5().j6(str);
        }
        return j6;
    }

    private static String Hw() {
        return FH() + "@" + v5().j6();
    }

    private static axi v5() {
        return axi.FH();
    }
}
