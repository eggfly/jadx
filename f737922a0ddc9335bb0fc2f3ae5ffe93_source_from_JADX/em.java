public abstract class em {
    private static em DW;
    private static Object j6;

    public abstract float j6(String str);

    static {
        j6 = new Object();
    }

    public static em j6() {
        em emVar;
        synchronized (j6) {
            emVar = DW;
        }
        return emVar;
    }
}
