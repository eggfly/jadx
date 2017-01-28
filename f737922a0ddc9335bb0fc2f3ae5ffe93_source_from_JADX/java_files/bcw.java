import com.aide.uidesigner.ProxyTextView;

public class bcw extends ayp {
    ayn DW;
    azu EQ;
    ayn FH;
    bcp Hw;
    bcy VH;
    bcy Zo;
    bcl gn;
    ayw j6;
    azu tp;
    bcv u7;
    bcl v5;
    bct we;

    public static bcw j6(Object obj) {
        if (obj instanceof bcw) {
            return (bcw) obj;
        }
        if (obj != null) {
            return new bcw(ayw.j6(obj));
        }
        return null;
    }

    private bcw(ayw ayw) {
        int i;
        this.j6 = ayw;
        if (ayw.j6(0) instanceof baq) {
            this.DW = bad.j6((azc) ayw.j6(0), true);
            i = 0;
        } else {
            this.DW = new ayn(0);
            i = -1;
        }
        this.FH = bad.j6((Object) ayw.j6(i + 1));
        this.Hw = bcp.j6(ayw.j6(i + 2));
        this.v5 = bcl.j6(ayw.j6(i + 3));
        ayw ayw2 = (ayw) ayw.j6(i + 4);
        this.Zo = bcy.j6(ayw2.j6(0));
        this.VH = bcy.j6(ayw2.j6(1));
        this.gn = bcl.j6(ayw.j6(i + 5));
        this.u7 = bcv.j6(ayw.j6(i + 6));
        for (int v5 = (ayw.v5() - (i + 6)) - 1; v5 > 0; v5--) {
            azc azc = (baq) ayw.j6((i + 6) + v5);
            switch (azc.FH()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.tp = azu.j6(azc, false);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.EQ = azu.j6(azc, false);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.we = bct.j6(ayw.j6(azc, true));
                    break;
                default:
                    break;
            }
        }
    }

    public ayn FH() {
        return this.FH;
    }

    public bcl Hw() {
        return this.v5;
    }

    public bct v5() {
        return this.we;
    }

    public ayv w_() {
        return this.j6;
    }
}
