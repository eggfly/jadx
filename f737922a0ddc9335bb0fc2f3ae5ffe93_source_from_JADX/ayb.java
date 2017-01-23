import com.aide.uidesigner.ProxyTextView;

public class ayb extends Exception {
    private Object DW;
    private int FH;
    private int j6;

    public ayb(int i, int i2, Object obj) {
        this.FH = i;
        this.j6 = i2;
        this.DW = obj;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.j6) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                stringBuffer.append("Unexpected character (").append(this.DW).append(") at position ").append(this.FH).append(".");
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                stringBuffer.append("Unexpected token ").append(this.DW).append(" at position ").append(this.FH).append(".");
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                stringBuffer.append("Unexpected exception at position ").append(this.FH).append(": ").append(this.DW);
                break;
            default:
                stringBuffer.append("Unkown error at position ").append(this.FH).append(".");
                break;
        }
        return stringBuffer.toString();
    }
}
