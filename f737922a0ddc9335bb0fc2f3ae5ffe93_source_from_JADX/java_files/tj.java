public final class tj extends adc implements ta {
    public tj(int i) {
        super(i);
    }

    public sz j6(int i) {
        return (sz) v5(i);
    }

    public int DW() {
        int i = 2;
        for (int i2 = 0; i2 < m_(); i2++) {
            i += j6(i2).j6();
        }
        return i;
    }

    public sz j6(String str) {
        int m_ = m_();
        for (int i = 0; i < m_; i++) {
            sz j6 = j6(i);
            if (j6.VH().equals(str)) {
                return j6;
            }
        }
        return null;
    }

    public sz j6(sz szVar) {
        int m_ = m_();
        for (int i = 0; i < m_; i++) {
            if (j6(i) == szVar) {
                String VH = szVar.VH();
                for (int i2 = i + 1; i2 < m_; i2++) {
                    sz j6 = j6(i2);
                    if (j6.VH().equals(VH)) {
                        return j6;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public void j6(int i, sz szVar) {
        j6(i, szVar);
    }
}
