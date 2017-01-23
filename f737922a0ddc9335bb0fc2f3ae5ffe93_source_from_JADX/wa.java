import java.util.BitSet;

public final class wa extends ul {
    public static final ul DW;

    static {
        DW = new wa();
    }

    private wa() {
    }

    public String j6(uf ufVar) {
        return ufVar.tp().DW(0).J0() + ", " + ul.j6((aay) ((ud) ufVar).FH());
    }

    public String DW(uf ufVar, boolean z) {
        return ul.j6((aay) ((ud) ufVar).FH(), 64);
    }

    public int j6() {
        return 5;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if ((ufVar instanceof ud) && tp.m_() == 1 && ul.Hw(tp.DW(0).VH())) {
            return ((ud) ufVar).FH() instanceof aax;
        }
        return false;
    }

    public BitSet FH(uf ufVar) {
        zx tp = ufVar.tp();
        BitSet bitSet = new BitSet(1);
        bitSet.set(0, ul.Hw(tp.DW(0).VH()));
        return bitSet;
    }

    public void j6(acr acr, uf ufVar) {
        zx tp = ufVar.tp();
        ul.j6(acr, ul.j6(ufVar, tp.DW(0).VH()), ((aax) ((ud) ufVar).FH()).EQ());
    }
}
