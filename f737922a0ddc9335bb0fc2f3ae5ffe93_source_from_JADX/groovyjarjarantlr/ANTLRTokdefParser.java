package groovyjarjarantlr;

import groovyjarjarantlr.collections.impl.BitSet;

public class ANTLRTokdefParser extends LLkParser implements ANTLRTokdefParserTokenTypes {
    public static final BitSet DW;
    public static final BitSet FH;
    public static final String[] j6;

    static {
        j6 = new String[]{"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "ID", "STRING", "ASSIGN", "LPAREN", "RPAREN", "INT", "WS", "SL_COMMENT", "ML_COMMENT", "ESC", "DIGIT", "XDIGIT"};
        DW = new BitSet(VH());
        FH = new BitSet(gn());
    }

    private static final long[] VH() {
        return new long[]{2, 0};
    }

    private static final long[] gn() {
        return new long[]{50, 0};
    }
}
