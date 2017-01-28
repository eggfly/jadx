public class awz {
    private int DW;
    private long[] j6;

    public awz() {
        this(10);
    }

    public awz(int i) {
        this.j6 = new long[i];
    }

    public long j6(int i) {
        if (this.DW > i) {
            return this.j6[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public boolean j6(long j) {
        for (int i = 0; i < this.DW; i++) {
            if (this.j6[i] == j) {
                return true;
            }
        }
        return false;
    }

    public void j6() {
        this.DW = 0;
    }

    public void DW(long j) {
        if (this.DW == this.j6.length) {
            DW();
        }
        long[] jArr = this.j6;
        int i = this.DW;
        this.DW = i + 1;
        jArr[i] = j;
    }

    public void j6(int i, long j) {
        if (this.DW < i) {
            throw new ArrayIndexOutOfBoundsException(i);
        } else if (this.DW == i) {
            DW(j);
        } else {
            this.j6[i] = j;
        }
    }

    private void DW() {
        Object obj = new long[(((this.j6.length + 16) * 3) / 2)];
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
