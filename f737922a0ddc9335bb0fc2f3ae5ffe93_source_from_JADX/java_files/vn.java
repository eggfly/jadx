import java.util.BitSet;

public final class vn extends ul {
    public static final ul DW;

    static {
        DW = new vn();
    }

    private vn() {
    }

    public String j6(uf ufVar) {
        zx tp = ufVar.tp();
        return tp.DW(0).J0() + ", " + tp.DW(1).J0() + ", " + ul.Zo(ufVar);
    }

    public String DW(uf ufVar, boolean z) {
        if (z) {
            return ul.VH(ufVar);
        }
        return "";
    }

    public int j6() {
        return 2;
    }

    public boolean DW(uf ufVar) {
        zx tp = ufVar.tp();
        if (!(ufVar instanceof ud) || tp.m_() != 2 || !ul.DW(tp.DW(0).VH()) || !ul.DW(tp.DW(1).VH())) {
            return false;
        }
        ud udVar = (ud) ufVar;
        if (!ul.Zo(udVar.Hw())) {
            return false;
        }
        aah FH = udVar.FH();
        if ((FH instanceof abf) || (FH instanceof aar)) {
            return true;
        }
        return false;
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
        ul.j6(acr, ul.j6(ufVar, ul.DW(tp.DW(0).VH(), tp.DW(1).VH())), (short) ((ud) ufVar).Hw());
    }
}
