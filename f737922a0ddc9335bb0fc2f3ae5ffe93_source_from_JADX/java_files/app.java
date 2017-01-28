final class app extends apv {
    private final aps DW;
    private int FH;
    private final apv j6;

    app(apv apv) {
        this.j6 = apv;
        this.DW = new aps();
    }

    int DW() {
        return this.j6.DW();
    }

    aqc j6() {
        aqc j6;
        while (this.FH < 6) {
            j6 = this.j6.j6();
            if (j6 == null) {
                break;
            }
            this.DW.j6(j6);
            this.FH++;
        }
        j6 = this.DW.j6();
        if (j6 == null) {
            return null;
        }
        this.FH--;
        return j6;
    }
}
