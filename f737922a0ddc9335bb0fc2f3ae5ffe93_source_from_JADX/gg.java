import com.aide.uidesigner.ProxyTextView;

public class gg implements be {
    private final by DW;
    private final bt FH;
    private final gv Hw;
    private final cc j6;

    public gg(cc ccVar, gv gvVar) {
        this.j6 = ccVar;
        this.DW = ccVar.ro;
        this.FH = ccVar.cb;
        this.Hw = gvVar;
    }

    public String j6(bs bsVar) {
        if (bsVar.fY()) {
            switch (((co) bsVar).Gj()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    return "void";
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    return "null";
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    return "byte";
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    return "ubyte";
                case 5:
                    return "short";
                case 7:
                    return "int";
                case 9:
                    return "long";
                case 11:
                    return "boolean";
                case 12:
                    return "char";
                case 13:
                    return "float";
                case 14:
                    return "double";
            }
        }
        String str;
        if (bsVar.AL()) {
            String str2 = "";
            co coVar = (co) bsVar;
            while (coVar.AL()) {
                int DW = ((bo) coVar).DW();
                str2 = str2 + "[";
                for (int i = 1; i < DW; i++) {
                    str2 = str2 + ",";
                }
                str = str2 + "]";
                coVar = ((bo) coVar).FH();
                str2 = str;
            }
            return coVar.eU() + str2;
        } else if (bsVar.cT()) {
            r0 = "";
            bsVar = (bp) bsVar;
            while (true) {
                str = bsVar.br() + r0;
                bs Xa = bsVar.Xa();
                if (Xa == bsVar) {
                    return str;
                }
                bsVar = Xa;
                r0 = "." + str;
            }
        } else if (bsVar.zh()) {
            return this.DW.j6(bsVar.aq());
        } else {
            if (bsVar.Z1()) {
                return this.DW.j6(bsVar.aq());
            }
            if (bsVar.q7()) {
                return this.DW.j6(bsVar.aq());
            }
            if (bsVar.k2()) {
                return ((cb) bsVar).j6().eU() + "?";
            }
            if (bsVar.n5()) {
                bp gn = ((cf) bsVar).gn();
                int kQ = gn.kQ() - 1;
                Object obj = 1;
                bp bpVar = gn;
                str = "";
                while (true) {
                    Object obj2;
                    int XX = bpVar.XX();
                    if (obj != null && XX > 0) {
                        int i2 = XX - 1;
                        String str3 = str;
                        int i3 = kQ;
                        while (i2 >= 0) {
                            str = "";
                            if (((cf) bsVar).FH()[i3] == 2) {
                                str = "? extends ";
                            }
                            if (((cf) bsVar).FH()[i3] == 3) {
                                str = "? super ";
                            }
                            str = str + ((cf) bsVar).DW()[i3].eU();
                            if (((cf) bsVar).FH()[i3] == 1) {
                                r0 = "?";
                            } else {
                                r0 = str;
                            }
                            if (i2 < XX - 1) {
                                r0 = r0 + ", " + str3;
                            } else {
                                r0 = r0 + ">" + str3;
                            }
                            i3--;
                            i2--;
                            str3 = r0;
                        }
                        str = "<" + str3;
                        kQ = i3;
                    }
                    String str4 = bpVar.br() + str;
                    if (bpVar.we()) {
                        obj2 = obj;
                    } else {
                        obj2 = null;
                    }
                    bp Xa2 = bpVar.Xa();
                    if (Xa2 == bpVar) {
                        return str4;
                    }
                    bpVar = Xa2;
                    Object obj3 = obj2;
                    str = "." + str4;
                    obj = obj3;
                }
            } else if (bsVar.w9()) {
                return ((ch) bsVar).j6().eU() + "*";
            } else {
                if (bsVar.qp()) {
                    return this.DW.j6(((ce) bsVar).aq());
                }
                return "";
            }
        }
    }

