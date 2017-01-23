import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.jgit.JGitText;

class avg$1 extends avl {
    private final Set<String> DW;
    private final String[] j6;

    avg$1() {
        this.j6 = new String[]{"bundle", "file"};
        this.DW = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(this.j6)));
    }

    public String j6() {
        return JGitText.j6().transportProtoBundleFile;
    }

    public Set<String> DW() {
        return this.DW;
    }

    public boolean DW(avn avn, aoh aoh, String str) {
        if (avn.FH() != null && avn.VH() <= 0 && avn.v5() == null && avn.Zo() == null && avn.j6() == null && (avn.DW() == null || DW().contains(avn.DW()))) {
            return true;
        }
        return false;
    }

    public avd j6(avn avn, aoh aoh, String str) {
        if ("bundle".equals(avn.DW())) {
            return new avg(aoh, avn, aoh.gn().j6(new File("."), avn.FH()));
        }
        return avk.v5.j6(avn, aoh, str);
    }
}
