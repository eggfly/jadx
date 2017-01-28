import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class axx extends HashMap implements axw, Map {
    private static String j6(String str, Object obj, StringBuffer stringBuffer) {
        stringBuffer.append('\"');
        if (str == null) {
            stringBuffer.append("null");
        } else {
            axy.j6(str, stringBuffer);
        }
        stringBuffer.append('\"').append(':');
        stringBuffer.append(axy.j6(obj));
        return stringBuffer.toString();
    }

    public static String j6(Map map) {
        if (map == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = 1;
        stringBuffer.append('{');
        for (Entry entry : map.entrySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuffer.append(',');
                obj2 = obj;
            }
            j6(String.valueOf(entry.getKey()), entry.getValue(), stringBuffer);
            obj = obj2;
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public String j6() {
        return j6(this);
    }

    public String toString() {
        return j6();
    }
}
