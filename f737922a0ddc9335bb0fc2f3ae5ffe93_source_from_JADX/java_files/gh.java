import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gh {
    private final gv DW;
    private de FH;
    private final cc j6;

    public gh(cc ccVar, gv gvVar) {
        this.j6 = ccVar;
        this.DW = gvVar;
    }

    public void j6(de deVar, bv bvVar, int i, int i2, String str, List<String> list) {
        this.FH = deVar;
        deVar.j6();
        if (str.equals("SELECT")) {
            for (String j6 : list) {
                String j62;
                deVar.j6(j62);
            }
        }
        if (str.equals("SELECT_VARIABLE")) {
            j6(bvVar, i, i2, (List) list);
        }
        if (str.equals("SUGGEST_NAME")) {
            DW(bvVar, i, i2, j6(new String[]{"v", "f", "t"}));
        }
        if (str.equals("SUGGEST_TYPE")) {
            j6(bvVar, i, i2);
        }
        if (str.equals("SUGGEST_ELEMENT_NAME")) {
            if (list.size() == 1) {
                j62 = (String) list.get(0);
                if (j62.endsWith("s")) {
                    j62 = j62.substring(0, j62.length() - 1);
                    DW(bvVar, i, i2, j6(new String[]{j62}));
                }
            }
            DW(bvVar, i, i2, j6(new String[]{"e", "m", "a"}));
        }
        if (str.equals("SUGGEST_INDEX_NAME")) {
            DW(bvVar, i, i2, j6(new String[]{"i", "j", "k", "n", "z", "l"}));
        }
        if (str.equals("SUGGEST_EXCEPTION_NAME")) {
            DW(bvVar, i, i2, j6(new String[]{"e", "ex", "e2", "e3", "e4"}));
        }
        if (str.equals("GET_ELEMENT_TYPE") && list.size() == 1) {
            try {
                deVar.j6(j6(bvVar, i, i2, (String) list.get(0)));
            } catch (ej e) {
            }
        }
        deVar.DW();
    }

    private List<String> j6(String[] strArr) {
        List arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void j6(bv bvVar, int i, int i2) {
        cj DW = this.j6.sh.DW(bvVar, this.DW);
        int Ws = DW.Ws(i, i2);
        int Hw;
        int Hw2;
        if (Ws != -1 && DW.rN(Ws) == 172 && DW.rN(DW.Hw(Ws, 1)) == 17) {
            ((gb) DW.tp().u7()).DW(DW, Ws);
            Hw = DW.Hw(Ws, 0);
            Hw2 = DW.Hw(Ws, 1);
            Ws = DW.Hw(Ws, 2);
            if (DW.J0(Hw)) {
                j6(DW.we(Hw));
                this.j6.lg.j6(bvVar, i, i2, new int[]{DW.SI(Hw2), DW.SI(Ws)}, new int[]{DW.ro(Hw2) - 1, DW.ro(Ws)});
                this.j6.sh.j6(DW);
                return;
            }
            this.j6.lg.DW(bvVar, i, i2);
            this.j6.sh.j6(DW);
            return;
        }
        Ws = DW.j6(200, i, i2, i, i2);
        if (Ws == -1 || DW.lg(Ws) != 4) {
            this.j6.lg.DW(bvVar, i, i2);
            this.j6.sh.j6(DW);
            return;
        }
        ((gb) DW.tp().u7()).DW(DW, Ws);
        Hw = DW.Hw(Ws, 0);
        Hw2 = DW.Hw(Ws, 2);
        Ws = DW.Hw(Ws, 3);
        if (DW.J0(Hw)) {
            j6(DW.we(Hw));
            this.j6.lg.j6(bvVar, i, i2, new int[]{DW.nw(Hw2), DW.SI(Ws)}, new int[]{DW.KD(Hw2), DW.ro(Ws)});
            this.j6.sh.j6(DW);
            return;
        }
        this.j6.lg.DW(bvVar, i, i2);
        this.j6.sh.j6(DW);
    }

    private void j6(co coVar) {
        this.FH.j6((bs) coVar);
    }

    private co j6(bv bvVar, int i, int i2, String str) {
        co v5 = this.j6.cb.v5(bvVar, this.DW);
        cj j6 = this.j6.sh.j6(bvVar, this.DW, i, i2, str);
        int J8 = j6.J8(i, i2);
        if (J8 != -1) {
            j6.tp().u7().DW(j6, J8);
            if (j6.J0(J8)) {
                co we = j6.we(J8);
                if (we.AL()) {
                    return ((bo) we).FH();
                }
                if (we.n5()) {
                    return ((cf) we).DW()[0];
                }
                if (we.cT()) {
                    dr sh = ((bp) we).sh();
                    sh.j6.j6(this.j6.ro.j6("get"));
                    while (sh.j6.DW()) {
                        try {
                            return ((bz) sh.j6.Hw()).Mz();
                        } catch (ej e) {
                        }
                    }
                }
            }
        }
        return v5;
    }

    private void j6(bv bvVar, int i, int i2, List<String> list) {
        cj DW = this.j6.sh.DW(bvVar, this.DW);
        for (cp j6 : j6(DW, i, i2, (List) list)) {
            this.FH.j6(j6);
        }
        dm DW2 = DW(DW, i, i2, (List) list);
        for (int i3 = 0; i3 < DW2.Hw(); i3++) {
            this.FH.j6(DW2.j6(i3));
        }
        this.j6.sh.j6(DW);
    }

    private void DW(bv bvVar, int i, int i2, List<String> list) {
        List<cp> j6 = j6(this.j6.sh.DW(bvVar, this.DW, i, i2, "i;"), i, i2, Collections.EMPTY_LIST);
        for (String str : list) {
            for (cp VH : j6) {
                if (VH.VH() == this.j6.ro.j6(str)) {
                    break;
                }
            }
            this.FH.j6(str);
        }
    }

    private List<cp> j6(cj cjVar, int i, int i2, List<String> list) {
        List arrayList = new ArrayList();
        int Zo = cjVar.Zo(i, i2, i, i2);
        int FH = cjVar.FH(i, i2, i, i2);
        if (FH != -1) {
            Zo = FH;
        }
        if (Zo != -1) {
            ((gb) cjVar.tp().u7()).DW(cjVar, Zo);
        } else {
            ((gb) cjVar.tp().u7()).j6(cjVar);
        }
        ec ecVar = new ec();
        int i3 = Zo;
        while (i3 != -1) {
            int i4;
            int Hw;
            int i5;
            int Hw2;
            int gW;
            co we;
            if (cjVar.rN(i3) == 133) {
                FH = cjVar.lg(i3) - 1;
                while (FH >= 0 && cjVar.Hw(i3, FH) != r6) {
                    FH--;
                }
                for (i4 = FH - 1; i4 >= 0; i4--) {
                    Hw = cjVar.Hw(i3, i4);
                    if (cjVar.rN(Hw) == 151) {
                        int lg = cjVar.lg(Hw);
                        for (i5 = 3; i5 < lg; i5 += 2) {
                            Hw2 = cjVar.Hw(cjVar.Hw(Hw, i5), 0);
                            gW = cjVar.gW(Hw2);
                            if (!ecVar.FH(gW) && cjVar.J0(Hw2) && (cjVar.nw(Hw2) != i || cjVar.KD(Hw2) > i2 || cjVar.ro(Hw2) < i2)) {
                                we = cjVar.we(Hw2);
                                if (j6(we, list)) {
                                    arrayList.add(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.ro(Hw2), gW, we));
                                }
                            }
                        }
                    }
                }
            } else if (cjVar.rN(i3) == 124) {
                i4 = cjVar.Hw(i3, 5);
                Hw = cjVar.lg(i4);
                for (i5 = 1; i5 < Hw - 1; i5 += 2) {
                    FH = cjVar.Hw(i4, i5);
                    if (cjVar.rN(FH) != 16) {
                        Hw2 = cjVar.Hw(FH, 3);
                        gW = cjVar.gW(Hw2);
                        if (!ecVar.FH(gW) && cjVar.J0(Hw2)) {
                            we = cjVar.we(Hw2);
                            if (j6(we, list)) {
                                arrayList.add(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.ro(Hw2), gW, we));
                            }
                        }
                    }
                }
            } else if (cjVar.rN(i3) == 123) {
                i4 = cjVar.Hw(i3, 3);
                Hw = cjVar.lg(i4);
                for (i5 = 1; i5 < Hw - 1; i5 += 2) {
                    FH = cjVar.Hw(i4, i5);
                    Hw2 = cjVar.Hw(FH, 3);
                    if (cjVar.rN(FH) != 16) {
                        gW = cjVar.gW(Hw2);
                        if (!ecVar.FH(gW) && cjVar.J0(Hw2)) {
                            we = cjVar.we(Hw2);
                            if (j6(we, list)) {
                                arrayList.add(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.ro(Hw2), gW, we));
                            }
                        }
                    }
                }
            } else if (cjVar.rN(i3) == 204 && cjVar.lg(i3) == 7) {
                Hw2 = cjVar.Hw(i3, 4);
                gW = cjVar.gW(Hw2);
                if (!ecVar.FH(gW) && cjVar.J0(Hw2)) {
                    we = cjVar.we(Hw2);
                    if (j6(we, list)) {
                        arrayList.add(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.ro(Hw2), gW, we));
                    }
                }
            } else if (cjVar.rN(i3) == 211) {
                Hw2 = cjVar.Hw(i3, 5);
                gW = cjVar.gW(Hw2);
                if (!ecVar.FH(gW) && cjVar.J0(Hw2)) {
                    we = cjVar.we(Hw2);
                    if (j6(we, list)) {
                        arrayList.add(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.ro(Hw2), gW, we));
                    }
                }
            } else if (cjVar.rN(i3) == 149) {
                i4 = cjVar.Hw(cjVar.Hw(i3, 2), 0);
                if (cjVar.rN(i4) == 151) {
                    Hw = cjVar.lg(i4);
                    for (i5 = 3; i5 < Hw; i5 += 2) {
                        Hw2 = cjVar.Hw(cjVar.Hw(i4, i5), 0);
                        gW = cjVar.gW(Hw2);
                        if (!ecVar.FH(gW) && cjVar.J0(Hw2)) {
                            we = cjVar.we(Hw2);
                            if (j6(we, list)) {
                                arrayList.add(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.ro(Hw2), gW, we));
                            }
                        }
                    }
                }
            }
            Zo = cjVar.aM(i3);
            int i6;
            if (Zo == cjVar.Ws()) {
                i6 = i3;
                i3 = -1;
                Zo = i6;
            } else {
                i6 = i3;
                i3 = Zo;
                Zo = i6;
            }
        }
        return arrayList;
    }

    private dm<bz> DW(cj cjVar, int i, int i2, List<String> list) {
        dm<bz> dmVar = new dm(this.j6.cb);
        int Zo = cjVar.Zo(i, i2, i, i2);
        int FH = cjVar.FH(i, i2, i, i2);
        if (FH != -1) {
            Zo = FH;
        }
        if (Zo != -1) {
            ((gb) cjVar.tp().u7()).DW(cjVar, Zo);
        } else {
            ((gb) cjVar.tp().u7()).j6(cjVar);
        }
        ec ecVar = new ec();
        while (Zo != -1) {
            if (cjVar.rN(Zo) == 122) {
                try {
                    dr sy = this.j6.cb.j6(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.aM(Zo))).sy();
                    sy.j6.j6();
                    while (sy.j6.DW()) {
                        if (!ecVar.FH(sy.j6.FH())) {
                            bz bzVar = (bz) sy.j6.Hw();
                            if ((bzVar.tp() != cjVar.we() || bzVar.er() != i || bzVar.gW() > i2 || bzVar.yS() < i2) && bzVar.tp().DW() && j6(bzVar.Mz(), list)) {
                                dmVar.FH(bzVar);
                            }
                            ecVar.j6(sy.j6.FH());
                        }
                    }
                } catch (ej e) {
                }
            }
            FH = cjVar.aM(Zo);
            if (FH == cjVar.Ws()) {
                Zo = -1;
            } else {
                Zo = FH;
            }
        }
        return dmVar;
    }

    private boolean j6(co coVar, List<String> list) {
        if (list.size() < 1) {
            return true;
        }
        for (String str : list) {
            if (str.equals("[]") && coVar.AL()) {
                return true;
            }
            try {
                if (coVar.a_().iW().equals(str)) {
                    return true;
                }
            } catch (ej e) {
            }
        }
        return false;
    }
}
