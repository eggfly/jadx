public class ajv {
    int DW;
    int FH;
    int Hw;
    int j6;

    public ajv(int i, int i2) {
        this(i, i, i2, i2);
    }

    public ajv(int i, int i2, int i3, int i4) {
        this.j6 = i;
        this.DW = i2;
        this.FH = i3;
        this.Hw = i4;
    }

    public final ajv$a j6() {
        if (this.j6 < this.DW) {
            if (this.FH < this.Hw) {
                return ajv$a.REPLACE;
            }
            return ajv$a.DELETE;
        } else if (this.FH < this.Hw) {
            return ajv$a.INSERT;
        } else {
            return ajv$a.EMPTY;
        }
    }

    public final boolean DW() {
        return this.j6 == this.DW && this.FH == this.Hw;
    }

    public final int FH() {
        return this.j6;
    }

    public final int Hw() {
        return this.DW;
    }

    public final int v5() {
        return this.FH;
    }

    public final int Zo() {
        return this.Hw;
    }

    public final int VH() {
        return this.DW - this.j6;
    }

    public final ajv j6(ajv ajv) {
        return new ajv(this.j6, ajv.j6, this.FH, ajv.FH);
    }

    public final ajv DW(ajv ajv) {
        return new ajv(ajv.DW, this.DW, ajv.Hw, this.Hw);
    }

    public void gn() {
        this.DW++;
    }

    public void u7() {
        this.Hw++;
    }

    public int hashCode() {
        return this.j6 ^ this.DW;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ajv)) {
            return false;
        }
        ajv ajv = (ajv) obj;
        if (this.j6 == ajv.j6 && this.DW == ajv.DW && this.FH == ajv.FH && this.Hw == ajv.Hw) {
            return true;
        }
        return false;
    }

    public String toString() {
        return j6() + "(" + this.j6 + "-" + this.DW + "," + this.FH + "-" + this.Hw + ")";
    }
}
