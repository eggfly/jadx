public class bbp extends ayp implements ayg {
    private ayh j6;

    public bbp(bbn bbn) {
        this.j6 = bbn;
    }

    public bbp(ayr ayr) {
        this.j6 = new baq(false, 0, ayr);
    }

    public bbp(ayv ayv) {
        this.j6 = ayv;
    }

    public static bbp j6(Object obj) {
        if (obj == null || (obj instanceof bbp)) {
            return (bbp) obj;
        }
        if (obj instanceof bbn) {
            return new bbp((bbn) obj);
        }
        if (obj instanceof ayr) {
            return new bbp((ayr) obj);
        }
        if (obj instanceof ayv) {
            return new bbp((ayv) obj);
        }
        throw new IllegalArgumentException("Illegal object in SignerIdentifier: " + obj.getClass().getName());
    }

    public boolean FH() {
        return this.j6 instanceof azc;
    }

    public ayv w_() {
        return this.j6.w_();
    }
}
