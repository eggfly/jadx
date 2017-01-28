public class dp {
    private int DW;
    private long[] j6;

    public dp() {
        this.j6 = null;
        this.DW = 0;
    }

    public void j6() {
        this.DW = 0;
    }

    public void j6(long j) {
        if (this.j6 == null) {
            this.j6 = new long[10];
        } else if (this.DW >= this.j6.length) {
            Object obj = new long[((this.j6.length * 2) + 1)];
            System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
            this.j6 = obj;
        }
        long[] jArr = this.j6;
        int i = this.DW;
        this.DW = i + 1;
        jArr[i] = j;
    }

    public long j6(int i) {
        if (this.j6 != null && i < this.j6.length && i < this.DW) {
            return this.j6[i];
        }
        return -1;
    }

    public void j6(int i, long j) {
        if (this.j6 == null) {
            this.j6 = new long[Math.max(10, i + 1)];
        } else if (i >= this.j6.length) {
            Object obj = new long[Math.max(i + 1, (this.j6.length * 2) + 1)];
            System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
            this.j6 = obj;
        }
        if (i >= this.DW) {
            this.DW = i + 1;
        }
        this.j6[i] = j;
    }

    public String toString() {
        String str = "{";
        for (int i = 0; i < this.DW; i++) {
            str = str + this.j6[i] + ", ";
        }
        return str + "}";
    }
}
