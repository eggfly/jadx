import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class oe<T extends oe<?>> {
    private static Map<String, Long> DW;
    private static Map<String, oe<?>> j6;
    public String Ws;

    protected abstract T DW(String str);

    static {
        j6 = new HashMap();
        DW = new HashMap();
    }

    public T J0(String str) {
        if (j6.containsKey(str) && DW.containsKey(str) && new File(str).lastModified() == ((Long) DW.get(str)).longValue()) {
            return (oe) j6.get(str);
        }
        try {
            T DW = DW(str);
            DW.Ws = str;
            j6.put(str, DW);
            DW.put(str, Long.valueOf(new File(str).lastModified()));
            return DW;
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }
}
