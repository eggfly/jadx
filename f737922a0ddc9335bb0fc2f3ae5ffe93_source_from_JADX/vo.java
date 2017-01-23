import java.util.BitSet;

public final class vo extends ul {
    public static final ul DW;

    static {
        DW = new vo();
    }

    private vo() {
    }

    public String j6(uf ufVar) {
        zx tp = ufVar.tp();
        return tp.DW(0).J0() + ", " + tp.DW(1).J0() + ", " + ul.j6((aay) ((ud) ufVar).FH());
    }

    public String DW(uf ufVar, boolean z) {
        return ul.j6((aay) ((ud) ufVar).FH(), 16);
    }

    public int j6() {
        return 2;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if (!(ufVar instanceof ud) || tp.m_() != 2 || !ul.DW(tp.DW(0).VH()) || !ul.DW(tp.DW(1).VH())) {
            return false;
        }
        aah FH = ((ud) ufVar).FH();
        if (!(FH instanceof aay)) {
            return false;
        }
        aay aay = (aay) FH;
        boolean z = aay.u7() && ul.v5(aay.tp());
        return z;
    }

    public BitSet FH(uf ufVar) {
        zx tp = ufVar.tp();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, ul.DW(tp.DW(0).VH()));
        bitSet.set(1, ul.DW(tp.DW(1).VH()));
        return bitSet;
    }

    public void j6(acr acr, uf ufVar) {
        zx tp = ufVar.tp();
        ul.j6(acr, ul.j6(ufVar, ul.DW(tp.DW(0).VH(), tp.DW(1).VH())), (short) ((aay) ((ud) ufVar).FH()).tp());
    }
}
