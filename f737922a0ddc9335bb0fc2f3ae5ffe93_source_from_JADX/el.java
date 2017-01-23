import java.io.File;

public abstract class el {
    private static el DW;
    private static Object j6;

    public abstract boolean j6(File file, long j);

    static {
        j6 = new Object();
    }

    public static el j6() {
        el elVar;
        synchronized (j6) {
            elVar = DW;
        }
        return elVar;
    }
}
