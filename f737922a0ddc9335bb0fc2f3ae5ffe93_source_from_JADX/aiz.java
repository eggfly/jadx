import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class aiz extends ajb {
    private aoc DW;
    private aof$a j6;

    public aiz(String str, aoc aoc, aof$a aof_a) {
        if (aof_a != null) {
            str = new StringBuilder(String.valueOf(str)).append(". ").append(MessageFormat.format(JGitText.j6().refUpdateReturnCodeWas, new Object[]{aof_a})).toString();
        }
        super(str);
        this.j6 = aof_a;
        this.DW = aoc;
    }
}
