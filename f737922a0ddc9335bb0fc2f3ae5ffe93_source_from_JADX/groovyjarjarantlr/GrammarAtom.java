package groovyjarjarantlr;

abstract class GrammarAtom extends AlternativeElement {
    protected String DW;
    protected int FH;
    protected boolean Hw;
    protected String j6;
    protected String v5;

    public String j6() {
        return this.j6;
    }

    public String FH() {
        return this.DW;
    }

    public int Hw() {
        return this.FH;
    }

    public String v5() {
        return this.v5;
    }

    public String toString() {
        String str = " ";
        if (this.j6 != null) {
            str = new StringBuffer().append(str).append(this.j6).append(":").toString();
        }
        if (this.Hw) {
            str = new StringBuffer().append(str).append("~").toString();
        }
        return new StringBuffer().append(str).append(this.DW).toString();
    }
}
