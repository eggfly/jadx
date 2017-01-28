public abstract class avx {
    protected static final byte[] v5;
    protected final int EQ;
    avx VH;
    final avx Zo;
    int gn;
    protected byte[] tp;
    protected int u7;
    protected int we;

    public abstract void DW(int i);

    public abstract boolean Hw();

    public abstract int Zo();

    public abstract boolean gn();

    public abstract avx j6(any any);

    public abstract void j6(int i);

    public abstract boolean u7();

    public abstract byte[] v5();

    static {
        v5 = new byte[20];
    }

    protected avx() {
        this.Zo = null;
        this.tp = new byte[128];
        this.EQ = 0;
    }

    protected avx(byte[] bArr) {
        this.Zo = null;
        if (bArr == null || bArr.length <= 0) {
            this.tp = new byte[128];
            this.EQ = 0;
            return;
        }
        this.we = bArr.length;
        this.tp = new byte[Math.max(128, this.we + 1)];
        System.arraycopy(bArr, 0, this.tp, 0, this.we);
        if (this.tp[this.we - 1] != (byte) 47) {
            byte[] bArr2 = this.tp;
            int i = this.we;
            this.we = i + 1;
            bArr2[i] = (byte) 47;
        }
        this.EQ = this.we;
    }

    protected avx(avx avx) {
        this.Zo = avx;
        this.tp = avx.tp;
        this.EQ = avx.we + 1;
        try {
            this.tp[this.EQ - 1] = (byte) 47;
        } catch (ArrayIndexOutOfBoundsException e) {
            FH(avx.we);
            this.tp[this.EQ - 1] = (byte) 47;
        }
    }

    protected avx(avx avx, byte[] bArr, int i) {
        this.Zo = avx;
        this.tp = bArr;
        this.EQ = i;
    }

    protected void FH(int i) {
        DW(this.tp.length << 1, i);
    }

    protected void j6(int i, int i2) {
        if (this.tp.length < i) {
            int length = this.tp.length;
            while (length < i && length > 0) {
                length <<= 1;
            }
            DW(length, i2);
        }
    }

    private void DW(int i, int i2) {
        Object obj = this.tp;
        Object obj2 = new byte[i];
        System.arraycopy(obj, 0, obj2, 0, i2);
        while (this != null && this.tp == obj) {
            this.tp = obj2;
            this = this.Zo;
        }
    }

    public int j6(avx avx) {
        return j6(avx, avx.u7);
    }

    int j6(avx avx, int i) {
        int j6 = j6(this, avx);
        return j6(avx.tp, j6, avx.we, i, j6);
    }

    public int j6(byte[] bArr, int i, int i2, int i3) {
        return j6(bArr, i, i2, i3, 0);
    }

    private int j6(byte[] bArr, int i, int i2, int i3, int i4) {
        byte[] bArr2 = this.tp;
        int i5 = this.we;
        while (i4 < i5 && i < i2) {
            int i6 = (bArr2[i4] & 255) - (bArr[i] & 255);
            if (i6 != 0) {
                return i6;
            }
            i4++;
            i++;
        }
        if (i4 < i5) {
            return (bArr2[i4] & 255) - Hw(i3);
        }
        if (i < i2) {
            return Hw(this.u7) - (bArr[i] & 255);
        }
        return Hw(this.u7) - Hw(i3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int j6(avx r3, avx r4) {
        /*
    L_0x0000:
        r0 = r3.Zo;
        r4 = r4.Zo;
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        if (r4 != 0) goto L_0x000a;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = r0.VH;
        r2 = r4.VH;
        if (r1 != r2) goto L_0x0013;
    L_0x0010:
        r0 = r3.EQ;
        goto L_0x0009;
    L_0x0013:
        r3 = r0;
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: avx.j6(avx, avx):int");
    }

    private static int Hw(int i) {
        return anl.j6.DW(i) ? 47 : 0;
    }

    public boolean DW(avx avx) {
        return ans.j6(v5(), Zo(), avx.v5(), avx.Zo());
    }

    public ans EQ() {
        return ans.Hw(v5(), Zo());
    }

    public void j6(ano ano) {
        ano.Hw(v5(), Zo());
    }

    public anl we() {
        return anl.j6(this.u7);
    }

    public int J0() {
        return this.u7;
    }

    public String J8() {
        return awc.DW(this);
    }

    public avz FH() {
        return new avz(this);
    }

    public avx j6(any any, ano ano) {
        return j6(any);
    }

    public void VH() {
        while (!gn()) {
            DW(1);
        }
    }

    public void j6() {
        j6(1);
    }

    public void DW() {
    }
}
