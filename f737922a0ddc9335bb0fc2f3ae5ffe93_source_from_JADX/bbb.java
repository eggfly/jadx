import java.io.EOFException;
import java.io.InputStream;

class bbb extends bbe {
    private int DW;
    private int FH;
    private boolean Hw;
    private boolean v5;

    bbb(InputStream inputStream, int i) {
        super(inputStream, i);
        this.Hw = false;
        this.v5 = true;
        this.DW = inputStream.read();
        this.FH = inputStream.read();
        if (this.FH < 0) {
            throw new EOFException();
        }
        DW();
    }

    void j6(boolean z) {
        this.v5 = z;
        DW();
    }

    private boolean DW() {
        if (!this.Hw && this.v5 && this.DW == 0 && this.FH == 0) {
            this.Hw = true;
            DW(true);
        }
        return this.Hw;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.v5 || i2 < 3) {
            return super.read(bArr, i, i2);
        }
        if (this.Hw) {
            return -1;
        }
        int read = this.j6.read(bArr, i + 2, i2 - 2);
        if (read < 0) {
            throw new EOFException();
        }
        bArr[i] = (byte) this.DW;
        bArr[i + 1] = (byte) this.FH;
        this.DW = this.j6.read();
        this.FH = this.j6.read();
        if (this.FH >= 0) {
            return read + 2;
        }
        throw new EOFException();
    }

    public int read() {
        if (DW()) {
            return -1;
        }
        int read = this.j6.read();
        if (read < 0) {
            throw new EOFException();
        }
        int i = this.DW;
        this.DW = this.FH;
        this.FH = read;
        return i;
    }
}
