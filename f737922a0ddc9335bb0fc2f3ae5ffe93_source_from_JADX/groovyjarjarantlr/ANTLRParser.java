package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.BitSet;

public class ANTLRParser extends LLkParser implements ANTLRTokenTypes {
    public static final BitSet DW;
    public static final BitSet EQ;
    public static final BitSet FH;
    public static final BitSet Hw;
    public static final BitSet J0;
    public static final BitSet VH;
    public static final BitSet Zo;
    public static final BitSet gn;
    public static final String[] j6;
    public static final BitSet tp;
    public static final BitSet u7;
    public static final BitSet v5;
    public static final BitSet we;

    static {
        j6 = new String[]{"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "\"tokens\"", "\"header\"", "STRING_LITERAL", "ACTION", "DOC_COMMENT", "\"lexclass\"", "\"class\"", "\"extends\"", "\"Lexer\"", "\"TreeParser\"", "OPTIONS", "ASSIGN", "SEMI", "RCURLY", "\"charVocabulary\"", "CHAR_LITERAL", "INT", "OR", "RANGE", "TOKENS", "TOKEN_REF", "OPEN_ELEMENT_OPTION", "CLOSE_ELEMENT_OPTION", "LPAREN", "RPAREN", "\"Parser\"", "\"protected\"", "\"public\"", "\"private\"", "BANG", "ARG_ACTION", "\"returns\"", "COLON", "\"throws\"", "COMMA", "\"exception\"", "\"catch\"", "RULE_REF", "NOT_OP", "SEMPRED", "TREE_BEGIN", "QUESTION", "STAR", "PLUS", "IMPLIES", "CARET", "WILDCARD", "\"options\"", "WS", "COMMENT", "SL_COMMENT", "ML_COMMENT", "ESC", "DIGIT", "XDIGIT", "NESTED_ARG_ACTION", "NESTED_ACTION", "WS_LOOP", "INTERNAL_RULE_REF", "WS_OPT"};
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
    }

    private static final long[] VH() {
        return new long[]{2206556225792L, 0};
    }

    private static final long[] gn() {
        return new long[]{2472844214400L, 0};
    }

    private static final long[] u7() {
        return new long[]{1158885407195328L, 0};
    }

    private static final long[] tp() {
        return new long[]{1159461236965568L, 0};
    }

    private static final long[] EQ() {
        return new long[]{1132497128128576L, 0};
    }

    private static final long[] we() {
        return new long[]{1722479914074304L, 0};
    }

    private static final long[] J0() {
        return new long[]{1722411194597568L, 0};
    }

    private static final long[] J8() {
        return new long[]{1125899924144192L, 0};
    }

    private static final long[] Ws() {
        return new long[]{1722411190386880L, 0};
    }

    private static final long[] QX() {
        return new long[]{1159444023476416L, 0};
    }

    private static final long[] XL() {
        return new long[]{2251345007067328L, 0};
    }

    private static final long[] aM() {
        return new long[]{1721861130420416L, 0};
    }
}
