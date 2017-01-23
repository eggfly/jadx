public final class acu {
    private final int DW;
    private final int FH;
    private final byte[] j6;

    public acu(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("start < 0");
        } else if (i2 < i) {
            throw new IllegalArgumentException("end < start");
        } else if (i2 > bArr.length) {
            throw new IllegalArgumentException("end > bytes.length");
        } else {
            this.j6 = bArr;
            this.DW = i;
            this.FH = i2 - i;
        }
    }

    public acu(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public int j6() {
        return this.FH;
    }

    public acu j6(int i, int i2) {
        DW(i, i2);
        return new acu(this.j6, this.DW + i, this.DW + i2);
    }

    public int j6(int i) {
        DW(i, i + 1);
        return VH(i);
    }

    public int DW(int i) {
        DW(i, i + 2);
        return (VH(i) << 8) | gn(i + 1);
    }

    public int FH(int i) {
        DW(i, i + 4);
        return (((VH(i) << 24) | (gn(i + 1) << 16)) | (gn(i + 2) << 8)) | gn(i + 3);
    }

    public long Hw(int i) {
        DW(i, i + 8);
        return (((long) ((((VH(i) << 24) | (gn(i + 1) << 16)) | (gn(i + 2) << 8)) | gn(i + 3))) << 32) | (((long) ((((VH(i + 4) << 24) | (gn(i + 5) << 16)) | (gn(i + 6) << 8)) | gn(i + 7))) & 4294967295L);
    }

    public int v5(int i) {
        DW(i, i + 1);
        return gn(i);
    }

    public int Zo(int i) {
        DW(i, i + 2);
        return (gn(i) << 8) | gn(i + 1);
    }

    public void j6(byte[] bArr, int i) {
        if (bArr.length - i < this.FH) {
            throw new IndexOutOfBoundsException("(out.length - offset) < size()");
        }
        System.arraycopy(this.j6, this.DW, bArr, i, this.FH);
    }

    private void DW(int i, int i2) {
        if (i < 0 || i2 < i || i2 > this.FH) {
            throw new IllegalArgumentException("bad range: " + i + ".." + i2 + "; actual size " + this.FH);
        }
    }

    private int VH(int i) {
        return this.j6[this.DW + i];
    }

    private int gn(int i) {
        return this.j6[this.DW + i] & 255;
    }

    public acu$a DW() {
        return new acu$a(FH());
    }

    public acu$b FH() {
        return new acu$b(this);
    }
}
