import java.util.Collection;
import org.eclipse.jgit.JGitText;

public abstract class awf extends awl {
    public static awl j6(awl awl, awl awl2) {
        if (awl == FH) {
            return awl2;
        }
        if (awl2 == FH) {
            return awl;
        }
        return new awf$a(awl, awl2);
    }

    public static awl j6(Collection<awl> collection) {
        if (collection.size() < 2) {
            throw new IllegalArgumentException(JGitText.j6().atLeastTwoFiltersNeeded);
        }
        awl[] awlArr = new awl[collection.size()];
        collection.toArray(awlArr);
        if (awlArr.length == 2) {
            return j6(awlArr[0], awlArr[1]);
        }
        return new awf$b(awlArr);
    }
}
