public final class zf extends adc {
    public static final zf j6;

    static {
        j6 = new zf(0);
    }

    public static zf j6(zf zfVar, zf zfVar2) {
        int m_ = zfVar.m_();
        if (m_ != zfVar2.m_()) {
            throw new IllegalArgumentException("list1.size() != list2.size()");
        }
        zf zfVar3 = new zf(m_);
        for (int i = 0; i < m_; i++) {
            zfVar3.j6(i, ze.j6(zfVar.j6(i), zfVar2.j6(i)));
        }
        zfVar3.l_();
        return zfVar3;
    }

    public zf(int i) {
        super(i);
    }

    public ze j6(int i) {
        return (ze) v5(i);
    }

    public void j6(int i, ze zeVar) {
        zeVar.J0();
        j6(i, zeVar);
    }
}
