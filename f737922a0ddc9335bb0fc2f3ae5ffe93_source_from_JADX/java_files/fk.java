public class fk {
    private cc j6;

    public fk(cc ccVar) {
        this.j6 = ccVar;
    }

    public void j6() {
        ec ecVar = new ec();
        eb Hw = this.j6.cn.Hw();
        Hw.j6.j6();
        while (Hw.j6.DW()) {
            bv FH = Hw.j6.FH();
            if ((FH.BT() instanceof fj) && !FH.v5().endsWith(".min.css")) {
                cj DW = this.j6.sh.DW(FH, (bj) FH.BT().Zo().get(0));
                j6(DW, DW.Ws(), ecVar);
                this.j6.sh.j6(DW);
            }
        }
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            this.j6.lg.j6(this.j6.ro.j6(ecVar.j6.FH()));
        }
    }

    private void j6(cj cjVar, int i, ec ecVar) {
        if (cjVar.rN(i) == 151) {
            ecVar.j6(cjVar.gW(cjVar.Hw(i, 1)));
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2), ecVar);
        }
    }
}
