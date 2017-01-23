package groovyjarjarantlr;

class WildcardElement extends GrammarAtom {
    protected String we;

    public String j6() {
        return this.we;
    }

    public Lookahead j6(int i) {
        return this.u7.j6.j6(i, this);
    }

    public String toString() {
        String str = " ";
        if (this.we != null) {
            str = new StringBuffer().append(str).append(this.we).append(":").toString();
        }
        return new StringBuffer().append(str).append(".").toString();
    }
}
