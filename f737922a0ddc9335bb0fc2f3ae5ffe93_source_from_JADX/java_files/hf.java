import com.aide.uidesigner.ProxyTextView;
import java.util.List;

public class hf {
    private final hq DW;
    private final cc j6;

    public hf(cc ccVar, hq hqVar) {
        this.j6 = ccVar;
        this.DW = hqVar;
    }

    public void j6(cj cjVar, int i, int i2, int i3, boolean z) {
        if (i3 == -1) {
            DW(cjVar, i, i2);
            return;
        }
        String DW = cjVar.we().DW(i);
        if (DW.length() < i2 - 1) {
            return;
        }
        if (DW.substring(0, i2 - 1).endsWith("else")) {
            this.j6.lg.j6(cjVar.we());
            return;
        }
        int i4 = i3 - 1;
        while (i4 < DW.length()) {
            if (Character.isJavaIdentifierPart(DW.charAt(i4))) {
                i4++;
            } else if (i4 + 1 < i2) {
                this.j6.lg.j6(cjVar.we());
                DW(cjVar, i, i2);
                return;
            } else {
                return;
            }
        }
    }

    private void DW(cj cjVar, int i, int i2) {
        String DW = cjVar.we().DW(i);
        if (DW.length() >= i2 - 1) {
            String substring = DW.substring(0, i2 - 1);
            DW = DW.substring(i2 - 1, DW.length());
            if (substring.length() > 0) {
                char charAt = substring.charAt(substring.length() - 1);
                if (charAt != '.' && !Character.isJavaIdentifierPart(charAt)) {
                    return;
                }
                if (DW.length() <= 0 || !Character.isJavaIdentifierPart(charAt) || !Character.isJavaIdentifierPart(DW.charAt(0))) {
                    DW = j6(substring);
                    if (!DW.endsWith("else")) {
                        if (DW.length() <= 0 || Character.isJavaIdentifierStart(DW.charAt(0))) {
                            j6(cjVar, i, i2);
                        }
                    }
                }
            }
        }
    }

    private String j6(String str) {
        int length = str.length() - 1;
        while (length >= 0 && Character.isJavaIdentifierPart(str.charAt(length))) {
            length--;
        }
        if (length == str.length() - 1) {
            return "";
        }
        return str.substring(length + 1, str.length());
    }

    private int FH(bv bvVar, int i, int i2) {
        String j6 = bvVar.j6(i, i2);
        int length = j6.length() + 1;
        while (length - 2 >= 0 && Character.isJavaIdentifierPart(j6.charAt(length - 2))) {
            length--;
        }
        return length;
    }

    public void j6(cj cjVar, int i, int i2) {
        FH(cjVar, i, i2);
    }

    private void FH(cj cjVar, int i, int i2) {
        bv we = cjVar.we();
        this.j6.lg.j6();
        int gn = cjVar.gn(i, i2);
        if (gn != -1) {
            int aM = cjVar.aM(gn);
            switch (cjVar.rN(aM)) {
                case 159:
                    if (cjVar.we().FH()) {
                        this.j6.lg.DW("Members");
                        int Hw = cjVar.Hw(aM, 0);
                        this.j6.Sf.j6(cjVar, Hw);
                        ec ecVar = new ec();
                        dm FH = this.j6.Sf.FH(cjVar, Hw);
                        for (aM = 0; aM < FH.Hw(); aM++) {
                            bs bsVar = (bz) FH.j6(aM);
                            ecVar.j6(bsVar.aq());
                            this.j6.lg.DW(bsVar);
                        }
                        for (cp cpVar : this.j6.Sf.DW(cjVar, Hw)) {
                            if (!ecVar.FH(cpVar.VH())) {
                                this.j6.lg.j6(cpVar);
                            }
                        }
                        this.j6.Sf.DW(cjVar);
                        this.j6.lg.j6(we, this.DW, i, i2, FH(we, i, i2), false, false);
                        return;
                    }
                    return;
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    if (cjVar.Hw(aM, 0) == gn) {
                        Hw(cjVar, i, i2);
                    }
                    this.j6.lg.j6(we, this.DW, i, i2, FH(we, i, i2), false, false);
                    return;
            }
        }
        gn = cjVar.EQ(i, i2);
        if (gn == -1 || cjVar.rN(gn) != 2) {
            Hw(cjVar, i, i2);
            this.j6.lg.j6(we, this.DW, i, i2, FH(we, i, i2), false, false);
        }
    }

    private void Hw(cj cjVar, int i, int i2) {
        int Zo = cjVar.Zo(i, i2, i, i2);
        int FH = cjVar.FH(i, i2, i, i2);
        if (FH != -1) {
            Zo = FH;
        }
        if (Zo == -1) {
            Zo = cjVar.Ws();
        }
        ec ecVar = new ec();
        while (Zo != -1) {
            if (cjVar.rN(Zo) == 124) {
                j6(cjVar, cjVar.Hw(Zo, cjVar.lg(Zo) - 1));
                j6(cjVar, cjVar.Hw(Zo, cjVar.lg(Zo) - 2));
            } else if (cjVar.rN(Zo) == 125) {
                j6(cjVar, cjVar.Hw(Zo, cjVar.lg(Zo) - 1));
                j6(cjVar, cjVar.Hw(Zo, cjVar.lg(Zo) - 2));
            } else if (cjVar.rN(Zo) == 223) {
                j6(cjVar, Zo);
            }
            if (Zo == cjVar.Ws()) {
                break;
            }
            Zo = cjVar.aM(Zo);
        }
        j6(cjVar);
        j6();
    }

