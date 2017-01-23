import java.util.BitSet;

public final class zx extends adc implements abn {
    public static final zx j6;

    static {
        j6 = new zx(0);
    }

    public static zx j6(zw zwVar) {
        zx zxVar = new zx(1);
        zxVar.j6(0, zwVar);
        return zxVar;
    }

    public static zx j6(zw zwVar, zw zwVar2) {
        zx zxVar = new zx(2);
        zxVar.j6(0, zwVar);
        zxVar.j6(1, zwVar2);
        return zxVar;
    }

    public zx(int i) {
        super(i);
    }

    public abl j6(int i) {
        return DW(i).j6().j6();
    }

    public int v5() {
        int i = 0;
        int i2 = 0;
        while (i < m_()) {
            i2 += j6(i).tp();
            i++;
        }
        return i2;
    }

    public abn j6(abl abl) {
        throw new UnsupportedOperationException("unsupported");
    }

    public zw DW(int i) {
        return (zw) v5(i);
    }

    public int FH(int i) {
        int m_ = m_();
        for (int i2 = 0; i2 < m_; i2++) {
            if (DW(i2).VH() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void j6(int i, zw zwVar) {
        j6(i, zwVar);
    }

    public zx DW(zw zwVar) {
        int m_ = m_();
        zx zxVar = new zx(m_ + 1);
        for (int i = 0; i < m_; i++) {
            zxVar.j6(i + 1, v5(i));
        }
        zxVar.j6(0, zwVar);
        if (EQ()) {
            zxVar.l_();
        }
        return zxVar;
    }

    public zx Zo() {
        int m_ = m_() - 1;
        if (m_ == 0) {
            return j6;
        }
        zx zxVar = new zx(m_);
        for (int i = 0; i < m_; i++) {
            zxVar.j6(i, v5(i + 1));
        }
        if (!EQ()) {
            return zxVar;
        }
        zxVar.l_();
        return zxVar;
    }

    public zx VH() {
        int m_ = m_() - 1;
        if (m_ == 0) {
            return j6;
        }
        zx zxVar = new zx(m_);
        for (int i = 0; i < m_; i++) {
            zxVar.j6(i, v5(i));
        }
        if (!EQ()) {
            return zxVar;
        }
        zxVar.l_();
        return zxVar;
    }

    public zx j6(BitSet bitSet) {
        int i = 0;
        int m_ = m_() - bitSet.cardinality();
        if (m_ == 0) {
            return j6;
        }
        zx zxVar = new zx(m_);
        m_ = 0;
        while (i < m_()) {
            if (!bitSet.get(i)) {
                zxVar.j6(m_, v5(i));
                m_++;
            }
            i++;
        }
        if (EQ()) {
            zxVar.l_();
        }
        return zxVar;
    }

    public zx Hw(int i) {
        int m_ = m_();
        if (m_ == 0) {
            return this;
        }
        zx zxVar = new zx(m_);
        for (int i2 = 0; i2 < m_; i2++) {
            zw zwVar = (zw) v5(i2);
            if (zwVar != null) {
                zxVar.j6(i2, zwVar.FH(i));
            }
        }
        if (EQ()) {
            zxVar.l_();
        }
        return zxVar;
    }

    public zx j6(int i, boolean z, BitSet bitSet) {
        int m_ = m_();
        if (m_ == 0) {
            return this;
        }
        zx zxVar = new zx(m_);
        int i2 = 0;
        boolean z2 = z;
        int i3 = i;
        while (i2 < m_) {
            Object obj;
            boolean z3;
            zw zwVar = (zw) v5(i2);
            if (bitSet == null) {
                obj = 1;
            } else if (bitSet.get(i2)) {
                obj = null;
            } else {
                int i4 = 1;
            }
            if (obj != null) {
                zxVar.j6(i2, zwVar.DW(i3));
                if (!z2) {
                    i3 = zwVar.EQ() + i3;
                }
            } else {
                zxVar.j6(i2, zwVar);
            }
            if (z2) {
                z3 = false;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (EQ()) {
            zxVar.l_();
        }
        return zxVar;
    }
}
