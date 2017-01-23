public class bay extends azc {
    private static final byte[] v5;

    static {
        v5 = new byte[0];
    }

    public bay(boolean z, int i, ayh ayh) {
        super(z, i, ayh);
    }

    boolean gn() {
        if (this.DW || this.FH) {
            return true;
        }
        return this.Hw.w_().VH().gn();
    }

    int u7() {
        if (this.DW) {
            return bbg.DW(this.j6) + 1;
        }
        int u7 = this.Hw.w_().VH().u7();
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
        ayv VH = this.Hw.w_().VH();
        if (this.FH) {
            ayt.j6(160, this.j6);
            ayt.j6(VH.u7());
            ayt.j6((ayh) VH);
            return;
        }
        if (!VH.gn()) {
            i = 128;
        }
        ayt.j6(i, this.j6);
        ayt.j6(VH);
    }
}
