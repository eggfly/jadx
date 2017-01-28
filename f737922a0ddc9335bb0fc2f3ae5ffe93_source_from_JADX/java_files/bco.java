import java.io.IOException;
import java.util.Hashtable;

public class bco {
    public static void j6(StringBuffer stringBuffer, bcj bcj, Hashtable hashtable) {
        String str = (String) hashtable.get(bcj.FH());
        if (str != null) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(bcj.FH().FH());
        }
        stringBuffer.append('=');
        stringBuffer.append(j6(bcj.Hw()));
    }

    public static String j6(ayh ayh) {
        int i;
        int i2 = 2;
        StringBuffer stringBuffer = new StringBuffer();
        if (!(ayh instanceof azb) || (ayh instanceof bat)) {
            try {
                stringBuffer.append("#" + j6(bhn.j6(ayh.w_().j6("DER"))));
            } catch (IOException e) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        }
        String j6 = ((azb) ayh).j6();
        if (j6.length() <= 0 || j6.charAt(0) != '#') {
            stringBuffer.append(j6);
        } else {
            stringBuffer.append("\\" + j6);
        }
        int length = stringBuffer.length();
        if (stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#') {
            i = length;
        } else {
            i2 = 0;
            i = length;
        }
        while (i2 != i) {
            if (stringBuffer.charAt(i2) == ',' || stringBuffer.charAt(i2) == '\"' || stringBuffer.charAt(i2) == '\\' || stringBuffer.charAt(i2) == '+' || stringBuffer.charAt(i2) == '=' || stringBuffer.charAt(i2) == '<' || stringBuffer.charAt(i2) == '>' || stringBuffer.charAt(i2) == ';') {
                stringBuffer.insert(i2, "\\");
                i2++;
                i++;
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    private static String j6(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return new String(cArr);
    }

    public static String j6(String str) {
        String DW;
        String DW2 = bhl.DW(str.trim());
        if (DW2.length() > 0 && DW2.charAt(0) == '#') {
            ayv FH = FH(DW2);
            if (FH instanceof azb) {
                DW = bhl.DW(((azb) FH).j6().trim());
                return DW(DW);
            }
        }
        DW = DW2;
        return DW(DW);
    }

    private static ayv FH(String str) {
        try {
            return ayv.j6(bhn.j6(str.substring(1)));
        } catch (IOException e) {
            throw new IllegalStateException("unknown encoding in name: " + e);
        }
    }

    public static String DW(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            stringBuffer.append(charAt);
            int i = 1;
            while (i < str.length()) {
                char charAt2 = str.charAt(i);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }
}
