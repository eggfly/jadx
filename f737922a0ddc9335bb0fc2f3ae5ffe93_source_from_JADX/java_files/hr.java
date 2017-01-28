import com.aide.uidesigner.ProxyTextView;

public class hr extends es {
    private final by Mr;
    private final bt U2;
    private int[] a8;
    private final hu aM;
    private int er;
    private final bu j3;
    private int lg;
    private int rN;

    public hr(by byVar, bu buVar, bt btVar, hu huVar) {
        super(byVar, buVar, btVar, huVar, 223, 0);
        this.a8 = new int[1000];
        this.lg = 0;
        this.j3 = buVar;
        this.Mr = byVar;
        this.U2 = btVar;
        this.aM = huVar;
    }

    public void j6(cm cmVar, bv bvVar, boolean z, cj cjVar) {
        this.rN = 2;
        this.er = 100000;
        super.j6(cmVar, bvVar, z, cjVar);
    }

    private void VH() {
        j6("Unexpected end of statement");
    }

    private void gn() {
        j6("Unexpected end of expression");
    }

    private void u7() {
        this.XL++;
        if (this.XL >= this.QX.length) {
            Object obj = new int[((this.QX.length * 2) + 1)];
            System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
            this.QX = obj;
        }
        int[] iArr = this.QX;
        int i = this.XL;
        cj cjVar = this.Zo;
        int i2 = this.VH;
        int i3 = this.EQ[this.gn];
        int i4 = this.we[this.gn];
        int i5 = this.J8[this.gn];
        int i6 = this.J0[this.gn];
        int i7 = this.Ws[this.gn];
        int i8 = this.er;
        this.er = i8 + 1;
        iArr[i] = cjVar.j6(i2, false, i3, i4, i5, i6, i7, i8);
        if (this.gn < this.u7) {
            this.gn++;
            this.VH = this.tp[this.gn];
        }
    }

    private boolean tp() {
        return this.gn > 0 && this.J0[this.gn - 1] != this.we[this.gn];
    }

    protected void Zo() {
        j6(223, false, j6(true), 0);
    }

    private void EQ() {
        DW();
        int j6 = j6(false);
        Hw(9);
        FH(133, j6 + 2);
    }

