public class cj {
    private long DW;
    private bl EQ;
    private cc FH;
    private char[] Hw;
    private long J0;
    private int J8;
    private bj Mr;
    private long QX;
    private int VH;
    private long Ws;
    private long XL;
    private int[] Zo;
    private long aM;
    private int[] gn;
    private boolean j3;
    private long j6;
    private int tp;
    private int u7;
    private int v5;
    private bv we;

    public cj(cc ccVar) {
        this.j6 = 1;
        this.DW = 1234567891234567891L - this.j6;
        this.FH = ccVar;
        this.Hw = new char[1000];
        this.v5 = 1;
        this.Zo = new int[10000];
        this.VH = 0;
        this.tp = -1;
        this.gn = new int[1000];
        this.u7 = 0;
        this.Ws = -1;
        this.QX = -1;
        this.XL = -1;
        this.aM = -1;
    }

    public void j6(cj cjVar) {
        if (cjVar.Zo.length < this.VH) {
            cjVar.Zo = new int[((this.VH * 5) / 4)];
        }
        System.arraycopy(this.Zo, 0, cjVar.Zo, 0, this.VH);
        if (cjVar.Hw.length <= this.v5) {
            cjVar.Hw = new char[((this.v5 * 5) / 4)];
        }
        System.arraycopy(this.Hw, 0, cjVar.Hw, 0, this.v5);
        cjVar.v5 = this.v5;
        cjVar.VH = this.VH;
        cjVar.tp = this.tp;
        cjVar.Ws = this.Ws;
        cjVar.QX = this.QX;
        cjVar.XL = this.XL;
        cjVar.aM = this.aM;
        cjVar.we = this.we;
        cjVar.Mr = this.Mr;
        cjVar.EQ = this.EQ;
        cjVar.J0 = this.J0;
        cjVar.u7 = 0;
        cjVar.j3 = this.j3;
        cjVar.u7 = this.u7;
        if (cjVar.gn.length <= this.u7) {
            cjVar.gn = new int[((this.u7 * 5) / 4)];
        }
        System.arraycopy(this.gn, 0, cjVar.gn, 0, this.u7);
    }

    public void j6(cm cmVar) {
        this.v5 = cmVar.gn;
        if (this.Hw.length <= this.v5) {
            this.Hw = new char[((this.v5 * 5) / 4)];
        }
        System.arraycopy(cmVar.VH, 0, this.Hw, 0, this.v5);
    }

    public void j6(int i) {
        this.tp = i;
        this.j3 = true;
    }

    public void j6(bv bvVar, bj bjVar) {
        this.we = bvVar;
        this.Mr = bjVar;
        this.EQ = bjVar.Hw();
    }

    public void j6(long j) {
        this.J0 = j;
    }

    public void DW(int i) {
        this.J8 = i;
    }

    public void j6(int i, int i2) {
        J8(i, 8, i2);
    }

    public void DW(int i, int i2) {
        J8(i, 7, i2);
    }

    public void j6(int i, long j) {
        J8(i, 3, (int) j);
        J8(i, 2, (int) (j >> 32));
    }

    public void FH(int i, int i2) {
        J8(i, 9, i2);
    }

    public void j6(int i, co coVar) {
        if (this.FH.cb != null) {
            if (coVar == null) {
                J8(i, 1, -1);
            }
            J8(i, 1, this.FH.cb.j6((bs) coVar));
        }
    }

    public void j6(int i, int i2, int i3) {
        J8(i, 4, i2);
        J8(i, 5, i3);
    }

    public void DW(int i, co coVar) {
        J8(i, 6, this.FH.cb.j6((bs) coVar));
    }

    public void j6(int i, int i2, bs bsVar) {
        J8(i, 4, i2);
        J8(i, 5, this.FH.cb.j6(bsVar));
    }

    public int j6(char[] cArr, int i, int i2) {
        if ((this.v5 + i2) + 1 >= this.Hw.length) {
            Object obj = new char[Math.max((this.Hw.length * 2) + 1, (this.v5 + i2) + 1)];
            System.arraycopy(this.Hw, 0, obj, 0, this.Hw.length);
            this.Hw = obj;
        }
        int i3 = this.v5;
        char[] cArr2 = this.Hw;
        int i4 = this.v5;
        this.v5 = i4 + 1;
        cArr2[i4] = (char) i2;
        System.arraycopy(cArr, i, this.Hw, this.v5, i2);
        this.v5 += i2;
        return i3;
    }

    public int j6(int i, boolean z, int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = this.VH;
        this.VH += 5;
        while (this.VH >= this.Zo.length) {
            Object obj = new int[((this.Zo.length * 2) + 1)];
            System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
            this.Zo = obj;
        }
        int[] iArr = this.Zo;
        int i7 = i6 + 1;
        if (z) {
            i5 = 1048576;
        }
        iArr[i6] = (i5 | i) | 268435456;
        i5 = i7 + 1;
        iArr[i7] = -1;
        i7 = i5 + 1;
        iArr[i5] = -1;
        i5 = i7 + 1;
        iArr[i7] = i2;
        iArr[i5] = i3;
        return i6;
    }

