class acv$a {
    private int DW;
    private final String FH;
    private final int j6;

    public acv$a(int i, int i2, String str) {
        this.j6 = i;
        this.DW = i2;
        this.FH = str;
    }

    public acv$a(int i, String str) {
        this(i, Integer.MAX_VALUE, str);
    }

    public void j6(int i) {
        if (this.DW == Integer.MAX_VALUE) {
            this.DW = i;
        }
    }

    public void DW(int i) {
        this.DW = i;
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public String FH() {
        return this.FH;
    }
}
