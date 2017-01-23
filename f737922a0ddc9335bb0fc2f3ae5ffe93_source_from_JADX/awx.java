import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class awx {
    public static final byte[] j6(File file) {
        return DW(file, Integer.MAX_VALUE);
    }

    public static final byte[] j6(File file, int i) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (true) {
                int read = fileInputStream.read(bArr, i2, bArr.length - i2);
                if (read <= 0) {
                    break;
                }
                i2 = read + i2;
            }
            if (i2 == bArr.length) {
                return bArr;
            }
            Object obj = new byte[i2];
            System.arraycopy(bArr, 0, obj, 0, i2);
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
            return obj;
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    public static final byte[] DW(File file, int i) {
        InputStream fileInputStream = new FileInputStream(file);
        try {
            long size = fileInputStream.getChannel().size();
            if (size > ((long) i)) {
                throw new IOException(MessageFormat.format(JGitText.j6().fileIsTooLarge, new Object[]{file}));
            }
            Object obj = new byte[((int) size)];
            int j6 = j6(fileInputStream, obj, 0);
            if (((long) j6) == size) {
                byte[] bArr = new byte[j6];
                System.arraycopy(obj, 0, bArr, 0, j6);
                return bArr;
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
            return obj;
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    public static ByteBuffer j6(InputStream inputStream, int i) {
        int read;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                return ByteBuffer.wrap(bArr, 0, i2);
            }
            i2 += read;
        }
        read = inputStream.read();
        if (read < 0) {
            return ByteBuffer.wrap(bArr, 0, i2);
        }
        axj$c axj_c = new axj$c(Integer.MAX_VALUE);
        axj_c.write(bArr);
        axj_c.write(read);
        axj_c.j6(inputStream);
        return ByteBuffer.wrap(axj_c.FH());
    }

    public static void j6(InputStream inputStream, byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int read = inputStream.read(bArr, i, i2);
            if (read <= 0) {
                throw new EOFException(JGitText.j6().shortReadOfBlock);
            }
            i += read;
            i2 -= read;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int j6(java.io.InputStream r3, byte[] r4, int r5) {
        /*
        r0 = 0;
    L_0x0001:
        r1 = r4.length;
        r1 = r1 - r5;
        r1 = r3.read(r4, r5, r1);
        if (r1 < 0) goto L_0x000c;
    L_0x0009:
        r2 = r4.length;
        if (r0 < r2) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r5 = r5 + r1;
        r0 = r0 + r1;
        goto L_0x0001;
        */
        throw new UnsupportedOperationException("Method not decompiled: awx.j6(java.io.InputStream, byte[], int):int");
    }

    public static void j6(InputStream inputStream, long j) {
        while (j > 0) {
            long skip = inputStream.skip(j);
            if (skip <= 0) {
                throw new EOFException(JGitText.j6().shortSkipOfBlock);
            }
            j -= skip;
        }
    }
}
