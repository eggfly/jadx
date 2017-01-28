import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class amc extends IOException {
    private final akt j6;

    public amc(akt akt) {
        super(MessageFormat.format(JGitText.j6().unmergedPath, new Object[]{akt.J8()}));
        this.j6 = akt;
    }
}
