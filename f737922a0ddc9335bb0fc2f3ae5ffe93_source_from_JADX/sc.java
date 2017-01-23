public final class sc extends adc {
    public static final sc j6;

    static {
        j6 = new sc(0);
    }

    public static sc j6(sc scVar, sc scVar2) {
        int i = 0;
        if (scVar == j6) {
            return scVar2;
        }
        int m_ = scVar.m_();
        int m_2 = scVar2.m_();
        sc scVar3 = new sc(m_ + m_2);
        for (int i2 = 0; i2 < m_; i2++) {
            scVar3.j6(i2, scVar.j6(i2));
        }
        while (i < m_2) {
            scVar3.j6(m_ + i, scVar2.j6(i));
            i++;
        }
        scVar3.l_();
        return scVar3;
    }

    public static sc DW(sc scVar, sc scVar2) {
        int m_ = scVar.m_();
        sc scVar3 = new sc(m_);
        for (int i = 0; i < m_; i++) {
            sc$a j6 = scVar.j6(i);
            sc$a j62 = scVar2.j6(j6);
            if (j62 != null) {
                j6 = j6.j6(j62.FH());
            }
            scVar3.j6(i, j6);
        }
        scVar3.l_();
        return scVar3;
    }

    public sc(int i) {
        super(i);
    }

    public sc$a j6(int i) {
        return (sc$a) v5(i);
    }

    public void j6(int i, sc$a sc_a) {
        if (sc_a == null) {
            throw new NullPointerException("item == null");
        }
        j6(i, sc_a);
    }

    public void j6(int i, int i2, int i3, abe abe, abe abe2, abe abe3, int i4) {
        j6(i, new sc$a(i2, i3, abe, abe2, abe3, i4));
    }

    public sc$a j6(sc$a sc_a) {
        int m_ = m_();
        for (int i = 0; i < m_; i++) {
            sc$a sc_a2 = (sc$a) v5(i);
            if (sc_a2 != null && sc_a2.j6(sc_a)) {
                return sc_a2;
            }
        }
        return null;
    }

    public sc$a j6(int i, int i2) {
        int m_ = m_();
        for (int i3 = 0; i3 < m_; i3++) {
            sc$a sc_a = (sc$a) v5(i3);
            if (sc_a != null && sc_a.j6(i, i2)) {
                return sc_a;
            }
        }
        return null;
    }
}
