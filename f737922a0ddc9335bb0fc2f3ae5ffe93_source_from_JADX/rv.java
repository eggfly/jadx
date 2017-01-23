public final class rv extends adc {
    public static final rv j6;

    static {
        j6 = new rv(0);
    }

    public rv(int i) {
        super(i);
    }

    public int j6() {
        return (m_() * 8) + 2;
    }

    public rv$a j6(int i) {
        return (rv$a) v5(i);
    }

    public void j6(int i, rv$a rv_a) {
        if (rv_a == null) {
            throw new NullPointerException("item == null");
        }
        j6(i, rv_a);
    }

    public void j6(int i, int i2, int i3, int i4, abf abf) {
        j6(i, new rv$a(i2, i3, i4, abf));
    }

    public rv DW(int i) {
        int i2 = 0;
        int m_ = m_();
        rv$a[] rv_aArr = new rv$a[m_];
        int i3 = 0;
        for (int i4 = 0; i4 < m_; i4++) {
            rv$a j6 = j6(i4);
            if (j6.j6(i) && j6(j6, rv_aArr, i3)) {
                rv_aArr[i3] = j6;
                i3++;
            }
        }
        if (i3 == 0) {
            return j6;
        }
        rv rvVar = new rv(i3);
        while (i2 < i3) {
            rvVar.j6(i2, rv_aArr[i2]);
            i2++;
        }
        rvVar.l_();
        return rvVar;
    }

    private static boolean j6(rv$a rv_a, rv$a[] rv_aArr, int i) {
        abf Hw = rv_a.Hw();
        for (int i2 = 0; i2 < i; i2++) {
            abf Hw2 = rv_aArr[i2].Hw();
            if (Hw2 == Hw || Hw2 == abf.j6) {
                return false;
            }
        }
        return true;
    }

    public adg FH(int i) {
        int i2 = 1;
        int i3 = 0;
        if (i < -1) {
            throw new IllegalArgumentException("noException < -1");
        }
        int i4 = i >= 0 ? 1 : 0;
        int m_ = m_();
        if (m_ != 0) {
            if (i4 == 0) {
                i2 = 0;
            }
            adg adg = new adg(i2 + m_);
            while (i3 < m_) {
                adg.FH(j6(i3).FH());
                i3++;
            }
            if (i4 != 0) {
                adg.FH(i);
            }
            adg.l_();
            return adg;
        } else if (i4 != 0) {
            return adg.j6(i);
        } else {
            return adg.j6;
        }
    }

    public abn j_() {
        int m_ = m_();
        if (m_ == 0) {
            return abk.j6;
        }
        abn abk = new abk(m_);
        for (int i = 0; i < m_; i++) {
            abk.j6(i, j6(i).Hw().u7());
        }
        abk.l_();
        return abk;
    }
}
