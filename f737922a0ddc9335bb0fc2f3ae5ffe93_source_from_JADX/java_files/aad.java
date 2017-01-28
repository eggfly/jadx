public final class aad extends zo {
    private final adg j6;

    public aad(zz zzVar, aac aac, zw zwVar, zx zxVar, adg adg) {
        super(zzVar, aac, zwVar, zxVar);
        if (zzVar.Hw() != 5) {
            throw new IllegalArgumentException("bogus branchingness");
        } else if (adg == null) {
            throw new NullPointerException("cases == null");
        } else {
            this.j6 = adg;
        }
    }

    public String j6() {
        return this.j6.toString();
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

    public boolean j6(zo zoVar) {
        return false;
    }

    public zo j6(zw zwVar, zx zxVar) {
        return new aad(Zo(), VH(), zwVar, zxVar, this.j6);
    }

    public adg FH() {
        return this.j6;
    }
}
