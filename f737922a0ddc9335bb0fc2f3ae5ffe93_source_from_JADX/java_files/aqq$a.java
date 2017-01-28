class aqq$a extends aqq {
    private final boolean VH;
    private final aqt Zo;
    private final aqt j6;

    aqq$a(aqt aqt, aqt aqt2) {
        this.j6 = aqt;
        this.Zo = aqt2;
        boolean z = this.j6.DW() || this.Zo.DW();
        this.VH = z;
    }

    public boolean j6(aql aql, aqc aqc) {
        return this.j6.j6(aql, aqc) && this.Zo.j6(aql, aqc);
    }

    public boolean DW() {
        return this.VH;
    }

    public aqt j6() {
        return new aqq$a(this.j6.j6(), this.Zo.j6());
    }

    public String toString() {
        return "(" + this.j6.toString() + " AND " + this.Zo.toString() + ")";
    }
}
