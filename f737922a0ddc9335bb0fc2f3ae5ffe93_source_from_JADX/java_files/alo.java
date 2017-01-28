import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class alo extends IOException {
    public alo(File file) {
        this(file.getAbsolutePath());
    }

    public alo(String str) {
        super(MessageFormat.format(JGitText.j6().packFileInvalid, new Object[]{str}));
    }
}
