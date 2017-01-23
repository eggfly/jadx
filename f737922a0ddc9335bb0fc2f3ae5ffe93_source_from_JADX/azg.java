public class azg implements aye {
    private final aza DW;
    private final int j6;

    azg(int i, aza aza) {
        this.j6 = i;
        this.DW = aza;
    }

    public ayv v5() {
        return new azf(this.j6, this.DW.DW());
    }

    public ayv w_() {
        try {
            return v5();
        } catch (Throwable e) {
            throw new ayu(e.getMessage(), e);
        }
    }
}
