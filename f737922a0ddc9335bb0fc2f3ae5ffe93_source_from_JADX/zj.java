import com.aide.uidesigner.ProxyTextView;

public final class zj extends adj {
    private int j6;

    public zj(int i) {
        super(i);
        this.j6 = -1;
    }

    private zj(zj zjVar) {
        super((adj) zjVar);
        this.j6 = zjVar.j6;
    }

    public zi j6(int i) {
        return (zi) v5(i);
    }

    public void j6(int i, zi ziVar) {
        super.j6(i, (adi) ziVar);
        this.j6 = -1;
    }

    public int v5() {
        if (this.j6 == -1) {
            zo$b zj_a = new zj$a();
            j6(zj_a);
            this.j6 = zj_a.j6();
        }
        return this.j6;
    }

    public int Zo() {
        int m_ = m_();
        int i = 0;
        int i2 = 0;
        while (i < m_) {
            int m_2;
            zi ziVar = (zi) Zo(i);
            if (ziVar != null) {
                m_2 = ziVar.DW().m_() + i2;
            } else {
                m_2 = i2;
            }
            i++;
            i2 = m_2;
        }
        return i2;
    }

    public int VH() {
        int m_ = m_();
        int i = 0;
        int i2 = 0;
        while (i < m_) {
            int i3;
            zi ziVar = (zi) Zo(i);
            if (ziVar != null) {
                zp DW = ziVar.DW();
                int m_2 = DW.m_();
                i3 = i2;
                for (i2 = 0; i2 < m_2; i2++) {
                    if (DW.j6(i2).Zo().j6() != 54) {
                        i3++;
                    }
                }
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public zi DW(int i) {
        int FH = FH(i);
        if (FH >= 0) {
            return j6(FH);
        }
        throw new IllegalArgumentException("no such label: " + add.FH(i));
    }

    public void j6(zo$b zo_b) {
        int m_ = m_();
        for (int i = 0; i < m_; i++) {
            j6(i).DW().j6(zo_b);
        }
    }

    public zj gn() {
        return new zj(this);
    }

    public zi j6(zi ziVar) {
        int Hw = ziVar.Hw();
        adg FH = ziVar.FH();
        switch (FH.DW()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return null;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return DW(FH.DW(0));
            default:
                if (Hw != -1) {
                    return DW(Hw);
                }
                return DW(FH.DW(0));
        }
    }
}
