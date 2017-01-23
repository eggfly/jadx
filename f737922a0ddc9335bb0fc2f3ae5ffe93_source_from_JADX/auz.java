import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public enum auz {
    AUTO_FOLLOW(""),
    NO_TAGS("--no-tags"),
    FETCH_TAGS("--tags");
    
    private final String Hw;

    private auz(String str) {
        this.Hw = str;
    }

    public String j6() {
        return this.Hw;
    }

    public static auz j6(String str) {
        if (str == null || str.length() == 0) {
            return AUTO_FOLLOW;
        }
        for (auz auz : values()) {
            if (auz.j6().equals(str)) {
                return auz;
            }
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidTagOption, new Object[]{str}));
    }
}
