import java.io.IOException;
import org.eclipse.jgit.JGitText;

public class alc extends IOException {
    public alc() {
        super(JGitText.j6().indexWriteException);
    }
}
