import com.aide.uidesigner.ProxyTextView;

public class ga {
    private final gv DW;
    private final hc FH;
    private ea<bp> Hw;
    private final cc j6;

    public ga(cc ccVar, gv gvVar, hc hcVar) {
        this.j6 = ccVar;
        this.DW = gvVar;
        this.FH = hcVar;
    }

    public void j6(bv bvVar, String str) {
        int Hw;
        cj DW = this.j6.sh.DW(bvVar, this.DW);
        this.DW.J0().DW(DW);
        this.Hw = new ea(this.j6.cb);
        int lg = DW.lg(DW.Ws());
        for (int i = 0; i < lg; i++) {
            Hw = DW.Hw(DW.Ws(), i);
            if (DW.rN(Hw) == 214) {
                Hw = DW.Hw(Hw, DW.lg(Hw) - 4);
                if (DW.J8(Hw) == 8) {
                    this.Hw.j6((bp) DW.QX(Hw));
                }
            }
        }
        Hw = DW.Hw(DW.Ws(), 0);
        if (DW.lg(Hw) > 0) {
            j6(DW, DW.Ws(), "\n}");
        }
        j6(DW, DW.Ws());
        if (DW.lg(Hw) > 0) {
            j6(DW, Hw, " {\nusing System;\nusing System.IO;\nusing System.Text;\nusing System.Collections.Generic;\n");
            Hw(DW, DW.Hw(Hw, DW.lg(Hw) - 1), "");
            Hw(DW, DW.Hw(Hw, 1), "namespace");
        }
        this.j6.sh.j6(DW);
    }

