import com.aide.uidesigner.ProxyTextView;
import java.util.List;
import java.util.Set;

public class hb implements bm {
    private final gc DW;
    private final ge FH;
    private final gh Hw;
    private final gu VH;
    private final gd Zo;
    private final gv gn;
    private final cc j6;
    private final ga u7;
    private final gw v5;

    public hb(cc ccVar, gv gvVar) {
        this.j6 = ccVar;
        this.gn = gvVar;
        this.v5 = new gw(ccVar, gvVar);
        this.Zo = new gd(ccVar, gvVar);
        this.VH = new gu(ccVar, gvVar);
        this.DW = new gc(ccVar, gvVar);
        this.FH = new ge(ccVar, gvVar);
        this.Hw = new gh(ccVar, gvVar);
        this.u7 = new ga(ccVar, gvVar, gvVar.we());
    }

    public boolean j6(String str) {
        return true;
    }

    public void j6(bv bvVar, String str) {
        this.u7.j6(bvVar, str);
    }

    public void j6(bv bvVar, int i, int i2) {
        List lg = bvVar.lg();
        for (int i3 = i; i3 <= Math.min(lg.size() - 1, i2); i3++) {
            String str = (String) lg.get(i3);
            if (str.trim().startsWith("//")) {
                int indexOf = str.indexOf("//") + 1;
                this.j6.rN.j6(bvVar, i3, indexOf, i3, indexOf + 2, "");
            }
        }
    }

    public void DW(bv bvVar, int i, int i2) {
        for (int i3 = i; i3 <= i2; i3++) {
            this.j6.rN.j6(bvVar, i3, 1, i3, 1, "//");
        }
    }

    public boolean j6(bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        return this.VH.j6(bzVar, doVar, doVar2, doVar3, doVar4, doVar5);
    }

    public void j6(bv bvVar, bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        this.VH.j6(bvVar, bzVar, doVar, doVar2, doVar3, doVar4, doVar5);
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4) {
        this.v5.DW(bvVar, i, i2, i3, i4);
    }

    public void VH(bv bvVar, int i, int i2) {
        this.v5.j6(bvVar, i, i2, i, i2);
    }

    public void j6(bv bvVar, int i, int i2, int i3, co coVar) {
        this.Zo.j6(bvVar, i, i2, i3, coVar);
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, co coVar) {
        this.Zo.j6(bvVar, i, i2, i3, i4, coVar);
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, co coVar, int[] iArr, co[] coVarArr, int[] iArr2) {
        this.Zo.j6(bvVar, i, i2, i3, i4, coVar, iArr, coVarArr, iArr2);
    }

    public void Zo(bv bvVar, int i, int i2) {
        this.Zo.DW(bvVar, i, i2);
    }

    public void j6(bv bvVar) {
        this.Zo.j6(bvVar);
    }

    public void gn(bv bvVar, int i, int i2) {
        this.v5.j6(bvVar, i, i2);
    }

    public void DW(bv bvVar, int i, int i2, int i3, int i4) {
        this.Zo.DW(bvVar, i, i2, i3, i4);
    }

    public void FH(bv bvVar, int i, int i2, int i3, int i4) {
        this.Zo.j6(bvVar, i, i2, i3, i4);
    }

    public void Hw(bv bvVar, int i, int i2, int i3, int i4) {
        this.v5.FH(bvVar, i, i2, i3, i4);
    }

    public void u7(bv bvVar, int i, int i2) {
        this.Zo.j6(bvVar, i, i2);
    }

    public void j6(bv bvVar, int i, int i2, bz bzVar) {
        this.Zo.j6(bvVar, i, i2, bzVar);
    }

    public void v5(bv bvVar, int i, int i2, int i3, int i4) {
        this.v5.Hw(bvVar, i, i2, i3, i4);
    }

    public void j6(bv bvVar, bv bvVar2, int i, int i2, int i3, int i4) {
    }

    public void j6(de deVar, bv bvVar, int i, int i2, String str, List<String> list) {
        this.Hw.j6(deVar, bvVar, i, i2, str, list);
    }

