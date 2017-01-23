package groovyjarjarantlr;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.collections.impl.BitSet;

public class ANTLRLexer extends CharScanner implements ANTLRTokenTypes, TokenStream {
    public static final BitSet DW;
    public static final BitSet FH;
    public static final BitSet Hw;
    public static final BitSet Zo;
    public static final BitSet j6;
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
                        j6(true);
                        token = this.J8;
                        break;
                    case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                        j3(true);
                        token = this.J8;
                        break;
                    case '\"':
                        gW(true);
                        token = this.J8;
                        break;
                    case '#':
                        u7(true);
                        token = this.J8;
                        break;
                    case '\'':
                        er(true);
                        token = this.J8;
                        break;
                    case '(':
                        tp(true);
                        token = this.J8;
                        break;
                    case ')':
                        EQ(true);
                        token = this.J8;
                        break;
                    case '*':
                        J0(true);
                        token = this.J8;
                        break;
                    case '+':
                        J8(true);
                        token = this.J8;
                        break;
                    case ',':
                        VH(true);
                        token = this.J8;
                        break;
                    case '/':
                        DW(true);
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
                        vy(true);
                        token = this.J8;
                        break;
                    case ':':
                        we(true);
                        token = this.J8;
                        break;
                    case ';':
                        XL(true);
                        token = this.J8;
                        break;
                    case '<':
                        v5(true);
                        token = this.J8;
                        break;
                    case '>':
                        Zo(true);
                        token = this.J8;
                        break;
                    case '?':
                        gn(true);
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
                        KD(true);
                        token = this.J8;
                        break;
                    case '[':
                        P8(true);
                        token = this.J8;
                        break;
                    case '^':
                        aM(true);
                        token = this.J8;
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
                        ro(true);
                        token = this.J8;
                        break;
                    case '{':
                        nw(true);
                        token = this.J8;
                        break;
                    case '|':
                        Mr(true);
                        token = this.J8;
                        break;
                    case '}':
                        rN(true);
                        token = this.J8;
                        break;
                    case '~':
                        lg(true);
                        token = this.J8;
                        break;
                    default:
                        if (DW(1) != '=' || DW(2) != '>') {
                            if (DW(1) == '.' && DW(2) == '.') {
                                a8(true);
                                token = this.J8;
                                break;
                            } else if (DW(1) == '=') {
                                Ws(true);
                                token = this.J8;
                                break;
                            } else if (DW(1) == '.') {
                                U2(true);
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
                        QX(true);
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
            case ' ':
                DW(' ');
                break;
            default:
                if (DW(1) == '\r' && DW(2) == '\n') {
                    DW('\r');
                    DW('\n');
                    u7();
                    break;
                } else if (DW(1) == '\r') {
                    DW('\r');
                    u7();
                    break;
                } else {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                break;
        }
        if (!z || null == null) {
            this.J8 = null;
        } else {
            this.J8 = null;
        }
    }

    public final void DW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        int i = 53;
        if (DW(1) == '/' && DW(2) == '/') {
            FH(false);
        } else if (DW(1) == '/' && DW(2) == '*') {
            Hw(true);
            i = this.J8.Hw();
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (i != 8) {
            i = -1;
        }
        if (z && null == null && i != -1) {
            token = FH(i);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void FH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("//");
        while (j6.Hw(DW(1))) {
            j6(j6);
        }
        if (DW(1) == '\r' && DW(2) == '\n') {
            DW('\r');
            DW('\n');
        } else if (DW(1) == '\r') {
            DW('\r');
        } else if (DW(1) == '\n') {
            DW('\n');
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        u7();
        if (z && null == null) {
            token = FH(54);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void Hw(boolean z) {
        Token FH;
        int DW = this.VH.DW();
        int i = 55;
        j6("/*");
        if (DW(1) == '*' && DW(2) >= '\u0003' && DW(2) <= '\u00ff' && DW(2) != '/') {
            DW('*');
            i = 8;
        } else if (DW(1) < '\u0003' || DW(1) > '\u00ff' || DW(2) < '\u0003' || DW(2) > '\u00ff') {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        while (true) {
            if (DW(1) == '*' && DW(2) == '/') {
                break;
            } else if (DW(1) == '\r' && DW(2) == '\n') {
                DW('\r');
                DW('\n');
                u7();
            } else if (DW(1) == '\r' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                DW('\r');
                u7();
            } else if (!j6.Hw(DW(1)) || DW(2) < '\u0003' || DW(2) > '\u00ff') {
                if (DW(1) != '\n') {
                    break;
                }
                DW('\n');
                u7();
            } else {
                j6(j6);
            }
        }
        j6("*/");
        if (z && null == null && i != -1) {
            FH = FH(i);
            FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        } else {
            FH = null;
        }
        this.J8 = FH;
    }

    public final void v5(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('<');
        if (z && null == null) {
            token = FH(25);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Zo(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('>');
        if (z && null == null) {
            token = FH(26);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void VH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(',');
        if (z && null == null) {
            token = FH(38);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void gn(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('?');
        if (z && null == null) {
            token = FH(45);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void u7(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("#(");
        if (z && null == null) {
            token = FH(44);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void tp(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('(');
        if (z && null == null) {
            token = FH(27);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void EQ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(')');
        if (z && null == null) {
            token = FH(28);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void we(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(':');
        if (z && null == null) {
            token = FH(36);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void J0(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('*');
        if (z && null == null) {
            token = FH(46);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void J8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('+');
        if (z && null == null) {
            token = FH(47);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Ws(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('=');
        if (z && null == null) {
            token = FH(15);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void QX(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("=>");
        if (z && null == null) {
            token = FH(48);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void XL(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(';');
        if (z && null == null) {
            token = FH(16);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void aM(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('^');
        if (z && null == null) {
            token = FH(49);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void j3(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('!');
        if (z && null == null) {
            token = FH(33);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Mr(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('|');
        if (z && null == null) {
            token = FH(21);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void U2(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('.');
        if (z && null == null) {
            token = FH(50);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void a8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("..");
        if (z && null == null) {
            token = FH(22);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void lg(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('~');
        if (z && null == null) {
            token = FH(42);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void rN(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('}');
        if (z && null == null) {
            token = FH(17);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void er(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\'');
        if (DW(1) == '\\') {
            yS(false);
        } else if (DW.Hw(DW(1))) {
            FH('\'');
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        DW('\'');
        if (z && null == null) {
            token = FH(19);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void yS(boolean z) {
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
                if (DW(1) >= '0' && DW(1) <= '7' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                    j6('0', '7');
                    if (DW(1) >= '0' && DW(1) <= '7' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                        j6('0', '7');
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
                if (DW(1) >= '0' && DW(1) <= '7' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                    j6('0', '7');
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
                BT(false);
                BT(false);
                BT(false);
                BT(false);
                break;
            case 'w':
                DW('w');
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(56);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void gW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\"');
        while (true) {
            if (DW(1) != '\\') {
                if (!FH.Hw(DW(1))) {
                    break;
                }
                FH('\"');
            } else {
                yS(false);
            }
        }
        DW('\"');
        if (z && null == null) {
            token = FH(6);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void BT(boolean z) {
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
            token = FH(58);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void vy(boolean z) {
        int DW = this.VH.DW();
        int i = 0;
        while (DW(1) >= '0' && DW(1) <= '9') {
            j6('0', '9');
            i++;
        }
        if (i >= 1) {
            Token FH;
            if (z && null == null) {
                FH = FH(20);
                FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            } else {
                FH = null;
            }
            this.J8 = FH;
            return;
        }
        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
    }

    public final void P8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        ei(false);
        v5(StringUtils.j6(VH(), "[", "]"));
        if (z && null == null) {
            token = FH(34);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void ei(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('[');
        while (true) {
            switch (DW(1)) {
                case '\n':
                    DW('\n');
                    u7();
                    break;
                case '\"':
                    gW(false);
                    break;
                case '\'':
                    er(false);
                    break;
                case '[':
                    ei(false);
                    break;
                default:
                    if (DW(1) != '\r' || DW(2) != '\n') {
                        if (DW(1) == '\r' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                            DW('\r');
                            u7();
                            break;
                        } else if (Hw.Hw(DW(1))) {
                            FH(']');
                            break;
                        } else {
                            DW(']');
                            if (z && null == null) {
                                token = FH(59);
                                token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                            }
                            this.J8 = token;
                            return;
                        }
                    }
                    DW('\r');
                    DW('\n');
                    u7();
                    break;
                    break;
            }
        }
    }

    public final void nw(boolean z) {
        int i;
        int DW = this.VH.DW();
        int Zo = Zo();
        int Hw = Hw();
        SI(false);
        if (DW(1) == '?') {
            DW('?');
            i = 43;
        } else {
            i = 7;
        }
        if (i == 7) {
            v5(StringUtils.j6(VH(), "{", "}"));
        } else {
            v5(StringUtils.j6(VH(), "{", "}?"));
        }
        Token commonToken = new CommonToken(i, new String(this.VH.j6(), DW, this.VH.DW() - DW));
        commonToken.j6(Zo);
        commonToken.DW(Hw);
        if (z && commonToken == null && i != -1) {
            commonToken = FH(i);
            commonToken.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = commonToken;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void SI(boolean r11) {
        /*
        r10 = this;
        r9 = 10;
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r7 = 3;
        r6 = 1;
        r5 = 2;
        r0 = 0;
        r1 = r10.VH;
        r1 = r1.DW();
        r2 = 60;
        r3 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r10.DW(r3);
    L_0x0015:
        r3 = r10.DW(r6);
        r4 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r3 != r4) goto L_0x0042;
    L_0x001d:
        r3 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r10.DW(r3);
        if (r11 == 0) goto L_0x003f;
    L_0x0024:
        if (r0 != 0) goto L_0x003f;
    L_0x0026:
        r0 = r10.FH(r2);
        r2 = new java.lang.String;
        r3 = r10.VH;
        r3 = r3.j6();
        r4 = r10.VH;
        r4 = r4.DW();
        r4 = r4 - r1;
        r2.<init>(r3, r1, r4);
        r0.j6(r2);
    L_0x003f:
        r10.J8 = r0;
        return;
    L_0x0042:
        r3 = r10.DW(r6);
        if (r3 == r9) goto L_0x0050;
    L_0x0048:
        r3 = r10.DW(r6);
        r4 = 13;
        if (r3 != r4) goto L_0x00b7;
    L_0x0050:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x00b7;
    L_0x0056:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x00b7;
    L_0x005c:
        r3 = r10.DW(r6);
        r4 = 13;
        if (r3 != r4) goto L_0x0076;
    L_0x0064:
        r3 = r10.DW(r5);
        if (r3 != r9) goto L_0x0076;
    L_0x006a:
        r3 = 13;
        r10.DW(r3);
        r10.DW(r9);
        r10.u7();
        goto L_0x0015;
    L_0x0076:
        r3 = r10.DW(r6);
        r4 = 13;
        if (r3 != r4) goto L_0x0093;
    L_0x007e:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0093;
    L_0x0084:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x0093;
    L_0x008a:
        r3 = 13;
        r10.DW(r3);
        r10.u7();
        goto L_0x0015;
    L_0x0093:
        r3 = r10.DW(r6);
        if (r3 != r9) goto L_0x00a1;
    L_0x0099:
        r10.DW(r9);
        r10.u7();
        goto L_0x0015;
    L_0x00a1:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r10.DW(r6);
        r2 = r10.v5();
        r3 = r10.Zo();
        r4 = r10.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x00b7:
        r3 = r10.DW(r6);
        r4 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r3 != r4) goto L_0x00d1;
    L_0x00bf:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x00d1;
    L_0x00c5:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x00d1;
    L_0x00cb:
        r3 = 0;
        r10.SI(r3);
        goto L_0x0015;
    L_0x00d1:
        r3 = r10.DW(r6);
        r4 = 39;
        if (r3 != r4) goto L_0x00eb;
    L_0x00d9:
        r3 = v5;
        r4 = r10.DW(r5);
        r3 = r3.Hw(r4);
        if (r3 == 0) goto L_0x00eb;
    L_0x00e5:
        r3 = 0;
        r10.er(r3);
        goto L_0x0015;
    L_0x00eb:
        r3 = r10.DW(r6);
        r4 = 47;
        if (r3 != r4) goto L_0x0109;
    L_0x00f3:
        r3 = r10.DW(r5);
        r4 = 42;
        if (r3 == r4) goto L_0x0103;
    L_0x00fb:
        r3 = r10.DW(r5);
        r4 = 47;
        if (r3 != r4) goto L_0x0109;
    L_0x0103:
        r3 = 0;
        r10.DW(r3);
        goto L_0x0015;
    L_0x0109:
        r3 = r10.DW(r6);
        r4 = 34;
        if (r3 != r4) goto L_0x0123;
    L_0x0111:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x0123;
    L_0x0117:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x0123;
    L_0x011d:
        r3 = 0;
        r10.gW(r3);
        goto L_0x0015;
    L_0x0123:
        r3 = r10.DW(r6);
        if (r3 < r7) goto L_0x001d;
    L_0x0129:
        r3 = r10.DW(r6);
        if (r3 > r8) goto L_0x001d;
    L_0x012f:
        r3 = r10.DW(r5);
        if (r3 < r7) goto L_0x001d;
    L_0x0135:
        r3 = r10.DW(r5);
        if (r3 > r8) goto L_0x001d;
    L_0x013b:
        r3 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r10.FH(r3);
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.ANTLRLexer.SI(boolean):void");
    }

    public final void KD(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6('A', 'Z');
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
                    int Zo = Zo(24);
                    if (z && null == null && Zo != -1) {
                        token = FH(Zo);
                        token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                    }
                    this.J8 = token;
                    return;
            }
        }
    }

    public final void ro(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        int cn = cn(false);
        if (cn == 51) {
            sh(false);
            if (DW(1) == '{') {
                DW('{');
                cn = 14;
            }
        } else if (cn == 4) {
            sh(false);
            if (DW(1) == '{') {
                DW('{');
                cn = 23;
            }
        }
        if (z && null == null && cn != -1) {
            token = FH(cn);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final int cn(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6('a', 'z');
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
                    int Zo = Zo(41);
                    if (z && null == null) {
                        token = FH(62);
                        token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                    }
                    this.J8 = token;
                    return Zo;
            }
        }
    }

    protected final void sh(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        while (true) {
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    j6(false);
                    break;
                case '/':
                    DW(false);
                    break;
                default:
                    if (z && null == null) {
                        token = FH(61);
                        token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                    }
                    this.J8 = token;
                    return;
            }
        }
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
        v5 = new BitSet(XL());
        Zo = new BitSet(aM());
    }

    private static final long[] J8() {
        long[] jArr = new long[8];
        jArr[0] = -549755813896L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] Ws() {
        long[] jArr = new long[8];
        jArr[0] = -17179869192L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] QX() {
        long[] jArr = new long[8];
        jArr[0] = -566935692296L;
        jArr[1] = -671088641;
        for (int i = 2; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] XL() {
        long[] jArr = new long[8];
        jArr[0] = -549755813896L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] aM() {
        return new long[]{4294977024L, 0, 0, 0, 0};
    }
}
