import java.util.Enumeration;

public class azp extends azc {
    public azp(int i, ayh ayh) {
        super(true, i, ayh);
    }

    public azp(boolean z, int i, ayh ayh) {
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
        int u7 = this.Hw.w_().u7();
        if (this.FH) {
            return u7 + (bbg.DW(this.j6) + bbg.j6(u7));
        }
        return (u7 - 1) + bbg.DW(this.j6);
    }

    void j6(ayt ayt) {
        ayt.j6(160, this.j6);
        ayt.DW(128);
        if (!this.DW) {
            if (this.FH) {
                ayt.j6(this.Hw);
            } else {
                Enumeration tp;
                if (this.Hw instanceof ayr) {
                    if (this.Hw instanceof azj) {
                        tp = ((azj) this.Hw).tp();
                    } else {
                        tp = new azj(((ayr) this.Hw).Hw()).tp();
                    }
                } else if (this.Hw instanceof ayw) {
                    tp = ((ayw) this.Hw).Hw();
                } else if (this.Hw instanceof ayy) {
                    tp = ((ayy) this.Hw).FH();
                } else {
                    throw new RuntimeException("not implemented: " + this.Hw.getClass().getName());
                }
                while (tp.hasMoreElements()) {
                    ayt.j6((ayh) tp.nextElement());
                }
            }
        }
        ayt.DW(0);
        ayt.DW(0);
    }
}