    private void j6(cj cjVar, int i) {
        String j6;
        int Hw;
        bz DW;
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (cjVar.J8(i) == 27 && cjVar.gW(i) == this.j6.ro.j6("length")) {
                    Hw(cjVar, i, "Length");
                } else if (cjVar.gW(i) == this.j6.ro.j6("out")) {
                    Hw(cjVar, i, "@out");
                } else if (cjVar.gW(i) == this.j6.ro.j6("in")) {
                    Hw(cjVar, i, "@in");
                } else if (cjVar.gW(i) == this.j6.ro.j6("namespace")) {
                    Hw(cjVar, i, "@namespace");
                } else if (cjVar.gW(i) == this.j6.ro.j6("operator")) {
                    Hw(cjVar, i, "@operator");
                } else if (cjVar.gW(i) == this.j6.ro.j6("lock")) {
                    Hw(cjVar, i, "@lock");
                } else if (cjVar.gW(i) == this.j6.ro.j6("string")) {
                    Hw(cjVar, i, "str");
                } else if ((cjVar.J8(i) == 8 || cjVar.J8(i) == 9 || cjVar.J8(i) == 10 || cjVar.J8(i) == 17 || cjVar.J8(i) == 22 || cjVar.J8(i) == 23 || cjVar.J8(i) == 24 || cjVar.J8(i) == 25) && !cjVar.QX(i).tp().DW()) {
                    if (cjVar.gW(i) == this.j6.ro.j6("Reader")) {
                        Hw(cjVar, i, "TextReader");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("ArrayList")) {
                        Hw(cjVar, i, "List");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("Vector")) {
                        Hw(cjVar, i, "List");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("Map")) {
                        Hw(cjVar, i, "Dictionary");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("HashMap")) {
                        Hw(cjVar, i, "Dictionary");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("File")) {
                        Hw(cjVar, i, "Path");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("Long")) {
                        Hw(cjVar, i, "long");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("Integer")) {
                        Hw(cjVar, i, "int");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("StringBuffer")) {
                        Hw(cjVar, i, "StringBuilder");
                    } else if (cjVar.gW(i) == this.j6.ro.j6("InputStream")) {
                        Hw(cjVar, i, "Stream");
                    }
                } else if (cjVar.J8(i) == 20 || cjVar.J8(i) == 19) {
                    j6 = this.j6.ro.j6(cjVar.gW(i));
                    if (j6.length() > 0) {
                        String str = Character.toUpperCase(j6.charAt(0)) + j6.substring(1, j6.length());
                        if (!j6.equals(str)) {
                            Hw(cjVar, i, str);
                        }
                    }
                } else if (cjVar.J8(i) == 16) {
                    bz bzVar = (bz) cjVar.QX(i);
                    if (bzVar.I()) {
                        bs Xa = bzVar.Xa();
                        if (this.Hw.FH(Xa)) {
                            DW(cjVar, i, Xa.eU() + ".");
                        }
                    }
                }
            case 60:
                Hw(cjVar, i, "sbyte");
            case 78:
                if (!cjVar.er(i)) {
                    Hw(cjVar, i, "base");
                }
            case 89:
                Hw(cjVar, i, "bool");
            case 103:
                Hw(cjVar, i, "is");
            case 104:
                Hw(cjVar, i, "lock");
            case 120:
            case 227:
                try {
                    bp j62 = this.j6.cb.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                    j6(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
                    Hw = cjVar.Hw(i, 5);
                    int Hw2 = cjVar.Hw(i, 4);
                    if (cjVar.lg(Hw2) > 0) {
                        if (cjVar.lg(Hw) > 0) {
                            Hw(cjVar, cjVar.Hw(Hw, 0), ",");
                        }
                        Hw(cjVar, cjVar.Hw(Hw2, 0), ":");
                    } else if (cjVar.lg(Hw) > 0) {
                        Hw(cjVar, cjVar.Hw(Hw, 0), ":");
                    }
                    j6(cjVar, cjVar.Hw(i, 3));
                    j6 = "";
                    if (cd.J0(j62.Ev())) {
                        j6 = j6 + "public ";
                    }
                    if (cd.J8(j62.Ev())) {
                        j6 = j6 + "public ";
                    }
                    if (cd.Zo(j62.Ev())) {
                        j6 = j6 + "sealed ";
                    }
                    FH(cjVar, cjVar.Hw(i, 0), j6);
                } catch (ej e) {
                }
            case 124:
                try {
                    DW = this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                    for (Hw = cjVar.lg(i) - 1; Hw >= 1; Hw--) {
                        j6(cjVar, cjVar.Hw(i, Hw));
                    }
                    j6 = "";
                    if (!DW.Xa().g3()) {
                        if (cd.J8(DW.Ev())) {
                            j6 = j6 + "protected ";
                        }
                        if (cd.QX(DW.Ev())) {
                            j6 = j6 + "private ";
                        }
                        if (cd.J0(DW.Ev())) {
                            j6 = j6 + "public ";
                        }
                        if (cd.j6(DW.Ev())) {
                            j6 = j6 + "internal ";
                        }
                        if (cd.aM(DW.Ev())) {
                            j6 = j6 + "static ";
                        }
                        if (cd.XL(DW.Ev())) {
                            j6 = j6 + "abstract ";
                        } else if (DW.dx()) {
                            j6 = j6 + "override ";
                        } else if (!(cd.Zo(DW.Ev()) || cd.aM(DW.Ev()) || cd.QX(DW.Ev()))) {
                            j6 = j6 + "virtual ";
                        }
                    }
                    FH(cjVar, cjVar.Hw(i, 0), j6);
                } catch (ej e2) {
                }
            case 126:
                try {
                    DW = this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.Hw(i, 3)));
                    for (Hw = cjVar.lg(i) - 1; Hw >= 1; Hw--) {
                        j6(cjVar, cjVar.Hw(i, Hw));
                    }
                    j6 = "";
                    if (cd.J8(DW.Ev())) {
                        j6 = j6 + "protected ";
                    }
                    if (cd.QX(DW.Ev())) {
                        j6 = j6 + "private ";
                    }
                    if (cd.J0(DW.Ev())) {
                        j6 = j6 + "public ";
                    }
                    if (cd.j6(DW.Ev())) {
                        j6 = j6 + "internal ";
                    }
                    if (cd.u7(DW.Ev()) && cd.aM(DW.Ev())) {
                        j6 = j6 + "const ";
                    } else if (cd.u7(DW.Ev()) && !cd.aM(DW.Ev())) {
                        j6 = j6 + "readonly ";
                    } else if (cd.aM(DW.Ev())) {
                        j6 = j6 + "static ";
                    }
                    FH(cjVar, cjVar.Hw(i, 0), j6);
                } catch (ej e3) {
                }
            case 180:
                try {
                    if (cjVar.J0(i) && cjVar.we(i) == this.FH.lg(cjVar.we())) {
                        Hw(cjVar, i, "string");
                        return;
                    }
                    for (Hw = cjVar.lg(i) - 1; Hw >= 0; Hw--) {
                        j6(cjVar, cjVar.Hw(i, Hw));
                    }
                } catch (ej e4) {
                }
            case 195:
                Hw(cjVar, i, "");
            case 208:
                if (cjVar.lg(i) > 1) {
                    j6(cjVar, cjVar.Hw(i, 1), cjVar.Hw(i, cjVar.lg(i) - 1), "");
                }
            case 211:
                j6(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
                j6(cjVar, cjVar.Hw(i, cjVar.lg(i) - 3));
                Hw(cjVar, cjVar.Hw(i, cjVar.lg(i) - 4), "in");
                for (Hw = cjVar.lg(i) - 5; Hw >= 1; Hw--) {
                    j6(cjVar, cjVar.Hw(i, Hw));
                }
                Hw(cjVar, cjVar.Hw(i, 0), "foreach");
            case 213:
            case 214:
                Hw(cjVar, i, "");
            case ProxyTextView.INPUTTYPE_textWebPassword /*225*/:
                if (!cjVar.er(i)) {
                    Hw(cjVar, cjVar.Hw(i, 0), "using");
                }
            case 226:
                if (!cjVar.er(i)) {
                    j6(cjVar, cjVar.Hw(i, cjVar.lg(i) - 3), cjVar.Hw(i, cjVar.lg(i) - 2), "");
                    Hw(cjVar, cjVar.Hw(i, 0), "using");
                }
            case 230:
                Hw(cjVar, i, "");
            default:
                for (Hw = cjVar.lg(i) - 1; Hw >= 0; Hw--) {
                    j6(cjVar, cjVar.Hw(i, Hw));
                }
        }
    }

    private void j6(cj cjVar, int i, String str) {
        this.j6.rN.j6(cjVar.we(), cjVar.SI(i), cjVar.ro(i), cjVar.SI(i), cjVar.ro(i), str);
    }

    private void DW(cj cjVar, int i, String str) {
        this.j6.rN.j6(cjVar.we(), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), str);
    }

    private void j6(cj cjVar, int i, int i2, String str) {
        this.j6.rN.j6(cjVar.we(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i2), cjVar.ro(i2), str);
    }

    private void FH(cj cjVar, int i, String str) {
        if (!(cjVar.nw(i) == cjVar.SI(i) && cjVar.KD(i) == cjVar.ro(i))) {
            str = str.trim();
        }
        Hw(cjVar, i, str);
    }

    private void Hw(cj cjVar, int i, String str) {
        if (!cjVar.er(i)) {
            this.j6.rN.j6(cjVar.we(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), str);
        }
    }
}
