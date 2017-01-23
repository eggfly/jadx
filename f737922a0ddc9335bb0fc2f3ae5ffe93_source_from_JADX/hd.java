import com.aide.uidesigner.ProxyTextView;

public class hd {
    private final bu DW;
    private final bt FH;
    private dg Hw;
    private dg Zo;
    private boolean j6;
    private dg v5;

    public hd(cc ccVar) {
        this.j6 = true;
        this.DW = ccVar.sG;
        this.FH = ccVar.cb;
        this.Hw = new dg();
        this.v5 = new dg();
        this.Zo = new dg();
    }

    public void j6(cj cjVar) {
        if (this.j6) {
            this.v5.j6();
            this.Zo.j6();
            j6(cjVar, cjVar.Ws());
        }
        this.Hw.j6();
        DW(cjVar, cjVar.Ws());
        this.Hw.j6.j6();
        while (this.Hw.j6.DW()) {
            int Hw = this.Hw.j6.Hw();
            if (cjVar.rN(cjVar.aM(Hw)) == 200) {
                this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.SI(Hw), cjVar.ro(Hw), "There is no access to variable </C>" + cjVar.BT(Hw) + "<//C>", 49);
            } else {
                this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.SI(Hw), cjVar.ro(Hw), "There is no access to parameter </C>" + cjVar.BT(Hw) + "<//C> in this method", 40);
            }
        }
        if (this.j6) {
            bz bzVar;
            this.Zo.j6.j6();
            while (this.Zo.j6.DW()) {
                bzVar = (bz) this.FH.FH(this.Zo.j6.FH());
                Hw = this.Zo.j6.Hw();
                this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.SI(Hw), cjVar.ro(Hw), "Method </C>" + cjVar.BT(Hw) + "<//C> is never used", 41);
            }
            this.v5.j6.j6();
            while (this.v5.j6.DW()) {
                bzVar = (bz) this.FH.FH(this.v5.j6.FH());
                Hw = this.v5.j6.Hw();
                this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.SI(Hw), cjVar.ro(Hw), "There is no access to field </C>" + cjVar.BT(Hw) + "<//C>", 41);
            }
        }
    }

    private void j6(cj cjVar, int i) {
        bz DW;
        int Hw;
        switch (cjVar.rN(i)) {
            case 124:
                try {
                    DW = this.FH.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                    Hw = cjVar.Hw(i, 4);
                    if (DW.Q6()) {
                        this.Zo.j6(DW.v5(), Hw);
                        break;
                    }
                } catch (ej e) {
                    break;
                }
                break;
            case 133:
                return;
            case 194:
                try {
                    DW = this.FH.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                    Hw = cjVar.Hw(i, 0);
                    if (DW.Q6()) {
                        this.v5.j6(DW.v5(), Hw);
                        break;
                    }
                } catch (ej e2) {
                    break;
                }
                break;
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2));
        }
    }

    private void j6(cj cjVar, int i, String str, int i2) {
        this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), str, i2);
    }

    private void DW(cj cjVar, int i) {
        int aM;
        int Hw;
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                bz DW;
                switch (cjVar.J8(i)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case 32:
                        if (cjVar.rN(cjVar.aM(i)) != 200 && cjVar.rN(cjVar.aM(i)) != 211) {
                            if (cjVar.rN(cjVar.aM(i)) == 191) {
                                aM = cjVar.aM(cjVar.aM(cjVar.aM(i)));
                                if (cjVar.rN(aM) != 124 || cjVar.lg(cjVar.Hw(aM, 6)) > 2) {
                                    try {
                                        DW = this.FH.DW(cjVar.we(), cjVar.tp(), cjVar.XL(aM));
                                        if (!(DW.sG() || DW.ca())) {
                                            this.Hw.j6(cjVar.Ws(i), i);
                                            break;
                                        }
                                    } catch (ej e) {
                                        break;
                                    }
                                }
                            }
                        }
                        this.Hw.j6(cjVar.Ws(i), i);
                        break;
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        if (cjVar.lg(cjVar.aM(i)) > 1 || !cjVar.Sf(cjVar.aM(i))) {
                            this.Hw.j6(cjVar.Ws(i));
                            break;
                        }
                    case 8:
                    case 9:
                    case 10:
                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        break;
                    case 16:
                        this.v5.j6(((bz) cjVar.QX(i)).v5());
                        break;
                    case ProxyTextView.INPUTTYPE_date /*20*/:
                        DW = (bz) cjVar.QX(i);
                        this.Zo.j6(DW.v5());
                        if ((DW.Hw() instanceof gv) && DW.lg() == 5) {
                            j6(cjVar, i, "</C>" + DW.iW() + "<//C> has been introduced in Java 1.5", 61);
                            break;
                        }
                    default:
                        break;
                }
                break;
            case 134:
                this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "This empty statement may be not intended here", 43);
                if (cjVar.rN(cjVar.aM(i)) != 133) {
                    this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), " {}", "Replace with {}");
                    break;
                } else {
                    this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "", "Delete");
                    break;
                }
            case 136:
                if (cjVar.VH(cjVar.Hw(i, 4), cjVar.Hw(i, 6))) {
                    this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "The </C>if<//C> and </C>else<//C> parts of this statement are identical", 44);
                    break;
                }
                break;
            case 169:
                if (cjVar.J0(cjVar.Hw(i, 4)) && cjVar.J0(cjVar.Hw(i, 1))) {
                    co j6 = j6(cjVar, cjVar.we(cjVar.Hw(i, 1)), cjVar.Hw(i, 2));
                    co we = cjVar.we(cjVar.Hw(i, 4));
                    if (we == j6 || (we.FH(cjVar.we(), cjVar.tp(), j6) && (cjVar.rN(cjVar.aM(i)) == 194 || cjVar.rN(cjVar.aM(i)) == 200 || (cjVar.rN(cjVar.aM(i)) == 172 && cjVar.Hw(cjVar.aM(i), 2) == i && cjVar.rN(cjVar.Hw(cjVar.aM(i), 1)) == 17)))) {
                        int i2;
                        this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(cjVar.Hw(i, 0)), cjVar.KD(cjVar.Hw(i, 0)), cjVar.SI(cjVar.Hw(i, 3)), cjVar.ro(cjVar.Hw(i, 3)), "This cast is not required", 42);
                        aM = i;
                        while (cjVar.rN(cjVar.aM(aM)) == 168) {
                            aM = cjVar.aM(aM);
                        }
                        if (cjVar.rN(cjVar.Hw(i, 4)) == 169) {
                            switch (cjVar.rN(cjVar.aM(aM))) {
                                case 155:
                                case 159:
                                    i2 = i;
                                    break;
                            }
                        }
                        i2 = aM;
                        this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.SI(i), cjVar.ro(i), cjVar.SI(i2), cjVar.ro(i2), cjVar.nw(cjVar.Hw(i2, 0)), cjVar.KD(cjVar.Hw(i2, 0)), cjVar.nw(cjVar.Hw(i, 4)), Math.max(0, cjVar.KD(cjVar.Hw(i, 4))), "Remove cast");
                        break;
                    }
                }
            case 172:
                aM = cjVar.Hw(i, 0);
                Hw = cjVar.Hw(i, 2);
                if (cjVar.rN(cjVar.Hw(i, 1)) == 17 && (((cjVar.rN(aM) == 159 && cjVar.rN(cjVar.Hw(aM, 0)) == 166) || (cjVar.rN(aM) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(aM) == 1)) && ((cjVar.rN(Hw) == 159 && cjVar.rN(cjVar.Hw(Hw, 0)) == 166) || (cjVar.rN(Hw) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(Hw) == 1)))) {
                    int Hw2 = cjVar.Hw(aM, cjVar.lg(aM) - 1);
                    int Hw3 = cjVar.Hw(Hw, cjVar.lg(Hw) - 1);
                    if (cjVar.J8(Hw2) == 16 && cjVar.J8(Hw2) == cjVar.J8(Hw3) && cjVar.QX(Hw2) == cjVar.QX(Hw3)) {
                        this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "This assignment has no effect", 46);
                    }
                    if (cjVar.J8(Hw2) == 2 && cjVar.J8(Hw2) == cjVar.J8(Hw3) && cjVar.Ws(Hw2) == cjVar.Ws(Hw3)) {
                        this.DW.j6(cjVar.we(), cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), "This assignment has no effect", 46);
                        break;
                    }
                }
        }
        Hw = cjVar.lg(i);
        for (aM = 0; aM < Hw; aM++) {
            DW(cjVar, cjVar.Hw(i, aM));
        }
    }

    private co j6(cj cjVar, co coVar, int i) {
        int lg = cjVar.lg(i);
        if (lg > 0 && cjVar.rN(cjVar.Hw(i, lg - 1)) == 108) {
            coVar = this.FH.j6(coVar, 1);
            lg--;
        }
        for (lg -= 2; lg >= 0; lg -= 3) {
            coVar = this.FH.j6(coVar, cjVar.lg(cjVar.Hw(i, lg)) + 1);
        }
        return coVar;
    }
}
