import java.util.BitSet;

public final class wb extends ul {
    public static final ul DW;

    static {
        DW = new wb();
    }

    private wb() {
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
        return 5;
    }

    public boolean DW(uf ufVar) {
        if (!j6) {
            return false;
        }
        zx tp = ufVar.tp();
        if (!(ufVar instanceof ud) || tp.m_() != 2 || !ul.Zo(tp.DW(0).VH()) || !ul.Zo(tp.DW(1).VH())) {
            return false;
        }
        aah FH = ((ud) ufVar).FH();
        if ((FH instanceof abf) || (FH instanceof aar)) {
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
        ul.j6(acr, ul.gn(ufVar), ((ud) ufVar).Hw(), (short) tp.DW(0).VH(), (short) tp.DW(1).VH());
    }
}
