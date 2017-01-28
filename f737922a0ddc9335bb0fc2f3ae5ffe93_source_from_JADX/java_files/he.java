import java.util.Stack;

public class he implements bc {
    private final hq DW;
    private Stack<he$a> FH;
    private final cc j6;

    public he(cc ccVar, hq hqVar) {
        this.j6 = ccVar;
        this.DW = hqVar;
        this.FH = new Stack();
    }

    public co j6(cj cjVar, int i, int i2, String str) {
        return null;
    }

    public void j6(cj cjVar) {
        Zo(cjVar);
    }

    public void j6(cj cjVar, ec ecVar) {
        Zo(cjVar);
    }

    public void j6(cj cjVar, int i) {
        Zo(cjVar);
    }

    public void DW(cj cjVar, int i) {
        Zo(cjVar);
    }

    public void FH(cj cjVar, int i) {
        Zo(cjVar);
    }

    public void DW(cj cjVar) {
        Zo(cjVar);
    }

    public void FH(cj cjVar) {
    }

    private void Zo(cj cjVar) {
        if (cjVar.we().FH()) {
            this.j6.Sf.j6(cjVar);
            he$a j6 = j6();
            j6.j6(cjVar, false);
            j6(j6);
        }
    }

    protected void Hw(cj cjVar) {
        if (cjVar.we().FH()) {
            he$a j6 = j6();
            j6.j6(cjVar);
            j6(j6);
        }
    }

    private he$a j6() {
        if (this.FH.size() > 0) {
            return (he$a) this.FH.pop();
        }
        return new he$a(this.j6, this.DW, this);
    }

    private void j6(he$a he_a) {
        this.FH.push(he_a);
    }

    protected dm<bp> v5(cj cjVar) {
        dm dmVar = new dm(this.j6.cb);
        eb ebVar = new eb(this.j6.cn);
        ebVar.j6(this.j6.cn.v5());
        ebVar.j6.j6();
        while (ebVar.j6.DW()) {
            j6(ebVar.j6.FH(), dmVar);
        }
        return dmVar;
    }

    private void j6(bv bvVar, dm<bp> dmVar) {
        if (bvVar != null && bvVar.FH() && (bvVar.BT() instanceof hp)) {
            for (bj bjVar : bvVar.BT().Zo()) {
                if (bjVar instanceof hq) {
                    try {
                        dmVar.FH(this.j6.cb.j6(bvVar, bjVar, 0));
                    } catch (ej e) {
                    }
                }
            }
        }
    }
}
