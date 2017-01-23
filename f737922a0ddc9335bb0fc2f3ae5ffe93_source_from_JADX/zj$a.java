class zj$a implements zo$b {
    private int j6;

    public zj$a() {
        this.j6 = 0;
    }

    public int j6() {
        return this.j6;
    }

    public void j6(zu zuVar) {
        j6((zo) zuVar);
    }

    public void j6(zt ztVar) {
        j6((zo) ztVar);
    }

    public void j6(aad aad) {
        j6((zo) aad);
    }

    public void j6(aae aae) {
        j6((zo) aae);
    }

    public void j6(aaf aaf) {
        j6((zo) aaf);
    }

    public void j6(zn znVar) {
        j6((zo) znVar);
    }

    private void j6(zo zoVar) {
        zw gn = zoVar.gn();
        if (gn != null) {
            j6(gn);
        }
        zx tp = zoVar.tp();
        int m_ = tp.m_();
        for (int i = 0; i < m_; i++) {
            j6(tp.DW(i));
        }
    }

    private void j6(zw zwVar) {
        int tp = zwVar.tp();
        if (tp > this.j6) {
            this.j6 = tp;
        }
    }
}
