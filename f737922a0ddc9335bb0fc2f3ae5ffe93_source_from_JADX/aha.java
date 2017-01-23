import java.util.Map;
import java.util.TreeMap;

public class aha {
    static Map<String, agz> DW;
    static agy j6;

    static {
        j6 = new ahb();
        DW = new TreeMap();
    }

    public static agz j6(String str) {
        agz agz = (agz) DW.get(str);
        if (agz != null) {
            return agz;
        }
        agz = j6.j6(str);
        DW.put(str, agz);
        return agz;
    }
}
