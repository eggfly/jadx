import java.io.OutputStream;

public class qb extends OutputStream {
    private final OutputStream DW;
    private final OutputStream j6;

    public qb(OutputStream outputStream, OutputStream outputStream2) {
        this.j6 = outputStream;
        this.DW = outputStream2;
    }

    public void write(int i) {
        if (this.j6 != null) {
            this.j6.write(i);
        }
        if (this.DW != null) {
            this.DW.write(i);
        }
    }

    public void write(byte[] bArr) {
        if (this.j6 != null) {
            this.j6.write(bArr);
        }
        if (this.DW != null) {
            this.DW.write(bArr);
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.j6 != null) {
            this.j6.write(bArr, i, i2);
        }
        if (this.DW != null) {
            this.DW.write(bArr, i, i2);
        }
    }

    public void flush() {
        if (this.j6 != null) {
            this.j6.flush();
        }
        if (this.DW != null) {
            this.DW.flush();
        }
    }

    public void close() {
        if (this.j6 != null) {
            this.j6.close();
        }
        if (this.DW != null) {
            this.DW.close();
        }
    }
}
