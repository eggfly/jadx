public class apr$c extends aql implements apr {
    private final aqe EQ;
    private final aqe tp;
    private final int u7;

    public apr$c(any any, int i) {
        super(any);
        this.u7 = i;
        this.tp = j6("UNSHALLOW");
        this.EQ = j6("REINTERESTING");
    }

    public void j6(aqc aqc) {
        if (aqc instanceof apr$a) {
            ((apr$a) aqc).VH = 0;
        }
        super.DW(aqc);
    }

    protected aqc j6(anb anb) {
        return new apr$a(anb);
    }

    public int j6() {
        return this.u7;
    }

    public aqe DW() {
        return this.tp;
    }

    public aqe FH() {
        return this.EQ;
    }
}
