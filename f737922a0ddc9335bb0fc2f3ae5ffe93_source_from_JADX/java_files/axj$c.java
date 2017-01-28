import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.JGitText;

public class axj$c extends axj {
    public axj$c(int i) {
        super(i);
    }

    protected OutputStream j6() {
        throw new IOException(JGitText.j6().inMemoryBufferLimitExceeded);
    }
}
