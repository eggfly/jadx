import org.eclipse.jgit.JGitText;

public class awi extends awl {
    final byte[] DW;
    final String j6;

    public /* synthetic */ awl DW() {
        return Hw();
    }

    public static awi j6(String str) {
        while (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.length() != 0) {
            return new awi(str);
        }
        throw new IllegalArgumentException(JGitText.j6().emptyPathNotPermitted);
    }

    private awi(String str) {
        this.j6 = str;
        this.DW = anj.DW(this.j6);
    }

    public String FH() {
        return this.j6;
    }

    public boolean j6(awc awc) {
        return awc.j6(this.DW, this.DW.length) == 0;
    }

    public boolean j6() {
        for (byte b : this.DW) {
            if (b == 47) {
                return true;
            }
        }
        return false;
    }

    public awi Hw() {
        return this;
    }

    public String toString() {
        return "PATH(\"" + this.j6 + "\")";
    }

    public boolean DW(awc awc) {
        return this.DW.length == awc.J8();
    }
}
