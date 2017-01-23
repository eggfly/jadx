import com.aide.uidesigner.ProxyTextView;

public class ec {
    public static final ec DW;
    private static final int[] FH;
    private int[] Hw;
    private int VH;
    private int Zo;
    private int gn;
    public final ec$a j6;
    private int[] v5;

    static {
        FH = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
        DW = new ec();
    }

    public ec() {
        this.j6 = new ec$a();
        this.gn = 1;
        this.Hw = new int[FH[this.gn]];
        this.Zo = 0;
        this.VH = 0;
    }

    public ec(ee eeVar) {
        int i = 0;
        this.j6 = new ec$a();
        int readInt = eeVar.readInt();
        this.gn = eeVar.readInt();
        this.Hw = new int[FH[this.gn]];
        this.Zo = 0;
        this.VH = 0;
        while (i < readInt) {
            j6(eeVar.readInt());
            i++;
        }
    }

    public void j6(ef efVar) {
        efVar.writeInt(this.VH);
        efVar.writeInt(this.gn);
        for (int i = 0; i < this.Hw.length; i++) {
            int i2 = this.Hw[i];
            if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                efVar.writeInt(this.Hw[i]);
            }
        }
    }

    public void j6() {
        if (this.Zo > 0) {
            for (int i = 0; i < this.Hw.length; i++) {
                this.Hw[i] = 0;
            }
            this.Zo = 0;
            this.VH = 0;
        }
    }

    public void j6(ec ecVar) {
        for (int i : ecVar.Hw) {
            if (i == Integer.MAX_VALUE) {
                j6(0);
            } else if (!(i == 0 || i == Integer.MIN_VALUE)) {
                j6(i);
            }
        }
    }

    public void j6(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.Hw.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.Hw.length - 2)) + 1;
        int i2 = this.Hw[length];
        int i3 = -1;
        while (i2 != 0) {
            if (i2 != i) {
                if (i2 == Integer.MIN_VALUE) {
                    i3 = length;
                }
                i2 = (length + length2) % this.Hw.length;
                length = i2;
                i2 = this.Hw[i2];
            } else {
                return;
            }
        }
        if (i3 != -1) {
            length = i3;
        }
        this.Hw[length] = i;
        if (i3 == -1) {
            this.Zo++;
        }
        this.VH++;
        if (this.Zo * 2 > this.Hw.length) {
            v5();
        }
    }

    public void DW(ec ecVar) {
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            DW(ecVar.j6.FH());
        }
    }

    public void DW(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.Hw.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.Hw.length - 2)) + 1;
        int i2 = this.Hw[length];
        while (i2 != i) {
            if (i2 != 0) {
                length = (length + length2) % this.Hw.length;
                i2 = this.Hw[length];
            } else {
                return;
            }
        }
        this.Hw[length] = Integer.MIN_VALUE;
        this.VH--;
    }

    public int DW() {
        int i = 0;
        while (i < this.Hw.length) {
            int i2 = this.Hw[i];
            i++;
            if (i2 != 0 && i2 != Integer.MIN_VALUE) {
                if (i2 == Integer.MAX_VALUE) {
                    return 0;
                }
                return i2;
            }
        }
        return -1;
    }

    public boolean FH(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = ((i & Integer.MAX_VALUE) % (this.Hw.length - 2)) + 1;
        int length2 = (Integer.MAX_VALUE & i) % this.Hw.length;
        int i2 = this.Hw[length2];
        while (i2 != i) {
            if (i2 == 0) {
                return false;
            }
            length2 = (length2 + length) % this.Hw.length;
            i2 = this.Hw[length2];
        }
        return true;
    }

    public boolean FH() {
        return this.VH == 0;
    }

    private void v5() {
        int[] iArr;
        int i = 0;
        if (this.VH * 2 > this.Hw.length) {
            this.gn++;
            this.v5 = null;
            iArr = new int[FH[this.gn]];
        } else if (this.v5 == null || this.v5.length != this.Hw.length) {
            this.v5 = this.Hw;
            iArr = new int[FH[this.gn]];
        } else {
            int[] iArr2 = this.v5;
            for (int i2 = 0; i2 < iArr2.length; i2++) {
                iArr2[i2] = 0;
            }
            this.v5 = this.Hw;
            iArr = iArr2;
        }
        int i3 = 0;
        while (i < this.Hw.length) {
            int i4 = this.Hw[i];
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
        this.Hw = iArr;
        this.Zo = i3;
    }

    public int Hw() {
        return this.VH;
    }

    public String toString() {
        String str = "{";
        for (int i : this.Hw) {
            if (!(i == 0 || i == Integer.MIN_VALUE)) {
                if (i == Integer.MAX_VALUE) {
                    str = str + "0, ";
                } else {
                    str = str + i + ", ";
                }
            }
        }
        return str + "}";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ec)) {
            return false;
        }
        ec ecVar = (ec) obj;
        if (ecVar.Hw() != Hw()) {
            return false;
        }
        for (int i : this.Hw) {
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
