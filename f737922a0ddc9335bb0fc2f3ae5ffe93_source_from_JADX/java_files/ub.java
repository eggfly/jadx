public final class ub extends adc implements Comparable<ub> {
    public static final ub j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ub) obj);
    }

    static {
        j6 = new ub(0);
    }

    public ub(int i) {
        super(i);
    }

    public ub$a j6(int i) {
        return (ub$a) v5(i);
    }

    public void j6(int i, ub$a ub_a) {
        j6(i, ub_a);
    }

    public int j6(ub ubVar) {
        if (this == ubVar) {
            return 0;
        }
        int m_ = m_();
        int m_2 = ubVar.m_();
        int min = Math.min(m_, m_2);
        for (int i = 0; i < min; i++) {
            int j6 = j6(i).j6(ubVar.j6(i));
            if (j6 != 0) {
                return j6;
            }
        }
        if (m_ < m_2) {
            return -1;
        }
        if (m_ > m_2) {
            return 1;
        }
        return 0;
    }
}
