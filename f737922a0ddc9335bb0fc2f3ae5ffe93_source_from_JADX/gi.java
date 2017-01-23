public class gi {
    private final gk DW;
    private ck FH;
    private cj Hw;
    private dj<bm$a> VH;
    private int Zo;
    private final cc j6;
    private int v5;

    public gi(cc ccVar, gk gkVar) {
        this.VH = new dj();
        this.j6 = ccVar;
        this.DW = gkVar;
    }

    public void j6(cj cjVar, ck ckVar, int i, int i2) {
        if (this.j6.u7().DW(cjVar.tp()).contains(gj.AUTO_INSERT_JAVADOC_ASTERISK_ONTYPE)) {
            int EQ = cjVar.EQ(i, i2);
            if (EQ != -1 && cjVar.rN(EQ) == 2) {
                this.j6.rN.j6(cjVar.we(), i + 1, 1, i + 1, 1, "* ");
            }
        }
    }

    public dj<bm$a> DW(cj cjVar, ck ckVar, int i, int i2) {
        return FH(cjVar, ckVar, i, i2);
    }

    public dj<bm$a> FH(cj cjVar, ck ckVar, int i, int i2) {
        this.Zo = i;
        this.v5 = i2;
        this.FH = ckVar;
        this.Hw = cjVar;
        this.VH.j6();
        j6(cjVar.Ws());
        return this.VH;
    }

    private void j6(int i) {
        int i2 = 0;
        if (DW(i)) {
            int DW;
            if (this.Hw.rN(i) == 1 && this.FH.FH(this.Hw, i) == 1) {
                this.VH.j6(this.FH.DW(this.Hw, i), new bm$a(this.DW, 0, false, true, 500));
            } else if (this.Hw.rN(i) == 2) {
                for (DW = this.FH.DW(this.Hw, i) + 1; DW <= this.FH.Hw(this.Hw, i); DW++) {
                    this.VH.j6(DW, new bm$a(this.DW, 1, true, false, 500));
                }
            }
            DW = this.Hw.lg(i);
            while (i2 < DW) {
                j6(this.Hw.Hw(i, i2));
                i2++;
            }
        }
    }

    private boolean DW(int i) {
        if (this.v5 < this.FH.DW(this.Hw, i) || this.Zo > this.FH.Hw(this.Hw, i)) {
            return false;
        }
        return true;
    }
}
