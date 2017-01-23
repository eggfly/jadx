import com.aide.uidesigner.ProxyTextView;

public class gx extends es {
    private int BT;
    private final by Mr;
    private int P8;
    private final bt U2;
    private final boolean a8;
    private final ha aM;
    private int er;
    private int[] gW;
    private final bu j3;
    private int lg;
    private int rN;
    private int vy;
    private int yS;

    public gx(by byVar, bu buVar, bt btVar, ha haVar, boolean z) {
        super(byVar, buVar, btVar, haVar, 223, 0);
        this.gW = new int[1000];
        this.BT = 0;
        this.j3 = buVar;
        this.Mr = byVar;
        this.U2 = btVar;
        this.aM = haVar;
        this.a8 = z;
        this.P8 = byVar.j6("enum");
    }

    public void j6(cm cmVar, bv bvVar, boolean z, cj cjVar) {
        this.lg = 1;
        this.rN = 1000000;
        this.er = 1;
        this.yS = 100000000;
        super.j6(cmVar, bvVar, z, cjVar);
        if (this.a8) {
            j6(cjVar, bvVar.Zo());
        }
    }

    private void j6(cj cjVar, int i) {
        int i2;
        int lg = cjVar.lg(cjVar.Ws());
        for (i2 = 0; i2 < lg; i2++) {
            int Hw = cjVar.Hw(cjVar.Ws(), i2);
            if (cjVar.rN(Hw) == 120 || cjVar.rN(Hw) == 220 || cjVar.rN(Hw) == 121) {
                if (cjVar.gW(cjVar.Hw(Hw, 2)) == i) {
                    return;
                }
            }
        }
        r12 = new int[7];
        r12[0] = cjVar.j6(199, true, new int[]{cjVar.j6(84, true, 1, 1, 1)}, 0, 1, 1, 1);
        r12[1] = cjVar.j6(72, true, 1, 1, 1);
        r12[2] = cjVar.j6(1, true, i, 1, 1, 1, 1);
        r12[3] = cjVar.j6(207, true, new int[0], 0, 0, 1, 1);
        r12[4] = cjVar.j6(192, true, new int[0], 0, 0, 1, 1);
        r12[5] = cjVar.j6((int) ProxyTextView.INPUTTYPE_textPhonetic, true, new int[0], 0, 0, 1, 1);
        r12[6] = cjVar.j6(122, true, new int[]{cjVar.j6(8, true, 1, 1, 1), cjVar.j6(9, true, 1, 1, 1)}, 0, 2, 1, 1);
        i2 = cjVar.j6(120, true, r12, 0, 7, 1, 1, 0);
        cj cjVar2 = cjVar;
        cjVar2.j6(cjVar.j6(223, false, new int[]{i2}, 0, 1, 1, 1));
    }

    private void VH() {
        j6("Unexpected end of statement");
    }

    private void gn() {
        j6("Unexpected end of expression");
    }

    private void u7() {
        j6("Unexpected end of package declaration");
    }

    private void tp() {
        j6("Unexpected end of declaration");
    }

    private void EQ() {
        j6("Unexpected end of import");
    }

    private void we() {
        DW(1, this.Mr.j6(""));
    }

    private void gn(int i) {
        DW(1, i);
    }

    private void j6(int i, boolean z, boolean z2) {
        if (z) {
            FH(84);
            Hw(199, 1);
            Hw(207, 0);
            gn(i);
            FH(12);
            Hw(199, 0);
            gn(this.Mr.j6("String"));
            Hw(206, 0);
            Hw(180, 2);
            Hw(198, 0);
            gn(this.Mr.j6("$name"));
            Hw(198, 0);
            Hw(191, 5);
            FH(15);
            Hw(199, 0);
            FH(57);
            Hw(180, 1);
            Hw(198, 0);
            gn(this.Mr.j6("$ordinal"));
            Hw(198, 0);
            Hw(191, 5);
            FH(13);
            Hw(190, 5);
            Hw(195, 0);
            FH(8);
            Hw(206, 0);
            FH(78);
            FH(12);
            gn(this.Mr.j6("$name"));
            Hw(ProxyTextView.INPUTTYPE_textWebEditText, 1);
            FH(15);
            gn(this.Mr.j6("$ordinal"));
            Hw(ProxyTextView.INPUTTYPE_textWebEditText, 1);
            FH(13);
            Hw(197, 5);
            we();
            Hw(164, 4);
            FH(14);
            Hw(146, 2);
            FH(9);
            Hw(133, 3);
            j6(123, true, 6, z2);
            return;
        }
        FH(84);
        Hw(199, 1);
        Hw(207, 0);
        gn(i);
        FH(12);
        FH(13);
        Hw(190, 2);
        Hw(195, 0);
        FH(8);
        Hw(206, 0);
        FH(78);
        FH(12);
        FH(13);
        Hw(197, 2);
        we();
        Hw(164, 4);
        FH(14);
        Hw(146, 2);
        FH(9);
        Hw(133, 3);
        j6(123, true, 6, z2);
    }

    private void j6(int i, boolean z, int i2, boolean z2) {
        int i3;
        if (this.aM.we(i)) {
            if (z2) {
                i3 = this.rN;
                this.rN = i3 + 1;
                j6(i, z, i2, i3);
                return;
            }
            i3 = this.lg;
            this.lg = i3 + 1;
            j6(i, z, i2, i3);
        } else if (this.aM.J0(i)) {
            switch (i) {
                case 128:
                case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                case 222:
                    i3 = this.yS;
                    this.yS = i3 + 1;
                    j6(i, z, i2, i3);
                default:
                    i3 = this.er;
                    this.er = i3 + 1;
                    j6(i, z, i2, i3);
            }
        } else {
            j6(i, z, i2);
        }
    }

    private void j6(int i, boolean z, int i2, boolean z2, int i3) {
        if (this.a8 && i3 == this.Zo.we().Zo()) {
            switch (i) {
                case 120:
                case 121:
                case 220:
                    j6(i, z, i2, 0);
                    return;
                default:
                    int i4 = this.er;
                    this.er = i4 + 1;
                    j6(i, z, i2, i4);
                    return;
            }
        }
        i4 = this.er;
        this.er = i4 + 1;
        j6(i, z, i2, i4);
    }

