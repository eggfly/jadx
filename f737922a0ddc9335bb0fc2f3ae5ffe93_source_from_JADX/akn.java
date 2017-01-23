abstract class akn {
    protected akt[] DW;
    protected int FH;
    protected ako j6;

    public abstract void DW();

    protected akn(ako ako, int i) {
        this.j6 = ako;
        this.DW = new akt[i];
    }

    public ako j6() {
        return this.j6;
    }

    protected void j6(akt akt) {
        if (this.DW.length == this.FH) {
            Object obj = new akt[(((this.FH + 16) * 3) / 2)];
            System.arraycopy(this.DW, 0, obj, 0, this.FH);
            this.DW = obj;
        }
        akt[] aktArr = this.DW;
        int i = this.FH;
        this.FH = i + 1;
        aktArr[i] = akt;
    }

    protected void j6(int i, int i2) {
        if (this.FH + i2 > this.DW.length) {
            Object obj = new akt[Math.max(((this.FH + 16) * 3) / 2, this.FH + i2)];
            System.arraycopy(this.DW, 0, obj, 0, this.FH);
            this.DW = obj;
        }
        this.j6.j6(i, this.DW, this.FH, i2);
        this.FH += i2;
    }

    protected void FH() {
        if (this.FH < this.DW.length / 2) {
            Object obj = new akt[this.FH];
            System.arraycopy(this.DW, 0, obj, 0, this.FH);
            this.DW = obj;
        }
        this.j6.j6(this.DW, this.FH);
    }

    public boolean Hw() {
        DW();
        this.j6.VH();
        return this.j6.gn();
    }
}
