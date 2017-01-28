import com.aide.uidesigner.ProxyTextView;

class he$a {
    private final hq DW;
    private dr<bz> EQ;
    private final he FH;
    private int Hw;
    private dm<bp> J0;
    private ea<bz> J8;
    private boolean VH;
    private di Ws;
    private cj Zo;
    private boolean gn;
    private final cc j6;
    private dz tp;
    private boolean u7;
    private int v5;
    private dt we;

    public he$a(cc ccVar, hq hqVar, he heVar) {
        this.Ws = new di();
        this.j6 = ccVar;
        this.DW = hqVar;
        this.FH = heVar;
        this.J8 = new ea(ccVar.cb);
        this.J0 = new dm(ccVar.cb);
        this.tp = new dz();
        this.we = new dt();
        this.EQ = new dr(ccVar.cb);
        this.Hw = ccVar.ro.j6("Array");
        this.v5 = ccVar.ro.j6("String");
    }

    public void j6(cj cjVar, boolean z) {
        this.Zo = cjVar;
        this.VH = false;
        this.gn = true;
        this.u7 = z;
        DW(cjVar);
        this.Zo = null;
    }

    public void j6(cj cjVar) {
        this.Zo = cjVar;
        this.VH = true;
        this.gn = false;
        this.u7 = false;
        DW(cjVar);
        this.Zo = null;
    }

    private void DW(cj cjVar) {
        this.Ws.j6();
        this.tp.j6();
        this.EQ.DW();
        this.we.DW();
        this.J0.j6();
        DW(cjVar.Ws());
        this.J0.j6(this.FH.v5(cjVar));
        j6(cjVar.Ws(), cjVar.Ws(), -1);
    }

