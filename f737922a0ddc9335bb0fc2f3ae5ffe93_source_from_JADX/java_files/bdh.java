import java.util.Enumeration;

public class bdh extends ayp {
    private ayn DW;
    private ayn FH;
    private ayn Hw;
    private ayn j6;
    private bdi v5;

    public static bdh j6(Object obj) {
        if (obj == null || (obj instanceof bdh)) {
            return (bdh) obj;
        }
        if (obj instanceof ayw) {
            return new bdh((ayw) obj);
        }
        throw new IllegalArgumentException("Invalid DHDomainParameters: " + obj.getClass().getName());
    }

    private bdh(ayw ayw) {
        if (ayw.v5() < 3 || ayw.v5() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + ayw.v5());
        }
        Enumeration Hw = ayw.Hw();
        this.j6 = bad.j6(Hw.nextElement());
        this.DW = bad.j6(Hw.nextElement());
        this.FH = bad.j6(Hw.nextElement());
        ayh j6 = j6(Hw);
        if (j6 != null && (j6 instanceof ayn)) {
            this.Hw = bad.j6((Object) j6);
            j6 = j6(Hw);
        }
        if (j6 != null) {
            this.v5 = bdi.j6(j6.w_());
        }
    }

    private static ayh j6(Enumeration enumeration) {
        return enumeration.hasMoreElements() ? (ayh) enumeration.nextElement() : null;
    }

    public ayn FH() {
        return this.j6;
    }

    public ayn Hw() {
        return this.DW;
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        ayi.j6(this.FH);
        if (this.Hw != null) {
            ayi.j6(this.Hw);
        }
        if (this.v5 != null) {
            ayi.j6(this.v5);
        }
        return new bal(ayi);
    }
}
