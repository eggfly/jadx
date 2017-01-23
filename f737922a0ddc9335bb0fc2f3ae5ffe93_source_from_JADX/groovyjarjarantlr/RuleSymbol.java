package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.Vector;

class RuleSymbol extends GrammarSymbol {
    RuleBlock DW;
    boolean FH;
    Vector Hw;

    public RuleBlock j6() {
        return this.DW;
    }

    public RuleRefElement j6(int i) {
        return (RuleRefElement) this.Hw.j6(i);
    }

    public int DW() {
        return this.Hw.DW();
    }
}
