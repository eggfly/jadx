public class bdi extends ayp {
    private ayn DW;
    private azu j6;

    public static bdi j6(Object obj) {
        if (obj == null || (obj instanceof bdh)) {
            return (bdi) obj;
        }
        if (obj instanceof ayw) {
            return new bdi((ayw) obj);
        }
        throw new IllegalArgumentException("Invalid DHValidationParms: " + obj.getClass().getName());
    }

    private bdi(ayw ayw) {
        if (ayw.v5() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + ayw.v5());
        }
        this.j6 = azu.j6(ayw.j6(0));
        this.DW = bad.j6((Object) ayw.j6(1));
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        ayi.j6(this.DW);
        return new bal(ayi);
    }
}
