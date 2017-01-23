public final class xr extends xl {
    private final abe j6;

    public xr(abe abe) {
        super(1, j6(abe));
        this.j6 = abe;
    }

    private static int j6(abe abe) {
        return (adk.j6(abe.J0()) + abe.we()) + 1;
    }

    public xd j6() {
        return xd.TYPE_STRING_DATA_ITEM;
    }

    public void j6(wq wqVar) {
    }

    public void a_(wq wqVar, acr acr) {
        acu EQ = this.j6.EQ();
        int J0 = this.j6.J0();
        if (acr.j6()) {
            acr.j6(adk.j6(J0), "utf16_size: " + add.j6(J0));
            acr.j6(EQ.j6() + 1, this.j6.u7());
        }
        acr.v5(J0);
        acr.j6(EQ);
        acr.FH(0);
    }

    public String DW() {
        return this.j6.u7();
    }

    protected int j6(xl xlVar) {
        return this.j6.j6(((xr) xlVar).j6);
    }
}
