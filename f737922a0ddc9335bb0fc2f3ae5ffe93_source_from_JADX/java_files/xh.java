public final class xh implements adq, Comparable<xh> {
    private wf DW;
    private final abb j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((xh) obj);
    }

    public xh(abb abb, wf wfVar) {
        if (abb == null) {
            throw new NullPointerException("method == null");
        } else if (wfVar == null) {
            throw new NullPointerException("annotations == null");
        } else {
            this.j6 = abb;
            this.DW = wfVar;
        }
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof xh) {
            return this.j6.equals(((xh) obj).j6);
        }
        return false;
    }

    public int j6(xh xhVar) {
        return this.j6.j6(xhVar.j6);
    }

    public void j6(wq wqVar) {
        xj J0 = wqVar.J0();
        xk Hw = wqVar.Hw();
        J0.j6(this.j6);
        this.DW = (wf) Hw.DW(this.DW);
    }

    public void j6(wq wqVar, acr acr) {
        int DW = wqVar.J0().DW(this.j6);
        int v5 = this.DW.v5();
        if (acr.j6()) {
            acr.j6(0, "    " + this.j6.Hw());
            acr.j6(4, "      method_idx:      " + add.j6(DW));
            acr.j6(4, "      annotations_off: " + add.j6(v5));
        }
        acr.Hw(DW);
        acr.Hw(v5);
    }

    public String Hw() {
        return this.j6.Hw() + ": " + this.DW;
    }
}
