import java.util.BitSet;
import java.util.List;

public class acc {
    private final BitSet DW;
    acj j6;

    public static void j6(acj acj) {
        new acc(acj).j6();
    }

    private acc(acj acj) {
        this.j6 = acj;
        this.DW = new BitSet(acj.VH());
    }

    private void j6() {
        int VH = this.j6.VH();
        for (int i = 0; i < VH; i++) {
            aci FH = this.j6.FH(i);
            if (FH != null && FH.Ws().FH() == 0) {
                this.DW.set(i);
            }
        }
        while (true) {
            VH = this.DW.nextSetBit(0);
            if (VH >= 0) {
                this.DW.clear(VH);
                if (j6((acb) this.j6.FH(VH))) {
                    List Hw = this.j6.Hw(VH);
                    int size = Hw.size();
                    for (VH = 0; VH < size; VH++) {
                        aci aci = (aci) Hw.get(VH);
                        zw Ws = aci.Ws();
                        if (Ws != null && (aci instanceof acb)) {
                            this.DW.set(Ws.VH());
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private static boolean j6(zq zqVar, zq zqVar2) {
        return zqVar == zqVar2 || (zqVar != null && zqVar.equals(zqVar2));
    }

    boolean j6(acb acb) {
        int i = 0;
        acb.j6(this.j6);
        zx DW = acb.DW();
        int i2 = -1;
        int m_ = DW.m_();
        int i3 = 0;
        zw zwVar = null;
        while (i3 < m_) {
            zw DW2 = DW.DW(i3);
            if (DW2.FH() != 0) {
                i2 = i3;
            } else {
                DW2 = zwVar;
            }
            i3++;
            zwVar = DW2;
        }
        if (zwVar == null) {
            return false;
        }
        zq u7 = zwVar.u7();
        abm j6 = zwVar.j6();
        i3 = 1;
        for (int i4 = 0; i4 < m_; i4++) {
            if (i4 != i2) {
                zw DW3 = DW.DW(i4);
                if (DW3.FH() != 0) {
                    if (i3 == 0 || !j6(u7, DW3.u7())) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    j6 = sg.j6(j6, DW3.j6());
                }
            }
        }
        if (j6 != null) {
            zq zqVar;
            if (i3 != 0) {
                zqVar = u7;
            } else {
                zqVar = null;
            }
            zw Ws = acb.Ws();
            if (Ws.gn() == j6 && j6(zqVar, Ws.u7())) {
                return false;
            }
            acb.j6(j6, zqVar);
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < m_) {
            stringBuilder.append(DW.DW(i).toString());
            stringBuilder.append(' ');
            i++;
        }
        throw new RuntimeException("Couldn't map types in phi insn:" + stringBuilder);
    }
}
