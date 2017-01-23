package groovyjarjarantlr;

import groovyjarjarantlr.collections.AST;
import groovyjarjarantlr.collections.impl.BitSet;
import java.util.Hashtable;

public abstract class Parser {
    protected int Mr;
    protected String[] QX;
    protected ParserSharedInputState Ws;
    protected AST XL;
    protected ASTFactory aM;
    protected Hashtable j3;
    private boolean j6;

    public abstract Token DW(int i);

    public abstract int j6(int i);

    public abstract void j6();

    public Parser() {
        this(new ParserSharedInputState());
    }

    public Parser(ParserSharedInputState parserSharedInputState) {
        this.aM = null;
        this.j3 = null;
        this.j6 = false;
        this.Mr = 0;
        this.Ws = parserSharedInputState;
    }

    public Hashtable DW() {
        return this.j3;
    }

    public AST FH() {
        return this.XL;
    }

    public ASTFactory Hw() {
        return this.aM;
    }

    public String v5() {
        return this.Ws.FH;
    }

    public int Zo() {
        return this.Ws.j6.DW();
    }

    public void FH(int i) {
        if (j6(1) != i) {
            throw new MismatchedTokenException(this.QX, DW(1), i, false, v5());
        } else {
            j6();
        }
    }

    public void j6(BitSet bitSet) {
        if (bitSet.Hw(j6(1))) {
            j6();
        } else {
            throw new MismatchedTokenException(this.QX, DW(1), bitSet, false, v5());
        }
    }

    public void Hw(int i) {
        if (j6(1) == i) {
            throw new MismatchedTokenException(this.QX, DW(1), i, true, v5());
        } else {
            j6();
        }
    }

    public void v5(int i) {
        this.Ws.j6.FH(i);
    }

    public void j6(TokenBuffer tokenBuffer) {
        this.Ws.j6 = tokenBuffer;
    }
}
