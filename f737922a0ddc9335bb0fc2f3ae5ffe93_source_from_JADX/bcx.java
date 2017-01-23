import com.aide.uidesigner.ProxyTextView;

public class bcx extends ayp implements bce, bdg {
    ayw E4;
    bdc Ej;
    bcl GK;
    bcl GT;
    bcv Hl;
    bcp PH;
    bcy Yi;
    bcy dW;
    ayn hp;
    azu oh;
    azu pl;
    ayn xg;

    public static bcx j6(Object obj) {
        if (obj instanceof bcx) {
            return (bcx) obj;
        }
        if (obj != null) {
            return new bcx(ayw.j6(obj));
        }
        return null;
    }

    public bcx(ayw ayw) {
        int i;
        this.E4 = ayw;
        if (ayw.j6(0) instanceof baq) {
            this.xg = bad.j6((azc) ayw.j6(0), true);
            i = 0;
        } else {
            this.xg = new ayn(0);
            i = -1;
        }
        this.hp = bad.j6((Object) ayw.j6(i + 1));
        this.PH = bcp.j6(ayw.j6(i + 2));
        this.GK = bcl.j6(ayw.j6(i + 3));
        ayw ayw2 = (ayw) ayw.j6(i + 4);
        this.dW = bcy.j6(ayw2.j6(0));
        this.Yi = bcy.j6(ayw2.j6(1));
        this.GT = bcl.j6(ayw.j6(i + 5));
        this.Hl = bcv.j6(ayw.j6(i + 6));
        for (int v5 = (ayw.v5() - (i + 6)) - 1; v5 > 0; v5--) {
            Object obj = (baq) ayw.j6((i + 6) + v5);
            switch (obj.FH()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.pl = azu.j6((azc) obj, false);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.oh = azu.j6((azc) obj, false);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.Ej = bdc.j6(obj);
                    break;
                default:
                    break;
            }
        }
    }

    public int FH() {
        return this.xg.FH().intValue() + 1;
    }

    public ayn Hw() {
        return this.hp;
    }

    public bcp v5() {
        return this.PH;
    }

    public bcl Zo() {
        return this.GK;
    }

    public bcy VH() {
        return this.dW;
    }

    public bcy gn() {
        return this.Yi;
    }

    public bcl u7() {
        return this.GT;
    }

    public bcv tp() {
        return this.Hl;
    }

    public azu EQ() {
        return this.pl;
    }

    public azu we() {
        return this.oh;
    }

    public bdc J0() {
        return this.Ej;
    }

    public ayv w_() {
        return this.E4;
    }
}
