public final class xw extends xl {
    private final abn j6;

    public xw(abn abn) {
        super(4, (abn.m_() * 2) + 4);
        this.j6 = abn;
    }

    public int hashCode() {
        return abk.DW(this.j6);
    }

    public xd j6() {
        return xd.TYPE_TYPE_LIST;
    }

    public void j6(wq wqVar) {
        xv tp = wqVar.tp();
        int m_ = this.j6.m_();
        for (int i = 0; i < m_; i++) {
            tp.j6(this.j6.j6(i));
        }
    }

    public String DW() {
        throw new RuntimeException("unsupported");
    }

    public abn FH() {
        return this.j6;
    }

    protected void a_(wq wqVar, acr acr) {
        int i = 0;
        xv tp = wqVar.tp();
        int m_ = this.j6.m_();
        if (acr.j6()) {
            acr.j6(0, VH() + " type_list");
            acr.j6(4, "  size: " + add.j6(m_));
            for (int i2 = 0; i2 < m_; i2++) {
                abl j6 = this.j6.j6(i2);
                acr.j6(2, "  " + add.FH(tp.DW(j6)) + " // " + j6.Hw());
            }
        }
        acr.Hw(m_);
        while (i < m_) {
            acr.DW(tp.DW(this.j6.j6(i)));
            i++;
        }
    }

    protected int j6(xl xlVar) {
        return abk.DW(this.j6, ((xw) xlVar).j6);
    }
}
