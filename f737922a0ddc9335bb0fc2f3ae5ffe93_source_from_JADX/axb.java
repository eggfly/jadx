public final class axb {
    public static int j6(int i, int i2) {
        int i3 = (i >>> 1) - (i2 >>> 1);
        return i3 != 0 ? i3 : (i & 1) - (i2 & 1);
    }

    public static int j6(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }

    public static int DW(byte[] bArr, int i) {
        return (((((bArr[i] << 8) | (bArr[i + 1] & 255)) << 8) | (bArr[i + 2] & 255)) << 8) | (bArr[i + 3] & 255);
    }

    public static long FH(byte[] bArr, int i) {
        return ((long) (((((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255)) << 8) | (bArr[i + 3] & 255))) | (((long) (bArr[i] & 255)) << 24);
    }

    public static long Hw(byte[] bArr, int i) {
        return (FH(bArr, i) << 32) | FH(bArr, i + 4);
    }

    public static void j6(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) i2;
        bArr[i] = (byte) (i2 >>> 8);
    }

    public static void DW(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) i2;
        int i3 = i2 >>> 8;
        bArr[i + 2] = (byte) i3;
        i3 >>>= 8;
        bArr[i + 1] = (byte) i3;
        bArr[i] = (byte) (i3 >>> 8);
    }

    public static void j6(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) ((int) j);
        long j2 = j >>> 8;
        bArr[i + 6] = (byte) ((int) j2);
        j2 >>>= 8;
        bArr[i + 5] = (byte) ((int) j2);
        j2 >>>= 8;
        bArr[i + 4] = (byte) ((int) j2);
        j2 >>>= 8;
        bArr[i + 3] = (byte) ((int) j2);
        j2 >>>= 8;
        bArr[i + 2] = (byte) ((int) j2);
        j2 >>>= 8;
        bArr[i + 1] = (byte) ((int) j2);
        bArr[i] = (byte) ((int) (j2 >>> 8));
    }
}
