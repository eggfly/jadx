public class anz$b extends anz {
    private final byte[] DW;
    private int FH;
    private int Hw;
    private final int j6;

    public anz$b(anx anx) {
        this(anx.DW(), anx.v5());
    }

    public anz$b(int i, byte[] bArr) {
        this.j6 = i;
        this.DW = bArr;
    }

    public long j6() {
        return (long) this.DW.length;
    }

    public int available() {
        return this.DW.length - this.FH;
    }

    public long skip(long j) {
        int min = (int) Math.min((long) available(), Math.max(0, j));
        this.FH += min;
        return (long) min;
    }

    public int read() {
        if (this.FH == this.DW.length) {
            return -1;
        }
        byte[] bArr = this.DW;
        int i = this.FH;
        this.FH = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.FH == this.DW.length) {
            return -1;
        }
        int min = Math.min(available(), i2);
        System.arraycopy(this.DW, this.FH, bArr, i, min);
        this.FH += min;
        return min;
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int i) {
        this.Hw = this.FH;
    }

    public void reset() {
        this.FH = this.Hw;
    }
}
