import java.math.BigInteger;

public class bcq extends ayp {
    ayn DW;
    azv j6;

    public static bcq j6(Object obj) {
        if (obj instanceof bcq) {
            return (bcq) obj;
        }
        if (obj instanceof bdb) {
            return j6(bdb.j6((bdb) obj));
        }
        if (obj != null) {
            return new bcq(ayw.j6(obj));
        }
        return null;
    }

    private bcq(ayw ayw) {
        this.j6 = new azv(false);
        this.DW = null;
        if (ayw.v5() == 0) {
            this.j6 = null;
            this.DW = null;
            return;
        }
        if (ayw.j6(0) instanceof azv) {
            this.j6 = azv.j6(ayw.j6(0));
        } else {
            this.j6 = null;
            this.DW = bad.j6((Object) ayw.j6(0));
        }
        if (ayw.v5() <= 1) {
            return;
        }
        if (this.j6 != null) {
            this.DW = bad.j6((Object) ayw.j6(1));
            return;
        }
        throw new IllegalArgumentException("wrong sequence in constructor");
    }

    public boolean FH() {
        return this.j6 != null && this.j6.FH();
    }

    public BigInteger Hw() {
        if (this.DW != null) {
            return this.DW.FH();
        }
        return null;
    }

    public ayv w_() {
        ayi ayi = new ayi();
        if (this.j6 != null) {
            ayi.j6(this.j6);
        }
        if (this.DW != null) {
            ayi.j6(this.DW);
        }
        return new bal(ayi);
    }

    public String toString() {
        if (this.DW != null) {
            return "BasicConstraints: isCa(" + FH() + "), pathLenConstraint = " + this.DW.FH();
        }
        if (this.j6 == null) {
            return "BasicConstraints: isCa(false)";
        }
        return "BasicConstraints: isCa(" + FH() + ")";
    }
}