    public void j6(cj cjVar, int i, int i2) {
        int EQ = cjVar.EQ(i, i2 - 1);
        if (EQ != -1) {
            switch (cjVar.rN(EQ)) {
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    EQ = cjVar.aM(EQ);
                    switch (cjVar.rN(EQ)) {
                        case 122:
                        case 133:
                        case 190:
                        case 197:
                            DW(cjVar, cjVar.Hw(EQ, 0), cjVar.Hw(EQ, cjVar.lg(EQ) - 1));
                            return;
                        case 135:
                        case 136:
                        case 137:
                        case 140:
                            DW(cjVar, cjVar.Hw(EQ, 1), cjVar.Hw(EQ, 3));
                            return;
                        case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                            DW(cjVar, cjVar.Hw(EQ, 3), cjVar.Hw(EQ, 5));
                            return;
                        case 149:
                            DW(cjVar, cjVar.Hw(EQ, 1), cjVar.Hw(EQ, 5));
                            return;
                        case 168:
                            DW(cjVar, cjVar.Hw(EQ, 0), cjVar.Hw(EQ, 2));
                            return;
                        case 169:
                            DW(cjVar, cjVar.Hw(EQ, 0), cjVar.Hw(EQ, 3));
                            return;
                        case 211:
                            DW(cjVar, cjVar.Hw(EQ, 1), cjVar.Hw(EQ, 9));
                            return;
                        default:
                            break;
                    }
                case 54:
                case 55:
                case 63:
                case 80:
                    EQ = cjVar.aM(EQ);
                    switch (cjVar.rN(EQ)) {
                        case 136:
                            DW(cjVar, cjVar.Hw(EQ, 0), cjVar.Hw(EQ, 5));
                            return;
                        case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                            DW(cjVar, cjVar.Hw(EQ, 0), cjVar.Hw(EQ, 2));
                            return;
                        default:
                            break;
                    }
            }
        }
        this.j6.vy.j6(cjVar.we());
    }

    private void DW(cj cjVar, int i, int i2) {
        if (!cjVar.er(i) && !cjVar.er(i2)) {
            this.j6.vy.j6(cjVar.we(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), cjVar.nw(i2), cjVar.KD(i2), cjVar.SI(i2), cjVar.ro(i2));
        }
    }

    public String j6() {
        return "i;";
    }

    public void j6(bv bvVar, int i, int i2, boolean z) {
        this.DW.FH(bvVar, i, i2);
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3, int i4, boolean z) {
        this.DW.j6(bvVar, i, i2, str, i3, i4, z);
    }

    public void j6(cj cjVar, int i, int i2, int i3, boolean z) {
        this.DW.j6(cjVar, i, i2, i3, z);
    }

    public boolean FH(bv bvVar, int i, int i2) {
        this.DW.Hw(bvVar, i, i2);
        return true;
    }

    public void j6(cj cjVar, bv bvVar, bj bjVar, int i, int i2) {
        this.DW.j6(cjVar, i, i2);
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3) {
        this.DW.j6(bvVar, i, i2, str, i3);
    }

    public void Hw(bv bvVar, int i, int i2) {
        this.DW.j6(bvVar, i, i2);
    }

    public void v5(bv bvVar, int i, int i2) {
        this.DW.DW(bvVar, i, i2);
    }

    public dj<bm$a> j6(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.FH.DW(cjVar, ckVar, i, i2, i3);
    }

    public dj<bm$a> DW(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.FH.DW(cjVar, ckVar, i, i2, i3);
    }

    public dj<bm$a> FH(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.FH.j6(cjVar, ckVar, i, i2, i3);
    }

    public void DW(cj cjVar, ck ckVar, int i, int i2) {
        this.FH.j6(cjVar, ckVar, i);
    }

    public int[] FH(cj cjVar, ck ckVar, int i, int i2) {
        return this.FH.j6(cjVar, ckVar, i, i2);
    }

    public void j6(cj cjVar, ck ckVar, int i, int i2) {
        this.FH.DW(cjVar, ckVar, i, i2);
    }

