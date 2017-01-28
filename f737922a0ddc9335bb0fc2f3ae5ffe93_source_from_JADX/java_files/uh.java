public final class uh {
    private final int DW;
    private final int FH;
    private final ul Hw;
    private final int j6;
    private final boolean v5;

    public uh(int i, int i2, int i3, ul ulVar, boolean z) {
        if (!yp.j6(i)) {
            throw new IllegalArgumentException("bogus opcode");
        } else if (!yp.j6(i2)) {
            throw new IllegalArgumentException("bogus family");
        } else if (!yp.j6(i3)) {
            throw new IllegalArgumentException("bogus nextOpcode");
        } else if (ulVar == null) {
            throw new NullPointerException("format == null");
        } else {
            this.j6 = i;
            this.DW = i2;
            this.FH = i3;
            this.Hw = ulVar;
            this.v5 = z;
        }
    }

    public String toString() {
        return v5();
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public ul FH() {
        return this.Hw;
    }

    public boolean Hw() {
        return this.v5;
    }

    public String v5() {
        return yo.DW(this.j6);
    }

    public int Zo() {
        return this.FH;
    }

    public uh VH() {
        switch (this.j6) {
            case 50:
                return ui.OW;
            case 51:
                return ui.lp;
            case 52:
                return ui.XX;
            case 53:
                return ui.br;
            case 54:
                return ui.yO;
            case 55:
                return ui.kQ;
            case 56:
                return ui.jJ;
            case 57:
                return ui.XG;
            case 58:
                return ui.et;
            case 59:
                return ui.wc;
            case 60:
                return ui.Xa;
            case 61:
                return ui.CU;
            default:
                throw new IllegalArgumentException("bogus opcode: " + this);
        }
    }
}
