public final class zr {
    private final zj DW;
    private final zs FH;
    private final int[] Hw;
    private final aaa j6;

    public static zs j6(aaa aaa) {
        return new zr(aaa).j6();
    }

    private zr(aaa aaa) {
        if (aaa == null) {
            throw new NullPointerException("method == null");
        }
        zj j6 = aaa.j6();
        int tp = j6.tp();
        this.j6 = aaa;
        this.DW = j6;
        this.FH = new zs(aaa);
        this.Hw = act.j6(tp);
    }

    private zs j6() {
        int DW = this.j6.DW();
        while (DW >= 0) {
            act.FH(this.Hw, DW);
            j6(DW);
            DW = act.Hw(this.Hw, 0);
        }
        this.FH.l_();
        return this.FH;
    }

    private void j6(int i) {
        int i2 = 0;
        zy DW = this.FH.DW(i);
        zi DW2 = this.DW.DW(i);
        zp DW3 = DW2.DW();
        int m_ = DW3.m_();
        int i3 = (!DW2.u7() || DW3.v5().gn() == null) ? 0 : 1;
        int i4 = m_ - 1;
        int i5 = 0;
        zy zyVar = DW;
        while (i5 < m_) {
            if (i3 != 0 && i5 == i4) {
                zyVar.l_();
                zyVar = zyVar.v5();
            }
            zo j6 = DW3.j6(i5);
            zw u7 = j6.u7();
            if (u7 == null) {
                zw gn = j6.gn();
                if (!(gn == null || zyVar.j6(gn.VH()) == null)) {
                    zyVar.FH(zyVar.j6(gn.VH()));
                }
            } else {
                u7 = u7.J8();
                if (!u7.equals(zyVar.j6(u7))) {
                    zw j62 = zyVar.j6(u7.u7());
                    if (!(j62 == null || j62.VH() == u7.VH())) {
                        zyVar.FH(j62);
                    }
                    this.FH.j6(j6, u7);
                    zyVar.Hw(u7);
                }
            }
            i5++;
        }
        zyVar.l_();
        adg FH = DW2.FH();
        int DW4 = FH.DW();
        int Hw = DW2.Hw();
        while (i2 < DW4) {
            zy zyVar2;
            m_ = FH.DW(i2);
            if (m_ == Hw) {
                zyVar2 = zyVar;
            } else {
                zyVar2 = DW;
            }
            if (this.FH.DW(m_, zyVar2)) {
                act.DW(this.Hw, m_);
            }
            i2++;
        }
    }
}
