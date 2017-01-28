public class dx$a {
    private int DW;
    private int FH;
    private int Hw;
    private int VH;
    private int Zo;
    private int gn;
    final /* synthetic */ dx j6;
    private int v5;

    private dx$a(dx dxVar) {
        this.j6 = dxVar;
        if (dxVar.VH == null) {
            this.DW = 0;
            this.FH = -1;
            return;
        }
        this.DW = 0;
        this.FH = 0;
        this.v5 = 0;
    }

    public void j6() {
        if (this.j6.VH == null) {
            this.DW = 0;
            this.FH = -1;
            return;
        }
        this.DW = 0;
        this.FH = 0;
        this.v5 = 0;
    }

    public void j6(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.gn = i;
        this.FH = ((i & Integer.MAX_VALUE) % (this.j6.FH.length - 2)) + 1;
        this.DW = (Integer.MAX_VALUE & i) % this.j6.FH.length;
    }

    public boolean DW() {
        if (this.FH == 0) {
            if (this.v5 == 0) {
                while (this.DW < this.j6.FH.length) {
                    this.Zo = this.j6.FH[this.DW];
                    if (this.j6.VH[this.DW] || this.Zo == 0 || this.Zo == Integer.MIN_VALUE) {
                        this.DW++;
                    } else {
                        this.v5 = ((this.Zo & Integer.MAX_VALUE) % (this.j6.FH.length - 2)) + 1;
                        this.Hw = (this.Zo & Integer.MAX_VALUE) % this.j6.FH.length;
                        this.gn = this.Zo;
                        this.DW++;
                        return DW();
                    }
                }
                return false;
            }
            while (true) {
                this.Zo = this.j6.FH[this.Hw];
                if (this.Zo == 0) {
                    this.v5 = 0;
                    return DW();
                } else if (this.Zo == this.gn) {
                    break;
                } else {
                    this.Hw = (this.Hw + this.v5) % this.j6.FH.length;
                }
            }
            if (this.Zo == Integer.MAX_VALUE) {
                this.Zo = 0;
            }
            this.VH = this.j6.v5[this.Hw];
            this.Hw = (this.Hw + this.v5) % this.j6.FH.length;
            return true;
        } else if (this.FH == -1) {
            while (this.DW < this.j6.FH.length) {
                this.Zo = this.j6.FH[this.DW];
                if (this.Zo == 0 || this.Zo == Integer.MIN_VALUE) {
                    this.DW++;
                } else {
                    if (this.Zo == Integer.MAX_VALUE) {
                        this.Zo = 0;
                    }
                    this.VH = this.j6.v5[this.DW];
                    this.DW++;
                    return true;
                }
            }
            return false;
        } else {
            while (true) {
                this.Zo = this.j6.FH[this.DW];
                if (this.Zo == 0) {
                    return false;
                }
                if (this.Zo == this.gn) {
                    break;
                }
                this.DW = (this.DW + this.FH) % this.j6.FH.length;
            }
            if (this.Zo == Integer.MAX_VALUE) {
                this.Zo = 0;
            }
            this.VH = this.j6.v5[this.DW];
            this.DW = (this.DW + this.FH) % this.j6.FH.length;
            return true;
        }
    }

    public int FH() {
        return this.Zo;
    }

    public int Hw() {
        return this.VH;
    }
}
