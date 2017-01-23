import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class al {
    private final cc j6;

    public al(cc ccVar) {
        this.j6 = ccVar;
    }

    public void j6(bv bvVar, int i, int i2, int i3) {
        bj bjVar;
        int i4;
        int i5 = 0;
        this.j6.rN.DW();
        List<cj> DW = this.j6.sh.DW(bvVar);
        ck ckVar = new ck();
        cj j6 = j6(DW, i, i2 - 1);
        if (j6 == null || j6.tp().v5() == null) {
            bjVar = null;
            i4 = 0;
        } else {
            bj tp = j6.tp();
            int[] FH = j6.tp().v5().FH(j6, ckVar, i, i2);
            if (FH == null || FH.length != 2) {
                bjVar = tp;
                i4 = 0;
            } else {
                i4 = FH[0];
                i5 = FH[1];
                bjVar = tp;
            }
        }
        if (i4 > 0) {
            dj djVar = new dj();
            for (cj cjVar : DW) {
                if (cjVar.tp().v5() != null) {
                    dj j62 = cjVar.tp().v5().j6(cjVar, ckVar, i4, i5, i3);
                    if (j62 != null) {
                        j62.j6.j6();
                        while (j62.j6.DW()) {
                            int FH2 = j62.j6.FH();
                            bm$a bm_a = (bm$a) j62.j6.Hw();
                            if (djVar.j6(FH2)) {
                                djVar.j6(FH2, ((bm$a) djVar.FH(FH2)).j6(bm_a, bjVar));
                            } else {
                                djVar.j6(FH2, bm_a);
                            }
                        }
                    }
                }
            }
            j6(bvVar, djVar, i4, i5, i3);
        }
        this.j6.rN.VH();
    }

    public void DW(bv bvVar, int i, int i2, int i3) {
        bj bjVar;
        this.j6.rN.DW();
        List j6;
        if (bvVar.DW(i + 1).trim().length() == 0) {
            j6 = this.j6.sh.j6(bvVar, i + 1, 1, "i;");
        } else {
            j6 = this.j6.sh.DW(bvVar);
        }
        ck ckVar = new ck();
        ckVar.j6(-1, i + 1, 1, i + 1, 2);
        for (cj cjVar : r6) {
            if (cjVar.tp().v5() != null) {
                ckVar.j6(cjVar);
            }
        }
        cj j62 = j6(r6, i, i2 - 1);
        if (j62 == null || j62.tp().v5() == null) {
            bjVar = null;
        } else {
            bj tp = j62.tp();
            j62.tp().v5().DW(j62, ckVar, i, i2);
            bjVar = tp;
        }
        int i4 = i + 1;
        int j63 = ckVar.j6(-1);
        dj djVar = new dj();
        for (cj cjVar2 : r6) {
            if (cjVar2.tp().v5() != null) {
                dj DW = cjVar2.tp().v5().DW(cjVar2, ckVar, i4, j63, i3);
                if (DW != null) {
                    DW.j6.j6();
                    while (DW.j6.DW()) {
                        int FH = DW.j6.FH();
                        bm$a bm_a = (bm$a) DW.j6.Hw();
                        if (djVar.j6(FH)) {
                            djVar.j6(FH, ((bm$a) djVar.FH(FH)).j6(bm_a, bjVar));
                        } else {
                            djVar.j6(FH, bm_a);
                        }
                    }
                }
            }
        }
        j6(bvVar, djVar, i4, j63, i3);
        this.j6.rN.VH();
    }

    private cj j6(List<cj> list, int i, int i2) {
        cj cjVar;
        cj cjVar2 = null;
        int i3 = Integer.MAX_VALUE;
        cj cjVar3 = null;
        for (cj cjVar4 : list) {
            cj cjVar5;
            if (cjVar3 == null) {
                cjVar5 = cjVar4;
            } else {
                cjVar5 = cjVar3;
            }
            int v5 = cjVar4.v5(i, i2);
            if (v5 == 0) {
                cjVar2 = cjVar4;
                cjVar4 = cjVar5;
                break;
            }
            int i4;
            if (v5 < i3) {
                i4 = v5;
            } else {
                cjVar4 = cjVar2;
                i4 = i3;
            }
            cjVar3 = cjVar5;
            i3 = i4;
            cjVar2 = cjVar4;
        }
        cjVar4 = cjVar3;
        if (cjVar2 == null) {
            return cjVar4;
        }
        return cjVar2;
    }

    public void j6(bv bvVar, int i) {
        for (cj cjVar : this.j6.sh.DW(bvVar)) {
            if (cjVar.tp().v5() != null) {
                Collection j6 = cjVar.tp().v5().j6(cjVar, i);
                if (j6 != null) {
                    this.j6.rN.j6(cjVar.tp(), new HashSet(j6));
                }
            }
        }
    }

    public void FH(bv bvVar, int i, int i2, int i3) {
        this.j6.rN.DW();
        Zo(bvVar, i, i2, i3);
        this.j6.rN.FH();
    }

    public void Hw(bv bvVar, int i, int i2, int i3) {
        this.j6.rN.DW();
        Zo(bvVar, i, i2, i3);
        this.j6.rN.VH();
    }

    private void Zo(bv bvVar, int i, int i2, int i3) {
        dj djVar = new dj();
        List<cj> DW = this.j6.sh.DW(bvVar);
        ck ckVar = new ck();
        ckVar.j6(-1, i, 1, i, 1);
        ckVar.j6(-2, i2, 1, i2, 1);
        for (cj cjVar : DW) {
            if (cjVar.tp().v5() != null) {
                ckVar.j6(cjVar);
            }
        }
        for (cj cjVar2 : DW) {
            if (cjVar2.tp().v5() != null) {
                cjVar2.tp().v5().j6(cjVar2, ckVar, i, i2);
            }
        }
        int j6 = ckVar.j6(-2);
        for (cj cjVar3 : DW) {
            if (cjVar3.tp().v5() != null) {
                dj j62 = cjVar3.tp().v5().j6(cjVar3, ckVar, i, j6, i3);
                if (j62 != null) {
                    j62.j6.j6();
                    while (j62.j6.DW()) {
                        int FH = j62.j6.FH();
                        bm$a bm_a = (bm$a) j62.j6.Hw();
                        if (djVar.j6(FH)) {
                            djVar.j6(FH, ((bm$a) djVar.FH(FH)).j6(bm_a, null));
                        } else {
                            djVar.j6(FH, bm_a);
                        }
                    }
                }
            }
        }
        j6(bvVar, djVar, i, j6, i3);
    }

    public void v5(bv bvVar, int i, int i2, int i3) {
        this.j6.rN.DW();
        dj djVar = new dj();
        ck ckVar = new ck();
        for (cj cjVar : this.j6.sh.DW(bvVar)) {
            if (cjVar.tp().v5() != null) {
                dj FH = cjVar.tp().v5().FH(cjVar, ckVar, i, i2, i3);
                if (FH != null) {
                    FH.j6.j6();
                    while (FH.j6.DW()) {
                        int FH2 = FH.j6.FH();
                        bm$a bm_a = (bm$a) FH.j6.Hw();
                        if (djVar.j6(FH2)) {
                            djVar.j6(FH2, ((bm$a) djVar.FH(FH2)).j6(bm_a, null));
                        } else {
                            djVar.j6(FH2, bm_a);
                        }
                    }
                }
            }
        }
        j6(bvVar, djVar, i, i2, i3);
        this.j6.rN.VH();
    }

    private void j6(bv bvVar, dj<bm$a> djVar, int i, int i2, int i3) {
        djVar.j6.j6();
        while (djVar.j6.DW()) {
            int FH = djVar.j6.FH();
            if (FH >= i && FH <= i2) {
                bm$a bm_a = (bm$a) djVar.j6.Hw();
                if (!(bm_a.j6 < 0 || bm_a.FH || bm_a.DW)) {
                    this.j6.rN.j6(bvVar, FH, bm_a.j6, i3);
                }
            }
        }
    }
}
