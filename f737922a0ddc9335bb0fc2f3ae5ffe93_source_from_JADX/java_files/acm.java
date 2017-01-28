import java.util.BitSet;

public class acm {
    private final zj DW;
    private final zj FH;
    private final aaa j6;

    public acm(aaa aaa) {
        this.j6 = aaa;
        this.DW = this.j6.j6();
        this.FH = this.DW.gn();
    }

    public aaa j6() {
        int i;
        int m_ = this.DW.m_();
        BitSet bitSet = new BitSet(this.DW.tp());
        for (int i2 = 0; i2 < m_; i2++) {
            zi j6 = this.DW.j6(i2);
            if (!bitSet.get(j6.j6())) {
                adg j62 = this.j6.j6(j6.j6());
                int DW = j62.DW();
                for (int i3 = 0; i3 < DW; i3++) {
                    int DW2 = j62.DW(i3);
                    zi DW3 = this.DW.DW(DW2);
                    if (!(bitSet.get(DW2) || DW3.FH().DW() > 1 || DW3.Zo().Zo().j6() == 55)) {
                        adg adg = new adg();
                        for (i = i3 + 1; i < DW; i++) {
                            int DW4 = j62.DW(i);
                            zi DW5 = this.DW.DW(DW4);
                            if (DW5.FH().DW() == 1 && j6(DW3, DW5)) {
                                adg.FH(DW4);
                                bitSet.set(DW4);
                            }
                        }
                        j6(DW2, adg);
                    }
                }
            }
        }
        for (i = m_ - 1; i >= 0; i--) {
            if (bitSet.get(this.FH.j6(i).j6())) {
                this.FH.j6(i, null);
            }
        }
        this.FH.u7();
        this.FH.l_();
        return new aaa(this.FH, this.j6.DW());
    }

    private static boolean j6(zi ziVar, zi ziVar2) {
        return ziVar.DW().j6(ziVar2.DW());
    }

    private void j6(int i, adg adg) {
        int DW = adg.DW();
        for (int i2 = 0; i2 < DW; i2++) {
            int DW2 = adg.DW(i2);
            adg j6 = this.j6.j6(this.DW.DW(DW2).j6());
            int DW3 = j6.DW();
            for (int i3 = 0; i3 < DW3; i3++) {
                j6(this.FH.DW(j6.DW(i3)), DW2, i);
            }
        }
    }

    private void j6(zi ziVar, int i, int i2) {
        adg Zo = ziVar.FH().Zo();
        Zo.DW(Zo.Zo(i), i2);
        int Hw = ziVar.Hw();
        if (Hw != i) {
            i2 = Hw;
        }
        Zo.l_();
        this.FH.j6(this.FH.FH(ziVar.j6()), new zi(ziVar.j6(), ziVar.DW(), Zo, i2));
    }
}
