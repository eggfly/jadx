public class baq extends azc {
    private static final byte[] v5;

    static {
        v5 = new byte[0];
    }

    public baq(boolean z, int i, ayh ayh) {
        super(z, i, ayh);
    }

    boolean gn() {
        if (this.DW || this.FH) {
            return true;
        }
        return this.Hw.w_().Zo().gn();
    }

    int u7() {
        if (this.DW) {
            return bbg.DW(this.j6) + 1;
        }
        int u7 = this.Hw.w_().Zo().u7();
        if (this.FH) {
            return u7 + (bbg.DW(this.j6) + bbg.j6(u7));
        }
        return (u7 - 1) + bbg.DW(this.j6);
    }

    void j6(ayt ayt) {
        int i = 160;
        if (this.DW) {
            ayt.j6(160, this.j6, v5);
            return;
        }
        ayv Zo = this.Hw.w_().Zo();
        if (this.FH) {
            ayt.j6(160, this.j6);
            ayt.j6(Zo.u7());
            ayt.j6((ayh) Zo);
            return;
        }
        if (!Zo.gn()) {
            i = 128;
        }
        ayt.j6(i, this.j6);
        ayt.j6(Zo);
    }
}
