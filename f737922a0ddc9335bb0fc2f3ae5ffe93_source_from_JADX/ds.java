import com.aide.uidesigner.ProxyTextView;

public class ds {
    private static final int[] j6;
    private int[] DW;
    private int FH;
    private int[] Hw;
    private int VH;
    private int Zo;
    private int gn;
    private int[] u7;
    private int[] v5;

    static {
        j6 = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
    }

    public ds() {
        this.gn = 0;
        this.Hw = new int[j6[this.gn]];
        this.v5 = new int[j6[this.gn]];
        this.DW = new int[10];
        this.FH = 1;
        this.Zo = 0;
        this.VH = 0;
    }

    public ds(ee eeVar) {
        int i;
        int i2 = 0;
        this.VH = eeVar.readInt();
        this.Zo = eeVar.readInt();
        this.gn = eeVar.readInt();
        this.Hw = new int[j6[this.gn]];
        for (i = 0; i < this.Hw.length; i++) {
            this.Hw[i] = eeVar.readInt();
        }
        this.v5 = new int[j6[this.gn]];
        for (i = 0; i < this.v5.length; i++) {
            this.v5[i] = eeVar.readInt();
        }
        this.FH = eeVar.readInt();
        this.DW = new int[eeVar.readInt()];
        while (i2 < this.FH) {
            this.DW[i2] = eeVar.readInt();
            i2++;
        }
    }

    public void j6(ef efVar) {
        int i = 0;
        efVar.writeInt(this.VH);
        efVar.writeInt(this.Zo);
        efVar.writeInt(this.gn);
        for (int writeInt : this.Hw) {
            efVar.writeInt(writeInt);
        }
        for (int writeInt2 : this.v5) {
            efVar.writeInt(writeInt2);
        }
        efVar.writeInt(this.FH);
        efVar.writeInt(this.DW.length);
        while (i < this.FH) {
            efVar.writeInt(this.DW[i]);
            i++;
        }
    }

