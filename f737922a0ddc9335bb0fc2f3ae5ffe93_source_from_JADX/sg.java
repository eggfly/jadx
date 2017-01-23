public final class sg {
    public static sh j6(sh shVar, sh shVar2) {
        if (shVar == shVar2) {
            return shVar;
        }
        int Zo = shVar.Zo();
        if (shVar2.Zo() != Zo) {
            throw new sl("mismatched maxLocals values");
        }
        sh shVar3 = null;
        for (int i = 0; i < Zo; i++) {
            abm FH = shVar.FH(i);
            abm j6 = j6(FH, shVar2.FH(i));
            if (j6 != FH) {
                if (shVar3 == null) {
                    shVar3 = shVar.v5();
                }
                if (j6 == null) {
                    shVar3.DW(i);
                } else {
                    shVar3.j6(i, j6);
                }
            }
        }
        if (shVar3 == null) {
            return shVar;
        }
        shVar3.l_();
        return shVar3;
    }

    public static rz j6(rz rzVar, rz rzVar2) {
        if (rzVar == rzVar2) {
            return rzVar;
        }
        int DW = rzVar.DW();
        if (rzVar2.DW() != DW) {
            throw new sl("mismatched stack depths");
        }
        rz rzVar3 = null;
        for (int i = 0; i < DW; i++) {
            abm j6 = rzVar.j6(i);
            abm j62 = rzVar2.j6(i);
            abm j63 = j6(j6, j62);
            if (j63 != j6) {
                if (rzVar3 == null) {
                    rzVar3 = rzVar.j6();
                }
                if (j63 == null) {
                    try {
                        throw new sl("incompatible: " + j6 + ", " + j62);
                    } catch (sl e) {
                        e.j6("...while merging stack[" + add.FH(i) + "]");
                        throw e;
                    }
                }
                rzVar3.j6(i, j63);
            }
        }
        if (rzVar3 == null) {
            return rzVar;
        }
        rzVar3.l_();
        return rzVar3;
    }

    public static abm j6(abm abm, abm abm2) {
        if (abm == null || abm.equals(abm2)) {
            return abm;
        }
        if (abm2 == null) {
            return null;
        }
        abm = abm.j6();
        abm j6 = abm2.j6();
        if (abm == j6) {
            return abm;
        }
        if (!abm.Ws() || !j6.Ws()) {
            return (abm.J0() && j6.J0()) ? abl.Zo : null;
        } else {
            if (abm == abl.tp) {
                return j6;
            }
            if (j6 == abl.tp) {
                return abm;
            }
            if (!abm.QX() || !j6.QX()) {
                return abl.Ws;
            }
            abm j62 = j6(abm.U2(), j6.U2());
            if (j62 == null) {
                return abl.Ws;
            }
            return ((abl) j62).Mr();
        }
    }

    public static boolean DW(abm abm, abm abm2) {
        boolean z = false;
        abl j6 = abm.j6();
        abl j62 = abm2.j6();
        if (j6.equals(j62)) {
            return true;
        }
        abl abl;
        int i;
        abl abl2;
        int FH = j6.FH();
        int FH2 = j62.FH();
        if (FH == 10) {
            abl = abl.Ws;
            i = 9;
        } else {
            int i2 = FH;
            abl = j6;
            i = i2;
        }
        int i3;
        if (FH2 == 10) {
            abl2 = abl.Ws;
            i3 = 9;
        } else {
            i2 = FH2;
            abl2 = j62;
            i3 = i2;
        }
        if (i == 9 && r4 == 9) {
            if (abl == abl.tp) {
                return false;
            }
            if (abl2 == abl.tp || abl == abl.Ws) {
                return true;
            }
            if (abl.QX()) {
                if (!abl2.QX()) {
                    return false;
                }
                abl abl3 = abl2;
                abl abl4 = abl;
                do {
                    abl4 = abl4.U2();
                    abl3 = abl3.U2();
                    if (!abl4.QX()) {
                        break;
                    }
                } while (abl3.QX());
                return DW(abl4, abl3);
            } else if (!abl2.QX()) {
                return true;
            } else {
                if (abl == abl.QX || abl == abl.J8) {
                    z = true;
                }
                return z;
            }
        } else if (abl.J0() && abl2.J0()) {
            return true;
        } else {
            return false;
        }
    }
}
