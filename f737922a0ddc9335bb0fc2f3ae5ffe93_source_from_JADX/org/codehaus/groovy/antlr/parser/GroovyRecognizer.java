package org.codehaus.groovy.antlr.parser;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.ASTFactory;
import groovyjarjarantlr.ASTPair;
import groovyjarjarantlr.CommonToken;
import groovyjarjarantlr.LLkParser;
import groovyjarjarantlr.NoViableAltException;
import groovyjarjarantlr.ParserSharedInputState;
import groovyjarjarantlr.RecognitionException;
import groovyjarjarantlr.SemanticException;
import groovyjarjarantlr.Token;
import groovyjarjarantlr.TokenStream;
import groovyjarjarantlr.TokenStreamException;
import groovyjarjarantlr.TokenStreamRecognitionException;
import groovyjarjarantlr.collections.AST;
import groovyjarjarantlr.collections.impl.ASTArray;
import groovyjarjarantlr.collections.impl.BitSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.groovy.antlr.GroovySourceAST;
import org.codehaus.groovy.antlr.SourceBuffer;
import org.codehaus.groovy.antlr.SourceInfo;

public class GroovyRecognizer extends LLkParser implements GroovyTokenTypes {
    public static final BitSet AE;
    public static final BitSet AL;
    private static GroovySourceAST AR;
    public static final BitSet An;
    public static final BitSet BR;
    public static final BitSet BT;
    public static final BitSet Bx;
    public static final BitSet CU;
    public static final BitSet Cz;
    public static final BitSet EQ;
    public static final BitSet Eq;
    public static final BitSet Ev;
    public static boolean FH;
    public static final BitSet FN;
    public static final BitSet Gj;
    public static final String[] Hw;
    public static final BitSet I;
    public static final BitSet IS;
    public static final BitSet J0;
    public static final BitSet Jl;
    public static final BitSet Jm;
    public static final BitSet KD;
    public static final BitSet MP;
    public static final BitSet Mz;
    public static final BitSet Nh;
    public static final BitSet OW;
    public static final BitSet Of;
    public static final BitSet P8;
    public static final BitSet PT;
    public static final BitSet Pa;
    public static final BitSet Q6;
    public static final BitSet QO;
    public static final BitSet Qq;
    public static final BitSet SI;
    public static final BitSet Sf;
    public static final BitSet U2;
    public static final BitSet VH;
    public static final BitSet WB;
    public static final BitSet XG;
    public static final BitSet XX;
    public static final BitSet Xa;
    public static final BitSet Z1;
    public static final BitSet Za;
    public static final BitSet Zo;
    public static final BitSet a5;
    public static final BitSet a8;
    public static final BitSet aX;
    public static final BitSet aj;
    public static final BitSet aq;
    public static final BitSet b1;
    public static final BitSet br;
    public static final BitSet cT;
    public static final BitSet ca;
    public static final BitSet cb;
    public static final BitSet ce;
    public static final BitSet cn;
    public static final BitSet dx;
    public static final BitSet e3;
    public static final BitSet e9;
    public static final BitSet eU;
    public static final BitSet ef;
    public static final BitSet ei;
    public static final BitSet er;
    public static final BitSet et;
    public static final BitSet fN;
    public static final BitSet fY;
    public static final BitSet g3;
    public static final BitSet gG;
    public static final BitSet gW;
    public static final BitSet gn;
    public static final BitSet hK;
    public static final BitSet hz;
    public static final BitSet iW;
    public static final BitSet jJ;
    public static final BitSet jO;
    public static final BitSet jw;
    public static final BitSet k2;
    public static final BitSet kQ;
    public static final BitSet kf;
    public static final BitSet ko;
    public static final BitSet lg;
    public static final BitSet lp;
    public static final BitSet mb;
    public static final BitSet n5;
    public static final BitSet nw;
    public static final BitSet oY;
    public static final BitSet oa;
    public static final BitSet oy;
    public static final BitSet pN;
    public static final BitSet pO;
    public static final BitSet q7;
    public static final BitSet qP;
    public static final BitSet qp;
    public static final BitSet rN;
    public static final BitSet ro;
    public static final BitSet sE;
    public static final BitSet sG;
    public static final BitSet sM;
    public static final BitSet sg;
    public static final BitSet sh;
    public static final BitSet sy;
    public static final BitSet tp;
    public static final BitSet u7;
    public static final BitSet v5;
    public static final BitSet vJ;
    public static final BitSet vy;
    public static final BitSet w9;
    public static final BitSet wc;
    public static final BitSet we;
    public static final BitSet x9;
    public static final BitSet yO;
    public static final BitSet yS;
    public static final BitSet ye;
    public static final BitSet ys;
    public static final BitSet zh;
    GroovyLexer DW;
    private final int E4;
    private int Fd;
    private boolean Lz;
    private SourceBuffer TI;
    private AST ct;
    private int hp;
    List j6;
    private AST sT;
    private final int xg;

    public static GroovyRecognizer j6(GroovyLexer groovyLexer) {
        GroovyRecognizer groovyRecognizer = new GroovyRecognizer(groovyLexer.j3());
        groovyRecognizer.DW = groovyLexer;
        groovyLexer.j3 = groovyRecognizer;
        groovyRecognizer.Hw().DW(GroovySourceAST.class);
        groovyRecognizer.j6 = new ArrayList();
        return groovyRecognizer;
    }

    static {
        AR = new GroovySourceAST();
        FH = false;
        Hw = new String[]{"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "BLOCK", "MODIFIERS", "OBJBLOCK", "SLIST", "METHOD_DEF", "VARIABLE_DEF", "INSTANCE_INIT", "STATIC_INIT", "TYPE", "CLASS_DEF", "INTERFACE_DEF", "TRAIT_DEF", "PACKAGE_DEF", "ARRAY_DECLARATOR", "EXTENDS_CLAUSE", "IMPLEMENTS_CLAUSE", "PARAMETERS", "PARAMETER_DEF", "LABELED_STAT", "TYPECAST", "INDEX_OP", "POST_INC", "POST_DEC", "METHOD_CALL", "EXPR", "IMPORT", "UNARY_MINUS", "UNARY_PLUS", "CASE_GROUP", "ELIST", "FOR_INIT", "FOR_CONDITION", "FOR_ITERATOR", "EMPTY_STAT", "\"final\"", "\"abstract\"", "\"goto\"", "\"const\"", "\"do\"", "\"strictfp\"", "SUPER_CTOR_CALL", "CTOR_CALL", "CTOR_IDENT", "VARIABLE_PARAMETER_DEF", "STRING_CONSTRUCTOR", "STRING_CTOR_MIDDLE", "CLOSABLE_BLOCK", "IMPLICIT_PARAMETERS", "SELECT_SLOT", "DYNAMIC_MEMBER", "LABELED_ARG", "SPREAD_ARG", "SPREAD_MAP_ARG", "LIST_CONSTRUCTOR", "MAP_CONSTRUCTOR", "FOR_IN_ITERABLE", "STATIC_IMPORT", "ENUM_DEF", "ENUM_CONSTANT_DEF", "FOR_EACH_CLAUSE", "ANNOTATION_DEF", "ANNOTATIONS", "ANNOTATION", "ANNOTATION_MEMBER_VALUE_PAIR", "ANNOTATION_FIELD_DEF", "ANNOTATION_ARRAY_INIT", "TYPE_ARGUMENTS", "TYPE_ARGUMENT", "TYPE_PARAMETERS", "TYPE_PARAMETER", "WILDCARD_TYPE", "TYPE_UPPER_BOUNDS", "TYPE_LOWER_BOUNDS", "CLOSURE_LIST", "MULTICATCH", "MULTICATCH_TYPES", "a script header", "\"package\"", "\"import\"", "\"static\"", "\"def\"", "'['", "']'", "an identifier", "a string literal", "'<'", "'.'", "'('", "\"class\"", "\"interface\"", "\"enum\"", "\"trait\"", "'@'", "'?'", "\"extends\"", "\"super\"", "'>'", "','", "'>>'", "'>>>'", "\"void\"", "\"boolean\"", "\"byte\"", "\"char\"", "\"short\"", "\"int\"", "\"float\"", "\"long\"", "\"double\"", "'*'", "\"as\"", "\"private\"", "\"public\"", "\"protected\"", "\"transient\"", "\"native\"", "\"threadsafe\"", "\"synchronized\"", "\"volatile\"", "')'", "'='", "'&'", "'{'", "'}'", "';'", "\"default\"", "\"throws\"", "\"implements\"", "\"this\"", "'...'", "'|'", "'->'", "':'", "\"if\"", "\"else\"", "\"while\"", "\"switch\"", "\"for\"", "\"in\"", "\"return\"", "\"break\"", "\"continue\"", "\"throw\"", "\"assert\"", "'+'", "'-'", "\"case\"", "\"try\"", "\"finally\"", "\"catch\"", "'*.'", "'?.'", "'.&'", "\"false\"", "\"instanceof\"", "\"new\"", "\"null\"", "\"true\"", "'+='", "'-='", "'*='", "'/='", "'%='", "'>>='", "'>>>='", "'<<='", "'&='", "'^='", "'|='", "'**='", "'?:'", "'||'", "'&&'", "'^'", "'=~'", "'==~'", "'!='", "'=='", "'==='", "'!=='", "'<=>'", "'<='", "'>='", "'<<'", "'..'", "'..<'", "'++'", "'/'", "'%'", "'--'", "'**'", "'~'", "'!'", "STRING_CTOR_START", "a string literal end", "a numeric literal", "NUM_FLOAT", "NUM_LONG", "NUM_DOUBLE", "NUM_BIG_INT", "NUM_BIG_DECIMAL", "some newlines, whitespace or comments", "'$'", "whitespace", "a newline", "a single line comment", "a comment", "a string character", "a multiline regular expression literal", "a multiline dollar escaping regular expression literal", "a multiline regular expression literal end", "a multiline dollar escaping regular expression literal end", "ESCAPED_SLASH", "ESCAPED_DOLLAR", "a multiline regular expression character", "a multiline dollar escaping regular expression character", "an escape sequence", "a newline inside a string", "a hexadecimal digit", "a character", "a letter", "a digit", "a sequence of digits and underscores, bordered by digits", "a sequence of digits and underscores with maybe underscore starting", "an exponent", "a float or double suffix", "a big decimal suffix"};
        v5 = new BitSet(qP());
        Zo = new BitSet(MP());
        VH = new BitSet(Of());
        gn = new BitSet(PT());
        u7 = new BitSet(b1());
        tp = new BitSet(AR());
        EQ = new BitSet(TI());
        we = new BitSet(ct());
        J0 = new BitSet(Fd());
        U2 = new BitSet(Lz());
        a8 = new BitSet(sT());
        lg = new BitSet(E4());
        rN = new BitSet(xg());
        er = new BitSet(hp());
        yS = new BitSet(PH());
        gW = new BitSet(GK());
        BT = new BitSet(dW());
        vy = new BitSet(Yi());
        P8 = new BitSet(GT());
        ei = new BitSet(Hl());
        nw = new BitSet(pl());
        SI = new BitSet(oh());
        KD = new BitSet(Ej());
        ro = new BitSet(T6());
        cn = new BitSet(cc());
        sh = new BitSet(Od());
        cb = new BitSet(om());
        dx = new BitSet(wE());
        sG = new BitSet(d8());
        ef = new BitSet(N0());
        Sf = new BitSet(eN());
        vJ = new BitSet(zf());
        g3 = new BitSet(fP());
        Mz = new BitSet(b());
        I = new BitSet(ba());
        ca = new BitSet(u9());
        x9 = new BitSet(Ak());
        Qq = new BitSet(nl());
        sy = new BitSet(ti());
        aj = new BitSet(k1());
        lp = new BitSet(iK());
        OW = new BitSet(fh());
        br = new BitSet(sv());
        XX = new BitSet(HT());
        kQ = new BitSet(oT());
        yO = new BitSet(hx());
        XG = new BitSet(qU());
        jJ = new BitSet(uC());
        wc = new BitSet(ep());
        et = new BitSet(HO());
        CU = new BitSet(qI());
        Xa = new BitSet(DY());
        Eq = new BitSet(tj());
        hz = new BitSet(pn());
        aq = new BitSet(x6());
        FN = new BitSet(k4());
        jO = new BitSet(RW());
        oY = new BitSet(Vq());
        ko = new BitSet(cX());
        Ev = new BitSet(ya());
        ye = new BitSet(ir());
        WB = new BitSet(uD());
        mb = new BitSet(HE());
        jw = new BitSet(h2());
        fY = new BitSet(gy());
        qp = new BitSet(F3());
        k2 = new BitSet(S4());
        zh = new BitSet(tv());
        AL = new BitSet(gM());
        w9 = new BitSet(tR());
        hK = new BitSet(ji());
        cT = new BitSet(ME());
        q7 = new BitSet(C());
        Z1 = new BitSet(dH());
        n5 = new BitSet(BN());
        Q6 = new BitSet(jn());
        kf = new BitSet(DP());
        Jl = new BitSet(ee());
        iW = new BitSet(K3());
        eU = new BitSet(OM());
        e3 = new BitSet(Qs());
        sE = new BitSet(g0());
        sg = new BitSet(fd());
        pO = new BitSet(Lx());
        fN = new BitSet(wC());
        Gj = new BitSet(hG());
        Cz = new BitSet(s0());
        pN = new BitSet(zg());
        oy = new BitSet(J1());
        aX = new BitSet(N2());
        e9 = new BitSet(NZ());
        QO = new BitSet(IM());
        sM = new BitSet(jg());
        a5 = new BitSet(eQ());
        ys = new BitSet(BJ());
        IS = new BitSet(Sc());
        gG = new BitSet(jD());
        Nh = new BitSet(UF());
        BR = new BitSet(rB());
        AE = new BitSet(CN());
        Za = new BitSet(oC());
        An = new BitSet(Dm());
        Pa = new BitSet(re());
        ce = new BitSet(TE());
        Jm = new BitSet(df());
        Bx = new BitSet(p8());
        oa = new BitSet(Z3());
        qP = new BitSet(mu());
        MP = new BitSet(oP());
        Of = new BitSet(LA());
        PT = new BitSet(yu());
        b1 = new BitSet(e4());
    }

    public void j6(SourceBuffer sourceBuffer) {
        this.TI = sourceBuffer;
    }

    public AST j6(int i, String str, AST ast) {
        AST j6 = this.aM.j6(i, str);
        if (!(j6 == null || ast == null)) {
            j6.DW(ast);
            j6.j6(i, str);
        }
        return j6;
    }

    private AST j6(AST ast, Object obj) {
        if ((ast instanceof GroovySourceAST) && (obj instanceof SourceInfo)) {
            SourceInfo sourceInfo = (SourceInfo) obj;
            GroovySourceAST groovySourceAST = (GroovySourceAST) ast;
            groovySourceAST.FH(sourceInfo.Zo());
            groovySourceAST.DW(sourceInfo.v5());
        }
        return ast;
    }

    public AST j6(int i, String str, Token token, Token token2) {
        return j6(j6(i, str, this.aM.j6(token)), (Object) token2);
    }

    public AST j6(int i, String str, AST ast, Token token) {
        return j6(j6(i, str, ast), (Object) token);
    }

    public Token j6(Token token) {
        Token commonToken = new CommonToken(token.Hw(), token.FH());
        commonToken.j6(token.v5());
        commonToken.DW(token.Zo());
        return commonToken;
    }

    public void j6(String str, String str2) {
        int v5 = Token.VH.v5();
        int Zo = Token.VH.Zo();
        try {
            Token DW = DW(1);
            if (DW != null) {
                v5 = DW.v5();
                Zo = DW.Zo();
            }
        } catch (TokenStreamException e) {
            TokenStreamException tokenStreamException = e;
            int i = v5;
            TokenStreamException tokenStreamException2 = tokenStreamException;
            if (tokenStreamException2 instanceof TokenStreamRecognitionException) {
                i = ((TokenStreamRecognitionException) tokenStreamException2).j6.j6();
                Zo = ((TokenStreamRecognitionException) tokenStreamException2).j6.DW();
                v5 = i;
            } else {
                v5 = i;
            }
        }
        throw new SemanticException(str + ";\n   solution: " + str2, v5(), v5, Zo);
    }

    public void DW(String str, String str2) {
        Token token = null;
        try {
            token = DW(1);
        } catch (TokenStreamException e) {
        }
        if (token == null) {
            token = Token.VH;
        }
        Map hashMap = new HashMap();
        hashMap.put("warning", str);
        hashMap.put("solution", str2);
        hashMap.put("filename", v5());
        hashMap.put("line", Integer.valueOf(token.v5()));
        hashMap.put("column", Integer.valueOf(token.Zo()));
        this.j6.add(hashMap);
    }

    private void j6(boolean z, String str, String str2) {
        if (!z) {
            j6(str, str2);
        }
    }

    private boolean DW(boolean z, String str, String str2) {
        if (!z) {
            FH(str, str2);
        }
        return z;
    }

    public void FH(String str, String str2) {
        int v5 = Token.VH.v5();
        int Zo = Token.VH.Zo();
        try {
            Token DW = DW(1);
            if (DW != null) {
                v5 = DW.v5();
                Zo = DW.Zo();
            }
        } catch (TokenStreamException e) {
            TokenStreamException tokenStreamException = e;
            int i = v5;
            TokenStreamException tokenStreamException2 = tokenStreamException;
            if (tokenStreamException2 instanceof TokenStreamRecognitionException) {
                i = ((TokenStreamRecognitionException) tokenStreamException2).j6.j6();
                Zo = ((TokenStreamRecognitionException) tokenStreamException2).j6.DW();
                v5 = i;
            } else {
                v5 = i;
            }
        }
        throw new SemanticException(str + ";\n   solution: " + str2, v5(), v5, Zo);
    }

    private boolean DW(Token token) {
        if (token == null || token.Hw() != 87) {
            return false;
        }
        String FH = token.FH();
        if (FH.length() <= 0 || !Character.isUpperCase(FH.charAt(0))) {
            return false;
        }
        return true;
    }

    private boolean FH(Token token) {
        if (this.ct == null || this.ct.Hw() != 87) {
            return false;
        }
        String FH = this.ct.FH();
        if (token == null || token.Hw() != 87) {
            return false;
        }
        return FH.equals(token.FH());
    }

    protected GroovyRecognizer(TokenStream tokenStream, int i) {
        super(tokenStream, i);
        this.ct = null;
        this.Fd = 1;
        this.Lz = false;
        this.sT = null;
        this.E4 = 1;
        this.xg = 2;
        this.hp = 0;
        this.QX = Hw;
        oa();
        this.aM = new ASTFactory(DW());
    }

    public GroovyRecognizer(TokenStream tokenStream) {
        this(tokenStream, 2);
    }

