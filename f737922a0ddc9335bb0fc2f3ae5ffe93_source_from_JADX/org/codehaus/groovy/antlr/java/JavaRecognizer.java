package org.codehaus.groovy.antlr.java;

import groovyjarjarantlr.LLkParser;
import groovyjarjarantlr.collections.impl.BitSet;
import org.codehaus.groovy.antlr.GroovySourceAST;

public class JavaRecognizer extends LLkParser implements JavaTokenTypes {
    public static final BitSet BT;
    public static final BitSet DW;
    public static final BitSet EQ;
    public static final BitSet FH;
    public static final BitSet Hw;
    public static final BitSet I;
    public static final BitSet J0;
    public static final BitSet KD;
    public static final BitSet Mz;
    public static final BitSet OW;
    public static final BitSet P8;
    public static final BitSet Qq;
    public static final BitSet SI;
    public static final BitSet Sf;
    public static final BitSet U2;
    public static final BitSet VH;
    private static GroovySourceAST XG;
    public static final BitSet XX;
    public static final BitSet Zo;
    public static final BitSet a8;
    public static final BitSet aj;
    public static final BitSet br;
    public static final BitSet ca;
    public static final BitSet cb;
    public static final BitSet cn;
    public static final BitSet dx;
    public static final BitSet ef;
    public static final BitSet ei;
    public static final BitSet er;
    public static final BitSet g3;
    public static final BitSet gW;
    public static final BitSet gn;
    public static final String[] j6;
    public static final BitSet kQ;
    public static final BitSet lg;
    public static final BitSet lp;
    public static final BitSet nw;
    public static final BitSet rN;
    public static final BitSet ro;
    public static final BitSet sG;
    public static final BitSet sh;
    public static final BitSet sy;
    public static final BitSet tp;
    public static final BitSet u7;
    public static final BitSet v5;
    public static final BitSet vJ;
    public static final BitSet vy;
    public static final BitSet we;
    public static final BitSet x9;
    public static final BitSet yO;
    public static final BitSet yS;

