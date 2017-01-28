import java.util.BitSet;

public final class vm extends ul {
    public static final ul DW;

    static {
        DW = new vm();
    }

    private vm() {
    }

    public String j6(uf ufVar) {
        zx tp = ufVar.tp();
        return tp.DW(0).J0() + ", " + tp.DW(1).J0() + ", " + ul.j6((aay) ((ud) ufVar).FH());
    }

    public String DW(uf ufVar, boolean z) {
        return ul.j6((aay) ((ud) ufVar).FH(), 8);
    }

    public int j6() {
        return 2;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if (!(ufVar instanceof ud) || tp.m_() != 2 || !ul.Hw(tp.DW(0).VH()) || !ul.Hw(tp.DW(1).VH())) {
            return false;
        }
        aah FH = ((ud) ufVar).FH();
        if (!(FH instanceof aay)) {
            return false;
        }
        aay aay = (aay) FH;
        boolean z = aay.u7() && ul.FH(aay.tp());
        return z;
    }

    public BitSet FH(uf ufVar) {
        zx tp = ufVar.tp();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, ul.Hw(tp.DW(0).VH()));
        bitSet.set(1, ul.Hw(tp.DW(1).VH()));
        return bitSet;
    }

    public void j6(acr acr, uf ufVar) {
        zx tp = ufVar.tp();
        ul.j6(acr, ul.j6(ufVar, tp.DW(0).VH()), ul.j6(tp.DW(1).VH(), ((aay) ((ud) ufVar).FH()).tp() & 255));
    }
}
