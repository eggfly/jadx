package groovyjarjarantlr;

class RuleRefElement extends AlternativeElement {
    protected String DW;
    protected String FH;
    protected String j6;

    public String j6() {
        return this.FH;
    }

    public Lookahead j6(int i) {
        return this.u7.j6.j6(i, this);
    }

    public String toString() {
        if (this.DW != null) {
            return new StringBuffer().append(" ").append(this.j6).append(this.DW).toString();
        }
        return new StringBuffer().append(" ").append(this.j6).toString();
    }
}
