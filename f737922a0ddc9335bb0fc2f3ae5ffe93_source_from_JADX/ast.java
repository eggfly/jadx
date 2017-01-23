class ast {
    private int DW;
    private int[] j6;

    ast() {
        this.j6 = new int[64];
    }

    boolean j6(int i) {
        int i2 = this.DW;
        if (i2 == 0) {
            this.j6[0] = i;
            this.DW = 1;
            return true;
        }
        int i3 = i2;
        i2 = 0;
        do {
            int i4 = (i2 + i3) >>> 1;
            if (i < this.j6[i4]) {
                i3 = i4;
                continue;
            } else if (i == this.j6[i4]) {
                return false;
            } else {
                i2 = i4 + 1;
                continue;
            }
        } while (i2 < i3);
        if (this.DW == this.j6.length) {
            Object obj = new int[(this.j6.length * 2)];
            System.arraycopy(this.j6, 0, obj, 0, this.DW);
            this.j6 = obj;
        }
        if (i2 < this.DW) {
            System.arraycopy(this.j6, i2, this.j6, i2 + 1, this.DW - i2);
        }
        this.j6[i2] = i;
        this.DW++;
        return true;
    }
}
