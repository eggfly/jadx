import java.io.EOFException;
import java.io.InputStream;

class baz extends bbe {
    private static final byte[] DW;
    private final int FH;
    private int Hw;

    static {
        DW = new byte[0];
    }

    baz(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i < 0) {
            throw new IllegalArgumentException("negative lengths not allowed");
        }
        this.FH = i;
        this.Hw = i;
        if (i == 0) {
            DW(true);
        }
    }

    int j6() {
        return this.Hw;
    }

    public int read() {
        if (this.Hw == 0) {
            return -1;
        }
        int read = this.j6.read();
        if (read < 0) {
            throw new EOFException("DEF length " + this.FH + " object truncated by " + this.Hw);
        }
        int i = this.Hw - 1;
        this.Hw = i;
        if (i != 0) {
            return read;
        }
        DW(true);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.Hw == 0) {
            return -1;
        }
        int read = this.j6.read(bArr, i, Math.min(i2, this.Hw));
        if (read < 0) {
            throw new EOFException("DEF length " + this.FH + " object truncated by " + this.Hw);
        }
        int i3 = this.Hw - read;
        this.Hw = i3;
        if (i3 != 0) {
            return read;
        }
        DW(true);
        return read;
    }

    byte[] DW() {
        if (this.Hw == 0) {
            return DW;
        }
        byte[] bArr = new byte[this.Hw];
        int j6 = this.Hw - bhp.j6(this.j6, bArr);
        this.Hw = j6;
        if (j6 != 0) {
            throw new EOFException("DEF length " + this.FH + " object truncated by " + this.Hw);
        }
        DW(true);
        return bArr;
    }
}
