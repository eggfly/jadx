import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.eclipse.jgit.JGitText;

public abstract class atf implements atl {
    private boolean DW;
    private Writer FH;
    private Map<String, aoc> j6;

    public atf() {
        this.j6 = Collections.emptyMap();
    }

    public Map<String, aoc> j6() {
        return this.j6;
    }

    public final Collection<aoc> DW() {
        return this.j6.values();
    }

    public final aoc j6(String str) {
        return (aoc) this.j6.get(str);
    }

    public String FH() {
        return this.FH != null ? this.FH.toString() : "";
    }

    protected void j6(Map<String, aoc> map) {
        this.j6 = Collections.unmodifiableMap(map);
    }

    protected void Hw() {
        if (this.DW) {
            throw new amb(JGitText.j6().onlyOneOperationCallPerConnectionIsSupported);
        }
        this.DW = true;
    }

    protected Writer v5() {
        if (this.FH == null) {
            j6(new StringWriter());
        }
        return this.FH;
    }

    protected void j6(Writer writer) {
        if (this.FH != null) {
            throw new IllegalStateException(JGitText.j6().writerAlreadyInitialized);
        }
        this.FH = writer;
    }
}
