import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class anx {
    public abstract int DW();

    public abstract anz FH();

    public abstract long j6();

    public abstract byte[] v5();

    public boolean Hw() {
        try {
            v5();
            return false;
        } catch (alf e) {
            return true;
        }
    }

    public final byte[] j6(int i) {
        try {
            return j6(DW(i));
        } catch (OutOfMemoryError e) {
            throw new alf$c(e);
        }
    }

    public byte[] DW(int i) {
        if (!Hw()) {
            return v5();
        }
        InputStream FH = FH();
        try {
            long j6 = FH.j6();
            if (((long) i) < j6) {
                throw new alf$b((long) i, j6);
            } else if (2147483647L < j6) {
                throw new alf$a();
            } else {
                byte[] bArr = new byte[((int) j6)];
                awx.j6(FH, bArr, 0, bArr.length);
                FH.close();
                return bArr;
            }
        } catch (OutOfMemoryError e) {
            throw new alf$c(e);
        } catch (Throwable th) {
            FH.close();
        }
    }

    public void j6(OutputStream outputStream) {
        if (Hw()) {
            anz FH = FH();
            try {
                long j6 = FH.j6();
                byte[] bArr = new byte[8192];
                long j = 0;
                while (j < j6) {
                    int read = FH.read(bArr);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    outputStream.write(bArr, 0, read);
                    j += (long) read;
                }
                if (FH.read() >= 0) {
                    throw new EOFException();
                }
            } finally {
                FH.close();
            }
        } else {
            outputStream.write(v5());
        }
    }

    private static byte[] j6(byte[] bArr) {
        Object obj = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        return obj;
    }
}
