package groovyjarjarantlr.actions.java;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.ActionTransInfo;
import groovyjarjarantlr.CharScanner;
import groovyjarjarantlr.CharStreamException;
import groovyjarjarantlr.CharStreamIOException;
import groovyjarjarantlr.CodeGenerator;
import groovyjarjarantlr.NoViableAltForCharException;
import groovyjarjarantlr.RecognitionException;
import groovyjarjarantlr.RuleBlock;
import groovyjarjarantlr.Token;
import groovyjarjarantlr.TokenStream;
import groovyjarjarantlr.TokenStreamException;
import groovyjarjarantlr.TokenStreamIOException;
import groovyjarjarantlr.TokenStreamRecognitionException;
import groovyjarjarantlr.Tool;
import groovyjarjarantlr.collections.impl.BitSet;
import groovyjarjarantlr.collections.impl.Vector;

public class ActionLexer extends CharScanner implements TokenStream, ActionLexerTokenTypes {
    public static final BitSet BT;
    public static final BitSet Hw;
    public static final BitSet KD;
    public static final BitSet Mr;
    public static final BitSet P8;
    public static final BitSet SI;
    public static final BitSet U2;
    public static final BitSet Zo;
    public static final BitSet a8;
    public static final BitSet cb;
    public static final BitSet cn;
    public static final BitSet dx;
    public static final BitSet ef;
    public static final BitSet ei;
    public static final BitSet er;
    public static final BitSet gW;
    public static final BitSet j3;
    public static final BitSet lg;
    public static final BitSet nw;
    public static final BitSet rN;
    public static final BitSet ro;
    public static final BitSet sG;
    public static final BitSet sh;
    public static final BitSet v5;
    public static final BitSet vy;
    public static final BitSet yS;
    protected CodeGenerator DW;
    ActionTransInfo FH;
    private Tool Sf;
    protected RuleBlock j6;

    public void FH(String str) {
        this.Sf.j6(str, v5(), Zo(), Hw());
    }

    public void Hw(String str) {
        if (v5() == null) {
            this.Sf.Hw(str);
        } else {
            this.Sf.DW(str, v5(), Zo(), Hw());
        }
    }

