import com.aide.uidesigner.ProxyTextView;
import java.util.List;
import java.util.Set;

public class hv implements bm {
    private final hg DW;
    private final hf FH;
    private final hj Hw;
    private final cc j6;
    private final hq v5;

    public hv(cc ccVar, hq hqVar) {
        this.j6 = ccVar;
        this.v5 = hqVar;
        this.DW = new hg(ccVar, hqVar);
        this.FH = new hf(ccVar, hqVar);
        this.Hw = new hj(ccVar, hqVar);
    }

    public boolean j6(String str) {
        return false;
    }

    public void j6(bv bvVar, String str) {
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
        return false;
    }

    public void j6(bv bvVar, bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void VH(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, co coVar) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, co coVar) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, co coVar, int[] iArr, co[] coVarArr, int[] iArr2) {
    }

    public void Zo(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar) {
    }

    public void gn(bv bvVar, int i, int i2) {
        this.j6.rN.DW();
        cj DW = this.j6.sh.DW(bvVar, this.v5);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            ((he) DW.tp().u7()).j6(DW, DW.gW(gn));
            switch (DW.J8(gn)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    int Ws = DW.Ws(gn);
                    if (DW.J8(Ws) == 1 && DW.lg(DW.aM(Ws)) == 3) {
                        j6(DW, DW.Ws(), Ws, DW.Hw(DW.aM(Ws), 2));
                        this.j6.sh.j6(DW);
                        int aM = DW.aM(DW.aM(Ws));
                        this.j6.rN.j6(DW.we(), DW.SI(DW.sh(aM)), DW.ro(DW.sh(aM)), DW.SI(aM), DW.ro(aM), "");
                        this.j6.rN.J8();
                        return;
                    }
            }
        }
        this.j6.rN.u7("Select an initialized variable.");
        this.j6.sh.j6(DW);
    }

    private void j6(cj cjVar, int i, int i2, int i3) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, cjVar.Hw(i, lg), i2, i3);
        }
        if (cjVar.rN(i) == 1 && cjVar.J8(i) == 2 && i2 == cjVar.Ws(i) && !cjVar.Zo(i3, i)) {
            this.j6.rN.j6(cjVar.we(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "");
            this.j6.rN.DW(cjVar.we(), cjVar.nw(i3), cjVar.KD(i3), cjVar.SI(i3), cjVar.ro(i3), cjVar.nw(i), cjVar.KD(i));
        }
    }

    public void DW(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void FH(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void Hw(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void u7(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar, int i, int i2, bz bzVar) {
    }

    public void j6(bv bvVar, bv bvVar2, int i, int i2, int i3, int i4) {
    }

    public void v5(bv bvVar, int i, int i2, int i3, int i4) {
        this.j6.rN.DW();
        cj DW = this.j6.sh.DW(bvVar, this.v5);
        int tp = DW.tp(i, i2, i3, i4);
        int Hw = DW.Hw(i, i2, i3, i4);
        if (tp == -1) {
            this.j6.sh.j6(DW);
            this.j6.rN.u7("Select an expression to be extracted.");
        } else if (Hw == -1) {
            this.j6.sh.j6(DW);
            this.j6.rN.u7("Select an expression inside a block to be extracted.");
        } else if (DW.rN(DW.aM(tp)) == 146) {
            this.j6.sh.j6(DW);
            this.j6.rN.u7("Select an expression to be extracted.");
        } else {
            String j6;
            String str = "v";
            int rN = ((hu) DW.tp().Hw()).rN(DW, tp);
            if (rN != -1) {
                j6 = this.j6.ro.j6(rN);
            } else {
                j6 = str;
            }
            this.j6.rN.j6(bvVar, DW.SI(tp), DW.ro(tp), DW.SI(tp), DW.ro(tp), ";\n");
            this.j6.rN.j6(bvVar, DW.nw(tp), DW.KD(tp), DW.nw(tp), DW.KD(tp), j6);
            bv bvVar2 = bvVar;
            this.j6.rN.j6(bvVar2, DW.nw(tp), j6.length() + DW.KD(tp), DW.SI(tp) + 1, 1, DW.nw(Hw), DW.KD(Hw));
            this.j6.rN.j6(bvVar, DW.nw(Hw), DW.KD(Hw), DW.nw(Hw), DW.KD(Hw), "var " + j6 + " = ");
            this.j6.rN.DW(bvVar, DW.nw(Hw), DW.SI(tp) + 1);
            this.j6.sh.j6(DW);
            this.j6.rN.J0();
        }
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
                        case 133:
                        case 190:
                        case 197:
                            DW(cjVar, cjVar.Hw(EQ, 0), cjVar.Hw(EQ, cjVar.lg(EQ) - 1));
                            return;
                        case 135:
                        case 136:
                        case 137:
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
        this.FH.j6(bvVar, i, i2);
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3, int i4, boolean z) {
    }

    public void j6(cj cjVar, int i, int i2, int i3, boolean z) {
        this.FH.j6(cjVar, i, i2, i3, z);
    }

    public boolean FH(bv bvVar, int i, int i2) {
        this.FH.DW(bvVar, i, i2);
        return true;
    }

    public void j6(cj cjVar, bv bvVar, bj bjVar, int i, int i2) {
        this.FH.j6(cjVar, i, i2);
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3) {
    }

    public void Hw(bv bvVar, int i, int i2) {
    }

    public void v5(bv bvVar, int i, int i2) {
    }

    public dj<bm$a> j6(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.DW(cjVar, ckVar, i, i2, i3);
    }

    public dj<bm$a> DW(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.DW(cjVar, ckVar, i, i2, i3);
    }

    public dj<bm$a> FH(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.j6(cjVar, ckVar, i, i2, i3);
    }

    public int[] FH(cj cjVar, ck ckVar, int i, int i2) {
        return this.DW.j6(cjVar, ckVar, i, i2);
    }

    public void DW(cj cjVar, ck ckVar, int i, int i2) {
        this.DW.j6(cjVar, ckVar, i);
    }

    public void j6(cj cjVar, ck ckVar, int i, int i2) {
        this.DW.DW(cjVar, ckVar, i, i2);
    }

    public Set<? extends bd> j6(cj cjVar, int i) {
        return this.DW.j6(cjVar, i);
    }

    public String j6(String str, String str2) {
        return "";
    }

    public String j6(cj cjVar, int i, int i2, co coVar) {
        return "";
    }

    public String j6(cj cjVar, dq<bp, bs> dqVar) {
        return "";
    }

    public String j6(ce ceVar) {
        return "";
    }

    public String DW(ce ceVar) {
        return "";
    }

    public String FH(ce ceVar) {
        return "";
    }

    public String j6(cj cjVar, dq<bp, bs> dqVar, ea<ce> eaVar) {
        return "";
    }

    public String j6(cj cjVar, int i, int i2, ea<? extends co> eaVar) {
        return "";
    }

    public String j6(cj cjVar, int i, int i2, ea<? extends co> eaVar, ea<bs> eaVar2) {
        return "";
    }
}
