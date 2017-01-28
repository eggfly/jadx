import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class alb extends IOException {
    public alb(ans ans, String str) {
        super(MessageFormat.format(JGitText.j6().objectIsNotA, new Object[]{ans.DW(), str}));
    }

    public alb(ans ans, int i) {
        this(ans, anj.j6(i));
    }
}
