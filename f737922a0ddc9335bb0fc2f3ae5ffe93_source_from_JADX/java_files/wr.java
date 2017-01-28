public final class wr extends xl {
    private byte[] DW;
    private final aak j6;

    public wr(aak aak) {
        super(1, -1);
        if (aak == null) {
            throw new NullPointerException("array == null");
        }
        this.j6 = aak;
        this.DW = null;
    }

    public xd j6() {
        return xd.TYPE_ENCODED_ARRAY_ITEM;
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    protected int j6(xl xlVar) {
        return this.j6.j6(((wr) xlVar).j6);
    }

    public String DW() {
        return this.j6.Hw();
    }

    public void j6(wq wqVar) {
        xz.j6(wqVar, this.j6);
    }

    protected void j6(xp xpVar, int i) {
        Object acv = new acv();
        new xz(xpVar.v5(), acv).j6(this.j6, false);
        this.DW = acv.Zo();
        j6(this.DW.length);
    }

    protected void a_(wq wqVar, acr acr) {
        if (acr.j6()) {
            acr.j6(0, VH() + " encoded array");
            new xz(wqVar, acr).j6(this.j6, true);
            return;
        }
        acr.j6(this.DW);
    }
}
