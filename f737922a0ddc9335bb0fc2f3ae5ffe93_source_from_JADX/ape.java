import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class ape {
    private static final InheritableThreadLocal<ape> DW;
    public static final Locale j6;
    private final Locale FH;
    private final ConcurrentHashMap<Class, apf> Hw;

    static {
        j6 = new Locale("", "", "");
        DW = new ape$1();
    }

    public static <T extends apf> T j6(Class<T> cls) {
        return ((ape) DW.get()).DW(cls);
    }

    private ape(Locale locale) {
        this.Hw = new ConcurrentHashMap();
        this.FH = locale;
    }

    private <T extends apf> T DW(Class<T> cls) {
        apf apf = (apf) this.Hw.get(cls);
        if (apf != null) {
            return apf;
        }
        T j6 = apd.j6(this.FH, cls);
        apf = (apf) this.Hw.putIfAbsent(cls, j6);
        return apf != null ? apf : j6;
    }
}