    public int j6(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 0;
        int i9 = this.VH;
        this.VH += 9;
        while (this.VH >= this.Zo.length) {
            Object obj = new int[((this.Zo.length * 2) + 1)];
            System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
            this.Zo = obj;
        }
        int[] iArr = this.Zo;
        int i10 = i9 + 1;
        if (z) {
            i8 = 1048576;
        }
        iArr[i9] = (i8 | i) | 268435456;
        i8 = i10 + 1;
        iArr[i10] = -1;
        i10 = i8 + 1;
        iArr[i8] = -1;
        i8 = i10 + 1;
        iArr[i10] = i2;
        i10 = i8 + 1;
        iArr[i8] = i3;
        i8 = i10 + 1;
        iArr[i10] = i4;
        i10 = i8 + 1;
        iArr[i8] = i5;
        i8 = i10 + 1;
        iArr[i10] = i6;
        iArr[i8] = i7;
        return i9;
    }

    public int j6(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = this.VH;
        this.VH += 8;
        while (this.VH >= this.Zo.length) {
            Object obj = new int[((this.Zo.length * 2) + 1)];
            System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
            this.Zo = obj;
        }
        int[] iArr = this.Zo;
        int i9 = i8 + 1;
        if (z) {
            i7 = 1048576;
        }
        iArr[i8] = (i7 | i) | 268435456;
        i7 = i9 + 1;
        iArr[i9] = -1;
        i9 = i7 + 1;
        iArr[i7] = -1;
        i7 = i9 + 1;
        iArr[i9] = i2;
        i9 = i7 + 1;
        iArr[i7] = i3;
        i7 = i9 + 1;
        iArr[i9] = i4;
        i9 = i7 + 1;
        iArr[i7] = i5;
        iArr[i9] = i6;
        return i8;
    }

    public int j6(int i, boolean z, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        int i7 = this.VH;
        this.VH += 8;
        while (this.VH >= this.Zo.length) {
            Object obj = new int[((this.Zo.length * 2) + 1)];
            System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
            this.Zo = obj;
        }
        int[] iArr = this.Zo;
        int i8 = i7 + 1;
        if (z) {
            i6 = 1048576;
        }
        iArr[i7] = (i6 | i) | 268435456;
        i6 = i8 + 1;
        iArr[i8] = -1;
        i8 = i6 + 1;
        iArr[i6] = -1;
        i6 = i8 + 1;
        iArr[i8] = i2;
        i8 = i6 + 1;
        iArr[i6] = i3;
        i6 = i8 + 1;
        iArr[i8] = i4;
        iArr[i6] = i5;
        return i7;
    }

    public int j6(int i, boolean z, int[] iArr, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        int i7 = this.VH;
        if (i3 > 0) {
            this.VH += i3 + 4;
        } else {
            this.VH += i3 + 6;
        }
        while (this.VH >= this.Zo.length) {
            Object obj = new int[((this.Zo.length * 2) + 1)];
            System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
            this.Zo = obj;
        }
        Object obj2 = this.Zo;
        int i8 = i7 + 1;
        obj2[i7] = (z ? 1048576 : 0) | i;
        int i9 = i8 + 1;
        obj2[i8] = -1;
        i8 = i9 + 1;
        obj2[i9] = -1;
        i9 = i8 + 1;
        obj2[i8] = i3;
        if (i3 > 0) {
            System.arraycopy(iArr, i2, obj2, i9, i3);
            while (i6 < i3) {
                obj2[iArr[i2 + i6] + 1] = i7;
                i6++;
            }
        } else {
            i6 = i9 + 1;
            obj2[i9] = i4;
            i9 = i6 + 1;
            obj2[i6] = i5;
        }
        return i7;
    }

    public int j6(int i, boolean z, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = this.VH;
        if (i3 > 0) {
            this.VH += i3 + 5;
        } else {
            this.VH += i3 + 7;
        }
        while (this.VH >= this.Zo.length) {
            Object obj = new int[((this.Zo.length * 2) + 1)];
            System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
            this.Zo = obj;
        }
        Object obj2 = this.Zo;
        int i9 = i8 + 1;
        obj2[i8] = (z ? 1048576 : 0) | i;
        int i10 = i9 + 1;
        obj2[i9] = -1;
        i9 = i10 + 1;
        obj2[i10] = -1;
        i10 = i9 + 1;
        obj2[i9] = i3;
        if (i3 > 0) {
            System.arraycopy(iArr, i2, obj2, i10, i3);
            while (i7 < i3) {
                obj2[iArr[i2 + i7] + 1] = i8;
                i7++;
            }
            i10 += i3;
        } else {
            i7 = i10 + 1;
            obj2[i10] = i4;
            i10 = i7 + 1;
            obj2[i7] = i5;
        }
        obj2[i10] = i6;
        return i8;
    }

    public long j6() {
        return (long) ((this.VH * 4) + (this.u7 * 4));
    }

    public long DW() {
        return (long) ((this.Zo.length * 4) + (this.gn.length * 4));
    }

    public void FH() {
        this.v5 = 1;
        this.VH = 0;
        this.tp = -1;
        this.Ws = -1;
        this.u7 = 0;
        this.QX = -1;
        this.XL = -1;
        this.aM = -1;
    }

    public void Hw() {
        if (!this.j3) {
            CU(Ws());
            this.j3 = true;
            this.u7 = 0;
        }
    }

