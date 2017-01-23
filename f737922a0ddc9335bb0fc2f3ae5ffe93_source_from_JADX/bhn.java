import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class bhn {
    private static final bhm j6;

    static {
        j6 = new bho();
    }

    public static byte[] j6(byte[] bArr) {
        return j6(bArr, 0, bArr.length);
    }

    public static byte[] j6(byte[] bArr, int i, int i2) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            j6.j6(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("exception encoding Hex string: " + e);
        }
    }

    public static byte[] j6(String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            j6.j6(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("exception decoding Hex string: " + e);
        }
    }
}
