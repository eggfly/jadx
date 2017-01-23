import java.io.InputStream;

class fa$b extends InputStream {
    private long DW;
    private long FH;
    private InputStream j6;

    public fa$b(InputStream inputStream, long j) {
        this.j6 = inputStream;
        this.DW = j;
        this.FH = 0;
    }

    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0];
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.FH >= this.DW) {
            return -1;
        }
        int read = this.j6.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.FH += (long) read;
        return read;
    }

    public void close() {
        if (this.j6 != null) {
            this.j6.close();
        }
        this.j6 = null;
    }
}
