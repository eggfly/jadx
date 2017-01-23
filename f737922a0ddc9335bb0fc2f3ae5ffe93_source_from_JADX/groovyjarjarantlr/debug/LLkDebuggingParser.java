package groovyjarjarantlr.debug;

import groovyjarjarantlr.LLkParser;
import groovyjarjarantlr.MismatchedTokenException;
import groovyjarjarantlr.collections.impl.BitSet;

public class LLkDebuggingParser extends LLkParser implements DebuggingParser {
    protected ParserEventSupport j6;

    public void j6() {
        int j6 = j6(1);
        super.j6();
        this.j6.j6(j6);
    }

    public int j6(int i) {
        int j6 = super.j6(i);
        this.j6.j6(i, j6);
        return j6;
    }

    public void FH(int i) {
        String FH = DW(1).FH();
        int j6 = j6(1);
        try {
            super.FH(i);
            this.j6.j6(i, FH, this.Ws.DW);
        } catch (MismatchedTokenException e) {
            if (this.Ws.DW == 0) {
                this.j6.DW(j6, i, FH, this.Ws.DW);
            }
            throw e;
        }
    }

    public void j6(BitSet bitSet) {
        String FH = DW(1).FH();
        int j6 = j6(1);
        try {
            super.j6(bitSet);
            this.j6.j6(j6, bitSet, FH, this.Ws.DW);
        } catch (MismatchedTokenException e) {
            if (this.Ws.DW == 0) {
                this.j6.DW(j6, bitSet, FH, this.Ws.DW);
            }
            throw e;
        }
    }

    public void Hw(int i) {
        String FH = DW(1).FH();
        int j6 = j6(1);
        try {
            super.Hw(i);
            this.j6.j6(j6, i, FH, this.Ws.DW);
        } catch (MismatchedTokenException e) {
            if (this.Ws.DW == 0) {
                this.j6.FH(j6, i, FH, this.Ws.DW);
            }
            throw e;
        }
    }
}
