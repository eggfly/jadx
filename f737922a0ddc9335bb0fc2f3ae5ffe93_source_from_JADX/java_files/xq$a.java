class xq$a {
    private int DW;
    private int FH;
    private int Hw;
    private final String j6;
    private int v5;

    public xq$a(xc xcVar, String str) {
        int n_ = xcVar.n_();
        this.j6 = str;
        this.DW = 1;
        this.FH = n_;
        this.Hw = n_;
        this.v5 = n_;
    }

    public void j6(xc xcVar) {
        int n_ = xcVar.n_();
        this.DW++;
        this.FH += n_;
        if (n_ > this.Hw) {
            this.Hw = n_;
        }
        if (n_ < this.v5) {
            this.v5 = n_;
        }
    }

    public void j6(acr acr) {
        acr.j6(j6());
    }

    public String j6() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  " + this.j6 + ": " + this.DW + " item" + (this.DW == 1 ? "" : "s") + "; " + this.FH + " bytes total\n");
        if (this.v5 == this.Hw) {
            stringBuilder.append("    " + this.v5 + " bytes/item\n");
        } else {
            stringBuilder.append("    " + this.v5 + ".." + this.Hw + " bytes/item; average " + (this.FH / this.DW) + "\n");
        }
        return stringBuilder.toString();
    }
}
