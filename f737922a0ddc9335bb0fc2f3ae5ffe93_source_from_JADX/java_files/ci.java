public final class ci extends co {
    private final bt DW;
    private int FH;
    private final bw j6;

    protected ci(bt btVar, bw bwVar, int i, bj bjVar) {
        super(bwVar, btVar, i);
        this.j6 = bwVar;
        this.DW = btVar;
        this.FH = btVar.DW((bs) this);
        j6(bjVar);
    }

    protected ci(bt btVar, bw bwVar) {
        super(bwVar, btVar);
        this.j6 = bwVar;
        this.DW = btVar;
    }

    protected void j6(ee eeVar) {
        super.j6(eeVar);
        this.FH = eeVar.readInt();
    }

    protected void j6(ef efVar) {
        super.j6(efVar);
        efVar.writeInt(this.FH);
    }

    public int v5() {
        return this.FH;
    }
}
