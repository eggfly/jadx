public final class zu extends zo {
    public zu(zz zzVar, aac aac, zw zwVar, zx zxVar) {
        super(zzVar, aac, zwVar, zxVar);
        switch (zzVar.Hw()) {
            case 5:
            case 6:
                throw new IllegalArgumentException("bogus branchingness");
            default:
                if (zwVar != null && zzVar.Hw() != 1) {
                    throw new IllegalArgumentException("can't mix branchingness with result");
                }
        }
    }

    public zu(zz zzVar, aac aac, zw zwVar, zw zwVar2) {
        this(zzVar, aac, zwVar, zx.j6(zwVar2));
    }

    public abn DW() {
        return abk.j6;
    }

    public void j6(zo$b zo_b) {
        zo_b.j6(this);
    }

    public zo j6(abl abl) {
        throw new UnsupportedOperationException("unsupported");
    }

    public zo we() {
        zx tp = tp();
        int m_ = tp.m_();
        if (m_ == 0) {
            return this;
        }
        abm gn = tp.DW(m_ - 1).gn();
        Object VH;
        aah j6;
        if (gn.Zo()) {
            aah aah = (aah) gn;
            VH = tp.VH();
            try {
                int i;
                int j62 = Zo().j6();
                if (j62 == 15 && (aah instanceof aat)) {
                    j6 = aat.j6(-((aat) aah).r_());
                    i = 14;
                } else {
                    j6 = aah;
                    i = j62;
                }
                return new zt(aab.j6(i, gn(), VH, j6), VH(), gn(), VH, j6);
            } catch (IllegalArgumentException e) {
                return this;
            }
        }
        abm gn2 = tp.DW(0).gn();
        if (m_ != 2 || !gn2.Zo()) {
            return this;
        }
        j6 = (aah) gn2;
        VH = tp.Zo();
        return new zt(aab.j6(Zo().j6(), gn(), VH, j6), VH(), gn(), VH, j6);
    }

    public zo j6(zw zwVar, zx zxVar) {
        return new zu(Zo(), VH(), zwVar, zxVar);
    }
}
