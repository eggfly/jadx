public final class ch extends co {
    private int DW;
    private co FH;
    private bt j6;

    protected ch(bw bwVar, bt btVar) {
        super(bwVar, btVar, 16);
        this.j6 = btVar;
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.DW = eeVar.readInt();
        this.FH = (co) this.j6.FH(eeVar.readInt());
    }

    protected void j6(ef efVar) {
        super.j6(efVar);
        efVar.writeInt(this.DW);
        efVar.writeInt(this.j6.j6(this.FH));
    }

    public co j6() {
        return this.FH;
    }

    public int v5() {
        return this.DW;
    }

    public bj Hw() {
        return j6().Hw();
    }
}
