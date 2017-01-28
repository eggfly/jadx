import java.util.HashSet;
import java.util.Set;

public enum gj implements bd {
    AUTO_INSERT_JAVADOC_ASTERISK_ONTYPE("General", "Automatically insert * in JavaDoc comments", "", "");
    
    private final String DW;
    private final String FH;
    private final String Hw;
    private final String v5;

    private gj(String str, String str2, String str3, String str4) {
        this.DW = str;
        this.FH = str2;
        this.Hw = str3;
        this.v5 = str4;
    }

    public String j6() {
        return this.FH;
    }

    public static Set<gj> DW() {
        Set hashSet = new HashSet();
        hashSet.add(AUTO_INSERT_JAVADOC_ASTERISK_ONTYPE);
        return hashSet;
    }
}
