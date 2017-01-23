import com.aide.uidesigner.ProxyTextView;

class gz$a {
    private gz DW;
    private cj FH;
    private bt Hw;
    private gz$a$a j6;
    private hc v5;

    public gz$a(gz gzVar, bt btVar) {
        this.j6 = new gz$a$a(this, btVar);
        this.DW = gzVar;
    }

    public void j6(bt btVar, hc hcVar, cj cjVar) {
        this.Hw = btVar;
        this.v5 = hcVar;
        this.FH = cjVar;
        this.j6.j6();
        if (!cjVar.u7()) {
            j6(cjVar.Ws());
        }
        this.FH = null;
        this.j6.j6();
    }

    private void j6(int i) {
        int i2 = 0;
        bp j6;
        int lg;
        switch (this.FH.rN(i)) {
            case 120:
            case 121:
            case 220:
            case 221:
            case 227:
            case 228:
                try {
                    j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
                    this.j6.FH();
                    U2(this.FH.Hw(i, 3));
                    this.j6.j6(j6);
                    j6(this.FH.Hw(i, this.FH.lg(i) - 1));
                    this.j6.DW();
                    this.j6.Hw();
                } catch (ej e) {
                }
            case 123:
                FH(i);
            case 124:
                v5(i);
            case 126:
                Hw(i);
            case 127:
                this.j6.VH();
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    j6(this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.gn();
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 222:
                try {
                    j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
                    this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
                    this.j6.FH();
                    U2(this.FH.Hw(i, 3));
                    this.j6.j6(j6);
                    j6(this.FH.Hw(i, this.FH.lg(i) - 1));
                    this.j6.DW();
                    this.j6.Hw();
                } catch (ej e2) {
                }
            case 133:
                this.j6.u7();
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    j6(this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.tp();
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                try {
                    j6(this.FH.Hw(i, this.FH.lg(i) - 2));
                    this.j6.j6(this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i)));
                    if (this.FH.lg(i) == 7) {
                        j6(this.FH.Hw(i, 0));
                    }
                    j6(this.FH.Hw(i, this.FH.lg(i) - 1));
                    this.j6.DW();
                } catch (ej e3) {
                }
            case 223:
                j3(this.FH.Hw(i, 0));
                int lg2 = this.FH.lg(i);
                for (i2 = 1; i2 < lg2; i2++) {
                    DW(this.FH.Hw(i, i2));
                }
                Mr(i);
                for (i2 = 1; i2 < lg2; i2++) {
                    lg = this.FH.Hw(i, i2);
                    if (this.FH.rN(lg) == 120 || this.FH.rN(lg) == 220 || this.FH.rN(lg) == 245 || this.FH.rN(lg) == 121) {
                        j6(this.FH.Hw(i, i2));
                    }
                }
            case 245:
            case 246:
                try {
                    this.Hw.j6(this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i)), j6(BT(this.FH.Hw(i, 2)), this.FH.Hw(i, 3)));
                } catch (ej e4) {
                }
            default:
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    j6(this.FH.Hw(i, i2));
                    i2++;
                }
        }
    }

    private void DW(int i) {
        switch (this.FH.rN(i)) {
            case 213:
                rN(i);
            case 214:
                lg(i);
            case ProxyTextView.INPUTTYPE_textWebPassword /*225*/:
                yS(i);
            case 226:
                er(i);
            default:
        }
    }

    private void FH(int i) {
        this.j6.VH();
        a8(this.FH.Hw(i, 1));
        try {
            int i2;
            int i3;
            int i4;
            int Hw;
            bz DW = this.Hw.DW(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            int Hw2 = this.FH.Hw(i, 1);
            int lg = this.FH.lg(Hw2);
            int i5 = 1;
            int i6 = 0;
            while (i5 < lg) {
                int Hw3 = this.FH.Hw(Hw2, i5);
                try {
                    ca Hw4 = this.Hw.Hw(this.FH.we(), this.FH.tp(), this.FH.XL(Hw3));
                    int lg2 = this.FH.lg(Hw3);
                    for (i2 = 2; i2 < lg2; i2 += 2) {
                        co BT = BT(this.FH.Hw(Hw3, i2));
                        if (BT.cT() || BT.n5() || BT.q7() || BT.Z1()) {
                            if (BT.Z1()) {
                                if (((ca) BT).DW() == DW) {
                                    if (((ca) BT).FH() >= i6) {
                                    }
                                }
                            }
                            this.Hw.j6(Hw4, BT);
                        }
                    }
                } catch (ej e) {
                }
                i5 += 2;
                i6++;
            }
            i2 = this.FH.Hw(i, 3);
            i5 = this.FH.lg(i2);
            if (i5 > 2) {
                i3 = 0;
                for (i4 = 1; i4 < i5 - 1; i4 += 2) {
                    Hw = this.FH.Hw(i2, i4);
                    if (this.FH.rN(Hw) != 16) {
                        try {
                            this.Hw.DW(DW, j6(j6(BT(this.FH.Hw(Hw, 1)), this.FH.Hw(Hw, 2)), this.FH.Hw(Hw, 4)), i3);
                        } catch (ej e2) {
                        }
                        i3++;
                    }
                }
            }
            i2 = this.FH.Hw(i, 4);
            Hw = this.FH.lg(i2);
            i3 = 1;
            i4 = 0;
            while (i3 < Hw) {
                try {
                    co BT2 = BT(this.FH.Hw(i2, i3));
                    if (BT2.cT() || BT2.Z1() || BT2.q7()) {
                        this.Hw.j6(DW, BT2, i4);
                        i4++;
                        i3 += 2;
                    } else {
                        i4++;
                        i3 += 2;
                    }
                } catch (ej e3) {
                }
            }
        } catch (ej e4) {
        }
        j6(this.FH.Hw(i, this.FH.lg(i) - 1));
        this.j6.gn();
    }

    private void Hw(int i) {
        this.j6.VH();
        try {
            co j6 = j6(BT(this.FH.Hw(i, 1)), this.FH.Hw(i, 2));
            int lg = this.FH.lg(i);
            for (int i2 = 3; i2 < lg; i2 += 2) {
                int Hw = this.FH.Hw(i, i2);
                try {
                    this.Hw.j6(this.Hw.DW(this.FH.we(), this.FH.tp(), this.FH.XL(Hw)), j6(j6, this.FH.Hw(Hw, 1)));
                } catch (ej e) {
                }
                j6(Hw);
            }
        } catch (ej e2) {
        }
        this.j6.gn();
    }

    private void v5(int i) {
        this.j6.VH();
        a8(this.FH.Hw(i, 1));
        try {
            int i2;
            int i3;
            int i4;
            int Hw;
            co j6 = j6(j6(BT(this.FH.Hw(i, 2)), this.FH.Hw(i, 3)), this.FH.Hw(i, 6));
            bz DW = this.Hw.DW(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            this.Hw.j6(DW, j6);
            int Hw2 = this.FH.Hw(i, 1);
            int lg = this.FH.lg(Hw2);
            int i5 = 1;
            int i6 = 0;
            while (i5 < lg) {
                int Hw3 = this.FH.Hw(Hw2, i5);
                try {
                    ca Hw4 = this.Hw.Hw(this.FH.we(), this.FH.tp(), this.FH.XL(Hw3));
                    int lg2 = this.FH.lg(Hw3);
                    for (i2 = 2; i2 < lg2; i2 += 2) {
                        co BT = BT(this.FH.Hw(Hw3, i2));
                        if (BT.cT() || BT.n5() || BT.q7() || BT.Z1()) {
                            if (BT.Z1()) {
                                if (((ca) BT).DW() == DW) {
                                    if (((ca) BT).FH() >= i6) {
                                    }
                                }
                            }
                            this.Hw.j6(Hw4, BT);
                        }
                    }
                } catch (ej e) {
                }
                i5 += 2;
                i6++;
            }
            i2 = this.FH.Hw(i, 5);
            i5 = this.FH.lg(i2);
            if (i5 > 2) {
                i3 = 0;
                for (i4 = 1; i4 < i5 - 1; i4 += 2) {
                    Hw = this.FH.Hw(i2, i4);
                    if (this.FH.rN(Hw) != 16) {
                        try {
                            this.Hw.DW(DW, j6(j6(BT(this.FH.Hw(Hw, 1)), this.FH.Hw(Hw, 2)), this.FH.Hw(Hw, 4)), i3);
                        } catch (ej e2) {
                        }
                        i3++;
                    }
                }
            }
            i2 = this.FH.Hw(i, 7);
            Hw = this.FH.lg(i2);
            i3 = 1;
            i4 = 0;
            while (i3 < Hw) {
                try {
                    co BT2 = BT(this.FH.Hw(i2, i3));
                    if (BT2.cT() || BT2.Z1() || BT2.q7()) {
                        this.Hw.j6(DW, BT2, i4);
                        i4++;
                        i3 += 2;
                    } else {
                        i4++;
                        i3 += 2;
                    }
                } catch (ej e3) {
                }
            }
        } catch (ej e4) {
        }
        j6(this.FH.Hw(i, this.FH.lg(i) - 1));
        this.j6.gn();
    }

    public void j6(bt btVar, hc hcVar, bp bpVar, cj cjVar) {
        this.Hw = btVar;
        this.FH = cjVar;
        this.v5 = hcVar;
        this.j6.j6();
        j6(bpVar, cjVar.Ws());
        this.FH = null;
        this.j6.j6();
    }

    private void j6(bp bpVar, int i) {
        int i2 = 0;
        int lg;
        switch (this.FH.rN(i)) {
            case 120:
            case 128:
            case 227:
                FH(bpVar, i);
            case 121:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 228:
                DW(bpVar, i);
            case 123:
            case 124:
                this.j6.VH();
                a8(this.FH.Hw(i, 1));
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    j6(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.gn();
            case 126:
            case 127:
                this.j6.VH();
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    j6(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.gn();
            case 133:
                this.j6.u7();
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    j6(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.tp();
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                j6(i, bpVar);
            case 220:
            case 221:
            case 222:
                Hw(bpVar, i);
            case 223:
                j3(this.FH.Hw(i, 0));
                int lg2 = this.FH.lg(i);
                for (i2 = 1; i2 < lg2; i2++) {
                    DW(this.FH.Hw(i, i2));
                }
                Mr(i);
                for (i2 = 1; i2 < lg2; i2++) {
                    lg = this.FH.Hw(i, i2);
                    if (this.FH.rN(lg) == 120 || this.FH.rN(lg) == 220 || this.FH.rN(lg) == 121) {
                        j6(bpVar, this.FH.Hw(i, i2));
                    }
                }
            default:
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    j6(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
        }
    }

    private void j6(int i, bp bpVar) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (bpVar.FH(j6)) {
                j6(bpVar, this.FH.Hw(i, this.FH.lg(i) - 2));
                this.j6.j6(j6);
                if (j6 == bpVar) {
                    try {
                        if (this.FH.lg(i) != 7) {
                            co BT = BT(this.FH.Hw(i, 2));
                            if (BT.g3()) {
                                this.Hw.DW(j6, this.v5.Zo(this.FH.we()));
                            }
                            this.Hw.DW(j6, BT);
                        } else {
                            this.Hw.DW(j6, this.v5.Zo(this.FH.we()));
                        }
                    } catch (ej e) {
                    }
                }
                if (this.FH.lg(i) == 7) {
                    j6(bpVar, this.FH.Hw(i, 0));
                }
                j6(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
            }
        } catch (ej e2) {
        }
    }

    private void DW(bp bpVar, int i) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (bpVar.FH(j6)) {
                if (this.FH.rN(i) == ProxyTextView.INPUTTYPE_textPassword) {
                    this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
                }
                this.j6.FH();
                U2(this.FH.Hw(i, 3));
                if (j6 == bpVar) {
                    int Hw = this.FH.Hw(i, 4);
                    int lg = this.FH.lg(Hw);
                    if (lg != 0) {
                        for (int i2 = 1; i2 < lg; i2 += 2) {
                            try {
                                this.Hw.DW(j6, BT(this.FH.Hw(Hw, i2)));
                            } catch (ej e) {
                            }
                        }
                    } else if (j6 != this.v5.Zo(this.FH.we())) {
                        this.Hw.DW(j6, this.v5.Zo(this.FH.we()));
                    }
                }
                this.j6.j6(j6);
                j6(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
                this.j6.Hw();
            } else if (this.FH.rN(i) == ProxyTextView.INPUTTYPE_textPassword) {
                this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
            }
        } catch (ej e2) {
        }
    }

    private void FH(bp bpVar, int i) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (bpVar.FH(j6)) {
                if (this.FH.rN(i) == 128) {
                    this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
                }
                this.j6.FH();
                U2(this.FH.Hw(i, 3));
                if (j6 == bpVar) {
                    int Hw = this.FH.Hw(i, 4);
                    if (this.FH.lg(Hw) != 0) {
                        try {
                            this.Hw.DW(j6, BT(this.FH.Hw(Hw, 1)));
                        } catch (ej e) {
                        }
                    } else if (j6 != this.v5.Zo(this.FH.we())) {
                        this.Hw.DW(j6, this.v5.Zo(this.FH.we()));
                    }
                    Hw = this.FH.Hw(i, 5);
                    int lg = this.FH.lg(Hw);
                    for (int i2 = 1; i2 < lg; i2 += 2) {
                        try {
                            this.Hw.DW(j6, BT(this.FH.Hw(Hw, i2)));
                        } catch (ej e2) {
                        }
                    }
                }
                this.j6.j6(j6);
                j6(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
                this.j6.Hw();
            } else if (this.FH.rN(i) == 128) {
                this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
            }
        } catch (ej e3) {
        }
    }

    private void Hw(bp bpVar, int i) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (bpVar.FH(j6)) {
                if (this.FH.rN(i) == 222) {
                    this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
                }
                this.j6.FH();
                U2(this.FH.Hw(i, 3));
                if (j6 == bpVar) {
                    int Hw = this.FH.Hw(i, 4);
                    if (this.FH.lg(Hw) != 0) {
                        try {
                            this.Hw.DW(j6, BT(this.FH.Hw(Hw, 1)));
                        } catch (ej e) {
                        }
                    } else if (j6 != this.v5.Zo(this.FH.we())) {
                        this.Hw.DW(j6, this.v5.Zo(this.FH.we()));
                    }
                    Hw = this.FH.Hw(i, 5);
                    int lg = this.FH.lg(Hw);
                    for (int i2 = 1; i2 < lg; i2 += 2) {
                        try {
                            this.Hw.DW(j6, BT(this.FH.Hw(Hw, i2)));
                        } catch (ej e2) {
                        }
                    }
                }
                this.j6.j6(j6);
                j6(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
                this.j6.Hw();
            } else if (this.FH.rN(i) == 222) {
                this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
            }
        } catch (ej e3) {
        }
    }

    public void DW(bt btVar, hc hcVar, bp bpVar, cj cjVar) {
        this.Hw = btVar;
        this.FH = cjVar;
        this.v5 = hcVar;
        this.j6.j6();
        if (!cjVar.u7()) {
            v5(bpVar, cjVar.Ws());
        }
        this.FH = null;
        this.j6.j6();
    }

    private void v5(bp bpVar, int i) {
        int i2 = 0;
        int lg;
        switch (this.FH.rN(i)) {
            case 120:
            case 128:
            case 227:
                VH(bpVar, i);
            case 121:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 228:
                Zo(bpVar, i);
            case 123:
            case 124:
                this.j6.VH();
                a8(this.FH.Hw(i, 1));
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    v5(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.gn();
            case 126:
            case 127:
                this.j6.VH();
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    v5(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.gn();
            case 133:
                this.j6.u7();
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    v5(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.tp();
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                try {
                    v5(bpVar, this.FH.Hw(i, this.FH.lg(i) - 2));
                    bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
                    if (bpVar.FH(j6)) {
                        this.j6.j6(j6);
                        if (this.FH.lg(i) == 7) {
                            v5(bpVar, this.FH.Hw(i, 0));
                        }
                        v5(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                        this.j6.DW();
                    }
                } catch (ej e) {
                }
            case 220:
            case 221:
            case 222:
            case 223:
                j3(this.FH.Hw(i, 0));
                int lg2 = this.FH.lg(i);
                for (i2 = 1; i2 < lg2; i2++) {
                    DW(this.FH.Hw(i, i2));
                }
                Mr(i);
                for (i2 = 1; i2 < lg2; i2++) {
                    lg = this.FH.Hw(i, i2);
                    if (this.FH.rN(lg) == 120 || this.FH.rN(lg) == 220 || this.FH.rN(lg) == 121) {
                        v5(bpVar, this.FH.Hw(i, i2));
                    }
                }
            default:
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    v5(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
        }
    }

    private void Zo(bp bpVar, int i) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (bpVar.FH(j6)) {
                if (this.FH.rN(i) == ProxyTextView.INPUTTYPE_textPassword) {
                    this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
                }
                this.j6.FH();
                U2(this.FH.Hw(i, 3));
                if (j6 == bpVar) {
                    int Hw = this.FH.Hw(i, 3);
                    int lg = this.FH.lg(Hw);
                    int i2 = 1;
                    int i3 = 0;
                    while (i2 < lg) {
                        try {
                            int Hw2 = this.FH.Hw(Hw, i2);
                            cg FH = this.Hw.FH(this.FH.we(), this.FH.tp(), this.FH.XL(Hw2));
                            int lg2 = this.FH.lg(Hw2);
                            for (int i4 = 2; i4 < lg2; i4 += 2) {
                                co BT = BT(this.FH.Hw(Hw2, i4));
                                if (BT.cT() || BT.n5() || BT.q7() || BT.Z1()) {
                                    if (BT.q7()) {
                                        if (((cg) BT).gn() == j6) {
                                            if (((cg) BT).FH() >= i3) {
                                            }
                                        }
                                    }
                                    this.Hw.j6(FH, BT);
                                }
                            }
                        } catch (ej e) {
                        }
                        i2 += 2;
                        i3++;
                    }
                }
                this.j6.j6(j6);
                v5(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
                this.j6.Hw();
            } else if (this.FH.rN(i) == ProxyTextView.INPUTTYPE_textPassword) {
                this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
            }
        } catch (ej e2) {
        }
    }

    private void VH(bp bpVar, int i) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (bpVar.FH(j6)) {
                if (this.FH.rN(i) == 128) {
                    this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
                }
                this.j6.FH();
                U2(this.FH.Hw(i, 3));
                if (j6 == bpVar) {
                    int Hw = this.FH.Hw(i, 3);
                    int lg = this.FH.lg(Hw);
                    int i2 = 1;
                    int i3 = 0;
                    while (i2 < lg) {
                        try {
                            int Hw2 = this.FH.Hw(Hw, i2);
                            cg FH = this.Hw.FH(this.FH.we(), this.FH.tp(), this.FH.XL(Hw2));
                            int lg2 = this.FH.lg(Hw2);
                            for (int i4 = 2; i4 < lg2; i4 += 2) {
                                co BT = BT(this.FH.Hw(Hw2, i4));
                                if (BT.cT() || BT.n5() || BT.q7() || BT.Z1()) {
                                    if (BT.q7()) {
                                        if (((cg) BT).gn() == j6) {
                                            if (((cg) BT).FH() >= i3) {
                                            }
                                        }
                                    }
                                    this.Hw.j6(FH, BT);
                                }
                            }
                        } catch (ej e) {
                        }
                        i2 += 2;
                        i3++;
                    }
                }
                this.j6.j6(j6);
                v5(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
                this.j6.Hw();
            } else if (this.FH.rN(i) == 128) {
                this.j6.DW(this.FH.gW(this.FH.Hw(i, 2)), j6);
            }
        } catch (ej e2) {
        }
    }

    public void FH(bt btVar, hc hcVar, bp bpVar, cj cjVar) {
        this.Hw = btVar;
        this.FH = cjVar;
        this.v5 = hcVar;
        this.j6.j6();
        if (cjVar.Ws() != -1) {
            gn(bpVar, cjVar.Ws());
        }
        this.FH = null;
        this.j6.j6();
    }

    private void gn(bp bpVar, int i) {
        int i2 = 0;
        int lg;
        switch (this.FH.rN(i)) {
            case 120:
            case 128:
            case 227:
                tp(bpVar, i);
            case 121:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 228:
                u7(bpVar, i);
            case 123:
            case 124:
            case 126:
            case 127:
                this.j6.VH();
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    gn(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.gn();
            case 133:
                this.j6.u7();
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    gn(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
                this.j6.tp();
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                DW(i, bpVar);
            case 220:
            case 221:
            case 222:
                EQ(bpVar, i);
            case 223:
                j3(this.FH.Hw(i, 0));
                int lg2 = this.FH.lg(i);
                for (i2 = 1; i2 < lg2; i2++) {
                    DW(this.FH.Hw(i, i2));
                }
                Mr(i);
                for (i2 = 1; i2 < lg2; i2++) {
                    lg = this.FH.Hw(i, i2);
                    if (this.FH.rN(lg) == 120 || this.FH.rN(lg) == 220 || this.FH.rN(lg) == 121) {
                        gn(bpVar, this.FH.Hw(i, i2));
                    }
                }
            default:
                lg = this.FH.lg(i);
                while (i2 < lg) {
                    gn(bpVar, this.FH.Hw(i, i2));
                    i2++;
                }
        }
    }

    private void DW(int i, bp bpVar) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (this.Hw.gn() || bpVar.FH(j6)) {
                gn(bpVar, this.FH.Hw(i, this.FH.lg(i) - 2));
                this.Hw.j6(j6);
                try {
                    if (this.FH.lg(i) != 7) {
                        bp gW = gW(this.FH.Hw(i, 2));
                        if (gW.g3()) {
                            this.Hw.j6(j6, this.v5.Zo(this.FH.we()));
                        }
                        this.Hw.j6(j6, gW);
                    } else {
                        this.Hw.j6(j6, this.v5.Zo(this.FH.we()));
                    }
                } catch (ej e) {
                    this.Hw.FH(j6);
                }
                this.Hw.DW(j6);
                this.j6.j6(j6);
                if (this.FH.lg(i) == 7) {
                    gn(bpVar, this.FH.Hw(i, 0));
                }
                gn(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
            }
        } catch (ej e2) {
        }
    }

    private void u7(bp bpVar, int i) {
        bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
        if (this.Hw.gn() || bpVar.FH(j6)) {
            this.Hw.j6(j6);
            int Hw = this.FH.Hw(i, 4);
            int lg = this.FH.lg(Hw);
            if (lg != 0) {
                for (int i2 = 1; i2 < lg; i2 += 2) {
                    try {
                        this.Hw.j6(j6, gW(this.FH.Hw(Hw, i2)));
                    } catch (ej e) {
                        try {
                            this.Hw.FH(j6);
                        } catch (ej e2) {
                            return;
                        }
                    }
                }
            }
            try {
                if (j6 != this.v5.Zo(this.FH.we())) {
                    this.Hw.j6(j6, this.v5.Zo(this.FH.we()));
                }
            } catch (ej e3) {
            }
            this.Hw.DW(j6);
            if (this.FH.rN(i) == ProxyTextView.INPUTTYPE_textPassword) {
                this.j6.j6(this.FH.gW(this.FH.Hw(i, 2)), j6);
            }
            this.j6.j6(j6);
            gn(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
            this.j6.DW();
        } else if (this.FH.rN(i) == ProxyTextView.INPUTTYPE_textPassword) {
            this.j6.j6(this.FH.gW(this.FH.Hw(i, 2)), j6);
        }
    }

    private void tp(bp bpVar, int i) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (this.Hw.gn() || bpVar.FH(j6)) {
                this.Hw.j6(j6);
                int Hw = this.FH.Hw(i, 4);
                if (this.FH.lg(Hw) == 0) {
                    try {
                        if (j6 != this.v5.Zo(this.FH.we())) {
                            this.Hw.j6(j6, this.v5.Zo(this.FH.we()));
                        }
                    } catch (ej e) {
                    }
                } else {
                    try {
                        this.Hw.j6(j6, gW(this.FH.Hw(Hw, 1)));
                    } catch (ej e2) {
                        this.Hw.FH(j6);
                    }
                }
                Hw = this.FH.Hw(i, 5);
                int lg = this.FH.lg(Hw);
                for (int i2 = 1; i2 < lg; i2 += 2) {
                    try {
                        this.Hw.j6(j6, gW(this.FH.Hw(Hw, i2)));
                    } catch (ej e3) {
                    }
                }
                this.Hw.DW(j6);
                if (this.FH.rN(i) == 128) {
                    this.j6.j6(this.FH.gW(this.FH.Hw(i, 2)), j6);
                }
                this.j6.j6(j6);
                gn(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
            } else if (this.FH.rN(i) == 128) {
                this.j6.j6(this.FH.gW(this.FH.Hw(i, 2)), j6);
            }
        } catch (ej e4) {
        }
    }

    private void EQ(bp bpVar, int i) {
        try {
            bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i));
            if (this.Hw.gn() || bpVar.FH(j6)) {
                this.Hw.j6(j6);
                int Hw = this.FH.Hw(i, 4);
                if (this.FH.lg(Hw) == 0) {
                    try {
                        if (j6 != this.v5.Zo(this.FH.we())) {
                            this.Hw.j6(j6, this.v5.Zo(this.FH.we()));
                        }
                    } catch (ej e) {
                    }
                } else {
                    try {
                        this.Hw.j6(j6, gW(this.FH.Hw(Hw, 1)));
                    } catch (ej e2) {
                        this.Hw.FH(j6);
                    }
                }
                Hw = this.FH.Hw(i, 5);
                int lg = this.FH.lg(Hw);
                for (int i2 = 1; i2 < lg; i2 += 2) {
                    try {
                        this.Hw.j6(j6, gW(this.FH.Hw(Hw, i2)));
                    } catch (ej e3) {
                    }
                }
                this.Hw.DW(j6);
                if (this.FH.rN(i) == 222) {
                    this.j6.j6(this.FH.gW(this.FH.Hw(i, 2)), j6);
                }
                this.j6.j6(j6);
                gn(bpVar, this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
            } else if (this.FH.rN(i) == 222) {
                this.j6.j6(this.FH.gW(this.FH.Hw(i, 2)), j6);
            }
        } catch (ej e4) {
        }
    }

    protected void j6(bt btVar, cj cjVar) {
        this.Hw = btVar;
        this.FH = cjVar;
        Zo(cjVar.Ws());
        this.FH = null;
    }

    private void Zo(int i) {
        switch (this.FH.rN(i)) {
            case 120:
            case 121:
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 220:
            case 221:
            case 222:
            case 227:
            case 228:
                try {
                    J0(this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i)), i);
                    break;
                } catch (ej e) {
                    break;
                }
            case 123:
                try {
                    FH(this.Hw.DW(this.FH.we(), this.FH.tp(), this.FH.XL(i)), i);
                    break;
                } catch (ej e2) {
                    break;
                }
            case 124:
                try {
                    j6(this.Hw.DW(this.FH.we(), this.FH.tp(), this.FH.XL(i)), i);
                    break;
                } catch (ej e3) {
                    break;
                }
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                try {
                    J8(this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i)), i);
                    break;
                } catch (ej e4) {
                    break;
                }
            case 194:
                try {
                    DW(this.Hw.DW(this.FH.we(), this.FH.tp(), this.FH.XL(i)), i);
                    break;
                } catch (ej e5) {
                    break;
                }
        }
        int lg = this.FH.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            Zo(this.FH.Hw(i, i2));
        }
    }

    private void j6(bz bzVar, int i) {
        int nw;
        int KD;
        int SI;
        int ro;
        int nw2 = this.FH.nw(this.FH.Hw(i, 4));
        int KD2 = this.FH.KD(this.FH.Hw(i, 4));
        int ro2 = this.FH.ro(this.FH.Hw(i, 4));
        int Hw = this.FH.Hw(i, 0);
        int VH = VH(Hw);
        if (VH != -1) {
            nw = this.FH.nw(VH);
            KD = this.FH.KD(VH);
            SI = this.FH.SI(VH);
            ro = this.FH.ro(VH);
        } else {
            nw = this.FH.nw(Hw);
            KD = this.FH.KD(Hw);
            SI = this.FH.nw(Hw);
            ro = this.FH.KD(Hw);
        }
        this.Hw.j6(bzVar, nw2, KD2, ro2, nw, KD, SI, ro, this.FH.cn(i) ? this.FH.SI(this.FH.sh(i)) : this.FH.nw(i), this.FH.cn(i) ? this.FH.ro(this.FH.sh(i)) : this.FH.KD(i), this.FH.SI(i), this.FH.ro(i));
        gn(this.FH.Hw(i, 1));
    }

    private void we(bp bpVar, int i) {
        int nw;
        int KD;
        int SI;
        int ro;
        int nw2 = this.FH.nw(this.FH.Hw(i, 4));
        int KD2 = this.FH.KD(this.FH.Hw(i, 4));
        int ro2 = this.FH.ro(this.FH.Hw(i, 4));
        int Hw = this.FH.Hw(i, 0);
        int VH = VH(Hw);
        if (VH != -1) {
            nw = this.FH.nw(VH);
            KD = this.FH.KD(VH);
            SI = this.FH.SI(VH);
            ro = this.FH.ro(VH);
        } else {
            nw = this.FH.nw(Hw);
            KD = this.FH.KD(Hw);
            SI = this.FH.nw(Hw);
            ro = this.FH.KD(Hw);
        }
        this.Hw.j6(bpVar, nw2, KD2, ro2, nw, KD, SI, ro, this.FH.cn(i) ? this.FH.SI(this.FH.sh(i)) : this.FH.nw(i), this.FH.cn(i) ? this.FH.ro(this.FH.sh(i)) : this.FH.KD(i), this.FH.SI(i), this.FH.ro(i));
    }

    private int VH(int i) {
        int lg = this.FH.lg(i);
        int i2 = 0;
        while (i2 < lg) {
            int Hw = this.FH.Hw(i, i2);
            switch (this.FH.rN(Hw)) {
                case 84:
                case 94:
                case 100:
                    return Hw;
                default:
                    i2++;
            }
        }
        return -1;
    }

    private void DW(bz bzVar, int i) {
        int nw;
        int KD;
        int SI;
        int ro;
        int nw2 = this.FH.nw(this.FH.Hw(i, 0));
        int KD2 = this.FH.KD(this.FH.Hw(i, 0));
        int ro2 = this.FH.ro(this.FH.Hw(i, 0));
        int Hw = this.FH.Hw(this.FH.aM(i), 0);
        int VH = VH(Hw);
        if (VH != -1) {
            nw = this.FH.nw(VH);
            KD = this.FH.KD(VH);
            SI = this.FH.SI(VH);
            ro = this.FH.ro(VH);
        } else {
            nw = this.FH.nw(Hw);
            KD = this.FH.KD(Hw);
            SI = this.FH.nw(Hw);
            ro = this.FH.KD(Hw);
        }
        this.Hw.j6(bzVar, nw2, KD2, ro2, nw, KD, SI, ro, this.FH.SI(this.FH.sh(this.FH.aM(i))), this.FH.ro(this.FH.sh(this.FH.aM(i))), this.FH.SI(this.FH.aM(i)), this.FH.ro(this.FH.aM(i)));
    }

    private void J0(bp bpVar, int i) {
        int nw;
        int KD;
        int SI;
        int ro;
        int nw2 = this.FH.nw(this.FH.Hw(i, 2));
        int KD2 = this.FH.KD(this.FH.Hw(i, 2));
        int ro2 = this.FH.ro(this.FH.Hw(i, 2));
        int Hw = this.FH.Hw(i, 0);
        int VH = VH(Hw);
        if (VH != -1) {
            nw = this.FH.nw(VH);
            KD = this.FH.KD(VH);
            SI = this.FH.SI(VH);
            ro = this.FH.ro(VH);
        } else {
            nw = this.FH.nw(Hw);
            KD = this.FH.KD(Hw);
            SI = this.FH.nw(Hw);
            ro = this.FH.KD(Hw);
        }
        this.Hw.j6(bpVar, nw2, KD2, ro2, nw, KD, SI, ro, this.FH.cn(i) ? this.FH.SI(this.FH.sh(i)) : this.FH.nw(i), this.FH.cn(i) ? this.FH.ro(this.FH.sh(i)) : this.FH.KD(i), this.FH.SI(i), this.FH.ro(i));
        u7(this.FH.Hw(i, 3));
    }

    private void J8(bp bpVar, int i) {
        this.Hw.j6(bpVar, this.FH.nw(this.FH.Hw(i, 2)), this.FH.KD(this.FH.Hw(i, 2)), this.FH.ro(this.FH.Hw(i, 2)), 0, 0, 0, 0, 0, 0, 0, 0);
    }

    private void FH(bz bzVar, int i) {
        int nw;
        int KD;
        int SI;
        int ro;
        int nw2 = this.FH.nw(this.FH.Hw(i, 2));
        int KD2 = this.FH.KD(this.FH.Hw(i, 2));
        int ro2 = this.FH.ro(this.FH.Hw(i, 2));
        int Hw = this.FH.Hw(i, 0);
        int VH = VH(Hw);
        if (VH != -1) {
            nw = this.FH.nw(VH);
            KD = this.FH.KD(VH);
            SI = this.FH.SI(VH);
            ro = this.FH.ro(VH);
        } else {
            nw = this.FH.nw(Hw);
            KD = this.FH.KD(Hw);
            SI = this.FH.nw(Hw);
            ro = this.FH.KD(Hw);
        }
        this.Hw.j6(bzVar, nw2, KD2, ro2, nw, KD, SI, ro, this.FH.cn(i) ? this.FH.SI(this.FH.sh(i)) : this.FH.nw(i), this.FH.cn(i) ? this.FH.ro(this.FH.sh(i)) : this.FH.KD(i), this.FH.SI(i), this.FH.ro(i));
        gn(this.FH.Hw(i, 1));
    }

    private void gn(int i) {
        int lg = this.FH.lg(i);
        for (int i2 = 1; i2 < lg; i2 += 2) {
            try {
                int Hw = this.FH.Hw(i, i2);
                this.Hw.j6(this.Hw.Hw(this.FH.we(), this.FH.tp(), this.FH.XL(Hw)), this.FH.nw(Hw), this.FH.KD(Hw), this.FH.ro(Hw));
            } catch (ej e) {
            }
        }
    }

    private void u7(int i) {
        int lg = this.FH.lg(i);
        for (int i2 = 1; i2 < lg; i2 += 2) {
            try {
                int Hw = this.FH.Hw(i, i2);
                this.Hw.j6(this.Hw.FH(this.FH.we(), this.FH.tp(), this.FH.XL(Hw)), this.FH.nw(Hw), this.FH.KD(Hw), this.FH.ro(Hw));
            } catch (ej e) {
            }
        }
    }

    protected void DW(bt btVar, hc hcVar, cj cjVar) {
        this.Hw = btVar;
        this.FH = cjVar;
        this.v5 = hcVar;
        this.j6.j6();
        if (!cjVar.u7()) {
            tp(cjVar.Ws());
        }
        this.FH = null;
        this.j6.j6();
    }

    private void tp(int i) {
        int i2 = 1;
        int i3 = 0;
        switch (this.FH.rN(i)) {
            case 120:
            case 121:
            case 220:
                XL(i);
            case 123:
                J0(i);
            case 124:
                Ws(i);
            case 126:
                J8(i);
            case 127:
                this.j6.j6(P8(this.FH.Hw(i, 0)));
                tp(this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.v5();
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 222:
                aM(i);
            case 163:
                this.j6.j6(64);
                tp(this.FH.Hw(i, 2));
                this.j6.v5();
            case 164:
                this.j6.j6(64);
                if (this.FH.lg(i) == 4) {
                    tp(this.FH.Hw(i, 2));
                } else {
                    tp(this.FH.Hw(i, 0));
                    tp(this.FH.Hw(i, 4));
                }
                this.j6.v5();
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                tp(this.FH.Hw(i, this.FH.lg(i) - 2));
                bp j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i), this.j6.J0(), this.j6.we(), this.j6.Zo(), true);
                this.j6.j6(j6);
                J8(j6, i);
                tp(this.FH.Hw(i, this.FH.lg(i) - 1));
                this.j6.DW();
            case 221:
            case 227:
            case 228:
                QX(i);
            case 223:
                this.Hw.j6(j3(this.FH.Hw(i, 0)), this.FH.we(), this.FH.tp());
                i3 = this.FH.lg(i);
                while (i2 < i3) {
                    tp(this.FH.Hw(i, i2));
                    i2++;
                }
            case 245:
                we(i);
            case 246:
                EQ(i);
            default:
                int lg = this.FH.lg(i);
                while (i3 < lg) {
                    tp(this.FH.Hw(i, i3));
                    i3++;
                }
        }
    }

    private void EQ(int i) {
        we(this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i), this.j6.J0(), 0, this.j6.we(), P8(this.FH.Hw(i, 0)) | 33554432, this.FH.gW(this.FH.Hw(i, 4)), 0), i);
    }

    private void we(int i) {
        we(this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i), this.j6.J0(), 0, P8(this.FH.Hw(i, 0)) | 33554432, this.FH.gW(this.FH.Hw(i, 4)), 0), i);
    }

    private void J0(int i) {
        int i2;
        int P8 = P8(this.FH.Hw(i, 0));
        if ((P8 & 1) == 0 && (P8 & 4) == 0) {
            P8 |= 32;
        }
        this.j6.j6(P8);
        int lg = this.FH.lg(this.FH.Hw(i, 4)) / 2;
        int Hw = this.FH.Hw(i, 3);
        if (this.FH.lg(Hw) == 2) {
            i2 = 0;
        } else {
            i2 = (this.FH.lg(Hw) - 1) / 2;
        }
        boolean z = false;
        if (this.FH.lg(Hw) > 2) {
            int Hw2 = this.FH.Hw(this.FH.Hw(Hw, this.FH.lg(Hw) - 2), 2);
            boolean z2 = this.FH.lg(Hw2) > 0 && this.FH.rN(this.FH.Hw(Hw2, this.FH.lg(Hw2) - 1)) == 108;
            z = z2;
        }
        int Hw3 = this.FH.Hw(i, 1);
        int lg2 = this.FH.lg(Hw3);
        bz j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i), this.j6.we(), P8, (lg2 - 1) / 2, i2, z, lg);
        if (this.FH.lg(Hw) > 2) {
            int lg3 = this.FH.lg(Hw);
            int i3 = 0;
            Hw2 = 1;
            while (Hw2 < lg3) {
                this.Hw.j6(j6, 0, this.FH.gW(this.FH.Hw(this.FH.Hw(Hw, Hw2), 3)), i3);
                Hw2 += 2;
                i3++;
            }
        }
        P8 = 0;
        for (i2 = 1; i2 < lg2; i2 += 2) {
            int Hw4 = this.FH.Hw(Hw3, i2);
            if (this.FH.lg(Hw4) != 3) {
                Hw2 = (this.FH.lg(Hw4) - 1) / 2;
            }
            this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(Hw4), j6, P8, this.FH.gW(this.FH.Hw(Hw4, 0)));
            P8++;
        }
        tp(this.FH.Hw(i, this.FH.lg(i) - 1));
        this.j6.v5();
        FH(j6, i);
    }

    private void J8(int i) {
        int P8 = P8(this.FH.Hw(i, 0)) & -129;
        if (this.j6.we().g3()) {
            P8 |= 577;
        }
        if ((P8 & 1) == 0 && (P8 & 4) == 0) {
            P8 |= 32;
        }
        this.j6.j6(P8);
        int lg = this.FH.lg(i);
        int i2 = 3;
        while (i2 < lg) {
            boolean z;
            int i3;
            int Hw = this.FH.Hw(i, i2);
            if (this.FH.lg(Hw) > 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i3 = P8 & -257;
            } else {
                i3 = P8 & -513;
            }
            DW(this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(Hw), this.j6.we(), i3, this.FH.gW(this.FH.Hw(Hw, 0)), z, false, false, false), Hw);
            tp(Hw);
            i2 += 2;
            P8 = i3;
        }
        this.j6.v5();
    }

    private void Ws(int i) {
        int i2;
        int i3;
        int P8 = P8(this.FH.Hw(i, 0)) & -769;
        if (!cd.aM(P8)) {
            P8 |= 98304;
        }
        if ((P8 & 1) == 0 && (P8 & 4) == 0) {
            P8 |= 32;
        }
        this.j6.j6(P8);
        if (this.j6.we().g3()) {
            i2 = P8 | ProxyTextView.INPUTTYPE_textCapSentences;
        } else {
            i2 = P8;
        }
        int ei = ei(this.FH.Hw(i, 0));
        int lg = this.FH.lg(this.FH.Hw(i, 7)) / 2;
        int Hw = this.FH.Hw(i, 5);
        if (this.FH.lg(Hw) == 2) {
            i3 = 0;
        } else {
            i3 = (this.FH.lg(Hw) - 1) / 2;
        }
        boolean z = false;
        if (this.FH.lg(Hw) > 2) {
            P8 = this.FH.Hw(this.FH.Hw(Hw, this.FH.lg(Hw) - 2), 2);
            boolean z2 = this.FH.lg(P8) > 0 && this.FH.rN(this.FH.Hw(P8, this.FH.lg(P8) - 1)) == 108;
            z = z2;
        }
        int Hw2 = this.FH.Hw(i, 1);
        int lg2 = this.FH.lg(Hw2);
        bz j6 = this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(i), this.j6.we(), i2, this.FH.gW(this.FH.Hw(i, 4)), (lg2 - 1) / 2, i3, z, false, lg);
        this.Hw.j6(j6, ei);
        if (this.FH.lg(Hw) > 2) {
            int lg3 = this.FH.lg(Hw);
            int i4 = 0;
            P8 = 1;
            while (P8 < lg3) {
                this.Hw.j6(j6, 0, this.FH.gW(this.FH.Hw(this.FH.Hw(Hw, P8), 3)), i4);
                P8 += 2;
                i4++;
            }
        }
        i2 = 0;
        for (int i5 = 1; i5 < lg2; i5 += 2) {
            int Hw3 = this.FH.Hw(Hw2, i5);
            if (this.FH.lg(Hw3) != 3) {
                P8 = (this.FH.lg(Hw3) - 1) / 2;
            }
            this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(Hw3), j6, i2, this.FH.gW(this.FH.Hw(Hw3, 0)));
            i2++;
        }
        tp(this.FH.Hw(i, this.FH.lg(i) - 1));
        this.j6.v5();
        j6(j6, i);
    }

    private void QX(int i) {
        int i2;
        int i3;
        boolean z;
        int Hw = this.FH.Hw(i, 2);
        int P8 = P8(this.FH.Hw(i, 0)) & -769;
        if (this.FH.rN(i) == 228) {
            P8 |= 134217792;
        } else if (this.FH.rN(i) == 221) {
            P8 |= 268435520;
        }
        if (this.j6.we().g3()) {
            P8 |= 65;
        }
        if (this.j6.we().Mz()) {
            i2 = P8 | 64;
        } else {
            i2 = P8;
        }
        if ((i2 & 1) == 0 && (i2 & 4) == 0) {
            i2 |= 32;
        }
        int Hw2 = this.FH.Hw(i, 3);
        int lg = this.FH.lg(Hw2);
        if (lg == 0) {
            i3 = 0;
        } else if (lg == 3) {
            i3 = 1;
        } else {
            i3 = (lg - 1) / 2;
        }
        bt btVar = this.Hw;
        bv we = this.FH.we();
        bj tp = this.FH.tp();
        int XL = this.FH.XL(i);
        ce J0 = this.j6.J0();
        bp we2 = this.j6.we();
        Hw = this.FH.gW(Hw);
        if (this.FH.lg(this.FH.Hw(i, 4)) + this.FH.lg(this.FH.Hw(i, 5)) > 0) {
            z = true;
        } else {
            z = false;
        }
        bp j6 = btVar.j6(we, tp, XL, J0, i3, we2, i2, Hw, z);
        i3 = 0;
        i2 = 1;
        while (i2 < lg) {
            XL = this.FH.Hw(Hw2, i2);
            int gW = this.FH.gW(this.FH.Hw(XL, 0));
            if (this.FH.lg(XL) != 3) {
                P8 = (this.FH.lg(XL) - 1) / 2;
            }
            Hw = i3 + 1;
            this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(XL), j6, i3, gW);
            i2 += 2;
            i3 = Hw;
        }
        J0(j6, i);
        this.j6.j6(j6);
        tp(this.FH.Hw(i, 6));
        this.j6.DW();
    }

    private void XL(int i) {
        int i2;
        boolean z;
        int Hw = this.FH.Hw(i, 2);
        int P8 = P8(this.FH.Hw(i, 0)) & -769;
        if (this.FH.rN(i) == 121) {
            P8 |= 134217728;
        } else if (this.FH.rN(i) == 220) {
            P8 |= 268435456;
        }
        if ((P8 & 1) == 0 && (P8 & 4) == 0) {
            P8 |= 32;
        }
        int Hw2 = this.FH.Hw(i, 3);
        int lg = this.FH.lg(Hw2);
        if (lg == 0) {
            i2 = 0;
        } else if (lg == 3) {
            i2 = 1;
        } else {
            i2 = (lg - 1) / 2;
        }
        bt btVar = this.Hw;
        bv we = this.FH.we();
        bj tp = this.FH.tp();
        int XL = this.FH.XL(i);
        ce J0 = this.j6.J0();
        Hw = this.FH.gW(Hw);
        if (this.FH.lg(this.FH.Hw(i, 4)) + this.FH.lg(this.FH.Hw(i, 5)) > 0) {
            z = true;
        } else {
            z = false;
        }
        bp j6 = btVar.j6(we, tp, XL, J0, i2, P8, Hw, z, false, false);
        i2 = 0;
        Hw = 1;
        while (Hw < lg) {
            XL = this.FH.Hw(Hw2, Hw);
            P8 = this.FH.gW(this.FH.Hw(XL, 0));
            if (this.FH.lg(XL) != 3) {
                int lg2 = (this.FH.lg(XL) - 1) / 2;
            }
            int i3 = i2 + 1;
            this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(XL), j6, i2, P8);
            Hw += 2;
            i2 = i3;
        }
        J0(j6, i);
        this.j6.j6(j6);
        tp(this.FH.Hw(i, 6));
        this.j6.DW();
    }

    private void aM(int i) {
        int i2;
        boolean z;
        int Hw = this.FH.Hw(i, 2);
        int P8 = P8(this.FH.Hw(i, 0)) & -769;
        if (this.FH.rN(i) == ProxyTextView.INPUTTYPE_textPassword) {
            P8 |= 134217728;
        } else if (this.FH.rN(i) == 222) {
            P8 |= 268435520;
        }
        int Hw2 = this.FH.Hw(i, 3);
        int lg = this.FH.lg(Hw2);
        if (lg == 0) {
            i2 = 0;
        } else if (lg == 3) {
            i2 = 1;
        } else {
            i2 = (lg - 1) / 2;
        }
        bt btVar = this.Hw;
        bv we = this.FH.we();
        bj tp = this.FH.tp();
        int XL = this.FH.XL(i);
        ce J0 = this.j6.J0();
        bp we2 = this.j6.we();
        Hw = this.FH.gW(Hw);
        boolean Zo = this.j6.Zo();
        if (this.FH.lg(this.FH.Hw(i, 4)) + this.FH.lg(this.FH.Hw(i, 5)) > 0) {
            z = true;
        } else {
            z = false;
        }
        bp j6 = btVar.j6(we, tp, XL, J0, i2, we2, P8, Hw, Zo, z);
        i2 = 0;
        P8 = 1;
        while (P8 < lg) {
            XL = this.FH.Hw(Hw2, P8);
            int gW = this.FH.gW(this.FH.Hw(XL, 0));
            if (this.FH.lg(XL) != 3) {
                int lg2 = (this.FH.lg(XL) - 1) / 2;
            }
            Hw = i2 + 1;
            this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(XL), j6, i2, gW);
            P8 += 2;
            i2 = Hw;
        }
        J0(j6, i);
        this.j6.j6(j6);
        tp(this.FH.Hw(i, 6));
        this.j6.DW();
    }

    private ce j3(int i) {
        ce Mr = this.v5.Mr();
        int lg = this.FH.lg(i);
        for (int i2 = 2; i2 < lg - 1; i2 += 2) {
            Mr = Mr.j6(this.FH.gW(this.FH.Hw(i, i2)));
        }
        this.j6.j6(Mr);
        return Mr;
    }

    private void Mr(int i) {
        int lg = this.FH.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            int Hw = this.FH.Hw(i, i2);
            if (this.FH.rN(Hw) == 120 || this.FH.rN(Hw) == 220 || this.FH.rN(Hw) == 121) {
                try {
                    this.j6.Hw(this.FH.gW(this.FH.Hw(Hw, 2)), this.Hw.j6(this.FH.we(), this.FH.tp(), this.FH.XL(Hw)));
                } catch (ej e) {
                }
            }
        }
    }

    private void U2(int i) {
        int lg = this.FH.lg(i);
        for (int i2 = 1; i2 < lg; i2 += 2) {
            int Hw = this.FH.Hw(i, i2);
            int gW = this.FH.gW(this.FH.Hw(Hw, 0));
            try {
                this.j6.j6(gW, this.Hw.FH(this.FH.we(), this.FH.tp(), this.FH.XL(Hw)));
            } catch (ej e) {
            }
        }
    }

    private void a8(int i) {
        int lg = this.FH.lg(i);
        for (int i2 = 1; i2 < lg; i2 += 2) {
            int Hw = this.FH.Hw(i, i2);
            int gW = this.FH.gW(this.FH.Hw(Hw, 0));
            try {
                this.j6.j6(gW, this.Hw.Hw(this.FH.we(), this.FH.tp(), this.FH.XL(Hw)));
            } catch (ej e) {
            }
        }
    }

    private void lg(int i) {
        bs Mr = this.v5.Mr();
        int lg = this.FH.lg(i);
        int i2 = 2;
        bs bsVar = Mr;
        while (i2 < lg - 2) {
            int gW = this.FH.gW(this.FH.Hw(i, i2));
            try {
                if (bsVar.cT()) {
                    bsVar = ((bp) bsVar).DW(gW, true, 0, this.j6.J0(), this.FH.we(), this.FH.tp());
                } else {
                    int i3 = gW;
                    bsVar = ((ce) bsVar).j6(this.FH.we(), this.FH.tp(), i3, true, 0, (ce) bsVar);
                }
                i2 += 2;
            } catch (ej e) {
                return;
            } catch (eg e2) {
                return;
            }
        }
        if (bsVar.cT()) {
            this.j6.DW((bp) bsVar);
        }
    }

    private void rN(int i) {
        int lg = this.FH.lg(i) - 2;
        int i2 = 2;
        bs Mr = this.v5.Mr();
        while (i2 < lg) {
            int gW = this.FH.gW(this.FH.Hw(i, i2));
            try {
                if (Mr.cT()) {
                    Mr = ((bp) Mr).DW(gW, true, 0, this.j6.J0(), this.FH.we(), this.FH.tp());
                } else {
                    int i3 = gW;
                    Mr = ((ce) Mr).j6(this.FH.we(), this.FH.tp(), i3, true, 0, (ce) Mr);
                }
                i2 += 2;
            } catch (ej e) {
                return;
            } catch (eg e2) {
                return;
            }
        }
        if (Mr.cT()) {
            gW = this.FH.gW(this.FH.Hw(i, this.FH.lg(i) - 2));
            try {
                Mr = ((bp) Mr).DW(gW, true, 0, this.j6.J0(), this.FH.we(), this.FH.tp());
                if (Mr.Ws()) {
                    this.j6.j6(gW, Mr);
                }
            } catch (eg e3) {
            } catch (ej e4) {
            }
        }
    }

    private void er(int i) {
        bs Mr = this.v5.Mr();
        int lg = this.FH.lg(i);
        int i2 = 1;
        bs bsVar = Mr;
        while (i2 < lg - 2) {
            int gW = this.FH.gW(this.FH.Hw(i, i2));
            try {
                if (bsVar.cT()) {
                    bsVar = ((bp) bsVar).DW(gW, true, 0, this.j6.J0(), this.FH.we(), this.FH.tp());
                } else {
                    int i3 = gW;
                    bsVar = ((ce) bsVar).j6(this.FH.we(), this.FH.tp(), i3, true, 0, (ce) bsVar);
                }
                i2 += 2;
            } catch (ej e) {
                return;
            } catch (eg e2) {
                return;
            }
        }
        if (bsVar.cT()) {
            this.j6.FH((bp) bsVar);
        } else {
            this.j6.DW((ce) bsVar);
        }
    }

    private void yS(int i) {
        bs Mr = this.v5.Mr();
        int lg = this.FH.lg(i);
        int i2 = 1;
        bs bsVar = Mr;
        while (i2 < lg) {
            int gW = this.FH.gW(this.FH.Hw(i, i2));
            try {
                if (bsVar.cT()) {
                    bsVar = ((bp) bsVar).DW(gW, true, 0, this.j6.J0(), this.FH.we(), this.FH.tp());
                } else {
                    int i3 = gW;
                    bsVar = ((ce) bsVar).j6(this.FH.we(), this.FH.tp(), i3, true, 0, (ce) bsVar);
                }
                i2 += 2;
            } catch (ej e) {
                return;
            } catch (eg e2) {
                return;
            }
        }
        if (bsVar.cT()) {
            this.j6.FH(this.FH.gW(this.FH.Hw(i, this.FH.lg(i) - 2)), (bp) bsVar);
        }
    }

    private bp gW(int i) {
        int gW = this.FH.gW(this.FH.Hw(i, 0));
        int max = Math.max(0, (this.FH.lg(this.FH.Hw(i, 1)) - 2) / 3);
        try {
            bs DW = this.j6.DW(gW, max);
            int lg = this.FH.lg(i);
            int i2 = 3;
            bs bsVar = DW;
            while (i2 < lg) {
                int gW2 = this.FH.gW(this.FH.Hw(i, i2));
                this.FH.Hw(i, i2 + 1);
                try {
                    if (bsVar.cT()) {
                        bsVar = ((bp) bsVar).DW(gW2, true, max, this.j6.EQ(), this.FH.we(), this.FH.tp());
                    } else {
                        bsVar = ((ce) bsVar).j6(this.FH.we(), this.FH.tp(), gW2, true, max, this.j6.J0());
                    }
                    i2 += 3;
                } catch (ej e) {
                    this.Hw.FH(this.FH.we(), this.FH.tp());
                    throw new ej();
                } catch (eg e2) {
                    this.Hw.FH(this.FH.we(), this.FH.tp());
                    throw new ej();
                }
            }
            if (bsVar.cT()) {
                return (bp) bsVar;
            }
            this.Hw.FH(this.FH.we(), this.FH.tp());
            throw new ej();
        } catch (eg e3) {
            this.Hw.FH(this.FH.we(), this.FH.tp());
            throw new ej();
        } catch (ej e4) {
            this.Hw.FH(this.FH.we(), this.FH.tp());
            throw new ej();
        }
    }

    private co BT(int i) {
        switch (this.FH.rN(this.FH.Hw(i, 0))) {
            case 57:
                return this.v5.J0();
            case 60:
                return this.v5.EQ();
            case 62:
                return this.v5.QX();
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                return this.v5.aM();
            case 69:
                return this.v5.u7();
            case 76:
                return this.v5.J8();
            case 77:
                return this.v5.Ws();
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                return this.v5.j3();
            case 89:
                return this.v5.XL();
            case 114:
                return this.v5.we();
            default:
                return vy(i);
        }
    }

    private co vy(int i) {
        try {
            bs j6 = j6(this.j6.j6(this.FH.gW(this.FH.Hw(i, 0)), Math.max(0, (this.FH.lg(this.FH.Hw(i, 1)) - 2) / 3)), this.FH.Hw(i, 1));
            int lg = this.FH.lg(i);
            int i2 = 3;
            bs bsVar = j6;
            while (i2 < lg) {
                int gW = this.FH.gW(this.FH.Hw(i, i2));
                int max = Math.max(0, (this.FH.lg(this.FH.Hw(i, i2 + 1)) - 2) / 3);
                try {
                    if (bsVar.qp()) {
                        bsVar = ((ce) bsVar).j6(this.FH.we(), this.FH.tp(), gW, true, max, this.j6.J0());
                    } else {
                        bs j62 = ((co) bsVar).j6(gW, true, max, this.j6.EQ(), this.FH.we(), this.FH.tp());
                        if (max == 0) {
                            if (((co) bsVar).cT() && ((bp) bsVar).XX() > 0) {
                                bsVar = j62.a_();
                            }
                        }
                        bsVar = j62;
                    }
                    j6 = j6(bsVar, this.FH.Hw(i, i2 + 1));
                    i2 += 3;
                    bsVar = j6;
                } catch (ej e) {
                    this.Hw.FH(this.FH.we(), this.FH.tp());
                    throw new ej();
                } catch (eg e2) {
                    this.Hw.FH(this.FH.we(), this.FH.tp());
                    throw new ej();
                }
            }
            if (!bsVar.qp()) {
                return (co) bsVar;
            }
            this.Hw.FH(this.FH.we(), this.FH.tp());
            throw new ej();
        } catch (eg e3) {
            this.Hw.FH(this.FH.we(), this.FH.tp());
            throw new ej();
        } catch (ej e4) {
            this.Hw.FH(this.FH.we(), this.FH.tp());
            throw new ej();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private bs j6(bs r13, int r14) {
        /*
        r12 = this;
        r4 = 2;
        r2 = 0;
        r3 = 1;
        r0 = r13.n5();
        if (r0 == 0) goto L_0x010e;
    L_0x0009:
        r0 = r13;
        r0 = (cf) r0;
        r1 = r0.gn();
        r0 = r1.hz();
        if (r0 != 0) goto L_0x010e;
    L_0x0016:
        r0 = r1.J0();
        if (r0 != 0) goto L_0x010e;
    L_0x001c:
        r0 = r12.FH;
        r5 = r0.lg(r14);
        if (r5 != 0) goto L_0x003a;
    L_0x0024:
        r0 = r1.n5();
        if (r0 != 0) goto L_0x002b;
    L_0x002a:
        return r1;
    L_0x002b:
        r0 = r1;
        r0 = (cf) r0;
        r0 = r0.gn();
        r2 = r0.XX();
        if (r2 == 0) goto L_0x002a;
    L_0x0038:
        r1 = r0;
        goto L_0x002a;
    L_0x003a:
        if (r5 == r4) goto L_0x002a;
    L_0x003c:
        r0 = r5 + -1;
        r4 = r0 / 4;
        r0 = r1.cT();
        if (r0 != 0) goto L_0x004c;
    L_0x0046:
        r0 = r1.n5();
        if (r0 == 0) goto L_0x002a;
    L_0x004c:
        r0 = r1.n5();
        if (r0 == 0) goto L_0x00ba;
    L_0x0052:
        r0 = r1;
        r0 = (cf) r0;
        r0 = r0.gn();
    L_0x0059:
        r6 = r0.XX();
        if (r4 != r6) goto L_0x002a;
    L_0x005f:
        r6 = new co[r4];
        r7 = new int[r4];
        r4 = r2;
        r2 = r3;
    L_0x0065:
        if (r2 >= r5) goto L_0x00f8;
    L_0x0067:
        r8 = r12.FH;	 Catch:{ ej -> 0x00e2 }
        r9 = r2 + 1;
        r8 = r8.Hw(r14, r9);	 Catch:{ ej -> 0x00e2 }
        r8 = r12.BT(r8);	 Catch:{ ej -> 0x00e2 }
        r9 = r12.FH;	 Catch:{ ej -> 0x00e2 }
        r10 = r2 + 2;
        r9 = r9.Hw(r14, r10);	 Catch:{ ej -> 0x00e2 }
        r8 = r12.j6(r8, r9);	 Catch:{ ej -> 0x00e2 }
        r6[r4] = r8;	 Catch:{ ej -> 0x00e2 }
        r8 = 0;
        r7[r4] = r8;	 Catch:{ ej -> 0x00e2 }
        r8 = r12.FH;	 Catch:{ ej -> 0x00e2 }
        r8 = r8.Hw(r14, r2);	 Catch:{ ej -> 0x00e2 }
        r9 = r12.FH;	 Catch:{ ej -> 0x00e2 }
        r9 = r9.lg(r8);	 Catch:{ ej -> 0x00e2 }
        if (r9 <= 0) goto L_0x00ab;
    L_0x0092:
        r9 = r12.FH;	 Catch:{ ej -> 0x00e2 }
        r9 = r9.lg(r8);	 Catch:{ ej -> 0x00e2 }
        if (r9 != r3) goto L_0x00be;
    L_0x009a:
        r8 = 1;
        r7[r4] = r8;	 Catch:{ ej -> 0x00e2 }
        r8 = r0.j6(r4);	 Catch:{ ej -> 0x00e2 }
        r8 = r8.a_();	 Catch:{ ej -> 0x00e2 }
        r8 = r8.a_();	 Catch:{ ej -> 0x00e2 }
        r6[r4] = r8;	 Catch:{ ej -> 0x00e2 }
    L_0x00ab:
        r8 = r12.v5;	 Catch:{ ej -> 0x00e2 }
        r9 = r6[r4];	 Catch:{ ej -> 0x00e2 }
        r8 = r8.DW(r9);	 Catch:{ ej -> 0x00e2 }
        if (r8 == 0) goto L_0x002a;
    L_0x00b5:
        r4 = r4 + 1;
        r2 = r2 + 4;
        goto L_0x0065;
    L_0x00ba:
        r0 = r1;
        r0 = (bp) r0;
        goto L_0x0059;
    L_0x00be:
        r9 = r12.FH;	 Catch:{ ej -> 0x00e2 }
        r10 = r12.FH;	 Catch:{ ej -> 0x00e2 }
        r11 = 1;
        r8 = r10.Hw(r8, r11);	 Catch:{ ej -> 0x00e2 }
        r8 = r9.rN(r8);	 Catch:{ ej -> 0x00e2 }
        switch(r8) {
            case 78: goto L_0x00cf;
            case 91: goto L_0x00e5;
            default: goto L_0x00ce;
        };	 Catch:{ ej -> 0x00e2 }
    L_0x00ce:
        goto L_0x00ab;
    L_0x00cf:
        r8 = 3;
        r7[r4] = r8;	 Catch:{ ej -> 0x00e2 }
        r8 = r0.j6(r4);	 Catch:{ ej -> 0x00e2 }
        r8 = r8.a_();	 Catch:{ ej -> 0x00e2 }
        r9 = r6[r4];	 Catch:{ ej -> 0x00e2 }
        if (r8 != r9) goto L_0x00ab;
    L_0x00de:
        r8 = 0;
        r7[r4] = r8;	 Catch:{ ej -> 0x00e2 }
        goto L_0x00ab;
    L_0x00e2:
        r0 = move-exception;
        goto L_0x002a;
    L_0x00e5:
        r8 = 2;
        r7[r4] = r8;	 Catch:{ ej -> 0x00e2 }
        r8 = r0.j6(r4);	 Catch:{ ej -> 0x00e2 }
        r8 = r8.a_();	 Catch:{ ej -> 0x00e2 }
        r9 = r6[r4];	 Catch:{ ej -> 0x00e2 }
        if (r8 != r9) goto L_0x00ab;
    L_0x00f4:
        r8 = 1;
        r7[r4] = r8;	 Catch:{ ej -> 0x00e2 }
        goto L_0x00ab;
    L_0x00f8:
        r0 = r1.cT();
        if (r0 == 0) goto L_0x0106;
    L_0x00fe:
        r1 = (bp) r1;
        r1 = r1.j6(r6, r7);
        goto L_0x002a;
    L_0x0106:
        r1 = (cf) r1;
        r1 = r1.j6(r6, r7);
        goto L_0x002a;
    L_0x010e:
        r1 = r13;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: gz$a.j6(bs, int):bs");
    }

    private co j6(co coVar, int i) {
        int lg = this.FH.lg(i);
        if (lg > 0 && this.FH.rN(this.FH.Hw(i, lg - 1)) == 108) {
            lg--;
            coVar = this.Hw.j6(coVar, 1);
        }
        for (lg -= 2; lg >= 0; lg -= 3) {
            coVar = this.Hw.j6(coVar, this.FH.lg(this.FH.Hw(i, lg)) + 1);
        }
        return coVar;
    }

    private int P8(int i) {
        int lg = this.FH.lg(i);
        int i2 = 0;
        for (int i3 = 0; i3 < lg; i3++) {
            int i4;
            switch (this.FH.rN(this.FH.Hw(i, i3))) {
                case 75:
                    i4 = 896;
                    break;
                case 83:
                    i4 = 524288;
                    break;
                case 84:
                    i4 = 1;
                    break;
                case 86:
                    i4 = 64;
                    break;
                case 94:
                    i4 = 4;
                    break;
                case 95:
                    i4 = 16384;
                    break;
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                    i4 = 8192;
                    break;
                case 98:
                    i4 = 1024;
                    break;
                case 100:
                    i4 = 8;
                    break;
                case 101:
                    i4 = 4096;
                    break;
                case 104:
                    i4 = 2048;
                    break;
                case 115:
                    i4 = 536870912;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            i2 |= i4;
        }
        return i2;
    }

    private int ei(int i) {
        int i2 = 0;
        int lg = this.FH.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            switch (this.FH.rN(this.FH.Hw(i, i3))) {
                case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                    i2 = 5;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }
}
