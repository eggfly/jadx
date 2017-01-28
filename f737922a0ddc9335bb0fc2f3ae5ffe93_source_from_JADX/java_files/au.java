import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.List;

public class au {
    private final by DW;
    private List<String> EQ;
    private final bw FH;
    private final cl Hw;
    private ea<bs> J0;
    private ea<co> J8;
    private List<Integer> VH;
    private ck Ws;
    private final ap Zo;
    private List<String> gn;
    private final ba j6;
    private List<String> tp;
    private dm<co> u7;
    private final bt v5;
    private String we;

    public au(ba baVar) {
        this.Ws = new ck();
        this.j6 = baVar;
        this.DW = baVar.ro;
        this.FH = baVar.cn;
        this.Hw = baVar.sh;
        this.v5 = baVar.cb;
        this.Zo = baVar.j6;
        this.J0 = new ea(this.v5);
        this.J8 = new ea(this.v5);
    }

    public void j6(bv bvVar, int i, int i2, int i3, co coVar) {
        this.j6.rN.DW();
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        int u7 = DW.u7(i, i2, i, i2);
        if (u7 != -1) {
            try {
                bz DW2 = this.v5.DW(bvVar, DW.tp(), DW.XL(u7));
                this.VH = new ArrayList();
                this.tp = new ArrayList();
                this.gn = new ArrayList();
                this.u7 = new dm(this.j6.cb);
                this.EQ = new ArrayList();
                this.VH.add(Integer.valueOf(-1));
                this.gn.add(coVar.eU());
                this.u7.FH(coVar);
                this.tp.add(this.DW.j6(i3));
                this.EQ.add("");
                int lp = DW2.lp();
                for (u7 = 0; u7 < lp; u7++) {
                    this.VH.add(Integer.valueOf(u7));
                    this.gn.add(DW2.v5(u7).eU());
                    this.u7.FH(DW2.v5(u7));
                    this.tp.add(this.DW.j6(DW2.Zo(u7)));
                    this.EQ.add("");
                }
                this.j6.rN.j6(bvVar, DW2.er(), DW2.gW(), this.VH, this.gn, this.tp, this.EQ);
                this.Hw.j6(DW);
                return;
            } catch (ej e) {
            }
        }
        this.Hw.j6(DW);
    }

