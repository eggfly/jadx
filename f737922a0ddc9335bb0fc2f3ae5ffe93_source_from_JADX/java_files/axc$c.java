import com.aide.uidesigner.ProxyTextView;
import java.util.Arrays;

public final class axc$c extends axc {
    private static final byte[] Hw;

    static {
        int i;
        Hw = new byte[128];
        Arrays.fill(Hw, (byte) -1);
        for (i = 48; i <= 57; i++) {
            Hw[i] = (byte) 0;
        }
        for (i = 97; i <= 122; i++) {
            Hw[i] = (byte) 0;
        }
        for (i = 65; i <= 90; i++) {
            Hw[i] = (byte) 0;
        }
        Hw[32] = (byte) 0;
        Hw[36] = (byte) 0;
        Hw[37] = (byte) 0;
        Hw[38] = (byte) 0;
        Hw[42] = (byte) 0;
        Hw[43] = (byte) 0;
        Hw[44] = (byte) 0;
        Hw[45] = (byte) 0;
        Hw[46] = (byte) 0;
        Hw[47] = (byte) 0;
        Hw[58] = (byte) 0;
        Hw[59] = (byte) 0;
        Hw[61] = (byte) 0;
        Hw[63] = (byte) 0;
        Hw[64] = (byte) 0;
        Hw[95] = (byte) 0;
        Hw[94] = (byte) 0;
        Hw[124] = (byte) 0;
        Hw[126] = (byte) 0;
        Hw[7] = (byte) 97;
        Hw[8] = (byte) 98;
        Hw[12] = (byte) 102;
        Hw[10] = (byte) 110;
        Hw[13] = (byte) 114;
        Hw[9] = (byte) 116;
        Hw[11] = (byte) 118;
        Hw[92] = (byte) 92;
        Hw[34] = (byte) 34;
    }

    public String j6(String str) {
        if (str.length() == 0) {
            return "\"\"";
        }
        byte[] DW = anj.DW(str);
        StringBuilder stringBuilder = new StringBuilder(DW.length + 2);
        stringBuilder.append('\"');
        Object obj = 1;
        for (byte b : DW) {
            int i = b & 255;
            if (i < Hw.length) {
                byte b2 = Hw[i];
                if (b2 == null) {
                    stringBuilder.append((char) i);
                } else if (b2 > null) {
                    stringBuilder.append('\\');
                    stringBuilder.append((char) b2);
                    obj = null;
                }
            }
            stringBuilder.append('\\');
            stringBuilder.append((char) (((i >> 6) & 3) + 48));
            stringBuilder.append((char) (((i >> 3) & 7) + 48));
            stringBuilder.append((char) (((i >> 0) & 7) + 48));
            obj = null;
        }
        if (obj != null) {
            return str;
        }
        stringBuilder.append('\"');
        return stringBuilder.toString();
    }

    public String j6(byte[] bArr, int i, int i2) {
        if (2 <= i2 - i && bArr[i] == (byte) 34 && bArr[i2 - 1] == (byte) 34) {
            return DW(bArr, i + 1, i2 - 1);
        }
        return axe.j6(anj.DW, bArr, i, i2);
    }

    private static String DW(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2 = new byte[(i2 - i)];
        int i4 = 0;
        int i5 = i;
        while (i5 < i2) {
            i = i5 + 1;
            byte b = bArr[i5];
            if (b == (byte) 92) {
                if (i != i2) {
                    i5 = i + 1;
                    switch (bArr[i]) {
                        case (byte) 34:
                        case (byte) 92:
                            i3 = i4 + 1;
                            bArr2[i4] = bArr[i5 - 1];
                            i4 = i3;
                            break;
                        case (byte) 48:
                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                        case (byte) 50:
                        case (byte) 51:
                            int i6 = bArr[i5 - 1] - 48;
                            i3 = 1;
                            while (i3 < 3 && i5 < i2) {
                                byte b2 = bArr[i5];
                                if (48 <= b2 && b2 <= 55) {
                                    i6 = (i6 << 3) | (b2 - 48);
                                    i5++;
                                    i3++;
                                }
                            }
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) i6;
                            i4 = i3;
                            break;
                        case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) 7;
                            i4 = i3;
                            break;
                        case (byte) 98:
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) 8;
                            i4 = i3;
                            break;
                        case (byte) 102:
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) 12;
                            i4 = i3;
                            break;
                        case (byte) 110:
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) 10;
                            i4 = i3;
                            break;
                        case (byte) 114:
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) 13;
                            i4 = i3;
                            break;
                        case (byte) 116:
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) 9;
                            i4 = i3;
                            break;
                        case (byte) 118:
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) 11;
                            i4 = i3;
                            break;
                        default:
                            i3 = i4 + 1;
                            bArr2[i4] = (byte) 92;
                            i4 = i3 + 1;
                            bArr2[i3] = bArr[i5 - 1];
                            break;
                    }
                }
                i3 = i4 + 1;
                bArr2[i4] = (byte) 92;
                return axe.j6(anj.DW, bArr2, 0, i3);
            }
            i3 = i4 + 1;
            bArr2[i4] = b;
            i4 = i3;
            i5 = i;
        }
        i3 = i4;
        return axe.j6(anj.DW, bArr2, 0, i3);
    }

    private axc$c() {
    }
}
