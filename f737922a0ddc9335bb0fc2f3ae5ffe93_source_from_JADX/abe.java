import com.aide.uidesigner.ProxyTextView;

public final class abe extends abh {
    public static final abe j6;
    private final String DW;
    private final acu FH;

    static {
        j6 = new abe("");
    }

    public static byte[] j6(String str) {
        int length = str.length();
        Object obj = new byte[(length * 3)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt != '\u0000' && charAt < '\u0080') {
                obj[i] = (byte) charAt;
                i++;
            } else if (charAt < '\u0800') {
                obj[i] = (byte) (((charAt >> 6) & 31) | 192);
                obj[i + 1] = (byte) ((charAt & 63) | 128);
                i += 2;
            } else {
                obj[i] = (byte) (((charAt >> 12) & 15) | 224);
                obj[i + 1] = (byte) (((charAt >> 6) & 63) | 128);
                obj[i + 2] = (byte) ((charAt & 63) | 128);
                i += 3;
            }
        }
        Object obj2 = new byte[i];
        System.arraycopy(obj, 0, obj2, 0, i);
        return obj2;
    }

    public static String j6(acu acu) {
        int j6 = acu.j6();
        char[] cArr = new char[j6];
        int i = 0;
        int i2 = 0;
        while (j6 > 0) {
            char c;
            int v5 = acu.v5(i);
            int v52;
            switch (v5 >> 4) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                case 6:
                case 7:
                    j6--;
                    if (v5 != 0) {
                        c = (char) v5;
                        i++;
                        break;
                    }
                    return j6(v5, i);
                case 12:
                case 13:
                    j6 -= 2;
                    if (j6 < 0) {
                        return j6(v5, i);
                    }
                    v52 = acu.v5(i + 1);
                    if ((v52 & 192) != 128) {
                        return j6(v52, i + 1);
                    }
                    v5 = ((v5 & 31) << 6) | (v52 & 63);
                    if (v5 == 0 || v5 >= 128) {
                        c = (char) v5;
                        i += 2;
                        break;
                    }
                    return j6(v52, i + 1);
                case 14:
                    j6 -= 3;
                    if (j6 >= 0) {
                        v52 = acu.v5(i + 1);
                        if ((v52 & 192) == 128) {
                            int v53 = acu.v5(i + 2);
                            if ((v52 & 192) == 128) {
                                v5 = (((v5 & 15) << 12) | ((v52 & 63) << 6)) | (v53 & 63);
                                if (v5 >= 2048) {
                                    c = (char) v5;
                                    i += 3;
                                    break;
                                }
                                return j6(v53, i + 2);
                            }
                            return j6(v53, i + 2);
                        }
                        return j6(v52, i + 1);
                    }
                    return j6(v5, i);
                default:
                    return j6(v5, i);
            }
            cArr[i2] = c;
            i2++;
        }
        return new String(cArr, 0, i2);
    }

    private static String j6(int i, int i2) {
        throw new IllegalArgumentException("bad utf-8 byte " + add.v5(i) + " at offset " + add.j6(i2));
    }

    public abe(String str) {
        if (str == null) {
            throw new NullPointerException("string == null");
        }
        this.DW = str.intern();
        this.FH = new acu(j6(str));
    }

    public abe(acu acu) {
        if (acu == null) {
            throw new NullPointerException("bytes == null");
        }
        this.FH = acu;
        this.DW = j6(acu).intern();
    }

    public boolean equals(Object obj) {
        if (obj instanceof abe) {
            return this.DW.equals(((abe) obj).DW);
        }
        return false;
    }

    public int hashCode() {
        return this.DW.hashCode();
    }

    protected int DW(aah aah) {
        return this.DW.compareTo(((abe) aah).DW);
    }

    public String toString() {
        return "string{\"" + Hw() + "\"}";
    }

    public String gn() {
        return "utf8";
    }

    public boolean VH() {
        return false;
    }

    public String Hw() {
        int length = this.DW.length();
        StringBuilder stringBuilder = new StringBuilder((length * 3) / 2);
        for (int i = 0; i < length; i++) {
            char charAt = this.DW.charAt(i);
            if (charAt >= ' ' && charAt < '\u007f') {
                if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                    stringBuilder.append('\\');
                }
                stringBuilder.append(charAt);
            } else if (charAt <= '\u007f') {
                switch (charAt) {
                    case '\t':
                        stringBuilder.append("\\t");
                        break;
                    case '\n':
                        stringBuilder.append("\\n");
                        break;
                    case '\r':
                        stringBuilder.append("\\r");
                        break;
                    default:
                        char charAt2;
                        Object obj;
                        if (i < length - 1) {
                            charAt2 = this.DW.charAt(i + 1);
                        } else {
                            charAt2 = '\u0000';
                        }
                        if (charAt2 < '0' || charAt2 > '7') {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        stringBuilder.append('\\');
                        for (int i2 = 6; i2 >= 0; i2 -= 3) {
                            char c = (char) (((charAt >> i2) & 7) + 48);
                            if (c != '0' || obj != null) {
                                stringBuilder.append(c);
                                obj = 1;
                            }
                        }
                        if (obj != null) {
                            break;
                        }
                        stringBuilder.append('0');
                        break;
                        break;
                }
            } else {
                stringBuilder.append("\\u");
                stringBuilder.append(Character.forDigit(charAt >> 12, 16));
                stringBuilder.append(Character.forDigit((charAt >> 8) & 15, 16));
                stringBuilder.append(Character.forDigit((charAt >> 4) & 15, 16));
                stringBuilder.append(Character.forDigit(charAt & 15, 16));
            }
        }
        return stringBuilder.toString();
    }

    public String u7() {
        return '\"' + Hw() + '\"';
    }

    public String j6(int i) {
        String str;
        String Hw = Hw();
        if (Hw.length() <= i - 2) {
            str = "";
        } else {
            Hw = Hw.substring(0, i - 5);
            str = "...";
        }
        return '\"' + Hw + str + '\"';
    }

    public String tp() {
        return this.DW;
    }

    public acu EQ() {
        return this.FH;
    }

    public int we() {
        return this.FH.j6();
    }

    public int J0() {
        return this.DW.length();
    }

    public abl j6() {
        return abl.XL;
    }
}
