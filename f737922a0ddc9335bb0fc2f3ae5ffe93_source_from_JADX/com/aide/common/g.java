package com.aide.common;

public class g {
    private static final char[] DW;
    private static final byte[] FH;
    private static final String j6;

    static {
        int i;
        int i2 = 0;
        j6 = System.getProperty("line.separator");
        DW = new char[64];
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            DW[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            DW[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            DW[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        i = i3 + 1;
        DW[i3] = '+';
        i3 = i + 1;
        DW[i] = '/';
        FH = new byte[128];
        for (int i4 = 0; i4 < FH.length; i4++) {
            FH[i4] = (byte) -1;
        }
        while (i2 < 64) {
            FH[DW[i2]] = (byte) i2;
            i2++;
        }
    }

    public static char[] j6(byte[] bArr) {
        return j6(bArr, 0, bArr.length);
    }

    public static char[] j6(byte[] bArr, int i, int i2) {
        int i3 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i4 = i + i2;
        int i5 = 0;
        while (i < i4) {
            int i6;
            int i7;
            char c;
            int i8 = i + 1;
            int i9 = bArr[i] & 255;
            if (i8 < i4) {
                i6 = bArr[i8] & 255;
                i8++;
            } else {
                i6 = 0;
            }
            if (i8 < i4) {
                i7 = i8 + 1;
                i8 = bArr[i8] & 255;
            } else {
                i7 = i8;
                i8 = 0;
            }
            int i10 = i9 >>> 2;
            i9 = ((i9 & 3) << 4) | (i6 >>> 4);
            i6 = ((i6 & 15) << 2) | (i8 >>> 6);
            int i11 = i8 & 63;
            i8 = i5 + 1;
            cArr[i5] = DW[i10];
            i5 = i8 + 1;
            cArr[i8] = DW[i9];
            if (i5 < i3) {
                c = DW[i6];
            } else {
                c = '=';
            }
            cArr[i5] = c;
            i6 = i5 + 1;
            if (i6 < i3) {
                c = DW[i11];
            } else {
                c = '=';
            }
            cArr[i6] = c;
            i5 = i6 + 1;
            i = i7;
        }
        return cArr;
    }

    public static byte[] j6(String str) {
        return j6(str.toCharArray());
    }

    public static byte[] j6(char[] cArr) {
        return j6(cArr, 0, cArr.length);
    }

    public static byte[] j6(char[] cArr, int i, int i2) {
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
            i2--;
        }
        int i3 = (i2 * 3) / 4;
        byte[] bArr = new byte[i3];
        int i4 = i + i2;
        int i5 = 0;
        while (i < i4) {
            int i6;
            int i7;
            int i8 = i + 1;
            char c = cArr[i];
            int i9 = i8 + 1;
            char c2 = cArr[i8];
            if (i9 < i4) {
                i8 = i9 + 1;
                i6 = cArr[i9];
                i9 = i8;
            } else {
                i6 = 65;
            }
            if (i9 < i4) {
                i8 = i9 + 1;
                i9 = cArr[i9];
                i7 = i8;
            } else {
                i7 = i9;
                i9 = 65;
            }
            if (c > '\u007f' || c2 > '\u007f' || i6 > 127 || i9 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = FH[c];
            byte b2 = FH[c2];
            byte b3 = FH[i6];
            byte b4 = FH[i9];
            if (b < null || b2 < null || b3 < null || b4 < null) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            i8 = (b << 2) | (b2 >>> 4);
            int i10 = ((b2 & 15) << 4) | (b3 >>> 2);
            i6 = ((b3 & 3) << 6) | b4;
            i9 = i5 + 1;
            bArr[i5] = (byte) i8;
            if (i9 < i3) {
                i8 = i9 + 1;
                bArr[i9] = (byte) i10;
            } else {
                i8 = i9;
            }
            if (i8 < i3) {
                i9 = i8 + 1;
                bArr[i8] = (byte) i6;
            } else {
                i9 = i8;
            }
            i5 = i9;
            i = i7;
        }
        return bArr;
    }
}