    private int FH(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = iArr[i4 + i] ^ i3;
            i4++;
            i3 = i5;
        }
        if (i3 == 0) {
            i3 = Integer.MAX_VALUE;
        }
        return i3 & Integer.MAX_VALUE;
    }

    public void j6(int i, int[] iArr, int[] iArr2, int i2, int i3, int i4) {
        int i5 = (i3 * 2) + 1;
        if (this.u7 == null || this.u7.length <= i5) {
            this.u7 = new int[i5];
        }
        this.u7[0] = i;
        System.arraycopy(iArr, i2, this.u7, 1, i3);
        System.arraycopy(iArr2, i2, this.u7, i3 + 1, i3);
        j6(this.u7, 0, i5, i4);
    }

    public int j6(int i, int[] iArr, int[] iArr2, int i2, int i3) {
        int i4 = (i3 * 2) + 1;
        if (this.u7 == null || this.u7.length <= i4) {
            this.u7 = new int[i4];
        }
        this.u7[0] = i;
        System.arraycopy(iArr, i2, this.u7, 1, i3);
        System.arraycopy(iArr2, i2, this.u7, i3 + 1, i3);
        return DW(this.u7, 0, i4);
    }

    public boolean DW(int i, int[] iArr, int[] iArr2, int i2, int i3) {
        int i4 = (i3 * 2) + 1;
        if (this.u7 == null || this.u7.length <= i4) {
            this.u7 = new int[i4];
        }
        this.u7[0] = i;
        System.arraycopy(iArr, i2, this.u7, 1, i3);
        System.arraycopy(iArr2, i2, this.u7, i3 + 1, i3);
        return j6(this.u7, 0, i4);
    }

    public void j6(int[] iArr, int i, int i2, int i3) {
        int i4;
        int i5 = 0;
        int FH = FH(iArr, i, i2);
        int length = FH % this.Hw.length;
        int length2 = (FH % (this.Hw.length - 2)) + 1;
        FH = this.Hw[length];
        int i6 = length;
        while (FH != 0 && FH != Integer.MIN_VALUE) {
            if (this.DW[FH] == i2) {
                length = FH + 1;
                FH = 0;
                while (FH < i2) {
                    i4 = length + 1;
                    if (this.DW[length] == iArr[i + FH]) {
                        FH++;
                        length = i4;
                    }
                }
                this.v5[i6] = i3;
                return;
            }
            length = (i6 + length2) % this.Hw.length;
            FH = this.Hw[length];
            i6 = length;
        }
        this.Hw[i6] = this.FH;
        if ((this.FH + i2) + 1 >= this.DW.length) {
            Object obj = new int[Math.max((this.DW.length + i2) + 1, (this.DW.length * 2) + 1)];
            System.arraycopy(this.DW, 0, obj, 0, this.DW.length);
            this.DW = obj;
        }
        int[] iArr2 = this.DW;
        i4 = this.FH;
        this.FH = i4 + 1;
        iArr2[i4] = i2;
        while (i5 < i2) {
            iArr2 = this.DW;
            i4 = this.FH;
            this.FH = i4 + 1;
            iArr2[i4] = iArr[i + i5];
            i5++;
        }
        this.v5[i6] = i3;
        if (FH != Integer.MIN_VALUE) {
            this.Zo++;
        }
        this.VH++;
        if (this.Zo * 2 > this.Hw.length) {
            j6();
        }
    }

    public boolean j6(int[] iArr, int i, int i2) {
        int FH = FH(iArr, i, i2);
        int length = FH % this.Hw.length;
        int length2 = (FH % (this.Hw.length - 2)) + 1;
        FH = this.Hw[length];
        int i3 = length;
        while (FH != 0 && FH != Integer.MIN_VALUE) {
            if (this.DW[FH] == i2) {
                length = FH + 1;
                FH = 0;
                while (FH < i2) {
                    int i4 = length + 1;
                    if (this.DW[length] == iArr[i + FH]) {
                        FH++;
                        length = i4;
                    }
                }
                return true;
            }
            length = (i3 + length2) % this.Hw.length;
            FH = this.Hw[length];
            i3 = length;
        }
        return false;
    }

    public int DW(int[] iArr, int i, int i2) {
        int FH = FH(iArr, i, i2);
        int length = FH % this.Hw.length;
        int length2 = (FH % (this.Hw.length - 2)) + 1;
        FH = this.Hw[length];
        int i3 = length;
        while (FH != 0 && FH != Integer.MIN_VALUE) {
            if (this.DW[FH] == i2) {
                length = FH + 1;
                FH = 0;
                while (FH < i2) {
                    int i4 = length + 1;
                    if (this.DW[length] == iArr[i + FH]) {
                        FH++;
                        length = i4;
                    }
                }
                return this.v5[i3];
            }
            length = (i3 + length2) % this.Hw.length;
            FH = this.Hw[length];
            i3 = length;
        }
        return -1;
    }

    private void j6() {
        int i = 0;
        this.gn++;
        int[] iArr = new int[j6[this.gn]];
        int[] iArr2 = new int[j6[this.gn]];
        int i2 = 0;
        while (i < this.Hw.length) {
            int i3 = this.Hw[i];
            if (!(i3 == 0 || i3 == Integer.MIN_VALUE)) {
                int FH = FH(this.DW, i3 + 1, this.DW[i3]);
                int length = FH % iArr.length;
                FH = (FH % (iArr.length - 2)) + 1;
                while (iArr[length] != 0) {
                    length = (length + FH) % iArr.length;
                }
                iArr[length] = i3;
                iArr2[length] = this.v5[i];
                i2++;
            }
            i++;
        }
        this.Hw = iArr;
        this.v5 = iArr2;
        this.Zo = i2;
    }

    public String toString() {
        return getClass().getName() + "[Size=" + this.VH + "]";
    }
}
