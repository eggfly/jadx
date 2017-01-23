import org.eclipse.jgit.JGitText;

public class all extends IllegalStateException {
    public all() {
        super(JGitText.j6().bareRepositoryNoWorkdirAndIndex);
    }
}
