public class bbm extends ayp implements bbl {
    private ayq EQ;
    private ayh we;

    public static bbm j6(Object obj) {
        if (obj instanceof bbm) {
            return (bbm) obj;
        }
        if (obj != null) {
            return new bbm(ayw.j6(obj));
        }
        return null;
    }

    public bbm(ayw ayw) {
        if (ayw.v5() < 1 || ayw.v5() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + ayw.v5());
        }
        this.EQ = (ayq) ayw.j6(0);
        if (ayw.v5() > 1) {
            azc azc = (azc) ayw.j6(1);
            if (azc.Hw() && azc.FH() == 0) {
                this.we = azc.EQ();
                return;
            }
            throw new IllegalArgumentException("Bad tag for 'content'");
        }
    }

    public bbm(ayq ayq, ayh ayh) {
        this.EQ = ayq;
        this.we = ayh;
    }

    public ayq FH() {
        return this.EQ;
    }

    public ayh Hw() {
        return this.we;
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.EQ);
        if (this.we != null) {
            ayi.j6(new azp(0, this.we));
        }
        return new azl(ayi);
    }
}