    private void j6(cj cjVar) {
        ea eaVar = new ea(this.j6.cb);
        dm v5 = ((he) cjVar.tp().u7()).v5(cjVar);
        for (int i = 0; i < v5.Hw(); i++) {
            bp bpVar = (bp) v5.j6(i);
            dr lp = bpVar.lp();
            lp.j6.j6();
            while (lp.j6.DW()) {
                bs bsVar = (bz) lp.j6.Hw();
                if (!eaVar.FH(bsVar)) {
                    this.j6.lg.j6(bsVar, false);
                    eaVar.j6(bsVar);
                }
            }
            dr sy = bpVar.sy();
            sy.j6.j6();
            while (sy.j6.DW()) {
                bs bsVar2 = (bz) sy.j6.Hw();
                if (!eaVar.FH(bsVar2)) {
                    this.j6.lg.j6(bsVar2, false);
                    eaVar.j6(bsVar2);
                }
            }
        }
    }

    private void j6(cj cjVar, int i) {
        int Hw;
        switch (cjVar.rN(i)) {
            case 124:
                if (cjVar.lg(i) == 4) {
                    Hw = cjVar.Hw(i, 1);
                    this.j6.lg.j6(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), cjVar.gW(Hw), null));
                    return;
                }
                return;
            case 125:
                return;
            case 191:
            case 200:
                Hw = cjVar.Hw(i, 0);
                this.j6.lg.j6(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), cjVar.gW(Hw), null));
                break;
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2));
        }
    }

    private void j6() {
        this.j6.lg.FH("console.log(");
        this.j6.lg.FH("break");
        this.j6.lg.FH("case");
        this.j6.lg.FH("catch");
        this.j6.lg.FH("continue");
        this.j6.lg.FH("default");
        this.j6.lg.FH("do");
        this.j6.lg.FH("else");
        this.j6.lg.FH("false");
        this.j6.lg.FH("finally");
        this.j6.lg.FH("for");
        this.j6.lg.FH("if");
        this.j6.lg.FH("instanceof");
        this.j6.lg.FH("new");
        this.j6.lg.FH("null");
        this.j6.lg.FH("return");
        this.j6.lg.FH("switch");
        this.j6.lg.FH("this");
        this.j6.lg.FH("throw");
        this.j6.lg.FH("true");
        this.j6.lg.FH("try");
        this.j6.lg.FH("void");
        this.j6.lg.FH("while");
        this.j6.lg.FH("with");
        this.j6.lg.FH("function");
        this.j6.lg.FH("var");
        this.j6.lg.FH("in");
    }

    public void j6(bv bvVar, int i, int i2) {
        String j6 = bvVar.j6(i, i2);
        if (j6.length() > 0) {
            char charAt = j6.charAt(j6.length() - 1);
            if (charAt == '(' || charAt == ',') {
                DW(bvVar, i, i2);
            }
        }
    }

    public void DW(bv bvVar, int i, int i2) {
        int i3 = 0;
        cj DW = this.j6.sh.DW(bvVar, this.DW);
        if (DW.we().FH()) {
            int we = DW.we(i, i2);
            if (we != -1) {
                int Hw = DW.Hw(DW.aM(we), 0);
                this.j6.Sf.j6(DW, Hw);
                for (bs DW2 : this.j6.Sf.v5(DW, Hw)) {
                    this.j6.lg.DW(DW2, null);
                }
                for (List j6 : this.j6.Sf.Hw(DW, Hw)) {
                    this.j6.lg.j6(j6);
                }
                this.j6.Sf.DW(DW);
                int lg = (DW.lg(we) - 1) / 2;
                lg = lg == 0 ? 2 : lg + 1;
                int[] iArr = new int[lg];
                int[] iArr2 = new int[lg];
                for (lg = 0; lg < DW.lg(we) - 1; lg += 2) {
                    int Hw2 = DW.Hw(we, lg);
                    iArr[i3] = DW.nw(Hw2);
                    iArr2[i3] = DW.KD(Hw2);
                    i3++;
                }
                iArr[i3] = DW.nw(DW.Hw(we, DW.lg(we) - 1));
                iArr2[i3] = DW.KD(DW.Hw(we, DW.lg(we) - 1));
                if (iArr[i3] == 0) {
                    iArr[i3] = iArr[i3 - 1];
                    iArr2[i3] = iArr2[i3 - 1] + 1;
                }
                this.j6.lg.j6(bvVar, i, i2, iArr, iArr2);
            }
        }
    }
}
