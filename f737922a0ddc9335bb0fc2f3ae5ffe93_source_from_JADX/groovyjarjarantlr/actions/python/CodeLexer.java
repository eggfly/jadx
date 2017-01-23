package groovyjarjarantlr.actions.python;

import groovyjarjarantlr.CharScanner;
import groovyjarjarantlr.CharStreamException;
import groovyjarjarantlr.CharStreamIOException;
import groovyjarjarantlr.NoViableAltForCharException;
import groovyjarjarantlr.RecognitionException;
import groovyjarjarantlr.Token;
import groovyjarjarantlr.TokenStream;
import groovyjarjarantlr.TokenStreamException;
import groovyjarjarantlr.TokenStreamIOException;
import groovyjarjarantlr.TokenStreamRecognitionException;
import groovyjarjarantlr.Tool;
import groovyjarjarantlr.collections.impl.BitSet;

public class CodeLexer extends CharScanner implements TokenStream, CodeLexerTokenTypes {
    public static final BitSet DW;
    public static final BitSet j6;
    private Tool FH;

    public void FH(String str) {
        this.FH.j6(str, v5(), Zo(), Hw());
    }

    public void Hw(String str) {
        if (v5() == null) {
            this.FH.Hw(str);
        } else {
            this.FH.DW(str, v5(), Zo(), Hw());
        }
    }

    public Token j6() {
        do {
            EQ();
            try {
                j6(true);
                Token token = this.J8;
            } catch (RecognitionException e) {
                throw new TokenStreamRecognitionException(e);
            } catch (CharStreamException e2) {
                if (e2 instanceof CharStreamIOException) {
                    throw new TokenStreamIOException(((CharStreamIOException) e2).j6);
                }
                throw new TokenStreamException(e2.getMessage());
            }
        } while (this.J8 == null);
        this.J8.FH(this.J8.Hw());
        return this.J8;
    }

