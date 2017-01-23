class awj$b extends awl {
    private final byte[] DW;
    private final awi j6;

    private awj$b(awi awi) {
        this.j6 = awi;
        this.DW = this.j6.DW;
    }

    public boolean j6(awc awc) {
        int j6 = awc.j6(this.DW, this.DW.length);
        if (j6 <= 0) {
            return j6 == 0;
        } else {
            throw alv.j6;
        }
    }

    public boolean j6() {
        return this.j6.j6();
    }

    public awl DW() {
        return this;
    }

    public String toString() {
        return "FAST_" + this.j6.toString();
    }
}
