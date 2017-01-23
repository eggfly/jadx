import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class acl extends acp {
    private final BitSet EQ;
    private final Map<zq, ArrayList<zw>> FH;
    private final ArrayList<abz> Hw;
    private final BitSet VH;
    private final ArrayList<acb> Zo;
    private final abu gn;
    private final BitSet tp;
    private final int u7;
    private final ArrayList<abz> v5;
    private final boolean we;

    public acl(acj acj, acn acn, boolean z) {
        super(acj, acn);
        this.VH = new BitSet(acj.VH());
        this.gn = new abu(acn, acj.VH());
        this.we = z;
        this.u7 = acj.gn();
        this.tp = new BitSet(this.u7 * 2);
        this.tp.set(0, this.u7);
        this.EQ = new BitSet(this.u7 * 2);
        this.FH = new TreeMap();
        this.Hw = new ArrayList();
        this.v5 = new ArrayList();
        this.Zo = new ArrayList();
    }

    public boolean j6() {
        return true;
    }

    public acd DW() {
        tp();
        FH();
        v5();
        Zo();
        Hw();
        VH();
        gn();
        u7();
        return this.gn;
    }

    private void FH() {
        for (ArrayList arrayList : this.FH.values()) {
            int size = arrayList.size();
            int i = -1;
            int i2 = 0;
            while (i2 < size) {
                zw zwVar = (zw) arrayList.get(i2);
                int DW = DW(zwVar.VH());
                if (DW >= 0) {
                    i2 = zwVar.EQ();
                    DW(zwVar, DW);
                    i = i2;
                    i2 = DW;
                    break;
                }
                i2++;
                i = DW;
            }
            i2 = i;
            i = 0;
            if (i2 >= 0) {
                j6(arrayList, i2, i, true);
            }
        }
    }

    private int DW(int i) {
        aci FH = this.j6.FH(i);
        if (FH == null) {
            return -1;
        }
        zz v5 = FH.v5();
        if (v5 == null || v5.j6() != 3) {
            return -1;
        }
        return ((aat) ((zk) FH.Zo()).p_()).r_();
    }

    private void Hw() {
        for (ArrayList arrayList : this.FH.values()) {
            boolean z = false;
            int i = this.u7;
            while (true) {
                boolean j6;
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 1;
                while (i2 < size) {
                    int i4;
                    zw zwVar = (zw) arrayList.get(i2);
                    int EQ = zwVar.EQ();
                    if (this.VH.get(zwVar.VH()) || EQ <= i3) {
                        i4 = i3;
                    } else {
                        i4 = EQ;
                    }
                    i2++;
                    i3 = i4;
                }
                i = Hw(i, i3);
                if (j6(arrayList, i)) {
                    j6 = j6(arrayList, i, i3, true);
                } else {
                    j6 = z;
                }
                int i5 = i + 1;
                if (!j6) {
                    i = i5;
                    z = j6;
                }
            }
        }
    }

    private boolean j6(ArrayList<zw> arrayList, int i, int i2, boolean z) {
        Iterator it = arrayList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            zw zwVar = (zw) it.next();
            if (!this.VH.get(zwVar.VH())) {
                boolean j6 = j6(zwVar, i, i2);
                if (!j6 || z2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (j6 && z) {
                    j6(i, zwVar.EQ());
                }
            }
        }
        if (z2) {
            return false;
        }
        return true;
    }

    private boolean j6(zw zwVar, int i, int i2) {
        if (zwVar.EQ() > i2 || this.VH.get(zwVar.VH()) || !j6(zwVar, i)) {
            return false;
        }
        DW(zwVar, i);
        return true;
    }

    private void j6(int i, int i2) {
        this.tp.set(i, i + i2, true);
    }

    private boolean DW(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (this.tp.get(i3)) {
                return true;
            }
        }
        return false;
    }

    private int FH(int i, int i2) {
        int nextClearBit = this.tp.nextClearBit(i);
        while (true) {
            int i3 = 1;
            while (i3 < i2 && !this.tp.get(nextClearBit + i3)) {
                i3++;
            }
            if (i3 == i2) {
                return nextClearBit;
            }
            nextClearBit = this.tp.nextClearBit(nextClearBit + i3);
        }
    }

    private int Hw(int i, int i2) {
        int nextClearBit = this.EQ.nextClearBit(i);
        while (true) {
            int i3 = 1;
            while (i3 < i2 && !this.EQ.get(nextClearBit + i3)) {
                i3++;
            }
            if (i3 == i2) {
                return nextClearBit;
            }
            nextClearBit = this.EQ.nextClearBit(nextClearBit + i3);
        }
    }

    private void v5() {
        int VH = this.j6.VH();
        for (int i = 0; i < VH; i++) {
            if (!this.VH.get(i)) {
                int DW = DW(i);
                zw j6 = j6(i);
                if (DW >= 0) {
                    DW(j6, DW);
                }
            }
        }
    }

    private void Zo() {
        Iterator it = this.v5.iterator();
        while (it.hasNext()) {
            j6((abz) it.next());
        }
    }

    private void VH() {
        Iterator it = this.Hw.iterator();
        while (it.hasNext()) {
            abz abz = (abz) it.next();
            zw Ws = abz.Ws();
            int VH = Ws.VH();
            BitSet gn = abz.QX().gn();
            if (gn.cardinality() == 1) {
                ArrayList FH = ((acg) this.j6.tp().get(gn.nextSetBit(0))).FH();
                aci aci = (aci) FH.get(FH.size() - 1);
                if (aci.v5().j6() == 43) {
                    int j6;
                    int i;
                    zw DW = aci.DW().DW(0);
                    int VH2 = DW.VH();
                    int EQ = DW.EQ();
                    boolean z = this.VH.get(VH);
                    boolean z2 = this.VH.get(VH2);
                    if (((!z2 ? 1 : 0) & z) != 0) {
                        j6 = j6(DW, this.gn.j6(VH), EQ);
                    } else {
                        boolean z3 = z2;
                    }
                    if (z) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if ((i & j6) != 0) {
                        z = j6(Ws, this.gn.j6(VH2), EQ);
                    }
                    if (!z || j6 == 0) {
                        int FH2 = FH(this.u7, EQ);
                        ArrayList arrayList = new ArrayList(2);
                        arrayList.add(Ws);
                        arrayList.add(DW);
                        while (!j6(arrayList, FH2, EQ, false)) {
                            FH2 = FH(FH2 + 1, EQ);
                        }
                    }
                    z = aci.Zo().DW().m_() != 0;
                    i = this.gn.j6(VH);
                    if (!(i == this.gn.j6(VH2) || z)) {
                        ((abz) aci).j6(0, j6(aci, DW));
                        DW(aci.DW().DW(0), i);
                    }
                }
            }
        }
    }

    private void gn() {
        Iterator it = this.Zo.iterator();
        while (it.hasNext()) {
            j6((acb) it.next());
        }
    }

    private void u7() {
        int VH = this.j6.VH();
        for (int i = 0; i < VH; i++) {
            if (!this.VH.get(i)) {
                zw j6 = j6(i);
                if (j6 != null) {
                    int EQ = j6.EQ();
                    int FH = FH(this.u7, EQ);
                    while (!j6(j6, FH)) {
                        FH = FH(FH + 1, EQ);
                    }
                    DW(j6, FH);
                }
            }
        }
    }

    private boolean j6(ArrayList<zw> arrayList, int i) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zw zwVar = (zw) it.next();
            if (!this.VH.get(zwVar.VH()) && !j6(zwVar, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean j6(zw zwVar, int i) {
        return (v5(i, zwVar.EQ()) || this.gn.j6(zwVar, i)) ? false : true;
    }

    private boolean v5(int i, int i2) {
        return i < this.u7 && i + i2 > this.u7;
    }

    private void tp() {
        this.j6.j6(new acl$1(this));
    }

    private void DW(zw zwVar, int i) {
        int VH = zwVar.VH();
        if (this.VH.get(VH) || !j6(zwVar, i)) {
            throw new RuntimeException("attempt to add invalid register mapping");
        }
        int EQ = zwVar.EQ();
        this.gn.j6(zwVar.VH(), i, EQ);
        this.VH.set(VH);
        this.EQ.set(i, EQ + i);
    }

    private void j6(abz abz) {
        int DW = DW(abz);
        zx DW2 = abz.DW();
        int m_ = DW2.m_();
        int i = 0;
        int i2 = DW;
        while (i < m_) {
            zw DW3 = DW2.DW(i);
            int VH = DW3.VH();
            int EQ = DW3.EQ();
            int i3 = i2 + EQ;
            if (!this.VH.get(VH)) {
                zq FH = FH(VH);
                DW(DW3, i2);
                if (FH != null) {
                    j6(i2, EQ);
                    ArrayList arrayList = (ArrayList) this.FH.get(FH);
                    int size = arrayList.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        zw zwVar = (zw) arrayList.get(i4);
                        if (-1 == DW2.FH(zwVar.VH())) {
                            j6(zwVar, i2, EQ);
                        }
                    }
                }
            }
            i++;
            i2 = i3;
        }
    }

    private int DW(abz abz) {
        zx DW = abz.DW();
        int m_ = DW.m_();
        int[] iArr = new int[m_];
        int i = 0;
        int i2 = 0;
        while (i < m_) {
            iArr[i] = DW.DW(i).EQ();
            i++;
            i2 = iArr[i] + i2;
        }
        int i3 = 0;
        BitSet bitSet = null;
        int i4 = -1;
        int i5 = Integer.MIN_VALUE;
        for (int i6 = 0; i6 < m_; i6++) {
            int VH = DW.DW(i6).VH();
            if (i6 != 0) {
                i3 -= iArr[i6 - 1];
            }
            if (this.VH.get(VH)) {
                int j6 = this.gn.j6(VH) + i3;
                if (j6 >= 0 && !v5(j6, i2)) {
                    BitSet bitSet2 = new BitSet(m_);
                    int j62 = j6(j6, abz, iArr, bitSet2);
                    if (j62 >= 0) {
                        int cardinality = j62 - bitSet2.cardinality();
                        if (cardinality > i5) {
                            bitSet = bitSet2;
                            i4 = j6;
                            i5 = cardinality;
                        }
                        if (j62 == i2) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (i4 == -1) {
            bitSet = new BitSet(m_);
            i4 = j6(abz, i2, iArr, bitSet);
        }
        for (i5 = bitSet.nextSetBit(0); i5 >= 0; i5 = bitSet.nextSetBit(i5 + 1)) {
            abz.j6(i5, j6(abz, DW.DW(i5)));
        }
        return i4;
    }

    private int j6(abz abz, int i, int[] iArr, BitSet bitSet) {
        int i2 = this.u7;
        while (true) {
            i2 = FH(i2, i);
            if (j6(i2, abz, iArr, bitSet) >= 0) {
                return i2;
            }
            i2++;
            bitSet.clear();
        }
    }

    private int j6(int i, abz abz, int[] iArr, BitSet bitSet) {
        zx DW = abz.DW();
        int m_ = DW.m_();
        int i2 = 0;
        zx j6 = j6(abz.QX().XL());
        BitSet bitSet2 = new BitSet(this.j6.VH());
        int i3 = i;
        for (int i4 = 0; i4 < m_; i4++) {
            zw DW2 = DW.DW(i4);
            int VH = DW2.VH();
            int i5 = iArr[i4];
            if (i4 != 0) {
                i3 += iArr[i4 - 1];
            }
            if (this.VH.get(VH) && this.gn.j6(VH) == i3) {
                i2 += i5;
            } else if (DW(i3, i5)) {
                return -1;
            } else {
                if (!this.VH.get(VH) && j6(DW2, i3) && !bitSet2.get(VH)) {
                    i2 += i5;
                } else if (this.gn.j6(j6, i3, i5) || this.gn.j6(DW, i3, i5)) {
                    return -1;
                } else {
                    bitSet.set(i4);
                }
            }
            bitSet2.set(VH);
        }
        return i2;
    }

    zx j6(adh adh) {
        zx zxVar = new zx(adh.j6());
        adf DW = adh.DW();
        int i = 0;
        while (DW.j6()) {
            int i2 = i + 1;
            zxVar.j6(i, j6(DW.DW()));
            i = i2;
        }
        return zxVar;
    }

    private zq FH(int i) {
        for (Entry entry : this.FH.entrySet()) {
            Iterator it = ((ArrayList) entry.getValue()).iterator();
            while (it.hasNext()) {
                if (((zw) it.next()).VH() == i) {
                    return (zq) entry.getKey();
                }
            }
        }
        return null;
    }

    private void j6(acb acb) {
        int i;
        zw Ws = acb.Ws();
        int VH = Ws.VH();
        int EQ = Ws.EQ();
        zx DW = acb.DW();
        int m_ = DW.m_();
        ArrayList arrayList = new ArrayList();
        acl$a acl_a = new acl$a(m_ + 1);
        if (this.VH.get(VH)) {
            acl_a.j6(this.gn.j6(VH));
        } else {
            arrayList.add(Ws);
        }
        for (i = 0; i < m_; i++) {
            zw Ws2 = this.j6.FH(DW.DW(i).VH()).Ws();
            int VH2 = Ws2.VH();
            if (this.VH.get(VH2)) {
                acl_a.j6(this.gn.j6(VH2));
            } else {
                arrayList.add(Ws2);
            }
        }
        for (i = 0; i < acl_a.DW(); i++) {
            j6(arrayList, acl_a.j6(), EQ, false);
        }
        i = FH(this.u7, EQ);
        while (!j6(arrayList, i, EQ, false)) {
            i = FH(i + 1, EQ);
        }
    }
}
