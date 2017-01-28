import com.aide.uidesigner.ProxyTextView;
import java.util.BitSet;

public final class vg extends ul {
    public static final ul DW;

    static {
        DW = new vg();
    }

    private vg() {
    }

    public String j6(uf ufVar) {
        zx tp = ufVar.tp();
        int m_ = tp.m_();
        return tp.DW(m_ - 2).J0() + ", " + tp.DW(m_ - 1).J0();
    }

    public String DW(uf ufVar, boolean z) {
        return "";
    }

    public int j6() {
        return 1;
    }

    public boolean DW(uf ufVar) {
        if (!(ufVar instanceof uw)) {
            return false;
        }
        zw DW;
        boolean z;
        zx tp = ufVar.tp();
        zw DW2;
        switch (tp.m_()) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                DW = tp.DW(0);
                DW2 = tp.DW(1);
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                DW = tp.DW(1);
                DW2 = tp.DW(2);
                if (DW.VH() != tp.DW(0).VH()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        if (ul.DW(DW.VH()) && ul.DW(r0.VH())) {
            z = true;
        } else {
            z = false;
        }
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
        int m_ = tp.m_();
        ul.j6(acr, ul.j6(ufVar, ul.DW(tp.DW(m_ - 2).VH(), tp.DW(m_ - 1).VH())));
    }
}
