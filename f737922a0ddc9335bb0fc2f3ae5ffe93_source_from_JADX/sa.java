public final class sa {
    private final rz DW;
    private final adg FH;
    private final sd j6;

    private sa(sd sdVar, rz rzVar) {
        this(sdVar, rzVar, adg.j6);
    }

    private sa(sd sdVar, rz rzVar, adg adg) {
        if (sdVar == null) {
            throw new NullPointerException("locals == null");
        } else if (rzVar == null) {
            throw new NullPointerException("stack == null");
        } else {
            adg.J0();
            this.j6 = sdVar;
            this.DW = rzVar;
            this.FH = adg;
        }
    }

    public sa(int i, int i2) {
        this(new sh(i), new rz(i2));
    }

    public sa j6() {
        return new sa(this.j6.j6(), this.DW.j6(), this.FH);
    }

    public void DW() {
        this.j6.l_();
        this.DW.l_();
    }

    public void j6(abl abl) {
        this.j6.j6(abl);
        this.DW.j6(abl);
    }

    public sd FH() {
        return this.j6;
    }

    public rz Hw() {
        return this.DW;
    }

    public adg v5() {
        return this.FH;
    }

    public void j6(abk abk) {
        int i = 0;
        int m_ = abk.m_();
        int i2 = 0;
        while (i < m_) {
            abm DW = abk.DW(i);
            this.j6.j6(i2, DW);
            i2 += DW.tp();
            i++;
        }
    }

    public sa j6(int i, int i2) {
        sd DW;
        if (this.j6 instanceof se) {
            DW = ((se) this.j6).DW(i2);
        } else {
            DW = null;
        }
        try {
            adg Zo = this.FH.Zo();
            if (Zo.v5() != i) {
                throw new RuntimeException("returning from invalid subroutine");
            }
            Zo.l_();
            return DW == null ? null : new sa(DW, this.DW, Zo);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("returning from invalid subroutine");
        } catch (NullPointerException e2) {
            throw new NullPointerException("can't return from non-subroutine");
        }
    }

    public sa j6(sa saVar) {
        sd j6 = FH().j6(saVar.FH());
        rz j62 = Hw().j6(saVar.Hw());
        adg j63 = j6(saVar.FH);
        j6 = j6(j6, j63);
        if (j6 == FH() && j62 == Hw() && this.FH == j63) {
            return this;
        }
        this(j6, j62, j63);
        return this;
    }

    private adg j6(adg adg) {
        if (this.FH.equals(adg)) {
            return this.FH;
        }
        adg adg2 = new adg();
        int DW = this.FH.DW();
        int DW2 = adg.DW();
        int i = 0;
        while (i < DW && i < DW2 && this.FH.DW(i) == adg.DW(i)) {
            adg2.FH(i);
            i++;
        }
        adg2.l_();
        return adg2;
    }

    private static sd j6(sd sdVar, adg adg) {
        if (!(sdVar instanceof se)) {
            return sdVar;
        }
        se seVar = (se) sdVar;
        if (adg.DW() == 0) {
            return seVar.DW();
        }
        return seVar;
    }

    public sa j6(sa saVar, int i, int i2) {
        sd j6 = FH().j6(saVar.FH(), i2);
        rz j62 = Hw().j6(saVar.Hw());
        adg Zo = saVar.FH.Zo();
        Zo.FH(i);
        Zo.l_();
        if (j6 == FH() && j62 == Hw() && this.FH.equals(Zo)) {
            return this;
        }
        adg adg;
        if (this.FH.equals(Zo)) {
            adg = this.FH;
        } else {
            if (this.FH.DW() > Zo.DW()) {
                adg = this.FH;
            } else {
                adg = Zo;
                Zo = this.FH;
            }
            int DW = adg.DW();
            int DW2 = Zo.DW();
            for (int i3 = DW2 - 1; i3 >= 0; i3--) {
                if (Zo.DW(i3) != adg.DW((DW - DW2) + i3)) {
                    throw new RuntimeException("Incompatible merged subroutines");
                }
            }
        }
        this(j6, j62, adg);
        return this;
    }

    public sa DW(int i, int i2) {
        this.FH.Zo().FH(i);
        return new sa(this.j6.DW(), this.DW, adg.j6(i)).j6(this, i, i2);
    }

    public sa j6(abf abf) {
        rz j6 = Hw().j6();
        j6.FH();
        j6.j6((abm) abf);
        return new sa(FH(), j6, this.FH);
    }

    public void j6(ada ada) {
        this.j6.j6(ada);
        this.DW.j6(ada);
    }
}
