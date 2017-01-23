package groovyjarjarantlr.debug;

import groovyjarjarantlr.CharStreamException;
import groovyjarjarantlr.InputBuffer;

public class DebuggingInputBuffer extends InputBuffer {
    private boolean VH;
    private InputBufferEventSupport Zo;
    private InputBuffer j6;

    public void j6() {
        char c = ' ';
        try {
            c = this.j6.DW(1);
        } catch (CharStreamException e) {
        }
        this.j6.j6();
        if (this.VH) {
            this.Zo.j6(c);
        }
    }

    public void j6(int i) {
        this.j6.j6(i);
    }

    public char DW(int i) {
        char DW = this.j6.DW(i);
        if (this.VH) {
            this.Zo.j6(DW, i);
        }
        return DW;
    }

    public int DW() {
        int DW = this.j6.DW();
        this.Zo.j6(DW);
        return DW;
    }

    public void FH(int i) {
        this.j6.FH(i);
        this.Zo.DW(i);
    }
}
