public class gu {
    private final by DW;
    private final bw FH;
    private final bt Hw;
    private final gv Zo;
    private final cc j6;
    private final cl v5;

    public gu(cc ccVar, gv gvVar) {
        this.j6 = ccVar;
        this.Zo = gvVar;
        this.DW = ccVar.ro;
        this.FH = ccVar.cn;
        this.Hw = ccVar.cb;
        this.v5 = ccVar.sh;
    }

    public void j6(bv bvVar, bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        cj DW = this.v5.DW(bvVar, this.Zo);
        DW.tp().u7().j6(DW, bzVar.aq());
        j6(DW, DW.Ws(), bzVar, bzVar.aq(), doVar, doVar2, doVar3, doVar4, doVar5);
        this.v5.j6(DW);
    }

    public boolean j6(bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        int i;
        int i2;
        bv tp = bzVar.tp();
        cj DW = this.v5.DW(tp, this.Zo);
        DW.tp().u7().DW(DW);
        int sG = DW.sG(bzVar.EQ());
        int Hw = DW.Hw(sG, 5);
        int Hw2 = DW.Hw(sG, DW.lg(sG) - 1);
        int i3 = -1;
        sG = -1;
        if (DW.lg(Hw2) == 3 && DW.rN(DW.Hw(Hw2, 1)) == 141 && DW.lg(DW.Hw(Hw2, 1)) == 3) {
            sG = DW.Hw(DW.Hw(Hw2, 1), 1);
            i3 = sG;
        }
        if (DW.lg(Hw2) == 3 && DW.rN(DW.Hw(Hw2, 1)) == 146 && DW.lg(DW.Hw(Hw2, 1)) == 2) {
            sG = DW.Hw(DW.Hw(Hw2, 1), 0);
            i = sG;
            i2 = sG;
        } else {
            i = sG;
            i2 = i3;
        }
        if (i2 == -1 || i == -1) {
            this.j6.rN.Hw("Cannot inline this method.");
            this.v5.j6(DW);
            return false;
        }
        this.j6.rN.j6(tp, DW.nw(i2), DW.KD(i2), DW.SI(i), DW.ro(i));
        j6(DW, Hw2, Hw, i2, bzVar.Xa(), doVar, doVar2, doVar3, doVar4, doVar5);
        this.v5.j6(DW);
        return true;
    }

