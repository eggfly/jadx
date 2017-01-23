package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.BitSet;
import java.util.Hashtable;

public abstract class CharScanner implements TokenStream {
    protected boolean EQ;
    protected int J0;
    protected Token J8;
    protected LexerSharedInputState QX;
    protected ANTLRStringBuffer VH;
    protected ANTLRHashString Ws;
    protected boolean XL;
    protected int aM;
    protected boolean gn;
    protected boolean tp;
    protected Class u7;
    protected Hashtable we;

    public CharScanner() {
        this.gn = true;
        this.tp = true;
        this.EQ = true;
        this.J0 = 8;
        this.J8 = null;
        this.XL = false;
        this.aM = 0;
        this.VH = new ANTLRStringBuffer();
        this.Ws = new ANTLRHashString(this);
        Zo("groovyjarjarantlr.CommonToken");
    }

    public CharScanner(LexerSharedInputState lexerSharedInputState) {
        this();
        this.QX = lexerSharedInputState;
    }

    public void j6(char c) {
        if (this.gn) {
            this.VH.j6(c);
        }
    }

    public void DW() {
        if (this.QX.VH == 0) {
            char DW = DW(1);
            if (this.tp) {
                j6(DW);
            } else {
                j6(this.QX.v5.DW(1));
            }
            if (DW == '\t') {
                tp();
            } else {
                LexerSharedInputState lexerSharedInputState = this.QX;
                lexerSharedInputState.j6++;
            }
        }
        this.QX.v5.j6();
    }

    public final boolean FH() {
        return this.EQ;
    }

    public int Hw() {
        return this.QX.j6;
    }

    public void j6(int i) {
        this.QX.j6 = i;
    }

    public String v5() {
        return this.QX.Zo;
    }

    public int Zo() {
        return this.QX.DW;
    }

    public String VH() {
        return this.VH.toString();
    }

    public char DW(int i) {
        if (this.tp) {
            return this.QX.v5.DW(i);
        }
        return Hw(this.QX.v5.DW(i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected groovyjarjarantlr.Token FH(int r3) {
        /*
        r2 = this;
        r0 = r2.u7;	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r0 = r0.newInstance();	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r0 = (groovyjarjarantlr.Token) r0;	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r0.FH(r3);	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r1 = r2.QX;	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r1 = r1.FH;	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r0.DW(r1);	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r1 = r2.QX;	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r1 = r1.Hw;	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
        r0.j6(r1);	 Catch:{ InstantiationException -> 0x001a, IllegalAccessException -> 0x0037 }
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = move-exception;
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = "can't instantiate token: ";
        r0 = r0.append(r1);
        r1 = r2.u7;
        r0 = r0.append(r1);
        r0 = r0.toString();
        r2.DW(r0);
    L_0x0034:
        r0 = groovyjarjarantlr.Token.VH;
        goto L_0x0019;
    L_0x0037:
        r0 = move-exception;
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = "Token class is not accessible";
        r0 = r0.append(r1);
        r1 = r2.u7;
        r0 = r0.append(r1);
        r0 = r0.toString();
        r2.DW(r0);
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.CharScanner.FH(int):groovyjarjarantlr.Token");
    }

    public int gn() {
        return this.QX.v5.DW();
    }

    public void DW(char c) {
        if (DW(1) != c) {
            throw new MismatchedCharException(DW(1), c, false, this);
        }
        DW();
    }

    public void j6(BitSet bitSet) {
        if (bitSet.Hw(DW(1))) {
            DW();
            return;
        }
        throw new MismatchedCharException(DW(1), bitSet, false, this);
    }

    public void j6(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (DW(1) != str.charAt(i)) {
                throw new MismatchedCharException(DW(1), str.charAt(i), false, this);
            }
            DW();
        }
    }

    public void FH(char c) {
        if (DW(1) == c) {
            throw new MismatchedCharException(DW(1), c, true, this);
        }
        DW();
    }

    public void j6(char c, char c2) {
        if (DW(1) < c || DW(1) > c2) {
            throw new MismatchedCharException(DW(1), c, c2, false, this);
        }
        DW();
    }

    public void u7() {
        LexerSharedInputState lexerSharedInputState = this.QX;
        lexerSharedInputState.DW++;
        this.QX.j6 = 1;
    }

    public void tp() {
        j6(((((Hw() - 1) / this.J0) + 1) * this.J0) + 1);
    }

    public void Hw(int i) {
        this.J0 = i;
    }

    public void DW(String str) {
        System.err.println(new StringBuffer().append("CharScanner; panic: ").append(str).toString());
        Utils.DW(str);
    }

    public void FH(String str) {
        if (v5() == null) {
            System.err.println(new StringBuffer().append("error: ").append(str).toString());
        } else {
            System.err.println(new StringBuffer().append(v5()).append(": error: ").append(str).toString());
        }
    }

    public void Hw(String str) {
        if (v5() == null) {
            System.err.println(new StringBuffer().append("warning: ").append(str).toString());
        } else {
            System.err.println(new StringBuffer().append(v5()).append(": warning: ").append(str).toString());
        }
    }

    public void EQ() {
        this.VH.j6(0);
        this.QX.FH = this.QX.j6;
        this.QX.Hw = this.QX.DW;
    }

    public void v5(int i) {
        this.QX.v5.FH(i);
    }

    public void cb(boolean z) {
        this.tp = z;
    }

    public void v5(String str) {
        EQ();
        this.VH.j6(str);
    }

    public void Zo(String str) {
        try {
            this.u7 = Utils.j6(str);
        } catch (ClassNotFoundException e) {
            DW(new StringBuffer().append("ClassNotFoundException: ").append(str).toString());
        }
    }

    public int Zo(int i) {
        this.Ws.j6(this.VH.j6(), this.VH.DW());
        Integer num = (Integer) this.we.get(this.Ws);
        if (num != null) {
            return num.intValue();
        }
        return i;
    }

    public int j6(String str, int i) {
        Integer num = (Integer) this.we.get(new ANTLRHashString(str, this));
        if (num != null) {
            return num.intValue();
        }
        return i;
    }

    public char Hw(char c) {
        return Character.toLowerCase(c);
    }

    public void we() {
    }
}
