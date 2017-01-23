import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class avi extends auy implements auc {
    static final avl v5;

    static {
        v5 = new avi$1();
    }

    avi(aoh aoh, avn avn) {
        super(aoh, avn);
        if (j3()) {
            j6(new avi$2(this));
        }
    }

    public atq QX() {
        return new avi$b(this);
    }

    public auj XL() {
        return new avi$c(this);
    }

    String FH(String str) {
        String FH = this.Hw.FH();
        if (this.Hw.DW() != null && this.Hw.FH().startsWith("/~")) {
            FH = this.Hw.FH().substring(1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(' ');
        stringBuilder.append(axc.DW.j6(FH));
        return stringBuilder.toString();
    }

    void j6(int i, String str, String str2) {
        if (i == 127) {
            Throwable th = null;
            if (str2 != null && str2.length() > 0) {
                th = new IOException(str2);
            }
            throw new amb(this.Hw, MessageFormat.format(JGitText.j6().cannotExecute, new Object[]{FH(str)}), th);
        }
    }

    alk j6(alk alk, String str) {
        if (str == null || str.length() == 0) {
            return alk;
        }
        String FH = this.Hw.FH();
        if (this.Hw.DW() != null && this.Hw.FH().startsWith("/~")) {
            FH = this.Hw.FH().substring(1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fatal: ");
        stringBuilder.append(axc.DW.j6(FH));
        stringBuilder.append(": ");
        if (str.startsWith(stringBuilder.toString())) {
            str = str.substring(stringBuilder.length());
        }
        return new alk(this.Hw, str);
    }

    private static boolean j3() {
        return axi.FH().j6("GIT_SSH") != null;
    }
}
