import java.io.File;
import java.util.Collections;
import java.util.Set;
import org.eclipse.jgit.JGitText;

class avk$1 extends avl {
    avk$1() {
    }

    public String j6() {
        return JGitText.j6().transportProtoLocal;
    }

    public Set<String> DW() {
        return Collections.singleton("file");
    }

    public boolean DW(avn avn, aoh aoh, String str) {
        if (avn.FH() != null && avn.VH() <= 0 && avn.v5() == null && avn.Zo() == null && avn.j6() == null && (avn.DW() == null || DW().contains(avn.DW()))) {
            return true;
        }
        return false;
    }

    public avd j6(avn avn, aoh aoh, String str) {
        File j6 = aoh.gn().j6(new File("."), avn.FH());
        if (j6.isFile()) {
            return new avg(aoh, avn, j6);
        }
        j6 = aoj$a.Hw(j6, aoh.gn());
        if (j6 != null) {
            return new avk(aoh, avn, j6);
        }
        throw new alk(avn, JGitText.j6().notFound);
    }
}
