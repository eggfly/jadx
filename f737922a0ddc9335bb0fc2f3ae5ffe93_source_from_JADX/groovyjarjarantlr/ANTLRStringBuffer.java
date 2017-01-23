package groovyjarjarantlr;

public class ANTLRStringBuffer {
    protected int DW;
    protected char[] j6;

    public ANTLRStringBuffer() {
        this.j6 = null;
        this.DW = 0;
        this.j6 = new char[50];
    }

    public final void j6(char c) {
        if (this.DW >= this.j6.length) {
            int length = this.j6.length;
            while (this.DW >= length) {
                length *= 2;
            }
            char[] cArr = new char[length];
            for (length = 0; length < this.DW; length++) {
                cArr[length] = this.j6[length];
            }
            this.j6 = cArr;
        }
        this.j6[this.DW] = c;
        this.DW++;
    }

    public final void j6(String str) {
        for (int i = 0; i < str.length(); i++) {
            j6(str.charAt(i));
        }
    }

    public final char[] j6() {
        return this.j6;
    }

    public final int DW() {
        return this.DW;
    }

    public final void j6(int i) {
        if (i < this.DW) {
            this.DW = i;
            return;
        }
        while (i > this.DW) {
            j6('\u0000');
        }
    }

    public final String toString() {
        return new String(this.j6, 0, this.DW);
    }
}
