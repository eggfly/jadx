public final class zp extends adc {
    public zp(int i) {
        super(i);
    }

    public zo j6(int i) {
        return (zo) v5(i);
    }

    public void j6(int i, zo zoVar) {
        j6(i, zoVar);
    }

    public zo v5() {
        return j6(m_() - 1);
    }

    public void j6(zo$b zo_b) {
        int m_ = m_();
        for (int i = 0; i < m_; i++) {
            j6(i).j6(zo_b);
        }
    }

    public boolean j6(zp zpVar) {
        if (zpVar == null) {
            return false;
        }
        int m_ = m_();
        if (m_ != zpVar.m_()) {
            return false;
        }
        for (int i = 0; i < m_; i++) {
            if (!j6(i).j6(zpVar.j6(i))) {
                return false;
            }
        }
        return true;
    }
}
