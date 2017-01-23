package groovyjarjarantlr;

class TokenRangeElement extends AlternativeElement {
    protected int DW;
    protected int FH;
    protected String Hw;
    String j6;
    protected String v5;

    public String j6() {
        return this.j6;
    }

    public Lookahead j6(int i) {
        return this.u7.j6.j6(i, this);
    }

    public String toString() {
        if (this.j6 != null) {
            return new StringBuffer().append(" ").append(this.j6).append(":").append(this.Hw).append("..").append(this.v5).toString();
        }
        return new StringBuffer().append(" ").append(this.Hw).append("..").append(this.v5).toString();
    }
}
