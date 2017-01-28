import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import org.eclipse.jgit.JGitText;

public class akw extends IOException {
    private final Collection<ans> DW;
    private final amz j6;

    public akw(amz amz, Collection<ans> collection) {
        super(MessageFormat.format(JGitText.j6().ambiguousObjectAbbreviation, new Object[]{amz.v5()}));
        this.j6 = amz;
        this.DW = collection;
    }
}