    public Token j6() {
        do {
            EQ();
            try {
                if (DW(1) >= '\u0003' && DW(1) <= '\u00ff') {
                    j6(true);
                    Token token = this.J8;
                } else if (DW(1) == '\uffff') {
                    we();
                    this.J8 = FH(1);
                } else {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
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
        int DW = this.VH.DW();
        int i = 0;
        while (true) {
            switch (DW(1)) {
                case '#':
                    FH(false);
                    break;
                case ProxyTextView.INPUTTYPE_time /*36*/:
                    Hw(false);
                    break;
                default:
                    if (Hw.Hw(DW(1))) {
                        DW(false);
                        break;
                    } else if (i >= 1) {
                        Token FH;
                        if (z && null == null) {
                            FH = FH(4);
                            FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                        } else {
                            FH = null;
                        }
                        this.J8 = FH;
                        return;
                    } else {
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
            }
            i++;
        }
    }

    protected final void DW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case '\n':
                DW('\n');
                u7();
                break;
            case '\"':
                Zo(false);
                break;
            case '\'':
                VH(false);
                break;
            default:
                if (DW(1) != '/' || (DW(2) != '*' && DW(2) != '/')) {
                    if (DW(1) != '\r' || DW(2) != '\n') {
                        if (DW(1) == '/' && v5.Hw(DW(2))) {
                            DW('/');
                            j6(v5);
                            break;
                        } else if (DW(1) == '\r') {
                            DW('\r');
                            u7();
                            break;
                        } else if (Zo.Hw(DW(1))) {
                            j6(Zo);
                            break;
                        } else {
                            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                        }
                    }
                    j6("\r\n");
                    u7();
                    break;
                }
                v5(false);
                break;
                break;
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
        int DW2;
        Token token2;
        if (DW(1) == '#' && DW(2) == '(') {
            DW2 = this.VH.DW();
            DW('#');
            this.VH.j6(DW2);
            gn(true);
            token2 = this.J8;
        } else if (DW(1) == '#' && j3.Hw(DW(2))) {
            DW2 = this.VH.DW();
            DW('#');
            this.VH.j6(DW2);
            u7(true);
            r3 = this.DW.j6(this.J8.FH(), this.FH);
            if (r3 != null) {
                this.VH.j6(DW);
                this.VH.j6(r3);
            }
            if (Mr.Hw(DW(1))) {
                tp(false);
            }
            if (DW(1) == '=') {
                EQ(false);
            }
        } else if (DW(1) == '#' && DW(2) == '[') {
            DW2 = this.VH.DW();
            DW('#');
            this.VH.j6(DW2);
            we(true);
            token2 = this.J8;
        } else if (DW(1) == '#' && DW(2) == '#') {
            j6("##");
            r3 = new StringBuffer().append(this.j6.FH()).append("_AST").toString();
            this.VH.j6(DW);
            this.VH.j6(r3);
            if (this.FH != null) {
                this.FH.DW = r3;
            }
            if (Mr.Hw(DW(1))) {
                tp(false);
            }
            if (DW(1) == '=') {
                EQ(false);
            }
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
        int DW = this.VH.DW();
        Token token = null;
        String FH;
        String FH2;
        if (DW(1) == '$' && DW(2) == 'F' && DW(3) == 'O') {
            j6("$FOLLOW");
            if (U2.Hw(DW(1)) && a8.Hw(DW(2)) && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        tp(false);
                        break;
                    case '(':
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                DW('(');
                J0(true);
                token = this.J8;
                DW(')');
            }
            FH = this.j6.FH();
            if (token != null) {
                FH2 = token.FH();
            } else {
                FH2 = FH;
            }
            FH = this.DW.j6(FH2, 1);
            if (FH == null) {
                FH(new StringBuffer().append("$FOLLOW(").append(FH2).append(")").append(": unknown rule or bad lookahead computation").toString());
            } else {
                this.VH.j6(DW);
                this.VH.j6(FH);
            }
        } else if (DW(1) == '$' && DW(2) == 'F' && DW(3) == 'I') {
            j6("$FIRST");
            if (!U2.Hw(DW(1)) || !a8.Hw(DW(2)) || DW(3) < '\u0003' || DW(3) > '\u00ff') {
                token = null;
            } else {
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        tp(false);
                        break;
                    case '(':
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                DW('(');
                J0(true);
                token = this.J8;
                DW(')');
            }
            FH = this.j6.FH();
            if (token != null) {
                FH2 = token.FH();
            } else {
                FH2 = FH;
            }
            FH = this.DW.DW(FH2, 1);
            if (FH == null) {
                FH(new StringBuffer().append("$FIRST(").append(FH2).append(")").append(": unknown rule or bad lookahead computation").toString());
            } else {
                this.VH.j6(DW);
                this.VH.j6(FH);
            }
        } else if (DW(1) == '$' && DW(2) == 'a') {
            j6("$append");
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    tp(false);
                    break;
                case '(':
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            DW('(');
            J0(true);
            token = this.J8;
            DW(')');
            FH2 = new StringBuffer().append("text.append(").append(token.FH()).append(")").toString();
            this.VH.j6(DW);
            this.VH.j6(FH2);
        } else if (DW(1) == '$' && DW(2) == 's') {
            j6("$set");
            if (DW(1) == 'T' && DW(2) == 'e') {
                j6("Text");
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        tp(false);
                        break;
                    case '(':
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                DW('(');
                J0(true);
                token = this.J8;
                DW(')');
                FH2 = new StringBuffer().append("text.setLength(_begin); text.append(").append(token.FH()).append(")").toString();
                this.VH.j6(DW);
                this.VH.j6(FH2);
            } else if (DW(1) == 'T' && DW(2) == 'o') {
                j6("Token");
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        tp(false);
                        break;
                    case '(':
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                DW('(');
                J0(true);
                token = this.J8;
                DW(')');
                FH2 = new StringBuffer().append("_token = ").append(token.FH()).toString();
                this.VH.j6(DW);
                this.VH.j6(FH2);
            } else if (DW(1) == 'T' && DW(2) == 'y') {
                j6("Type");
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        tp(false);
                        break;
                    case '(':
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                DW('(');
                J0(true);
                token = this.J8;
                DW(')');
                FH2 = new StringBuffer().append("_ttype = ").append(token.FH()).toString();
                this.VH.j6(DW);
                this.VH.j6(FH2);
            } else {
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
        } else if (DW(1) == '$' && DW(2) == 'g') {
            j6("$getText");
            this.VH.j6(DW);
            this.VH.j6("new String(text.getBuffer(),_begin,text.length()-_begin)");
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(7);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        } else {
            token = null;
        }
        this.J8 = token;
    }

    protected final void v5(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        if (DW(1) == '/' && DW(2) == '/') {
            a8(false);
        } else if (DW(1) == '/' && DW(2) == '*') {
            lg(false);
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(19);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void Zo(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\"');
        while (true) {
            if (DW(1) != '\\') {
                if (!lg.Hw(DW(1))) {
                    break;
                }
                FH('\"');
            } else {
                rN(false);
            }
        }
        DW('\"');
        if (z && null == null) {
            token = FH(23);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void VH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('\'');
        if (DW(1) == '\\') {
            rN(false);
        } else if (rN.Hw(DW(1))) {
            FH('\'');
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        DW('\'');
        if (z && null == null) {
            token = FH(22);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void gn(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector(10);
        int DW2 = this.VH.DW();
        DW('(');
        this.VH.j6(DW2);
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                DW2 = this.VH.DW();
                tp(false);
                this.VH.j6(DW2);
                break;
            case '\"':
            case '#':
            case '(':
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
            case '[':
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
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        DW2 = this.VH.DW();
        J8(true);
        this.VH.j6(DW2);
        vector.j6(this.J8.FH());
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                DW2 = this.VH.DW();
                tp(false);
                this.VH.j6(DW2);
                break;
            case ')':
            case ',':
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        while (DW(1) == ',') {
            DW2 = this.VH.DW();
            DW(',');
            this.VH.j6(DW2);
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    DW2 = this.VH.DW();
                    tp(false);
                    this.VH.j6(DW2);
                    break;
                case '\"':
                case '#':
                case '(':
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
                case '[':
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
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            DW2 = this.VH.DW();
            J8(true);
            this.VH.j6(DW2);
            vector.j6(this.J8.FH());
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    DW2 = this.VH.DW();
                    tp(false);
                    this.VH.j6(DW2);
                    break;
                case ')':
                case ',':
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
        }
        this.VH.j6(DW);
        this.VH.j6(this.DW.j6(vector));
        int DW3 = this.VH.DW();
        DW(')');
        this.VH.j6(DW3);
        if (z && null == null) {
            token = FH(8);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void u7(boolean z) {
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
        while (er.Hw(DW(1))) {
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
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
        }
        if (z && null == null) {
            token = FH(17);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void tp(boolean z) {
        int DW = this.VH.DW();
        int i = 0;
        while (true) {
            if (DW(1) != '\r' || DW(2) != '\n') {
                if (DW(1) != ' ') {
                    if (DW(1) != '\t') {
                        if (DW(1) != '\r') {
                            if (DW(1) != '\n') {
                                break;
                            }
                            DW('\n');
                            u7();
                        } else {
                            DW('\r');
                            u7();
                        }
                    } else {
                        DW('\t');
                    }
                } else {
                    DW(' ');
                }
            } else {
                DW('\r');
                DW('\n');
                u7();
            }
            i++;
        }
        if (i >= 1) {
            Token FH;
            if (z && null == null) {
                FH = FH(28);
                FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            } else {
                FH = null;
            }
            this.J8 = FH;
            return;
        }
        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
    }

    protected final void EQ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('=');
        if (!(DW(1) == '=' || this.FH == null || this.FH.DW == null)) {
            this.FH.j6 = true;
        }
        if (z && null == null) {
            token = FH(18);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void we(boolean z) {
        Token token;
        Token token2;
        int DW;
        String stringBuffer;
        Token token3 = null;
        int DW2 = this.VH.DW();
        int DW3 = this.VH.DW();
        DW('[');
        this.VH.j6(DW3);
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                DW3 = this.VH.DW();
                tp(false);
                this.VH.j6(DW3);
                break;
            case '\"':
            case '#':
            case '(':
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
            case '[':
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
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        DW3 = this.VH.DW();
        QX(true);
        this.VH.j6(DW3);
        Token token4 = this.J8;
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                DW3 = this.VH.DW();
                tp(false);
                this.VH.j6(DW3);
                break;
            case ',':
            case ']':
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (DW(1) == ',' && yS.Hw(DW(2)) && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
            DW3 = this.VH.DW();
            DW(',');
            this.VH.j6(DW3);
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    DW3 = this.VH.DW();
                    tp(false);
                    this.VH.j6(DW3);
                    break;
                case '\"':
                case '#':
                case '(':
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
                case '[':
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
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            DW3 = this.VH.DW();
            QX(true);
            this.VH.j6(DW3);
            token = this.J8;
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    int DW4 = this.VH.DW();
                    tp(false);
                    this.VH.j6(DW4);
                    break;
                case ',':
                case ']':
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
        } else if (DW(1) == ',') {
            token = null;
        } else if (DW(1) == ']') {
            token = null;
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        switch (DW(1)) {
            case ',':
                DW4 = this.VH.DW();
                DW(',');
                this.VH.j6(DW4);
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        DW4 = this.VH.DW();
                        tp(false);
                        this.VH.j6(DW4);
                        break;
                    case '\"':
                    case '#':
                    case '(':
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
                    case '[':
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
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                DW4 = this.VH.DW();
                QX(true);
                this.VH.j6(DW4);
                token2 = this.J8;
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        DW = this.VH.DW();
                        tp(false);
                        this.VH.j6(DW);
                        break;
                    case ']':
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
            case ']':
                token2 = null;
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        DW = this.VH.DW();
        DW(']');
        this.VH.j6(DW);
        String FH = token4.FH();
        if (token != null) {
            stringBuffer = new StringBuffer().append(FH).append(",").append(token.FH()).toString();
        } else {
            stringBuffer = FH;
        }
        if (token2 != null) {
            stringBuffer = new StringBuffer().append(stringBuffer).append(",").append(token2.FH()).toString();
        }
        this.VH.j6(DW2);
        this.VH.j6(this.DW.j6(null, stringBuffer));
        if (z && null == null) {
            token3 = FH(10);
            token3.j6(new String(this.VH.j6(), DW2, this.VH.DW() - DW2));
        }
        this.J8 = token3;
    }

    protected final void J0(boolean z) {
        int DW = this.VH.DW();
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
                tp(false);
                break;
            case '\"':
            case ProxyTextView.INPUTTYPE_time /*36*/:
            case '\'':
            case '+':
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
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        int i = 0;
        while (gW.Hw(DW(1)) && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
            j3(false);
            if (Mr.Hw(DW(1)) && BT.Hw(DW(2))) {
                tp(false);
            } else if (!BT.Hw(DW(1))) {
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            i++;
        }
        if (i >= 1) {
            Token FH;
            if (z && null == null) {
                FH = FH(13);
                FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            } else {
                FH = null;
            }
            this.J8 = FH;
            return;
        }
        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
    }

    protected final void J8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case '\"':
                Zo(false);
                break;
            case '(':
                gn(false);
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
                Ws(false);
                break;
            case '[':
                we(false);
                break;
            default:
                int DW2;
                if (DW(1) != '#' || DW(2) != '(') {
                    if (DW(1) != '#' || DW(2) != '[') {
                        String stringBuffer;
                        if (DW(1) != '#' || !j3.Hw(DW(2))) {
                            if (DW(1) == '#' && DW(2) == '#') {
                                j6("##");
                                stringBuffer = new StringBuffer().append(this.j6.FH()).append("_AST").toString();
                                this.VH.j6(DW);
                                this.VH.j6(stringBuffer);
                                break;
                            }
                            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                        }
                        DW2 = this.VH.DW();
                        DW('#');
                        this.VH.j6(DW2);
                        boolean Ws = Ws(true);
                        Token token2 = this.J8;
                        if (!Ws) {
                            stringBuffer = this.DW.j6(token2.FH(), null);
                            this.VH.j6(DW);
                            this.VH.j6(stringBuffer);
                            break;
                        }
                    }
                    DW2 = this.VH.DW();
                    DW('#');
                    this.VH.j6(DW2);
                    we(false);
                    break;
                }
                DW2 = this.VH.DW();
                DW('#');
                this.VH.j6(DW2);
                gn(false);
                break;
                break;
        }
        if (z && null == null) {
            token = FH(9);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final boolean Ws(boolean z) {
        boolean z2 = false;
        int DW = this.VH.DW();
        u7(true);
        Token token = this.J8;
        if (Mr.Hw(DW(1)) && vy.Hw(DW(2))) {
            int DW2 = this.VH.DW();
            tp(false);
            this.VH.j6(DW2);
        } else if (!vy.Hw(DW(1))) {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        int DW3;
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '/':
            case '=':
            case ']':
                String j6 = this.DW.j6(token.FH(), this.FH);
                this.VH.j6(DW);
                this.VH.j6(j6);
                if (ei.Hw(DW(1)) && nw.Hw(DW(2)) && this.FH != null && this.FH.DW != null) {
                    switch (DW(1)) {
                        case '\t':
                        case '\n':
                        case '\r':
                        case ' ':
                            tp(false);
                            break;
                        case '=':
                            break;
                        default:
                            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                    EQ(false);
                    z2 = true;
                    break;
                } else if (SI.Hw(DW(1))) {
                    z2 = true;
                    break;
                } else {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
            case '(':
                DW('(');
                if (Mr.Hw(DW(1)) && P8.Hw(DW(2)) && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
                    DW3 = this.VH.DW();
                    tp(false);
                    this.VH.j6(DW3);
                } else if (!P8.Hw(DW(1)) || DW(2) < '\u0003' || DW(2) > '\u00ff') {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                    case ')':
                        break;
                    case '\"':
                    case '#':
                    case '\'':
                    case '(':
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
                    case '[':
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
                        aM(false);
                        while (DW(1) == ',') {
                            DW(',');
                            switch (DW(1)) {
                                case '\t':
                                case '\n':
                                case '\r':
                                case ' ':
                                    DW3 = this.VH.DW();
                                    tp(false);
                                    this.VH.j6(DW3);
                                    break;
                                case '\"':
                                case '#':
                                case '\'':
                                case '(':
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
                                case '[':
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
                                    break;
                                default:
                                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                            }
                            aM(false);
                        }
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        DW3 = this.VH.DW();
                        tp(false);
                        this.VH.j6(DW3);
                        break;
                    case ')':
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                DW(')');
                break;
            case '.':
                DW('.');
                Ws(false);
                break;
            case '[':
                DW3 = 0;
                while (DW(1) == '[') {
                    DW('[');
                    switch (DW(1)) {
                        case '\t':
                        case '\n':
                        case '\r':
                        case ' ':
                            DW2 = this.VH.DW();
                            tp(false);
                            this.VH.j6(DW2);
                            break;
                        case '\"':
                        case '#':
                        case '\'':
                        case '(':
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
                        case '[':
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
                            break;
                        default:
                            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                    aM(false);
                    switch (DW(1)) {
                        case '\t':
                        case '\n':
                        case '\r':
                        case ' ':
                            DW2 = this.VH.DW();
                            tp(false);
                            this.VH.j6(DW2);
                            break;
                        case ']':
                            break;
                        default:
                            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                    DW(']');
                    DW3++;
                }
                if (DW3 < 1) {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(12);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        } else {
            token = null;
        }
        this.J8 = token;
        return z2;
    }

    protected final void QX(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        if (DW(1) == '\"' && DW(2) >= '\u0003' && DW(2) <= '\u00ff' && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
            Zo(false);
        } else if (KD.Hw(DW(1)) && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
            J8(false);
        } else if (DW(1) < '0' || DW(1) > '9') {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        } else {
            XL(false);
        }
        if (z && null == null) {
            token = FH(11);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void XL(boolean z) {
        int DW = this.VH.DW();
        int i = 0;
        while (DW(1) >= '0' && DW(1) <= '9') {
            er(false);
            i++;
        }
        if (i >= 1) {
            Token FH;
            if (z && null == null) {
                FH = FH(26);
                FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            } else {
                FH = null;
            }
            this.J8 = FH;
            return;
        }
        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
    }

    protected final void aM(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case '\'':
                VH(false);
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
                U2(false);
                break;
            default:
                if (!KD.Hw(DW(1)) || DW(2) < '\u0003' || DW(2) > '\u00ff' || DW(3) < '\u0003' || DW(3) > '\u00ff') {
                    if (DW(1) == '\"' && DW(2) >= '\u0003' && DW(2) <= '\u00ff' && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
                        Zo(false);
                        break;
                    }
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                J8(false);
                break;
                break;
        }
        while (ro.Hw(DW(1)) && cn.Hw(DW(2)) && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    tp(false);
                    break;
                case '*':
                case '+':
                case '-':
                case '/':
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            switch (DW(1)) {
                case '*':
                    DW('*');
                    break;
                case '+':
                    DW('+');
                    break;
                case '-':
                    DW('-');
                    break;
                case '/':
                    DW('/');
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            switch (DW(1)) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    tp(false);
                    break;
                case '\"':
                case '#':
                case '\'':
                case '(':
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
                case '[':
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
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            aM(false);
        }
        if (z && null == null) {
            token = FH(16);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void j3(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case '\"':
                Zo(false);
                break;
            case ProxyTextView.INPUTTYPE_time /*36*/:
                Hw(false);
                break;
            case '\'':
                VH(false);
                break;
            case '+':
                DW('+');
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
                U2(false);
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
                Mr(false);
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(14);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void Mr(boolean z) {
        int DW = this.VH.DW();
        u7(true);
        Token token = this.J8;
        if (Mr.Hw(DW(1)) && sh.Hw(DW(2))) {
            int DW2 = this.VH.DW();
            tp(false);
            this.VH.j6(DW2);
        } else if (!sh.Hw(DW(1))) {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        switch (DW(1)) {
            case '\t':
            case '\n':
            case '\r':
            case ' ':
            case '\"':
            case ProxyTextView.INPUTTYPE_time /*36*/:
            case '\'':
            case ')':
            case '+':
            case ',':
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
            case ']':
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
                break;
            case '(':
                DW('(');
                if (Mr.Hw(DW(1)) && cb.Hw(DW(2)) && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
                    DW2 = this.VH.DW();
                    tp(false);
                    this.VH.j6(DW2);
                } else if (!cb.Hw(DW(1)) || DW(2) < '\u0003' || DW(2) > '\u00ff') {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                while (dx.Hw(DW(1)) && DW(2) >= '\u0003' && DW(2) <= '\u00ff' && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
                    J0(false);
                    while (DW(1) == ',') {
                        DW(',');
                        J0(false);
                    }
                }
                switch (DW(1)) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        DW2 = this.VH.DW();
                        tp(false);
                        this.VH.j6(DW2);
                        break;
                    case ')':
                        break;
                    default:
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                DW(')');
                break;
            case '.':
                DW('.');
                Mr(false);
                break;
            case '[':
                DW2 = 0;
                while (DW(1) == '[') {
                    int DW3;
                    DW('[');
                    if (Mr.Hw(DW(1)) && dx.Hw(DW(2)) && DW(3) >= '\u0003' && DW(3) <= '\u00ff') {
                        DW3 = this.VH.DW();
                        tp(false);
                        this.VH.j6(DW3);
                    } else if (!dx.Hw(DW(1)) || DW(2) < '\u0003' || DW(2) > '\u00ff' || DW(3) < '\u0003' || DW(3) > '\u00ff') {
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                    J0(false);
                    switch (DW(1)) {
                        case '\t':
                        case '\n':
                        case '\r':
                        case ' ':
                            DW3 = this.VH.DW();
                            tp(false);
                            this.VH.j6(DW3);
                            break;
                        case ']':
                            break;
                        default:
                            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                    DW(']');
                    DW2++;
                }
                if (DW2 < 1) {
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                }
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(15);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        } else {
            token = null;
        }
        this.J8 = token;
    }

    protected final void U2(boolean z) {
        int DW = this.VH.DW();
        int i = 0;
        while (DW(1) >= '0' && DW(1) <= '9' && sG.Hw(DW(2))) {
            er(false);
            i++;
        }
        if (i >= 1) {
            Token FH;
            if (DW(1) == 'L' && ef.Hw(DW(2))) {
                DW('L');
            } else if (DW(1) == 'l' && ef.Hw(DW(2))) {
                DW('l');
            } else if (DW(1) == '.') {
                DW('.');
                while (DW(1) >= '0' && DW(1) <= '9' && ef.Hw(DW(2))) {
                    er(false);
                }
            } else if (!ef.Hw(DW(1))) {
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            if (z && null == null) {
                FH = FH(27);
                FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            } else {
                FH = null;
            }
            this.J8 = FH;
            return;
        }
        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
    }

    protected final void a8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("//");
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
            token = FH(20);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void lg(boolean r11) {
        /*
        r10 = this;
        r9 = 10;
        r8 = 1;
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6 = 2;
        r5 = 3;
        r0 = 0;
        r1 = r10.VH;
        r1 = r1.DW();
        r2 = 21;
        r3 = "/*";
        r10.j6(r3);
    L_0x0016:
        r3 = r10.DW(r8);
        r4 = 42;
        if (r3 != r4) goto L_0x004c;
    L_0x001e:
        r3 = r10.DW(r6);
        r4 = 47;
        if (r3 != r4) goto L_0x004c;
    L_0x0026:
        r3 = "*/";
        r10.j6(r3);
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
        r3 = r10.DW(r8);
        r4 = 13;
        if (r3 != r4) goto L_0x0072;
    L_0x0054:
        r3 = r10.DW(r6);
        if (r3 != r9) goto L_0x0072;
    L_0x005a:
        r3 = r10.DW(r5);
        if (r3 < r5) goto L_0x0072;
    L_0x0060:
        r3 = r10.DW(r5);
        if (r3 > r7) goto L_0x0072;
    L_0x0066:
        r3 = 13;
        r10.DW(r3);
        r10.DW(r9);
        r10.u7();
        goto L_0x0016;
    L_0x0072:
        r3 = r10.DW(r8);
        r4 = 13;
        if (r3 != r4) goto L_0x009c;
    L_0x007a:
        r3 = r10.DW(r6);
        if (r3 < r5) goto L_0x009c;
    L_0x0080:
        r3 = r10.DW(r6);
        if (r3 > r7) goto L_0x009c;
    L_0x0086:
        r3 = r10.DW(r5);
        if (r3 < r5) goto L_0x009c;
    L_0x008c:
        r3 = r10.DW(r5);
        if (r3 > r7) goto L_0x009c;
    L_0x0092:
        r3 = 13;
        r10.DW(r3);
        r10.u7();
        goto L_0x0016;
    L_0x009c:
        r3 = r10.DW(r8);
        if (r3 != r9) goto L_0x00c2;
    L_0x00a2:
        r3 = r10.DW(r6);
        if (r3 < r5) goto L_0x00c2;
    L_0x00a8:
        r3 = r10.DW(r6);
        if (r3 > r7) goto L_0x00c2;
    L_0x00ae:
        r3 = r10.DW(r5);
        if (r3 < r5) goto L_0x00c2;
    L_0x00b4:
        r3 = r10.DW(r5);
        if (r3 > r7) goto L_0x00c2;
    L_0x00ba:
        r10.DW(r9);
        r10.u7();
        goto L_0x0016;
    L_0x00c2:
        r3 = r10.DW(r8);
        if (r3 < r5) goto L_0x0026;
    L_0x00c8:
        r3 = r10.DW(r8);
        if (r3 > r7) goto L_0x0026;
    L_0x00ce:
        r3 = r10.DW(r6);
        if (r3 < r5) goto L_0x0026;
    L_0x00d4:
        r3 = r10.DW(r6);
        if (r3 > r7) goto L_0x0026;
    L_0x00da:
        r3 = r10.DW(r5);
        if (r3 < r5) goto L_0x0026;
    L_0x00e0:
        r3 = r10.DW(r5);
        if (r3 > r7) goto L_0x0026;
    L_0x00e6:
        r3 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r10.FH(r3);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: groovyjarjarantlr.actions.java.ActionLexer.lg(boolean):void");
    }

    protected final void rN(boolean z) {
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
                    er(false);
                    if (DW(1) >= '0' && DW(1) <= '9' && DW(2) >= '\u0003' && DW(2) <= '\u00ff') {
                        er(false);
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
                    er(false);
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
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(24);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void er(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6('0', '9');
        if (z && null == null) {
            token = FH(25);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    private static final long[] J0() {
        long[] jArr = new long[8];
        jArr[0] = -103079215112L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    static {
        Hw = new BitSet(J0());
        v5 = new BitSet(J8());
        Zo = new BitSet(Ws());
        j3 = new BitSet(QX());
        Mr = new BitSet(XL());
        U2 = new BitSet(aM());
        a8 = new BitSet(j3());
        lg = new BitSet(Mr());
        rN = new BitSet(U2());
        er = new BitSet(a8());
        yS = new BitSet(lg());
        gW = new BitSet(rN());
        BT = new BitSet(er());
        vy = new BitSet(yS());
        P8 = new BitSet(gW());
        ei = new BitSet(BT());
        nw = new BitSet(vy());
        SI = new BitSet(P8());
        KD = new BitSet(ei());
        ro = new BitSet(nw());
        cn = new BitSet(SI());
        sh = new BitSet(KD());
        cb = new BitSet(ro());
        dx = new BitSet(cn());
        sG = new BitSet(sh());
        ef = new BitSet(cb());
    }

    private static final long[] J8() {
        long[] jArr = new long[8];
        jArr[0] = -145135534866440L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] Ws() {
        long[] jArr = new long[8];
        jArr[0] = -141407503262728L;
        for (int i = 1; i <= 3; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] QX() {
        return new long[]{0, 576460745995190270L, 0, 0, 0};
    }

    private static final long[] XL() {
        return new long[]{4294977024L, 0, 0, 0, 0};
    }

    private static final long[] aM() {
        return new long[]{1103806604800L, 0, 0, 0, 0};
    }

    private static final long[] j3() {
        return new long[]{287959436729787904L, 576460745995190270L, 0, 0, 0};
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
        return new long[]{287948901175001088L, 576460745995190270L, 0, 0, 0};
    }

    private static final long[] lg() {
        return new long[]{287950056521213440L, 576460746129407998L, 0, 0, 0};
    }

    private static final long[] rN() {
        return new long[]{287958332923183104L, 576460745995190270L, 0, 0, 0};
    }

    private static final long[] er() {
        return new long[]{287978128427460096L, 576460746532061182L, 0, 0, 0};
    }

    private static final long[] yS() {
        return new long[]{2306123388973753856L, 671088640, 0, 0, 0};
    }

    private static final long[] gW() {
        return new long[]{287952805300282880L, 576460746129407998L, 0, 0, 0};
    }

    private static final long[] BT() {
        return new long[]{2305843013508670976L, 0, 0, 0, 0};
    }

    private static final long[] vy() {
        return new long[]{2306051920717948416L, 536870912, 0, 0, 0};
    }

    private static final long[] P8() {
        return new long[]{208911504254464L, 536870912, 0, 0, 0};
    }

    private static final long[] ei() {
        return new long[]{1151051235328L, 576460746129407998L, 0, 0, 0};
    }

    private static final long[] nw() {
        return new long[]{189120294954496L, 0, 0, 0, 0};
    }

    private static final long[] SI() {
        return new long[]{288139722277004800L, 576460746129407998L, 0, 0, 0};
    }

    private static final long[] KD() {
        return new long[]{288049596683265536L, 576460746666278910L, 0, 0, 0};
    }

    private static final long[] ro() {
        return new long[]{287960536241415680L, 576460745995190270L, 0, 0, 0};
    }

    private static final long[] cn() {
        return new long[]{287958337218160128L, 576460745995190270L, 0, 0, 0};
    }

    private static final long[] sh() {
        return new long[]{288228817078593024L, 576460746532061182L, 0, 0, 0};
    }

    private static final long[] cb() {
        return new long[]{288158448334415360L, 576460746532061182L, 0, 0, 0};
    }
}
