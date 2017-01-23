package groovyjarjarantlr.debug;

public class InputBufferEvent extends Event {
    int DW;
    char j6;

    public char DW() {
        return this.j6;
    }

    public int FH() {
        return this.DW;
    }

    void j6(char c) {
        this.j6 = c;
    }

    void FH(int i) {
        this.DW = i;
    }

    void j6(int i, char c, int i2) {
        super.DW(i);
        j6(c);
        FH(i2);
    }

    public String toString() {
        return new StringBuffer().append("CharBufferEvent [").append(j6() == 0 ? "CONSUME, " : "LA, ").append(DW()).append(",").append(FH()).append("]").toString();
    }
}
