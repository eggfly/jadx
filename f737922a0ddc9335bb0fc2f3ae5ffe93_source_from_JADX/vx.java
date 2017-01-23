import java.util.BitSet;

public final class vx extends ul {
    public static final ul DW;

    static {
        DW = new vx();
    }

    private vx() {
    }

    public String j6(uf ufVar) {
        return ul.j6(v5(ufVar.tp())) + ", " + ul.Zo(ufVar);
    }

    public String DW(uf ufVar, boolean z) {
        if (z) {
            return ul.VH(ufVar);
        }
        return "";
    }

    public int j6() {
        return 3;
    }

    public boolean DW(uf ufVar) {
        if (!(ufVar instanceof ud)) {
            return false;
        }
        ud udVar = (ud) ufVar;
        if (!ul.Zo(udVar.Hw())) {
            return false;
        }
        aah FH = udVar.FH();
        if (((FH instanceof abb) || (FH instanceof abf)) && Hw(udVar.tp()) >= 0) {
            return true;
        }
        return false;
    }

    public BitSet FH(uf ufVar) {
        zx tp = ufVar.tp();
        int m_ = tp.m_();
        BitSet bitSet = new BitSet(m_);
        for (int i = 0; i < m_; i++) {
            zw DW = tp.DW(i);
            bitSet.set(i, ul.DW((DW.EQ() + DW.VH()) - 1));
        }
        return bitSet;
    }

    public void j6(acr acr, uf ufVar) {
        int VH;
        int VH2;
        int VH3;
        int VH4;
        int Hw = ((ud) ufVar).Hw();
        zx v5 = v5(ufVar.tp());
        int m_ = v5.m_();
        int VH5 = m_ > 0 ? v5.DW(0).VH() : 0;
        if (m_ > 1) {
            VH = v5.DW(1).VH();
        } else {
            VH = 0;
        }
        if (m_ > 2) {
            VH2 = v5.DW(2).VH();
        } else {
            VH2 = 0;
        }
        if (m_ > 3) {
            VH3 = v5.DW(3).VH();
        } else {
            VH3 = 0;
        }
        if (m_ > 4) {
            VH4 = v5.DW(4).VH();
        } else {
            VH4 = 0;
        }
        ul.j6(acr, ul.j6(ufVar, ul.DW(VH4, m_)), (short) Hw, ul.j6(VH5, VH, VH2, VH3));
    }

    private static int Hw(zx zxVar) {
        int i = 0;
        int m_ = zxVar.m_();
        if (m_ > 5) {
            return -1;
        }
        int i2 = 0;
        while (i2 < m_) {
            zw DW = zxVar.DW(i2);
            int EQ = DW.EQ() + i;
            if (!ul.DW((DW.VH() + DW.EQ()) - 1)) {
                return -1;
            }
            i2++;
            i = EQ;
        }
        if (i > 5) {
            i = -1;
        }
        return i;
    }

    private static zx v5(zx zxVar) {
        int i = 0;
        int Hw = Hw(zxVar);
        int m_ = zxVar.m_();
        if (Hw == m_) {
            return zxVar;
        }
        zx zxVar2 = new zx(Hw);
        for (Hw = 0; Hw < m_; Hw++) {
            zw DW = zxVar.DW(Hw);
            zxVar2.j6(i, DW);
            if (DW.EQ() == 2) {
                zxVar2.j6(i + 1, zw.j6(DW.VH() + 1, abl.u7));
                i += 2;
            } else {
                i++;
            }
        }
        zxVar2.l_();
        return zxVar2;
    }
}