    public long v5() {
        if (this.Ws != -1) {
            return this.Ws;
        }
        bk Zo = tp().Zo();
        if (Zo == null) {
            return 0;
        }
        this.Ws = Zo.DW(this);
        return this.Ws;
    }

    public long Zo() {
        if (this.aM != -1) {
            return this.aM;
        }
        bk Zo = tp().Zo();
        if (Zo == null) {
            return 0;
        }
        this.aM = Zo.j6(this);
        return this.aM;
    }

    public long VH() {
        if (this.XL != -1) {
            return this.XL;
        }
        bk Zo = tp().Zo();
        if (Zo == null) {
            return 0;
        }
        this.XL = Zo.FH(this);
        return this.XL;
    }

    public long gn() {
        if (this.QX != -1) {
            return this.QX;
        }
        bk Zo = tp().Zo();
        if (Zo == null) {
            return 0;
        }
        this.QX = Zo.Hw(this);
        return this.QX;
    }

    public boolean u7() {
        return this.tp == -1;
    }

    public bj tp() {
        return this.Mr;
    }

    public cc EQ() {
        return this.FH;
    }

    public bv we() {
        return this.we;
    }

    public long J0() {
        return this.J0;
    }

    public int J8() {
        return this.J8;
    }

    public int FH(int i) {
        return j3(i, 8);
    }

    public boolean Hw(int i) {
        return j3(i, 8) != -1;
    }

    public int v5(int i) {
        return j3(i, 7);
    }

    public int Zo(int i) {
        return j3(i, 9);
    }

    public boolean VH(int i) {
        return j3(i, 9) != -1;
    }

    public long gn(int i) {
        return (((long) j3(i, 2)) << 32) + (((long) j3(i, 3)) & 4294967295L);
    }

    public boolean u7(int i) {
        if (this.EQ.ei(rN(i)) && gn(i) != this.DW) {
            return true;
        }
        return false;
    }

    public boolean tp(int i) {
        return j3(i, 6) != -1;
    }

    public co EQ(int i) {
        return (co) this.FH.cb.FH(j3(i, 6));
    }

    public co we(int i) {
        return (co) this.FH.cb.FH(j3(i, 1));
    }

    public boolean J0(int i) {
        boolean z = true;
        if (!this.EQ.P8(rN(i))) {
            return false;
        }
        if (j3(i, 1) == -1) {
            z = false;
        }
        return z;
    }

    public int J8(int i) {
        return j3(i, 4);
    }

    public int Ws(int i) {
        return j3(i, 5);
    }

    public bs QX(int i) {
        return this.FH.cb.FH(j3(i, 5));
    }

    public int XL(int i) {
        if (yS(i)) {
            return this.Zo[i + 8];
        }
        if (this.Zo[i + 3] == 0) {
            return this.Zo[i + 6];
        }
        return this.Zo[(i + 4) + this.Zo[i + 3]];
    }

    public int aM(int i) {
        return this.Zo[i + 1];
    }

    public int Ws() {
        return this.tp;
    }

    public char[] j3(int i) {
        return this.Hw;
    }

    public int Mr(int i) {
        return this.Zo[i + 3] + 1;
    }

    public int U2(int i) {
        return this.Hw[this.Zo[i + 3]];
    }

    public String a8(int i) {
        int i2 = this.Zo[i + 3];
        return new String(this.Hw, i2 + 1, this.Hw[i2]);
    }

    public int lg(int i) {
        if ((this.Zo[i] & 268435456) != 0) {
            return 0;
        }
        return this.Zo[i + 3];
    }

    public int Hw(int i, int i2) {
        return this.Zo[(i + 4) + i2];
    }

    public int rN(int i) {
        return this.Zo[i] & 65535;
    }

    public boolean er(int i) {
        return (this.Zo[i] & 1048576) != 0;
    }

    public boolean yS(int i) {
        return (this.Zo[i] & 268435456) != 0;
    }

    public int gW(int i) {
        return this.Zo[i + 3];
    }

    public String BT(int i) {
        return this.FH.ro.j6(this.Zo[i + 3]);
    }

    public int v5(int i, int i2) {
        return Zo(Ws(), i, i2);
    }

    private int Zo(int i, int i2, int i3) {
        int i4;
        int Zo;
        if (!yS(i) || this.EQ.j3(rN(i))) {
            int lg = lg(i);
            i4 = 0;
            int i5 = Integer.MAX_VALUE;
            while (i4 < lg) {
                Zo = Zo(Hw(i, i4), i2, i3);
                if (Zo >= i5) {
                    Zo = i5;
                }
                i4++;
                i5 = Zo;
            }
            return i5;
        }
        Zo = nw(i);
        if (Zo > i2) {
            return (Zo - i2) * 1000;
        }
        i4 = SI(i);
        if (i4 < i2) {
            return (i2 - i4) * 1000;
        }
        if (i4 == Zo) {
            Zo = KD(i);
            if (Zo > i3) {
                return Zo - i3;
            }
            Zo = ro(i);
            if (Zo < i3) {
                return i3 - Zo;
            }
            return 0;
        } else if (i2 == Zo) {
            Zo = KD(i);
            if (Zo > i3) {
                return Zo - i3;
            }
            return 0;
        } else if (i2 != i4) {
            return 0;
        } else {
            Zo = ro(i);
            if (Zo < i3) {
                return i3 - Zo;
            }
            return 0;
        }
    }