    public String DW(bs bsVar) {
        int i = 0;
        if (bsVar.fY()) {
            switch (((co) bsVar).Gj()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    return "void";
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    return "null";
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    return "byte";
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    return "ubyte";
                case 5:
                    return "short";
                case 7:
                    return "int";
                case 9:
                    return "long";
                case 11:
                    return "boolean";
                case 12:
                    return "char";
                case 13:
                    return "float";
                case 14:
                    return "double";
            }
        }
        int DW;
        int i2;
        String str;
        if (bsVar.AL()) {
            String str2 = "";
            co coVar = (co) bsVar;
            while (coVar.AL()) {
                DW = ((bo) coVar).DW();
                str2 = str2 + "[";
                for (i2 = 1; i2 < DW; i2++) {
                    str2 = str2 + ",";
                }
                str = str2 + "]";
                coVar = ((bo) coVar).FH();
                str2 = str;
            }
            return coVar.iW() + str2;
        } else if (bsVar.cT()) {
            if (!((bp) bsVar).hz()) {
                return ((bp) bsVar).Xa().iW() + "." + ((bp) bsVar).br();
            }
            ce rN = ((bp) bsVar).rN();
            if (rN.Zo()) {
                return ((bp) bsVar).br();
            }
            return rN.iW() + "." + ((bp) bsVar).br();
        } else if (bsVar.zh() && ((bz) bsVar).u7()) {
            return bsVar.Xa().iW() + "." + this.DW.j6(bsVar.aq());
        } else {
            String str3;
            if (bsVar.zh() && ((bz) bsVar).gn()) {
                String str4;
                str = bsVar.Xa().j3().iW();
                if (((bz) bsVar).aj()) {
                    str = str + ".this";
                } else {
                    str = str + "." + this.DW.j6(bsVar.aq());
                }
                if (((bz) bsVar).OW() > 0) {
                    str4 = str + "<";
                    for (i2 = 0; i2 < ((bz) bsVar).OW(); i2++) {
                        str4 = str4 + ((bz) bsVar).gn(i2).eU();
                        if (i2 < ((bz) bsVar).OW() - 1) {
                            str4 = str4 + ", ";
                        }
                    }
                    str = str4 + ">";
                }
                if (((bz) bsVar).aj()) {
                    str3 = str + "[";
                } else {
                    str3 = str + "(";
                }
                str = str3;
                while (i < ((bz) bsVar).lp()) {
                    if (i > 0) {
                        str = str + ", ";
                    }
                    str4 = str + j6(((bz) bsVar).VH(i));
                    try {
                        co v5 = ((bz) bsVar).v5(i);
                        if (i == ((bz) bsVar).lp() - 1) {
                            if (((bz) bsVar).sh()) {
                                if (v5.AL()) {
                                    v5 = ((bo) v5).FH();
                                }
                                str3 = str4 + v5.iW() + " ... ";
                                i++;
                                str = str3;
                            }
                        }
                        str3 = str4 + v5.iW();
                    } catch (ej e) {
                        str3 = str4 + "?";
                    }
                    i++;
                    str = str3;
                }
                if (((bz) bsVar).aj()) {
                    return str + "]";
                }
                return str + ")";
            } else if (bsVar.Z1()) {
                return this.DW.j6(((ca) bsVar).aq());
            } else {
                if (bsVar.q7()) {
                    return this.DW.j6(((cg) bsVar).aq());
                }
                if (bsVar.k2()) {
                    return ((cb) bsVar).j6().eU() + "?";
                }
                if (bsVar.n5()) {
                    bp gn = ((cf) bsVar).gn();
                    int kQ = gn.kQ() - 1;
                    int i3 = 1;
                    bp bpVar = gn;
                    str = "";
                    while (true) {
                        int XX = bpVar.XX();
                        if (i3 != 0 && XX > 0) {
                            int i4 = XX - 1;
                            String str5 = str;
                            DW = kQ;
                            while (i4 >= 0) {
                                str = "";
                                if (((cf) bsVar).FH()[DW] == 2) {
                                    str = "? extends ";
                                }
                                if (((cf) bsVar).FH()[DW] == 3) {
                                    str = "? super ";
                                }
                                str = str + ((cf) bsVar).DW()[DW].iW();
                                if (((cf) bsVar).FH()[DW] == 1) {
                                    str3 = "?";
                                } else {
                                    str3 = str;
                                }
                                if (i4 < XX - 1) {
                                    str3 = str3 + ", " + str5;
                                } else {
                                    str3 = str3 + ">" + str5;
                                }
                                DW--;
                                i4--;
                                str5 = str3;
                            }
                            str = "<" + str5;
                            kQ = DW;
                        }
                        String str6 = bpVar.br() + str;
                        if (bpVar.we()) {
                            i2 = i3;
                        } else {
                            i2 = 0;
                        }
                        bp Xa = bpVar.Xa();
                        if (Xa != bpVar) {
                            bpVar = Xa;
                            int i5 = i2;
                            str = "." + str6;
                            i3 = i5;
                        } else if (bpVar.rN().Zo()) {
                            return str6;
                        } else {
                            return bpVar.rN().iW() + "." + str6;
                        }
                    }
                } else if (bsVar.w9()) {
                    return ((ch) bsVar).j6().iW() + "*";
                } else {
                    if (!bsVar.qp()) {
                        return "";
                    }
                    if (((ce) bsVar).Zo()) {
                        return "";
                    }
                    if (((ce) bsVar).FH().Zo()) {
                        return this.DW.j6(bsVar.aq());
                    }
                    return ((ce) bsVar).FH().iW() + "." + this.DW.j6(bsVar.aq());
                }
            }
        }
    }

