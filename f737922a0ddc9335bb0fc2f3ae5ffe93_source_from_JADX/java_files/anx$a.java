public class anx$a extends anx {
    private final byte[] DW;
    private final int j6;

    public anx$a(int i, byte[] bArr) {
        this.j6 = i;
        this.DW = bArr;
    }

    public int DW() {
        return this.j6;
    }

    public long j6() {
        return (long) v5().length;
    }

    public boolean Hw() {
        return false;
    }

    public byte[] v5() {
        return this.DW;
    }

    public anz FH() {
        return new anz$b(this);
    }
}
