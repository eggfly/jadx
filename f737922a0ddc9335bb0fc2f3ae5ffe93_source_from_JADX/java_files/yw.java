public final class yw {
    private final short[] DW;
    private final yz EQ;
    private final short[] FH;
    private final short[] Hw;
    private final yz VH;
    private final yz Zo;
    private final yz gn;
    private final int[] j6;
    private final yz tp;
    private final yz u7;
    private final short[] v5;

    public yw(int i, int i2, int i3, int i4, int i5) {
        this.j6 = new int[i];
        this.DW = new short[i2];
        this.FH = new short[i3];
        this.Hw = new short[i4];
        this.v5 = new short[i5];
        this.Zo = new yz();
        this.VH = new yz();
        this.gn = new yz();
        this.u7 = new yz();
        this.tp = new yz();
        this.EQ = new yz();
        this.Zo.j6(0, 0);
        this.gn.j6(0, 0);
        this.tp.j6(0, 0);
        this.EQ.j6(0, 0);
    }

    public yf j6(yf yfVar) {
        return new yf(j6(yfVar.j6()), j6(yfVar.DW()), j6(yfVar.FH()), j6(yfVar.Hw()));
    }

    private yf$a[] j6(yf$a[] yf_aArr) {
        yf$a[] yf_aArr2 = new yf$a[yf_aArr.length];
        for (int i = 0; i < yf_aArr.length; i++) {
            yf_aArr2[i] = j6(yf_aArr[i]);
        }
        return yf_aArr2;
    }

    private yf$a j6(yf$a yf_a) {
        return new yf$a(Hw(yf_a.j6()), yf_a.DW());
    }

    private yf$b[] j6(yf$b[] yf_bArr) {
        yf$b[] yf_bArr2 = new yf$b[yf_bArr.length];
        for (int i = 0; i < yf_bArr.length; i++) {
            yf_bArr2[i] = j6(yf_bArr[i]);
        }
        return yf_bArr2;
    }

    private yf$b j6(yf$b yf_b) {
        return new yf$b(v5(yf_b.j6()), yf_b.DW(), yf_b.FH());
    }

    public void j6(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.Zo.j6(i, i2);
    }

    public void DW(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.VH.j6(i, i2);
    }

    public void FH(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.gn.j6(i, i2);
    }

    public void Hw(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.u7.j6(i, i2);
    }

    public void v5(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.tp.j6(i, i2);
    }

    public void Zo(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.EQ.j6(i, i2);
    }

    public int j6(int i) {
        return i == -1 ? -1 : this.j6[i];
    }

    public int DW(int i) {
        return i == -1 ? -1 : this.DW[i] & 65535;
    }

    public ys j6(ys ysVar) {
        if (ysVar == ys.j6) {
            return ysVar;
        }
        short[] sArr = (short[]) ysVar.j6().clone();
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) DW(sArr[i]);
        }
        return new ys(null, sArr);
    }

    public int FH(int i) {
        return this.FH[i] & 65535;
    }

    public int Hw(int i) {
        return this.Hw[i] & 65535;
    }

    public int v5(int i) {
        return this.v5[i] & 65535;
    }

    public int Zo(int i) {
        return this.Zo.j6(i);
    }

    public int VH(int i) {
        return this.VH.j6(i);
    }

    public int gn(int i) {
        return this.gn.j6(i);
    }

    public int u7(int i) {
        return this.u7.j6(i);
    }

    public int tp(int i) {
        return this.tp.j6(i);
    }

    public int EQ(int i) {
        return this.EQ.j6(i);
    }

    public yn j6(yn ynVar) {
        return new yn(null, DW(ynVar.j6()), FH(ynVar.DW()), j6(ynVar.FH()));
    }

    public yl j6(yl ylVar) {
        return new yl(null, DW(ylVar.j6()), DW(ylVar.DW()), j6(ylVar.FH()));
    }

    public yq j6(yq yqVar) {
        return new yq(null, j6(yqVar.j6()), DW(yqVar.DW()), Zo(yqVar.FH()));
    }

    public yg j6(yg ygVar) {
        return new yg(null, ygVar.j6(), DW(ygVar.DW()), ygVar.v5(), DW(ygVar.FH()), Zo(ygVar.Hw()), j6(ygVar.Zo()), tp(ygVar.VH()), ygVar.gn(), EQ(ygVar.u7()));
    }

    public yj j6(yj yjVar) {
        Object acv = new acv(32);
        new yw$a(this, yjVar, acv).FH();
        return new yj(acv.Zo());
    }

    public yj DW(yj yjVar) {
        Object acv = new acv(32);
        new yw$a(this, yjVar, acv).j6();
        return new yj(acv.Zo());
    }

    public ya j6(ya yaVar) {
        int[] iArr = (int[]) yaVar.FH().clone();
        yj[] yjVarArr = (yj[]) yaVar.Hw().clone();
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = j6(iArr[i]);
            yjVarArr[i] = j6(yjVarArr[i]);
        }
        return new ya(null, yaVar.j6(), DW(yaVar.DW()), iArr, yjVarArr);
    }

    public yc j6(yc ycVar) {
        int[] iArr = (int[]) ycVar.j6().clone();
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = VH(iArr[i]);
        }
        return new yc(iArr);
    }

    public yd j6(yd ydVar) {
        int[] j6 = ydVar.j6();
        for (int i = 0; i < j6.length; i++) {
            j6[i] = gn(j6[i]);
        }
        return new yd(j6);
    }

    public yb j6(yb ybVar) {
        int i;
        int i2 = 0;
        int gn = gn(ybVar.j6());
        int[] iArr = (int[]) ybVar.DW().clone();
        for (i = 0; i < iArr.length; i++) {
            iArr[i] = Hw(iArr[i]);
        }
        int[] iArr2 = (int[]) ybVar.FH().clone();
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i] = gn(iArr2[i]);
        }
        int[] iArr3 = (int[]) ybVar.Hw().clone();
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i] = v5(iArr3[i]);
        }
        int[] iArr4 = (int[]) ybVar.v5().clone();
        for (i = 0; i < iArr4.length; i++) {
            iArr4[i] = gn(iArr4[i]);
        }
        int[] iArr5 = (int[]) ybVar.Zo().clone();
        for (i = 0; i < iArr5.length; i++) {
            iArr5[i] = v5(iArr5[i]);
        }
        int[] iArr6 = (int[]) ybVar.VH().clone();
        while (i2 < iArr6.length) {
            iArr6[i2] = u7(iArr6[i2]);
            i2++;
        }
        return new yb(gn, iArr, iArr2, iArr3, iArr4, iArr5, iArr6);
    }

    public void VH(int i, int i2) {
        this.j6[i] = i2;
    }

    public void gn(int i, int i2) {
        this.DW[i] = (short) i2;
    }

    public void u7(int i, int i2) {
        this.FH[i] = (short) i2;
    }

    public void tp(int i, int i2) {
        this.v5[i] = (short) i2;
    }

    void EQ(int i, int i2) {
        this.Hw[i] = (short) i2;
    }
}
