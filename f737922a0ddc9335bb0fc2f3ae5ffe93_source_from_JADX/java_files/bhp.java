import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class bhp {
    private static int j6;

    static {
        j6 = 512;
    }

    public static byte[] j6(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        j6(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int j6(InputStream inputStream, byte[] bArr) {
        return j6(inputStream, bArr, 0, bArr.length);
    }

    public static int j6(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    public static void j6(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[j6];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
