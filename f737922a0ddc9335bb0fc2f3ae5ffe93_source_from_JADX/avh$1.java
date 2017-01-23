import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import org.eclipse.jgit.JGitText;

class avh$1 extends avl {
    avh$1() {
    }

    public String j6() {
        return JGitText.j6().transportProtoGitAnon;
    }

    public Set<String> DW() {
        return Collections.singleton("git");
    }

    public Set<avl$a> FH() {
        return Collections.unmodifiableSet(EnumSet.of(avl$a.HOST, avl$a.PATH));
    }

    public Set<avl$a> Hw() {
        return Collections.unmodifiableSet(EnumSet.of(avl$a.PORT));
    }

    public avd j6(avn avn, aoh aoh, String str) {
        return new avh(aoh, avn);
    }
}
