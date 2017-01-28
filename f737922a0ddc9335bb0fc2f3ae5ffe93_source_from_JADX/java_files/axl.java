import java.io.OutputStream;
import org.eclipse.jgit.JGitText;

public final class axl extends OutputStream {
    public static final axl j6;

    static {
        j6 = new axl();
    }

    private axl() {
    }

    public void write(int i) {
        throw new IllegalStateException(JGitText.j6().writingNotPermitted);
    }
}
