import com.aide.uidesigner.ProxyTextView;

public class an {
    private final ba j6;

    public an(ba baVar) {
        this.j6 = baVar;
    }

    public boolean j6(cj cjVar, int i, int i2, int i3, int i4) {
        if (cjVar.Zo(i, i2, i3, i4) == -1) {
            return true;
        }
        return false;
    }

    public an$a DW(cj cjVar, int i, int i2, int i3, int i4) {
        if (i2 == i4 && i == i3) {
            return new an$a(this);
        }
        int gn = cjVar.gn(i, i2, i3, i4);
        int v5 = cjVar.v5(i, i2, i3, i4);
        if (gn == -1 || gn == v5) {
            do DW = cjVar.DW(i, i2, i3, i4);
            if (DW == null) {
                return new an$a(this);
            }
            an$a an_a = new an$a(this);
            an_a.v5 = true;
            an_a.j6 = cjVar.nw(DW.FH(0));
            an_a.DW = cjVar.KD(DW.FH(0));
            an_a.FH = cjVar.SI(DW.FH(DW.Hw() - 1));
            an_a.Hw = cjVar.ro(DW.FH(DW.Hw() - 1));
            return an_a;
        }
        an_a = new an$a(this);
        an_a.v5 = true;
        an_a.j6 = cjVar.nw(gn);
        an_a.DW = cjVar.KD(gn);
        an_a.FH = cjVar.SI(gn);
        an_a.Hw = cjVar.ro(gn);
        return an_a;
    }

    public boolean FH(cj cjVar, int i, int i2, int i3, int i4) {
        if (i2 != i4 || i != i3) {
            return false;
        }
        int gn = cjVar.gn(i, i2, i3, i4);
        if (gn == -1 || !cjVar.Qq(gn)) {
            return false;
        }
        return true;
    }

    public boolean Hw(cj cjVar, int i, int i2, int i3, int i4) {
        if (i2 != i4 || i != i3) {
            return false;
        }
        int Zo = cjVar.Zo(i, i2, i3, i4);
        if (Zo != -1) {
            int v5 = cjVar.v5(i, i2, i3, i4);
            if (v5 == -1 || !cjVar.Zo(Zo, v5)) {
                try {
                    bz bzVar;
                    bp j6 = this.j6.cb.j6(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.aM(Zo)));
                    dr lp = j6.lp();
                    lp.j6.j6();
                    while (lp.j6.DW()) {
                        bzVar = (bz) lp.j6.Hw();
                        if (cd.XL(bzVar.Ev()) && bzVar.Xa() != j6) {
                            return true;
                        }
                    }
                    lp = j6.sy();
                    lp.j6.j6();
                    while (lp.j6.DW()) {
                        bzVar = (bz) lp.j6.Hw();
                        if (cd.XL(bzVar.Ev()) && bzVar.Xa() != j6) {
                            if (bzVar.J0() || bzVar.we()) {
                                return true;
                            }
                        }
                    }
                } catch (ej e) {
                }
            }
        }
        return false;
    }

    public boolean v5(cj cjVar, int i, int i2, int i3, int i4) {
        if (i2 == i4 && i == i3) {
            return false;
        }
        int tp = cjVar.tp(i, i2, i3, i4);
        if (tp == -1 || cjVar.aj(cjVar.aM(tp))) {
            return false;
        }
        return true;
    }

    public boolean Zo(cj cjVar, int i, int i2, int i3, int i4) {
        do VH = cjVar.VH(i, i2, i3, i4);
        if (VH == null) {
            return false;
        }
        for (int Hw = VH.Hw() - 1; Hw >= 0; Hw--) {
            for (int i5 = 0; i5 < cjVar.lg(VH.FH(Hw)); i5++) {
                int Hw2 = cjVar.Hw(VH.FH(Hw), i5);
                if (cjVar.x9(Hw2)) {
                    try {
                        bz DW = this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(Hw2));
                        if (!(DW.J0() || DW.we())) {
                            return true;
                        }
                    } catch (ej e) {
                    }
                }
            }
        }
        return false;
    }

    public boolean VH(cj cjVar, int i, int i2, int i3, int i4) {
        int u7 = cjVar.u7(i, i2);
        int gn = cjVar.gn(i3, i4);
        if (u7 == -1 || gn == 1 || u7 != gn) {
            return false;
        }
        return true;
    }

    public bs j6(cj cjVar, int i, int i2) {
        if (cjVar.gn(i, i2) != -1) {
            return Hw(cjVar, i, i2);
        }
        int tp = cjVar.tp(i, i2);
        if (tp != -1 && cjVar.J0(cjVar.aM(tp))) {
            bs we = cjVar.we(cjVar.aM(tp));
            if (we.cT()) {
                return we;
            }
        }
        return null;
    }

    public boolean DW(cj cjVar, int i, int i2) {
        int gn = cjVar.gn(i, i2);
        if (gn != -1) {
            int J8 = cjVar.J8(gn);
            switch (J8) {
                case 7:
                case 11:
                case 13:
                case 15:
                case 19:
                case 21:
                    return true;
                default:
                    switch (J8) {
                        case 16:
                            if (this.j6.cn.v5(((bz) cjVar.QX(gn)).tp())) {
                                return true;
                            }
                            break;
                    }
                    break;
            }
        }
        return false;
    }

    public boolean FH(cj cjVar, int i, int i2) {
        int gn = cjVar.gn(i, i2);
        if (gn != -1) {
            switch (cjVar.J8(gn)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case 32:
                    return true;
            }
        }
        return false;
    }

    public bs Hw(cj cjVar, int i, int i2) {
        int gn = cjVar.gn(i, i2);
        if (gn != -1) {
            switch (cjVar.J8(gn)) {
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                case 19:
                case ProxyTextView.INPUTTYPE_date /*20*/:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    return cjVar.QX(gn);
            }
        }
        return null;
    }

    public cp v5(cj cjVar, int i, int i2) {
        co coVar = null;
        int gn = cjVar.gn(i, i2);
        if (gn != -1) {
            int gW = cjVar.gW(gn);
            switch (cjVar.J8(gn)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case 32:
                    int Ws = cjVar.Ws(gn);
                    bv we = cjVar.we();
                    bj tp = cjVar.tp();
                    int nw = cjVar.nw(Ws);
                    int KD = cjVar.KD(Ws);
                    Ws = cjVar.ro(Ws);
                    if (cjVar.J0(gn)) {
                        coVar = cjVar.we(gn);
                    }
                    return new cp(we, tp, nw, KD, Ws, gW, coVar);
            }
        }
        return null;
    }

    public boolean Zo(cj cjVar, int i, int i2) {
        int gn = cjVar.gn(i, i2);
        if (gn != -1) {
            cjVar.gW(gn);
            switch (cjVar.J8(gn)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    if (cjVar.J8(cjVar.Ws(gn)) != 1) {
                        return false;
                    }
                    return true;
            }
        }
        return false;
    }

    public boolean VH(cj cjVar, int i, int i2) {
        int gn = cjVar.gn(i, i2);
        if (gn != -1) {
            cjVar.gW(gn);
            switch (cjVar.J8(gn)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case 32:
                    return true;
            }
        }
        return false;
    }
}