    private void j6(cj cjVar, int i, int i2, int i3, bp bpVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        int KD;
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, cjVar.Hw(i, lg), i2, i3, bpVar, doVar, doVar2, doVar3, doVar4, doVar5);
        }
        if (cjVar.rN(i) == 166) {
            j6(cjVar, i, i3, -1, doVar, doVar2, doVar3, doVar4, doVar5);
        }
        if (cjVar.sy(i) && cjVar.Hw(cjVar.aM(i), 0) == i && cjVar.J8(i) == 16 && ((bz) cjVar.QX(i)).Xa() == bpVar) {
            int nw;
            nw = cjVar.nw(i) - cjVar.nw(i3);
            KD = cjVar.KD(i);
            if (nw == 0) {
                KD -= cjVar.KD(i3);
            }
            doVar.DW(-2);
            doVar2.DW(nw);
            doVar3.DW(KD);
            doVar4.DW(nw);
            doVar5.DW(KD);
        }
        if (cjVar.sy(i) && cjVar.Hw(cjVar.aM(i), 0) == i && cjVar.J8(i) == 20 && ((bz) cjVar.QX(i)).Xa() == bpVar) {
            nw = cjVar.nw(i) - cjVar.nw(i3);
            KD = cjVar.KD(i);
            if (nw == 0) {
                KD -= cjVar.KD(i3);
            }
            doVar.DW(-2);
            doVar2.DW(nw);
            doVar3.DW(KD);
            doVar4.DW(nw);
            doVar5.DW(KD);
        }
        if (cjVar.sy(i) && cjVar.J8(i) == 2) {
            int aM = cjVar.aM(cjVar.Ws(i));
            for (int i4 = 0; i4 < cjVar.lg(i2); i4++) {
                if (cjVar.Hw(i2, i4) == aM) {
                    j6(cjVar, i, i3, i4, doVar, doVar2, doVar3, doVar4, doVar5);
                }
            }
        }
    }

    private void j6(cj cjVar, int i, int i2, int i3, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        int nw = cjVar.nw(i) - cjVar.nw(i2);
        int KD = cjVar.KD(i);
        if (nw == 0) {
            KD -= cjVar.KD(i2);
        }
        int SI = cjVar.SI(i) - cjVar.nw(i2);
        int ro = cjVar.ro(i);
        if (SI == 0) {
            ro -= cjVar.KD(i2);
        }
        doVar.DW(i3);
        doVar2.DW(nw);
        doVar3.DW(KD);
        doVar4.DW(SI);
        doVar5.DW(ro);
    }

    private void j6(cj cjVar, int i, bz bzVar, int i2, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, cjVar.Hw(i, lg), bzVar, i2, doVar, doVar2, doVar3, doVar4, doVar5);
        }
        if (cjVar.sy(i) && cjVar.gW(i) == i2 && cjVar.J8(i) == 20 && cjVar.QX(i) == bzVar) {
            int aM = cjVar.aM(i);
            if (cjVar.rN(aM) == 155 || cjVar.rN(aM) == 156) {
                int Hw = cjVar.Hw(aM, cjVar.lg(aM) - 1);
                this.j6.rN.j6(cjVar.we(), cjVar.SI(aM), cjVar.ro(aM));
                for (int i3 = 0; i3 < doVar.Hw(); i3++) {
                    int FH;
                    int FH2;
                    int SI;
                    int FH3;
                    if (doVar.FH(i3) == -2) {
                        if (cjVar.cn(i)) {
                            if (cjVar.cn(cjVar.sh(i))) {
                                FH = doVar2.FH(i3);
                                FH2 = doVar3.FH(i3);
                                if (FH == 0) {
                                    FH2 += cjVar.ro(aM);
                                }
                                SI = FH + cjVar.SI(aM);
                                FH = doVar4.FH(i3);
                                FH3 = doVar5.FH(i3);
                                if (FH == 0) {
                                    FH3 += cjVar.ro(aM);
                                }
                                this.j6.rN.j6(cjVar.we(), SI, FH2, FH + cjVar.SI(aM), FH3, "");
                                this.j6.rN.DW(cjVar.we(), cjVar.nw(aM), cjVar.KD(aM), cjVar.nw(i), cjVar.KD(i), SI, FH2);
                            }
                        }
                    } else if (doVar.FH(i3) != -1) {
                        int Hw2 = cjVar.Hw(Hw, doVar.FH(i3));
                        FH = doVar2.FH(i3);
                        FH2 = doVar3.FH(i3);
                        if (FH == 0) {
                            FH2 += cjVar.ro(aM);
                        }
                        SI = FH + cjVar.SI(aM);
                        FH = doVar4.FH(i3);
                        FH3 = doVar5.FH(i3);
                        if (FH == 0) {
                            FH3 += cjVar.ro(aM);
                        }
                        this.j6.rN.j6(cjVar.we(), SI, FH2, FH + cjVar.SI(aM), FH3, "");
                        this.j6.rN.DW(cjVar.we(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.SI(Hw2), cjVar.ro(Hw2), SI, FH2);
                    } else if (cjVar.cn(i)) {
                        if (cjVar.cn(cjVar.sh(i))) {
                            FH = doVar2.FH(i3);
                            FH2 = doVar3.FH(i3);
                            if (FH == 0) {
                                FH2 += cjVar.ro(aM);
                            }
                            SI = FH + cjVar.SI(aM);
                            FH = doVar4.FH(i3);
                            FH3 = doVar5.FH(i3);
                            if (FH == 0) {
                                FH3 += cjVar.ro(aM);
                            }
                            this.j6.rN.j6(cjVar.we(), SI, FH2, FH + cjVar.SI(aM), FH3, "");
                            this.j6.rN.DW(cjVar.we(), cjVar.nw(aM), cjVar.KD(aM), cjVar.nw(cjVar.sh(cjVar.sh(i))), cjVar.KD(cjVar.sh(cjVar.sh(i))), SI, FH2);
                        }
                    }
                }
                this.j6.rN.j6(cjVar.we(), cjVar.nw(aM), cjVar.KD(aM), cjVar.SI(aM), cjVar.ro(aM), "");
            }
        }
    }
}