    public String j6(cp cpVar) {
        return (((cpVar.j6().j6() + "<br>") + "<code>") + "<font color=\"#0000EE\">" + j6(j6(cpVar.gn())) + "" + "</font>" + "") + " " + this.j6.ro.j6(cpVar.VH()) + "</code>";
    }

    public String FH(bs bsVar) {
        String str;
        int i = 0;
        String str2 = "";
        if (bsVar.qp()) {
            str = ((str2 + bsVar.Hw().j6() + "<br>") + "<code>") + "<b><font color=\"#2A50D0\">package </font></b><i><font color=\"#202020\">" + bsVar.iW() + "</font></i>";
        } else if (bsVar.cT()) {
            str2 = ((str2 + bsVar.Hw().j6() + "<br>") + "<code>") + "<b><font color=\"#2A50D0\">" + j6(bsVar.Ev()) + "" + "</font></b>" + "";
            if (((bp) bsVar).I()) {
                str2 = str2 + "<b><font color=\"#2A50D0\">delegate </font></b>";
                try {
                    str = str2 + "<font color=\"#0000EE\">" + j6(j6(((bp) bsVar).U2())) + "" + "</font>" + " ";
                } catch (ej e) {
                    str = str2 + "??? ";
                }
                str2 = str + "<font color=\"#0000EE\">" + ((bp) bsVar).br() + "" + "</font>" + "";
                r4 = ((bp) bsVar).XX();
                if (r4 > 0) {
                    str2 = str2 + "<font color=\"#0000EE\">&lt;</font>";
                    while (i < r4) {
                        try {
                            str = str2 + "<font color=\"#0000EE\">" + j6(((bp) bsVar).j6(i)) + "" + "</font>" + "";
                        } catch (ej e2) {
                            str = str2;
                        }
                        if (i < r4 - 1) {
                            str = str + "<font color=\"#0000EE\">, </font>";
                        }
                        i++;
                        str2 = str;
                    }
                    str = str2 + "<font color=\"#0000EE\">&gt;</font>";
                } else {
                    str = str2;
                }
                str2 = str + "<font color=\"#0000EE\">()</font>";
            } else {
                if (((bp) bsVar).g3()) {
                    str = str2 + "<b><font color=\"#2A50D0\">interface </font></b>";
                } else if (((bp) bsVar).ca()) {
                    str = str2 + "<b><font color=\"#2A50D0\">struct </font></b>";
                } else if (((bp) bsVar).Mz()) {
                    str = str2 + "<b><font color=\"#2A50D0\">enum </font></b>";
                } else {
                    str = str2 + "<b><font color=\"#2A50D0\">class </font></b>";
                }
                str2 = str + "<font color=\"#0000EE\">" + ((bp) bsVar).br() + "" + "</font>" + "";
                int XX = ((bp) bsVar).XX();
                if (XX > 0) {
                    str2 = str2 + "<font color=\"#0000EE\">&lt;</font>";
                    r5 = 0;
                    while (r5 < XX) {
                        try {
                            str = str2 + "<font color=\"#0000EE\">" + j6(((bp) bsVar).j6(r5)) + "" + "</font>" + "";
                        } catch (ej e3) {
                            str = str2;
                        }
                        if (r5 < XX - 1) {
                            str = str + "<font color=\"#0000EE\">, </font>";
                        }
                        r5++;
                        str2 = str;
                    }
                    str2 = str2 + "<font color=\"#0000EE\">&gt; </font>";
                }
                if (!((bp) bsVar).Mz()) {
                    r5 = ((bp) bsVar).WB();
                    if (!((bp) bsVar).g3()) {
                        if (r5 > 0) {
                            try {
                                if (((bp) bsVar).v5(0) != this.Hw.we().v5(bsVar.tp())) {
                                    str = (str2 + "<b><font color=\"#2A50D0\"> extends </font></b>") + "<font color=\"#0000EE\">" + j6(j6(((bp) bsVar).v5(0))) + "</font>";
                                    if (r5 > 1) {
                                        try {
                                            str = str + "<b><font color=\"#2A50D0\"> implements </font></b>";
                                            i = 1;
                                            while (i < r5) {
                                                if (i <= 1) {
                                                    str2 = str + "<font color=\"#0000EE\">, </font>";
                                                } else {
                                                    str2 = str;
                                                }
                                                str2 = str2 + "<font color=\"#0000EE\">" + j6(j6(((bp) bsVar).v5(i))) + "</font>";
                                                i++;
                                                str = str2;
                                            }
                                        } catch (ej e4) {
                                            str2 = str;
                                        }
                                    }
                                    str2 = str;
                                }
                            } catch (ej e5) {
                            }
                        }
                        str = str2;
                        if (r5 > 1) {
                            str = str + "<b><font color=\"#2A50D0\"> implements </font></b>";
                            i = 1;
                            while (i < r5) {
                                if (i <= 1) {
                                    str2 = str;
                                } else {
                                    str2 = str + "<font color=\"#0000EE\">, </font>";
                                }
                                str2 = str2 + "<font color=\"#0000EE\">" + j6(j6(((bp) bsVar).v5(i))) + "</font>";
                                i++;
                                str = str2;
                            }
                        }
                        str2 = str;
                    } else if (r5 > 0) {
                        try {
                            if (((bp) bsVar).v5(0) != this.Hw.we().v5(bsVar.tp())) {
                                str2 = str2 + "<b><font color=\"#2A50D0\"> extends </font></b>";
                                while (i < r5) {
                                    if (i > 0) {
                                        str2 = str2 + "<font color=\"#0000EE\">, </font>";
                                    }
                                    str2 = str2 + "<font color=\"#0000EE\">" + j6(j6(((bp) bsVar).v5(i))) + "</font>";
                                    i++;
                                }
                            }
                        } catch (ej e6) {
                        }
                    }
                }
            }
            if (((bp) bsVar).hz()) {
                ce rN = ((bp) bsVar).rN();
                if (!rN.Zo()) {
                    str2 = (str2 + "<p>") + "<b><font color=\"#2A50D0\">package </font></b><i><font color=\"#202020\">" + rN.iW() + "</font></i>";
                }
            } else {
                str = str2 + "<p>";
                r2 = bsVar.Xa();
                if (r2.g3()) {
                    str = str + "<b><font color=\"#2A50D0\">interface </font></b>";
                } else if (r2.ca()) {
                    str = str + "<b><font color=\"#2A50D0\">struct </font></b>";
                } else if (r2.Mz()) {
                    str = str + "<b><font color=\"#2A50D0\">enum </font></b>";
                } else {
                    str = str + "<b><font color=\"#2A50D0\">class </font></b>";
                }
                str2 = str + "<font color=\"#0000EE\">" + j6(j6(r2.j3())) + "</font>";
            }
            str = str2;
        } else if (bsVar.zh() && ((bz) bsVar).u7()) {
            str2 = ((str2 + bsVar.Hw().j6() + "<br>") + "<code>") + "<b><font color=\"#2A50D0\">" + j6(bsVar.Ev()) + "" + "</font></b>" + "";
            try {
                str = str2 + "<font color=\"#0000EE\">" + j6(j6(((bz) bsVar).Mz())) + " " + "</font>" + "";
            } catch (ej e7) {
                str = str2 + "<font color=\"#0000EE\">? </font>";
            }
            str2 = str + j6(bsVar);
            if (((bz) bsVar).J0()) {
                str2 = str2 + "<font color=\"#0000EE\"> { ";
                if (((bz) bsVar).QX()) {
                    str2 = str2 + "<b><font color=\"#2A50D0\">get </font></b>";
                }
                if (((bz) bsVar).Ws()) {
                    str2 = str2 + "<b><font color=\"#2A50D0\">set </font></b>";
                }
                str = str2 + "}</font>";
            } else {
                str = str2;
            }
            str = str + "<p>";
            r2 = ((bz) bsVar).Xa();
            if (r2.g3()) {
                str = str + "<b><font color=\"#2A50D0\">interface </font></b>";
            } else if (r2.Mz()) {
                str = str + "<b><font color=\"#2A50D0\">enum </font></b>";
            } else if (r2.ca()) {
                str = str + "<b><font color=\"#2A50D0\">struct </font></b>";
            } else {
                str = str + "<b><font color=\"#2A50D0\">class </font></b>";
            }
            str = str + "<font color=\"#0000EE\">" + j6(j6(r2.j3())) + "</font>";
            r2 = r2.rN();
            if (!r2.Zo()) {
                str = (str + "<br>") + "<b><font color=\"#2A50D0\">package </font></b><i><font color=\"#202020\">" + r2.iW() + "</font></i>";
            }
        } else if (bsVar.zh() && ((bz) bsVar).gn()) {
            str2 = ((str2 + bsVar.Hw().j6() + "<br>") + "<code>") + "<b><font color=\"#2A50D0\">" + j6(bsVar.Ev()) + "" + "</font></b>" + "";
            if (!((bz) bsVar).sy()) {
                try {
                    str2 = str2 + "<font color=\"#0000EE\">" + j6(j6(((bz) bsVar).Mz())) + " " + "</font>" + "";
                } catch (ej e8) {
                    str2 = str2 + "<font color=\"#0000EE\">? </font>";
                }
            }
            if (((bz) bsVar).sy()) {
                str2 = str2 + "<font color=\"#0000EE\">" + j6(bsVar) + "</font>";
            } else {
                str2 = str2 + j6(bsVar);
            }
            r5 = ((bz) bsVar).OW();
            if (r5 > 0) {
                int i2 = 0;
                String str3 = str2 + "<font color=\"#0000EE\">&lt;</font>";
                while (i2 < r5) {
                    str = str3 + "<font color=\"#0000EE\">" + j6(((bz) bsVar).gn(i2)) + "" + "</font>" + "";
                    if (i2 < r5 - 1) {
                        str = str + "<font color=\"#0000EE\">, </font>";
                    }
                    i2++;
                    str3 = str;
                }
                str2 = str3 + "<font color=\"#0000EE\">&gt;</font>";
            }
            str2 = str2 + "<font color=\"#0000EE\">(</font>";
            r5 = ((bz) bsVar).lp();
            str = str2;
            for (r4 = 0; r4 < r5; r4++) {
                String str4 = str + "<b><font color=\"#2A50D0\">" + j6(((bz) bsVar).VH(r4)) + "</font></b>";
                try {
                    bs v5 = ((bz) bsVar).v5(r4);
                    if (r4 == r5 - 1) {
                        if (((bz) bsVar).sh()) {
                            if (((bz) bsVar).OW() == 0) {
                                if (v5.AL()) {
                                    v5 = ((bo) v5).FH();
                                }
                                str = str4 + "<font color=\"#0000EE\">" + j6(j6(v5)) + " ... " + "</font>" + "";
                                str = str + this.DW.j6(((bz) bsVar).Zo(r4));
                                if (r4 < r5 - 1) {
                                    str = str + "<font color=\"#0000EE\">, </font>";
                                }
                            }
                        }
                    }
                    str = str4 + "<font color=\"#0000EE\">" + j6(j6(v5)) + " " + "</font>" + "";
                } catch (ej e9) {
                    str = str4 + "<font color=\"#0000EE\">? </font>";
                }
                str = str + this.DW.j6(((bz) bsVar).Zo(r4));
                if (r4 < r5 - 1) {
                    str = str + "<font color=\"#0000EE\">, </font>";
                }
            }
            str2 = str + "<font color=\"#0000EE\">) </font>";
            r4 = ((bz) bsVar).rN();
            if (r4 > 0) {
                str = str2 + " <b><font color=\"#2A50D0\">throws</font></b> ";
                while (i < r4) {
                    if (i > 0) {
                        str2 = str + "<font color=\"#0000EE\">, </font>";
                    } else {
                        str2 = str;
                    }
                    try {
                        str = str2 + "<font color=\"#0000EE\">" + j6(j6(((bz) bsVar).DW(i))) + "</font>";
                    } catch (ej e10) {
                        str = str2 + "<font color=\"#0000EE\">?</font>";
                    }
                    i++;
                }
            } else {
                str = str2;
            }
            str = str + "<p>";
            r2 = ((bz) bsVar).Xa();
            if (r2.g3()) {
                str = str + "<b><font color=\"#2A50D0\">interface </font></b>";
            } else if (r2.Mz()) {
                str = str + "<b><font color=\"#2A50D0\">enum </font></b>";
            } else if (r2.ca()) {
                str = str + "<b><font color=\"#2A50D0\">struct </font></b>";
            } else {
                str = str + "<b><font color=\"#2A50D0\">class </font></b>";
            }
            str = str + "<font color=\"#0000EE\">" + j6(j6(r2.j3())) + "</font>";
            r2 = r2.rN();
            if (!r2.Zo()) {
                str = (str + "<br>") + "<b><font color=\"#2A50D0\">package </font></b><i><font color=\"#202020\">" + r2.iW() + "</font></i>";
            }
        } else if (bsVar.Z1() || bsVar.q7()) {
            str = ((str2 + bsVar.Hw().j6() + "<br>") + "<code>") + j6(bsVar);
        } else {
            str = str2;
        }
        return str + "</code>";
    }

