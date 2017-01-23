import com.aide.uidesigner.ProxyTextView;

public class aq {
    private final by DW;
    private final bw FH;
    private final bt Hw;
    private final ap Zo;
    private final ba j6;
    private final cl v5;

    public aq(ba baVar) {
        this.j6 = baVar;
        this.DW = baVar.ro;
        this.FH = baVar.cn;
        this.Hw = baVar.cb;
        this.v5 = baVar.sh;
        this.Zo = baVar.j6;
    }

    public void j6(bv bvVar, int i, int i2) {
        this.j6.rN.DW();
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            switch (DW.J8(gn)) {
                case 19:
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    j6(DW.tp(), (bz) DW.QX(gn));
                    this.j6.rN.Zo();
                    return;
                default:
                    this.j6.rN.Hw("Select a method to inline.");
                    return;
            }
        }
        this.v5.j6(DW);
        this.j6.rN.Hw("Select a method to inline.");
    }

    private void j6(bj bjVar, bz bzVar) {
        bv tp = bzVar.tp();
        do doVar = new do();
        do doVar2 = new do();
        do doVar3 = new do();
        do doVar4 = new do();
        do doVar5 = new do();
        if (bjVar.v5().j6(bzVar, doVar, doVar2, doVar3, doVar4, doVar5)) {
            this.Zo.DW(bzVar.aq());
            while (true) {
                bv FH = this.Zo.FH();
                if (FH == null) {
                    return;
                }
                if (FH.BT() == tp.BT()) {
                    cj DW = this.v5.DW(FH, bjVar);
                    bjVar.v5().j6(FH, bzVar, doVar, doVar2, doVar3, doVar4, doVar5);
                    this.v5.j6(DW);
                }
            }
        }
    }
}
