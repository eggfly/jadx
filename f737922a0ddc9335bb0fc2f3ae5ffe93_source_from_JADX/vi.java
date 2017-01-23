import com.aide.uidesigner.ProxyTextView;
import java.util.BitSet;

public final class vi extends ul {
    public static final ul DW;

    static {
        DW = new vi();
    }

    private vi() {
    }

    public String j6(uf ufVar) {
        return ufVar.tp().DW(0).J0() + ", " + ul.Zo(ufVar);
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
        if (!(ufVar instanceof ud)) {
            return false;
        }
        zw DW;
        zx tp = ufVar.tp();
        switch (tp.m_()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                DW = tp.DW(0);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                DW = tp.DW(0);
                if (DW.VH() != tp.DW(1).VH()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        if (!ul.Hw(DW.VH())) {
            return false;
        }
        ud udVar = (ud) ufVar;
        int Hw = udVar.Hw();
        aah FH = udVar.FH();
        if (!ul.Zo(Hw)) {
            return false;
        }
        boolean z;
        if ((FH instanceof abf) || (FH instanceof aar) || (FH instanceof abe)) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public BitSet FH(uf ufVar) {
        zx tp = ufVar.tp();
        int m_ = tp.m_();
        BitSet bitSet = new BitSet(m_);
        boolean Hw = ul.Hw(tp.DW(0).VH());
        if (m_ == 1) {
            bitSet.set(0, Hw);
        } else if (tp.DW(0).VH() == tp.DW(1).VH()) {
            bitSet.set(0, Hw);
            bitSet.set(1, Hw);
        }
        return bitSet;
    }

    public void j6(acr acr, uf ufVar) {
        ul.j6(acr, ul.j6(ufVar, ufVar.tp().DW(0).VH()), (short) ((ud) ufVar).Hw());
    }
}