    public boolean vy(int i) {
        return this.EQ.j6(rN(i));
    }

    public boolean P8(int i) {
        return this.EQ.J8(rN(i));
    }

    public boolean ei(int i) {
        return this.EQ.QX(rN(i));
    }

    public int nw(int i) {
        if (yS(i)) {
            if (P8(i)) {
                return this.Zo[i + 4];
            }
            if (sy(i)) {
                return this.Zo[i + 4];
            }
            if (ei(i)) {
                return this.Zo[i + 3];
            }
            return this.Zo[i + 3];
        } else if (lg(i) == 0) {
            return this.Zo[i + 4];
        } else {
            return nw(Hw(i, 0));
        }
    }

    public int SI(int i) {
        if (yS(i)) {
            if (P8(i)) {
                return this.Zo[i + 6];
            }
            if (sy(i)) {
                return this.Zo[i + 6];
            }
            if (ei(i)) {
                return this.Zo[i + 5];
            }
            return this.Zo[i + 3];
        } else if (lg(i) == 0) {
            return this.Zo[i + 4];
        } else {
            return SI(Hw(i, lg(i) - 1));
        }
    }

    public int KD(int i) {
        if (yS(i)) {
            if (P8(i)) {
                return this.Zo[i + 5];
            }
            if (sy(i)) {
                return this.Zo[i + 5];
            }
            if (ei(i)) {
                return this.Zo[i + 4];
            }
            return this.Zo[i + 4];
        } else if (lg(i) == 0) {
            return this.Zo[i + 5];
        } else {
            return KD(Hw(i, 0));
        }
    }

    public int ro(int i) {
        if (yS(i)) {
            if (P8(i)) {
                return this.Zo[i + 7];
            }
            if (sy(i)) {
                return this.Zo[i + 7];
            }
            if (ei(i)) {
                return this.Zo[i + 6];
            }
            if (er(i)) {
                return this.Zo[i + 4];
            }
            return this.Zo[i + 4] + this.EQ.aM(rN(i));
        } else if (lg(i) == 0) {
            return this.Zo[i + 5];
        } else {
            return ro(Hw(i, lg(i) - 1));
        }
    }

    public String toString() {
        if (u7()) {
            return "\n";
        }
        StringBuffer stringBuffer = new StringBuffer();
        j6(stringBuffer, "", new ck(), Ws());
        return stringBuffer.toString();
    }

    public int j6(int i, int i2, int i3, int i4) {
        return DW(Ws(), i, i2, i3, i4);
    }

