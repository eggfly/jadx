public final class sb extends adc {
    public static final sb j6;

    static {
        j6 = new sb(0);
    }

    public static sb j6(sb sbVar, sb sbVar2) {
        int i = 0;
        if (sbVar == j6) {
            return sbVar2;
        }
        int m_ = sbVar.m_();
        int m_2 = sbVar2.m_();
        sb sbVar3 = new sb(m_ + m_2);
        for (int i2 = 0; i2 < m_; i2++) {
            sbVar3.j6(i2, sbVar.j6(i2));
        }
        while (i < m_2) {
            sbVar3.j6(m_ + i, sbVar2.j6(i));
            i++;
        }
        return sbVar3;
    }

    public sb(int i) {
        super(i);
    }

    public sb$a j6(int i) {
        return (sb$a) v5(i);
    }

    public void j6(int i, sb$a sb_a) {
        if (sb_a == null) {
            throw new NullPointerException("item == null");
        }
        j6(i, sb_a);
    }

    public void j6(int i, int i2, int i3) {
        j6(i, new sb$a(i2, i3));
    }

    public int DW(int i) {
        int m_ = m_();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (i2 < m_) {
            sb$a j6 = j6(i2);
            int j62 = j6.j6();
            if (j62 > i || j62 <= i3) {
                j62 = i3;
            } else {
                i4 = j6.DW();
                if (j62 == i) {
                    break;
                }
            }
            i2++;
            i3 = j62;
        }
        return i4;
    }
}
