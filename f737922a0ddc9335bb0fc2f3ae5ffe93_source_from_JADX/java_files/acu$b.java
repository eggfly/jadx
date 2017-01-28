import java.io.InputStream;

public class acu$b extends InputStream {
    private int DW;
    private int FH;
    final /* synthetic */ acu j6;

    public acu$b(acu acu) {
        this.j6 = acu;
        this.DW = 0;
        this.FH = 0;
    }

    public int read() {
        if (this.DW >= this.j6.FH) {
            return -1;
        }
        int j6 = this.j6.gn(this.DW);
        this.DW++;
        return j6;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            i2 = bArr.length - i;
        }
        int j6 = this.j6.FH - this.DW;
        if (i2 > j6) {
            i2 = j6;
        }
        System.arraycopy(this.j6.j6, this.DW + this.j6.DW, bArr, i, i2);
        this.DW += i2;
        return i2;
    }

    public int available() {
        return this.j6.FH - this.DW;
    }

    public void mark(int i) {
        this.FH = this.DW;
    }

    public void reset() {
        this.DW = this.FH;
    }

    public boolean markSupported() {
        return true;
    }
}
