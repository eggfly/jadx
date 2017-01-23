package groovyjarjarantlr;

class TreeElement extends AlternativeBlock {
    GrammarAtom we;

    public Lookahead j6(int i) {
        return this.u7.j6.j6(i, this);
    }

    public String toString() {
        String stringBuffer = new StringBuffer().append(" #(").append(this.we).toString();
        for (AlternativeElement alternativeElement = ((Alternative) this.DW.j6(0)).j6; alternativeElement != null; alternativeElement = alternativeElement.Zo) {
            stringBuffer = new StringBuffer().append(stringBuffer).append(alternativeElement).toString();
        }
        return new StringBuffer().append(stringBuffer).append(" )").toString();
    }
}
