package org.codehaus.groovy.antlr.java;

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

public class JavaLexer extends CharScanner implements TokenStream, JavaTokenTypes {
    public static final BitSet FH;
    public static final BitSet Hw;
    public static final BitSet Mr;
    public static final BitSet Zo;
    public static final BitSet j3;
    public static final BitSet v5;
    protected int DW;
    private boolean U2;
    private boolean a8;
    protected int j6;
    private boolean lg;

    class 1 implements TokenStream {
        final /* synthetic */ JavaLexer j6;

        public Token j6() {
            int i;
            if (this.j6.j6 >= 8) {
                i = this.j6.j6 & 3;
                this.j6.j6 = 0;
                this.j6.EQ();
            }
            Token j6 = this.j6.j6();
            i = j6.Hw();
            if (this.j6.lg) {
                switch (i) {
                    case 165:
                    case 166:
                    case 167:
                        i = this.j6.DW;
                        break;
                }
            }
            this.j6.DW = i;
            return j6;
        }
    }

    public Token j6() {
        do {
            EQ();
            try {
                Token token;
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        ca(true);
                        token = this.J8;
                        break;
                    case '\"':
                        lp(true);
                        token = this.J8;
                        break;
                    case ProxyTextView.INPUTTYPE_time /*36*/:
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
                        br(true);
                        token = this.J8;
                        break;
                    case '\'':
                        sy(true);
                        token = this.J8;
                        break;
                    case '(':
                        DW(true);
                        token = this.J8;
                        break;
                    case ')':
                        FH(true);
                        token = this.J8;
                        break;
                    case ',':
                        u7(true);
                        token = this.J8;
                        break;
                    case '.':
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
                        XX(true);
                        token = this.J8;
                        break;
                    case ':':
                        gn(true);
                        token = this.J8;
                        break;
                    case ';':
                        I(true);
                        token = this.J8;
                        break;
                    case '?':
                        j6(true);
                        token = this.J8;
                        break;
                    case '@':
                        XG(true);
                        token = this.J8;
                        break;
                    case '[':
                        Hw(true);
                        token = this.J8;
                        break;
                    case ']':
                        v5(true);
                        token = this.J8;
                        break;
                    case '{':
                        Zo(true);
                        token = this.J8;
                        break;
                    case '}':
                        VH(true);
                        token = this.J8;
                        break;
                    case '~':
                        J0(true);
                        token = this.J8;
                        break;
                    default:
                        if (DW(1) != '>' || DW(2) != '>' || DW(3) != '>' || DW(4) != '=') {
                            if (DW(1) != '>' || DW(2) != '>' || DW(3) != '=') {
                                if (DW(1) != '>' || DW(2) != '>' || DW(3) != '>') {
                                    if (DW(1) != '<' || DW(2) != '<' || DW(3) != '=') {
                                        if (DW(1) != '=' || DW(2) != '=') {
                                            if (DW(1) != '!' || DW(2) != '=') {
                                                if (DW(1) != '/' || DW(2) != '=') {
                                                    if (DW(1) != '+' || DW(2) != '=') {
                                                        if (DW(1) != '+' || DW(2) != '+') {
                                                            if (DW(1) != '-' || DW(2) != '=') {
                                                                if (DW(1) != '-' || DW(2) != '-') {
                                                                    if (DW(1) != '*' || DW(2) != '=') {
                                                                        if (DW(1) != '%' || DW(2) != '=') {
                                                                            if (DW(1) != '>' || DW(2) != '>') {
                                                                                if (DW(1) != '>' || DW(2) != '=') {
                                                                                    if (DW(1) != '<' || DW(2) != '<') {
                                                                                        if (DW(1) != '<' || DW(2) != '=') {
                                                                                            if (DW(1) != '^' || DW(2) != '=') {
                                                                                                if (DW(1) != '|' || DW(2) != '=') {
                                                                                                    if (DW(1) != '|' || DW(2) != '|') {
                                                                                                        if (DW(1) != '&' || DW(2) != '=') {
                                                                                                            if (DW(1) != '&' || DW(2) != '&') {
                                                                                                                if (DW(1) != '/' || DW(2) != '/') {
                                                                                                                    if (DW(1) == '/' && DW(2) == '*') {
                                                                                                                        Qq(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '=') {
                                                                                                                        tp(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '!') {
                                                                                                                        we(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '/') {
                                                                                                                        Ws(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '+') {
                                                                                                                        XL(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '-') {
                                                                                                                        Mr(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '*') {
                                                                                                                        lg(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '%') {
                                                                                                                        er(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '>') {
                                                                                                                        nw(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '<') {
                                                                                                                        cn(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '^') {
                                                                                                                        sh(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '|') {
                                                                                                                        sG(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    } else if (DW(1) == '&') {
                                                                                                                        vJ(true);
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
                                                                                                                x9(true);
                                                                                                                token = this.J8;
                                                                                                                break;
                                                                                                            }
                                                                                                            Mz(true);
                                                                                                            token = this.J8;
                                                                                                            break;
                                                                                                        }
                                                                                                        g3(true);
                                                                                                        token = this.J8;
                                                                                                        break;
                                                                                                    }
                                                                                                    Sf(true);
                                                                                                    token = this.J8;
                                                                                                    break;
                                                                                                }
                                                                                                ef(true);
                                                                                                token = this.J8;
                                                                                                break;
                                                                                            }
                                                                                            dx(true);
                                                                                            token = this.J8;
                                                                                            break;
                                                                                        }
                                                                                        ro(true);
                                                                                        token = this.J8;
                                                                                        break;
                                                                                    }
                                                                                    SI(true);
                                                                                    token = this.J8;
                                                                                    break;
                                                                                }
                                                                                ei(true);
                                                                                token = this.J8;
                                                                                break;
                                                                            }
                                                                            gW(true);
                                                                            token = this.J8;
                                                                            break;
                                                                        }
                                                                        yS(true);
                                                                        token = this.J8;
                                                                        break;
                                                                    }
                                                                    rN(true);
                                                                    token = this.J8;
                                                                    break;
                                                                }
                                                                a8(true);
                                                                token = this.J8;
                                                                break;
                                                            }
                                                            U2(true);
                                                            token = this.J8;
                                                            break;
                                                        }
                                                        j3(true);
                                                        token = this.J8;
                                                        break;
                                                    }
                                                    aM(true);
                                                    token = this.J8;
                                                    break;
                                                }
                                                QX(true);
                                                token = this.J8;
                                                break;
                                            }
                                            J8(true);
                                            token = this.J8;
                                            break;
                                        }
                                        EQ(true);
                                        token = this.J8;
                                        break;
                                    }
                                    KD(true);
                                    token = this.J8;
                                    break;
                                }
                                vy(true);
                                token = this.J8;
                                break;
                            }
                            BT(true);
                            token = this.J8;
                            break;
                        }
                        P8(true);
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
        Token token = null;
        int DW = this.VH.DW();
        DW('?');
        if (z && null == null) {
            token = FH(69);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void DW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('(');
        if (z && null == null) {
            token = FH(96);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void FH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(')');
        if (z && null == null) {
            token = FH(97);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Hw(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('[');
        if (z && null == null) {
            token = FH(65);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void v5(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(']');
        if (z && null == null) {
            token = FH(66);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Zo(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('{');
        if (z && null == null) {
            token = FH(99);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void VH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('}');
        if (z && null == null) {
            token = FH(100);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void gn(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(':');
        if (z && null == null) {
            token = FH(110);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void u7(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(',');
        if (z && null == null) {
            token = FH(73);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void tp(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('=');
        if (z && null == null) {
            token = FH(98);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void EQ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("==");
        if (z && null == null) {
            token = FH(142);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void we(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('!');
        if (z && null == null) {
            token = FH(154);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void J0(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('~');
        if (z && null == null) {
            token = FH(153);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void J8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("!=");
        if (z && null == null) {
            token = FH(141);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Ws(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('/');
        if (z && null == null) {
            token = FH(149);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void QX(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("/=");
        if (z && null == null) {
            token = FH((int) ProxyTextView.INPUTTYPE_textPassword);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void XL(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('+');
        if (z && null == null) {
            token = FH(147);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void aM(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("+=");
        if (z && null == null) {
            token = FH(126);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void j3(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("++");
        if (z && null == null) {
            token = FH(151);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Mr(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('-');
        if (z && null == null) {
            token = FH(148);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void U2(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("-=");
        if (z && null == null) {
            token = FH(127);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void a8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("--");
        if (z && null == null) {
            token = FH(152);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void lg(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('*');
        if (z && null == null) {
            token = FH(86);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void rN(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("*=");
        if (z && null == null) {
            token = FH(128);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void er(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('%');
        if (z && null == null) {
            token = FH(150);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void yS(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("%=");
        if (z && null == null) {
            token = FH(130);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void gW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">>");
        if (z && null == null) {
            token = FH(75);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void BT(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">>=");
        if (z && null == null) {
            token = FH(131);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void vy(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">>>");
        if (z && null == null) {
            token = FH(76);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void P8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">>>=");
        if (z && null == null) {
            token = FH(132);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void ei(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">=");
        if (z && null == null) {
            token = FH(144);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void nw(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">");
        if (z && null == null) {
            token = FH(74);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void SI(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("<<");
        if (z && null == null) {
            token = FH(146);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void KD(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("<<=");
        if (z && null == null) {
            token = FH(133);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void ro(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("<=");
        if (z && null == null) {
            token = FH(143);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void cn(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('<');
        if (z && null == null) {
            token = FH(72);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void sh(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('^');
        if (z && null == null) {
            token = FH(140);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void dx(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("^=");
        if (z && null == null) {
            token = FH(135);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void sG(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('|');
        if (z && null == null) {
            token = FH(139);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void ef(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("|=");
        if (z && null == null) {
            token = FH(136);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Sf(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("||");
        if (z && null == null) {
            token = FH(137);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void vJ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('&');
        if (z && null == null) {
            token = FH(104);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void g3(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("&=");
        if (z && null == null) {
            token = FH(134);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Mz(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("&&");
        if (z && null == null) {
            token = FH(138);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void I(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(';');
        if (z && null == null) {
            token = FH(62);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void ca(boolean z) {
        int DW = this.VH.DW();
        int i = 0;
        while (true) {
            switch (DW(1)) {
                case '\t':
                    DW('\t');
                    break;
                case '\n':
                case '\r':
                    if (DW(1) == '\r' && DW(2) == '\n') {
                        j6("\r\n");
                    } else if (DW(1) == '\r') {
                        DW('\r');
                    } else if (DW(1) == '\n') {
                        DW('\n');
                    } else {
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                    if (this.QX.VH != 0) {
                        break;
                    }
                    u7();
                    break;
                case '\f':
                    DW('\f');
                    break;
                case ' ':
                    DW(' ');
                    break;
                default:
                    if (i >= 1) {
                        Token FH;
                        if (this.QX.VH == 0) {
                            i = -1;
                        } else {
                            i = 165;
                        }
                        if (z && null == null && i != -1) {
                            FH = FH(i);
                            FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                        } else {
                            FH = null;
                        }
                        this.J8 = FH;
                        return;
                    }
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            i++;
        }
    }

    public final void x9(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        int i = 166;
        j6("//");
        while (FH.Hw(DW(1))) {
            j6(FH);
        }
        if (this.QX.VH == 0) {
            i = -1;
        }
        if (z && null == null && i != -1) {
            token = FH(i);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Qq(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        int i = 167;
        j6("/*");
        while (true) {
            if (DW(1) == '\r' && DW(2) == '\n' && DW(3) >= '\u0003' && DW(3) <= '\uffff' && DW(4) >= '\u0003' && DW(4) <= '\uffff') {
                DW('\r');
                DW('\n');
                if (this.QX.VH == 0) {
                    u7();
                }
            } else if (DW(1) == '*' && DW(2) >= '\u0003' && DW(2) <= '\uffff' && DW(3) >= '\u0003' && DW(3) <= '\uffff' && DW(2) != '/') {
                DW('*');
            } else if (DW(1) != '\r' || DW(2) < '\u0003' || DW(2) > '\uffff' || DW(3) < '\u0003' || DW(3) > '\uffff') {
                if (DW(1) != '\n') {
                    if (!Hw.Hw(DW(1))) {
                        break;
                    }
                    j6(Hw);
                } else {
                    DW('\n');
                    if (this.QX.VH == 0) {
                        u7();
                    }
                }
            } else {
                DW('\r');
                if (this.QX.VH == 0) {
                    u7();
                }
            }
        }
        j6("*/");
        if (this.QX.VH == 0) {
            i = -1;
        }
        if (z && null == null && i != -1) {
            token = FH(i);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void sy(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\'');
        if (DW(1) == '\\') {
            aj(false);
        } else if (v5.Hw(DW(1))) {
            j6(v5);
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        DW('\'');
        if (z && null == null) {
            token = FH(160);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void aj(boolean z) {
        Token FH;
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
                if (DW(1) >= '0' && DW(1) <= '7' && Zo.Hw(DW(2))) {
                    j6('0', '7');
                    if (DW(1) >= '0' && DW(1) <= '7' && Zo.Hw(DW(2))) {
                        j6('0', '7');
                        break;
                    } else if (!Zo.Hw(DW(1))) {
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                } else if (!Zo.Hw(DW(1))) {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                break;
            case '4':
            case '5':
            case '6':
            case '7':
                j6('4', '7');
                if (DW(1) >= '0' && DW(1) <= '7' && Zo.Hw(DW(2))) {
                    j6('0', '7');
                    break;
                } else if (!Zo.Hw(DW(1))) {
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
                int i = 0;
                while (DW(1) == 'u') {
                    DW('u');
                    i++;
                }
                if (i >= 1) {
                    OW(false);
                    OW(false);
                    OW(false);
                    OW(false);
                    break;
                }
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            FH = FH(168);
            FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        } else {
            FH = null;
        }
        this.J8 = FH;
    }

    public final void lp(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\"');
        while (true) {
            if (DW(1) != '\\') {
                if (!j3.Hw(DW(1))) {
                    break;
                }
                j6(j3);
            } else {
                aj(false);
            }
        }
        DW('\"');
        if (z && null == null) {
            token = FH((int) ProxyTextView.INPUTTYPE_textWebEditText);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void OW(boolean z) {
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
            token = FH(169);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void br(boolean z) {
        int DW = this.VH.DW();
        int i = 67;
        switch (DW(1)) {
            case ProxyTextView.INPUTTYPE_time /*36*/:
                DW('$');
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
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        while (true) {
            switch (DW(1)) {
                case ProxyTextView.INPUTTYPE_time /*36*/:
                    DW('$');
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
                    Token FH;
                    if (this.QX.VH == 0) {
                        if (this.U2 && "assert".equals(new String(this.VH.j6(), DW, this.VH.DW() - DW))) {
                            i = 120;
                        }
                        if (this.a8 && "enum".equals(new String(this.VH.j6(), DW, this.VH.DW() - DW))) {
                            i = 103;
                        }
                    }
                    i = Zo(i);
                    if (z && null == null && i != -1) {
                        FH = FH(i);
                        FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                    } else {
                        FH = null;
                    }
                    this.J8 = FH;
                    return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void XX(boolean r12) {
        /*
        r11 = this;
        r4 = 0;
        r0 = r11.VH;
        r6 = r0.DW();
        r0 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        r1 = 0;
        r2 = 0;
        r3 = 1;
        r3 = r11.DW(r3);
        switch(r3) {
            case 46: goto L_0x002a;
            case 47: goto L_0x0013;
            case 48: goto L_0x010f;
            case 49: goto L_0x010f;
            case 50: goto L_0x010f;
            case 51: goto L_0x010f;
            case 52: goto L_0x010f;
            case 53: goto L_0x010f;
            case 54: goto L_0x010f;
            case 55: goto L_0x010f;
            case 56: goto L_0x010f;
            case 57: goto L_0x010f;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x002a:
        r1 = 46;
        r11.DW(r1);
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x0037;
    L_0x0035:
        r0 = 68;
    L_0x0037:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 46: goto L_0x00ff;
            case 47: goto L_0x003f;
            case 48: goto L_0x0062;
            case 49: goto L_0x0062;
            case 50: goto L_0x0062;
            case 51: goto L_0x0062;
            case 52: goto L_0x0062;
            case 53: goto L_0x0062;
            case 54: goto L_0x0062;
            case 55: goto L_0x0062;
            case 56: goto L_0x0062;
            case 57: goto L_0x0062;
            default: goto L_0x003f;
        };
    L_0x003f:
        if (r12 == 0) goto L_0x0454;
    L_0x0041:
        if (r4 != 0) goto L_0x0454;
    L_0x0043:
        r1 = -1;
        if (r0 == r1) goto L_0x0454;
    L_0x0046:
        r0 = r11.FH(r0);
        r1 = new java.lang.String;
        r2 = r11.VH;
        r2 = r2.j6();
        r3 = r11.VH;
        r3 = r3.DW();
        r3 = r3 - r6;
        r1.<init>(r2, r6, r3);
        r0.j6(r1);
    L_0x005f:
        r11.J8 = r0;
        return;
    L_0x0062:
        r1 = 0;
    L_0x0063:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 48;
        if (r3 < r5) goto L_0x007f;
    L_0x006c:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 57;
        if (r3 > r5) goto L_0x007f;
    L_0x0075:
        r3 = 48;
        r5 = 57;
        r11.j6(r3, r5);
        r1 = r1 + 1;
        goto L_0x0063;
    L_0x007f:
        r3 = 1;
        if (r1 < r3) goto L_0x00e4;
    L_0x0082:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 69;
        if (r1 == r3) goto L_0x0094;
    L_0x008b:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r1 != r3) goto L_0x0098;
    L_0x0094:
        r1 = 0;
        r11.kQ(r1);
    L_0x0098:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 68;
        if (r1 == r3) goto L_0x00bc;
    L_0x00a1:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 70;
        if (r1 == r3) goto L_0x00bc;
    L_0x00aa:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 100;
        if (r1 == r3) goto L_0x00bc;
    L_0x00b3:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r1 != r3) goto L_0x0457;
    L_0x00bc:
        r1 = 1;
        r11.yO(r1);
        r1 = r11.J8;
        r3 = r11.QX;
        r3 = r3.VH;
        if (r3 != 0) goto L_0x0457;
    L_0x00c8:
        r2 = r11.QX;
        r2 = r2.VH;
        if (r2 != 0) goto L_0x003f;
    L_0x00ce:
        if (r1 == 0) goto L_0x00fb;
    L_0x00d0:
        r0 = r1.FH();
        r0 = r0.toUpperCase();
        r1 = 70;
        r0 = r0.indexOf(r1);
        if (r0 < 0) goto L_0x00fb;
    L_0x00e0:
        r0 = 162; // 0xa2 float:2.27E-43 double:8.0E-322;
        goto L_0x003f;
    L_0x00e4:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x00fb:
        r0 = 164; // 0xa4 float:2.3E-43 double:8.1E-322;
        goto L_0x003f;
    L_0x00ff:
        r1 = "..";
        r11.j6(r1);
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x003f;
    L_0x010b:
        r0 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        goto L_0x003f;
    L_0x010f:
        r3 = 1;
        r3 = r11.DW(r3);
        switch(r3) {
            case 48: goto L_0x012e;
            case 49: goto L_0x02eb;
            case 50: goto L_0x02eb;
            case 51: goto L_0x02eb;
            case 52: goto L_0x02eb;
            case 53: goto L_0x02eb;
            case 54: goto L_0x02eb;
            case 55: goto L_0x02eb;
            case 56: goto L_0x02eb;
            case 57: goto L_0x02eb;
            default: goto L_0x0117;
        };
    L_0x0117:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x012e:
        r3 = 48;
        r11.DW(r3);
        r3 = r11.QX;
        r3 = r3.VH;
        if (r3 != 0) goto L_0x013a;
    L_0x0139:
        r1 = 1;
    L_0x013a:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 88;
        if (r3 == r5) goto L_0x014c;
    L_0x0143:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r3 != r5) goto L_0x01d6;
    L_0x014c:
        r3 = 1;
        r3 = r11.DW(r3);
        switch(r3) {
            case 88: goto L_0x0185;
            case 120: goto L_0x016b;
            default: goto L_0x0154;
        };
    L_0x0154:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x016b:
        r3 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r11.DW(r3);
    L_0x0170:
        r3 = 0;
    L_0x0171:
        r5 = Mr;
        r7 = 1;
        r7 = r11.DW(r7);
        r5 = r5.Hw(r7);
        if (r5 == 0) goto L_0x018b;
    L_0x017e:
        r5 = 0;
        r11.OW(r5);
        r3 = r3 + 1;
        goto L_0x0171;
    L_0x0185:
        r3 = 88;
        r11.DW(r3);
        goto L_0x0170;
    L_0x018b:
        r5 = 1;
        if (r3 < r5) goto L_0x01bf;
    L_0x018e:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 76;
        if (r3 == r5) goto L_0x01a0;
    L_0x0197:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        if (r3 != r5) goto L_0x032a;
    L_0x01a0:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 76: goto L_0x0324;
            case 108: goto L_0x0315;
            default: goto L_0x01a8;
        };
    L_0x01a8:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x01bf:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x01d6:
        r3 = 0;
        r5 = 1;
        r5 = r11.DW(r5);
        r7 = 48;
        if (r5 < r7) goto L_0x0242;
    L_0x01e0:
        r5 = 1;
        r5 = r11.DW(r5);
        r7 = 57;
        if (r5 > r7) goto L_0x0242;
    L_0x01e9:
        r7 = r11.gn();
        r3 = 1;
        r5 = r11.QX;
        r8 = r5.VH;
        r8 = r8 + 1;
        r5.VH = r8;
        r5 = 0;
    L_0x01f7:
        r8 = 1;
        r8 = r11.DW(r8);	 Catch:{ RecognitionException -> 0x0235 }
        r9 = 48;
        if (r8 < r9) goto L_0x0213;
    L_0x0200:
        r8 = 1;
        r8 = r11.DW(r8);	 Catch:{ RecognitionException -> 0x0235 }
        r9 = 57;
        if (r8 > r9) goto L_0x0213;
    L_0x0209:
        r8 = 48;
        r9 = 57;
        r11.j6(r8, r9);	 Catch:{ RecognitionException -> 0x0235 }
        r5 = r5 + 1;
        goto L_0x01f7;
    L_0x0213:
        r8 = 1;
        if (r5 < r8) goto L_0x0261;
    L_0x0216:
        r5 = 1;
        r5 = r11.DW(r5);	 Catch:{ RecognitionException -> 0x0235 }
        switch(r5) {
            case 46: goto L_0x0278;
            case 68: goto L_0x0283;
            case 69: goto L_0x027e;
            case 70: goto L_0x0283;
            case 100: goto L_0x0283;
            case 101: goto L_0x027e;
            case 102: goto L_0x0283;
            default: goto L_0x021e;
        };	 Catch:{ RecognitionException -> 0x0235 }
    L_0x021e:
        r3 = new groovyjarjarantlr.NoViableAltForCharException;	 Catch:{ RecognitionException -> 0x0235 }
        r5 = 1;
        r5 = r11.DW(r5);	 Catch:{ RecognitionException -> 0x0235 }
        r8 = r11.v5();	 Catch:{ RecognitionException -> 0x0235 }
        r9 = r11.Zo();	 Catch:{ RecognitionException -> 0x0235 }
        r10 = r11.Hw();	 Catch:{ RecognitionException -> 0x0235 }
        r3.<init>(r5, r8, r9, r10);	 Catch:{ RecognitionException -> 0x0235 }
        throw r3;	 Catch:{ RecognitionException -> 0x0235 }
    L_0x0235:
        r3 = move-exception;
        r3 = 0;
    L_0x0237:
        r11.v5(r7);
        r5 = r11.QX;
        r7 = r5.VH;
        r7 = r7 + -1;
        r5.VH = r7;
    L_0x0242:
        if (r3 == 0) goto L_0x02a2;
    L_0x0244:
        r3 = 0;
    L_0x0245:
        r5 = 1;
        r5 = r11.DW(r5);
        r7 = 48;
        if (r5 < r7) goto L_0x0288;
    L_0x024e:
        r5 = 1;
        r5 = r11.DW(r5);
        r7 = 57;
        if (r5 > r7) goto L_0x0288;
    L_0x0257:
        r5 = 48;
        r7 = 57;
        r11.j6(r5, r7);
        r3 = r3 + 1;
        goto L_0x0245;
    L_0x0261:
        r3 = new groovyjarjarantlr.NoViableAltForCharException;	 Catch:{ RecognitionException -> 0x0235 }
        r5 = 1;
        r5 = r11.DW(r5);	 Catch:{ RecognitionException -> 0x0235 }
        r8 = r11.v5();	 Catch:{ RecognitionException -> 0x0235 }
        r9 = r11.Zo();	 Catch:{ RecognitionException -> 0x0235 }
        r10 = r11.Hw();	 Catch:{ RecognitionException -> 0x0235 }
        r3.<init>(r5, r8, r9, r10);	 Catch:{ RecognitionException -> 0x0235 }
        throw r3;	 Catch:{ RecognitionException -> 0x0235 }
    L_0x0278:
        r5 = 46;
        r11.DW(r5);	 Catch:{ RecognitionException -> 0x0235 }
        goto L_0x0237;
    L_0x027e:
        r5 = 0;
        r11.kQ(r5);	 Catch:{ RecognitionException -> 0x0235 }
        goto L_0x0237;
    L_0x0283:
        r5 = 0;
        r11.yO(r5);	 Catch:{ RecognitionException -> 0x0235 }
        goto L_0x0237;
    L_0x0288:
        r5 = 1;
        if (r3 >= r5) goto L_0x018e;
    L_0x028b:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x02a2:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 48;
        if (r3 < r5) goto L_0x018e;
    L_0x02ab:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 55;
        if (r3 > r5) goto L_0x018e;
    L_0x02b4:
        r3 = 0;
    L_0x02b5:
        r5 = 1;
        r5 = r11.DW(r5);
        r7 = 48;
        if (r5 < r7) goto L_0x02d1;
    L_0x02be:
        r5 = 1;
        r5 = r11.DW(r5);
        r7 = 55;
        if (r5 > r7) goto L_0x02d1;
    L_0x02c7:
        r5 = 48;
        r7 = 55;
        r11.j6(r5, r7);
        r3 = r3 + 1;
        goto L_0x02b5;
    L_0x02d1:
        r5 = 1;
        if (r3 >= r5) goto L_0x018e;
    L_0x02d4:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x02eb:
        r3 = 49;
        r5 = 57;
        r11.j6(r3, r5);
    L_0x02f2:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 48;
        if (r3 < r5) goto L_0x030c;
    L_0x02fb:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 57;
        if (r3 > r5) goto L_0x030c;
    L_0x0304:
        r3 = 48;
        r5 = 57;
        r11.j6(r3, r5);
        goto L_0x02f2;
    L_0x030c:
        r3 = r11.QX;
        r3 = r3.VH;
        if (r3 != 0) goto L_0x018e;
    L_0x0312:
        r1 = 1;
        goto L_0x018e;
    L_0x0315:
        r1 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r11.DW(r1);
    L_0x031a:
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x003f;
    L_0x0320:
        r0 = 163; // 0xa3 float:2.28E-43 double:8.05E-322;
        goto L_0x003f;
    L_0x0324:
        r1 = 76;
        r11.DW(r1);
        goto L_0x031a;
    L_0x032a:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 46;
        if (r3 == r5) goto L_0x0369;
    L_0x0333:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 68;
        if (r3 == r5) goto L_0x0369;
    L_0x033c:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 69;
        if (r3 == r5) goto L_0x0369;
    L_0x0345:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 70;
        if (r3 == r5) goto L_0x0369;
    L_0x034e:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 100;
        if (r3 == r5) goto L_0x0369;
    L_0x0357:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 == r5) goto L_0x0369;
    L_0x0360:
        r3 = 1;
        r3 = r11.DW(r3);
        r5 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r3 != r5) goto L_0x003f;
    L_0x0369:
        if (r1 == 0) goto L_0x003f;
    L_0x036b:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 46: goto L_0x038a;
            case 68: goto L_0x0442;
            case 69: goto L_0x040c;
            case 70: goto L_0x0442;
            case 100: goto L_0x0442;
            case 101: goto L_0x040c;
            case 102: goto L_0x0442;
            default: goto L_0x0373;
        };
    L_0x0373:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x038a:
        r1 = 46;
        r11.DW(r1);
    L_0x038f:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 48;
        if (r1 < r3) goto L_0x03a9;
    L_0x0398:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 57;
        if (r1 > r3) goto L_0x03a9;
    L_0x03a1:
        r1 = 48;
        r3 = 57;
        r11.j6(r1, r3);
        goto L_0x038f;
    L_0x03a9:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 69;
        if (r1 == r3) goto L_0x03bb;
    L_0x03b2:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r1 != r3) goto L_0x03bf;
    L_0x03bb:
        r1 = 0;
        r11.kQ(r1);
    L_0x03bf:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 68;
        if (r1 == r3) goto L_0x03e3;
    L_0x03c8:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 70;
        if (r1 == r3) goto L_0x03e3;
    L_0x03d1:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 100;
        if (r1 == r3) goto L_0x03e3;
    L_0x03da:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r1 != r3) goto L_0x03f0;
    L_0x03e3:
        r1 = 1;
        r11.yO(r1);
        r1 = r11.J8;
        r3 = r11.QX;
        r3 = r3.VH;
        if (r3 != 0) goto L_0x03f0;
    L_0x03ef:
        r2 = r1;
    L_0x03f0:
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x003f;
    L_0x03f6:
        if (r2 == 0) goto L_0x0450;
    L_0x03f8:
        r0 = r2.FH();
        r0 = r0.toUpperCase();
        r1 = 70;
        r0 = r0.indexOf(r1);
        if (r0 < 0) goto L_0x0450;
    L_0x0408:
        r0 = 162; // 0xa2 float:2.27E-43 double:8.0E-322;
        goto L_0x003f;
    L_0x040c:
        r1 = 0;
        r11.kQ(r1);
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 68;
        if (r1 == r3) goto L_0x0434;
    L_0x0419:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 70;
        if (r1 == r3) goto L_0x0434;
    L_0x0422:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 100;
        if (r1 == r3) goto L_0x0434;
    L_0x042b:
        r1 = 1;
        r1 = r11.DW(r1);
        r3 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r1 != r3) goto L_0x03f0;
    L_0x0434:
        r1 = 1;
        r11.yO(r1);
        r1 = r11.J8;
        r3 = r11.QX;
        r3 = r3.VH;
        if (r3 != 0) goto L_0x03f0;
    L_0x0440:
        r2 = r1;
        goto L_0x03f0;
    L_0x0442:
        r1 = 1;
        r11.yO(r1);
        r1 = r11.J8;
        r3 = r11.QX;
        r3 = r3.VH;
        if (r3 != 0) goto L_0x03f0;
    L_0x044e:
        r2 = r1;
        goto L_0x03f0;
    L_0x0450:
        r0 = 164; // 0xa4 float:2.3E-43 double:8.1E-322;
        goto L_0x003f;
    L_0x0454:
        r0 = r4;
        goto L_0x005f;
    L_0x0457:
        r1 = r2;
        goto L_0x00c8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.java.JavaLexer.XX(boolean):void");
    }

    protected final void kQ(boolean z) {
        int DW = this.VH.DW();
        switch (DW(1)) {
            case 'E':
                DW('E');
                break;
            case 'e':
                DW('e');
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        switch (DW(1)) {
            case '+':
                DW('+');
                break;
            case '-':
                DW('-');
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
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        int i = 0;
        while (DW(1) >= '0' && DW(1) <= '9') {
            j6('0', '9');
            i++;
        }
        if (i >= 1) {
            Token FH;
            if (z && null == null) {
                FH = FH(171);
                FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            } else {
                FH = null;
            }
            this.J8 = FH;
            return;
        }
        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
    }

    protected final void yO(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case 'D':
                DW('D');
                break;
            case 'F':
                DW('F');
                break;
            case 'd':
                DW('d');
                break;
            case 'f':
                DW('f');
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(172);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void XG(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('@');
        if (z && null == null) {
            token = FH(95);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    private static final long[] J0() {
        long[] jArr = new long[2048];
        jArr[0] = -9224;
        for (int i = 1; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    static {
        FH = new BitSet(J0());
        Hw = new BitSet(J8());
        v5 = new BitSet(Ws());
        Zo = new BitSet(QX());
        j3 = new BitSet(XL());
        Mr = new BitSet(aM());
    }

    private static final long[] J8() {
        long[] jArr = new long[2048];
        jArr[0] = -4398046520328L;
        for (int i = 1; i <= 1023; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] Ws() {
        long[] jArr = new long[2048];
        jArr[0] = -549755823112L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 1023; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] QX() {
        long[] jArr = new long[2048];
        jArr[0] = -9224;
        for (int i = 1; i <= 1023; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] XL() {
        long[] jArr = new long[2048];
        jArr[0] = -17179878408L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 1023; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] aM() {
        long[] jArr = new long[1025];
        jArr[0] = 287948901175001088L;
        jArr[1] = 541165879422L;
        return jArr;
    }
}
