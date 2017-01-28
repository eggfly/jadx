public class dq$a {
    private int DW;
    private int FH;
    private int Hw;
    private int Zo;
    final /* synthetic */ dq j6;
    private int v5;

    private dq$a(dq dqVar) {
        this.j6 = dqVar;
        this.DW = 0;
        this.FH = 0;
    }

    public void j6() {
        this.DW = 0;
        this.FH = 0;
    }

    public void j6(K k) {
        int j6 = this.j6.tp.j6((bs) k);
        if (j6 == 0) {
            j6 = Integer.MAX_VALUE;
        }
        this.Zo = j6;
        this.FH = ((j6 & Integer.MAX_VALUE) % (this.j6.FH.length - 2)) + 1;
        this.DW = (j6 & Integer.MAX_VALUE) % this.j6.FH.length;
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

    public K FH() {
        return this.j6.tp.FH(this.Hw);
    }

    public V Hw() {
        return this.j6.tp.FH(this.v5);
    }
}
