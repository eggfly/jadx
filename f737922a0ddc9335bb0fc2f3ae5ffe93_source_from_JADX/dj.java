import com.aide.uidesigner.ProxyTextView;

public class dj<T> {
    private static final int[] DW;
    private int[] FH;
    private int[] Hw;
    private int VH;
    private T[] Zo;
    private int gn;
    public final dj$a j6;
    private int u7;
    private T[] v5;

    static {
        DW = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
    }

    public dj(int i) {
        this.j6 = new dj$a();
        this.u7 = 0;
        while (DW[this.u7] < i * 2) {
            this.u7++;
        }
        this.FH = new int[DW[this.u7]];
        this.v5 = new Object[DW[this.u7]];
        this.VH = 0;
        this.gn = 0;
    }

    public dj() {
        this.j6 = new dj$a();
        this.u7 = 0;
        this.FH = new int[DW[this.u7]];
        this.v5 = new Object[DW[this.u7]];
        this.VH = 0;
        this.gn = 0;
    }

    public void j6(dj<? extends T> djVar) {
        for (int i = 0; i < djVar.FH.length; i++) {
            int i2 = djVar.FH[i];
            Object obj = djVar.v5[i];
            if (i2 == Integer.MAX_VALUE) {
                DW(0, obj);
            } else if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                DW(i2, obj);
            }
        }
    }

    public void j6() {
        int i;
        for (i = 0; i < this.FH.length; i++) {
            this.FH[i] = 0;
        }
        for (i = 0; i < this.v5.length; i++) {
            this.v5[i] = null;
        }
        this.VH = 0;
        this.gn = 0;
        this.Zo = null;
        this.Hw = null;
    }

    public void j6(int i, T t) {
        DW(i);
        DW(i, t);
    }

    public void DW(int i, T t) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.FH.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.FH.length - 2)) + 1;
        int i2 = this.FH[length];
        int i3 = -1;
        while (i2 != 0) {
            if (i2 == i) {
                if (this.v5[length] == t) {
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
        this.v5[length] = t;
        this.gn++;
        if (i3 == -1) {
            this.VH++;
        }
        if (this.VH * 2 > this.FH.length) {
            FH();
        }
    }

    public boolean j6(int i) {
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

    public void DW(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.FH.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.FH.length - 2)) + 1;
        int i2 = this.FH[length];
        while (i2 != 0) {
            if (i2 == i) {
                this.FH[length] = Integer.MIN_VALUE;
                this.v5[length] = null;
                this.gn--;
            }
            length = (length + length2) % this.FH.length;
            i2 = this.FH[length];
        }
    }

    public T FH(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = ((i & Integer.MAX_VALUE) % (this.FH.length - 2)) + 1;
        int length2 = (Integer.MAX_VALUE & i) % this.FH.length;
        int i2 = this.FH[length2];
        while (i2 != i) {
            if (i2 == 0) {
                return null;
            }
            length2 = (length2 + length) % this.FH.length;
            i2 = this.FH[length2];
        }
        return this.v5[length2];
    }

    private void FH() {
        int[] iArr;
        Object[] objArr;
        int i = 0;
        if (this.gn * 2 > this.FH.length) {
            this.u7++;
            this.Hw = null;
            this.Zo = null;
            iArr = new int[DW[this.u7]];
            objArr = new Object[DW[this.u7]];
        } else if (this.Hw == null || this.Hw.length != this.FH.length) {
            this.Hw = this.FH;
            this.Zo = this.v5;
            iArr = new int[DW[this.u7]];
            objArr = new Object[DW[this.u7]];
        } else {
            iArr = this.Hw;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = 0;
            }
            objArr = this.Zo;
            this.Hw = this.FH;
            this.Zo = this.v5;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.FH.length; i4++) {
            int i5 = this.FH[i4];
            if (!(i5 == 0 || i5 == Integer.MIN_VALUE)) {
                int length = ((i5 & Integer.MAX_VALUE) % (iArr.length - 2)) + 1;
                int length2 = (i5 & Integer.MAX_VALUE) % iArr.length;
                while (iArr[length2] != 0) {
                    length2 = (length2 + length) % iArr.length;
                }
                iArr[length2] = i5;
                objArr[length2] = this.v5[i4];
                i3++;
            }
        }
        this.FH = iArr;
        this.v5 = objArr;
        this.VH = i3;
        if (this.Zo != null) {
            while (i < this.Zo.length) {
                this.Zo[i] = null;
                i++;
            }
        }
    }

    public int DW() {
        return this.gn;
    }

    public String toString() {
        return getClass().getName() + "[Size=" + this.gn + "]";
    }
}
