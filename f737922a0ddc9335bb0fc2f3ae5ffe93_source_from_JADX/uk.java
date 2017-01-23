public final class uk extends va {
    private uw[] j6;

    public uk(aac aac, zx zxVar) {
        super(aac, zxVar);
        if (zxVar.m_() == 0) {
            throw new IllegalArgumentException("registers.size() == 0");
        }
        this.j6 = null;
    }

    public int j6() {
        int i = 0;
        FH();
        uw[] uwVarArr = this.j6;
        int i2 = 0;
        while (i < uwVarArr.length) {
            i2 += uwVarArr[i].j6();
            i++;
        }
        return i2;
    }

    public void j6(acr acr) {
        FH();
        for (uw j6 : this.j6) {
            j6.j6(acr);
        }
    }

    private void FH() {
        int i = 0;
        if (this.j6 == null) {
            zx tp = tp();
            int m_ = tp.m_();
            this.j6 = new uw[m_];
            for (int i2 = 0; i2 < m_; i2++) {
                zw DW = tp.DW(i2);
                this.j6[i2] = j6(DW, i);
                i += DW.EQ();
            }
        }
    }

    public uf j6(zx zxVar) {
        return new uk(u7(), zxVar);
    }

    protected String DW() {
        return null;
    }

    protected String j6(boolean z) {
        int i = 0;
        zx tp = tp();
        int m_ = tp.m_();
        StringBuffer stringBuffer = new StringBuffer(100);
        for (int i2 = 0; i2 < m_; i2++) {
            zw DW = tp.DW(i2);
            uw j6 = j6(DW, i);
            if (i2 != 0) {
                stringBuffer.append('\n');
            }
            stringBuffer.append(j6.j6(z));
            i += DW.EQ();
        }
        return stringBuffer.toString();
    }

    private static uw j6(zw zwVar, int i) {
        return uf.j6(aac.j6, zw.j6(i, zwVar.j6()), zwVar);
    }
}
