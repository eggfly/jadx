import com.aide.uidesigner.ProxyTextView;

public class ed {
    public static final ed DW;
    private static final int[] FH;
    private long[] Hw;
    private int VH;
    private int Zo;
    private int gn;
    public final ed$a j6;
    private long[] v5;

    static {
        FH = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
        DW = new ed();
    }

    public ed() {
        this.j6 = new ed$a();
        this.gn = 1;
        this.Hw = new long[FH[this.gn]];
        this.Zo = 0;
        this.VH = 0;
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

    public void j6(long j) {
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.Hw.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.Hw.length) - 2))) + 1;
        long j2 = this.Hw[length];
        int i = -1;
        int i2 = length;
        while (j2 != 0) {
            if (j2 != j) {
                if (j2 == Long.MIN_VALUE) {
                    i = i2;
                }
                i2 = (i2 + length2) % this.Hw.length;
                j2 = this.Hw[i2];
            } else {
                return;
            }
        }
        if (i != -1) {
            i2 = i;
        }
        this.Hw[i2] = j;
        if (i == -1) {
            this.Zo++;
        }
        this.VH++;
        if (this.Zo * 2 > this.Hw.length) {
            FH();
        }
    }

    public boolean DW(long j) {
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.Hw.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.Hw.length) - 2))) + 1;
        long j2 = this.Hw[length];
        while (j2 != j) {
            if (j2 == 0) {
                return false;
            }
            length = (length + length2) % this.Hw.length;
            j2 = this.Hw[length];
        }
        return true;
    }

    private void FH() {
        long[] jArr;
        if (this.VH * 2 > this.Hw.length) {
            this.gn++;
            this.v5 = null;
            jArr = new long[FH[this.gn]];
        } else if (this.v5 == null || this.v5.length != this.Hw.length) {
            this.v5 = this.Hw;
            jArr = new long[FH[this.gn]];
        } else {
            long[] jArr2 = this.v5;
            for (int i = 0; i < jArr2.length; i++) {
                jArr2[i] = 0;
            }
            this.v5 = this.Hw;
            jArr = jArr2;
        }
        int i2 = 0;
        for (long j : this.Hw) {
            if (!(j == 0 || j == Long.MIN_VALUE)) {
                int length = (int) ((Long.MAX_VALUE & j) % ((long) jArr.length));
                int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) jArr.length) - 2))) + 1;
                while (jArr[length] != 0) {
                    length = (length + length2) % jArr.length;
                }
                jArr[length] = j;
                i2++;
            }
        }
        this.Hw = jArr;
        this.Zo = i2;
    }

    public int DW() {
        return this.VH;
    }

    public String toString() {
        String str = "{";
        for (long j : this.Hw) {
            if (!(j == 0 || j == Long.MIN_VALUE)) {
                if (j == Long.MAX_VALUE) {
                    str = str + "0, ";
                } else {
                    str = str + j + ", ";
                }
            }
        }
        return str + "}";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ed)) {
            return false;
        }
        ed edVar = (ed) obj;
        if (edVar.DW() != DW()) {
            return false;
        }
        for (long j : this.Hw) {
            long j2;
            if (!(j2 == 0 || j2 == Long.MIN_VALUE)) {
                if (j2 == Long.MAX_VALUE) {
                    j2 = 0;
                }
                if (!edVar.DW(j2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
