import com.aide.uidesigner.ProxyTextView;

public class bcg extends ayp {
    public static final bcp DW;
    public static final ayn FH;
    public static final ayn Hw;
    public static final bcp j6;
    private ayn VH;
    private bcp Zo;
    private ayn gn;
    private bcp v5;

    static {
        j6 = new bcp(bcc.u7, new bae());
        DW = new bcp(bce.f_, j6);
        FH = new ayn(20);
        Hw = new ayn(1);
    }

    public static bcg j6(Object obj) {
        if (obj instanceof bcg) {
            return (bcg) obj;
        }
        if (obj != null) {
            return new bcg(ayw.j6(obj));
        }
        return null;
    }

    public bcg() {
        this.v5 = j6;
        this.Zo = DW;
        this.VH = FH;
        this.gn = Hw;
    }

    public bcg(bcp bcp, bcp bcp2, ayn ayn, ayn ayn2) {
        this.v5 = bcp;
        this.Zo = bcp2;
        this.VH = ayn;
        this.gn = ayn2;
    }

    private bcg(ayw ayw) {
        this.v5 = j6;
        this.Zo = DW;
        this.VH = FH;
        this.gn = Hw;
        for (int i = 0; i != ayw.v5(); i++) {
            azc azc = (azc) ayw.j6(i);
            switch (azc.FH()) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    this.v5 = bcp.j6(azc, true);
                    break;
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.Zo = bcp.j6(azc, true);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.VH = bad.j6(azc, true);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.gn = bad.j6(azc, true);
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag");
            }
        }
    }

    public bcp FH() {
        return this.v5;
    }

    public ayv w_() {
        ayi ayi = new ayi();
        if (!this.v5.equals(j6)) {
            ayi.j6(new baq(true, 0, this.v5));
        }
        if (!this.Zo.equals(DW)) {
            ayi.j6(new baq(true, 1, this.Zo));
        }
        if (!this.VH.equals(FH)) {
            ayi.j6(new baq(true, 2, this.VH));
        }
        if (!this.gn.equals(Hw)) {
            ayi.j6(new baq(true, 3, this.gn));
        }
        return new bal(ayi);
    }
}
