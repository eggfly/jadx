import java.io.OutputStream;

public class bhq extends OutputStream {
    private OutputStream DW;
    private OutputStream j6;

    public bhq(OutputStream outputStream, OutputStream outputStream2) {
        this.j6 = outputStream;
        this.DW = outputStream2;
    }

    public void write(byte[] bArr) {
        this.j6.write(bArr);
        this.DW.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.j6.write(bArr, i, i2);
        this.DW.write(bArr, i, i2);
    }

    public void write(int i) {
        this.j6.write(i);
        this.DW.write(i);
    }

    public void flush() {
        this.j6.flush();
        this.DW.flush();
    }

    public void close() {
        this.j6.close();
        this.DW.close();
    }
}
