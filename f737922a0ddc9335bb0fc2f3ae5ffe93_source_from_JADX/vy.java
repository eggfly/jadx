public final class vy extends ul {
    public static final ul DW;

    static {
        DW = new vy();
    }

    private vy() {
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
        return 3;
    }

    public boolean DW(uf ufVar) {
        if (!(ufVar instanceof ud)) {
            return false;
        }
        ud udVar = (ud) ufVar;
        int Hw = udVar.Hw();
        aah FH = udVar.FH();
        if (!ul.Zo(Hw)) {
            return false;
        }
        if (!(FH instanceof abb) && !(FH instanceof abf)) {
            return false;
        }
        zx tp = udVar.tp();
        tp.m_();
        if (tp.m_() == 0 || (ul.FH(tp) && ul.Zo(tp.DW(0).VH()) && ul.Hw(tp.v5()))) {
            return true;
        }
        return false;
    }

    public void j6(acr acr, uf ufVar) {
        zx tp = ufVar.tp();
        ul.j6(acr, ul.j6(ufVar, tp.v5()), (short) ((ud) ufVar).Hw(), (short) (tp.m_() == 0 ? 0 : tp.DW(0).VH()));
    }
}
