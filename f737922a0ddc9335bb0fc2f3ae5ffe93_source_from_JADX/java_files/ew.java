public class ew {
    private static Object DW;
    private static long j6;

    static {
        DW = new Object();
        Thread ew_1 = new ew$1("Time getter");
        ew_1.setPriority(1);
        ew_1.start();
    }

    public static long j6() {
        long j;
        synchronized (DW) {
            j = j6;
        }
        return j;
    }
}
