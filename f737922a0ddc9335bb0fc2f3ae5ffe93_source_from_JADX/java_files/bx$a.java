class bx$a {
    private long DW;
    private dr<bz> EQ;
    private int[] FH;
    private int Hw;
    private dg VH;
    private dg Zo;
    private dt gn;
    private final cc j6;
    private dg tp;
    private dy u7;
    private dg v5;

    public bx$a(cc ccVar) {
        this.FH = new int[1000];
        this.Hw = 0;
        this.v5 = new dg();
        this.Zo = new dg();
        this.VH = new dg();
        this.gn = new dt();
        this.u7 = new dy();
        this.tp = new dg();
        this.j6 = ccVar;
        this.EQ = new dr(ccVar.cb);
    }

    protected void j6(dg dgVar) {
        this.tp.j6();
        this.tp.j6(dgVar);
        this.u7.j6();
    }

    public void j6(long j) {
        this.DW = j;
        this.u7.j6();
        this.tp.j6();
        this.v5.j6();
        this.Zo.j6();
        this.VH.j6();
        this.gn.DW();
        this.EQ.DW();
        this.Hw = 0;
    }

    public void j6(int i, bz bzVar) {
        this.EQ.j6(i, (bs) bzVar);
    }

    public void j6(int i, int i2, int i3, boolean z, bz bzVar, int i4) {
        int i5 = 0;
        int i6 = this.Hw + 5;
        if (i6 >= this.FH.length) {
            Object obj = new int[Math.max(this.FH.length * 2, i6)];
            System.arraycopy(this.FH, 0, obj, 0, this.FH.length);
            this.FH = obj;
        }
        this.v5.j6(i, this.Hw);
        int[] iArr = this.FH;
        int i7 = this.Hw;
        this.Hw = i7 + 1;
        iArr[i7] = i3;
        iArr = this.FH;
        i7 = this.Hw;
        this.Hw = i7 + 1;
        iArr[i7] = i2;
        int[] iArr2 = this.FH;
        int i8 = this.Hw;
        this.Hw = i8 + 1;
        if (z) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        iArr2[i8] = i6;
        iArr = this.FH;
        i7 = this.Hw;
        this.Hw = i7 + 1;
        if (bzVar != null) {
            i5 = bzVar.v5();
        }
        iArr[i7] = i5;
        iArr = this.FH;
        i5 = this.Hw;
        this.Hw = i5 + 1;
        iArr[i5] = i4;
        this.gn.DW(i4, i);
    }

    public void j6(int i, int i2, do doVar, do doVar2) {
        int i3 = 0;
        int Hw = ((this.Hw + 3) + doVar.Hw()) + doVar2.Hw();
        if (Hw >= this.FH.length) {
            Object obj = new int[Math.max(this.FH.length * 2, Hw)];
            System.arraycopy(this.FH, 0, obj, 0, this.FH.length);
            this.FH = obj;
        }
        this.Zo.j6(i, this.Hw);
        int[] iArr = this.FH;
        int i4 = this.Hw;
        this.Hw = i4 + 1;
        iArr[i4] = i2;
        iArr = this.FH;
        i4 = this.Hw;
        this.Hw = i4 + 1;
        iArr[i4] = doVar.Hw();
        iArr = this.FH;
        i4 = this.Hw;
        this.Hw = i4 + 1;
        iArr[i4] = doVar2.Hw();
        for (Hw = 0; Hw < doVar.Hw(); Hw++) {
            int[] iArr2 = this.FH;
            int i5 = this.Hw;
            this.Hw = i5 + 1;
            iArr2[i5] = doVar.FH(Hw);
            this.gn.DW(doVar.FH(Hw), i);
        }
        while (i3 < doVar2.Hw()) {
            iArr = this.FH;
            i4 = this.Hw;
            this.Hw = i4 + 1;
            iArr[i4] = doVar2.FH(i3);
            this.gn.DW(doVar2.FH(i3), i);
            i3++;
        }
        this.gn.DW(i2, i);
    }

    public void j6(int i, int i2, do doVar, int i3) {
        int i4 = 0;
        int Hw = (this.Hw + 3) + doVar.Hw();
        if (Hw >= this.FH.length) {
            Object obj = new int[Math.max(this.FH.length * 2, Hw)];
            System.arraycopy(this.FH, 0, obj, 0, this.FH.length);
            this.FH = obj;
        }
        this.VH.j6(i, this.Hw);
        int[] iArr = this.FH;
        int i5 = this.Hw;
        this.Hw = i5 + 1;
        iArr[i5] = i2;
        iArr = this.FH;
        i5 = this.Hw;
        this.Hw = i5 + 1;
        iArr[i5] = i3;
        iArr = this.FH;
        i5 = this.Hw;
        this.Hw = i5 + 1;
        iArr[i5] = doVar.Hw();
        while (i4 < doVar.Hw()) {
            iArr = this.FH;
            i5 = this.Hw;
            this.Hw = i5 + 1;
            iArr[i5] = doVar.FH(i4);
            this.gn.DW(doVar.FH(i4), i);
            i4++;
        }
        if (i2 != -1) {
            this.gn.DW(i2, i);
        }
    }

    public void j6(int i, int i2) {
        this.tp.j6(i, i2);
    }

    public void DW(int i, int i2) {
        if (i != -1 && i2 != -1) {
            this.u7.j6(i, i2);
        }
    }

    public long j6() {
        return this.DW;
    }

    public dt DW() {
        return this.gn;
    }

    public int j6(int i) {
        return this.FH[this.VH.FH(i)];
    }

    public int DW(int i) {
        return this.FH[this.VH.FH(i) + 2];
    }

    public int FH(int i, int i2) {
        return this.FH[(this.VH.FH(i) + 3) + i2];
    }

    public int FH(int i) {
        return this.FH[this.VH.FH(i) + 1];
    }

    public int Hw(int i) {
        return this.FH[this.Zo.FH(i) + 1];
    }

    public int Hw(int i, int i2) {
        return this.FH[(this.Zo.FH(i) + 3) + i2];
    }

    public int v5(int i) {
        return this.FH[this.Zo.FH(i) + 2];
    }

    public int v5(int i, int i2) {
        return this.FH[((this.Zo.FH(i) + 3) + i2) + this.FH[this.Zo.FH(i) + 1]];
    }

    public int Zo(int i) {
        return this.FH[this.Zo.FH(i)];
    }

    public int VH(int i) {
        return this.FH[this.v5.FH(i) + 4];
    }

    public bz gn(int i) {
        int i2 = this.FH[this.v5.FH(i) + 3];
        return i2 == 0 ? null : (bz) this.j6.cb.FH(i2);
    }

    public boolean u7(int i) {
        return this.FH[this.v5.FH(i) + 2] == 1;
    }

    public int tp(int i) {
        return this.FH[this.v5.FH(i) + 1];
    }

    public int EQ(int i) {
        if (this.v5.DW(i)) {
            return this.FH[this.v5.FH(i)];
        }
        return -1;
    }

    public dg FH() {
        return this.tp;
    }

    public dy Hw() {
        return this.u7;
    }

    public dr<bz> v5() {
        return this.EQ;
    }
}
