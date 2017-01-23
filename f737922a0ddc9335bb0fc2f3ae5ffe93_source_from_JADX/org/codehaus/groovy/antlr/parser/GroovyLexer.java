package org.codehaus.groovy.antlr.parser;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.ANTLRHashString;
import groovyjarjarantlr.CharBuffer;
import groovyjarjarantlr.CharScanner;
import groovyjarjarantlr.CharStreamException;
import groovyjarjarantlr.CharStreamIOException;
import groovyjarjarantlr.InputBuffer;
import groovyjarjarantlr.LexerSharedInputState;
import groovyjarjarantlr.MismatchedCharException;
import groovyjarjarantlr.NoViableAltForCharException;
import groovyjarjarantlr.RecognitionException;
import groovyjarjarantlr.SemanticException;
import groovyjarjarantlr.Token;
import groovyjarjarantlr.TokenStream;
import groovyjarjarantlr.TokenStreamException;
import groovyjarjarantlr.TokenStreamIOException;
import groovyjarjarantlr.TokenStreamRecognitionException;
import groovyjarjarantlr.collections.impl.BitSet;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Hashtable;
import org.codehaus.groovy.antlr.GroovySourceToken;

public class GroovyLexer extends CharScanner implements TokenStream, GroovyTokenTypes {
    public static final BitSet BT;
    public static final BitSet KD;
    public static final BitSet Mr;
    public static final BitSet P8;
    public static final BitSet SI;
    public static final BitSet U2;
    public static boolean Zo;
    public static final BitSet a8;
    public static final BitSet ei;
    public static final BitSet er;
    public static final BitSet gW;
    public static final BitSet lg;
    public static final BitSet nw;
    public static final BitSet rN;
    public static final BitSet ro;
    public static final BitSet vy;
    public static final BitSet yS;
    protected int DW;
    protected int FH;
    protected ArrayList Hw;
    private boolean cb;
    private boolean cn;
    protected GroovyRecognizer j3;
    protected int j6;
    private boolean sh;
    protected int v5;

    class 1 implements TokenStream {
        final /* synthetic */ GroovyLexer j6;

        1(GroovyLexer groovyLexer) {
            this.j6 = groovyLexer;
        }

