import com.aide.uidesigner.ProxyTextView;
import java.util.StringTokenizer;

public class gr implements bg {
    private final cl DW;
    private final bt FH;
    private final by Hw;
    private final gv VH;
    private final hc Zo;
    private final bh gn;
    private final bw j6;
    private final cc v5;

    public gr(cc ccVar, gv gvVar, bh bhVar) {
        this.v5 = ccVar;
        this.j6 = ccVar.cn;
        this.DW = ccVar.sh;
        this.FH = ccVar.cb;
        this.Hw = ccVar.ro;
        this.Zo = gvVar.we();
        this.VH = gvVar;
        this.gn = bhVar;
    }

    public bz j6(bv bvVar, int i, int i2) {
        cj DW = this.DW.DW(bvVar, this.VH);
        int QX = DW.QX(i, i2);
        if (QX != -1) {
            try {
                return this.FH.DW(bvVar, this.VH, DW.XL(QX));
            } catch (ej e) {
            }
        }
        this.DW.j6(DW);
        throw new ej();
    }

    public bp j6(String str) {
        String str2 = "";
        if (str.lastIndexOf(46) != -1) {
            str2 = str.substring(0, str.lastIndexOf(46));
        }
        if (str.indexOf(36) != -1) {
            str = str.substring(0, str.lastIndexOf(36));
        }
        ce Zo = this.FH.Zo();
        StringTokenizer stringTokenizer = new StringTokenizer(str2, ".");
        ce ceVar = Zo;
        while (stringTokenizer.hasMoreTokens()) {
            ceVar = ceVar.j6(this.Hw.j6(stringTokenizer.nextToken()));
        }
        dr gn = ceVar.gn();
        gn.j6.j6();
        while (gn.j6.DW()) {
            bp bpVar = (bp) gn.j6.Hw();
            if ((bpVar.Hw() instanceof gv) && bpVar.tp().BT() == this.gn && bpVar.tp().BT().tp() != null && j6(bpVar).equals(r7)) {
                return bpVar;
            }
        }
        throw new ej();
    }

