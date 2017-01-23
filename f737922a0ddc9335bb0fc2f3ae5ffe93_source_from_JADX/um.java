public final class um extends vb {
    private final zw j6;

    public um(aac aac, zw zwVar) {
        super(aac);
        if (zwVar == null) {
            throw new NullPointerException("local == null");
        }
        this.j6 = zwVar;
    }

    public uf Hw(int i) {
        return new um(u7(), this.j6.FH(i));
    }

    public uf j6(zx zxVar) {
        return new um(u7(), this.j6);
    }

    public zw FH() {
        return this.j6;
    }

    protected String DW() {
        return this.j6.toString();
    }

    protected String j6(boolean z) {
        return "local-end " + up.j6(this.j6);
    }
}
