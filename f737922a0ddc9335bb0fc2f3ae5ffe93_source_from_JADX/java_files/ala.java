import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class ala extends IOException {
    public ala(anb anb, String str) {
        this(anb.v5(), str);
    }

    public ala(ans ans, String str) {
        super(MessageFormat.format(JGitText.j6().objectIsCorrupt, new Object[]{ans.DW(), str}));
    }

    public ala(String str) {
        super(str);
    }
}