    private void j6(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 1;
        int Hw;
        do doVar;
        int Hw2;
        int lg;
        int i6;
        int Hw3;
        int Hw4;
        bs DW;
        bz bzVar;
        switch (this.Zo.rN(i)) {
            case 124:
            case 125:
                this.tp.DW();
                Hw = this.Zo.Hw(i, this.Zo.lg(i) - 1);
                DW(Hw);
                do doVar2 = new do();
                j6(Hw, doVar2);
                doVar = new do();
                Hw2 = this.Zo.Hw(i, this.Zo.lg(i) - 2);
                lg = this.Zo.lg(Hw2);
                if (lg > 2) {
                    for (i6 = 1; i6 < lg; i6 += 2) {
                        Hw3 = this.Zo.Hw(this.Zo.Hw(Hw2, i6), 0);
                        this.tp.j6(this.Zo.gW(Hw3), Hw3);
                        this.Zo.j6(Hw3, 1, Hw3);
                        doVar.DW(Hw3);
                        if (this.VH) {
                            this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), Hw3, Hw3);
                        }
                    }
                }
                Hw4 = this.Zo.Hw(Hw, 0);
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), Hw4, Hw4);
                }
                if (this.VH) {
                    this.j6.Sf.DW(this.Zo.we(), this.Zo.tp(), j6(i), Hw4);
                }
                if (((hu) this.Zo.tp().Hw()).U2(this.Zo, i) != -1) {
                    lg = ((hu) this.Zo.tp().Hw()).U2(this.Zo, i);
                    try {
                        DW = this.j6.cb.DW(this.Zo.we(), this.Zo.tp(), this.Zo.XL(lg));
                        try {
                            this.Zo.j6(lg, 19, DW);
                            if (this.VH) {
                                this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                            }
                        } catch (ej e) {
                        }
                    } catch (ej e2) {
                        DW = null;
                    }
                    bzVar = DW;
                } else if (this.Zo.lg(i) == 4) {
                    lg = this.Zo.Hw(i, 1);
                    if (this.Zo.rN(i) == 125) {
                        try {
                            DW = this.j6.cb.DW(this.Zo.we(), this.Zo.tp(), this.Zo.XL(i));
                            try {
                                this.Zo.j6(lg, 19, DW);
                                if (this.VH) {
                                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), (bz) DW, i);
                                }
                                if (this.VH) {
                                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, lg);
                                }
                            } catch (ej e3) {
                            }
                        } catch (ej e4) {
                            DW = null;
                        }
                    } else {
                        this.Zo.j6(lg, 1, lg);
                        if (this.VH) {
                            this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, lg);
                        }
                        DW = null;
                    }
                    bs bsVar = DW;
                } else {
                    if (this.VH) {
                        this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                    }
                    bzVar = null;
                }
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, Hw4, doVar, doVar2, bzVar);
                }
                j6(Hw, i, Hw4);
                this.tp.FH();
            case 140:
                int lg2 = this.Zo.lg(i);
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i);
                }
                if (this.VH) {
                    this.j6.Sf.DW(this.Zo.we(), this.Zo.tp(), this.Zo.Hw(i, 0), i);
                }
                for (Hw = 1; Hw < lg2 - 1; Hw += 4) {
                    Hw4 = this.Zo.Hw(i, Hw);
                    Hw3 = this.Zo.Hw(i, Hw - 1);
                    int Hw5 = this.Zo.Hw(i, Hw + 2);
                    if (this.Zo.rN(Hw4) == 1) {
                        int gW = this.Zo.gW(Hw4);
                        if (this.gn) {
                            j6(Hw4, Hw3);
                        }
                        try {
                            bzVar = this.j6.cb.DW(this.Zo.we(), this.Zo.tp(), this.Zo.XL(Hw4));
                            if (this.VH) {
                                this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), Hw3, Hw4, gW, true, bzVar, Hw5);
                            }
                        } catch (ej e5) {
                        }
                        if (this.VH) {
                            this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), Hw3, i);
                        }
                    }
                    j6(Hw5, i2, i3);
                }
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                }
            case 151:
            case 152:
                Hw2 = this.Zo.lg(i);
                for (i6 = 1; i6 < Hw2; i6 += 2) {
                    lg = this.Zo.Hw(i, i6);
                    Hw3 = this.Zo.Hw(lg, 0);
                    if (this.Zo.lg(lg) == 3) {
                        j6(this.Zo.Hw(lg, 2), i2, i3);
                        if (this.VH) {
                            this.j6.Sf.DW(this.Zo.we(), this.Zo.tp(), this.Zo.Hw(lg, 2), lg);
                        }
                    }
                    if (this.Zo.rN(i) == 152) {
                        try {
                            bz DW2 = this.j6.cb.DW(this.Zo.we(), this.Zo.tp(), this.Zo.XL(lg));
                            this.Zo.j6(Hw3, 15, (bs) DW2);
                            if (this.VH) {
                                this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), lg, Hw3);
                            }
                            if (this.VH) {
                                this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), DW2, lg);
                            }
                        } catch (ej e6) {
                        }
                    } else {
                        Hw4 = this.tp.j6(this.Zo.gW(Hw3));
                        if (this.VH) {
                            this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), lg, Hw4);
                        }
                        if (Hw4 != Hw3) {
                            this.Zo.j6(Hw3, 2, Hw4);
                        } else {
                            this.Zo.j6(Hw3, 1, Hw4);
                        }
                    }
                }
            case 159:
                boolean z;
                Hw3 = this.Zo.Hw(i, 0);
                Hw4 = this.Zo.Hw(i, 2);
                if (this.gn) {
                    j6(Hw4, Hw3);
                }
                if (this.Zo.rN(this.Zo.aM(i)) == 172 && this.Zo.Hw(this.Zo.aM(i), 0) == i && this.Zo.rN(this.Zo.Hw(this.Zo.aM(i), 1)) == 17) {
                    z = true;
                } else {
                    z = false;
                }
                bzVar = null;
                if (((hu) this.DW.Hw()).lg(this.Zo, Hw4) || ((hu) this.DW.Hw()).Mr(this.Zo, Hw4)) {
                    try {
                        bzVar = this.j6.cb.DW(this.Zo.we(), this.Zo.tp(), this.Zo.XL(Hw4));
                    } catch (ej e7) {
                    }
                }
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), Hw3, Hw4, this.Zo.gW(Hw4), z, bzVar, i);
                }
                j6(Hw3, i2, i3);
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                }
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                Hw = this.Zo.Hw(i, 0);
                Hw3 = this.Zo.gW(Hw);
                if (this.tp.DW(Hw3)) {
                    i6 = this.tp.j6(Hw3);
                    if (this.VH) {
                        this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i6);
                    }
                    this.Zo.j6(Hw, 2, i6);
                    return;
                }
                if (!this.EQ.j6(Hw3)) {
                    try {
                        bp j6 = this.j6.cb.j6(this.Zo.we(), this.Zo.tp(), this.Zo.XL(this.Zo.Ws()));
                        while (i4 < this.J0.Hw()) {
                            bp bpVar = (bp) this.J0.j6(i4);
                            this.J8.j6();
                            bpVar.DW(this.Zo.we(), this.Zo.tp(), Hw3, true, j6, this.J8);
                            if (this.J8.Hw() == 1) {
                                this.EQ.j6(Hw3, this.J8.DW());
                                if (this.VH) {
                                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, (bz) this.J8.DW());
                                }
                            } else {
                                this.J8.j6();
                                bpVar.j6(this.Zo.we(), this.Zo.tp(), Hw3, true, j6, this.J8);
                                if (this.J8.Hw() == 1) {
                                    this.EQ.j6(Hw3, this.J8.DW());
                                    if (this.VH) {
                                        this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, (bz) this.J8.DW());
                                    }
                                } else {
                                    i4++;
                                }
                            }
                        }
                    } catch (ej e8) {
                    }
                }
                if (!this.we.FH(Hw3)) {
                    this.we.j6(Hw3, Hw);
                }
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, this.we.Hw(Hw3));
                }
                if (this.EQ.j6(Hw3)) {
                    DW = (bz) this.EQ.FH(Hw3);
                    if (DW.gn()) {
                        this.Zo.j6(Hw, 20, DW);
                        return;
                    } else {
                        this.Zo.j6(Hw, 16, DW);
                        return;
                    }
                }
                this.Zo.j6(Hw, 2, this.we.Hw(Hw3));
                if (this.u7) {
                    this.j6.sG.DW(this.Zo.we(), this.Zo.tp(), this.Zo.nw(Hw), this.Zo.KD(Hw), this.Zo.SI(Hw), this.Zo.ro(Hw), "Unknown variable " + this.Zo.BT(Hw), 21);
                }
            case 165:
                Hw2 = this.Zo.Hw(i, 0);
                lg = this.Zo.lg(i);
                for (i6 = 2; i6 < lg - 1; i6 += 2) {
                    j6(this.Zo.Hw(i, i6), i2, i3);
                }
                if (this.VH) {
                    this.j6.Sf.FH(this.Zo.we(), this.Zo.tp(), Hw2, i);
                }
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                }
                j6(Hw2, i2, i3);
            case 166:
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i3);
                }
            case 168:
                j6(this.Zo.Hw(i, 1), i2, i3);
                if (this.VH) {
                    this.j6.Sf.DW(this.Zo.we(), this.Zo.tp(), this.Zo.Hw(i, 1), i);
                }
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                }
            case 172:
                j6(this.Zo.Hw(i, 0), i2, i3);
                j6(this.Zo.Hw(i, 1), i2, i3);
                j6(this.Zo.Hw(i, 2), i2, i3);
                if (this.Zo.rN(this.Zo.Hw(i, 1)) == 17) {
                    if (this.VH) {
                        this.j6.Sf.DW(this.Zo.we(), this.Zo.tp(), this.Zo.Hw(i, 2), this.Zo.Hw(i, 0));
                    }
                    if (this.VH) {
                        this.j6.Sf.DW(this.Zo.we(), this.Zo.tp(), this.Zo.Hw(i, 0), i);
                    }
                }
            case 175:
                Hw3 = this.Zo.Hw(i, 0);
                doVar = new do();
                i6 = this.Zo.Hw(i, 1);
                Hw2 = this.Zo.lg(i6);
                if (Hw2 > 2) {
                    while (i5 < Hw2) {
                        lg = this.Zo.Hw(i6, i5);
                        doVar.DW(lg);
                        j6(lg, i2, i3);
                        i5 += 2;
                    }
                }
                if (this.Zo.rN(this.Zo.aM(i)) != 176 || this.Zo.rN(Hw3) != ProxyTextView.INPUTTYPE_textWebEditText || this.Zo.gW(this.Zo.Hw(Hw3, 0)) != this.v5) {
                    if (this.Zo.rN(this.Zo.aM(i)) != 176 || this.Zo.rN(Hw3) != ProxyTextView.INPUTTYPE_textWebEditText || this.Zo.gW(this.Zo.Hw(Hw3, 0)) != this.Hw) {
                        if (this.Zo.rN(this.Zo.aM(i)) == 176) {
                            if (this.VH) {
                                this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), Hw3, this.Zo.aM(i), doVar, i);
                            }
                        } else if (this.Zo.rN(Hw3) == 159) {
                            if (this.VH) {
                                this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), Hw3, this.Zo.Hw(Hw3, 0), doVar, i);
                            }
                        } else if (this.VH) {
                            this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), Hw3, -1, doVar, i);
                        }
                        if (this.VH) {
                            this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                        }
                        j6(Hw3, i2, i3);
                    }
                }
            case 176:
                j6(this.Zo.Hw(i, 1), i2, i3);
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                }
                if (this.Zo.rN(this.Zo.Hw(i, 1)) == 175 && this.Zo.rN(this.Zo.Hw(this.Zo.Hw(i, 1), 0)) == ProxyTextView.INPUTTYPE_textWebEditText && this.Zo.J8(this.Zo.Hw(this.Zo.Hw(this.Zo.Hw(i, 1), 0), 0)) != 2 && this.Zo.gW(this.Zo.Hw(this.Zo.Hw(this.Zo.Hw(i, 1), 0), 0)) != this.Hw && this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i);
                }
            case 178:
                i6 = this.Zo.lg(i);
                while (i4 < i6) {
                    j6(this.Zo.Hw(i, i4), i2, i3);
                    i4 += 2;
                }
            case 196:
                i6 = this.Zo.lg(i);
                if (this.VH) {
                    this.j6.Sf.DW(this.Zo.we(), this.Zo.tp(), this.Zo.Hw(i, 0), i);
                }
                while (i5 < i6 - 1) {
                    Hw2 = this.Zo.Hw(i, i5);
                    lg = this.Zo.Hw(i, i5 - 1);
                    if (this.VH) {
                        this.j6.Sf.FH(this.Zo.we(), this.Zo.tp(), lg, Hw2);
                    }
                    j6(Hw2, i2, i3);
                    if (this.VH) {
                        this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), lg, i);
                    }
                    i5 += 2;
                }
                if (this.VH) {
                    this.j6.Sf.j6(this.Zo.we(), this.Zo.tp(), i, i);
                }
            default:
                i6 = this.Zo.lg(i);
                while (i4 < i6) {
                    j6(this.Zo.Hw(i, i4), i2, i3);
                    i4++;
                }
        }
    }

    private void j6(int i, int i2) {
        int gW = this.Zo.gW(i);
        int DW = this.j6.Sf.DW(this.Zo.we(), this.Zo.tp(), i2);
        bs j6 = this.j6.Sf.j6(DW, gW);
        if (j6 != null) {
            bs DW2;
            if (((hu) this.DW.Hw()).lg(this.Zo, i) || ((hu) this.DW.Hw()).Mr(this.Zo, i)) {
                try {
                    DW2 = this.j6.cb.DW(this.Zo.we(), this.Zo.tp(), this.Zo.XL(i));
                } catch (ej e) {
                    DW2 = null;
                }
            } else {
                DW2 = null;
            }
            if (j6 == DW2) {
                this.Zo.j6(i, 19, j6);
                return;
            } else {
                this.Zo.j6(i, 20, j6);
                return;
            }
        }
        int i3 = (DW << 16) | gW;
        if (!this.Ws.j6((long) i3)) {
            this.Ws.j6((long) i3, i);
        }
        this.Zo.j6(i, 1, this.Ws.DW((long) i3));
        if (this.j6.Sf.DW(DW, gW) && this.u7) {
            this.j6.sG.Hw(this.Zo.we(), this.Zo.tp(), this.Zo.nw(i), this.Zo.KD(i), this.Zo.SI(i), this.Zo.ro(i), "Unknwon member " + this.Zo.BT(i), 20);
        }
    }

    private int j6(int i) {
        if (this.Zo.lg(i) == 4) {
            return -1;
        }
        int Hw = this.Zo.Hw(i, this.Zo.lg(i) - 1);
        if (this.Zo.lg(Hw) >= 3 && this.Zo.rN(this.Zo.Hw(Hw, 1)) == 146) {
            Hw = this.Zo.Hw(this.Zo.Hw(Hw, 1), 0);
            if (this.Zo.rN(Hw) == 172 && this.Zo.rN(this.Zo.Hw(Hw, 1)) == 17 && this.Zo.rN(this.Zo.Hw(Hw, 0)) == 159 && this.Zo.rN(this.Zo.Hw(this.Zo.Hw(Hw, 0), 0)) == 166) {
                return -1;
            }
        }
        if (this.Zo.rN(this.Zo.aM(i)) == 140) {
            return this.Zo.aM(i);
        }
        if (this.Zo.rN(this.Zo.aM(i)) != 172 || this.Zo.rN(this.Zo.Hw(this.Zo.aM(i), 1)) != 17 || this.Zo.Hw(this.Zo.aM(i), 2) != i) {
            return -1;
        }
        Hw = this.Zo.Hw(this.Zo.aM(i), 0);
        if (this.Zo.rN(Hw) == 159) {
            return this.Zo.Hw(Hw, 0);
        }
        return -1;
    }

    private void DW(int i) {
        int Hw;
        int i2 = 0;
        switch (this.Zo.rN(i)) {
            case 124:
                if (this.Zo.lg(i) == 4) {
                    i2 = this.Zo.Hw(i, 1);
                    this.tp.j6(this.Zo.gW(i2), i2);
                    return;
                }
                return;
            case 125:
                try {
                    i2 = this.Zo.Hw(i, 1);
                    this.we.j6(this.Zo.gW(i2), i2);
                    this.EQ.j6(this.Zo.gW(i2), this.j6.cb.DW(this.Zo.we(), this.Zo.tp(), this.Zo.XL(i)));
                    return;
                } catch (ej e) {
                    return;
                }
            case 200:
                Hw = this.Zo.Hw(i, 0);
                this.tp.j6(this.Zo.gW(Hw), Hw);
                break;
            case 207:
                try {
                    Hw = this.Zo.Hw(i, 0);
                    this.we.j6(this.Zo.gW(Hw), Hw);
                    this.EQ.j6(this.Zo.gW(Hw), this.j6.cb.DW(this.Zo.we(), this.Zo.tp(), this.Zo.XL(i)));
                    break;
                } catch (ej e2) {
                    break;
                }
        }
        Hw = this.Zo.lg(i);
        while (i2 < Hw) {
            DW(this.Zo.Hw(i, i2));
            i2++;
        }
    }

    private void j6(int i, do doVar) {
        switch (this.Zo.rN(i)) {
            case 124:
            case 125:
                return;
            case 141:
                if (this.Zo.lg(i) == 3) {
                    doVar.DW(this.Zo.Hw(i, 1));
                    break;
                }
                break;
        }
        int lg = this.Zo.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(this.Zo.Hw(i, i2), doVar);
        }
    }
}
