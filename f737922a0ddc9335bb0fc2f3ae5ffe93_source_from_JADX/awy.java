public class awy {
    private int DW;
    private int[] j6;

    public awy() {
        this(10);
    }

    public awy(int i) {
        this.j6 = new int[i];
    }

    public int j6() {
        return this.DW;
    }

    public int j6(int i) {
        if (this.DW > i) {
            return this.j6[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public void DW() {
        this.DW = 0;
    }

    public void DW(int i) {
        if (this.DW == this.j6.length) {
            FH();
        }
        int[] iArr = this.j6;
        int i2 = this.DW;
        this.DW = i2 + 1;
        iArr[i2] = i;
    }

    public void j6(int i, int i2) {
        if (this.DW < i) {
            throw new ArrayIndexOutOfBoundsException(i);
        } else if (this.DW == i) {
            DW(i2);
        } else {
            this.j6[i] = i2;
        }
    }

    public void DW(int i, int i2) {
        while (this.DW < i) {
            DW(i2);
        }
    }

    private void FH() {
        Object obj = new int[(((this.j6.length + 16) * 3) / 2)];
        System.arraycopy(this.j6, 0, obj, 0, this.DW);
        this.j6 = obj;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < this.DW; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.j6[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
