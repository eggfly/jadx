public class azy implements ayh, bba {
    private aza j6;

    public azy(aza aza) {
        this.j6 = aza;
    }

    public ayv v5() {
        try {
            return new azx(this.j6.DW());
        } catch (Throwable e) {
            throw new ayk(e.getMessage(), e);
        }
    }

    public ayv w_() {
        try {
            return v5();
        } catch (Throwable e) {
            throw new ayu("unable to get DER object", e);
        } catch (Throwable e2) {
            throw new ayu("unable to get DER object", e2);
        }
    }
}
