public final class aae extends zk {
    private final abn j6;

    public aae(zz zzVar, aac aac, zx zxVar, abn abn, aah aah) {
        super(zzVar, aac, null, zxVar, aah);
        if (zzVar.Hw() != 6) {
            throw new IllegalArgumentException("bogus branchingness");
        } else if (abn == null) {
            throw new NullPointerException("catches == null");
        } else {
            this.j6 = abn;
        }
    }

    public String j6() {
        String u7;
        aah p_ = p_();
        String Hw = p_.Hw();
        if (p_ instanceof abe) {
            u7 = ((abe) p_).u7();
        } else {
            u7 = Hw;
        }
        return u7 + " " + aaf.j6(this.j6);
    }

    public abn DW() {
        return this.j6;
    }

    public void j6(zo$b zo_b) {
        zo_b.j6(this);
    }

    public zo j6(abl abl) {
        return new aae(Zo(), VH(), tp(), this.j6.j6(abl), p_());
    }

    public zo j6(zw zwVar, zx zxVar) {
        return new aae(Zo(), VH(), zxVar, this.j6, p_());
    }
}
