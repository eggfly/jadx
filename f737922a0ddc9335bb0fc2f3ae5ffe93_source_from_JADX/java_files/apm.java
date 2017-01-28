abstract class apm extends apj {
    protected apm$b FH;

    protected apm() {
        this.FH = new apm$b();
    }

    apm(apv apv) {
        this.FH = new apm$b();
        this.DW = apv.DW();
        apv.j6(this);
        while (true) {
            aqc j6 = apv.j6();
            if (j6 != null) {
                j6(j6);
            } else {
                return;
            }
        }
    }

    public void j6(apm apm) {
        this.FH = apm.FH;
    }
}
