import java.util.BitSet;

public final class vf extends ul {
    public static final ul DW;

    static {
        DW = new vf();
    }

    private vf() {
    }

    public String j6(uf ufVar) {
        return ufVar.tp().DW(0).J0();
    }

    public String DW(uf ufVar, boolean z) {
        return "";
    }

    public int j6() {
        return 1;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if ((ufVar instanceof uw) && tp.m_() == 1 && ul.Hw(tp.DW(0).VH())) {
            return true;
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
        ul.j6(acr, ul.j6(ufVar, ufVar.tp().DW(0).VH()));
    }
}
