public class fb extends gz {
    private final hc DW;
    private final gv FH;
    private eb Hw;
    private final cc j6;
    private do v5;

    public fb(cc ccVar, ez ezVar) {
        super(ccVar, ezVar);
        this.j6 = ccVar;
        this.FH = ezVar;
        this.DW = ezVar.we();
        this.Hw = new eb(ccVar.cn);
        this.v5 = new do();
    }

    public long Hw(cj cjVar) {
        return 0;
    }

    public long DW(cj cjVar) {
        return 0;
    }

    public long FH(cj cjVar) {
        return 0;
    }

    public void j6(bv bvVar) {
        if (bvVar.J8()) {
            bv EQ = bvVar.EQ();
            this.v5.j6();
            for (bv u7 = bvVar.u7(); u7 != EQ; u7 = u7.u7()) {
                this.v5.DW(u7.VH());
            }
            ce Mr = this.DW.Mr();
            for (int Hw = this.v5.Hw() - 1; Hw >= 0; Hw--) {
                Mr = Mr.j6(this.v5.FH(Hw));
            }
            this.j6.cb.j6(bvVar, this.FH, Mr, bvVar.Zo(), false, -1);
            return;
        }
        super.j6(bvVar);
    }
}
