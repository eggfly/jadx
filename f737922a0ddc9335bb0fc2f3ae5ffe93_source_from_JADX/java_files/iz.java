import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class iz {
    private Integer DW;
    private Integer FH;
    private Integer Hw;
    private ix Zo;
    private Integer j6;
    private String v5;

    public static int j6(String str, String str2) {
        return new iz(str).j6(new iz(str2));
    }

    public iz(String str) {
        j6(str);
    }

    public int hashCode() {
        return this.Zo.hashCode() + 11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iz)) {
            return false;
        }
        if (j6((iz) obj) != 0) {
            return false;
        }
        return true;
    }

    public int j6(iz izVar) {
        if (izVar instanceof iz) {
            return this.Zo.j6(izVar.Zo);
        }
        return j6(new iz(izVar.toString()));
    }

    public final void j6(String str) {
        String str2;
        String str3;
        int i = 0;
        this.Zo = new ix(str);
        int indexOf = str.indexOf("-");
        if (indexOf < 0) {
            str2 = null;
            str3 = str;
        } else {
            str3 = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1);
        }
        if (str2 != null) {
            try {
                if (str2.length() == 1 || !str2.startsWith("0")) {
                    this.Hw = Integer.valueOf(str2);
                } else {
                    this.v5 = str2;
                }
            } catch (NumberFormatException e) {
                this.v5 = str2;
            }
        }
        if (str3.contains(".") || str3.startsWith("0")) {
            StringTokenizer stringTokenizer = new StringTokenizer(str3, ".");
            try {
                this.j6 = j6(stringTokenizer);
                if (stringTokenizer.hasMoreTokens()) {
                    this.DW = j6(stringTokenizer);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    this.FH = j6(stringTokenizer);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    this.v5 = stringTokenizer.nextToken();
                    i = Pattern.compile("\\d+").matcher(this.v5).matches();
                }
                if (str3.contains("..") || str3.startsWith(".") || str3.endsWith(".")) {
                    i = 1;
                }
            } catch (NumberFormatException e2) {
                i = 1;
            }
            if (i != 0) {
                this.v5 = str;
                this.j6 = null;
                this.DW = null;
                this.FH = null;
                this.Hw = null;
                return;
            }
            return;
        }
        try {
            this.j6 = Integer.valueOf(str3);
        } catch (NumberFormatException e3) {
            this.v5 = str;
            this.Hw = null;
        }
    }

    private static Integer j6(StringTokenizer stringTokenizer) {
        try {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() <= 1 || !nextToken.startsWith("0")) {
                return Integer.valueOf(nextToken);
            }
            throw new NumberFormatException("Number part has a leading 0: '" + nextToken + "'");
        } catch (NoSuchElementException e) {
            throw new NumberFormatException("Number is invalid");
        }
    }

    public String toString() {
        return this.Zo.toString();
    }
}