    public List<au$a> j6(bv bvVar, int i, int i2) {
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        if (DW != null) {
            bz bzVar;
            int tp;
            ArrayList arrayList;
            int we;
            int EQ;
            int i3;
            bl Hw = DW.tp().Hw();
            int J0 = DW.J0(i, i2);
            if (J0 != -1) {
                DW.tp().u7().DW(DW, J0);
                switch (DW.J8(J0)) {
                    case 19:
                        bzVar = (bz) DW.QX(J0);
                        tp = Hw.tp(DW, J0);
                        if (!bzVar.tp().DW() || tp <= 0) {
                            this.Hw.j6(DW);
                            return null;
                        }
                        arrayList = new ArrayList();
                        we = Hw.we(DW, J0);
                        EQ = Hw.EQ(DW, J0);
                        arrayList.add(new au$a(this, false, false, DW.nw(EQ), DW.KD(EQ), DW.nw(Hw.j6(DW, J0, 0)), DW.KD(Hw.j6(DW, J0, 0))));
                        for (i3 = 0; i3 < tp; i3++) {
                            arrayList.add(new au$a(this, DW.FH(Hw.j6(DW, J0, i3), i, i2), true, DW.nw(Hw.j6(DW, J0, i3)), DW.KD(Hw.j6(DW, J0, i3)), DW.SI(Hw.j6(DW, J0, i3)), DW.ro(Hw.j6(DW, J0, i3))));
                            if (i3 < tp - 1) {
                                arrayList.add(new au$a(this, false, false, DW.SI(Hw.j6(DW, J0, i3)), DW.ro(Hw.j6(DW, J0, i3)), DW.nw(Hw.j6(DW, J0, i3 + 1)), DW.KD(Hw.j6(DW, J0, i3 + 1))));
                            }
                        }
                        arrayList.add(new au$a(this, false, false, DW.SI(Hw.j6(DW, J0, tp - 1)), DW.ro(Hw.j6(DW, J0, tp - 1)), DW.SI(we), DW.ro(we)));
                        this.Hw.j6(DW);
                        return arrayList;
                }
            }
            J0 = DW.we(i, i2);
            if (J0 != -1) {
                DW.tp().u7().DW(DW, J0);
                switch (DW.J8(J0)) {
                    case ProxyTextView.INPUTTYPE_date /*20*/:
                        bzVar = (bz) DW.QX(J0);
                        tp = Hw.J0(DW, J0);
                        if (!bzVar.tp().DW() || tp <= 0) {
                            this.Hw.j6(DW);
                            return null;
                        }
                        arrayList = new ArrayList();
                        we = Hw.Ws(DW, J0);
                        EQ = Hw.J8(DW, J0);
                        arrayList.add(new au$a(this, false, false, DW.nw(EQ), DW.KD(EQ), DW.nw(Hw.DW(DW, J0, 0)), DW.KD(Hw.DW(DW, J0, 0))));
                        for (i3 = 0; i3 < tp; i3++) {
                            arrayList.add(new au$a(this, DW.FH(Hw.DW(DW, J0, i3), i, i2), true, DW.nw(Hw.DW(DW, J0, i3)), DW.KD(Hw.DW(DW, J0, i3)), DW.SI(Hw.DW(DW, J0, i3)), DW.ro(Hw.DW(DW, J0, i3))));
                            if (i3 < tp - 1) {
                                arrayList.add(new au$a(this, false, false, DW.SI(Hw.DW(DW, J0, i3)), DW.ro(Hw.DW(DW, J0, i3)), DW.nw(Hw.DW(DW, J0, i3 + 1)), DW.KD(Hw.DW(DW, J0, i3 + 1))));
                            }
                        }
                        arrayList.add(new au$a(this, false, false, DW.SI(Hw.DW(DW, J0, tp - 1)), DW.ro(Hw.DW(DW, J0, tp - 1)), DW.SI(we), DW.ro(we)));
                        this.Hw.j6(DW);
                        return arrayList;
                }
            }
            this.Hw.j6(DW);
        }
        return null;
    }

    public void DW(bv bvVar, int i, int i2) {
        this.j6.rN.DW();
        try {
            bz FH = FH(bvVar, i, i2);
            if (FH.tp().DW()) {
                this.VH = new ArrayList();
                this.tp = new ArrayList();
                this.gn = new ArrayList();
                this.u7 = new dm(this.j6.cb);
                this.EQ = new ArrayList();
                int lp = FH.lp();
                for (int i3 = 0; i3 < lp; i3++) {
                    this.VH.add(Integer.valueOf(i3));
                    this.gn.add(FH.v5(i3).eU());
                    this.u7.FH(FH.v5(i3));
                    this.tp.add(this.DW.j6(FH.Zo(i3)));
                    this.EQ.add("");
                }
                this.j6.rN.j6(bvVar, i, i2, this.VH, this.gn, this.tp, this.EQ);
                return;
            }
            this.j6.rN.tp("This method is defined outside of the project.");
        } catch (ej e) {
            this.j6.rN.tp("Select a method.");
        }
    }

