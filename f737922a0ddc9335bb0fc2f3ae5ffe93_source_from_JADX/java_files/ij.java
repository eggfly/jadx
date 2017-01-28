import com.aide.uidesigner.ProxyTextView;

public class ij extends es {
    private dt BT;
    private final bt Mr;
    private final ik U2;
    private ic a8;
    private final by aM;
    private int[] er;
    private boolean gW;
    private final bu j3;
    private final boolean lg;
    private int[] rN;
    private dt vy;
    private int yS;

    public ij(ic icVar, by byVar, bu buVar, bt btVar, ik ikVar, boolean z) {
        super(byVar, buVar, btVar, ikVar, 206, 0);
        this.rN = new int[10000];
        this.er = new int[10000];
        this.BT = new dt();
        this.vy = new dt();
        this.a8 = icVar;
        this.aM = byVar;
        this.j3 = buVar;
        this.Mr = btVar;
        this.U2 = ikVar;
        this.lg = z;
        this.BT.j6(byVar.j6("BR"), 12);
        this.BT.j6(byVar.j6("AREA"), 12);
        this.BT.j6(byVar.j6("LINK"), 12);
        this.BT.j6(byVar.j6("IMG"), 12);
        this.BT.j6(byVar.j6("LINK"), 12);
        this.BT.j6(byVar.j6("PARAM"), 12);
        this.BT.j6(byVar.j6("HR"), 12);
        this.BT.j6(byVar.j6("P"), 4);
        this.BT.j6(byVar.j6("DT"), 4);
        this.BT.j6(byVar.j6("DD"), 4);
        this.BT.j6(byVar.j6("LI"), 4);
        this.BT.j6(byVar.j6("INPUT"), 12);
        this.BT.j6(byVar.j6("OPTION"), 4);
        this.BT.j6(byVar.j6("THEAD"), 4);
        this.BT.j6(byVar.j6("TFOOT"), 4);
        this.BT.j6(byVar.j6("COLGROUP"), 4);
        this.BT.j6(byVar.j6("COL"), 12);
        this.BT.j6(byVar.j6("TR"), 4);
        this.BT.j6(byVar.j6("TH"), 4);
        this.BT.j6(byVar.j6("TD"), 4);
        this.BT.j6(byVar.j6("BASE"), 12);
        this.BT.j6(byVar.j6("META"), 12);
        this.BT.j6(byVar.j6("BODY"), 4);
        this.BT.j6(byVar.j6("TBODY"), 4);
        this.BT.j6(byVar.j6("HEAD"), 4);
        this.BT.j6(byVar.j6("HTML"), 4);
        this.BT.j6.j6();
        while (this.BT.j6.DW()) {
            this.vy.j6(this.BT.j6.FH(), this.BT.j6.Hw());
        }
        this.vy.j6(byVar.j6("BASEFONT"), 12);
        this.vy.j6(byVar.j6("FRAME"), 12);
        this.vy.j6(byVar.j6("ISINDEX"), 12);
        ic icVar2 = new ic(buVar, byVar);
    }

    public void j6(cm cmVar, bv bvVar, boolean z, cj cjVar) {
        super.j6(cmVar, bvVar, z, cjVar);
        this.a8.Hw(cjVar);
        if (z) {
            this.a8.j6(cjVar, VH());
        }
    }

    private boolean VH() {
        return this.lg || this.gW;
    }

    private boolean gn() {
        return false;
    }

    protected void j6(String str) {
        if (this.v5) {
            int i = this.gn;
            while (i > 0) {
                i--;
                if (this.tp[i] != 2) {
                    break;
                }
            }
            int i2 = this.J0[i];
            int i3 = this.Ws[i] - 1;
            this.j3.Zo(this.Zo.we(), this.Zo.tp(), i2, i3, i2, i3 + 2, str, 0);
        }
    }

    protected void DW(String str) {
        if (this.v5) {
            int i = this.gn;
            while (i > 0) {
                i--;
                if (this.tp[i] != 2) {
                    break;
                }
            }
            int i2 = this.J0[i];
            int i3 = this.Ws[i] - 1;
            this.j3.Zo(this.Zo.we(), this.Zo.tp(), i2, i3, i2, i3 + 2, str, 1);
        }
    }

