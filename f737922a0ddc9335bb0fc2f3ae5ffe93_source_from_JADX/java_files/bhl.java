public final class bhl {
    public static String j6(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < bArr.length) {
            i2++;
            if ((bArr[i3] & 240) == 240) {
                i2++;
                i3 += 4;
            } else if ((bArr[i3] & 224) == 224) {
                i3 += 3;
            } else if ((bArr[i3] & 192) == 192) {
                i3 += 2;
            } else {
                i3++;
            }
        }
        char[] cArr = new char[i2];
        i2 = 0;
        while (i2 < bArr.length) {
            char c;
            int i4;
            if ((bArr[i2] & 240) == 240) {
                i3 = (((((bArr[i2] & 3) << 18) | ((bArr[i2 + 1] & 63) << 12)) | ((bArr[i2 + 2] & 63) << 6)) | (bArr[i2 + 3] & 63)) - 65536;
                char c2 = (char) (55296 | (i3 >> 10));
                c = (char) ((i3 & 1023) | 56320);
                i4 = i + 1;
                cArr[i] = c2;
                i2 += 4;
            } else if ((bArr[i2] & 224) == 224) {
                c = (char) ((((bArr[i2] & 15) << 12) | ((bArr[i2 + 1] & 63) << 6)) | (bArr[i2 + 2] & 63));
                i2 += 3;
                i4 = i;
            } else if ((bArr[i2] & 208) == 208) {
                c = (char) (((bArr[i2] & 31) << 6) | (bArr[i2 + 1] & 63));
                i2 += 2;
                i4 = i;
            } else if ((bArr[i2] & 192) == 192) {
                c = (char) (((bArr[i2] & 31) << 6) | (bArr[i2 + 1] & 63));
                i2 += 2;
                i4 = i;
            } else {
                c = (char) (bArr[i2] & 255);
                i2++;
                i4 = i;
            }
            i = i4 + 1;
            cArr[i4] = c;
        }
        return new String(cArr);
    }

    public static String j6(String str) {
        int i = 0;
        char[] toCharArray = str.toCharArray();
        int i2 = 0;
        while (i != toCharArray.length) {
            char c = toCharArray[i];
            if ('a' <= c && 'z' >= c) {
                i2 = 1;
                toCharArray[i] = (char) ((c - 97) + 65);
            }
            i++;
        }
        if (i2 != 0) {
            return new String(toCharArray);
        }
        return str;
    }

    public static String DW(String str) {
        int i = 0;
        char[] toCharArray = str.toCharArray();
        int i2 = 0;
        while (i != toCharArray.length) {
            char c = toCharArray[i];
            if ('A' <= c && 'Z' >= c) {
                i2 = 1;
                toCharArray[i] = (char) ((c - 65) + 97);
            }
            i++;
        }
        if (i2 != 0) {
            return new String(toCharArray);
        }
        return str;
    }

    public static byte[] FH(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static String DW(byte[] bArr) {
        return new String(FH(bArr));
    }

    public static char[] FH(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }
}
