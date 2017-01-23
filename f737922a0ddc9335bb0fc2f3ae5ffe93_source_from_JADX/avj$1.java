import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.jgit.JGitText;

class avj$1 extends avl {
    private final Set<String> DW;
    private final String[] j6;

    avj$1() {
        this.j6 = new String[]{"http", "https"};
        this.DW = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(this.j6)));
    }

    public String j6() {
        return JGitText.j6().transportProtoHTTP;
    }

    public Set<String> DW() {
        return this.DW;
    }

    public Set<avl$a> FH() {
        return Collections.unmodifiableSet(EnumSet.of(avl$a.HOST, avl$a.PATH));
    }

    public Set<avl$a> Hw() {
        return Collections.unmodifiableSet(EnumSet.of(avl$a.USER, avl$a.PASS, avl$a.PORT));
    }

    public avd j6(avn avn, aoh aoh, String str) {
        return new avj(aoh, avn);
    }
}