    private int j6(boolean z) {
        int i = 0;
        while (true) {
            switch (this.VH) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                case 9:
                    return i;
                default:
                    int i2 = this.gn;
                    int i3 = this.XL + 1;
                    try {
                        DW(z);
                        i++;
                    } catch (es$a e) {
                        if (e instanceof hr$a) {
                            j6();
                        } else {
                            VH();
                        }
                        int i4 = this.XL;
                        int i5 = i3;
                        while (i5 <= i4) {
                            switch (this.Zo.rN(this.QX[i5])) {
                                case 159:
                                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                                case 165:
                                case 166:
                                case 168:
                                case 170:
                                case 171:
                                case 172:
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
                                    i++;
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
                                        i++;
                                        break;
                                    }
                                default:
                                    break;
                            }
                            i5++;
                        }
                        System.arraycopy(this.QX, i4 + 1, this.QX, i3, this.XL - i4);
                        this.XL -= (i4 - i3) + 1;
                    }
                    if (this.gn == i2) {
                        Hw();
                    }
            }
        }
    }

    private void DW(boolean z) {
        int i;
        switch (this.VH) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (Zo(1) == 26) {
                    DW();
                    DW();
                    DW(false);
                    FH(148, 3);
                    return;
                }
                J0();
                we();
                FH(146, 2);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
            case 7:
            case 10:
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
            case 69:
            case 74:
            case 105:
            case 118:
                J0();
                we();
                FH(146, 2);
            case 8:
                EQ();
            case 14:
                DW();
                FH(134, 1);
            case 26:
                if (z && Zo(1) == 2) {
                    DW();
                    DW();
                    FH(213, 2);
                    return;
                }
                throw new hr$a();
            case 54:
                DW();
                DW(false);
                if (this.VH != 80) {
                    throw new es$a();
                }
                DW();
                Hw(12);
                J0();
                Hw(13);
                we();
                FH(ProxyTextView.INPUTTYPE_textVisiblePassword, 7);
            case 55:
                DW();
                Hw(12);
                J0();
                Hw(13);
                DW(false);
                if (this.VH == 63) {
                    DW();
                    DW(false);
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
                } else if (this.VH == 98 && Zo(1) == 1 && Zo(2) == 114) {
                    DW();
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    DW();
                    FH(200, 1);
                    FH(151, 2);
                    Hw(114);
                    J0();
                    Hw(13);
                    DW(false);
                    FH(211, 7);
                    return;
                } else if (this.VH == 1 && Zo(1) == 114) {
                    XL();
                    Hw(114);
                    J0();
                    Hw(13);
                    DW(false);
                    FH(211, 7);
                    return;
                } else if (this.VH == 98) {
                    FH(false);
                    FH(201, 1);
                } else {
                    J8();
                    i = 2;
                    while (this.VH == 15) {
                        DW();
                        J8();
                        i += 2;
                    }
                    we();
                    FH(201, i);
                }
                if (this.VH == 14) {
                    DW();
                    FH(203, 1);
                } else {
                    J0();
                    we();
                    FH(203, 2);
                }
                if (this.VH == 13) {
                    FH(202, 0);
                } else {
                    J8();
                    i = 1;
                    while (this.VH == 15) {
                        DW();
                        J8();
                        i += 2;
                    }
                    FH(202, i);
                }
                Hw(13);
                DW(false);
                FH(149, 7);
            case 59:
                DW();
                if (this.VH != 8) {
                    throw new es$a();
                }
                EQ();
                i = 2;
                while (this.VH == 71) {
                    DW();
                    Hw(12);
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    DW();
                    Hw(13);
                    if (this.VH != 8) {
                        throw new es$a();
                    }
                    EQ();
                    FH(204, 5);
                    i++;
                }
                if (this.VH == 92) {
                    DW();
                    if (this.VH != 8) {
                        throw new es$a();
                    }
                    EQ();
                    FH(205, 2);
                    i++;
                }
                FH(150, i);
            case 61:
                DW();
                J0();
                Hw(26);
                FH(143, 3);
            case 70:
                DW();
                if (this.VH != 1 || tp()) {
                    we();
                    FH(138, 2);
                    return;
                }
                DW();
                we();
                FH(138, 3);
            case 79:
                DW();
                J0();
                we();
                FH(142, 3);
            case 80:
                DW();
                Hw(12);
                J0();
                Hw(13);
                DW(false);
                FH(137, 5);
            case 85:
                DW();
                if (this.VH == 14 || this.VH == 9 || tp()) {
                    we();
                    FH(141, 2);
                    return;
                }
                J0();
                we();
                FH(141, 3);
            case 87:
                DW();
                Hw(12);
                J0();
                Hw(13);
                if (this.VH != 8) {
                    throw new es$a();
                }
                EQ();
                FH(147, 5);
            case 90:
                DW();
                Hw(26);
                FH(144, 2);
            case 96:
                DW();
                if (this.VH != 1 || tp()) {
                    we();
                    FH(139, 2);
                    return;
                }
                DW();
                we();
                FH(139, 3);
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                if (z) {
                    DW();
                    if (this.VH != 1) {
                        throw new es$a();
                    }
                    DW();
                    rN();
                    EQ();
                    int i2 = this.rN;
                    this.rN = i2 + 1;
                    j6(125, false, 4, i2);
                } else {
                    J0();
                }
                Hw(false);
                FH(146, 2);
            case 98:
                FH(z);
            case 106:
                DW();
                Hw(12);
                J0();
                Hw(13);
                DW(false);
                FH(212, 5);
            default:
                throw new hr$a();
        }
    }

    private void FH(boolean z) {
        int i;
        Hw(98);
        if (this.VH != 1) {
            throw new es$a();
        }
        DW();
        if (this.VH == 17) {
            DW();
            i = this.XL;
            try {
                J8();
            } catch (es$a e) {
                this.XL = i;
                FH(66);
            }
            if (z) {
                i = this.rN;
                this.rN = i + 1;
                j6(207, false, 3, i);
            } else {
                FH(200, 3);
            }
            i = 3;
        } else if (z) {
            i = this.rN;
            this.rN = i + 1;
            j6(207, false, 1, i);
            i = 3;
        } else {
            FH(200, 1);
            i = 3;
        }
        while (this.VH == 15) {
            DW();
            if (this.VH != 1) {
                throw new es$a();
            }
            DW();
            int i2;
            if (this.VH == 17) {
                DW();
                J8();
                if (z) {
                    i2 = this.rN;
                    this.rN = i2 + 1;
                    j6(207, false, 3, i2);
                } else {
                    FH(200, 3);
                }
            } else if (z) {
                i2 = this.rN;
                this.rN = i2 + 1;
                j6(207, false, 1, i2);
            } else {
                FH(200, 1);
            }
            i += 2;
        }
        we();
        if (z) {
            FH(152, i);
        } else {
            FH(151, i);
        }
    }

    private void we() {
        Hw(true);
    }

    private void Hw(boolean z) {
        if (this.VH == 14) {
            DW();
            return;
        }
        if (z) {
            DW(14);
        }
        FH(14);
    }

    private void J0() {
        J8();
        int i = 1;
        while (this.VH == 15) {
            DW();
            J8();
            i += 2;
        }
        if (i > 1) {
            FH(178, i);
        }
    }

    private void J8() {
        XL();
        Ws();
        QX();
    }

    private void Ws() {
        while (true) {
            switch (this.VH) {
                case 22:
                case 28:
                    DW();
                    FH(171, 2);
                    break;
                case 103:
                    DW();
                    J8();
                    FH(ProxyTextView.INPUTTYPE_textFilter, 3);
                    break;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void QX() {
        /*
        r8 = this;
        r1 = 0;
        r3 = r8.lg;
        r2 = r1;
    L_0x0004:
        r0 = r8.VH;	 Catch:{ es$a -> 0x009d }
        switch(r0) {
            case 17: goto L_0x001b;
            case 18: goto L_0x001b;
            case 19: goto L_0x001b;
            case 20: goto L_0x001b;
            case 21: goto L_0x001b;
            case 23: goto L_0x001b;
            case 25: goto L_0x001b;
            case 27: goto L_0x001b;
            case 29: goto L_0x001b;
            case 30: goto L_0x001b;
            case 31: goto L_0x001b;
            case 32: goto L_0x001b;
            case 33: goto L_0x001b;
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
            case 114: goto L_0x001b;
            case 115: goto L_0x001b;
            case 116: goto L_0x001b;
            default: goto L_0x0009;
        };	 Catch:{ es$a -> 0x009d }
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 >= r2) goto L_0x00f6;
    L_0x000c:
        r1 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r1 = r1 + -1;
        r8.lg = r1;	 Catch:{ es$a -> 0x009d }
        r1 = 172; // 0xac float:2.41E-43 double:8.5E-322;
        r4 = 3;
        r8.FH(r1, r4);	 Catch:{ es$a -> 0x009d }
        r0 = r0 + 1;
        goto L_0x000a;
    L_0x001b:
        r0 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r4 = r8.a8;	 Catch:{ es$a -> 0x009d }
        r4 = r4.length;	 Catch:{ es$a -> 0x009d }
        if (r0 < r4) goto L_0x0037;
    L_0x0022:
        r0 = r8.a8;	 Catch:{ es$a -> 0x009d }
        r0 = r0.length;	 Catch:{ es$a -> 0x009d }
        r0 = r0 * 2;
        r0 = r0 + 1;
        r0 = new int[r0];	 Catch:{ es$a -> 0x009d }
        r4 = r8.a8;	 Catch:{ es$a -> 0x009d }
        r5 = 0;
        r6 = 0;
        r7 = r8.a8;	 Catch:{ es$a -> 0x009d }
        r7 = r7.length;	 Catch:{ es$a -> 0x009d }
        java.lang.System.arraycopy(r4, r5, r0, r6, r7);	 Catch:{ es$a -> 0x009d }
        r8.a8 = r0;	 Catch:{ es$a -> 0x009d }
    L_0x0037:
        r0 = r8.a8;	 Catch:{ es$a -> 0x009d }
        r4 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r5 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r0[r4] = r5;	 Catch:{ es$a -> 0x009d }
        r0 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r0 = r0 + 1;
        r8.lg = r0;	 Catch:{ es$a -> 0x009d }
        r0 = r2 + 1;
        r2 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r4 = 25;
        if (r2 != r4) goto L_0x006b;
    L_0x004d:
        r8.DW();	 Catch:{ es$a -> 0x009d }
        r8.J8();	 Catch:{ es$a -> 0x009d }
        r2 = 26;
        r8.Hw(r2);	 Catch:{ es$a -> 0x009d }
        r2 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r4 = 3;
        r8.FH(r2, r4);	 Catch:{ es$a -> 0x009d }
        r8.XL();	 Catch:{ es$a -> 0x009d }
    L_0x0061:
        r8.Ws();	 Catch:{ es$a -> 0x009d }
        r2 = r8.VH;	 Catch:{ es$a -> 0x009d }
        switch(r2) {
            case 17: goto L_0x00a1;
            case 18: goto L_0x00a1;
            case 19: goto L_0x00a1;
            case 20: goto L_0x00a1;
            case 21: goto L_0x00a1;
            case 23: goto L_0x00a1;
            case 25: goto L_0x00a1;
            case 27: goto L_0x00a1;
            case 29: goto L_0x00a1;
            case 30: goto L_0x00a1;
            case 31: goto L_0x00a1;
            case 32: goto L_0x00a1;
            case 33: goto L_0x00a1;
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
            case 114: goto L_0x00a1;
            case 115: goto L_0x00a1;
            case 116: goto L_0x00a1;
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
        r8.XL();	 Catch:{ es$a -> 0x007a }
        goto L_0x0061;
    L_0x007a:
        r4 = move-exception;
        r8.XL = r2;	 Catch:{ es$a -> 0x009d }
        r2 = 66;
        r8.FH(r2);	 Catch:{ es$a -> 0x009d }
        r2 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r2 = r2 + -1;
        r8.lg = r2;	 Catch:{ es$a -> 0x009d }
        r0 = r0 + -1;
        r2 = 172; // 0xac float:2.41E-43 double:8.5E-322;
        r4 = 3;
        r8.FH(r2, r4);	 Catch:{ es$a -> 0x009d }
        r8.gn();	 Catch:{ es$a -> 0x009d }
        r2 = r0;
        goto L_0x0004;
    L_0x0096:
        r8.DW();	 Catch:{ es$a -> 0x009d }
        r8.XL();	 Catch:{ es$a -> 0x009d }
        goto L_0x0061;
    L_0x009d:
        r0 = move-exception;
        r8.lg = r3;
        throw r0;
    L_0x00a1:
        if (r0 <= 0) goto L_0x0069;
    L_0x00a3:
        r2 = r8.aM;	 Catch:{ es$a -> 0x009d }
        r4 = r8.a8;	 Catch:{ es$a -> 0x009d }
        r5 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r5 = r5 + -1;
        r4 = r4[r5];	 Catch:{ es$a -> 0x009d }
        r2 = r2.nw(r4);	 Catch:{ es$a -> 0x009d }
        r4 = r8.aM;	 Catch:{ es$a -> 0x009d }
        r5 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r4 = r4.nw(r5);	 Catch:{ es$a -> 0x009d }
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
        r2 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r2 = r2 + -1;
        r8.lg = r2;	 Catch:{ es$a -> 0x009d }
        r0 = r0 + -1;
        r2 = 172; // 0xac float:2.41E-43 double:8.5E-322;
        r4 = 3;
        r8.FH(r2, r4);	 Catch:{ es$a -> 0x009d }
        goto L_0x00a1;
    L_0x00cf:
        r2 = r8.aM;	 Catch:{ es$a -> 0x009d }
        r4 = r8.a8;	 Catch:{ es$a -> 0x009d }
        r5 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r5 = r5 + -1;
        r4 = r4[r5];	 Catch:{ es$a -> 0x009d }
        r2 = r2.nw(r4);	 Catch:{ es$a -> 0x009d }
        r4 = r8.aM;	 Catch:{ es$a -> 0x009d }
        r5 = r8.VH;	 Catch:{ es$a -> 0x009d }
        r4 = r4.nw(r5);	 Catch:{ es$a -> 0x009d }
        if (r2 > r4) goto L_0x0069;
    L_0x00e7:
        r2 = r8.lg;	 Catch:{ es$a -> 0x009d }
        r2 = r2 + -1;
        r8.lg = r2;	 Catch:{ es$a -> 0x009d }
        r0 = r0 + -1;
        r2 = 172; // 0xac float:2.41E-43 double:8.5E-322;
        r4 = 3;
        r8.FH(r2, r4);	 Catch:{ es$a -> 0x009d }
        goto L_0x00a1;
    L_0x00f6:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: hr.QX():void");
    }

    private void XL() {
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
                        J0();
                        Hw(13);
                        FH(168, 3);
                    } else {
                        aM();
                    }
                    Mr();
                    while (i < i2) {
                        FH(170, 2);
                        i++;
                    }
                    return;
            }
        }
    }

    private void aM() {
        switch (this.VH) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                DW();
                FH(ProxyTextView.INPUTTYPE_textWebEditText, 1);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
            case 7:
            case 66:
            case 68:
            case 74:
                DW();
            case 8:
                a8();
            case 10:
                lg();
            case 58:
                DW();
                XL();
                FH(176, 2);
            case 67:
                if (Zo(1) == 12) {
                    DW(199, false, 0);
                }
                DW();
                FH(166, 1);
            case 69:
                DW();
                J8();
                FH(164, 2);
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                j3();
            case 105:
                DW();
                J8();
                FH(173, 2);
            case 118:
                DW();
                J8();
                FH(163, 2);
            default:
                throw new es$a();
        }
    }

    private void j3() {
        DW();
        if (this.VH == 1) {
            DW();
            rN();
            EQ();
            FH(124, 4);
            return;
        }
        rN();
        EQ();
        FH(124, 3);
    }

    private void Mr() {
        while (true) {
            switch (this.VH) {
                case 10:
                    int i = 4;
                    DW();
                    J8();
                    while (this.VH == 15) {
                        DW();
                        J8();
                        i += 2;
                    }
                    Hw(11);
                    FH(165, i);
                    break;
                case 12:
                    U2();
                    FH(175, 2);
                    break;
                case 16:
                    DW();
                    switch (this.VH) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            u7();
                            FH(159, 3);
                            break;
                        default:
                            throw new es$a();
                    }
                default:
                    return;
            }
        }
    }

    private void U2() {
        DW();
        if (this.VH == 13) {
            DW();
            FH(197, 2);
            return;
        }
        int i = 3;
        int i2 = this.XL;
        try {
            J8();
        } catch (es$a e) {
            this.XL = i2;
            FH(66);
            gn();
        }
        while (this.VH == 15) {
            DW();
            i2 = this.XL;
            try {
                J8();
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

    private void a8() {
        int i = 2;
        Hw(8);
        if (this.VH == 9) {
            DW();
            FH(140, 2);
            return;
        }
        do {
            switch (this.VH) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    u7();
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                case 6:
                case 7:
                    DW();
                    break;
                default:
                    throw new es$a();
            }
            if (this.VH == 17) {
                DW();
            } else {
                Hw(26);
            }
            J8();
            i += 3;
            if (this.VH == 15) {
                DW();
                i++;
            }
            Hw(9);
            FH(140, i);
        } while (this.VH != 9);
        Hw(9);
        FH(140, i);
    }

    private void lg() {
        int i = 2;
        Hw(10);
        if (this.VH == 11) {
            DW();
            FH(196, 2);
            return;
        }
        do {
            J8();
            i++;
            if (this.VH != 15) {
                break;
            }
            DW();
            i++;
        } while (this.VH != 11);
        Hw(11);
        FH(196, i);
    }

    private void rN() {
        int i = 2;
        DW();
        if (this.VH == 13) {
            DW();
            FH(190, 2);
            return;
        }
        while (this.VH == 1) {
            DW();
            FH(191, 1);
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
        throw new es$a();
    }
}
