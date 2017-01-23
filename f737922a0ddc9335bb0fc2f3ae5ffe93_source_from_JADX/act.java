public final class act {
    public static int[] j6(int i) {
        return new int[((i + 31) >> 5)];
    }

    public static int j6(int[] iArr) {
        return iArr.length * 32;
    }

    public static boolean j6(int[] iArr, int i) {
        if ((iArr[i >> 5] & (1 << (i & 31))) != 0) {
            return true;
        }
        return false;
    }

    public static void j6(int[] iArr, int i, boolean z) {
        int i2 = i >> 5;
        int i3 = 1 << (i & 31);
        if (z) {
            iArr[i2] = i3 | iArr[i2];
            return;
        }
        iArr[i2] = (i3 ^ -1) & iArr[i2];
    }

    public static void DW(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public static void FH(int[] iArr, int i) {
        int i2 = i >> 5;
        iArr[i2] = ((1 << (i & 31)) ^ -1) & iArr[i2];
    }

    public static boolean DW(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static int FH(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 += Integer.bitCount(iArr[i]);
            i++;
        }
        return i2;
    }

    public static boolean j6(int[] iArr, int i, int i2) {
        int Hw = Hw(iArr, i);
        return Hw >= 0 && Hw < i2;
    }

    public static int Hw(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = i & 31;
        for (int i3 = i >> 5; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i4 != 0) {
                i2 = j6(i4, i2);
                if (i2 >= 0) {
                    return (i3 << 5) + i2;
                }
            }
            i2 = 0;
        }
        return -1;
    }

    public static int j6(int i, int i2) {
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros((((1 << i2) - 1) ^ -1) & i);
        return numberOfTrailingZeros == 32 ? -1 : numberOfTrailingZeros;
    }

    public static void j6(int[] iArr, int[] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            iArr[i] = iArr[i] | iArr2[i];
        }
    }
}
