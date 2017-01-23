package groovyjarjarantlr;

class TokenQueue {
    private Token[] DW;
    private int FH;
    private int Hw;
    protected int j6;

    public TokenQueue(int i) {
        if (i < 0) {
            DW(16);
        } else if (i >= 1073741823) {
            DW(Integer.MAX_VALUE);
        } else {
            int i2 = 2;
            while (i2 < i) {
                i2 *= 2;
            }
            DW(i2);
        }
    }

    public final void j6(Token token) {
        if (this.j6 == this.DW.length) {
            DW();
        }
        this.DW[(this.Hw + this.j6) & this.FH] = token;
        this.j6++;
    }

    public final Token j6(int i) {
        return this.DW[(this.Hw + i) & this.FH];
    }

    private final void DW() {
        Token[] tokenArr = new Token[(this.DW.length * 2)];
        for (int i = 0; i < this.DW.length; i++) {
            tokenArr[i] = j6(i);
        }
        this.DW = tokenArr;
        this.FH = this.DW.length - 1;
        this.Hw = 0;
    }

    private final void DW(int i) {
        this.DW = new Token[i];
        this.FH = i - 1;
        this.Hw = 0;
        this.j6 = 0;
    }

    public final void j6() {
        this.Hw = (this.Hw + 1) & this.FH;
        this.j6--;
    }
}
