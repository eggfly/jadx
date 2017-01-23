import java.util.BitSet;

public final class vw extends ul {
    public static final ul DW;

    static {
        DW = new vw();
    }

    private vw() {
    }

    public String j6(uf ufVar) {
        zx tp = ufVar.tp();
        return tp.DW(0).J0() + ", " + tp.DW(1).J0();
    }

    public String DW(uf ufVar, boolean z) {
        return "";
    }

    public int j6() {
        return 3;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if ((ufVar instanceof uw) && tp.m_() == 2 && ul.Zo(tp.DW(0).VH()) && ul.Zo(tp.DW(1).VH())) {
            return true;
        }
        return false;
    }

    public BitSet FH(uf ufVar) {
        zx tp = ufVar.tp();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, ul.Zo(tp.DW(0).VH()));
        bitSet.set(1, ul.Zo(tp.DW(1).VH()));
        return bitSet;
    }

    public void j6(acr acr, uf ufVar) {
        zx tp = ufVar.tp();
        ul.j6(acr, ul.j6(ufVar, 0), (short) tp.DW(0).VH(), (short) tp.DW(1).VH());
    }
}
