import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class ali extends IOException {
    private final ans j6;

    public ali(ans ans, String str) {
        super(MessageFormat.format(JGitText.j6().missingObject, new Object[]{str, ans.DW()}));
        this.j6 = ans.Hw();
    }

    public ali(ans ans, int i) {
        this(ans, anj.j6(i));
    }

    public ali(amz amz, int i) {
        super(MessageFormat.format(JGitText.j6().missingObject, new Object[]{anj.j6(i), amz.v5()}));
        this.j6 = null;
    }

    public ans j6() {
        return this.j6;
    }
}
