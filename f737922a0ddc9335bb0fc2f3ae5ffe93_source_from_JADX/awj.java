import java.util.Collection;
import org.eclipse.jgit.JGitText;

public class awj {
    public static awl j6(Collection<String> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(JGitText.j6().atLeastOnePathIsRequired);
        }
        awi[] awiArr = new awi[collection.size()];
        int i = 0;
        for (String j6 : collection) {
            int i2 = i + 1;
            awiArr[i] = awi.j6(j6);
            i = i2;
        }
        return j6(awiArr);
    }

    public static awl DW(Collection<awi> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(JGitText.j6().atLeastOnePathIsRequired);
        }
        awi[] awiArr = new awi[collection.size()];
        collection.toArray(awiArr);
        return j6(awiArr);
    }

    private static awl j6(awi[] awiArr) {
        if (awiArr.length == 1) {
            return new awj$b(null);
        }
        return new awj$a(null);
    }
}
