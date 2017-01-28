import com.aide.uidesigner.ProxyTextView;

public class di {
    private static final int[] DW;
    private long[] FH;
    private long[] Hw;
    private int VH;
    private int[] Zo;
    private int gn;
    public final di$a j6;
    private int u7;
    private int[] v5;

    static {
        DW = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
    }

    public di() {
        this.j6 = new di$a();
        this.u7 = 0;
        this.FH = new long[DW[this.u7]];
        this.v5 = new int[DW[this.u7]];
        this.VH = 0;
        this.gn = 0;
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

    public void j6(long j, int i) {
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
                if (this.v5[i3] != i) {
                    this.FH[i3] = Long.MIN_VALUE;
                    this.gn--;
                } else {
                    return;
                }
            } else if (j2 == Long.MIN_VALUE) {
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
            FH();
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

    public int DW(long j) {
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

    private void FH() {
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

    public int DW() {
        return this.gn;
    }

    public String toString() {
        String str = "{";
        for (int i = 0; i < this.FH.length; i++) {
            long j = this.FH[i];
            if (!(j == 0 || j == Long.MIN_VALUE)) {
                int i2 = this.v5[i];
                if (j == Long.MAX_VALUE) {
                    str = str + "0->" + i2 + ", ";
                } else {
                    str = str + j + "->" + i2 + ", ";
                }
            }
        }
        return str + "}";
    }
}
