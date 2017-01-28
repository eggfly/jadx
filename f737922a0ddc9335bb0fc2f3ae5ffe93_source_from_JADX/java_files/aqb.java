public class aqb extends aqg {
    protected aqb(anb anb) {
        super(anb);
    }

    public final int v_() {
        return 3;
    }

    void j6(aql aql) {
        if (aql.DW.DW(this)) {
            this.we |= 1;
            return;
        }
        throw new ali((ans) this, v_());
    }

    void DW(aql aql) {
        if ((this.we & 1) == 0) {
            j6(aql);
        }
    }
}
