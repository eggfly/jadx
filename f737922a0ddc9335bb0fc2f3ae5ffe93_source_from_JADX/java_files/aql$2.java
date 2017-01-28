import java.util.Iterator;

class aql$2 implements apk {
    private final /* synthetic */ Iterator DW;
    private final /* synthetic */ anc FH;
    final /* synthetic */ aql j6;

    aql$2(aql aql, Iterator it, anc anc) {
        this.j6 = aql;
        this.DW = it;
        this.FH = anc;
    }

    public aqg j6() {
        if (this.DW.hasNext()) {
            return (aqg) this.DW.next();
        }
        if (!this.FH.j6()) {
            return null;
        }
        anb DW = this.FH.DW();
        anx FH = this.FH.FH();
        aqg aqg = (aqg) this.j6.Hw.j6(DW);
        if (aqg == null) {
            return this.j6.j6(DW, FH);
        }
        if (aqg instanceof aqc) {
            ((aqc) aqg).j6(this.j6, FH.v5());
            return aqg;
        } else if (aqg instanceof aqj) {
            ((aqj) aqg).j6(this.j6, FH.v5());
            return aqg;
        } else {
            aqg.we |= 1;
            return aqg;
        }
    }

    public void v5() {
        this.FH.v5();
    }
}
