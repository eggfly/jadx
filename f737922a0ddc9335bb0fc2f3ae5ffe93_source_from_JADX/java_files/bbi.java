public class bbi extends ayp {
    private ayy DW;
    private ayq j6;

    public static bbi j6(Object obj) {
        if (obj instanceof bbi) {
            return (bbi) obj;
        }
        if (obj != null) {
            return new bbi(ayw.j6(obj));
        }
        return null;
    }

    private bbi(ayw ayw) {
        this.j6 = (ayq) ayw.j6(0);
        this.DW = (ayy) ayw.j6(1);
    }

    public bbi(ayq ayq, ayy ayy) {
        this.j6 = ayq;
        this.DW = ayy;
    }

    public ayq FH() {
        return this.j6;
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        return new bal(ayi);
    }
}