    public bz j6(String str, String str2, String str3) {
        String substring;
        boolean z;
        String str4;
        String substring2;
        if (str.endsWith("$0$debug")) {
            substring = str.substring(0, str.length() - 8);
            if (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            z = true;
            str4 = str2;
        } else {
            z = false;
            str4 = str2;
            substring = str;
        }
        if (substring.indexOf(36) != -1) {
            substring2 = substring.substring(0, substring.indexOf(36));
        } else {
            substring2 = substring;
        }
        bv tp = j6(substring2).tp();
        if (tp.BT() == this.gn) {
            cj DW = this.DW.DW(tp, this.VH);
            bz j6 = j6(DW, DW.Ws(), substring, str4, str3, z);
            this.DW.j6(DW);
            if (j6 != null) {
                return j6;
            }
        }
        throw new ej();
    }

    public String j6(bs bsVar) {
        return ((gq) bsVar.tp().BT().u7()).DW(bsVar);
    }

    public String FH(bs bsVar) {
        return ((gq) bsVar.tp().BT().u7()).Hw(bsVar);
    }

    public String Hw(bs bsVar) {
        return ((gq) bsVar.tp().BT().u7()).FH(bsVar);
    }

    public String DW(bs bsVar) {
        return ((gq) bsVar.tp().BT().u7()).j6(bsVar);
    }

    public String j6(bp bpVar) {
        return ((gq) bpVar.tp().BT().u7()).j6(bpVar);
    }

    private bz j6(cj cjVar, int i, String str, String str2, String str3, boolean z) {
        bs DW;
        if (cjVar.rN(i) == 124) {
            try {
                DW = this.FH.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                bp Xa = DW.Xa();
                if (DW(DW).equals(str2) && j6(Xa).equals(str)) {
                    if (z) {
                        if (!DW.I()) {
                            String j6 = j6(DW);
                            if (("(L" + j6(DW.Xa()) + ";" + j6.substring(1, j6.length())).equals(str3)) {
                                return DW;
                            }
                        } else if (j6(DW).equals(str3)) {
                            return DW;
                        }
                    } else if (j6(DW).equals(str3)) {
                        return DW;
                    }
                }
            } catch (ej e) {
            }
        }
        if (cjVar.rN(i) == 123 && str2.equals("<init>")) {
            try {
                DW = this.FH.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                if (j6(DW.Xa()).equals(str) && j6(DW).equals(str3)) {
                    return DW;
                }
            } catch (ej e2) {
            }
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            bz j62 = j6(cjVar, cjVar.Hw(i, i2), str, str2, str3, z);
            if (j62 != null) {
                return j62;
            }
        }
        return null;
    }

    public void j6(bv bvVar, int i, int i2, String str) {
        cj j6 = this.DW.j6(bvVar, this.VH, i, i2, str);
        if (j6 != null) {
            int J8 = j6.J8(i, i2);
            if (J8 != -1) {
                j6.tp().u7().FH(j6, J8);
                j6(j6, J8);
            }
        }
    }

    private void j6(cj cjVar, int i) {
        if (!cjVar.u7(i)) {
            int Hw;
            bz bzVar;
            switch (cjVar.rN(i)) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.v5.BT.j6(new String(cjVar.j3(i), cjVar.Mr(i) + 1, cjVar.U2(i) - 2));
                    return;
                case 66:
                    this.v5.BT.j6(null);
                    return;
                case 155:
                    Hw = cjVar.Hw(i, cjVar.lg(i) - 2);
                    if (cjVar.J8(Hw) == 20) {
                        bzVar = (bz) cjVar.QX(Hw);
                        if (bzVar.I()) {
                            this.v5.BT.j6(null);
                            j6(cjVar, i, bzVar);
                            DW(bzVar);
                            return;
                        }
                        j6(cjVar, cjVar.Hw(i, 0));
                        j6(cjVar, i, bzVar);
                        DW(bzVar);
                        return;
                    }
                    break;
                case 156:
                    int Hw2 = cjVar.Hw(i, cjVar.lg(i) - 2);
                    if (cjVar.J8(Hw2) == 20) {
                        bzVar = (bz) cjVar.QX(Hw2);
                        if (bzVar.I()) {
                            this.v5.BT.j6(null);
                            j6(cjVar, i, bzVar);
                            DW(bzVar);
                            return;
                        } else if (cjVar.lg(i) == 2) {
                            j6(cjVar, i, (bp) cjVar.EQ(Hw2).a_());
                            j6(cjVar, i, bzVar);
                            DW(bzVar);
                            return;
                        } else {
                            j6(cjVar, i, cjVar.lg(i) - 5);
                            j6(cjVar, i, bzVar);
                            DW(bzVar);
                            return;
                        }
                    }
                    break;
                case 159:
                    Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
                    if (cjVar.J8(Hw) == 16) {
                        bzVar = (bz) cjVar.QX(Hw);
                        if (bzVar.I()) {
                            j6(bzVar);
                            return;
                        }
                        j6(cjVar, cjVar.Hw(i, 0));
                        j6(bzVar);
                        return;
                    }
                    break;
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    j6(cjVar, i, cjVar.lg(i) - 1);
                    return;
                case 165:
                    j6(cjVar, cjVar.Hw(i, 0));
                    j6(cjVar, cjVar.Hw(i, 2));
                    j6(cjVar.we(), cjVar.we(cjVar.Hw(i, 2)), this.Zo.J0());
                    this.v5.BT.j6();
                    return;
                case 166:
                    if (cjVar.lg(i) == 1) {
                        this.v5.BT.FH("this");
                        return;
                    } else {
                        j6(cjVar, i, (bp) cjVar.we(cjVar.Hw(i, 0)));
                        return;
                    }
                case 168:
                    j6(cjVar, cjVar.Hw(i, 1));
                    return;
                case 169:
                    j6(cjVar, cjVar.Hw(i, 4));
                    j6(cjVar.we(), cjVar.we(cjVar.Hw(i, 4)), cjVar.we(i));
                    return;
                case 170:
                    switch (cjVar.rN(cjVar.Hw(i, 0))) {
                        case 21:
                        case 24:
                        case 27:
                        case 34:
                            j6(cjVar, cjVar.Hw(i, 1));
                            this.v5.BT.j6(cjVar.tp().Hw().XL(cjVar.rN(cjVar.Hw(i, 0))));
                            return;
                        default:
                            break;
                    }
                case 172:
                    co we = cjVar.we(i);
                    int Hw3 = cjVar.Hw(i, 0);
                    co we2 = cjVar.we(Hw3);
                    int Hw4 = cjVar.Hw(i, 2);
                    co we3 = cjVar.we(Hw4);
                    co j6;
                    switch (cjVar.rN(cjVar.Hw(i, 1))) {
                        case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        case 35:
                            if (this.Zo.j6(we2) || this.Zo.j6(we3)) {
                                j6 = this.Zo.j6(cjVar.we(), 9, we2, we3);
                                j6(cjVar, Hw3);
                                j6(cjVar.we(), we2, j6);
                                j6(cjVar, Hw4);
                                j6(cjVar.we(), we3, j6);
                                this.v5.BT.DW(cjVar.tp().Hw().XL(cjVar.rN(cjVar.Hw(i, 1))));
                                return;
                            }
                            j6(cjVar, Hw3);
                            j6(cjVar, Hw4);
                            this.v5.BT.DW(cjVar.tp().Hw().XL(cjVar.rN(cjVar.Hw(i, 1))));
                            return;
                        case 19:
                        case 21:
                        case 27:
                        case 30:
                        case 32:
                        case ProxyTextView.INPUTTYPE_time /*36*/:
                        case 38:
                        case 41:
                        case 46:
                        case 50:
                        case 51:
                            if (we.Gj() != 16) {
                                switch (cjVar.rN(cjVar.Hw(i, 1))) {
                                    case 46:
                                    case 47:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                        j6 = this.Zo.J0();
                                        break;
                                    default:
                                        j6 = we;
                                        break;
                                }
                                j6(cjVar, Hw3);
                                j6(cjVar.we(), we2, we);
                                j6(cjVar, Hw4);
                                j6(cjVar.we(), we3, j6);
                                this.v5.BT.DW(cjVar.tp().Hw().XL(cjVar.rN(cjVar.Hw(i, 1))));
                                return;
                            }
                            break;
                        case 39:
                        case 42:
                            j6(cjVar, Hw3);
                            j6(cjVar, Hw4);
                            this.v5.BT.DW(cjVar.tp().Hw().XL(cjVar.rN(cjVar.Hw(i, 1))));
                            return;
                        case 44:
                        case 45:
                        case 48:
                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                            j6 = this.Zo.j6(cjVar.we(), 11, we2, we3);
                            j6(cjVar, Hw3);
                            j6(cjVar.we(), we2, j6);
                            j6(cjVar, Hw4);
                            j6(cjVar.we(), we3, j6);
                            this.v5.BT.DW(cjVar.tp().Hw().XL(cjVar.rN(cjVar.Hw(i, 1))));
                            return;
                        default:
                            break;
                    }
                default:
                    break;
            }
        }
        switch (cjVar.we(i).Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                this.v5.BT.j6(new Byte((byte) this.FH.v5(cjVar.gn(i))));
                return;
            case 5:
                this.v5.BT.j6(new Short((short) this.FH.v5(cjVar.gn(i))));
                return;
            case 7:
                this.v5.BT.j6(new Integer(this.FH.v5(cjVar.gn(i))));
                return;
            case 9:
                this.v5.BT.j6(new Long(this.FH.VH(cjVar.gn(i))));
                return;
            case 11:
                this.v5.BT.j6(new Boolean(this.FH.DW(cjVar.gn(i))));
                return;
            case 12:
                this.v5.BT.j6(new Character((char) this.FH.v5(cjVar.gn(i))));
                return;
            case 13:
                this.v5.BT.j6(new Float(this.FH.Hw(cjVar.gn(i))));
                return;
            case 14:
                this.v5.BT.j6(new Double(this.FH.FH(cjVar.gn(i))));
                return;
        }
        throw new ej();
    }