    protected void j6(int i) {
        if (this.v5) {
            int i2 = this.gn;
            while (i2 > 0) {
                i2--;
                if (this.tp[i2] != 2) {
                    break;
                }
            }
            int i3 = this.J0[i2];
            int i4 = this.Ws[i2] - 1;
            int i5 = i4 + 2;
            String XL = this.U2.XL(i);
            this.j3.Zo(this.Zo.we(), this.Zo.tp(), i3, i4, i3, i5, "Missing </C>" + XL + "<//C>", 0);
            this.j3.j6(this.Zo.we(), this.Zo.tp(), i3, i4 + 1, i3, i4 + 1, XL, "Insert '" + XL + "'");
        }
    }

    private void u7() {
        j6("Missing tag name");
    }

    private void tp() {
        j6("Missing DOCTYPE literal");
    }

    private void EQ() {
        DW("Missing entity name");
    }

    private void v5(int i, int i2) {
        int i3;
        int i4;
        String str;
        if (this.gn > 0) {
            i3 = this.J0[this.gn - 1];
            i4 = this.Ws[this.gn - 1];
        } else {
            i3 = this.we[this.gn];
            i4 = this.J8[this.gn];
        }
        if (i == this.aM.j6("")) {
            str = "</" + this.aM.j6(i2) + ">";
        } else {
            str = "</" + this.aM.j6(i) + ":" + this.aM.j6(i2) + ">";
        }
        j6("Expected " + str);
        if (this.v5) {
            this.j3.j6(this.Zo.we(), this.Zo.tp(), i3, i4, i3, i4, str, "Insert " + str);
        }
    }

    private void we() {
        j6("Attribute value expected");
    }

    private void Zo(int i, int i2) {
        this.yS++;
        if (this.yS >= this.er.length) {
            Object obj = new int[((this.er.length * 2) + 1)];
            System.arraycopy(this.er, 0, obj, 0, this.er.length);
            this.er = obj;
            obj = new int[((this.rN.length * 2) + 1)];
            System.arraycopy(this.rN, 0, obj, 0, this.rN.length);
            this.rN = obj;
        }
        this.er[this.yS] = i2;
        this.rN[this.yS] = i;
    }

    private void J0() {
        this.yS--;
        if (this.yS < -1) {
            throw new InternalError("tag stack corruption");
        }
    }

    private boolean VH(int i, int i2) {
        int i3 = 0;
        while (i3 <= this.yS) {
            if (this.er[i3] == i2 && this.rN[i3] == i) {
                return true;
            }
            i3++;
        }
        return false;
    }

    private boolean j6(char[] cArr, int i, int i2, String str) {
        int i3 = 0;
        while (i3 < i2 - str.length()) {
            int i4 = 0;
            while (i4 < str.length()) {
                if (Character.toUpperCase(cArr[(i + i3) + i4]) != str.charAt(i4)) {
                    i3++;
                } else {
                    i4++;
                }
            }
            return true;
        }
        return false;
    }

    private boolean gn(int i, int i2) {
        if (VH() || i != this.aM.j6("")) {
            return false;
        }
        boolean z;
        dt dtVar = gn() ? this.BT : this.vy;
        if (!dtVar.FH(i2) || (dtVar.Hw(i2) & 4) == 0) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    private boolean gn(int i) {
        if (VH()) {
            return false;
        }
        boolean z;
        dt dtVar = gn() ? this.BT : this.vy;
        if (!dtVar.FH(i) || (dtVar.Hw(i) & 8) == 0) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    private void J8() {
        DW(26, this.aM.j6(""));
    }

    private void Ws() {
        DW(26, this.aM.j6(""));
        DW(49, this.aM.j6(""));
        DW(26, this.aM.j6(""));
        Hw(218, 3);
    }

    private boolean QX() {
        return Zo(0) == 34 && Zo(1) == 2 && Zo(2) == 38;
    }

    private boolean XL() {
        int i = 0;
        while (true) {
            switch (Zo(i)) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case 40:
                case 41:
                case 42:
                case 44:
                case 45:
                case 70:
                case 71:
                case 75:
                case 76:
                case 77:
                case 100:
                    i++;
                case 13:
                    return true;
                default:
                    return false;
            }
        }
    }

    private void aM() {
        Hw();
        if (this.VH == 33) {
            Hw();
        } else {
            j6(33);
        }
        v5(32);
    }

    private void u7(int i, int i2) {
        FH(7);
        DW(25, i);
        FH(49);
        DW(25, i2);
        Hw(217, 3);
        FH(8);
        Hw(200, 3);
    }

    private void tp(int i, int i2) {
        Object obj = null;
        if (this.gn > 0 && this.tp[this.gn - 1] == 15) {
            this.gn--;
            obj = 1;
        }
        FH(11);
        DW(25, i);
        FH(49);
        DW(25, i2);
        Hw(217, 3);
        FH(8);
        Hw(207, 3);
        if (obj != null) {
            this.gn++;
        }
    }

    private void u7(int i) {
        Object obj = null;
        if (this.gn > 0 && this.tp[this.gn - 1] == 15) {
            this.gn--;
            obj = 1;
        }
        FH(11);
        DW(25, this.aM.j6(""));
        FH(49);
        DW(25, i);
        Hw(217, 3);
        FH(8);
        Hw(208, 3);
        if (obj != null) {
            this.gn++;
        }
    }

    private void j3() {
        Hw(211, 0);
    }

    protected void Zo() {
        this.gW = false;
        DW(true);
        FH(206, 1);
    }

    private int j6(boolean z) {
        int i = 0;
        while (true) {
            switch (this.VH) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw();
                    continue;
                case 40:
                    U2();
                    i++;
                    continue;
                case 70:
                case 71:
                case 75:
                case 100:
                    KD();
                    i++;
                    continue;
                case 72:
                case 73:
                    if (!z) {
                        break;
                    }
                    KD();
                    i++;
                    continue;
                default:
                    break;
            }
            return i;
        }
    }

