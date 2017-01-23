public class av {
    private final bt DW;
    private final cl FH;
    private final ba j6;

    public av(ba baVar) {
        this.j6 = baVar;
        this.DW = baVar.cb;
        this.FH = baVar.sh;
    }

    public void j6(cj cjVar) {
        j6(cjVar, cjVar.Ws());
    }

    private void j6(cj cjVar, int i) {
        bz DW;
        if (cjVar.ca(i)) {
            try {
                DW = this.DW.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                if (DW.sG()) {
                    int gW = DW.gW();
                    int yS = DW.yS();
                    int er = DW.er();
                    this.j6.sG.j6(cjVar.we(), cjVar.tp(), er, gW, er, yS, "", 91);
                }
            } catch (ej e) {
            }
        }
        if (cjVar.x9(i)) {
            try {
                DW = this.DW.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                if (DW.sG()) {
                    gW = DW.gW();
                    yS = DW.yS();
                    er = DW.er();
                    this.j6.sG.j6(cjVar.we(), cjVar.tp(), er, gW, er, yS, "", 91);
                }
            } catch (ej e2) {
            }
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2));
        }
    }

    public void j6(bv bvVar) {
        if (bvVar.BT() != null) {
            this.j6.Mr.j6();
            int i = 0;
            for (cj cjVar : this.j6.sh.DW(bvVar)) {
                int j6 = j6(cjVar, cjVar.Ws(), 0);
                if (j6 > 0) {
                    this.j6.Mr.j6(cjVar.tp(), j6);
                    i++;
                }
                this.FH.j6(cjVar);
            }
            this.j6.Mr.j6(bvVar, i);
        }
    }

    private int j6(cj cjVar, int i, int i2) {
        int lg = cjVar.lg(i);
        int i3 = i2;
        for (int i4 = 0; i4 < lg; i4++) {
            int Hw = cjVar.Hw(i, i4);
            if (cjVar.vy(Hw)) {
                if (!cjVar.er(Hw) && cjVar.nw(Hw) > 0) {
                    int j6 = j6(cjVar, Hw, 0);
                    int QX = cjVar.tp().Hw().QX(cjVar, Hw);
                    if (QX <= 0) {
                        this.j6.Mr.j6(cjVar.nw(Hw) + "," + cjVar.KD(Hw), cjVar.tp().Hw().XL(cjVar, Hw), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.KD(Hw), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.SI(Hw), cjVar.ro(Hw), j6);
                    } else {
                        this.j6.Mr.j6(this.j6.ro.j6(cjVar.gW(QX)), cjVar.tp().Hw().XL(cjVar, Hw), cjVar.nw(QX), cjVar.KD(QX), cjVar.ro(QX), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.SI(Hw), cjVar.ro(Hw), j6);
                    }
                    i3++;
                }
            } else if (cjVar.I(Hw)) {
                if (!cjVar.er(Hw) && cjVar.nw(Hw) > 0) {
                    int i5;
                    int j62 = j6(cjVar, Hw, 0);
                    try {
                        r4 = this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.XL(Hw));
                        this.j6.Mr.j6(r4, r4.er(), r4.gW(), r4.yS(), r4.ro(), r4.KD(), r4.SI(), r4.nw(), j62);
                        i5 = i3 + 1;
                    } catch (ej e) {
                        i5 = i3;
                    }
                    i3 = i5;
                }
            } else if (cjVar.ca(Hw)) {
                if (!cjVar.er(Hw) && cjVar.nw(Hw) > 0) {
                    try {
                        r4 = this.DW.DW(cjVar.we(), cjVar.tp(), cjVar.XL(Hw));
                        this.j6.Mr.j6(r4, r4.er(), r4.gW(), r4.yS(), r4.ro(), r4.KD(), r4.SI(), r4.nw());
                        i3++;
                    } catch (ej e2) {
                    }
                }
            } else if (!cjVar.x9(Hw)) {
                i3 = j6(cjVar, Hw, i3);
            } else if (!cjVar.er(Hw) && cjVar.nw(Hw) > 0) {
                try {
                    r4 = this.DW.DW(cjVar.we(), cjVar.tp(), cjVar.XL(Hw));
                    this.j6.Mr.j6(r4, r4.er(), r4.gW(), r4.yS(), r4.ro(), r4.KD(), r4.SI(), r4.nw());
                    i3++;
                } catch (ej e3) {
                }
            }
        }
        return i3;
    }
}
