public final class up extends vb {
    private final zw j6;

    public static String j6(zw zwVar) {
        return zwVar.J0() + ' ' + zwVar.u7().toString() + ": " + zwVar.gn().Hw();
    }

    public up(aac aac, zw zwVar) {
        super(aac);
        if (zwVar == null) {
            throw new NullPointerException("local == null");
        }
        this.j6 = zwVar;
    }

    public uf Hw(int i) {
        return new up(u7(), this.j6.FH(i));
    }

    public uf j6(zx zxVar) {
        return new up(u7(), this.j6);
    }

    public zw FH() {
        return this.j6;
    }

    protected String DW() {
        return this.j6.toString();
    }

    protected String j6(boolean z) {
        return "local-start " + j6(this.j6);
    }
}