    private void Mr() {
        DW();
        Hw(78);
        Hw(76);
        FH(306, 3);
    }

    private void U2() {
        DW();
        int i = 0;
        while (true) {
            switch (this.VH) {
                case 41:
                case 42:
                    DW();
                    i++;
                    break;
                case 70:
                case 71:
                case 72:
                case 73:
                case 75:
                case 100:
                    KD();
                    i++;
                    break;
                default:
                    if (this.VH == 45) {
                        DW();
                    } else {
                        Hw(44);
                    }
                    FH(216, i + 2);
                    return;
            }
        }
    }

    private void a8() {
        Object obj = 1;
        DW();
        v5(2);
        DW();
        if (this.VH == 2) {
            Hw();
        }
        switch (this.VH) {
            case 8:
                obj = null;
                break;
            case 35:
                if (Zo(2) != 37) {
                    tp();
                    Hw();
                    obj = null;
                    break;
                }
                lg();
                break;
            case ProxyTextView.INPUTTYPE_time /*36*/:
                if (Zo(2) != 37) {
                    tp();
                    Hw();
                    obj = null;
                    break;
                }
                rN();
                break;
            case 39:
                Hw();
                if (this.VH == 2) {
                    Hw();
                }
                Hw(8);
                FH(213, 3);
                return;
            default:
                j6();
                obj = null;
                break;
        }
        if (this.VH == 2) {
            Hw();
        }
        if (this.VH == 39) {
            Hw();
            if (this.VH == 2) {
                Hw();
            }
        }
        Hw(8);
        FH(213, obj != null ? 4 : 3);
    }

    private void lg() {
        DW();
        v5(2);
        DW();
        FH(214, 2);
    }

    private void rN() {
        DW();
        v5(2);
        DW();
        int i = this.QX[this.XL];
        if (!VH() && j6(this.Zo.j3(i), this.Zo.Mr(i), this.Zo.U2(i), "XHTML")) {
            this.gW = true;
        }
        if (this.VH == 2) {
            Hw();
        }
        if (this.VH == 37) {
            DW();
            FH(215, 3);
            return;
        }
        FH(215, 2);
    }

    private void er() {
        this.gW = true;
        DW();
        if (this.VH == 33) {
            DW();
            Hw(32);
            FH(212, 3);
            return;
        }
        Hw(32);
        FH(212, 2);
    }