    public void j6(bv bvVar, int i, int i2, List<Integer> list, List<String> list2, List<String> list3, List<String> list4) {
        this.VH = list;
        this.tp = list3;
        this.u7 = new dm(this.j6.cb, list2.size());
        this.gn = list2;
        this.EQ = list4;
        this.j6.rN.DW();
        if (list2 != null) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                String str = (String) list2.get(i3);
                cj FH = this.j6.sh.FH(bvVar, i, i2);
                if (FH != null) {
                    try {
                        this.u7.j6(i3, FH.tp().u7().j6(FH, i, i2, str));
                    } catch (ej e) {
                    }
                    this.j6.sh.j6(FH);
                }
            }
        }
        try {
            bz FH2 = FH(bvVar, i, i2);
            int Hw = Hw(bvVar, i, i2);
            if (Hw < FH2.lp()) {
                while (Hw < FH2.lp()) {
                    if (!list.contains(Integer.valueOf(Hw))) {
                        list.add(Integer.valueOf(Hw));
                    }
                    Hw++;
                }
            }
            ea eaVar;
            if (FH2.sy()) {
                eaVar = new ea(this.v5);
                eaVar.j6((bs) FH2);
                j6(eaVar);
            } else {
                eaVar = j6(FH2);
                DW(eaVar);
                j6(eaVar);
            }
        } catch (ej e2) {
        }
        this.j6.rN.QX();
    }

    private bz FH(bv bvVar, int i, int i2) {
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            if (DW.J8(gn) == 19) {
                return (bz) DW.QX(gn);
            }
        }
        gn = DW.J0(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            switch (DW.J8(gn)) {
                case 19:
                    return (bz) DW.QX(gn);
            }
        }
        gn = DW.we(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            switch (DW.J8(gn)) {
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    return (bz) DW.QX(gn);
            }
        }
        throw new ej();
    }

    private int Hw(bv bvVar, int i, int i2) {
        bz bzVar;
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        bl Hw = DW.tp().Hw();
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            if (DW.J8(gn) == 19) {
                return ((bz) DW.QX(gn)).lp();
            }
        }
        int J0 = DW.J0(i, i2);
        if (J0 != -1) {
            DW.tp().u7().DW(DW, J0);
            switch (DW.J8(J0)) {
                case 19:
                    bzVar = (bz) DW.QX(J0);
                    J0 = Hw.tp(DW, J0);
                    if (bzVar.tp().DW() && J0 > 0) {
                        return J0;
                    }
            }
        }
        J0 = DW.we(i, i2);
        if (J0 != -1) {
            DW.tp().u7().DW(DW, J0);
            switch (DW.J8(J0)) {
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    bzVar = (bz) DW.QX(J0);
                    J0 = Hw.J0(DW, J0);
                    if (bzVar.tp().DW() && J0 > 0) {
                        return J0;
                    }
            }
        }
        throw new ej();
    }

    private void j6(ea<bz> eaVar) {
        ec ecVar = new ec();
        int aq = ((bz) eaVar.DW()).aq();
        ecVar.j6(aq);
        this.Zo.FH(ecVar);
        while (true) {
            bv FH = this.Zo.FH();
            if (FH != null) {
                this.we = "";
                this.J0.j6();
                for (cj cjVar : this.Hw.j6(FH)) {
                    if (((bz) eaVar.DW()).sy()) {
                        cjVar.tp().u7().DW(cjVar);
                    } else {
                        cjVar.tp().u7().j6(cjVar, ecVar);
                    }
                    j6(cjVar, cjVar.Ws(), aq, (ea) eaVar, true);
                    this.Hw.j6(cjVar);
                    if (this.we.length() > 0) {
                        int j3 = cjVar.j3();
                        int aM = cjVar.aM();
                        this.j6.rN.j6(FH, j3, aM, j3, aM, this.we);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void j6(cj cjVar, int i, int i2, ea<bz> eaVar, boolean z) {
        int lg;
        if (!cjVar.XX(i) || cjVar.er(i)) {
            if (!cjVar.br(i) || cjVar.er(i)) {
                if (cjVar.Qq(i)) {
                    this.Ws.j6();
                }
                for (lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
                    j6(cjVar, cjVar.Hw(i, lg), i2, (ea) eaVar, z);
                }
                return;
            }
            for (lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
                j6(cjVar, cjVar.Hw(i, lg), i2, (ea) eaVar, z);
            }
            if (DW(cjVar, i, (ea) eaVar)) {
                j6(cjVar, i);
            }
        } else if (j6(cjVar, i, (ea) eaVar)) {
            DW(cjVar, i);
            DW(cjVar, i, i2, eaVar, z);
        } else {
            for (lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
                j6(cjVar, cjVar.Hw(i, lg), i2, (ea) eaVar, z);
            }
        }
    }

    private boolean j6(cj cjVar, int i, ea<bz> eaVar) {
        switch (cjVar.J8(i)) {
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 22:
            case 23:
            case 24:
            case 25:
                bs bsVar = (bz) cjVar.QX(i);
                cjVar.tp().Hw();
                return eaVar.FH(bsVar);
            default:
                return false;
        }
    }

    private boolean DW(cj cjVar, int i, ea<bz> eaVar) {
        switch (cjVar.J8(i)) {
            case 19:
            case 21:
                return eaVar.FH((bz) cjVar.QX(i));
            default:
                return false;
        }
    }

    private void j6(cj cjVar, int i) {
        bl Hw = cjVar.tp().Hw();
        int we = Hw.we(cjVar, i);
        int EQ = Hw.EQ(cjVar, i);
        int tp = Hw.tp(cjVar, i);
        int nw = cjVar.nw(we);
        int KD = cjVar.KD(we);
        for (int size = this.VH.size() - 1; size >= 0; size--) {
            if (((Integer) this.VH.get(size)).intValue() != -1) {
                we = ((Integer) this.VH.get(size)).intValue();
                if (we < tp) {
                    int j6 = Hw.j6(cjVar, i, we);
                    this.j6.rN.DW(cjVar.we(), cjVar.nw(j6), cjVar.KD(j6), cjVar.SI(j6), cjVar.ro(j6), nw, KD);
                }
            } else {
                bs bsVar = (co) this.u7.j6(size);
                if (bsVar != null) {
                    int i2 = nw;
                    int i3 = KD;
                    this.j6.rN.j6(cjVar.we(), nw, KD, i2, i3, cjVar.tp().v5().j6(cjVar.tp().v5().j6(cjVar, nw, KD, (co) bsVar), (String) this.tp.get(size)));
                    this.J8.j6();
                    this.J8.j6(bsVar);
                    this.we += cjVar.tp().v5().j6(cjVar, nw, KD, this.J8, this.J0);
                } else {
                    this.j6.rN.j6(cjVar.we(), nw, KD, nw, KD, cjVar.tp().v5().j6((String) this.gn.get(size), (String) this.tp.get(size)));
                }
            }
            if (size > 0) {
                String str = ",";
                if (ek.j6 && cjVar.nw(i) != cjVar.SI(i)) {
                    str = ",\n";
                }
                this.j6.rN.j6(cjVar.we(), nw, KD, nw, KD, str);
            }
        }
        this.j6.rN.j6(cjVar.we(), cjVar.SI(EQ), cjVar.ro(EQ), nw, KD, "");
        if (!ek.j6 || cjVar.nw(i) == cjVar.SI(i)) {
            this.j6.rN.DW(cjVar.we(), cjVar.nw(i), cjVar.nw(i));
        } else {
            this.j6.rN.DW(cjVar.we(), cjVar.nw(i), cjVar.nw(i) + this.VH.size());
        }
    }

    private void DW(cj cjVar, int i) {
        int i2;
        int lg = cjVar.lg(i);
        for (i2 = lg - 1; i2 >= 0; i2--) {
            DW(cjVar, cjVar.Hw(i, i2));
        }
        if (cjVar.XX(i)) {
            for (i2 = lg - 1; i2 >= 0; i2--) {
                this.Ws.j6(cjVar, cjVar.Hw(i, i2));
            }
        }
    }

    private void DW(cj cjVar, int i, int i2, ea<bz> eaVar, boolean z) {
        int i3;
        int i4;
        bl Hw = cjVar.tp().Hw();
        int Ws = Hw.Ws(cjVar, i);
        int J8 = Hw.J8(cjVar, i);
        int J0 = Hw.J0(cjVar, i);
        if (J0 == 0) {
            i3 = Ws;
            i4 = J8;
        } else {
            int DW = Hw.DW(cjVar, i, J0 - 1);
            i3 = Hw.DW(cjVar, i, 0);
            i4 = DW;
        }
        int intValue;
        String str;
        String str2;
        if (!ek.j6 || cjVar.nw(i) == cjVar.SI(i)) {
            this.j6.rN.j6(cjVar.we(), this.Ws.Hw(cjVar, i4), this.Ws.v5(cjVar, i4), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), "");
            this.Ws.j6(this.Ws.Hw(cjVar, i4), this.Ws.v5(cjVar, i4), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws));
            for (i3 = 0; i3 < this.VH.size(); i3++) {
                if (((Integer) this.VH.get(i3)).intValue() != -1) {
                    intValue = ((Integer) this.VH.get(i3)).intValue();
                    if (intValue < J0) {
                        if (i3 > 0) {
                            str = ", ";
                            this.j6.rN.j6(cjVar.we(), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), str);
                            this.Ws.DW(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), str.length());
                        }
                        int DW2 = Hw.DW(cjVar, i, intValue);
                        j6(cjVar, DW2, i2, (ea) eaVar, false);
                        this.j6.rN.DW(cjVar.we(), this.Ws.DW(cjVar, DW2), this.Ws.FH(cjVar, DW2), this.Ws.Hw(cjVar, DW2), this.Ws.v5(cjVar, DW2), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws));
                        this.Ws.j6(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, DW2), this.Ws.FH(cjVar, DW2), this.Ws.Hw(cjVar, DW2), this.Ws.v5(cjVar, DW2));
                    }
                } else {
                    if (i3 > 0) {
                        str = ", ";
                        this.j6.rN.j6(cjVar.we(), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), str);
                        this.Ws.DW(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), str.length());
                    }
                    str2 = (String) this.EQ.get(i3);
                    if (str2.length() == 0) {
                        str = j6(cjVar, (co) this.u7.j6(i3));
                    } else {
                        str = str2;
                    }
                    this.j6.rN.j6(cjVar.we(), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), str);
                    this.Ws.DW(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), str.length());
                }
            }
            this.j6.rN.j6(cjVar.we(), this.Ws.Hw(cjVar, J8), this.Ws.v5(cjVar, J8), this.Ws.Hw(cjVar, i4), this.Ws.v5(cjVar, i4), "");
            this.Ws.j6(this.Ws.Hw(cjVar, J8), this.Ws.v5(cjVar, J8), this.Ws.Hw(cjVar, i4), this.Ws.v5(cjVar, i4));
            if (z) {
                this.j6.rN.DW(cjVar.we(), cjVar.nw(i), cjVar.nw(i));
                return;
            }
            return;
        }
        for (int i5 = 0; i5 < this.VH.size(); i5++) {
            if (((Integer) this.VH.get(i5)).intValue() != -1) {
                intValue = ((Integer) this.VH.get(i5)).intValue();
                if (intValue < J0) {
                    if (i5 > 0) {
                        this.j6.rN.j6(cjVar.we(), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), ",\n");
                        this.Ws.DW(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), 1);
                        this.Ws.j6(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws));
                    }
                    DW2 = Hw.DW(cjVar, i, intValue);
                    j6(cjVar, DW2, i2, (ea) eaVar, false);
                    this.j6.rN.DW(cjVar.we(), this.Ws.DW(cjVar, DW2), this.Ws.FH(cjVar, DW2), this.Ws.Hw(cjVar, DW2), this.Ws.v5(cjVar, DW2), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws));
                    this.Ws.j6(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, DW2), this.Ws.FH(cjVar, DW2), this.Ws.Hw(cjVar, DW2), this.Ws.v5(cjVar, DW2));
                }
            } else {
                if (i5 > 0) {
                    this.j6.rN.j6(cjVar.we(), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), ",\n");
                    this.Ws.DW(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), 1);
                    this.Ws.j6(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws));
                }
                str2 = (String) this.EQ.get(i5);
                if (str2.length() == 0) {
                    str = j6(cjVar, (co) this.u7.j6(i5));
                } else {
                    str = str2;
                }
                this.j6.rN.j6(cjVar.we(), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), str);
                this.Ws.DW(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), str.length());
            }
        }
        if (cjVar.SI(J8) != cjVar.nw(i3)) {
            this.j6.rN.j6(cjVar.we(), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws), "\n");
            this.Ws.j6(this.Ws.DW(cjVar, Ws), this.Ws.FH(cjVar, Ws));
        }
        this.j6.rN.j6(cjVar.we(), this.Ws.Hw(cjVar, J8), this.Ws.v5(cjVar, J8), this.Ws.Hw(cjVar, i4), this.Ws.v5(cjVar, i4), "");
        this.Ws.j6(this.Ws.Hw(cjVar, J8), this.Ws.v5(cjVar, J8), this.Ws.Hw(cjVar, i4), this.Ws.v5(cjVar, i4));
        if (z) {
            this.j6.rN.DW(cjVar.we(), cjVar.nw(i), this.Ws.DW(cjVar, Ws));
        }
    }

    private String j6(cj cjVar, co coVar) {
        return cjVar.tp().gn().j6(coVar);
    }

    private ea<bz> j6(bz bzVar) {
        ea j6 = j6(bzVar.aq(), bzVar.lp());
        ea eaVar = new ea(this.v5);
        eaVar.j6((bs) bzVar);
        ea eaVar2 = new ea(this.v5);
        while (true) {
            eaVar.j6.j6();
            while (eaVar.j6.DW()) {
                bs bsVar = (bz) eaVar.j6.FH();
                eaVar2.j6(bsVar);
                eaVar2.j6(bsVar.cb());
                j6.j6.j6();
                while (j6.j6.DW()) {
                    bs bsVar2 = (bz) j6.j6.FH();
                    if (bsVar2.ef().FH(bsVar)) {
                        eaVar2.j6(bsVar2);
                    }
                }
            }
            if (eaVar.Hw() == eaVar2.Hw()) {
                return eaVar2;
            }
            eaVar.j6();
            eaVar.j6(eaVar2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ea<bz> j6(int r8, int r9) {
        /*
        r7 = this;
        r5 = new ea;
        r0 = r7.v5;
        r5.<init>(r0);
        r0 = r7.Zo;
        r0.j6(r8);
    L_0x000c:
        r0 = r7.Zo;
        r0 = r0.DW();
        if (r0 == 0) goto L_0x001e;
    L_0x0014:
        r1 = r7.j6;
        r1 = r1.P8;
        r1 = r1.FH();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r5;
    L_0x001f:
        r1 = r7.Hw;
        r0 = r1.j6(r0);
        r6 = r0.iterator();
    L_0x0029:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x000c;
    L_0x002f:
        r1 = r6.next();
        r1 = (cj) r1;
        r2 = r1.Ws();
        r0 = r7;
        r3 = r8;
        r4 = r9;
        r0.j6(r1, r2, r3, r4, r5);
        r0 = r7.Hw;
        r0.j6(r1);
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: au.j6(int, int):ea<bz>");
    }

    private void j6(cj cjVar, int i, int i2, int i3, ea<bz> eaVar) {
        int lg = cjVar.lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            j6(cjVar, cjVar.Hw(i, i4), i2, i3, (ea) eaVar);
        }
        if (cjVar.ca(i)) {
            try {
                bs DW = this.v5.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                if (!DW.sy() && this.DW.FH(DW.aq()) == this.DW.FH(i2) && DW.lp() == i3) {
                    eaVar.j6(DW);
                }
            } catch (ej e) {
            }
        }
    }

    private void DW(ea<bz> eaVar) {
        eaVar.j6.j6();
        while (eaVar.j6.DW()) {
            bz bzVar = (bz) eaVar.j6.FH();
            if (!bzVar.tp().DW()) {
                j6("There is an overridden method, which is defined outside the project.", bzVar.tp(), bzVar.er(), bzVar.gW());
            }
            dr lp = bzVar.Xa().lp();
            lp.j6.j6(((bz) eaVar.DW()).aq());
            while (lp.j6.DW()) {
                bs bsVar = (bz) lp.j6.Hw();
                if (!eaVar.FH(bsVar) && bsVar.lp() == this.VH.size()) {
                    j6("There already is a method with that name.", bsVar.tp(), bsVar.er(), bsVar.gW());
                }
            }
        }
    }

    private void j6(String str, bv bvVar, int i, int i2) {
        this.j6.rN.j6(bvVar.er() + ":" + i + ":" + i2 + "\n    " + str);
    }
}
