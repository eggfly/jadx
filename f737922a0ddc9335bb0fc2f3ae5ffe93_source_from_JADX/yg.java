public final class yg {
    private final int DW;
    private final int FH;
    private final int Hw;
    private final int VH;
    private final int Zo;
    private final int gn;
    private final yi j6;
    private final int tp;
    private final int u7;
    private final int v5;

    public yg(yi yiVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.j6 = yiVar;
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = i4;
        this.Zo = i5;
        this.VH = i6;
        this.gn = i7;
        this.u7 = i8;
        this.tp = i9;
    }

    public int j6() {
        return this.DW;
    }

    public int DW() {
        return this.FH;
    }

    public int FH() {
        return this.v5;
    }

    public int Hw() {
        return this.Zo;
    }

    public int v5() {
        return this.Hw;
    }

    public int Zo() {
        return this.VH;
    }

    public int VH() {
        return this.gn;
    }

    public int gn() {
        return this.u7;
    }

    public int u7() {
        return this.tp;
    }

    public void j6(yt$a yt_a) {
        yt_a.u7();
        yt_a.v5(DW());
        yt_a.v5(v5());
        yt_a.v5(FH());
        yt_a.v5(Hw());
        yt_a.v5(Zo());
        yt_a.v5(VH());
        yt_a.v5(gn());
        yt_a.v5(u7());
    }

    public String toString() {
        if (this.j6 == null) {
            return this.FH + " " + this.v5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String) this.j6.FH().get(this.FH));
        if (this.v5 != -1) {
            stringBuilder.append(" extends ").append((String) this.j6.FH().get(this.v5));
        }
        return stringBuilder.toString();
    }
}