    static {
        XG = new GroovySourceAST();
        j6 = new String[]{"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "BLOCK", "MODIFIERS", "OBJBLOCK", "SLIST", "METHOD_DEF", "VARIABLE_DEF", "INSTANCE_INIT", "STATIC_INIT", "TYPE", "CLASS_DEF", "INTERFACE_DEF", "PACKAGE_DEF", "ARRAY_DECLARATOR", "EXTENDS_CLAUSE", "IMPLEMENTS_CLAUSE", "PARAMETERS", "PARAMETER_DEF", "LABELED_STAT", "TYPECAST", "INDEX_OP", "POST_INC", "POST_DEC", "METHOD_CALL", "EXPR", "ARRAY_INIT", "IMPORT", "UNARY_MINUS", "UNARY_PLUS", "CASE_GROUP", "ELIST", "FOR_INIT", "FOR_CONDITION", "FOR_ITERATOR", "EMPTY_STAT", "\"final\"", "\"abstract\"", "\"strictfp\"", "SUPER_CTOR_CALL", "CTOR_CALL", "VARIABLE_PARAMETER_DEF", "STATIC_IMPORT", "ENUM_DEF", "ENUM_CONSTANT_DEF", "FOR_EACH_CLAUSE", "ANNOTATION_DEF", "ANNOTATIONS", "ANNOTATION", "ANNOTATION_MEMBER_VALUE_PAIR", "ANNOTATION_FIELD_DEF", "ANNOTATION_ARRAY_INIT", "TYPE_ARGUMENTS", "TYPE_ARGUMENT", "TYPE_PARAMETERS", "TYPE_PARAMETER", "WILDCARD_TYPE", "TYPE_UPPER_BOUNDS", "TYPE_LOWER_BOUNDS", "\"package\"", "SEMI", "\"import\"", "\"static\"", "LBRACK", "RBRACK", "IDENT", "DOT", "QUESTION", "\"extends\"", "\"super\"", "LT", "COMMA", "GT", "SR", "BSR", "\"void\"", "\"boolean\"", "\"byte\"", "\"char\"", "\"short\"", "\"int\"", "\"float\"", "\"long\"", "\"double\"", "STAR", "\"private\"", "\"public\"", "\"protected\"", "\"transient\"", "\"native\"", "\"threadsafe\"", "\"synchronized\"", "\"volatile\"", "AT", "LPAREN", "RPAREN", "ASSIGN", "LCURLY", "RCURLY", "\"class\"", "\"interface\"", "\"enum\"", "BAND", "\"default\"", "\"implements\"", "\"this\"", "\"throws\"", "TRIPLE_DOT", "COLON", "\"if\"", "\"else\"", "\"while\"", "\"do\"", "\"break\"", "\"continue\"", "\"return\"", "\"switch\"", "\"throw\"", "\"assert\"", "\"for\"", "\"case\"", "\"try\"", "\"finally\"", "\"catch\"", "PLUS_ASSIGN", "MINUS_ASSIGN", "STAR_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "SR_ASSIGN", "BSR_ASSIGN", "SL_ASSIGN", "BAND_ASSIGN", "BXOR_ASSIGN", "BOR_ASSIGN", "LOR", "LAND", "BOR", "BXOR", "NOT_EQUAL", "EQUAL", "LE", "GE", "\"instanceof\"", "SL", "PLUS", "MINUS", "DIV", "MOD", "INC", "DEC", "BNOT", "LNOT", "\"true\"", "\"false\"", "\"null\"", "\"new\"", "NUM_INT", "CHAR_LITERAL", "STRING_LITERAL", "NUM_FLOAT", "NUM_LONG", "NUM_DOUBLE", "WS", "SL_COMMENT", "ML_COMMENT", "ESC", "HEX_DIGIT", "VOCAB", "EXPONENT", "FLOAT_SUFFIX"};
        DW = new BitSet(VH());
        FH = new BitSet(gn());
        Hw = new BitSet(u7());
        v5 = new BitSet(tp());
        Zo = new BitSet(EQ());
        VH = new BitSet(we());
        gn = new BitSet(J0());
        u7 = new BitSet(J8());
        tp = new BitSet(Ws());
        EQ = new BitSet(QX());
        we = new BitSet(XL());
        J0 = new BitSet(aM());
        U2 = new BitSet(j3());
        a8 = new BitSet(Mr());
        lg = new BitSet(U2());
        rN = new BitSet(a8());
        er = new BitSet(lg());
        yS = new BitSet(rN());
        gW = new BitSet(er());
        BT = new BitSet(yS());
        vy = new BitSet(gW());
        P8 = new BitSet(BT());
        ei = new BitSet(vy());
        nw = new BitSet(P8());
        SI = new BitSet(ei());
        KD = new BitSet(nw());
        ro = new BitSet(SI());
        cn = new BitSet(KD());
        sh = new BitSet(ro());
        cb = new BitSet(cn());
        dx = new BitSet(sh());
        sG = new BitSet(cb());
        ef = new BitSet(dx());
        Sf = new BitSet(sG());
        vJ = new BitSet(ef());
        g3 = new BitSet(Sf());
        Mz = new BitSet(vJ());
        I = new BitSet(g3());
        ca = new BitSet(Mz());
        x9 = new BitSet(I());
        Qq = new BitSet(ca());
        sy = new BitSet(x9());
        aj = new BitSet(Qq());
        lp = new BitSet(sy());
        OW = new BitSet(aj());
        br = new BitSet(lp());
        XX = new BitSet(OW());
        kQ = new BitSet(br());
        yO = new BitSet(XX());
    }

    private static final long[] VH() {
        return new long[]{-4611684094282039294L, 966359252993L, 0, 0};
    }

    private static final long[] gn() {
        return new long[]{4611687942572736514L, 966359253001L, 0, 0};
    }

    private static final long[] u7() {
        return new long[]{4611687942572736512L, 966359252993L, 0, 0};
    }

    private static final long[] tp() {
        return new long[]{4611687942572736514L, 966359252993L, 0, 0};
    }

    private static final long[] EQ() {
        return new long[]{1924145348608L, 2139095041, 0, 0};
    }

    private static final long[] we() {
        return new long[]{0, 4186152, 0, 0};
    }

    private static final long[] J0() {
        return new long[]{4611686018427387904L, -4611566038511780098L, 32767, 0, 0, 0};
    }

    private static final long[] J8() {
        return new long[]{6917530951786430464L, -3458782106006585345L, 137438953471L, 0, 0, 0};
    }

    private static final long[] Ws() {
        return new long[]{0, 8836899398024L, 137432137728L, 0, 0, 0};
    }

    private static final long[] QX() {
        return new long[]{0, 9979364900282L, 137438952960L, 0, 0, 0};
    }

    private static final long[] XL() {
        return new long[]{0, 8802539659656L, 137432137728L, 0, 0, 0};
    }

    private static final long[] aM() {
        return new long[]{0, 4432410443336L, 0, 0};
    }

