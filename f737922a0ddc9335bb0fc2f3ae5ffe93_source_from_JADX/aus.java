import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class aus {
    private final ans DW;
    private final String FH;
    private final avb Hw;
    private aus$a VH;
    private final boolean Zo;
    private boolean gn;
    private final ans j6;
    private final aoh tp;
    private String u7;
    private final String v5;

    public aus(aoh aoh, String str, String str2, boolean z, String str3, ans ans) {
        ans DW;
        if (str != null) {
            DW = aoh.DW(str);
        } else {
            DW = ans.Zo();
        }
        this(aoh, str, DW, str2, z, str3, ans);
    }

    public aus(aoh aoh, String str, ans ans, String str2, boolean z, String str3, ans ans2) {
        if (str2 == null) {
            throw new IllegalArgumentException(JGitText.j6().remoteNameCantBeNull);
        } else if (ans != null || str == null) {
            if (str != null) {
                this.v5 = str;
            } else if (ans == null || ans.DW(ans.Zo())) {
                this.v5 = null;
            } else {
                this.v5 = ans.DW();
            }
            if (ans != null) {
                this.DW = ans;
            } else {
                this.DW = ans.Zo();
            }
            this.FH = str2;
            this.Zo = z;
            if (str3 == null || aoh == null) {
                this.Hw = null;
            } else {
                this.Hw = new avb(aoh, str3, str2, true, this.DW, "push");
            }
            this.tp = aoh;
            this.j6 = ans2;
            this.VH = aus$a.NOT_ATTEMPTED;
        } else {
            throw new IOException(MessageFormat.format(JGitText.j6().sourceRefDoesntResolveToAnyObject, new Object[]{str}));
        }
    }

    public ans j6() {
        return this.j6;
    }

    public boolean DW() {
        return this.j6 != null;
    }

    public ans FH() {
        return this.DW;
    }

    public boolean Hw() {
        return ans.Zo().DW(this.DW);
    }

    public String v5() {
        return this.FH;
    }

    public avb Zo() {
        return this.Hw;
    }

    public boolean VH() {
        return this.Hw != null;
    }

    public boolean gn() {
        return this.Zo;
    }

    public aus$a u7() {
        return this.VH;
    }

    void j6(aus$a aus_a) {
        this.VH = aus_a;
    }

    void j6(boolean z) {
        this.gn = z;
    }

    void j6(String str) {
        this.u7 = str;
    }

    protected void j6(aql aql) {
        if (Hw()) {
            this.Hw.DW(aql);
        } else {
            this.Hw.j6(aql);
        }
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("RemoteRefUpdate[remoteName=").append(this.FH).append(", ").append(this.VH).append(", ").append(this.j6 != null ? this.j6.DW() : "(null)").append("...").append(this.DW != null ? this.DW.DW() : "(null)").append(this.gn ? ", fastForward" : "").append(", srcRef=").append(this.v5).append(this.Zo ? ", forceUpdate" : "").append(", message=");
        if (this.u7 != null) {
            str = "\"" + this.u7 + "\"";
        } else {
            str = "null";
        }
        return append.append(str).append("]").toString();
    }
}
