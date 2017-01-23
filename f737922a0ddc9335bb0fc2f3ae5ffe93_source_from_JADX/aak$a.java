public final class aak$a extends adc implements Comparable<aak$a> {
    public /* synthetic */ int compareTo(Object obj) {
        return j6((aak$a) obj);
    }

    public aak$a(int i) {
        super(i);
    }

    public int j6(aak$a aak_a) {
        int m_ = m_();
        int m_2 = aak_a.m_();
        int i = m_ < m_2 ? m_ : m_2;
        for (int i2 = 0; i2 < i; i2++) {
            int j6 = ((aah) v5(i2)).j6((aah) aak_a.v5(i2));
            if (j6 != 0) {
                return j6;
            }
        }
        if (m_ < m_2) {
            return -1;
        }
        return m_ > m_2 ? 1 : 0;
    }

    public aah j6(int i) {
        return (aah) v5(i);
    }

    public void j6(int i, aah aah) {
        j6(i, aah);
    }
}
