public class dk<E extends bs> {
    private final bt DW;
    private int[] FH;
    private int[] Hw;
    private int[] VH;
    private int[] Zo;
    private int[] gn;
    public final dk$a j6;
    private int tp;
    private int[] u7;
    private int[] v5;

    public dk(bt btVar) {
        this.j6 = new dk$a();
        this.FH = new int[3000];
        this.Hw = new int[3000];
        this.v5 = new int[3000];
        this.Zo = new int[1000];
        this.VH = new int[1000];
        this.gn = new int[1000];
        this.u7 = new int[1000];
        this.tp = 0;
        this.DW = btVar;
    }

    public void j6(int i, E e, int i2) {
        if (this.FH.length < this.tp * 3) {
            v5();
        }
        if (this.Zo.length <= this.tp) {
            Hw();
        }
        this.Zo[this.tp] = i;
        this.VH[this.tp] = i2;
        this.gn[this.tp] = this.DW.j6((bs) e);
        this.tp++;
        int[] iArr = this.FH;
        int length = iArr.length;
        int i3 = (Integer.MAX_VALUE & i) % length;
        while (iArr[i3] != 0) {
            i3++;
            if (i3 >= length) {
                i3 = 0;
            }
        }
        iArr[i3] = i;
        this.Hw[i3] = this.DW.j6((bs) e);
        this.v5[i3] = i2;
    }

    public E j6(int i, int i2) {
        int[] iArr = this.FH;
        int length = iArr.length;
        int i3 = (Integer.MAX_VALUE & i) % length;
        int i4 = -1;
        int i5;
        do {
            i5 = iArr[i3];
            if (i5 == i && this.v5[i3] == i2) {
                i4 = this.Hw[i3];
            }
            i3++;
            if (i3 >= length) {
                i3 = 0;
                continue;
            }
        } while (i5 != 0);
        return this.DW.FH(i4);
    }

    public boolean DW(int i, int i2) {
        int[] iArr = this.FH;
        int length = iArr.length;
        int i3 = (Integer.MAX_VALUE & i) % length;
        int i4;
        do {
            i4 = iArr[i3];
            if (i4 == i && this.v5[i3] == i2) {
                return true;
            }
            i3++;
            if (i3 >= length) {
                i3 = 0;
                continue;
            }
        } while (i4 != 0);
        return false;
    }

    public void j6() {
        if (this.tp > 0) {
            for (int i = 0; i < this.FH.length; i++) {
                this.FH[i] = 0;
            }
        }
        this.tp = 0;
    }

    public void DW() {
        if (this.Zo.length <= this.tp) {
            Hw();
        }
        this.Zo[this.tp] = 0;
        this.tp++;
    }

    public void FH() {
        int[] iArr = this.FH;
        int length = iArr.length;
        this.tp--;
        int i = this.Zo[this.tp];
        while (i != 0) {
            int i2 = (Integer.MAX_VALUE & i) % length;
            int i3 = -1;
            int i4;
            do {
                i4 = iArr[i2];
                if (i4 == i) {
                    i3 = i2;
                }
                i2++;
                if (i2 >= length) {
                    i2 = 0;
                    continue;
                }
            } while (i4 != 0);
            if (i3 != -1) {
                iArr[i3] = 0;
            }
            this.tp--;
            i = this.Zo[this.tp];
        }
    }

    private void Hw() {
        Object obj = new int[((this.Zo.length * 2) + 1)];
        System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
        this.Zo = obj;
        obj = new int[((this.VH.length * 2) + 1)];
        System.arraycopy(this.VH, 0, obj, 0, this.VH.length);
        this.VH = obj;
        obj = new int[((this.gn.length * 2) + 1)];
        System.arraycopy(this.gn, 0, obj, 0, this.gn.length);
        this.gn = obj;
        obj = new int[((this.u7.length * 2) + 1)];
        System.arraycopy(this.u7, 0, obj, 0, this.u7.length);
        this.u7 = obj;
    }

    private void v5() {
        int[] iArr = new int[((this.FH.length * 2) + 1)];
        int[] iArr2 = new int[((this.FH.length * 2) + 1)];
        int[] iArr3 = new int[((this.FH.length * 2) + 1)];
        for (int i = 0; i < this.tp; i++) {
            int i2 = this.Zo[i];
            if (i2 != 0) {
                int i3 = this.VH[i];
                int i4 = this.gn[i];
                int length = (Integer.MAX_VALUE & i2) % iArr.length;
                while (iArr[length] != 0) {
                    length++;
                    if (length >= iArr.length) {
                        length = 0;
                    }
                }
                iArr[length] = i2;
                iArr2[length] = i4;
                iArr3[length] = i3;
            }
        }
        this.FH = iArr;
        this.v5 = iArr3;
        this.Hw = iArr2;
    }
}
