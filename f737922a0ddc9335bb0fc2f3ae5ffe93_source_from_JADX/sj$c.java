import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

class sj$c {
    private final HashMap<Integer, Integer> DW;
    private final BitSet FH;
    private int Hw;
    private final ArrayList<adg> VH;
    private final sj$a Zo;
    final /* synthetic */ sj j6;
    private int v5;

    sj$c(sj sjVar, sj$a sj_a, ArrayList<adg> arrayList) {
        this.j6 = sjVar;
        this.DW = new HashMap();
        this.FH = new BitSet(sjVar.Hw);
        this.Zo = sj_a;
        this.VH = arrayList;
    }

    void j6(zi ziVar) {
        this.v5 = ziVar.FH().DW(0);
        this.Hw = ziVar.FH().DW(1);
        int j6 = j6(this.Hw);
        int nextSetBit = this.FH.nextSetBit(0);
        while (nextSetBit >= 0) {
            this.FH.clear(nextSetBit);
            int intValue = ((Integer) this.DW.get(Integer.valueOf(nextSetBit))).intValue();
            j6(nextSetBit, intValue);
            if (this.j6.j6(this.j6.Hw(nextSetBit))) {
                new sj$c(this.j6, this.Zo, this.VH).j6(this.j6.Hw(intValue));
            }
            nextSetBit = this.FH.nextSetBit(0);
        }
        this.j6.FH(new zi(ziVar.j6(), ziVar.DW(), adg.j6(j6), j6), (adg) this.VH.get(ziVar.j6()));
    }

    private void j6(int i, int i2) {
        adg j6;
        zi j62 = this.j6.Hw(i);
        adg FH = j62.FH();
        int i3 = -1;
        if (this.j6.j6(j62)) {
            j6 = adg.j6(j6(FH.DW(0)), FH.DW(1));
        } else {
            sj$b DW = this.j6.Zo(i);
            if (DW == null) {
                int Hw = j62.Hw();
                int DW2 = FH.DW();
                adg adg = new adg(DW2);
                int i4 = 0;
                while (i4 < DW2) {
                    int DW3 = FH.DW(i4);
                    int j63 = j6(DW3);
                    adg.FH(j63);
                    if (Hw != DW3) {
                        j63 = i3;
                    }
                    i4++;
                    i3 = j63;
                }
                adg.l_();
                j6 = adg;
            } else if (DW.Hw != this.Hw) {
                throw new RuntimeException("ret instruction returns to label " + add.FH(DW.Hw) + " expected: " + add.FH(this.Hw));
            } else {
                j6 = adg.j6(this.v5);
                i3 = this.v5;
            }
        }
        this.j6.j6(new zi(i2, this.j6.j6(j62.DW()), j6, i3), (adg) this.VH.get(i2));
    }

    private boolean DW(int i, int i2) {
        adg adg = (adg) this.VH.get(i);
        return adg != null && adg.DW() > 0 && adg.Hw() == i2;
    }

    private int j6(int i) {
        Integer num = (Integer) this.DW.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        if (!DW(i, this.Hw)) {
            return i;
        }
        int j6 = this.Zo.j6();
        this.FH.set(i);
        this.DW.put(Integer.valueOf(i), Integer.valueOf(j6));
        while (this.VH.size() <= j6) {
            this.VH.add(null);
        }
        this.VH.set(j6, this.VH.get(i));
        return j6;
    }
}
