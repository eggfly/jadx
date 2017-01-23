package groovyjarjarantlr;

class ZeroOrMoreBlock extends BlockWithImpliedExitPath {
    public Lookahead j6(int i) {
        return this.u7.j6.j6(i, this);
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append("*").toString();
    }
}
