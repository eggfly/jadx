import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

public class axy {
    public static String DW(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        j6(str, stringBuffer);
        return stringBuffer.toString();
    }

    public static Object j6(Reader reader) {
        try {
            return new aya().DW(reader);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object j6(String str) {
        return j6(new StringReader(str));
    }

    public static String j6(Object obj) {
        return obj == null ? "null" : obj instanceof String ? new StringBuffer().append("\"").append(DW((String) obj)).append("\"").toString() : obj instanceof Double ? (((Double) obj).isInfinite() || ((Double) obj).isNaN()) ? "null" : obj.toString() : obj instanceof Float ? (((Float) obj).isInfinite() || ((Float) obj).isNaN()) ? "null" : obj.toString() : obj instanceof Number ? obj.toString() : obj instanceof Boolean ? obj.toString() : obj instanceof axw ? ((axw) obj).j6() : obj instanceof Map ? axx.j6((Map) obj) : obj instanceof List ? axv.j6((List) obj) : obj.toString();
    }

    static void j6(String str, StringBuffer stringBuffer) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                    stringBuffer.append("\\\"");
                    break;
                case '/':
                    stringBuffer.append("\\/");
                    break;
                case '\\':
                    stringBuffer.append("\\\\");
                    break;
                default:
                    if ((charAt >= '\u0000' && charAt <= '\u001f') || ((charAt >= '\u007f' && charAt <= '\u009f') || (charAt >= '\u2000' && charAt <= '\u20ff'))) {
                        String toHexString = Integer.toHexString(charAt);
                        stringBuffer.append("\\u");
                        for (int i2 = 0; i2 < 4 - toHexString.length(); i2++) {
                            stringBuffer.append('0');
                        }
                        stringBuffer.append(toHexString.toUpperCase());
                        break;
                    }
                    stringBuffer.append(charAt);
                    break;
            }
        }
    }
}
