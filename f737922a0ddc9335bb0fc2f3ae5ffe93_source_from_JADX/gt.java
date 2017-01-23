import com.aide.uidesigner.ProxyTextView;
import java.util.Stack;

public class gt {
    private final bt DW;
    private do EQ;
    private final hc FH;
    private Stack<dt> Hw;
    private int J0;
    private dg J8;
    private do QX;
    private ec VH;
    private dg Ws;
    private do XL;
    private final boolean Zo;
    private ec gn;
    private final bu j6;
    private do tp;
    private do u7;
    private co[] v5;
    private int we;

    public gt(cc ccVar, hc hcVar, boolean z) {
        this.VH = new ec();
        this.gn = new ec();
        this.u7 = new do();
        this.tp = new do();
        this.EQ = new do();
        this.J8 = new dg();
        this.Ws = new dg();
        this.QX = new do();
        this.XL = new do();
        this.j6 = ccVar.sG;
        this.DW = ccVar.cb;
        this.FH = hcVar;
        this.Zo = z;
        this.Hw = new Stack();
        this.v5 = new co[1000];
    }

    public void j6(cj cjVar) {
        dt j6 = j6();
        j6(cjVar, cjVar.Ws(), j6);
        j6(j6);
    }

    private void j6(cj cjVar, int i, dt dtVar) {
        int sh;
        int i2;
        int aM;
        int lg;
        int i3;
        String str;
        dt j6;
        int lg2;
        int Hw;
        int Hw2;
        int lg3;
        co we;
        int KD;
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                bz bzVar;
                int rN;
                if (cjVar.J8(i) == 20) {
                    bzVar = (bz) cjVar.QX(i);
                    if (cjVar.rN(cjVar.aM(i)) == 156 && cjVar.cn(i)) {
                        sh = cjVar.sh(cjVar.sh(cjVar.sh(i)));
                        if (cjVar.J0(sh) && cjVar.we(sh).AL() && this.FH.j6(bzVar)) {
                            return;
                        }
                    }
                    if (cjVar.rN(cjVar.aM(i)) == 155) {
                        sh = cjVar.Hw(cjVar.aM(i), 0);
                        if (cjVar.J0(sh) && cjVar.we(sh).AL() && this.FH.j6(bzVar)) {
                            return;
                        }
                    }
                    rN = bzVar.rN();
                    for (i2 = 0; i2 < rN; i2++) {
                        cj cjVar2 = cjVar;
                        j6(cjVar, i, cjVar2.Hw(cjVar.aM(i), cjVar.lg(cjVar.aM(i)) - 1), dtVar, bzVar, i2);
                    }
                }
                if (cjVar.J8(i) == 22 || cjVar.J8(i) == 25 || cjVar.J8(i) == 24 || cjVar.J8(i) == 23) {
                    bzVar = (bz) cjVar.QX(i);
                    rN = bzVar.rN();
                    for (i2 = 0; i2 < rN; i2++) {
                        sh = cjVar.aM(cjVar.aM(i));
                        aM = cjVar.aM(cjVar.aM(i));
                        j6(cjVar, i, cjVar.Hw(sh, cjVar.lg(aM) - 1), dtVar, bzVar, i2);
                    }
                }
            case 122:
                lg = cjVar.lg(i);
                for (i3 = 0; i3 < lg; i3++) {
                    sh = cjVar.Hw(i, i3);
                    switch (cjVar.rN(sh)) {
                        case 126:
                            break;
                        case 127:
                            if (cjVar.lg(cjVar.Hw(sh, 0)) == 0) {
                                j6(cjVar, sh, dtVar);
                                break;
                            }
                            dt j62 = j6();
                            j6(cjVar, cjVar.Hw(sh, cjVar.lg(sh) - 1), j62);
                            j62.j6.j6();
                            while (j62.j6.DW()) {
                                str = "The exception </C>" + this.DW.FH(j62.j6.FH()).iW() + "<//C> must be caught";
                                this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(j62.j6.Hw()), cjVar.KD(j62.j6.Hw()), cjVar.SI(j62.j6.Hw()), cjVar.ro(j62.j6.Hw()), str, 12);
                                this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.nw(j62.j6.Hw()), cjVar.KD(j62.j6.Hw()), "Surround with try/catch");
                            }
                            j6(j62);
                            break;
                        default:
                            j6(cjVar, sh, dtVar);
                            break;
                    }
                }
            case 123:
                j6 = j6();
                j6(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1), j6);
                aM = cjVar.aM(i);
                lg2 = cjVar.lg(aM);
                for (sh = 0; sh < lg2; sh++) {
                    Hw = cjVar.Hw(aM, sh);
                    switch (cjVar.rN(Hw)) {
                        case 127:
                            if (cjVar.lg(cjVar.Hw(Hw, 0)) != 0) {
                                break;
                            }
                        case 126:
                            j6(cjVar, Hw, j6);
                            break;
                        default:
                            break;
                    }
                }
                Hw2 = cjVar.Hw(i, 4);
                lg3 = cjVar.lg(Hw2);
                for (i3 = 1; i3 < lg3; i3 += 2) {
                    i2 = cjVar.Hw(Hw2, i3);
                    if (cjVar.J0(i2)) {
                        we = cjVar.we(i2);
                        try {
                            if (!(j6(cjVar, j6, we) || !this.FH.Hw(cjVar.we(), we) || we == this.FH.P8(cjVar.we()) || we == this.FH.yS(cjVar.we()) || !this.Zo)) {
                                this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i2), cjVar.KD(i2), cjVar.SI(i2), cjVar.ro(i2), "The exception </C>" + we.iW() + "<//C> is not thrown", 50);
                            }
                        } catch (ej e) {
                        }
                    }
                }
                for (sh = 1; sh < lg3; sh += 2) {
                    aM = cjVar.Hw(Hw2, sh);
                    if (cjVar.J0(aM)) {
                        DW(cjVar, j6, cjVar.we(aM));
                    }
                }
                j6.j6.j6();
                while (j6.j6.DW()) {
                    str = "The exception </C>" + this.DW.FH(j6.j6.FH()).iW() + "<//C> must be caught";
                    Hw = cjVar.nw(j6.j6.Hw());
                    KD = cjVar.KD(j6.j6.Hw());
                    int SI = cjVar.SI(j6.j6.Hw());
                    i2 = cjVar.ro(j6.j6.Hw());
                    if (Hw == SI && KD == i2) {
                        i2++;
                    }
                    this.j6.v5(cjVar.we(), cjVar.tp(), Hw, KD, SI, i2, str, 12);
                    this.j6.j6(cjVar.we(), cjVar.tp(), Hw, KD, "Surround with try/catch");
                    this.j6.DW(cjVar.we(), cjVar.tp(), Hw, KD, "Add to throws clause");
                }
                j6(j6);
            case 124:
                j6 = j6();
                j6(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1), j6);
                Hw2 = cjVar.Hw(i, 7);
                lg3 = cjVar.lg(Hw2);
                try {
                    if (!this.DW.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i)).a8()) {
                        for (i3 = 1; i3 < lg3; i3 += 2) {
                            i2 = cjVar.Hw(Hw2, i3);
                            if (cjVar.J0(i2)) {
                                we = cjVar.we(i2);
                                try {
                                    if (!(j6(cjVar, j6, we) || !this.FH.Hw(cjVar.we(), we) || we == this.FH.P8(cjVar.we()) || we == this.FH.yS(cjVar.we()) || !this.Zo)) {
                                        this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i2), cjVar.KD(i2), cjVar.SI(i2), cjVar.ro(i2), "The exception </C>" + we.iW() + "<//C> is not thrown", 50);
                                    }
                                } catch (ej e2) {
                                }
                            }
                        }
                    }
                } catch (ej e3) {
                }
                for (sh = 1; sh < lg3; sh += 2) {
                    aM = cjVar.Hw(Hw2, sh);
                    if (cjVar.J0(aM)) {
                        DW(cjVar, j6, cjVar.we(aM));
                    }
                }
                j6.j6.j6();
                while (j6.j6.DW()) {
                    str = "The exception </C>" + this.DW.FH(j6.j6.FH()).iW() + "<//C> must be caught or declared in the throws clause";
                    Hw = cjVar.nw(j6.j6.Hw());
                    KD = cjVar.KD(j6.j6.Hw());
                    this.j6.v5(cjVar.we(), cjVar.tp(), Hw, KD, cjVar.SI(j6.j6.Hw()), cjVar.ro(j6.j6.Hw()), str, 12);
                    this.j6.j6(cjVar.we(), cjVar.tp(), Hw, KD, "Surround with try/catch");
                    this.j6.DW(cjVar.we(), cjVar.tp(), Hw, KD, "Add to throws clause");
                }
                j6(j6);
            case 142:
                aM = cjVar.lg(i);
                for (sh = 0; sh < aM; sh++) {
                    j6(cjVar, cjVar.Hw(i, sh), dtVar);
                }
                if (cjVar.J0(cjVar.Hw(i, 1))) {
                    j6(cjVar, dtVar, cjVar.we(cjVar.Hw(i, 1)), i);
                }
            case 150:
                int lg4;
                dt j63 = j6();
                j6(cjVar, cjVar.Hw(i, 1), j63);
                int lg5 = cjVar.lg(i);
                for (lg = 2; lg < lg5; lg++) {
                    Hw2 = cjVar.Hw(i, lg);
                    if (cjVar.rN(Hw2) == 204) {
                        lg3 = cjVar.Hw(Hw2, 3);
                        lg4 = cjVar.lg(lg3);
                        for (i3 = 0; i3 < lg4; i3 += 2) {
                            i2 = cjVar.Hw(lg3, i3);
                            if (cjVar.J0(i2)) {
                                co we2 = cjVar.we(i2);
                                try {
                                    if (!(!this.FH.Hw(cjVar.we(), we2) || we2 == this.FH.P8(cjVar.we()) || we2 == this.FH.yS(cjVar.we()) || j6(cjVar, j63, we2))) {
                                        this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(i2), cjVar.KD(i2), cjVar.SI(i2), cjVar.ro(i2), "The exception </C>" + we2.iW() + "<//C> is not thrown", 12);
                                        this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.SI(Hw2), cjVar.ro(Hw2), "", "Delete catch clause");
                                    }
                                } catch (ej e4) {
                                }
                            }
                        }
                    }
                }
                for (aM = 2; aM < lg5; aM++) {
                    sh = cjVar.Hw(i, aM);
                    if (cjVar.rN(sh) == 204) {
                        lg2 = cjVar.Hw(sh, 3);
                        Hw = cjVar.lg(lg2);
                        for (sh = 0; sh < Hw; sh += 2) {
                            KD = cjVar.Hw(lg2, sh);
                            if (cjVar.J0(KD)) {
                                DW(cjVar, j63, cjVar.we(KD));
                            }
                        }
                    }
                }
                for (lg3 = 2; lg3 < lg5; lg3++) {
                    lg4 = cjVar.Hw(i, lg3);
                    if (cjVar.rN(lg4) == 204) {
                        int Hw3 = cjVar.Hw(lg4, 3);
                        int lg6 = cjVar.lg(Hw3);
                        for (Hw2 = 0; Hw2 < lg6; Hw2 += 2) {
                            int Hw4 = cjVar.Hw(Hw3, Hw2);
                            if (cjVar.J0(Hw4)) {
                                co we3 = cjVar.we(Hw4);
                                for (lg = 2; lg < lg3; lg++) {
                                    sh = cjVar.Hw(i, lg);
                                    if (cjVar.rN(sh) == 204) {
                                        int Hw5 = cjVar.Hw(sh, 3);
                                        int lg7 = cjVar.lg(Hw5);
                                        for (i3 = 0; i3 < lg7; i3 += 2) {
                                            sh = cjVar.Hw(Hw5, i3);
                                            if (cjVar.J0(sh)) {
                                                if (we3.FH(cjVar.we(), cjVar.tp(), cjVar.we(sh))) {
                                                    this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(Hw4), cjVar.KD(Hw4), cjVar.SI(Hw4), cjVar.ro(Hw4), "The exception </C>" + we3.iW() + "<//C> has already been caught", 12);
                                                    this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.nw(lg4), cjVar.KD(lg4), cjVar.SI(lg4), cjVar.ro(lg4), "", "Delete catch clause");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                dtVar.j6(j63);
                j6(j63);
                for (sh = 2; sh < lg5; sh++) {
                    j6(cjVar, cjVar.Hw(i, sh), dtVar);
                }
            default:
                aM = cjVar.lg(i);
                for (sh = 0; sh < aM; sh++) {
                    j6(cjVar, cjVar.Hw(i, sh), dtVar);
                }
        }
    }

    private void j6(cj cjVar, int i, int i2, dt dtVar, bz bzVar, int i3) {
        try {
            co DW = bzVar.DW(i3);
            if (DW.cT()) {
                j6(cjVar, dtVar, DW, i);
            } else if (DW.q7()) {
                if (cjVar.tp(i)) {
                    j6(cjVar, dtVar, bzVar.j6(i3, cjVar.EQ(i)), i);
                }
            } else if (DW.Z1() && cjVar.tp(i)) {
                co EQ = cjVar.EQ(i);
                int i4 = 0;
                int lg = cjVar.lg(i2);
                if (lg > 2) {
                    int i5 = 1;
                    while (i5 < lg) {
                        if (cjVar.J0(cjVar.Hw(i2, i5))) {
                            int i6 = i4 + 1;
                            this.v5[i4] = cjVar.we(cjVar.Hw(i2, i5));
                            i5 += 2;
                            i4 = i6;
                        } else {
                            return;
                        }
                    }
                }
                dt dtVar2 = dtVar;
                j6(cjVar, dtVar2, bzVar.j6(cjVar.we(), cjVar.tp(), i3, EQ, this.v5, 0, i4, new co[0], 0, 0), i);
            }
        } catch (ej e) {
        }
    }

    private boolean j6(cj cjVar, dt dtVar, co coVar) {
        if (dtVar.FH(coVar.v5())) {
            return true;
        }
        dtVar.j6.j6();
        while (dtVar.j6.DW()) {
            if (coVar.FH(cjVar.we(), cjVar.tp(), (co) this.DW.FH(dtVar.j6.FH()))) {
                return true;
            }
            if (((co) this.DW.FH(dtVar.j6.FH())).FH(cjVar.we(), cjVar.tp(), coVar)) {
                return true;
            }
        }
        return false;
    }

    private void DW(cj cjVar, dt dtVar, co coVar) {
        dt j6 = j6();
        dtVar.j6.j6();
        while (dtVar.j6.DW()) {
            if (!((co) this.DW.FH(dtVar.j6.FH())).FH(cjVar.we(), cjVar.tp(), coVar)) {
                j6.DW(dtVar.j6.FH(), dtVar.j6.Hw());
            }
        }
        dtVar.DW();
        dtVar.j6(j6);
        j6(j6);
    }

    private void j6(cj cjVar, dt dtVar, co coVar, int i) {
        if (this.FH.Hw(cjVar.we(), coVar)) {
            dtVar.DW(coVar.v5(), i);
        }
    }

    private dt j6() {
        if (this.Hw.empty()) {
            return new dt();
        }
        dt dtVar = (dt) this.Hw.pop();
        dtVar.DW();
        return dtVar;
    }

    private void j6(dt dtVar) {
        this.Hw.push(dtVar);
    }

    public void DW(cj cjVar) {
        this.VH.j6();
        this.gn.j6();
        j6(cjVar, cjVar.Ws(), true);
    }

    private boolean j6(cj cjVar, int i, boolean z) {
        switch (cjVar.rN(i)) {
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
            case 211:
                if (!z) {
                    this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "This statement cannot be reached", 12);
                    this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "", "Delete");
                    break;
                }
                break;
        }
        int Hw;
        int Hw2;
        int lg;
        int i2;
        boolean z2;
        boolean z3;
        switch (cjVar.rN(i)) {
            case 124:
                Hw = cjVar.Hw(i, 8);
                if (cjVar.rN(Hw) == 133 && j6(cjVar, Hw, true)) {
                    try {
                        co Mz = this.DW.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i)).Mz();
                        if (Mz.Gj() != 1) {
                            String str;
                            Hw2 = cjVar.Hw(Hw, cjVar.lg(Hw) - 1);
                            this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.SI(Hw2), cjVar.ro(Hw2), "This method must return a value of type </C>" + Mz.iW() + "<//C>", 12);
                            if (Mz.Gj() == 11) {
                                str = "return false;\n";
                            } else if (this.FH.j6(Mz)) {
                                str = "return 0;\n";
                            } else {
                                str = "return null;\n";
                            }
                            this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.nw(Hw2), cjVar.KD(Hw2), str, "Insert return statement");
                        }
                    } catch (ej e) {
                    }
                }
                return true;
            case 127:
                Hw = cjVar.Hw(i, 1);
                if (!j6(cjVar, Hw, true)) {
                    int Hw3 = cjVar.Hw(Hw, cjVar.lg(Hw) - 1);
                    this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(Hw3), cjVar.KD(Hw3), cjVar.SI(Hw3), cjVar.ro(Hw3), "An initializer must be able to complete normally", 12);
                }
                return true;
            case 133:
                lg = cjVar.lg(i);
                i2 = 1;
                z2 = z;
                while (i2 < lg - 1) {
                    i2++;
                    z2 = j6(cjVar, cjVar.Hw(i, i2), z2);
                }
                return z2;
            case 134:
            case 143:
            case 144:
            case 146:
            case 151:
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
                i2 = cjVar.lg(i);
                for (Hw = 0; Hw < i2; Hw++) {
                    j6(cjVar, cjVar.Hw(i, Hw), z);
                }
                return z;
            case 135:
                j6(cjVar, cjVar.Hw(i, 2), z);
                j6(cjVar, cjVar.Hw(i, 4), z);
                return z;
            case 136:
                j6(cjVar, cjVar.Hw(i, 2), z);
                return j6(cjVar, cjVar.Hw(i, 4), z) | j6(cjVar, cjVar.Hw(i, 6), z);
            case 137:
                j6(cjVar, cjVar.Hw(i, 2), z);
                Hw = cjVar.Hw(i, 2);
                if (cjVar.u7(Hw) && cjVar.J0(Hw) && cjVar.we(Hw).Gj() == 11 && !this.DW.DW(cjVar.gn(Hw))) {
                    j6(cjVar, cjVar.Hw(i, 4), false);
                } else {
                    j6(cjVar, cjVar.Hw(i, 4), z);
                }
                if (cjVar.u7(Hw) && cjVar.J0(Hw) && cjVar.we(Hw).Gj() == 11 && this.DW.DW(cjVar.gn(Hw))) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if (!z2) {
                    z2 = FH(cjVar, i);
                }
                this.gn.DW(i);
                this.VH.DW(i);
                return z2;
            case 138:
                if (z) {
                    j6(cjVar, i);
                }
                return false;
            case 139:
                if (z) {
                    DW(cjVar, i);
                }
                return false;
            case 140:
                return j6(cjVar, cjVar.Hw(i, 4), z);
            case 141:
            case 142:
                i2 = cjVar.lg(i);
                for (Hw = 0; Hw < i2; Hw++) {
                    j6(cjVar, cjVar.Hw(i, Hw), z);
                }
                return false;
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                z2 = j6(cjVar, cjVar.Hw(i, 1), z);
                i2 = cjVar.Hw(i, 4);
                if (cjVar.u7(i2) && cjVar.J0(i2) && cjVar.we(i2).Gj() == 11 && this.DW.DW(cjVar.gn(i2))) {
                    z2 = false;
                }
                if (!z2) {
                    z2 = FH(cjVar, i);
                }
                this.gn.DW(i);
                this.VH.DW(i);
                j6(cjVar, cjVar.Hw(i, 4), z2);
                return z2;
            case 147:
                j6(cjVar, cjVar.Hw(i, 2), z);
                int Hw4 = cjVar.Hw(i, 4);
                int lg2 = cjVar.lg(Hw4);
                Hw2 = 1;
                z3 = z;
                Object obj = null;
                while (Hw2 < lg2 - 1) {
                    Object obj2;
                    if (cjVar.rN(cjVar.Hw(Hw4, Hw2)) == 144) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    switch (cjVar.rN(cjVar.Hw(Hw4, Hw2))) {
                        case 143:
                        case 144:
                            switch (cjVar.rN(cjVar.Hw(Hw4, Hw2 - 1))) {
                                case 8:
                                case 143:
                                case 144:
                                    break;
                                default:
                                    if (z3 && this.Zo) {
                                        this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.SI(cjVar.Hw(Hw4, Hw2 - 1)), cjVar.ro(cjVar.Hw(Hw4, Hw2 - 1)) - 1, cjVar.SI(cjVar.Hw(Hw4, Hw2 - 1)), cjVar.ro(cjVar.Hw(Hw4, Hw2 - 1)) + 1, "Possible fall through", 48);
                                        this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.SI(cjVar.Hw(Hw4, Hw2 - 1)), cjVar.ro(cjVar.Hw(Hw4, Hw2 - 1)), cjVar.SI(cjVar.Hw(Hw4, Hw2 - 1)), cjVar.ro(cjVar.Hw(Hw4, Hw2 - 1)), "\nbreak;", "Insert break statement");
                                        break;
                                    }
                            }
                            z2 = j6(cjVar, cjVar.Hw(Hw4, Hw2), z);
                            break;
                        default:
                            z2 = j6(cjVar, cjVar.Hw(Hw4, Hw2), z3);
                            break;
                    }
                    Hw2++;
                    z3 = z2;
                    obj = obj2;
                }
                if (z3 || obj != null) {
                    z2 = z3;
                } else {
                    z2 = z;
                }
                if (!z2) {
                    z2 = FH(cjVar, i);
                }
                this.gn.DW(i);
                this.VH.DW(i);
                return z2;
            case 148:
                z2 = j6(cjVar, cjVar.Hw(i, 2), z);
                if (!z2) {
                    z2 = FH(cjVar, i);
                }
                this.gn.DW(i);
                this.VH.DW(i);
                return z2;
            case 149:
                for (Hw = 0; Hw < 6; Hw++) {
                    j6(cjVar, cjVar.Hw(i, Hw), true);
                }
                Hw = cjVar.Hw(cjVar.Hw(i, 3), 0);
                if (cjVar.rN(Hw) != 14 && cjVar.u7(Hw) && cjVar.J0(Hw) && cjVar.we(Hw).Gj() == 11 && !this.DW.DW(cjVar.gn(Hw))) {
                    j6(cjVar, cjVar.Hw(i, 6), false);
                } else {
                    j6(cjVar, cjVar.Hw(i, 6), z);
                }
                if (cjVar.rN(Hw) == 14 || (cjVar.u7(Hw) && cjVar.J0(Hw) && cjVar.we(Hw).Gj() == 11 && this.DW.DW(cjVar.gn(Hw)))) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if (!z2) {
                    z2 = FH(cjVar, i);
                }
                this.gn.DW(i);
                this.VH.DW(i);
                return z2;
            case 150:
                z3 = j6(cjVar, cjVar.Hw(i, 1), z);
                lg = cjVar.lg(i);
                z2 = z3;
                for (i2 = 2; i2 < lg; i2++) {
                    switch (cjVar.rN(cjVar.Hw(i, i2))) {
                        case 204:
                            z2 |= j6(cjVar, cjVar.Hw(cjVar.Hw(i, i2), 6), z);
                            break;
                        case 205:
                            z2 &= j6(cjVar, cjVar.Hw(cjVar.Hw(i, i2), 1), z);
                            break;
                        default:
                            break;
                    }
                }
                return z2;
            case 211:
                j6(cjVar, cjVar.Hw(i, 10), z);
                this.gn.DW(i);
                this.VH.DW(i);
                return z;
            case 212:
                return j6(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1), z);
            default:
                i2 = cjVar.lg(i);
                for (Hw = 0; Hw < i2; Hw++) {
                    j6(cjVar, cjVar.Hw(i, Hw), true);
                }
                return true;
        }
    }

    private void j6(cj cjVar, int i) {
        if (cjVar.VH(i)) {
            this.VH.j6(cjVar.Zo(i));
        }
    }

    private void DW(cj cjVar, int i) {
        if (cjVar.VH(i)) {
            this.gn.j6(cjVar.Zo(i));
        }
    }

    private boolean FH(cj cjVar, int i) {
        if (this.VH.FH(i)) {
            return true;
        }
        if (this.gn.Hw() > 0) {
            this.gn.j6.j6();
            while (this.gn.j6.DW()) {
                int FH = this.gn.j6.FH();
                if (FH != i && cjVar.Zo(FH, i)) {
                    return true;
                }
                switch (cjVar.rN(FH)) {
                    case 137:
                        FH = cjVar.Hw(FH, 2);
                        break;
                    case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                        FH = cjVar.Hw(FH, 4);
                        break;
                    case 149:
                        FH = cjVar.Hw(cjVar.Hw(FH, 3), 0);
                        break;
                    case 211:
                        FH = cjVar.Hw(cjVar.Hw(FH, 4), 0);
                        break;
                    default:
                        FH = -1;
                        break;
                }
                if (FH == -1) {
                    return true;
                }
                if (cjVar.rN(FH) != 14) {
                    if (!cjVar.u7(FH) || !cjVar.J0(FH) || cjVar.we(FH).Gj() != 11) {
                        return true;
                    }
                    if (!this.DW.DW(cjVar.gn(FH))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void FH(cj cjVar) {
        this.J0 = -1;
        this.we = (cjVar.J8() / 31) + 1;
        this.u7.j6();
        this.tp.j6();
        this.EQ.j6();
        this.J8.j6();
        this.Ws.j6();
        this.QX.j6();
        this.XL.j6();
        FH();
        Hw(cjVar, cjVar.Ws());
    }

    private void Hw(cj cjVar, int i) {
        int i2 = 3;
        int i3 = 2;
        int i4 = 1;
        int i5 = 0;
        int i6;
        int lg;
        int i7;
        int Hw;
        int lg2;
        int Hw2;
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
            case 7:
            case 66:
            case 143:
            case 144:
            case 162:
            case 163:
            case 164:
            case 166:
            case 167:
            case 178:
                gn();
                VH();
            case 68:
                j6(true);
                VH();
            case 74:
                j6(false);
                VH();
            case 122:
                i6 = this.J0;
                lg = cjVar.lg(i);
                for (i7 = 0; i7 < lg; i7++) {
                    Hw = cjVar.Hw(i, i7);
                    switch (cjVar.rN(Hw)) {
                        case 126:
                            lg2 = cjVar.lg(Hw);
                            for (i3 = 3; i3 < lg2; i3 += 2) {
                                Hw2 = cjVar.Hw(cjVar.Hw(Hw, i3), 0);
                                if (cjVar.Hw(Hw2)) {
                                    Hw2 = cjVar.FH(Hw2);
                                    if (Hw2 > this.J0) {
                                        this.J0 = Hw2;
                                    }
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
                for (i3 = 0; i3 < lg; i3++) {
                    switch (cjVar.rN(cjVar.Hw(i, i3))) {
                        case 126:
                        case 127:
                            Hw(cjVar, cjVar.Hw(i, i3));
                            break;
                        default:
                            break;
                    }
                }
                while (i5 < lg) {
                    switch (cjVar.rN(cjVar.Hw(i, i5))) {
                        case 126:
                        case 127:
                            break;
                        default:
                            Hw(cjVar, cjVar.Hw(i, i5));
                            break;
                    }
                    i5++;
                }
                DW(cjVar, i, true);
                this.J0 = i6;
                gn();
                a8();
                VH();
                Hw();
                lg();
            case 123:
                if (cjVar.rN(cjVar.Hw(i, 5)) == 133) {
                    i5 = this.J0;
                    gn();
                    i3 = cjVar.Hw(i, 3);
                    i7 = cjVar.lg(i3);
                    while (i4 < i7 - 1) {
                        i6 = cjVar.Hw(i3, i4);
                        if (cjVar.rN(i6) != 16) {
                            i6 = cjVar.FH(cjVar.Hw(i6, 3));
                            if (i6 > this.J0) {
                                this.J0 = i6;
                            }
                            DW(i6);
                        }
                        i4 += 2;
                    }
                    Hw();
                    lg();
                    Hw(cjVar, cjVar.Hw(i, 5));
                    lg();
                    this.J0 = i5;
                }
            case 124:
                if (cjVar.rN(cjVar.Hw(i, 8)) == 133) {
                    i5 = this.J0;
                    gn();
                    i3 = cjVar.Hw(i, 5);
                    i7 = cjVar.lg(i3);
                    while (i4 < i7 - 1) {
                        i6 = cjVar.Hw(i3, i4);
                        if (cjVar.rN(i6) != 16) {
                            i6 = cjVar.FH(cjVar.Hw(i6, 3));
                            if (i6 > this.J0) {
                                this.J0 = i6;
                            }
                            DW(i6);
                        }
                        i4 += 2;
                    }
                    Hw();
                    lg();
                    Hw(cjVar, cjVar.Hw(i, 8));
                    lg();
                    this.J0 = i5;
                }
            case 126:
                i7 = cjVar.lg(i);
                for (i4 = 3; i4 < i7; i4 += 2) {
                    i6 = cjVar.Hw(i, i4);
                    lg = cjVar.Hw(i6, 0);
                    if (cjVar.lg(i6) > 2) {
                        Hw(cjVar, cjVar.Hw(i6, 3));
                        Hw();
                        lg();
                    }
                    if (cjVar.Hw(lg)) {
                        i6 = cjVar.FH(lg);
                        if (i6 > this.J0) {
                            this.J0 = i6;
                        }
                    }
                }
            case 127:
                Hw(cjVar, cjVar.Hw(i, 1));
                Hw();
                lg();
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 222:
                Hw(cjVar, cjVar.Hw(i, 6));
                gn();
                VH();
            case 133:
                i6 = cjVar.lg(i);
                lg = this.J0;
                if (cjVar.rN(cjVar.aM(i)) == 123 && cjVar.rN(cjVar.Hw(i, 1)) == 146 && cjVar.rN(cjVar.Hw(cjVar.Hw(i, 1), 0)) == 163) {
                    gn();
                    Hw = cjVar.aM(cjVar.aM(i));
                    lg2 = cjVar.lg(Hw);
                    for (i7 = 0; i7 < lg2; i7++) {
                        Hw2 = cjVar.Hw(Hw, i7);
                        int lg3 = cjVar.lg(Hw2);
                        if (cjVar.rN(Hw2) == 126) {
                            for (i3 = 3; i3 < lg3; i3 += 2) {
                                int Hw3 = cjVar.Hw(cjVar.Hw(Hw2, i3), 0);
                                if (cjVar.Hw(Hw3)) {
                                    DW(cjVar.FH(Hw3));
                                }
                            }
                        }
                    }
                    VH();
                    Hw();
                    lg();
                }
                while (i4 < i6 - 1) {
                    Hw(cjVar, cjVar.Hw(i, i4));
                    Hw();
                    lg();
                    i4++;
                }
                if (cjVar.rN(cjVar.aM(i)) == 123) {
                    DW(cjVar, cjVar.aM(cjVar.aM(i)), false);
                }
                gn();
                VH();
                this.J0 = lg;
                a8();
            case 134:
                gn();
                VH();
            case 135:
                Hw(cjVar, cjVar.Hw(i, 2));
                v5();
                Hw(cjVar, cjVar.Hw(i, 4));
                j3();
            case 136:
                Hw(cjVar, cjVar.Hw(i, 2));
                Zo();
                v5();
                lg();
                Hw(cjVar, cjVar.Hw(i, 4));
                Hw(cjVar, cjVar.Hw(i, 6));
                XL();
            case 137:
                gn(cjVar, i);
                Hw(cjVar, cjVar.Hw(i, 2));
                v5();
                tp();
                Hw(cjVar, cjVar.Hw(i, 4));
                lg();
                Zo(cjVar, i);
                u7(cjVar, i);
            case 138:
                EQ(cjVar, i);
                EQ();
                VH();
            case 139:
                tp(cjVar, i);
                EQ();
                VH();
            case 140:
                Hw(cjVar, cjVar.Hw(i, 2));
                Hw();
                lg();
                Hw(cjVar, cjVar.Hw(i, 4));
            case 141:
            case 142:
                if (cjVar.lg(i) > 2) {
                    DW();
                    Hw(cjVar, cjVar.Hw(i, 1));
                    lg();
                }
                EQ();
                VH();
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                gn(cjVar, i);
                Hw(cjVar, cjVar.Hw(i, 1));
                VH(cjVar, i);
                Hw();
                lg();
                Hw(cjVar, cjVar.Hw(i, 4));
                tp();
                Zo(cjVar, i);
                u7(cjVar, i);
            case 146:
                Hw(cjVar, cjVar.Hw(i, 0));
            case 147:
                gn(cjVar, i);
                Hw(cjVar, cjVar.Hw(i, 2));
                u7();
                i2 = cjVar.Hw(i, 4);
                i7 = cjVar.lg(i2);
                for (i3 = 1; i3 < i7 - 1; i3++) {
                    switch (cjVar.rN(cjVar.Hw(i2, i3))) {
                        case 143:
                            J8();
                            break;
                        case 144:
                            J8();
                            i5 = 1;
                            break;
                        default:
                            Hw();
                            lg();
                            Hw(cjVar, cjVar.Hw(i2, i3));
                            break;
                    }
                }
                if (i5 != 0) {
                    J0();
                } else {
                    lg();
                }
                Zo(cjVar, i);
                u7(cjVar, i);
            case 148:
                gn(cjVar, i);
                Hw(cjVar, cjVar.Hw(i, 2));
                Zo(cjVar, i);
                u7(cjVar, i);
            case 149:
                i7 = this.J0;
                gn(cjVar, i);
                DW();
                i3 = cjVar.Hw(i, 2);
                if (cjVar.rN(cjVar.Hw(i3, 0)) != 14) {
                    i6 = cjVar.lg(i3);
                    for (i4 = 0; i4 < i6; i4 += 2) {
                        Hw(cjVar, cjVar.Hw(i3, i4));
                        Hw();
                        lg();
                    }
                }
                i4 = cjVar.Hw(i, 3);
                if (cjVar.rN(cjVar.Hw(i4, 0)) != 14) {
                    Hw(cjVar, cjVar.Hw(i4, 0));
                    v5();
                    tp();
                } else {
                    EQ();
                }
                Hw(cjVar, cjVar.Hw(i, 6));
                i4 = cjVar.Hw(i, 4);
                if (cjVar.lg(i4) > 0) {
                    VH(cjVar, i);
                    Hw();
                    lg();
                    i3 = cjVar.lg(i4);
                    while (i5 < i3) {
                        Hw(cjVar, cjVar.Hw(i4, i5));
                        Hw();
                        lg();
                        i5 += 2;
                    }
                    VH();
                } else {
                    lg();
                }
                VH();
                Zo(cjVar, i);
                u7(cjVar, i);
                this.J0 = i7;
                a8();
            case 150:
                i2 = this.J0;
                DW();
                Hw(cjVar, cjVar.Hw(i, 1));
                i4 = cjVar.lg(i);
                for (i5 = 2; i5 < i4; i5++) {
                    i3 = cjVar.Hw(i, i5);
                    if (cjVar.rN(i3) == 204) {
                        gn();
                        i7 = cjVar.FH(cjVar.Hw(i3, 4));
                        DW(i7);
                        if (i7 > this.J0) {
                            this.J0 = i7;
                        }
                        Hw();
                        lg();
                        Hw(cjVar, cjVar.Hw(i3, cjVar.lg(i3) - 1));
                        Mr();
                    } else {
                        DW();
                        Hw(cjVar, cjVar.Hw(i3, cjVar.lg(i3) - 1));
                        U2();
                    }
                }
                VH();
                this.J0 = i2;
                a8();
            case 151:
                i7 = cjVar.lg(i);
                for (i4 = 3; i4 < i7; i4 += 2) {
                    i6 = cjVar.Hw(i, i4);
                    lg = cjVar.FH(cjVar.Hw(i6, 0));
                    if (cjVar.lg(i6) > 2) {
                        Hw(cjVar, cjVar.Hw(i6, 3));
                        DW(lg);
                        Hw();
                        lg();
                    }
                    if (lg > this.J0) {
                        this.J0 = lg;
                    }
                }
                gn();
                VH();
            case 155:
                Hw(cjVar, cjVar.Hw(i, 0));
                Hw();
                lg();
                Hw(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
            case 156:
                i5 = cjVar.Hw(i, 0);
                if (cjVar.Hw(i5) && !j6(cjVar.FH(i5))) {
                    v5(cjVar, i5);
                }
                Hw(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
            case 157:
                Hw(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
            case 159:
                Hw(cjVar, cjVar.Hw(i, 0));
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                if (cjVar.u7(i) && cjVar.J0(i) && cjVar.we(i).Gj() == 11) {
                    j6(this.DW.DW(cjVar.gn(i)));
                    VH();
                    return;
                }
                i5 = cjVar.Hw(i, 0);
                if (cjVar.Hw(i5) && !((cjVar.lg(i) == 1 && cjVar.Sf(i)) || j6(cjVar.FH(i5)))) {
                    v5(cjVar, i5);
                }
                gn();
                VH();
            case 165:
                Hw(cjVar, cjVar.Hw(i, 0));
                Hw();
                lg();
                Hw(cjVar, cjVar.Hw(i, 2));
            case 168:
                if (cjVar.u7(i) && cjVar.J0(i) && cjVar.we(i).Gj() == 11) {
                    j6(this.DW.DW(cjVar.gn(i)));
                    VH();
                    return;
                }
                Hw(cjVar, cjVar.Hw(i, 1));
            case 169:
                if (cjVar.u7(i) && cjVar.J0(i) && cjVar.we(i).Gj() == 11) {
                    j6(this.DW.DW(cjVar.gn(i)));
                    VH();
                    return;
                }
                Hw(cjVar, cjVar.Hw(i, 4));
            case 170:
                if (cjVar.u7(i) && cjVar.J0(i) && cjVar.we(i).Gj() == 11) {
                    j6(this.DW.DW(cjVar.gn(i)));
                    VH();
                } else if (cjVar.rN(cjVar.Hw(i, 0)) == 34) {
                    Hw(cjVar, cjVar.Hw(i, 1));
                    Ws();
                } else {
                    Hw(cjVar, cjVar.Hw(i, 1));
                    if (cjVar.vJ(cjVar.Hw(i, 1)) && cjVar.rN(cjVar.Hw(i, 1)) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(cjVar.Hw(i, 1)) == 1) {
                        i5 = cjVar.Hw(cjVar.Hw(i, 1), 0);
                        if (cjVar.Hw(i5)) {
                            DW(cjVar.FH(i5));
                        }
                    }
                }
            case 171:
                Hw(cjVar, cjVar.Hw(i, 0));
                if (cjVar.vJ(cjVar.Hw(i, 0)) && cjVar.rN(cjVar.Hw(i, 0)) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(cjVar.Hw(i, 0)) == 1) {
                    i5 = cjVar.Hw(cjVar.Hw(i, 0), 0);
                    if (cjVar.Hw(i5)) {
                        DW(cjVar.FH(i5));
                    }
                }
            case 172:
                if (cjVar.u7(i) && cjVar.J0(i) && cjVar.we(i).Gj() == 11) {
                    j6(this.DW.DW(cjVar.gn(i)));
                    VH();
                } else if (cjVar.rN(cjVar.Hw(i, 1)) == 42) {
                    Hw(cjVar, cjVar.Hw(i, 0));
                    v5();
                    Hw(cjVar, cjVar.Hw(i, 2));
                    we();
                } else if (cjVar.rN(cjVar.Hw(i, 1)) == 39) {
                    Hw(cjVar, cjVar.Hw(i, 0));
                    Zo();
                    Hw(cjVar, cjVar.Hw(i, 2));
                    QX();
                } else if (cjVar.rN(cjVar.Hw(i, 1)) != 210) {
                    Hw(cjVar, cjVar.Hw(i, 0));
                    Hw();
                    lg();
                    Hw(cjVar, cjVar.Hw(i, 2));
                    i3 = cjVar.Hw(i, 0);
                    if (!cjVar.vJ(i3)) {
                        return;
                    }
                    if ((cjVar.rN(i3) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(i3) == 1) || (cjVar.rN(i3) == 159 && cjVar.rN(cjVar.Hw(i3, 0)) == 166)) {
                        i5 = cjVar.Hw(i3, cjVar.lg(i3) - 1);
                        if (cjVar.Hw(i5)) {
                            DW(cjVar.FH(i5));
                        }
                    }
                } else if (cjVar.J0(i) && cjVar.we(i).Gj() == 11) {
                    Hw(cjVar, cjVar.Hw(i, 0));
                    Zo();
                    v5();
                    lg();
                    Hw(cjVar, cjVar.Hw(cjVar.Hw(i, 1), 1));
                    Hw(cjVar, cjVar.Hw(i, 2));
                    aM();
                } else {
                    Hw(cjVar, cjVar.Hw(i, 0));
                    Zo();
                    v5();
                    lg();
                    Hw(cjVar, cjVar.Hw(cjVar.Hw(i, 1), 1));
                    Hw(cjVar, cjVar.Hw(i, 2));
                    XL();
                }
            case 173:
                Hw(cjVar, cjVar.Hw(i, 0));
            case 175:
                i4 = cjVar.lg(i);
                while (i2 < i4) {
                    i5 = cjVar.Hw(i, i2);
                    if (cjVar.rN(i5) == 11) {
                        i5 = i2 + 2;
                    } else if (cjVar.rN(i5) == 230) {
                        i5 = i2 + 3;
                    } else {
                        Hw(cjVar, i5);
                        Hw();
                        lg();
                        i5 = i2 + 3;
                    }
                    i2 = i5;
                }
                if (cjVar.rN(cjVar.Hw(i, cjVar.lg(i) - 1)) == 196) {
                    Hw(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
                    Hw();
                    lg();
                }
                gn();
                VH();
            case 176:
                if (cjVar.lg(i) > 4) {
                    Hw(cjVar, cjVar.Hw(i, 0));
                    Hw();
                    lg();
                    Hw(cjVar, cjVar.Hw(i, 5));
                    return;
                }
                Hw(cjVar, cjVar.Hw(i, 3));
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                if (cjVar.lg(i) > 5) {
                    Hw(cjVar, cjVar.Hw(i, 0));
                    Hw();
                    lg();
                    Hw(cjVar, cjVar.Hw(i, 5));
                    Hw();
                    Hw(cjVar, cjVar.Hw(i, 6));
                    VH();
                    return;
                }
                Hw(cjVar, cjVar.Hw(i, 3));
                Hw();
                Hw(cjVar, cjVar.Hw(i, 4));
                VH();
            case 196:
                i5 = cjVar.lg(i);
                while (i4 < i5 - 1) {
                    Hw(cjVar, cjVar.Hw(i, i4));
                    Hw();
                    lg();
                    i4 += 2;
                }
                gn();
                VH();
            case 197:
                i5 = cjVar.lg(i);
                while (i4 < i5 - 1) {
                    Hw(cjVar, cjVar.Hw(i, i4));
                    Hw();
                    lg();
                    i4 += 2;
                }
                gn();
                VH();
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
                DW();
                Hw(cjVar, cjVar.Hw(i, 1));
                if (cjVar.lg(i) > 3) {
                    Zo();
                    lg();
                    Hw(cjVar, cjVar.Hw(i, 3));
                }
                lg();
                gn();
                VH();
            case 211:
                i5 = this.J0;
                DW();
                gn(cjVar, i);
                Hw(cjVar, cjVar.Hw(i, 8));
                i4 = cjVar.FH(cjVar.Hw(i, 5));
                DW(i4);
                if (i4 > this.J0) {
                    this.J0 = i4;
                }
                Hw();
                Hw(cjVar, cjVar.Hw(i, 10));
                lg();
                Zo(cjVar, i);
                u7(cjVar, i);
                VH();
                this.J0 = i5;
                a8();
            case 212:
                i5 = cjVar.lg(i);
                while (i3 < i5 - 2) {
                    Hw(cjVar, cjVar.Hw(i, i3));
                    Hw();
                    lg();
                    i3++;
                }
                Hw(cjVar, cjVar.Hw(i, i5 - 1));
            case 231:
            default:
                i4 = cjVar.lg(i);
                while (i5 < i4) {
                    Hw(cjVar, cjVar.Hw(i, i5));
                    i5++;
                }
        }
    }

    private void DW(cj cjVar, int i, boolean z) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            if (cjVar.rN(cjVar.Hw(i, i2)) == 126) {
                int lg2 = cjVar.lg(cjVar.Hw(i, i2));
                for (int i3 = 3; i3 < lg2; i3 += 2) {
                    int Hw = cjVar.Hw(cjVar.Hw(i, i2), i3);
                    try {
                        if (this.DW.DW(cjVar.we(), cjVar.tp(), cjVar.XL(Hw)).I() == z) {
                            int Hw2 = cjVar.Hw(Hw, 0);
                            if (cjVar.Hw(Hw2) && !j6(cjVar.FH(Hw2))) {
                                this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.SI(Hw2), cjVar.ro(Hw2), "This field may not be initialized", 12);
                            }
                        }
                    } catch (ej e) {
                    }
                }
            }
        }
    }

    private void v5(cj cjVar, int i) {
        if (cjVar.J8(i) == 1 || cjVar.J8(i) == 32 || cjVar.J8(i) == 2) {
            this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "Variable </C>" + cjVar.BT(i) + "<//C> might not have been initialized", 12);
            if (cjVar.J0(i)) {
                String str;
                co we = cjVar.we(i);
                int Ws = cjVar.Ws(i);
                if (we.Gj() == 11) {
                    str = " = false";
                } else if (this.FH.j6(we)) {
                    str = " = 0";
                } else {
                    str = " = null";
                }
                this.j6.j6(cjVar.we(), cjVar.tp(), cjVar.SI(Ws), cjVar.ro(Ws), cjVar.SI(Ws), cjVar.ro(Ws), str, "Initialize variable");
                return;
            }
            return;
        }
        this.j6.v5(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "Field </C>" + cjVar.BT(i) + "<//C> might not have been initialized", 12);
    }

    private void Zo(cj cjVar, int i) {
        for (int i2 = 0; i2 < this.we; i2++) {
            this.tp.j6((this.tp.Hw() - this.we) + i2, this.tp.FH((this.tp.Hw() - this.we) + i2) & this.QX.FH((this.QX.Hw() - this.we) + i2));
            this.EQ.j6((this.EQ.Hw() - this.we) + i2, this.EQ.FH((this.EQ.Hw() - this.we) + i2) & this.QX.FH((this.QX.Hw() - this.we) + i2));
        }
    }

    private void VH(cj cjVar, int i) {
        for (int i2 = 0; i2 < this.we; i2++) {
            this.tp.j6((this.tp.Hw() - this.we) + i2, this.tp.FH((this.tp.Hw() - this.we) + i2) & this.XL.FH((this.XL.Hw() - this.we) + i2));
            this.EQ.j6((this.EQ.Hw() - this.we) + i2, this.EQ.FH((this.EQ.Hw() - this.we) + i2) & this.XL.FH((this.XL.Hw() - this.we) + i2));
        }
    }

    private void gn(cj cjVar, int i) {
        int i2 = 0;
        this.J8.j6(i, this.QX.Hw());
        this.Ws.j6(i, this.XL.Hw());
        for (int i3 = 0; i3 < this.we; i3++) {
            this.QX.j6(-1);
        }
        while (i2 < this.we) {
            this.XL.j6(-1);
            i2++;
        }
    }

    private void u7(cj cjVar, int i) {
        int i2 = 0;
        this.J8.j6(i);
        this.Ws.j6(i);
        for (int i3 = 0; i3 < this.we; i3++) {
            this.XL.DW();
        }
        while (i2 < this.we) {
            this.QX.DW();
            i2++;
        }
    }

    private void tp(cj cjVar, int i) {
        if (cjVar.VH(i)) {
            int FH = this.Ws.FH(cjVar.Zo(i));
            for (int i2 = 0; i2 < this.we; i2++) {
                this.XL.j6(FH + i2, this.XL.FH(FH + i2) & this.u7.FH((this.u7.Hw() - this.we) + i2));
            }
        }
    }

    private void EQ(cj cjVar, int i) {
        if (cjVar.VH(i)) {
            int FH = this.J8.FH(cjVar.Zo(i));
            for (int i2 = 0; i2 < this.we; i2++) {
                this.QX.j6(FH + i2, this.QX.FH(FH + i2) & this.u7.FH((this.u7.Hw() - this.we) + i2));
            }
        }
    }

    private void DW() {
        for (int i = 0; i < this.we; i++) {
            this.u7.j6(this.u7.FH(this.u7.Hw() - this.we));
        }
    }

    private void FH() {
        for (int i = 0; i < this.we; i++) {
            this.u7.j6(0);
        }
    }

    private void Hw() {
        for (int i = 0; i < this.we; i++) {
            this.u7.j6(this.tp.FH((this.tp.Hw() - this.we) + i) & this.EQ.FH((this.EQ.Hw() - this.we) + i));
        }
    }

    private void v5() {
        for (int i = 0; i < this.we; i++) {
            this.u7.j6(this.tp.FH((this.tp.Hw() - this.we) + i));
        }
    }

    private void Zo() {
        for (int i = 0; i < this.we; i++) {
            this.u7.j6(this.EQ.FH((this.EQ.Hw() - this.we) + i));
        }
    }

    private boolean j6(int i) {
        if ((this.u7.FH((this.u7.Hw() - this.we) + (i / 31)) & (1 << (i % 31))) != 0) {
            return true;
        }
        return false;
    }

    private void VH() {
        for (int i = 0; i < this.we; i++) {
            this.u7.DW();
        }
    }

    private void gn() {
        for (int i = 0; i < this.we; i++) {
            this.tp.j6(this.u7.FH((this.u7.Hw() - this.we) + i));
            this.EQ.j6(this.u7.FH((this.u7.Hw() - this.we) + i));
        }
    }

    private void u7() {
        for (int i = 0; i < this.we; i++) {
            this.tp.j6(this.tp.FH(this.tp.Hw() - this.we));
            this.EQ.j6(this.EQ.FH(this.EQ.Hw() - this.we));
        }
    }

    private void tp() {
        for (int i = 0; i < this.we; i++) {
            int FH = this.EQ.FH((this.EQ.Hw() - this.we) + i);
            this.tp.j6((this.EQ.Hw() - this.we) + i, FH);
            this.EQ.j6((this.EQ.Hw() - this.we) + i, FH);
        }
    }

    private void EQ() {
        for (int i = 0; i < this.we; i++) {
            this.tp.j6(-1);
            this.EQ.j6(-1);
        }
    }

    private void j6(boolean z) {
        int i = 0;
        if (z) {
            while (i < this.we) {
                this.tp.j6(this.u7.FH((this.u7.Hw() - this.we) + i));
                this.EQ.j6(-1);
                i++;
            }
            return;
        }
        while (i < this.we) {
            this.tp.j6(-1);
            this.EQ.j6(this.u7.FH((this.u7.Hw() - this.we) + i));
            i++;
        }
    }

    private void we() {
        int i = 0;
        for (int i2 = 0; i2 < this.we; i2++) {
            int FH = this.EQ.FH((this.EQ.Hw() - (this.we * 2)) + i2) & this.EQ.FH((this.EQ.Hw() - this.we) + i2);
            this.tp.j6((this.tp.Hw() - (this.we * 2)) + i2, this.tp.FH((this.tp.Hw() - this.we) + i2));
            this.EQ.j6((this.EQ.Hw() - (this.we * 2)) + i2, FH);
        }
        while (i < this.we) {
            this.tp.DW();
            this.EQ.DW();
            i++;
        }
    }

    private void J0() {
        int i = 0;
        for (int i2 = 0; i2 < this.we; i2++) {
            int FH = this.tp.FH((this.tp.Hw() - this.we) + i2);
            int FH2 = this.EQ.FH((this.EQ.Hw() - this.we) + i2);
            this.tp.j6((this.tp.Hw() - (this.we * 2)) + i2, FH);
            this.EQ.j6((this.EQ.Hw() - (this.we * 2)) + i2, FH2);
        }
        while (i < this.we) {
            this.tp.DW();
            this.EQ.DW();
            i++;
        }
    }

    private void J8() {
        for (int i = 0; i < this.we; i++) {
            int FH = this.tp.FH((this.tp.Hw() - (this.we * 2)) + i);
            int FH2 = this.tp.FH((this.tp.Hw() - this.we) + i);
            FH = (FH & this.EQ.FH((this.EQ.Hw() - (this.we * 2)) + i)) & (FH2 & this.EQ.FH((this.EQ.Hw() - this.we) + i));
            this.tp.j6((this.tp.Hw() - this.we) + i, FH);
            this.EQ.j6((this.EQ.Hw() - this.we) + i, FH);
        }
    }

    private void Ws() {
        for (int i = 0; i < this.we; i++) {
            int FH = this.tp.FH((this.tp.Hw() - this.we) + i);
            this.tp.j6((this.EQ.Hw() - this.we) + i, this.EQ.FH((this.EQ.Hw() - this.we) + i));
            this.EQ.j6((this.tp.Hw() - this.we) + i, FH);
        }
    }

    private void QX() {
        int i = 0;
        for (int i2 = 0; i2 < this.we; i2++) {
            int FH = this.tp.FH((this.tp.Hw() - (this.we * 2)) + i2);
            int FH2 = this.tp.FH((this.tp.Hw() - this.we) + i2);
            int FH3 = this.EQ.FH((this.EQ.Hw() - this.we) + i2);
            this.tp.j6((this.tp.Hw() - (this.we * 2)) + i2, FH & FH2);
            this.EQ.j6((this.EQ.Hw() - (this.we * 2)) + i2, FH3);
        }
        while (i < this.we) {
            this.tp.DW();
            this.EQ.DW();
            i++;
        }
    }

    private void XL() {
        int i = 0;
        for (int i2 = 0; i2 < this.we; i2++) {
            int FH = this.tp.FH((this.tp.Hw() - (this.we * 2)) + i2);
            int FH2 = this.tp.FH((this.tp.Hw() - this.we) + i2);
            FH = (FH & this.EQ.FH((this.EQ.Hw() - (this.we * 2)) + i2)) & (FH2 & this.EQ.FH((this.EQ.Hw() - this.we) + i2));
            this.tp.j6((this.tp.Hw() - (this.we * 2)) + i2, FH);
            this.EQ.j6((this.EQ.Hw() - (this.we * 2)) + i2, FH);
        }
        while (i < this.we) {
            this.tp.DW();
            this.EQ.DW();
            i++;
        }
    }

    private void aM() {
        int i = 0;
        for (int i2 = 0; i2 < this.we; i2++) {
            int FH = this.tp.FH((this.tp.Hw() - (this.we * 2)) + i2);
            int FH2 = this.tp.FH((this.tp.Hw() - this.we) + i2);
            FH &= FH2;
            FH2 = this.EQ.FH((this.EQ.Hw() - this.we) + i2) & this.EQ.FH((this.EQ.Hw() - (this.we * 2)) + i2);
            this.tp.j6((this.tp.Hw() - (this.we * 2)) + i2, FH);
            this.EQ.j6((this.EQ.Hw() - (this.we * 2)) + i2, FH2);
        }
        while (i < this.we) {
            this.tp.DW();
            this.EQ.DW();
            i++;
        }
    }

    private void j3() {
        int i = 0;
        for (int i2 = 0; i2 < this.we; i2++) {
            int FH = this.tp.FH((this.tp.Hw() - this.we) + i2);
            FH = (FH & this.EQ.FH((this.EQ.Hw() - this.we) + i2)) & this.EQ.FH((this.EQ.Hw() - (this.we * 2)) + i2);
            this.tp.j6((this.tp.Hw() - (this.we * 2)) + i2, FH);
            this.EQ.j6((this.EQ.Hw() - (this.we * 2)) + i2, FH);
        }
        while (i < this.we) {
            this.tp.DW();
            this.EQ.DW();
            i++;
        }
    }

    private void Mr() {
        int i = 0;
        for (int i2 = 0; i2 < this.we; i2++) {
            int FH = this.tp.FH((this.tp.Hw() - (this.we * 2)) + i2);
            int FH2 = this.tp.FH((this.tp.Hw() - this.we) + i2);
            FH = (FH & this.EQ.FH((this.EQ.Hw() - (this.we * 2)) + i2)) & (FH2 & this.EQ.FH((this.EQ.Hw() - this.we) + i2));
            this.tp.j6((this.tp.Hw() - (this.we * 2)) + i2, FH);
            this.EQ.j6((this.EQ.Hw() - (this.we * 2)) + i2, FH);
        }
        while (i < this.we) {
            this.tp.DW();
            this.EQ.DW();
            i++;
        }
    }

    private void U2() {
        int i = 0;
        for (int i2 = 0; i2 < this.we; i2++) {
            int FH = this.tp.FH((this.tp.Hw() - (this.we * 2)) + i2);
            int FH2 = this.tp.FH((this.tp.Hw() - this.we) + i2);
            FH = (FH & this.EQ.FH((this.EQ.Hw() - (this.we * 2)) + i2)) | (FH2 & this.EQ.FH((this.EQ.Hw() - this.we) + i2));
            this.tp.j6((this.tp.Hw() - (this.we * 2)) + i2, FH);
            this.EQ.j6((this.EQ.Hw() - (this.we * 2)) + i2, FH);
        }
        while (i < this.we) {
            this.tp.DW();
            this.EQ.DW();
            i++;
        }
    }

    private void DW(int i) {
        int Hw = (this.tp.Hw() - this.we) + (i / 31);
        int i2 = 1 << (i % 31);
        this.tp.j6(Hw, this.tp.FH(Hw) | i2);
        this.EQ.j6(Hw, i2 | this.EQ.FH(Hw));
    }

    private void a8() {
        int max;
        if (this.J0 < 0) {
            for (max = Math.max(0, this.tp.Hw() - this.we); max < this.tp.Hw(); max++) {
                this.tp.j6(max, 0);
                this.EQ.j6(max, 0);
            }
            return;
        }
        int Hw = (this.J0 / 31) + (this.tp.Hw() - this.we);
        for (max = Hw + 1; max < this.tp.Hw(); max++) {
            this.tp.j6(max, 0);
            this.EQ.j6(max, 0);
        }
        max = -1 >>> (31 - (this.J0 % 31));
        this.tp.j6(Hw, this.tp.FH(Hw) & max);
        this.EQ.j6(Hw, max & this.EQ.FH(Hw));
    }

    private void lg() {
        for (int i = 0; i < this.we; i++) {
            this.tp.DW();
            this.EQ.DW();
        }
    }
}
