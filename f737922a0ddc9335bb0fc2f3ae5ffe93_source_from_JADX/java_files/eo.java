public abstract class eo {
    private static eo DW;
    private static Object j6;

    public abstract boolean j6(String str, String str2);

    static {
        j6 = new Object();
        DW = new eo$1();
    }

    public static eo j6() {
        eo eoVar;
        synchronized (j6) {
            eoVar = DW;
        }
        return eoVar;
    }
}
