public class dz {
    private int[] DW;
    private int[] FH;
    private int[] Hw;
    private int Zo;
    public final dz$a j6;
    private int[] v5;

    public dz() {
        this.j6 = new dz$a();
        this.DW = new int[3000];
        this.FH = new int[3000];
        this.Hw = new int[1000];
        this.v5 = new int[1000];
        this.Zo = 0;
    }

    public void j6(int i, int i2) {
        if (this.DW.length < this.Zo * 3) {
            v5();
        }
        if (this.Hw.length <= this.Zo) {
            Hw();
        }
        this.Hw[this.Zo] = i;
        this.v5[this.Zo] = i2;
        this.Zo++;
        int[] iArr = this.DW;
        int length = iArr.length;
        int i3 = (Integer.MAX_VALUE & i) % length;
        while (iArr[i3] != 0) {
            i3++;
            if (i3 >= length) {
                i3 = 0;
            }
        }
        iArr[i3] = i;
        this.FH[i3] = i2;
    }

    public int j6(int i) {
        int[] iArr = this.DW;
        int length = iArr.length;
        int i2 = (Integer.MAX_VALUE & i) % length;
        int i3 = -1;
        int i4;
        do {
            i4 = iArr[i2];
            if (i4 == i) {
                i3 = this.FH[i2];
            }
            i2++;
            if (i2 >= length) {
                i2 = 0;
                continue;
            }
        } while (i4 != 0);
        return i3;
    }

    public boolean DW(int i) {
        int[] iArr = this.DW;
        int length = iArr.length;
        int i2 = (Integer.MAX_VALUE & i) % length;
        int i3;
        do {
            i3 = iArr[i2];
            if (i3 == i) {
                return true;
            }
            i2++;
            if (i2 >= length) {
                i2 = 0;
                continue;
            }
        } while (i3 != 0);
        return false;
    }

    public void j6() {
        if (this.Zo > 0) {
            for (int i = 0; i < this.DW.length; i++) {
                this.DW[i] = 0;
            }
        }
        this.Zo = 0;
    }

    public void DW() {
        if (this.Hw.length <= this.Zo) {
            Hw();
        }
        this.Hw[this.Zo] = 0;
        this.Zo++;
    }

    public void FH() {
        int[] iArr = this.DW;
        int length = iArr.length;
        this.Zo--;
        int i = this.Hw[this.Zo];
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
            this.Zo--;
            i = this.Hw[this.Zo];
        }
    }

    private void Hw() {
        Object obj = new int[((this.Hw.length * 2) + 1)];
        System.arraycopy(this.Hw, 0, obj, 0, this.Hw.length);
        this.Hw = obj;
        obj = new int[((this.v5.length * 2) + 1)];
        System.arraycopy(this.v5, 0, obj, 0, this.v5.length);
        this.v5 = obj;
    }

    private void v5() {
        int[] iArr = new int[((this.DW.length * 2) + 1)];
        int[] iArr2 = new int[((this.DW.length * 2) + 1)];
        int[] iArr3 = new int[((this.DW.length * 2) + 1)];
        for (int i = 0; i < this.Zo; i++) {
            int i2 = this.Hw[i];
            if (i2 != 0) {
                int i3 = this.v5[i];
                int length = (Integer.MAX_VALUE & i2) % iArr.length;
                while (iArr[length] != 0) {
                    length++;
                    if (length >= iArr.length) {
                        length = 0;
                    }
                }
                iArr[length] = i2;
                iArr2[length] = i3;
            }
        }
        this.DW = iArr;
        this.FH = iArr2;
    }
}
