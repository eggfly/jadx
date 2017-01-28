import java.io.InputStream;

public class anz$a extends anz {
    private final long DW;
    private final InputStream FH;
    private final int j6;

    public anz$a(int i, long j, InputStream inputStream) {
        this.j6 = i;
        this.DW = j;
        this.FH = inputStream;
    }

    public long j6() {
        return this.DW;
    }

    public int available() {
        return this.FH.available();
    }

    public long skip(long j) {
        return this.FH.skip(j);
    }

    public int read() {
        return this.FH.read();
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.FH.read(bArr, i, i2);
    }

    public boolean markSupported() {
        return this.FH.markSupported();
    }

    public void mark(int i) {
        this.FH.mark(i);
    }

    public void reset() {
        this.FH.reset();
    }

    public void close() {
        this.FH.close();
    }
}
