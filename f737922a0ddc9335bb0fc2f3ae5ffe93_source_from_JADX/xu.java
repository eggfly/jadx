public final class xu extends xa {
    public xu(abf abf) {
        super(abf);
    }

    public xd j6() {
        return xd.TYPE_TYPE_ID_ITEM;
    }

    public int n_() {
        return 4;
    }

    public void j6(wq wqVar) {
        wqVar.VH().j6(v5().tp());
    }

    public void j6(wq wqVar, acr acr) {
        abe tp = v5().tp();
        int DW = wqVar.VH().DW(tp);
        if (acr.j6()) {
            acr.j6(0, gn() + ' ' + tp.Hw());
            acr.j6(4, "  descriptor_idx: " + add.j6(DW));
        }
        acr.Hw(DW);
    }
}
