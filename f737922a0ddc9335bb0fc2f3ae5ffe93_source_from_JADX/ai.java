public class ai {
    private final by DW;
    private final bw FH;
    private final bt Hw;
    private final ap Zo;
    private final ba j6;
    private final cl v5;

    public ai(ba baVar) {
        this.j6 = baVar;
        this.DW = baVar.ro;
        this.FH = baVar.cn;
        this.Hw = baVar.cb;
        this.v5 = baVar.sh;
        this.Zo = baVar.j6;
    }

    public void j6(bv bvVar, int i, int i2, boolean z) {
        this.j6.gW.DW();
        cj DW = this.v5.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            if (DW.J8(gn) != 0) {
                bs Xa;
                bs QX = DW.QX(gn);
                if (QX.zh() && ((bz) QX).sy()) {
                    Xa = ((bz) QX).Xa();
                } else {
                    Xa = QX;
                }
                if (Xa.cT()) {
                    this.j6.gW.j6("Inheritors of " + Xa.iW());
                    boolean z2 = Xa.tp().DW() || !z;
                    eb j6 = j6(z2);
                    ec ecVar = new ec();
                    ea eaVar = new ea(this.Hw);
                    ea eaVar2 = new ea(this.Hw);
                    ea eaVar3 = new ea(this.Hw);
                    eaVar2.j6((bp) Xa);
                    do {
                        eaVar3.j6();
                        ecVar.j6();
                        eaVar2.j6.j6();
                        while (eaVar2.j6.DW()) {
                            ecVar.j6(((bp) eaVar2.j6.FH()).aq());
                        }
                        j6(ecVar, eaVar2, eaVar3, eaVar, j6, z);
                        eaVar2.j6();
                        eaVar2.j6(eaVar3);
                    } while (eaVar3.Hw() != 0);
                }
            }
        }
        this.v5.j6(DW);
        this.j6.gW.j6();
    }

    public void DW(bv bvVar, int i, int i2, boolean z) {
        this.j6.gW.DW();
        cj DW = this.v5.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            int J8 = DW.J8(gn);
            int gW = DW.gW(gn);
            if (J8 != 0) {
                bs Xa;
                bs QX = DW.QX(gn);
                if (QX.zh() && ((bz) QX).sy()) {
                    Xa = ((bz) QX).Xa();
                } else {
                    Xa = QX;
                }
                if (Xa.cT()) {
                    this.j6.gW.j6("Methods returning " + Xa.iW());
                    ea eaVar = new ea(this.j6.cb);
                    boolean z2 = Xa.tp().DW() || !z;
                    eb j6 = j6(z2);
                    ec ecVar = new ec();
                    ea eaVar2 = new ea(this.Hw);
                    ea eaVar3 = new ea(this.Hw);
                    ea eaVar4 = new ea(this.Hw);
                    eaVar3.j6((bp) Xa);
                    do {
                        eaVar4.j6();
                        ecVar.j6();
                        eaVar3.j6.j6();
                        while (eaVar3.j6.DW()) {
                            ecVar.j6(((bp) eaVar3.j6.FH()).aq());
                        }
                        j6(DW, ecVar, (bp) Xa, eaVar3, eaVar4, eaVar2, j6, eaVar, z);
                        eaVar3.j6();
                        eaVar3.j6(eaVar4);
                    } while (eaVar4.Hw() != 0);
                    j6(DW, gW, (bp) Xa, j6, z, true, false);
                }
            }
        }
        this.v5.j6(DW);
        this.j6.gW.j6();
    }

    public void FH(bv bvVar, int i, int i2, boolean z) {
        this.j6.gW.DW();
        cj DW = this.v5.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            int gW = DW.gW(gn);
            if (DW.J8(gn) != 0) {
                bs QX = DW.QX(gn);
                if (QX.zh() && ((bz) QX).sy()) {
                    QX = ((bz) QX).Xa();
                }
                if (QX.cT()) {
                    this.j6.gW.j6("Methods taking " + QX.iW());
                    boolean z2 = QX.tp().DW() || !z;
                    j6(DW, gW, (bp) QX, j6(z2), z, false, true);
                }
            }
        }
        this.v5.j6(DW);
        this.j6.gW.j6();
    }

    public void j6(bv bvVar, int i, int i2) {
        this.j6.gW.DW();
        cj DW = this.v5.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            DW.gW(gn);
            if (DW.J8(gn) != 0) {
                bs QX = DW.QX(gn);
                ea cb;
                bs bsVar;
                if (QX.zh() && ((bz) QX).gn()) {
                    this.j6.gW.j6("Overridden methods of " + QX.iW());
                    cb = ((bz) QX).cb();
                    cb.j6.j6();
                    while (cb.j6.DW()) {
                        bsVar = (bz) cb.j6.FH();
                        if (bsVar != QX) {
                            this.j6.gW.j6(bsVar);
                        }
                    }
                } else if (QX.zh() && ((bz) QX).u7()) {
                    this.j6.gW.j6("Overridden properties of " + QX.iW());
                    cb = ((bz) QX).cb();
                    cb.j6.j6();
                    while (cb.j6.DW()) {
                        bsVar = (bz) cb.j6.FH();
                        if (bsVar != QX) {
                            this.j6.gW.j6(bsVar);
                        }
                    }
                }
            }
        }
        this.v5.j6(DW);
        this.j6.gW.j6();
    }

    public void Hw(bv bvVar, int i, int i2, boolean z) {
        boolean z2 = false;
        this.j6.gW.DW();
        cj DW = this.v5.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            int gW = DW.gW(gn);
            if (DW.J8(gn) != 0) {
                bs QX = DW.QX(gn);
                if (QX.zh() && ((bz) QX).gn()) {
                    this.j6.gW.j6("Methods overriding " + QX.iW());
                    boolean z3 = QX.tp().DW() || !z;
                    j6(DW, gW, QX, j6(z3), z);
                } else if (QX.zh() && ((bz) QX).u7()) {
                    this.j6.gW.j6("Properties overriding " + QX.iW());
                    if (QX.tp().DW() || !z) {
                        z2 = true;
                    }
                    j6(DW, gW, QX, j6(z2), z);
                }
            }
        }
        this.v5.j6(DW);
        this.j6.gW.j6();
    }

    private eb j6(boolean z) {
        if (z) {
            eb ebVar = new eb(this.FH);
            ebVar.j6(this.FH.Hw());
            return ebVar;
        }
        ebVar = new eb(this.FH);
        ebVar.j6(this.FH.v5());
        return ebVar;
    }

    private void j6(ec ecVar, ea<bp> eaVar, ea<bp> eaVar2, ea<bp> eaVar3, eb ebVar, boolean z) {
        ebVar.j6.j6();
        while (ebVar.j6.DW() && !this.j6.P8.v5()) {
            bv FH = ebVar.j6.FH();
            if ((FH.DW() && this.Zo.DW(FH, ecVar)) || (!FH.DW() && this.Zo.j6(FH, ecVar))) {
                ea j6 = this.Hw.j6(FH);
                j6.j6.j6();
                while (j6.j6.DW()) {
                    bs FH2 = j6.j6.FH();
                    if (FH2.cT()) {
                        FH2 = (bp) FH2;
                        eaVar.j6.j6();
                        while (eaVar.j6.DW()) {
                            if (!(FH2 == eaVar.j6.FH() || !FH2.jO().FH(eaVar.j6.FH()) || eaVar3.FH(FH2))) {
                                this.j6.gW.j6(FH2);
                                eaVar2.j6(FH2);
                                eaVar3.j6(FH2);
                            }
                        }
                    }
                }
            }
        }
    }

    private void j6(cj cjVar, ec ecVar, bp bpVar, ea<bp> eaVar, ea<bp> eaVar2, ea<bp> eaVar3, eb ebVar, ea<bs> eaVar4, boolean z) {
        ebVar.j6.j6();
        while (ebVar.j6.DW() && !this.j6.P8.v5()) {
            bv FH = ebVar.j6.FH();
            if ((FH.DW() && this.Zo.DW(FH, ecVar)) || (!FH.DW() && this.Zo.j6(FH, ecVar))) {
                ea j6 = this.Hw.j6(FH);
                j6.j6.j6();
                while (j6.j6.DW()) {
                    bs FH2 = j6.j6.FH();
                    if (FH2.cT()) {
                        FH2 = (bp) FH2;
                        eaVar.j6.j6();
                        while (eaVar.j6.DW()) {
                            if (!(FH2 == eaVar.j6.FH() || !FH2.jO().FH(eaVar.j6.FH()) || eaVar3.FH(FH2))) {
                                eaVar2.j6(FH2);
                                eaVar3.j6(FH2);
                            }
                        }
                    } else if (FH2.zh() && ((bz) FH2).gn()) {
                        try {
                            FH2 = (bz) FH2;
                            if ((eaVar.FH(FH2.Mz().a_()) || j6(FH2.Mz(), bpVar)) && !eaVar4.FH(FH2)) {
                                eaVar4.j6(FH2);
                                this.j6.gW.j6(FH2);
                            }
                        } catch (ej e) {
                        }
                    } else if (FH2.zh() && ((bz) FH2).u7()) {
                        try {
                            FH2 = (bz) FH2;
                            if (((FH2.J0() && eaVar.FH(FH2.Mz().a_())) || j6(FH2.Mz(), bpVar)) && !eaVar4.FH(FH2)) {
                                eaVar4.j6(FH2);
                                this.j6.gW.j6(FH2);
                            }
                        } catch (ej e2) {
                        }
                    }
                }
            }
        }
    }

    private void j6(cj cjVar, int i, bp bpVar, eb ebVar, boolean z, boolean z2, boolean z3) {
        ebVar.j6.j6();
        while (ebVar.j6.DW() && !this.j6.P8.v5()) {
            bv FH = ebVar.j6.FH();
            if ((FH.DW() && this.Zo.FH(FH, i)) || (!FH.DW() && this.Zo.j6(FH, i))) {
                ea j6 = this.Hw.j6(FH);
                j6.j6.j6();
                while (j6.j6.DW()) {
                    bs FH2 = j6.j6.FH();
                    if (FH2.zh() && ((bz) FH2).gn()) {
                        try {
                            FH2 = (bz) FH2;
                            int lp = FH2.lp();
                            int i2 = 0;
                            while (i2 < lp) {
                                if (j6(FH2.v5(i2), bpVar) && ((z2 && cd.EQ(FH2.VH(i2))) || cd.tp(FH2.VH(i2)) || (z3 && !cd.EQ(FH2.VH(i2))))) {
                                    this.j6.gW.j6(FH2);
                                }
                                i2++;
                            }
                        } catch (ej e) {
                        }
                    } else if (FH2.zh() && ((bz) FH2).u7()) {
                        try {
                            FH2 = (bz) FH2;
                            if (FH2.J0() && FH2.Ws() && FH2.Mz().a_().Hw(bpVar)) {
                                this.j6.gW.j6(FH2);
                            }
                        } catch (ej e2) {
                        }
                    }
                }
            }
        }
    }

    private boolean j6(co coVar, bp bpVar) {
        if (coVar.Hw(bpVar)) {
            return true;
        }
        if (coVar.a_().Hw(bpVar)) {
            return true;
        }
        if (coVar.AL()) {
            return j6(((bo) coVar).j6(), bpVar);
        }
        if (!coVar.n5()) {
            return false;
        }
        co[] DW = ((cf) coVar).DW();
        for (co j6 : DW) {
            if (j6(j6, bpVar)) {
                return true;
            }
        }
        return false;
    }

    private void j6(cj cjVar, int i, bs bsVar, eb ebVar, boolean z) {
        ebVar.j6.j6();
        while (ebVar.j6.DW() && !this.j6.P8.v5()) {
            bv FH = ebVar.j6.FH();
            if ((FH.DW() && this.Zo.DW(FH, i)) || (!FH.DW() && this.Zo.j6(FH, i))) {
                ea j6 = this.Hw.j6(FH);
                j6.j6.j6();
                while (j6.j6.DW()) {
                    bs FH2 = j6.j6.FH();
                    if (FH2.zh() && ((bz) FH2).gn()) {
                        bs bsVar2 = (bz) FH2;
                        if (bsVar2 != bsVar && bsVar2.ef().FH(bsVar)) {
                            this.j6.gW.j6(bsVar2);
                        }
                    }
                    if (FH2.zh() && ((bz) FH2).u7()) {
                        FH2 = (bz) FH2;
                        if (FH2 != bsVar && FH2.ef().FH(bsVar)) {
                            this.j6.gW.j6(FH2);
                        }
                    }
                }
            }
        }
    }
}
