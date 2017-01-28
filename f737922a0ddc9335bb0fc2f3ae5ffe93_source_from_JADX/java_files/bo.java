public final class bo extends co {
    private int DW;
    private co FH;
    private int Hw;
    private bt j6;

    protected bo(bw bwVar, bt btVar) {
        super(bwVar, btVar, 16);
        this.j6 = btVar;
    }

    protected bo(bw bwVar, bt btVar, co coVar, int i) {
        super(bwVar, btVar, 16);
        this.j6 = btVar;
        this.DW = btVar.DW((bs) this);
        this.FH = coVar;
        this.Hw = i;
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.DW = eeVar.readInt();
        this.FH = (co) this.j6.FH(eeVar.readInt());
        this.Hw = eeVar.readInt();
    }

    protected void j6(ef efVar) {
        super.j6(efVar);
        efVar.writeInt(this.DW);
        efVar.writeInt(this.j6.j6(this.FH));
        efVar.writeInt(this.Hw);
    }

    public co j6() {
        co FH = FH();
        while (FH.AL()) {
            FH = ((bo) FH).FH();
        }
        return FH;
    }

    public int DW() {
        return this.Hw;
    }

    public co FH() {
        return this.FH;
    }

    public bj Hw() {
        return FH().Hw();
    }

    public int v5() {
        return this.DW;
    }
}
