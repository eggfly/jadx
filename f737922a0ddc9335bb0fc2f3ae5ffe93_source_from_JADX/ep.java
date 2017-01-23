import java.io.InputStream;

public abstract class ep {
    private static ep DW;
    private static Object j6;

    public abstract String DW();

    public abstract InputStream j6(String str);

    static {
        j6 = new Object();
    }

    public static void j6(ep epVar) {
        synchronized (j6) {
            DW = epVar;
        }
    }

    public static ep j6() {
        ep epVar;
        synchronized (j6) {
            epVar = DW;
        }
        return epVar;
    }
}