    private void j6(bv bvVar, co coVar, co coVar2) {
        Class cls = null;
        if (coVar2 != coVar && this.Zo.j6(coVar) == this.Zo.j6(coVar2) && coVar.DW(bvVar, this.VH, coVar2)) {
            Class cls2;
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    cls2 = Byte.TYPE;
                    break;
                case 5:
                    cls2 = Short.TYPE;
                    break;
                case 7:
                    cls2 = Integer.TYPE;
                    break;
                case 9:
                    cls2 = Long.TYPE;
                    break;
                case 12:
                    cls2 = Character.TYPE;
                    break;
                case 13:
                    cls2 = Float.TYPE;
                    break;
                case 14:
                    cls2 = Double.TYPE;
                    break;
                default:
                    cls2 = null;
                    break;
            }
            switch (coVar2.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    cls = Byte.TYPE;
                    break;
                case 5:
                    cls = Short.TYPE;
                    break;
                case 7:
                    cls = Integer.TYPE;
                    break;
                case 9:
                    cls = Long.TYPE;
                    break;
                case 12:
                    cls = Character.TYPE;
                    break;
                case 13:
                    cls = Float.TYPE;
                    break;
                case 14:
                    cls = Double.TYPE;
                    break;
            }
            if (cls2 != null && cls != null) {
                this.v5.BT.j6(cls2, cls);
            }
        }
    }

    private void j6(cj cjVar, int i, int i2) {
        int Hw = cjVar.Hw(i, i2);
        if (cjVar.J8(Hw) == 2) {
            this.v5.BT.FH(cjVar.BT(Hw));
        } else if (cjVar.J8(Hw) == 3) {
            bp DW = DW(cjVar, i);
            this.v5.BT.FH("this");
            this.v5.BT.j6(false, true, j6(DW), "val$" + cjVar.BT(Hw));
        } else if (i2 > 0 && cjVar.J8(Hw) == 27) {
            j6(cjVar, i, i2 - 2);
            this.v5.BT.DW();
        } else if (cjVar.J8(Hw) == 16) {
            bz bzVar = (bz) cjVar.QX(Hw);
            if (bzVar.I()) {
                this.v5.BT.j6(null);
                j6(bzVar);
            } else if (i2 == 0) {
                j6(cjVar, i, (bp) cjVar.EQ(Hw).a_());
                j6(bzVar);
            } else {
                j6(cjVar, i, i2 - 2);
                j6(bzVar);
            }
        } else {
            throw new ej();
        }
    }

    private void j6(bz bzVar) {
        this.v5.BT.j6(bzVar.I(), bzVar.U2(), j6(bzVar.Xa()), bzVar.eU());
    }

    private void j6(cj cjVar, int i, bp bpVar) {
        bp DW = DW(cjVar, i);
        if (bpVar == DW) {
            this.v5.BT.FH("this");
            return;
        }
        this.v5.BT.FH("this");
        this.v5.BT.j6(false, true, j6(DW), "this$0");
        DW = DW.Xa();
        while (DW != bpVar && !DW.FH((co) bpVar) && !DW.hz()) {
            this.v5.BT.j6(false, true, j6(DW), "this$0");
            DW = DW.Xa();
        }
    }

    private void DW(bz bzVar) {
        this.v5.BT.j6(bzVar.I(), j6(bzVar.Xa()), bzVar.eU(), j6((bs) bzVar), bzVar.lp());
    }

    private void j6(cj cjVar, int i, bz bzVar) {
        int Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
        int lg = (cjVar.lg(Hw) - 1) / 2;
        bzVar.lp();
        int i2 = 0;
        int lg2 = cjVar.lg(Hw);
        lg = 1;
        while (lg < lg2 - 1) {
            int Hw2 = cjVar.Hw(Hw, lg);
            co v5 = bzVar.v5(i2);
            co we = cjVar.we(Hw2);
            j6(cjVar, Hw2);
            j6(cjVar.we(), we, v5);
            lg += 2;
            i2++;
        }
    }

    private bp DW(cj cjVar, int i) {
        while (true) {
            switch (cjVar.rN(i)) {
                case 120:
                case 121:
                case 128:
                case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                case 220:
                case 221:
                case 222:
                case 227:
                case 228:
                    return this.FH.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                default:
                    i = cjVar.aM(i);
            }
        }
    }
}
