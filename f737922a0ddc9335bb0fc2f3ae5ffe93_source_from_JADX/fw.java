import com.aide.uidesigner.ProxyTextView;

public class fw extends es {
    private final int Mr;
    private final int U2;
    private final int a8;
    private final int aM;
    private ec er;
    private final int j3;
    private final int lg;
    private final int rN;

    public fw(by byVar, bu buVar, bt btVar, fy fyVar) {
        super(byVar, buVar, btVar, fyVar, 218, 0);
        this.er = new ec();
        this.aM = byVar.j6("O");
        this.j3 = byVar.j6("ANY");
        this.Mr = byVar.j6("EMPTY");
        this.U2 = byVar.j6("PUBLIC");
        this.a8 = byVar.j6("SYSTEM");
        this.lg = byVar.j6("NOTATION");
        this.rN = byVar.j6("CDATA");
        this.er.j6(byVar.j6("CDATA"));
        this.er.j6(byVar.j6("IDREF"));
        this.er.j6(byVar.j6("IDREFS"));
        this.er.j6(byVar.j6("ENTITY"));
        this.er.j6(byVar.j6("ENTITIES"));
        this.er.j6(byVar.j6("NMTOKEN"));
        this.er.j6(byVar.j6("ID"));
        this.er.j6(byVar.j6("NAME"));
        this.er.j6(byVar.j6("NUMBER"));
    }

    protected void Zo() {
        int i;
        while (this.VH == 10) {
            Hw();
        }
        if (this.VH == 55) {
            VH();
            i = 1;
        } else {
            i = 0;
        }
        j6(false);
        FH(218, i + 1);
    }

