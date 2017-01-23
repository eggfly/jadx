package groovyjarjarantlr;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.collections.impl.BitSet;

public class ANTLRTokdefLexer extends CharScanner implements ANTLRTokdefParserTokenTypes, TokenStream {
    public static final BitSet DW;
    public static final BitSet FH;
    public static final BitSet Hw;
    public static final BitSet j6;

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
                        j6(true);
                        token = this.J8;
                        break;
                    case '\"':
                        VH(true);
                        token = this.J8;
                        break;
                    case '(':
                        Hw(true);
                        token = this.J8;
                        break;
                    case ')':
                        v5(true);
                        token = this.J8;
                        break;
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
                        we(true);
                        token = this.J8;
                        break;
                    case '=':
                        Zo(true);
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
                        EQ(true);
                        token = this.J8;
                        break;
                    default:
                        if (DW(1) != '/' || DW(2) != '/') {
                            if (DW(1) == '/' && DW(2) == '*') {
                                FH(true);
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
                        DW(true);
                        token = this.J8;
                        break;
                        break;
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
        this.J8.FH(this.J8.Hw());
        return this.J8;
    }

    public final void j6(boolean z) {
        this.VH.DW();
        switch (DW(1)) {
            case '\t':
                DW('\t');
                break;
            case '\n':
                DW('\n');
                u7();
                break;
            case '\r':
                DW('\r');
                if (DW(1) == '\n') {
                    DW('\n');
                }
                u7();
                break;
            case ' ':
                DW(' ');
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (!z || null == null) {
            this.J8 = null;
        } else {
            this.J8 = null;
        }
    }

    public final void DW(boolean z) {
        this.VH.DW();
        j6("//");
        while (j6.Hw(DW(1))) {
            j6(j6);
        }
        switch (DW(1)) {
            case '\n':
                DW('\n');
                break;
            case '\r':
                DW('\r');
                if (DW(1) == '\n') {
                    DW('\n');
                    break;
                }
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        u7();
        if (!z || null == null) {
            this.J8 = null;
        } else {
            this.J8 = null;
        }
    }

    public final void FH(boolean z) {
        this.VH.DW();
        j6("/*");
        while (true) {
            if (DW(1) != '*' || !DW.Hw(DW(2))) {
                if (DW(1) != '\n') {
                    if (!FH.Hw(DW(1))) {
                        break;
                    }
                    FH('*');
                } else {
                    DW('\n');
                    u7();
                }
            } else {
                DW('*');
                FH('/');
            }
        }
        j6("*/");
        if (!z || null == null) {
            this.J8 = null;
        } else {
            this.J8 = null;
        }
    }

    public final void Hw(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('(');
        if (z && null == null) {
            token = FH(7);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void v5(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(')');
        if (z && null == null) {
            token = FH(8);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Zo(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('=');
        if (z && null == null) {
            token = FH(6);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void VH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\"');
        while (true) {
            if (DW(1) != '\\') {
                if (!Hw.Hw(DW(1))) {
                    break;
                }
                FH('\"');
            } else {
                gn(false);
            }
        }
        DW('\"');
        if (z && null == null) {
            token = FH(5);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void gn(boolean z) {
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
                    u7(false);
                    if (DW(1) >= '0' && DW(1) <= '9' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                        u7(false);
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
                    u7(false);
                    break;
                } else if (DW(1) < '\u0003' || DW(1) > '\u00ff') {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                break;
            case '\\':
                DW('\\');
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
                tp(false);
                tp(false);
                tp(false);
                tp(false);
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(13);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void u7(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6('0', '9');
        if (z && null == null) {
            token = FH(14);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void tp(boolean z) {
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
            token = FH(15);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void EQ(boolean z) {
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
                    if (z && null == null) {
                        token = FH(4);
                        token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                    }
                    this.J8 = token;
                    return;
            }
        }
    }

    public final void we(boolean z) {
        int DW = this.VH.DW();
        int i = 0;
        while (DW(1) >= '0' && DW(1) <= '9') {
            u7(false);
            i++;
        }
        if (i >= 1) {
            Token FH;
            if (z && null == null) {
                FH = FH(9);
                FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            } else {
                FH = null;
            }
            this.J8 = FH;
            return;
        }
        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
    }

    private static final long[] J0() {
        long[] jArr = new long[8];
        jArr[0] = -9224;
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
    }

    private static final long[] J8() {
        long[] jArr = new long[8];
        jArr[0] = -140737488355336L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] Ws() {
        long[] jArr = new long[8];
        jArr[0] = -4398046512136L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] QX() {
        long[] jArr = new long[8];
        jArr[0] = -17179869192L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }
}
