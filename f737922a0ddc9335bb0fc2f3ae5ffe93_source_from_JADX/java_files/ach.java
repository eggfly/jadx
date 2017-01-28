import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

public class ach {
    public static acj j6(aaa aaa, int i, boolean z) {
        acj j6 = acj.j6(aaa, i, z);
        j6(j6);
        j6(j6, abw.j6(j6), 0);
        new ack(j6).run();
        j6.j6();
        return j6;
    }

    public static void j6(acj acj, int i) {
        j6(acj, abw.j6(acj), i);
        new ack(acj, i).run();
    }

    private static void j6(acj acj) {
        DW(acj);
        FH(acj);
        Hw(acj);
    }

    private static void DW(acj acj) {
        ArrayList tp = acj.tp();
        for (int size = tp.size() - 1; size >= 0; size--) {
            acg acg = (acg) tp.get(size);
            if (j6(acg)) {
                acg.QX();
            }
        }
    }

    private static boolean j6(acg acg) {
        int cardinality = acg.gn().cardinality();
        int cardinality2 = acg.u7().cardinality();
        if (cardinality <= 1 || cardinality2 <= 1) {
            return false;
        }
        return true;
    }

    private static void FH(acj acj) {
        ArrayList tp = acj.tp();
        for (int size = tp.size() - 1; size >= 0; size--) {
            acg acg = (acg) tp.get(size);
            if (!acg.aM() && acg.gn().cardinality() > 1 && ((aci) acg.FH().get(0)).tp()) {
                BitSet bitSet = (BitSet) acg.gn().clone();
                for (int nextSetBit = bitSet.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet.nextSetBit(nextSetBit + 1)) {
                    ((acg) tp.get(nextSetBit)).DW(acg).FH().add(0, ((aci) acg.FH().get(0)).J8());
                }
                acg.FH().remove(0);
            }
        }
    }

    private static void Hw(acj acj) {
        ArrayList tp = acj.tp();
        for (int size = tp.size() - 1; size >= 0; size--) {
            acg acg = (acg) tp.get(size);
            BitSet bitSet = (BitSet) acg.u7().clone();
            for (int nextSetBit = bitSet.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet.nextSetBit(nextSetBit + 1)) {
                acg acg2 = (acg) tp.get(nextSetBit);
                if (j6(acg, acg2)) {
                    acg.DW(acg2);
                }
            }
        }
    }

    private static boolean j6(acg acg, acg acg2) {
        ArrayList FH = acg.FH();
        aci aci = (aci) FH.get(FH.size() - 1);
        return (aci.Ws() != null || aci.DW().m_() > 0) && acg2.gn().cardinality() > 1;
    }

    private static void j6(acj acj, abx abx, int i) {
        int i2;
        ArrayList tp = acj.tp();
        int size = tp.size();
        int VH = acj.VH() - i;
        abr$a[] j6 = new abr(acj).j6();
        BitSet[] bitSetArr = new BitSet[VH];
        BitSet[] bitSetArr2 = new BitSet[VH];
        for (i2 = 0; i2 < VH; i2++) {
            bitSetArr[i2] = new BitSet(size);
            bitSetArr2[i2] = new BitSet(size);
        }
        int size2 = tp.size();
        for (size = 0; size < size2; size++) {
            Iterator it = ((acg) tp.get(size)).FH().iterator();
            while (it.hasNext()) {
                zw Ws = ((aci) it.next()).Ws();
                if (Ws != null && Ws.VH() - i >= 0) {
                    bitSetArr[Ws.VH() - i].set(size);
                }
            }
        }
        for (size2 = 0; size2 < VH; size2++) {
            BitSet bitSet = (BitSet) bitSetArr[size2].clone();
            while (true) {
                i2 = bitSet.nextSetBit(0);
                if (i2 < 0) {
                    break;
                }
                bitSet.clear(i2);
                adf DW = j6[i2].j6.DW();
                while (DW.j6()) {
                    int DW2 = DW.DW();
                    if (!bitSetArr2[size2].get(DW2)) {
                        bitSetArr2[size2].set(DW2);
                        int i3 = size2 + i;
                        zw j62 = abx.j6(DW2).j6(i3);
                        if (j62 == null) {
                            ((acg) tp.get(DW2)).j6(i3);
                        } else {
                            ((acg) tp.get(DW2)).j6(j62);
                        }
                        if (!bitSetArr[size2].get(DW2)) {
                            bitSet.set(DW2);
                        }
                    }
                }
            }
        }
    }
}
