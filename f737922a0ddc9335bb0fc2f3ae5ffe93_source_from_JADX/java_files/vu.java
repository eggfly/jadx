import java.util.BitSet;

public final class vu extends ul {
    public static final ul DW;

    static {
        DW = new vu();
    }

    private vu() {
    }

    public String j6(uf ufVar) {
        return ufVar.tp().DW(0).J0() + ", " + ul.j6((aay) ((ud) ufVar).FH());
    }

    public String DW(uf ufVar, boolean z) {
        return ul.j6((aay) ((ud) ufVar).FH(), 32);
    }

    public int j6() {
        return 3;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if (!(ufVar instanceof ud) || tp.m_() != 1 || !ul.Hw(tp.DW(0).VH())) {
            return false;
        }
        aah FH = ((ud) ufVar).FH();
        if (FH instanceof aay) {
            return ((aay) FH).u7();
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
        ul.j6(acr, ul.j6(ufVar, tp.DW(0).VH()), ((aay) ((ud) ufVar).FH()).tp());
    }
}
