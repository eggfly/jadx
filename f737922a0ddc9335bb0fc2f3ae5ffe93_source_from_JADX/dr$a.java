public class dr$a {
    private int DW;
    private int FH;
    private int Hw;
    private int Zo;
    final /* synthetic */ dr j6;
    private int v5;

    private dr$a(dr drVar) {
        this.j6 = drVar;
        this.DW = 0;
        this.FH = 0;
    }

    public void j6() {
        this.DW = 0;
        this.FH = 0;
    }

    public void j6(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.Zo = i;
        this.FH = ((i & Integer.MAX_VALUE) % (this.j6.FH.length - 2)) + 1;
        this.DW = (Integer.MAX_VALUE & i) % this.j6.FH.length;
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

    public E Hw() {
        return this.j6.tp.FH(this.v5);
    }
}
