import java.util.ArrayList;

class acq$a implements acb$b {
    private final ArrayList<acg> j6;

    public acq$a(ArrayList<acg> arrayList) {
        this.j6 = arrayList;
    }

    public void j6(acb acb) {
        zx DW = acb.DW();
        zw Ws = acb.Ws();
        int m_ = DW.m_();
        for (int i = 0; i < m_; i++) {
            ((acg) this.j6.get(acb.j6(i))).j6(Ws, DW.DW(i));
        }
    }
}
