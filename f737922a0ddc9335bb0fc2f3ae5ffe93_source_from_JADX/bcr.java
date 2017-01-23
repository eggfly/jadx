public class bcr extends ayp {
    bcw DW;
    bcp FH;
    azu Hw;
    ayw j6;

    public static bcr j6(Object obj) {
        if (obj instanceof bcr) {
            return (bcr) obj;
        }
        if (obj != null) {
            return new bcr(ayw.j6(obj));
        }
        return null;
    }

    private bcr(ayw ayw) {
        this.j6 = ayw;
        if (ayw.v5() == 3) {
            this.DW = bcw.j6(ayw.j6(0));
            this.FH = bcp.j6(ayw.j6(1));
            this.Hw = azu.j6(ayw.j6(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    public bcw FH() {
        return this.DW;
    }

    public ayn Hw() {
        return this.DW.FH();
    }

    public bcl v5() {
        return this.DW.Hw();
    }

    public ayv w_() {
        return this.j6;
    }
}
