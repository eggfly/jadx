public final class vc extends ul {
    public static final ul DW;

    static {
        DW = new vc();
    }

    private vc() {
    }

    public String j6(uf ufVar) {
        return ul.Hw(ufVar);
    }

    public String DW(uf ufVar, boolean z) {
        return ul.v5(ufVar);
    }

    public int j6() {
        return 1;
    }

    public boolean DW(uf ufVar) {
        if (!(ufVar instanceof uz) || ufVar.tp().m_() != 0) {
            return false;
        }
        uz uzVar = (uz) ufVar;
        return uzVar.Ws() ? j6(uzVar) : true;
    }

    public boolean j6(uz uzVar) {
        int v5 = uzVar.v5();
        return v5 != 0 && ul.FH(v5);
    }

    public void j6(acr acr, uf ufVar) {
        ul.j6(acr, ul.j6(ufVar, ((uz) ufVar).v5() & 255));
    }
}
