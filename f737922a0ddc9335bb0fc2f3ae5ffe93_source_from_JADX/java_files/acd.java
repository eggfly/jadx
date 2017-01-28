public abstract class acd {
    public abstract int j6();

    public abstract zw j6(zw zwVar);

    public final zx j6(zx zxVar) {
        int m_ = zxVar.m_();
        zx zxVar2 = new zx(m_);
        for (int i = 0; i < m_; i++) {
            zxVar2.j6(i, j6(zxVar.DW(i)));
        }
        zxVar2.l_();
        return zxVar2.equals(zxVar) ? zxVar : zxVar2;
    }
}
