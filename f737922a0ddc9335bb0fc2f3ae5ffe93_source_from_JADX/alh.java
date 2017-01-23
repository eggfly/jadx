import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.jgit.JGitText;

public class alh extends amb {
    private static String j6(Map<ans, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(JGitText.j6().missingPrerequisiteCommits);
        for (Entry entry : map.entrySet()) {
            stringBuilder.append("\n  ");
            stringBuilder.append(((ans) entry.getKey()).DW());
            if (entry.getValue() != null) {
                stringBuilder.append(" ").append((String) entry.getValue());
            }
        }
        return stringBuilder.toString();
    }

    public alh(avn avn, Map<ans, String> map) {
        super(avn, j6(map));
    }
}
