public class ea$a {
    private int DW;
    private int FH;
    final /* synthetic */ ea j6;

    private ea$a(ea eaVar) {
        this.j6 = eaVar;
        this.DW = 0;
    }

    public void j6() {
        this.DW = 0;
    }

    public boolean DW() {
        while (this.DW < this.j6.FH.length) {
            this.FH = this.j6.FH[this.DW];
            this.DW++;
            if (this.FH != 0 && this.FH != Integer.MIN_VALUE) {
                if (this.FH == Integer.MAX_VALUE) {
                    this.FH = 0;
                }
                return true;
            }
        }
        return false;
    }

    public E FH() {
        return this.j6.gn.FH(this.FH);
    }
}
