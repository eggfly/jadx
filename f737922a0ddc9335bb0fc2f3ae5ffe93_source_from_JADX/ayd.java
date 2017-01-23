import com.aide.uidesigner.ProxyTextView;

public class ayd {
    public Object DW;
    public int j6;

    public ayd(int i, Object obj) {
        this.j6 = 0;
        this.DW = null;
        this.j6 = i;
        this.DW = obj;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.j6) {
            case -1:
                stringBuffer.append("END OF FILE");
                break;
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                stringBuffer.append("VALUE(").append(this.DW).append(")");
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                stringBuffer.append("LEFT BRACE({)");
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                stringBuffer.append("RIGHT BRACE(})");
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                stringBuffer.append("LEFT SQUARE([)");
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                stringBuffer.append("RIGHT SQUARE(])");
                break;
            case 5:
                stringBuffer.append("COMMA(,)");
                break;
            case 6:
                stringBuffer.append("COLON(:)");
                break;
        }
        return stringBuffer.toString();
    }
}
