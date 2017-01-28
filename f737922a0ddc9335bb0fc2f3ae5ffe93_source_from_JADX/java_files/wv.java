public final class wv implements adq, Comparable<wv> {
    private wf DW;
    private final aar j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((wv) obj);
    }

    public wv(aar aar, wf wfVar) {
        if (aar == null) {
            throw new NullPointerException("field == null");
        } else if (wfVar == null) {
            throw new NullPointerException("annotations == null");
        } else {
            this.j6 = aar;
            this.DW = wfVar;
        }
    }

    public int hashCode() {
        return this.j6.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof wv) {
            return this.j6.equals(((wv) obj).j6);
        }
        return false;
    }

    public int j6(wv wvVar) {
        return this.j6.j6(wvVar.j6);
    }

    public void j6(wq wqVar) {
        wx we = wqVar.we();
        xk Hw = wqVar.Hw();
        we.j6(this.j6);
        this.DW = (wf) Hw.DW(this.DW);
    }

    public void j6(wq wqVar, acr acr) {
        int DW = wqVar.we().DW(this.j6);
        int v5 = this.DW.v5();
        if (acr.j6()) {
            acr.j6(0, "    " + this.j6.Hw());
            acr.j6(4, "      field_idx:       " + add.j6(DW));
            acr.j6(4, "      annotations_off: " + add.j6(v5));
        }
        acr.Hw(DW);
        acr.Hw(v5);
    }

    public String Hw() {
        return this.j6.Hw() + ": " + this.DW;
    }
}
