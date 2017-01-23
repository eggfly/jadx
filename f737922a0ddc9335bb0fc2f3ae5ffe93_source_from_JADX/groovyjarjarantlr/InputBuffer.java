package groovyjarjarantlr;

public abstract class InputBuffer {
    protected int DW;
    protected int FH;
    protected int Hw;
    protected CharQueue v5;

    public abstract void j6(int i);

    public InputBuffer() {
        this.DW = 0;
        this.FH = 0;
        this.Hw = 0;
        this.v5 = new CharQueue(1);
    }

    public void j6() {
        this.Hw++;
    }

    public char DW(int i) {
        j6(i);
        return this.v5.j6((this.FH + i) - 1);
    }

    public int DW() {
        FH();
        this.DW++;
        return this.FH;
    }

    public void FH(int i) {
        FH();
        this.FH = i;
        this.DW--;
    }

    protected void FH() {
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
