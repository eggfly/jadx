package groovyjarjarantlr;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarantlr.collections.impl.BitSet;

public class MismatchedCharException extends RecognitionException {
    public int DW;
    public int FH;
    public int Hw;
    public CharScanner Zo;
    public int j6;
    public BitSet v5;

    public MismatchedCharException() {
        super("Mismatched char");
    }

    public MismatchedCharException(char c, char c2, char c3, boolean z, CharScanner charScanner) {
        super("Mismatched char", charScanner.v5(), charScanner.Zo(), charScanner.Hw());
        this.j6 = z ? 4 : 3;
        this.DW = c;
        this.FH = c2;
        this.Hw = c3;
        this.Zo = charScanner;
    }

    public MismatchedCharException(char c, char c2, boolean z, CharScanner charScanner) {
        super("Mismatched char", charScanner.v5(), charScanner.Zo(), charScanner.Hw());
        this.j6 = z ? 2 : 1;
        this.DW = c;
        this.FH = c2;
        this.Zo = charScanner;
    }

    public MismatchedCharException(char c, BitSet bitSet, boolean z, CharScanner charScanner) {
        super("Mismatched char", charScanner.v5(), charScanner.Zo(), charScanner.Hw());
        this.j6 = z ? 6 : 5;
        this.DW = c;
        this.v5 = bitSet;
        this.Zo = charScanner;
    }

    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.j6) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                stringBuffer.append("expecting ");
                j6(stringBuffer, this.FH);
                stringBuffer.append(", found ");
                j6(stringBuffer, this.DW);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                stringBuffer.append("expecting anything but '");
                j6(stringBuffer, this.FH);
                stringBuffer.append("'; got it anyway");
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                stringBuffer.append("expecting token ");
                if (this.j6 == 4) {
                    stringBuffer.append("NOT ");
                }
                stringBuffer.append("in range: ");
                j6(stringBuffer, this.FH);
                stringBuffer.append("..");
                j6(stringBuffer, this.Hw);
                stringBuffer.append(", found ");
                j6(stringBuffer, this.DW);
                break;
            case 5:
            case 6:
                stringBuffer.append(new StringBuffer().append("expecting ").append(this.j6 == 6 ? "NOT " : "").append("one of (").toString());
                int[] FH = this.v5.FH();
                for (int j6 : FH) {
                    j6(stringBuffer, j6);
                }
                stringBuffer.append("), found ");
                j6(stringBuffer, this.DW);
                break;
            default:
                stringBuffer.append(super.getMessage());
                break;
        }
        return stringBuffer.toString();
    }

    private void j6(StringBuffer stringBuffer, int i) {
        switch (i) {
            case 9:
                stringBuffer.append("'\\t'");
            case 10:
                stringBuffer.append("'\\n'");
            case 13:
                stringBuffer.append("'\\r'");
            case 65535:
                stringBuffer.append("'<EOF>'");
            default:
                stringBuffer.append('\'');
                stringBuffer.append((char) i);
                stringBuffer.append('\'');
        }
    }
}
