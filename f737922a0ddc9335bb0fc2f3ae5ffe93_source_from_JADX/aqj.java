public class aqj extends aqg {
    private aqg VH;
    private byte[] gn;
    private String u7;

    protected aqj(anb anb) {
        super(anb);
    }

    void j6(aql aql) {
        j6(aql, aql.v5((aqg) this));
    }

    void DW(aql aql) {
        if (this.gn == null) {
            this.gn = aql.v5((aqg) this);
            if ((this.we & 1) == 0) {
                j6(aql, this.gn);
            }
        }
    }

    void j6(aql aql, byte[] bArr) {
        axa axa = new axa();
        axa.j6 = 53;
        int j6 = anj.j6(this, bArr, (byte) 10, axa);
        aql.FH.v5(bArr, 7);
        this.VH = aql.j6(aql.FH, j6);
        j6 = axa.j6 + 4;
        axa.j6 = j6;
        this.u7 = axe.j6(anj.DW, bArr, j6, axe.Hw(bArr, j6) - 1);
        if (aql.Ws()) {
            this.gn = bArr;
        }
        this.we |= 1;
    }

    public final int v_() {
        return 4;
    }

    public final aqg gn() {
        return this.VH;
    }
}
