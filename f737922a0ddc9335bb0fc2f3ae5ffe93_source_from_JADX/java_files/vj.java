import java.util.BitSet;

public final class vj extends ul {
    public static final ul DW;

    static {
        DW = new vj();
    }

    private vj() {
    }

    public String j6(uf ufVar) {
        return ufVar.tp().DW(0).J0() + ", " + ul.j6((aay) ((ud) ufVar).FH());
    }

    public String DW(uf ufVar, boolean z) {
        return ul.j6((aay) ((ud) ufVar).FH(), ufVar.tp().DW(0).EQ() == 1 ? 32 : 64);
    }

    public int j6() {
        return 2;
    }

    public boolean DW(uf ufVar) {
        boolean z = true;
        zx tp = ufVar.tp();
        if (!(ufVar instanceof ud) || tp.m_() != 1 || !ul.Hw(tp.DW(0).VH())) {
            return false;
        }
        aah FH = ((ud) ufVar).FH();
        if (!(FH instanceof aay)) {
            return false;
        }
        aay aay = (aay) FH;
        if (tp.DW(0).EQ() == 1) {
            return (aay.tp() & 65535) == 0;
        }
        if ((aay.EQ() & 281474976710655L) != 0) {
            z = false;
        }
        return z;
    }

    public BitSet FH(uf ufVar) {
        zx tp = ufVar.tp();
        BitSet bitSet = new BitSet(1);
        bitSet.set(0, ul.Hw(tp.DW(0).VH()));
        return bitSet;
    }

    public void j6(acr acr, uf ufVar) {
        short tp;
        zx tp2 = ufVar.tp();
        aay aay = (aay) ((ud) ufVar).FH();
        if (tp2.DW(0).EQ() == 1) {
            tp = (short) (aay.tp() >>> 16);
        } else {
            tp = (short) ((int) (aay.EQ() >>> 48));
        }
        ul.j6(acr, ul.j6(ufVar, tp2.DW(0).VH()), tp);
    }
}
