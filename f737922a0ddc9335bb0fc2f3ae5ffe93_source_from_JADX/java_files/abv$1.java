class abv$1 implements aci$a {
    final /* synthetic */ abv DW;
    final /* synthetic */ aag j6;

    abv$1(abv abv, aag aag) {
        this.DW = abv;
        this.j6 = aag;
    }

    public void j6(abz abz) {
    }

    public void j6(acb acb) {
    }

    public void DW(abz abz) {
        zz Zo = abz.Zo().Zo();
        zx DW = abz.DW();
        if (this.DW.j6(abz) || DW.m_() != 2) {
            return;
        }
        if (Zo.Hw() == 4) {
            if (abv.DW(DW.DW(0))) {
                this.DW.j6(abz, DW.Zo(), zv.DW(Zo.j6()), null);
            } else if (abv.DW(DW.DW(1))) {
                this.DW.j6(abz, DW.VH(), Zo.j6(), null);
            }
        } else if (this.j6.j6(Zo, DW.DW(0), DW.DW(1))) {
            abz.gn();
        } else if (Zo.Zo() && this.j6.j6(Zo, DW.DW(1), DW.DW(0))) {
            abz.j6(zx.j6(DW.DW(1), DW.DW(0)));
            abz.gn();
        }
    }
}
