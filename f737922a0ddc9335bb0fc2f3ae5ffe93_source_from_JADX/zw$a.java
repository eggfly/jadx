class zw$a {
    private abm DW;
    private zq FH;
    private int j6;

    private zw$a() {
    }

    public void j6(int i, abm abm, zq zqVar) {
        this.j6 = i;
        this.DW = abm;
        this.FH = zqVar;
    }

    public zw j6() {
        return new zw(this.DW, this.FH, null);
    }

    public boolean equals(Object obj) {
        if (obj instanceof zw) {
            return ((zw) obj).v5(this.j6, this.DW, this.FH);
        }
        return false;
    }

    public int hashCode() {
        return zw.Zo(this.j6, this.DW, this.FH);
    }
}
