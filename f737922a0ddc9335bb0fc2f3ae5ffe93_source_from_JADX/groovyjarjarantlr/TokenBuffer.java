package groovyjarjarantlr;

public class TokenBuffer {
    int DW;
    int FH;
    int Hw;
    protected TokenStream j6;
    TokenQueue v5;

    public TokenBuffer(TokenStream tokenStream) {
        this.DW = 0;
        this.FH = 0;
        this.Hw = 0;
        this.j6 = tokenStream;
        this.v5 = new TokenQueue(1);
    }

    public final void j6() {
        this.Hw++;
    }

    private final void Hw(int i) {
        FH();
        while (this.v5.j6 < this.FH + i) {
            this.v5.j6(this.j6.j6());
        }
    }

    public final int j6(int i) {
        Hw(i);
        return this.v5.j6((this.FH + i) - 1).Hw();
    }

    public final Token DW(int i) {
        Hw(i);
        return this.v5.j6((this.FH + i) - 1);
    }

    public final int DW() {
        FH();
        this.DW++;
        return this.FH;
    }

    public final void FH(int i) {
        FH();
        this.FH = i;
        this.DW--;
    }

    private final void FH() {
        while (this.Hw > 0) {
            if (this.DW > 0) {
                this.FH++;
            } else {
                this.v5.j6();
            }
            this.Hw--;
        }
    }
}
