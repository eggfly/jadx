import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

public final class sj {
    private final ru DW;
    private boolean EQ;
    private final int FH;
    private final int Hw;
    private boolean J0;
    private final sa[] VH;
    private final sm Zo;
    private final ArrayList<zi> gn;
    private final ry j6;
    private final abl[] tp;
    private final ArrayList<adg> u7;
    private final sk v5;
    private final sj$b[] we;

    public static aaa j6(ry ryVar, aag aag) {
        try {
            sj sjVar = new sj(ryVar, aag);
            sjVar.u7();
            return sjVar.gn();
        } catch (sl e) {
            e.j6("...while working on method " + ryVar.j6().Hw());
            throw e;
        }
    }

    private sj(ry ryVar, aag aag) {
        if (ryVar == null) {
            throw new NullPointerException("method == null");
        } else if (aag == null) {
            throw new NullPointerException("advice == null");
        } else {
            this.j6 = ryVar;
            this.DW = rs.j6(ryVar);
            this.Hw = this.DW.tp();
            this.FH = ryVar.tp();
            this.v5 = new sk(this, ryVar, aag);
            this.Zo = new sm(this.v5, ryVar);
            this.VH = new sa[this.Hw];
            this.we = new sj$b[this.Hw];
            this.gn = new ArrayList((this.DW.m_() * 2) + 10);
            this.u7 = new ArrayList((this.DW.m_() * 2) + 10);
            this.tp = new abl[this.Hw];
            this.EQ = false;
            this.VH[0] = new sa(this.FH, ryVar.u7());
        }
    }

    int j6() {
        int Zo = Zo();
        return Hw() ? Zo + 1 : Zo;
    }

    private int j6(int i) {
        return this.Hw + i;
    }

    private int DW(int i) {
        return (this.Hw * 2) + (i ^ -1);
    }

    private int DW() {
        return (this.Hw * 2) + 7;
    }

    private int FH() {
        int DW = DW();
        Iterator it = this.gn.iterator();
        int i = DW;
        while (it.hasNext()) {
            DW = ((zi) it.next()).j6();
            if (DW >= i) {
                DW++;
            } else {
                DW = i;
            }
            i = DW;
        }
        return i;
    }

    private boolean Hw() {
        return (this.j6.Hw() & 32) != 0;
    }

    private boolean v5() {
        return (this.j6.Hw() & 8) != 0;
    }

    private int Zo() {
        return this.FH + this.j6.u7();
    }

    private zw VH() {
        int i = 1;
        int Zo = Zo();
        if (Zo >= 1) {
            i = Zo;
        }
        return zw.j6(i, abl.Ws);
    }

