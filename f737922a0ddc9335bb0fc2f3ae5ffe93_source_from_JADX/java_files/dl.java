public class dl {
    private int[] DW;
    private int[] FH;
    private int[] Hw;
    private int[] VH;
    private int[] Zo;
    private int gn;
    private int[] j6;
    private int[] v5;

    public dl() {
        this.j6 = new int[3000];
        this.DW = new int[3000];
        this.FH = new int[3000];
        this.Hw = new int[1000];
        this.v5 = new int[1000];
        this.Zo = new int[1000];
        this.VH = new int[1000];
        this.gn = 0;
    }

    public void j6(int i, int i2, int i3) {
        if (this.j6.length < this.gn * 3) {
            Zo();
        }
        if (this.Hw.length <= this.gn) {
            v5();
        }
        this.Hw[this.gn] = i;
        this.v5[this.gn] = i3;
        this.Zo[this.gn] = i2;
        this.gn++;
        int[] iArr = this.j6;
        int length = iArr.length;
        int i4 = (Integer.MAX_VALUE & i) % length;
        while (iArr[i4] != 0) {
            i4++;
            if (i4 >= length) {
                i4 = 0;
            }
        }
        iArr[i4] = i;
        this.DW[i4] = i2;
        this.FH[i4] = i3;
    }

    public int j6(int i, int i2) {
        int[] iArr = this.j6;
        int length = iArr.length;
        int i3 = (Integer.MAX_VALUE & i) % length;
        int i4 = -1;
        int i5;
        do {
            i5 = iArr[i3];
            if (i5 == i && this.FH[i3] == i2) {
                i4 = this.DW[i3];
            }
            i3++;
            if (i3 >= length) {
                i3 = 0;
                continue;
            }
        } while (i5 != 0);
        return i4;
    }

    public boolean DW(int i, int i2) {
        int[] iArr = this.j6;
        int length = iArr.length;
        int i3 = (Integer.MAX_VALUE & i) % length;
        int i4;
        do {
            i4 = iArr[i3];
            if (i4 == i && this.FH[i3] == i2) {
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
        if (this.gn > 0) {
            for (int i = 0; i < this.j6.length; i++) {
                this.j6[i] = 0;
            }
        }
        this.gn = 0;
    }

    public void DW() {
        if (this.Hw.length <= this.gn) {
            v5();
        }
        this.Hw[this.gn] = 0;
        this.gn++;
    }

    public void FH() {
        if (this.Hw.length <= this.gn) {
            v5();
        }
        this.Hw[this.gn] = 0;
        this.gn++;
    }

    public void Hw() {
        int[] iArr = this.j6;
        int length = iArr.length;
        this.gn--;
        int i = this.Hw[this.gn];
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
            this.gn--;
            i = this.Hw[this.gn];
        }
    }

    private void v5() {
        Object obj = new int[((this.Hw.length * 2) + 1)];
        System.arraycopy(this.Hw, 0, obj, 0, this.Hw.length);
        this.Hw = obj;
        obj = new int[((this.v5.length * 2) + 1)];
        System.arraycopy(this.v5, 0, obj, 0, this.v5.length);
        this.v5 = obj;
        obj = new int[((this.Zo.length * 2) + 1)];
        System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
        this.Zo = obj;
        obj = new int[((this.VH.length * 2) + 1)];
        System.arraycopy(this.VH, 0, obj, 0, this.VH.length);
        this.VH = obj;
    }

    private void Zo() {
        int[] iArr = new int[((this.j6.length * 2) + 1)];
        int[] iArr2 = new int[((this.j6.length * 2) + 1)];
        int[] iArr3 = new int[((this.j6.length * 2) + 1)];
        for (int i = 0; i < this.gn; i++) {
            int i2 = this.Hw[i];
            if (i2 != 0) {
                int i3 = this.v5[i];
                int i4 = this.Zo[i];
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
        this.j6 = iArr;
        this.FH = iArr3;
        this.DW = iArr2;
    }
}
