public abstract class bfu {
    public static int j6(byte[] bArr, int i) {
        int i2 = i + 1;
        i2++;
        return (((bArr[i] << 24) | ((bArr[i2] & 255) << 16)) | ((bArr[i2] & 255) << 8)) | (bArr[i2 + 1] & 255);
    }

    public static void j6(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        i3++;
        bArr[i3] = (byte) (i >>> 8);
        bArr[i3 + 1] = (byte) i;
    }

    public static long DW(byte[] bArr, int i) {
        return (((long) j6(bArr, i + 4)) & 4294967295L) | ((((long) j6(bArr, i)) & 4294967295L) << 32);
    }

    public static void j6(long j, byte[] bArr, int i) {
        j6((int) (j >>> 32), bArr, i);
        j6((int) (4294967295L & j), bArr, i + 4);
    }

    public static void DW(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        i3++;
        bArr[i3] = (byte) (i >>> 16);
        bArr[i3 + 1] = (byte) (i >>> 24);
    }

    public static void DW(long j, byte[] bArr, int i) {
        DW((int) (4294967295L & j), bArr, i);
        DW((int) (j >>> 32), bArr, i + 4);
    }
}
