package groovyjarjarantlr;

public class CharQueue {
    protected int DW;
    private int FH;
    private int Hw;
    protected char[] j6;

    public CharQueue(int i) {
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

    public final void j6(char c) {
        if (this.DW == this.j6.length) {
            DW();
        }
        this.j6[(this.Hw + this.DW) & this.FH] = c;
        this.DW++;
    }

    public final char j6(int i) {
        return this.j6[(this.Hw + i) & this.FH];
    }

    private final void DW() {
        char[] cArr = new char[(this.j6.length * 2)];
        for (int i = 0; i < this.j6.length; i++) {
            cArr[i] = j6(i);
        }
        this.j6 = cArr;
        this.FH = this.j6.length - 1;
        this.Hw = 0;
    }

    public void DW(int i) {
        this.j6 = new char[i];
        this.FH = i - 1;
        this.Hw = 0;
        this.DW = 0;
    }

    public final void j6() {
        this.Hw = (this.Hw + 1) & this.FH;
        this.DW--;
    }
}
