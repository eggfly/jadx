public class bfl extends bfs {
    private static byte[] j6;

    static {
        j6 = new byte[]{(byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 31, (byte) 31, (byte) 31, (byte) 31, (byte) 14, (byte) 14, (byte) 14, (byte) 14, (byte) -32, (byte) -32, (byte) -32, (byte) -32, (byte) -15, (byte) -15, (byte) -15, (byte) -15, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 31, (byte) -32, (byte) 31, (byte) -32, (byte) 14, (byte) -15, (byte) 14, (byte) -15, (byte) 1, (byte) -32, (byte) 1, (byte) -32, (byte) 1, (byte) -15, (byte) 1, (byte) -15, (byte) 31, (byte) -2, (byte) 31, (byte) -2, (byte) 14, (byte) -2, (byte) 14, (byte) -2, (byte) 1, (byte) 31, (byte) 1, (byte) 31, (byte) 1, (byte) 14, (byte) 1, (byte) 14, (byte) -32, (byte) -2, (byte) -32, (byte) -2, (byte) -15, (byte) -2, (byte) -15, (byte) -2, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -2, (byte) 1, (byte) -32, (byte) 31, (byte) -32, (byte) 31, (byte) -15, (byte) 14, (byte) -15, (byte) 14, (byte) -32, (byte) 1, (byte) -32, (byte) 1, (byte) -15, (byte) 1, (byte) -15, (byte) 1, (byte) -2, (byte) 31, (byte) -2, (byte) 31, (byte) -2, (byte) 14, (byte) -2, (byte) 14, (byte) 31, (byte) 1, (byte) 31, (byte) 1, (byte) 14, (byte) 1, (byte) 14, (byte) 1, (byte) -2, (byte) -32, (byte) -2, (byte) -32, (byte) -2, (byte) -15, (byte) -2, (byte) -15};
    }

    public static void j6(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            bArr[i] = (byte) (((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) & 1) | (b & 254));
        }
    }
}
