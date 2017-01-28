import java.io.InputStream;
import java.io.OutputStream;

public class axr extends InputStream {
    private InputStream DW;
    private OutputStream FH;
    private byte[] j6;

    public axr(InputStream inputStream, OutputStream outputStream) {
        this.DW = inputStream;
        this.FH = outputStream;
    }

    public int read() {
        byte[] j6 = j6();
        return read(j6, 0, 1) == 1 ? j6[0] & 255 : -1;
    }

    public long skip(long j) {
        byte[] j6 = j6();
        long j2 = 0;
        while (0 < j) {
            int read = this.DW.read(j6, 0, (int) Math.min((long) j6.length, j));
            if (read <= 0) {
                break;
            }
            this.FH.write(j6, 0, read);
            j2 += (long) read;
            j -= (long) read;
        }
        return j2;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int read = this.DW.read(bArr, i, i2);
        if (read <= 0) {
            return read;
        }
        this.FH.write(bArr, i, read);
        return read;
    }

    public void close() {
        byte[] j6 = j6();
        while (true) {
            int read = this.DW.read(j6);
            if (read <= 0) {
                this.FH.close();
                this.DW.close();
                return;
            }
            this.FH.write(j6, 0, read);
        }
    }

    private byte[] j6() {
        if (this.j6 == null) {
            this.j6 = new byte[2048];
        }
        return this.j6;
    }
}
