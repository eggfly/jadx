public class axd {
    private static final boolean[] j6;

    static {
        j6 = new boolean[256];
        j6[13] = true;
        j6[10] = true;
        j6[9] = true;
        j6[32] = true;
    }

    public static boolean j6(byte b) {
        return j6[b & 255];
    }

    public static int j6(byte[] bArr, int i, int i2) {
        int i3 = i2 - 1;
        while (i <= i3 && j6(bArr[i3])) {
            i3--;
        }
        return i3 + 1;
    }

    public static int DW(byte[] bArr, int i, int i2) {
        while (i < i2 && j6(bArr[i])) {
            i++;
        }
        return i;
    }
}