    public Set<? extends bd> j6(cj cjVar, int i) {
        return this.FH.j6(cjVar, i);
    }

    public String j6(String str, String str2) {
        return str + " " + str2;
    }

    public String j6(cj cjVar, int i, int i2, co coVar) {
        if (coVar.cT()) {
            if (j6(cjVar, (bp) coVar)) {
                return coVar.iW();
            }
            return coVar.eU();
        } else if (coVar.w9()) {
            return j6(cjVar, i, i2, ((ch) coVar).j6()) + "*";
        } else {
            int i3;
            String str;
            if (coVar.AL()) {
                String str2 = "";
                co coVar2 = coVar;
                while (coVar2.AL()) {
                    int DW = ((bo) coVar2).DW();
                    str2 = str2 + "[";
                    for (i3 = 1; i3 < DW; i3++) {
                        str2 = str2 + ",";
                    }
                    str = str2 + "]";
                    coVar2 = ((bo) coVar2).FH();
                    str2 = str;
                }
                return j6(cjVar, i, i2, coVar2) + str2;
            } else if (!coVar.n5()) {
                return coVar.iW();
            } else {
                bp gn = ((cf) coVar).gn();
                co[] DW2 = ((cf) coVar).DW();
                int[] FH = ((cf) coVar).FH();
                int kQ = gn.kQ() - 1;
                Object obj = 1;
                bp bpVar = gn;
                str = "";
                bp bpVar2 = bpVar;
                while (true) {
                    Object obj2;
                    int XX = bpVar2.XX();
                    if (obj != null && XX > 0) {
                        int i4 = XX - 1;
                        String str3 = str;
                        i3 = kQ;
                        while (i4 >= 0) {
                            String j6 = j6(cjVar, i, i2, DW2[i3]);
                            if (FH[i3] == 2) {
                                j6 = "? extends " + j6;
                            }
                            if (FH[i3] == 3) {
                                j6 = "? super " + j6;
                            }
                            if (FH[i3] == 1) {
                                j6 = "?";
                            }
                            if (i4 < XX - 1) {
                                j6 = j6 + ", " + str3;
                            } else {
                                j6 = j6 + ">" + str3;
                            }
                            i4--;
                            i3--;
                            str3 = j6;
                        }
                        int i5 = i3;
                        str = "<" + str3;
                        kQ = i5;
                    }
                    String str4 = bpVar2.br() + str;
                    if (bpVar2.we()) {
                        obj2 = obj;
                    } else {
                        obj2 = null;
                    }
                    bp Xa = bpVar2.Xa();
                    if (Xa == bpVar2) {
                        return str4;
                    }
                    Object obj3 = obj2;
                    str = "." + str4;
                    bpVar2 = Xa;
                    obj = obj3;
                }
            }
        }
    }

