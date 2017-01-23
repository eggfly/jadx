import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class alf$b extends alf {
    private final long DW;
    private final long j6;

    public alf$b(long j, long j2) {
        this.j6 = j;
        this.DW = j2;
    }

    public String getMessage() {
        return MessageFormat.format(JGitText.j6().largeObjectExceedsLimit, new Object[]{DW(), Long.valueOf(this.j6), Long.valueOf(this.DW)});
    }
}
