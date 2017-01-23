public final class uz extends uj {
    private uc j6;

    public uz(uh uhVar, aac aac, zx zxVar, uc ucVar) {
        super(uhVar, aac, zxVar);
        if (ucVar == null) {
            throw new NullPointerException("target == null");
        }
        this.j6 = ucVar;
    }

    public uf j6(uh uhVar) {
        return new uz(uhVar, u7(), tp(), this.j6);
    }

    public uf j6(zx zxVar) {
        return new uz(gn(), u7(), zxVar, this.j6);
    }

    public uz j6(uc ucVar) {
        return new uz(gn().VH(), u7(), tp(), ucVar);
    }

    public uc FH() {
        return this.j6;
    }

    public int Hw() {
        return this.j6.VH();
    }

    public int v5() {
        return this.j6.VH() - VH();
    }

    public boolean Ws() {
        return Zo() && this.j6.Zo();
    }

    protected String DW() {
        if (this.j6 == null) {
            return "????";
        }
        return this.j6.J0();
    }
}
