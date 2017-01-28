import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class alf$a extends alf {
    public String getMessage() {
        return MessageFormat.format(JGitText.j6().largeObjectExceedsByteArray, new Object[]{DW()});
    }
}
