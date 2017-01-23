import java.util.List;
import org.eclipse.jgit.JGitText;

abstract class amp implements amt {
    private final boolean DW;
    private List<amt> j6;

    protected abstract boolean j6(char c);

    amp(boolean z) {
        this.j6 = null;
        this.DW = z;
    }

    public final void j6(List<amt> list) {
        if (this.j6 != null) {
            throw new IllegalStateException(JGitText.j6().propertyIsAlreadyNonNull);
        }
        this.j6 = list;
    }

    public List<amt> DW(char c) {
        if (j6(c)) {
            return this.j6;
        }
        return amr.j6;
    }

    boolean j6() {
        return this.DW;
    }
}
