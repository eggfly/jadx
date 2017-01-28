import java.util.ArrayList;
import java.util.List;

public class axv extends ArrayList implements axw, List {
    public static String j6(List list) {
        if (list == null) {
            return "null";
        }
        Object obj = 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (Object next : list) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuffer.append(',');
            }
            if (next == null) {
                stringBuffer.append("null");
            } else {
                stringBuffer.append(axy.j6(next));
            }
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public String j6() {
        return j6(this);
    }

    public String toString() {
        return j6();
    }
}
