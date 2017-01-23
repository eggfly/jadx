package groovyjarjarantlr.preprocessor;

import com.aide.uidesigner.ProxyTextView;
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
import groovyjarjarantlr.collections.impl.BitSet;

public class PreprocessorLexer extends CharScanner implements TokenStream, PreprocessorTokenTypes {
    public static final BitSet DW;
    public static final BitSet FH;
    public static final BitSet Hw;
    public static final BitSet Mr;
    public static final BitSet U2;
    public static final BitSet Zo;
    public static final BitSet a8;
    public static final BitSet j3;
    public static final BitSet j6;
    public static final BitSet lg;
    public static final BitSet v5;

    public Token j6() {
        do {
            EQ();
            try {
                Token token;
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        DW(true);
                        token = this.J8;
                        break;
                    case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                        EQ(true);
                        token = this.J8;
                        break;
                    case '\"':
                        gn(true);
                        token = this.J8;
                        break;
                    case '\'':
                        u7(true);
                        token = this.J8;
                        break;
                    case ')':
                        QX(true);
                        token = this.J8;
                        break;
                    case ',':
                        J0(true);
                        token = this.J8;
                        break;
                    case '/':
                        Zo(true);
                        token = this.J8;
                        break;
                    case ':':
                        j6(true);
                        token = this.J8;
                        break;
                    case ';':
                        we(true);
                        token = this.J8;
                        break;
                    case '=':
                        Mr(true);
                        token = this.J8;
                        break;
                    case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'I':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'O':
                    case 'P':
                    case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                    case 'R':
                    case 'S':
                    case 'T':
                    case 'U':
                    case 'V':
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                    case '_':
                    case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                    case 'r':
                    case 's':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                        XL(true);
                        token = this.J8;
                        break;
                    case '[':
                        yS(true);
                        token = this.J8;
                        break;
                    case '{':
                        VH(true);
                        token = this.J8;
                        break;
                    case '}':
                        J8(true);
                        token = this.J8;
                        break;
                    default:
                        if (DW(1) == '(' && j6.Hw(DW(2))) {
                            Hw(true);
                            token = this.J8;
                            break;
                        } else if (DW(1) == '(') {
                            Ws(true);
                            token = this.J8;
                            break;
                        } else if (DW(1) == '\uffff') {
                            we();
                            this.J8 = FH(1);
                            break;
                        } else {
                            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                        }
                }
            } catch (RecognitionException e) {
                throw new TokenStreamRecognitionException(e);
            } catch (CharStreamException e2) {
                if (e2 instanceof CharStreamIOException) {
                    throw new TokenStreamIOException(((CharStreamIOException) e2).j6);
                }
                throw new TokenStreamException(e2.getMessage());
            }
        } while (this.J8 == null);
        this.J8.FH(Zo(this.J8.Hw()));
        return this.J8;
    }

    public final void j6(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(':');
        if (DW.Hw(DW(1)) && FH.Hw(DW(2))) {
            int DW2 = this.VH.DW();
            DW(false);
            this.VH.j6(DW2);
        } else if (!FH.Hw(DW(1))) {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        FH(false);
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                DW2 = this.VH.DW();
                DW(false);
                this.VH.j6(DW2);
                break;
            case ';':
            case '|':
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        while (DW(1) == '|') {
            DW('|');
            if (DW.Hw(DW(1)) && FH.Hw(DW(2))) {
                DW2 = this.VH.DW();
                DW(false);
                this.VH.j6(DW2);
            } else if (!FH.Hw(DW(1))) {
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            FH(false);
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    DW2 = this.VH.DW();
                    DW(false);
                    this.VH.j6(DW2);
                    break;
                case ';':
                case '|':
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
        }
        DW(';');
        if (z && null == null) {
            token = FH(22);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void DW(boolean z) {
        this.VH.DW();
        int i = 0;
        while (true) {
            if (DW(1) != ' ') {
                if (DW(1) != '\t') {
                    if (DW(1) != '\n' && DW(1) != '\r') {
                        break;
                    }
                    tp(false);
                } else {
                    DW('\t');
                }
            } else {
                DW(' ');
            }
            i++;
        }
        if (i >= 1) {
            if (!z || null == null) {
                this.J8 = null;
            } else {
                this.J8 = null;
            }
            return;
        }
        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
    }

    protected final void FH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        while (Hw.Hw(DW(1)) && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
            v5(false);
        }
        if (z && null == null) {
            token = FH(27);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Hw(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('(');
        if (DW.Hw(DW(1)) && j6.Hw(DW(2))) {
            DW(false);
        } else if (!j6.Hw(DW(1))) {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        FH(false);
        while (v5.Hw(DW(1)) && j6.Hw(DW(2))) {
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    DW(false);
                    break;
                case '|':
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            DW('|');
            if (DW.Hw(DW(1)) && j6.Hw(DW(2))) {
                DW(false);
            } else if (!j6.Hw(DW(1))) {
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            FH(false);
        }
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                DW(false);
                break;
            case ')':
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        DW(')');
        if (DW(1) == '=' && DW(2) == '>') {
            j6("=>");
        } else if (DW(1) == '*') {
            DW('*');
        } else if (DW(1) == '+') {
            DW('+');
        } else if (DW(1) == '?') {
            DW('?');
        }
        if (z && null == null) {
            token = FH(6);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void v5(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case '\n':
            case '\r':
                tp(false);
                break;
            case '\"':
                gn(false);
                break;
            case '\'':
                u7(false);
                break;
            case '(':
                Hw(false);
                break;
            case '/':
                Zo(false);
                break;
            case '{':
                VH(false);
                break;
            default:
                if (Zo.Hw(DW(1))) {
                    j6(Zo);
                    break;
                }
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(28);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Zo(boolean z) {
        this.VH.DW();
        if (DW(1) == '/' && DW(2) == '/') {
            U2(false);
        } else if (DW(1) == '/' && DW(2) == '*') {
            a8(false);
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (!z || null == null) {
            this.J8 = null;
        } else {
            this.J8 = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void VH(boolean r11) {
        /*
        r10 = this;
        r9 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r8 = 3;
        r7 = 0;
        r6 = 1;
        r5 = 2;
        r0 = 0;
        r1 = r10.VH;
        r1 = r1.DW();
        r2 = 7;
        r3 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r10.DW(r3);
    L_0x0013:
        r3 = r10.DW(r6);
        r4 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r3 != r4) goto L_0x0040;
    L_0x001b:
        r3 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r10.DW(r3);
        if (r11 == 0) goto L_0x003d;
    L_0x0022:
        if (r0 != 0) goto L_0x003d;
    L_0x0024:
        r0 = r10.FH(r2);
        r2 = new java.lang.String;
        r3 = r10.VH;
        r3 = r3.j6();
        r4 = r10.VH;
        r4 = r4.DW();
        r4 = r4 - r1;
        r2.<init>(r3, r1, r4);
        r0.j6(r2);
    L_0x003d:
        r10.J8 = r0;
        return;
    L_0x0040:
        r3 = r10.DW(r6);
        r4 = 10;
        if (r3 == r4) goto L_0x0050;
    L_0x0048:
        r3 = r10.DW(r6);
        r4 = 13;
        if (r3 != r4) goto L_0x0060;
    L_0x0050:
        r3 = r10.DW(r5);
        if (r3 < r8) goto L_0x0060;
    L_0x0056:
        r3 = r10.DW(r5);
        if (r3 > r9) goto L_0x0060;
    L_0x005c:
        r10.tp(r7);
        goto L_0x0013;
    L_0x0060:
        r3 = r10.DW(r6);
        r4 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r3 != r4) goto L_0x0078;
    L_0x0068:
        r3 = r10.DW(r5);
        if (r3 < r8) goto L_0x0078;
    L_0x006e:
        r3 = r10.DW(r5);
        if (r3 > r9) goto L_0x0078;
    L_0x0074:
        r10.VH(r7);
        goto L_0x0013;
    L_0x0078:
        r3 = r10.DW(r6);
        r4 = 39;
        if (r3 != r4) goto L_0x0090;
    L_0x0080:
        r3 = j3;
        r4 = r10.DW(r5);
        r3 = r3.Hw(r4);
        if (r3 == 0) goto L_0x0090;
    L_0x008c:
        r10.u7(r7);
        goto L_0x0013;
    L_0x0090:
        r3 = r10.DW(r6);
        r4 = 47;
        if (r3 != r4) goto L_0x00ad;
    L_0x0098:
        r3 = r10.DW(r5);
        r4 = 42;
        if (r3 == r4) goto L_0x00a8;
    L_0x00a0:
        r3 = r10.DW(r5);
        r4 = 47;
        if (r3 != r4) goto L_0x00ad;
    L_0x00a8:
        r10.Zo(r7);
        goto L_0x0013;
    L_0x00ad:
        r3 = r10.DW(r6);
        r4 = 34;
        if (r3 != r4) goto L_0x00c6;
    L_0x00b5:
        r3 = r10.DW(r5);
        if (r3 < r8) goto L_0x00c6;
    L_0x00bb:
        r3 = r10.DW(r5);
        if (r3 > r9) goto L_0x00c6;
    L_0x00c1:
        r10.gn(r7);
        goto L_0x0013;
    L_0x00c6:
        r3 = r10.DW(r6);
        if (r3 < r8) goto L_0x001b;
    L_0x00cc:
        r3 = r10.DW(r6);
        if (r3 > r9) goto L_0x001b;
    L_0x00d2:
        r3 = r10.DW(r5);
        if (r3 < r8) goto L_0x001b;
    L_0x00d8:
        r3 = r10.DW(r5);
        if (r3 > r9) goto L_0x001b;
    L_0x00de:
        r3 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r10.FH(r3);
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.preprocessor.PreprocessorLexer.VH(boolean):void");
    }

    public final void gn(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\"');
        while (true) {
            if (DW(1) != '\\') {
                if (!Mr.Hw(DW(1))) {
                    break;
                }
                FH('\"');
            } else {
                lg(false);
            }
        }
        DW('\"');
        if (z && null == null) {
            token = FH(39);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void u7(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\'');
        if (DW(1) == '\\') {
            lg(false);
        } else if (U2.Hw(DW(1))) {
            FH('\'');
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        DW('\'');
        if (z && null == null) {
            token = FH(38);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void tp(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        if (DW(1) == '\r' && DW(2) == '\n') {
            DW('\r');
            DW('\n');
            u7();
        } else if (DW(1) == '\r') {
            DW('\r');
            u7();
        } else if (DW(1) == '\n') {
            DW('\n');
            u7();
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(34);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void EQ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('!');
        if (z && null == null) {
            token = FH(19);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void we(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(';');
        if (z && null == null) {
            token = FH(11);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void J0(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(',');
        if (z && null == null) {
            token = FH(24);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void J8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('}');
        if (z && null == null) {
            token = FH(15);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Ws(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('(');
        if (z && null == null) {
            token = FH(29);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void QX(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(')');
        if (z && null == null) {
            token = FH(30);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void XL(boolean r12) {
        /*
        r11 = this;
        r10 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r9 = 3;
        r8 = 2;
        r7 = 0;
        r6 = 1;
        r0 = 0;
        r1 = r11.VH;
        r2 = r1.DW();
        r11.aM(r6);
        r3 = r11.J8;
        r1 = r3.Hw();
        r4 = a8;
        r5 = r11.DW(r6);
        r4 = r4.Hw(r5);
        if (r4 == 0) goto L_0x00da;
    L_0x0022:
        r4 = r11.DW(r8);
        if (r4 < r9) goto L_0x00da;
    L_0x0028:
        r4 = r11.DW(r8);
        if (r4 > r10) goto L_0x00da;
    L_0x002e:
        r4 = r3.FH();
        r5 = "header";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x00da;
    L_0x003b:
        r1 = DW;
        r3 = r11.DW(r6);
        r1 = r1.Hw(r3);
        if (r1 == 0) goto L_0x0073;
    L_0x0047:
        r1 = a8;
        r3 = r11.DW(r8);
        r1 = r1.Hw(r3);
        if (r1 == 0) goto L_0x0073;
    L_0x0053:
        r11.DW(r7);
    L_0x0056:
        r1 = r11.DW(r6);
        switch(r1) {
            case 9: goto L_0x00a4;
            case 10: goto L_0x00a4;
            case 13: goto L_0x00a4;
            case 32: goto L_0x00a4;
            case 34: goto L_0x00a1;
            case 47: goto L_0x00a4;
            case 123: goto L_0x00a4;
            default: goto L_0x005d;
        };
    L_0x005d:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r11.DW(r6);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0073:
        r1 = a8;
        r3 = r11.DW(r6);
        r1 = r1.Hw(r3);
        if (r1 == 0) goto L_0x008b;
    L_0x007f:
        r1 = r11.DW(r8);
        if (r1 < r9) goto L_0x008b;
    L_0x0085:
        r1 = r11.DW(r8);
        if (r1 <= r10) goto L_0x0056;
    L_0x008b:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r11.DW(r6);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x00a1:
        r11.gn(r7);
    L_0x00a4:
        r1 = r11.DW(r6);
        switch(r1) {
            case 9: goto L_0x00d2;
            case 10: goto L_0x00d2;
            case 13: goto L_0x00d2;
            case 32: goto L_0x00d2;
            case 47: goto L_0x00d6;
            default: goto L_0x00ab;
        };
    L_0x00ab:
        r11.VH(r7);
        r1 = 5;
    L_0x00af:
        if (r12 == 0) goto L_0x00cf;
    L_0x00b1:
        if (r0 != 0) goto L_0x00cf;
    L_0x00b3:
        r3 = -1;
        if (r1 == r3) goto L_0x00cf;
    L_0x00b6:
        r0 = r11.FH(r1);
        r1 = new java.lang.String;
        r3 = r11.VH;
        r3 = r3.j6();
        r4 = r11.VH;
        r4 = r4.DW();
        r4 = r4 - r2;
        r1.<init>(r3, r2, r4);
        r0.j6(r1);
    L_0x00cf:
        r11.J8 = r0;
        return;
    L_0x00d2:
        r11.DW(r7);
        goto L_0x00a4;
    L_0x00d6:
        r11.Zo(r7);
        goto L_0x00a4;
    L_0x00da:
        r4 = lg;
        r5 = r11.DW(r6);
        r4 = r4.Hw(r5);
        if (r4 == 0) goto L_0x0114;
    L_0x00e6:
        r4 = r11.DW(r8);
        if (r4 < r9) goto L_0x0114;
    L_0x00ec:
        r4 = r11.DW(r8);
        if (r4 > r10) goto L_0x0114;
    L_0x00f2:
        r4 = r3.FH();
        r5 = "tokens";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0114;
    L_0x00ff:
        r1 = r11.DW(r6);
        switch(r1) {
            case 9: goto L_0x010c;
            case 10: goto L_0x010c;
            case 13: goto L_0x010c;
            case 32: goto L_0x010c;
            case 47: goto L_0x0110;
            default: goto L_0x0106;
        };
    L_0x0106:
        r11.j3(r7);
        r1 = 12;
        goto L_0x00af;
    L_0x010c:
        r11.DW(r7);
        goto L_0x00ff;
    L_0x0110:
        r11.Zo(r7);
        goto L_0x00ff;
    L_0x0114:
        r4 = lg;
        r5 = r11.DW(r6);
        r4 = r4.Hw(r5);
        if (r4 == 0) goto L_0x00af;
    L_0x0120:
        r3 = r3.FH();
        r4 = "options";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00af;
    L_0x012d:
        r1 = r11.DW(r6);
        switch(r1) {
            case 9: goto L_0x013d;
            case 10: goto L_0x013d;
            case 13: goto L_0x013d;
            case 32: goto L_0x013d;
            case 47: goto L_0x0141;
            default: goto L_0x0134;
        };
    L_0x0134:
        r1 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r11.DW(r1);
        r1 = 13;
        goto L_0x00af;
    L_0x013d:
        r11.DW(r7);
        goto L_0x012d;
    L_0x0141:
        r11.Zo(r7);
        goto L_0x012d;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.preprocessor.PreprocessorLexer.XL(boolean):void");
    }

    protected final void aM(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                j6('A', 'Z');
                break;
            case '_':
                DW('_');
                break;
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                j6('a', 'z');
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        while (true) {
            switch (DW(1)) {
                case '0':
                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    j6('0', '9');
                    break;
                case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    j6('A', 'Z');
                    break;
                case '_':
                    DW('_');
                    break;
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    j6('a', 'z');
                    break;
                default:
                    int j6 = j6(new String(this.VH.j6(), DW, this.VH.DW() - DW), 9);
                    if (z && null == null && j6 != -1) {
                        token = FH(j6);
                        token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                    }
                    this.J8 = token;
                    return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void j3(boolean r11) {
        /*
        r10 = this;
        r9 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r8 = 3;
        r7 = 0;
        r6 = 1;
        r5 = 2;
        r0 = 0;
        r1 = r10.VH;
        r1 = r1.DW();
        r2 = 32;
        r3 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r10.DW(r3);
    L_0x0014:
        r3 = r10.DW(r6);
        r4 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r3 != r4) goto L_0x0041;
    L_0x001c:
        r3 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r10.DW(r3);
        if (r11 == 0) goto L_0x003e;
    L_0x0023:
        if (r0 != 0) goto L_0x003e;
    L_0x0025:
        r0 = r10.FH(r2);
        r2 = new java.lang.String;
        r3 = r10.VH;
        r3 = r3.j6();
        r4 = r10.VH;
        r4 = r4.DW();
        r4 = r4 - r1;
        r2.<init>(r3, r1, r4);
        r0.j6(r2);
    L_0x003e:
        r10.J8 = r0;
        return;
    L_0x0041:
        r3 = r10.DW(r6);
        r4 = 10;
        if (r3 == r4) goto L_0x0051;
    L_0x0049:
        r3 = r10.DW(r6);
        r4 = 13;
        if (r3 != r4) goto L_0x0061;
    L_0x0051:
        r3 = r10.DW(r5);
        if (r3 < r8) goto L_0x0061;
    L_0x0057:
        r3 = r10.DW(r5);
        if (r3 > r9) goto L_0x0061;
    L_0x005d:
        r10.tp(r7);
        goto L_0x0014;
    L_0x0061:
        r3 = r10.DW(r6);
        r4 = 34;
        if (r3 != r4) goto L_0x0079;
    L_0x0069:
        r3 = r10.DW(r5);
        if (r3 < r8) goto L_0x0079;
    L_0x006f:
        r3 = r10.DW(r5);
        if (r3 > r9) goto L_0x0079;
    L_0x0075:
        r10.gn(r7);
        goto L_0x0014;
    L_0x0079:
        r3 = r10.DW(r6);
        r4 = 39;
        if (r3 != r4) goto L_0x0091;
    L_0x0081:
        r3 = j3;
        r4 = r10.DW(r5);
        r3 = r3.Hw(r4);
        if (r3 == 0) goto L_0x0091;
    L_0x008d:
        r10.u7(r7);
        goto L_0x0014;
    L_0x0091:
        r3 = r10.DW(r6);
        r4 = 47;
        if (r3 != r4) goto L_0x00ae;
    L_0x0099:
        r3 = r10.DW(r5);
        r4 = 42;
        if (r3 == r4) goto L_0x00a9;
    L_0x00a1:
        r3 = r10.DW(r5);
        r4 = 47;
        if (r3 != r4) goto L_0x00ae;
    L_0x00a9:
        r10.Zo(r7);
        goto L_0x0014;
    L_0x00ae:
        r3 = r10.DW(r6);
        if (r3 < r8) goto L_0x001c;
    L_0x00b4:
        r3 = r10.DW(r6);
        if (r3 > r9) goto L_0x001c;
    L_0x00ba:
        r3 = r10.DW(r5);
        if (r3 < r8) goto L_0x001c;
    L_0x00c0:
        r3 = r10.DW(r5);
        if (r3 > r9) goto L_0x001c;
    L_0x00c6:
        r3 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r10.FH(r3);
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.preprocessor.PreprocessorLexer.j3(boolean):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Mr(boolean r11) {
        /*
        r10 = this;
        r9 = 0;
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r7 = 3;
        r6 = 2;
        r5 = 1;
        r0 = 0;
        r1 = r10.VH;
        r1 = r1.DW();
        r2 = 14;
        r3 = r10.VH;
        r3 = r3.DW();
        r4 = 61;
        r10.DW(r4);
        r4 = r10.VH;
        r4.j6(r3);
    L_0x001f:
        r3 = r10.DW(r5);
        r4 = 59;
        if (r3 != r4) goto L_0x004c;
    L_0x0027:
        r3 = 59;
        r10.DW(r3);
        if (r11 == 0) goto L_0x0049;
    L_0x002e:
        if (r0 != 0) goto L_0x0049;
    L_0x0030:
        r0 = r10.FH(r2);
        r2 = new java.lang.String;
        r3 = r10.VH;
        r3 = r3.j6();
        r4 = r10.VH;
        r4 = r4.DW();
        r4 = r4 - r1;
        r2.<init>(r3, r1, r4);
        r0.j6(r2);
    L_0x0049:
        r10.J8 = r0;
        return;
    L_0x004c:
        r3 = r10.DW(r5);
        r4 = 34;
        if (r3 != r4) goto L_0x0064;
    L_0x0054:
        r3 = r10.DW(r6);
        if (r3 < r7) goto L_0x0064;
    L_0x005a:
        r3 = r10.DW(r6);
        if (r3 > r8) goto L_0x0064;
    L_0x0060:
        r10.gn(r9);
        goto L_0x001f;
    L_0x0064:
        r3 = r10.DW(r5);
        r4 = 39;
        if (r3 != r4) goto L_0x007c;
    L_0x006c:
        r3 = j3;
        r4 = r10.DW(r6);
        r3 = r3.Hw(r4);
        if (r3 == 0) goto L_0x007c;
    L_0x0078:
        r10.u7(r9);
        goto L_0x001f;
    L_0x007c:
        r3 = r10.DW(r5);
        r4 = 10;
        if (r3 == r4) goto L_0x008c;
    L_0x0084:
        r3 = r10.DW(r5);
        r4 = 13;
        if (r3 != r4) goto L_0x009c;
    L_0x008c:
        r3 = r10.DW(r6);
        if (r3 < r7) goto L_0x009c;
    L_0x0092:
        r3 = r10.DW(r6);
        if (r3 > r8) goto L_0x009c;
    L_0x0098:
        r10.tp(r9);
        goto L_0x001f;
    L_0x009c:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0027;
    L_0x00a2:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x0027;
    L_0x00a8:
        r3 = r10.DW(r6);
        if (r3 < r7) goto L_0x0027;
    L_0x00ae:
        r3 = r10.DW(r6);
        if (r3 > r8) goto L_0x0027;
    L_0x00b4:
        r3 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r10.FH(r3);
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.preprocessor.PreprocessorLexer.Mr(boolean):void");
    }

    protected final void U2(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("//");
        while (DW(1) != '\n' && DW(1) != '\r' && DW(1) >= '\u0003' && DW(1) <= '\u00ff' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
            FH('\uffff');
        }
        tp(false);
        if (z && null == null) {
            token = FH(36);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void a8(boolean r10) {
        /*
        r9 = this;
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r7 = 3;
        r6 = 2;
        r5 = 1;
        r0 = 0;
        r1 = r9.VH;
        r1 = r1.DW();
        r2 = 37;
        r3 = "/*";
        r9.j6(r3);
    L_0x0014:
        r3 = r9.DW(r5);
        r4 = 42;
        if (r3 != r4) goto L_0x004a;
    L_0x001c:
        r3 = r9.DW(r6);
        r4 = 47;
        if (r3 != r4) goto L_0x004a;
    L_0x0024:
        r3 = "*/";
        r9.j6(r3);
        if (r10 == 0) goto L_0x0047;
    L_0x002c:
        if (r0 != 0) goto L_0x0047;
    L_0x002e:
        r0 = r9.FH(r2);
        r2 = new java.lang.String;
        r3 = r9.VH;
        r3 = r3.j6();
        r4 = r9.VH;
        r4 = r4.DW();
        r4 = r4 - r1;
        r2.<init>(r3, r1, r4);
        r0.j6(r2);
    L_0x0047:
        r9.J8 = r0;
        return;
    L_0x004a:
        r3 = r9.DW(r5);
        r4 = 10;
        if (r3 == r4) goto L_0x005a;
    L_0x0052:
        r3 = r9.DW(r5);
        r4 = 13;
        if (r3 != r4) goto L_0x006b;
    L_0x005a:
        r3 = r9.DW(r6);
        if (r3 < r7) goto L_0x006b;
    L_0x0060:
        r3 = r9.DW(r6);
        if (r3 > r8) goto L_0x006b;
    L_0x0066:
        r3 = 0;
        r9.tp(r3);
        goto L_0x0014;
    L_0x006b:
        r3 = r9.DW(r5);
        if (r3 < r7) goto L_0x0024;
    L_0x0071:
        r3 = r9.DW(r5);
        if (r3 > r8) goto L_0x0024;
    L_0x0077:
        r3 = r9.DW(r6);
        if (r3 < r7) goto L_0x0024;
    L_0x007d:
        r3 = r9.DW(r6);
        if (r3 > r8) goto L_0x0024;
    L_0x0083:
        r3 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r9.FH(r3);
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.preprocessor.PreprocessorLexer.a8(boolean):void");
    }

    protected final void lg(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\\');
        switch (DW(1)) {
            case '\"':
                DW('\"');
                break;
            case '\'':
                DW('\'');
                break;
            case '0':
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
            case '2':
            case '3':
                j6('0', '3');
                if (DW(1) >= '0' && DW(1) <= '9' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                    rN(false);
                    if (DW(1) >= '0' && DW(1) <= '9' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                        rN(false);
                        break;
                    } else if (DW(1) < '\u0003' || DW(1) > '\u00ff') {
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                } else if (DW(1) < '\u0003' || DW(1) > '\u00ff') {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                break;
            case '4':
            case '5':
            case '6':
            case '7':
                j6('4', '7');
                if (DW(1) >= '0' && DW(1) <= '9' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                    rN(false);
                    break;
                } else if (DW(1) < '\u0003' || DW(1) > '\u00ff') {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                break;
            case '\\':
                DW('\\');
                break;
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                DW('a');
                break;
            case 'b':
                DW('b');
                break;
            case 'f':
                DW('f');
                break;
            case 'n':
                DW('n');
                break;
            case 'r':
                DW('r');
                break;
            case 't':
                DW('t');
                break;
            case 'u':
                DW('u');
                er(false);
                er(false);
                er(false);
                er(false);
                break;
            case 'w':
                DW('w');
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(40);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void rN(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6('0', '9');
        if (z && null == null) {
            token = FH(41);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void er(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case '0':
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                j6('0', '9');
                break;
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                j6('A', 'F');
                break;
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                j6('a', 'f');
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(42);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void yS(boolean r11) {
        /*
        r10 = this;
        r9 = 0;
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r7 = 3;
        r6 = 1;
        r5 = 2;
        r0 = 0;
        r1 = r10.VH;
        r1 = r1.DW();
        r2 = 20;
        r3 = 91;
        r10.DW(r3);
    L_0x0014:
        r3 = r10.DW(r6);
        r4 = 93;
        if (r3 != r4) goto L_0x0041;
    L_0x001c:
        r3 = 93;
        r10.DW(r3);
        if (r11 == 0) goto L_0x003e;
    L_0x0023:
        if (r0 != 0) goto L_0x003e;
    L_0x0025:
        r0 = r10.FH(r2);
        r2 = new java.lang.String;
        r3 = r10.VH;
        r3 = r3.j6();
        r4 = r10.VH;
        r4 = r4.DW();
        r4 = r4 - r1;
        r2.<init>(r3, r1, r4);
        r0.j6(r2);
    L_0x003e:
        r10.J8 = r0;
        return;
    L_0x0041:
        r3 = r10.DW(r6);
        r4 = 91;
        if (r3 != r4) goto L_0x0059;
    L_0x0049:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0059;
    L_0x004f:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x0059;
    L_0x0055:
        r10.yS(r9);
        goto L_0x0014;
    L_0x0059:
        r3 = r10.DW(r6);
        r4 = 10;
        if (r3 == r4) goto L_0x0069;
    L_0x0061:
        r3 = r10.DW(r6);
        r4 = 13;
        if (r3 != r4) goto L_0x0079;
    L_0x0069:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0079;
    L_0x006f:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x0079;
    L_0x0075:
        r10.tp(r9);
        goto L_0x0014;
    L_0x0079:
        r3 = r10.DW(r6);
        r4 = 39;
        if (r3 != r4) goto L_0x0091;
    L_0x0081:
        r3 = j3;
        r4 = r10.DW(r5);
        r3 = r3.Hw(r4);
        if (r3 == 0) goto L_0x0091;
    L_0x008d:
        r10.u7(r9);
        goto L_0x0014;
    L_0x0091:
        r3 = r10.DW(r6);
        r4 = 34;
        if (r3 != r4) goto L_0x00aa;
    L_0x0099:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x00aa;
    L_0x009f:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x00aa;
    L_0x00a5:
        r10.gn(r9);
        goto L_0x0014;
    L_0x00aa:
        r3 = r10.DW(r6);
        if (r3 < r7) goto L_0x001c;
    L_0x00b0:
        r3 = r10.DW(r6);
        if (r3 > r8) goto L_0x001c;
    L_0x00b6:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x001c;
    L_0x00bc:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x001c;
    L_0x00c2:
        r3 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r10.FH(r3);
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.preprocessor.PreprocessorLexer.yS(boolean):void");
    }

    private static final long[] J0() {
        long[] jArr = new long[8];
        jArr[0] = -576460752303423496L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    static {
        j6 = new BitSet(J0());
        DW = new BitSet(J8());
        FH = new BitSet(Ws());
        Hw = new BitSet(QX());
        v5 = new BitSet(XL());
        Zo = new BitSet(aM());
        j3 = new BitSet(j3());
        Mr = new BitSet(Mr());
        U2 = new BitSet(U2());
        a8 = new BitSet(a8());
        lg = new BitSet(lg());
    }

    private static final long[] J8() {
        return new long[]{4294977024L, 0, 0, 0, 0};
    }

    private static final long[] Ws() {
        long[] jArr = new long[8];
        jArr[0] = -2199023255560L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] QX() {
        long[] jArr = new long[8];
        jArr[0] = -576462951326679048L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] XL() {
        return new long[]{4294977024L, 1152921504606846976L, 0, 0, 0};
    }

    private static final long[] aM() {
        long[] jArr = new long[8];
        jArr[0] = -576605355262354440L;
        jArr[1] = -576460752303423489L;
        for (int i = 2; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] j3() {
        long[] jArr = new long[8];
        jArr[0] = -549755813896L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] Mr() {
        long[] jArr = new long[8];
        jArr[0] = -17179869192L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] U2() {
        long[] jArr = new long[8];
        jArr[0] = -549755813896L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] a8() {
        return new long[]{140758963201536L, 576460752303423488L, 0, 0, 0};
    }

    private static final long[] lg() {
        return new long[]{140741783332352L, 576460752303423488L, 0, 0, 0};
    }
}
