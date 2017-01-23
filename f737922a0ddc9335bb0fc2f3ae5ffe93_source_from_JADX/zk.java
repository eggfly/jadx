public abstract class zk extends zo {
    private final aah j6;

    public zk(zz zzVar, aac aac, zw zwVar, zx zxVar, aah aah) {
        super(zzVar, aac, zwVar, zxVar);
        if (aah == null) {
            throw new NullPointerException("cst == null");
        }
        this.j6 = aah;
    }

    public String j6() {
        return this.j6.Hw();
    }

    public aah p_() {
        return this.j6;
    }

    public boolean j6(zo zoVar) {
        return super.j6(zoVar) && this.j6.equals(((zk) zoVar).p_());
    }
}