    public final void j6(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        while (DW(1) >= '\u0003' && DW(1) <= '\u00ff') {
            DW(false);
        }
        if (z && null == null) {
            token = FH(4);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void DW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        if (DW(1) == '/' && (DW(2) == '*' || DW(2) == '/')) {
            FH(false);
        } else if (DW(1) == '\r' && DW(2) == '\n') {
            j6("\r\n");
            u7();
        } else if (DW(1) == '/' && j6.Hw(DW(2))) {
            DW('/');
            j6(j6);
        } else if (DW(1) == '\r') {
            DW('\r');
            u7();
        } else if (DW(1) == '\n') {
            DW('\n');
            u7();
        } else if (DW.Hw(DW(1))) {
            j6(DW);
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(5);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void FH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        if (DW(1) == '/' && DW(2) == '/') {
            Hw(false);
        } else if (DW(1) == '/' && DW(2) == '*') {
            v5(false);
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(6);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void Hw(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        int DW2 = this.VH.DW();
        j6("//");
        this.VH.j6(DW2);
        this.VH.j6("#");
        while (DW(1) != '\n' && DW(1) != '\r' && DW(1) >= '\u0003' && DW(1) <= '\u00ff' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
            FH('\uffff');
        }
        if (DW(1) == '\r' && DW(2) == '\n') {
            j6("\r\n");
        } else if (DW(1) == '\n') {
            DW('\n');
        } else if (DW(1) == '\r') {
            DW('\r');
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        u7();
        if (z && null == null) {
            token = FH(7);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void v5(boolean r11) {
        /*
        r10 = this;
        r9 = 13;
        r8 = 10;
        r7 = 3;
        r6 = 1;
        r5 = 2;
        r0 = 0;
        r1 = r10.VH;
        r1 = r1.DW();
        r2 = 9;
        r3 = r10.VH;
        r3 = r3.DW();
        r4 = "/*";
        r10.j6(r4);
        r4 = r10.VH;
        r4.j6(r3);
        r3 = r10.VH;
        r4 = "#";
        r3.j6(r4);
    L_0x0029:
        r3 = r10.DW(r6);
        r4 = 42;
        if (r3 != r4) goto L_0x0072;
    L_0x0031:
        r3 = r10.DW(r5);
        r4 = 47;
        if (r3 != r4) goto L_0x0072;
    L_0x0039:
        r3 = r10.VH;
        r4 = "\n";
        r3.j6(r4);
        r3 = r10.VH;
        r3 = r3.DW();
        r4 = "*/";
        r10.j6(r4);
        r4 = r10.VH;
        r4.j6(r3);
        if (r11 == 0) goto L_0x006f;
    L_0x0054:
        if (r0 != 0) goto L_0x006f;
    L_0x0056:
        r0 = r10.FH(r2);
        r2 = new java.lang.String;
        r3 = r10.VH;
        r3 = r3.j6();
        r4 = r10.VH;
        r4 = r4.DW();
        r4 = r4 - r1;
        r2.<init>(r3, r1, r4);
        r0.j6(r2);
    L_0x006f:
        r10.J8 = r0;
        return;
    L_0x0072:
        r3 = r10.DW(r6);
        if (r3 != r9) goto L_0x009f;
    L_0x0078:
        r3 = r10.DW(r5);
        if (r3 != r8) goto L_0x009f;
    L_0x007e:
        r10.DW(r9);
        r10.DW(r8);
        r3 = r10.VH;
        r3 = r3.DW();
        r4 = 0;
        r10.Zo(r4);
        r4 = r10.VH;
        r4.j6(r3);
        r10.u7();
        r3 = r10.VH;
        r4 = "# ";
        r3.j6(r4);
        goto L_0x0029;
    L_0x009f:
        r3 = r10.DW(r6);
        if (r3 != r9) goto L_0x00d2;
    L_0x00a5:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x00d2;
    L_0x00ab:
        r3 = r10.DW(r5);
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 > r4) goto L_0x00d2;
    L_0x00b3:
        r10.DW(r9);
        r3 = r10.VH;
        r3 = r3.DW();
        r4 = 0;
        r10.Zo(r4);
        r4 = r10.VH;
        r4.j6(r3);
        r10.u7();
        r3 = r10.VH;
        r4 = "# ";
        r3.j6(r4);
        goto L_0x0029;
    L_0x00d2:
        r3 = r10.DW(r6);
        if (r3 != r8) goto L_0x0105;
    L_0x00d8:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0105;
    L_0x00de:
        r3 = r10.DW(r5);
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 > r4) goto L_0x0105;
    L_0x00e6:
        r10.DW(r8);
        r3 = r10.VH;
        r3 = r3.DW();
        r4 = 0;
        r10.Zo(r4);
        r4 = r10.VH;
        r4.j6(r3);
        r10.u7();
        r3 = r10.VH;
        r4 = "# ";
        r3.j6(r4);
        goto L_0x0029;
    L_0x0105:
        r3 = r10.DW(r6);
        if (r3 < r7) goto L_0x0039;
    L_0x010b:
        r3 = r10.DW(r6);
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 > r4) goto L_0x0039;
    L_0x0113:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0039;
    L_0x0119:
        r3 = r10.DW(r5);
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 > r4) goto L_0x0039;
    L_0x0121:
        r3 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r10.FH(r3);
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.actions.python.CodeLexer.v5(boolean):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void Zo(boolean r11) {
        /*
        r10 = this;
        r9 = 32;
        r8 = 9;
        r7 = 3;
        r6 = 1;
        r5 = 2;
        r0 = 0;
        r1 = r10.VH;
        r1 = r1.DW();
        r2 = 8;
    L_0x0010:
        r3 = r10.DW(r6);
        if (r3 != r9) goto L_0x0028;
    L_0x0016:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0028;
    L_0x001c:
        r3 = r10.DW(r5);
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 > r4) goto L_0x0028;
    L_0x0024:
        r10.DW(r9);
        goto L_0x0010;
    L_0x0028:
        r3 = r10.DW(r6);
        if (r3 != r8) goto L_0x0040;
    L_0x002e:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0040;
    L_0x0034:
        r3 = r10.DW(r5);
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 > r4) goto L_0x0040;
    L_0x003c:
        r10.DW(r8);
        goto L_0x0010;
    L_0x0040:
        if (r11 == 0) goto L_0x005d;
    L_0x0042:
        if (r0 != 0) goto L_0x005d;
    L_0x0044:
        r0 = r10.FH(r2);
        r2 = new java.lang.String;
        r3 = r10.VH;
        r3 = r3.j6();
        r4 = r10.VH;
        r4 = r4.DW();
        r4 = r4 - r1;
        r2.<init>(r3, r1, r4);
        r0.j6(r2);
    L_0x005d:
        r10.J8 = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.actions.python.CodeLexer.Zo(boolean):void");
    }

    private static final long[] J0() {
        long[] jArr = new long[8];
        jArr[0] = -145135534866440L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    static {
        j6 = new BitSet(J0());
        DW = new BitSet(J8());
    }

    private static final long[] J8() {
        long[] jArr = new long[8];
        jArr[0] = -140737488364552L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }
}
