import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public final class acj {
    private int DW;
    private ArrayList<aci>[] EQ;
    private int FH;
    private int Hw;
    private boolean J0;
    private int VH;
    private int Zo;
    private final int gn;
    private ArrayList<acg> j6;
    private aci[] tp;
    private final boolean u7;
    private int v5;
    private List<aci>[] we;

    public static acj j6(aaa aaa, int i, boolean z) {
        acj acj = new acj(aaa, i, z);
        acj.j6(aaa);
        return acj;
    }

    private acj(aaa aaa, int i, boolean z) {
        this.gn = i;
        this.u7 = z;
        this.J0 = false;
        this.VH = aaa.j6().tp();
        this.Hw = aaa.j6().v5();
        this.v5 = this.Hw;
    }

    static BitSet j6(zj zjVar, adg adg) {
        BitSet bitSet = new BitSet(zjVar.m_());
        int DW = adg.DW();
        for (int i = 0; i < DW; i++) {
            bitSet.set(zjVar.FH(adg.DW(i)));
        }
        return bitSet;
    }

    public static adg DW(zj zjVar, adg adg) {
        adg adg2 = new adg(adg.DW());
        int DW = adg.DW();
        for (int i = 0; i < DW; i++) {
            adg2.FH(zjVar.FH(adg.DW(i)));
        }
        return adg2;
    }

    private void j6(aaa aaa) {
        int m_ = aaa.j6().m_();
        this.j6 = new ArrayList(m_ + 2);
        for (int i = 0; i < m_; i++) {
            this.j6.add(acg.j6(aaa, i, this));
        }
        this.DW = ((acg) this.j6.get(aaa.j6().FH(aaa.DW()))).QX().v5();
        this.FH = -1;
    }

    void j6() {
        if (this.FH >= 0) {
            throw new RuntimeException("must be called at most once");
        }
        this.FH = this.j6.size();
        int i = this.FH;
        int i2 = this.VH;
        this.VH = i2 + 1;
        acg acg = new acg(i, i2, this);
        this.j6.add(acg);
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            ((acg) it.next()).FH(acg);
        }
        if (acg.gn().cardinality() == 0) {
            this.j6.remove(this.FH);
            this.FH = -1;
            this.VH--;
        }
    }

    private static aci j6(acg acg) {
        return new abz(new zu(aab.j3, aac.j6, null, zx.j6), acg);
    }

    public acg DW() {
        int size = this.j6.size();
        int i = this.VH;
        this.VH = i + 1;
        acg acg = new acg(size, i, this);
        acg.FH().add(j6(acg));
        this.j6.add(acg);
        return acg;
    }

    public int FH() {
        return this.DW;
    }

    public acg Hw() {
        return (acg) this.j6.get(this.DW);
    }

    public int v5() {
        return this.FH;
    }

    public acg Zo() {
        return this.FH < 0 ? null : (acg) this.j6.get(this.FH);
    }

    public int j6(int i) {
        if (i < 0) {
            return -1;
        }
        return ((acg) this.j6.get(i)).Zo();
    }

    public int VH() {
        return this.Hw;
    }

    public int gn() {
        return this.gn;
    }

    public int DW(int i) {
        int i2 = this.v5 + this.Zo;
        this.Zo += i;
        this.Hw = Math.max(this.Hw, i2 + i);
        return i2;
    }

    public void u7() {
        this.Zo = 0;
    }

    public ArrayList<acg> tp() {
        return this.j6;
    }

    public int EQ() {
        Iterator it = this.j6.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            if (((acg) it.next()).j3()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public void we() {
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            ((acg) it.next()).v5(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Hw());
        while (!arrayList.isEmpty()) {
            acg acg = (acg) arrayList.remove(0);
            if (!acg.j3()) {
                acg.v5(1);
                BitSet u7 = acg.u7();
                for (int nextSetBit = u7.nextSetBit(0); nextSetBit >= 0; nextSetBit = u7.nextSetBit(nextSetBit + 1)) {
                    arrayList.add(this.j6.get(nextSetBit));
                }
            }
        }
    }

    public void j6(acd acd) {
        Iterator it = tp().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((acg) it.next()).FH().iterator();
            while (it2.hasNext()) {
                ((aci) it2.next()).DW(acd);
            }
        }
        this.Hw = acd.j6();
        this.v5 = this.Hw;
    }

    public aci FH(int i) {
        if (this.J0) {
            throw new RuntimeException("No def list in back mode");
        } else if (this.tp != null) {
            return this.tp[i];
        } else {
            this.tp = new aci[VH()];
            j6(new acj$1(this));
            return this.tp[i];
        }
    }

    private void XL() {
        int i = 0;
        if (this.J0) {
            throw new RuntimeException("No use list in back mode");
        }
        this.EQ = new ArrayList[this.Hw];
        for (int i2 = 0; i2 < this.Hw; i2++) {
            this.EQ[i2] = new ArrayList();
        }
        j6(new acj$2(this));
        this.we = new List[this.Hw];
        while (i < this.Hw) {
            this.we[i] = Collections.unmodifiableList(this.EQ[i]);
            i++;
        }
    }

    void j6(aci aci, zw zwVar, zw zwVar2) {
        if (this.EQ != null) {
            if (zwVar != null) {
                this.EQ[zwVar.VH()].remove(aci);
            }
            int VH = zwVar2.VH();
            if (this.EQ.length <= VH) {
                this.EQ = null;
            } else {
                this.EQ[VH].add(aci);
            }
        }
    }

    void j6(aci aci, zx zxVar) {
        if (this.EQ != null) {
            if (zxVar != null) {
                DW(aci, zxVar);
            }
            zx DW = aci.DW();
            int m_ = DW.m_();
            for (int i = 0; i < m_; i++) {
                this.EQ[DW.DW(i).VH()].add(aci);
            }
        }
    }

    private void DW(aci aci, zx zxVar) {
        if (zxVar != null) {
            int m_ = zxVar.m_();
            int i = 0;
            while (i < m_) {
                if (this.EQ[zxVar.DW(i).VH()].remove(aci)) {
                    i++;
                } else {
                    throw new RuntimeException("use not found");
                }
            }
        }
    }

    void j6(aci aci) {
        j6(aci, null);
        j6(aci, null);
    }

    void DW(aci aci) {
        if (this.EQ != null) {
            DW(aci, aci.DW());
        }
        zw Ws = aci.Ws();
        if (this.tp != null && Ws != null) {
            this.tp[Ws.VH()] = null;
        }
    }

    public void J0() {
        this.tp = null;
        this.EQ = null;
        this.we = null;
    }

    void j6(aci aci, zw zwVar) {
        if (this.tp != null) {
            if (zwVar != null) {
                this.tp[zwVar.VH()] = null;
            }
            zw Ws = aci.Ws();
            if (Ws != null) {
                if (this.tp[Ws.VH()] != null) {
                    throw new RuntimeException("Duplicate add of insn");
                }
                this.tp[Ws.VH()] = aci;
            }
        }
    }

    public List<aci> Hw(int i) {
        if (this.we == null) {
            XL();
        }
        return this.we[i];
    }

    public ArrayList<aci>[] J8() {
        if (this.EQ == null) {
            XL();
        }
        ArrayList[] arrayListArr = new ArrayList[this.Hw];
        for (int i = 0; i < this.Hw; i++) {
            arrayListArr[i] = new ArrayList(this.EQ[i]);
        }
        return arrayListArr;
    }

    public boolean j6(zw zwVar) {
        aci FH = FH(zwVar.VH());
        if (FH == null) {
            return false;
        }
        if (FH.VH() != null) {
            return true;
        }
        for (aci FH2 : Hw(zwVar.VH())) {
            zo Zo = FH2.Zo();
            if (Zo != null && Zo.Zo().j6() == 54) {
                return true;
            }
        }
        return false;
    }

    void v5(int i) {
        this.Hw = i;
        this.v5 = this.Hw;
        J0();
    }

    public int Ws() {
        int i = this.Hw;
        this.Hw = i + 1;
        this.v5 = this.Hw;
        J0();
        return i;
    }

    public void j6(aci$a aci_a) {
        Iterator it = this.j6.iterator();
        while (it.hasNext()) {
            ((acg) it.next()).j6(aci_a);
        }
    }

    public void j6(boolean z, acg$b acg_b) {
        BitSet bitSet = new BitSet(this.j6.size());
        Stack stack = new Stack();
        Object Zo = z ? Zo() : Hw();
        if (Zo != null) {
            stack.add(null);
            stack.add(Zo);
            while (stack.size() > 0) {
                acg acg = (acg) stack.pop();
                acg acg2 = (acg) stack.pop();
                if (!bitSet.get(acg.v5())) {
                    BitSet gn = z ? acg.gn() : acg.u7();
                    for (int nextSetBit = gn.nextSetBit(0); nextSetBit >= 0; nextSetBit = gn.nextSetBit(nextSetBit + 1)) {
                        stack.add(acg);
                        stack.add(this.j6.get(nextSetBit));
                    }
                    bitSet.set(acg.v5());
                    acg_b.j6(acg, acg2);
                }
            }
        }
    }

    public void j6(acg$b acg_b) {
        BitSet bitSet = new BitSet(tp().size());
        Stack stack = new Stack();
        stack.add(Hw());
        while (stack.size() > 0) {
            acg acg = (acg) stack.pop();
            ArrayList j6 = acg.j6();
            if (!bitSet.get(acg.v5())) {
                for (int size = j6.size() - 1; size >= 0; size--) {
                    stack.add((acg) j6.get(size));
                }
                bitSet.set(acg.v5());
                acg_b.j6(acg, null);
            }
        }
    }

    public void j6(Set<aci> set) {
        Iterator it = tp().iterator();
        while (it.hasNext()) {
            int size;
            acg acg = (acg) it.next();
            ArrayList FH = acg.FH();
            for (size = FH.size() - 1; size >= 0; size--) {
                aci aci = (aci) FH.get(size);
                if (set.contains(aci)) {
                    DW(aci);
                    FH.remove(size);
                }
            }
            size = FH.size();
            if (size == 0) {
                aci = null;
            } else {
                aci = (aci) FH.get(size - 1);
            }
            if (acg != Zo() && (size == 0 || r1.Zo() == null || r1.Zo().Zo().Hw() == 1)) {
                FH.add(aci.j6(new zu(aab.j3, aac.j6, null, zx.j6), acg));
                BitSet u7 = acg.u7();
                for (int nextSetBit = u7.nextSetBit(0); nextSetBit >= 0; nextSetBit = u7.nextSetBit(nextSetBit + 1)) {
                    if (nextSetBit != acg.EQ()) {
                        acg.DW(nextSetBit);
                    }
                }
            }
        }
    }

    public void QX() {
        this.J0 = true;
        this.EQ = null;
        this.tp = null;
    }
}
