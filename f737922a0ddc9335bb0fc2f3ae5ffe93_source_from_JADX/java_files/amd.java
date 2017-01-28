import java.io.IOException;
import org.eclipse.jgit.JGitText;

public class amd extends IOException {
    public amd(Throwable th) {
        super(JGitText.j6().unpackException);
        initCause(th);
    }
}
