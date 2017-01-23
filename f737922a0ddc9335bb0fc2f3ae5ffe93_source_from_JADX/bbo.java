import com.aide.uidesigner.ProxyTextView;
import java.util.Enumeration;

public class bbo extends ayp {
    private ayy DW;
    private bbm FH;
    private ayy Hw;
    private boolean VH;
    private ayy Zo;
    private boolean gn;
    private ayn j6;
    private ayy v5;

    public static bbo j6(Object obj) {
        if (obj instanceof bbo) {
            return (bbo) obj;
        }
        if (obj != null) {
            return new bbo(ayw.j6(obj));
        }
        return null;
    }

    public bbo(ayy ayy, bbm bbm, ayy ayy2, ayy ayy3, ayy ayy4) {
        this.j6 = j6(bbm.FH(), ayy2, ayy3, ayy4);
        this.DW = ayy;
        this.FH = bbm;
        this.Hw = ayy2;
        this.v5 = ayy3;
        this.Zo = ayy4;
        this.gn = ayy3 instanceof azn;
        this.VH = ayy2 instanceof azn;
    }

    private ayn j6(ayq ayq, ayy ayy, ayy ayy2, ayy ayy3) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (ayy != null) {
            Enumeration FH = ayy.FH();
            i = 0;
            i2 = 0;
            i3 = 0;
            while (FH.hasMoreElements()) {
                Object nextElement = FH.nextElement();
                if (nextElement instanceof azc) {
                    azc j6 = azc.j6(nextElement);
                    if (j6.FH() == 1) {
                        i2 = 1;
                    } else if (j6.FH() == 2) {
                        i = 1;
                    } else if (j6.FH() == 3) {
                        i3 = 1;
                    }
                }
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        if (i3 != 0) {
            return new ayn(5);
        }
        if (ayy2 != null) {
            Enumeration FH2 = ayy2.FH();
            while (FH2.hasMoreElements()) {
                if (FH2.nextElement() instanceof azc) {
                    i4 = 1;
                }
            }
        }
        if (i4 != 0) {
            return new ayn(5);
        }
        if (i != 0) {
            return new ayn(4);
        }
        if (i2 != 0) {
            return new ayn(3);
        }
        if (j6(ayy3)) {
            return new ayn(3);
        }
        if (bbl.j6.equals(ayq)) {
            return new ayn(1);
        }
        return new ayn(3);
    }

    private boolean j6(ayy ayy) {
        Enumeration FH = ayy.FH();
        while (FH.hasMoreElements()) {
            if (bbq.j6(FH.nextElement()).FH().FH().intValue() == 3) {
                return true;
            }
        }
        return false;
    }

    private bbo(ayw ayw) {
        Enumeration Hw = ayw.Hw();
        this.j6 = bad.j6(Hw.nextElement());
        this.DW = (ayy) Hw.nextElement();
        this.FH = bbm.j6(Hw.nextElement());
        while (Hw.hasMoreElements()) {
            ayv ayv = (ayv) Hw.nextElement();
            if (ayv instanceof azc) {
                azc azc = (azc) ayv;
                switch (azc.FH()) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        this.VH = azc instanceof azp;
                        this.Hw = ayy.j6(azc, false);
                        break;
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        this.gn = azc instanceof azp;
                        this.v5 = ayy.j6(azc, false);
                        break;
                    default:
                        throw new IllegalArgumentException("unknown tag value " + azc.FH());
                }
            }
            this.Zo = (ayy) ayv;
        }
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        ayi.j6(this.FH);
        if (this.Hw != null) {
            if (this.VH) {
                ayi.j6(new azp(false, 0, this.Hw));
            } else {
                ayi.j6(new baq(false, 0, this.Hw));
            }
        }
        if (this.v5 != null) {
            if (this.gn) {
                ayi.j6(new azp(false, 1, this.v5));
            } else {
                ayi.j6(new baq(false, 1, this.v5));
            }
        }
        ayi.j6(this.Zo);
        return new azl(ayi);
    }
}
