import java.util.ArrayList;
import java.util.BitSet;

class acq$1 implements acg$b {
    final /* synthetic */ acq DW;
    final /* synthetic */ ArrayList j6;

    acq$1(acq acq, ArrayList arrayList) {
        this.DW = acq;
        this.j6 = arrayList;
    }

    public void j6(acg acg, acg acg2) {
        ArrayList FH = acg.FH();
        if (FH.size() == 1 && ((aci) FH.get(0)).v5() == aab.j3) {
            BitSet bitSet = (BitSet) acg.gn().clone();
            for (int nextSetBit = bitSet.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet.nextSetBit(nextSetBit + 1)) {
                ((acg) this.j6.get(nextSetBit)).j6(acg.v5(), acg.EQ());
            }
        }
    }
}
