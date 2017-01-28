import java.util.List;

public class aj {
    private cj DW;
    private ec FH;
    private final ba j6;

    public aj(ba baVar) {
        this.j6 = baVar;
        this.DW = new cj(baVar);
        this.FH = new ec();
    }

    public void j6(List<String> list) {
        eb ebVar = new eb(this.j6.cn);
        ebVar.j6(this.j6.cn.Hw());
        eb ebVar2 = new eb(this.j6.cn);
        ebVar.j6.j6();
        while (ebVar.j6.DW()) {
            for (bv u7 = ebVar.j6.FH().u7(); !u7.U2(); u7 = u7.u7()) {
                ebVar2.j6(u7);
            }
        }
        aj$a aj_a = new aj$a();
        for (int i = 0; i < list.size(); i++) {
            aj_a.j6(j6(this.j6.cn.DW((String) list.get(i)), ebVar2));
        }
        j6(aj_a);
        this.j6.yS.j6();
    }

    private aj$a j6(bv bvVar, eb ebVar) {
        int i = 0;
        bv FH;
        if (bvVar.Mr() && ebVar.FH(bvVar)) {
            int yS = bvVar.yS();
            aj$a aj_a = new aj$a();
            for (int i2 = 0; i2 < yS; i2++) {
                if (this.j6.P8.Hw()) {
                    return null;
                }
                bv FH2 = bvVar.FH(i2);
                if (FH2.Mr()) {
                    aj_a.j6(j6(FH2, ebVar));
                }
            }
            while (i < yS) {
                if (this.j6.P8.Hw()) {
                    return null;
                }
                FH = bvVar.FH(i);
                if (!FH.Mr()) {
                    aj_a.j6(j6(FH, ebVar));
                }
                i++;
            }
            if (aj_a.DW > 0) {
                j6(bvVar, aj_a);
            }
            return aj_a;
        } else if (bvVar.BT() == null || !bvVar.DW()) {
            return null;
        } else {
            this.FH.j6();
            aj$a aj_a2 = new aj$a();
            for (bj j6 : bvVar.BT().Zo()) {
                FH = bvVar;
                this.j6.sh.j6(FH, j6, this.DW, false, null, 0, 0);
                aj_a2.Zo = Math.max(this.DW.SI(this.DW.Ws()), aj_a2.Zo);
                j6(this.DW, this.DW.Ws(), aj_a2);
            }
            aj_a2.DW = bvVar.tp();
            aj_a2.v5 = this.FH.Hw();
            DW(bvVar, aj_a2);
            return aj_a2;
        }
    }

    private void j6(bv bvVar, aj$a aj_a) {
        this.j6.yS.j6(bvVar, aj_a.DW, aj_a.j6, aj_a.Zo, aj_a.v5, aj_a.FH, aj_a.Hw, aj_a.VH);
    }

    private void DW(bv bvVar, aj$a aj_a) {
        this.j6.yS.DW(bvVar, aj_a.DW, aj_a.j6, aj_a.Zo, aj_a.v5, aj_a.FH, aj_a.Hw, aj_a.VH);
    }

    private void j6(aj$a aj_a) {
        this.j6.yS.j6(aj_a.DW, aj_a.j6, aj_a.Zo, aj_a.v5, aj_a.FH, aj_a.Hw, aj_a.VH);
    }

    private void j6(cj cjVar, int i, aj$a aj_a) {
        if (cjVar.g3(i)) {
            aj_a.j6 += (cjVar.SI(i) - cjVar.nw(i)) + 1;
        }
        if (cjVar.ca(i)) {
            aj_a.Hw++;
        }
        if (cjVar.x9(i)) {
            aj_a.VH++;
        }
        if (cjVar.I(i)) {
            aj_a.FH++;
        }
        if (cjVar.yS(i) && !cjVar.g3(i)) {
            this.FH.j6(cjVar.nw(i));
        }
        if (!cjVar.er(i) && cjVar.SI(i) > aj_a.Zo) {
            aj_a.Zo = cjVar.SI(i);
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2), aj_a);
        }
    }
}
