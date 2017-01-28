public final class abk extends adc implements abn {
    public static final abk BT;
    public static final abk DW;
    public static final abk EQ;
    public static final abk FH;
    public static final abk Hw;
    public static final abk J0;
    public static final abk J8;
    public static final abk KD;
    public static final abk Mr;
    public static final abk P8;
    public static final abk QX;
    public static final abk SI;
    public static final abk U2;
    public static final abk VH;
    public static final abk Ws;
    public static final abk XL;
    public static final abk Zo;
    public static final abk a8;
    public static final abk aM;
    public static final abk cn;
    public static final abk ei;
    public static final abk er;
    public static final abk gW;
    public static final abk gn;
    public static final abk j3;
    public static final abk j6;
    public static final abk lg;
    public static final abk nw;
    public static final abk rN;
    public static final abk ro;
    public static final abk tp;
    public static final abk u7;
    public static final abk v5;
    public static final abk vy;
    public static final abk we;
    public static final abk yS;

    static {
        j6 = new abk(0);
        DW = DW(abl.Zo);
        FH = DW(abl.VH);
        Hw = DW(abl.v5);
        v5 = DW(abl.Hw);
        Zo = DW(abl.Ws);
        VH = DW(abl.EQ);
        gn = DW(abl.aM);
        u7 = j6(abl.Zo, abl.Zo);
        tp = j6(abl.VH, abl.VH);
        EQ = j6(abl.v5, abl.v5);
        we = j6(abl.Hw, abl.Hw);
        J0 = j6(abl.Ws, abl.Ws);
        J8 = j6(abl.Zo, abl.Ws);
        Ws = j6(abl.VH, abl.Ws);
        QX = j6(abl.v5, abl.Ws);
        XL = j6(abl.Hw, abl.Ws);
        aM = j6(abl.VH, abl.Zo);
        j3 = j6(abl.SI, abl.Zo);
        Mr = j6(abl.KD, abl.Zo);
        U2 = j6(abl.nw, abl.Zo);
        a8 = j6(abl.ei, abl.Zo);
        lg = j6(abl.ro, abl.Zo);
        rN = j6(abl.BT, abl.Zo);
        er = j6(abl.vy, abl.Zo);
        yS = j6(abl.P8, abl.Zo);
        gW = j6(abl.cn, abl.Zo);
        BT = j6(abl.Zo, abl.SI, abl.Zo);
        vy = j6(abl.VH, abl.KD, abl.Zo);
        P8 = j6(abl.v5, abl.nw, abl.Zo);
        ei = j6(abl.Hw, abl.ei, abl.Zo);
        nw = j6(abl.Ws, abl.ro, abl.Zo);
        SI = j6(abl.Zo, abl.BT, abl.Zo);
        KD = j6(abl.Zo, abl.vy, abl.Zo);
        ro = j6(abl.Zo, abl.P8, abl.Zo);
        cn = j6(abl.Zo, abl.cn, abl.Zo);
    }

    public static abk DW(abl abl) {
        abk abk = new abk(1);
        abk.j6(0, abl);
        return abk;
    }

    public static abk j6(abl abl, abl abl2) {
        abk abk = new abk(2);
        abk.j6(0, abl);
        abk.j6(1, abl2);
        return abk;
    }

    public static abk j6(abl abl, abl abl2, abl abl3) {
        abk abk = new abk(3);
        abk.j6(0, abl);
        abk.j6(1, abl2);
        abk.j6(2, abl3);
        return abk;
    }

    public static abk j6(abl abl, abl abl2, abl abl3, abl abl4) {
        abk abk = new abk(4);
        abk.j6(0, abl);
        abk.j6(1, abl2);
        abk.j6(2, abl3);
        abk.j6(3, abl4);
        return abk;
    }

    public static String j6(abn abn) {
        int m_ = abn.m_();
        if (m_ == 0) {
            return "<empty>";
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        for (int i = 0; i < m_; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(abn.j6(i).Hw());
        }
        return stringBuffer.toString();
    }

    public static int DW(abn abn) {
        int i = 0;
        int i2 = 0;
        while (i < abn.m_()) {
            i2 = (i2 * 31) + abn.j6(i).hashCode();
            i++;
        }
        return i2;
    }

    public static boolean j6(abn abn, abn abn2) {
        int m_ = abn.m_();
        if (abn2.m_() != m_) {
            return false;
        }
        for (int i = 0; i < m_; i++) {
            if (!abn.j6(i).equals(abn2.j6(i))) {
                return false;
            }
        }
        return true;
    }

    public static int DW(abn abn, abn abn2) {
        int m_ = abn.m_();
        int m_2 = abn2.m_();
        int min = Math.min(m_, m_2);
        for (int i = 0; i < min; i++) {
            int j6 = abn.j6(i).j6(abn2.j6(i));
            if (j6 != 0) {
                return j6;
            }
        }
        if (m_ == m_2) {
            return 0;
        }
        if (m_ < m_2) {
            return -1;
        }
        return 1;
    }

    public abk(int i) {
        super(i);
    }

    public abl j6(int i) {
        return DW(i);
    }

    public int v5() {
        int i = 0;
        int i2 = 0;
        while (i < m_()) {
            i2 += DW(i).tp();
            i++;
        }
        return i2;
    }

    public abn j6(abl abl) {
        int m_ = m_();
        abn abk = new abk(m_ + 1);
        for (int i = 0; i < m_; i++) {
            abk.j6(i, v5(i));
        }
        abk.j6(m_, abl);
        abk.l_();
        return abk;
    }

    public abl DW(int i) {
        return (abl) v5(i);
    }

    public void j6(int i, abl abl) {
        j6(i, abl);
    }

    public abk FH(abl abl) {
        int i = 0;
        int m_ = m_();
        abk abk = new abk(m_ + 1);
        abk.j6(0, abl);
        while (i < m_) {
            abk.j6(i + 1, Zo(i));
            i++;
        }
        return abk;
    }
}
