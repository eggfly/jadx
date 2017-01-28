import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class alx extends IOException {
    public alx(long j) {
        super(MessageFormat.format(JGitText.j6().receivePackObjectTooLarge1, new Object[]{Long.valueOf(j)}));
    }

    public alx(long j, long j2) {
        super(MessageFormat.format(JGitText.j6().receivePackObjectTooLarge2, new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
    }
}
