import com.aide.uidesigner.ProxyTextView;

public class dh {
    private static final int[] DW;
    private int[] FH;
    private int[] Hw;
    private int VH;
    private long[] Zo;
    private int gn;
    public final dh$a j6;
    private int u7;
    private long[] v5;

    static {
        DW = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
    }

    public dh() {
        this.j6 = new dh$a();
        this.u7 = 0;
        this.FH = new int[DW[this.u7]];
        this.v5 = new long[DW[this.u7]];
        this.VH = 0;
        this.gn = 0;
    }

    public dh(ee eeVar) {
        int i = 0;
        this.j6 = new dh$a();
        int readInt = eeVar.readInt();
        this.u7 = eeVar.readInt();
        this.FH = new int[DW[this.u7]];
        this.v5 = new long[DW[this.u7]];
        this.VH = 0;
        this.gn = 0;
        while (i < readInt) {
            j6(eeVar.readInt(), eeVar.readLong());
            i++;
        }
    }

    public void j6(dh dhVar) {
        for (int i = 0; i < dhVar.FH.length; i++) {
            int i2 = dhVar.FH[i];
            if (i2 == Integer.MAX_VALUE) {
                j6(0, dhVar.v5[i]);
            } else if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                j6(i2, dhVar.v5[i]);
            }
        }
    }

    public void j6(ef efVar) {
        efVar.writeInt(this.gn);
        efVar.writeInt(this.u7);
        for (int i = 0; i < this.FH.length; i++) {
            int i2 = this.FH[i];
            if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                efVar.writeInt(this.FH[i]);
                efVar.writeLong(this.v5[i]);
            }
        }
    }

    public void j6() {
        if (this.VH > 0) {
            for (int i = 0; i < this.FH.length; i++) {
                this.FH[i] = 0;
            }
            this.VH = 0;
            this.gn = 0;
        }
    }

    public void j6(int i, long j) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.FH.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.FH.length - 2)) + 1;
        int i2 = this.FH[length];
        int i3 = -1;
        while (i2 != 0) {
            if (i2 == i) {
                if (this.v5[length] != j) {
                    this.FH[length] = Integer.MIN_VALUE;
                    this.gn--;
                } else {
                    return;
                }
            } else if (i2 == Integer.MIN_VALUE) {
                i3 = length;
            }
            i2 = (length + length2) % this.FH.length;
            length = i2;
            i2 = this.FH[i2];
        }
        if (i3 != -1) {
            length = i3;
        }
        this.FH[length] = i;
        this.v5[length] = j;
        this.gn++;
        if (i3 == -1) {
            this.VH++;
        }
        if (this.VH * 2 > this.FH.length) {
            DW();
        }
    }

    public void j6(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.FH.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.FH.length - 2)) + 1;
        int i2 = this.FH[length];
        while (i2 != 0) {
            if (i2 == i) {
                this.FH[length] = Integer.MIN_VALUE;
                this.gn--;
                return;
            }
            length = (length + length2) % this.FH.length;
            i2 = this.FH[length];
        }
    }

    public boolean DW(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = ((i & Integer.MAX_VALUE) % (this.FH.length - 2)) + 1;
        int length2 = (Integer.MAX_VALUE & i) % this.FH.length;
        int i2 = this.FH[length2];
        while (i2 != i) {
            if (i2 == 0) {
                return false;
            }
            length2 = (length2 + length) % this.FH.length;
            i2 = this.FH[length2];
        }
        return true;
    }

    public long FH(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = ((i & Integer.MAX_VALUE) % (this.FH.length - 2)) + 1;
        int length2 = (Integer.MAX_VALUE & i) % this.FH.length;
        int i2 = this.FH[length2];
        while (i2 != i) {
            if (i2 == 0) {
                return -1;
            }
            length2 = (length2 + length) % this.FH.length;
            i2 = this.FH[length2];
        }
        return this.v5[length2];
    }

    private void DW() {
        int[] iArr;
        long[] jArr;
        int i = 0;
        if (this.gn * 2 > this.FH.length) {
            this.u7++;
            this.Hw = null;
            this.Zo = null;
            iArr = new int[DW[this.u7]];
            jArr = new long[DW[this.u7]];
        } else if (this.Hw == null || this.Hw.length != this.FH.length) {
            this.Hw = this.FH;
            this.Zo = this.v5;
            iArr = new int[DW[this.u7]];
            jArr = new long[DW[this.u7]];
        } else {
            iArr = this.Hw;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = 0;
            }
            jArr = this.Zo;
            this.Hw = this.FH;
            this.Zo = this.v5;
        }
        int i3 = 0;
        while (i < this.FH.length) {
            int i4 = this.FH[i];
            if (!(i4 == 0 || i4 == Integer.MIN_VALUE)) {
                int length = ((i4 & Integer.MAX_VALUE) % (iArr.length - 2)) + 1;
                int length2 = (i4 & Integer.MAX_VALUE) % iArr.length;
                while (iArr[length2] != 0) {
                    length2 = (length2 + length) % iArr.length;
                }
                iArr[length2] = i4;
                jArr[length2] = this.v5[i];
                i3++;
            }
            i++;
        }
        this.FH = iArr;
        this.v5 = jArr;
        this.VH = i3;
    }

    public String toString() {
        String str = "{";
        for (int i = 0; i < this.FH.length; i++) {
            int i2 = this.FH[i];
            if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                long j = this.v5[i];
                if (i2 == Integer.MAX_VALUE) {
                    str = str + "0->" + j + ", ";
                } else {
                    str = str + i2 + "->" + j + ", ";
                }
            }
        }
        return str + "}";
    }
}
