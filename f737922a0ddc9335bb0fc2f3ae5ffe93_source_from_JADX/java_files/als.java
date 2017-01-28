import java.io.File;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class als extends amb {
    public als(File file) {
        this(file.getPath());
    }

    public als(String str) {
        super(j6(str));
    }

    private static String j6(String str) {
        return MessageFormat.format(JGitText.j6().repositoryNotFound, new Object[]{str});
    }
}
