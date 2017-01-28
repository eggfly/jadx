import com.aide.uidesigner.ProxyTextView;
import java.math.BigInteger;

class ix$a implements ix$b {
    private static final BigInteger DW;
    public static final ix$a j6;
    private final BigInteger FH;

    static {
        DW = new BigInteger("0");
        j6 = new ix$a();
    }

    private ix$a() {
        this.FH = DW;
    }

    public ix$a(String str) {
        this.FH = new BigInteger(str);
    }

    public int j6() {
        return 0;
    }

    public boolean DW() {
        return DW.equals(this.FH);
    }

    public int j6(ix$b ix_b) {
        if (ix_b != null) {
            switch (ix_b.j6()) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    return this.FH.compareTo(((ix$a) ix_b).FH);
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    return 1;
                default:
                    throw new RuntimeException("invalid item: " + ix_b.getClass());
            }
        } else if (DW.equals(this.FH)) {
            return 0;
        } else {
            return 1;
        }
    }

    public String toString() {
        return this.FH.toString();
    }
}
