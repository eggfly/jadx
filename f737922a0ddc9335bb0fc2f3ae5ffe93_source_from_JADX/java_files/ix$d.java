import com.aide.uidesigner.ProxyTextView;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

class ix$d implements ix$b {
    private static final List<String> DW;
    private static final Properties FH;
    private static final String Hw;
    private static final String[] j6;
    private String v5;

    static {
        j6 = new String[]{"alpha", "beta", "milestone", "rc", "snapshot", "", "sp"};
        DW = Arrays.asList(j6);
        FH = new Properties();
        FH.put("ga", "");
        FH.put("final", "");
        FH.put("cr", "rc");
        Hw = String.valueOf(DW.indexOf(""));
    }

    public ix$d(String str, boolean z) {
        if (z && str.length() == 1) {
            switch (str.charAt(0)) {
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                    str = "alpha";
                    break;
                case 'b':
                    str = "beta";
                    break;
                case 'm':
                    str = "milestone";
                    break;
            }
        }
        this.v5 = FH.getProperty(str, str);
    }

    public int j6() {
        return 1;
    }

    public boolean DW() {
        return j6(this.v5).compareTo(Hw) == 0;
    }

    public static String j6(String str) {
        int indexOf = DW.indexOf(str);
        return indexOf == -1 ? DW.size() + "-" + str : String.valueOf(indexOf);
    }

    public int j6(ix$b ix_b) {
        if (ix_b == null) {
            return j6(this.v5).compareTo(Hw);
        }
        switch (ix_b.j6()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return -1;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return j6(this.v5).compareTo(j6(((ix$d) ix_b).v5));
            default:
                throw new RuntimeException("invalid item: " + ix_b.getClass());
        }
    }

    public String toString() {
        return this.v5;
    }
}
