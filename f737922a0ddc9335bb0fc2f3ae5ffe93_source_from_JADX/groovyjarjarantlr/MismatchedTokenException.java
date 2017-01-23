package groovyjarjarantlr;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.collections.impl.BitSet;

public class MismatchedTokenException extends RecognitionException {
    public Token DW;
    String FH;
    public int Hw;
    public BitSet VH;
    public int Zo;
    String[] j6;
    public int v5;

    public MismatchedTokenException() {
        super("Mismatched Token: expecting any AST node", "<AST>", -1, -1);
        this.FH = null;
    }

    public MismatchedTokenException(String[] strArr, Token token, int i, boolean z, String str) {
        super("Mismatched Token", str, token.v5(), token.Zo());
        this.FH = null;
        this.j6 = strArr;
        this.DW = token;
        this.FH = token.FH();
        this.Hw = z ? 2 : 1;
        this.v5 = i;
    }

    public MismatchedTokenException(String[] strArr, Token token, BitSet bitSet, boolean z, String str) {
        super("Mismatched Token", str, token.v5(), token.Zo());
        this.FH = null;
        this.j6 = strArr;
        this.DW = token;
        this.FH = token.FH();
        this.Hw = z ? 6 : 5;
        this.VH = bitSet;
    }

    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.Hw) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                stringBuffer.append(new StringBuffer().append("expecting ").append(j6(this.v5)).append(", found '").append(this.FH).append("'").toString());
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                stringBuffer.append(new StringBuffer().append("expecting anything but ").append(j6(this.v5)).append("; got it anyway").toString());
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                stringBuffer.append(new StringBuffer().append("expecting token in range: ").append(j6(this.v5)).append("..").append(j6(this.Zo)).append(", found '").append(this.FH).append("'").toString());
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                stringBuffer.append(new StringBuffer().append("expecting token NOT in range: ").append(j6(this.v5)).append("..").append(j6(this.Zo)).append(", found '").append(this.FH).append("'").toString());
                break;
            case 5:
            case 6:
                stringBuffer.append(new StringBuffer().append("expecting ").append(this.Hw == 6 ? "NOT " : "").append("one of (").toString());
                int[] FH = this.VH.FH();
                for (int j6 : FH) {
                    stringBuffer.append(" ");
                    stringBuffer.append(j6(j6));
                }
                stringBuffer.append(new StringBuffer().append("), found '").append(this.FH).append("'").toString());
                break;
            default:
                stringBuffer.append(super.getMessage());
                break;
        }
        return stringBuffer.toString();
    }

    private String j6(int i) {
        if (i == 0) {
            return "<Set of tokens>";
        }
        if (i < 0 || i >= this.j6.length) {
            return new StringBuffer().append("<").append(String.valueOf(i)).append(">").toString();
        }
        return this.j6[i];
    }
}