        public Token j6() {
            int i;
            if (this.j6.FH >= 8) {
                i = this.j6.FH & 3;
                this.j6.FH = 0;
                this.j6.EQ();
                switch (i) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        this.j6.j6(true, false, false);
                        break;
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        this.j6.j6(true, false, true);
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        this.j6.FH(true, false);
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        this.j6.Hw(true, false);
                        break;
                    default:
                        try {
                            throw new AssertionError(false);
                        } catch (RecognitionException e) {
                            throw new TokenStreamRecognitionException(e);
                        } catch (CharStreamException e2) {
                            if (e2 instanceof CharStreamIOException) {
                                throw new TokenStreamIOException(((CharStreamIOException) e2).j6);
                            }
                            throw new TokenStreamException(e2.getMessage());
                        }
                }
                this.j6.v5 = this.j6.J8.Hw();
                return this.j6.J8;
            }
            Token j6 = this.j6.j6();
            i = j6.Hw();
            if (this.j6.cb) {
                switch (i) {
                    case 207:
                    case 208:
                    case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
                    case 210:
                        i = this.j6.v5;
                        break;
                }
            }
            this.j6.v5 = i;
            return j6;
        }
    }

    public void Zo(String str) {
    }

    protected Token FH(int i) {
        Token groovySourceToken = new GroovySourceToken(i);
        groovySourceToken.DW(this.QX.DW());
        groovySourceToken.j6(this.QX.FH());
        groovySourceToken.v5(this.QX.Hw());
        groovySourceToken.Hw(this.QX.j6());
        return groovySourceToken;
    }

    protected void J0() {
        this.Hw.add(Integer.valueOf((this.j6 * 16) + this.FH));
        this.j6 = 0;
        this.FH = 0;
    }

    protected void J8() {
        int size = this.Hw.size();
        if (size != 0) {
            size = ((Integer) this.Hw.remove(size - 1)).intValue();
            this.j6 = size / 16;
            this.FH = size % 16;
        }
    }

    protected void j6(boolean z) {
        if (this.FH != 0) {
            this.FH = (z ? 8 : 4) + (this.FH & 3);
        }
    }

    protected boolean Ws() {
        return !VH(this.v5);
    }

    protected static boolean VH(int i) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
            case 86:
            case 87:
            case 88:
            case 92:
            case 93:
            case 94:
            case 95:
            case 98:
            case 99:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 127:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 130:
            case 131:
            case 132:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
            case 150:
            case 151:
            case 152:
            case 153:
            case 157:
            case 158:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 190:
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
            case 198:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                return true;
            default:
                return false;
        }
    }

    protected void DW(boolean z) {
        if (z && this.DW > 0) {
            j6(this.DW == 0, "end of line reached within a simple string 'x' or \"x\" or /x/", "for multi-line literals, use triple quotes '''x''' or \"\"\"x\"\"\" or /x/ or $/x/$");
            this.DW = 0;
        }
        u7();
    }

    protected boolean QX() {
        if (DW(1) != '$') {
            return false;
        }
        char DW = DW(2);
        if (DW == '*') {
            DW = DW(3);
        }
        if (DW == '{' || (DW != '$' && Character.isJavaIdentifierStart(DW))) {
            return true;
        }
        return false;
    }

    protected boolean XL() {
        return DW(1) == '$' && DW(2) == '$';
    }

    protected boolean aM() {
        return DW(1) == '$' && DW(2) == '/';
    }

    public TokenStream j3() {
        return new 1(this);
    }

    static {
        Zo = false;
        Mr = new BitSet(Mr());
        U2 = new BitSet(U2());
        a8 = new BitSet(a8());
        lg = new BitSet(lg());
        rN = new BitSet(rN());
        er = new BitSet(er());
        yS = new BitSet(yS());
        gW = new BitSet(gW());
        BT = new BitSet(BT());
        vy = new BitSet(vy());
        P8 = new BitSet(P8());
        ei = new BitSet(ei());
        nw = new BitSet(nw());
        SI = new BitSet(SI());
        KD = new BitSet(KD());
        ro = new BitSet(ro());
    }

    private void j6(boolean z, String str, String str2) {
        if (!(z || this.j3 == null)) {
            this.j3.j6(str, str2);
        }
        if (!z) {
            throw new SemanticException(str + ";\n   solution: " + str2, v5(), this.QX.j6(), this.QX.Hw());
        }
    }

    public GroovyLexer(Reader reader) {
        this(new CharBuffer(reader));
    }

    public GroovyLexer(InputBuffer inputBuffer) {
        this(new LexerSharedInputState(inputBuffer));
    }

    public GroovyLexer(LexerSharedInputState lexerSharedInputState) {
        super(lexerSharedInputState);
        this.cn = true;
        this.sh = true;
        this.cb = false;
        Hw(1);
        this.j6 = 0;
        this.DW = 0;
        this.FH = 0;
        this.Hw = new ArrayList();
        this.v5 = 1;
        this.EQ = true;
        cb(true);
        this.we = new Hashtable();
        this.we.put(new ANTLRHashString("byte", this), new Integer(106));
        this.we.put(new ANTLRHashString("public", this), new Integer(116));
        this.we.put(new ANTLRHashString("trait", this), new Integer(95));
        this.we.put(new ANTLRHashString("case", this), new Integer(150));
        this.we.put(new ANTLRHashString("short", this), new Integer(108));
        this.we.put(new ANTLRHashString("break", this), new Integer(144));
        this.we.put(new ANTLRHashString("while", this), new Integer(139));
        this.we.put(new ANTLRHashString("new", this), new Integer(159));
        this.we.put(new ANTLRHashString("instanceof", this), new Integer(158));
        this.we.put(new ANTLRHashString("implements", this), new Integer(131));
        this.we.put(new ANTLRHashString("synchronized", this), new Integer(121));
        this.we.put(new ANTLRHashString("const", this), new Integer(41));
        this.we.put(new ANTLRHashString("float", this), new Integer(110));
        this.we.put(new ANTLRHashString("package", this), new Integer(81));
        this.we.put(new ANTLRHashString("return", this), new Integer(143));
        this.we.put(new ANTLRHashString("throw", this), new Integer(146));
        this.we.put(new ANTLRHashString("null", this), new Integer(160));
        this.we.put(new ANTLRHashString("def", this), new Integer(84));
        this.we.put(new ANTLRHashString("threadsafe", this), new Integer(120));
        this.we.put(new ANTLRHashString("protected", this), new Integer(117));
        this.we.put(new ANTLRHashString("class", this), new Integer(92));
        this.we.put(new ANTLRHashString("throws", this), new Integer(130));
        this.we.put(new ANTLRHashString("do", this), new Integer(42));
        this.we.put(new ANTLRHashString("strictfp", this), new Integer(43));
        this.we.put(new ANTLRHashString("super", this), new Integer(99));
        this.we.put(new ANTLRHashString("transient", this), new Integer(118));
        this.we.put(new ANTLRHashString("native", this), new Integer(119));
        this.we.put(new ANTLRHashString("interface", this), new Integer(93));
        this.we.put(new ANTLRHashString("final", this), new Integer(38));
        this.we.put(new ANTLRHashString("if", this), new Integer(137));
        this.we.put(new ANTLRHashString("double", this), new Integer(112));
        this.we.put(new ANTLRHashString("volatile", this), new Integer(122));
        this.we.put(new ANTLRHashString("as", this), new Integer(114));
        this.we.put(new ANTLRHashString("assert", this), new Integer(147));
        this.we.put(new ANTLRHashString("catch", this), new Integer(153));
        this.we.put(new ANTLRHashString("try", this), new Integer(151));
        this.we.put(new ANTLRHashString("goto", this), new Integer(40));
        this.we.put(new ANTLRHashString("enum", this), new Integer(94));
        this.we.put(new ANTLRHashString("int", this), new Integer(109));
        this.we.put(new ANTLRHashString("for", this), new Integer(141));
        this.we.put(new ANTLRHashString("extends", this), new Integer(98));
        this.we.put(new ANTLRHashString("boolean", this), new Integer(105));
        this.we.put(new ANTLRHashString("char", this), new Integer(107));
        this.we.put(new ANTLRHashString("private", this), new Integer(115));
        this.we.put(new ANTLRHashString("default", this), new Integer(ProxyTextView.INPUTTYPE_textPassword));
        this.we.put(new ANTLRHashString("false", this), new Integer(157));
        this.we.put(new ANTLRHashString("this", this), new Integer(132));
        this.we.put(new ANTLRHashString("static", this), new Integer(83));
        this.we.put(new ANTLRHashString("abstract", this), new Integer(39));
        this.we.put(new ANTLRHashString("continue", this), new Integer(ProxyTextView.INPUTTYPE_textVisiblePassword));
        this.we.put(new ANTLRHashString("finally", this), new Integer(152));
        this.we.put(new ANTLRHashString("else", this), new Integer(138));
        this.we.put(new ANTLRHashString("import", this), new Integer(82));
        this.we.put(new ANTLRHashString("in", this), new Integer(142));
        this.we.put(new ANTLRHashString("void", this), new Integer(104));
        this.we.put(new ANTLRHashString("switch", this), new Integer(140));
        this.we.put(new ANTLRHashString("true", this), new Integer(ProxyTextView.INPUTTYPE_textWebEditText));
        this.we.put(new ANTLRHashString("long", this), new Integer(111));
    }

    public Token j6() {
        do {
            EQ();
            try {
                Token token;
                switch (DW(1)) {
                    case '\t':
                    case '\f':
                    case ' ':
                    case '\\':
                        aq(true);
                        token = this.J8;
                        break;
                    case '\n':
                    case '\r':
                        FN(true);
                        token = this.J8;
                        break;
                    case '\"':
                    case '\'':
                        Ev(true);
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
                    case ',':
                        EQ(true);
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
                        n5(true);
                        token = this.J8;
                        break;
                    case ':':
                        tp(true);
                        token = this.J8;
                        break;
                    case ';':
                        lp(true);
                        token = this.J8;
                        break;
                    case '@':
                        iW(true);
                        token = this.J8;
                        break;
                    case '[':
                        Zo(true);
                        token = this.J8;
                        break;
                    case ']':
                        VH(true);
                        token = this.J8;
                        break;
                    case '{':
                        gn(true);
                        token = this.J8;
                        break;
                    case '}':
                        u7(true);
                        token = this.J8;
                        break;
                    case '~':
                        aM(true);
                        token = this.J8;
                        break;
                    default:
                        if (DW(1) != '>' || DW(2) != '>' || DW(3) != '>' || DW(4) != '=') {
                            if (DW(1) != '<' || DW(2) != '=' || DW(3) != '>') {
                                if (DW(1) != '=' || DW(2) != '=' || DW(3) != '=') {
                                    if (DW(1) != '!' || DW(2) != '=' || DW(3) != '=') {
                                        if (DW(1) != '>' || DW(2) != '>' || DW(3) != '=') {
                                            if (DW(1) != '>' || DW(2) != '>' || DW(3) != '>') {
                                                if (DW(1) != '<' || DW(2) != '<' || DW(3) != '=') {
                                                    if (DW(1) != '.' || DW(2) != '.' || DW(3) != '<') {
                                                        if (DW(1) != '.' || DW(2) != '.' || DW(3) != '.') {
                                                            if (DW(1) != '=' || DW(2) != '=' || DW(3) != '~') {
                                                                if (DW(1) != '*' || DW(2) != '*' || DW(3) != '=') {
                                                                    if (DW(1) != '=' || DW(2) != '=') {
                                                                        if (DW(1) != '!' || DW(2) != '=') {
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
                                                                                                                                        if (DW(1) != '.' || DW(2) != '.') {
                                                                                                                                            if (DW(1) != '*' || DW(2) != '.') {
                                                                                                                                                if (DW(1) != '?' || DW(2) != '.') {
                                                                                                                                                    if (DW(1) != '?' || DW(2) != ':') {
                                                                                                                                                        if (DW(1) != '.' || DW(2) != '&') {
                                                                                                                                                            if (DW(1) != '=' || DW(2) != '~') {
                                                                                                                                                                if (DW(1) != '*' || DW(2) != '*') {
                                                                                                                                                                    if (DW(1) != '-' || DW(2) != '>') {
                                                                                                                                                                        if (DW(1) != '/' || DW(2) != '/') {
                                                                                                                                                                            if (DW(1) != '/' || DW(2) != '*') {
                                                                                                                                                                                if (DW(1) != '$' || DW(2) != '/' || !Ws()) {
                                                                                                                                                                                    if (DW(1) != '?') {
                                                                                                                                                                                        if (DW(1) != '.') {
                                                                                                                                                                                            if (DW(1) != '=') {
                                                                                                                                                                                                if (DW(1) != '!') {
                                                                                                                                                                                                    if (DW(1) != '+') {
                                                                                                                                                                                                        if (DW(1) != '-') {
                                                                                                                                                                                                            if (DW(1) != '*') {
                                                                                                                                                                                                                if (DW(1) != '%') {
                                                                                                                                                                                                                    if (DW(1) != '>') {
                                                                                                                                                                                                                        if (DW(1) != '<') {
                                                                                                                                                                                                                            if (DW(1) != '^') {
                                                                                                                                                                                                                                if (DW(1) != '|') {
                                                                                                                                                                                                                                    if (DW(1) != '&') {
                                                                                                                                                                                                                                        if (DW(1) == '#' && Zo() == 1 && Hw() == 1) {
                                                                                                                                                                                                                                            ko(true);
                                                                                                                                                                                                                                            token = this.J8;
                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                        } else if (DW(1) == '/') {
                                                                                                                                                                                                                                            mb(true);
                                                                                                                                                                                                                                            token = this.J8;
                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                        } else if (Mr.Hw(DW(1))) {
                                                                                                                                                                                                                                            w9(true);
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
                                                                                                                                                                                                                                    Qq(true);
                                                                                                                                                                                                                                    token = this.J8;
                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                I(true);
                                                                                                                                                                                                                                token = this.J8;
                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            g3(true);
                                                                                                                                                                                                                            token = this.J8;
                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        vJ(true);
                                                                                                                                                                                                                        token = this.J8;
                                                                                                                                                                                                                        break;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    dx(true);
                                                                                                                                                                                                                    token = this.J8;
                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                ei(true);
                                                                                                                                                                                                                token = this.J8;
                                                                                                                                                                                                                break;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            vy(true);
                                                                                                                                                                                                            token = this.J8;
                                                                                                                                                                                                            break;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        yS(true);
                                                                                                                                                                                                        token = this.J8;
                                                                                                                                                                                                        break;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    lg(true);
                                                                                                                                                                                                    token = this.J8;
                                                                                                                                                                                                    break;
                                                                                                                                                                                                }
                                                                                                                                                                                                XL(true);
                                                                                                                                                                                                token = this.J8;
                                                                                                                                                                                                break;
                                                                                                                                                                                            }
                                                                                                                                                                                            J0(true);
                                                                                                                                                                                            token = this.J8;
                                                                                                                                                                                            break;
                                                                                                                                                                                        }
                                                                                                                                                                                        we(true);
                                                                                                                                                                                        token = this.J8;
                                                                                                                                                                                        break;
                                                                                                                                                                                    }
                                                                                                                                                                                    FH(true);
                                                                                                                                                                                    token = this.J8;
                                                                                                                                                                                    break;
                                                                                                                                                                                }
                                                                                                                                                                                fY(true);
                                                                                                                                                                                token = this.J8;
                                                                                                                                                                                break;
                                                                                                                                                                            }
                                                                                                                                                                            oY(true);
                                                                                                                                                                            token = this.J8;
                                                                                                                                                                            break;
                                                                                                                                                                        }
                                                                                                                                                                        jO(true);
                                                                                                                                                                        token = this.J8;
                                                                                                                                                                        break;
                                                                                                                                                                    }
                                                                                                                                                                    hz(true);
                                                                                                                                                                    token = this.J8;
                                                                                                                                                                    break;
                                                                                                                                                                }
                                                                                                                                                                Xa(true);
                                                                                                                                                                token = this.J8;
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            et(true);
                                                                                                                                                            token = this.J8;
                                                                                                                                                            break;
                                                                                                                                                        }
                                                                                                                                                        wc(true);
                                                                                                                                                        token = this.J8;
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    jJ(true);
                                                                                                                                                    token = this.J8;
                                                                                                                                                    break;
                                                                                                                                                }
                                                                                                                                                XG(true);
                                                                                                                                                token = this.J8;
                                                                                                                                                break;
                                                                                                                                            }
                                                                                                                                            yO(true);
                                                                                                                                            token = this.J8;
                                                                                                                                            break;
                                                                                                                                        }
                                                                                                                                        br(true);
                                                                                                                                        token = this.J8;
                                                                                                                                        break;
                                                                                                                                    }
                                                                                                                                    aj(true);
                                                                                                                                    token = this.J8;
                                                                                                                                    break;
                                                                                                                                }
                                                                                                                                sy(true);
                                                                                                                                token = this.J8;
                                                                                                                                break;
                                                                                                                            }
                                                                                                                            x9(true);
                                                                                                                            token = this.J8;
                                                                                                                            break;
                                                                                                                        }
                                                                                                                        ca(true);
                                                                                                                        token = this.J8;
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    Mz(true);
                                                                                                                    token = this.J8;
                                                                                                                    break;
                                                                                                                }
                                                                                                                Sf(true);
                                                                                                                token = this.J8;
                                                                                                                break;
                                                                                                            }
                                                                                                            sG(true);
                                                                                                            token = this.J8;
                                                                                                            break;
                                                                                                        }
                                                                                                        sh(true);
                                                                                                        token = this.J8;
                                                                                                        break;
                                                                                                    }
                                                                                                    SI(true);
                                                                                                    token = this.J8;
                                                                                                    break;
                                                                                                }
                                                                                                nw(true);
                                                                                                token = this.J8;
                                                                                                break;
                                                                                            }
                                                                                            P8(true);
                                                                                            token = this.J8;
                                                                                            break;
                                                                                        }
                                                                                        BT(true);
                                                                                        token = this.J8;
                                                                                        break;
                                                                                    }
                                                                                    gW(true);
                                                                                    token = this.J8;
                                                                                    break;
                                                                                }
                                                                                er(true);
                                                                                token = this.J8;
                                                                                break;
                                                                            }
                                                                            rN(true);
                                                                            token = this.J8;
                                                                            break;
                                                                        }
                                                                        j3(true);
                                                                        token = this.J8;
                                                                        break;
                                                                    }
                                                                    Ws(true);
                                                                    token = this.J8;
                                                                    break;
                                                                }
                                                                Eq(true);
                                                                token = this.J8;
                                                                break;
                                                            }
                                                            CU(true);
                                                            token = this.J8;
                                                            break;
                                                        }
                                                        kQ(true);
                                                        token = this.J8;
                                                        break;
                                                    }
                                                    XX(true);
                                                    token = this.J8;
                                                    break;
                                                }
                                                ef(true);
                                                token = this.J8;
                                                break;
                                            }
                                            ro(true);
                                            token = this.J8;
                                            break;
                                        }
                                        KD(true);
                                        token = this.J8;
                                        break;
                                    }
                                    Mr(true);
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
                        cn(true);
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

    public final void FH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('?');
        if (z && null == null) {
            token = FH(97);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Hw(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('(');
        if (this.QX.VH == 0) {
            this.j6++;
        }
        if (z && null == null) {
            token = FH(91);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void v5(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(')');
        if (this.QX.VH == 0) {
            this.j6--;
        }
        if (z && null == null) {
            token = FH(123);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Zo(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('[');
        if (this.QX.VH == 0) {
            this.j6++;
        }
        if (z && null == null) {
            token = FH(85);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void VH(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(']');
        if (this.QX.VH == 0) {
            this.j6--;
        }
        if (z && null == null) {
            token = FH(86);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void gn(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('{');
        if (this.QX.VH == 0) {
            J0();
        }
        if (z && null == null) {
            token = FH(126);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void u7(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('}');
        if (this.QX.VH == 0) {
            J8();
            if (this.FH != 0) {
                j6(true);
            }
        }
        if (z && null == null) {
            token = FH(127);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void tp(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(':');
        if (z && null == null) {
            token = FH(136);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void EQ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(',');
        if (z && null == null) {
            token = FH(101);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void we(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('.');
        if (z && null == null) {
            token = FH(90);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void J0(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('=');
        if (z && null == null) {
            token = FH(124);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void J8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("<=>");
        if (z && null == null) {
            token = FH(184);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Ws(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("==");
        if (z && null == null) {
            token = FH(181);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void QX(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("===");
        if (z && null == null) {
            token = FH(182);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void XL(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('!');
        if (z && null == null) {
            token = FH(196);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void aM(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('~');
        if (z && null == null) {
            token = FH(195);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void j3(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("!=");
        if (z && null == null) {
            token = FH(180);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Mr(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("!==");
        if (z && null == null) {
            token = FH(183);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void U2(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('/');
        if (z && null == null) {
            token = FH(191);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void a8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("/=");
        if (z && null == null) {
            token = FH(165);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void lg(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('+');
        if (z && null == null) {
            token = FH(148);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void rN(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("+=");
        if (z && null == null) {
            token = FH(162);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void er(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("++");
        if (z && null == null) {
            token = FH(190);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void yS(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('-');
        if (z && null == null) {
            token = FH(149);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void gW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("-=");
        if (z && null == null) {
            token = FH(163);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void BT(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("--");
        if (z && null == null) {
            token = FH((int) ProxyTextView.INPUTTYPE_textPhonetic);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void vy(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('*');
        if (z && null == null) {
            token = FH((int) ProxyTextView.INPUTTYPE_textPostalAddress);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void P8(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("*=");
        if (z && null == null) {
            token = FH(164);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void ei(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('%');
        if (z && null == null) {
            token = FH(192);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void nw(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("%=");
        if (z && null == null) {
            token = FH(166);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void SI(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">>");
        if (z && null == null) {
            token = FH(102);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void KD(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">>=");
        if (z && null == null) {
            token = FH(167);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void ro(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">>>");
        if (z && null == null) {
            token = FH(103);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void cn(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">>>=");
        if (z && null == null) {
            token = FH(168);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void sh(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">=");
        if (z && null == null) {
            token = FH(186);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void dx(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(">");
        if (z && null == null) {
            token = FH(100);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void sG(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("<<");
        if (z && null == null) {
            token = FH(187);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void ef(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("<<=");
        if (z && null == null) {
            token = FH(169);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Sf(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("<=");
        if (z && null == null) {
            token = FH(185);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void vJ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('<');
        if (z && null == null) {
            token = FH(89);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void g3(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('^');
        if (z && null == null) {
            token = FH((int) ProxyTextView.INPUTTYPE_textFilter);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Mz(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("^=");
        if (z && null == null) {
            token = FH(171);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void I(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('|');
        if (z && null == null) {
            token = FH(134);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void ca(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("|=");
        if (z && null == null) {
            token = FH(172);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void x9(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("||");
        if (z && null == null) {
            token = FH(175);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Qq(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('&');
        if (z && null == null) {
            token = FH(125);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void sy(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("&=");
        if (z && null == null) {
            token = FH(170);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void aj(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("&&");
        if (z && null == null) {
            token = FH(176);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void lp(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW(';');
        if (z && null == null) {
            token = FH(128);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void OW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('$');
        if (z && null == null) {
            token = FH(206);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void br(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("..");
        if (z && null == null) {
            token = FH(188);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void XX(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("..<");
        if (z && null == null) {
            token = FH(189);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void kQ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("...");
        if (z && null == null) {
            token = FH(133);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void yO(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("*.");
        if (z && null == null) {
            token = FH(154);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void XG(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("?.");
        if (z && null == null) {
            token = FH(155);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void jJ(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("?:");
        if (z && null == null) {
            token = FH(174);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void wc(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(".&");
        if (z && null == null) {
            token = FH(156);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void et(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("=~");
        if (z && null == null) {
            token = FH(178);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void CU(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("==~");
        if (z && null == null) {
            token = FH(179);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Xa(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("**");
        if (z && null == null) {
            token = FH(194);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void Eq(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("**=");
        if (z && null == null) {
            token = FH(173);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void hz(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6("->");
        if (z && null == null) {
            token = FH(135);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void aq(boolean z) {
        int DW = this.VH.DW();
        int i = 0;
        while (true) {
            if (DW(1) != '\\' || (DW(2) != '\n' && DW(2) != '\r')) {
                if (DW(1) != ' ') {
                    if (DW(1) != '\t') {
                        if (DW(1) != '\f') {
                            break;
                        }
                        DW('\f');
                    } else {
                        DW('\t');
                    }
                } else {
                    DW(' ');
                }
            } else {
                DW('\\');
                j6(false, false);
            }
            i++;
        }
        if (i >= 1) {
            Token FH;
            if (this.QX.VH != 0 || this.cb) {
                i = 207;
            } else {
                i = -1;
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

    protected final void j6(boolean z, boolean z2) {
        Token token = null;
        int DW = this.VH.DW();
        int DW2;
        if (DW(1) == '\r' && DW(2) == '\n') {
            DW2 = this.VH.DW();
            j6("\r\n");
            this.VH.j6(DW2);
        } else if (DW(1) == '\r') {
            DW2 = this.VH.DW();
            DW('\r');
            this.VH.j6(DW2);
        } else if (DW(1) == '\n') {
            DW2 = this.VH.DW();
            DW('\n');
            this.VH.j6(DW2);
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (this.QX.VH == 0) {
            DW(z2);
        }
        if (z && null == null) {
            token = FH(208);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void FN(boolean z) {
        int i;
        Token token;
        int DW = this.VH.DW();
        j6(false, true);
        if ((DW(1) == '\t' || DW(1) == '\n' || DW(1) == '\f' || DW(1) == '\r' || DW(1) == ' ' || DW(1) == '/' || DW(1) == '\\') && !this.cb) {
            i = 0;
            while (true) {
                switch (DW(1)) {
                    case '\t':
                    case '\f':
                    case ' ':
                    case '\\':
                        aq(false);
                        continue;
                    case '\n':
                    case '\r':
                        j6(false, true);
                        continue;
                    default:
                        if (DW(1) != '/' || DW(2) != '/') {
                            if (DW(1) == '/' && DW(2) == '*') {
                                oY(false);
                                break;
                            } else if (i < 1) {
                                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                            }
                        }
                        jO(false);
                        continue;
                        break;
                }
                i++;
            }
        }
        if (this.QX.VH == 0) {
            if (this.cb) {
                i = 205;
            } else if (this.j6 != 0) {
                i = -1;
            } else {
                this.VH.j6(DW);
                this.VH.j6("<newline>");
            }
            if (z || null != null || i == -1) {
                token = null;
            } else {
                token = FH(i);
                token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            }
            this.J8 = token;
        }
        i = 205;
        if (z) {
        }
        token = null;
        this.J8 = token;
    }

    public final void jO(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        int i = ProxyTextView.INPUTTYPE_textWebEmailAddress;
        j6("//");
        while (U2.Hw(DW(1))) {
            j6(U2);
        }
        if (this.QX.VH == 0 && !this.cb) {
            i = -1;
        }
        if (z && null == null && i != -1) {
            token = FH(i);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void oY(boolean z) {
        int i;
        Token FH;
        int DW = this.VH.DW();
        j6("/*");
        while (true) {
            boolean z2;
            if (DW(1) != '*' || DW(2) < '\u0000' || DW(2) > '\ufffe' || DW(3) < '\u0000' || DW(3) > '\ufffe') {
                z2 = false;
            } else {
                int gn = gn();
                LexerSharedInputState lexerSharedInputState = this.QX;
                lexerSharedInputState.VH++;
                try {
                    DW('*');
                    FH('/');
                    z2 = true;
                } catch (RecognitionException e) {
                    z2 = false;
                }
                v5(gn);
                LexerSharedInputState lexerSharedInputState2 = this.QX;
                lexerSharedInputState2.VH--;
            }
            if (!z2) {
                if (DW(1) != '\n' && DW(1) != '\r') {
                    if (!a8.Hw(DW(1))) {
                        break;
                    }
                    j6(a8);
                } else {
                    j6(false, true);
                }
            } else {
                DW('*');
            }
        }
        j6("*/");
        if (this.QX.VH != 0 || this.cb) {
            i = 210;
        } else {
            i = -1;
        }
        if (z && null == null && i != -1) {
            FH = FH(i);
            FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        } else {
            FH = null;
        }
        this.J8 = FH;
    }

    public final void ko(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        int i = 80;
        if (Zo() == 1 && Hw() == 1) {
            j6("#!");
            while (U2.Hw(DW(1))) {
                j6(U2);
            }
            if (this.QX.VH == 0 && !this.cb) {
                i = -1;
            }
            if (z && null == null && i != -1) {
                token = FH(i);
                token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            }
            this.J8 = token;
            return;
        }
        throw new SemanticException("getLine() == 1 && getColumn() == 1");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ev(boolean r15) {
        /*
        r14 = this;
        r13 = 34;
        r12 = 2;
        r11 = 39;
        r2 = 0;
        r1 = 1;
        r3 = 0;
        r0 = r14.VH;
        r5 = r0.DW();
        r4 = 88;
        r0 = r14.DW(r1);
        if (r0 != r11) goto L_0x028f;
    L_0x0016:
        r0 = r14.DW(r12);
        if (r0 != r11) goto L_0x028f;
    L_0x001c:
        r0 = 3;
        r0 = r14.DW(r0);
        if (r0 != r11) goto L_0x028f;
    L_0x0023:
        r0 = 4;
        r0 = r14.DW(r0);
        if (r0 < 0) goto L_0x028f;
    L_0x002a:
        r0 = 4;
        r0 = r14.DW(r0);
        r6 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r6) goto L_0x028f;
    L_0x0034:
        r6 = r14.gn();
        r0 = r14.QX;
        r7 = r0.VH;
        r7 = r7 + 1;
        r0.VH = r7;
        r0 = "'''";
        r14.j6(r0);	 Catch:{ RecognitionException -> 0x00d8 }
        r0 = r1;
    L_0x0047:
        r14.v5(r6);
        r6 = r14.QX;
        r7 = r6.VH;
        r7 = r7 + -1;
        r6.VH = r7;
    L_0x0052:
        if (r0 == 0) goto L_0x0162;
    L_0x0054:
        r0 = r14.VH;
        r0 = r0.DW();
        r6 = "'''";
        r14.j6(r6);
        r6 = r14.VH;
        r6.j6(r0);
    L_0x0065:
        r0 = r14.DW(r1);
        switch(r0) {
            case 10: goto L_0x00eb;
            case 13: goto L_0x00eb;
            case 34: goto L_0x00e0;
            case 36: goto L_0x00e4;
            case 92: goto L_0x00dc;
            default: goto L_0x006c;
        };
    L_0x006c:
        r0 = r14.DW(r1);
        if (r0 != r11) goto L_0x028c;
    L_0x0072:
        r0 = r14.DW(r12);
        if (r0 < 0) goto L_0x028c;
    L_0x0078:
        r0 = r14.DW(r12);
        r6 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r6) goto L_0x028c;
    L_0x0081:
        r0 = 3;
        r0 = r14.DW(r0);
        if (r0 < 0) goto L_0x028c;
    L_0x0088:
        r0 = 3;
        r0 = r14.DW(r0);
        r6 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r6) goto L_0x028c;
    L_0x0092:
        r0 = 4;
        r0 = r14.DW(r0);
        if (r0 < 0) goto L_0x028c;
    L_0x0099:
        r0 = 4;
        r0 = r14.DW(r0);
        r6 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r6) goto L_0x028c;
    L_0x00a3:
        r6 = r14.gn();
        r0 = r14.QX;
        r7 = r0.VH;
        r7 = r7 + 1;
        r0.VH = r7;
        r0 = 39;
        r14.DW(r0);	 Catch:{ RecognitionException -> 0x0102 }
        r0 = lg;	 Catch:{ RecognitionException -> 0x0102 }
        r7 = 1;
        r7 = r14.DW(r7);	 Catch:{ RecognitionException -> 0x0102 }
        r0 = r0.Hw(r7);	 Catch:{ RecognitionException -> 0x0102 }
        if (r0 == 0) goto L_0x00f0;
    L_0x00c1:
        r0 = 39;
        r14.FH(r0);	 Catch:{ RecognitionException -> 0x0102 }
    L_0x00c6:
        r0 = r1;
    L_0x00c7:
        r14.v5(r6);
        r6 = r14.QX;
        r7 = r6.VH;
        r7 = r7 + -1;
        r6.VH = r7;
    L_0x00d2:
        if (r0 == 0) goto L_0x011c;
    L_0x00d4:
        r14.DW(r11);
        goto L_0x0065;
    L_0x00d8:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0047;
    L_0x00dc:
        r14.WB(r2);
        goto L_0x0065;
    L_0x00e0:
        r14.DW(r13);
        goto L_0x0065;
    L_0x00e4:
        r0 = 36;
        r14.DW(r0);
        goto L_0x0065;
    L_0x00eb:
        r14.DW(r2, r1);
        goto L_0x0065;
    L_0x00f0:
        r0 = 1;
        r0 = r14.DW(r0);	 Catch:{ RecognitionException -> 0x0102 }
        if (r0 != r11) goto L_0x0105;
    L_0x00f7:
        r0 = 39;
        r14.DW(r0);	 Catch:{ RecognitionException -> 0x0102 }
        r0 = 39;
        r14.FH(r0);	 Catch:{ RecognitionException -> 0x0102 }
        goto L_0x00c6;
    L_0x0102:
        r0 = move-exception;
        r0 = r2;
        goto L_0x00c7;
    L_0x0105:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;	 Catch:{ RecognitionException -> 0x0102 }
        r7 = 1;
        r7 = r14.DW(r7);	 Catch:{ RecognitionException -> 0x0102 }
        r8 = r14.v5();	 Catch:{ RecognitionException -> 0x0102 }
        r9 = r14.Zo();	 Catch:{ RecognitionException -> 0x0102 }
        r10 = r14.Hw();	 Catch:{ RecognitionException -> 0x0102 }
        r0.<init>(r7, r8, r9, r10);	 Catch:{ RecognitionException -> 0x0102 }
        throw r0;	 Catch:{ RecognitionException -> 0x0102 }
    L_0x011c:
        r0 = rN;
        r6 = r14.DW(r1);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x012d;
    L_0x0128:
        r14.ye(r2);
        goto L_0x0065;
    L_0x012d:
        r0 = r14.VH;
        r0 = r0.DW();
        r1 = "'''";
        r14.j6(r1);
        r1 = r14.VH;
        r1.j6(r0);
        r0 = r4;
    L_0x013f:
        if (r15 == 0) goto L_0x0286;
    L_0x0141:
        if (r3 != 0) goto L_0x0286;
    L_0x0143:
        r1 = -1;
        if (r0 == r1) goto L_0x0286;
    L_0x0146:
        r0 = r14.FH(r0);
        r1 = new java.lang.String;
        r2 = r14.VH;
        r2 = r2.j6();
        r3 = r14.VH;
        r3 = r3.DW();
        r3 = r3 - r5;
        r1.<init>(r2, r5, r3);
        r0.j6(r1);
    L_0x015f:
        r14.J8 = r0;
        return;
    L_0x0162:
        r0 = r14.DW(r1);
        if (r0 != r13) goto L_0x0289;
    L_0x0168:
        r0 = r14.DW(r12);
        if (r0 != r13) goto L_0x0289;
    L_0x016e:
        r0 = 3;
        r0 = r14.DW(r0);
        if (r0 != r13) goto L_0x0289;
    L_0x0175:
        r0 = 4;
        r0 = r14.DW(r0);
        if (r0 < 0) goto L_0x0289;
    L_0x017c:
        r0 = 4;
        r0 = r14.DW(r0);
        r6 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r6) goto L_0x0289;
    L_0x0186:
        r6 = r14.gn();
        r0 = r14.QX;
        r7 = r0.VH;
        r7 = r7 + 1;
        r0.VH = r7;
        r0 = "\"\"\"";
        r14.j6(r0);	 Catch:{ RecognitionException -> 0x01c4 }
        r0 = r1;
    L_0x0199:
        r14.v5(r6);
        r6 = r14.QX;
        r7 = r6.VH;
        r7 = r7 + -1;
        r6.VH = r7;
    L_0x01a4:
        if (r0 == 0) goto L_0x01c7;
    L_0x01a6:
        r0 = r14.VH;
        r0 = r0.DW();
        r6 = "\"\"\"";
        r14.j6(r6);
        r6 = r14.VH;
        r6.j6(r0);
        r0 = r14.j6(r2, r1, r1);
        r1 = r14.QX;
        r1 = r1.VH;
        if (r1 == 0) goto L_0x013f;
    L_0x01c1:
        r0 = r4;
        goto L_0x013f;
    L_0x01c4:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0199;
    L_0x01c7:
        r0 = r14.DW(r1);
        if (r0 != r11) goto L_0x0235;
    L_0x01cd:
        r0 = U2;
        r6 = r14.DW(r12);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x0235;
    L_0x01d9:
        r0 = r14.VH;
        r0 = r0.DW();
        r14.DW(r11);
        r6 = r14.VH;
        r6.j6(r0);
        r0 = r14.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x01f3;
    L_0x01ed:
        r0 = r14.DW;
        r0 = r0 + 1;
        r14.DW = r0;
    L_0x01f3:
        r0 = r14.DW(r1);
        switch(r0) {
            case 34: goto L_0x020e;
            case 36: goto L_0x0212;
            case 92: goto L_0x020a;
            default: goto L_0x01fa;
        };
    L_0x01fa:
        r0 = rN;
        r6 = r14.DW(r1);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x0218;
    L_0x0206:
        r14.ye(r2);
        goto L_0x01f3;
    L_0x020a:
        r14.WB(r2);
        goto L_0x01f3;
    L_0x020e:
        r14.DW(r13);
        goto L_0x01f3;
    L_0x0212:
        r0 = 36;
        r14.DW(r0);
        goto L_0x01f3;
    L_0x0218:
        r0 = r14.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x0224;
    L_0x021e:
        r0 = r14.DW;
        r0 = r0 + -1;
        r14.DW = r0;
    L_0x0224:
        r0 = r14.VH;
        r0 = r0.DW();
        r14.DW(r11);
        r1 = r14.VH;
        r1.j6(r0);
        r0 = r4;
        goto L_0x013f;
    L_0x0235:
        r0 = r14.DW(r1);
        if (r0 != r13) goto L_0x0270;
    L_0x023b:
        r0 = r14.DW(r12);
        if (r0 < 0) goto L_0x0270;
    L_0x0241:
        r0 = r14.DW(r12);
        r6 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r6) goto L_0x0270;
    L_0x024a:
        r0 = r14.VH;
        r0 = r0.DW();
        r14.DW(r13);
        r6 = r14.VH;
        r6.j6(r0);
        r0 = r14.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x0264;
    L_0x025e:
        r0 = r14.DW;
        r0 = r0 + 1;
        r14.DW = r0;
    L_0x0264:
        r0 = r14.j6(r2, r1, r2);
        r1 = r14.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x01c1;
    L_0x026e:
        goto L_0x013f;
    L_0x0270:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r14.DW(r1);
        r2 = r14.v5();
        r3 = r14.Zo();
        r4 = r14.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0286:
        r0 = r3;
        goto L_0x015f;
    L_0x0289:
        r0 = r2;
        goto L_0x01a4;
    L_0x028c:
        r0 = r2;
        goto L_0x00d2;
    L_0x028f:
        r0 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyLexer.Ev(boolean):void");
    }

    protected final void ye(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6(rN);
        if (z && null == null) {
            token = FH(211);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void WB(boolean z) {
        Token FH;
        int DW = this.VH.DW();
        int DW2;
        if (DW(1) == '\\' && (DW(2) == '\"' || DW(2) == '$' || DW(2) == '\'' || DW(2) == '0' || DW(2) == '1' || DW(2) == '2' || DW(2) == '3' || DW(2) == '4' || DW(2) == '5' || DW(2) == '6' || DW(2) == '7' || DW(2) == '\\' || DW(2) == 'b' || DW(2) == 'f' || DW(2) == 'n' || DW(2) == 'r' || DW(2) == 't' || DW(2) == 'u')) {
            DW2 = this.VH.DW();
            DW('\\');
            this.VH.j6(DW2);
            char parseInt;
            switch (DW(1)) {
                case '\"':
                    DW('\"');
                    break;
                case ProxyTextView.INPUTTYPE_time /*36*/:
                    DW('$');
                    break;
                case '\'':
                    DW('\'');
                    break;
                case '0':
                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                case '2':
                case '3':
                    j6('0', '3');
                    if (DW(1) >= '0' && DW(1) <= '7' && DW(2) >= '\u0000' && DW(2) <= '\ufffe') {
                        j6('0', '7');
                        if (DW(1) >= '0' && DW(1) <= '7' && DW(2) >= '\u0000' && DW(2) <= '\ufffe') {
                            j6('0', '7');
                        } else if (DW(1) < '\u0000' || DW(1) > '\ufffe') {
                            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                        }
                    } else if (DW(1) < '\u0000' || DW(1) > '\ufffe') {
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                    if (this.QX.VH == 0) {
                        parseInt = (char) Integer.parseInt(new String(this.VH.j6(), DW, this.VH.DW() - DW), 8);
                        this.VH.j6(DW);
                        this.VH.j6(parseInt);
                        break;
                    }
                    break;
                case '4':
                case '5':
                case '6':
                case '7':
                    j6('4', '7');
                    if (DW(1) >= '0' && DW(1) <= '7' && DW(2) >= '\u0000' && DW(2) <= '\ufffe') {
                        j6('0', '7');
                    } else if (DW(1) < '\u0000' || DW(1) > '\ufffe') {
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                    if (this.QX.VH == 0) {
                        parseInt = (char) Integer.parseInt(new String(this.VH.j6(), DW, this.VH.DW() - DW), 8);
                        this.VH.j6(DW);
                        this.VH.j6(parseInt);
                        break;
                    }
                    break;
                case '\\':
                    DW('\\');
                    break;
                case 'b':
                    DW('b');
                    if (this.QX.VH == 0) {
                        this.VH.j6(DW);
                        this.VH.j6("\b");
                        break;
                    }
                    break;
                case 'f':
                    DW('f');
                    if (this.QX.VH == 0) {
                        this.VH.j6(DW);
                        this.VH.j6("\f");
                        break;
                    }
                    break;
                case 'n':
                    DW('n');
                    if (this.QX.VH == 0) {
                        this.VH.j6(DW);
                        this.VH.j6("\n");
                        break;
                    }
                    break;
                case 'r':
                    DW('r');
                    if (this.QX.VH == 0) {
                        this.VH.j6(DW);
                        this.VH.j6("\r");
                        break;
                    }
                    break;
                case 't':
                    DW('t');
                    if (this.QX.VH == 0) {
                        this.VH.j6(DW);
                        this.VH.j6("\t");
                        break;
                    }
                    break;
                case 'u':
                    DW2 = 0;
                    while (DW(1) == 'u') {
                        DW('u');
                        DW2++;
                    }
                    if (DW2 >= 1) {
                        if (this.QX.VH == 0) {
                            this.VH.j6(DW);
                            this.VH.j6("");
                        }
                        AL(false);
                        AL(false);
                        AL(false);
                        AL(false);
                        if (this.QX.VH == 0) {
                            parseInt = (char) Integer.parseInt(new String(this.VH.j6(), DW, this.VH.DW() - DW), 16);
                            this.VH.j6(DW);
                            this.VH.j6(parseInt);
                            break;
                        }
                    }
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    break;
                default:
                    throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
        } else if (DW(1) == '\\' && (DW(2) == '\n' || DW(2) == '\r')) {
            DW2 = this.VH.DW();
            DW('\\');
            this.VH.j6(DW2);
            DW2 = this.VH.DW();
            j6(false, false);
            this.VH.j6(DW2);
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            FH = FH(220);
            FH.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        } else {
            FH = null;
        }
        this.J8 = FH;
    }

    protected final void DW(boolean z, boolean z2) {
        Token token = null;
        int DW = this.VH.DW();
        if (this.QX.VH != 0 || z2) {
            j6(false, false);
            if (this.QX.VH == 0) {
                this.VH.j6(DW);
                this.VH.j6('\n');
            }
            if (z && null == null) {
                token = FH(221);
                token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
            }
            this.J8 = token;
            return;
        }
        throw new MismatchedCharException('\n', '\n', true, (CharScanner) this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int j6(boolean r12, boolean r13, boolean r14) {
        /*
        r11 = this;
        r2 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r3 = 0;
        r0 = r11.VH;
        r5 = r0.DW();
        r4 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r1 = 0;
    L_0x000c:
        r0 = 1;
        r0 = r11.DW(r0);
        switch(r0) {
            case 10: goto L_0x0073;
            case 13: goto L_0x0073;
            case 39: goto L_0x006d;
            case 92: goto L_0x0068;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = 0;
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 34;
        if (r6 != r7) goto L_0x0060;
    L_0x001e:
        r6 = 2;
        r6 = r11.DW(r6);
        if (r6 < 0) goto L_0x0060;
    L_0x0025:
        r6 = 2;
        r6 = r11.DW(r6);
        r7 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r6 > r7) goto L_0x0060;
    L_0x002f:
        if (r14 == 0) goto L_0x0060;
    L_0x0031:
        r6 = r11.gn();
        r0 = 1;
        r7 = r11.QX;
        r8 = r7.VH;
        r8 = r8 + 1;
        r7.VH = r8;
        r7 = 34;
        r11.DW(r7);	 Catch:{ RecognitionException -> 0x008c }
        r7 = er;	 Catch:{ RecognitionException -> 0x008c }
        r8 = 1;
        r8 = r11.DW(r8);	 Catch:{ RecognitionException -> 0x008c }
        r7 = r7.Hw(r8);	 Catch:{ RecognitionException -> 0x008c }
        if (r7 == 0) goto L_0x0078;
    L_0x0050:
        r7 = 34;
        r11.FH(r7);	 Catch:{ RecognitionException -> 0x008c }
    L_0x0055:
        r11.v5(r6);
        r6 = r11.QX;
        r7 = r6.VH;
        r7 = r7 + -1;
        r6.VH = r7;
    L_0x0060:
        if (r0 == 0) goto L_0x00a6;
    L_0x0062:
        r0 = 34;
        r11.DW(r0);
        goto L_0x000c;
    L_0x0068:
        r0 = 0;
        r11.WB(r0);
        goto L_0x000c;
    L_0x006d:
        r0 = 39;
        r11.DW(r0);
        goto L_0x000c;
    L_0x0073:
        r0 = 0;
        r11.DW(r0, r14);
        goto L_0x000c;
    L_0x0078:
        r7 = 1;
        r7 = r11.DW(r7);	 Catch:{ RecognitionException -> 0x008c }
        r8 = 34;
        if (r7 != r8) goto L_0x008f;
    L_0x0081:
        r7 = 34;
        r11.DW(r7);	 Catch:{ RecognitionException -> 0x008c }
        r7 = 34;
        r11.FH(r7);	 Catch:{ RecognitionException -> 0x008c }
        goto L_0x0055;
    L_0x008c:
        r0 = move-exception;
        r0 = 0;
        goto L_0x0055;
    L_0x008f:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;	 Catch:{ RecognitionException -> 0x008c }
        r7 = 1;
        r7 = r11.DW(r7);	 Catch:{ RecognitionException -> 0x008c }
        r8 = r11.v5();	 Catch:{ RecognitionException -> 0x008c }
        r9 = r11.Zo();	 Catch:{ RecognitionException -> 0x008c }
        r10 = r11.Hw();	 Catch:{ RecognitionException -> 0x008c }
        r0.<init>(r7, r8, r9, r10);	 Catch:{ RecognitionException -> 0x008c }
        throw r0;	 Catch:{ RecognitionException -> 0x008c }
    L_0x00a6:
        r0 = rN;
        r6 = 1;
        r6 = r11.DW(r6);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x00b9;
    L_0x00b3:
        r0 = 0;
        r11.ye(r0);
        goto L_0x000c;
    L_0x00b9:
        r0 = 1;
        r0 = r11.DW(r0);
        switch(r0) {
            case 34: goto L_0x00d8;
            case 35: goto L_0x00c1;
            case 36: goto L_0x016d;
            default: goto L_0x00c1;
        };
    L_0x00c1:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x00d8:
        r0 = 1;
        r0 = r11.DW(r0);
        r1 = 34;
        if (r0 != r1) goto L_0x0139;
    L_0x00e1:
        r0 = 2;
        r0 = r11.DW(r0);
        r1 = 34;
        if (r0 != r1) goto L_0x0139;
    L_0x00ea:
        if (r14 == 0) goto L_0x0139;
    L_0x00ec:
        r0 = r11.VH;
        r0 = r0.DW();
        r1 = "\"\"\"";
        r11.j6(r1);
        r1 = r11.VH;
        r1.j6(r0);
    L_0x00fd:
        r0 = r11.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x01ae;
    L_0x0103:
        if (r13 == 0) goto L_0x01b3;
    L_0x0105:
        r0 = 88;
    L_0x0107:
        if (r14 != 0) goto L_0x010f;
    L_0x0109:
        r1 = r11.DW;
        r1 = r1 + -1;
        r11.DW = r1;
    L_0x010f:
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x01ab;
    L_0x0115:
        r1 = r0;
    L_0x0116:
        if (r12 == 0) goto L_0x01a9;
    L_0x0118:
        if (r3 != 0) goto L_0x01a9;
    L_0x011a:
        r2 = -1;
        if (r1 == r2) goto L_0x01a9;
    L_0x011d:
        r1 = r11.FH(r1);
        r2 = new java.lang.String;
        r3 = r11.VH;
        r3 = r3.j6();
        r4 = r11.VH;
        r4 = r4.DW();
        r4 = r4 - r5;
        r2.<init>(r3, r5, r4);
        r1.j6(r2);
    L_0x0136:
        r11.J8 = r1;
        return r0;
    L_0x0139:
        r0 = 1;
        r0 = r11.DW(r0);
        r1 = 34;
        if (r0 != r1) goto L_0x0156;
    L_0x0142:
        if (r14 != 0) goto L_0x0156;
    L_0x0144:
        r0 = r11.VH;
        r0 = r0.DW();
        r1 = "\"";
        r11.j6(r1);
        r1 = r11.VH;
        r1.j6(r0);
        goto L_0x00fd;
    L_0x0156:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x016d:
        r0 = r11.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x01b1;
    L_0x0173:
        r0 = r11.QX();
    L_0x0177:
        r1 = r11.VH;
        r1 = r1.DW();
        r6 = 36;
        r11.DW(r6);
        r6 = r11.VH;
        r6.j6(r1);
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x01ae;
    L_0x018d:
        r1 = "illegal string body character after dollar sign";
        r2 = "either escape a literal dollar sign \"\\$5\" or bracket the value expression \"${5}\"";
        r11.j6(r0, r1, r2);
        if (r13 == 0) goto L_0x01a4;
    L_0x0198:
        r1 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
    L_0x019a:
        if (r14 == 0) goto L_0x01a7;
    L_0x019c:
        r0 = 1;
    L_0x019d:
        r0 = r0 + 4;
        r11.FH = r0;
        r0 = r1;
        goto L_0x010f;
    L_0x01a4:
        r1 = 49;
        goto L_0x019a;
    L_0x01a7:
        r0 = 0;
        goto L_0x019d;
    L_0x01a9:
        r1 = r3;
        goto L_0x0136;
    L_0x01ab:
        r1 = r4;
        goto L_0x0116;
    L_0x01ae:
        r0 = r2;
        goto L_0x010f;
    L_0x01b1:
        r0 = r1;
        goto L_0x0177;
    L_0x01b3:
        r0 = r2;
        goto L_0x0107;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyLexer.j6(boolean, boolean, boolean):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mb(boolean r11) {
        /*
        r10 = this;
        r9 = 2;
        r8 = 47;
        r7 = 36;
        r0 = 0;
        r6 = 1;
        r1 = 0;
        r2 = r10.VH;
        r3 = r2.DW();
        r2 = 212; // 0xd4 float:2.97E-43 double:1.047E-321;
        r4 = r10.DW(r6);
        if (r4 != r8) goto L_0x00d4;
    L_0x0016:
        r4 = yS;
        r5 = r10.DW(r9);
        r4 = r4.Hw(r5);
        if (r4 == 0) goto L_0x00d4;
    L_0x0022:
        r4 = r10.Ws();
        if (r4 == 0) goto L_0x00d4;
    L_0x0028:
        r4 = r10.VH;
        r4 = r4.DW();
        r10.DW(r8);
        r5 = r10.VH;
        r5.j6(r4);
        r4 = r10.QX;
        r4 = r4.VH;
        if (r4 != 0) goto L_0x0042;
    L_0x003c:
        r4 = r10.DW;
        r4 = r4 + 1;
        r10.DW = r4;
    L_0x0042:
        r4 = r10.DW(r6);
        if (r4 != r7) goto L_0x008a;
    L_0x0048:
        r4 = gW;
        r5 = r10.DW(r9);
        r4 = r4.Hw(r5);
        if (r4 == 0) goto L_0x008a;
    L_0x0054:
        r4 = r10.QX();
        if (r4 != 0) goto L_0x008a;
    L_0x005a:
        r10.DW(r7);
        r0 = r10.FH(r0, r6);
    L_0x0061:
        r4 = r10.QX;
        r4 = r4.VH;
        if (r4 != 0) goto L_0x011b;
    L_0x0067:
        if (r11 == 0) goto L_0x0118;
    L_0x0069:
        if (r1 != 0) goto L_0x0118;
    L_0x006b:
        r2 = -1;
        if (r0 == r2) goto L_0x0118;
    L_0x006e:
        r0 = r10.FH(r0);
        r1 = new java.lang.String;
        r2 = r10.VH;
        r2 = r2.j6();
        r4 = r10.VH;
        r4 = r4.DW();
        r4 = r4 - r3;
        r1.<init>(r2, r3, r4);
        r0.j6(r1);
    L_0x0087:
        r10.J8 = r0;
        return;
    L_0x008a:
        r4 = BT;
        r5 = r10.DW(r6);
        r4 = r4.Hw(r5);
        if (r4 == 0) goto L_0x009e;
    L_0x0096:
        r10.jw(r0);
        r0 = r10.FH(r0, r6);
        goto L_0x0061;
    L_0x009e:
        r4 = r10.DW(r6);
        if (r4 != r7) goto L_0x00be;
    L_0x00a4:
        r4 = r10.VH;
        r4 = r4.DW();
        r10.DW(r7);
        r5 = r10.VH;
        r5.j6(r4);
        r4 = r10.QX;
        r4 = r4.VH;
        if (r4 != 0) goto L_0x0061;
    L_0x00b8:
        r0 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
        r4 = 6;
        r10.FH = r4;
        goto L_0x0061;
    L_0x00be:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r10.DW(r6);
        r2 = r10.v5();
        r3 = r10.Zo();
        r4 = r10.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x00d4:
        r4 = r10.DW(r6);
        if (r4 != r8) goto L_0x00ef;
    L_0x00da:
        r4 = r10.DW(r9);
        r5 = 61;
        if (r4 != r5) goto L_0x00ef;
    L_0x00e2:
        r10.a8(r0);
        r0 = r10.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x011b;
    L_0x00eb:
        r0 = 165; // 0xa5 float:2.31E-43 double:8.15E-322;
        goto L_0x0067;
    L_0x00ef:
        r4 = r10.DW(r6);
        if (r4 != r8) goto L_0x0102;
    L_0x00f5:
        r10.U2(r0);
        r0 = r10.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x011b;
    L_0x00fe:
        r0 = 191; // 0xbf float:2.68E-43 double:9.44E-322;
        goto L_0x0067;
    L_0x0102:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r10.DW(r6);
        r2 = r10.v5();
        r3 = r10.Zo();
        r4 = r10.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0118:
        r0 = r1;
        goto L_0x0087;
    L_0x011b:
        r0 = r2;
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyLexer.mb(boolean):void");
    }

    protected final void jw(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        if (DW(1) == '\\' && DW(2) == '/' && DW(3) >= '\u0000' && DW(3) <= '\ufffe') {
            DW('\\');
            DW('/');
            if (this.QX.VH == 0) {
                this.VH.j6(DW);
                this.VH.j6('/');
            }
        } else if (DW(1) == '\\' && ((DW(2) == '\n' || DW(2) == '\r') && DW(3) >= '\u0000' && DW(3) <= '\ufffe')) {
            int DW2 = this.VH.DW();
            DW('\\');
            this.VH.j6(DW2);
            DW2 = this.VH.DW();
            j6(false, false);
            this.VH.j6(DW2);
        } else if (DW(1) == '\\' && DW(2) >= '\u0000' && DW(2) <= '\ufffe' && DW(2) != '/' && DW(2) != '\n' && DW(2) != '\r') {
            DW('\\');
        } else if (vy.Hw(DW(1))) {
            j6(vy);
        } else if (DW(1) == '\n' || DW(1) == '\r') {
            DW(false, true);
        } else {
            throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        while (DW(1) == '*') {
            DW('*');
        }
        if (z && null == null) {
            token = FH(218);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final int FH(boolean z, boolean z2) {
        int i = 198;
        Token token = null;
        int DW = this.VH.DW();
        int i2 = 214;
        while (true) {
            if (DW(1) != '$' || !gW.Hw(DW(2)) || QX()) {
                if (!BT.Hw(DW(1))) {
                    break;
                }
                jw(false);
            } else {
                DW('$');
            }
        }
        int DW2;
        switch (DW(1)) {
            case ProxyTextView.INPUTTYPE_time /*36*/:
                DW2 = this.VH.DW();
                DW('$');
                this.VH.j6(DW2);
                if (this.QX.VH == 0) {
                    i = z2 ? 197 : 49;
                    this.FH = 6;
                    break;
                }
                break;
            case '/':
                DW2 = this.VH.DW();
                DW('/');
                this.VH.j6(DW2);
                if (this.QX.VH == 0) {
                    if (z2) {
                        i = 88;
                    }
                    this.DW--;
                    break;
                }
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (this.QX.VH == 0) {
            i2 = i;
        }
        if (z && null == null && i2 != -1) {
            token = FH(i2);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
        return i;
    }

    public final void fY(boolean z) {
        int i = 0;
        int DW = this.VH.DW();
        if (Ws()) {
            Token FH;
            int DW2 = this.VH.DW();
            j6("$/");
            this.VH.j6(DW2);
            if (DW(1) == '$' && DW(2) >= '\u0000' && DW(2) <= '\ufffe' && !QX()) {
                DW('$');
                i = Hw(false, true);
            } else if (P8.Hw(DW(1))) {
                qp(false);
                i = Hw(false, true);
            } else if (DW(1) == '$') {
                DW2 = this.VH.DW();
                DW('$');
                this.VH.j6(DW2);
                if (this.QX.VH == 0) {
                    i = 197;
                    this.FH = 7;
                }
            } else {
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
            }
            if (this.QX.VH != 0) {
                i = 213;
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
        throw new SemanticException("allowRegexpLiteral()");
    }

    protected final void qp(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case '\n':
            case '\r':
                DW(false, true);
                break;
            case '/':
                DW('/');
                break;
            default:
                if (DW(1) != '\\' || ((DW(2) != '\n' && DW(2) != '\r') || DW(3) < '\u0000' || DW(3) > '\ufffe')) {
                    if (DW(1) == '\\' && DW(2) >= '\u0000' && DW(2) <= '\ufffe' && DW(2) != '\n' && DW(2) != '\r') {
                        DW('\\');
                        break;
                    } else if (ei.Hw(DW(1))) {
                        j6(ei);
                        break;
                    } else {
                        throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
                    }
                }
                int DW2 = this.VH.DW();
                DW('\\');
                this.VH.j6(DW2);
                DW2 = this.VH.DW();
                j6(false, false);
                this.VH.j6(DW2);
                break;
                break;
        }
        if (z && null == null) {
            token = FH(219);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int Hw(boolean r13, boolean r14) {
        /*
        r12 = this;
        r11 = 3;
        r10 = 2;
        r2 = 0;
        r1 = 1;
        r9 = 36;
        r3 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        r4 = 0;
        r0 = r12.VH;
        r6 = r0.DW();
        r5 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
    L_0x0011:
        r0 = r12.DW(r1);
        if (r0 != r9) goto L_0x0184;
    L_0x0017:
        r0 = r12.DW(r10);
        r7 = 47;
        if (r0 != r7) goto L_0x0184;
    L_0x001f:
        r0 = r12.DW(r11);
        if (r0 < 0) goto L_0x0184;
    L_0x0025:
        r0 = r12.DW(r11);
        r7 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r7) goto L_0x0184;
    L_0x002e:
        r7 = r12.gn();
        r0 = r12.QX;
        r8 = r0.VH;
        r8 = r8 + 1;
        r0.VH = r8;
        r0 = 36;
        r12.DW(r0);	 Catch:{ RecognitionException -> 0x0056 }
        r0 = 47;
        r12.DW(r0);	 Catch:{ RecognitionException -> 0x0056 }
        r0 = r1;
    L_0x0045:
        r12.v5(r7);
        r7 = r12.QX;
        r8 = r7.VH;
        r8 = r8 + -1;
        r7.VH = r8;
    L_0x0050:
        if (r0 == 0) goto L_0x0059;
    L_0x0052:
        r12.k2(r2);
        goto L_0x0011;
    L_0x0056:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0045;
    L_0x0059:
        r0 = r12.DW(r1);
        if (r0 != r9) goto L_0x0181;
    L_0x005f:
        r0 = r12.DW(r10);
        if (r0 != r9) goto L_0x0181;
    L_0x0065:
        r0 = r12.DW(r11);
        if (r0 < 0) goto L_0x0181;
    L_0x006b:
        r0 = r12.DW(r11);
        r7 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r7) goto L_0x0181;
    L_0x0074:
        r7 = r12.gn();
        r0 = r12.QX;
        r8 = r0.VH;
        r8 = r8 + 1;
        r0.VH = r8;
        r0 = 36;
        r12.DW(r0);	 Catch:{ RecognitionException -> 0x009d }
        r0 = 36;
        r12.DW(r0);	 Catch:{ RecognitionException -> 0x009d }
        r0 = r1;
    L_0x008b:
        r12.v5(r7);
        r7 = r12.QX;
        r8 = r7.VH;
        r8 = r8 + -1;
        r7.VH = r8;
    L_0x0096:
        if (r0 == 0) goto L_0x00a0;
    L_0x0098:
        r12.zh(r2);
        goto L_0x0011;
    L_0x009d:
        r0 = move-exception;
        r0 = r2;
        goto L_0x008b;
    L_0x00a0:
        r0 = P8;
        r7 = r12.DW(r1);
        r0 = r0.Hw(r7);
        if (r0 == 0) goto L_0x00ce;
    L_0x00ac:
        r0 = r12.DW(r10);
        if (r0 < 0) goto L_0x00ce;
    L_0x00b2:
        r0 = r12.DW(r10);
        r7 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r7) goto L_0x00ce;
    L_0x00bb:
        r0 = r12.DW(r1);
        r7 = 47;
        if (r0 != r7) goto L_0x00c9;
    L_0x00c3:
        r0 = r12.DW(r10);
        if (r0 == r9) goto L_0x00ce;
    L_0x00c9:
        r12.qp(r2);
        goto L_0x0011;
    L_0x00ce:
        r0 = r12.DW(r1);
        if (r0 != r9) goto L_0x00fa;
    L_0x00d4:
        r0 = r12.DW(r10);
        if (r0 < 0) goto L_0x00fa;
    L_0x00da:
        r0 = r12.DW(r10);
        r7 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;
        if (r0 > r7) goto L_0x00fa;
    L_0x00e3:
        r0 = r12.QX();
        if (r0 != 0) goto L_0x00fa;
    L_0x00e9:
        r0 = r12.aM();
        if (r0 != 0) goto L_0x00fa;
    L_0x00ef:
        r0 = r12.XL();
        if (r0 != 0) goto L_0x00fa;
    L_0x00f5:
        r12.DW(r9);
        goto L_0x0011;
    L_0x00fa:
        r0 = r12.DW(r1);
        switch(r0) {
            case 36: goto L_0x015c;
            case 47: goto L_0x0117;
            default: goto L_0x0101;
        };
    L_0x0101:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r12.DW(r1);
        r2 = r12.v5();
        r3 = r12.Zo();
        r4 = r12.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0117:
        r0 = r12.VH;
        r0 = r0.DW();
        r1 = "/$";
        r12.j6(r1);
        r1 = r12.VH;
        r1.j6(r0);
        r0 = r12.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x017f;
    L_0x012e:
        if (r14 == 0) goto L_0x017f;
    L_0x0130:
        r0 = 88;
    L_0x0132:
        r1 = r12.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x017d;
    L_0x0138:
        r1 = r0;
    L_0x0139:
        if (r13 == 0) goto L_0x017b;
    L_0x013b:
        if (r4 != 0) goto L_0x017b;
    L_0x013d:
        r2 = -1;
        if (r1 == r2) goto L_0x017b;
    L_0x0140:
        r1 = r12.FH(r1);
        r2 = new java.lang.String;
        r3 = r12.VH;
        r3 = r3.j6();
        r4 = r12.VH;
        r4 = r4.DW();
        r4 = r4 - r6;
        r2.<init>(r3, r6, r4);
        r1.j6(r2);
    L_0x0159:
        r12.J8 = r1;
        return r0;
    L_0x015c:
        r0 = r12.VH;
        r0 = r0.DW();
        r12.DW(r9);
        r1 = r12.VH;
        r1.j6(r0);
        r0 = r12.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x017f;
    L_0x0170:
        if (r14 == 0) goto L_0x0178;
    L_0x0172:
        r0 = 197; // 0xc5 float:2.76E-43 double:9.73E-322;
    L_0x0174:
        r1 = 7;
        r12.FH = r1;
        goto L_0x0132;
    L_0x0178:
        r0 = 49;
        goto L_0x0174;
    L_0x017b:
        r1 = r4;
        goto L_0x0159;
    L_0x017d:
        r1 = r5;
        goto L_0x0139;
    L_0x017f:
        r0 = r3;
        goto L_0x0132;
    L_0x0181:
        r0 = r2;
        goto L_0x0096;
    L_0x0184:
        r0 = r2;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyLexer.Hw(boolean, boolean):int");
    }

    protected final void k2(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('$');
        DW('/');
        if (this.QX.VH == 0) {
            this.VH.j6(DW);
            this.VH.j6('/');
        }
        if (z && null == null) {
            token = FH(216);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void zh(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('$');
        DW('$');
        if (this.QX.VH == 0) {
            this.VH.j6(DW);
            this.VH.j6('$');
        }
        if (z && null == null) {
            token = FH(217);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void AL(boolean z) {
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
            token = FH(222);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w9(boolean r10) {
        /*
        r9 = this;
        r8 = 2;
        r7 = 46;
        r0 = 87;
        r5 = 0;
        r6 = 1;
        r2 = 0;
        r1 = r9.VH;
        r3 = r1.DW();
        r1 = Mr;
        r4 = r9.DW(r6);
        r1 = r1.Hw(r4);
        if (r1 == 0) goto L_0x006e;
    L_0x001a:
        r1 = r9.FH;
        if (r1 != 0) goto L_0x006e;
    L_0x001e:
        r1 = r9.DW(r6);
        r4 = 36;
        if (r1 != r4) goto L_0x0040;
    L_0x0026:
        r9.OW(r5);
    L_0x0029:
        r1 = r9.DW(r6);
        switch(r1) {
            case 36: goto L_0x006a;
            case 37: goto L_0x0030;
            case 38: goto L_0x0030;
            case 39: goto L_0x0030;
            case 40: goto L_0x0030;
            case 41: goto L_0x0030;
            case 42: goto L_0x0030;
            case 43: goto L_0x0030;
            case 44: goto L_0x0030;
            case 45: goto L_0x0030;
            case 46: goto L_0x0030;
            case 47: goto L_0x0030;
            case 48: goto L_0x0066;
            case 49: goto L_0x0066;
            case 50: goto L_0x0066;
            case 51: goto L_0x0066;
            case 52: goto L_0x0066;
            case 53: goto L_0x0066;
            case 54: goto L_0x0066;
            case 55: goto L_0x0066;
            case 56: goto L_0x0066;
            case 57: goto L_0x0066;
            default: goto L_0x0030;
        };
    L_0x0030:
        r1 = nw;
        r4 = r9.DW(r6);
        r1 = r1.Hw(r4);
        if (r1 == 0) goto L_0x00b7;
    L_0x003c:
        r9.hK(r5);
        goto L_0x0029;
    L_0x0040:
        r1 = nw;
        r4 = r9.DW(r6);
        r1 = r1.Hw(r4);
        if (r1 == 0) goto L_0x0050;
    L_0x004c:
        r9.hK(r5);
        goto L_0x0029;
    L_0x0050:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r9.DW(r6);
        r2 = r9.v5();
        r3 = r9.Zo();
        r4 = r9.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0066:
        r9.cT(r5);
        goto L_0x0029;
    L_0x006a:
        r9.OW(r5);
        goto L_0x0029;
    L_0x006e:
        r1 = nw;
        r4 = r9.DW(r6);
        r1 = r1.Hw(r4);
        if (r1 == 0) goto L_0x00a1;
    L_0x007a:
        r9.hK(r5);
    L_0x007d:
        r1 = nw;
        r4 = r9.DW(r6);
        r1 = r1.Hw(r4);
        if (r1 == 0) goto L_0x008d;
    L_0x0089:
        r9.hK(r5);
        goto L_0x007d;
    L_0x008d:
        r1 = r9.DW(r6);
        r4 = 48;
        if (r1 < r4) goto L_0x00b7;
    L_0x0095:
        r1 = r9.DW(r6);
        r4 = 57;
        if (r1 > r4) goto L_0x00b7;
    L_0x009d:
        r9.cT(r5);
        goto L_0x007d;
    L_0x00a1:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = r9.DW(r6);
        r2 = r9.v5();
        r3 = r9.Zo();
        r4 = r9.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x00b7:
        r1 = r9.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x0174;
    L_0x00bd:
        r1 = r9.FH;
        if (r1 == 0) goto L_0x00dc;
    L_0x00c1:
        r1 = r9.DW(r6);
        if (r1 != r7) goto L_0x0197;
    L_0x00c7:
        r1 = r9.DW(r8);
        r4 = 36;
        if (r1 == r4) goto L_0x0197;
    L_0x00cf:
        r1 = r9.DW(r8);
        r1 = java.lang.Character.isJavaIdentifierStart(r1);
        if (r1 == 0) goto L_0x0197;
    L_0x00d9:
        r9.j6(r5);
    L_0x00dc:
        r1 = r9.Zo(r0);
        r4 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        if (r1 == r4) goto L_0x00f0;
    L_0x00e4:
        r4 = 84;
        if (r1 == r4) goto L_0x00f0;
    L_0x00e8:
        r4 = 142; // 0x8e float:1.99E-43 double:7.0E-322;
        if (r1 == r4) goto L_0x00f0;
    L_0x00ec:
        r4 = 95;
        if (r1 != r4) goto L_0x0103;
    L_0x00f0:
        r4 = r9.DW(r6);
        if (r4 == r7) goto L_0x0102;
    L_0x00f6:
        r4 = r9.v5;
        r5 = 90;
        if (r4 == r5) goto L_0x0102;
    L_0x00fc:
        r4 = r9.v5;
        r5 = 81;
        if (r4 != r5) goto L_0x0103;
    L_0x0102:
        r1 = r0;
    L_0x0103:
        r4 = 81;
        if (r1 != r4) goto L_0x0128;
    L_0x0107:
        r4 = r9.DW(r6);
        if (r4 == r7) goto L_0x0127;
    L_0x010d:
        r4 = r9.v5;
        r5 = 90;
        if (r4 == r5) goto L_0x0127;
    L_0x0113:
        r4 = r9.v5;
        r5 = 82;
        if (r4 == r5) goto L_0x0127;
    L_0x0119:
        r4 = r9.DW(r6);
        r5 = 41;
        if (r4 != r5) goto L_0x0128;
    L_0x0121:
        r4 = r9.v5;
        r5 = 91;
        if (r4 != r5) goto L_0x0128;
    L_0x0127:
        r1 = r0;
    L_0x0128:
        r4 = 83;
        if (r1 != r4) goto L_0x019e;
    L_0x012c:
        r4 = r9.DW(r6);
        if (r4 != r7) goto L_0x019e;
    L_0x0132:
        r1 = r9.cn;
        if (r1 == 0) goto L_0x0153;
    L_0x0136:
        r1 = "assert";
        r4 = new java.lang.String;
        r5 = r9.VH;
        r5 = r5.j6();
        r6 = r9.VH;
        r6 = r6.DW();
        r6 = r6 - r3;
        r4.<init>(r5, r3, r6);
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0153;
    L_0x0151:
        r0 = 147; // 0x93 float:2.06E-43 double:7.26E-322;
    L_0x0153:
        r1 = r9.sh;
        if (r1 == 0) goto L_0x0174;
    L_0x0157:
        r1 = "enum";
        r4 = new java.lang.String;
        r5 = r9.VH;
        r5 = r5.j6();
        r6 = r9.VH;
        r6 = r6.DW();
        r6 = r6 - r3;
        r4.<init>(r5, r3, r6);
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x0174;
    L_0x0172:
        r0 = 94;
    L_0x0174:
        if (r10 == 0) goto L_0x019c;
    L_0x0176:
        if (r2 != 0) goto L_0x019c;
    L_0x0178:
        r1 = -1;
        if (r0 == r1) goto L_0x019c;
    L_0x017b:
        r0 = r9.FH(r0);
        r1 = new java.lang.String;
        r2 = r9.VH;
        r2 = r2.j6();
        r4 = r9.VH;
        r4 = r4.DW();
        r4 = r4 - r3;
        r1.<init>(r2, r3, r4);
        r0.j6(r1);
    L_0x0194:
        r9.J8 = r0;
        return;
    L_0x0197:
        r9.j6(r6);
        goto L_0x00dc;
    L_0x019c:
        r0 = r2;
        goto L_0x0194;
    L_0x019e:
        r0 = r1;
        goto L_0x0132;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyLexer.w9(boolean):void");
    }

    protected final void hK(boolean z) {
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
            case '\u00c0':
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
            case '\u00c2':
            case '\u00c3':
            case '\u00c4':
            case '\u00c5':
            case '\u00c6':
            case '\u00c7':
            case '\u00c8':
            case '\u00c9':
            case '\u00ca':
            case '\u00cb':
            case '\u00cc':
            case '\u00cd':
            case '\u00ce':
            case '\u00cf':
            case '\u00d0':
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
            case '\u00d2':
            case '\u00d3':
            case '\u00d4':
            case '\u00d5':
            case '\u00d6':
                j6('\u00c0', '\u00d6');
                break;
            case '\u00d8':
            case '\u00d9':
            case '\u00da':
            case '\u00db':
            case '\u00dc':
            case '\u00dd':
            case '\u00de':
            case '\u00df':
            case '\u00e0':
            case ProxyTextView.INPUTTYPE_textWebPassword /*225*/:
            case '\u00e2':
            case '\u00e3':
            case '\u00e4':
            case '\u00e5':
            case '\u00e6':
            case '\u00e7':
            case '\u00e8':
            case '\u00e9':
            case '\u00ea':
            case '\u00eb':
            case '\u00ec':
            case '\u00ed':
            case '\u00ee':
            case '\u00ef':
            case '\u00f0':
            case '\u00f1':
            case '\u00f2':
            case '\u00f3':
            case '\u00f4':
            case '\u00f5':
            case '\u00f6':
                j6('\u00d8', '\u00f6');
                break;
            case '\u00f8':
            case '\u00f9':
            case '\u00fa':
            case '\u00fb':
            case '\u00fc':
            case '\u00fd':
            case '\u00fe':
            case '\u00ff':
                j6('\u00f8', '\u00ff');
                break;
            default:
                if (DW(1) >= '\u0100' && DW(1) <= '\ufffe') {
                    j6('\u0100', '\ufffe');
                    break;
                }
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(224);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void cT(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        j6('0', '9');
        if (z && null == null) {
            token = FH((int) ProxyTextView.INPUTTYPE_textWebPassword);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void q7(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        cT(false);
        if (DW(1) == '0' || DW(1) == '1' || DW(1) == '2' || DW(1) == '3' || DW(1) == '4' || DW(1) == '5' || DW(1) == '6' || DW(1) == '7' || DW(1) == '8' || DW(1) == '9' || DW(1) == '_') {
            Z1(false);
        }
        if (z && null == null) {
            token = FH(226);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void Z1(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        while (true) {
            if (DW(1) < '0' || DW(1) > '9' || (DW(2) != '0' && DW(2) != '1' && DW(2) != '2' && DW(2) != '3' && DW(2) != '4' && DW(2) != '5' && DW(2) != '6' && DW(2) != '7' && DW(2) != '8' && DW(2) != '9' && DW(2) != '_')) {
                if (DW(1) != '_') {
                    break;
                }
                DW('_');
            } else {
                cT(false);
            }
        }
        cT(false);
        if (z && null == null) {
            token = FH(227);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n5(boolean r12) {
        /*
        r11 = this;
        r3 = 0;
        r0 = r11.VH;
        r5 = r0.DW();
        r4 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r0 = 0;
        r2 = 0;
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 48: goto L_0x002a;
            case 49: goto L_0x03af;
            case 50: goto L_0x03af;
            case 51: goto L_0x03af;
            case 52: goto L_0x03af;
            case 53: goto L_0x03af;
            case 54: goto L_0x03af;
            case 55: goto L_0x03af;
            case 56: goto L_0x03af;
            case 57: goto L_0x03af;
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
        r1 = 48;
        r11.DW(r1);
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x0036;
    L_0x0035:
        r0 = 1;
    L_0x0036:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 66: goto L_0x019f;
            case 88: goto L_0x0129;
            case 98: goto L_0x019f;
            case 120: goto L_0x0129;
            default: goto L_0x003e;
        };
    L_0x003e:
        r1 = 0;
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 48;
        if (r6 < r7) goto L_0x008e;
    L_0x0048:
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 57;
        if (r6 > r7) goto L_0x008e;
    L_0x0051:
        r6 = r11.gn();
        r1 = 1;
        r7 = r11.QX;
        r8 = r7.VH;
        r8 = r8 + 1;
        r7.VH = r8;
        r7 = 0;
        r11.q7(r7);	 Catch:{ RecognitionException -> 0x0081 }
        r7 = 1;
        r7 = r11.DW(r7);	 Catch:{ RecognitionException -> 0x0081 }
        switch(r7) {
            case 46: goto L_0x02a4;
            case 68: goto L_0x02b5;
            case 69: goto L_0x02af;
            case 70: goto L_0x02b5;
            case 100: goto L_0x02b5;
            case 101: goto L_0x02af;
            case 102: goto L_0x02b5;
            default: goto L_0x006a;
        };	 Catch:{ RecognitionException -> 0x0081 }
    L_0x006a:
        r1 = new groovyjarjarantlr.NoViableAltForCharException;	 Catch:{ RecognitionException -> 0x0081 }
        r7 = 1;
        r7 = r11.DW(r7);	 Catch:{ RecognitionException -> 0x0081 }
        r8 = r11.v5();	 Catch:{ RecognitionException -> 0x0081 }
        r9 = r11.Zo();	 Catch:{ RecognitionException -> 0x0081 }
        r10 = r11.Hw();	 Catch:{ RecognitionException -> 0x0081 }
        r1.<init>(r7, r8, r9, r10);	 Catch:{ RecognitionException -> 0x0081 }
        throw r1;	 Catch:{ RecognitionException -> 0x0081 }
    L_0x0081:
        r1 = move-exception;
        r1 = 0;
    L_0x0083:
        r11.v5(r6);
        r6 = r11.QX;
        r7 = r6.VH;
        r7 = r7 + -1;
        r6.VH = r7;
    L_0x008e:
        if (r1 == 0) goto L_0x02bb;
    L_0x0090:
        r1 = 0;
        r11.q7(r1);
    L_0x0094:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 71: goto L_0x04ae;
            case 73: goto L_0x047b;
            case 76: goto L_0x0426;
            case 103: goto L_0x04ae;
            case 105: goto L_0x047b;
            case 108: goto L_0x0426;
            default: goto L_0x009c;
        };
    L_0x009c:
        r1 = 0;
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 46;
        if (r6 == r7) goto L_0x00dc;
    L_0x00a6:
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 68;
        if (r6 == r7) goto L_0x00dc;
    L_0x00af:
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 69;
        if (r6 == r7) goto L_0x00dc;
    L_0x00b8:
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 70;
        if (r6 == r7) goto L_0x00dc;
    L_0x00c1:
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 100;
        if (r6 == r7) goto L_0x00dc;
    L_0x00ca:
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r6 == r7) goto L_0x00dc;
    L_0x00d3:
        r6 = 1;
        r6 = r11.DW(r6);
        r7 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r6 != r7) goto L_0x059d;
    L_0x00dc:
        if (r0 == 0) goto L_0x059d;
    L_0x00de:
        r1 = r11.gn();
        r0 = 1;
        r6 = r11.QX;
        r7 = r6.VH;
        r7 = r7 + 1;
        r6.VH = r7;
        r6 = ro;	 Catch:{ RecognitionException -> 0x04d2 }
        r7 = 1;
        r7 = r11.DW(r7);	 Catch:{ RecognitionException -> 0x04d2 }
        r6 = r6.Hw(r7);	 Catch:{ RecognitionException -> 0x04d2 }
        if (r6 == 0) goto L_0x04bb;
    L_0x00f8:
        r6 = 46;
        r11.FH(r6);	 Catch:{ RecognitionException -> 0x04d2 }
    L_0x00fd:
        r11.v5(r1);
        r1 = r11.QX;
        r6 = r1.VH;
        r6 = r6 + -1;
        r1.VH = r6;
    L_0x0108:
        if (r0 == 0) goto L_0x059a;
    L_0x010a:
        r0 = 1;
        r0 = r11.DW(r0);
        switch(r0) {
            case 46: goto L_0x04ed;
            case 68: goto L_0x0571;
            case 69: goto L_0x0549;
            case 70: goto L_0x0571;
            case 100: goto L_0x0571;
            case 101: goto L_0x0549;
            case 102: goto L_0x0571;
            default: goto L_0x0112;
        };
    L_0x0112:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0129:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 88: goto L_0x0184;
            case 120: goto L_0x0148;
            default: goto L_0x0131;
        };
    L_0x0131:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0148:
        r1 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r11.DW(r1);
    L_0x014d:
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x0154;
    L_0x0153:
        r0 = 0;
    L_0x0154:
        r1 = 0;
        r11.AL(r1);
        r1 = SI;
        r6 = 1;
        r6 = r11.DW(r6);
        r1 = r1.Hw(r6);
        if (r1 == 0) goto L_0x0094;
    L_0x0165:
        r1 = KD;
        r6 = 1;
        r6 = r11.DW(r6);
        r1 = r1.Hw(r6);
        if (r1 == 0) goto L_0x018a;
    L_0x0172:
        r1 = SI;
        r6 = 2;
        r6 = r11.DW(r6);
        r1 = r1.Hw(r6);
        if (r1 == 0) goto L_0x018a;
    L_0x017f:
        r1 = 0;
        r11.AL(r1);
        goto L_0x0165;
    L_0x0184:
        r1 = 88;
        r11.DW(r1);
        goto L_0x014d;
    L_0x018a:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x0199;
    L_0x0193:
        r1 = 95;
        r11.DW(r1);
        goto L_0x0165;
    L_0x0199:
        r1 = 0;
        r11.AL(r1);
        goto L_0x0094;
    L_0x019f:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 66: goto L_0x01e2;
            case 98: goto L_0x01be;
            default: goto L_0x01a7;
        };
    L_0x01a7:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x01be:
        r1 = 98;
        r11.DW(r1);
    L_0x01c3:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 48: goto L_0x01e8;
            case 49: goto L_0x0232;
            default: goto L_0x01cb;
        };
    L_0x01cb:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x01e2:
        r1 = 66;
        r11.DW(r1);
        goto L_0x01c3;
    L_0x01e8:
        r1 = 48;
        r11.DW(r1);
    L_0x01ed:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 == r6) goto L_0x0208;
    L_0x01f6:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 49;
        if (r1 == r6) goto L_0x0208;
    L_0x01ff:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x0295;
    L_0x0208:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 != r6) goto L_0x0238;
    L_0x0211:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 == r6) goto L_0x022c;
    L_0x021a:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 49;
        if (r1 == r6) goto L_0x022c;
    L_0x0223:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x0238;
    L_0x022c:
        r1 = 48;
        r11.DW(r1);
        goto L_0x0208;
    L_0x0232:
        r1 = 49;
        r11.DW(r1);
        goto L_0x01ed;
    L_0x0238:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 49;
        if (r1 != r6) goto L_0x0262;
    L_0x0241:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 == r6) goto L_0x025c;
    L_0x024a:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 49;
        if (r1 == r6) goto L_0x025c;
    L_0x0253:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x0262;
    L_0x025c:
        r1 = 49;
        r11.DW(r1);
        goto L_0x0208;
    L_0x0262:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x0271;
    L_0x026b:
        r1 = 95;
        r11.DW(r1);
        goto L_0x0208;
    L_0x0271:
        r1 = 1;
        r1 = r11.DW(r1);
        switch(r1) {
            case 48: goto L_0x0290;
            case 49: goto L_0x029e;
            default: goto L_0x0279;
        };
    L_0x0279:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0290:
        r1 = 48;
        r11.DW(r1);
    L_0x0295:
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x0094;
    L_0x029b:
        r0 = 0;
        goto L_0x0094;
    L_0x029e:
        r1 = 49;
        r11.DW(r1);
        goto L_0x0295;
    L_0x02a4:
        r7 = 46;
        r11.DW(r7);	 Catch:{ RecognitionException -> 0x0081 }
        r7 = 0;
        r11.q7(r7);	 Catch:{ RecognitionException -> 0x0081 }
        goto L_0x0083;
    L_0x02af:
        r7 = 0;
        r11.Q6(r7);	 Catch:{ RecognitionException -> 0x0081 }
        goto L_0x0083;
    L_0x02b5:
        r7 = 0;
        r11.kf(r7);	 Catch:{ RecognitionException -> 0x0081 }
        goto L_0x0083;
    L_0x02bb:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 < r6) goto L_0x0094;
    L_0x02c4:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 55;
        if (r1 > r6) goto L_0x0094;
    L_0x02cd:
        r1 = 48;
        r6 = 55;
        r11.j6(r1, r6);
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 == r6) goto L_0x0325;
    L_0x02dd:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 49;
        if (r1 == r6) goto L_0x0325;
    L_0x02e6:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 50;
        if (r1 == r6) goto L_0x0325;
    L_0x02ef:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 51;
        if (r1 == r6) goto L_0x0325;
    L_0x02f8:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 52;
        if (r1 == r6) goto L_0x0325;
    L_0x0301:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 53;
        if (r1 == r6) goto L_0x0325;
    L_0x030a:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 54;
        if (r1 == r6) goto L_0x0325;
    L_0x0313:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 55;
        if (r1 == r6) goto L_0x0325;
    L_0x031c:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x03a6;
    L_0x0325:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 < r6) goto L_0x0390;
    L_0x032e:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 55;
        if (r1 > r6) goto L_0x0390;
    L_0x0337:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 == r6) goto L_0x0388;
    L_0x0340:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 49;
        if (r1 == r6) goto L_0x0388;
    L_0x0349:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 50;
        if (r1 == r6) goto L_0x0388;
    L_0x0352:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 51;
        if (r1 == r6) goto L_0x0388;
    L_0x035b:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 52;
        if (r1 == r6) goto L_0x0388;
    L_0x0364:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 53;
        if (r1 == r6) goto L_0x0388;
    L_0x036d:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 54;
        if (r1 == r6) goto L_0x0388;
    L_0x0376:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 55;
        if (r1 == r6) goto L_0x0388;
    L_0x037f:
        r1 = 2;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x0390;
    L_0x0388:
        r1 = 48;
        r6 = 55;
        r11.j6(r1, r6);
        goto L_0x0325;
    L_0x0390:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x039f;
    L_0x0399:
        r1 = 95;
        r11.DW(r1);
        goto L_0x0325;
    L_0x039f:
        r1 = 48;
        r6 = 55;
        r11.j6(r1, r6);
    L_0x03a6:
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x0094;
    L_0x03ac:
        r0 = 0;
        goto L_0x0094;
    L_0x03af:
        r1 = 49;
        r6 = 57;
        r11.j6(r1, r6);
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 48;
        if (r1 == r6) goto L_0x0419;
    L_0x03bf:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 49;
        if (r1 == r6) goto L_0x0419;
    L_0x03c8:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 50;
        if (r1 == r6) goto L_0x0419;
    L_0x03d1:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 51;
        if (r1 == r6) goto L_0x0419;
    L_0x03da:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 52;
        if (r1 == r6) goto L_0x0419;
    L_0x03e3:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 53;
        if (r1 == r6) goto L_0x0419;
    L_0x03ec:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 54;
        if (r1 == r6) goto L_0x0419;
    L_0x03f5:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 55;
        if (r1 == r6) goto L_0x0419;
    L_0x03fe:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 56;
        if (r1 == r6) goto L_0x0419;
    L_0x0407:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 57;
        if (r1 == r6) goto L_0x0419;
    L_0x0410:
        r1 = 1;
        r1 = r11.DW(r1);
        r6 = 95;
        if (r1 != r6) goto L_0x041d;
    L_0x0419:
        r1 = 0;
        r11.Z1(r1);
    L_0x041d:
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x0094;
    L_0x0423:
        r0 = 1;
        goto L_0x0094;
    L_0x0426:
        r0 = 1;
        r0 = r11.DW(r0);
        switch(r0) {
            case 76: goto L_0x0475;
            case 108: goto L_0x0445;
            default: goto L_0x042e;
        };
    L_0x042e:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x0445:
        r0 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r11.DW(r0);
    L_0x044a:
        r0 = r11.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x059a;
    L_0x0450:
        r0 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
    L_0x0452:
        if (r12 == 0) goto L_0x0597;
    L_0x0454:
        if (r3 != 0) goto L_0x0597;
    L_0x0456:
        r1 = -1;
        if (r0 == r1) goto L_0x0597;
    L_0x0459:
        r0 = r11.FH(r0);
        r1 = new java.lang.String;
        r2 = r11.VH;
        r2 = r2.j6();
        r3 = r11.VH;
        r3 = r3.DW();
        r3 = r3 - r5;
        r1.<init>(r2, r5, r3);
        r0.j6(r1);
    L_0x0472:
        r11.J8 = r0;
        return;
    L_0x0475:
        r0 = 76;
        r11.DW(r0);
        goto L_0x044a;
    L_0x047b:
        r0 = 1;
        r0 = r11.DW(r0);
        switch(r0) {
            case 73: goto L_0x04a8;
            case 105: goto L_0x049a;
            default: goto L_0x0483;
        };
    L_0x0483:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;
        r1 = 1;
        r1 = r11.DW(r1);
        r2 = r11.v5();
        r3 = r11.Zo();
        r4 = r11.Hw();
        r0.<init>(r1, r2, r3, r4);
        throw r0;
    L_0x049a:
        r0 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r11.DW(r0);
    L_0x049f:
        r0 = r11.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x059a;
    L_0x04a5:
        r0 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        goto L_0x0452;
    L_0x04a8:
        r0 = 73;
        r11.DW(r0);
        goto L_0x049f;
    L_0x04ae:
        r0 = 0;
        r11.Jl(r0);
        r0 = r11.QX;
        r0 = r0.VH;
        if (r0 != 0) goto L_0x059a;
    L_0x04b8:
        r0 = 203; // 0xcb float:2.84E-43 double:1.003E-321;
        goto L_0x0452;
    L_0x04bb:
        r6 = 1;
        r6 = r11.DW(r6);	 Catch:{ RecognitionException -> 0x04d2 }
        r7 = 46;
        if (r6 != r7) goto L_0x04d6;
    L_0x04c4:
        r6 = 46;
        r11.DW(r6);	 Catch:{ RecognitionException -> 0x04d2 }
        r6 = 48;
        r7 = 57;
        r11.j6(r6, r7);	 Catch:{ RecognitionException -> 0x04d2 }
        goto L_0x00fd;
    L_0x04d2:
        r0 = move-exception;
        r0 = 0;
        goto L_0x00fd;
    L_0x04d6:
        r0 = new groovyjarjarantlr.NoViableAltForCharException;	 Catch:{ RecognitionException -> 0x04d2 }
        r6 = 1;
        r6 = r11.DW(r6);	 Catch:{ RecognitionException -> 0x04d2 }
        r7 = r11.v5();	 Catch:{ RecognitionException -> 0x04d2 }
        r8 = r11.Zo();	 Catch:{ RecognitionException -> 0x04d2 }
        r9 = r11.Hw();	 Catch:{ RecognitionException -> 0x04d2 }
        r0.<init>(r6, r7, r8, r9);	 Catch:{ RecognitionException -> 0x04d2 }
        throw r0;	 Catch:{ RecognitionException -> 0x04d2 }
    L_0x04ed:
        r0 = 46;
        r11.DW(r0);
        r0 = 0;
        r11.q7(r0);
        r0 = 1;
        r0 = r11.DW(r0);
        r1 = 69;
        if (r0 == r1) goto L_0x0508;
    L_0x04ff:
        r0 = 1;
        r0 = r11.DW(r0);
        r1 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r0 != r1) goto L_0x050e;
    L_0x0508:
        r0 = 1;
        r11.Q6(r0);
        r0 = r11.J8;
    L_0x050e:
        r0 = 1;
        r0 = r11.DW(r0);
        switch(r0) {
            case 68: goto L_0x052e;
            case 70: goto L_0x052e;
            case 71: goto L_0x053c;
            case 100: goto L_0x052e;
            case 102: goto L_0x052e;
            case 103: goto L_0x053c;
            default: goto L_0x0516;
        };
    L_0x0516:
        r0 = r2;
    L_0x0517:
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x059a;
    L_0x051d:
        if (r0 != 0) goto L_0x057e;
    L_0x051f:
        r0 = "";
    L_0x0522:
        r1 = 70;
        r1 = r0.indexOf(r1);
        if (r1 < 0) goto L_0x0587;
    L_0x052a:
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        goto L_0x0452;
    L_0x052e:
        r0 = 1;
        r11.kf(r0);
        r0 = r11.J8;
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 == 0) goto L_0x0517;
    L_0x053a:
        r0 = r2;
        goto L_0x0517;
    L_0x053c:
        r0 = 1;
        r11.Jl(r0);
        r0 = r11.J8;
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x053a;
    L_0x0548:
        goto L_0x0517;
    L_0x0549:
        r0 = 0;
        r11.Q6(r0);
        r0 = 1;
        r0 = r11.DW(r0);
        switch(r0) {
            case 68: goto L_0x0557;
            case 70: goto L_0x0557;
            case 71: goto L_0x0564;
            case 100: goto L_0x0557;
            case 102: goto L_0x0557;
            case 103: goto L_0x0564;
            default: goto L_0x0555;
        };
    L_0x0555:
        r0 = r2;
        goto L_0x0517;
    L_0x0557:
        r0 = 1;
        r11.kf(r0);
        r0 = r11.J8;
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x053a;
    L_0x0563:
        goto L_0x0517;
    L_0x0564:
        r0 = 1;
        r11.Jl(r0);
        r0 = r11.J8;
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x053a;
    L_0x0570:
        goto L_0x0517;
    L_0x0571:
        r0 = 1;
        r11.kf(r0);
        r0 = r11.J8;
        r1 = r11.QX;
        r1 = r1.VH;
        if (r1 != 0) goto L_0x053a;
    L_0x057d:
        goto L_0x0517;
    L_0x057e:
        r0 = r0.FH();
        r0 = r0.toUpperCase();
        goto L_0x0522;
    L_0x0587:
        r1 = 71;
        r0 = r0.indexOf(r1);
        if (r0 < 0) goto L_0x0593;
    L_0x058f:
        r0 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        goto L_0x0452;
    L_0x0593:
        r0 = 202; // 0xca float:2.83E-43 double:1.0E-321;
        goto L_0x0452;
    L_0x0597:
        r0 = r3;
        goto L_0x0472;
    L_0x059a:
        r0 = r4;
        goto L_0x0452;
    L_0x059d:
        r0 = r1;
        goto L_0x0108;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyLexer.n5(boolean):void");
    }

    protected final void Q6(boolean z) {
        Token token = null;
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
            case '_':
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        while (true) {
            if (DW(1) >= '0' && DW(1) <= '9' && (DW(2) == '0' || DW(2) == '1' || DW(2) == '2' || DW(2) == '3' || DW(2) == '4' || DW(2) == '5' || DW(2) == '6' || DW(2) == '7' || DW(2) == '8' || DW(2) == '9' || DW(2) == '_')) {
                j6('0', '9');
            } else if (DW(1) == '_') {
                DW('_');
            } else {
                j6('0', '9');
                if (z && null == null) {
                    token = FH(228);
                    token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
                }
                this.J8 = token;
                return;
            }
        }
    }

    protected final void kf(boolean z) {
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
            token = FH(229);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    protected final void Jl(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        switch (DW(1)) {
            case 'G':
                DW('G');
                break;
            case 'g':
                DW('g');
                break;
            default:
                throw new NoViableAltForCharException(DW(1), v5(), Zo(), Hw());
        }
        if (z && null == null) {
            token = FH(230);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    public final void iW(boolean z) {
        Token token = null;
        int DW = this.VH.DW();
        DW('@');
        if (z && null == null) {
            token = FH(96);
            token.j6(new String(this.VH.j6(), DW, this.VH.DW() - DW));
        }
        this.J8 = token;
    }

    private static final long[] Mr() {
        long[] jArr = new long[2560];
        jArr[0] = 68719476736L;
        jArr[1] = 576460745995190270L;
        jArr[3] = -36028797027352577L;
        for (int i = 4; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] U2() {
        long[] jArr = new long[2048];
        jArr[0] = -9217;
        for (int i = 1; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] a8() {
        long[] jArr = new long[2048];
        jArr[0] = -4398046520321L;
        for (int i = 1; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] lg() {
        long[] jArr = new long[2048];
        jArr[0] = -549755813889L;
        for (int i = 1; i <= 1023; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] rN() {
        long[] jArr = new long[2048];
        jArr[0] = -635655169025L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] er() {
        long[] jArr = new long[2048];
        jArr[0] = -17179869185L;
        for (int i = 1; i <= 1023; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }

    private static final long[] yS() {
        long[] jArr = new long[2048];
        jArr[0] = -145135534866433L;
        for (int i = 1; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] gW() {
        long[] jArr = new long[2048];
        jArr[0] = -4398046511105L;
        for (int i = 1; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] BT() {
        long[] jArr = new long[2048];
        jArr[0] = -145204254343169L;
        for (int i = 1; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] vy() {
        long[] jArr = new long[2048];
        jArr[0] = -145204254352385L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] P8() {
        long[] jArr = new long[2048];
        jArr[0] = -68719476737L;
        for (int i = 1; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] ei() {
        long[] jArr = new long[2048];
        jArr[0] = -140806207841281L;
        jArr[1] = -268435457;
        for (int i = 2; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] nw() {
        long[] jArr = new long[2560];
        jArr[1] = 576460745995190270L;
        jArr[3] = -36028797027352577L;
        for (int i = 4; i <= 1022; i++) {
            jArr[i] = -1;
        }
        jArr[1023] = Long.MAX_VALUE;
        return jArr;
    }

    private static final long[] SI() {
        long[] jArr = new long[1025];
        jArr[0] = 287948901175001088L;
        jArr[1] = 543313363070L;
        return jArr;
    }

    private static final long[] KD() {
        long[] jArr = new long[1025];
        jArr[0] = 287948901175001088L;
        jArr[1] = 541165879422L;
        return jArr;
    }

    private static final long[] ro() {
        long[] jArr = new long[2048];
        jArr[0] = -70368744177665L;
        for (int i = 1; i <= 1023; i++) {
            jArr[i] = -1;
        }
        return jArr;
    }
}
