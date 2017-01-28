import java.util.BitSet;

class sj$b {
    private BitSet DW;
    private BitSet FH;
    private int Hw;
    final /* synthetic */ sj j6;

    sj$b(sj sjVar, int i) {
        this.j6 = sjVar;
        this.Hw = i;
        this.FH = new BitSet(sjVar.Hw);
        this.DW = new BitSet(sjVar.Hw);
        sjVar.J0 = true;
    }

    sj$b(sj sjVar, int i, int i2) {
        this(sjVar, i);
        j6(i2);
    }

    int j6() {
        return this.Hw;
    }

    void j6(int i) {
        this.FH.set(i);
    }

    void DW(int i) {
        this.DW.set(i);
    }

    adg DW() {
        adg adg = new adg(this.DW.size());
        int nextSetBit = this.DW.nextSetBit(0);
        while (nextSetBit >= 0) {
            adg.FH(this.j6.Hw(nextSetBit).FH().DW(0));
            nextSetBit = this.DW.nextSetBit(nextSetBit + 1);
        }
        adg.l_();
        return adg;
    }

    void j6(sa saVar, int[] iArr) {
        int nextSetBit = this.DW.nextSetBit(0);
        while (nextSetBit >= 0) {
            int DW = this.j6.Hw(nextSetBit).FH().DW(0);
            sa j6 = saVar.j6(this.Hw, nextSetBit);
            if (j6 != null) {
                this.j6.j6(DW, -1, null, j6, iArr);
            } else {
                act.DW(iArr, nextSetBit);
            }
            nextSetBit = this.DW.nextSetBit(nextSetBit + 1);
        }
    }
}
