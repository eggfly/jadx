public abstract class en {
    private static en DW;
    private static Object j6;

    public abstract en$b DW();

    public abstract en$d DW(String str);

    public abstract en$d j6(String str);

    static {
        j6 = new Object();
    }

    public static en j6() {
        en enVar;
        synchronized (j6) {
            enVar = DW;
        }
        return enVar;
    }
}
