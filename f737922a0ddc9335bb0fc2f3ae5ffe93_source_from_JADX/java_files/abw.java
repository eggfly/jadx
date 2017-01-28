import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class abw {
    private final ArrayList<acg> DW;
    private final abx FH;
    private final BitSet Hw;
    private final acj j6;

    public static abx j6(acj acj) {
        return new abw(acj).j6();
    }

    private abw(acj acj) {
        if (acj == null) {
            throw new NullPointerException("method == null");
        }
        ArrayList tp = acj.tp();
        this.j6 = acj;
        this.DW = tp;
        this.FH = new abx(acj);
        this.Hw = new BitSet(tp.size());
    }

    private abx j6() {
        if (this.j6.VH() > 0) {
            int FH = this.j6.FH();
            while (FH >= 0) {
                this.Hw.clear(FH);
                j6(FH);
                FH = this.Hw.nextSetBit(0);
            }
        }
        this.FH.l_();
        return this.FH;
    }

    private void j6(int i) {
        int i2 = 1;
        int i3 = 0;
        zy DW = this.FH.DW(i);
        acg acg = (acg) this.DW.get(i);
        List FH = acg.FH();
        int size = FH.size();
        if (i != this.j6.v5()) {
            aci aci = (aci) FH.get(size - 1);
            if ((aci.Zo().DW().m_() != 0 ? 1 : 0) == 0 || aci.Ws() == null) {
                i2 = 0;
            }
            int i4 = size - 1;
            int i5 = 0;
            zy zyVar = DW;
            while (i5 < size) {
                zy zyVar2;
                if (i2 == 0 || i5 != i4) {
                    zyVar2 = zyVar;
                } else {
                    zyVar.l_();
                    zyVar2 = zyVar.v5();
                }
                aci = (aci) FH.get(i5);
                zw VH = aci.VH();
                if (VH == null) {
                    zw Ws = aci.Ws();
                    if (!(Ws == null || zyVar2.j6(Ws.VH()) == null)) {
                        zyVar2.FH(zyVar2.j6(Ws.VH()));
                    }
                } else {
                    VH = VH.J8();
                    if (!VH.equals(zyVar2.j6(VH))) {
                        zw j6 = zyVar2.j6(VH.u7());
                        if (!(j6 == null || j6.VH() == VH.VH())) {
                            zyVar2.FH(j6);
                        }
                        this.FH.j6(aci, VH);
                        zyVar2.Hw(VH);
                    }
                }
                i5++;
                zyVar = zyVar2;
            }
            zyVar.l_();
            adg tp = acg.tp();
            int DW2 = tp.DW();
            i5 = acg.EQ();
            while (i3 < DW2) {
                zy zyVar3;
                int DW3 = tp.DW(i3);
                if (DW3 == i5) {
                    zyVar3 = zyVar;
                } else {
                    zyVar3 = DW;
                }
                if (this.FH.DW(DW3, zyVar3)) {
                    this.Hw.set(DW3);
                }
                i3++;
            }
        }
    }
}