    public String j6(cj cjVar, dq<bp, bs> dqVar) {
        bs bsVar;
        int i = 0;
        dm dmVar = new dm(this.j6.cb);
        dm dmVar2 = new dm(this.j6.cb);
        int lg = cjVar.lg(cjVar.Ws());
        for (int i2 = 1; i2 < lg; i2++) {
            int Hw = cjVar.Hw(cjVar.Ws(), i2);
            switch (cjVar.rN(Hw)) {
                case 213:
                    Hw = cjVar.Hw(Hw, cjVar.lg(Hw) - 2);
                    if (cjVar.J8(Hw) == 0) {
                        break;
                    }
                    dmVar2.FH(cjVar.QX(Hw));
                    break;
                case 214:
                    Hw = cjVar.Hw(Hw, cjVar.lg(Hw) - 4);
                    if (cjVar.J8(Hw) != 8) {
                        break;
                    }
                    dmVar.FH((bp) cjVar.QX(Hw));
                    break;
                default:
                    break;
            }
        }
        String str = "";
        if (dmVar.Hw() > 0) {
            int i3 = 0;
            while (i3 < dmVar.Hw()) {
                String str2;
                if (str.length() > 0) {
                    str2 = str + "\n";
                } else {
                    str2 = str;
                }
                bsVar = (bp) dmVar.j6(i3);
                bs rN = bsVar.rN();
                if (dqVar.DW(bsVar)) {
                    rN = dqVar.Hw(bsVar);
                }
                i3++;
                str = str2 + "import static " + (rN.iW() + "." + bsVar.br()) + ".*;";
            }
        }
        if (dmVar2.Hw() > 0) {
            while (i < dmVar2.Hw()) {
                String str3;
                if (str.length() > 0) {
                    str3 = str + "\n";
                } else {
                    str3 = str;
                }
                bs j6 = dmVar2.j6(i);
                if (j6.zh()) {
                    bs Xa = ((bz) j6).Xa();
                    bsVar = Xa.rN();
                    if (dqVar.DW(Xa)) {
                        bsVar = dqVar.Hw(Xa);
                    }
                    str = str3 + "import static " + (bsVar.iW() + "." + Xa.br() + "." + this.j6.ro.j6(((bz) j6).aq())) + ";";
                } else if (j6.cT()) {
                    j6 = (bp) j6;
                    bsVar = j6.rN();
                    if (dqVar.DW(j6)) {
                        bsVar = dqVar.Hw(j6);
                    }
                    str = str3 + "import static " + (bsVar.iW() + "." + j6.eU()) + ";";
                } else {
                    str = str3;
                }
                i++;
            }
        }
        return str;
    }

    public String j6(ce ceVar) {
        if (ceVar.Zo()) {
            return "";
        }
        return "package " + ceVar.iW() + ";";
    }

    public String DW(ce ceVar) {
        return "";
    }

    public String FH(ce ceVar) {
        return "";
    }

    public String j6(cj cjVar, dq<bp, bs> dqVar, ea<ce> eaVar) {
        bs bsVar;
        int i = 0;
        dg dgVar = new dg();
        dqVar.j6.j6();
        while (dqVar.j6.DW()) {
            bp bpVar = (bp) dqVar.j6.FH();
            bs Hw = dqVar.j6.Hw();
            if (dgVar.DW(Hw.v5())) {
                dgVar.j6(Hw.v5(), dgVar.FH(Hw.v5()) + 1);
            } else {
                dgVar.j6(Hw.v5(), 1);
            }
        }
        ea eaVar2 = new ea(this.j6.cb);
        ea eaVar3 = new ea(this.j6.cb);
        dqVar.j6.j6();
        while (dqVar.j6.DW()) {
            Hw = (bp) dqVar.j6.FH();
            bs Hw2 = dqVar.j6.Hw();
            try {
                if (!(Hw2 == this.gn.we().Hw(cjVar.we()) || Hw2 == this.gn.we().Mr())) {
                    if (dgVar.FH(Hw2.v5()) <= this.j6.u7().v5) {
                        eaVar2.j6(Hw);
                    } else {
                        eaVar3.j6(Hw2);
                    }
                }
            } catch (ej e) {
            }
        }
        ea eaVar4 = new ea(this.j6.cb);
        dqVar.j6.j6();
        dq FH = this.j6.cb.FH(cjVar.we());
        if (FH.FH() > 0) {
            FH.j6.j6();
            FH.j6.DW();
            FH.j6.FH();
            bsVar = (ce) FH.j6.Hw();
        } else {
            bsVar = null;
        }
        while (dqVar.j6.DW()) {
            Hw = (bp) dqVar.j6.FH();
            if (!eaVar2.FH(Hw)) {
                boolean z;
                bs lg = Hw.lg();
                int aq = Hw.aq();
                eaVar3.j6.j6();
                while (eaVar3.j6.DW()) {
                    Hw2 = eaVar3.j6.FH();
                    if (Hw2 != lg) {
                        if (!Hw2.qp() || !((ce) Hw2).j6(aq, true)) {
                            if (Hw2.cT() && ((bp) Hw2).j6(aq, true)) {
                                eaVar4.j6(Hw);
                                z = true;
                                break;
                            }
                        }
                        eaVar4.j6(Hw);
                        z = true;
                        break;
                    }
                }
                z = false;
                if (!z) {
                    try {
                        if (lg != this.gn.we().Hw(cjVar.we()) && this.gn.we().Hw(cjVar.we()).j6(aq, true)) {
                            eaVar4.j6(Hw);
                            z = true;
                        }
                    } catch (ej e2) {
                    }
                }
                if (!(z || r3 == null || r3 == lg || !r3.j6(aq, true))) {
                    eaVar4.j6(Hw);
                }
            }
        }
        eaVar2.j6(eaVar4);
        String[] strArr = new String[eaVar2.Hw()];
        eaVar2.j6.j6();
        int i2 = 0;
        while (eaVar2.j6.DW()) {
            Hw = (bp) eaVar2.j6.FH();
            Hw2 = Hw.lg();
            if (dqVar.DW(Hw)) {
                bsVar = dqVar.Hw(Hw);
            } else {
                bsVar = Hw2;
            }
            int i3 = i2 + 1;
            strArr[i2] = bsVar.iW() + "." + Hw.br();
            i2 = i3;
        }
        j6(strArr, 0, strArr.length - 1);
        String[] strArr2 = new String[eaVar3.Hw()];
        eaVar3.j6.j6();
        int i4 = 0;
        while (eaVar3.j6.DW()) {
            i2 = i4 + 1;
            strArr2[i4] = eaVar3.j6.FH().iW();
            i4 = i2;
        }
        j6(strArr2, 0, strArr2.length - 1);
        String str = "";
        for (String DW : strArr2) {
            String DW2 = DW(DW2);
            if (DW2.length() > 0) {
                if (str.length() > 0) {
                    str = str + "\n";
                }
                str = str + DW2;
            }
        }
        if (strArr.length > 0) {
            if (str.length() > 0) {
                str = str + "\n";
            }
            while (i < strArr.length) {
                String FH2 = FH(strArr[i]);
                if (FH2.length() > 0) {
                    if (str.length() > 0) {
                        str = str + "\n";
                    }
                    str = str + FH2;
                }
                i++;
            }
        }
        return str;
    }

