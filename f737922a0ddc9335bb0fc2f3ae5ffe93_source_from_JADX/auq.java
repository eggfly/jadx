import java.io.Serializable;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class auq implements Serializable {
    private boolean DW;
    private String FH;
    private String Hw;
    private boolean j6;

    public static boolean j6(String str) {
        return str != null && str.endsWith("/*");
    }

    public auq() {
        this.j6 = false;
        this.DW = false;
        this.FH = "HEAD";
        this.Hw = null;
    }

    public auq(String str) {
        String substring;
        if (str.startsWith("+")) {
            this.j6 = true;
            substring = str.substring(1);
        } else {
            substring = str;
        }
        int lastIndexOf = substring.lastIndexOf(58);
        if (lastIndexOf == 0) {
            substring = substring.substring(1);
            if (j6(substring)) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidWildcards, new Object[]{str}));
            }
            this.Hw = substring;
        } else if (lastIndexOf > 0) {
            this.FH = substring.substring(0, lastIndexOf);
            this.Hw = substring.substring(lastIndexOf + 1);
            if (j6(this.FH) && j6(this.Hw)) {
                this.DW = true;
            } else if (j6(this.FH) || j6(this.Hw)) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidWildcards, new Object[]{str}));
            }
        } else if (j6(substring)) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidWildcards, new Object[]{str}));
        } else {
            this.FH = substring;
        }
    }

    private auq(auq auq) {
        this.j6 = auq.j6();
        this.DW = auq.DW();
        this.FH = auq.FH();
        this.Hw = auq.Hw();
    }

    public boolean j6() {
        return this.j6;
    }

    public auq j6(boolean z) {
        auq auq = new auq(this);
        auq.j6 = z;
        return auq;
    }

    public boolean DW() {
        return this.DW;
    }

    public String FH() {
        return this.FH;
    }

    public auq DW(String str) {
        auq auq = new auq(this);
        auq.FH = str;
        if (j6(auq.FH) && auq.Hw == null) {
            throw new IllegalStateException(JGitText.j6().destinationIsNotAWildcard);
        } else if (j6(auq.FH) == j6(auq.Hw)) {
            return auq;
        } else {
            throw new IllegalStateException(JGitText.j6().sourceDestinationMustMatch);
        }
    }

    public String Hw() {
        return this.Hw;
    }

    public auq FH(String str) {
        auq auq = new auq(this);
        auq.Hw = str;
        if (j6(auq.Hw) && auq.FH == null) {
            throw new IllegalStateException(JGitText.j6().sourceIsNotAWildcard);
        } else if (j6(auq.FH) == j6(auq.Hw)) {
            return auq;
        } else {
            throw new IllegalStateException(JGitText.j6().sourceDestinationMustMatch);
        }
    }

    public auq j6(String str, String str2) {
        if (j6(str) != j6(str2)) {
            throw new IllegalStateException(JGitText.j6().sourceDestinationMustMatch);
        }
        auq auq = new auq(this);
        auq.DW = j6(str);
        auq.FH = str;
        auq.Hw = str2;
        return auq;
    }

    public boolean Hw(String str) {
        return DW(str, FH());
    }

    public boolean j6(aoc aoc) {
        return DW(aoc.j6(), FH());
    }

    public boolean v5(String str) {
        return DW(str, Hw());
    }

    public auq Zo(String str) {
        return DW() ? new auq(this).gn(str) : this;
    }

    private auq gn(String str) {
        String str2 = this.FH;
        String str3 = this.Hw;
        this.DW = false;
        this.FH = str;
        this.Hw = str3.substring(0, str3.length() - 1) + str.substring(str2.length() - 1);
        return this;
    }

    public auq DW(aoc aoc) {
        return Zo(aoc.j6());
    }

    public auq VH(String str) {
        return DW() ? new auq(this).u7(str) : this;
    }

    private auq u7(String str) {
        String str2 = this.FH;
        String str3 = this.Hw;
        this.DW = false;
        this.FH = str2.substring(0, str2.length() - 1) + str.substring(str3.length() - 1);
        this.Hw = str;
        return this;
    }

    private boolean DW(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        if (DW()) {
            return str.startsWith(str2.substring(0, str2.length() - 1));
        }
        return str.equals(str2);
    }

    public int hashCode() {
        int i = 0;
        if (FH() != null) {
            i = FH().hashCode() + 0;
        }
        if (Hw() != null) {
            return (i * 31) + Hw().hashCode();
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof auq)) {
            return false;
        }
        auq auq = (auq) obj;
        if (j6() == auq.j6() && DW() == auq.DW() && FH(FH(), auq.FH()) && FH(Hw(), auq.Hw())) {
            return true;
        }
        return false;
    }

    private static boolean FH(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (j6()) {
            stringBuilder.append('+');
        }
        if (FH() != null) {
            stringBuilder.append(FH());
        }
        if (Hw() != null) {
            stringBuilder.append(':');
            stringBuilder.append(Hw());
        }
        return stringBuilder.toString();
    }
}
