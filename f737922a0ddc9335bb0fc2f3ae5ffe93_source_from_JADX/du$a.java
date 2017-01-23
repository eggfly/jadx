public class du$a {
    private int DW;
    private int FH;
    private int Hw;
    private int Zo;
    final /* synthetic */ du j6;
    private long v5;

    private du$a(du duVar) {
        this.j6 = duVar;
        this.DW = 0;
        this.FH = 0;
    }

    public void j6() {
        this.DW = 0;
        this.FH = 0;
    }

    public boolean DW() {
        if (this.FH == 0) {
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
        while (true) {
            this.Hw = this.j6.FH[this.DW];
            if (this.Hw == 0) {
                return false;
            }
            if (this.Hw == this.Zo) {
                break;
            }
            this.DW = (this.DW + this.FH) % this.j6.FH.length;
        }
        if (this.Hw == Integer.MAX_VALUE) {
            this.Hw = 0;
        }
        this.v5 = this.j6.v5[this.DW];
        this.DW = (this.DW + this.FH) % this.j6.FH.length;
        return true;
    }

    public int FH() {
        return this.Hw;
    }

    public long Hw() {
        return this.v5;
    }
}
