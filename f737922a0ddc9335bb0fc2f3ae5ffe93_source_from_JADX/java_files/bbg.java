import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class bbg {
    private static final long j6;

    static {
        j6 = Runtime.getRuntime().maxMemory();
    }

    static int j6(InputStream inputStream) {
        if (inputStream instanceof bbe) {
            return ((bbe) inputStream).j6();
        }
        if (inputStream instanceof aym) {
            return ((aym) inputStream).j6();
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                long size = ((FileInputStream) inputStream).getChannel().size();
                if (size < 2147483647L) {
                    return (int) size;
                }
            } catch (IOException e) {
            }
        }
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j6;
    }

    static int j6(int i) {
        int i2 = 1;
        if (i > 127) {
            int i3 = 1;
            while (true) {
                i >>>= 8;
                if (i == 0) {
                    break;
                }
                i3++;
            }
            i3 = (i3 - 1) * 8;
            while (i3 >= 0) {
                i3 -= 8;
                i2++;
            }
        }
        return i2;
    }

    static int DW(int i) {
        if (i < 31) {
            return 1;
        }
        if (i < 128) {
            return 2;
        }
        byte[] bArr = new byte[5];
        int length = bArr.length - 1;
        bArr[length] = (byte) (i & 127);
        do {
            i >>= 7;
            length--;
            bArr[length] = (byte) ((i & 127) | 128);
        } while (i > 127);
        return (bArr.length - length) + 1;
    }
}