    private String j6(String str) {
        while (true) {
            int indexOf = str.indexOf(60);
            if (indexOf == -1) {
                break;
            }
            str = str.substring(0, indexOf) + "&lt;" + str.substring(indexOf + 1, str.length());
        }
        while (true) {
            indexOf = str.indexOf(62);
            if (indexOf == -1) {
                return str;
            }
            str = str.substring(0, indexOf) + "&gt;" + str.substring(indexOf + 1, str.length());
        }
    }

    public String j6(int i) {
        String str = "";
        if ((i & 1) != 0) {
            str = str + "public ";
        }
        if ((i & 4) != 0) {
            str = str + "private ";
        }
        if ((i & 8) != 0) {
            str = str + "protected ";
        }
        if ((i & 64) != 0) {
            str = str + "static ";
        }
        if ((i & 512) != 0) {
            str = str + "final ";
        }
        if ((i & 256) != 0) {
            str = str + "final ";
        }
        if ((i & 128) != 0) {
            str = str + "final ";
        }
        if ((i & 1024) != 0) {
            str = str + "volatile ";
        }
        if ((i & 4096) != 0) {
            str = str + "transient ";
        }
        if ((524288 & i) != 0) {
            str = str + "native ";
        }
        if ((i & 16384) != 0) {
            str = str + "abstract ";
        }
        if ((i & 8192) != 0) {
            return str + "strictfp ";
        }
        return str;
    }

    public String j6(co coVar) {
        if (coVar == null) {
            return "null";
        }
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return "";
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return "0";
            case 11:
                return "false";
            default:
                return "null";
        }
    }
}
