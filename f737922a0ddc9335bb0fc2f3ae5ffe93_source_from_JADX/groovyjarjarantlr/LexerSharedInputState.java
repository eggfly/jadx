package groovyjarjarantlr;

public class LexerSharedInputState {
    protected int DW;
    protected int FH;
    protected int Hw;
    public int VH;
    protected String Zo;
    protected int j6;
    protected InputBuffer v5;

    public LexerSharedInputState(InputBuffer inputBuffer) {
        this.j6 = 1;
        this.DW = 1;
        this.FH = 1;
        this.Hw = 1;
        this.VH = 0;
        this.v5 = inputBuffer;
    }

    public int j6() {
        return this.DW;
    }

    public int DW() {
        return this.FH;
    }

    public int FH() {
        return this.Hw;
    }

    public int Hw() {
        return this.j6;
    }
}