    private int FH(int i) {
        int size = this.gn.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((zi) this.gn.get(i2)).j6() == i) {
                return i2;
            }
        }
        return -1;
    }

    private zi Hw(int i) {
        int FH = FH(i);
        if (FH >= 0) {
            return (zi) this.gn.get(FH);
        }
        throw new IllegalArgumentException("no such label " + add.FH(i));
    }

    private void j6(zi ziVar, adg adg) {
        if (ziVar == null) {
            throw new NullPointerException("block == null");
        }
        this.gn.add(ziVar);
        adg.J0();
        this.u7.add(adg);
    }

    private boolean DW(zi ziVar, adg adg) {
        if (ziVar == null) {
            throw new NullPointerException("block == null");
        }
        boolean z;
        int FH = FH(ziVar.j6());
        if (FH < 0) {
            z = false;
        } else {
            v5(FH);
            z = true;
        }
        this.gn.add(ziVar);
        adg.J0();
        this.u7.add(adg);
        return z;
    }

    private boolean FH(zi ziVar, adg adg) {
        if (ziVar == null) {
            throw new NullPointerException("block == null");
        }
        boolean z;
        int FH = FH(ziVar.j6());
        if (FH < 0) {
            z = false;
        } else {
            this.gn.remove(FH);
            this.u7.remove(FH);
            z = true;
        }
        this.gn.add(ziVar);
        adg.J0();
        this.u7.add(adg);
        return z;
    }

    private void v5(int i) {
        int DW = DW();
        adg FH = ((zi) this.gn.get(i)).FH();
        int DW2 = FH.DW();
        this.gn.remove(i);
        this.u7.remove(i);
        for (int i2 = 0; i2 < DW2; i2++) {
            int DW3 = FH.DW(i2);
            if (DW3 >= DW) {
                int FH2 = FH(DW3);
                if (FH2 < 0) {
                    throw new RuntimeException("Invalid label " + add.FH(DW3));
                }
                v5(FH2);
            }
        }
    }

    private aaa gn() {
        int size = this.gn.size();
        zj zjVar = new zj(size);
        for (int i = 0; i < size; i++) {
            zjVar.j6(i, (zi) this.gn.get(i));
        }
        zjVar.l_();
        return new aaa(zjVar, DW(-1));
    }

    private void u7() {
        int[] j6 = act.j6(this.Hw);
        act.DW(j6, 0);
        EQ();
        tp();
        while (true) {
            int Hw = act.Hw(j6, 0);
            if (Hw < 0) {
                break;
            }
            act.FH(j6, Hw);
            try {
                j6(this.DW.DW(Hw), this.VH[Hw], j6);
            } catch (sl e) {
                e.j6("...while working on block " + add.FH(Hw));
                throw e;
            }
        }
        we();
        J0();
        J8();
        if (this.J0) {
            Ws();
        }
    }

    private void tp() {
        this.VH[0].j6(this.j6.VH().FH());
        this.VH[0].DW();
    }

    private void j6(rt rtVar, sa saVar, int[] iArr) {
        int i;
        int DW;
        adg adg;
        int DW2;
        int i2;
        adg j6;
        Object obj;
        adg adg2;
        int FH;
        zo zoVar;
        rv v5 = rtVar.v5();
        this.v5.j6(v5.j_());
        sa j62 = saVar.j6();
        this.Zo.j6(rtVar, j62);
        j62.DW();
        int j3 = this.v5.j3();
        ArrayList J0 = this.v5.J0();
        int size = J0.size();
        int m_ = v5.m_();
        adg Hw = rtVar.Hw();
        sj$b sj_b = null;
        if (this.v5.U2()) {
            i = 1;
            DW = Hw.DW(1);
            if (this.we[DW] == null) {
                this.we[DW] = new sj$b(this, DW);
            }
            this.we[DW].DW(rtVar.j6());
            sj_b = this.we[DW];
            adg = Hw;
        } else if (this.v5.a8()) {
            i = this.v5.lg().VH();
            if (this.we[i] == null) {
                this.we[i] = new sj$b(this, i, rtVar.j6());
            } else {
                this.we[i].j6(rtVar.j6());
            }
            Hw = this.we[i].DW();
            this.we[i].j6(j62, iArr);
            i = Hw.DW();
            adg = Hw;
        } else if (this.v5.QX()) {
            i = m_;
            adg = Hw;
        } else {
            i = 0;
            adg = Hw;
        }
        int DW3 = adg.DW();
        int i3 = i;
        while (i3 < DW3) {
            DW2 = adg.DW(i3);
            try {
                j6(DW2, rtVar.j6(), sj_b, j62, iArr);
                i3++;
            } catch (sl e) {
                e.j6("...while merging to block " + add.FH(DW2));
                throw e;
            }
        }
        if (DW3 == 0 && this.v5.XL()) {
            i2 = 1;
            j6 = adg.j6(DW(-2));
        } else {
            i2 = DW3;
            j6 = adg;
        }
        if (i2 == 0) {
            DW2 = -1;
        } else {
            i = this.v5.aM();
            if (i >= 0) {
                DW2 = j6.DW(i);
            } else {
                DW2 = i;
            }
        }
        if (Hw() && this.v5.Mr()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && m_ == 0) {
            adg2 = j6;
        } else {
            j6 = new adg(i2);
            i2 = 0;
            int i4 = 0;
            while (i4 < m_) {
                rv$a j63 = v5.j6(i4);
                abf Hw2 = j63.Hw();
                FH = j63.FH();
                int i5 = i2 | (Hw2 == abf.j6 ? 1 : 0);
                try {
                    j6(FH, rtVar.j6(), null, j62.j6(Hw2), iArr);
                    abl abl = this.tp[FH];
                    if (abl == null) {
                        this.tp[FH] = Hw2.u7();
                    } else if (abl != Hw2.u7()) {
                        this.tp[FH] = abl.Ws;
                    }
                    j6.FH(j6(FH));
                    i4++;
                    i2 = i5;
                } catch (sl e2) {
                    e2.j6("...while merging exception to block " + add.FH(FH));
                    throw e2;
                }
            }
            if (obj != null && i2 == 0) {
                j6.FH(DW(-6));
                this.EQ = true;
                for (i4 = (size - j3) - 1; i4 < size; i4++) {
                    zoVar = (zo) J0.get(i4);
                    if (zoVar.EQ()) {
                        J0.set(i4, zoVar.j6(abl.Ws));
                    }
                }
            }
            if (DW2 >= 0) {
                j6.FH(DW2);
            }
            j6.l_();
            adg2 = j6;
        }
        i3 = adg2.Zo(DW2);
        i2 = DW2;
        adg adg3 = adg2;
        DW3 = j3;
        DW2 = size;
        while (DW3 > 0) {
            FH = DW2 - 1;
            zoVar = (zo) J0.get(FH);
            Object obj2 = zoVar.Zo().Hw() == 1 ? 1 : null;
            zp zpVar = new zp(obj2 != null ? 2 : 1);
            zpVar.j6(0, zoVar);
            if (obj2 != null) {
                zpVar.j6(1, new zu(aab.j3, zoVar.VH(), null, zx.j6));
                adg2 = adg.j6(i2);
            } else {
                adg2 = adg3;
            }
            zpVar.l_();
            DW2 = FH();
            j6(new zi(DW2, zpVar, adg2, i2), j62.v5());
            adg3 = adg3.Zo();
            adg3.DW(i3, DW2);
            adg3.l_();
            i2 = DW2;
            DW3--;
            DW2 = FH;
        }
        if (DW2 == 0) {
            zoVar = null;
        } else {
            zoVar = (zo) J0.get(DW2 - 1);
        }
        if (zoVar == null || zoVar.Zo().Hw() == 1) {
            J0.add(new zu(aab.j3, zoVar == null ? aac.j6 : zoVar.VH(), null, zx.j6));
            DW2++;
        }
        zp zpVar2 = new zp(DW2);
        for (DW = 0; DW < DW2; DW++) {
            zpVar2.j6(DW, (zo) J0.get(DW));
        }
        zpVar2.l_();
        DW(new zi(rtVar.j6(), zpVar2, adg3, i2), j62.v5());
    }

    private void j6(int i, int i2, sj$b sj_b, sa saVar, int[] iArr) {
        sa saVar2 = this.VH[i];
        if (saVar2 != null) {
            sa j6;
            if (sj_b != null) {
                j6 = saVar2.j6(saVar, sj_b.j6(), i2);
            } else {
                j6 = saVar2.j6(saVar);
            }
            if (j6 != saVar2) {
                this.VH[i] = j6;
                act.DW(iArr, i);
                return;
            }
            return;
        }
        if (sj_b != null) {
            this.VH[i] = saVar.DW(i, i2);
        } else {
            this.VH[i] = saVar;
        }
        act.DW(iArr, i);
    }

    private void EQ() {
        sc J0 = this.j6.J0();
        aac j6 = this.j6.j6(0);
        abk FH = this.j6.VH().FH();
        int m_ = FH.m_();
        zp zpVar = new zp(m_ + 1);
        int i = 0;
        int i2 = 0;
        while (i < m_) {
            zw j62;
            abm DW = FH.DW(i);
            sc$a j63 = J0.j6(0, i2);
            if (j63 == null) {
                j62 = zw.j6(i2, DW);
            } else {
                j62 = zw.DW(i2, DW, j63.j6());
            }
            zpVar.j6(i, new zt(aab.DW(DW), j6, j62, zx.j6, aat.j6(i2)));
            i++;
            i2 += DW.tp();
        }
        zpVar.j6(m_, new zu(aab.j3, j6, null, zx.j6));
        zpVar.l_();
        boolean Hw = Hw();
        if (Hw) {
            i = DW(-4);
        } else {
            i = 0;
        }
        j6(new zi(DW(-1), zpVar, adg.j6(i), i), adg.j6);
        if (Hw) {
            zp zpVar2;
            zw VH = VH();
            if (v5()) {
                zo aae = new aae(aab.XL, j6, zx.j6, abk.j6, this.j6.Zo());
                zp zpVar3 = new zp(1);
                zpVar3.j6(0, aae);
                zpVar2 = zpVar3;
            } else {
                zp zpVar4 = new zp(2);
                zpVar4.j6(0, new zt(aab.we, j6, VH, zx.j6, aat.DW));
                zpVar4.j6(1, new zu(aab.j3, j6, null, zx.j6));
                zpVar2 = zpVar4;
            }
            int DW2 = DW(-5);
            zpVar2.l_();
            j6(new zi(i, zpVar2, adg.j6(DW2), DW2), adg.j6);
            zp zpVar5 = new zp(v5() ? 2 : 1);
            if (v5()) {
                zpVar5.j6(0, new zu(aab.v5((abm) VH), j6, VH, zx.j6));
            }
            zpVar5.j6(v5() ? 1 : 0, new aaf(aab.dW, j6, zx.j6(VH), abk.j6));
            zpVar5.l_();
            j6(new zi(DW2, zpVar5, adg.j6(0), 0), adg.j6);
        }
    }

    private void we() {
        zz J8 = this.v5.J8();
        if (J8 != null) {
            zp zpVar;
            int DW;
            zx zxVar;
            aac Ws = this.v5.Ws();
            int DW2 = DW(-2);
            if (Hw()) {
                zpVar = new zp(1);
                zpVar.j6(0, new aaf(aab.Yi, Ws, zx.j6(VH()), abk.j6));
                zpVar.l_();
                DW = DW(-3);
                j6(new zi(DW2, zpVar, adg.j6(DW), DW), adg.j6);
            } else {
                DW = DW2;
            }
            zpVar = new zp(1);
            abn FH = J8.FH();
            if (FH.m_() == 0) {
                zxVar = zx.j6;
            } else {
                zxVar = zx.j6(zw.j6(0, FH.j6(0)));
            }
            zpVar.j6(0, new zu(J8, Ws, null, zxVar));
            zpVar.l_();
            j6(new zi(DW, zpVar, adg.j6, -1), adg.j6);
        }
    }

    private void J0() {
        if (this.EQ) {
            aac j6 = this.j6.j6(0);
            zw j62 = zw.j6(0, abl.aM);
            zp zpVar = new zp(2);
            zpVar.j6(0, new zu(aab.FH(abl.aM), j6, j62, zx.j6));
            zpVar.j6(1, new aaf(aab.Yi, j6, zx.j6(VH()), abk.j6));
            zpVar.l_();
            int DW = DW(-7);
            j6(new zi(DW(-6), zpVar, adg.j6(DW), DW), adg.j6);
            zpVar = new zp(1);
            zpVar.j6(0, new aaf(aab.GK, j6, zx.j6(j62), abk.j6));
            zpVar.l_();
            j6(new zi(DW, zpVar, adg.j6, -1), adg.j6);
        }
    }

    private void J8() {
        int length = this.tp.length;
        for (int i = 0; i < length; i++) {
            abm abm = this.tp[i];
            if (abm != null) {
                aac VH = Hw(i).Zo().VH();
                zp zpVar = new zp(2);
                zpVar.j6(0, new zu(aab.FH(abm), VH, zw.j6(this.FH, abm), zx.j6));
                zpVar.j6(1, new zu(aab.j3, VH, null, zx.j6));
                zpVar.l_();
                j6(new zi(j6(i), zpVar, adg.j6(i), i), this.VH[i].v5());
            }
        }
    }

    private boolean j6(zi ziVar) {
        boolean z = true;
        adg FH = ziVar.FH();
        if (FH.DW() < 2) {
            return false;
        }
        int DW = FH.DW(1);
        if (DW >= this.we.length || this.we[DW] == null) {
            z = false;
        }
        return z;
    }

    private void Ws() {
        int i;
        int i2 = 0;
        adg adg = new adg(4);
        j6(0, new sj$1(this, adg));
        int FH = FH();
        ArrayList arrayList = new ArrayList(FH);
        for (i = 0; i < FH; i++) {
            arrayList.add(null);
        }
        for (int i3 = 0; i3 < this.gn.size(); i3++) {
            zi ziVar = (zi) this.gn.get(i3);
            if (ziVar != null) {
                arrayList.set(ziVar.j6(), (adg) this.u7.get(i3));
            }
        }
        i = adg.DW();
        while (i2 < i) {
            new sj$c(this, new sj$a(FH()), arrayList).j6(Hw(adg.DW(i2)));
            i2++;
        }
        QX();
    }

    private void QX() {
        adg adg = new adg(this.gn.size());
        this.u7.clear();
        j6(DW(-1), new sj$2(this, adg));
        adg.VH();
        for (int size = this.gn.size() - 1; size >= 0; size--) {
            if (adg.Zo(((zi) this.gn.get(size)).j6()) < 0) {
                this.gn.remove(size);
            }
        }
    }

    private sj$b Zo(int i) {
        for (int length = this.we.length - 1; length >= 0; length--) {
            if (this.we[length] != null) {
                sj$b sj_b = this.we[length];
                if (sj_b.FH.get(i)) {
                    return sj_b;
                }
            }
        }
        return null;
    }

    private zp j6(zp zpVar) {
        int i = 0;
        int m_ = zpVar.m_();
        int i2 = 0;
        for (int i3 = 0; i3 < m_; i3++) {
            if (zpVar.j6(i3).Zo() != aab.VH) {
                i2++;
            }
        }
        if (i2 == m_) {
            return zpVar;
        }
        zp zpVar2 = new zp(i2);
        int i4 = 0;
        while (i4 < m_) {
            zo j6 = zpVar.j6(i4);
            if (j6.Zo() != aab.VH) {
                i2 = i + 1;
                zpVar2.j6(i, j6);
            } else {
                i2 = i;
            }
            i4++;
            i = i2;
        }
        zpVar2.l_();
        return zpVar2;
    }

    private void j6(int i, zi$a zi_a) {
        j6(Hw(i), zi_a, new BitSet(this.Hw));
    }

    private void j6(zi ziVar, zi$a zi_a, BitSet bitSet) {
        zi_a.j6(ziVar);
        bitSet.set(ziVar.j6());
        adg FH = ziVar.FH();
        int DW = FH.DW();
        int i = 0;
        while (i < DW) {
            int DW2 = FH.DW(i);
            if (!bitSet.get(DW2) && (!j6(ziVar) || i <= 0)) {
                DW2 = FH(DW2);
                if (DW2 >= 0) {
                    j6((zi) this.gn.get(DW2), zi_a, bitSet);
                }
            }
            i++;
        }
    }
}
