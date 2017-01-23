class awf$a extends awf {
    private final awl DW;
    private final awl j6;

    awf$a(awl awl, awl awl2) {
        this.j6 = awl;
        this.DW = awl2;
    }

    public boolean j6(awc awc) {
        return this.j6.j6(awc) && this.DW.j6(awc);
    }

    public boolean j6() {
        return this.j6.j6() || this.DW.j6();
    }

    public awl DW() {
        return new awf$a(this.j6.DW(), this.DW.DW());
    }

    public String toString() {
        return "(" + this.j6.toString() + " AND " + this.DW.toString() + ")";
    }
}
