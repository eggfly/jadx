public class apr$b extends apy implements apr {
    private final aqe EQ;
    private final aqe tp;
    private final int u7;

    public apr$b(any any, int i) {
        super(any);
        this.u7 = i;
        this.tp = j6("UNSHALLOW");
        this.EQ = j6("REINTERESTING");
    }

    public void j6(aqg aqg) {
        aqg aqg2 = aqg;
        while (aqg2 instanceof aqj) {
            aqg2 = ((aqj) aqg2).gn();
            Zo(aqg2);
        }
        if (aqg2 instanceof apr$a) {
            ((apr$a) aqg2).VH = 0;
        }
        super.FH(aqg);
    }

    public void DW(aqg aqg) {
        if (aqg instanceof aqc) {
            aqg.FH(this.tp);
        }
        super.FH(aqg);
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