    private void VH() {
        DW();
        int i = 1;
        if (this.VH == 53) {
            DW();
            i = 2;
        }
        Hw(54);
        FH(219, i + 1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j6(boolean r5) {
        /*
        r4 = this;
        r0 = 0;
    L_0x0001:
        r1 = r4.XL;
        r2 = r4.VH;	 Catch:{ es$a -> 0x000f }
        switch(r2) {
            case 0: goto L_0x0053;
            case 10: goto L_0x0013;
            case 11: goto L_0x001d;
            case 12: goto L_0x0023;
            case 13: goto L_0x0029;
            case 15: goto L_0x0017;
            case 16: goto L_0x0013;
            case 17: goto L_0x0013;
            case 46: goto L_0x002f;
            case 48: goto L_0x0051;
            default: goto L_0x0008;
        };	 Catch:{ es$a -> 0x000f }
    L_0x0008:
        r4.j6();	 Catch:{ es$a -> 0x000f }
        r4.Hw();	 Catch:{ es$a -> 0x000f }
        goto L_0x0001;
    L_0x000f:
        r2 = move-exception;
        r4.XL = r1;
        goto L_0x0001;
    L_0x0013:
        r4.Hw();	 Catch:{ es$a -> 0x000f }
        goto L_0x0001;
    L_0x0017:
        r4.gn();	 Catch:{ es$a -> 0x000f }
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x001d:
        r4.aM();	 Catch:{ es$a -> 0x000f }
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0023:
        r4.Ws();	 Catch:{ es$a -> 0x000f }
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0029:
        r4.u7();	 Catch:{ es$a -> 0x000f }
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x002f:
        r4.DW();	 Catch:{ es$a -> 0x000f }
        r4.a8();	 Catch:{ es$a -> 0x000f }
        r2 = r4.VH;	 Catch:{ es$a -> 0x000f }
        r3 = 45;
        if (r2 != r3) goto L_0x0041;
    L_0x003b:
        r4.J8();	 Catch:{ es$a -> 0x000f }
    L_0x003e:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0041:
        r2 = r4.VH;	 Catch:{ es$a -> 0x000f }
        r3 = 44;
        if (r2 != r3) goto L_0x004b;
    L_0x0047:
        r4.J0();	 Catch:{ es$a -> 0x000f }
        goto L_0x003e;
    L_0x004b:
        r2 = new es$a;	 Catch:{ es$a -> 0x000f }
        r2.<init>();	 Catch:{ es$a -> 0x000f }
        throw r2;	 Catch:{ es$a -> 0x000f }
    L_0x0051:
        if (r5 == 0) goto L_0x0059;
    L_0x0053:
        r1 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
        r4.FH(r1, r0);
        return;
    L_0x0059:
        r4.j6();	 Catch:{ es$a -> 0x000f }
        r4.Hw();	 Catch:{ es$a -> 0x000f }
        goto L_0x0001;
        */
        throw new UnsupportedOperationException("Method not decompiled: fw.j6(boolean):void");
    }

    private void gn() {
        Hw(15);
        int i = 1;
        while (this.VH == 16) {
            DW();
            i++;
        }
        Hw(17);
        FH(220, i + 1);
    }

    private void u7() {
        int i = 2;
        DW();
        a8();
        switch (this.VH) {
            case 30:
                DW();
                break;
            case 34:
                XL();
                break;
            default:
                j6();
                throw new es$a();
        }
        a8();
        while (true) {
            switch (this.VH) {
                case 30:
                    tp();
                    i++;
                    a8();
                default:
                    Hw(26);
                    FH(215, i + 1);
                    return;
            }
        }
    }

    private void tp() {
        int i = 3;
        DW();
        a8();
        switch (this.VH) {
            case 30:
                int FH = this.FH.FH(v5());
                if (FH != this.lg) {
                    if (!this.er.FH(FH)) {
                        DW("Unknown type: " + this.FH.j6(FH));
                        DW();
                        break;
                    }
                    DW();
                    break;
                }
                EQ();
                break;
            case 34:
                we();
                break;
            default:
                j6();
                throw new es$a();
        }
        a8();
        switch (this.VH) {
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case 19:
                U2();
                break;
            case 30:
                DW();
                break;
            case 38:
            case 39:
                DW();
                break;
            case 41:
                DW();
                a8();
                U2();
                i = 4;
                break;
            default:
                j6();
                throw new es$a();
        }
        FH(216, i);
    }

    private void EQ() {
        j6();
        throw new es$a();
    }

    private void we() {
        DW();
        int i = 1;
        a8();
        while (this.VH == 30) {
            DW();
            i++;
            a8();
            if (this.VH == 33) {
                DW();
                i++;
                a8();
            } else {
                Hw(35);
                FH(217, i + 1);
                return;
            }
        }
        j6();
        throw new es$a();
    }

    private void J0() {
        DW();
        a8();
        Hw(47);
        j6(true);
        Hw(48);
        FH(213, 5);
    }

    private void J8() {
        DW();
        a8();
        Hw(47);
        int i = 3;
        while (this.VH == 49) {
            DW();
            i++;
        }
        Hw(48);
        FH(214, i + 1);
    }

    private void Ws() {
        int i = 1;
        int i2 = 2;
        DW();
        a8();
        switch (this.VH) {
            case 30:
                DW();
                break;
            case 34:
                XL();
                break;
            default:
                j6();
                throw new es$a();
        }
        a8();
        if ((v5(0, this.aM) || this.VH == 22) && Zo(1) == 10 && ((v5(2, this.aM) || Zo(2) == 22) && Zo(3) == 10)) {
            DW();
            a8();
            DW();
            i2 = 4;
            a8();
        } else {
            i = 0;
        }
        if (v5(0, this.Mr) || v5(0, this.j3)) {
            DW();
        } else {
            QX();
        }
        int i3 = i2 + 1;
        a8();
        if (this.VH == 37 || this.VH == 22) {
            DW();
            i3++;
            QX();
            i3++;
        }
        Hw(26);
        FH(i != 0 ? 208 : 207, i3 + 1);
    }

    private boolean v5(int i, int i2) {
        return Zo(i) == 30 && Zo(VH(i), i2);
    }

    private boolean Zo(int i, int i2) {
        return this.FH.FH(i) == i2;
    }

    private void QX() {
        int i = 1;
        a8();
        switch (this.VH) {
            case 30:
                DW();
                break;
            case 34:
                XL();
                break;
            case 40:
                DW();
                break;
            default:
                j6();
                throw new es$a();
        }
        a8();
        switch (this.VH) {
            case ProxyTextView.INPUTTYPE_time /*36*/:
            case 37:
            case 43:
                if (!(Zo(1) == 34 || (Zo(1) == 10 && Zo(2) == 34))) {
                    DW();
                    i = 2;
                    break;
                }
        }
        FH(ProxyTextView.INPUTTYPE_textWebEmailAddress, i);
    }

    private void XL() {
        Hw(34);
        int i = 1;
        Object obj = null;
        while (true) {
            a8();
            switch (this.VH) {
                case 30:
                    QX();
                    i++;
                    break;
                case 34:
                    QX();
                    i++;
                    break;
                case 40:
                    QX();
                    i++;
                    break;
                default:
                    j6();
                    throw new es$a();
            }
            a8();
            int i2;
            switch (this.VH) {
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                    DW();
                    if (obj <= null || obj == 33) {
                        i2 = 33;
                    } else {
                        j6("Unexpected |");
                    }
                    i++;
                    break;
                case 35:
                    Hw(35);
                    i++;
                    switch (obj) {
                        case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                            FH(210, i);
                            return;
                        case 50:
                            FH(212, i);
                            return;
                        default:
                            FH(211, i);
                            return;
                    }
                case 42:
                    DW();
                    if (obj <= null || obj == 42) {
                        i2 = 42;
                    } else {
                        j6("Unexpected ,");
                    }
                    i++;
                    break;
                case 50:
                    DW();
                    if (obj <= null || obj == 50) {
                        i2 = 50;
                    } else {
                        j6("Unexpected &");
                    }
                    i++;
                    break;
                default:
                    j6();
                    throw new es$a();
            }
        }
    }

    private void aM() {
        int i;
        int i2 = 1;
        DW();
        a8();
        if (this.VH == 20) {
            DW();
            i = 2;
            a8();
        } else {
            i = 1;
            i2 = 0;
        }
        if (this.VH != 30) {
            j6();
            throw new es$a();
        }
        int i3;
        DW();
        i++;
        a8();
        if (v5(0, this.U2)) {
            Mr();
            i3 = i + 1;
        } else if (v5(0, this.a8)) {
            j3();
            i3 = i + 1;
        } else if (v5(0, this.rN)) {
            DW();
            i3 = i + 1;
            a8();
            U2();
            i3++;
        } else {
            U2();
            i3 = i + 1;
        }
        a8();
        Hw(26);
        FH(i2 != 0 ? 202 : 203, i3 + 1);
    }

    private void j3() {
        DW();
        a8();
        U2();
        FH(206, 2);
    }

    private void Mr() {
        DW();
        a8();
        U2();
        a8();
        if (this.VH == 18 || this.VH == 19) {
            U2();
            FH(205, 3);
            return;
        }
        FH(205, 2);
    }

    private void U2() {
        if (this.VH == 18 || this.VH == 19) {
            int i = this.VH;
            DW();
            int i2 = 1;
            while (this.VH != i) {
                switch (this.VH) {
                    case 27:
                    case 28:
                    case 29:
                    case 31:
                        DW();
                        i2++;
                    default:
                        j6();
                        throw new es$a();
                }
            }
            Hw(i);
            FH(204, i2 + 1);
            return;
        }
        j6();
        throw new es$a();
    }

    private void a8() {
        while (true) {
            switch (this.VH) {
                case 10:
                case 15:
                case 16:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    Hw();
                default:
                    return;
            }
        }
    }

    private void DW(String str) {
        if (this.v5) {
            int i = this.we[this.gn];
            int i2 = this.we[this.gn];
            this.DW.Zo(this.Zo.we(), this.Zo.tp(), i, this.J8[this.gn], i2, this.Ws[this.gn], str, 0);
        }
    }
}
