package com.google.android.gms.internal;

public final class p implements Cloneable {
    private static final q j6;
    private boolean DW;
    private int[] FH;
    private q[] Hw;
    private int v5;

    static {
        j6 = new q();
    }

    p() {
        this(10);
    }

    p(int i) {
        this.DW = false;
        int FH = FH(i);
        this.FH = new int[FH];
        this.Hw = new q[FH];
        this.v5 = 0;
    }

    private int FH(int i) {
        return Hw(i * 4) / 4;
    }

    private int Hw(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private void Hw() {
        int i = this.v5;
        int[] iArr = this.FH;
        q[] qVarArr = this.Hw;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            q qVar = qVarArr[i3];
            if (qVar != j6) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    qVarArr[i2] = qVar;
                    qVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.DW = false;
        this.v5 = i2;
    }

    private boolean j6(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean j6(q[] qVarArr, q[] qVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!qVarArr[i2].equals(qVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int v5(int i) {
        int i2 = 0;
        int i3 = this.v5 - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.FH[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    q DW(int i) {
        if (this.DW) {
            Hw();
        }
        return this.Hw[i];
    }

    public boolean DW() {
        return j6() == 0;
    }

    public final p FH() {
        int j6 = j6();
        p pVar = new p(j6);
        System.arraycopy(this.FH, 0, pVar.FH, 0, j6);
        for (int i = 0; i < j6; i++) {
            if (this.Hw[i] != null) {
                pVar.Hw[i] = (q) this.Hw[i].clone();
            }
        }
        pVar.v5 = j6;
        return pVar;
    }

    public /* synthetic */ Object clone() {
        return FH();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return j6() != pVar.j6() ? false : j6(this.FH, pVar.FH, this.v5) && j6(this.Hw, pVar.Hw, this.v5);
    }

    public int hashCode() {
        if (this.DW) {
            Hw();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.v5; i2++) {
            i = (((i * 31) + this.FH[i2]) * 31) + this.Hw[i2].hashCode();
        }
        return i;
    }

    int j6() {
        if (this.DW) {
            Hw();
        }
        return this.v5;
    }

    q j6(int i) {
        int v5 = v5(i);
        return (v5 < 0 || this.Hw[v5] == j6) ? null : this.Hw[v5];
    }

    void j6(int i, q qVar) {
        int v5 = v5(i);
        if (v5 >= 0) {
            this.Hw[v5] = qVar;
            return;
        }
        v5 ^= -1;
        if (v5 >= this.v5 || this.Hw[v5] != j6) {
            if (this.DW && this.v5 >= this.FH.length) {
                Hw();
                v5 = v5(i) ^ -1;
            }
            if (this.v5 >= this.FH.length) {
                int FH = FH(this.v5 + 1);
                Object obj = new int[FH];
                Object obj2 = new q[FH];
                System.arraycopy(this.FH, 0, obj, 0, this.FH.length);
                System.arraycopy(this.Hw, 0, obj2, 0, this.Hw.length);
                this.FH = obj;
                this.Hw = obj2;
            }
            if (this.v5 - v5 != 0) {
                System.arraycopy(this.FH, v5, this.FH, v5 + 1, this.v5 - v5);
                System.arraycopy(this.Hw, v5, this.Hw, v5 + 1, this.v5 - v5);
            }
            this.FH[v5] = i;
            this.Hw[v5] = qVar;
            this.v5++;
            return;
        }
        this.FH[v5] = i;
        this.Hw[v5] = qVar;
    }
}
