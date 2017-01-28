public class id {
    private final ih DW;
    private boolean FH;
    private hx Hw;
    private fk Zo;
    private final cc j6;
    private ia v5;

    public id(cc ccVar, ih ihVar, boolean z) {
        this.j6 = ccVar;
        this.DW = ihVar;
        this.FH = z;
        this.Hw = new hx(ccVar);
        if (z) {
            this.v5 = new ia(ccVar);
        } else {
            this.Zo = new fk(ccVar);
        }
    }

    public fs j6(String str) {
        fs FH = j6().FH(str);
        if (FH != null) {
            return FH;
        }
        bv DW = this.Hw.DW(str);
        if (DW == null || DW.BT() != j6()) {
            return null;
        }
        cj j6 = this.j6.sh.j6(DW, DW());
        FH = new fs(this.j6, j6, true);
        this.j6.sh.j6(j6);
        return FH;
    }

    public fs DW(String str) {
        bv j6 = this.Hw.j6(str);
        if (j6 == null || j6.BT() != j6()) {
            return null;
        }
        cj j62 = this.j6.sh.j6(j6, DW());
        fs fsVar = new fs(this.j6, j62, true);
        this.j6.sh.j6(j62);
        return fsVar;
    }

    public void j6(cj cjVar, int i, int i2, int i3, boolean z) {
        String substring;
        if (i3 == -1) {
            String DW = cjVar.we().DW(i);
            if (DW.length() >= i2 - 1) {
                substring = DW.substring(0, i2 - 1);
                DW = DW.substring(i2 - 1, DW.length());
                if (substring.length() > 0) {
                    char charAt = substring.charAt(substring.length() - 1);
                    if (charAt != '<' && !j6(charAt)) {
                        return;
                    }
                    if (DW.length() <= 0 || !Character.isJavaIdentifierPart(charAt) || !Character.isJavaIdentifierPart(DW.charAt(0))) {
                        j6(cjVar, i, i2);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        substring = cjVar.we().DW(i);
        if (substring.length() >= i2 - 1) {
            int i4 = i3 - 1;
            while (i4 < substring.length()) {
                if (j6(substring.charAt(i4))) {
                    i4++;
                } else if (i4 + 1 < i2) {
                    this.j6.lg.j6(cjVar.we());
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void j6(cj cjVar, int i, int i2) {
        this.j6.lg.j6();
        int gn = cjVar.gn(i, i2);
        if (gn == -1) {
            gn = cjVar.j6(204, i, i2, i, i2);
            if (gn != -1) {
                FH(cjVar, cjVar.aM(gn));
            }
        } else if (gn != -1 && cjVar.rN(gn) == 25 && (cjVar.rN(cjVar.aM(cjVar.aM(gn))) == 200 || cjVar.rN(cjVar.aM(cjVar.aM(gn))) == 201)) {
            gn = cjVar.aM(cjVar.aM(gn));
            FH(cjVar, gn, DW(cjVar, gn));
        } else if (gn != -1 && cjVar.rN(gn) == 26) {
            gn = j6(cjVar, gn);
            if (gn != -1) {
                DW(cjVar, gn, DW(cjVar, gn));
            }
        }
        this.j6.lg.j6(cjVar.we(), this.DW, i, i2, j6(cjVar.we(), i, i2), false, false);
    }

    private int j6(cj cjVar, int i) {
        int aM = cjVar.aM(cjVar.aM(i));
        while (cjVar.rN(aM) != 200 && cjVar.rN(aM) != 201) {
            aM = cjVar.aM(aM);
            if (aM == cjVar.Ws()) {
                return -1;
            }
        }
        return aM;
    }

    private int DW(cj cjVar, int i) {
        return cjVar.Hw(cjVar.Hw(i, 1), 2);
    }

    private void FH(cj cjVar, int i) {
        if (this.FH) {
            if (this.v5 != null && this.v5.j6(cjVar.we())) {
                this.v5.j6(cjVar, i);
            }
        } else if (cjVar.gW(cjVar.Hw(cjVar.Hw(i, 0), 2)) == this.j6.ro.j6("class")) {
            this.Zo.j6();
        }
    }

    protected void DW(cj cjVar, int i, int i2) {
        if (this.v5 == null || !this.v5.j6(cjVar.we())) {
            fs j6 = j6(cjVar);
            if (j6 != null) {
                int gW = cjVar.gW(i2);
                ec ecVar = new ec();
                j6.DW(gW, ecVar);
                ecVar.j6.j6();
                while (ecVar.j6.DW()) {
                    this.j6.lg.FH(this.j6.ro.j6(ecVar.j6.FH()) + "=");
                }
                return;
            }
            return;
        }
        this.v5.DW(cjVar, i, i2);
    }

    protected void FH(cj cjVar, int i, int i2) {
        if (this.v5 == null || !this.v5.j6(cjVar.we())) {
            fs j6 = j6(cjVar);
            if (j6 != null) {
                int aM;
                if (cjVar.rN(i) == 200) {
                    aM = cjVar.aM(cjVar.aM(cjVar.aM(i)));
                } else {
                    aM = cjVar.aM(cjVar.aM(i));
                }
                ec ecVar = new ec();
                if (cjVar.rN(aM) == 210) {
                    j6.j6(cjVar.gW(cjVar.Hw(cjVar.Hw(cjVar.Hw(aM, 0), 1), 2)), ecVar);
                } else {
                    j6.j6(ecVar);
                }
                ecVar.j6.j6();
                while (ecVar.j6.DW()) {
                    this.j6.lg.FH(this.j6.ro.j6(ecVar.j6.FH()));
                }
                return;
            }
            return;
        }
        this.v5.j6(cjVar, i, i2);
    }

    private fs j6(cj cjVar) {
        ft j6 = j6();
        if (j6 == null) {
            return null;
        }
        String a8;
        String substring;
        int Hw = Hw(cjVar, cjVar.Ws());
        if (Hw > 0) {
            if (cjVar.rN(cjVar.Hw(Hw, 2)) == 215) {
                a8 = cjVar.a8(cjVar.Hw(cjVar.Hw(Hw, 2), 1));
                if (a8.length() >= 2) {
                    substring = a8.substring(1, a8.length() - 1);
                    a8 = null;
                } else {
                    substring = a8;
                    a8 = null;
                }
            } else if (cjVar.rN(cjVar.Hw(Hw, 2)) == 214) {
                a8 = cjVar.a8(cjVar.Hw(cjVar.Hw(Hw, 2), 1));
                if (a8.length() >= 2) {
                    a8 = a8.substring(1, a8.length() - 1);
                    substring = null;
                } else {
                    substring = null;
                }
            }
            if (this.FH) {
                if (substring == null) {
                    return j6.FH(j6.we());
                }
                fs FH = j6.FH(substring);
                return FH != null ? j6.FH(j6.we()) : FH;
            } else if (substring != null) {
                return j6(substring);
            } else {
                if (a8 == null) {
                    return DW(a8);
                }
                return null;
            }
        }
        a8 = null;
        substring = null;
        if (this.FH) {
            if (substring == null) {
                return j6.FH(j6.we());
            }
            fs FH2 = j6.FH(substring);
            if (FH2 != null) {
            }
        } else if (substring != null) {
            return j6(substring);
        } else {
            if (a8 == null) {
                return null;
            }
            return DW(a8);
        }
    }

    private ft j6() {
        for (bh bhVar : this.j6.cn.DW()) {
            if (bhVar instanceof ft) {
                return (ft) bhVar;
            }
        }
        return null;
    }

    private bj DW() {
        for (bj bjVar : j6().Zo()) {
            if (bjVar instanceof fu) {
                return bjVar;
            }
        }
        return null;
    }

    private int Hw(cj cjVar, int i) {
        if (cjVar.rN(i) == 213) {
            return i;
        }
        for (int i2 = 0; i2 < cjVar.lg(i); i2++) {
            int Hw = Hw(cjVar, cjVar.Hw(i, i2));
            if (Hw != -1) {
                return Hw;
            }
        }
        return -1;
    }

    private int j6(bv bvVar, int i, int i2) {
        String j6 = bvVar.j6(i, i2);
        int length = j6.length() + 1;
        while (length - 2 >= 0 && j6(j6.charAt(length - 2))) {
            length--;
        }
        return length;
    }

    private boolean j6(char c) {
        return Character.isJavaIdentifierPart(c) || c == ':';
    }
}
