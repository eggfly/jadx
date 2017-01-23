public abstract class xf extends xa {
    private final aba j6;

    protected abstract int DW(wq wqVar);

    protected abstract String Hw();

    public xf(aba aba) {
        super(aba.J0());
        this.j6 = aba;
    }

    public int n_() {
        return 8;
    }

    public void j6(wq wqVar) {
        super.j6(wqVar);
        wqVar.VH().j6(tp().J8().j6());
    }

    public final void j6(wq wqVar, acr acr) {
        xv tp = wqVar.tp();
        xt VH = wqVar.VH();
        abc J8 = this.j6.J8();
        int DW = tp.DW(v5());
        int DW2 = VH.DW(J8.j6());
        int DW3 = DW(wqVar);
        if (acr.j6()) {
            acr.j6(0, gn() + ' ' + this.j6.Hw());
            acr.j6(2, "  class_idx: " + add.FH(DW));
            acr.j6(2, String.format("  %-10s %s", new Object[]{Hw() + ':', add.FH(DW3)}));
            acr.j6(4, "  name_idx:  " + add.j6(DW2));
        }
        acr.DW(DW);
        acr.DW(DW3);
        acr.Hw(DW2);
    }

    public final aba tp() {
        return this.j6;
    }
}
