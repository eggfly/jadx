import java.util.BitSet;

public final class vv extends ul {
    public static final ul DW;

    static {
        DW = new vv();
    }

    private vv() {
    }

    public String j6(uf ufVar) {
        return ufVar.tp().DW(0).J0() + ", " + ul.Hw(ufVar);
    }

    public String DW(uf ufVar, boolean z) {
        return ul.v5(ufVar);
    }

    public int j6() {
        return 3;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if ((ufVar instanceof uz) && tp.m_() == 1 && ul.Hw(tp.DW(0).VH())) {
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

    public boolean j6(uz uzVar) {
        return true;
    }

    public void j6(acr acr, uf ufVar) {
        zx tp = ufVar.tp();
        ul.j6(acr, ul.j6(ufVar, tp.DW(0).VH()), ((uz) ufVar).v5());
    }
}
