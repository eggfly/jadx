public final class cb extends co {
    private int DW;
    private ca FH;
    private bt j6;

    protected cb(bw bwVar, bt btVar) {
        super(bwVar, btVar, 16);
        this.j6 = btVar;
    }

    protected cb(bw bwVar, bt btVar, ca caVar) {
        super(bwVar, btVar, 16);
        this.j6 = btVar;
        this.DW = btVar.DW((bs) this);
        this.FH = caVar;
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.DW = eeVar.readInt();
        this.FH = (ca) this.j6.FH(eeVar.readInt());
    }

    public int v5() {
        return this.DW;
    }

    protected void j6(ef efVar) {
        super.j6(efVar);
        efVar.writeInt(this.DW);
        efVar.writeInt(this.j6.j6(this.FH));
    }

    public bj Hw() {
        return j6().Hw();
    }

    public ca j6() {
        return this.FH;
    }
}
