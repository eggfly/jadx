import java.util.zip.Inflater;

public class ann {
    private static int DW;
    private static final Inflater[] j6;

    static {
        j6 = new Inflater[4];
    }

    public static Inflater j6() {
        Inflater DW = DW();
        return DW != null ? DW : new ana();
    }

    private static synchronized Inflater DW() {
        Inflater inflater = null;
        synchronized (ann.class) {
            if (DW > 0) {
                Inflater[] inflaterArr = j6;
                int i = DW - 1;
                DW = i;
                inflater = inflaterArr[i];
                j6[DW] = null;
            }
        }
        return inflater;
    }

    public static void j6(Inflater inflater) {
        if (inflater != null) {
            inflater.reset();
            if (DW(inflater)) {
                ((ana) inflater).j6();
            }
        }
    }

    private static synchronized boolean DW(Inflater inflater) {
        boolean z;
        synchronized (ann.class) {
            if (DW < 4) {
                Inflater[] inflaterArr = j6;
                int i = DW;
                DW = i + 1;
                inflaterArr[i] = inflater;
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }
}
