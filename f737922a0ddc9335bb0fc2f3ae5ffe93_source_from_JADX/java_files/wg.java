public final class wg extends xl {
    private wf j6;

    public wg(wf wfVar) {
        super(4, 4);
        if (wfVar == null) {
            throw new NullPointerException("annotations == null");
        }
        this.j6 = wfVar;
    }

    public xd j6() {
        return xd.TYPE_ANNOTATION_SET_REF_ITEM;
    }

    public void j6(wq wqVar) {
        this.j6 = (wf) wqVar.Hw().DW(this.j6);
    }

    public String DW() {
        return this.j6.DW();
    }

    protected void a_(wq wqVar, acr acr) {
        int v5 = this.j6.v5();
        if (acr.j6()) {
            acr.j6(4, "  annotations_off: " + add.j6(v5));
        }
        acr.Hw(v5);
    }
}
