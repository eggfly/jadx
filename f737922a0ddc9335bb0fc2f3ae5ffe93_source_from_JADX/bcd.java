import java.math.BigInteger;
import java.util.Enumeration;

public class bcd extends ayp {
    ayn DW;
    ayn FH;
    ayn j6;

    public bcd(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.j6 = new ayn(bigInteger);
        this.DW = new ayn(bigInteger2);
        if (i != 0) {
            this.FH = new ayn(i);
        } else {
            this.FH = null;
        }
    }

    public static bcd j6(Object obj) {
        if (obj instanceof bcd) {
            return (bcd) obj;
        }
        if (obj != null) {
            return new bcd(ayw.j6(obj));
        }
        return null;
    }

    private bcd(ayw ayw) {
        Enumeration Hw = ayw.Hw();
        this.j6 = bad.j6(Hw.nextElement());
        this.DW = bad.j6(Hw.nextElement());
        if (Hw.hasMoreElements()) {
            this.FH = (ayn) Hw.nextElement();
        } else {
            this.FH = null;
        }
    }

    public BigInteger FH() {
        return this.j6.Hw();
    }

    public BigInteger Hw() {
        return this.DW.Hw();
    }

    public BigInteger v5() {
        if (this.FH == null) {
            return null;
        }
        return this.FH.Hw();
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        if (v5() != null) {
            ayi.j6(this.FH);
        }
        return new bal(ayi);
    }
}
