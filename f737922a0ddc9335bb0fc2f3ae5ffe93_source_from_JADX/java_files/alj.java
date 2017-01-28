import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class alj extends ale {
    public alj(int i, String str, String str2, String str3) {
        super(j6(i, str, str2), str3);
    }

    private static String j6(int i, String str, String str2) {
        return MessageFormat.format(JGitText.j6().noClosingBracket, new Object[]{str2, str, Integer.valueOf(i)});
    }
}
