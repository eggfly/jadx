public class adj extends adc {
    private final adg j6;

    public adj(int i) {
        super(i);
        this.j6 = new adg(i);
    }

    public adj(adj adj) {
        super(adj.m_());
        this.j6 = adj.j6.Zo();
        int m_ = adj.m_();
        for (int i = 0; i < m_; i++) {
            Object v5 = adj.v5(i);
            if (v5 != null) {
                j6(i, v5);
            }
        }
    }

    public final int tp() {
        int DW = this.j6.DW() - 1;
        while (DW >= 0 && this.j6.DW(DW) < 0) {
            DW--;
        }
        DW++;
        this.j6.v5(DW);
        return DW;
    }

    private void j6(int i) {
        this.j6.DW(i, -1);
    }

    private void j6(int i, int i2) {
        int DW = this.j6.DW();
        for (int i3 = 0; i3 <= i - DW; i3++) {
            this.j6.FH(-1);
        }
        this.j6.DW(i, i2);
    }

    public final int FH(int i) {
        if (i >= this.j6.DW()) {
            return -1;
        }
        return this.j6.DW(i);
    }

    public void u7() {
        super.u7();
        v5();
    }

    private void v5() {
        int m_ = m_();
        for (int i = 0; i < m_; i++) {
            adi adi = (adi) v5(i);
            if (adi != null) {
                this.j6.DW(adi.j6(), i);
            }
        }
    }

    protected void j6(int i, adi adi) {
        adi adi2 = (adi) Zo(i);
        j6(i, adi);
        if (adi2 != null) {
            j6(adi2.j6());
        }
        if (adi != null) {
            j6(adi.j6(), i);
        }
    }
}
