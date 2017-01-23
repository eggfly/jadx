import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ahe {
    static ahf j6;

    static {
        j6 = new ahf();
    }

    public static String j6(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            j6.j6(bArr, 0, bArr.length, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < toByteArray.length; i += 32) {
                int i2;
                int min = Math.min(i + 32, toByteArray.length);
                StringBuilder stringBuilder2 = new StringBuilder();
                CharSequence stringBuilder3 = new StringBuilder();
                stringBuilder2.append(String.format("%08x: ", new Object[]{Integer.valueOf(i / 2)}));
                for (i2 = i; i2 < min; i2 += 2) {
                    stringBuilder2.append(Character.valueOf((char) toByteArray[i2]));
                    stringBuilder2.append(Character.valueOf((char) toByteArray[i2 + 1]));
                    if ((i2 + 2) % 4 == 0) {
                        stringBuilder2.append(' ');
                    }
                    byte b = bArr[i2 / 2];
                    if (b < 32 || b >= 127) {
                        stringBuilder3.append('.');
                    } else {
                        stringBuilder3.append(Character.valueOf((char) b));
                    }
                }
                stringBuilder.append(stringBuilder2.toString());
                for (i2 = stringBuilder2.length(); i2 < 50; i2++) {
                    stringBuilder.append(' ');
                }
                stringBuilder.append("  ");
                stringBuilder.append(stringBuilder3);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
