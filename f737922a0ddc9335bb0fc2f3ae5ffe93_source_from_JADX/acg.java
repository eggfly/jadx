import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class acg {
    public static final Comparator<acg> j6;
    private ArrayList<aci> DW;
    private int EQ;
    private BitSet FH;
    private BitSet Hw;
    private int J0;
    private adh J8;
    private int VH;
    private adh Ws;
    private int Zo;
    private acj gn;
    private final ArrayList<acg> tp;
    private int u7;
    private adg v5;
    private int we;

    static {
        j6 = new acg$a();
    }

    public acg(int i, int i2, acj acj) {
        this.Zo = -1;
        this.EQ = 0;
        this.we = 0;
        this.J0 = -1;
        this.gn = acj;
        this.u7 = i;
        this.DW = new ArrayList();
        this.VH = i2;
        this.FH = new BitSet(acj.tp().size());
        this.Hw = new BitSet(acj.tp().size());
        this.v5 = new adg();
        this.tp = new ArrayList();
    }

    public static acg j6(aaa aaa, int i, acj acj) {
        int i2;
        zj j6 = aaa.j6();
        zi j62 = j6.j6(i);
        acg acg = new acg(i, j62.j6(), acj);
        zp DW = j62.DW();
        acg.DW.ensureCapacity(DW.m_());
        int m_ = DW.m_();
        for (i2 = 0; i2 < m_; i2++) {
            acg.DW.add(new abz(DW.j6(i2), acg));
        }
        acg.FH = acj.j6(j6, aaa.j6(j62.j6()));
        acg.Hw = acj.j6(j6, j62.FH());
        acg.v5 = acj.DW(j6, j62.FH());
        if (acg.v5.DW() != 0) {
            i2 = j62.Hw();
            acg.Zo = i2 < 0 ? -1 : j6.FH(i2);
        }
        return acg;
    }

    public void j6(acg acg) {
        this.tp.add(acg);
    }

    public ArrayList<acg> j6() {
        return this.tp;
    }

    public void j6(int i) {
        this.DW.add(0, new acb(i, this));
    }

    public void j6(zw zwVar) {
        this.DW.add(0, new acb(zwVar, this));
    }

    public void j6(zo zoVar) {
        aci j6 = aci.j6(zoVar, this);
        this.DW.add(U2(), j6);
        this.gn.j6(j6);
    }

    public void DW(zo zoVar) {
        if (zoVar.Zo().Hw() == 1) {
            throw new IllegalArgumentException("last insn must branch");
        }
        aci aci = (aci) this.DW.get(this.DW.size() - 1);
        aci j6 = aci.j6(zoVar, this);
        this.DW.set(this.DW.size() - 1, j6);
        this.gn.DW(aci);
        this.gn.j6(j6);
    }

    public void j6(acb$b acb_b) {
        int size = this.DW.size();
        int i = 0;
        while (i < size) {
            aci aci = (aci) this.DW.get(i);
            if (aci instanceof acb) {
                acb_b.j6((acb) aci);
                i++;
            } else {
                return;
            }
        }
    }

    public void DW() {
        this.DW.subList(0, U2()).clear();
    }

    private int U2() {
        int size = this.DW.size();
        int i = 0;
        while (i < size && (((aci) this.DW.get(i)) instanceof acb)) {
            i++;
        }
        return i;
    }

    public ArrayList<aci> FH() {
        return this.DW;
    }

    public List<aci> Hw() {
        return this.DW.subList(0, U2());
    }

    public int v5() {
        return this.u7;
    }

    public int Zo() {
        return this.VH;
    }

    public String VH() {
        return add.FH(this.VH);
    }

    public BitSet gn() {
        return this.FH;
    }

    public BitSet u7() {
        return this.Hw;
    }

    public adg tp() {
        return this.v5;
    }

    public int EQ() {
        return this.Zo;
    }

    public int we() {
        return this.gn.j6(this.Zo);
    }

    public acg J0() {
        if (this.Zo < 0) {
            return null;
        }
        return (acg) this.gn.tp().get(this.Zo);
    }

    public adg J8() {
        adg adg = new adg(this.v5.DW());
        int DW = this.v5.DW();
        for (int i = 0; i < DW; i++) {
            adg.FH(this.gn.j6(this.v5.DW(i)));
        }
        return adg;
    }

    public acj Ws() {
        return this.gn;
    }

    public acg QX() {
        acg DW = this.gn.DW();
        DW.FH = this.FH;
        DW.Hw.set(this.u7);
        DW.v5.FH(this.u7);
        DW.Zo = this.u7;
        this.FH = new BitSet(this.gn.tp().size());
        this.FH.set(DW.u7);
        for (int nextSetBit = DW.FH.nextSetBit(0); nextSetBit >= 0; nextSetBit = DW.FH.nextSetBit(nextSetBit + 1)) {
            ((acg) this.gn.tp().get(nextSetBit)).j6(this.u7, DW.u7);
        }
        return DW;
    }

    public acg DW(acg acg) {
        acg DW = this.gn.DW();
        if (this.Hw.get(acg.u7)) {
            DW.FH.set(this.u7);
            DW.Hw.set(acg.u7);
            DW.v5.FH(acg.u7);
            DW.Zo = acg.u7;
            for (int DW2 = this.v5.DW() - 1; DW2 >= 0; DW2--) {
                if (this.v5.DW(DW2) == acg.u7) {
                    this.v5.DW(DW2, DW.u7);
                }
            }
            if (this.Zo == acg.u7) {
                this.Zo = DW.u7;
            }
            this.Hw.clear(acg.u7);
            this.Hw.set(DW.u7);
            acg.FH.set(DW.u7);
            acg.FH.set(this.u7, this.Hw.get(acg.u7));
            return DW;
        }
        throw new RuntimeException("Block " + acg.VH() + " not successor of " + VH());
    }

    public void j6(int i, int i2) {
        if (i != i2) {
            this.Hw.set(i2);
            if (this.Zo == i) {
                this.Zo = i2;
            }
            for (int DW = this.v5.DW() - 1; DW >= 0; DW--) {
                if (this.v5.DW(DW) == i) {
                    this.v5.DW(DW, i2);
                }
            }
            this.Hw.clear(i);
            ((acg) this.gn.tp().get(i2)).FH.set(this.u7);
            ((acg) this.gn.tp().get(i)).FH.clear(this.u7);
        }
    }

    public void DW(int i) {
        int i2 = 0;
        for (int DW = this.v5.DW() - 1; DW >= 0; DW--) {
            if (this.v5.DW(DW) == i) {
                i2 = DW;
            } else {
                this.Zo = this.v5.DW(DW);
            }
        }
        this.v5.Hw(i2);
        this.Hw.clear(i);
        ((acg) this.gn.tp().get(i)).FH.clear(this.u7);
    }

    public void FH(acg acg) {
        if (this != acg && this.v5.DW() == 0) {
            this.Hw.set(acg.u7);
            this.v5.FH(acg.u7);
            this.Zo = acg.u7;
            acg.FH.set(this.u7);
        }
    }

    public void j6(zw zwVar, zw zwVar2) {
        if (zwVar.VH() != zwVar2.VH()) {
            abz abz = (abz) this.DW.get(this.DW.size() - 1);
            if (abz.Ws() != null || abz.DW().m_() > 0) {
                int nextSetBit = this.Hw.nextSetBit(0);
                while (nextSetBit >= 0) {
                    ((acg) this.gn.tp().get(nextSetBit)).DW(zwVar, zwVar2);
                    nextSetBit = this.Hw.nextSetBit(nextSetBit + 1);
                }
                return;
            }
            this.DW.add(this.DW.size() - 1, new abz(new zu(aab.j6(zwVar.j6()), aac.j6, zwVar, zx.j6(zwVar2)), this));
            this.EQ++;
        }
    }

    public void DW(zw zwVar, zw zwVar2) {
        if (zwVar.VH() != zwVar2.VH()) {
            this.DW.add(U2(), new abz(new zu(aab.j6(zwVar.j6()), aac.j6, zwVar, zx.j6(zwVar2)), this));
            this.we++;
        }
    }

    private static void j6(BitSet bitSet, zw zwVar) {
        bitSet.set(zwVar.VH());
        if (zwVar.EQ() > 1) {
            bitSet.set(zwVar.VH() + 1);
        }
    }

    private static boolean DW(BitSet bitSet, zw zwVar) {
        int VH = zwVar.VH();
        return bitSet.get(VH) || (zwVar.EQ() == 2 && bitSet.get(VH + 1));
    }

    private void j6(List<aci> list) {
        BitSet bitSet = new BitSet(this.gn.VH());
        BitSet bitSet2 = new BitSet(this.gn.VH());
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2;
            int i3;
            for (i2 = i; i2 < size; i2++) {
                j6(bitSet, ((aci) list.get(i2)).DW().DW(0));
                j6(bitSet2, ((aci) list.get(i2)).Ws());
            }
            int i4 = i;
            i2 = i;
            while (i4 < size) {
                if (DW(bitSet, ((aci) list.get(i4)).Ws())) {
                    i3 = i2;
                } else {
                    i3 = i2 + 1;
                    Collections.swap(list, i4, i2);
                }
                i4++;
                i2 = i3;
            }
            if (i == i2) {
                aci aci;
                for (i = i2; i < size; i++) {
                    aci = (aci) list.get(i);
                    if (DW(bitSet, aci.Ws()) && DW(bitSet2, aci.DW().DW(0))) {
                        Collections.swap(list, i2, i);
                        break;
                    }
                }
                aci = null;
                zw Ws = aci.Ws();
                zw DW = Ws.DW(this.gn.DW(Ws.EQ()));
                i3 = i2 + 1;
                list.add(i2, new abz(new zu(aab.j6(Ws.j6()), aac.j6, DW, aci.DW()), this));
                list.set(i3, new abz(new zu(aab.j6(Ws.j6()), aac.j6, Ws, zx.j6(DW)), this));
                int i5 = i3;
                i3 = list.size();
                i2 = i5;
            } else {
                i3 = size;
            }
            bitSet.clear();
            bitSet2.clear();
            i = i2;
            size = i3;
        }
    }

    public void FH(int i) {
        if (this.Ws == null) {
            this.Ws = acf.FH(this.gn.VH());
        }
        this.Ws.j6(i);
    }

    public void Hw(int i) {
        if (this.J8 == null) {
            this.J8 = acf.FH(this.gn.VH());
        }
        this.J8.j6(i);
    }

    public adh XL() {
        if (this.Ws == null) {
            this.Ws = acf.FH(this.gn.VH());
        }
        return this.Ws;
    }

    public boolean aM() {
        return this.u7 == this.gn.v5();
    }

    public boolean j3() {
        if (this.J0 == -1) {
            this.gn.we();
        }
        if (this.J0 == 1) {
            return true;
        }
        return false;
    }

    public void v5(int i) {
        this.J0 = i;
    }

    public void Mr() {
        if (this.we > 1) {
            j6(this.DW.subList(0, this.we));
            if (((aci) this.DW.get(this.we)).tp()) {
                throw new RuntimeException("Unexpected: moves from phis before move-exception");
            }
        }
        if (this.EQ > 1) {
            j6(this.DW.subList((this.DW.size() - this.EQ) - 1, this.DW.size() - 1));
        }
        this.gn.u7();
    }

    public void j6(aci$a aci_a) {
        int size = this.DW.size();
        for (int i = 0; i < size; i++) {
            ((aci) this.DW.get(i)).j6(aci_a);
        }
    }

    public String toString() {
        return "{" + this.u7 + ":" + add.FH(this.VH) + '}';
    }
}
