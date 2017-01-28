public abstract class bes implements beo {
    private int DW;
    private long FH;
    private byte[] j6;

    protected abstract void DW(byte[] bArr, int i);

    protected abstract void j6(long j);

    protected abstract void v5();

    protected bes() {
        this.j6 = new byte[4];
        this.DW = 0;
    }

    protected bes(bes bes) {
        this.j6 = new byte[bes.j6.length];
        System.arraycopy(bes.j6, 0, this.j6, 0, bes.j6.length);
        this.DW = bes.DW;
        this.FH = bes.FH;
    }

    public void j6(byte b) {
        byte[] bArr = this.j6;
        int i = this.DW;
        this.DW = i + 1;
        bArr[i] = b;
        if (this.DW == this.j6.length) {
            DW(this.j6, 0);
            this.DW = 0;
        }
        this.FH++;
    }

    public void j6(byte[] bArr, int i, int i2) {
        while (this.DW != 0 && i2 > 0) {
            j6(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.j6.length) {
            DW(bArr, i);
            i += this.j6.length;
            i2 -= this.j6.length;
            this.FH += (long) this.j6.length;
        }
        while (i2 > 0) {
            j6(bArr[i]);
            i++;
            i2--;
        }
    }

    public void Hw() {
        long j = this.FH << 3;
        j6(Byte.MIN_VALUE);
        while (this.DW != 0) {
            j6((byte) 0);
        }
        j6(j);
        v5();
    }

    public void FH() {
        this.FH = 0;
        this.DW = 0;
        for (int i = 0; i < this.j6.length; i++) {
            this.j6[i] = (byte) 0;
        }
    }
}
