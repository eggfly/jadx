public class dg$a {
    private int DW;
    private int FH;
    private int Hw;
    final /* synthetic */ dg j6;
    private int v5;

    private dg$a(dg dgVar) {
        this.j6 = dgVar;
        this.DW = 0;
        this.FH = 0;
    }

    public void j6() {
        this.DW = 0;
    }

    public boolean DW() {
        while (this.DW < this.j6.FH.length) {
            this.Hw = this.j6.FH[this.DW];
            if (this.Hw == 0 || this.Hw == Integer.MIN_VALUE) {
                this.DW++;
            } else {
                if (this.Hw == Integer.MAX_VALUE) {
                    this.Hw = 0;
                }
                this.v5 = this.j6.v5[this.DW];
                this.DW++;
                return true;
            }
        }
        return false;
    }

    public int FH() {
        return this.Hw;
    }

    public int Hw() {
        return this.v5;
    }
}
