public class akd<S extends akh> {
    public static final ajr j6;
    protected ajw DW;
    protected ajy<S> FH;
    protected ajx<S> Hw;
    akd$a Zo;
    protected ajx<S> v5;

    static {
        j6 = new akd$1();
    }

    private akd(ajw ajw, ajy<S> ajy_S, ajx<S> ajx_S, ajx<S> ajx_S2, ajv ajv) {
        this.Zo = new akd$a(this);
        this.DW = ajw;
        this.FH = ajy_S;
        this.Hw = ajx_S;
        this.v5 = ajx_S2;
        j6(ajv);
    }

    private void j6(ajv ajv) {
        this.Zo.j6(ajv.j6, ajv.DW, ajv.FH, ajv.Hw);
        if (this.Zo.FH < this.Zo.Hw || this.Zo.v5 < this.Zo.Zo) {
            j6(this.Zo.FH, this.Zo.Hw, this.Zo.v5, this.Zo.Zo);
        }
    }

    protected void j6(int i, int i2, int i3, int i4) {
        ajv DW = this.Zo.DW(i, i2, i3, i4);
        if (i < DW.j6 || i3 < DW.FH) {
            int i5 = DW.FH - DW.j6;
            int j6 = this.Zo.DW.j6(i5, DW.j6);
            j6(i, j6, i3, i5 + j6);
        }
        if (DW.j6() != ajv$a.EMPTY) {
            this.DW.add(this.DW.size(), DW);
        }
        if (i2 > DW.DW || i4 > DW.Hw) {
            i5 = DW.Hw - DW.DW;
            int j62 = this.Zo.j6.j6(i5, DW.DW);
            j6(j62, i2, i5 + j62, i4);
        }
    }
}
