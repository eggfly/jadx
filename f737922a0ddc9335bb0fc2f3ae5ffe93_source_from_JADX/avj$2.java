import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import org.eclipse.jgit.JGitText;

class avj$2 extends avl {
    avj$2() {
    }

    public String j6() {
        return JGitText.j6().transportProtoFTP;
    }

    public Set<String> DW() {
        return Collections.singleton("ftp");
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
