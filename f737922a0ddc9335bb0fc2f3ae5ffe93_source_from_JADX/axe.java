import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class axe {
    private static final byte[] DW;
    private static final byte[] FH;
    private static final Map<String, Charset> Hw;
    private static final byte[] j6;
    private static final byte[] v5;

    static {
        int i;
        int i2 = 65;
        int i3 = 48;
        Hw = new HashMap();
        Hw.put("latin-1", Charset.forName("ISO-8859-1"));
        j6 = new byte[58];
        Arrays.fill(j6, (byte) -1);
        for (i = 48; i <= 57; i = (char) (i + 1)) {
            j6[i] = (byte) (i - 48);
        }
        DW = new byte[103];
        Arrays.fill(DW, (byte) -1);
        for (i = 48; i <= 57; i = (char) (i + 1)) {
            DW[i] = (byte) (i - 48);
        }
        for (i = 97; i <= 102; i = (char) (i + 1)) {
            DW[i] = (byte) ((i - 97) + 10);
        }
        for (i = 65; i <= 70; i = (char) (i + 1)) {
            DW[i] = (byte) ((i - 65) + 10);
        }
        FH = new byte[123];
        FH[45] = (byte) 1;
        while (i3 <= 57) {
            FH[i3] = (byte) 1;
            i3 = (char) (i3 + 1);
        }
        while (i2 <= 90) {
            FH[i2] = (byte) 1;
            i2 = (char) (i2 + 1);
        }
        for (i2 = 97; i2 <= 122; i2 = (char) (i2 + 1)) {
            FH[i2] = (byte) 1;
        }
        v5 = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57};
    }

    public static final int j6(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2.length + i > bArr.length) {
            return -1;
        }
        int i2 = 0;
        while (i2 < bArr2.length) {
            if (bArr[i] != bArr2[i2]) {
                return -1;
            }
            i2++;
            i++;
        }
        return i;
    }

    public static int j6(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            int i3 = i - 1;
            bArr[i3] = (byte) 48;
            return i3;
        }
        Object obj = i2 < 0 ? 1 : null;
        if (obj != null) {
            i2 = -i2;
            i3 = i;
        } else {
            i3 = i;
        }
        while (i2 != 0) {
            i = i3 - 1;
            bArr[i] = v5[i2 % 10];
            i2 /= 10;
            i3 = i;
        }
        if (obj == null) {
            return i3;
        }
        i3--;
        bArr[i3] = (byte) 45;
        return i3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int j6(byte[] r5, int r6, axa r7) {
        /*
        r1 = 0;
        r3 = r5.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x003a }
        r0 = r6;
    L_0x0003:
        if (r0 >= r3) goto L_0x000b;
    L_0x0005:
        r2 = r5[r0];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x003d }
        r4 = 32;
        if (r2 == r4) goto L_0x000f;
    L_0x000b:
        if (r0 < r3) goto L_0x0012;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = r0 + 1;
        goto L_0x0003;
    L_0x0012:
        r2 = r5[r0];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x003d }
        switch(r2) {
            case 43: goto L_0x0029;
            case 44: goto L_0x0017;
            case 45: goto L_0x0023;
            default: goto L_0x0017;
        };
    L_0x0017:
        r6 = r0;
        r0 = r1;
    L_0x0019:
        if (r6 < r3) goto L_0x002c;
    L_0x001b:
        if (r7 == 0) goto L_0x001f;
    L_0x001d:
        r7.j6 = r6;
    L_0x001f:
        if (r1 >= 0) goto L_0x000e;
    L_0x0021:
        r0 = -r0;
        goto L_0x000e;
    L_0x0023:
        r2 = -1;
        r6 = r0 + 1;
        r0 = r1;
        r1 = r2;
        goto L_0x0019;
    L_0x0029:
        r0 = r0 + 1;
        goto L_0x0017;
    L_0x002c:
        r2 = j6;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0041 }
        r4 = r5[r6];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0041 }
        r2 = r2[r4];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0041 }
        if (r2 < 0) goto L_0x001b;
    L_0x0034:
        r0 = r0 * 10;
        r0 = r0 + r2;
        r6 = r6 + 1;
        goto L_0x0019;
    L_0x003a:
        r0 = move-exception;
        r0 = r1;
        goto L_0x001b;
    L_0x003d:
        r2 = move-exception;
        r6 = r0;
        r0 = r1;
        goto L_0x001b;
    L_0x0041:
        r2 = move-exception;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: axe.j6(byte[], int, axa):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long DW(byte[] r9, int r10, axa r11) {
        /*
        r2 = 0;
        r1 = 0;
        r4 = r9.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0044 }
        r0 = r10;
    L_0x0005:
        if (r0 >= r4) goto L_0x000d;
    L_0x0007:
        r5 = r9[r0];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004a }
        r6 = 32;
        if (r5 == r6) goto L_0x0011;
    L_0x000d:
        if (r0 < r4) goto L_0x0014;
    L_0x000f:
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = r0 + 1;
        goto L_0x0005;
    L_0x0014:
        r5 = r9[r0];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004a }
        switch(r5) {
            case 43: goto L_0x002d;
            case 44: goto L_0x0019;
            case 45: goto L_0x0028;
            default: goto L_0x0019;
        };
    L_0x0019:
        r10 = r0;
        r0 = r1;
    L_0x001b:
        if (r10 < r4) goto L_0x0030;
    L_0x001d:
        r8 = r0;
        r0 = r2;
        r2 = r8;
    L_0x0020:
        if (r11 == 0) goto L_0x0024;
    L_0x0022:
        r11.j6 = r10;
    L_0x0024:
        if (r2 >= 0) goto L_0x0010;
    L_0x0026:
        r0 = -r0;
        goto L_0x0010;
    L_0x0028:
        r1 = -1;
        r10 = r0 + 1;
        r0 = r1;
        goto L_0x001b;
    L_0x002d:
        r0 = r0 + 1;
        goto L_0x0019;
    L_0x0030:
        r1 = j6;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004e }
        r5 = r9[r10];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004e }
        r1 = r1[r5];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004e }
        if (r1 >= 0) goto L_0x003c;
    L_0x0038:
        r8 = r0;
        r0 = r2;
        r2 = r8;
        goto L_0x0020;
    L_0x003c:
        r6 = 10;
        r2 = r2 * r6;
        r6 = (long) r1;
        r2 = r2 + r6;
        r10 = r10 + 1;
        goto L_0x001b;
    L_0x0044:
        r0 = move-exception;
        r0 = r1;
    L_0x0046:
        r8 = r0;
        r0 = r2;
        r2 = r8;
        goto L_0x0020;
    L_0x004a:
        r4 = move-exception;
        r10 = r0;
        r0 = r1;
        goto L_0x0046;
    L_0x004e:
        r1 = move-exception;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: axe.DW(byte[], int, axa):long");
    }

    public static final int j6(byte[] bArr, int i) {
        int i2 = (((((DW[bArr[i]] << 4) | DW[bArr[i + 1]]) << 4) | DW[bArr[i + 2]]) << 4) | DW[bArr[i + 3]];
        if (i2 >= 0) {
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final int DW(byte[] bArr, int i) {
        int i2 = (((((((((((DW[bArr[i]] << 4) | DW[bArr[i + 1]]) << 4) | DW[bArr[i + 2]]) << 4) | DW[bArr[i + 3]]) << 4) | DW[bArr[i + 4]]) << 4) | DW[bArr[i + 5]]) << 4) | DW[bArr[i + 6]];
        byte b = DW[bArr[i + 7]];
        if (i2 >= 0 && b >= null) {
            return (i2 << 4) | b;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final int j6(byte b) {
        byte b2 = DW[b];
        if (b2 >= null) {
            return b2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final int FH(byte[] bArr, int i) {
        int j6 = j6(bArr, i, null);
        return ((j6 / 100) * 60) + (j6 % 100);
    }

    public static final int j6(byte[] bArr, int i, char c) {
        int length = bArr.length;
        int i2 = i;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (bArr[i2] == c) {
                return i3;
            }
            i2 = i3;
        }
        return i2;
    }

    public static final int Hw(byte[] bArr, int i) {
        return j6(bArr, i, '\n');
    }

    public static final int DW(byte[] bArr, int i, char c) {
        int length = bArr.length;
        int i2 = i;
        while (i2 < length) {
            int i3 = i2 + 1;
            char c2 = bArr[i2];
            if (c2 == c || c2 == '\n') {
                return i3;
            }
            i2 = i3;
        }
        return i2;
    }

    public static final int FH(byte[] bArr, int i, char c) {
        r1 = i == bArr.length ? i - 1 : i;
        while (r1 >= 0) {
            int i2 = r1 - 1;
            if (bArr[r1] == c) {
                return i2;
            }
            r1 = i2;
        }
        return r1;
    }

    public static final int v5(byte[] bArr, int i) {
        return FH(bArr, i, '\n');
    }

    public static final awy DW(byte[] bArr, int i, int i2) {
        awy awy = new awy((i2 - i) / 36);
        awy.DW(1, Integer.MIN_VALUE);
        while (i < i2) {
            awy.DW(i);
            i = Hw(bArr, i);
        }
        awy.DW(i2);
        return awy;
    }

    public static final int Zo(byte[] bArr, int i) {
        int length = bArr.length;
        if (i == 0) {
            i += 46;
        }
        while (i < length && bArr[i] == 112) {
            i += 48;
        }
        return j6(bArr, i, anq.FH);
    }

    public static final int VH(byte[] bArr, int i) {
        int length = bArr.length;
        int i2 = i == 0 ? i + 46 : i;
        while (i2 < length && bArr[i2] == 112) {
            i2 += 48;
        }
        if (i2 < length && bArr[i2] == 97) {
            i2 = Hw(bArr, i2);
        }
        return j6(bArr, i2, anq.Hw);
    }

    public static final int gn(byte[] bArr, int i) {
        int length = bArr.length;
        while (i < length) {
            if (bArr[i] != 10) {
                if (bArr[i] == 101) {
                    break;
                }
                i = Hw(bArr, i);
            } else {
                return -1;
            }
        }
        return j6(bArr, i, anq.v5);
    }

    public static Charset j6(byte[] bArr) {
        Charset j6;
        int gn = gn(bArr, 0);
        if (gn < 0) {
            return anj.DW;
        }
        String j62 = j6(anj.DW, bArr, gn, Hw(bArr, gn) - 1);
        try {
            return Charset.forName(j62);
        } catch (IllegalCharsetNameException e) {
            j6 = j6(j62);
            if (j6 != null) {
                return j6;
            }
            throw e;
        } catch (UnsupportedCharsetException e2) {
            j6 = j6(j62);
            if (j6 != null) {
                return j6;
            }
            throw e2;
        }
    }

    public static aoa u7(byte[] bArr, int i) {
        Charset j6 = j6(bArr);
        int DW = DW(bArr, i, '<');
        int DW2 = DW(bArr, DW, '>');
        if (DW >= bArr.length || bArr[DW] == 10) {
            return null;
        }
        if (DW2 >= bArr.length - 1 && bArr[DW2 - 1] != (byte) 62) {
            return null;
        }
        int i2 = (DW + -2 < i || bArr[DW - 2] != (byte) 32) ? DW - 1 : DW - 2;
        String j62 = j6(j6, bArr, i, i2);
        String j63 = j6(j6, bArr, DW, DW2 - 1);
        i2 = j6(bArr, ' ', Hw(bArr, DW2 - 1) - 2) + 1;
        if (i2 <= DW2) {
            return new aoa(j62, j63, 0, 0);
        }
        DW = Math.max(DW2, j6(bArr, ' ', i2 - 1) + 1);
        if (DW >= i2 - 1) {
            return new aoa(j62, j63, 0, 0);
        }
        return new aoa(j62, j63, DW(bArr, DW, null) * 1000, FH(bArr, i2));
    }

    public static aoa tp(byte[] bArr, int i) {
        String FH;
        String FH2;
        int FH3;
        long j;
        int Hw = Hw(bArr, i);
        int DW = DW(bArr, i, '<');
        int DW2 = DW(bArr, DW, '>');
        if (DW2 < Hw) {
            FH = FH(bArr, DW, DW2 - 1);
        } else {
            FH = "invalid";
        }
        if (DW < Hw) {
            FH2 = FH(bArr, i, DW - 2);
        } else {
            FH2 = FH(bArr, i, Hw);
        }
        axa axa = new axa();
        if (DW2 < Hw) {
            long DW3 = DW(bArr, DW2 + 1, axa);
            FH3 = FH(bArr, axa.j6);
            j = DW3;
        } else {
            FH3 = 0;
            j = 0;
        }
        return new aoa(FH2, FH, j * 1000, FH3);
    }

    public static String DW(byte[] bArr) {
        return FH(bArr, 0, bArr.length);
    }

    public static String FH(byte[] bArr, int i, int i2) {
        return j6(anj.DW, bArr, i, i2);
    }

    public static String j6(Charset charset, byte[] bArr, int i, int i2) {
        try {
            return DW(charset, bArr, i, i2);
        } catch (CharacterCodingException e) {
            return Hw(bArr, i, i2);
        }
    }

    public static String DW(Charset charset, byte[] bArr, int i, int i2) {
        String j6;
        Charset defaultCharset;
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2 - i);
        wrap.mark();
        try {
            j6 = j6(wrap, anj.DW);
        } catch (CharacterCodingException e) {
            wrap.reset();
            if (!charset.equals(anj.DW)) {
                try {
                    j6 = j6(wrap, charset);
                } catch (CharacterCodingException e2) {
                    wrap.reset();
                    defaultCharset = Charset.defaultCharset();
                    try {
                        j6 = j6(wrap, defaultCharset);
                        return j6;
                    } catch (CharacterCodingException e3) {
                        wrap.reset();
                        throw new CharacterCodingException();
                    }
                }
            }
            defaultCharset = Charset.defaultCharset();
            if (!(defaultCharset.equals(charset) || defaultCharset.equals(anj.DW))) {
                j6 = j6(wrap, defaultCharset);
            }
            throw new CharacterCodingException();
        }
        return j6;
    }

    public static String Hw(byte[] bArr, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(i2 - i);
        while (i < i2) {
            stringBuilder.append((char) (bArr[i] & 255));
            i++;
        }
        return stringBuilder.toString();
    }

    private static String j6(ByteBuffer byteBuffer, Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        newDecoder.onMalformedInput(CodingErrorAction.REPORT);
        newDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return newDecoder.decode(byteBuffer).toString();
    }

    public static final int EQ(byte[] bArr, int i) {
        int length = bArr.length;
        if (i == 0) {
            i += 46;
        }
        while (i < length && bArr[i] == 112) {
            i += 48;
        }
        return we(bArr, i);
    }

    public static final int we(byte[] bArr, int i) {
        int length = bArr.length;
        if (i == 0) {
            i += 48;
        }
        while (i < length && bArr[i] != (byte) 10) {
            i = Hw(bArr, i);
        }
        if (i >= length || bArr[i] != (byte) 10) {
            return -1;
        }
        return i + 1;
    }

    public static final int J0(byte[] bArr, int i) {
        int length = bArr.length;
        int i2 = i;
        while (i2 < length && bArr[i2] != (byte) 10) {
            i2 = Hw(bArr, i2);
        }
        while (i2 > 0 && i < i2 && bArr[i2 - 1] == (byte) 10) {
            i2--;
        }
        return i2;
    }

    private static int j6(byte[] bArr, char c, int i) {
        int i2 = i;
        while (i2 >= 0 && bArr[i2] == 32) {
            i2--;
        }
        while (i2 >= 0 && bArr[i2] != c) {
            i2--;
        }
        return i2;
    }

    private static Charset j6(String str) {
        return (Charset) Hw.get(axh.j6(str));
    }
}
