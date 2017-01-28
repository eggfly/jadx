import java.util.Enumeration;

public class bbq extends ayp {
    private bbp DW;
    private bcp FH;
    private ayy Hw;
    private ayy VH;
    private ayr Zo;
    private ayn j6;
    private bcp v5;

    public static bbq j6(Object obj) {
        if (obj == null || (obj instanceof bbq)) {
            return (bbq) obj;
        }
        if (obj instanceof ayw) {
            return new bbq((ayw) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public bbq(bbp bbp, bcp bcp, ayy ayy, bcp bcp2, ayr ayr, ayy ayy2) {
        if (bbp.FH()) {
            this.j6 = new ayn(3);
        } else {
            this.j6 = new ayn(1);
        }
        this.DW = bbp;
        this.FH = bcp;
        this.Hw = ayy;
        this.v5 = bcp2;
        this.Zo = ayr;
        this.VH = ayy2;
    }

    public bbq(ayw ayw) {
        Enumeration Hw = ayw.Hw();
        this.j6 = (ayn) Hw.nextElement();
        this.DW = bbp.j6(Hw.nextElement());
        this.FH = bcp.j6(Hw.nextElement());
        Object nextElement = Hw.nextElement();
        if (nextElement instanceof azc) {
            this.Hw = ayy.j6((azc) nextElement, false);
            this.v5 = bcp.j6(Hw.nextElement());
        } else {
            this.Hw = null;
            this.v5 = bcp.j6(nextElement);
        }
        this.Zo = ayr.j6(Hw.nextElement());
        if (Hw.hasMoreElements()) {
            this.VH = ayy.j6((azc) Hw.nextElement(), false);
        } else {
            this.VH = null;
        }
    }

    public ayn FH() {
        return this.j6;
    }

    public bcp Hw() {
        return this.FH;
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        ayi.j6(this.FH);
        if (this.Hw != null) {
            ayi.j6(new baq(false, 0, this.Hw));
        }
        ayi.j6(this.v5);
        ayi.j6(this.Zo);
        if (this.VH != null) {
            ayi.j6(new baq(false, 1, this.VH));
        }
        return new bal(ayi);
    }
}
