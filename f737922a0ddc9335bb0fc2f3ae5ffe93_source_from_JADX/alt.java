import org.eclipse.jgit.JGitText;

public class alt extends RuntimeException {
    public alt(Throwable th) {
        super(JGitText.j6().walkFailure, th);
    }
}
