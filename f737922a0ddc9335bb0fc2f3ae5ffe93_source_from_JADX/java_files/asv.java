public class asv extends aud {
    private ans VH;
    private int gn;
    private asl$a tp;
    private int u7;

    public asv(anb anb, int i) {
        super(anb);
        this.gn = i << 5;
    }

    public asv(aqg aqg) {
        this(aqg, aqg.v_());
    }

    public ans gn() {
        return this.VH;
    }

    public asv u7() {
        if (this.VH instanceof asv) {
            return (asv) this.VH;
        }
        return null;
    }

    void DW(ans ans) {
        this.VH = ans;
    }

    void j6(asl$a asl_a) {
        this.tp = asl_a;
    }

    asl$a tp() {
        asl$a asl_a = this.tp;
        if (asl_a != null) {
            this.tp = null;
        }
        return asl_a;
    }

    void EQ() {
        this.VH = null;
        if (this.tp != null) {
            this.tp.clear();
            this.tp.enqueue();
            this.tp = null;
        }
    }

    public boolean we() {
        return this.VH != null;
    }

    public boolean J0() {
        return yS() != 0;
    }

    public int J8() {
        return (this.gn >> 5) & 7;
    }

    int Ws() {
        return this.gn >>> 12;
    }

    void DW(int i) {
        this.gn = (i << 12) | (this.gn & 4095);
    }

    boolean QX() {
        return (this.gn & 1) != 0;
    }

    void XL() {
        this.gn |= 1;
    }

    public boolean aM() {
        return (this.gn & 2) != 0;
    }

    void j3() {
        this.gn |= 2;
    }

    protected void VH() {
        this.gn &= -3;
    }

    boolean Mr() {
        return (this.gn & 4) != 0;
    }

    void j6(boolean z) {
        if (z) {
            this.gn |= 4;
        } else {
            this.gn &= -5;
        }
    }

    boolean U2() {
        return (this.gn & 8) != 0;
    }

    void a8() {
        this.gn |= 8;
    }

    int lg() {
        return gW();
    }

    void FH(int i) {
        Zo(i);
    }

    int rN() {
        return this.u7;
    }

    void Hw(int i) {
        this.u7 = i;
    }

    int er() {
        return this.u7;
    }

    void v5(int i) {
        this.u7 = i;
    }

    public void j6(asz asz) {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ObjectToPack[");
        stringBuilder.append(anj.j6(J8()));
        stringBuilder.append(" ");
        stringBuilder.append(DW());
        if (QX()) {
            stringBuilder.append(" wantWrite");
        }
        if (aM()) {
            stringBuilder.append(" reuseAsIs");
        }
        if (Mr()) {
            stringBuilder.append(" doNotDelta");
        }
        if (U2()) {
            stringBuilder.append(" edge");
        }
        if (Ws() > 0) {
            stringBuilder.append(" depth=" + Ws());
        }
        if (we()) {
            if (u7() != null) {
                stringBuilder.append(" base=inpack:" + u7().DW());
            } else {
                stringBuilder.append(" base=edge:" + gn().DW());
            }
        }
        if (J0()) {
            stringBuilder.append(" offset=" + yS());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
