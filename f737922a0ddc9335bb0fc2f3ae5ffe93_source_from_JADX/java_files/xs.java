public final class xs extends xb implements Comparable {
    private xr DW;
    private final abe j6;

    public xs(abe abe) {
        if (abe == null) {
            throw new NullPointerException("value == null");
        }
        this.j6 = abe;
        this.DW = null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof xs)) {
            return false;
        }
        return this.j6.equals(((xs) obj).j6);
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    public int compareTo(Object obj) {
        return this.j6.j6(((xs) obj).j6);
    }

    public xd j6() {
        return xd.TYPE_STRING_ID_ITEM;
    }

    public int n_() {
        return 4;
    }

    public void j6(wq wqVar) {
        if (this.DW == null) {
            xk FH = wqVar.FH();
            this.DW = new xr(this.j6);
            FH.j6(this.DW);
        }
    }

    public void j6(wq wqVar, acr acr) {
        int v5 = this.DW.v5();
        if (acr.j6()) {
            acr.j6(0, gn() + ' ' + this.j6.j6(100));
            acr.j6(4, "  string_data_off: " + add.j6(v5));
        }
        acr.Hw(v5);
    }

    public abe FH() {
        return this.j6;
    }
}
