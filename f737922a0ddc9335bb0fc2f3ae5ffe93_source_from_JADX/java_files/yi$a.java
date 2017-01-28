public final class yi$a implements acx, acy {
    private final String DW;
    private int FH;
    private final int Hw;
    final /* synthetic */ yi j6;
    private final int v5;

    private yi$a(yi yiVar, String str, int i, int i2) {
        this.j6 = yiVar;
        this.DW = str;
        this.v5 = i;
        this.FH = i;
        this.Hw = i2;
    }

    private yi$a(yi yiVar, int i) {
        this(yiVar, "section", i, yiVar.DW.length);
    }

    public int j6() {
        return this.FH;
    }

    public byte[] DW() {
        return this.j6.DW;
    }

    public int FH() {
        int i = (((this.j6.DW[this.FH] & 255) | ((this.j6.DW[this.FH + 1] & 255) << 8)) | ((this.j6.DW[this.FH + 2] & 255) << 16)) | ((this.j6.DW[this.FH + 3] & 255) << 24);
        this.FH += 4;
        return i;
    }

    public short Hw() {
        int i = (this.j6.DW[this.FH] & 255) | ((this.j6.DW[this.FH + 1] & 255) << 8);
        this.FH += 2;
        return (short) i;
    }

    public int v5() {
        return Hw() & 65535;
    }

    public byte Zo() {
        byte[] Hw = this.j6.DW;
        int i = this.FH;
        this.FH = i + 1;
        return (byte) (Hw[i] & 255);
    }

    public byte[] j6(int i) {
        byte[] j6 = yi.DW(this.j6.DW, this.FH, this.FH + i);
        this.FH += i;
        return j6;
    }

    public short[] DW(int i) {
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = Hw();
        }
        return sArr;
    }

    public int VH() {
        return adk.DW(this);
    }

    public int gn() {
        return adk.DW(this) - 1;
    }

    public int u7() {
        return adk.j6((acx) this);
    }

    public ys tp() {
        int FH = FH();
        short[] sArr = new short[FH];
        for (int i = 0; i < FH; i++) {
            sArr[i] = Hw();
        }
        a8();
        return new ys(this.j6, sArr);
    }

    public String EQ() {
        int FH = FH();
        int i = this.FH;
        this.FH = FH;
        try {
            FH = VH();
            String j6 = ado.j6(this, new char[FH]);
            if (j6.length() != FH) {
                throw new acz("Declared length " + FH + " doesn't match decoded length of " + j6.length());
            }
            this.FH = i;
            return j6;
        } catch (Throwable e) {
            throw new acz(e);
        } catch (Throwable th) {
            this.FH = i;
        }
    }

    public yl we() {
        return new yl(this.j6, v5(), v5(), FH());
    }

    public yn J0() {
        return new yn(this.j6, v5(), v5(), FH());
    }

    public yq J8() {
        return new yq(this.j6, FH(), FH(), FH());
    }

    public yg Ws() {
        return new yg(this.j6, j6(), FH(), FH(), FH(), FH(), FH(), FH(), FH(), FH());
    }

    private yh lg() {
        int i = 0;
        int v5 = v5();
        int v52 = v5();
        int v53 = v5();
        int v54 = v5();
        int FH = FH();
        short[] DW = DW(FH());
        yh$b[] yh_bArr = new yh$b[v54];
        yh$a[] yh_aArr = new yh$a[0];
        if (v54 > 0) {
            if (DW.length % 2 == 1) {
                Hw();
            }
            for (int i2 = 0; i2 < v54; i2++) {
                yh_bArr[i2] = new yh$b(FH(), v5(), v5());
            }
            v54 = j6();
            int VH = VH();
            yh_aArr = new yh$a[VH];
            while (i < VH) {
                yh_aArr[i] = Hw(v54);
                i++;
            }
        }
        return new yh(v5, v52, v53, FH, DW, yh_bArr, yh_aArr);
    }

    private yh$a Hw(int i) {
        int j6 = j6() - i;
        int u7 = u7();
        int abs = Math.abs(u7);
        int[] iArr = new int[abs];
        int[] iArr2 = new int[abs];
        for (int i2 = 0; i2 < abs; i2++) {
            iArr[i2] = VH();
            iArr2[i2] = VH();
        }
        return new yh$a(j6, iArr, iArr2, u7 <= 0 ? VH() : -1);
    }

    private yf rN() {
        return new yf(v5(VH()), v5(VH()), Zo(VH()), Zo(VH()));
    }

    private yf$a[] v5(int i) {
        int i2 = 0;
        yf$a[] yf_aArr = new yf$a[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += VH();
            yf_aArr[i2] = new yf$a(i3, VH());
            i2++;
        }
        return yf_aArr;
    }

    private yf$b[] Zo(int i) {
        int i2 = 0;
        yf$b[] yf_bArr = new yf$b[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += VH();
            yf_bArr[i2] = new yf$b(i3, VH(), VH());
            i2++;
        }
        return yf_bArr;
    }

    public ya QX() {
        byte Zo = Zo();
        int VH = VH();
        int VH2 = VH();
        int[] iArr = new int[VH2];
        yj[] yjVarArr = new yj[VH2];
        for (int i = 0; i < VH2; i++) {
            iArr[i] = VH();
            yjVarArr[i] = Mr();
        }
        return new ya(this.j6, Zo, VH, iArr, yjVarArr);
    }

    public yc XL() {
        int FH = FH();
        int[] iArr = new int[FH];
        for (int i = 0; i < FH; i++) {
            iArr[i] = FH();
        }
        return new yc(iArr);
    }

    public yd aM() {
        int FH = FH();
        int[] iArr = new int[FH];
        for (int i = 0; i < FH; i++) {
            iArr[i] = FH();
        }
        return new yd(iArr);
    }

    public yb j3() {
        int i = 0;
        int FH = FH();
        int FH2 = FH();
        int FH3 = FH();
        int FH4 = FH();
        int[] iArr = FH2 == 0 ? ye.j6 : new int[FH2];
        int[] iArr2 = FH2 == 0 ? ye.j6 : new int[FH2];
        for (int i2 = 0; i2 < FH2; i2++) {
            iArr[i2] = FH();
            iArr2[i2] = FH();
        }
        int[] iArr3 = FH3 == 0 ? ye.j6 : new int[FH3];
        int[] iArr4 = FH3 == 0 ? ye.j6 : new int[FH3];
        for (int i3 = 0; i3 < FH3; i3++) {
            iArr3[i3] = FH();
            iArr4[i3] = FH();
        }
        int[] iArr5 = FH4 == 0 ? ye.j6 : new int[FH4];
        int[] iArr6 = FH4 == 0 ? ye.j6 : new int[FH4];
        while (i < FH4) {
            iArr5[i] = FH();
            iArr6[i] = FH();
            i++;
        }
        return new yb(FH, iArr, iArr2, iArr3, iArr4, iArr5, iArr6);
    }

    public yj Mr() {
        int i = this.FH;
        new yk((acx) this).FH();
        return new yj(yi.DW(this.j6.DW, i, this.FH));
    }

    public yj U2() {
        int i = this.FH;
        new yk((acx) this).j6();
        return new yj(yi.DW(this.j6.DW, i, this.FH));
    }

    private void VH(int i) {
        if (this.FH + i > this.Hw) {
            throw new acz("Section limit " + this.Hw + " exceeded by " + this.DW);
        }
    }

    public void a8() {
        this.FH = yi.Hw(this.FH);
        for (int i = this.FH; i < this.FH; i++) {
            this.j6.DW[i] = (byte) 0;
        }
    }

    public void FH(int i) {
        VH(1);
        byte[] Hw = this.j6.DW;
        int i2 = this.FH;
        this.FH = i2 + 1;
        Hw[i2] = (byte) i;
    }
}