    public String j6(cj cjVar, int i, int i2, ea<? extends co> eaVar) {
        return j6(cjVar, i, i2, (ea) eaVar, new ea(this.j6.cb));
    }

    public String j6(cj cjVar, int i, int i2, ea<? extends co> eaVar, ea<bs> eaVar2) {
        String str = "";
        eaVar.j6.j6();
        while (eaVar.j6.DW()) {
            str = j6(cjVar, i, i2, (co) eaVar.j6.FH(), str, (ea) eaVar2, this.j6.u7().v5);
        }
        if (str.length() > 0) {
            return "\n" + str;
        }
        return str;
    }

    private String j6(cj cjVar, int i, int i2, co coVar, String str, ea<bs> eaVar, int i3) {
        if (this.gn.we().j6(coVar)) {
            return str;
        }
        if (coVar.AL()) {
            return j6(cjVar, i, i2, ((bo) coVar).FH(), str, (ea) eaVar, i3);
        } else if (coVar.w9()) {
            return j6(cjVar, i, i2, ((ch) coVar).j6(), str, (ea) eaVar, i3);
        } else if (coVar.n5()) {
            String j6 = j6(cjVar, i, i2, ((cf) coVar).gn(), str, (ea) eaVar, i3);
            co[] DW = ((cf) coVar).DW();
            for (co j62 : DW) {
                j6 = j6(cjVar, i, i2, j62, j6, (ea) eaVar, i3);
            }
            return j6;
        } else if (!coVar.cT()) {
            return str;
        } else {
            bs rN;
            if (((bp) coVar).hz()) {
                rN = ((bp) coVar).rN();
            } else {
                rN = ((bp) coVar).Xa();
            }
            if (rN == this.j6.cb.Zo() || j6(cjVar, i, i2, (bp) coVar)) {
                return str;
            }
            if (i3 == 0) {
                if (eaVar.FH(rN)) {
                    return str;
                }
                eaVar.j6(rN);
                if (str.length() > 0) {
                    str = str + "\n";
                }
                return str + DW(rN.iW());
            } else if (eaVar.FH((bs) coVar)) {
                return str;
            } else {
                eaVar.j6((bs) coVar);
                if (str.length() > 0) {
                    str = str + "\n";
                }
                return str + FH(coVar.iW());
            }
        }
    }