    public boolean Zo(int i, int i2) {
        if (i2 == i) {
            return true;
        }
        while (i2 != Ws()) {
            i2 = aM(i2);
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean cn(int i) {
        return Hw(aM(i), 0) != i;
    }

    public int sh(int i) {
        int aM = aM(i);
        for (int i2 = 1; i2 < lg(aM); i2++) {
            if (Hw(aM, i2) == i) {
                return Hw(aM, i2 - 1);
            }
        }
        return -1;
    }

    public boolean cb(int i) {
        return Hw(aM(i), lg(aM(i)) + -1) != i;
    }

    public int dx(int i) {
        int aM = aM(i);
        for (int i2 = 0; i2 < lg(aM) - 1; i2++) {
            if (Hw(aM, i2) == i) {
                return Hw(aM, i2 + 1);
            }
        }
        return -1;
    }

    public boolean DW(int i, int i2, int i3) {
        if (nw(i) == 0 || i2 < nw(i) || i2 > SI(i)) {
            return false;
        }
        if (nw(i) == SI(i)) {
            if (i3 < KD(i) || i3 >= ro(i)) {
                return false;
            }
        } else if (i2 == nw(i) && i3 < KD(i)) {
            return false;
        } else {
            if (i2 == SI(i) && i3 >= ro(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean FH(int i, int i2, int i3) {
        if (i2 < nw(i) || i2 > SI(i)) {
            return false;
        }
        if (nw(i) == SI(i)) {
            if (i3 < KD(i) || i3 > ro(i)) {
                return false;
            }
        } else if (i2 == nw(i) && i3 < KD(i)) {
            return false;
        } else {
            if (i2 == SI(i) && i3 > ro(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean Hw(int i, int i2, int i3) {
        if (nw(i) == 0 || i2 < SI(i)) {
            return false;
        }
        if (i2 > SI(i)) {
            return true;
        }
        if (ro(i) <= i3) {
            return true;
        }
        return false;
    }

    public boolean v5(int i, int i2, int i3) {
        if (i2 > nw(i)) {
            return false;
        }
        if (i2 < nw(i)) {
            return true;
        }
        if (KD(i) > i3) {
            return true;
        }
        return false;
    }

    public boolean VH(int i, int i2) {
        if (rN(i) != rN(i2)) {
            return false;
        }
        int lg = lg(i);
        if (lg != lg(i2)) {
            return false;
        }
        if (this.EQ.gn(rN(i)) && gW(i) != gW(i2)) {
            return false;
        }
        int i3;
        if (this.EQ.J8(rN(i))) {
            char[] j3 = j3(i);
            int Mr = Mr(i);
            int U2 = U2(i);
            char[] j32 = j3(i2);
            int Mr2 = Mr(i2);
            if (U2 != U2(i2)) {
                return false;
            }
            for (i3 = 0; i3 < U2; i3++) {
                if (j3[Mr + i3] != j32[Mr2 + i3]) {
                    return false;
                }
            }
        }
        for (i3 = 0; i3 < lg; i3++) {
            if (!VH(Hw(i, i3), Hw(i2, i3))) {
                return false;
            }
        }
        return true;
    }

    public int gn(int i, int i2) {
        return u7(Ws(), i, i2);
    }

    public int u7(int i, int i2) {
        return tp(Ws(), i, i2);
    }

    public int tp(int i, int i2) {
        return VH(Ws(), i, i2);
    }

    public int EQ(int i, int i2) {
        return gn(Ws(), i, i2);
    }

    public int sG(int i) {
        return XL(Ws(), i);
    }

    public int ef(int i) {
        return aM(Ws(), i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public do DW(int r9, int r10, int r11, int r12) {
        /*
        r8 = this;
        r2 = 0;
        r1 = -1;
        r6 = r8.v5(r9, r10, r11, r12);
        if (r6 != r1) goto L_0x000a;
    L_0x0008:
        r0 = r2;
    L_0x0009:
        return r0;
    L_0x000a:
        r4 = r8.lg(r6);
        r3 = 0;
    L_0x000f:
        if (r3 >= r4) goto L_0x005b;
    L_0x0011:
        r0 = r8.Hw(r6, r3);
        r5 = r8.DW(r0, r9, r10);
        if (r5 != 0) goto L_0x0021;
    L_0x001b:
        r5 = r8.v5(r0, r9, r10);
        if (r5 == 0) goto L_0x003c;
    L_0x0021:
        r4 = r4 + -1;
        r5 = r4;
    L_0x0024:
        if (r5 < 0) goto L_0x0059;
    L_0x0026:
        r4 = r8.Hw(r6, r5);
        r7 = r8.DW(r4, r11, r12);
        if (r7 != 0) goto L_0x0036;
    L_0x0030:
        r7 = r8.Hw(r4, r11, r12);
        if (r7 == 0) goto L_0x003f;
    L_0x0036:
        if (r0 == r1) goto L_0x003a;
    L_0x0038:
        if (r4 != r1) goto L_0x0043;
    L_0x003a:
        r0 = r2;
        goto L_0x0009;
    L_0x003c:
        r3 = r3 + 1;
        goto L_0x000f;
    L_0x003f:
        r4 = r5 + -1;
        r5 = r4;
        goto L_0x0024;
    L_0x0043:
        if (r3 <= r5) goto L_0x0047;
    L_0x0045:
        r0 = r2;
        goto L_0x0009;
    L_0x0047:
        r0 = new do;
        r0.<init>();
        r1 = r3;
    L_0x004d:
        if (r1 > r5) goto L_0x0009;
    L_0x004f:
        r2 = r8.Hw(r6, r1);
        r0.DW(r2);
        r1 = r1 + 1;
        goto L_0x004d;
    L_0x0059:
        r4 = r1;
        goto L_0x0036;
    L_0x005b:
        r0 = r1;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.DW(int, int, int, int):do");
    }

    public int FH(int i, int i2, int i3, int i4) {
        int v5 = v5(i, i2, i3, i4);
        if (v5 == -1) {
            return -1;
        }
        int lg = lg(v5);
        for (int i5 = 1; i5 < lg - 1; i5++) {
            int Hw = Hw(v5, i5);
            if (DW(Hw, i, i2) || v5(Hw, i, i2)) {
                return Hw;
            }
        }
        if (lg == 0) {
            return v5;
        }
        return Hw(v5, lg - 1);
    }

    public int Hw(int i, int i2, int i3, int i4) {
        int v5 = v5(i, i2, i3, i4);
        if (v5 == -1) {
            return -1;
        }
        int Hw;
        int lg = lg(v5);
        for (int i5 = 1; i5 < lg - 1; i5++) {
            Hw = Hw(v5, i5);
            if (this.EQ.EQ(rN(Hw)) && (DW(Hw, i, i2) || v5(Hw, i, i2))) {
                return Hw;
            }
        }
        Hw = Hw(v5, lg - 1);
        if (lg == 0 || !this.EQ.EQ(rN(Hw))) {
            return v5;
        }
        return Hw;
    }

    public int v5(int i, int i2, int i3, int i4) {
        return Hw(Ws(), i, i2, i3, i4);
    }

    public int Zo(int i, int i2, int i3, int i4) {
        int FH = FH(Ws(), i, i2, i3, i4);
        if (FH != -1) {
            while (FH != Ws()) {
                if (this.EQ.Zo(rN(FH))) {
                    return FH;
                }
                FH = aM(FH);
            }
        }
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public do VH(int r9, int r10, int r11, int r12) {
        /*
        r8 = this;
        r2 = 0;
        r1 = -1;
        r6 = r8.Zo(r9, r10, r11, r12);
        if (r6 != r1) goto L_0x000a;
    L_0x0008:
        r0 = r2;
    L_0x0009:
        return r0;
    L_0x000a:
        r4 = r8.lg(r6);
        r3 = 0;
    L_0x000f:
        r0 = r4 + -1;
        if (r3 >= r0) goto L_0x005d;
    L_0x0013:
        r0 = r8.Hw(r6, r3);
        r5 = r8.DW(r0, r9, r10);
        if (r5 != 0) goto L_0x0023;
    L_0x001d:
        r5 = r8.v5(r0, r9, r10);
        if (r5 == 0) goto L_0x003e;
    L_0x0023:
        r4 = r4 + -1;
        r5 = r4;
    L_0x0026:
        if (r5 < 0) goto L_0x005b;
    L_0x0028:
        r4 = r8.Hw(r6, r5);
        r7 = r8.DW(r4, r11, r12);
        if (r7 != 0) goto L_0x0038;
    L_0x0032:
        r7 = r8.Hw(r4, r11, r12);
        if (r7 == 0) goto L_0x0041;
    L_0x0038:
        if (r0 == r1) goto L_0x003c;
    L_0x003a:
        if (r4 != r1) goto L_0x0045;
    L_0x003c:
        r0 = r2;
        goto L_0x0009;
    L_0x003e:
        r3 = r3 + 1;
        goto L_0x000f;
    L_0x0041:
        r4 = r5 + -1;
        r5 = r4;
        goto L_0x0026;
    L_0x0045:
        if (r3 <= r5) goto L_0x0049;
    L_0x0047:
        r0 = r2;
        goto L_0x0009;
    L_0x0049:
        r0 = new do;
        r0.<init>();
        r1 = r3;
    L_0x004f:
        if (r1 > r5) goto L_0x0009;
    L_0x0051:
        r2 = r8.Hw(r6, r1);
        r0.DW(r2);
        r1 = r1 + 1;
        goto L_0x004f;
    L_0x005b:
        r4 = r1;
        goto L_0x0038;
    L_0x005d:
        r0 = r1;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.VH(int, int, int, int):do");
    }

    public int we(int i, int i2) {
        int EQ = EQ(Ws(), i, i2);
        if (EQ == -1 || !this.EQ.Zo(rN(EQ))) {
            return EQ;
        }
        return -1;
    }

    public int J0(int i, int i2) {
        return we(Ws(), i, i2);
    }

    public int J8(int i, int i2) {
        return v5(Ws(), i, i2 + 1, i, i2 + 1);
    }

    public int Ws(int i, int i2) {
        return Zo(Ws(), i, i2, i, i2);
    }

    public int j6(int i, int i2, int i3, int i4, int i5) {
        return j6(Ws(), i, i2, i3, i4, i5);
    }

    public int gn(int i, int i2, int i3, int i4) {
        return VH(Ws(), i, i2, i3, i4);
    }

    public int u7(int i, int i2, int i3, int i4) {
        return gn(Ws(), i, i2, i3, i4);
    }

    public int QX(int i, int i2) {
        return J0(Ws(), i, i2);
    }

    public boolean Sf(int i) {
        return this.EQ.gn(this, i);
    }

    public boolean vJ(int i) {
        return this.EQ.u7(this, i);
    }

    public boolean g3(int i) {
        return this.EQ.lg(rN(i));
    }

    public boolean Mz(int i) {
        return !Sf(i);
    }

    public int tp(int i, int i2, int i3, int i4) {
        return u7(Ws(), i, i2, i3, i4);
    }

    private boolean et(int i) {
        return ca(i) || I(i) || x9(i);
    }

    public boolean I(int i) {
        return this.EQ.J0(rN(i));
    }

    public boolean ca(int i) {
        return this.EQ.FH(rN(i));
    }

    public boolean x9(int i) {
        return this.EQ.Hw(rN(i));
    }

    public boolean Qq(int i) {
        return this.EQ.VH(rN(i));
    }

    public boolean sy(int i) {
        return this.EQ.gn(rN(i));
    }

    public boolean aj(int i) {
        return this.EQ.tp(rN(i));
    }

    public boolean lp(int i) {
        return this.EQ.gn(rN(i)) && this.EQ.DW(this, i);
    }

    public boolean OW(int i) {
        return this.EQ.gn(rN(i)) && this.EQ.j6(this, i);
    }

    public boolean br(int i) {
        return this.EQ.DW(rN(i));
    }

    public boolean XX(int i) {
        return this.EQ.v5(rN(i));
    }

    public boolean kQ(int i) {
        return this.EQ.FH(this, i);
    }

    public boolean yO(int i) {
        return this.EQ.Hw(this, i);
    }

    public int XG(int i) {
        return this.EQ.v5(this, i);
    }

    public int jJ(int i) {
        return this.EQ.Zo(this, i);
    }

    public boolean wc(int i) {
        return this.EQ.VH(this, i);
    }

    public do QX() {
        return this.EQ.j6(this);
    }

    public do XL() {
        return this.EQ.DW(this);
    }

    public int aM() {
        return this.EQ.Zo(this);
    }

    public int j3() {
        return this.EQ.v5(this);
    }

    public int Mr() {
        return this.EQ.Hw(this);
    }

    public int U2() {
        return this.EQ.FH(this);
    }

    private int DW(int i, int i2, int i3, int i4, int i5) {
        int lg = lg(i);
        for (int i6 = 0; i6 < lg; i6++) {
            int DW = DW(Hw(i, i6), i2, i3, i4, i5);
            if (DW != -1) {
                return DW;
            }
        }
        if (DW(i, i2, i3) && FH(i, i4, i5)) {
            return i;
        }
        return -1;
    }

    private int FH(int i, int i2, int i3, int i4, int i5) {
        int lg = lg(i);
        for (int i6 = 0; i6 < lg; i6++) {
            int FH = FH(Hw(i, i6), i2, i3, i4, i5);
            if (FH != -1) {
                return FH;
            }
        }
        if (FH(i, i2, i3) && FH(i, i4, i5)) {
            return i;
        }
        return -1;
    }

    private int VH(int i, int i2, int i3) {
        if (yS(i) && FH(i, i2, i3)) {
            return i;
        }
        int lg = lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            int VH = VH(Hw(i, i4), i2, i3);
            if (VH != -1) {
                return VH;
            }
        }
        return -1;
    }

    private int gn(int i, int i2, int i3) {
        if (yS(i) && DW(i, i2, i3)) {
            return i;
        }
        int lg = lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            int gn = gn(Hw(i, i4), i2, i3);
            if (gn != -1) {
                return gn;
            }
        }
        return -1;
    }

    private int XL(int i, int i2) {
        if (this.EQ.we(rN(i)) && XL(i) == i2) {
            return i;
        }
        int lg = lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            int XL = XL(Hw(i, i3), i2);
            if (XL != -1) {
                return XL;
            }
        }
        return -1;
    }

    private int u7(int i, int i2, int i3) {
        if (this.EQ.gn(rN(i)) && FH(i, i2, i3)) {
            return i;
        }
        int lg = lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            int u7 = u7(Hw(i, i4), i2, i3);
            if (u7 != -1) {
                return u7;
            }
        }
        return -1;
    }

    private int tp(int i, int i2, int i3) {
        if (this.EQ.gn(rN(i)) && DW(i, i2, i3)) {
            return i;
        }
        int lg = lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            int tp = tp(Hw(i, i4), i2, i3);
            if (tp != -1) {
                return tp;
            }
        }
        return -1;
    }

    private int aM(int i, int i2) {
        if (this.EQ.J0(rN(i)) && XL(i) == i2) {
            return i;
        }
        int lg = lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            int aM = aM(Hw(i, i3), i2);
            if (aM != -1) {
                return aM;
            }
        }
        return -1;
    }

    private int Hw(int i, int i2, int i3, int i4, int i5) {
        int lg = lg(i);
        for (int i6 = 0; i6 < lg; i6++) {
            int Hw = Hw(Hw(i, i6), i2, i3, i4, i5);
            if (Hw != -1) {
                return Hw;
            }
        }
        if (this.EQ.VH(rN(i)) && DW(i, i2, i3) && DW(i, i4, i5)) {
            return i;
        }
        return -1;
    }

    private int EQ(int i, int i2, int i3) {
        int lg = lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            int EQ = EQ(Hw(i, i4), i2, i3);
            if (EQ != -1) {
                return EQ;
            }
        }
        if (this.EQ.v5(rN(i)) || this.EQ.Zo(rN(i))) {
            if (FH(i, i2, i3)) {
                return i;
            }
            if (SI(i) == 0 && nw(i) != 0) {
                if (i2 > nw(i)) {
                    return i;
                }
                if (i2 == nw(i) && i3 >= KD(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int we(int i, int i2, int i3) {
        int lg = lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            int we = we(Hw(i, i4), i2, i3);
            if (we != -1) {
                return we;
            }
        }
        if (this.EQ.DW(rN(i)) && FH(i, i2, i3)) {
            return i;
        }
        return -1;
    }

    private int v5(int i, int i2, int i3, int i4, int i5) {
        if (this.EQ.u7(rN(i)) && nw(i) == i2 && KD(i) == i3) {
            return i;
        }
        int lg = lg(i);
        for (int i6 = 0; i6 < lg; i6++) {
            int v5 = v5(Hw(i, i6), i2, i3, i4, i5);
            if (v5 != -1) {
                return v5;
            }
        }
        return -1;
    }

    private int Zo(int i, int i2, int i3, int i4, int i5) {
        int lg = lg(i);
        for (int i6 = 0; i6 < lg; i6++) {
            int Zo = Zo(Hw(i, i6), i2, i3, i4, i5);
            if (Zo != -1) {
                return Zo;
            }
        }
        if (this.EQ.u7(rN(i)) && DW(i, i2, i3) && DW(i, i4, i5)) {
            return i;
        }
        return -1;
    }

    private int j6(int i, int i2, int i3, int i4, int i5, int i6) {
        int lg = lg(i);
        for (int i7 = 0; i7 < lg; i7++) {
            int j6 = j6(Hw(i, i7), i2, i3, i4, i5, i6);
            if (j6 != -1) {
                return j6;
            }
        }
        return (rN(i) == i2 && DW(i, i3, i4) && DW(i, i5, i6)) ? i : -1;
    }

    private int VH(int i, int i2, int i3, int i4, int i5) {
        int lg = lg(i);
        for (int i6 = 0; i6 < lg; i6++) {
            int VH = VH(Hw(i, i6), i2, i3, i4, i5);
            if (VH != -1) {
                return VH;
            }
        }
        if (this.EQ.EQ(rN(i)) && DW(i, i2, i3) && DW(i, i4, i5)) {
            return i;
        }
        return -1;
    }

    private int gn(int i, int i2, int i3, int i4, int i5) {
        int lg = lg(i);
        for (int i6 = 0; i6 < lg; i6++) {
            int gn = gn(Hw(i, i6), i2, i3, i4, i5);
            if (gn != -1) {
                return gn;
            }
        }
        if (this.EQ.FH(rN(i)) && DW(i, i2, i3) && DW(i, i4, i5)) {
            return i;
        }
        return -1;
    }

    private int J0(int i, int i2, int i3) {
        int lg = lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            int J0 = J0(Hw(i, i4), i2, i3);
            if (J0 != -1) {
                return J0;
            }
        }
        if (this.EQ.FH(rN(i))) {
            if (DW(i, i2, i3)) {
                return i;
            }
            if (cn(i) && Hw(sh(i), i2, i3) && v5(i, i2, i3)) {
                return i;
            }
        }
        return -1;
    }

    private int u7(int i, int i2, int i3, int i4, int i5) {
        int lg = lg(i);
        for (int i6 = 0; i6 < lg; i6++) {
            int u7 = u7(Hw(i, i6), i2, i3, i4, i5);
            if (u7 != -1) {
                return u7;
            }
        }
        if (this.EQ.u7(rN(i)) && !vJ(i) && DW(i, i2, i3) && FH(i, i4, i5)) {
            return i;
        }
        return -1;
    }

    private void j6(StringBuffer stringBuffer, String str, ck ckVar, int i) {
        int i2;
        int i3 = 0;
        String str2 = "(" + ckVar.DW(this, i) + "," + ckVar.FH(this, i) + "-" + ckVar.Hw(this, i) + "," + ckVar.v5(this, i) + ") " + i + "                     ";
        if (str2.length() > 25) {
            str2 = str2.substring(0, 25);
        }
        if (this.EQ.gn(rN(i))) {
            stringBuffer.append(str2 + str + BT(i));
        } else if (this.EQ.J8(rN(i))) {
            stringBuffer.append(str2 + str + a8(i));
        } else {
            stringBuffer.append(str2 + str + this.EQ.XL(rN(i)));
        }
        if (this.EQ != null) {
            for (i2 = 0; i2 < Xa(rN(i)); i2++) {
                stringBuffer.append(" " + j3(i, i2));
            }
        }
        if (et(i)) {
            stringBuffer.append(" " + XL(i));
        }
        if (er(i)) {
            stringBuffer.append(" synthetic");
        }
        stringBuffer.append("\n");
        i2 = lg(i);
        while (i3 < i2) {
            j6(stringBuffer, str + "  ", ckVar, Hw(i, i3));
            i3++;
        }
    }

    private void CU(int i) {
        int lg = lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            CU(Hw(i, i2));
        }
        this.Zo[i + 2] = -1;
    }

    private int Xa(int i) {
        if (this.EQ.vy(i)) {
            return 10;
        }
        if (this.EQ.BT(i)) {
            return 9;
        }
        if (this.EQ.gW(i)) {
            return 8;
        }
        if (this.EQ.gn(i) || this.EQ.v5(i) || this.EQ.DW(i)) {
            return 7;
        }
        if (this.EQ.ei(i)) {
            return 4;
        }
        if (this.EQ.P8(i)) {
            return 2;
        }
        return 0;
    }

    private void J8(int i, int i2, int i3) {
        this.j3 = false;
        int i4 = this.Zo[i + 2];
        if (i4 == -1) {
            i4 = Eq(i);
        }
        this.gn[i4 + i2] = i3;
    }

    private int Eq(int i) {
        int i2 = this.u7;
        this.Zo[i + 2] = i2;
        int rN = rN(i);
        this.u7 += Xa(rN);
        if (this.u7 >= this.gn.length) {
            Object obj = new int[Math.min(this.u7 * 2, (this.gn.length * 2) + 1)];
            System.arraycopy(this.gn, 0, obj, 0, this.gn.length);
            this.gn = obj;
        }
        if (this.EQ.P8(rN)) {
            j6(i, null);
        }
        if (this.EQ.BT(rN)) {
            j6(i, -1);
        }
        if (this.EQ.ei(rN)) {
            j6(i, this.DW);
        }
        if (this.EQ.gn(rN)) {
            J8(i, 4, 0);
            J8(i, 6, -1);
        }
        if (this.EQ.DW(rN)) {
            J8(i, 4, 0);
        }
        if (this.EQ.v5(rN)) {
            J8(i, 4, 0);
        }
        if (this.EQ.vy(rN)) {
            FH(i, -1);
        }
        return i2;
    }

    private int j3(int i, int i2) {
        int i3 = this.Zo[i + 2];
        if (i3 == -1) {
            i3 = Eq(i);
        }
        if (i3 + i2 > this.gn.length) {
            System.out.println("");
        }
        return this.gn[i3 + i2];
    }
}