    private boolean J0() {
        int i = 0;
        while (true) {
            switch (Zo(i)) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                case 72:
                case 75:
                case 82:
                case 83:
                case 84:
                case 86:
                case 94:
                case 95:
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                case 98:
                case 99:
                case 100:
                case 101:
                case 104:
                case 107:
                case 118:
                case 119:
                    return false;
                case 93:
                    return true;
                default:
                    i++;
            }
        }
    }

    private boolean J8() {
        this.vy = 1;
        if (Zo(1) == 115 || Zo(1) == 14) {
            return true;
        }
        while (true) {
            switch (Zo(this.vy)) {
                case 75:
                case 84:
                case 95:
                    this.vy++;
                default:
                    switch (Zo(this.vy)) {
                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        case 72:
                        case 99:
                        case 107:
                        case 115:
                        case 118:
                        case 119:
                            return true;
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            if (VH(this.vy) != this.P8) {
                                return false;
                            }
                            return true;
                        default:
                            return false;
                    }
            }
        }
    }

    private boolean Ws() {
        if (Zo(this.vy) != 44) {
            return false;
        }
        this.vy++;
        switch (Zo(this.vy)) {
            case 25:
                this.vy++;
                switch (Zo(this.vy)) {
                    case 78:
                    case 91:
                        this.vy++;
                        if (!QX()) {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            default:
                if (!QX()) {
                    return false;
                }
                break;
        }
        while (Zo(this.vy) == 15) {
            this.vy++;
            switch (Zo(this.vy)) {
                case 25:
                    this.vy++;
                    switch (Zo(this.vy)) {
                        case 78:
                        case 91:
                            this.vy++;
                            if (QX()) {
                                break;
                            }
                            return false;
                        default:
                            break;
                    }
                default:
                    if (QX()) {
                        break;
                    }
                    return false;
            }
        }
        switch (Zo(this.vy)) {
            case 48:
            case 50:
            case 51:
                this.vy++;
                break;
        }
        return true;
    }

    private boolean QX() {
        switch (Zo(this.vy)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                break;
            case 57:
            case 60:
            case 62:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 69:
            case 76:
            case 77:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 89:
            case 114:
                this.vy++;
                while (Zo(this.vy) == 10) {
                    this.vy++;
                    while (Zo(this.vy) == 15) {
                        this.vy++;
                    }
                    if (Zo(this.vy) != 11) {
                        return false;
                    }
                    this.vy++;
                }
                return true;
            default:
                return false;
        }
        while (Zo(this.vy) == 1) {
            this.vy++;
            if (Zo(this.vy) == 44 && !Ws()) {
                return false;
            }
            switch (Zo(this.vy)) {
                case 10:
                    while (Zo(this.vy) == 10) {
                        this.vy++;
                        while (Zo(this.vy) == 15) {
                            this.vy++;
                        }
                        if (Zo(this.vy) != 11) {
                            return false;
                        }
                        this.vy++;
                    }
                    return true;
                case 16:
                    this.vy++;
                default:
                    return true;
            }
        }
        return false;
    }

    private boolean XL() {
        boolean z = true;
        this.vy = 0;
        if (Zo(this.vy) != 1) {
            return false;
        }
        this.vy++;
        while (Zo(this.vy) == 16) {
            this.vy++;
            switch (Zo(this.vy)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.vy++;
                    break;
                case 67:
                case 72:
                case 78:
                    return true;
                default:
                    break;
            }
        }
        if (Zo(this.vy) != 10) {
            return false;
        }
        while (Zo(this.vy) == 10) {
            this.vy++;
            if (Zo(this.vy) != 11) {
                return false;
            }
            this.vy++;
        }
        if (Zo(this.vy) != 16) {
            return false;
        }
        this.vy++;
        if (Zo(this.vy) != 72) {
            z = false;
        }
        return z;
    }

    private boolean aM() {
        this.vy = 0;
        if (!QX() || Zo(this.vy) != 1) {
            return false;
        }
        int Zo = Zo(this.vy + 1);
        if (Zo == 14 || Zo == 17 || Zo == 15 || Zo == 10) {
            return true;
        }
        return false;
    }

    private boolean j3() {
        boolean z = true;
        this.vy = 0;
        if (Zo(this.vy) == 75) {
            this.vy++;
        }
        if (!QX() || Zo(this.vy) != 1) {
            return false;
        }
        this.vy++;
        while (Zo(this.vy) == 10) {
            this.vy++;
            if (Zo(this.vy) != 11) {
                return false;
            }
            this.vy++;
        }
        if (Zo(this.vy) != 26) {
            z = false;
        }
        return z;
    }

    private boolean Mr() {
        this.vy = 0;
        if (this.VH == 44 && !Ws()) {
            return false;
        }
        if (Zo(this.vy) == 78 && Zo(this.vy + 1) == 12) {
            return true;
        }
        if (Zo(this.vy) == 67 && Zo(this.vy + 1) == 12) {
            return true;
        }
        while (Zo(this.vy) != 14 && Zo(this.vy) != 9 && Zo(this.vy) != 0) {
            if (Zo(this.vy) == 16) {
                if (Zo(this.vy + 1) == 78 && Zo(this.vy + 2) == 12) {
                    return true;
                }
                if (Zo(this.vy + 1) == 67 && Zo(this.vy + 2) == 12) {
                    return true;
                }
            }
            this.vy++;
        }
        return false;
    }

    private boolean U2() {
        boolean z = true;
        this.vy = 0;
        if (!QX() || Zo(this.vy) != 1) {
            return false;
        }
        if (Zo(this.vy + 1) != 12) {
            z = false;
        }
        return z;
    }

    private boolean a8() {
        this.vy = 0;
        int i = 0;
        do {
            int i2 = this.vy;
            this.vy = i2 + 1;
            if (Zo(i2) != 21) {
                return false;
            }
            i2 = this.vy;
            this.vy = i2 + 1;
            if (Zo(i2) != 2) {
                return false;
            }
            i++;
        } while (Zo(this.vy) == 21);
        if (i >= 100) {
            return true;
        }
        return false;
    }

    private boolean lg() {
        this.vy = 0;
        switch (Zo(this.vy)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                break;
            case 57:
            case 60:
            case 62:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 69:
            case 76:
            case 77:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 89:
            case 114:
                this.vy++;
                while (Zo(this.vy) == 10) {
                    this.vy++;
                    if (Zo(this.vy) != 11) {
                        return false;
                    }
                    this.vy++;
                }
                if (Zo(this.vy) != 13) {
                    return false;
                }
                this.vy++;
                switch (Zo(this.vy)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    case 7:
                    case 12:
                    case 21:
                    case 22:
                    case 24:
                    case 27:
                    case 28:
                    case 34:
                    case 58:
                    case 66:
                    case 67:
                    case 68:
                    case 74:
                    case 78:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
        while (Zo(this.vy) == 1) {
            this.vy++;
            if (Zo(this.vy) == 44 && !Ws()) {
                return false;
            }
            switch (Zo(this.vy)) {
                case 10:
                    while (Zo(this.vy) == 10) {
                        this.vy++;
                        if (Zo(this.vy) != 11) {
                            return false;
                        }
                        this.vy++;
                    }
                    break;
                case 16:
                    this.vy++;
                    continue;
                default:
                    break;
            }
            if (Zo(this.vy) == 13) {
                this.vy++;
                switch (Zo(this.vy)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    case 7:
                    case 12:
                    case 24:
                    case 34:
                    case 58:
                    case 66:
                    case 67:
                    case 68:
                    case 74:
                    case 78:
                        return true;
                    default:
                        break;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void Zo() {
        /*
        r10 = this;
        r6 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        r8 = 16;
        r9 = 14;
        r2 = 1;
        r3 = 0;
        r0 = 2;
        r1 = r10.J0();
        if (r1 == 0) goto L_0x00be;
    L_0x000f:
        r4 = r10.XL;
        r10.Sf();	 Catch:{ es$a -> 0x0020 }
        r1 = r10.VH;	 Catch:{ es$a -> 0x0020 }
        r5 = 93;
        if (r1 == r5) goto L_0x008a;
    L_0x001a:
        r1 = new es$a;	 Catch:{ es$a -> 0x0020 }
        r1.<init>();	 Catch:{ es$a -> 0x0020 }
        throw r1;	 Catch:{ es$a -> 0x0020 }
    L_0x0020:
        r1 = move-exception;
        r10.u7();
        r10.XL = r4;
        r10.FH(r6, r3);
    L_0x0029:
        r1 = 82;
        r10.FH(r1);
        r1 = r10.Mr;
        r4 = "java";
        r1 = r1.j6(r4);
        r10.gn(r1);
        r10.FH(r8);
        r1 = r10.Mr;
        r4 = "lang";
        r1 = r1.j6(r4);
        r10.gn(r1);
        r10.FH(r8);
        r1 = 30;
        r10.FH(r1);
        r10.FH(r9);
        r1 = 226; // 0xe2 float:3.17E-43 double:1.117E-321;
        r4 = 7;
        r10.Hw(r1, r4);
    L_0x005a:
        r1 = r10.VH;
        r4 = 82;
        if (r1 != r4) goto L_0x0117;
    L_0x0060:
        r5 = r10.XL;
        r1 = 3;
        r10.DW();	 Catch:{ es$a -> 0x007b }
        r4 = r10.VH;	 Catch:{ es$a -> 0x007b }
        r6 = 86;
        if (r4 != r6) goto L_0x0196;
    L_0x006c:
        r10.DW();	 Catch:{ es$a -> 0x007b }
        r1 = 4;
        r4 = r2;
    L_0x0071:
        r6 = r10.VH;	 Catch:{ es$a -> 0x007b }
        if (r6 == r2) goto L_0x00c3;
    L_0x0075:
        r1 = new es$a;	 Catch:{ es$a -> 0x007b }
        r1.<init>();	 Catch:{ es$a -> 0x007b }
        throw r1;	 Catch:{ es$a -> 0x007b }
    L_0x007b:
        r1 = move-exception;
        r10.EQ();
        r10.XL = r5;
    L_0x0081:
        r1 = r10.VH;
        switch(r1) {
            case 0: goto L_0x0117;
            case 72: goto L_0x0117;
            case 75: goto L_0x0117;
            case 82: goto L_0x005a;
            case 83: goto L_0x0117;
            case 84: goto L_0x0117;
            case 86: goto L_0x0117;
            case 94: goto L_0x0117;
            case 95: goto L_0x0117;
            case 97: goto L_0x0117;
            case 98: goto L_0x0117;
            case 99: goto L_0x0117;
            case 100: goto L_0x0117;
            case 101: goto L_0x0117;
            case 104: goto L_0x0117;
            case 107: goto L_0x0117;
            case 118: goto L_0x0117;
            case 119: goto L_0x0117;
            default: goto L_0x0086;
        };
    L_0x0086:
        r10.Hw();
        goto L_0x0081;
    L_0x008a:
        r10.DW();	 Catch:{ es$a -> 0x0020 }
        r1 = r10.VH;	 Catch:{ es$a -> 0x0020 }
        if (r1 == r2) goto L_0x0097;
    L_0x0091:
        r1 = new es$a;	 Catch:{ es$a -> 0x0020 }
        r1.<init>();	 Catch:{ es$a -> 0x0020 }
        throw r1;	 Catch:{ es$a -> 0x0020 }
    L_0x0097:
        r10.DW();	 Catch:{ es$a -> 0x0020 }
        r1 = 4;
    L_0x009b:
        r5 = r10.VH;	 Catch:{ es$a -> 0x0020 }
        if (r5 != r8) goto L_0x00b2;
    L_0x009f:
        r10.DW();	 Catch:{ es$a -> 0x0020 }
        r5 = r10.VH;	 Catch:{ es$a -> 0x0020 }
        if (r5 == r2) goto L_0x00ac;
    L_0x00a6:
        r1 = new es$a;	 Catch:{ es$a -> 0x0020 }
        r1.<init>();	 Catch:{ es$a -> 0x0020 }
        throw r1;	 Catch:{ es$a -> 0x0020 }
    L_0x00ac:
        r10.DW();	 Catch:{ es$a -> 0x0020 }
        r1 = r1 + 2;
        goto L_0x009b;
    L_0x00b2:
        r5 = 14;
        r10.Hw(r5);	 Catch:{ es$a -> 0x0020 }
        r5 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        r10.FH(r5, r1);	 Catch:{ es$a -> 0x0020 }
        goto L_0x0029;
    L_0x00be:
        r10.FH(r6, r3);
        goto L_0x0029;
    L_0x00c3:
        r10.DW();	 Catch:{ es$a -> 0x007b }
    L_0x00c6:
        r6 = r10.VH;	 Catch:{ es$a -> 0x007b }
        if (r6 != r8) goto L_0x0101;
    L_0x00ca:
        r10.DW();	 Catch:{ es$a -> 0x007b }
        r6 = r10.VH;	 Catch:{ es$a -> 0x007b }
        r7 = 30;
        if (r6 != r7) goto L_0x00f0;
    L_0x00d3:
        r10.DW();	 Catch:{ es$a -> 0x007b }
        r6 = 14;
        r10.Hw(r6);	 Catch:{ es$a -> 0x007b }
        if (r4 == 0) goto L_0x00e8;
    L_0x00dd:
        r4 = 214; // 0xd6 float:3.0E-43 double:1.057E-321;
        r1 = r1 + 2;
        r10.FH(r4, r1);	 Catch:{ es$a -> 0x007b }
    L_0x00e4:
        r0 = r0 + 1;
        goto L_0x005a;
    L_0x00e8:
        r4 = 226; // 0xe2 float:3.17E-43 double:1.117E-321;
        r1 = r1 + 2;
        r10.FH(r4, r1);	 Catch:{ es$a -> 0x007b }
        goto L_0x00e4;
    L_0x00f0:
        r6 = r10.VH;	 Catch:{ es$a -> 0x007b }
        if (r6 == r2) goto L_0x00fd;
    L_0x00f4:
        r10.EQ();	 Catch:{ es$a -> 0x007b }
        r10.we();	 Catch:{ es$a -> 0x007b }
    L_0x00fa:
        r1 = r1 + 2;
        goto L_0x00c6;
    L_0x00fd:
        r10.DW();	 Catch:{ es$a -> 0x007b }
        goto L_0x00fa;
    L_0x0101:
        r6 = 14;
        r10.Hw(r6);	 Catch:{ es$a -> 0x007b }
        if (r4 == 0) goto L_0x0111;
    L_0x0108:
        r4 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r10.FH(r4, r1);	 Catch:{ es$a -> 0x007b }
    L_0x010d:
        r0 = r0 + 1;
        goto L_0x005a;
    L_0x0111:
        r4 = 225; // 0xe1 float:3.15E-43 double:1.11E-321;
        r10.FH(r4, r1);	 Catch:{ es$a -> 0x007b }
        goto L_0x010d;
    L_0x0117:
        r1 = r10.VH;
        if (r1 == 0) goto L_0x0190;
    L_0x011b:
        r1 = r10.VH;
        if (r1 != r9) goto L_0x0123;
    L_0x011f:
        r10.Hw();
        goto L_0x011b;
    L_0x0123:
        r4 = r10.gn;
        r5 = r10.XL;
        r1 = r10.ef();	 Catch:{ es$a -> 0x0139 }
        r6 = r10.VH;	 Catch:{ es$a -> 0x0139 }
        switch(r6) {
            case 1: goto L_0x016f;
            case 72: goto L_0x014e;
            case 99: goto L_0x014e;
            case 107: goto L_0x014e;
            case 118: goto L_0x0168;
            case 119: goto L_0x015e;
            default: goto L_0x0130;
        };	 Catch:{ es$a -> 0x0139 }
    L_0x0130:
        r10.tp();	 Catch:{ es$a -> 0x0139 }
        r1 = new es$a;	 Catch:{ es$a -> 0x0139 }
        r1.<init>();	 Catch:{ es$a -> 0x0139 }
        throw r1;	 Catch:{ es$a -> 0x0139 }
    L_0x0139:
        r1 = move-exception;
        r10.tp();
        r10.XL = r5;
    L_0x013f:
        r1 = r10.gn;
        if (r4 != r1) goto L_0x0146;
    L_0x0143:
        r10.Hw();
    L_0x0146:
        r1 = r10.VH;
        if (r1 != r9) goto L_0x0117;
    L_0x014a:
        r10.Hw();
        goto L_0x0146;
    L_0x014e:
        r6 = 0;
        r7 = 0;
        r8 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r1 = r1 & r8;
        if (r1 == 0) goto L_0x015c;
    L_0x0155:
        r1 = r2;
    L_0x0156:
        r10.j6(r6, r7, r1);	 Catch:{ es$a -> 0x0139 }
        r0 = r0 + 1;
        goto L_0x013f;
    L_0x015c:
        r1 = r3;
        goto L_0x0156;
    L_0x015e:
        r10.Hw();	 Catch:{ es$a -> 0x0139 }
        r1 = 0;
        r10.FH(r1);	 Catch:{ es$a -> 0x0139 }
        r0 = r0 + 1;
        goto L_0x013f;
    L_0x0168:
        r1 = 0;
        r10.FH(r1);	 Catch:{ es$a -> 0x0139 }
        r0 = r0 + 1;
        goto L_0x013f;
    L_0x016f:
        r6 = r10.v5();	 Catch:{ es$a -> 0x0139 }
        r7 = r10.P8;	 Catch:{ es$a -> 0x0139 }
        if (r6 != r7) goto L_0x0187;
    L_0x0177:
        r6 = 0;
        r7 = 0;
        r8 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r1 = r1 & r8;
        if (r1 == 0) goto L_0x0185;
    L_0x017e:
        r1 = r2;
    L_0x017f:
        r10.j6(r6, r7, r1);	 Catch:{ es$a -> 0x0139 }
        r0 = r0 + 1;
        goto L_0x013f;
    L_0x0185:
        r1 = r3;
        goto L_0x017f;
    L_0x0187:
        r10.tp();	 Catch:{ es$a -> 0x0139 }
        r1 = new es$a;	 Catch:{ es$a -> 0x0139 }
        r1.<init>();	 Catch:{ es$a -> 0x0139 }
        throw r1;	 Catch:{ es$a -> 0x0139 }
    L_0x0190:
        r1 = 223; // 0xdf float:3.12E-43 double:1.1E-321;
        r10.FH(r1, r0);
        return;
    L_0x0196:
        r4 = r3;
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: gx.Zo():void");
    }

    private void j6(boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        int i = 2;
        if (this.VH == 72) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.VH == 1 && v5() == this.P8) {
            z5 = true;
        } else {
            z5 = false;
        }
        DW();
        if (this.VH != 1) {
            throw new es$a();
        }
        int v5 = v5();
        DW();
        I();
        if (z3) {
            FH(91);
            gn(this.Mr.j6("java"));
            Hw(206, 0);
            FH(16);
            gn(this.Mr.j6("lang"));
            Hw(206, 0);
            FH(16);
            gn(this.Mr.j6("annotation"));
            Hw(206, 0);
            FH(16);
            gn(this.Mr.j6("Annotation"));
            Hw(206, 0);
            Hw(180, 11);
            Hw(192, 2);
            Hw(ProxyTextView.INPUTTYPE_textPhonetic, 0);
        } else {
            if (z5) {
                FH(91);
                gn(this.Mr.j6("Enum"));
                FH(44);
                Hw(230, 0);
                gn(v5);
                Hw(206, 0);
                Hw(180, 2);
                Hw(198, 0);
                FH(48);
                Hw(206, 5);
                Hw(180, 2);
                Hw(192, 2);
            } else if (this.VH == 91) {
                DW();
                if (this.VH != 1) {
                    throw new es$a();
                }
                Qq();
                int i2 = 2;
                while (this.VH == 15) {
                    DW();
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    Qq();
                    i2 += 2;
                }
                FH(192, i2);
            } else {
                FH(192, 0);
            }
            if (this.VH == 102) {
                DW();
                if (this.VH != 1) {
                    throw new es$a();
                }
                Qq();
                while (this.VH == 15) {
                    DW();
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    Qq();
                    i += 2;
                }
                FH(ProxyTextView.INPUTTYPE_textPhonetic, i);
            } else {
                FH(ProxyTextView.INPUTTYPE_textPhonetic, 0);
            }
        }
        if (this.VH != 8) {
            throw new es$a();
        }
        boolean z6 = (z2 || z) ? false : true;
        boolean z7 = (z4 || z5) ? false : true;
        j6(z6, false, z, z7, z5, v5);
        if (z) {
            if (z4) {
                j6(128, false, 7, false);
            } else if (z5) {
                j6(222, false, 7, false);
            } else {
                j6((int) ProxyTextView.INPUTTYPE_textPassword, false, 7, false);
            }
        } else if (z2) {
            if (z4) {
                j6(227, false, 7, false);
            } else if (z5) {
                j6(221, false, 7, false);
            } else {
                j6(228, false, 7, false);
            }
        } else if (z4) {
            j6(120, false, 7, false, v5);
        } else if (z5) {
            j6(220, false, 7, false, v5);
        } else {
            j6(121, false, 7, false, v5);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j6(boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, int r14) {
        /*
        r8 = this;
        r0 = 2;
        r8.DW();
        if (r13 == 0) goto L_0x000b;
    L_0x0006:
        r1 = r8.u7(r14);
        r0 = r0 + r1;
    L_0x000b:
        r1 = 0;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x000f:
        r2 = r8.VH;
        r3 = 14;
        if (r2 != r3) goto L_0x0019;
    L_0x0015:
        r8.Hw();
        goto L_0x000f;
    L_0x0019:
        r2 = r8.VH;
        switch(r2) {
            case 0: goto L_0x004e;
            case 9: goto L_0x0067;
            default: goto L_0x001e;
        };
    L_0x001e:
        r3 = r8.gn;
        r4 = r8.XL;
        if (r10 != 0) goto L_0x0026;
    L_0x0024:
        if (r11 == 0) goto L_0x008a;
    L_0x0026:
        r2 = 1;
    L_0x0027:
        r8.j6(r13, r2);	 Catch:{ es$a -> 0x008c }
        r2 = r8.Zo;	 Catch:{ es$a -> 0x008c }
        r5 = r8.QX;	 Catch:{ es$a -> 0x008c }
        r6 = r8.XL;	 Catch:{ es$a -> 0x008c }
        r5 = r5[r6];	 Catch:{ es$a -> 0x008c }
        r2 = r2.rN(r5);	 Catch:{ es$a -> 0x008c }
        r4 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r2 != r4) goto L_0x003b;
    L_0x003a:
        r0 = 1;
    L_0x003b:
        r1 = r1 + 1;
    L_0x003d:
        r2 = r8.gn;
        if (r2 != r3) goto L_0x0044;
    L_0x0041:
        r8.Hw();
    L_0x0044:
        r2 = r8.VH;
        r3 = 14;
        if (r2 != r3) goto L_0x000f;
    L_0x004a:
        r8.Hw();
        goto L_0x0044;
    L_0x004e:
        r8.tp();
        if (r0 != 0) goto L_0x005c;
    L_0x0053:
        if (r10 != 0) goto L_0x005c;
    L_0x0055:
        if (r12 != 0) goto L_0x005c;
    L_0x0057:
        r8.j6(r14, r13, r11);
        r1 = r1 + 1;
    L_0x005c:
        r0 = 9;
        r8.Hw(r0);
        r0 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        r8.FH(r0, r1);
    L_0x0066:
        return;
    L_0x0067:
        if (r9 == 0) goto L_0x0076;
    L_0x0069:
        r2 = r8.J8();
        if (r2 != 0) goto L_0x0076;
    L_0x006f:
        r8.j6();
        r8.Hw();
        goto L_0x0044;
    L_0x0076:
        if (r0 != 0) goto L_0x0081;
    L_0x0078:
        if (r10 != 0) goto L_0x0081;
    L_0x007a:
        if (r12 != 0) goto L_0x0081;
    L_0x007c:
        r8.j6(r14, r13, r11);
        r1 = r1 + 1;
    L_0x0081:
        r8.DW();
        r0 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        r8.FH(r0, r1);
        goto L_0x0066;
    L_0x008a:
        r2 = 0;
        goto L_0x0027;
    L_0x008c:
        r2 = move-exception;
        r8.tp();
        r8.XL = r4;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: gx.j6(boolean, boolean, boolean, boolean, boolean, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int u7(int r12) {
        /*
        r11 = this;
        r0 = 0;
        r2 = 0;
        r10 = new do;
        r10.<init>();
        r1 = r11.XL;
        r3 = r11.VH;	 Catch:{ es$a -> 0x018a }
        r4 = 14;
        if (r3 == r4) goto L_0x002e;
    L_0x000f:
        r3 = r11.VH;	 Catch:{ es$a -> 0x018a }
        r4 = 9;
        if (r3 == r4) goto L_0x002e;
    L_0x0015:
        r7 = r1;
        r9 = r2;
        r8 = r0;
    L_0x0018:
        r11.sG();	 Catch:{ es$a -> 0x0026 }
        r0 = r11.VH;	 Catch:{ es$a -> 0x0026 }
        r1 = 1;
        if (r0 == r1) goto L_0x0095;
    L_0x0020:
        r0 = new es$a;	 Catch:{ es$a -> 0x0026 }
        r0.<init>();	 Catch:{ es$a -> 0x0026 }
        throw r0;	 Catch:{ es$a -> 0x0026 }
    L_0x0026:
        r0 = move-exception;
        r1 = r7;
        r0 = r8;
    L_0x0029:
        r11.tp();
        r11.XL = r1;
    L_0x002e:
        r1 = 94;
        r11.FH(r1);
        r1 = 86;
        r11.FH(r1);
        r1 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r11.gn(r12);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 10;
        r11.FH(r1);
        r1 = 11;
        r11.FH(r1);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "$VALUES";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 17;
        r11.FH(r1);
        r1 = 8;
        r11.FH(r1);
        r1 = 0;
    L_0x007a:
        r2 = r10.Hw();
        if (r1 >= r2) goto L_0x024b;
    L_0x0080:
        r2 = r10.FH(r1);
        r11.gn(r2);
        r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r3 = 1;
        r11.Hw(r2, r3);
        r2 = 15;
        r11.FH(r2);
        r1 = r1 + 1;
        goto L_0x007a;
    L_0x0095:
        r11.gn(r12);	 Catch:{ es$a -> 0x0026 }
        r0 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r1 = 0;
        r11.Hw(r0, r1);	 Catch:{ es$a -> 0x0026 }
        r0 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r1 = 2;
        r11.Hw(r0, r1);	 Catch:{ es$a -> 0x0026 }
        r0 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r1 = 0;
        r11.Hw(r0, r1);	 Catch:{ es$a -> 0x0026 }
        r0 = r11.v5();	 Catch:{ es$a -> 0x0026 }
        r10.DW(r0);	 Catch:{ es$a -> 0x0026 }
        r11.DW();	 Catch:{ es$a -> 0x0026 }
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);	 Catch:{ es$a -> 0x0026 }
        r1 = 17;
        r11.FH(r1);	 Catch:{ es$a -> 0x0026 }
        r1 = 58;
        r11.FH(r1);	 Catch:{ es$a -> 0x0026 }
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);	 Catch:{ es$a -> 0x0026 }
        r11.gn(r12);	 Catch:{ es$a -> 0x0026 }
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);	 Catch:{ es$a -> 0x0026 }
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r2 = 2;
        r11.Hw(r1, r2);	 Catch:{ es$a -> 0x0026 }
        r1 = r11.VH;	 Catch:{ es$a -> 0x0026 }
        r2 = 12;
        if (r1 != r2) goto L_0x01cd;
    L_0x00df:
        r11.DW();	 Catch:{ es$a -> 0x0026 }
        r1 = new java.lang.StringBuilder;	 Catch:{ es$a -> 0x0026 }
        r1.<init>();	 Catch:{ es$a -> 0x0026 }
        r2 = "\"";
        r1 = r1.append(r2);	 Catch:{ es$a -> 0x0026 }
        r2 = r11.Mr;	 Catch:{ es$a -> 0x0026 }
        r0 = r2.j6(r0);	 Catch:{ es$a -> 0x0026 }
        r0 = r1.append(r0);	 Catch:{ es$a -> 0x0026 }
        r1 = "\"";
        r0 = r0.append(r1);	 Catch:{ es$a -> 0x0026 }
        r0 = r0.toString();	 Catch:{ es$a -> 0x0026 }
        r1 = 2;
        r2 = r11.Zo;	 Catch:{ es$a -> 0x0026 }
        r3 = r0.toCharArray();	 Catch:{ es$a -> 0x0026 }
        r4 = 0;
        r0 = r0.length();	 Catch:{ es$a -> 0x0026 }
        r0 = r2.j6(r3, r4, r0);	 Catch:{ es$a -> 0x0026 }
        r11.j6(r1, r0);	 Catch:{ es$a -> 0x0026 }
        r0 = 15;
        r11.FH(r0);	 Catch:{ es$a -> 0x0026 }
        r0 = java.lang.Integer.toString(r9);	 Catch:{ es$a -> 0x0026 }
        r1 = 4;
        r2 = r11.Zo;	 Catch:{ es$a -> 0x0026 }
        r3 = r0.toCharArray();	 Catch:{ es$a -> 0x0026 }
        r4 = 0;
        r0 = r0.length();	 Catch:{ es$a -> 0x0026 }
        r0 = r2.j6(r3, r4, r0);	 Catch:{ es$a -> 0x0026 }
        r11.j6(r1, r0);	 Catch:{ es$a -> 0x0026 }
        r0 = r11.VH;	 Catch:{ es$a -> 0x0026 }
        r1 = 13;
        if (r0 != r1) goto L_0x018d;
    L_0x0138:
        r11.DW();	 Catch:{ es$a -> 0x0026 }
        r0 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
        r1 = 5;
        r11.FH(r0, r1);	 Catch:{ es$a -> 0x0026 }
    L_0x0141:
        r0 = r11.VH;	 Catch:{ es$a -> 0x0026 }
        r1 = 8;
        if (r0 != r1) goto L_0x022f;
    L_0x0147:
        r1 = 0;
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r0 = r11;
        r0.j6(r1, r2, r3, r4, r5, r6);	 Catch:{ es$a -> 0x0026 }
        r0 = 177; // 0xb1 float:2.48E-43 double:8.74E-322;
        r1 = 0;
        r2 = 5;
        r3 = 0;
        r11.j6(r0, r1, r2, r3);	 Catch:{ es$a -> 0x0026 }
    L_0x0159:
        r0 = 194; // 0xc2 float:2.72E-43 double:9.6E-322;
        r1 = 0;
        r2 = 4;
        r3 = 0;
        r11.j6(r0, r1, r2, r3);	 Catch:{ es$a -> 0x0026 }
        r0 = 14;
        r11.FH(r0);	 Catch:{ es$a -> 0x0026 }
        r0 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r1 = 5;
        r11.FH(r0, r1);	 Catch:{ es$a -> 0x0026 }
        r0 = r8 + 1;
        r2 = r9 + 1;
        r1 = r11.XL;	 Catch:{ es$a -> 0x0531 }
        r3 = r11.VH;	 Catch:{ es$a -> 0x018a }
        r4 = 14;
        if (r3 == r4) goto L_0x002e;
    L_0x0178:
        r3 = r11.VH;	 Catch:{ es$a -> 0x018a }
        r4 = 9;
        if (r3 == r4) goto L_0x002e;
    L_0x017e:
        r3 = r11.VH;	 Catch:{ es$a -> 0x018a }
        r4 = 15;
        if (r3 == r4) goto L_0x0237;
    L_0x0184:
        r2 = new es$a;	 Catch:{ es$a -> 0x018a }
        r2.<init>();	 Catch:{ es$a -> 0x018a }
        throw r2;	 Catch:{ es$a -> 0x018a }
    L_0x018a:
        r2 = move-exception;
        goto L_0x0029;
    L_0x018d:
        r0 = 15;
        r11.FH(r0);	 Catch:{ es$a -> 0x0026 }
        r0 = 7;
        r1 = r11.XL;	 Catch:{ es$a -> 0x0026 }
        r11.gW();	 Catch:{ es$a -> 0x01a9 }
    L_0x0198:
        r1 = r11.VH;	 Catch:{ es$a -> 0x0026 }
        r2 = 15;
        if (r1 != r2) goto L_0x01c1;
    L_0x019e:
        r11.DW();	 Catch:{ es$a -> 0x0026 }
        r1 = r11.XL;	 Catch:{ es$a -> 0x0026 }
        r11.gW();	 Catch:{ es$a -> 0x01b5 }
    L_0x01a6:
        r0 = r0 + 2;
        goto L_0x0198;
    L_0x01a9:
        r2 = move-exception;
        r11.XL = r1;	 Catch:{ es$a -> 0x0026 }
        r1 = 66;
        r11.FH(r1);	 Catch:{ es$a -> 0x0026 }
        r11.gn();	 Catch:{ es$a -> 0x0026 }
        goto L_0x0198;
    L_0x01b5:
        r2 = move-exception;
        r11.XL = r1;	 Catch:{ es$a -> 0x0026 }
        r1 = 66;
        r11.FH(r1);	 Catch:{ es$a -> 0x0026 }
        r11.gn();	 Catch:{ es$a -> 0x0026 }
        goto L_0x01a6;
    L_0x01c1:
        r1 = 13;
        r11.Hw(r1);	 Catch:{ es$a -> 0x0026 }
        r1 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
        r11.FH(r1, r0);	 Catch:{ es$a -> 0x0026 }
        goto L_0x0141;
    L_0x01cd:
        r1 = 12;
        r11.FH(r1);	 Catch:{ es$a -> 0x0026 }
        r1 = new java.lang.StringBuilder;	 Catch:{ es$a -> 0x0026 }
        r1.<init>();	 Catch:{ es$a -> 0x0026 }
        r2 = "\"";
        r1 = r1.append(r2);	 Catch:{ es$a -> 0x0026 }
        r2 = r11.Mr;	 Catch:{ es$a -> 0x0026 }
        r0 = r2.j6(r0);	 Catch:{ es$a -> 0x0026 }
        r0 = r1.append(r0);	 Catch:{ es$a -> 0x0026 }
        r1 = "\"";
        r0 = r0.append(r1);	 Catch:{ es$a -> 0x0026 }
        r0 = r0.toString();	 Catch:{ es$a -> 0x0026 }
        r1 = 2;
        r2 = r11.Zo;	 Catch:{ es$a -> 0x0026 }
        r3 = r0.toCharArray();	 Catch:{ es$a -> 0x0026 }
        r4 = 0;
        r0 = r0.length();	 Catch:{ es$a -> 0x0026 }
        r0 = r2.j6(r3, r4, r0);	 Catch:{ es$a -> 0x0026 }
        r11.j6(r1, r0);	 Catch:{ es$a -> 0x0026 }
        r0 = 15;
        r11.FH(r0);	 Catch:{ es$a -> 0x0026 }
        r0 = java.lang.Integer.toString(r9);	 Catch:{ es$a -> 0x0026 }
        r1 = 4;
        r2 = r11.Zo;	 Catch:{ es$a -> 0x0026 }
        r3 = r0.toCharArray();	 Catch:{ es$a -> 0x0026 }
        r4 = 0;
        r0 = r0.length();	 Catch:{ es$a -> 0x0026 }
        r0 = r2.j6(r3, r4, r0);	 Catch:{ es$a -> 0x0026 }
        r11.j6(r1, r0);	 Catch:{ es$a -> 0x0026 }
        r0 = 13;
        r11.FH(r0);	 Catch:{ es$a -> 0x0026 }
        r0 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
        r1 = 5;
        r11.FH(r0, r1);	 Catch:{ es$a -> 0x0026 }
        goto L_0x0141;
    L_0x022f:
        r0 = 176; // 0xb0 float:2.47E-43 double:8.7E-322;
        r1 = 4;
        r11.FH(r0, r1);	 Catch:{ es$a -> 0x0026 }
        goto L_0x0159;
    L_0x0237:
        r11.Hw();	 Catch:{ es$a -> 0x018a }
        r3 = r11.VH;	 Catch:{ es$a -> 0x018a }
        r4 = 14;
        if (r3 == r4) goto L_0x002e;
    L_0x0240:
        r3 = r11.VH;	 Catch:{ es$a -> 0x018a }
        r4 = 9;
        if (r3 == r4) goto L_0x002e;
    L_0x0246:
        r7 = r1;
        r9 = r2;
        r8 = r0;
        goto L_0x0018;
    L_0x024b:
        r1 = 9;
        r11.FH(r1);
        r1 = 196; // 0xc4 float:2.75E-43 double:9.7E-322;
        r2 = r10.Hw();
        r2 = r2 * 2;
        r2 = r2 + 2;
        r11.Hw(r1, r2);
        r1 = 194; // 0xc2 float:2.72E-43 double:9.6E-322;
        r2 = 1;
        r3 = 4;
        r4 = 0;
        r11.j6(r1, r2, r3, r4);
        r1 = 14;
        r11.FH(r1);
        r1 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r2 = 5;
        r11.Hw(r1, r2);
        r1 = 84;
        r11.FH(r1);
        r1 = 86;
        r11.FH(r1);
        r1 = 75;
        r11.FH(r1);
        r1 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r2 = 3;
        r11.Hw(r1, r2);
        r1 = 207; // 0xcf float:2.9E-43 double:1.023E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r11.gn(r12);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 10;
        r11.FH(r1);
        r1 = 11;
        r11.FH(r1);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "values";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 12;
        r11.FH(r1);
        r1 = 13;
        r11.FH(r1);
        r1 = 190; // 0xbe float:2.66E-43 double:9.4E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 195; // 0xc3 float:2.73E-43 double:9.63E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 8;
        r11.FH(r1);
        r1 = 85;
        r11.FH(r1);
        r1 = r11.Mr;
        r2 = "$VALUES";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 16;
        r11.FH(r1);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "clone";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 12;
        r11.FH(r1);
        r1 = 13;
        r11.FH(r1);
        r1 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 156; // 0x9c float:2.19E-43 double:7.7E-322;
        r2 = 5;
        r11.Hw(r1, r2);
        r1 = 14;
        r11.FH(r1);
        r1 = 141; // 0x8d float:1.98E-43 double:6.97E-322;
        r2 = 3;
        r11.Hw(r1, r2);
        r1 = 8;
        r11.FH(r1);
        r1 = 133; // 0x85 float:1.86E-43 double:6.57E-322;
        r2 = 3;
        r11.Hw(r1, r2);
        r1 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r2 = 1;
        r3 = 9;
        r4 = 0;
        r11.j6(r1, r2, r3, r4);
        r1 = 84;
        r11.FH(r1);
        r1 = 86;
        r11.FH(r1);
        r1 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 207; // 0xcf float:2.9E-43 double:1.023E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r11.gn(r12);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "valueOf";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 12;
        r11.FH(r1);
        r1 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "String";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "name";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 191; // 0xbf float:2.68E-43 double:9.44E-322;
        r2 = 5;
        r11.Hw(r1, r2);
        r1 = 13;
        r11.FH(r1);
        r1 = 190; // 0xbe float:2.66E-43 double:9.4E-322;
        r2 = 3;
        r11.Hw(r1, r2);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 195; // 0xc3 float:2.73E-43 double:9.63E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 8;
        r11.FH(r1);
        r1 = 56;
        r11.FH(r1);
        r1 = 12;
        r11.FH(r1);
        r1 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r11.gn(r12);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "e";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 26;
        r11.FH(r1);
        r1 = r11.Mr;
        r2 = "$VALUES";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r2 = 1;
        r11.Hw(r1, r2);
        r1 = 13;
        r11.FH(r1);
        r1 = 55;
        r11.FH(r1);
        r1 = 12;
        r11.FH(r1);
        r1 = r11.Mr;
        r2 = "e";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 16;
        r11.FH(r1);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "name";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 12;
        r11.FH(r1);
        r1 = 13;
        r11.FH(r1);
        r1 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 156; // 0x9c float:2.19E-43 double:7.7E-322;
        r2 = 5;
        r11.Hw(r1, r2);
        r1 = 16;
        r11.FH(r1);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "equals";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 12;
        r11.FH(r1);
        r1 = r11.Mr;
        r2 = "name";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r2 = 1;
        r11.Hw(r1, r2);
        r1 = 13;
        r11.FH(r1);
        r1 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
        r2 = 3;
        r11.Hw(r1, r2);
        r1 = 155; // 0x9b float:2.17E-43 double:7.66E-322;
        r2 = 5;
        r11.Hw(r1, r2);
        r1 = 13;
        r11.FH(r1);
        r1 = 85;
        r11.FH(r1);
        r1 = r11.Mr;
        r2 = "e";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r2 = 1;
        r11.Hw(r1, r2);
        r1 = 14;
        r11.FH(r1);
        r1 = 141; // 0x8d float:1.98E-43 double:6.97E-322;
        r2 = 3;
        r11.Hw(r1, r2);
        r1 = 135; // 0x87 float:1.89E-43 double:6.67E-322;
        r2 = 5;
        r11.Hw(r1, r2);
        r1 = 211; // 0xd3 float:2.96E-43 double:1.042E-321;
        r2 = 11;
        r11.Hw(r1, r2);
        r1 = 79;
        r11.FH(r1);
        r1 = 58;
        r11.FH(r1);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = r11.Mr;
        r2 = "IllegalArgumentException";
        r1 = r1.j6(r2);
        r11.gn(r1);
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r2 = 0;
        r11.Hw(r1, r2);
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 12;
        r11.FH(r1);
        r1 = 13;
        r11.FH(r1);
        r1 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
        r2 = 2;
        r11.Hw(r1, r2);
        r1 = 176; // 0xb0 float:2.47E-43 double:8.7E-322;
        r2 = 4;
        r11.Hw(r1, r2);
        r1 = 14;
        r11.FH(r1);
        r1 = 142; // 0x8e float:1.99E-43 double:7.0E-322;
        r2 = 3;
        r11.Hw(r1, r2);
        r1 = 9;
        r11.FH(r1);
        r1 = 133; // 0x85 float:1.86E-43 double:6.57E-322;
        r2 = 4;
        r11.Hw(r1, r2);
        r1 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r2 = 1;
        r3 = 9;
        r4 = 0;
        r11.j6(r1, r2, r3, r4);
        r0 = r0 + 3;
        return r0;
    L_0x0531:
        r1 = move-exception;
        r1 = r7;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: gx.u7(int):int");
    }

    private void j6(boolean z, boolean z2) {
        boolean z3 = false;
        boolean z4 = true;
        int ef = ef();
        switch (this.VH) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (v5() == this.P8) {
                    j6(false, true, (ef & 536870912) != 0);
                } else if (Zo(1) == 12) {
                    FH(207, 0);
                    DW();
                    if (z) {
                        rN();
                    } else {
                        dx();
                    }
                    cb();
                    if (this.VH == 14) {
                        DW();
                    } else if (this.VH != 8) {
                        throw new es$a();
                    } else {
                        Hw(z);
                    }
                    if (!(cd.QX(ef) || z2)) {
                        z4 = false;
                    }
                    j6(123, false, 6, z4);
                } else if (U2()) {
                    FH(207, 0);
                    x9();
                    sy();
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    if (cd.QX(ef) || z2) {
                        z3 = true;
                    }
                    j6(z3);
                } else {
                    x9();
                    sy();
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    if (cd.QX(ef) || z2) {
                        z3 = true;
                    }
                    DW(z3);
                }
            case 8:
                er();
                j6(127, false, 2, true);
            case 44:
                I();
                if (this.VH == 1 && Zo(1) == 12) {
                    DW();
                    if (z) {
                        rN();
                    } else {
                        dx();
                    }
                    cb();
                    if (this.VH == 14) {
                        DW();
                    } else if (this.VH != 8) {
                        throw new es$a();
                    } else {
                        Hw(z);
                    }
                    if (!(cd.QX(ef) || z2)) {
                        z4 = false;
                    }
                    j6(123, false, 6, z4);
                    return;
                }
                x9();
                sy();
                if (this.VH != 1) {
                    throw new es$a();
                }
                if (cd.QX(ef) || z2) {
                    z3 = true;
                }
                j6(z3);
            case 57:
            case 60:
            case 62:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 69:
            case 76:
            case 77:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 89:
            case 114:
                if (U2()) {
                    FH(207, 0);
                    x9();
                    sy();
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    if (cd.QX(ef) || z2) {
                        z3 = true;
                    }
                    j6(z3);
                    return;
                }
                x9();
                sy();
                if (this.VH != 1) {
                    throw new es$a();
                }
                if (cd.QX(ef) || z2) {
                    z3 = true;
                }
                DW(z3);
            case 72:
            case 99:
            case 107:
                boolean z5;
                if ((ef & 536870912) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                j6(false, true, z5);
            case 118:
                FH(true);
            case 119:
                Hw();
                FH(true);
            default:
                throw new es$a();
        }
    }

    private void rN() {
        DW();
        DW(199, true, 0);
        gn(this.Mr.j6("String"));
        FH(206, 0);
        FH(180, 2);
        FH(198, 0);
        gn(this.Mr.j6("$name"));
        FH(198, 0);
        FH(191, 5);
        FH(15);
        FH(199, 0);
        FH(57);
        FH(180, 1);
        FH(198, 0);
        gn(this.Mr.j6("$ordinal"));
        FH(198, 0);
        FH(191, 5);
        if (this.VH == 13) {
            DW();
            FH(190, 5);
            return;
        }
        FH(15);
        int i = 6;
        while (true) {
            g3();
            x9();
            sy();
            if (this.VH != 1) {
                throw new es$a();
            }
            DW();
            sy();
            FH(191, 5);
            i++;
            switch (this.VH) {
                case 13:
                    DW();
                    FH(190, i);
                    return;
                case 15:
                    DW();
                    i++;
                default:
                    Hw(13);
                    FH(190, i);
                    return;
            }
        }
    }

    private void j6(boolean z) {
        DW();
        if (this.VH != 12) {
            throw new es$a();
        }
        dx();
        sy();
        cb();
        switch (this.VH) {
            case 8:
                er();
                j6(124, false, 9, z);
            case 14:
                DW();
                j6(124, false, 9, z);
            case 90:
                DW();
                switch (this.VH) {
                    case 8:
                        cn();
                        break;
                    case 115:
                        DW();
                        vJ();
                        break;
                    default:
                        gW();
                        break;
                }
                Hw(14);
                FH(232, 3);
                j6(124, false, 9, z);
            default:
                FH(14);
                j6(124, false, 9, z);
        }
    }

    private void DW(boolean z) {
        DW();
        sy();
        if (this.VH == 17) {
            DW();
            if (this.VH == 8) {
                cn();
                j6(194, false, 4, z);
            } else {
                gW();
                j6(194, false, 4, z);
            }
        } else {
            j6(194, false, 2, z);
        }
        int i = 5;
        while (this.VH == 15) {
            DW();
            if (this.VH != 1) {
                throw new es$a();
            }
            DW();
            sy();
            if (this.VH == 17) {
                DW();
                if (this.VH == 8) {
                    cn();
                    j6(194, false, 4, z);
                } else {
                    gW();
                    j6(194, false, 4, z);
                }
            } else {
                j6(194, false, 2, z);
            }
            i += 2;
        }
        Hw(14);
        FH(126, i);
    }

    private void FH(boolean z) {
        DW();
        x9();
        sy();
        if (this.VH != 1) {
            throw new es$a();
        }
        DW();
        dx();
        Hw(14);
        if (z) {
            FH(246, 7);
        } else {
            FH(245, 7);
        }
    }

    private void Hw(boolean z) {
        DW();
        if (!Mr()) {
            Hw(206, 0);
            FH(78);
            if (z) {
                FH(12);
                gn(this.Mr.j6("$name"));
                Hw(ProxyTextView.INPUTTYPE_textWebEditText, 1);
                FH(15);
                gn(this.Mr.j6("$ordinal"));
                Hw(ProxyTextView.INPUTTYPE_textWebEditText, 1);
                FH(13);
                Hw(197, 5);
            } else {
                FH(12);
                FH(13);
                Hw(197, 2);
            }
            we();
            Hw(164, 4);
            FH(14);
            Hw(146, 2);
            tp(3);
        } else if (z && this.VH == 67 && Zo(1) == 12) {
            FH(206, 0);
            DW();
            DW();
            gn(this.Mr.j6("$name"));
            FH(ProxyTextView.INPUTTYPE_textWebEditText, 1);
            FH(15);
            gn(this.Mr.j6("$ordinal"));
            FH(ProxyTextView.INPUTTYPE_textWebEditText, 1);
            if (this.VH == 13) {
                DW();
                FH(197, 5);
            } else {
                FH(15);
                int i = 7;
                int i2 = this.XL;
                try {
                    gW();
                } catch (es$a e) {
                    this.XL = i2;
                    FH(66);
                    gn();
                }
                while (this.VH == 15) {
                    DW();
                    i2 = this.XL;
                    try {
                        gW();
                    } catch (es$a e2) {
                        this.XL = i2;
                        FH(66);
                        gn();
                    }
                    i += 2;
                }
                Hw(13);
                FH(197, i);
            }
            we();
            FH(163, 4);
            Hw(14);
            FH(146, 2);
            tp(3);
        } else {
            tp(2);
        }
    }

    private void er() {
        Hw(8);
        tp(2);
    }

    private void tp(int i) {
        while (true) {
            switch (this.VH) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                case 83:
                case 84:
                case 86:
                case 94:
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                case 98:
                case 100:
                case 101:
                    Hw(9);
                    FH(133, i);
                    return;
                case 9:
                    DW();
                    FH(133, i);
                    return;
                default:
                    int i2 = this.gn;
                    int i3 = this.XL + 1;
                    try {
                        yS();
                        i++;
                    } catch (es$a e) {
                        if (e instanceof gx$a) {
                            j6();
                        } else {
                            VH();
                        }
                        int i4 = this.XL;
                        int i5 = i3;
                        int i6 = i;
                        while (i5 <= i4) {
                            switch (this.Zo.rN(this.QX[i5])) {
                                case 155:
                                case 156:
                                case 157:
                                case 159:
                                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                                case 162:
                                case 165:
                                case 166:
                                case 167:
                                case 168:
                                case 169:
                                case 170:
                                case 171:
                                case 172:
                                case 173:
                                case 175:
                                case 176:
                                case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                                    this.XL++;
                                    if (this.XL >= this.QX.length) {
                                        Object obj = new int[((this.QX.length * 2) + 1)];
                                        System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
                                        this.QX = obj;
                                    }
                                    this.QX[this.XL] = this.QX[i5];
                                    FH(14);
                                    FH(146, 2);
                                    i6++;
                                    break;
                                case 201:
                                case 202:
                                case 203:
                                    if (this.Zo.lg(this.QX[i5]) > 1 || (this.Zo.lg(this.QX[i5]) == 1 && this.Zo.rN(this.QX[i5]) == 202)) {
                                        int Hw = this.Zo.Hw(this.QX[i5], 0);
                                        Object obj2;
                                        if (this.Zo.rN(Hw) == 151) {
                                            this.XL++;
                                            if (this.XL >= this.QX.length) {
                                                obj2 = new int[((this.QX.length * 2) + 1)];
                                                System.arraycopy(this.QX, 0, obj2, 0, this.QX.length);
                                                this.QX = obj2;
                                            }
                                            this.QX[this.XL] = Hw;
                                        } else {
                                            this.XL++;
                                            if (this.XL >= this.QX.length) {
                                                obj2 = new int[((this.QX.length * 2) + 1)];
                                                System.arraycopy(this.QX, 0, obj2, 0, this.QX.length);
                                                this.QX = obj2;
                                            }
                                            this.QX[this.XL] = Hw;
                                            FH(14);
                                            FH(146, 2);
                                        }
                                        i6++;
                                        break;
                                    }
                                default:
                                    break;
                            }
                            i5++;
                        }
                        System.arraycopy(this.QX, i4 + 1, this.QX, i3, this.XL - i4);
                        this.XL -= (i4 - i3) + 1;
                        i = i6;
                    }
                    if (this.gn == i2) {
                        Hw();
                    }
            }
        }
    }

    private void yS() {
        int i;
        switch (this.VH) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (v5() == this.P8 && Zo(1) == 1) {
                    DW(199, false, 0);
                    j6(true, false, false);
                } else if (Zo(1) == 26) {
                    DW();
                    DW();
                    yS();
                    FH(148, 3);
                } else if (aM()) {
                    v5(true);
                } else {
                    gW();
                    Hw(14);
                    FH(146, 2);
                }
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
            case 7:
            case 12:
            case 21:
            case 22:
            case 24:
            case 27:
            case 28:
            case 34:
            case 44:
            case 57:
            case 58:
            case 60:
            case 62:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 66:
            case 67:
            case 68:
            case 69:
            case 74:
            case 76:
            case 77:
            case 78:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 89:
            case 114:
                if (aM()) {
                    v5(true);
                    return;
                }
                gW();
                Hw(14);
                FH(146, 2);
            case 8:
                er();
            case 14:
                DW();
                FH(134, 1);
            case 54:
                DW();
                yS();
                if (this.VH != 80) {
                    throw new es$a();
                }
                DW();
                Hw(12);
                gW();
                Hw(13);
                Hw(14);
                FH(ProxyTextView.INPUTTYPE_textVisiblePassword, 7);
            case 55:
                DW();
                Hw(12);
                gW();
                Hw(13);
                yS();
                if (this.VH == 63) {
                    DW();
                    yS();
                    FH(136, 7);
                    return;
                }
                FH(135, 5);
            case 56:
                DW();
                Hw(12);
                if (this.VH == 14) {
                    DW();
                    FH(201, 1);
                } else if (j3()) {
                    g3();
                    x9();
                    sy();
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    DW();
                    sy();
                    Hw(26);
                    gW();
                    Hw(13);
                    yS();
                    FH(211, 11);
                    return;
                } else if (this.VH == 75 || aM()) {
                    v5(true);
                    FH(201, 1);
                } else {
                    gW();
                    i = 2;
                    while (this.VH == 15) {
                        DW();
                        gW();
                        i += 2;
                    }
                    Hw(14);
                    FH(201, i);
                }
                if (this.VH == 14) {
                    DW();
                    FH(203, 1);
                } else {
                    gW();
                    Hw(14);
                    FH(203, 2);
                }
                if (this.VH == 13) {
                    FH(202, 0);
                } else {
                    gW();
                    i = 1;
                    while (this.VH == 15) {
                        DW();
                        gW();
                        i += 2;
                    }
                    FH(202, i);
                }
                Hw(13);
                yS();
                FH(149, 7);
            case 59:
                DW();
                if (this.VH == 12) {
                    DW();
                    i = 5;
                    v5(false);
                    while (aM()) {
                        v5(false);
                        i++;
                    }
                    Hw(13);
                    er();
                    FH(212, i);
                } else if (this.VH != 8) {
                    throw new es$a();
                } else {
                    er();
                    i = 2;
                    while (this.VH == 71) {
                        DW();
                        Hw(12);
                        g3();
                        if (this.VH != 1) {
                            throw new es$a();
                        }
                        Qq();
                        int i2 = 1;
                        while (this.VH == 38) {
                            DW();
                            Qq();
                            i2 += 2;
                        }
                        FH(216, i2);
                        if (this.VH != 1) {
                            throw new es$a();
                        }
                        DW();
                        Hw(13);
                        if (this.VH != 8) {
                            throw new es$a();
                        }
                        er();
                        FH(204, 7);
                        i++;
                    }
                    if (this.VH == 92) {
                        DW();
                        if (this.VH != 8) {
                            throw new es$a();
                        }
                        er();
                        FH(205, 2);
                        i++;
                    }
                    FH(150, i);
                }
            case 61:
                DW();
                gW();
                Hw(26);
                FH(143, 3);
            case 70:
                DW();
                if (this.VH == 1) {
                    DW();
                    Hw(14);
                    FH(138, 3);
                    return;
                }
                Hw(14);
                FH(138, 2);
            case 72:
            case 99:
            case 107:
                DW(199, false, 0);
                j6(true, false, false);
            case 75:
            case 95:
            case 115:
                g3();
                switch (this.VH) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        if (v5() == this.P8) {
                            DW(199, false, 0);
                            j6(true, false, false);
                            return;
                        }
                        x9();
                        sy();
                        Zo(true);
                    case 72:
                    case 99:
                    case 107:
                        j6(true, false, false);
                    default:
                        x9();
                        sy();
                        Zo(true);
                }
            case 79:
                DW();
                gW();
                Hw(14);
                FH(142, 3);
            case 80:
                DW();
                Hw(12);
                gW();
                Hw(13);
                yS();
                FH(137, 5);
            case 85:
                DW();
                if (this.VH == 14) {
                    DW();
                    FH(141, 2);
                    return;
                }
                gW();
                Hw(14);
                FH(141, 3);
            case 87:
                DW();
                Hw(12);
                gW();
                Hw(13);
                if (this.VH != 8) {
                    throw new es$a();
                }
                er();
                FH(147, 5);
            case 90:
                DW();
                Hw(26);
                FH(144, 2);
            case 96:
                DW();
                if (this.VH == 1) {
                    DW();
                    Hw(14);
                    FH(139, 3);
                    return;
                }
                Hw(14);
                FH(139, 2);
            case 104:
                DW();
                Hw(12);
                gW();
                Hw(13);
                if (this.VH != 8) {
                    throw new es$a();
                }
                er();
                FH(140, 5);
            case 105:
                DW();
                gW();
                if (this.VH == 26) {
                    DW();
                    gW();
                    Hw(14);
                    FH(ProxyTextView.INPUTTYPE_textWebEmailAddress, 5);
                    return;
                }
                Hw(14);
                FH(ProxyTextView.INPUTTYPE_textWebEmailAddress, 3);
            default:
                throw new gx$a();
        }
    }

    private void v5(boolean z) {
        g3();
        x9();
        sy();
        Zo(z);
    }

    private void Zo(boolean z) {
        int i = 5;
        if (this.VH != 1) {
            throw new es$a();
        }
        DW();
        sy();
        if (this.VH == 17) {
            DW();
            if (this.VH == 8) {
                cn();
                FH(200, 4);
            } else {
                int i2 = this.XL;
                try {
                    gW();
                } catch (es$a e) {
                    this.XL = i2;
                    FH(66);
                }
                FH(200, 4);
            }
        } else {
            FH(200, 2);
        }
        while (this.VH == 15) {
            DW();
            if (this.VH != 1) {
                throw new es$a();
            }
            DW();
            sy();
            if (this.VH == 17) {
                DW();
                if (this.VH == 8) {
                    cn();
                    FH(200, 4);
                } else {
                    gW();
                    FH(200, 4);
                }
            } else {
                FH(200, 2);
            }
            i += 2;
        }
        if (z) {
            Hw(14);
        } else if (this.VH == 14) {
            DW();
        } else {
            FH(14);
        }
        FH(151, i);
    }

    private void gW() {
        P8();
        BT();
        vy();
    }

    private void BT() {
        while (true) {
            switch (this.VH) {
                case 22:
                case 28:
                    DW();
                    FH(171, 2);
                    break;
                case 103:
                    DW();
                    x9();
                    sy();
                    FH(173, 4);
                    break;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void vy() {
        /*
        r8 = this;
        r1 = 0;
        r3 = r8.BT;
        r2 = r1;
    L_0x0004:
        r0 = r8.VH;	 Catch:{ es$a -> 0x009d }
        switch(r0) {
            case 17: goto L_0x001b;
            case 18: goto L_0x001b;
            case 19: goto L_0x001b;
            case 20: goto L_0x001b;
            case 21: goto L_0x001b;
            case 22: goto L_0x0009;
            case 23: goto L_0x001b;
            case 24: goto L_0x0009;
            case 25: goto L_0x001b;
            case 26: goto L_0x0009;
            case 27: goto L_0x001b;
            case 28: goto L_0x0009;
            case 29: goto L_0x001b;
            case 30: goto L_0x001b;
            case 31: goto L_0x001b;
            case 32: goto L_0x001b;
            case 33: goto L_0x001b;
            case 34: goto L_0x0009;
            case 35: goto L_0x001b;
            case 36: goto L_0x001b;
            case 37: goto L_0x001b;
            case 38: goto L_0x001b;
            case 39: goto L_0x001b;
            case 40: goto L_0x001b;
            case 41: goto L_0x001b;
            case 42: goto L_0x001b;
            case 43: goto L_0x001b;
            case 44: goto L_0x001b;
            case 45: goto L_0x001b;
            case 46: goto L_0x001b;
            case 47: goto L_0x001b;
            case 48: goto L_0x001b;
            case 49: goto L_0x001b;
            case 50: goto L_0x001b;
            case 51: goto L_0x001b;
            case 52: goto L_0x001b;
            case 53: goto L_0x001b;
            default: goto L_0x0009;
        };	 Catch:{ es$a -> 0x009d }
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 >= r2) goto L_0x00f6;
    L_0x000c:
        r1 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r1 = r1 + -1;
        r8.BT = r1;	 Catch:{ es$a -> 0x009d }
        r1 = 172; // 0xac float:2.41E-43 double:8.5E-322;
        r4 = 3;
        r8.FH(r1, r4);	 Catch:{ es$a -> 0x009d }
        r0 = r0 + 1;
        goto L_0x000a;
    L_0x001b:
        r0 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r4 = r8.gW;	 Catch:{ es$a -> 0x009d }
        r4 = r4.length;	 Catch:{ es$a -> 0x009d }
        if (r0 < r4) goto L_0x0037;
    L_0x0022:
        r0 = r8.gW;	 Catch:{ es$a -> 0x009d }
        r0 = r0.length;	 Catch:{ es$a -> 0x009d }
        r0 = r0 * 2;
        r0 = r0 + 1;
        r0 = new int[r0];	 Catch:{ es$a -> 0x009d }
        r4 = r8.gW;	 Catch:{ es$a -> 0x009d }
        r5 = 0;
        r6 = 0;
        r7 = r8.gW;	 Catch:{ es$a -> 0x009d }
        r7 = r7.length;	 Catch:{ es$a -> 0x009d }
        java.lang.System.arraycopy(r4, r5, r0, r6, r7);	 Catch:{ es$a -> 0x009d }
        r8.gW = r0;	 Catch:{ es$a -> 0x009d }
    L_0x0037:
        r0 = r8.gW;	 Catch:{ es$a -> 0x009d }
        r4 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r5 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r0[r4] = r5;	 Catch:{ es$a -> 0x009d }
        r0 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r0 = r0 + 1;
        r8.BT = r0;	 Catch:{ es$a -> 0x009d }
        r0 = r2 + 1;
        r2 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r4 = 25;
        if (r2 != r4) goto L_0x006b;
    L_0x004d:
        r8.DW();	 Catch:{ es$a -> 0x009d }
        r8.gW();	 Catch:{ es$a -> 0x009d }
        r2 = 26;
        r8.Hw(r2);	 Catch:{ es$a -> 0x009d }
        r2 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r4 = 3;
        r8.FH(r2, r4);	 Catch:{ es$a -> 0x009d }
        r8.P8();	 Catch:{ es$a -> 0x009d }
    L_0x0061:
        r8.BT();	 Catch:{ es$a -> 0x009d }
        r2 = r8.VH;	 Catch:{ es$a -> 0x009d }
        switch(r2) {
            case 17: goto L_0x00a1;
            case 18: goto L_0x00a1;
            case 19: goto L_0x00a1;
            case 20: goto L_0x00a1;
            case 21: goto L_0x00a1;
            case 22: goto L_0x0069;
            case 23: goto L_0x00a1;
            case 24: goto L_0x0069;
            case 25: goto L_0x00a1;
            case 26: goto L_0x0069;
            case 27: goto L_0x00a1;
            case 28: goto L_0x0069;
            case 29: goto L_0x00a1;
            case 30: goto L_0x00a1;
            case 31: goto L_0x00a1;
            case 32: goto L_0x00a1;
            case 33: goto L_0x00a1;
            case 34: goto L_0x0069;
            case 35: goto L_0x00a1;
            case 36: goto L_0x00a1;
            case 37: goto L_0x00a1;
            case 38: goto L_0x00a1;
            case 39: goto L_0x00a1;
            case 40: goto L_0x00a1;
            case 41: goto L_0x00a1;
            case 42: goto L_0x00a1;
            case 43: goto L_0x00a1;
            case 44: goto L_0x00a1;
            case 45: goto L_0x00a1;
            case 46: goto L_0x00a1;
            case 47: goto L_0x00a1;
            case 48: goto L_0x00a1;
            case 49: goto L_0x00a1;
            case 50: goto L_0x00a1;
            case 51: goto L_0x00a1;
            case 52: goto L_0x00a1;
            case 53: goto L_0x00a1;
            default: goto L_0x0069;
        };	 Catch:{ es$a -> 0x009d }
    L_0x0069:
        r2 = r0;
        goto L_0x0004;
    L_0x006b:
        r2 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r4 = 17;
        if (r2 != r4) goto L_0x0096;
    L_0x0071:
        r8.DW();	 Catch:{ es$a -> 0x009d }
        r2 = r8.XL;	 Catch:{ es$a -> 0x009d }
        r8.P8();	 Catch:{ es$a -> 0x007a }
        goto L_0x0061;
    L_0x007a:
        r4 = move-exception;
        r8.XL = r2;	 Catch:{ es$a -> 0x009d }
        r2 = 66;
        r8.FH(r2);	 Catch:{ es$a -> 0x009d }
        r2 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r2 = r2 + -1;
        r8.BT = r2;	 Catch:{ es$a -> 0x009d }
        r0 = r0 + -1;
        r2 = 172; // 0xac float:2.41E-43 double:8.5E-322;
        r4 = 3;
        r8.FH(r2, r4);	 Catch:{ es$a -> 0x009d }
        r8.gn();	 Catch:{ es$a -> 0x009d }
        r2 = r0;
        goto L_0x0004;
    L_0x0096:
        r8.DW();	 Catch:{ es$a -> 0x009d }
        r8.P8();	 Catch:{ es$a -> 0x009d }
        goto L_0x0061;
    L_0x009d:
        r0 = move-exception;
        r8.BT = r3;
        throw r0;
    L_0x00a1:
        if (r0 <= 0) goto L_0x0069;
    L_0x00a3:
        r2 = r8.aM;	 Catch:{ es$a -> 0x009d }
        r4 = r8.gW;	 Catch:{ es$a -> 0x009d }
        r5 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r5 = r5 + -1;
        r4 = r4[r5];	 Catch:{ es$a -> 0x009d }
        r2 = r2.SI(r4);	 Catch:{ es$a -> 0x009d }
        r4 = r8.aM;	 Catch:{ es$a -> 0x009d }
        r5 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r4 = r4.SI(r5);	 Catch:{ es$a -> 0x009d }
        if (r2 != r4) goto L_0x00cf;
    L_0x00bb:
        r2 = r8.VH;	 Catch:{ es$a -> 0x009d }
        switch(r2) {
            case 17: goto L_0x0069;
            case 20: goto L_0x0069;
            case 23: goto L_0x0069;
            case 25: goto L_0x0069;
            case 29: goto L_0x0069;
            case 31: goto L_0x0069;
            case 33: goto L_0x0069;
            case 37: goto L_0x0069;
            case 40: goto L_0x0069;
            case 43: goto L_0x0069;
            case 47: goto L_0x0069;
            case 52: goto L_0x0069;
            case 53: goto L_0x0069;
            default: goto L_0x00c0;
        };	 Catch:{ es$a -> 0x009d }
    L_0x00c0:
        r2 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r2 = r2 + -1;
        r8.BT = r2;	 Catch:{ es$a -> 0x009d }
        r0 = r0 + -1;
        r2 = 172; // 0xac float:2.41E-43 double:8.5E-322;
        r4 = 3;
        r8.FH(r2, r4);	 Catch:{ es$a -> 0x009d }
        goto L_0x00a1;
    L_0x00cf:
        r2 = r8.aM;	 Catch:{ es$a -> 0x009d }
        r4 = r8.gW;	 Catch:{ es$a -> 0x009d }
        r5 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r5 = r5 + -1;
        r4 = r4[r5];	 Catch:{ es$a -> 0x009d }
        r2 = r2.SI(r4);	 Catch:{ es$a -> 0x009d }
        r4 = r8.aM;	 Catch:{ es$a -> 0x009d }
        r5 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r4 = r4.SI(r5);	 Catch:{ es$a -> 0x009d }
        if (r2 > r4) goto L_0x0069;
    L_0x00e7:
        r2 = r8.BT;	 Catch:{ es$a -> 0x009d }
        r2 = r2 + -1;
        r8.BT = r2;	 Catch:{ es$a -> 0x009d }
        r0 = r0 + -1;
        r2 = 172; // 0xac float:2.41E-43 double:8.5E-322;
        r4 = 3;
        r8.FH(r2, r4);	 Catch:{ es$a -> 0x009d }
        goto L_0x00a1;
    L_0x00f6:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: gx.vy():void");
    }

    private void P8() {
        int i = 0;
        int i2 = 0;
        while (true) {
            switch (this.VH) {
                case 21:
                case 22:
                case 24:
                case 27:
                case 28:
                case 34:
                    DW();
                    i2++;
                default:
                    if (this.VH == 12) {
                        DW();
                        switch (this.VH) {
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                            case 57:
                            case 60:
                            case 62:
                            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                            case 69:
                            case 76:
                            case 77:
                            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                            case 89:
                            case 114:
                                if (!lg()) {
                                    gW();
                                    Hw(13);
                                    FH(168, 3);
                                    switch (this.VH) {
                                        case 10:
                                        case 16:
                                            nw();
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                x9();
                                sy();
                                Hw(13);
                                P8();
                                while (true) {
                                    switch (this.VH) {
                                        case 22:
                                        case 28:
                                            DW();
                                            FH(171, 2);
                                        default:
                                            FH(169, 5);
                                            break;
                                    }
                                }
                            default:
                                gW();
                                Hw(13);
                                FH(168, 3);
                                switch (this.VH) {
                                    case 10:
                                    case 16:
                                        nw();
                                        break;
                                    default:
                                        break;
                                }
                        }
                    }
                    ei();
                    switch (this.VH) {
                        case 10:
                        case 16:
                            nw();
                            break;
                    }
                    while (i < i2) {
                        FH(170, 2);
                        i++;
                    }
                    return;
            }
        }
    }

    private void ei() {
        int i = 1;
        switch (this.VH) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                int i2;
                if (XL()) {
                    i2 = 2;
                    DW();
                    FH(206, 0);
                    while (this.VH == 16) {
                        DW();
                        switch (this.VH) {
                            case ProxyTextView.TYPEFACE_SANS /*1*/:
                                DW();
                                FH(206, 0);
                                i2 += 3;
                                break;
                            case 67:
                                DW();
                                j6(180, 2, i2);
                                FH(166, 3);
                                return;
                            case 72:
                                DW();
                                j6(180, 2, i2);
                                j6(198, 2, 0);
                                FH(167, 4);
                                return;
                            case 78:
                                DW();
                                j6(180, 2, i2);
                                Hw(16);
                                if (Zo(1) == 12) {
                                    ca();
                                }
                                if (this.VH != 1) {
                                    throw new es$a();
                                }
                                DW();
                                if (this.VH == 12) {
                                    ro();
                                    FH(157, 7);
                                    return;
                                }
                                FH(162, 5);
                                return;
                            default:
                                break;
                        }
                    }
                    FH(180, i2);
                    if (this.VH != 10) {
                        throw new es$a();
                    }
                    sy();
                    Hw(16);
                    Hw(72);
                    FH(167, 4);
                    return;
                }
                DW();
                i2 = 1;
                while (this.VH == 16) {
                    DW();
                    switch (this.VH) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            if (Zo(1) == 12) {
                                FH(206, 0);
                                i2++;
                            }
                            DW();
                            break;
                        case 44:
                            ca();
                            i2++;
                            if (this.VH == 1) {
                                DW();
                                if (this.VH == 12) {
                                    break;
                                }
                                throw new es$a();
                            }
                            throw new es$a();
                        case 58:
                            j6((int) ProxyTextView.INPUTTYPE_textWebEditText, 1, i2);
                            SI();
                            return;
                        default:
                            throw new es$a();
                    }
                    i2 += 2;
                }
                if (this.VH == 12) {
                    ro();
                    FH(156, i2 + 1);
                    return;
                }
                FH(ProxyTextView.INPUTTYPE_textWebEditText, i2);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                DW();
                if (a8()) {
                    while (this.VH == 21) {
                        DW();
                        DW();
                        i += 2;
                    }
                    FH(178, i);
                }
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
            case 7:
            case 66:
            case 68:
            case 74:
                DW();
            case 44:
                ca();
                switch (this.VH) {
                    case 67:
                        DW();
                        if (this.VH != 12) {
                            throw new es$a();
                        }
                        ro();
                        we();
                        FH(163, 4);
                    case 78:
                        DW();
                        if (this.VH != 12) {
                            throw new es$a();
                        }
                        ro();
                        we();
                        FH(164, 4);
                    default:
                        throw new es$a();
                }
            case 57:
            case 60:
            case 62:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 69:
            case 76:
            case 77:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 89:
            case 114:
                DW();
                FH(180, 1);
                sy();
                Hw(16);
                Hw(72);
                FH(167, 4);
            case 58:
                KD();
            case 67:
                if (Zo(1) == 12) {
                    DW(206, false, 0);
                }
                DW();
                if (this.VH == 12) {
                    ro();
                    we();
                    FH(163, 4);
                    return;
                }
                FH(166, 1);
            case 78:
                if (Zo(1) == 12) {
                    DW(206, false, 0);
                }
                DW();
                if (this.VH == 12) {
                    ro();
                    we();
                    FH(164, 4);
                } else if (this.VH == 16) {
                    DW();
                    if (Zo(1) == 12) {
                        ca();
                    }
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    DW();
                    if (this.VH == 12) {
                        ro();
                        FH(157, 5);
                        return;
                    }
                    FH(162, 3);
                } else {
                    throw new es$a();
                }
            default:
                throw new es$a();
        }
    }

    private void nw() {
        while (true) {
            switch (this.VH) {
                case 10:
                    int i = 4;
                    DW();
                    gW();
                    while (this.VH == 15) {
                        DW();
                        gW();
                        i += 2;
                    }
                    Hw(11);
                    FH(165, i);
                    break;
                case 16:
                    DW();
                    switch (this.VH) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            if (Zo(1) == 12) {
                                FH(206, 0);
                            }
                            DW();
                            if (this.VH != 12) {
                                FH(159, 3);
                                break;
                            }
                            ro();
                            FH(155, 5);
                            break;
                        case 44:
                            ca();
                            switch (this.VH) {
                                case ProxyTextView.TYPEFACE_SANS /*1*/:
                                    DW();
                                    if (this.VH == 12) {
                                        ro();
                                        FH(155, 5);
                                        break;
                                    }
                                    throw new es$a();
                                case 78:
                                    DW();
                                    if (this.VH == 12) {
                                        ro();
                                        we();
                                        FH(164, 6);
                                        break;
                                    }
                                    throw new es$a();
                                default:
                                    throw new es$a();
                            }
                        case 58:
                            SI();
                            break;
                        case 78:
                            FH(206, 0);
                            DW();
                            if (this.VH == 12) {
                                ro();
                                we();
                                FH(164, 6);
                                break;
                            }
                            throw new es$a();
                        default:
                            throw new es$a();
                    }
                default:
                    return;
            }
        }
    }

    private void SI() {
        DW();
        ca();
        if (this.VH != 1) {
            throw new es$a();
        }
        Qq();
        if (this.VH != 12) {
            throw new es$a();
        }
        ro();
        if (this.VH == 8) {
            j6(false, true, false, false, false, 0);
            j6((int) ProxyTextView.INPUTTYPE_textFilter, false, 7, false);
            return;
        }
        FH(176, 6);
    }

    private void KD() {
        int i = 2;
        DW();
        switch (this.VH) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                Qq();
                switch (this.VH) {
                    case 10:
                        break;
                    case 12:
                        j6(206, 1, 0);
                        ro();
                        if (this.VH == 8) {
                            j6(false, true, false, false, false, 0);
                            j6((int) ProxyTextView.INPUTTYPE_textFilter, false, 5, false);
                            return;
                        }
                        FH(176, 4);
                        return;
                    default:
                        VH();
                        j6(206, 1, 0);
                        FH(12);
                        FH(13);
                        FH(197, 2);
                        FH(176, 4);
                        return;
                }
                while (this.VH == 10) {
                    DW();
                    i++;
                    switch (this.VH) {
                        case 11:
                            DW();
                            i++;
                            break;
                        default:
                            gW();
                            i++;
                            Hw(11);
                            i++;
                            break;
                    }
                }
                if (this.VH == 8) {
                    cn();
                    i++;
                }
                FH(175, i);
            case 44:
                ca();
                Qq();
                switch (this.VH) {
                    case 12:
                        ro();
                        if (this.VH == 8) {
                            j6(false, true, false, false, false, 0);
                            j6((int) ProxyTextView.INPUTTYPE_textFilter, false, 5, false);
                            return;
                        }
                        FH(176, 4);
                    default:
                        VH();
                        j6(206, 1, 0);
                        FH(12);
                        FH(13);
                        FH(197, 2);
                        FH(176, 4);
                }
            case 57:
            case 60:
            case 62:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 69:
            case 76:
            case 77:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 89:
            case 114:
                DW();
                FH(180, 1);
                if (this.VH != 10) {
                    throw new es$a();
                }
                while (this.VH == 10) {
                    DW();
                    i++;
                    switch (this.VH) {
                        case 11:
                            DW();
                            i++;
                            break;
                        default:
                            gW();
                            i++;
                            Hw(11);
                            i++;
                            break;
                    }
                }
                if (this.VH == 8) {
                    cn();
                    i++;
                }
                FH(175, i);
            default:
                throw new es$a();
        }
    }

    private void ro() {
        DW();
        if (this.VH == 13) {
            DW();
            FH(197, 2);
            return;
        }
        int i = 3;
        int i2 = this.XL;
        try {
            gW();
        } catch (es$a e) {
            this.XL = i2;
            FH(66);
            gn();
        }
        while (this.VH == 15) {
            DW();
            i2 = this.XL;
            try {
                gW();
            } catch (es$a e2) {
                this.XL = i2;
                FH(66);
                gn();
            }
            i += 2;
        }
        Hw(13);
        FH(197, i);
    }

    private void cn() {
        int i = 2;
        Hw(8);
        if (this.VH == 9) {
            DW();
            FH(196, 2);
            return;
        }
        do {
            switch (this.VH) {
                case 8:
                    cn();
                    i++;
                    break;
                default:
                    gW();
                    i++;
                    break;
            }
            if (this.VH == 15) {
                DW();
                i++;
            }
            Hw(9);
            FH(196, i);
        } while (this.VH != 9);
        Hw(9);
        FH(196, i);
    }

    private void sh() {
        int i = 2;
        Hw(8);
        if (this.VH == 9) {
            DW();
            FH(196, 2);
            return;
        }
        do {
            switch (this.VH) {
                case 8:
                    sh();
                    i++;
                    break;
                case 115:
                    DW();
                    vJ();
                    i++;
                    break;
                default:
                    gW();
                    i++;
                    break;
            }
            if (this.VH == 15) {
                DW();
                i++;
            }
            Hw(9);
            FH(196, i);
        } while (this.VH != 9);
        Hw(9);
        FH(196, i);
    }

    private void cb() {
        if (this.VH == 88) {
            DW();
            if (this.VH != 1) {
                throw new es$a();
            }
            Qq();
            int i = 2;
            while (this.VH == 15) {
                DW();
                if (this.VH != 1) {
                    throw new es$a();
                }
                Qq();
                i += 2;
            }
            FH(195, i);
            return;
        }
        FH(195, 0);
    }

    private void dx() {
        int i = 2;
        DW();
        if (this.VH == 13) {
            DW();
            FH(190, 2);
            return;
        }
        while (true) {
            g3();
            x9();
            sy();
            if (this.VH != 1) {
                throw new es$a();
            }
            DW();
            sy();
            FH(191, 5);
            i++;
            switch (this.VH) {
                case 13:
                    DW();
                    FH(190, i);
                    return;
                case 15:
                    DW();
                    i++;
                default:
                    Hw(13);
                    FH(190, i);
                    return;
            }
        }
    }

    private void sG() {
        FH(84);
        FH(86);
        FH(75);
        int i = 3;
        while (true) {
            switch (this.VH) {
                case 75:
                case 83:
                case 84:
                case 86:
                case 95:
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                case 98:
                case 100:
                case 101:
                case 104:
                    DW();
                    i++;
                    break;
                case 94:
                    DW();
                    i++;
                    break;
                case 115:
                    DW();
                    i++;
                    vJ();
                    break;
                default:
                    DW(199, false, i);
                    return;
            }
        }
    }

    private int ef() {
        int i = 0;
        int i2 = 0;
        while (true) {
            switch (this.VH) {
                case 75:
                case 83:
                case 84:
                case 86:
                case 95:
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                case 98:
                case 100:
                case 101:
                case 104:
                    DW();
                    i++;
                    break;
                case 94:
                    i2 |= 4;
                    DW();
                    i++;
                    break;
                case 115:
                    DW();
                    i++;
                    if (this.VH == 1) {
                        vJ();
                        break;
                    }
                    DW(199, false, i);
                    return i2 | 536870912;
                default:
                    DW(199, false, i);
                    return i2;
            }
        }
    }

    private void Sf() {
        int i = 0;
        while (this.VH == 115) {
            DW();
            i++;
            if (this.VH == 1) {
                vJ();
            } else {
                DW(199, false, i);
                return;
            }
        }
        DW(199, false, i);
    }

    private void vJ() {
        x9();
        if (this.VH == 12) {
            DW();
            if (this.VH == 13) {
                DW();
                FH(231, 4);
                return;
            }
            int i = 3;
            while (true) {
                if (this.VH == 1 && Zo(1) == 17) {
                    DW();
                    DW();
                } else {
                    gn(this.Mr.j6("value"));
                    FH(17);
                }
                i += 4;
                if (this.VH == 8) {
                    sh();
                } else if (this.VH == 115) {
                    DW();
                    vJ();
                } else {
                    gW();
                }
                if (this.VH != 15) {
                    Hw(13);
                    FH(231, i);
                    return;
                }
                DW();
            }
        } else {
            FH(12);
            FH(13);
            FH(231, 4);
        }
    }

    private void g3() {
        int i = 0;
        while (true) {
            switch (this.VH) {
                case 75:
                case 95:
                    DW();
                    i++;
                    break;
                case 115:
                    DW();
                    i++;
                    vJ();
                    break;
                default:
                    DW(199, false, i);
                    return;
            }
        }
    }

    private void Mz() {
        if (this.VH != 1) {
            throw new es$a();
        }
        DW();
        if (this.VH == 91) {
            int i = 3;
            DW();
            Qq();
            while (this.VH == 41) {
                DW();
                Qq();
                i += 2;
            }
            j6(208, false, i, false);
            return;
        }
        j6(208, false, 1, false);
    }

    private void I() {
        if (this.VH == 44) {
            int i = 3;
            DW();
            Mz();
            while (this.VH == 15) {
                DW();
                Mz();
                i += 2;
            }
            switch (this.VH) {
                case 48:
                    DW();
                    break;
                case 50:
                    FH(48);
                    this.VH = 48;
                    break;
                case 51:
                    FH(48);
                    this.VH = 50;
                    break;
                default:
                    throw new es$a();
            }
            FH(207, i);
            return;
        }
        FH(207, 0);
    }

    private void ca() {
        if (this.VH == 44) {
            DW();
            if (this.VH == 48) {
                DW();
                FH(206, 2);
                return;
            }
            int i = 5;
            switch (this.VH) {
                case 25:
                    DW();
                    switch (this.VH) {
                        case 78:
                        case 91:
                            DW();
                            FH(230, 2);
                            x9();
                            sy();
                            break;
                        default:
                            FH(230, 1);
                            gn(this.Mr.j6("Object"));
                            FH(206, 0);
                            FH(180, 2);
                            FH(198, 0);
                            break;
                    }
                default:
                    FH(230, 0);
                    x9();
                    sy();
                    break;
            }
            while (this.VH == 15) {
                DW();
                switch (this.VH) {
                    case 25:
                        DW();
                        switch (this.VH) {
                            case 78:
                            case 91:
                                DW();
                                FH(230, 2);
                                x9();
                                sy();
                                break;
                            default:
                                FH(230, 1);
                                gn(this.Mr.j6("Object"));
                                FH(206, 0);
                                FH(180, 2);
                                FH(198, 0);
                                break;
                        }
                    default:
                        FH(230, 0);
                        x9();
                        sy();
                        break;
                }
                i += 4;
            }
            int[] iArr;
            int i2;
            switch (this.VH) {
                case 48:
                    DW();
                    break;
                case 50:
                    FH(48);
                    this.VH = 48;
                    iArr = this.J8;
                    i2 = this.gn;
                    iArr[i2] = iArr[i2] + 1;
                    break;
                case 51:
                    FH(48);
                    this.VH = 50;
                    iArr = this.J8;
                    i2 = this.gn;
                    iArr[i2] = iArr[i2] + 1;
                    break;
                default:
                    throw new es$a();
            }
            FH(206, i);
            return;
        }
        FH(206, 0);
    }

    private void x9() {
        switch (this.VH) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                DW();
                ca();
                int i = 2;
                while (this.VH == 16) {
                    DW();
                    if (this.VH == 1) {
                        DW();
                        ca();
                        i += 3;
                    } else {
                        throw new es$a();
                    }
                }
                FH(180, i);
            case 57:
            case 60:
            case 62:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 69:
            case 76:
            case 77:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 89:
            case 114:
                DW();
                FH(180, 1);
            default:
                throw new es$a();
        }
    }

    private void Qq() {
        if (this.VH != 1) {
            throw new es$a();
        }
        DW();
        ca();
        int i = 2;
        while (this.VH == 16) {
            DW();
            if (this.VH != 1) {
                throw new es$a();
            }
            DW();
            ca();
            i += 3;
        }
        FH(180, i);
    }

    private void sy() {
        int i = 0;
        while (true) {
            switch (this.VH) {
                case 10:
                    DW();
                    aj();
                    Hw(11);
                    i += 3;
                case 11:
                    throw new es$a();
                case 108:
                    DW();
                    FH(198, i + 1);
                    return;
                default:
                    FH(198, i);
                    return;
            }
        }
    }

    private void aj() {
        int i = 0;
        while (this.VH == 15) {
            DW();
            i++;
        }
        FH(240, i);
    }
}