    protected String DW(String str) {
        return "import " + str + ".*;";
    }

    protected String FH(String str) {
        return "import " + str + ";";
    }

    private boolean j6(cj cjVar, bp bpVar) {
        int Ws = cjVar.Ws();
        int lg = cjVar.lg(Ws);
        int aq = bpVar.aq();
        int i = 0;
        int i2 = 0;
        while (i < lg) {
            int Hw;
            int Hw2 = cjVar.Hw(Ws, i);
            if (cjVar.rN(Hw2) == ProxyTextView.INPUTTYPE_textWebPassword) {
                Hw = cjVar.Hw(Hw2, cjVar.lg(Hw2) - 2);
                if (cjVar.gW(Hw) == aq && cjVar.J8(Hw) == 8 && cjVar.QX(Hw) != bpVar) {
                    return true;
                }
            }
            if (cjVar.rN(Hw2) == ProxyTextView.INPUTTYPE_textWebPassword) {
                Hw = cjVar.Hw(Hw2, cjVar.lg(Hw2) - 2);
                if (cjVar.gW(Hw) == aq && cjVar.J8(Hw) == 8 && cjVar.QX(Hw) == bpVar) {
                    return false;
                }
            }
            if (cjVar.rN(Hw2) == 226) {
                Hw2 = cjVar.Hw(Hw2, cjVar.lg(Hw2) - 4);
                if (cjVar.J8(Hw2) == 6 && ((ce) cjVar.QX(Hw2)).j6(aq, true)) {
                    Hw2 = i2 + 1;
                    i++;
                    i2 = Hw2;
                }
            }
            Hw2 = i2;
            i++;
            i2 = Hw2;
        }
        return i2 >= 2;
    }

    private boolean j6(cj cjVar, int i, int i2, bp bpVar) {
        int Ws = cjVar.Ws();
        int lg = cjVar.lg(Ws);
        for (int i3 = 0; i3 < lg; i3++) {
            int Hw = cjVar.Hw(Ws, i3);
            if (cjVar.rN(Hw) == 224 && cjVar.lg(Hw) > 0) {
                Hw = cjVar.Hw(Hw, cjVar.lg(Hw) - 2);
                if (cjVar.J8(Hw) == 6 && bpVar.hz() && cjVar.QX(Hw) == bpVar.rN()) {
                    return true;
                }
            } else if (cjVar.rN(Hw) == ProxyTextView.INPUTTYPE_textWebPassword) {
                Hw = cjVar.Hw(Hw, cjVar.lg(Hw) - 2);
                if (cjVar.J8(Hw) == 8 && cjVar.QX(Hw) == bpVar) {
                    return true;
                }
            } else if (cjVar.rN(Hw) == 226) {
                Hw = cjVar.Hw(Hw, cjVar.lg(Hw) - 4);
                if (cjVar.J8(Hw) == 6 && bpVar.hz() && cjVar.QX(Hw) == bpVar.rN()) {
                    return true;
                }
                if (cjVar.J8(Hw) == 8 && !bpVar.hz() && cjVar.QX(Hw) == bpVar.Xa()) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void j6(String[] strArr, int i, int i2) {
        if (i < i2) {
            String str = strArr[((i2 - i) / 2) + i];
            int i3 = i2;
            int i4 = i;
            while (i4 <= i3) {
                while (strArr[i4].compareTo(str) < 0) {
                    i4++;
                }
                while (str.compareTo(strArr[i3]) < 0) {
                    i3--;
                }
                if (i4 <= i3) {
                    String str2 = strArr[i3];
                    strArr[i3] = strArr[i4];
                    strArr[i4] = str2;
                    i4++;
                    i3--;
                }
            }
            j6(strArr, i, i3);
            j6(strArr, i4, i2);
        }
    }
}
