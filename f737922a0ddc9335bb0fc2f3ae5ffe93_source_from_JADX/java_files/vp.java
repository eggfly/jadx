import java.util.BitSet;

public final class vp extends ul {
    public static final ul DW;

    static {
        DW = new vp();
    }

    private vp() {
    }

    public String j6(uf ufVar) {
        zx tp = ufVar.tp();
        return tp.DW(0).J0() + ", " + tp.DW(1).J0() + ", " + ul.Hw(ufVar);
    }

    public String DW(uf ufVar, boolean z) {
        return ul.v5(ufVar);
    }

    public int j6() {
        return 2;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if (!(ufVar instanceof uz) || tp.m_() != 2 || !ul.DW(tp.DW(0).VH()) || !ul.DW(tp.DW(1).VH())) {
            return false;
        }
        uz uzVar = (uz) ufVar;
        if (uzVar.Ws()) {
            return j6(uzVar);
        }
        return true;
    }

    public BitSet FH(uf ufVar) {
        zx tp = ufVar.tp();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, ul.DW(tp.DW(0).VH()));
        bitSet.set(1, ul.DW(tp.DW(1).VH()));
        return bitSet;
    }

    public boolean j6(uz uzVar) {
        int v5 = uzVar.v5();
        return v5 != 0 && ul.v5(v5);
    }

    public void j6(acr acr, uf ufVar) {
        zx tp = ufVar.tp();
        ul.j6(acr, ul.j6(ufVar, ul.DW(tp.DW(0).VH(), tp.DW(1).VH())), (short) ((uz) ufVar).v5());
    }
}
