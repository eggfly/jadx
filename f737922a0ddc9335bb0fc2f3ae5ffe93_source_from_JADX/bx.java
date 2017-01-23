import java.util.List;

public class bx {
    private bx$b DW;
    private bx$c FH;
    private dj<bx$a> Hw;
    private final cc j6;

    public bx(cc ccVar) {
        this.j6 = ccVar;
        this.FH = new bx$c(ccVar, this);
        this.DW = new bx$b(ccVar);
        this.Hw = new dj();
    }

    private bx$a j6(bv bvVar, bj bjVar) {
        return (bx$a) this.Hw.FH(bvVar.vy());
    }

    private void DW(bv bvVar, bj bjVar) {
        if (!this.Hw.j6(bvVar.vy())) {
            this.Hw.j6(bvVar.vy(), new bx$a(this.j6));
        }
        if (((bx$a) this.Hw.FH(bvVar.vy())).j6() != bvVar.aM()) {
            ((bx$a) this.Hw.FH(bvVar.vy())).j6(bvVar.aM());
            cj DW = this.j6.sh.DW(bvVar, bjVar);
            bjVar.Zo().v5(DW);
            this.j6.sh.j6(DW);
            this.DW.j6((bx$a) this.Hw.FH(bvVar.vy()));
        }
    }

    public void j6(ef efVar) {
    }

    public void j6(ee eeVar) {
    }

    public void j6() {
        this.Hw.j6();
    }

    public void DW() {
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2) {
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, i2);
    }

    public void DW(bv bvVar, bj bjVar, int i, int i2) {
        ((bx$a) this.Hw.FH(bvVar.vy())).DW(i, i2);
    }

    public void j6(bv bvVar, bj bjVar, int i) {
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, -1, this.j6.ro.j6("new"), false, null, -1);
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, do doVar, do doVar2, bz bzVar) {
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, i2, doVar, doVar2);
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, -1, this.j6.ro.j6("function"), false, bzVar, -1);
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, boolean z, bz bzVar, int i4) {
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, i2, i3, z, bzVar, i4);
    }

    public void FH(bv bvVar, bj bjVar, int i, int i2) {
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, -1, this.j6.ro.j6("[]"), false, null, i2);
    }

    public void j6(bv bvVar, bj bjVar, int i, int i2, do doVar, int i3) {
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, i2, doVar, i3);
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, -1, this.j6.ro.j6("()"), false, null, i3);
    }

    public void j6(bv bvVar, bj bjVar, bz bzVar, int i) {
        int v5 = bzVar.v5() | Integer.MIN_VALUE;
        j6(bvVar, bjVar, v5, bzVar.v5());
        DW(bvVar, bjVar, v5, i);
    }

    public void j6(bv bvVar, bj bjVar, int i, bz bzVar) {
        ((bx$a) this.Hw.FH(bvVar.vy())).j6(i, bzVar);
    }

    public void j6(cj cjVar) {
        DW(cjVar.we(), cjVar.tp());
        this.FH.DW(cjVar.we(), cjVar.tp(), -1);
    }

    public void DW(cj cjVar) {
        ((bx$a) this.Hw.FH(cjVar.we().vy())).j6(0);
    }

    public void j6(cj cjVar, int i) {
        bv we = cjVar.we();
        if (!this.Hw.j6(we.vy())) {
            this.Hw.j6(we.vy(), new bx$a(this.j6));
        }
        ((bx$a) this.Hw.FH(we.vy())).j6(we.aM());
        cjVar.tp().Zo().v5(cjVar);
        this.FH.DW(we, cjVar.tp(), i);
    }

    public bz j6(int i, int i2) {
        return this.FH.j6(i, i2);
    }

    public boolean DW(int i, int i2) {
        return this.FH.DW(i, i2);
    }

    public int DW(bv bvVar, bj bjVar, int i) {
        return this.FH.j6(bvVar, bjVar, i);
    }

    public List<cp> DW(cj cjVar, int i) {
        return this.FH.DW(cjVar, i);
    }

    public dm<bz> FH(cj cjVar, int i) {
        return this.FH.j6(cjVar, i);
    }

    public List<List<cp>> Hw(cj cjVar, int i) {
        return this.FH.Hw(cjVar, i);
    }

    public List<bz> v5(cj cjVar, int i) {
        return this.FH.FH(cjVar, i);
    }
}
