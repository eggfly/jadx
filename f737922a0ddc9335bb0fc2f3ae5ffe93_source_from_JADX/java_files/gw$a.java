import com.aide.uidesigner.ProxyTextView;

class gw$a {
    private final bt j6;

    public gw$a(bt btVar) {
        this.j6 = btVar;
    }

    public ec j6(cj cjVar, do doVar) {
        ec ecVar = new ec();
        for (int i = 0; i < doVar.Hw(); i++) {
            j6(cjVar, doVar.FH(i), cjVar.aM(doVar.FH(0)), ecVar);
        }
        return ecVar;
    }

    public do DW(cj cjVar, do doVar) {
        ec ecVar = new ec();
        do doVar2 = new do();
        for (int i = 0; i < doVar.Hw(); i++) {
            j6(cjVar, doVar.FH(i), cjVar.aM(doVar.FH(0)), ecVar, doVar2);
        }
        return doVar2;
    }

    public ec FH(cj cjVar, do doVar) {
        ec ecVar = new ec();
        ec ecVar2 = new ec();
        int FH = doVar.FH(0);
        int i = FH;
        while (i != cjVar.Ws()) {
            ecVar2.j6(i);
            switch (cjVar.rN(i)) {
                case 123:
                case 124:
                    FH = i;
                    break;
                default:
                    break;
            }
            i = cjVar.aM(i);
        }
        j6(cjVar, FH, doVar, ecVar2, false, true, ecVar);
        ec ecVar3 = new ec();
        ec Zo = Zo(cjVar, doVar);
        ec Hw = Hw(cjVar, doVar);
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            int FH2 = ecVar.j6.FH();
            if (Hw.FH(FH2) || Zo.FH(FH2)) {
                ecVar3.j6(FH2);
            }
        }
        return ecVar3;
    }

    private ec Zo(cj cjVar, do doVar) {
        ec ecVar = new ec();
        for (int i = 0; i < doVar.Hw(); i++) {
            j6(cjVar, doVar.FH(i), ecVar);
        }
        return ecVar;
    }

    public ec Hw(cj cjVar, do doVar) {
        ec ecVar = new ec();
        for (int i = 0; i < doVar.Hw(); i++) {
            DW(cjVar, doVar.FH(i), ecVar);
        }
        return ecVar;
    }

    private void j6(cj cjVar, int i, int i2, ec ecVar) {
        int i3 = 0;
        int i4;
        switch (cjVar.rN(i)) {
            case 85:
                ecVar.j6(i);
            case 122:
            case 138:
            case 139:
                if (cjVar.lg(i) == 2) {
                    i3 = i;
                    while (i3 != i2) {
                        switch (cjVar.rN(i3)) {
                            case 137:
                            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                            case 147:
                            case 149:
                            case 211:
                                return;
                            default:
                                i3 = cjVar.aM(i3);
                        }
                    }
                } else {
                    int gW = cjVar.gW(cjVar.Hw(i, 1));
                    i4 = i;
                    while (i4 != i2) {
                        switch (cjVar.rN(i4)) {
                            case 148:
                                if (cjVar.gW(cjVar.Hw(i4, 0)) != gW) {
                                    break;
                                }
                                return;
                            default:
                                break;
                        }
                        i4 = cjVar.aM(i4);
                    }
                }
                ecVar.j6(i);
            default:
                i4 = cjVar.lg(i);
                while (i3 < i4) {
                    j6(cjVar, cjVar.Hw(i, i3), i2, ecVar);
                    i3++;
                }
        }
    }

    private void j6(cj cjVar, int i, int i2, ec ecVar, do doVar) {
        int lg = cjVar.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            j6(cjVar, cjVar.Hw(i, i3), i2, ecVar, doVar);
        }
        if (cjVar.rN(i) == 1 && cjVar.J8(i) == 2) {
            int Ws = cjVar.Ws(i);
            if (!ecVar.FH(Ws)) {
                ecVar.j6(Ws);
                doVar.DW(Ws);
            }
        }
    }

    private void j6(cj cjVar, int i, do doVar, ec ecVar, boolean z, boolean z2, ec ecVar2) {
        if (cjVar.rN(i) == 1) {
            if (cjVar.J8(i) == 2) {
                ecVar2.j6(cjVar.Ws(i));
            }
        } else if (cjVar.rN(i) != 133) {
            boolean z3;
            switch (cjVar.rN(i)) {
                case 137:
                case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                case 149:
                case 211:
                    z3 = true;
                    break;
                default:
                    z3 = z;
                    break;
            }
            r10 = cjVar.lg(i);
            for (r9 = 0; r9 < r10; r9++) {
                j6(cjVar, cjVar.Hw(i, r9), doVar, ecVar, z3, z2, ecVar2);
            }
        } else if (!z2) {
            r10 = cjVar.lg(i);
            for (r9 = 0; r9 < r10; r9++) {
                j6(cjVar, cjVar.Hw(i, r9), doVar, ecVar, z, false, ecVar2);
            }
        } else if (z) {
            int lg = cjVar.lg(i);
            for (int i2 = 0; i2 < lg; i2 = r10 + 1) {
                if (cjVar.Hw(i, i2) == doVar.FH(0)) {
                    r9 = 0;
                    r10 = i2;
                    while (r9 < doVar.Hw()) {
                        j6(cjVar, cjVar.Hw(i, r10), doVar, ecVar, z, false, ecVar2);
                        r9++;
                        r10++;
                    }
                    ecVar2.DW(Hw(cjVar, doVar));
                } else {
                    r10 = i2;
                }
                j6(cjVar, cjVar.Hw(i, r10), doVar, ecVar, z, false, ecVar2);
            }
        } else {
            r10 = cjVar.lg(i);
            r9 = 0;
            while (r9 < r10) {
                if (ecVar.FH(cjVar.Hw(i, r9))) {
                    break;
                }
                r9++;
            }
            while (r9 < r10) {
                int Hw;
                if (doVar.FH(0) == cjVar.Hw(i, r9)) {
                    Hw = (doVar.Hw() - 1) + r9;
                } else {
                    j6(cjVar, cjVar.Hw(i, r9), doVar, ecVar, z, ecVar.FH(cjVar.Hw(i, r9)), ecVar2);
                    Hw = r9;
                }
                r9 = Hw + 1;
            }
        }
    }

    private void j6(cj cjVar, int i, ec ecVar) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2), ecVar);
        }
        if (cjVar.rN(i) == 1 && cjVar.J8(i) == 2 && cjVar.lg(cjVar.aM(i)) == 2 && cjVar.vJ(cjVar.aM(i))) {
            ecVar.j6(cjVar.Ws(i));
        }
    }

    private void DW(cj cjVar, int i, ec ecVar) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            DW(cjVar, cjVar.Hw(i, i2), ecVar);
        }
        if (cjVar.rN(i) != 1) {
            return;
        }
        if (cjVar.J8(i) == 1 || cjVar.J8(i) == 32) {
            ecVar.j6(cjVar.Ws(i));
        }
    }

    public ea<bp> v5(cj cjVar, do doVar) {
        ea eaVar = new ea(this.j6);
        for (int i = 0; i < doVar.Hw(); i++) {
            j6(cjVar, doVar.FH(i), eaVar);
        }
        return eaVar;
    }

    private void j6(cj cjVar, int i, ea<bp> eaVar) {
        int i2 = 0;
        int rN;
        int i3;
        if (cjVar.rN(i) == 1) {
            bz bzVar;
            co DW;
            if (cjVar.J8(i) == 20) {
                bzVar = (bz) cjVar.QX(i);
                rN = bzVar.rN();
                for (i3 = 0; i3 < rN; i3++) {
                    try {
                        DW = bzVar.DW(i3);
                        if (DW.cT()) {
                            DW((ea) eaVar, (bp) DW);
                        }
                    } catch (ej e) {
                    }
                }
            }
            if (cjVar.J8(i) == 22 || cjVar.J8(i) == 25 || cjVar.J8(i) == 24 || cjVar.J8(i) == 23) {
                bzVar = (bz) cjVar.QX(i);
                i3 = bzVar.rN();
                while (i2 < i3) {
                    try {
                        DW = bzVar.DW(i2);
                        if (DW.cT()) {
                            DW((ea) eaVar, (bp) DW);
                        }
                    } catch (ej e2) {
                    }
                    i2++;
                }
            }
        } else if (cjVar.rN(i) == 142) {
            r0 = cjVar.lg(i);
            while (i2 < r0) {
                j6(cjVar, cjVar.Hw(i, i2), (ea) eaVar);
                i2++;
            }
            if (cjVar.J0(cjVar.Hw(i, 1))) {
                r0 = cjVar.we(cjVar.Hw(i, 1));
                if (r0.cT()) {
                    DW((ea) eaVar, (bp) r0);
                }
            }
        } else if (cjVar.rN(i) == 150) {
            ea eaVar2 = new ea(this.j6);
            j6(cjVar, cjVar.Hw(i, 1), eaVar2);
            int lg = cjVar.lg(i);
            for (rN = 2; rN < lg; rN++) {
                r0 = cjVar.Hw(i, rN);
                if (cjVar.rN(r0) == 204) {
                    int Hw = cjVar.Hw(r0, 3);
                    int lg2 = cjVar.lg(Hw);
                    for (i3 = 0; i3 < lg2; i3 += 2) {
                        r0 = cjVar.Hw(Hw, i3);
                        if (cjVar.J0(r0)) {
                            r0 = cjVar.we(r0);
                            if (r0.cT()) {
                                j6(eaVar2, (bp) r0);
                            }
                        }
                    }
                }
            }
            eaVar.j6(eaVar2);
            for (r0 = 2; r0 < lg; r0++) {
                j6(cjVar, cjVar.Hw(i, r0), (ea) eaVar);
            }
        } else if (cjVar.rN(i) != 122) {
            int lg3 = cjVar.lg(i);
            for (r0 = 0; r0 < lg3; r0++) {
                j6(cjVar, cjVar.Hw(i, r0), (ea) eaVar);
            }
        }
    }

    private void j6(ea<bp> eaVar, bp bpVar) {
        ea eaVar2 = null;
        eaVar.j6.j6();
        while (eaVar.j6.DW()) {
            if (((bp) eaVar.j6.FH()).FH((co) bpVar)) {
                ea eaVar3;
                if (eaVar2 == null) {
                    eaVar3 = new ea(this.j6);
                } else {
                    eaVar3 = eaVar2;
                }
                eaVar3.j6(eaVar.j6.FH());
                eaVar2 = eaVar3;
            }
        }
        if (eaVar2 != null) {
            eaVar.DW(eaVar2);
        }
    }

    private void DW(ea<bp> eaVar, bp bpVar) {
        Object obj;
        eaVar.j6.j6();
        while (eaVar.j6.DW()) {
            if (bpVar.FH((co) eaVar.j6.FH())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            j6((ea) eaVar, bpVar);
            eaVar.j6((bs) bpVar);
        }
    }
}
