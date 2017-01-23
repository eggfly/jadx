package groovyjarjarantlr;

class CppCharFormatter implements CharFormatter {
    CppCharFormatter() {
    }

    public String j6(int i, boolean z) {
        switch (i) {
            case 9:
                return "\\t";
            case 10:
                return "\\n";
            case 13:
                return "\\r";
            case 34:
                return "\\\"";
            case 39:
                return "\\'";
            case 92:
                return "\\\\";
            default:
                if (i >= 32 && i <= 126) {
                    return String.valueOf((char) i);
                }
                if (i <= 255) {
                    return new StringBuffer().append("\\").append(Integer.toString(i, 8)).toString();
                }
                String num = Integer.toString(i, 16);
                while (num.length() < 4) {
                    num = new StringBuffer().append('0').append(num).toString();
                }
                return new StringBuffer().append("\\u").append(num).toString();
        }
    }

    public String j6(int i) {
        String stringBuffer = new StringBuffer().append("0x").append(Integer.toString(i, 16)).toString();
        if (i < 0 || i > 126) {
            return stringBuffer;
        }
        return new StringBuffer().append(stringBuffer).append(" /* '").append(j6(i, true)).append("' */ ").toString();
    }
}
