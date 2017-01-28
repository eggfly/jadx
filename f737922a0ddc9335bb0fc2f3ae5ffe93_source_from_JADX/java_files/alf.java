import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class alf extends RuntimeException {
    private ans j6;

    public alf(anb anb) {
        j6(anb);
    }

    public ans j6() {
        return this.j6;
    }

    protected String DW() {
        if (j6() != null) {
            return j6().DW();
        }
        return JGitText.j6().unknownObject;
    }

    public void j6(anb anb) {
        if (this.j6 == null) {
            this.j6 = anb.Hw();
        }
    }

    public String getMessage() {
        return MessageFormat.format(JGitText.j6().largeObjectException, new Object[]{DW()});
    }
}
