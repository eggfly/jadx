class acl$a {
    private final int[] DW;
    private int FH;
    private final int[] j6;

    public acl$a(int i) {
        this.j6 = new int[i];
        this.DW = new int[i];
        this.FH = 0;
    }

    public void j6(int i) {
        for (int i2 = 0; i2 < this.FH; i2++) {
            if (this.j6[i2] == i) {
                int[] iArr = this.DW;
                iArr[i2] = iArr[i2] + 1;
                return;
            }
        }
        this.j6[this.FH] = i;
        this.DW[this.FH] = 1;
        this.FH++;
    }

    public int j6() {
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < this.FH; i4++) {
            if (i < this.DW[i4]) {
                i2 = this.j6[i4];
                i = this.DW[i4];
                i3 = i4;
            }
        }
        this.DW[i3] = 0;
        return i2;
    }

    public int DW() {
        return this.FH;
    }
}
