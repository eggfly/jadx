public class ic implements bc {
    private final by DW;
    private boolean FH;
    private cj Hw;
    private int Zo;
    private final bu j6;
    private dz v5;

    public ic(bu buVar, by byVar) {
        this.j6 = buVar;
        this.DW = byVar;
        this.v5 = new dz();
        this.Zo = byVar.j6("xmlns");
    }

    public void j6(cj cjVar, boolean z) {
        this.FH = z;
        this.Hw = cjVar;
        Zo(cjVar.Ws());
        j6(cjVar.Ws());
        this.Hw = null;
    }

    public void Hw(cj cjVar) {
        try {
            this.Hw = cjVar;
            FH(cjVar.Ws());
            this.Hw = null;
        } finally {
            this.v5.j6();
        }
    }

    private void j6(int i) {
        if (this.Hw.rN(i) == 18) {
            DW(i);
        } else if (this.Hw.rN(i) == 14) {
            DW(i);
        }
        int lg = this.Hw.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(this.Hw.Hw(i, i2));
        }
    }

    private void DW(int i) {
        try {
            if (this.Hw.U2(i) == 9) {
                if (this.Hw.j3(i)[this.Hw.Mr(i)] == '#') {
                    j6(i, (int) Long.parseLong(this.Hw.a8(i).substring(1), 16));
                }
            } else if (this.Hw.U2(i) == 7 && this.Hw.j3(i)[this.Hw.Mr(i)] == '#') {
                j6(i, -16777216 | ((int) Long.parseLong(this.Hw.a8(i).substring(1), 16)));
            }
        } catch (Exception e) {
        }
    }

    private void FH(int i) {
        int i2 = 0;
        switch (this.Hw.rN(i)) {
            case 200:
            case 201:
                for (int i3 = 0; i3 < this.Hw.lg(i); i3++) {
                    Hw(this.Hw.Hw(i, i3));
                }
                while (i2 < this.Hw.lg(i)) {
                    v5(this.Hw.Hw(i, i2));
                    i2++;
                }
                return;
            case 211:
                this.v5.DW();
                while (i2 < this.Hw.lg(i)) {
                    FH(this.Hw.Hw(i, i2));
                    i2++;
                }
                this.v5.FH();
                return;
        }
        while (i2 < this.Hw.lg(i)) {
            FH(this.Hw.Hw(i, i2));
            i2++;
        }
    }

    private void Hw(int i) {
        int i2 = 0;
        switch (this.Hw.rN(i)) {
            case 218:
                i2 = this.Hw.Hw(i, 0);
                int Hw = this.Hw.Hw(i, 2);
                int aM = this.Hw.aM(i);
                if (this.Hw.rN(aM) != 203) {
                    return;
                }
                if (this.Hw.gW(i2) == this.Zo) {
                    this.v5.j6(this.Hw.gW(Hw), aM);
                    this.Hw.j6(Hw, 4, aM);
                    return;
                } else if (this.Hw.gW(i2) == this.DW.j6("") && this.Hw.gW(Hw) == this.Zo) {
                    this.v5.j6(this.DW.j6(""), aM);
                    this.Hw.j6(i2, 4, aM);
                    return;
                } else {
                    return;
                }
        }
        while (i2 < this.Hw.lg(i)) {
            Hw(this.Hw.Hw(i, i2));
            i2++;
        }
    }

    private void v5(int i) {
        int i2 = 0;
        switch (this.Hw.rN(i)) {
            case 217:
                i2 = this.Hw.Hw(i, 0);
                this.Hw.Hw(i, 2);
                switch (this.Hw.rN(this.Hw.aM(i))) {
                    case 200:
                    case 201:
                    case 207:
                        if (this.v5.DW(this.Hw.gW(i2))) {
                            this.Hw.j6(i2, 5, this.v5.j6(this.Hw.gW(i2)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            case 218:
                i2 = this.Hw.Hw(i, 0);
                int Hw = this.Hw.Hw(i, 2);
                if (this.Hw.rN(this.Hw.aM(i)) == 203 && this.Hw.gW(i2) != this.Zo) {
                    if ((this.Hw.gW(i2) != this.DW.j6("") || this.Hw.gW(Hw) != this.Zo) && this.Hw.gW(i2) != this.DW.j6("") && this.v5.DW(this.Hw.gW(i2))) {
                        this.Hw.j6(i2, 5, this.v5.j6(this.Hw.gW(i2)));
                        return;
                    }
                    return;
                }
                return;
        }
        while (i2 < this.Hw.lg(i)) {
            v5(this.Hw.Hw(i, i2));
            i2++;
        }
    }

    private void Zo(int i) {
        int Hw;
        switch (this.Hw.rN(i)) {
            case 50:
                if (!this.Hw.er(i)) {
                    switch (this.Hw.rN(this.Hw.aM(i))) {
                        case 203:
                            j6(i, "Invalid character in attribute name");
                            break;
                        case 204:
                            j6(i, "Invalid character in attribute value");
                            VH(i);
                            break;
                        default:
                            break;
                    }
                }
                break;
            case 200:
                if (this.Hw.er(i)) {
                    String j6;
                    Hw = this.Hw.Hw(i, 1);
                    int gW = this.Hw.gW(this.Hw.Hw(Hw, 0));
                    Hw = this.Hw.gW(this.Hw.Hw(Hw, 2));
                    int Hw2 = this.Hw.Hw(this.Hw.aM(i), 2);
                    if (gW == this.DW.j6("")) {
                        j6 = this.DW.j6(Hw);
                    } else {
                        j6 = this.DW.j6(gW) + ":" + this.DW.j6(Hw);
                    }
                    j6(Hw2, "Unexpected closing tag </" + j6 + ">");
                    gn(Hw2);
                    break;
                }
                break;
        }
        for (Hw = 0; Hw < this.Hw.lg(i); Hw++) {
            Zo(this.Hw.Hw(i, Hw));
        }
    }

    private void VH(int i) {
        this.j6.j6(this.Hw.we(), this.Hw.tp(), this.Hw.nw(i), this.Hw.KD(i), this.Hw.SI(i), this.Hw.ro(i), '\"' + this.DW.j6(this.Hw.gW(i)) + '\"', "Surround with quotes");
    }

    private void gn(int i) {
        this.j6.j6(this.Hw.we(), this.Hw.tp(), this.Hw.nw(i), this.Hw.KD(i), this.Hw.SI(i), this.Hw.ro(i), "", "Delete");
    }

    private void j6(int i, int i2) {
        this.j6.j6(this.Hw.we(), this.Hw.tp(), this.Hw.nw(i), this.Hw.KD(i), this.Hw.SI(i), this.Hw.ro(i), i2);
    }

    private void j6(int i, String str) {
        this.j6.Zo(this.Hw.we(), this.Hw.tp(), this.Hw.nw(i), this.Hw.KD(i), this.Hw.SI(i), this.Hw.ro(i), str, 0);
    }

    public co j6(cj cjVar, int i, int i2, String str) {
        return null;
    }

    public void j6(cj cjVar) {
    }

    public void j6(cj cjVar, ec ecVar) {
        Hw(cjVar);
    }

    public void j6(cj cjVar, int i) {
        Hw(cjVar);
    }

    public void DW(cj cjVar, int i) {
        Hw(cjVar);
    }

    public void FH(cj cjVar, int i) {
    }

    public void DW(cj cjVar) {
    }

    public void FH(cj cjVar) {
    }
}
