import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class aky extends Exception {
    private final List<Throwable> j6;

    private static String j6(Collection<Throwable> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JGitText.j6().failureDueToOneOfTheFollowing);
        for (Throwable th : collection) {
            stringBuilder.append("  ");
            stringBuilder.append(th.getMessage());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public aky(Collection<Throwable> collection) {
        super(j6(collection));
        this.j6 = Collections.unmodifiableList(new ArrayList(collection));
    }
}
