import com.aide.uidesigner.ProxyTextView;
import java.util.Arrays;

public final class we extends xl {
    private static final we$a j6;
    private final zc DW;
    private xu FH;
    private byte[] Hw;

    static {
        j6 = new we$a();
    }

    public static void j6(we[] weVarArr) {
        Arrays.sort(weVarArr, j6);
    }

    public we(zc zcVar) {
        super(1, -1);
        if (zcVar == null) {
            throw new NullPointerException("annotation == null");
        }
        this.DW = zcVar;
        this.FH = null;
        this.Hw = null;
    }

    public xd j6() {
        return xd.TYPE_ANNOTATION_ITEM;
    }

    public int hashCode() {
        return this.DW.hashCode();
    }

    protected int j6(xl xlVar) {
        return this.DW.j6(((we) xlVar).DW);
    }

    public String DW() {
        return this.DW.Hw();
    }

    public void j6(wq wqVar) {
        this.FH = wqVar.tp().j6(this.DW.DW());
        xz.j6(wqVar, this.DW);
    }

    protected void j6(xp xpVar, int i) {
        Object acv = new acv();
        new xz(xpVar.v5(), acv).j6(this.DW, false);
        this.Hw = acv.Zo();
        j6(this.Hw.length + 1);
    }

    public void j6(acr acr, String str) {
        acr.j6(0, str + "visibility: " + this.DW.v5().Hw());
        acr.j6(0, str + "type: " + this.DW.DW().Hw());
        for (zg zgVar : this.DW.Zo()) {
            acr.j6(0, str + zgVar.j6().Hw() + ": " + xz.DW(zgVar.DW()));
        }
    }

    protected void a_(wq wqVar, acr acr) {
        boolean j6 = acr.j6();
        zd v5 = this.DW.v5();
        if (j6) {
            acr.j6(0, VH() + " annotation");
            acr.j6(1, "  visibility: VISBILITY_" + v5);
        }
        switch (we$1.j6[v5.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                acr.FH(0);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                acr.FH(1);
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                acr.FH(2);
                break;
            default:
                throw new RuntimeException("shouldn't happen");
        }
        if (j6) {
            new xz(wqVar, acr).j6(this.DW, true);
        } else {
            acr.j6(this.Hw);
        }
    }
}
