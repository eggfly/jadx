import com.aide.uidesigner.ProxyTextView;

public class dw {
    private static final int[] DW;
    private long[] FH;
    private long[] Hw;
    private int VH;
    private int[] Zo;
    private int gn;
    public final dw$a j6;
    private int u7;
    private int[] v5;

    static {
        DW = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
    }

    public dw() {
        this.j6 = new dw$a();
        this.u7 = 0;
        this.FH = new long[DW[this.u7]];
        this.v5 = new int[DW[this.u7]];
        this.VH = 0;
        this.gn = 0;
    }

    public dw(ee eeVar) {
        int i = 0;
        this.j6 = new dw$a();
        this.gn = eeVar.readInt();
        this.VH = eeVar.readInt();
        this.u7 = eeVar.readInt();
        this.FH = new long[DW[this.u7]];
        for (int i2 = 0; i2 < this.FH.length; i2++) {
            this.FH[i2] = eeVar.readLong();
        }
        this.v5 = new int[DW[this.u7]];
        while (i < this.v5.length) {
            this.v5[i] = eeVar.readInt();
            i++;
        }
    }

    public void j6(ef efVar) {
        int i = 0;
        efVar.writeInt(this.gn);
        efVar.writeInt(this.VH);
        efVar.writeInt(this.u7);
        for (long writeLong : this.FH) {
            efVar.writeLong(writeLong);
        }
        while (i < this.v5.length) {
            efVar.writeInt(this.v5[i]);
            i++;
        }
    }

    public void j6(int i) {
        if (this.VH > 0) {
            if (this.FH.length >= i) {
                this.u7 = 0;
                while (DW[this.u7] < i * 2) {
                    this.u7++;
                }
                this.FH = new long[DW[this.u7]];
                this.v5 = new int[DW[this.u7]];
            } else {
                for (int i2 = 0; i2 < this.FH.length; i2++) {
                    this.FH[i2] = 0;
                }
            }
            this.VH = 0;
            this.gn = 0;
        }
    }

    public void j6(long j, int i) {
        DW(j);
        DW(j, i);
    }

    public int j6(int i, int i2) {
        return FH((((long) i) << 32) | ((long) i2));
    }

    public void j6(int i, int i2, int i3) {
        j6((((long) i) << 32) | ((long) i2), i3);
    }

    public boolean DW(int i, int i2) {
        return j6((((long) i) << 32) | ((long) i2));
    }

    public void DW(long j, int i) {
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((Long.MAX_VALUE & j) % ((long) this.FH.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.FH.length) - 2))) + 1;
        int i2 = -1;
        int i3 = length;
        long j2 = this.FH[length];
        while (j2 != 0) {
            if (j2 == j) {
                if (this.v5[i3] == i) {
                    return;
                }
            } else if (j2 == -2147483648L) {
                i2 = i3;
            }
            i3 = (i3 + length2) % this.FH.length;
            j2 = this.FH[i3];
        }
        if (i2 != -1) {
            i3 = i2;
        }
        this.FH[i3] = j;
        this.v5[i3] = i;
        this.gn++;
        if (i2 == -1) {
            this.VH++;
        }
        if (this.VH * 2 > this.FH.length) {
            j6();
        }
    }

    public boolean j6(long j) {
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.FH.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.FH.length) - 2))) + 1;
        long j2 = this.FH[length];
        while (j2 != j) {
            if (j2 == 0) {
                return false;
            }
            length = (length + length2) % this.FH.length;
            j2 = this.FH[length];
        }
        return true;
    }

    public void DW(long j) {
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.FH.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.FH.length) - 2))) + 1;
        long j2 = this.FH[length];
        while (j2 != 0) {
            if (j2 == j) {
                this.FH[length] = Long.MIN_VALUE;
                this.gn--;
            }
            length = (length + length2) % this.FH.length;
            j2 = this.FH[length];
        }
    }

    public int FH(long j) {
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.FH.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.FH.length) - 2))) + 1;
        long j2 = this.FH[length];
        while (j2 != j) {
            if (j2 == 0) {
                return -1;
            }
            length = (length + length2) % this.FH.length;
            j2 = this.FH[length];
        }
        return this.v5[length];
    }

    private void j6() {
        long[] jArr;
        int[] iArr;
        if (this.gn * 2 > this.FH.length) {
            this.u7++;
            this.Hw = null;
            this.Zo = null;
            jArr = new long[DW[this.u7]];
            iArr = new int[DW[this.u7]];
        } else if (this.Hw == null || this.Hw.length != this.FH.length) {
            this.Hw = this.FH;
            this.Zo = this.v5;
            jArr = new long[DW[this.u7]];
            iArr = new int[DW[this.u7]];
        } else {
            jArr = this.Hw;
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = 0;
            }
            iArr = this.Zo;
            this.Hw = this.FH;
            this.Zo = this.v5;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.FH.length; i3++) {
            long j = this.FH[i3];
            if (!(j == 0 || j == Long.MIN_VALUE)) {
                int length = (int) ((Long.MAX_VALUE & j) % ((long) jArr.length));
                int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) jArr.length) - 2))) + 1;
                while (jArr[length] != 0) {
                    length = (length + length2) % jArr.length;
                }
                jArr[length] = j;
                iArr[length] = this.v5[i3];
                i2++;
            }
        }
        this.FH = jArr;
        this.v5 = iArr;
        this.VH = i2;
    }

    public String toString() {
        return getClass().getName() + "[Size=" + this.gn + "]";
    }
}
