public final class cm {
    public int[] DW;
    public int[] FH;
    public int[] Hw;
    public char[] VH;
    public int[] Zo;
    public int gn;
    public int[] j6;
    public int u7;
    public int[] v5;

    public cm() {
        this.j6 = new int[10000];
        this.DW = new int[10000];
        this.FH = new int[10000];
        this.Hw = new int[10000];
        this.v5 = new int[10000];
        this.Zo = new int[10000];
        this.VH = new char[1000];
        this.gn = 1;
    }

    public void j6(int i) {
        int length = this.j6.length;
        if (i >= length) {
            while (i >= length) {
                length = this.j6.length * 2;
            }
            Object obj = new int[length];
            System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
            this.j6 = obj;
            obj = new int[length];
            System.arraycopy(this.DW, 0, obj, 0, this.DW.length);
            this.DW = obj;
            obj = new int[length];
            System.arraycopy(this.FH, 0, obj, 0, this.FH.length);
            this.FH = obj;
            obj = new int[length];
            System.arraycopy(this.v5, 0, obj, 0, this.v5.length);
            this.v5 = obj;
            obj = new int[length];
            System.arraycopy(this.Hw, 0, obj, 0, this.Hw.length);
            this.Hw = obj;
            Object obj2 = new int[length];
            System.arraycopy(this.Zo, 0, obj2, 0, this.Zo.length);
            this.Zo = obj2;
        }
    }

    public void j6() {
        this.u7 = 0;
        this.gn = 1;
    }

    public int j6(char[] cArr, int i, int i2) {
        if ((this.gn + i2) + 1 >= this.VH.length) {
            Object obj = new char[Math.max((this.VH.length * 2) + 1, (this.gn + i2) + 1)];
            System.arraycopy(this.VH, 0, obj, 0, this.VH.length);
            this.VH = obj;
        }
        int i3 = this.gn;
        char[] cArr2 = this.VH;
        int i4 = this.gn;
        this.gn = i4 + 1;
        cArr2[i4] = (char) i2;
        System.arraycopy(cArr, i, this.VH, this.gn, i2);
        this.gn += i2;
        return i3;
    }

    public int DW(int i) {
        return this.VH[i];
    }

    public int FH(int i) {
        return i + 1;
    }

    public String Hw(int i) {
        return new String(this.VH, FH(i), DW(i));
    }

    public void j6(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = this.u7;
        j6(i7 + 1);
        this.j6[i7] = i;
        this.DW[i7] = i2;
        this.FH[i7] = i3;
        this.v5[i7] = i4;
        this.Hw[i7] = i5;
        this.Zo[i7] = i6;
        this.u7++;
    }
}
