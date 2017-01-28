import java.util.HashSet;

public final class ue {
    private us DW;
    private tz FH;
    private ub Hw;
    private ug VH;
    private un Zo;
    private final int j6;
    private ut v5;

    public ue(int i, us usVar, tz tzVar) {
        if (usVar == null) {
            throw new NullPointerException("unprocessedInsns == null");
        } else if (tzVar == null) {
            throw new NullPointerException("unprocessedCatches == null");
        } else {
            this.j6 = i;
            this.DW = usVar;
            this.FH = tzVar;
            this.Hw = null;
            this.v5 = null;
            this.Zo = null;
            this.VH = null;
        }
    }

    private void tp() {
        if (this.VH == null) {
            this.VH = this.DW.Hw();
            this.v5 = ut.j6(this.VH, this.j6);
            this.Zo = un.j6(this.VH);
            this.Hw = this.FH.j6();
            this.DW = null;
            this.FH = null;
        }
    }

    public void j6(ue$a ue_a) {
        this.DW.j6(ue_a);
    }

    public boolean j6() {
        return this.j6 != 1 && this.DW.j6();
    }

    public boolean DW() {
        return this.DW.DW();
    }

    public boolean FH() {
        return this.FH.DW();
    }

    public HashSet<abl> Hw() {
        return this.FH.FH();
    }

    public HashSet<aah> v5() {
        return this.DW.FH();
    }

    public ug Zo() {
        tp();
        return this.VH;
    }

    public ub VH() {
        tp();
        return this.Hw;
    }

    public ut gn() {
        tp();
        return this.v5;
    }

    public un u7() {
        tp();
        return this.Zo;
    }
}
