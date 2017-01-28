public final class wc extends ul {
    public static final ul DW;

    static {
        DW = new wc();
    }

    private wc() {
    }

    public String j6(uf ufVar) {
        return ul.DW(ufVar.tp()) + ", " + ul.Zo(ufVar);
    }

    public String DW(uf ufVar, boolean z) {
        if (z) {
            return ul.VH(ufVar);
        }
        return "";
    }

    public int j6() {
        return 5;
    }

    public boolean DW(uf ufVar) {
        if (!j6 || !(ufVar instanceof ud)) {
            return false;
        }
        ud udVar = (ud) ufVar;
        aah FH = udVar.FH();
        if (!(FH instanceof abb) && !(FH instanceof abf)) {
            return false;
        }
        zx tp = udVar.tp();
        tp.m_();
        if (tp.m_() == 0 || (ul.FH(tp) && ul.Zo(tp.DW(0).VH()) && ul.Zo(tp.v5()))) {
            return true;
        }
        return false;
    }

    public void j6(acr acr, uf ufVar) {
        zx tp = ufVar.tp();
        ul.j6(acr, ul.gn(ufVar), ((ud) ufVar).Hw(), (short) tp.v5(), (short) (tp.m_() == 0 ? 0 : tp.DW(0).VH()));
    }
}