    public final void VH() {
        int i = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case 38:
            case 39:
            case 43:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
            case 85:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
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
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 126:
            case 128:
            case 132:
            case 137:
            case 139:
            case 140:
            case 141:
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
            case 148:
            case 149:
            case 151:
            case 157:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 190:
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
                break;
            case 80:
                FH(80);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        gn();
        if ((j6(1) == 81 || j6(1) == 96) && (j6(2) == 87 || j6(2) == 93)) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                u7();
                FH(81);
                i = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            tp();
            this.aM.j6(aSTPair, this.XL);
        } else if (v5.Hw(j6(1)) && Zo.Hw(j6(2))) {
            switch (j6(1)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case 128:
                case 205:
                    break;
                case 38:
                case 39:
                case 43:
                case 82:
                case 83:
                case 84:
                case 85:
                case 87:
                case 88:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
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
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 126:
                case 132:
                case 137:
                case 139:
                case 140:
                case 141:
                case 143:
                case 144:
                case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                case 146:
                case 147:
                case 148:
                case 149:
                case 151:
                case 157:
                case 159:
                case 160:
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                case 190:
                case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                case 195:
                case 196:
                case 197:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                    Zo(1);
                    this.aM.j6(aSTPair, this.XL);
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        while (true) {
            if (j6(1) == 128 || j6(1) == 205) {
                EQ();
                switch (j6(1)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case 128:
                    case 205:
                        break;
                    case 38:
                    case 39:
                    case 43:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 87:
                    case 88:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
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
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 126:
                    case 132:
                    case 137:
                    case 139:
                    case 140:
                    case 141:
                    case 143:
                    case 144:
                    case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                    case 146:
                    case 147:
                    case 148:
                    case 149:
                    case 151:
                    case 157:
                    case 159:
                    case 160:
                    case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    case 190:
                    case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                    case 195:
                    case 196:
                    case 197:
                    case 199:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                        Zo(this.Fd);
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            }
            FH(1);
            this.XL = aSTPair.j6;
            return;
        }
    }

    public final void gn() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (j6(1) == 205 && VH.Hw(j6(2))) {
            FH(205);
        } else if (!(VH.Hw(j6(1)) && gn.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = null;
    }

    public final void u7() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        if (u7.Hw(j6(1)) && tp.Hw(j6(2))) {
            vJ();
            this.aM.j6(aSTPair, this.XL);
        } else if (!(EQ.Hw(j6(1)) && we.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(65, "ANNOTATIONS", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void tp() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        u7();
        AST ast = this.XL;
        FH(81);
        we();
        AST ast2 = this.XL;
        if (this.Ws.DW == 0) {
            AST ast3 = aSTPair.j6;
            AST j6 = this.aM.j6(new ASTArray(3).j6(j6(16, "package", DW, DW(1))).j6(ast).j6(ast2));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void Zo(int i) {
        AST ast;
        boolean z;
        AST ast2 = null;
        boolean z2 = false;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        AST ast3;
        AST ast4;
        switch (j6(1)) {
            case 137:
                FH(137);
                FH(91);
                Q6();
                ast3 = this.XL;
                FH(123);
                mb();
                kf();
                ast4 = this.XL;
                if (J0.Hw(j6(1)) && U2.Hw(j6(2))) {
                    int Zo = Zo();
                    ParserSharedInputState parserSharedInputState = this.Ws;
                    parserSharedInputState.DW++;
                    try {
                        switch (j6(1)) {
                            case 128:
                            case 205:
                                EQ();
                                break;
                            case 138:
                                break;
                            default:
                                throw new NoViableAltException(DW(1), v5());
                        }
                        FH(138);
                        z2 = true;
                    } catch (RecognitionException e) {
                    }
                    v5(Zo);
                    ParserSharedInputState parserSharedInputState2 = this.Ws;
                    parserSharedInputState2.DW--;
                }
                if (z2) {
                    switch (j6(1)) {
                        case 128:
                        case 205:
                            EQ();
                            break;
                        case 138:
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                    FH(138);
                    mb();
                    kf();
                    ast = this.XL;
                } else if (a8.Hw(j6(1)) && lg.Hw(j6(2))) {
                    ast = null;
                } else {
                    throw new NoViableAltException(DW(1), v5());
                }
                if (this.Ws.DW == 0) {
                    ast2 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(4).j6(j6(137, "if", DW, DW(1))).j6(ast3).j6(ast4).j6(ast));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                }
                ast = aSTPair.j6;
                break;
            case 139:
                FH(139);
                FH(91);
                VH(false);
                ast3 = this.XL;
                FH(123);
                mb();
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 87:
                    case 88:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
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
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 126:
                    case 132:
                    case 137:
                    case 139:
                    case 140:
                    case 141:
                    case 143:
                    case 144:
                    case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                    case 146:
                    case 147:
                    case 148:
                    case 149:
                    case 151:
                    case 157:
                    case 159:
                    case 160:
                    case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    case 190:
                    case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                    case 195:
                    case 196:
                    case 197:
                    case 199:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                        kf();
                        ast = null;
                        ast2 = this.XL;
                        break;
                    case 128:
                        ast = this.aM.j6(DW(1));
                        FH(128);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                if (this.Ws.DW == 0) {
                    ast4 = aSTPair.j6;
                    if (ast != null) {
                        ast = this.aM.j6(new ASTArray(3).j6(j6(139, "Literal_while", DW, DW(1))).j6(ast3).j6(ast));
                    } else {
                        ast = this.aM.j6(new ASTArray(3).j6(j6(139, "Literal_while", DW, DW(1))).j6(ast3).j6(ast2));
                    }
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                }
                ast = aSTPair.j6;
                break;
            case 140:
                FH(140);
                FH(91);
                VH(false);
                ast3 = this.XL;
                FH(123);
                mb();
                FH(126);
                gn();
                ast = null;
                while (true) {
                    if (j6(1) != ProxyTextView.INPUTTYPE_textPassword && j6(1) != 150) {
                        FH(127);
                        if (this.Ws.DW == 0) {
                            ast2 = aSTPair.j6;
                            ast = this.aM.j6(new ASTArray(3).j6(j6(140, "switch", DW, DW(1))).j6(ast3).j6(ast));
                            aSTPair.j6 = ast;
                            if (!(ast == null || ast.j6() == null)) {
                                ast = ast.j6();
                            }
                            aSTPair.DW = ast;
                            aSTPair.j6();
                        }
                        ast = aSTPair.j6;
                        break;
                    }
                    iW();
                    ast4 = this.XL;
                    if (this.Ws.DW == 0) {
                        ast = this.aM.j6(new ASTArray(3).j6(null).j6(ast).j6(ast4));
                    }
                }
                break;
            case 141:
                Jl();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
                e3();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 151:
                eU();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            default:
                int Zo2;
                ParserSharedInputState parserSharedInputState3;
                int i2;
                ParserSharedInputState parserSharedInputState4;
                if (rN.Hw(j6(1)) && er.Hw(j6(2))) {
                    Zo2 = Zo();
                    parserSharedInputState3 = this.Ws;
                    parserSharedInputState3.DW++;
                    try {
                        P8();
                        i2 = 1;
                    } catch (RecognitionException e2) {
                        z = false;
                    }
                    v5(Zo2);
                    parserSharedInputState4 = this.Ws;
                    parserSharedInputState4.DW--;
                } else {
                    z = false;
                }
                if (i2 == 0) {
                    if (rN.Hw(j6(1)) && yS.Hw(j6(2))) {
                        Zo2 = Zo();
                        parserSharedInputState3 = this.Ws;
                        parserSharedInputState3.DW++;
                        try {
                            ko();
                            i2 = 1;
                        } catch (RecognitionException e3) {
                            z = false;
                        }
                        v5(Zo2);
                        parserSharedInputState4 = this.Ws;
                        parserSharedInputState4.DW--;
                    } else {
                        z = false;
                    }
                    if (i2 == 0) {
                        if (gW.Hw(j6(1)) && BT.Hw(j6(2))) {
                            Zo2 = Zo();
                            parserSharedInputState3 = this.Ws;
                            parserSharedInputState3.DW++;
                            try {
                                a8();
                                i2 = 1;
                            } catch (RecognitionException e4) {
                                z = false;
                            }
                            v5(Zo2);
                            parserSharedInputState4 = this.Ws;
                            parserSharedInputState4.DW--;
                        } else {
                            z = false;
                        }
                        if (i2 == 0) {
                            if (j6(1) == 87 && j6(2) == 136) {
                                Zo2 = Zo();
                                parserSharedInputState3 = this.Ws;
                                parserSharedInputState3.DW++;
                                try {
                                    FH(87);
                                    FH(136);
                                    i2 = 1;
                                } catch (RecognitionException e5) {
                                    z = false;
                                }
                                v5(Zo2);
                                parserSharedInputState4 = this.Ws;
                                parserSharedInputState4.DW--;
                            } else {
                                z = false;
                            }
                            if (i2 == 0) {
                                if (!ei.Hw(j6(1)) || !Zo.Hw(j6(2))) {
                                    if ((j6(1) == 82 || j6(1) == 96) && nw.Hw(j6(2))) {
                                        Zo2 = Zo();
                                        parserSharedInputState3 = this.Ws;
                                        parserSharedInputState3.DW++;
                                        try {
                                            u7();
                                            FH(82);
                                            i2 = 1;
                                        } catch (RecognitionException e6) {
                                            z = false;
                                        }
                                        v5(Zo2);
                                        parserSharedInputState4 = this.Ws;
                                        parserSharedInputState4.DW--;
                                    } else {
                                        z = false;
                                    }
                                    if (i2 == 0) {
                                        if (!SI.Hw(j6(1)) || !KD.Hw(j6(2))) {
                                            if (j6(1) == 121 && j6(2) == 91) {
                                                FH(121);
                                                FH(91);
                                                VH(false);
                                                ast = this.XL;
                                                FH(123);
                                                mb();
                                                FN();
                                                ast2 = this.XL;
                                                if (this.Ws.DW == 0) {
                                                    ast3 = aSTPair.j6;
                                                    ast = this.aM.j6(new ASTArray(3).j6(j6(121, "synchronized", DW, DW(1))).j6(ast).j6(ast2));
                                                    aSTPair.j6 = ast;
                                                    if (!(ast == null || ast.j6() == null)) {
                                                        ast = ast.j6();
                                                    }
                                                    aSTPair.DW = ast;
                                                    aSTPair.j6();
                                                }
                                                ast = aSTPair.j6;
                                                break;
                                            }
                                            throw new NoViableAltException(DW(1), v5());
                                        }
                                        nw();
                                        j6(this.XL);
                                        this.aM.j6(aSTPair, this.XL);
                                        ast = aSTPair.j6;
                                        break;
                                    }
                                    J0();
                                    this.aM.j6(aSTPair, this.XL);
                                    ast = aSTPair.j6;
                                    break;
                                }
                                tp(i);
                                ast = this.XL;
                                this.aM.j6(aSTPair, this.XL);
                                ast = aSTPair.j6;
                                break;
                            }
                            n5();
                            ast2 = this.XL;
                            if (this.Ws.DW == 0) {
                                AST ast5 = aSTPair.j6;
                                aSTPair.j6 = ast2;
                                if (!(ast2 == null || ast2.j6() == null)) {
                                    ast2 = ast2.j6();
                                }
                                aSTPair.DW = ast2;
                                aSTPair.j6();
                            }
                            if (j6(1) == 126 && vy.Hw(j6(2))) {
                                i2 = Zo();
                                ParserSharedInputState parserSharedInputState5 = this.Ws;
                                parserSharedInputState5.DW++;
                                try {
                                    FH(126);
                                    z2 = true;
                                } catch (RecognitionException e7) {
                                }
                                v5(i2);
                                parserSharedInputState3 = this.Ws;
                                parserSharedInputState3.DW--;
                            }
                            if (z2) {
                                Z1();
                                this.aM.j6(aSTPair, this.XL);
                            } else if (P8.Hw(j6(1)) && Zo.Hw(j6(2))) {
                                Zo(136);
                                this.aM.j6(aSTPair, this.XL);
                            } else {
                                throw new NoViableAltException(DW(1), v5());
                            }
                            ast = aSTPair.j6;
                            break;
                        }
                        Ws();
                        this.aM.j6(aSTPair, this.XL);
                        ast = aSTPair.j6;
                        break;
                    }
                    Ev();
                    this.aM.j6(aSTPair, this.XL);
                    ast = aSTPair.j6;
                    break;
                }
                XL();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
                break;
        }
        this.XL = ast;
    }

    public final void EQ() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 128:
                FH(128);
                while (j6(1) == 205 && ro.Hw(j6(2))) {
                    FH(205);
                }
                if (this.Ws.DW == 0) {
                    this.Fd = 128;
                    break;
                }
                break;
            case 205:
                FH(205);
                if (this.Ws.DW == 0) {
                    this.Fd = 205;
                }
                while (j6(1) == 128 && ro.Hw(j6(2))) {
                    FH(128);
                    while (j6(1) == 205 && ro.Hw(j6(2))) {
                        FH(205);
                    }
                    if (this.Ws.DW == 0) {
                        this.Fd = 128;
                    }
                }
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = null;
    }

    public final void VH(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case 127:
            case 128:
            case 205:
                break;
            case 38:
            case 39:
            case 43:
            case 82:
            case 83:
            case 84:
            case 85:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
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
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 126:
            case 132:
            case 137:
            case 139:
            case 140:
            case 141:
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
            case 148:
            case 149:
            case 151:
            case 157:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 190:
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                Zo(i);
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        while (true) {
            if (j6(1) == 128 || j6(1) == 205) {
                EQ();
                switch (j6(1)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case 127:
                    case 128:
                    case 205:
                        break;
                    case 38:
                    case 39:
                    case 43:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 87:
                    case 88:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
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
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 126:
                    case 132:
                    case 137:
                    case 139:
                    case 140:
                    case 141:
                    case 143:
                    case 144:
                    case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                    case 146:
                    case 147:
                    case 148:
                    case 149:
                    case 151:
                    case 157:
                    case 159:
                    case 160:
                    case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    case 190:
                    case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                    case 195:
                    case 196:
                    case 197:
                    case 199:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                        Zo(this.Fd);
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            }
            this.XL = aSTPair.j6;
            return;
        }
    }

    public final void we() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        AST j6 = this.aM.j6(DW(1));
        FH(87);
        while (j6(1) == 90) {
            this.aM.j6(DW(1));
            FH(90);
            gn();
            AST j62 = this.aM.j6(DW(1));
            FH(87);
            if (this.Ws.DW == 0) {
                j6 = this.aM.j6(new ASTArray(3).j6(j6(90, ".", DW, DW(1))).j6(j6).j6(j62));
            }
        }
        if (this.Ws.DW == 0) {
            AST ast = aSTPair.j6;
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void J0() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        int i = 0;
        u7();
        AST ast = this.XL;
        this.aM.j6(aSTPair, this.XL);
        FH(82);
        switch (j6(1)) {
            case 83:
                FH(83);
                if (this.Ws.DW == 0) {
                    i = 1;
                    break;
                }
                break;
            case 87:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        J8();
        AST ast2 = this.XL;
        if (this.Ws.DW == 0) {
            AST j6;
            AST ast3 = aSTPair.j6;
            if (i != 0) {
                j6 = this.aM.j6(new ASTArray(3).j6(j6(60, "static_import", DW, DW(1))).j6(ast).j6(ast2));
            } else {
                j6 = this.aM.j6(new ASTArray(3).j6(j6(29, "import", DW, DW(1))).j6(ast).j6(ast2));
            }
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void J8() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        AST j6 = this.aM.j6(DW(1));
        FH(87);
        while (j6(1) == 90 && (j6(2) == 87 || j6(2) == 205)) {
            this.aM.j6(DW(1));
            FH(90);
            gn();
            AST j62 = this.aM.j6(DW(1));
            FH(87);
            if (this.Ws.DW == 0) {
                j6 = this.aM.j6(new ASTArray(3).j6(j6(90, ".", DW, DW(1))).j6(j6).j6(j62));
            }
        }
        switch (j6(1)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case 127:
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 138:
            case 150:
            case 205:
                break;
            case 90:
                this.aM.j6(DW(1));
                FH(90);
                gn();
                j62 = this.aM.j6(DW(1));
                FH(ProxyTextView.INPUTTYPE_textPostalAddress);
                if (this.Ws.DW == 0) {
                    j6 = this.aM.j6(new ASTArray(3).j6(j6(90, ".", DW, DW(1))).j6(j6).j6(j62));
                    break;
                }
                break;
            case 114:
                FH(114);
                gn();
                j62 = this.aM.j6(DW(1));
                FH(87);
                if (this.Ws.DW == 0) {
                    j6 = this.aM.j6(new ASTArray(3).j6(j6(114, "as", DW, DW(1))).j6(j6).j6(j62));
                    break;
                }
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST ast = aSTPair.j6;
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    protected final void j6(AST ast) {
        AST ast2;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        AST ast3;
        switch (j6(1)) {
            case 92:
                DW(ast);
                ast2 = this.XL;
                this.aM.j6(aSTPair, this.XL);
                if (this.Ws.DW == 0) {
                    ast3 = aSTPair.j6;
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            case 93:
                Hw(ast);
                ast2 = this.XL;
                this.aM.j6(aSTPair, this.XL);
                if (this.Ws.DW == 0) {
                    ast3 = aSTPair.j6;
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            case 94:
                v5(ast);
                ast2 = this.XL;
                this.aM.j6(aSTPair, this.XL);
                if (this.Ws.DW == 0) {
                    ast3 = aSTPair.j6;
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            case 95:
                FH(ast);
                ast2 = this.XL;
                this.aM.j6(aSTPair, this.XL);
                if (this.Ws.DW == 0) {
                    ast3 = aSTPair.j6;
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            case 96:
                Zo(ast);
                ast2 = this.XL;
                this.aM.j6(aSTPair, this.XL);
                if (this.Ws.DW == 0) {
                    ast3 = aSTPair.j6;
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast2;
    }

    public final void DW(AST ast) {
        AST ast2;
        AST ast3 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        AST ast4 = this.ct;
        if (ast != null) {
            j6.j6(ast.v5());
            j6.DW(ast.Zo());
        }
        FH(92);
        AST j62 = this.aM.j6(DW(1));
        FH(87);
        gn();
        if (this.Ws.DW == 0) {
            this.ct = j62;
        }
        switch (j6(1)) {
            case 89:
                aM();
                ast2 = this.XL;
                gn();
                break;
            case 98:
            case 126:
            case 131:
                ast2 = null;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        Qq();
        AST ast5 = this.XL;
        sy();
        AST ast6 = this.XL;
        aj();
        AST ast7 = this.XL;
        if (this.Ws.DW == 0) {
            ast3 = aSTPair.j6;
            ast3 = this.aM.j6(new ASTArray(7).j6(j6(13, "CLASS_DEF", j6, DW(1))).j6(ast).j6(j62).j6(ast2).j6(ast5).j6(ast6).j6(ast7));
            aSTPair.j6 = ast3;
            ast2 = (ast3 == null || ast3.j6() == null) ? ast3 : ast3.j6();
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        if (this.Ws.DW == 0) {
            this.ct = ast4;
        }
        this.XL = ast3;
    }

    public final void FH(AST ast) {
        AST ast2;
        AST ast3 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        AST ast4 = this.ct;
        if (ast != null) {
            j6.j6(ast.v5());
            j6.DW(ast.Zo());
        }
        FH(95);
        AST j62 = this.aM.j6(DW(1));
        FH(87);
        gn();
        if (this.Ws.DW == 0) {
            this.ct = j62;
        }
        switch (j6(1)) {
            case 89:
                aM();
                ast2 = this.XL;
                gn();
                break;
            case 98:
            case 126:
            case 131:
                ast2 = null;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        Qq();
        AST ast5 = this.XL;
        sy();
        AST ast6 = this.XL;
        aj();
        AST ast7 = this.XL;
        if (this.Ws.DW == 0) {
            ast3 = aSTPair.j6;
            ast3 = this.aM.j6(new ASTArray(7).j6(j6(15, "TRAIT_DEF", j6, DW(1))).j6(ast).j6(j62).j6(ast2).j6(ast5).j6(ast6).j6(ast7));
            aSTPair.j6 = ast3;
            ast2 = (ast3 == null || ast3.j6() == null) ? ast3 : ast3.j6();
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        if (this.Ws.DW == 0) {
            this.ct = ast4;
        }
        this.XL = ast3;
    }

    public final void Hw(AST ast) {
        AST ast2;
        AST ast3 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        if (ast != null) {
            j6.j6(ast.v5());
            j6.DW(ast.Zo());
        }
        FH(93);
        AST j62 = this.aM.j6(DW(1));
        FH(87);
        gn();
        switch (j6(1)) {
            case 89:
                aM();
                ast2 = this.XL;
                gn();
                break;
            case 98:
            case 126:
                ast2 = null;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        lp();
        AST ast4 = this.XL;
        OW();
        AST ast5 = this.XL;
        if (this.Ws.DW == 0) {
            ast3 = aSTPair.j6;
            ast3 = this.aM.j6(new ASTArray(6).j6(j6(14, "INTERFACE_DEF", j6, DW(1))).j6(ast).j6(j62).j6(ast2).j6(ast4).j6(ast5));
            aSTPair.j6 = ast3;
            ast2 = (ast3 == null || ast3.j6() == null) ? ast3 : ast3.j6();
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        this.XL = ast3;
    }

    public final void v5(AST ast) {
        AST ast2 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        AST ast3 = this.ct;
        if (ast != null) {
            j6.j6(ast.v5());
            j6.DW(ast.Zo());
        }
        FH(94);
        AST j62 = this.aM.j6(DW(1));
        FH(87);
        if (this.Ws.DW == 0) {
            this.ct = j62;
        }
        gn();
        sy();
        AST ast4 = this.XL;
        gn();
        br();
        AST ast5 = this.XL;
        if (this.Ws.DW == 0) {
            ast2 = aSTPair.j6;
            ast2 = this.aM.j6(new ASTArray(5).j6(j6(61, "ENUM_DEF", j6, DW(1))).j6(ast).j6(j62).j6(ast4).j6(ast5));
            aSTPair.j6 = ast2;
            AST j63 = (ast2 == null || ast2.j6() == null) ? ast2 : ast2.j6();
            aSTPair.DW = j63;
            aSTPair.j6();
        }
        if (this.Ws.DW == 0) {
            this.ct = ast3;
        }
        this.XL = ast2;
    }

    public final void Zo(AST ast) {
        AST ast2 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        if (ast != null) {
            j6.j6(ast.v5());
            j6.DW(ast.Zo());
        }
        this.aM.j6(DW(1));
        FH(96);
        FH(93);
        AST j62 = this.aM.j6(DW(1));
        FH(87);
        XX();
        AST ast3 = this.XL;
        if (this.Ws.DW == 0) {
            ast2 = aSTPair.j6;
            ast2 = this.aM.j6(new ASTArray(4).j6(j6(64, "ANNOTATION_DEF", j6, DW(1))).j6(ast).j6(j62).j6(ast3));
            aSTPair.j6 = ast2;
            AST j63 = (ast2 == null || ast2.j6() == null) ? ast2 : ast2.j6();
            aSTPair.DW = j63;
            aSTPair.j6();
        }
        this.XL = ast2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ws() {
        /*
        r8 = this;
        r7 = 2;
        r6 = 0;
        r1 = 0;
        r5 = 1;
        r8.XL = r1;
        r3 = new groovyjarjarantlr.ASTPair;
        r3.<init>();
        r0 = r8.j6(r5);
        switch(r0) {
            case 38: goto L_0x0020;
            case 39: goto L_0x0020;
            case 43: goto L_0x0020;
            case 83: goto L_0x0020;
            case 84: goto L_0x0020;
            case 87: goto L_0x0093;
            case 96: goto L_0x0020;
            case 104: goto L_0x0093;
            case 105: goto L_0x0093;
            case 106: goto L_0x0093;
            case 107: goto L_0x0093;
            case 108: goto L_0x0093;
            case 109: goto L_0x0093;
            case 110: goto L_0x0093;
            case 111: goto L_0x0093;
            case 112: goto L_0x0093;
            case 115: goto L_0x0020;
            case 116: goto L_0x0020;
            case 117: goto L_0x0020;
            case 118: goto L_0x0020;
            case 119: goto L_0x0020;
            case 120: goto L_0x0020;
            case 121: goto L_0x0020;
            case 122: goto L_0x0020;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r8.DW(r5);
        r2 = r8.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x0020:
        r8.QX();
        r2 = r8.XL;
        r0 = cn;
        r4 = r8.j6(r5);
        r0 = r0.Hw(r4);
        if (r0 == 0) goto L_0x0065;
    L_0x0031:
        r0 = sh;
        r4 = r8.j6(r7);
        r0 = r0.Hw(r4);
        if (r0 == 0) goto L_0x0065;
    L_0x003d:
        r8.j6(r6);
        r0 = r8.XL;
    L_0x0042:
        r8.j6(r2, r0);
        r2 = r8.XL;
        r0 = r8.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x00bb;
    L_0x004d:
        r0 = r3.j6;
        r3.j6 = r2;
        if (r2 == 0) goto L_0x0091;
    L_0x0053:
        r0 = r2.j6();
        if (r0 == 0) goto L_0x0091;
    L_0x0059:
        r0 = r2.j6();
    L_0x005d:
        r3.DW = r0;
        r3.j6();
    L_0x0062:
        r8.XL = r2;
        return;
    L_0x0065:
        r0 = r8.j6(r5);
        r4 = 87;
        if (r0 == r4) goto L_0x0075;
    L_0x006d:
        r0 = r8.j6(r5);
        r4 = 88;
        if (r0 != r4) goto L_0x0083;
    L_0x0075:
        r0 = cb;
        r4 = r8.j6(r7);
        r0 = r0.Hw(r4);
        if (r0 == 0) goto L_0x0083;
    L_0x0081:
        r0 = r1;
        goto L_0x0042;
    L_0x0083:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r8.DW(r5);
        r2 = r8.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x0091:
        r0 = r2;
        goto L_0x005d;
    L_0x0093:
        r8.j6(r6);
        r0 = r8.XL;
        r8.j6(r1, r0);
        r2 = r8.XL;
        r0 = r8.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x00bb;
    L_0x00a3:
        r0 = r3.j6;
        r3.j6 = r2;
        if (r2 == 0) goto L_0x00b9;
    L_0x00a9:
        r0 = r2.j6();
        if (r0 == 0) goto L_0x00b9;
    L_0x00af:
        r0 = r2.j6();
    L_0x00b3:
        r3.DW = r0;
        r3.j6();
        goto L_0x0062;
    L_0x00b9:
        r0 = r2;
        goto L_0x00b3;
    L_0x00bb:
        r2 = r1;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyRecognizer.Ws():void");
    }

    public final void QX() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        ef();
        this.aM.j6(aSTPair, this.XL);
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(5, "MODIFIERS", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void j6(boolean z) {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 87:
                DW(z);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                FH(z);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void j6(AST ast, AST ast2) {
        AST ast3;
        int i = 0;
        AST ast4 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        if (ast != null) {
            j6.j6(ast.v5());
            j6.DW(ast.Zo());
        } else if (ast2 != null) {
            j6.j6(ast2.v5());
            j6.DW(ast2.Zo());
        }
        if (j6(1) == 87 && dx.Hw(j6(2))) {
            j6(ast, ast2, j6);
            this.aM.j6(aSTPair, this.XL);
            ast3 = aSTPair.j6;
        } else if ((j6(1) == 87 || j6(1) == 88) && j6(2) == 91) {
            AST ast5;
            int Zo;
            int i2;
            ParserSharedInputState parserSharedInputState;
            AST ast6;
            switch (j6(1)) {
                case 87:
                    ast3 = this.aM.j6(DW(1));
                    this.aM.j6(aSTPair, ast3);
                    FH(87);
                    ast5 = ast3;
                    ast3 = null;
                    break;
                case 88:
                    ast3 = this.aM.j6(DW(1));
                    this.aM.j6(aSTPair, ast3);
                    FH(88);
                    if (this.Ws.DW != 0) {
                        ast5 = null;
                        break;
                    }
                    ast3.j6(87);
                    ast5 = null;
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
            FH(91);
            jO();
            AST ast7 = this.XL;
            FH(123);
            if ((j6(1) == 130 || j6(1) == 205) && sG.Hw(j6(2))) {
                Zo = Zo();
                ParserSharedInputState parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW++;
                try {
                    gn();
                    FH(130);
                    i2 = 1;
                } catch (RecognitionException e) {
                    i2 = 0;
                }
                v5(Zo);
                parserSharedInputState = this.Ws;
                parserSharedInputState.DW--;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                oY();
                ast6 = this.XL;
            } else if (ef.Hw(j6(1)) && lg.Hw(j6(2))) {
                ast6 = null;
            } else {
                throw new NoViableAltException(DW(1), v5());
            }
            if ((j6(1) == 126 || j6(1) == 205) && Sf.Hw(j6(2))) {
                Zo = Zo();
                ParserSharedInputState parserSharedInputState3 = this.Ws;
                parserSharedInputState3.DW++;
                try {
                    gn();
                    FH(126);
                    i = 1;
                } catch (RecognitionException e2) {
                }
                v5(Zo);
                parserSharedInputState = this.Ws;
                parserSharedInputState.DW--;
            }
            if (i != 0) {
                mb();
                jw();
                ast4 = this.XL;
            } else if (!(a8.Hw(j6(1)) && lg.Hw(j6(2)))) {
                throw new NoViableAltException(DW(1), v5());
            }
            if (this.Ws.DW == 0) {
                AST ast8 = aSTPair.j6;
                if (ast3 == null) {
                    ast3 = ast5;
                }
                ast3 = this.aM.j6(new ASTArray(7).j6(j6(8, "METHOD_DEF", j6, DW(1))).j6(ast).j6(this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", j6, DW(1))).j6(ast2))).j6(ast3).j6(ast7).j6(ast6).j6(ast4));
                aSTPair.j6 = ast3;
                if (!(ast3 == null || ast3.j6() == null)) {
                    ast3 = ast3.j6();
                }
                aSTPair.DW = ast3;
                aSTPair.j6();
            }
            ast3 = aSTPair.j6;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast3;
    }

    public final void XL() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        QX();
        AST ast = this.XL;
        aM();
        AST ast2 = this.XL;
        j6(false);
        j6(ast, this.XL);
        ast = this.XL;
        if (this.Ws.DW == 0) {
            AST ast3 = aSTPair.j6;
            ast3 = ast.j6();
            ast.FH(ast2);
            ast2.Hw(ast3);
            aSTPair.j6 = ast;
            ast3 = (ast == null || ast.j6() == null) ? ast : ast.j6();
            aSTPair.DW = ast3;
            aSTPair.j6();
        } else {
            ast = null;
        }
        this.XL = ast;
    }

    public final void aM() {
        int i;
        boolean z = false;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        if (this.Ws.DW == 0) {
            i = this.hp;
        } else {
            i = 0;
        }
        FH(89);
        if (this.Ws.DW == 0) {
            this.hp++;
        }
        gn();
        kQ();
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 101) {
            FH(101);
            gn();
            kQ();
            this.aM.j6(aSTPair, this.XL);
        }
        gn();
        switch (j6(1)) {
            case 87:
            case 88:
            case 98:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 126:
            case 131:
            case 205:
                break;
            case 100:
            case 102:
            case 103:
                dx();
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (i != 0 || this.hp == i) {
            z = true;
        }
        if (DW(z, "Missing closing bracket '>' for generics types", "Please specify the missing bracket!")) {
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(72, "TYPE_PARAMETERS", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
        throw new SemanticException("matchGenericTypeBrackets(((currentLtLevel != 0) || ltCounter == currentLtLevel),\n        \"Missing closing bracket '>' for generics types\", \"Please specify the missing bracket!\")");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j3() {
        /*
        r8 = this;
        r7 = 2;
        r6 = 0;
        r1 = 0;
        r5 = 1;
        r8.XL = r1;
        r3 = new groovyjarjarantlr.ASTPair;
        r3.<init>();
        r0 = r8.j6(r5);
        switch(r0) {
            case 38: goto L_0x0020;
            case 39: goto L_0x0020;
            case 43: goto L_0x0020;
            case 83: goto L_0x0020;
            case 84: goto L_0x0020;
            case 87: goto L_0x008b;
            case 96: goto L_0x0020;
            case 104: goto L_0x008b;
            case 105: goto L_0x008b;
            case 106: goto L_0x008b;
            case 107: goto L_0x008b;
            case 108: goto L_0x008b;
            case 109: goto L_0x008b;
            case 110: goto L_0x008b;
            case 111: goto L_0x008b;
            case 112: goto L_0x008b;
            case 115: goto L_0x0020;
            case 116: goto L_0x0020;
            case 117: goto L_0x0020;
            case 118: goto L_0x0020;
            case 119: goto L_0x0020;
            case 120: goto L_0x0020;
            case 121: goto L_0x0020;
            case 122: goto L_0x0020;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r8.DW(r5);
        r2 = r8.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x0020:
        r8.QX();
        r2 = r8.XL;
        r0 = cn;
        r4 = r8.j6(r5);
        r0 = r0.Hw(r4);
        if (r0 == 0) goto L_0x0065;
    L_0x0031:
        r0 = vJ;
        r4 = r8.j6(r7);
        r0 = r0.Hw(r4);
        if (r0 == 0) goto L_0x0065;
    L_0x003d:
        r8.j6(r6);
        r0 = r8.XL;
    L_0x0042:
        r8.DW(r2, r0);
        r2 = r8.XL;
        r0 = r8.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x00b3;
    L_0x004d:
        r0 = r3.j6;
        r3.j6 = r2;
        if (r2 == 0) goto L_0x0089;
    L_0x0053:
        r0 = r2.j6();
        if (r0 == 0) goto L_0x0089;
    L_0x0059:
        r0 = r2.j6();
    L_0x005d:
        r3.DW = r0;
        r3.j6();
    L_0x0062:
        r8.XL = r2;
        return;
    L_0x0065:
        r0 = r8.j6(r5);
        r4 = 87;
        if (r0 != r4) goto L_0x007b;
    L_0x006d:
        r0 = g3;
        r4 = r8.j6(r7);
        r0 = r0.Hw(r4);
        if (r0 == 0) goto L_0x007b;
    L_0x0079:
        r0 = r1;
        goto L_0x0042;
    L_0x007b:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r8.DW(r5);
        r2 = r8.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x0089:
        r0 = r2;
        goto L_0x005d;
    L_0x008b:
        r8.j6(r6);
        r0 = r8.XL;
        r8.DW(r1, r0);
        r2 = r8.XL;
        r0 = r8.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x00b3;
    L_0x009b:
        r0 = r3.j6;
        r3.j6 = r2;
        if (r2 == 0) goto L_0x00b1;
    L_0x00a1:
        r0 = r2.j6();
        if (r0 == 0) goto L_0x00b1;
    L_0x00a7:
        r0 = r2.j6();
    L_0x00ab:
        r3.DW = r0;
        r3.j6();
        goto L_0x0062;
    L_0x00b1:
        r0 = r2;
        goto L_0x00ab;
    L_0x00b3:
        r2 = r1;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyRecognizer.j3():void");
    }

    public final void DW(AST ast, AST ast2) {
        AST ast3 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        fY();
        AST ast4 = this.XL;
        if (this.Ws.DW == 0) {
            ast3 = aSTPair.j6;
            ast3 = this.aM.j6(new ASTArray(4).j6(j6(9, "VARIABLE_DEF", DW, DW(1))).j6(ast).j6(this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", DW, DW(1))).j6(ast2))).j6(ast4));
            aSTPair.j6 = ast3;
            AST j6 = (ast3 == null || ast3.j6() == null) ? ast3 : ast3.j6();
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = ast3;
    }

    public final void Mr() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        j3();
        AST ast = this.XL;
        if (this.Ws.DW == 0) {
            AST ast2 = aSTPair.j6;
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        switch (j6(1)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case 86:
            case 101:
            case 123:
            case 128:
                break;
            case 124:
                U2();
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void U2() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
        FH(124);
        gn();
        qp();
        this.aM.j6(aSTPair, this.XL);
        this.XL = aSTPair.j6;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a8() {
        /*
        r8 = this;
        r7 = 0;
        r6 = 85;
        r5 = 87;
        r4 = 2;
        r3 = 1;
        r8.XL = r7;
        r0 = new groovyjarjarantlr.ASTPair;
        r0.<init>();
        r0 = 0;
    L_0x000f:
        r1 = r8.j6(r3);
        switch(r1) {
            case 38: goto L_0x0063;
            case 39: goto L_0x0063;
            case 43: goto L_0x0063;
            case 83: goto L_0x0063;
            case 84: goto L_0x0058;
            case 96: goto L_0x006a;
            case 115: goto L_0x0063;
            case 116: goto L_0x0063;
            case 117: goto L_0x0063;
            case 118: goto L_0x0063;
            case 119: goto L_0x0063;
            case 120: goto L_0x0063;
            case 121: goto L_0x0063;
            case 122: goto L_0x0063;
            default: goto L_0x0016;
        };
    L_0x0016:
        r1 = cn;
        r2 = r8.j6(r3);
        r1 = r1.Hw(r2);
        if (r1 == 0) goto L_0x00cc;
    L_0x0022:
        r1 = Mz;
        r2 = r8.j6(r4);
        r1 = r1.Hw(r2);
        if (r1 == 0) goto L_0x00cc;
    L_0x002e:
        r1 = r8.j6(r3);
        if (r1 != r5) goto L_0x0071;
    L_0x0034:
        r1 = I;
        r2 = r8.j6(r4);
        r1 = r1.Hw(r2);
        if (r1 == 0) goto L_0x0071;
    L_0x0040:
        r8.er();
    L_0x0043:
        r1 = r8.j6(r3);
        switch(r1) {
            case 38: goto L_0x00a8;
            case 39: goto L_0x00a8;
            case 43: goto L_0x00a8;
            case 83: goto L_0x00a8;
            case 84: goto L_0x00a8;
            case 85: goto L_0x00a8;
            case 87: goto L_0x00a8;
            case 88: goto L_0x00a8;
            case 89: goto L_0x00a5;
            case 96: goto L_0x00a8;
            case 104: goto L_0x00a8;
            case 105: goto L_0x00a8;
            case 106: goto L_0x00a8;
            case 107: goto L_0x00a8;
            case 108: goto L_0x00a8;
            case 109: goto L_0x00a8;
            case 110: goto L_0x00a8;
            case 111: goto L_0x00a8;
            case 112: goto L_0x00a8;
            case 115: goto L_0x00a8;
            case 116: goto L_0x00a8;
            case 117: goto L_0x00a8;
            case 118: goto L_0x00a8;
            case 119: goto L_0x00a8;
            case 120: goto L_0x00a8;
            case 121: goto L_0x00a8;
            case 122: goto L_0x00a8;
            default: goto L_0x004a;
        };
    L_0x004a:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r8.DW(r3);
        r2 = r8.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x0058:
        r1 = 84;
        r8.FH(r1);
        r8.gn();
    L_0x0060:
        r0 = r0 + 1;
        goto L_0x000f;
    L_0x0063:
        r8.lg();
        r8.gn();
        goto L_0x0060;
    L_0x006a:
        r8.rN();
        r8.gn();
        goto L_0x0060;
    L_0x0071:
        r1 = r8.j6(r3);
        r2 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        if (r1 < r2) goto L_0x0085;
    L_0x0079:
        r1 = r8.j6(r3);
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        if (r1 > r2) goto L_0x0085;
    L_0x0081:
        r8.yS();
        goto L_0x0043;
    L_0x0085:
        r1 = r8.j6(r3);
        if (r1 != r5) goto L_0x0097;
    L_0x008b:
        r1 = r8.j6(r4);
        r2 = 90;
        if (r1 != r2) goto L_0x0097;
    L_0x0093:
        r8.gW();
        goto L_0x0043;
    L_0x0097:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r8.DW(r3);
        r2 = r8.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x00a5:
        r8.BT();
    L_0x00a8:
        r1 = r8.j6(r3);
        if (r1 != r6) goto L_0x0060;
    L_0x00ae:
        r1 = r8.aM;
        r2 = r8.DW(r3);
        r1.j6(r2);
        r8.FH(r6);
        r8.vy();
        r1 = r8.aM;
        r2 = r8.DW(r3);
        r1.j6(r2);
        r1 = 86;
        r8.FH(r1);
        goto L_0x00a8;
    L_0x00cc:
        if (r0 < r3) goto L_0x00e3;
    L_0x00ce:
        r0 = r8.j6(r3);
        switch(r0) {
            case 87: goto L_0x00f1;
            case 88: goto L_0x0100;
            default: goto L_0x00d5;
        };
    L_0x00d5:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r8.DW(r3);
        r2 = r8.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x00e3:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r8.DW(r3);
        r2 = r8.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x00f1:
        r0 = r8.aM;
        r1 = r8.DW(r3);
        r0.j6(r1);
        r8.FH(r5);
    L_0x00fd:
        r8.XL = r7;
        return;
    L_0x0100:
        r0 = r8.aM;
        r1 = r8.DW(r3);
        r0.j6(r1);
        r0 = 88;
        r8.FH(r0);
        goto L_0x00fd;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyRecognizer.a8():void");
    }

    public final void lg() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 38:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(38);
                ast = aSTPair.j6;
                break;
            case 39:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(39);
                ast = aSTPair.j6;
                break;
            case 43:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(43);
                ast = aSTPair.j6;
                break;
            case 83:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(83);
                ast = aSTPair.j6;
                break;
            case 115:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(115);
                ast = aSTPair.j6;
                break;
            case 116:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(116);
                ast = aSTPair.j6;
                break;
            case 117:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(117);
                ast = aSTPair.j6;
                break;
            case 118:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(118);
                ast = aSTPair.j6;
                break;
            case 119:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(119);
                ast = aSTPair.j6;
                break;
            case 120:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(120);
                ast = aSTPair.j6;
                break;
            case 121:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(121);
                ast = aSTPair.j6;
                break;
            case 122:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(122);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void rN() {
        AST ast;
        AST ast2 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(96);
        we();
        AST ast3 = this.XL;
        gn();
        if (j6(1) == 91 && ca.Hw(j6(2))) {
            FH(91);
            switch (j6(1)) {
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                case 82:
                case 83:
                case 84:
                case 85:
                case 87:
                case 88:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
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
                case 126:
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
                case 148:
                case 149:
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
                case 195:
                case 196:
                case 197:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                    Sf();
                    ast = this.XL;
                    break;
                case 123:
                    ast = null;
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
            FH(123);
        } else if (x9.Hw(j6(1)) && Qq.Hw(j6(2))) {
            ast = null;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            ast2 = aSTPair.j6;
            ast2 = this.aM.j6(new ASTArray(3).j6(j6(66, "ANNOTATION", DW, DW(1))).j6(ast3).j6(ast));
            aSTPair.j6 = ast2;
            if (ast2 == null || ast2.j6() == null) {
                ast = ast2;
            } else {
                ast = ast2.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = ast2;
    }

    public final void er() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (DW(DW(1))) {
            this.aM.j6(aSTPair, this.aM.j6(DW(1)));
            FH(87);
            this.XL = aSTPair.j6;
            return;
        }
        throw new SemanticException("isUpperCase(LT(1))");
    }

    public final void yS() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 104:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(104);
                ast = aSTPair.j6;
                break;
            case 105:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(105);
                ast = aSTPair.j6;
                break;
            case 106:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(106);
                ast = aSTPair.j6;
                break;
            case 107:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(107);
                ast = aSTPair.j6;
                break;
            case 108:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(108);
                ast = aSTPair.j6;
                break;
            case 109:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(109);
                ast = aSTPair.j6;
                break;
            case 110:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(110);
                ast = aSTPair.j6;
                break;
            case 111:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(111);
                ast = aSTPair.j6;
                break;
            case 112:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(112);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void gW() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        this.aM.j6(DW(1));
        FH(87);
        this.aM.j6(DW(1));
        FH(90);
        while (j6(1) == 87 && j6(2) == 90) {
            this.aM.j6(DW(1));
            FH(87);
            this.aM.j6(DW(1));
            FH(90);
        }
        er();
        this.XL = null;
    }

    public final void BT() {
        int i;
        boolean z = false;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        if (this.Ws.DW == 0) {
            i = this.hp;
        } else {
            i = 0;
        }
        FH(89);
        if (this.Ws.DW == 0) {
            this.hp++;
        }
        gn();
        cn();
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 101 && sy.Hw(j6(2)) && (this.Ws.DW != 0 || this.hp == i + 1)) {
            FH(101);
            gn();
            cn();
            this.aM.j6(aSTPair, this.XL);
        }
        gn();
        if (aj.Hw(j6(1)) && lp.Hw(j6(2))) {
            dx();
            this.aM.j6(aSTPair, this.XL);
        } else if (!(lp.Hw(j6(1)) && gn.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        if (i != 0 || this.hp == i) {
            z = true;
        }
        if (DW(z, "Missing closing bracket '>' for generics types", "Please specify the missing bracket!")) {
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(70, "TYPE_ARGUMENTS", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
        throw new SemanticException("matchGenericTypeBrackets(((currentLtLevel != 0) || ltCounter == currentLtLevel),\n        \"Missing closing bracket '>' for generics types\", \"Please specify the missing bracket!\")");
    }

    public final void vy() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        while (true) {
            if (OW.Hw(j6(1))) {
                Bx();
            } else if (br.Hw(j6(1))) {
                j6(br);
            } else {
                this.XL = null;
                return;
            }
        }
    }

    public final void P8() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        int i = 0;
        while (true) {
            switch (j6(1)) {
                case 38:
                case 39:
                case 43:
                case 83:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                    lg();
                    gn();
                    break;
                case 84:
                    FH(84);
                    gn();
                    break;
                case 96:
                    rN();
                    gn();
                    break;
                default:
                    if (i >= 1) {
                        this.aM.j6(DW(1));
                        FH(89);
                        this.XL = null;
                        return;
                    }
                    throw new NoViableAltException(DW(1), v5());
            }
            i++;
        }
    }

    public final void ei() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        nw();
        Token DW = DW(1);
        this.aM.j6(DW);
        FH(87);
        if (FH(DW)) {
            gn();
            FH(91);
            this.XL = null;
            return;
        }
        throw new SemanticException("isConstructorIdent(id)");
    }

    public final void nw() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        if (rN.Hw(j6(1)) && XX.Hw(j6(2))) {
            ef();
            this.aM.j6(aSTPair, this.XL);
        } else if (!(kQ.Hw(j6(1)) && yO.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(5, "MODIFIERS", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void SI() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        nw();
        switch (j6(1)) {
            case 92:
                FH(92);
                break;
            case 93:
                FH(93);
                break;
            case 94:
                FH(94);
                break;
            case 95:
                FH(95);
                break;
            case 96:
                this.aM.j6(DW(1));
                FH(96);
                FH(93);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = null;
    }

    public final void DW(boolean z) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        Hw(false);
        VH(this.XL);
        this.aM.j6(aSTPair, this.XL);
        if (this.Ws.DW == 0) {
            AST ast = aSTPair.j6;
            if (z) {
                ast = this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", DW, DW(1))).j6(ast));
            }
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void FH(boolean z) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        yS();
        VH(this.XL);
        this.aM.j6(aSTPair, this.XL);
        if (this.Ws.DW == 0) {
            AST ast = aSTPair.j6;
            if (z) {
                ast = this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", DW, DW(1))).j6(ast));
            }
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void Hw(boolean z) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        AST ast = null;
        Token DW = DW(1);
        AST j6 = this.aM.j6(DW(1));
        this.aM.DW(aSTPair, j6);
        FH(87);
        if (j6(1) == 89 && sy.Hw(j6(2))) {
            BT();
            this.aM.j6(aSTPair, this.XL);
        } else if (j6(1) == 89 && j6(2) == 100) {
            KD();
            this.aM.j6(aSTPair, this.XL);
        } else if (!lp.Hw(j6(1))) {
            throw new NoViableAltException(DW(1), v5());
        }
        while (j6(1) == 90 && j6(2) == 87) {
            this.aM.j6(DW(1));
            FH(90);
            AST j62 = this.aM.j6(DW(1));
            FH(87);
            switch (j6(1)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
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
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
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
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 153:
                case 157:
                case 158:
                case 159:
                case 160:
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 190:
                case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                case 195:
                case 196:
                case 197:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                case 205:
                    break;
                case 89:
                    BT();
                    ast = this.XL;
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
            if (this.Ws.DW == 0) {
                j6 = this.aM.j6(new ASTArray(4).j6(j6(90, ".", DW, DW(1))).j6(j6).j6(j62).j6(ast));
            }
        }
        if (this.Ws.DW == 0) {
            ast = aSTPair.j6;
            if (z) {
                j6 = this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", DW, DW(1))).j6(j6));
            }
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void VH(AST ast) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (this.Ws.DW == 0) {
            AST ast2 = aSTPair.j6;
            aSTPair.j6 = ast;
            ast2 = (ast == null || ast.j6() == null) ? ast : ast.j6();
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        while (j6(1) == 85 && j6(2) == 86) {
            FH(85);
            FH(86);
            if (this.Ws.DW == 0) {
                ast2 = this.aM.j6(new ASTArray(2).j6(j6(17, "[", ast, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = ast2;
                if (!(ast2 == null || ast2.j6() == null)) {
                    ast2 = ast2.j6();
                }
                aSTPair.DW = ast2;
                aSTPair.j6();
            }
        }
        this.XL = aSTPair.j6;
    }

    public final void KD() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(89);
        FH(100);
        gn();
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(70, "TYPE_ARGUMENTS", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void ro() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 87:
                DW(true);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                v5(true);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void v5(boolean z) {
        boolean z2;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        yS();
        AST ast = this.XL;
        if (lp.Hw(j6(1)) && gn.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                FH(85);
                int i = 1;
            } catch (RecognitionException e) {
                z2 = false;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            z2 = false;
        }
        if (i != 0) {
            VH(ast);
            this.aM.j6(aSTPair, this.XL);
        } else if (!lp.Hw(j6(1)) || !gn.Hw(j6(2))) {
            throw new NoViableAltException(DW(1), v5());
        } else if (this.Ws.DW == 0) {
            j6(false, "primitive type parameters not allowed here", "use the corresponding wrapper type, such as Integer for int");
        }
        if (this.Ws.DW == 0) {
            AST ast2 = aSTPair.j6;
            if (z) {
                ast2 = this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", DW, DW(1))).j6(ast2));
            }
            aSTPair.j6 = ast2;
            if (!(ast2 == null || ast2.j6() == null)) {
                ast2 = ast2.j6();
            }
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void cn() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        switch (j6(1)) {
            case 87:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                ro();
                this.aM.j6(aSTPair, this.XL);
                break;
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                sh();
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(71, "TYPE_ARGUMENT", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void sh() {
        int i = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
        FH(97);
        if ((j6(1) == 98 || j6(1) == 99) && (j6(2) == 87 || j6(2) == 205)) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                switch (j6(1)) {
                    case 98:
                        FH(98);
                        break;
                    case 99:
                        FH(99);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                i = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            cb();
            this.aM.j6(aSTPair, this.XL);
        } else if (!(lp.Hw(j6(1)) && gn.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            aSTPair.j6.j6(74);
        }
        this.XL = aSTPair.j6;
    }

    public final void cb() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        boolean z = false;
        switch (j6(1)) {
            case 98:
                FH(98);
                if (this.Ws.DW == 0) {
                    z = true;
                    break;
                }
                break;
            case 99:
                FH(99);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        gn();
        Hw(true);
        this.aM.j6(aSTPair, this.XL);
        gn();
        if (this.Ws.DW == 0) {
            AST j6;
            AST ast = aSTPair.j6;
            if (z) {
                j6 = this.aM.j6(new ASTArray(2).j6(j6(75, "TYPE_UPPER_BOUNDS", DW, DW(1))).j6(ast));
            } else {
                j6 = this.aM.j6(new ASTArray(2).j6(j6(76, "TYPE_LOWER_BOUNDS", DW, DW(1))).j6(ast));
            }
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    protected final void dx() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 100:
                FH(100);
                if (this.Ws.DW == 0) {
                    this.hp--;
                }
                ast = aSTPair.j6;
                break;
            case 102:
                FH(102);
                if (this.Ws.DW == 0) {
                    this.hp -= 2;
                }
                ast = aSTPair.j6;
                break;
            case 103:
                FH(103);
                if (this.Ws.DW == 0) {
                    this.hp -= 3;
                }
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void sG() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 87:
                Hw(false);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                yS();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ef() {
        /*
        r9 = this;
        r8 = 84;
        r7 = 2;
        r0 = 0;
        r6 = 96;
        r5 = 1;
        r1 = 0;
        r9.XL = r1;
        r3 = new groovyjarjarantlr.ASTPair;
        r3.<init>();
        r1 = r0;
    L_0x0010:
        r2 = r9.j6(r5);
        if (r2 != r8) goto L_0x0025;
    L_0x0016:
        r2 = r1 + 1;
        if (r1 != 0) goto L_0x0024;
    L_0x001a:
        r9.FH(r8);
        r9.gn();
        r1 = r2;
    L_0x0021:
        r0 = r0 + 1;
        goto L_0x0010;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        r2 = XG;
        r4 = r9.j6(r5);
        r2 = r2.Hw(r4);
        if (r2 == 0) goto L_0x003f;
    L_0x0031:
        r9.lg();
        r2 = r9.aM;
        r4 = r9.XL;
        r2.j6(r3, r4);
        r9.gn();
        goto L_0x0021;
    L_0x003f:
        r2 = r9.j6(r5);
        if (r2 != r6) goto L_0x007f;
    L_0x0045:
        r2 = r9.j6(r7);
        r4 = 93;
        if (r2 != r4) goto L_0x007f;
    L_0x004d:
        r2 = r9.Ws;
        r2 = r2.DW;
        if (r2 != 0) goto L_0x0058;
    L_0x0053:
        r0 = r3.j6;
        r9.XL = r0;
        return;
    L_0x0058:
        r2 = r9.aM;
        r4 = r9.DW(r5);
        r2 = r2.j6(r4);
        r4 = r9.aM;
        r4.j6(r3, r2);
        r9.FH(r6);
        r2 = r9.aM;
        r4 = r9.DW(r5);
        r2 = r2.j6(r4);
        r4 = r9.aM;
        r4.j6(r3, r2);
        r2 = 93;
        r9.FH(r2);
        goto L_0x0021;
    L_0x007f:
        r2 = r9.j6(r5);
        if (r2 != r6) goto L_0x009b;
    L_0x0085:
        r2 = r9.j6(r7);
        r4 = 87;
        if (r2 != r4) goto L_0x009b;
    L_0x008d:
        r9.rN();
        r2 = r9.aM;
        r4 = r9.XL;
        r2.j6(r3, r4);
        r9.gn();
        goto L_0x0021;
    L_0x009b:
        if (r0 >= r5) goto L_0x0053;
    L_0x009d:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r9.DW(r5);
        r2 = r9.v5();
        r0.<init>(r1, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyRecognizer.ef():void");
    }

    public final void Sf() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (jJ.Hw(j6(1)) && wc.Hw(j6(2))) {
            g3();
            ast = this.XL;
            this.aM.j6(aSTPair, this.XL);
            if (this.Ws.DW == 0) {
                AST ast2 = aSTPair.j6;
                Token token = new Token(87, "value");
                ast = this.aM.j6(new ASTArray(3).j6(j6(67, "ANNOTATION_MEMBER_VALUE_PAIR", DW(1), DW(1))).j6(this.aM.j6(new ASTArray(1).j6(j6(87, "value", token, token)))).j6(ast));
                aSTPair.j6 = ast;
                if (!(ast == null || ast.j6() == null)) {
                    ast = ast.j6();
                }
                aSTPair.DW = ast;
                aSTPair.j6();
            }
            ast = aSTPair.j6;
        } else if (et.Hw(j6(1)) && j6(2) == 124) {
            Mz();
            this.aM.j6(aSTPair, this.XL);
            ast = aSTPair.j6;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void vJ() {
        /*
        r7 = this;
        r6 = 93;
        r5 = 2;
        r4 = 96;
        r3 = 1;
        r0 = 0;
        r7.XL = r0;
        r0 = new groovyjarjarantlr.ASTPair;
        r0.<init>();
    L_0x000e:
        r1 = r7.j6(r3);
        if (r1 != r4) goto L_0x004a;
    L_0x0014:
        r1 = r7.j6(r5);
        if (r1 != r6) goto L_0x004a;
    L_0x001a:
        r1 = r7.Ws;
        r1 = r1.DW;
        if (r1 != 0) goto L_0x0025;
    L_0x0020:
        r0 = r0.j6;
        r7.XL = r0;
        return;
    L_0x0025:
        r1 = r7.aM;
        r2 = r7.DW(r3);
        r1 = r1.j6(r2);
        r2 = r7.aM;
        r2.j6(r0, r1);
        r7.FH(r4);
        r1 = r7.aM;
        r2 = r7.DW(r3);
        r1 = r1.j6(r2);
        r2 = r7.aM;
        r2.j6(r0, r1);
        r7.FH(r6);
        goto L_0x000e;
    L_0x004a:
        r1 = r7.j6(r3);
        if (r1 != r4) goto L_0x0020;
    L_0x0050:
        r1 = r7.j6(r5);
        r2 = 87;
        if (r1 != r2) goto L_0x0020;
    L_0x0058:
        r7.rN();
        r1 = r7.aM;
        r2 = r7.XL;
        r1.j6(r0, r2);
        r7.gn();
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyRecognizer.vJ():void");
    }

    public final void g3() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 85:
            case 87:
            case 88:
            case 91:
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
            case 126:
            case 132:
            case 148:
            case 149:
            case 157:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 190:
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                gn(0);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 96:
                rN();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void Mz() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        I();
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 101) {
            FH(101);
            gn();
            I();
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void I() {
        AST ast = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        ca();
        AST ast2 = this.XL;
        FH(124);
        gn();
        g3();
        AST ast3 = this.XL;
        if (this.Ws.DW == 0) {
            ast = aSTPair.j6;
            ast = this.aM.j6(new ASTArray(3).j6(j6(67, "ANNOTATION_MEMBER_VALUE_PAIR", DW, DW(1))).j6(ast2).j6(ast3));
            aSTPair.j6 = ast;
            AST j6 = (ast == null || ast.j6() == null) ? ast : ast.j6();
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = ast;
    }

    public final void ca() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
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
                x9();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 87:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(87);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void x9() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 38:
            case 39:
            case 43:
            case 83:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
                lg();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 40:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(40);
                break;
            case 41:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(41);
                break;
            case 42:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(42);
                break;
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(81);
                break;
            case 82:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(82);
                break;
            case 84:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(84);
                break;
            case 92:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(92);
                break;
            case 93:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(93);
                break;
            case 94:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(94);
                break;
            case 95:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(95);
                break;
            case 98:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(98);
                break;
            case 99:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(99);
                break;
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                yS();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 114:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(114);
                break;
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(ProxyTextView.INPUTTYPE_textPassword);
                break;
            case 130:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(130);
                break;
            case 131:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(131);
                break;
            case 132:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(132);
                break;
            case 137:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(137);
                break;
            case 138:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(138);
                break;
            case 139:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(139);
                break;
            case 140:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(140);
                break;
            case 141:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(141);
                break;
            case 142:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(142);
                break;
            case 143:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(143);
                break;
            case 144:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(144);
                break;
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(ProxyTextView.INPUTTYPE_textVisiblePassword);
                break;
            case 146:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(146);
                break;
            case 147:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(147);
                break;
            case 150:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(150);
                break;
            case 151:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(151);
                break;
            case 152:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(152);
                break;
            case 153:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(153);
                break;
            case 157:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(157);
                break;
            case 158:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(158);
                break;
            case 159:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(159);
                break;
            case 160:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(160);
                break;
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(ProxyTextView.INPUTTYPE_textWebEditText);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            aSTPair.j6.j6(87);
        }
        this.XL = aSTPair.j6;
    }

    public final void gn(int i) {
        int i2;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        QX(i);
        this.aM.j6(aSTPair, this.XL);
        if ((j6(1) == 174 || j6(1) == 205) && CU.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                gn();
                FH(174);
                i2 = 1;
            } catch (RecognitionException e) {
                i2 = 0;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            gn();
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(174);
            gn();
            gn(0);
            this.aM.j6(aSTPair, this.XL);
        } else {
            if ((j6(1) == 97 || j6(1) == 205) && Xa.Hw(j6(2))) {
                Zo = Zo();
                parserSharedInputState = this.Ws;
                parserSharedInputState.DW++;
                try {
                    gn();
                    FH(97);
                    i2 = 1;
                } catch (RecognitionException e2) {
                    i2 = 0;
                }
                v5(Zo);
                parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW--;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                gn();
                this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                FH(97);
                gn();
                u7(0);
                this.aM.j6(aSTPair, this.XL);
                gn();
                FH(136);
                gn();
                gn(0);
                this.aM.j6(aSTPair, this.XL);
            } else if (!(Eq.Hw(j6(1)) && hz.Hw(j6(2)))) {
                throw new NoViableAltException(DW(1), v5());
            }
        }
        this.XL = aSTPair.j6;
    }

    public final void Qq() {
        AST ast;
        AST ast2 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        switch (j6(1)) {
            case 98:
                FH(98);
                gn();
                Hw(false);
                ast = this.XL;
                gn();
                break;
            case 126:
            case 131:
                ast = null;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            ast2 = aSTPair.j6;
            ast2 = this.aM.j6(new ASTArray(2).j6(j6(18, "EXTENDS_CLAUSE", DW, DW(1))).j6(ast));
            aSTPair.j6 = ast2;
            ast = (ast2 == null || ast2.j6() == null) ? ast2 : ast2.j6();
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = ast2;
    }

    public final void sy() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        switch (j6(1)) {
            case 126:
            case 205:
                break;
            case 131:
                this.aM.j6(DW(1));
                FH(131);
                gn();
                Hw(true);
                this.aM.j6(aSTPair, this.XL);
                while (j6(1) == 101) {
                    FH(101);
                    gn();
                    Hw(true);
                    this.aM.j6(aSTPair, this.XL);
                }
                gn();
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(19, "IMPLEMENTS_CLAUSE", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void aj() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        switch (j6(1)) {
            case 38:
            case 39:
            case 43:
            case 83:
            case 84:
            case 87:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 126:
                XG();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 127:
            case 128:
            case 205:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        while (true) {
            if (j6(1) == 128 || j6(1) == 205) {
                EQ();
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 83:
                    case 84:
                    case 87:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 126:
                        XG();
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    case 127:
                    case 128:
                    case 205:
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            }
            FH(127);
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(6, "OBJBLOCK", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
    }

    public final void lp() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        switch (j6(1)) {
            case 98:
                this.aM.j6(DW(1));
                FH(98);
                gn();
                Hw(true);
                this.aM.j6(aSTPair, this.XL);
                while (j6(1) == 101) {
                    FH(101);
                    gn();
                    Hw(true);
                    this.aM.j6(aSTPair, this.XL);
                }
                gn();
                break;
            case 126:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(18, "EXTENDS_CLAUSE", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void OW() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        switch (j6(1)) {
            case 38:
            case 39:
            case 43:
            case 83:
            case 84:
            case 87:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
                jJ();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 127:
            case 128:
            case 205:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        while (true) {
            if (j6(1) == 128 || j6(1) == 205) {
                EQ();
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 83:
                    case 84:
                    case 87:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                        jJ();
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    case 127:
                    case 128:
                    case 205:
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            }
            FH(127);
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(6, "OBJBLOCK", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
    }

    public final void br() {
        int i = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        gn();
        if ((j6(1) == 87 || j6(1) == 96) && aq.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                et();
                i = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            CU();
            this.aM.j6(aSTPair, this.XL);
        } else if (FN.Hw(j6(1)) && jO.Hw(j6(2))) {
            switch (j6(1)) {
                case 38:
                case 39:
                case 43:
                case 83:
                case 84:
                case 87:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 126:
                    XG();
                    this.aM.j6(aSTPair, this.XL);
                    break;
                case 127:
                case 128:
                case 205:
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        while (true) {
            if (j6(1) == 128 || j6(1) == 205) {
                EQ();
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 83:
                    case 84:
                    case 87:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 126:
                        XG();
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    case 127:
                    case 128:
                    case 205:
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            }
            FH(127);
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(6, "OBJBLOCK", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
    }

    public final void XX() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        switch (j6(1)) {
            case 38:
            case 39:
            case 43:
            case 83:
            case 84:
            case 87:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
                wc();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 127:
            case 128:
            case 205:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        while (true) {
            if (j6(1) == 128 || j6(1) == 205) {
                EQ();
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 83:
                    case 84:
                    case 87:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                        wc();
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    case 127:
                    case 128:
                    case 205:
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            }
            FH(127);
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(6, "OBJBLOCK", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
    }

    public final void kQ() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
        FH(87);
        if (j6(1) == 98 && (j6(2) == 87 || j6(2) == 205)) {
            yO();
            this.aM.j6(aSTPair, this.XL);
        } else if (!(oY.Hw(j6(1)) && ko.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(73, "TYPE_PARAMETER", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void yO() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(98);
        gn();
        Hw(true);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 125) {
            FH(125);
            gn();
            Hw(true);
            this.aM.j6(aSTPair, this.XL);
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(75, "TYPE_UPPER_BOUNDS", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void XG() {
        int i;
        AST ast;
        int i2 = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        if (Ev.Hw(j6(1)) && ye.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                ei();
                i = 1;
            } catch (RecognitionException e) {
                i = 0;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            i = 0;
        }
        AST ast2;
        if (i != 0) {
            nw();
            gn(this.XL);
            ast = this.XL;
            if (this.Ws.DW == 0) {
                ast2 = aSTPair.j6;
                aSTPair.j6 = ast;
                ast2 = (ast == null || ast.j6() == null) ? ast : ast.j6();
                aSTPair.DW = ast2;
                aSTPair.j6();
            }
            ast = null;
        } else {
            if (rN.Hw(j6(1)) && er.Hw(j6(2))) {
                Zo = Zo();
                parserSharedInputState = this.Ws;
                parserSharedInputState.DW++;
                try {
                    P8();
                    i = 1;
                } catch (RecognitionException e2) {
                    i = 0;
                }
                v5(Zo);
                parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW--;
            } else {
                i = 0;
            }
            if (i != 0) {
                XL();
                ast = this.XL;
                if (this.Ws.DW == 0) {
                    ast2 = aSTPair.j6;
                    aSTPair.j6 = ast;
                    ast2 = (ast == null || ast.j6() == null) ? ast : ast.j6();
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast = null;
            } else {
                if (rN.Hw(j6(1)) && yS.Hw(j6(2))) {
                    Zo = Zo();
                    parserSharedInputState = this.Ws;
                    parserSharedInputState.DW++;
                    try {
                        ko();
                        i = 1;
                    } catch (RecognitionException e3) {
                        i = 0;
                    }
                    v5(Zo);
                    parserSharedInputState2 = this.Ws;
                    parserSharedInputState2.DW--;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    Ev();
                    ast = this.XL;
                    if (this.Ws.DW == 0) {
                        ast2 = aSTPair.j6;
                        aSTPair.j6 = ast;
                        ast2 = (ast == null || ast.j6() == null) ? ast : ast.j6();
                        aSTPair.DW = ast2;
                        aSTPair.j6();
                    }
                    ast = null;
                } else {
                    if (gW.Hw(j6(1)) && BT.Hw(j6(2))) {
                        Zo = Zo();
                        parserSharedInputState = this.Ws;
                        parserSharedInputState.DW++;
                        try {
                            a8();
                            i = 1;
                        } catch (RecognitionException e4) {
                            i = 0;
                        }
                        v5(Zo);
                        parserSharedInputState2 = this.Ws;
                        parserSharedInputState2.DW--;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        Ws();
                        ast = this.XL;
                        if (this.Ws.DW == 0) {
                            ast2 = aSTPair.j6;
                            aSTPair.j6 = ast;
                            ast2 = (ast == null || ast.j6() == null) ? ast : ast.j6();
                            aSTPair.DW = ast2;
                            aSTPair.j6();
                        }
                        ast = null;
                    } else {
                        if (SI.Hw(j6(1)) && KD.Hw(j6(2))) {
                            i = Zo();
                            parserSharedInputState2 = this.Ws;
                            parserSharedInputState2.DW++;
                            try {
                                SI();
                                i2 = 1;
                            } catch (RecognitionException e5) {
                            }
                            v5(i);
                            parserSharedInputState = this.Ws;
                            parserSharedInputState.DW--;
                        }
                        if (i2 != 0) {
                            nw();
                            j6(this.XL);
                            ast = this.XL;
                            if (this.Ws.DW == 0) {
                                ast2 = aSTPair.j6;
                                aSTPair.j6 = ast;
                                if (ast == null || ast.j6() == null) {
                                    ast2 = ast;
                                } else {
                                    ast2 = ast.j6();
                                }
                                aSTPair.DW = ast2;
                                aSTPair.j6();
                            }
                            ast = null;
                        } else if (j6(1) == 83 && (j6(2) == 126 || j6(2) == 205)) {
                            FH(83);
                            gn();
                            FN();
                            ast2 = this.XL;
                            if (this.Ws.DW == 0) {
                                r2 = aSTPair.j6;
                                ast = this.aM.j6(new ASTArray(2).j6(j6(11, "STATIC_INIT", DW, DW(1))).j6(ast2));
                                aSTPair.j6 = ast;
                                if (ast == null || ast.j6() == null) {
                                    ast2 = ast;
                                } else {
                                    ast2 = ast.j6();
                                }
                                aSTPair.DW = ast2;
                                aSTPair.j6();
                            }
                            ast = null;
                        } else if (j6(1) == 126) {
                            FN();
                            ast2 = this.XL;
                            if (this.Ws.DW == 0) {
                                r2 = aSTPair.j6;
                                ast = this.aM.j6(new ASTArray(2).j6(j6(10, "INSTANCE_INIT", DW, DW(1))).j6(ast2));
                                aSTPair.j6 = ast;
                                if (ast == null || ast.j6() == null) {
                                    ast2 = ast;
                                } else {
                                    ast2 = ast.j6();
                                }
                                aSTPair.DW = ast2;
                                aSTPair.j6();
                            }
                            ast = null;
                        } else {
                            throw new NoViableAltException(DW(1), v5());
                        }
                    }
                }
            }
        }
        this.XL = ast;
    }

    public final void jJ() {
        int i;
        AST ast;
        int i2 = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (gW.Hw(j6(1)) && BT.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                a8();
                i = 1;
            } catch (RecognitionException e) {
                i = 0;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            i = 0;
        }
        AST ast2;
        if (i != 0) {
            Ws();
            ast = this.XL;
            if (this.Ws.DW == 0) {
                ast2 = aSTPair.j6;
                aSTPair.j6 = ast;
                ast2 = (ast == null || ast.j6() == null) ? ast : ast.j6();
                aSTPair.DW = ast2;
                aSTPair.j6();
            }
            ast = null;
        } else {
            if (rN.Hw(j6(1)) && er.Hw(j6(2))) {
                Zo = Zo();
                parserSharedInputState = this.Ws;
                parserSharedInputState.DW++;
                try {
                    P8();
                    i = 1;
                } catch (RecognitionException e2) {
                    i = 0;
                }
                v5(Zo);
                parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW--;
            } else {
                i = 0;
            }
            if (i != 0) {
                XL();
                ast = this.XL;
                if (this.Ws.DW == 0) {
                    ast2 = aSTPair.j6;
                    aSTPair.j6 = ast;
                    ast2 = (ast == null || ast.j6() == null) ? ast : ast.j6();
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast = null;
            } else {
                if (SI.Hw(j6(1)) && KD.Hw(j6(2))) {
                    i = Zo();
                    parserSharedInputState2 = this.Ws;
                    parserSharedInputState2.DW++;
                    try {
                        SI();
                        i2 = 1;
                    } catch (RecognitionException e3) {
                    }
                    v5(i);
                    parserSharedInputState = this.Ws;
                    parserSharedInputState.DW--;
                }
                if (i2 != 0) {
                    nw();
                    j6(this.XL);
                    ast = this.XL;
                    if (this.Ws.DW == 0) {
                        ast2 = aSTPair.j6;
                        aSTPair.j6 = ast;
                        if (ast == null || ast.j6() == null) {
                            ast2 = ast;
                        } else {
                            ast2 = ast.j6();
                        }
                        aSTPair.DW = ast2;
                        aSTPair.j6();
                    }
                    ast = null;
                } else {
                    throw new NoViableAltException(DW(1), v5());
                }
            }
        }
        this.XL = ast;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void wc() {
        /*
        r14 = this;
        r13 = 91;
        r12 = 2;
        r0 = 0;
        r11 = 87;
        r1 = 1;
        r2 = 0;
        r14.XL = r2;
        r4 = new groovyjarjarantlr.ASTPair;
        r4.<init>();
        r3 = 0;
        r2 = 0;
        r5 = r14.DW(r1);
        r14.nw();
        r6 = r14.XL;
        r7 = r14.j6(r1);
        switch(r7) {
            case 87: goto L_0x0054;
            case 88: goto L_0x0021;
            case 89: goto L_0x0021;
            case 90: goto L_0x0021;
            case 91: goto L_0x0021;
            case 92: goto L_0x002f;
            case 93: goto L_0x002f;
            case 94: goto L_0x002f;
            case 95: goto L_0x002f;
            case 96: goto L_0x002f;
            case 97: goto L_0x0021;
            case 98: goto L_0x0021;
            case 99: goto L_0x0021;
            case 100: goto L_0x0021;
            case 101: goto L_0x0021;
            case 102: goto L_0x0021;
            case 103: goto L_0x0021;
            case 104: goto L_0x0054;
            case 105: goto L_0x0054;
            case 106: goto L_0x0054;
            case 107: goto L_0x0054;
            case 108: goto L_0x0054;
            case 109: goto L_0x0054;
            case 110: goto L_0x0054;
            case 111: goto L_0x0054;
            case 112: goto L_0x0054;
            default: goto L_0x0021;
        };
    L_0x0021:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r14.DW(r1);
        r2 = r14.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x002f:
        r14.j6(r6);
        r1 = r14.XL;
        r0 = r14.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x017d;
    L_0x003a:
        r0 = r4.j6;
        r4.j6 = r1;
        if (r1 == 0) goto L_0x0052;
    L_0x0040:
        r0 = r1.j6();
        if (r0 == 0) goto L_0x0052;
    L_0x0046:
        r0 = r1.j6();
    L_0x004a:
        r4.DW = r0;
        r4.j6();
    L_0x004f:
        r14.XL = r1;
        return;
    L_0x0052:
        r0 = r1;
        goto L_0x004a;
    L_0x0054:
        r14.j6(r0);
        r7 = r14.XL;
        r8 = r14.j6(r1);
        if (r8 != r11) goto L_0x0087;
    L_0x005f:
        r8 = r14.j6(r12);
        if (r8 != r13) goto L_0x0087;
    L_0x0065:
        r8 = r14.Zo();
        r9 = r14.Ws;
        r10 = r9.DW;
        r10 = r10 + 1;
        r9.DW = r10;
        r9 = 87;
        r14.FH(r9);	 Catch:{ RecognitionException -> 0x017a }
        r9 = 91;
        r14.FH(r9);	 Catch:{ RecognitionException -> 0x017a }
        r0 = r1;
    L_0x007c:
        r14.v5(r8);
        r8 = r14.Ws;
        r9 = r8.DW;
        r9 = r9 + -1;
        r8.DW = r9;
    L_0x0087:
        if (r0 == 0) goto L_0x012e;
    L_0x0089:
        r0 = r14.DW(r1);
        r8 = r14.aM;
        r8 = r8.j6(r0);
        r14.FH(r11);
        r14.FH(r13);
        r0 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r14.FH(r0);
        r0 = r14.j6(r1);
        switch(r0) {
            case 127: goto L_0x012a;
            case 128: goto L_0x012a;
            case 129: goto L_0x00b3;
            case 205: goto L_0x012a;
            default: goto L_0x00a5;
        };
    L_0x00a5:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r14.DW(r1);
        r2 = r14.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x00b3:
        r0 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        r14.FH(r0);
        r14.gn();
        r14.g3();
        r0 = r14.XL;
    L_0x00c0:
        r2 = r14.Ws;
        r2 = r2.DW;
        if (r2 != 0) goto L_0x017d;
    L_0x00c6:
        r2 = r4.j6;
        r2 = r14.aM;
        r3 = new groovyjarjarantlr.collections.impl.ASTArray;
        r9 = 5;
        r3.<init>(r9);
        r9 = 68;
        r10 = "ANNOTATION_FIELD_DEF";
        r11 = r14.DW(r1);
        r9 = r14.j6(r9, r10, r5, r11);
        r3 = r3.j6(r9);
        r3 = r3.j6(r6);
        r6 = r14.aM;
        r9 = new groovyjarjarantlr.collections.impl.ASTArray;
        r9.<init>(r12);
        r10 = 12;
        r11 = "TYPE";
        r1 = r14.DW(r1);
        r1 = r14.j6(r10, r11, r5, r1);
        r1 = r9.j6(r1);
        r1 = r1.j6(r7);
        r1 = r6.j6(r1);
        r1 = r3.j6(r1);
        r1 = r1.j6(r8);
        r0 = r1.j6(r0);
        r1 = r2.j6(r0);
        r4.j6 = r1;
        if (r1 == 0) goto L_0x012c;
    L_0x0119:
        r0 = r1.j6();
        if (r0 == 0) goto L_0x012c;
    L_0x011f:
        r0 = r1.j6();
    L_0x0123:
        r4.DW = r0;
        r4.j6();
        goto L_0x004f;
    L_0x012a:
        r0 = r2;
        goto L_0x00c0;
    L_0x012c:
        r0 = r1;
        goto L_0x0123;
    L_0x012e:
        r0 = r14.j6(r1);
        if (r0 == r11) goto L_0x013c;
    L_0x0134:
        r0 = r14.j6(r1);
        r2 = 88;
        if (r0 != r2) goto L_0x016c;
    L_0x013c:
        r0 = WB;
        r2 = r14.j6(r12);
        r0 = r0.Hw(r2);
        if (r0 == 0) goto L_0x016c;
    L_0x0148:
        r14.j6(r6, r7);
        r1 = r14.XL;
        r0 = r14.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x017d;
    L_0x0153:
        r0 = r4.j6;
        r4.j6 = r1;
        if (r1 == 0) goto L_0x016a;
    L_0x0159:
        r0 = r1.j6();
        if (r0 == 0) goto L_0x016a;
    L_0x015f:
        r0 = r1.j6();
    L_0x0163:
        r4.DW = r0;
        r4.j6();
        goto L_0x004f;
    L_0x016a:
        r0 = r1;
        goto L_0x0163;
    L_0x016c:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r14.DW(r1);
        r2 = r14.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x017a:
        r9 = move-exception;
        goto L_0x007c;
    L_0x017d:
        r1 = r3;
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyRecognizer.wc():void");
    }

    public final void et() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        u7();
        this.aM.j6(aSTPair, this.XL);
        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
        FH(87);
        switch (j6(1)) {
            case 38:
            case 39:
            case 43:
            case 83:
            case 84:
            case 87:
            case 96:
            case 101:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 127:
            case 128:
            case 205:
                gn();
                this.aM.j6(aSTPair, this.XL);
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 83:
                    case 84:
                    case 87:
                    case 96:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                        a8();
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    case 101:
                        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                        FH(101);
                        break;
                    case 127:
                        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                        FH(127);
                        break;
                    case 128:
                        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                        FH(128);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            case 91:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(91);
                break;
            case 126:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(126);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void CU() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Xa();
        this.aM.j6(aSTPair, this.XL);
        while (true) {
            int i;
            if (mb.Hw(j6(1)) && jw.Hw(j6(2))) {
                int Zo = Zo();
                ParserSharedInputState parserSharedInputState = this.Ws;
                parserSharedInputState.DW++;
                try {
                    gn();
                    switch (j6(1)) {
                        case 38:
                        case 39:
                        case 43:
                        case 83:
                        case 84:
                        case 87:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 110:
                        case 111:
                        case 112:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        case 126:
                            XG();
                            break;
                        case 127:
                            FH(127);
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                    i = 1;
                } catch (RecognitionException e) {
                    i = 0;
                }
                v5(Zo);
                ParserSharedInputState parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW--;
            } else {
                i = 0;
            }
            if (i != 0) {
                if (this.Ws.DW == 0) {
                }
            } else if ((j6(1) == 101 || j6(1) == 205) && fY.Hw(j6(2))) {
                gn();
                FH(101);
                if (mb.Hw(j6(1)) && jw.Hw(j6(2))) {
                    Zo = Zo();
                    parserSharedInputState = this.Ws;
                    parserSharedInputState.DW++;
                    try {
                        gn();
                        switch (j6(1)) {
                            case 38:
                            case 39:
                            case 43:
                            case 83:
                            case 84:
                            case 87:
                            case 92:
                            case 93:
                            case 94:
                            case 95:
                            case 96:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                            case 108:
                            case 109:
                            case 110:
                            case 111:
                            case 112:
                            case 115:
                            case 116:
                            case 117:
                            case 118:
                            case 119:
                            case 120:
                            case 121:
                            case 122:
                            case 126:
                                XG();
                                break;
                            case 127:
                                FH(127);
                                break;
                            default:
                                throw new NoViableAltException(DW(1), v5());
                        }
                        i = 1;
                    } catch (RecognitionException e2) {
                        i = 0;
                    }
                    v5(Zo);
                    parserSharedInputState2 = this.Ws;
                    parserSharedInputState2.DW--;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    if (qp.Hw(j6(1)) && k2.Hw(j6(2))) {
                        Zo = Zo();
                        parserSharedInputState = this.Ws;
                        parserSharedInputState.DW++;
                        try {
                            gn();
                            u7();
                            FH(87);
                            i = 1;
                        } catch (RecognitionException e3) {
                            i = 0;
                        }
                        v5(Zo);
                        parserSharedInputState2 = this.Ws;
                        parserSharedInputState2.DW--;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        gn();
                        Xa();
                        this.aM.j6(aSTPair, this.XL);
                    } else {
                        throw new NoViableAltException(DW(1), v5());
                    }
                } else if (this.Ws.DW == 0) {
                }
            }
            this.XL = aSTPair.j6;
            return;
        }
    }

    public final void Xa() {
        AST ast;
        AST ast2;
        AST ast3 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        u7();
        AST ast4 = this.XL;
        AST j6 = this.aM.j6(DW(1));
        FH(87);
        switch (j6(1)) {
            case 91:
                FH(91);
                Eq();
                ast = this.XL;
                FH(123);
                break;
            case 101:
            case 126:
            case 127:
            case 128:
            case 205:
                ast = null;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        switch (j6(1)) {
            case 101:
            case 127:
            case 128:
            case 205:
                ast2 = null;
                break;
            case 126:
                hz();
                ast2 = this.XL;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            ast3 = aSTPair.j6;
            ast3 = this.aM.j6(new ASTArray(5).j6(j6(62, "ENUM_CONSTANT_DEF", DW, DW(1))).j6(ast4).j6(j6).j6(ast).j6(ast2));
            aSTPair.j6 = ast3;
            ast = (ast3 == null || ast3.j6() == null) ? ast3 : ast3.j6();
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = ast3;
    }

    public final void Eq() {
        int Pa;
        boolean z = true;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        Token token = null;
        AST j6;
        switch (j6(1)) {
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
            case 85:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
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
            case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 126:
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
            case 148:
            case 149:
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
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                Pa = Pa();
                this.aM.j6(aSTPair, this.XL);
                switch (j6(1)) {
                    case 86:
                    case 101:
                    case 123:
                        int i = Pa;
                        boolean z2 = false;
                        while (j6(1) == 101) {
                            if (this.Ws.DW == 0) {
                                token = DW(1);
                            }
                            FH(101);
                            switch (j6(1)) {
                                case 38:
                                case 39:
                                case 40:
                                case 41:
                                case 42:
                                case 43:
                                case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 87:
                                case 88:
                                case 91:
                                case 92:
                                case 93:
                                case 94:
                                case 95:
                                case 96:
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
                                case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                                case 114:
                                case 115:
                                case 116:
                                case 117:
                                case 118:
                                case 119:
                                case 120:
                                case 121:
                                case 122:
                                case 126:
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
                                case 148:
                                case 149:
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
                                case 195:
                                case 196:
                                case 197:
                                case 199:
                                case 200:
                                case 201:
                                case 202:
                                case 203:
                                case 204:
                                    byte Pa2 = Pa();
                                    this.aM.j6(aSTPair, this.XL);
                                    if (this.Ws.DW != 0) {
                                        break;
                                    }
                                    i |= Pa2;
                                    break;
                                case 86:
                                case 101:
                                case 123:
                                    if (this.Ws.DW == 0) {
                                        if (!z2) {
                                            z2 = true;
                                            break;
                                        }
                                        throw new NoViableAltException(token, v5());
                                    }
                                    continue;
                                default:
                                    throw new NoViableAltException(DW(1), v5());
                            }
                        }
                        if (this.Ws.DW != 0) {
                            Pa = i;
                            break;
                        }
                        j6 = this.aM.j6(new ASTArray(2).j6(j6(33, "ELIST", DW, DW(1))).j6(aSTPair.j6));
                        aSTPair.j6 = j6;
                        if (!(j6 == null || j6.j6() == null)) {
                            j6 = j6.j6();
                        }
                        aSTPair.DW = j6;
                        aSTPair.j6();
                        Pa = i;
                        break;
                    case 128:
                        int i2 = 0;
                        while (j6(1) == 128) {
                            FH(128);
                            if (this.Ws.DW == 0) {
                            }
                            switch (j6(1)) {
                                case 38:
                                case 39:
                                case 43:
                                case 83:
                                case 84:
                                case 85:
                                case 87:
                                case 88:
                                case 91:
                                case 96:
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
                                case 115:
                                case 116:
                                case 117:
                                case 118:
                                case 119:
                                case 120:
                                case 121:
                                case 122:
                                case 126:
                                case 132:
                                case 143:
                                case 144:
                                case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                                case 146:
                                case 147:
                                case 148:
                                case 149:
                                case 157:
                                case 159:
                                case 160:
                                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                                case 190:
                                case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                                case 195:
                                case 196:
                                case 197:
                                case 199:
                                case 200:
                                case 201:
                                case 202:
                                case 203:
                                case 204:
                                    VH(true);
                                    this.aM.j6(aSTPair, this.XL);
                                    break;
                                case 86:
                                case 123:
                                case 128:
                                    if (this.Ws.DW != 0) {
                                        break;
                                    }
                                    this.aM.j6(aSTPair, this.aM.j6(37, "EMPTY_STAT"));
                                    break;
                                default:
                                    throw new NoViableAltException(DW(1), v5());
                            }
                            i2++;
                        }
                        if (i2 >= 1) {
                            if (this.Ws.DW == 0) {
                                j6 = this.aM.j6(new ASTArray(2).j6(j6(77, "CLOSURE_LIST", DW, DW(1))).j6(aSTPair.j6));
                                aSTPair.j6 = j6;
                                if (!(j6 == null || j6.j6() == null)) {
                                    j6 = j6.j6();
                                }
                                aSTPair.DW = j6;
                                aSTPair.j6();
                                break;
                            }
                        }
                        throw new NoViableAltException(DW(1), v5());
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            case 86:
            case 123:
                if (this.Ws.DW != 0) {
                    Pa = 0;
                    break;
                }
                j6 = aSTPair.j6;
                j6 = j6(33, "ELIST", DW, DW(1));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
                Pa = 0;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            if ((Pa & 1) == 0) {
                z = false;
            }
            this.Lz = z;
        }
        this.XL = aSTPair.j6;
    }

    public final void hz() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        switch (j6(1)) {
            case 38:
            case 39:
            case 43:
            case 83:
            case 84:
            case 87:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 126:
                aq();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 127:
            case 128:
            case 205:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        while (true) {
            if (j6(1) == 128 || j6(1) == 205) {
                EQ();
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 83:
                    case 84:
                    case 87:
                    case 89:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 126:
                        aq();
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    case 127:
                    case 128:
                    case 205:
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            }
            FH(127);
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(6, "OBJBLOCK", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aq() {
        /*
        r10 = this;
        r3 = 0;
        r9 = 2;
        r2 = 0;
        r1 = 1;
        r10.XL = r3;
        r4 = new groovyjarjarantlr.ASTPair;
        r4.<init>();
        r5 = r10.DW(r1);
        r0 = r10.j6(r1);
        switch(r0) {
            case 38: goto L_0x0024;
            case 39: goto L_0x0024;
            case 43: goto L_0x0024;
            case 83: goto L_0x0024;
            case 84: goto L_0x0024;
            case 87: goto L_0x0024;
            case 89: goto L_0x0024;
            case 92: goto L_0x0024;
            case 93: goto L_0x0024;
            case 94: goto L_0x0024;
            case 95: goto L_0x0024;
            case 96: goto L_0x0024;
            case 104: goto L_0x0024;
            case 105: goto L_0x0024;
            case 106: goto L_0x0024;
            case 107: goto L_0x0024;
            case 108: goto L_0x0024;
            case 109: goto L_0x0024;
            case 110: goto L_0x0024;
            case 111: goto L_0x0024;
            case 112: goto L_0x0024;
            case 115: goto L_0x0024;
            case 116: goto L_0x0024;
            case 117: goto L_0x0024;
            case 118: goto L_0x0024;
            case 119: goto L_0x0024;
            case 120: goto L_0x0024;
            case 121: goto L_0x0024;
            case 122: goto L_0x0024;
            case 126: goto L_0x01bc;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r10.DW(r1);
        r2 = r10.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x0024:
        r0 = SI;
        r6 = r10.j6(r1);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x0206;
    L_0x0030:
        r0 = KD;
        r6 = r10.j6(r9);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x0206;
    L_0x003c:
        r6 = r10.Zo();
        r0 = r10.Ws;
        r7 = r0.DW;
        r7 = r7 + 1;
        r0.DW = r7;
        r10.SI();	 Catch:{ RecognitionException -> 0x0081 }
        r0 = r1;
    L_0x004c:
        r10.v5(r6);
        r6 = r10.Ws;
        r7 = r6.DW;
        r7 = r7 + -1;
        r6.DW = r7;
    L_0x0057:
        if (r0 == 0) goto L_0x0086;
    L_0x0059:
        r10.nw();
        r0 = r10.XL;
        r10.j6(r0);
        r1 = r10.XL;
        r0 = r10.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x0200;
    L_0x0069:
        r0 = r4.j6;
        r4.j6 = r1;
        if (r1 == 0) goto L_0x0084;
    L_0x006f:
        r0 = r1.j6();
        if (r0 == 0) goto L_0x0084;
    L_0x0075:
        r0 = r1.j6();
    L_0x0079:
        r4.DW = r0;
        r4.j6();
    L_0x007e:
        r10.XL = r1;
        return;
    L_0x0081:
        r0 = move-exception;
        r0 = r2;
        goto L_0x004c;
    L_0x0084:
        r0 = r1;
        goto L_0x0079;
    L_0x0086:
        r0 = rN;
        r6 = r10.j6(r1);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x0203;
    L_0x0092:
        r0 = zh;
        r6 = r10.j6(r9);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x0203;
    L_0x009e:
        r6 = r10.Zo();
        r0 = r10.Ws;
        r7 = r0.DW;
        r7 = r7 + 1;
        r0.DW = r7;
        r10.QX();	 Catch:{ RecognitionException -> 0x00d5 }
        r0 = r1;
    L_0x00ae:
        r10.v5(r6);
        r6 = r10.Ws;
        r7 = r6.DW;
        r7 = r7 + -1;
        r6.DW = r7;
    L_0x00b9:
        if (r0 == 0) goto L_0x014c;
    L_0x00bb:
        r10.QX();
        r6 = r10.XL;
        r0 = r10.j6(r1);
        switch(r0) {
            case 87: goto L_0x011c;
            case 88: goto L_0x011c;
            case 89: goto L_0x00d8;
            case 90: goto L_0x00c7;
            case 91: goto L_0x00c7;
            case 92: goto L_0x00c7;
            case 93: goto L_0x00c7;
            case 94: goto L_0x00c7;
            case 95: goto L_0x00c7;
            case 96: goto L_0x00c7;
            case 97: goto L_0x00c7;
            case 98: goto L_0x00c7;
            case 99: goto L_0x00c7;
            case 100: goto L_0x00c7;
            case 101: goto L_0x00c7;
            case 102: goto L_0x00c7;
            case 103: goto L_0x00c7;
            case 104: goto L_0x011c;
            case 105: goto L_0x011c;
            case 106: goto L_0x011c;
            case 107: goto L_0x011c;
            case 108: goto L_0x011c;
            case 109: goto L_0x011c;
            case 110: goto L_0x011c;
            case 111: goto L_0x011c;
            case 112: goto L_0x011c;
            default: goto L_0x00c7;
        };
    L_0x00c7:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r10.DW(r1);
        r2 = r10.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x00d5:
        r0 = move-exception;
        r0 = r2;
        goto L_0x00ae;
    L_0x00d8:
        r10.aM();
        r0 = r10.XL;
    L_0x00dd:
        r7 = cn;
        r8 = r10.j6(r1);
        r7 = r7.Hw(r8);
        if (r7 == 0) goto L_0x011e;
    L_0x00e9:
        r7 = sh;
        r8 = r10.j6(r9);
        r7 = r7.Hw(r8);
        if (r7 == 0) goto L_0x011e;
    L_0x00f5:
        r10.j6(r2);
        r1 = r10.XL;
    L_0x00fa:
        r10.j6(r6, r0, r1, r5);
        r1 = r10.XL;
        r0 = r10.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x0200;
    L_0x0105:
        r0 = r4.j6;
        r4.j6 = r1;
        if (r1 == 0) goto L_0x014a;
    L_0x010b:
        r0 = r1.j6();
        if (r0 == 0) goto L_0x014a;
    L_0x0111:
        r0 = r1.j6();
    L_0x0115:
        r4.DW = r0;
        r4.j6();
        goto L_0x007e;
    L_0x011c:
        r0 = r3;
        goto L_0x00dd;
    L_0x011e:
        r2 = r10.j6(r1);
        r7 = 87;
        if (r2 == r7) goto L_0x012e;
    L_0x0126:
        r2 = r10.j6(r1);
        r7 = 88;
        if (r2 != r7) goto L_0x013c;
    L_0x012e:
        r2 = WB;
        r7 = r10.j6(r9);
        r2 = r2.Hw(r7);
        if (r2 == 0) goto L_0x013c;
    L_0x013a:
        r1 = r3;
        goto L_0x00fa;
    L_0x013c:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r10.DW(r1);
        r2 = r10.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x014a:
        r0 = r1;
        goto L_0x0115;
    L_0x014c:
        r0 = AL;
        r6 = r10.j6(r1);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x01ae;
    L_0x0158:
        r0 = BT;
        r6 = r10.j6(r9);
        r0 = r0.Hw(r6);
        if (r0 == 0) goto L_0x01ae;
    L_0x0164:
        r10.nw();
        r6 = r10.XL;
        r0 = r10.j6(r1);
        switch(r0) {
            case 87: goto L_0x01aa;
            case 88: goto L_0x0170;
            case 89: goto L_0x017e;
            case 90: goto L_0x0170;
            case 91: goto L_0x0170;
            case 92: goto L_0x0170;
            case 93: goto L_0x0170;
            case 94: goto L_0x0170;
            case 95: goto L_0x0170;
            case 96: goto L_0x0170;
            case 97: goto L_0x0170;
            case 98: goto L_0x0170;
            case 99: goto L_0x0170;
            case 100: goto L_0x0170;
            case 101: goto L_0x0170;
            case 102: goto L_0x0170;
            case 103: goto L_0x0170;
            case 104: goto L_0x01aa;
            case 105: goto L_0x01aa;
            case 106: goto L_0x01aa;
            case 107: goto L_0x01aa;
            case 108: goto L_0x01aa;
            case 109: goto L_0x01aa;
            case 110: goto L_0x01aa;
            case 111: goto L_0x01aa;
            case 112: goto L_0x01aa;
            default: goto L_0x0170;
        };
    L_0x0170:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r10.DW(r1);
        r2 = r10.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x017e:
        r10.aM();
        r0 = r10.XL;
    L_0x0183:
        r10.j6(r2);
        r1 = r10.XL;
        r10.j6(r6, r0, r1, r5);
        r1 = r10.XL;
        r0 = r10.Ws;
        r0 = r0.DW;
        if (r0 != 0) goto L_0x0200;
    L_0x0193:
        r0 = r4.j6;
        r4.j6 = r1;
        if (r1 == 0) goto L_0x01ac;
    L_0x0199:
        r0 = r1.j6();
        if (r0 == 0) goto L_0x01ac;
    L_0x019f:
        r0 = r1.j6();
    L_0x01a3:
        r4.DW = r0;
        r4.j6();
        goto L_0x007e;
    L_0x01aa:
        r0 = r3;
        goto L_0x0183;
    L_0x01ac:
        r0 = r1;
        goto L_0x01a3;
    L_0x01ae:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r10.DW(r1);
        r2 = r10.v5();
        r0.<init>(r1, r2);
        throw r0;
    L_0x01bc:
        r10.FN();
        r0 = r10.XL;
        r2 = r10.Ws;
        r2 = r2.DW;
        if (r2 != 0) goto L_0x0200;
    L_0x01c7:
        r2 = r4.j6;
        r2 = r10.aM;
        r3 = new groovyjarjarantlr.collections.impl.ASTArray;
        r3.<init>(r9);
        r6 = 10;
        r7 = "INSTANCE_INIT";
        r1 = r10.DW(r1);
        r1 = r10.j6(r6, r7, r5, r1);
        r1 = r3.j6(r1);
        r0 = r1.j6(r0);
        r1 = r2.j6(r0);
        r4.j6 = r1;
        if (r1 == 0) goto L_0x01fe;
    L_0x01ed:
        r0 = r1.j6();
        if (r0 == 0) goto L_0x01fe;
    L_0x01f3:
        r0 = r1.j6();
    L_0x01f7:
        r4.DW = r0;
        r4.j6();
        goto L_0x007e;
    L_0x01fe:
        r0 = r1;
        goto L_0x01f7;
    L_0x0200:
        r1 = r3;
        goto L_0x007e;
    L_0x0203:
        r0 = r2;
        goto L_0x00b9;
    L_0x0206:
        r0 = r2;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyRecognizer.aq():void");
    }

    protected final void j6(AST ast, AST ast2, AST ast3, Token token) {
        AST ast4;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Object obj = null;
        if (j6(1) == 87 && j6(2) == 91) {
            int Zo = Zo();
            obj = 1;
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                FH(87);
                FH(91);
            } catch (RecognitionException e) {
                obj = null;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        AST ast5;
        if (obj != null) {
            AST j6 = this.aM.j6(DW(1));
            FH(87);
            FH(91);
            jO();
            AST ast6 = this.XL;
            FH(123);
            obj = null;
            if ((j6(1) == 130 || j6(1) == 205) && sG.Hw(j6(2))) {
                int Zo2 = Zo();
                obj = 1;
                ParserSharedInputState parserSharedInputState3 = this.Ws;
                parserSharedInputState3.DW++;
                try {
                    gn();
                    FH(130);
                } catch (RecognitionException e2) {
                    obj = null;
                }
                v5(Zo2);
                ParserSharedInputState parserSharedInputState4 = this.Ws;
                parserSharedInputState4.DW--;
            }
            if (obj != null) {
                oY();
                ast5 = this.XL;
            } else if (w9.Hw(j6(1)) && hK.Hw(j6(2))) {
                ast5 = null;
            } else {
                throw new NoViableAltException(DW(1), v5());
            }
            switch (j6(1)) {
                case 126:
                    FN();
                    ast4 = this.XL;
                    break;
                case 127:
                case 128:
                case 205:
                    ast4 = null;
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
            if (this.Ws.DW == 0) {
                AST ast7 = aSTPair.j6;
                ast4 = this.aM.j6(new ASTArray(7).j6(j6(8, "METHOD_DEF", token, DW(1))).j6(ast).j6(this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", token, DW(1))).j6(ast3))).j6(j6).j6(ast6).j6(ast5).j6(ast4));
                if (ast2 != null) {
                    ast5 = ast4.j6();
                    ast4.FH(ast2);
                    ast2.Hw(ast5);
                }
                aSTPair.j6 = ast4;
                ast5 = (ast4 == null || ast4.j6() == null) ? ast4 : ast4.j6();
                aSTPair.DW = ast5;
                aSTPair.j6();
            }
            ast4 = null;
        } else if ((j6(1) == 87 || j6(1) == 88) && WB.Hw(j6(2))) {
            j6(ast, ast3);
            ast4 = this.XL;
            if (this.Ws.DW == 0) {
                ast5 = aSTPair.j6;
                aSTPair.j6 = ast4;
                if (ast4 == null || ast4.j6() == null) {
                    ast5 = ast4;
                } else {
                    ast5 = ast4.j6();
                }
                aSTPair.DW = ast5;
                aSTPair.j6();
            }
            ast4 = null;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast4;
    }

    public final void FN() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        jw();
        this.aM.j6(aSTPair, this.XL);
        this.XL = aSTPair.j6;
    }

    public final void jO() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        switch (j6(1)) {
            case 38:
            case 84:
            case 87:
            case 96:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 133:
                k2();
                this.aM.j6(aSTPair, this.XL);
                while (j6(1) == 101) {
                    FH(101);
                    gn();
                    k2();
                    this.aM.j6(aSTPair, this.XL);
                }
                break;
            case 123:
            case 135:
            case 205:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(20, "PARAMETERS", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void oY() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        gn();
        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
        FH(130);
        gn();
        we();
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 101) {
            FH(101);
            gn();
            we();
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void gn(AST ast) {
        AST ast2;
        int i = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        if (ast != null) {
            j6.j6(ast.v5());
            j6.DW(ast.Zo());
        }
        Token DW = DW(1);
        this.aM.j6(aSTPair, this.aM.j6(DW));
        FH(87);
        FH(91);
        jO();
        AST ast3 = this.XL;
        FH(123);
        if ((j6(1) == 130 || j6(1) == 205) && sG.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                gn();
                FH(130);
                i = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            oY();
            ast2 = this.XL;
        } else if ((j6(1) == 126 || j6(1) == 205) && cT.Hw(j6(2))) {
            ast2 = null;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        mb();
        if (this.Ws.DW == 0) {
            FH(DW);
        }
        ye();
        AST ast4 = this.XL;
        if (this.Ws.DW == 0) {
            AST ast5 = aSTPair.j6;
            ast2 = this.aM.j6(new ASTArray(5).j6(j6(46, "CTOR_IDENT", j6, DW(1))).j6(ast).j6(ast3).j6(ast2).j6(ast4));
            aSTPair.j6 = ast2;
            if (!(ast2 == null || ast2.j6() == null)) {
                ast2 = ast2.j6();
            }
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void ko() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        while (true) {
            switch (j6(1)) {
                case 38:
                case 39:
                case 43:
                case 83:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                    lg();
                    this.aM.j6(aSTPair, this.XL);
                    gn();
                    this.aM.j6(aSTPair, this.XL);
                    break;
                case 96:
                    rN();
                    this.aM.j6(aSTPair, this.XL);
                    gn();
                    this.aM.j6(aSTPair, this.XL);
                    break;
                default:
                    this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                    FH(84);
                    gn();
                    this.aM.j6(aSTPair, this.XL);
                    this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                    FH(91);
                    this.XL = aSTPair.j6;
                    return;
            }
        }
    }

    public final void Ev() {
        AST ast = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        QX();
        AST ast2 = this.XL;
        switch (j6(1)) {
            case 87:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                j6(false);
                ast = this.XL;
                break;
            case 91:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
        FH(91);
        gn();
        j6(ast2, j6);
        this.aM.j6(aSTPair, this.XL);
        FH(123);
        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
        FH(124);
        gn();
        u7(0);
        this.aM.j6(aSTPair, this.XL);
        if (this.Ws.DW == 0) {
            ast = this.aM.j6(new ASTArray(4).j6(j6(9, "VARIABLE_DEF", j6, DW(1))).j6(ast2).j6(this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", j6, DW(1))).j6(ast))).j6(aSTPair.j6));
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void ye() {
        AST ast;
        AST ast2;
        int i = 0;
        AST ast3 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        gn();
        if (q7.Hw(j6(1)) && Z1.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                WB();
                i = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            WB();
            ast = this.XL;
            switch (j6(1)) {
                case 127:
                    ast2 = null;
                    break;
                case 128:
                case 205:
                    EQ();
                    VH(this.Fd);
                    ast3 = this.XL;
                    ast2 = null;
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
        } else if (Sf.Hw(j6(1)) && n5.Hw(j6(2))) {
            VH(1);
            ast2 = this.XL;
            ast = null;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        FH(127);
        if (this.Ws.DW == 0) {
            AST ast4 = aSTPair.j6;
            if (ast != null) {
                ast2 = this.aM.j6(new ASTArray(3).j6(j6(7, "{", DW, DW(1))).j6(ast).j6(ast3));
            } else {
                ast2 = this.aM.j6(new ASTArray(2).j6(j6(7, "{", DW, DW(1))).j6(ast2));
            }
            aSTPair.j6 = ast2;
            if (!(ast2 == null || ast2.j6() == null)) {
                ast2 = ast2.j6();
            }
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void WB() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 89:
                BT();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 99:
            case 132:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        AST j6;
        switch (j6(1)) {
            case 99:
                FH(99);
                j6 = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, j6);
                FH(91);
                Eq();
                this.aM.j6(aSTPair, this.XL);
                FH(123);
                if (this.Ws.DW == 0) {
                    j6.j6(44);
                    break;
                }
                break;
            case 132:
                FH(132);
                j6 = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, j6);
                FH(91);
                Eq();
                this.aM.j6(aSTPair, this.XL);
                FH(123);
                if (this.Ws.DW == 0) {
                    j6.j6(45);
                    break;
                }
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void j6(AST ast, AST ast2, Token token) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        DW(Hw().FH(ast), Hw().FH(ast2), token);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 101) {
            FH(101);
            gn();
            if (this.Ws.DW == 0) {
                token = DW(1);
            }
            DW(Hw().FH(ast), Hw().FH(ast2), token);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void DW(AST ast, AST ast2, Token token) {
        AST ast3;
        AST ast4 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        fY();
        AST ast5 = this.XL;
        switch (j6(1)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case 101:
            case 123:
            case 127:
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 138:
            case 150:
            case 205:
                ast3 = null;
                break;
            case 124:
                U2();
                ast3 = this.XL;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            ast4 = aSTPair.j6;
            ast4 = this.aM.j6(new ASTArray(5).j6(j6(9, "VARIABLE_DEF", token, DW(1))).j6(ast).j6(this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", token, DW(1))).j6(ast2))).j6(ast5).j6(ast3));
            aSTPair.j6 = ast4;
            ast3 = (ast4 == null || ast4.j6() == null) ? ast4 : ast4.j6();
            aSTPair.DW = ast3;
            aSTPair.j6();
        }
        this.XL = ast4;
    }

    public final void j6(AST ast, Token token) {
        AST ast2;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (cn.Hw(j6(1)) && vJ.Hw(j6(2))) {
            j6(false);
            ast2 = this.XL;
        } else {
            if (j6(1) == 87) {
                if (j6(2) == 101) {
                    ast2 = null;
                } else if (j6(2) == 123) {
                    ast2 = null;
                }
            }
            throw new NoViableAltException(DW(1), v5());
        }
        DW(Hw().FH(ast), ast2);
        this.aM.j6(aSTPair, this.XL);
        ast2 = null;
        while (j6(1) == 101) {
            FH(101);
            gn();
            if (this.Ws.DW == 0) {
                DW(1);
            }
            if (cn.Hw(j6(1)) && vJ.Hw(j6(2))) {
                j6(false);
                ast2 = this.XL;
            } else if (!(j6(1) == 87 && (j6(2) == 101 || j6(2) == 123))) {
                throw new NoViableAltException(DW(1), v5());
            }
            DW(Hw().FH(ast), ast2);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void u7(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        gn(i);
        this.aM.j6(aSTPair, this.XL);
        switch (j6(1)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 98:
            case 99:
            case 101:
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
            case 126:
            case 127:
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 130:
            case 131:
            case 132:
            case 135:
            case 136:
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
            case 148:
            case 149:
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
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
                break;
            case 124:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
                switch (j6(1)) {
                    case 124:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(124);
                        break;
                    case 162:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(162);
                        break;
                    case 163:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(163);
                        break;
                    case 164:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(164);
                        break;
                    case 165:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(165);
                        break;
                    case 166:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(166);
                        break;
                    case 167:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(167);
                        break;
                    case 168:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(168);
                        break;
                    case 169:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(169);
                        break;
                    case 170:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(170);
                        break;
                    case 171:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(171);
                        break;
                    case 172:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(172);
                        break;
                    case 173:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(173);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                gn();
                qp();
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void mb() {
        int i = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (Q6.Hw(j6(1)) && Zo.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                FH(205);
                i = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            if (this.Ws.DW == 0) {
                DW("A newline at this point does not follow the Groovy Coding Conventions.", "Keep this statement on one line, or use curly braces to break across multiple lines.");
            }
        } else if (!(Q6.Hw(j6(1)) && Zo.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        gn();
        this.XL = null;
    }

    public final void jw() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        gn();
        VH(1);
        AST ast = this.XL;
        FH(127);
        if (this.Ws.DW == 0) {
            AST ast2 = aSTPair.j6;
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(7, "{", DW, DW(1))).j6(ast));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void fY() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
        FH(87);
        this.XL = aSTPair.j6;
    }

    public final void qp() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        we(1);
        AST ast = this.XL;
        this.aM.j6(aSTPair, this.XL);
        int i = this.Ws.DW == 0 ? ast == this.sT ? 1 : 0 : 1;
        if (kf.Hw(j6(1)) && hz.Hw(j6(2)) && j6(1) != 138 && r0 != 0) {
            u7(ast);
            AST ast2 = this.XL;
            if (this.Ws.DW == 0) {
                AST ast3 = aSTPair.j6;
                aSTPair.j6 = ast2;
                if (!(ast2 == null || ast2.j6() == null)) {
                    ast2 = ast2.j6();
                }
                aSTPair.DW = ast2;
                aSTPair.j6();
            }
        } else if (!(kf.Hw(j6(1)) && hz.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void k2() {
        AST ast;
        AST ast2;
        boolean z = false;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        zh();
        AST ast3 = this.XL;
        if (cn.Hw(j6(1)) && Jl.Hw(j6(2))) {
            j6(false);
            ast = this.XL;
        } else if ((j6(1) == 87 || j6(1) == 133) && iW.Hw(j6(2))) {
            ast = null;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        switch (j6(1)) {
            case 87:
                break;
            case 133:
                FH(133);
                if (this.Ws.DW == 0) {
                    z = true;
                    break;
                }
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        AST j6 = this.aM.j6(DW(1));
        FH(87);
        switch (j6(1)) {
            case 101:
            case 123:
            case 135:
            case 205:
                ast2 = null;
                break;
            case 124:
                U2();
                ast2 = this.XL;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST ast4 = aSTPair.j6;
            if (z) {
                ast = this.aM.j6(new ASTArray(5).j6(j6(47, "VARIABLE_PARAMETER_DEF", DW, DW(1))).j6(ast3).j6(this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", DW, DW(1))).j6(ast))).j6(j6).j6(ast2));
            } else {
                ast = this.aM.j6(new ASTArray(5).j6(j6(21, "PARAMETER_DEF", DW, DW(1))).j6(ast3).j6(this.aM.j6(new ASTArray(2).j6(j6(12, "TYPE", DW, DW(1))).j6(ast))).j6(j6).j6(ast2));
            }
            aSTPair.j6 = ast;
            if (ast == null || ast.j6() == null) {
                ast4 = ast;
            } else {
                ast4 = ast.j6();
            }
            aSTPair.DW = ast4;
            aSTPair.j6();
        } else {
            ast = null;
        }
        this.XL = ast;
    }

    public final void zh() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        int i = 0;
        while (true) {
            switch (j6(1)) {
                case 38:
                    this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                    FH(38);
                    gn();
                    break;
                case 96:
                    rN();
                    this.aM.j6(aSTPair, this.XL);
                    gn();
                    break;
                default:
                    if (j6(1) == 84) {
                        int i2 = i + 1;
                        if (i == 0) {
                            FH(84);
                            gn();
                            i = i2;
                            break;
                        }
                    }
                    if (this.Ws.DW == 0) {
                        AST j6 = this.aM.j6(new ASTArray(2).j6(j6(5, "MODIFIERS", DW, DW(1))).j6(aSTPair.j6));
                        aSTPair.j6 = j6;
                        if (!(j6 == null || j6.j6() == null)) {
                            j6 = j6.j6();
                        }
                        aSTPair.DW = j6;
                        aSTPair.j6();
                    }
                    this.XL = aSTPair.j6;
                    return;
            }
        }
    }

    public final void AL() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        gn();
        Hw(false);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 134) {
            FH(134);
            gn();
            Hw(false);
            this.aM.j6(aSTPair, this.XL);
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(79, "MULTICATCH_TYPES", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void w9() {
        AST ast = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        gn();
        switch (j6(1)) {
            case 38:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(38);
                break;
            case 84:
            case 87:
            case 205:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        switch (j6(1)) {
            case 84:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(84);
                break;
            case 87:
            case 205:
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if ((j6(1) == 87 || j6(1) == 205) && eU.Hw(j6(2))) {
            AL();
            ast = this.XL;
            this.aM.j6(aSTPair, this.XL);
        } else if (!(j6(1) == 87 && j6(2) == 123)) {
            throw new NoViableAltException(DW(1), v5());
        }
        AST j6 = this.aM.j6(DW(1));
        FH(87);
        if (this.Ws.DW == 0) {
            AST ast2 = aSTPair.j6;
            ast = this.aM.j6(new ASTArray(3).j6(j6(78, "MULTICATCH", DW, DW(1))).j6(ast).j6(j6));
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void Zo(boolean z) {
        AST ast;
        int i = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (e3.Hw(j6(1)) && sE.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                jO();
                gn();
                FH(135);
                i = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            jO();
            this.aM.j6(aSTPair, this.XL);
            gn();
            FH(135);
            gn();
            ast = aSTPair.j6;
        } else if (Sf.Hw(j6(1)) && hz.Hw(j6(2)) && z) {
            hK();
            this.aM.j6(aSTPair, this.XL);
            ast = aSTPair.j6;
        } else if (Sf.Hw(j6(1)) && hz.Hw(j6(2))) {
            ast = aSTPair.j6;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void hK() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        if (this.Ws.DW == 0) {
            AST ast = aSTPair.j6;
            AST j6 = this.aM.j6(new ASTArray(1).j6(j6(51, "IMPLICIT_PARAMETERS", DW, DW(1))));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void cT() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        gn();
        jO();
        gn();
        this.aM.j6(DW(1));
        FH(135);
        this.XL = null;
    }

    public final void q7() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        gn();
        Zo(true);
        AST ast = this.XL;
        VH(1);
        AST ast2 = this.XL;
        FH(127);
        if (this.Ws.DW == 0) {
            AST ast3 = aSTPair.j6;
            AST j6 = this.aM.j6(new ASTArray(3).j6(j6(50, "{", DW, DW(1))).j6(ast).j6(ast2));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void Z1() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(126);
        gn();
        Zo(false);
        AST ast = this.XL;
        VH(1);
        AST ast2 = this.XL;
        FH(127);
        if (this.Ws.DW == 0) {
            AST j6;
            AST ast3 = aSTPair.j6;
            if (ast == null) {
                j6 = this.aM.j6(new ASTArray(2).j6(j6(7, "{", DW, DW(1))).j6(ast2));
            } else {
                j6 = this.aM.j6(new ASTArray(3).j6(j6(50, "{", DW, DW(1))).j6(ast).j6(ast2));
            }
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void n5() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
        FH(87);
        AST j6 = this.aM.j6(DW(1));
        this.aM.DW(aSTPair, j6);
        FH(136);
        if (this.Ws.DW == 0) {
            j6.j6(22);
        }
        gn();
        this.XL = aSTPair.j6;
    }

    public final void tp(int i) {
        int i2 = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        if (ei.Hw(j6(1)) && Zo.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                pO();
                i2 = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i2 != 0) {
            J0(i);
            this.aM.j6(aSTPair, this.XL);
        } else if (!(ei.Hw(j6(1)) && Zo.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        qp();
        AST ast = this.XL;
        this.aM.j6(aSTPair, this.XL);
        if (this.Ws.DW == 0) {
            AST ast2 = aSTPair.j6;
            ast = this.aM.j6(new ASTArray(2).j6(j6(28, "EXPR", DW, DW(1))).j6(ast));
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void Q6() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        gn(0);
        this.aM.j6(aSTPair, this.XL);
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(28, "EXPR", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void kf() {
        AST ast;
        int i = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (j6(1) == 126 && Sf.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                FH(126);
                i = 1;
            } catch (RecognitionException e) {
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            FN();
            this.aM.j6(aSTPair, this.XL);
            ast = aSTPair.j6;
        } else if (P8.Hw(j6(1)) && Zo.Hw(j6(2))) {
            Zo(1);
            this.aM.j6(aSTPair, this.XL);
            ast = aSTPair.j6;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void Jl() {
        AST ast;
        AST ast2;
        AST ast3;
        AST ast4 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(141);
        FH(91);
        int i = 0;
        if (sg.Hw(j6(1)) && pO.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 83:
                    case 84:
                    case 85:
                    case 87:
                    case 88:
                    case 91:
                    case 96:
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
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 126:
                    case 132:
                    case 143:
                    case 144:
                    case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                    case 146:
                    case 147:
                    case 148:
                    case 149:
                    case 157:
                    case 159:
                    case 160:
                    case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    case 190:
                    case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                    case 195:
                    case 196:
                    case 197:
                    case 199:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                        VH(true);
                        FH(128);
                        break;
                    case 128:
                        FH(128);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                i = 1;
            } catch (RecognitionException e) {
                i = 0;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        }
        if (i != 0) {
            sE();
            ast = this.XL;
            ast2 = null;
        } else if (gW.Hw(j6(1)) && fN.Hw(j6(2))) {
            sg();
            ast2 = this.XL;
            ast = null;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        FH(123);
        gn();
        switch (j6(1)) {
            case 38:
            case 39:
            case 43:
            case 82:
            case 83:
            case 84:
            case 85:
            case 87:
            case 88:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
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
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 126:
            case 132:
            case 137:
            case 139:
            case 140:
            case 141:
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
            case 148:
            case 149:
            case 151:
            case 157:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 190:
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                kf();
                ast3 = null;
                ast4 = this.XL;
                break;
            case 128:
                ast3 = this.aM.j6(DW(1));
                FH(128);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST ast5 = aSTPair.j6;
            if (ast != null) {
                if (ast3 != null) {
                    ast2 = this.aM.j6(new ASTArray(3).j6(j6(141, "for", DW, DW(1))).j6(ast).j6(ast3));
                } else {
                    ast2 = this.aM.j6(new ASTArray(3).j6(j6(141, "for", DW, DW(1))).j6(ast).j6(ast4));
                }
            } else if (ast3 != null) {
                ast2 = this.aM.j6(new ASTArray(3).j6(j6(141, "for", DW, DW(1))).j6(ast2).j6(ast3));
            } else {
                ast2 = this.aM.j6(new ASTArray(3).j6(j6(141, "for", DW, DW(1))).j6(ast2).j6(ast4));
            }
            aSTPair.j6 = ast2;
            if (!(ast2 == null || ast2.j6() == null)) {
                ast2 = ast2.j6();
            }
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final boolean VH(boolean z) {
        boolean z2;
        boolean z3 = false;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        if (gW.Hw(j6(1)) && Gj.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            if (z) {
                a8();
                z2 = true;
                v5(Zo);
                ParserSharedInputState parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW--;
            } else {
                try {
                    throw new SemanticException("allowDeclaration");
                } catch (RecognitionException e) {
                    z2 = false;
                }
            }
        } else {
            z2 = false;
        }
        if (z2) {
            if (this.Ws.DW == 0) {
                z3 = true;
            }
            Mr();
            this.aM.j6(aSTPair, this.XL);
        } else if (ei.Hw(j6(1)) && Qq.Hw(j6(2))) {
            we(0);
            this.aM.j6(aSTPair, this.XL);
        } else if (j6(1) >= 143 && j6(1) <= 147) {
            e3();
            this.aM.j6(aSTPair, this.XL);
        } else if (j6(1) == 96 && j6(2) == 87) {
            rN();
            this.aM.j6(aSTPair, this.XL);
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(28, "EXPR", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
        return z3;
    }

    public final void iW() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        int i = 0;
        while (true) {
            if (j6(1) != ProxyTextView.INPUTTYPE_textPassword && j6(1) != 150) {
                break;
            }
            fN();
            this.aM.j6(aSTPair, this.XL);
            i++;
        }
        if (i >= 1) {
            Gj();
            this.aM.j6(aSTPair, this.XL);
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(32, "CASE_GROUP", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
        throw new NoViableAltException(DW(1), v5());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eU() {
        /*
        r13 = this;
        r12 = 91;
        r11 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
        r1 = 0;
        r10 = 2;
        r9 = 1;
        r13.XL = r1;
        r2 = new groovyjarjarantlr.ASTPair;
        r2.<init>();
        r3 = r13.DW(r9);
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        r13.FH(r0);
        r13.mb();
        r13.FN();
        r4 = r13.XL;
        r0 = r1;
    L_0x0025:
        r5 = r13.j6(r9);
        r6 = 153; // 0x99 float:2.14E-43 double:7.56E-322;
        if (r5 == r6) goto L_0x0033;
    L_0x002d:
        r5 = r13.j6(r9);
        if (r5 != r11) goto L_0x0074;
    L_0x0033:
        r5 = r13.j6(r10);
        if (r5 == r12) goto L_0x0041;
    L_0x0039:
        r5 = r13.j6(r10);
        r6 = 153; // 0x99 float:2.14E-43 double:7.56E-322;
        if (r5 != r6) goto L_0x0074;
    L_0x0041:
        r5 = r13.j6(r9);
        if (r5 != r11) goto L_0x004d;
    L_0x0047:
        r5 = r13.j6(r10);
        if (r5 == r12) goto L_0x0074;
    L_0x004d:
        r13.gn();
        r13.Cz();
        r5 = r13.XL;
        r6 = r13.Ws;
        r6 = r6.DW;
        if (r6 != 0) goto L_0x0025;
    L_0x005b:
        r6 = r13.aM;
        r7 = new groovyjarjarantlr.collections.impl.ASTArray;
        r8 = 3;
        r7.<init>(r8);
        r7 = r7.j6(r1);
        r0 = r7.j6(r0);
        r0 = r0.j6(r5);
        r0 = r6.j6(r0);
        goto L_0x0025;
    L_0x0074:
        r5 = r13.j6(r9);
        r6 = 152; // 0x98 float:2.13E-43 double:7.5E-322;
        if (r5 == r6) goto L_0x0082;
    L_0x007c:
        r5 = r13.j6(r9);
        if (r5 != r11) goto L_0x00df;
    L_0x0082:
        r5 = Cz;
        r6 = r13.j6(r10);
        r5 = r5.Hw(r6);
        if (r5 == 0) goto L_0x00df;
    L_0x008e:
        r13.gn();
        r13.pN();
        r1 = r13.XL;
    L_0x0096:
        r5 = r13.Ws;
        r5 = r5.DW;
        if (r5 != 0) goto L_0x00da;
    L_0x009c:
        r5 = r2.j6;
        r5 = r13.aM;
        r6 = new groovyjarjarantlr.collections.impl.ASTArray;
        r7 = 4;
        r6.<init>(r7);
        r7 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        r8 = "try";
        r9 = r13.DW(r9);
        r3 = r13.j6(r7, r8, r3, r9);
        r3 = r6.j6(r3);
        r3 = r3.j6(r4);
        r0 = r3.j6(r0);
        r0 = r0.j6(r1);
        r0 = r5.j6(r0);
        r2.j6 = r0;
        if (r0 == 0) goto L_0x00d5;
    L_0x00cb:
        r1 = r0.j6();
        if (r1 == 0) goto L_0x00d5;
    L_0x00d1:
        r0 = r0.j6();
    L_0x00d5:
        r2.DW = r0;
        r2.j6();
    L_0x00da:
        r0 = r2.j6;
        r13.XL = r0;
        return;
    L_0x00df:
        r5 = a8;
        r6 = r13.j6(r9);
        r5 = r5.Hw(r6);
        if (r5 == 0) goto L_0x00f7;
    L_0x00eb:
        r5 = lg;
        r6 = r13.j6(r10);
        r5 = r5.Hw(r6);
        if (r5 != 0) goto L_0x0096;
    L_0x00f7:
        r0 = new groovyjarjarantlr.NoViableAltException;
        r1 = r13.DW(r9);
        r2 = r13.v5();
        r0.<init>(r1, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.antlr.parser.GroovyRecognizer.eU():void");
    }

    public final void e3() {
        AST ast = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        AST ast2;
        switch (j6(1)) {
            case 143:
                FH(143);
                switch (j6(1)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case 86:
                    case 101:
                    case 123:
                    case 127:
                    case 128:
                    case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                    case 138:
                    case 150:
                    case 205:
                        break;
                    case 85:
                    case 87:
                    case 88:
                    case 91:
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
                    case 126:
                    case 132:
                    case 148:
                    case 149:
                    case 157:
                    case 159:
                    case 160:
                    case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    case 190:
                    case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                    case 195:
                    case 196:
                    case 197:
                    case 199:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                        we(0);
                        ast = this.XL;
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                if (this.Ws.DW == 0) {
                    ast2 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(2).j6(j6(143, "return", DW, DW(1))).j6(ast));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                }
                ast = aSTPair.j6;
                break;
            case 144:
                FH(144);
                switch (j6(1)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case 86:
                    case 101:
                    case 123:
                    case 127:
                    case 128:
                    case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                    case 138:
                    case 150:
                    case 205:
                        break;
                    case 87:
                        ast = this.aM.j6(DW(1));
                        FH(87);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                if (this.Ws.DW == 0) {
                    ast2 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(2).j6(j6(144, "break", DW, DW(1))).j6(ast));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                }
                ast = aSTPair.j6;
                break;
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                FH(ProxyTextView.INPUTTYPE_textVisiblePassword);
                switch (j6(1)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case 86:
                    case 101:
                    case 123:
                    case 127:
                    case 128:
                    case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                    case 138:
                    case 150:
                    case 205:
                        break;
                    case 87:
                        ast = this.aM.j6(DW(1));
                        FH(87);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                if (this.Ws.DW == 0) {
                    ast2 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(2).j6(j6((int) ProxyTextView.INPUTTYPE_textVisiblePassword, "continue", DW, DW(1))).j6(ast));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                }
                ast = aSTPair.j6;
                break;
            case 146:
                FH(146);
                we(0);
                ast = this.XL;
                if (this.Ws.DW == 0) {
                    ast2 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(2).j6(j6(146, "throw", DW, DW(1))).j6(ast));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                }
                ast = aSTPair.j6;
                break;
            case 147:
                FH(147);
                Q6();
                ast2 = this.XL;
                if ((j6(1) == 101 || j6(1) == 136) && pN.Hw(j6(2))) {
                    switch (j6(1)) {
                        case 101:
                            FH(101);
                            gn();
                            break;
                        case 136:
                            FH(136);
                            gn();
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                    we(0);
                    ast = this.XL;
                } else if (!(oy.Hw(j6(1)) && lg.Hw(j6(2)))) {
                    throw new NoViableAltException(DW(1), v5());
                }
                if (this.Ws.DW == 0) {
                    AST ast3 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(3).j6(j6(147, "assert", DW, DW(1))).j6(ast2).j6(ast));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                }
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void sE() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        switch (j6(1)) {
            case 38:
            case 39:
            case 43:
            case 83:
            case 84:
            case 85:
            case 87:
            case 88:
            case 91:
            case 96:
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
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 126:
            case 132:
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
            case 148:
            case 149:
            case 157:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 190:
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                VH(true);
                this.aM.j6(aSTPair, this.XL);
                break;
            case 128:
                if (this.Ws.DW == 0) {
                    this.aM.j6(aSTPair, this.aM.j6(37, "EMPTY_STAT"));
                    break;
                }
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        int i = 0;
        while (true) {
            if (j6(1) == 128 && aX.Hw(j6(2))) {
                FH(128);
                VH(true);
                this.aM.j6(aSTPair, this.XL);
            } else if (j6(1) == 128 && (j6(2) == 123 || j6(2) == 128)) {
                FH(128);
                if (this.Ws.DW == 0) {
                    this.aM.j6(aSTPair, this.aM.j6(37, "EMPTY_STAT"));
                }
            } else if (i >= 1) {
                if (this.Ws.DW == 0) {
                    AST j6 = this.aM.j6(new ASTArray(2).j6(j6(77, "CLOSURE_LIST", DW, DW(1))).j6(aSTPair.j6));
                    aSTPair.j6 = j6;
                    if (!(j6 == null || j6.j6() == null)) {
                        j6 = j6.j6();
                    }
                    aSTPair.DW = j6;
                    aSTPair.j6();
                }
                this.XL = aSTPair.j6;
                return;
            } else {
                throw new NoViableAltException(DW(1), v5());
            }
            i++;
        }
    }

    public final void sg() {
        int i;
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (gW.Hw(j6(1)) && Gj.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                a8();
                i = 1;
            } catch (RecognitionException e) {
                i = 0;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            i = 0;
        }
        if (i != 0) {
            j3();
            ast = this.XL;
            this.aM.j6(aSTPair, this.XL);
        } else if (j6(1) == 87 && (j6(2) == 136 || j6(2) == 142)) {
            this.aM.j6(aSTPair, this.aM.j6(DW(1)));
            FH(87);
            ast = null;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        switch (j6(1)) {
            case 136:
                if (this.Ws.DW == 0) {
                    DW("A colon at this point is legal Java but not recommended in Groovy.", "Use the 'in' keyword.");
                    j6(ast != null, "Java-style for-each statement requires a type declaration.", "Use the 'in' keyword, as for (x in y) {...}");
                }
                ast = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, ast);
                FH(136);
                if (this.Ws.DW == 0) {
                    ast.j6(59);
                }
                we(0);
                this.aM.j6(aSTPair, this.XL);
                break;
            case 142:
                ast = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, ast);
                FH(142);
                if (this.Ws.DW == 0) {
                    ast.j6(59);
                }
                EQ(0);
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void EQ(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        rN(i);
        this.aM.j6(aSTPair, this.XL);
        while (e9.Hw(j6(1))) {
            switch (j6(1)) {
                case 102:
                case 103:
                case 187:
                    switch (j6(1)) {
                        case 102:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(102);
                            break;
                        case 103:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(103);
                            break;
                        case 187:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(187);
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                case 188:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(188);
                    break;
                case 189:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(189);
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
            gn();
            rN(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void we(int i) {
        boolean z;
        AST j6;
        boolean z2 = false;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (j6(1) == 91 && cn.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                FH(91);
                j6(true);
                FH(123);
                we(i);
                z = true;
            } catch (RecognitionException e) {
                z = false;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            z = false;
        }
        if (z) {
            j6 = this.aM.j6(DW(1));
            this.aM.DW(aSTPair, j6);
            FH(91);
            if (this.Ws.DW == 0) {
                j6.j6(23);
            }
            j6(true);
            this.aM.j6(aSTPair, this.XL);
            FH(123);
            we(i);
            this.aM.j6(aSTPair, this.XL);
            j6 = aSTPair.j6;
        } else {
            if (j6(1) == 91 && (j6(2) == 87 || j6(2) == 205)) {
                int Zo2 = Zo();
                parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW++;
                try {
                    FH(91);
                    gn();
                    FH(87);
                    while (j6(1) == 101) {
                        FH(101);
                        gn();
                        FH(87);
                    }
                    FH(123);
                    FH(124);
                    z2 = true;
                } catch (RecognitionException e2) {
                }
                v5(Zo2);
                parserSharedInputState = this.Ws;
                parserSharedInputState.DW--;
            }
            if (z2) {
                J8(i);
                j6 = this.XL;
                this.aM.j6(aSTPair, this.XL);
                if (this.Ws.DW == 0) {
                    AST ast = aSTPair.j6;
                    aSTPair.j6 = j6;
                    if (!(j6 == null || j6.j6() == null)) {
                        j6 = j6.j6();
                    }
                    aSTPair.DW = j6;
                    aSTPair.j6();
                }
                j6 = aSTPair.j6;
            } else if (ei.Hw(j6(1)) && Qq.Hw(j6(2))) {
                u7(i);
                this.aM.j6(aSTPair, this.XL);
                j6 = aSTPair.j6;
            } else {
                throw new NoViableAltException(DW(1), v5());
            }
        }
        this.XL = j6;
    }

    public final void pO() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 85:
            case 91:
            case 126:
                switch (j6(1)) {
                    case 85:
                        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                        FH(85);
                        break;
                    case 91:
                        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                        FH(91);
                        break;
                    case 126:
                        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                        FH(126);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            case 148:
            case 149:
                switch (j6(1)) {
                    case 148:
                        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                        FH(148);
                        break;
                    case 149:
                        this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                        FH(149);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void J0(int i) {
        boolean z;
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (ei.Hw(j6(1)) && Zo.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                if (QO.Hw(j6(1))) {
                    Hw(126);
                } else if (j6(1) == 126) {
                    FH(126);
                    cT();
                } else {
                    throw new NoViableAltException(DW(1), v5());
                }
                int i2 = 1;
            } catch (RecognitionException e) {
                z = false;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            z = false;
        }
        if (i2 != 0) {
            if (ei.Hw(j6(1)) && Zo.Hw(j6(2)) && i == 205) {
                if (this.Ws.DW == 0) {
                    DW("Expression statement looks like it may continue a previous statement", "Either remove the previous newline, or add an explicit semicolon ';'.");
                }
            } else if (!(ei.Hw(j6(1)) && Zo.Hw(j6(2)))) {
                throw new NoViableAltException(DW(1), v5());
            }
            ast = aSTPair.j6;
        } else if (ei.Hw(j6(1)) && Zo.Hw(j6(2)) && i == 205) {
            if (this.Ws.DW == 0) {
                j6(false, "Ambiguous expression could be a parameterless closure expression, an isolated open code block, or it may continue a previous statement", "Add an explicit parameter list, e.g. {it -> ...}, or force it to be treated as an open block by giving it a label, e.g. L:{...}, and also either remove the previous newline, or add an explicit semicolon ';'");
            }
            ast = aSTPair.j6;
        } else if (ei.Hw(j6(1)) && Zo.Hw(j6(2)) && i != 205) {
            if (this.Ws.DW == 0) {
                j6(false, "Ambiguous expression could be either a parameterless closure expression or an isolated open code block", "Add an explicit closure parameter list, e.g. {it -> ...}, or force it to be treated as an open block by giving it a label, e.g. L:{...}");
            }
            ast = aSTPair.j6;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void u7(AST ast) {
        int i;
        AST ast2;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (sM.Hw(j6(1)) && Qq.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            if (ast != null) {
                try {
                    if (ast.Hw() == 27) {
                        throw new SemanticException("prev==null || prev.getType()!=METHOD_CALL");
                    }
                } catch (RecognitionException e) {
                    i = 0;
                }
            }
            oy();
            i = 1;
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            i = 0;
        }
        if (i != 0) {
            tp(ast);
            ast2 = this.XL;
            if (this.Ws.DW == 0) {
                ast = ast2;
            }
        } else if (!(kf.Hw(j6(1)) && hz.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        while (a5.Hw(j6(1)) && ys.Hw(j6(2))) {
            AST j6;
            aX();
            ast2 = this.XL;
            if (this.Ws.DW == 0) {
                j6 = this.aM.j6(new ASTArray(3).j6(j6(90, ".", ast)).j6(ast).j6(ast2));
            } else {
                j6 = ast;
            }
            if (IS.Hw(j6(1)) && gG.Hw(j6(2))) {
                int Zo2 = Zo();
                parserSharedInputState = this.Ws;
                parserSharedInputState.DW++;
                try {
                    e9();
                    i = 1;
                } catch (RecognitionException e2) {
                    i = 0;
                }
                v5(Zo2);
                ParserSharedInputState parserSharedInputState3 = this.Ws;
                parserSharedInputState3.DW--;
            } else {
                i = 0;
            }
            if (i != 0) {
                j6(1, j6);
                ast2 = this.XL;
                if (this.Ws.DW == 0) {
                }
                ast2 = j6;
            } else if (sM.Hw(j6(1)) && Qq.Hw(j6(2))) {
                tp(j6);
                ast2 = this.XL;
                if (this.Ws.DW == 0) {
                }
                ast2 = j6;
            } else if (kf.Hw(j6(1)) && hz.Hw(j6(2))) {
                ast2 = j6;
            } else {
                throw new NoViableAltException(DW(1), v5());
            }
            ast = ast2;
        }
        if (this.Ws.DW == 0) {
            ast2 = aSTPair.j6;
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void fN() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(ProxyTextView.INPUTTYPE_textPassword);
                break;
            case 150:
                this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                FH(150);
                we(0);
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        FH(136);
        gn();
        this.XL = aSTPair.j6;
    }

    public final void Gj() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        Zo(136);
        this.aM.j6(aSTPair, this.XL);
        while (true) {
            if (j6(1) == 128 || j6(1) == 205) {
                EQ();
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 43:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 87:
                    case 88:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
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
                    case 115:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 126:
                    case 132:
                    case 137:
                    case 139:
                    case 140:
                    case 141:
                    case 143:
                    case 144:
                    case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                    case 146:
                    case 147:
                    case 148:
                    case 149:
                    case 151:
                    case 157:
                    case 159:
                    case 160:
                    case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    case 190:
                    case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                    case 195:
                    case 196:
                    case 197:
                    case 199:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                        Zo(this.Fd);
                        this.aM.j6(aSTPair, this.XL);
                        break;
                    case 127:
                    case 128:
                    case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                    case 150:
                    case 205:
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            }
            if (this.Ws.DW == 0) {
                AST j6 = this.aM.j6(new ASTArray(2).j6(j6(7, "SLIST", DW, DW(1))).j6(aSTPair.j6));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
    }

    public final void Cz() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(153);
        FH(91);
        w9();
        AST ast = this.XL;
        FH(123);
        mb();
        FN();
        AST ast2 = this.XL;
        if (this.Ws.DW == 0) {
            AST ast3 = aSTPair.j6;
            AST j6 = this.aM.j6(new ASTArray(3).j6(j6(153, "catch", DW, DW(1))).j6(ast).j6(ast2));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void pN() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(152);
        mb();
        FN();
        AST ast = this.XL;
        if (this.Ws.DW == 0) {
            AST ast2 = aSTPair.j6;
            AST j6 = this.aM.j6(new ASTArray(2).j6(j6(152, "finally", DW, DW(1))).j6(ast));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void tp(AST ast) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        oy();
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 101 && AE.Hw(j6(2))) {
            FH(101);
            gn();
            oy();
            this.aM.j6(aSTPair, this.XL);
        }
        if (this.Ws.DW == 0) {
            AST j6 = this.aM.j6(new ASTArray(3).j6(j6(27, "<command>", DW, DW(1))).j6(ast).j6(this.aM.j6(new ASTArray(2).j6(j6(33, "ELIST", DW, DW(1))).j6(aSTPair.j6))));
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void oy() {
        int i;
        AST j6;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (Za.Hw(j6(1)) && An.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                QO();
                FH(136);
                gn();
                i = 1;
            } catch (RecognitionException e) {
                i = 0;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            i = 0;
        }
        if (i != 0) {
            QO();
            this.aM.j6(aSTPair, this.XL);
            j6 = this.aM.j6(DW(1));
            this.aM.DW(aSTPair, j6);
            FH(136);
            gn();
            we(0);
            this.aM.j6(aSTPair, this.XL);
            if (this.Ws.DW == 0) {
                j6.j6(54);
            }
            j6 = aSTPair.j6;
        } else if (ei.Hw(j6(1)) && Qq.Hw(j6(2))) {
            we(0);
            this.aM.j6(aSTPair, this.XL);
            j6 = aSTPair.j6;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = j6;
    }

    public final void aX() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        switch (j6(1)) {
            case 85:
                AE();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 87:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(87);
                ast = aSTPair.j6;
                break;
            case 88:
            case 157:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                gG();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 91:
                ys();
                AST ast2 = this.XL;
                if (this.Ws.DW == 0) {
                    AST ast3 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(2).j6(j6(28, "EXPR", DW, DW(1))).j6(ast2));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                }
                ast = aSTPair.j6;
                break;
            case 99:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(99);
                ast = aSTPair.j6;
                break;
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                yS();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 126:
                BR();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 132:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(132);
                ast = aSTPair.j6;
                break;
            case 159:
                Nh();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 197:
                IS();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void e9() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 85:
                this.aM.j6(DW(1));
                FH(85);
                break;
            case 90:
            case 154:
            case 155:
            case 156:
            case 205:
                gn();
                switch (j6(1)) {
                    case 90:
                        this.aM.j6(DW(1));
                        FH(90);
                        break;
                    case 154:
                        this.aM.j6(DW(1));
                        FH(154);
                        break;
                    case 155:
                        this.aM.j6(DW(1));
                        FH(155);
                        break;
                    case 156:
                        this.aM.j6(DW(1));
                        FH(156);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
            case 91:
                this.aM.j6(DW(1));
                FH(91);
                break;
            case 126:
                this.aM.j6(DW(1));
                FH(126);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = null;
    }

    public final void j6(int i, AST ast) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        int i2 = 0;
        AST ast2 = ast;
        while (true) {
            int i3;
            AST ast3;
            if (IS.Hw(j6(1)) && gG.Hw(j6(2))) {
                int Zo = Zo();
                ParserSharedInputState parserSharedInputState = this.Ws;
                parserSharedInputState.DW++;
                try {
                    e9();
                    i3 = 1;
                } catch (RecognitionException e) {
                    i3 = 0;
                }
                v5(Zo);
                ParserSharedInputState parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW--;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                if ((j6(1) == 126 || j6(1) == 205) && vy.Hw(j6(2)) && (i == 1 || i == 2)) {
                    Zo = Zo();
                    parserSharedInputState = this.Ws;
                    parserSharedInputState.DW++;
                    try {
                        gn();
                        FH(126);
                        i3 = 1;
                    } catch (RecognitionException e2) {
                        i3 = 0;
                    }
                    v5(Zo);
                    parserSharedInputState2 = this.Ws;
                    parserSharedInputState2.DW--;
                } else {
                    i3 = 0;
                }
                if (i3 == 0) {
                    break;
                }
                mb();
                we(ast2);
                ast3 = this.XL;
                if (this.Ws.DW == 0) {
                }
                ast3 = ast2;
            } else {
                gn();
                EQ(ast2);
                ast3 = this.XL;
                if (this.Ws.DW == 0) {
                }
                ast3 = ast2;
            }
            i2++;
            ast2 = ast3;
        }
        if (i2 >= 1) {
            if (this.Ws.DW == 0) {
                ast3 = aSTPair.j6;
                aSTPair.j6 = ast2;
                if (!(ast2 == null || ast2.j6() == null)) {
                    ast2 = ast2.j6();
                }
                aSTPair.DW = ast2;
                aSTPair.j6();
            }
            this.XL = aSTPair.j6;
            return;
        }
        throw new NoViableAltException(DW(1), v5());
    }

    public final void QO() {
        int i;
        AST j6;
        int i2 = 0;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (j6(1) == 87 && j6(2) == 136) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                FH(87);
                i = 1;
            } catch (RecognitionException e) {
                i = 0;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            i = 0;
        }
        if (i != 0) {
            j6 = this.aM.j6(DW(1));
            this.aM.j6(aSTPair, j6);
            FH(87);
            if (this.Ws.DW == 0) {
                j6.j6(88);
            }
            j6 = aSTPair.j6;
        } else {
            if (Pa.Hw(j6(1)) && j6(2) == 136) {
                i = Zo();
                parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW++;
                try {
                    x9();
                    i2 = 1;
                } catch (RecognitionException e2) {
                }
                v5(i);
                parserSharedInputState = this.Ws;
                parserSharedInputState.DW--;
            }
            if (i2 != 0) {
                x9();
                j6 = this.XL;
                this.aM.j6(aSTPair, this.XL);
                if (this.Ws.DW == 0) {
                    j6.j6(88);
                }
                j6 = aSTPair.j6;
            } else if (a5.Hw(j6(1)) && An.Hw(j6(2))) {
                aX();
                this.aM.j6(aSTPair, this.XL);
                j6 = aSTPair.j6;
            } else {
                throw new NoViableAltException(DW(1), v5());
            }
        }
        this.XL = j6;
    }

    public final void J8(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token j6 = j6(DW(1));
        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
        FH(91);
        gn();
        j6(null, null, j6);
        this.aM.j6(aSTPair, this.XL);
        FH(123);
        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
        FH(124);
        gn();
        u7(i);
        this.aM.j6(aSTPair, this.XL);
        this.XL = aSTPair.j6;
    }

    public final void EQ(AST ast) {
        AST ast2;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        AST ast3;
        switch (j6(1)) {
            case 85:
                J8(ast);
                ast2 = this.XL;
                if (this.Ws.DW == 0) {
                    ast3 = aSTPair.j6;
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            case 90:
            case 154:
            case 155:
            case 156:
            case 205:
                if (this.Ws.DW == 0) {
                    ast2 = aSTPair.j6;
                    aSTPair.j6 = ast;
                    ast2 = (ast == null || ast.j6() == null) ? ast : ast.j6();
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                gn();
                switch (j6(1)) {
                    case 90:
                        FH(90);
                        break;
                    case 154:
                        FH(154);
                        break;
                    case 155:
                        FH(155);
                        break;
                    case 156:
                        FH(156);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                gn();
                switch (j6(1)) {
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                    case 82:
                    case 83:
                    case 84:
                    case 87:
                    case 88:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
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
                    case 126:
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
                    case 197:
                        ast2 = null;
                        break;
                    case 89:
                        BT();
                        ast2 = this.XL;
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                sM();
                ast3 = this.XL;
                if (this.Ws.DW == 0) {
                    AST ast4 = aSTPair.j6;
                    ast2 = this.aM.j6(new ASTArray(4).j6(j6(DW.Hw(), DW.FH(), ast, DW(1))).j6(ast).j6(ast2).j6(ast3));
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            case 91:
                J0(ast);
                ast2 = this.XL;
                if (this.Ws.DW == 0) {
                    ast3 = aSTPair.j6;
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            case 126:
                we(ast);
                ast2 = this.XL;
                if (this.Ws.DW == 0) {
                    ast3 = aSTPair.j6;
                    aSTPair.j6 = ast2;
                    if (!(ast2 == null || ast2.j6() == null)) {
                        ast2 = ast2.j6();
                    }
                    aSTPair.DW = ast2;
                    aSTPair.j6();
                }
                ast2 = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast2;
    }

    public final void we(AST ast) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        q7();
        AST ast2 = this.XL;
        if (this.Ws.DW == 0) {
            AST ast3 = aSTPair.j6;
            if (ast == null || ast.Hw() != 27) {
                ast2 = this.aM.j6(new ASTArray(3).j6(j6(27, "{", ast, DW(1))).j6(ast).j6(ast2));
            } else {
                ast2 = this.aM.j6(new ASTArray(3).j6(j6(27, "(", ast, DW(1))).j6(ast.j6()).j6(ast2));
            }
            aSTPair.j6 = ast2;
            if (!(ast2 == null || ast2.j6() == null)) {
                ast2 = ast2.j6();
            }
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void Ws(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        aX();
        AST ast = this.XL;
        if (this.Ws.DW != 0) {
            ast = null;
        }
        while (true) {
            int i2;
            AST ast2;
            if (IS.Hw(j6(1)) && gG.Hw(j6(2))) {
                int Zo = Zo();
                ParserSharedInputState parserSharedInputState = this.Ws;
                parserSharedInputState.DW++;
                try {
                    e9();
                    i2 = 1;
                } catch (RecognitionException e) {
                    i2 = 0;
                }
                v5(Zo);
                ParserSharedInputState parserSharedInputState2 = this.Ws;
                parserSharedInputState2.DW--;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                if ((j6(1) == 126 || j6(1) == 205) && vy.Hw(j6(2)) && (i == 1 || i == 2)) {
                    Zo = Zo();
                    parserSharedInputState = this.Ws;
                    parserSharedInputState.DW++;
                    try {
                        gn();
                        FH(126);
                        i2 = 1;
                    } catch (RecognitionException e2) {
                        i2 = 0;
                    }
                    v5(Zo);
                    parserSharedInputState2 = this.Ws;
                    parserSharedInputState2.DW--;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    break;
                }
                mb();
                we(ast);
                ast2 = this.XL;
                if (this.Ws.DW == 0) {
                }
                ast2 = ast;
            } else {
                gn();
                EQ(ast);
                ast2 = this.XL;
                if (this.Ws.DW == 0) {
                }
                ast2 = ast;
            }
            ast = ast2;
        }
        if (this.Ws.DW == 0) {
            ast2 = aSTPair.j6;
            this.sT = ast;
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void sM() {
        AST j6;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        DW(1);
        switch (j6(1)) {
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
            case 87:
            case 88:
            case 91:
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
            case 126:
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
            case 197:
                break;
            case 96:
                j6 = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, j6);
                FH(96);
                if (this.Ws.DW == 0) {
                    j6.j6(52);
                    break;
                }
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        switch (j6(1)) {
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
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
                x9();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 87:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(87);
                break;
            case 88:
                j6 = this.aM.j6(DW(1));
                this.aM.j6(aSTPair, j6);
                FH(88);
                if (this.Ws.DW == 0) {
                    j6.j6(87);
                    break;
                }
                break;
            case 91:
            case 197:
                a5();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 126:
                jw();
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void J0(AST ast) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        FH(91);
        Eq();
        AST ast2 = this.XL;
        FH(123);
        if (this.Ws.DW == 0) {
            AST ast3 = aSTPair.j6;
            if (ast == null || ast.j6() == null) {
                ast2 = this.aM.j6(new ASTArray(3).j6(j6(27, "(", ast, DW(1))).j6(ast).j6(ast2));
            } else {
                ast2 = this.aM.j6(new ASTArray(3).j6(j6(27, "(", ast.j6(), DW(1))).j6(ast).j6(ast2));
            }
            aSTPair.j6 = ast2;
            if (!(ast2 == null || ast2.j6() == null)) {
                ast2 = ast2.j6();
            }
            aSTPair.DW = ast2;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void J8(AST ast) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        AST j6 = this.aM.j6(DW(1));
        this.aM.j6(aSTPair, j6);
        FH(85);
        Eq();
        AST ast2 = this.XL;
        FH(86);
        if (this.Ws.DW == 0) {
            AST ast3 = aSTPair.j6;
            if (ast == null || ast.j6() == null) {
                j6 = this.aM.j6(new ASTArray(4).j6(j6(24, "INDEX_OP", ast, DW(1))).j6(j6).j6(ast).j6(ast2));
            } else {
                j6 = this.aM.j6(new ASTArray(4).j6(j6(24, "INDEX_OP", ast.j6(), DW(1))).j6(j6).j6(ast).j6(ast2));
            }
            aSTPair.j6 = j6;
            if (!(j6 == null || j6.j6() == null)) {
                j6 = j6.j6();
            }
            aSTPair.DW = j6;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void a5() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        switch (j6(1)) {
            case 91:
                ys();
                ast = this.XL;
                if (this.Ws.DW == 0) {
                    AST ast2 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(2).j6(j6(28, "EXPR", DW, DW(1))).j6(ast));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                    break;
                }
                break;
            case 197:
                IS();
                this.aM.j6(aSTPair, this.XL);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        if (this.Ws.DW == 0) {
            ast = this.aM.j6(new ASTArray(2).j6(j6(53, "DYNAMIC_MEMBER", DW, DW(1))).j6(aSTPair.j6));
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void ys() {
        Token token = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        boolean z = false;
        FH(91);
        if (this.Ws.DW == 0) {
            token = DW(1);
        }
        boolean VH = VH(true);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 128) {
            FH(128);
            if (this.Ws.DW == 0) {
                z = true;
            }
            switch (j6(1)) {
                case 38:
                case 39:
                case 43:
                case 83:
                case 84:
                case 85:
                case 87:
                case 88:
                case 91:
                case 96:
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
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 126:
                case 132:
                case 143:
                case 144:
                case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                case 146:
                case 147:
                case 148:
                case 149:
                case 157:
                case 159:
                case 160:
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                case 190:
                case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                case 195:
                case 196:
                case 197:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                    VH(true);
                    this.aM.j6(aSTPair, this.XL);
                    break;
                case 123:
                case 128:
                    if (this.Ws.DW != 0) {
                        break;
                    }
                    this.aM.j6(aSTPair, this.aM.j6(37, "EMPTY_STAT"));
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
        }
        if (this.Ws.DW == 0 && VH && !z) {
            throw new NoViableAltException(token, v5());
        }
        FH(123);
        if (this.Ws.DW == 0) {
            AST ast = aSTPair.j6;
            if (z) {
                ast = this.aM.j6(new ASTArray(2).j6(j6(77, "CLOSURE_LIST", DW, DW(1))).j6(ast));
            }
            aSTPair.j6 = ast;
            if (!(ast == null || ast.j6() == null)) {
                ast = ast.j6();
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void IS() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        AST j6 = this.aM.j6(DW(1));
        this.aM.j6(aSTPair, j6);
        FH(197);
        if (this.Ws.DW == 0) {
            j6.j6(88);
        }
        Za();
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 49) {
            j6 = this.aM.j6(DW(1));
            this.aM.j6(aSTPair, j6);
            FH(49);
            if (this.Ws.DW == 0) {
                j6.j6(88);
            }
            Za();
            this.aM.j6(aSTPair, this.XL);
        }
        j6 = this.aM.j6(DW(1));
        this.aM.j6(aSTPair, j6);
        FH(198);
        if (this.Ws.DW == 0) {
            AST ast = aSTPair.j6;
            j6.j6(88);
            AST j62 = this.aM.j6(new ASTArray(2).j6(j6(48, "STRING_CONSTRUCTOR", DW, DW(1))).j6(ast));
            aSTPair.j6 = j62;
            if (!(j62 == null || j62.j6() == null)) {
                j62 = j62.j6();
            }
            aSTPair.DW = j62;
            aSTPair.j6();
        }
        this.XL = aSTPair.j6;
    }

    public final void QX(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        XL(i);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 175) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(175);
            gn();
            XL(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void XL(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        aM(i);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 176) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(176);
            gn();
            aM(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void aM(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        j3(i);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 134) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(134);
            gn();
            j3(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void j3(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Mr(i);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == ProxyTextView.INPUTTYPE_textFilter) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(ProxyTextView.INPUTTYPE_textFilter);
            gn();
            Mr(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void Mr(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        U2(i);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 125) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(125);
            gn();
            U2(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void U2(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        a8(i);
        this.aM.j6(aSTPair, this.XL);
        while (true) {
            if (j6(1) == 178 || j6(1) == 179) {
                switch (j6(1)) {
                    case 178:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(178);
                        break;
                    case 179:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(179);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                gn();
                a8(0);
                this.aM.j6(aSTPair, this.XL);
            } else {
                this.XL = aSTPair.j6;
                return;
            }
        }
    }

    public final void a8(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        lg(i);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) >= 180 && j6(1) <= 184) {
            switch (j6(1)) {
                case 180:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(180);
                    break;
                case 181:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(181);
                    break;
                case 182:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(182);
                    break;
                case 183:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(183);
                    break;
                case 184:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(184);
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
            gn();
            lg(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void lg(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        EQ(i);
        this.aM.j6(aSTPair, this.XL);
        if (ce.Hw(j6(1)) && pN.Hw(j6(2))) {
            switch (j6(1)) {
                case 89:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(89);
                    break;
                case 100:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(100);
                    break;
                case 142:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(142);
                    break;
                case 185:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(185);
                    break;
                case 186:
                    this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                    FH(186);
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
            gn();
            EQ(0);
            this.aM.j6(aSTPair, this.XL);
        } else if (j6(1) == 158 && Jm.Hw(j6(2))) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(158);
            gn();
            j6(true);
            this.aM.j6(aSTPair, this.XL);
        } else if (j6(1) == 114 && Jm.Hw(j6(2))) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(114);
            gn();
            j6(true);
            this.aM.j6(aSTPair, this.XL);
        } else if (!(Bx.Hw(j6(1)) && hz.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void rN(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        er(i);
        this.aM.j6(aSTPair, this.XL);
        while (true) {
            if ((j6(1) == 148 || j6(1) == 149) && pN.Hw(j6(2))) {
                switch (j6(1)) {
                    case 148:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(148);
                        break;
                    case 149:
                        this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                        FH(149);
                        break;
                    default:
                        throw new NoViableAltException(DW(1), v5());
                }
                gn();
                er(0);
                this.aM.j6(aSTPair, this.XL);
            } else {
                this.XL = aSTPair.j6;
                return;
            }
        }
    }

    public final void er(int i) {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        AST j6;
        switch (j6(1)) {
            case 85:
            case 87:
            case 88:
            case 91:
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
            case 126:
            case 132:
            case 157:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                yS(i);
                this.aM.j6(aSTPair, this.XL);
                while (oa.Hw(j6(1))) {
                    switch (j6(1)) {
                        case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(ProxyTextView.INPUTTYPE_textPostalAddress);
                            break;
                        case 191:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(191);
                            break;
                        case 192:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(192);
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                    gn();
                    gW(0);
                    this.aM.j6(aSTPair, this.XL);
                }
                ast = aSTPair.j6;
                break;
            case 148:
                j6 = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, j6);
                FH(148);
                if (this.Ws.DW == 0) {
                    j6.j6(31);
                }
                gn();
                yS(0);
                this.aM.j6(aSTPair, this.XL);
                while (oa.Hw(j6(1))) {
                    switch (j6(1)) {
                        case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(ProxyTextView.INPUTTYPE_textPostalAddress);
                            break;
                        case 191:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(191);
                            break;
                        case 192:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(192);
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                    gn();
                    gW(0);
                    this.aM.j6(aSTPair, this.XL);
                }
                ast = aSTPair.j6;
                break;
            case 149:
                j6 = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, j6);
                FH(149);
                if (this.Ws.DW == 0) {
                    j6.j6(30);
                }
                gn();
                yS(0);
                this.aM.j6(aSTPair, this.XL);
                while (oa.Hw(j6(1))) {
                    switch (j6(1)) {
                        case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(ProxyTextView.INPUTTYPE_textPostalAddress);
                            break;
                        case 191:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(191);
                            break;
                        case 192:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(192);
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                    gn();
                    gW(0);
                    this.aM.j6(aSTPair, this.XL);
                }
                ast = aSTPair.j6;
                break;
            case 190:
                this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                FH(190);
                gn();
                yS(0);
                this.aM.j6(aSTPair, this.XL);
                while (oa.Hw(j6(1))) {
                    switch (j6(1)) {
                        case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(ProxyTextView.INPUTTYPE_textPostalAddress);
                            break;
                        case 191:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(191);
                            break;
                        case 192:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(192);
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                    gn();
                    gW(0);
                    this.aM.j6(aSTPair, this.XL);
                }
                ast = aSTPair.j6;
                break;
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                FH(ProxyTextView.INPUTTYPE_textPhonetic);
                gn();
                yS(0);
                this.aM.j6(aSTPair, this.XL);
                while (oa.Hw(j6(1))) {
                    switch (j6(1)) {
                        case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(ProxyTextView.INPUTTYPE_textPostalAddress);
                            break;
                        case 191:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(191);
                            break;
                        case 192:
                            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                            FH(192);
                            break;
                        default:
                            throw new NoViableAltException(DW(1), v5());
                    }
                    gn();
                    gW(0);
                    this.aM.j6(aSTPair, this.XL);
                }
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void yS(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        vy(i);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 194) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(194);
            gn();
            BT(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void gW(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        BT(i);
        this.aM.j6(aSTPair, this.XL);
        while (j6(1) == 194) {
            this.aM.DW(aSTPair, this.aM.j6(DW(1)));
            FH(194);
            gn();
            BT(0);
            this.aM.j6(aSTPair, this.XL);
        }
        this.XL = aSTPair.j6;
    }

    public final void BT(int i) {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        AST j6;
        switch (j6(1)) {
            case 85:
            case 87:
            case 88:
            case 91:
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
            case 126:
            case 132:
            case 157:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 195:
            case 196:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                vy(i);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 148:
                j6 = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, j6);
                FH(148);
                if (this.Ws.DW == 0) {
                    j6.j6(31);
                }
                gn();
                BT(0);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 149:
                j6 = this.aM.j6(DW(1));
                this.aM.DW(aSTPair, j6);
                FH(149);
                if (this.Ws.DW == 0) {
                    j6.j6(30);
                }
                gn();
                BT(0);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case 190:
                this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                FH(190);
                gn();
                BT(0);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                FH(ProxyTextView.INPUTTYPE_textPhonetic);
                gn();
                BT(0);
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void vy(int i) {
        AST j6;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 85:
            case 87:
            case 88:
            case 91:
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
            case 126:
            case 132:
            case 157:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 197:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                boolean z;
                int Zo;
                ParserSharedInputState parserSharedInputState;
                ParserSharedInputState parserSharedInputState2;
                if (j6(1) != 91 || j6(2) < 104 || j6(2) > 112) {
                    z = false;
                } else {
                    Zo = Zo();
                    parserSharedInputState = this.Ws;
                    parserSharedInputState.DW++;
                    try {
                        FH(91);
                        FH(true);
                        FH(123);
                        BT(0);
                        z = true;
                    } catch (RecognitionException e) {
                        z = false;
                    }
                    v5(Zo);
                    parserSharedInputState2 = this.Ws;
                    parserSharedInputState2.DW--;
                }
                if (z) {
                    j6 = this.aM.j6(DW(1));
                    this.aM.DW(aSTPair, j6);
                    FH(91);
                    if (this.Ws.DW == 0) {
                        j6.j6(23);
                    }
                    FH(true);
                    this.aM.j6(aSTPair, this.XL);
                    FH(123);
                    BT(0);
                    this.aM.j6(aSTPair, this.XL);
                } else {
                    if (j6(1) == 91 && j6(2) == 87) {
                        Zo = Zo();
                        parserSharedInputState = this.Ws;
                        parserSharedInputState.DW++;
                        try {
                            FH(91);
                            DW(true);
                            FH(123);
                            vy(0);
                            z = true;
                        } catch (RecognitionException e2) {
                            z = false;
                        }
                        v5(Zo);
                        parserSharedInputState2 = this.Ws;
                        parserSharedInputState2.DW--;
                    } else {
                        z = false;
                    }
                    if (z) {
                        j6 = this.aM.j6(DW(1));
                        this.aM.DW(aSTPair, j6);
                        FH(91);
                        if (this.Ws.DW == 0) {
                            j6.j6(23);
                        }
                        DW(true);
                        this.aM.j6(aSTPair, this.XL);
                        FH(123);
                        vy(0);
                        this.aM.j6(aSTPair, this.XL);
                    } else if (a5.Hw(j6(1)) && Qq.Hw(j6(2))) {
                        P8(i);
                        this.aM.j6(aSTPair, this.XL);
                    } else {
                        throw new NoViableAltException(DW(1), v5());
                    }
                }
                j6 = aSTPair.j6;
                break;
            case 195:
                this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                FH(195);
                gn();
                BT(0);
                this.aM.j6(aSTPair, this.XL);
                j6 = aSTPair.j6;
                break;
            case 196:
                this.aM.DW(aSTPair, this.aM.j6(DW(1)));
                FH(196);
                gn();
                BT(0);
                this.aM.j6(aSTPair, this.XL);
                j6 = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = j6;
    }

    public final void P8(int i) {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Ws(i);
        this.aM.j6(aSTPair, this.XL);
        AST j6;
        if (j6(1) == 190 && qP.Hw(j6(2))) {
            j6 = this.aM.j6(DW(1));
            this.aM.DW(aSTPair, j6);
            FH(190);
            if (this.Ws.DW == 0) {
                j6.j6(25);
            }
        } else if (j6(1) == ProxyTextView.INPUTTYPE_textPhonetic && qP.Hw(j6(2))) {
            j6 = this.aM.j6(DW(1));
            this.aM.DW(aSTPair, j6);
            FH(ProxyTextView.INPUTTYPE_textPhonetic);
            if (this.Ws.DW == 0) {
                j6.j6(26);
            }
        } else if (!(qP.Hw(j6(1)) && hz.Hw(j6(2)))) {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void gG() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 88:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(88);
                ast = aSTPair.j6;
                break;
            case 157:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(157);
                ast = aSTPair.j6;
                break;
            case 160:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(160);
                ast = aSTPair.j6;
                break;
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(ProxyTextView.INPUTTYPE_textWebEditText);
                ast = aSTPair.j6;
                break;
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                Jm();
                this.aM.j6(aSTPair, this.XL);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void Nh() {
        AST ast;
        AST ast2 = null;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        Token DW = DW(1);
        FH(159);
        gn();
        switch (j6(1)) {
            case 87:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
                ast = null;
                break;
            case 89:
                BT();
                ast = this.XL;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        sG();
        AST ast3 = this.XL;
        AST ast4;
        switch (j6(1)) {
            case 85:
                An();
                ast2 = this.XL;
                if (this.Ws.DW == 0) {
                    ast4 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(4).j6(j6(159, "new", DW, DW(1))).j6(ast).j6(ast3).j6(ast2));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                    break;
                }
                break;
            case 91:
            case 205:
                gn();
                J0(null);
                ast4 = this.XL;
                if (j6(1) == 126 && FN.Hw(j6(2))) {
                    aj();
                    ast2 = this.XL;
                    this.aM.j6(aSTPair, this.XL);
                } else if (!(MP.Hw(j6(1)) && hz.Hw(j6(2)))) {
                    throw new NoViableAltException(DW(1), v5());
                }
                if (this.Ws.DW == 0) {
                    AST ast5 = aSTPair.j6;
                    ast = this.aM.j6(new ASTArray(5).j6(j6(159, "new", DW, DW(1))).j6(ast).j6(ast3).j6(ast4.j6()).j6(ast2));
                    aSTPair.j6 = ast;
                    if (!(ast == null || ast.j6() == null)) {
                        ast = ast.j6();
                    }
                    aSTPair.DW = ast;
                    aSTPair.j6();
                    break;
                }
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void BR() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        q7();
        this.aM.j6(aSTPair, this.XL);
        this.XL = aSTPair.j6;
    }

    public final void AE() {
        AST j6;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        int i = 0;
        if (j6(1) == 85 && Of.Hw(j6(2))) {
            AST j62 = this.aM.j6(DW(1));
            FH(85);
            Eq();
            AST ast = this.XL;
            this.aM.j6(aSTPair, this.XL);
            if (this.Ws.DW == 0) {
                i = 0 | this.Lz;
            }
            FH(86);
            if (this.Ws.DW == 0) {
                AST ast2 = aSTPair.j6;
                j6 = this.aM.j6(new ASTArray(2).j6(j6(i != 0 ? 58 : 57, "[", j62, DW(1))).j6(ast));
                aSTPair.j6 = j6;
                if (!(j6 == null || j6.j6() == null)) {
                    j6 = j6.j6();
                }
                aSTPair.DW = j6;
                aSTPair.j6();
            }
            j6 = aSTPair.j6;
        } else if (j6(1) == 85 && j6(2) == 136) {
            j6 = this.aM.j6(DW(1));
            this.aM.DW(aSTPair, j6);
            FH(85);
            FH(136);
            FH(86);
            if (this.Ws.DW == 0) {
                j6.j6(58);
            }
            j6 = aSTPair.j6;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        this.XL = j6;
    }

    public final void Za() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 87:
                we();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 99:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(99);
                break;
            case 126:
                Z1();
                this.aM.j6(aSTPair, this.XL);
                break;
            case 132:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(132);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = aSTPair.j6;
    }

    public final void An() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        int i = 0;
        while (j6(1) == 85 && PT.Hw(j6(2))) {
            AST j6 = this.aM.j6(DW(1));
            this.aM.DW(aSTPair, j6);
            FH(85);
            if (this.Ws.DW == 0) {
                j6.j6(17);
            }
            switch (j6(1)) {
                case 85:
                case 87:
                case 88:
                case 91:
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
                case 126:
                case 132:
                case 148:
                case 149:
                case 157:
                case 159:
                case 160:
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                case 190:
                case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                case 195:
                case 196:
                case 197:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                    we(0);
                    this.aM.j6(aSTPair, this.XL);
                    break;
                case 86:
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
            FH(86);
            i++;
        }
        if (i >= 1) {
            this.XL = aSTPair.j6;
            return;
        }
        throw new NoViableAltException(DW(1), v5());
    }

    public final byte Pa() {
        boolean z;
        byte b;
        boolean z2 = true;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        if (Za.Hw(j6(1)) && An.Hw(j6(2))) {
            int Zo = Zo();
            ParserSharedInputState parserSharedInputState = this.Ws;
            parserSharedInputState.DW++;
            try {
                ce();
                z = true;
            } catch (RecognitionException e) {
                z = false;
            }
            v5(Zo);
            ParserSharedInputState parserSharedInputState2 = this.Ws;
            parserSharedInputState2.DW--;
        } else {
            z = false;
        }
        if (z) {
            QO();
            this.aM.j6(aSTPair, this.XL);
            AST j6 = this.aM.j6(DW(1));
            this.aM.DW(aSTPair, j6);
            FH(136);
            if (this.Ws.DW == 0) {
                j6.j6(54);
            }
            b = this.Ws.DW == 0 ? (byte) 1 : (byte) 0;
        } else if (j6(1) == ProxyTextView.INPUTTYPE_textPostalAddress) {
            AST j62 = this.aM.j6(DW(1));
            this.aM.DW(aSTPair, j62);
            FH(ProxyTextView.INPUTTYPE_textPostalAddress);
            if (this.Ws.DW == 0) {
                j62.j6(55);
            }
            if (this.Ws.DW == 0) {
                b = (byte) 2;
            } else {
                b = (byte) 0;
            }
            switch (j6(1)) {
                case 38:
                case 39:
                case 43:
                case 83:
                case 84:
                case 85:
                case 87:
                case 88:
                case 91:
                case 96:
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
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 126:
                case 132:
                case 143:
                case 144:
                case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                case 146:
                case 147:
                case 148:
                case 149:
                case 157:
                case 159:
                case 160:
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                case 190:
                case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                case 195:
                case 196:
                case 197:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                    break;
                case 136:
                    FH(136);
                    if (this.Ws.DW == 0) {
                        j62.j6(56);
                    }
                    if (this.Ws.DW == 0) {
                        b = (byte) (b | 1);
                        break;
                    }
                    break;
                default:
                    throw new NoViableAltException(DW(1), v5());
            }
        } else if (aX.Hw(j6(1)) && b1.Hw(j6(2))) {
            b = (byte) 0;
        } else {
            throw new NoViableAltException(DW(1), v5());
        }
        VH(true);
        this.aM.j6(aSTPair, this.XL);
        if (this.Ws.DW == 0) {
            if (j6(1) == 136) {
                z2 = false;
            }
            j6(z2, "illegal colon after argument expression", "a complex label expression before a colon must be parenthesized");
        }
        this.XL = aSTPair.j6;
        return b;
    }

    public final void ce() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
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
                x9();
                break;
            case 85:
            case 91:
            case 126:
            case 197:
                Bx();
                break;
            case 87:
                this.aM.j6(DW(1));
                FH(87);
                break;
            case 88:
                this.aM.j6(DW(1));
                FH(88);
                break;
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
                Jm();
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.aM.j6(DW(1));
        FH(136);
        this.XL = null;
    }

    public final void Jm() {
        AST ast;
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 199:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(199);
                ast = aSTPair.j6;
                break;
            case 200:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(200);
                ast = aSTPair.j6;
                break;
            case 201:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(201);
                ast = aSTPair.j6;
                break;
            case 202:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(202);
                ast = aSTPair.j6;
                break;
            case 203:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(203);
                ast = aSTPair.j6;
                break;
            case 204:
                this.aM.j6(aSTPair, this.aM.j6(DW(1)));
                FH(204);
                ast = aSTPair.j6;
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = ast;
    }

    public final void Bx() {
        this.XL = null;
        ASTPair aSTPair = new ASTPair();
        switch (j6(1)) {
            case 85:
                this.aM.j6(DW(1));
                FH(85);
                vy();
                this.aM.j6(DW(1));
                FH(86);
                break;
            case 91:
                this.aM.j6(DW(1));
                FH(91);
                vy();
                this.aM.j6(DW(1));
                FH(123);
                break;
            case 126:
                this.aM.j6(DW(1));
                FH(126);
                vy();
                this.aM.j6(DW(1));
                FH(127);
                break;
            case 197:
                this.aM.j6(DW(1));
                FH(197);
                vy();
                this.aM.j6(DW(1));
                FH(198);
                break;
            default:
                throw new NoViableAltException(DW(1), v5());
        }
        this.XL = null;
    }

    protected void oa() {
        this.j3 = null;
    }

    private static final long[] qP() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743042L;
        jArr[1] = 5186456864203472896L;
        jArr[2] = 4611686034009209361L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] MP() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -576460889742508032L;
        jArr[2] = -1;
        jArr[3] = 16319;
        return jArr;
    }

    private static final long[] Of() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -131072;
        jArr[2] = 4755801206503243775L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] PT() {
        long[] jArr = new long[16];
        jArr[0] = -14;
        for (int i = 1; i <= 2; i++) {
            jArr[i] = -1;
        }
        jArr[3] = 549755813887L;
        return jArr;
    }

    private static final long[] b1() {
        return new long[]{0, 4303749120L, 0, 0};
    }

    private static final long[] AR() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -4036915073080885248L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] TI() {
        return new long[]{0, 8781824, 0, 0};
    }

    private static final long[] ct() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -4036915073617756160L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] Fd() {
        long[] jArr = new long[8];
        jArr[2] = 1025;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] Lz() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 5186456864203472896L;
        jArr[2] = 4611686034009210385L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] sT() {
        long[] jArr = new long[8];
        jArr[0] = 2;
        jArr[1] = Long.MIN_VALUE;
        jArr[2] = 4195331;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] E4() {
        long[] jArr = new long[8];
        jArr[0] = 580267261558786L;
        jArr[1] = -131072;
        jArr[2] = -33;
        jArr[3] = 16383;
        return jArr;
    }

    private static final long[] xg() {
        return new long[]{9620726743040L, 574208956786278400L, 0, 0};
    }

    private static final long[] hp() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574208957365092352L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] PH() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574770807907549184L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] GK() {
        return new long[]{9620726743040L, 574770807236460544L, 0, 0};
    }

    private static final long[] dW() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574770807892869120L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] Yi() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -4036915172651302912L;
        jArr[2] = 4611686034009209521L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] GT() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 5186456864203472896L;
        jArr[2] = 4611686034009209360L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] Hl() {
        long[] jArr = new long[8];
        jArr[1] = 4612247903390400512L;
        jArr[2] = 4611686033999790096L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] pl() {
        return new long[]{0, 545783808, 0, 0};
    }

    private static final long[] oh() {
        return new long[]{9620726743040L, 574208960812810240L, 0, 0};
    }

    private static final long[] Ej() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574208960821198848L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] T6() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743042L;
        jArr[1] = -4036915172617748480L;
        jArr[2] = 4611686034013404691L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] cc() {
        return new long[]{0, 561850450182144L, 0, 0};
    }

    private static final long[] Od() {
        return new long[]{0, 127926272, 0, 0};
    }

    private static final long[] om() {
        long[] jArr = new long[8];
        jArr[0] = 2;
        jArr[1] = -8070450394674757632L;
        jArr[2] = 4195331;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] wE() {
        long[] jArr = new long[8];
        jArr[0] = 2;
        jArr[1] = -8070450394808975360L;
        jArr[2] = 4195331;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] d8() {
        long[] jArr = new long[8];
        jArr[1] = 8388608;
        jArr[2] = 4;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] N0() {
        long[] jArr = new long[8];
        jArr[0] = 2;
        jArr[1] = -4611686018427387904L;
        jArr[2] = 4195331;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] eN() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -4036915172651302912L;
        jArr[2] = 4611686034009209361L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] zf() {
        return new long[]{0, 111149056, 0, 0};
    }

    private static final long[] fP() {
        return new long[]{2, 1729382394353418240L, 16641, 0, 0, 0};
    }

    private static final long[] b() {
        return new long[]{9620726743040L, 574770807355998208L, 0, 0};
    }

    private static final long[] ba() {
        return new long[]{9620726743040L, 574770807288889344L, 0, 0};
    }

    private static final long[] u9() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = 5764043533593739264L;
        jArr[2] = 4611686035137494558L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] Ak() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743042L;
        jArr[1] = -8072140335660269568L;
        jArr[2] = 33;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] nl() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -131072;
        jArr[2] = -1;
        jArr[3] = 16319;
        return jArr;
    }

    private static final long[] ti() {
        long[] jArr = new long[8];
        jArr[1] = 561859040116736L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] k1() {
        return new long[]{0, 893353197568L, 0, 0};
    }

    private static final long[] iK() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -562949987106816L;
        jArr[2] = 4755801206033481727L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] fh() {
        long[] jArr = new long[8];
        jArr[1] = 4611686018563702784L;
        jArr[3] = 32;
        return jArr;
    }

    private static final long[] sv() {
        long[] jArr = new long[16];
        jArr[0] = -16;
        jArr[1] = 4035225265983455231L;
        jArr[2] = -1;
        jArr[3] = 549755813791L;
        return jArr;
    }

    private static final long[] HT() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574770811296546816L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] oT() {
        return new long[]{0, 561858805235712L, 0, 0};
    }

    private static final long[] hx() {
        long[] jArr = new long[8];
        jArr[0] = 2;
        jArr[1] = 799014912;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] qU() {
        return new long[]{9620726743040L, 574208952490262528L, 0, 0};
    }

    private static final long[] uC() {
        long[] jArr = new long[8];
        jArr[1] = 4612247907685367808L;
        jArr[2] = 4611686033999790096L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] ep() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = -1152921642045931520L;
        jArr[2] = -70351564308481L;
        jArr[3] = 16319;
        return jArr;
    }

    private static final long[] HO() {
        return new long[]{17317308137472L, 575896758414868480L, 16706960926L, 0, 0, 0};
    }

    private static final long[] qI() {
        long[] jArr = new long[8];
        jArr[1] = 4612247903390400512L;
        jArr[2] = 4611756402743967760L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] DY() {
        long[] jArr = new long[8];
        jArr[1] = 4612247911980335104L;
        jArr[2] = 4611686033999790096L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] tj() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -2306406865506009088L;
        jArr[2] = 4611756386701803423L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] pn() {
        long[] jArr = new long[8];
        jArr[0] = 580267261558786L;
        jArr[1] = -131072;
        jArr[2] = -1;
        jArr[3] = 16383;
        return jArr;
    }

    private static final long[] x6() {
        long[] jArr = new long[8];
        jArr[1] = -4611685880308957184L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] k4() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -4036915207164395520L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] RW() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743042L;
        jArr[1] = -4036915172550639616L;
        jArr[2] = 4611686034013404691L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] Vq() {
        long[] jArr = new long[8];
        jArr[1] = 4612248916866367488L;
        jArr[2] = 8;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] cX() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -2883992654331772928L;
        jArr[2] = 9;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] ya() {
        return new long[]{9620726743040L, 574208956794667008L, 0, 0};
    }

    private static final long[] ir() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574208957465755648L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] uD() {
        long[] jArr = new long[8];
        jArr[1] = -8070450394674757632L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] HE() {
        long[] jArr = new long[8];
        jArr[1] = -9223371899415822336L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] h2() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743042L;
        jArr[1] = -4036915069725442048L;
        jArr[2] = 4195331;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] gy() {
        long[] jArr = new long[8];
        jArr[1] = -9223371895112466432L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] F3() {
        long[] jArr = new long[8];
        jArr[1] = 4303355904L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] S4() {
        long[] jArr = new long[8];
        jArr[1] = -4611685876013989888L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] tv() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574770807823663104L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] gM() {
        return new long[]{9620726743040L, 574770807270014976L, 0, 0};
    }

    private static final long[] tR() {
        long[] jArr = new long[8];
        jArr[1] = -4611686018427387904L;
        jArr[2] = 1;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] ji() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -4036915035178795008L;
        jArr[2] = 4611686034009209361L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] ME() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -4036915172617748480L;
        jArr[2] = 4611686034009209361L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] C() {
        return new long[]{0, 34393292800L, 16, 0, 0, 0};
    }

    private static final long[] dH() {
        long[] jArr = new long[8];
        jArr[1] = 561859174334464L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] BN() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = -576460889742508032L;
        jArr[2] = -1;
        jArr[3] = 16319;
        return jArr;
    }

    private static final long[] jn() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 5186456864203472896L;
        jArr[2] = 4611686034009209361L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] DP() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -3459328370112856064L;
        jArr[2] = 4611686035137494943L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] ee() {
        return new long[]{0, 111149056, 32, 0, 0, 0};
    }

    private static final long[] K3() {
        long[] jArr = new long[8];
        jArr[1] = 1729382394357612544L;
        jArr[2] = 128;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] OM() {
        return new long[]{0, 109051904, 64, 0, 0, 0};
    }

    private static final long[] Qs() {
        long[] jArr = new long[8];
        jArr[0] = 274877906944L;
        jArr[1] = 561854746198016L;
        jArr[2] = 160;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] g0() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = -2883993530504839168L;
        jArr[2] = 4611686034009209521L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] fd() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 5186456860176678912L;
        jArr[2] = 4611686034000805905L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] Lx() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = -137439084544L;
        jArr[2] = -1;
        jArr[3] = 16319;
        return jArr;
    }

    private static final long[] wC() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574770807876091904L;
        jArr[2] = 16640;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] hG() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 574770807876091904L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] s0() {
        long[] jArr = new long[8];
        jArr[1] = 4611686018427387904L;
        jArr[2] = 16777216;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] zg() {
        long[] jArr = new long[8];
        jArr[1] = 4612247903390400512L;
        jArr[2] = 4611686033999790096L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] J1() {
        long[] jArr = new long[8];
        jArr[0] = 2;
        jArr[1] = -8646911147108204544L;
        jArr[2] = 4195331;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] N2() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743040L;
        jArr[1] = 5186456860176678912L;
        jArr[2] = 4611686034000805904L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] NZ() {
        return new long[]{0, 824633720832L, 4035225266123964416L, 0, 0, 0};
    }

    private static final long[] IM() {
        long[] jArr = new long[8];
        jArr[0] = -16;
        jArr[1] = -4611686018427387905L;
        jArr[2] = -1;
        jArr[3] = 549755813887L;
        return jArr;
    }

    private static final long[] jg() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = 5187582776995348480L;
        jArr[2] = 4611686035137494558L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] eQ() {
        long[] jArr = new long[8];
        jArr[1] = 4612247903390400512L;
        jArr[2] = 15569256464L;
        jArr[3] = 8096;
        return jArr;
    }

    private static final long[] BJ() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -3458765415763804160L;
        jArr[2] = 4611686035607257023L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] Sc() {
        long[] jArr = new long[8];
        jArr[1] = 4611686018630811648L;
        jArr[2] = 469762048;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] jD() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = -3458765553202757632L;
        jArr[2] = 4611686035607256767L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] UF() {
        long[] jArr = new long[8];
        jArr[0] = 9620726743042L;
        jArr[1] = 5186456860176678912L;
        jArr[2] = 4611686034000805904L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] rB() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -576460752303554560L;
        jArr[2] = -1;
        jArr[3] = 16319;
        return jArr;
    }

    private static final long[] CN() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = 5187582776995348480L;
        jArr[2] = 4611686035137494558L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] oC() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = 5187582776995348480L;
        jArr[2] = 16706960926L;
        jArr[3] = 8096;
        return jArr;
    }

    private static final long[] Dm() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = -4035226305573289984L;
        jArr[2] = 4611686035137494975L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] re() {
        return new long[]{17317308137472L, 575896758406479872L, 16706960926L, 0, 0, 0};
    }

    private static final long[] TE() {
        return new long[]{0, 68753031168L, 432345564227584000L, 0, 0, 0};
    }

    private static final long[] df() {
        long[] jArr = new long[8];
        jArr[1] = 561850450182144L;
        jArr[3] = 8192;
        return jArr;
    }

    private static final long[] p8() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -563847702380544L;
        jArr[2] = 4755801206033481695L;
        jArr[3] = 16314;
        return jArr;
    }

    private static final long[] Z3() {
        long[] jArr = new long[8];
        jArr[1] = 562949953421312L;
        jArr[2] = Long.MIN_VALUE;
        jArr[3] = 1;
        return jArr;
    }

    private static final long[] mu() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -4362207232L;
        jArr[2] = -469762081;
        jArr[3] = 16319;
        return jArr;
    }

    private static final long[] oP() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137474L;
        jArr[1] = -4295098368L;
        jArr[2] = -33;
        jArr[3] = 16319;
        return jArr;
    }

    private static final long[] LA() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = 5188145731247931392L;
        jArr[2] = 4611686035137494558L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] yu() {
        long[] jArr = new long[8];
        jArr[1] = 4612247903394594816L;
        jArr[2] = 4611686033999790096L;
        jArr[3] = 8122;
        return jArr;
    }

    private static final long[] e4() {
        long[] jArr = new long[8];
        jArr[0] = 17317308137472L;
        jArr[1] = -131072;
        jArr[2] = -1;
        jArr[3] = 16319;
        return jArr;
    }
}
