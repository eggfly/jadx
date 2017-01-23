import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

public final class abs {
    private final acj DW;
    private final ArrayList<acg> FH;
    private final abs$a[] Hw;
    private final abr$a[] Zo;
    private final boolean j6;
    private final ArrayList<acg> v5;

    private abs(acj acj, abr$a[] abr_aArr, boolean z) {
        this.DW = acj;
        this.Zo = abr_aArr;
        this.j6 = z;
        this.FH = acj.tp();
        this.Hw = new abs$a[(this.FH.size() + 2)];
        this.v5 = new ArrayList();
    }

    public static abs j6(acj acj, abr$a[] abr_aArr, boolean z) {
        abs abs = new abs(acj, abr_aArr, z);
        abs.j6();
        return abs;
    }

    private BitSet j6(acg acg) {
        if (this.j6) {
            return acg.u7();
        }
        return acg.gn();
    }

    private void DW(acg acg) {
        if (this.Hw[this.Hw[acg.v5()].Hw.v5()].Hw != null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            arrayList.add(acg);
            while (!arrayList.isEmpty()) {
                int size = arrayList.size();
                abs$a abs_a = this.Hw[((acg) arrayList.get(size - 1)).v5()];
                acg acg2 = abs_a.Hw;
                abs$a abs_a2 = this.Hw[acg2.v5()];
                if (!hashSet.add(acg2) || abs_a2.Hw == null) {
                    arrayList.remove(size - 1);
                    if (abs_a2.Hw != null) {
                        acg acg3 = abs_a2.FH;
                        if (this.Hw[acg3.v5()].j6 < this.Hw[abs_a.FH.v5()].j6) {
                            abs_a.FH = acg3;
                        }
                        abs_a.Hw = abs_a2.Hw;
                    }
                } else {
                    arrayList.add(acg2);
                }
            }
        }
    }

    private acg FH(acg acg) {
        abs$a abs_a = this.Hw[acg.v5()];
        if (abs_a.Hw == null) {
            return acg;
        }
        DW(acg);
        return abs_a.FH;
    }

    private void j6() {
        acg Zo;
        int i = 2;
        if (this.j6) {
            Zo = this.DW.Zo();
        } else {
            Zo = this.DW.Hw();
        }
        if (Zo != null) {
            this.v5.add(Zo);
            this.Zo[Zo.v5()].DW = Zo.v5();
        }
        this.DW.j6(this.j6, new abs$b());
        int size = this.v5.size() - 1;
        for (int i2 = size; i2 >= 2; i2--) {
            Zo = (acg) this.v5.get(i2);
            abs$a abs_a = this.Hw[Zo.v5()];
            BitSet j6 = j6(Zo);
            for (int nextSetBit = j6.nextSetBit(0); nextSetBit >= 0; nextSetBit = j6.nextSetBit(nextSetBit + 1)) {
                acg acg = (acg) this.FH.get(nextSetBit);
                if (this.Hw[acg.v5()] != null) {
                    int i3 = this.Hw[FH(acg).v5()].j6;
                    if (i3 < abs_a.j6) {
                        abs_a.j6 = i3;
                    }
                }
            }
            this.Hw[((acg) this.v5.get(abs_a.j6)).v5()].v5.add(Zo);
            abs_a.Hw = abs_a.DW;
            ArrayList arrayList = this.Hw[abs_a.DW.v5()].v5;
            while (!arrayList.isEmpty()) {
                Zo = (acg) arrayList.remove(arrayList.size() - 1);
                acg FH = FH(Zo);
                if (this.Hw[FH.v5()].j6 < this.Hw[Zo.v5()].j6) {
                    this.Zo[Zo.v5()].DW = FH.v5();
                } else {
                    this.Zo[Zo.v5()].DW = abs_a.DW.v5();
                }
            }
        }
        while (i <= size) {
            Zo = (acg) this.v5.get(i);
            if (this.Zo[Zo.v5()].DW != ((acg) this.v5.get(this.Hw[Zo.v5()].j6)).v5()) {
                this.Zo[Zo.v5()].DW = this.Zo[this.Zo[Zo.v5()].DW].DW;
            }
            i++;
        }
    }
}
