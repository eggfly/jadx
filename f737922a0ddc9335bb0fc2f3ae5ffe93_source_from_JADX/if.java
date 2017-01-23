import java.util.HashSet;
import java.util.Set;

public enum if implements bd {
    ADJUST_NEWLINES("General", "Adjust lines on autoformat", "", ""),
    ADJUST_SPACES("General", "Adjust spaces on autoformat", "", ""),
    FORMAT_ONPASTE("General", "Autoformat pasted code", "", ""),
    INDENT_ONTYPE("General", "Adjust indentation while typing", "", ""),
    AUTO_INSERT_CLOSING_BRACE_ONTYPE("General", "Automatically insert closing tag", "", "");
    
    private final String VH;
    private final String Zo;
    private final String gn;
    private final String u7;

    private if(String str, String str2, String str3, String str4) {
        this.Zo = str;
        this.VH = str2;
        this.gn = str3;
        this.u7 = str4;
    }

    public String j6() {
        return this.VH;
    }

    public static Set<if> j6(boolean z) {
        Set hashSet = new HashSet();
        hashSet.add(ADJUST_SPACES);
        hashSet.add(FORMAT_ONPASTE);
        hashSet.add(INDENT_ONTYPE);
        hashSet.add(AUTO_INSERT_CLOSING_BRACE_ONTYPE);
        return hashSet;
    }
}
