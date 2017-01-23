package groovyjarjarantlr;

public class PythonCharFormatter implements CharFormatter {
    public String j6(int i, boolean z) {
        return DW(i, z);
    }

    public String DW(int i, boolean z) {
        switch (i) {
            case 9:
                return "\\t";
            case 10:
                return "\\n";
            case 13:
                return "\\r";
            case 34:
                return z ? "\"" : "\\\"";
            case 39:
                return z ? "\\'" : "'";
            case 92:
                return "\\\\";
            default:
                if (i >= 32 && i <= 126) {
                    return String.valueOf((char) i);
                }
                if (i >= 0 && i <= 15) {
                    return new StringBuffer().append("\\u000").append(Integer.toString(i, 16)).toString();
                }
                if (16 <= i && i <= 255) {
                    return new StringBuffer().append("\\u00").append(Integer.toString(i, 16)).toString();
                }
                if (256 > i || i > 4095) {
                    return new StringBuffer().append("\\u").append(Integer.toString(i, 16)).toString();
                }
                return new StringBuffer().append("\\u0").append(Integer.toString(i, 16)).toString();
        }
    }

    public String j6(int i) {
        return new StringBuffer().append("").append(j6(i, true)).append("").toString();
    }
}
