public final class wf extends xl {
    private final we[] DW;
    private final ze j6;

    public wf(ze zeVar) {
        super(4, j6(zeVar));
        this.j6 = zeVar;
        this.DW = new we[zeVar.DW()];
        int i = 0;
        for (zc weVar : zeVar.Hw()) {
            this.DW[i] = new we(weVar);
            i++;
        }
    }

    private static int j6(ze zeVar) {
        try {
            return (zeVar.DW() * 4) + 4;
        } catch (NullPointerException e) {
            throw new NullPointerException("list == null");
        }
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    protected int j6(xl xlVar) {
        return this.j6.j6(((wf) xlVar).j6);
    }

    public xd j6() {
        return xd.TYPE_ANNOTATION_SET_ITEM;
    }

    public String DW() {
        return this.j6.toString();
    }

    public void j6(wq wqVar) {
        xk J8 = wqVar.J8();
        int length = this.DW.length;
        for (int i = 0; i < length; i++) {
            this.DW[i] = (we) J8.DW(this.DW[i]);
        }
    }

    protected void j6(xp xpVar, int i) {
        we.j6(this.DW);
    }

    protected void a_(wq wqVar, acr acr) {
        int i = 0;
        boolean j6 = acr.j6();
        int length = this.DW.length;
        if (j6) {
            acr.j6(0, VH() + " annotation set");
            acr.j6(4, "  size: " + add.j6(length));
        }
        acr.Hw(length);
        while (i < length) {
            int v5 = this.DW[i].v5();
            if (j6) {
                acr.j6(4, "  entries[" + Integer.toHexString(i) + "]: " + add.j6(v5));
                this.DW[i].j6(acr, "    ");
            }
            acr.Hw(v5);
            i++;
        }
    }
}
