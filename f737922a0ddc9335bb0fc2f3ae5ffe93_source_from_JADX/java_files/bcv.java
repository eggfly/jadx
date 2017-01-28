import java.util.Enumeration;

public class bcv extends ayp {
    private azu DW;
    private bcp j6;

    public static bcv j6(Object obj) {
        if (obj instanceof bcv) {
            return (bcv) obj;
        }
        if (obj != null) {
            return new bcv(ayw.j6(obj));
        }
        return null;
    }

    public bcv(bcp bcp, ayh ayh) {
        this.DW = new azu(ayh);
        this.j6 = bcp;
    }

    public bcv(ayw ayw) {
        if (ayw.v5() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + ayw.v5());
        }
        Enumeration Hw = ayw.Hw();
        this.j6 = bcp.j6(Hw.nextElement());
        this.DW = azu.j6(Hw.nextElement());
    }

    public bcp FH() {
        return this.j6;
    }

    public ayv Hw() {
        return new aym(this.DW.FH()).Hw();
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        return new bal(ayi);
    }
}
