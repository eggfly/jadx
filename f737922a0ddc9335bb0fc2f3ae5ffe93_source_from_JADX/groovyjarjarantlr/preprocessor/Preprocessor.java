package groovyjarjarantlr.preprocessor;

import groovyjarjarantlr.LLkParser;
import groovyjarjarantlr.collections.impl.BitSet;

public class Preprocessor extends LLkParser implements PreprocessorTokenTypes {
    public static final BitSet DW;
    public static final BitSet FH;
    public static final BitSet Hw;
    public static final BitSet VH;
    public static final BitSet Zo;
    public static final BitSet gn;
    public static final String[] j6;
    public static final BitSet tp;
    public static final BitSet u7;
    public static final BitSet v5;

    static {
        j6 = new String[]{"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "\"tokens\"", "HEADER_ACTION", "SUBRULE_BLOCK", "ACTION", "\"class\"", "ID", "\"extends\"", "SEMI", "TOKENS_SPEC", "OPTIONS_START", "ASSIGN_RHS", "RCURLY", "\"protected\"", "\"private\"", "\"public\"", "BANG", "ARG_ACTION", "\"returns\"", "RULE_BLOCK", "\"throws\"", "COMMA", "\"exception\"", "\"catch\"", "ALT", "ELEMENT", "LPAREN", "RPAREN", "ID_OR_KEYWORD", "CURLY_BLOCK_SCARF", "WS", "NEWLINE", "COMMENT", "SL_COMMENT", "ML_COMMENT", "CHAR_LITERAL", "STRING_LITERAL", "ESC", "DIGIT", "XDIGIT"};
        DW = new BitSet(VH());
        FH = new BitSet(gn());
        Hw = new BitSet(u7());
        v5 = new BitSet(tp());
        Zo = new BitSet(EQ());
        VH = new BitSet(we());
        gn = new BitSet(J0());
        u7 = new BitSet(J8());
        tp = new BitSet(Ws());
    }

    private static final long[] VH() {
        return new long[]{2, 0};
    }

    private static final long[] gn() {
        return new long[]{4658050, 0};
    }

    private static final long[] u7() {
        return new long[]{459264, 0};
    }

    private static final long[] tp() {
        return new long[]{386, 0};
    }

    private static final long[] EQ() {
        return new long[]{2048, 0};
    }

    private static final long[] we() {
        return new long[]{459650, 0};
    }

    private static final long[] J0() {
        return new long[]{4202624, 0};
    }

    private static final long[] J8() {
        return new long[]{34014082, 0};
    }

    private static final long[] Ws() {
        return new long[]{101122946, 0};
    }
}