    private void yS() {
        int j6;
        int j62;
        Hw(7);
        if (this.VH != 25) {
            u7();
            j6 = this.aM.j6("");
            DW(25, j6);
            FH(49);
            j62 = this.aM.j6("");
            DW(25, j62);
        } else if (Zo(1) == 49) {
            j6 = v5();
            DW();
            DW();
            j62 = v5();
            DW();
        } else {
            j6 = this.aM.j6("");
            DW(25, j6);
            FH(49);
            j62 = v5();
            DW();
        }
        FH(217, 3);
        int FH = this.aM.FH(j6);
        int FH2 = this.aM.FH(j62);
        int i = 0;
        while (true) {
            switch (this.VH) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw();
                    break;
                case 26:
                case 50:
                    vy();
                    i++;
                    break;
                case 40:
                    U2();
                    i++;
                    break;
                case 70:
                case 71:
                case 72:
                case 73:
                case 75:
                case 100:
                    KD();
                    i++;
                    break;
                default:
                    i += 2;
                    switch (this.VH) {
                        case 8:
                            DW();
                            FH(200, i + 1);
                            if (j6 == this.aM.j6("") && gn(FH2)) {
                                j3();
                                u7(j62);
                            } else {
                                Zo(FH, FH2);
                                DW(false);
                                if (this.VH == 0) {
                                    if (!gn(FH, FH2)) {
                                        v5(j6, j62);
                                    }
                                    tp(j6, j62);
                                } else if (Zo(1) != 25) {
                                    DW();
                                    u7();
                                    DW(25, FH);
                                    FH(49);
                                    DW(25, FH2);
                                    Hw(217, 3);
                                    FH(8);
                                    FH(207, 3);
                                } else {
                                    int VH;
                                    if (Zo(2) == 49) {
                                        VH = VH(1);
                                        i = VH(3);
                                    } else {
                                        VH = this.aM.j6("");
                                        i = VH(1);
                                    }
                                    VH = this.aM.FH(VH);
                                    i = this.aM.FH(i);
                                    if (i == FH2 && VH == FH) {
                                        gW();
                                    } else if (!VH(VH, i)) {
                                        throw new RuntimeException("Non-open closing tag found in element()");
                                    } else if (gn(FH, FH2)) {
                                        u7(j62);
                                    } else {
                                        v5(j6, j62);
                                        tp(j6, j62);
                                    }
                                }
                                J0();
                            }
                            FH(210, 3);
                            return;
                        case 12:
                            DW();
                            FH(201, i + 1);
                            return;
                        default:
                            j6(8);
                            FH(12);
                            FH(201, i + 1);
                            return;
                    }
            }
        }
    }

    private void gW() {
        Hw(11);
        if (Zo(1) == 49) {
            DW();
            DW();
            DW();
        } else {
            DW(25, this.aM.j6(""));
            FH(49);
            DW();
        }
        FH(217, 3);
        int j6 = j6(true);
        Hw(8);
        FH(207, j6 + 3);
    }

    private void DW(boolean z) {
        int i = 0;
        while (this.VH != 0) {
            switch (this.VH) {
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    BT();
                    i++;
                    continue;
                case 7:
                    yS();
                    i++;
                    continue;
                case 11:
                    if (Zo(1) != 25) {
                        if (!z) {
                            break;
                        }
                        Hw();
                        u7();
                        continue;
                    } else {
                        int VH;
                        int VH2;
                        if (Zo(2) == 49) {
                            VH = VH(1);
                            VH2 = VH(3);
                        } else {
                            VH = this.aM.j6("");
                            VH2 = VH(1);
                        }
                        if (!z) {
                            if (!VH(this.aM.FH(VH), this.aM.FH(VH2))) {
                                u7(VH, VH2);
                                j3();
                                gW();
                                FH(210, 3);
                                i++;
                                break;
                            }
                            break;
                        }
                        u7(VH, VH2);
                        j3();
                        gW();
                        FH(210, 3);
                        i++;
                        break;
                    }
                case 14:
                case 15:
                    DW();
                    i++;
                    continue;
                case 24:
                    DW();
                    i++;
                    continue;
                case 27:
                    if (Zo(1) != 29) {
                        DW();
                        i++;
                        break;
                    }
                    SI();
                    i++;
                    continue;
                case 28:
                    DW();
                    i++;
                    continue;
                case 30:
                    er();
                    i++;
                    continue;
                case 31:
                    aM();
                    continue;
                case 34:
                    if (!QX()) {
                        j6();
                        Hw();
                        break;
                    }
                    a8();
                    i++;
                    continue;
                case 40:
                    U2();
                    i++;
                    continue;
                case 46:
                case 48:
                    DW();
                    i++;
                    continue;
                case 47:
                    DW();
                    i++;
                    continue;
                case 70:
                case 71:
                case 72:
                case 73:
                case 75:
                case 100:
                    KD();
                    i++;
                    continue;
                default:
                    j6();
                    Hw();
                    continue;
            }
            FH(211, i);
        }
        FH(211, i);
    }

    private void BT() {
        DW();
        if (this.VH == 6) {
            DW();
            Hw(5);
            FH(ProxyTextView.INPUTTYPE_textWebEmailAddress, 3);
            return;
        }
        Hw(5);
        FH(ProxyTextView.INPUTTYPE_textWebEmailAddress, 2);
    }

    private void vy() {
        int v5;
        int v52;
        if (Zo(1) == 49) {
            v5 = v5();
            DW();
            Hw(49);
            v52 = v5();
            DW();
        } else {
            v5 = this.aM.j6("");
            DW(26, v5);
            FH(49);
            v52 = v5();
            DW();
        }
        FH(218, 3);
        int i = 0;
        if (XL()) {
            i = 0 + j6(true);
        }
        if (this.VH == 13) {
            Hw(13);
            v52 = j6(false) + i;
            ei();
            FH(203, v52 + 3);
            return;
        }
        FH(13);
        DW(26, v5);
        FH(49);
        DW(26, v52);
        Hw(218, 3);
        Hw(204, 1);
        FH(203, 3);
    }

    private void P8() {
        if (Zo(1) == 49) {
            v5();
            DW();
            Hw(49);
            v5();
            DW();
        } else {
            DW(26, this.aM.j6(""));
            FH(49);
            v5();
            DW();
        }
        FH(218, 3);
    }

    private void ei() {
        switch (this.VH) {
            case 16:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                int i = this.VH;
                DW();
                int i2 = 0;
                while (this.VH != 0) {
                    switch (this.VH) {
                        case 16:
                        case ProxyTextView.INPUTTYPE_textUri /*17*/:
                            break;
                        case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                            DW();
                            i2++;
                            continue;
                        case ProxyTextView.INPUTTYPE_date /*20*/:
                            DW();
                            i2++;
                            continue;
                        case 22:
                            if (Zo(1) != 21) {
                                EQ();
                                Hw();
                                break;
                            }
                            nw();
                            i2++;
                            continue;
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 75:
                        case 100:
                            KD();
                            i2++;
                            continue;
                        case 74:
                            Mr();
                            i2++;
                            continue;
                        default:
                            j6();
                            break;
                    }
                    Hw(i);
                    FH(204, i2 + 2);
                }
                Hw(i);
                FH(204, i2 + 2);
            case 26:
            case 50:
                P8();
                FH(204, 1);
            case 72:
                sG();
                FH(204, 1);
            case 74:
                Mr();
                FH(204, 1);
            case 303:
                cb();
                FH(204, 1);
            default:
                Ws();
                FH(204, 1);
                we();
        }
    }

    private void nw() {
        DW();
        DW();
        if (this.VH == 23) {
            DW();
        } else {
            DW(23);
            FH(23);
        }
        FH(205, 3);
    }

    private void SI() {
        DW();
        DW();
        Hw(28);
        FH(205, 3);
    }

    private void KD() {
        switch (this.VH) {
            case 70:
                ro();
            case 71:
                dx();
            case 72:
                sG();
            case 73:
                cb();
            case 75:
                DW();
            case 100:
                ef();
            default:
                throw new RuntimeException("Expeted ASP content token");
        }
    }

    private void ro() {
        DW();
        if (this.VH == 2) {
            Hw();
        }
        int i = 0;
        if (this.VH == 25) {
            DW();
            i = 1;
        }
        while (true) {
            switch (this.VH) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw();
                    break;
                case 26:
                    cn();
                    i++;
                    break;
                default:
                    Hw(76);
                    FH(300, i + 2);
                    return;
            }
        }
    }

    private void cn() {
        DW();
        if (this.VH == 2) {
            Hw();
        }
        if (this.VH == 13) {
            Hw(13);
            if (this.VH == 2) {
                Hw();
            }
            sh();
            FH(304, 3);
            return;
        }
        FH(304, 1);
    }

    private void sh() {
        switch (this.VH) {
            case 16:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                int i = this.VH;
                DW();
                int i2 = 0;
                while (this.VH != 0 && this.VH == 18) {
                    DW();
                    i2++;
                }
                Hw(i);
                FH(305, i2 + 2);
            case 26:
                DW();
                FH(305, 1);
            default:
                J8();
                FH(305, 1);
                we();
        }
    }

    private void cb() {
        DW();
        if (this.VH == 77) {
            DW();
            Hw(76);
            FH(303, 3);
            return;
        }
        Hw(76);
        FH(303, 2);
    }

    private void dx() {
        DW();
        if (this.VH == 77) {
            DW();
            Hw(76);
            FH(301, 3);
            return;
        }
        Hw(76);
        FH(301, 2);
    }

    private void sG() {
        DW();
        if (this.VH == 77) {
            DW();
            Hw(76);
            FH(302, 3);
            return;
        }
        Hw(76);
        FH(302, 2);
    }

    private void ef() {
        DW();
        if (this.VH == 77) {
            DW();
            Hw(76);
            FH(320, 3);
            return;
        }
        Hw(76);
        FH(320, 2);
    }
}
