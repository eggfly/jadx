public class ap {
    private final cl DW;
    private ec EQ;
    private final bw FH;
    private dy Hw;
    private eb VH;
    private dy Zo;
    private eb gn;
    private final ba j6;
    private int tp;
    private du u7;
    private dy v5;
    private eb we;

    public ap(ba baVar) {
        this.j6 = baVar;
        this.DW = baVar.sh;
        this.FH = baVar.cn;
        this.Hw = new dy();
        this.v5 = new dy();
        this.Zo = new dy();
        this.VH = new eb(this.FH);
        this.gn = new eb(this.FH);
        this.u7 = new du();
        this.we = new eb(this.FH);
    }

    protected void j6(ee eeVar) {
        this.Hw = new dy(eeVar);
        this.v5 = new dy(eeVar);
        this.Zo = new dy(eeVar);
        this.VH = new eb(this.FH, eeVar);
        this.gn = new eb(this.FH, eeVar);
        this.u7 = new du(eeVar);
    }

    protected void j6(ef efVar) {
        this.Hw.j6(efVar);
        this.v5.j6(efVar);
        this.Zo.j6(efVar);
        this.VH.j6(efVar);
        this.gn.j6(efVar);
        this.u7.j6(efVar);
    }

    protected void j6() {
        this.u7.j6.j6();
        while (this.u7.j6.DW()) {
            bv gn = this.FH.gn(this.u7.j6.FH());
            if (this.VH.FH(gn)) {
                if (gn.QX() != this.u7.j6.Hw()) {
                    this.VH.DW(gn);
                    this.Hw.j6(gn.vy());
                    this.v5.j6(gn.vy());
                }
            }
            if (this.gn.FH(gn)) {
                if (gn.QX() != this.u7.j6.Hw()) {
                    this.gn.DW(gn);
                    this.Zo.j6(gn.vy());
                }
            }
        }
    }

    public void j6(int i) {
        this.we.j6();
        this.we.j6(this.FH.Hw());
        this.we.j6.j6();
        this.EQ = null;
        this.tp = this.j6.ro.FH(i);
    }

    public void j6(ec ecVar) {
        this.we.j6();
        this.we.j6(this.FH.Hw());
        this.we.j6.j6();
        this.EQ = new ec();
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            this.EQ.j6(this.j6.ro.FH(ecVar.j6.FH()));
        }
    }

    public void DW(ec ecVar) {
        this.we.j6();
        this.we.j6(this.FH.Hw());
        this.we.j6.j6();
        while (this.we.j6.DW()) {
            j6(this.we.j6.FH());
        }
        this.v5.j6.j6();
        while (this.v5.j6.DW()) {
            ecVar.j6(this.v5.j6.Hw());
        }
    }

    public bv DW() {
        while (this.we.j6.DW()) {
            bv FH = this.we.j6.FH();
            j6(FH);
            if (this.EQ != null) {
                this.EQ.j6.j6();
                while (this.EQ.j6.DW()) {
                    if (this.v5.FH(FH.vy(), this.EQ.j6.FH())) {
                        return FH;
                    }
                }
                continue;
            } else if (this.v5.FH(FH.vy(), this.tp)) {
                return FH;
            }
        }
        return null;
    }

    public void FH(ec ecVar) {
        this.we.j6();
        this.we.j6(this.FH.Hw());
        this.we.j6.j6();
        this.EQ = new ec();
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            this.EQ.j6(this.j6.ro.FH(ecVar.j6.FH()));
        }
    }

    public bv FH() {
        while (this.we.j6.DW()) {
            bv FH = this.we.j6.FH();
            j6(FH);
            if (this.EQ != null) {
                this.EQ.j6.j6();
                while (this.EQ.j6.DW()) {
                    if (this.Hw.FH(FH.vy(), this.EQ.j6.FH())) {
                        return FH;
                    }
                }
                continue;
            } else if (this.Hw.FH(FH.vy(), this.tp)) {
                return FH;
            }
        }
        return null;
    }

    public boolean j6(bv bvVar, ec ecVar) {
        DW(bvVar);
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            if (this.Zo.FH(bvVar.vy(), this.j6.ro.FH(ecVar.j6.FH()))) {
                return true;
            }
        }
        return false;
    }

    public boolean j6(bv bvVar, int i) {
        DW(bvVar);
        if (this.Zo.FH(bvVar.vy(), this.j6.ro.FH(i))) {
            return true;
        }
        return false;
    }

    public boolean DW(bv bvVar, int i) {
        j6(bvVar);
        if (this.v5.FH(bvVar.vy(), this.j6.ro.FH(i))) {
            return true;
        }
        return false;
    }

    public boolean FH(bv bvVar, int i) {
        j6(bvVar);
        if (this.Hw.FH(bvVar.vy(), this.j6.ro.FH(i))) {
            return true;
        }
        return false;
    }

    public boolean DW(bv bvVar, ec ecVar) {
        j6(bvVar);
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            if (this.Hw.FH(bvVar.vy(), this.j6.ro.FH(ecVar.j6.FH()))) {
                return true;
            }
        }
        return false;
    }

    public void DW(int i) {
        this.we.j6();
        this.we.j6(this.FH.Hw());
        this.we.j6.j6();
        this.tp = this.j6.ro.FH(i);
        this.EQ = null;
    }

    private void DW(bv bvVar) {
        if (!this.gn.FH(bvVar)) {
            this.gn.j6(bvVar);
            this.u7.j6(bvVar.vy(), bvVar.QX());
            for (cj cjVar : this.DW.j6(bvVar)) {
                DW(cjVar, bvVar, cjVar.Ws());
                this.j6.sh.j6(cjVar);
            }
        }
    }

    public void j6(bv bvVar) {
        DW(bvVar);
        if (!this.VH.FH(bvVar)) {
            this.VH.j6(bvVar);
            this.u7.j6(bvVar.vy(), bvVar.QX());
            for (cj cjVar : this.DW.j6(bvVar)) {
                j6(cjVar, bvVar, cjVar.Ws());
                this.j6.sh.j6(cjVar);
            }
        }
    }

    private void j6(cj cjVar, bv bvVar, int i) {
        if (cjVar.OW(i)) {
            v5(bvVar, this.j6.ro.FH(cjVar.gW(i)));
            Hw(bvVar, this.j6.ro.FH(cjVar.gW(i)));
        } else if (cjVar.sy(i)) {
            Hw(bvVar, this.j6.ro.FH(cjVar.gW(i)));
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, bvVar, cjVar.Hw(i, i2));
        }
    }

    private void DW(cj cjVar, bv bvVar, int i) {
        if (cjVar.lp(i)) {
            Zo(bvVar, this.j6.ro.FH(cjVar.gW(i)));
        }
        if (!cjVar.Qq(i)) {
            int lg = cjVar.lg(i);
            for (int i2 = 0; i2 < lg; i2++) {
                DW(cjVar, bvVar, cjVar.Hw(i, i2));
            }
        }
    }

    private void Hw(bv bvVar, int i) {
        this.Hw.DW(bvVar.vy(), i);
    }

    private void v5(bv bvVar, int i) {
        this.v5.DW(bvVar.vy(), i);
    }

    private void Zo(bv bvVar, int i) {
        this.Zo.DW(bvVar.vy(), i);
    }
}
