public class bm$a {
    public final boolean DW;
    public final boolean FH;
    public final int Hw;
    public final int j6;
    public final bj v5;

    public bm$a(bj bjVar, int i, boolean z, boolean z2, int i2) {
        this.v5 = bjVar;
        this.j6 = i;
        this.DW = z;
        this.FH = z2;
        this.Hw = i2;
    }

    public bm$a j6(bm$a bm_a, bj bjVar) {
        if (bm_a.FH && bm_a.Hw < this.Hw) {
            return bm_a;
        }
        if (this.FH && this.Hw < bm_a.Hw) {
            return this;
        }
        if (bm_a.DW || this.DW) {
            if (bm_a.DW && !this.DW) {
                return new bm$a(this.v5, this.j6 + bm_a.j6, false, false, this.Hw);
            } else if (!this.DW || bm_a.DW) {
                return this;
            } else {
                return new bm$a(bm_a.v5, this.j6 + bm_a.j6, false, false, bm_a.Hw);
            }
        } else if (bm_a.Hw > this.Hw) {
            return this;
        } else {
            if (this.Hw > bm_a.Hw) {
                return bm_a;
            }
            if (bjVar == this.v5) {
                return this;
            }
            if (bjVar == bm_a.v5) {
                return bm_a;
            }
            return new bm$a(this.v5, 0, false, true, 0);
        }
    }

    public bm$a j6(int i) {
        return new bm$a(this.v5, this.j6 + i, this.DW, this.FH, this.Hw);
    }
}
