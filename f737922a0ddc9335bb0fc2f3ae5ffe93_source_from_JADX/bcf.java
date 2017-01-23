import java.util.Enumeration;

public class bcf extends ayp {
    private bcp DW;
    private ayy FH;
    private ayr j6;

    public static bcf j6(Object obj) {
        if (obj instanceof bcf) {
            return (bcf) obj;
        }
        if (obj != null) {
            return new bcf(ayw.j6(obj));
        }
        return null;
    }

    public bcf(bcp bcp, ayh ayh) {
        this(bcp, ayh, null);
    }

    public bcf(bcp bcp, ayh ayh, ayy ayy) {
        this.j6 = new bah(ayh.w_().j6("DER"));
        this.DW = bcp;
        this.FH = ayy;
    }

    public bcf(ayw ayw) {
        Enumeration Hw = ayw.Hw();
        if (((ayn) Hw.nextElement()).FH().intValue() != 0) {
            throw new IllegalArgumentException("wrong version for private key info");
        }
        this.DW = bcp.j6(Hw.nextElement());
        this.j6 = ayr.j6(Hw.nextElement());
        if (Hw.hasMoreElements()) {
            this.FH = ayy.j6((azc) Hw.nextElement(), false);
        }
    }

    public bcp FH() {
        return this.DW;
    }

    public ayh Hw() {
        return ayv.j6(this.j6.Hw());
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(new ayn(0));
        ayi.j6(this.DW);
        ayi.j6(this.j6);
        if (this.FH != null) {
            ayi.j6(new baq(false, 0, this.FH));
        }
        return new bal(ayi);
    }
}
