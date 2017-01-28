public final class ud extends uj {
    private int DW;
    private int FH;
    private final aah j6;

    public ud(uh uhVar, aac aac, zx zxVar, aah aah) {
        super(uhVar, aac, zxVar);
        if (aah == null) {
            throw new NullPointerException("constant == null");
        }
        this.j6 = aah;
        this.DW = -1;
        this.FH = -1;
    }

    public uf j6(uh uhVar) {
        uf udVar = new ud(uhVar, u7(), tp(), this.j6);
        if (this.DW >= 0) {
            udVar.j6(this.DW);
        }
        if (this.FH >= 0) {
            udVar.DW(this.FH);
        }
        return udVar;
    }

    public uf j6(zx zxVar) {
        uf udVar = new ud(gn(), u7(), zxVar, this.j6);
        if (this.DW >= 0) {
            udVar.j6(this.DW);
        }
        if (this.FH >= 0) {
            udVar.DW(this.FH);
        }
        return udVar;
    }

    public aah FH() {
        return this.j6;
    }

    public int Hw() {
        if (this.DW >= 0) {
            return this.DW;
        }
        throw new RuntimeException("index not yet set for " + this.j6);
    }

    public boolean v5() {
        return this.DW >= 0;
    }

    public void j6(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index < 0");
        } else if (this.DW >= 0) {
            throw new RuntimeException("index already set");
        } else {
            this.DW = i;
        }
    }

    public void DW(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index < 0");
        } else if (this.FH >= 0) {
            throw new RuntimeException("class index already set");
        } else {
            this.FH = i;
        }
    }

    protected String DW() {
        return this.j6.Hw();
    }
}
