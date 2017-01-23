import com.aide.uidesigner.ProxyTextView;

public class eb {
    public static final ec DW;
    private static final int[] Hw;
    private final bw FH;
    private int VH;
    private int[] Zo;
    private int gn;
    public final eb$a j6;
    private int u7;
    private int[] v5;

    static {
        Hw = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
        DW = new ec();
    }

    public eb(bw bwVar) {
        this.j6 = new eb$a();
        this.FH = bwVar;
        this.u7 = 1;
        this.v5 = new int[Hw[this.u7]];
        this.VH = 0;
        this.gn = 0;
    }

    public eb(bw bwVar, ee eeVar) {
        int i = 0;
        this.j6 = new eb$a();
        this.FH = bwVar;
        int readInt = eeVar.readInt();
        this.u7 = eeVar.readInt();
        this.v5 = new int[Hw[this.u7]];
        this.VH = 0;
        this.gn = 0;
        while (i < readInt) {
            DW(eeVar.readInt());
            i++;
        }
    }

    public void j6(ef efVar) {
        efVar.writeInt(this.gn);
        efVar.writeInt(this.u7);
        for (int i = 0; i < this.v5.length; i++) {
            int i2 = this.v5[i];
            if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                efVar.writeInt(this.v5[i]);
            }
        }
    }

    public void j6() {
        if (this.VH > 0) {
            for (int i = 0; i < this.v5.length; i++) {
                this.v5[i] = 0;
            }
            this.VH = 0;
            this.gn = 0;
        }
    }

    public void j6(eb ebVar) {
        for (int i : ebVar.v5) {
            if (i == Integer.MAX_VALUE) {
                DW(0);
            } else if (!(i == 0 || i == Integer.MIN_VALUE)) {
                DW(i);
            }
        }
    }

    public void j6(bv bvVar) {
        DW(this.FH.QX(bvVar));
    }

    private void DW(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.v5.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.v5.length - 2)) + 1;
        int i2 = this.v5[length];
        int i3 = -1;
        while (i2 != 0) {
            if (i2 != i) {
                if (i2 == Integer.MIN_VALUE) {
                    i3 = length;
                }
                i2 = (length + length2) % this.v5.length;
                length = i2;
                i2 = this.v5[i2];
            } else {
                return;
            }
        }
        if (i3 != -1) {
            length = i3;
        }
        this.v5[length] = i;
        if (i3 == -1) {
            this.VH++;
        }
        this.gn++;
        if (this.VH * 2 > this.v5.length) {
            Hw();
        }
    }

    public void DW(bv bvVar) {
        int QX = this.FH.QX(bvVar);
        if (QX == 0) {
            QX = Integer.MAX_VALUE;
        }
        int length = (QX & Integer.MAX_VALUE) % this.v5.length;
        int length2 = ((Integer.MAX_VALUE & QX) % (this.v5.length - 2)) + 1;
        int i = this.v5[length];
        while (i != QX) {
            if (i != 0) {
                length = (length + length2) % this.v5.length;
                i = this.v5[length];
            } else {
                return;
            }
        }
        this.v5[length] = Integer.MIN_VALUE;
        this.gn--;
    }

    public bv DW() {
        int i = 0;
        int i2 = 0;
        while (i2 < this.v5.length) {
            int i3 = this.v5[i2];
            i2++;
            if (i3 != 0 && i3 != Integer.MIN_VALUE) {
                if (i3 != Integer.MAX_VALUE) {
                    i = i3;
                }
                return this.FH.gn(i);
            }
        }
        return null;
    }

    public boolean FH(bv bvVar) {
        return j6(this.FH.QX(bvVar));
    }

    public boolean j6(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = ((i & Integer.MAX_VALUE) % (this.v5.length - 2)) + 1;
        int length2 = (Integer.MAX_VALUE & i) % this.v5.length;
        int i2 = this.v5[length2];
        while (i2 != i) {
            if (i2 == 0) {
                return false;
            }
            length2 = (length2 + length) % this.v5.length;
            i2 = this.v5[length2];
        }
        return true;
    }

    private void Hw() {
        int[] iArr;
        int i = 0;
        if (this.gn * 2 > this.v5.length) {
            this.u7++;
            this.Zo = null;
            iArr = new int[Hw[this.u7]];
        } else if (this.Zo == null || this.Zo.length != this.v5.length) {
            this.Zo = this.v5;
            iArr = new int[Hw[this.u7]];
        } else {
            int[] iArr2 = this.Zo;
            for (int i2 = 0; i2 < iArr2.length; i2++) {
                iArr2[i2] = 0;
            }
            this.Zo = this.v5;
            iArr = iArr2;
        }
        int i3 = 0;
        while (i < this.v5.length) {
            int i4 = this.v5[i];
            if (!(i4 == 0 || i4 == Integer.MIN_VALUE)) {
                int length = ((i4 & Integer.MAX_VALUE) % (iArr.length - 2)) + 1;
                int length2 = (i4 & Integer.MAX_VALUE) % iArr.length;
                while (iArr[length2] != 0) {
                    length2 = (length2 + length) % iArr.length;
                }
                iArr[length2] = i4;
                i3++;
            }
            i++;
        }
        this.v5 = iArr;
        this.VH = i3;
    }

    public int FH() {
        return this.gn;
    }

    public String toString() {
        String str = "{";
        for (int i : this.v5) {
            int i2;
            if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                if (i2 == Integer.MAX_VALUE) {
                    i2 = 0;
                }
                str = str + i2 + " " + this.FH.gn(i2).er() + ", ";
            }
        }
        return str + "}";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ec)) {
            return false;
        }
        ec ecVar = (ec) obj;
        if (ecVar.Hw() != FH()) {
            return false;
        }
        for (int i : this.v5) {
            int i2;
            if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                if (i2 == Integer.MAX_VALUE) {
                    i2 = 0;
                }
                if (!ecVar.FH(i2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
