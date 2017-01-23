public class fo$a {
    public static fo$a DW;
    public static fo$a FH;
    public static fo$a Hw;
    public static fo$a VH;
    public static fo$a Zo;
    public static fo$a j6;
    public static fo$a v5;
    public String gn;
    public String u7;

    static {
        j6 = new fo$a("<length>");
        DW = new fo$a("<number>");
        FH = new fo$a("<percentage>");
        Hw = new fo$a("<url>");
        v5 = new fo$a("<color>");
        Zo = new fo$a("<gradient>");
        VH = new fo$a("<font-family-name>");
    }

    public fo$a(String str, String str2) {
        this.gn = str;
        this.u7 = str2;
    }

    public fo$a(String str) {
        this.gn = str;
    }

    public boolean j6() {
        return !this.gn.startsWith("<");
    }
}