    private static final long[] j3() {
        return new long[]{4611687942572736512L, 5471784132955L, 0, 0};
    }

    private static final long[] Mr() {
        return new long[]{1924145348608L, 966363439369L, 0, 0};
    }

    private static final long[] U2() {
        return new long[]{1924145348608L, 970658406683L, 0, 0};
    }

    private static final long[] a8() {
        return new long[]{0, 4186120, 0, 0};
    }

    private static final long[] lg() {
        return new long[]{0, 282, 0, 0};
    }

    private static final long[] rN() {
        return new long[]{4611686018427387904L, 17179869698L, 0, 0};
    }

    private static final long[] er() {
        return new long[]{274877906944L, 2151669768L, 0, 0};
    }

    private static final long[] yS() {
        return new long[]{0, 2151670042L, 0, 0};
    }

    private static final long[] gW() {
        return new long[]{0, 35186523758874L, 0, 0};
    }

    private static final long[] BT() {
        return new long[]{4611687942572736512L, 864277892467515785L, 137432137728L, 0, 0, 0};
    }

    private static final long[] vy() {
        return new long[]{0, 8796093022592L, 0, 0};
    }

    private static final long[] P8() {
        return new long[]{0, 4299153448L, 0, 0};
    }

    private static final long[] ei() {
        return new long[]{4611687942572736512L, 864277961186992521L, 137432137728L, 0, 0, 0};
    }

    private static final long[] nw() {
        return new long[]{4611687942572736512L, -3747335747166798405L, 137438953471L, 0, 0, 0};
    }

    private static final long[] SI() {
        return new long[]{4611687942572736512L, 1152792011338670473L, 137432137728L, 0, 0, 0};
    }

    private static final long[] KD() {
        return new long[]{4611687942572736512L, -57183194579525L, 137438953471L, 0, 0, 0};
    }

    private static final long[] ro() {
        return new long[]{1924145348608L, 4290764809L, 0, 0};
    }

    private static final long[] cn() {
        return new long[]{1924145348608L, 4290765083L, 0, 0};
    }

    private static final long[] sh() {
        return new long[]{0, 8800392176008L, 137432137728L, 0, 0, 0};
    }

    private static final long[] cb() {
        return new long[]{4611686018427387904L, -4611676101339513414L, 137438953471L, 0, 0, 0};
    }

    private static final long[] dx() {
        return new long[]{1924145348608L, 141725532161L, 0, 0};
    }

    private static final long[] sG() {
        return new long[]{1924145348608L, 141725532169L, 0, 0};
    }

    private static final long[] ef() {
        return new long[]{0, 8834751914376L, 137432137728L, 0, 0, 0};
    }

    private static final long[] Sf() {
        return new long[]{4611687942572736512L, 8804678754697L, 137432137728L, 0, 0, 0};
    }

    private static final long[] vJ() {
        return new long[]{4611687942572736512L, -4611676097052934213L, 137438953471L, 0, 0, 0};
    }

    private static final long[] g3() {
        return new long[]{0, 79169136353672L, 137432137728L, 0, 0, 0};
    }

    private static final long[] Mz() {
        return new long[]{4611686018427387904L, -4611676101339512902L, 137438953471L, 0, 0, 0};
    }

    private static final long[] I() {
        return new long[]{0, 1280, 98304, 0, 0, 0};
    }

    private static final long[] ca() {
        return new long[]{0, 6144, 262144, 0, 0, 0};
    }

    private static final long[] x9() {
        return new long[]{0, 4194304, 6291456, 0, 0, 0};
    }

    private static final long[] Qq() {
        return new long[]{0, 8800392176008L, 137304735744L, 0, 0, 0};
    }

    private static final long[] sy() {
        return new long[]{4611686018427387904L, -4611605655285923906L, 137438953471L, 0, 0, 0};
    }

    private static final long[] aj() {
        return new long[]{0, 392, 0, 0};
    }

    private static final long[] lp() {
        return new long[]{4611686018427387904L, -4611614455678099658L, 33554431, 0, 0, 0};
    }

    private static final long[] OW() {
        return new long[]{6917530951786430464L, -3458821688425185345L, 137438953471L, 0, 0, 0};
    }

    private static final long[] br() {
        return new long[]{4611686018427387904L, -4611614451383132362L, 33554431, 0, 0, 0};
    }

    private static final long[] XX() {
        return new long[]{0, 8800392176012L, 137432137728L, 0, 0, 0};
    }
}
