import java.util.Collections;
import java.util.Set;

public class aip {
    private final boolean DW;
    private final anm j6;

    public aip(anm anm) {
        boolean z;
        this.j6 = anm;
        if (anm.DW().isEmpty() && anm.FH().isEmpty() && anm.Hw().isEmpty() && anm.v5().isEmpty() && anm.Zo().isEmpty() && anm.VH().isEmpty() && anm.gn().isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        this.DW = z;
    }

    public Set<String> j6() {
        return Collections.unmodifiableSet(this.j6.DW());
    }

    public Set<String> DW() {
        return Collections.unmodifiableSet(this.j6.FH());
    }

    public Set<String> FH() {
        return Collections.unmodifiableSet(this.j6.Hw());
    }

    public Set<String> Hw() {
        return Collections.unmodifiableSet(this.j6.v5());
    }

    public Set<String> v5() {
        return Collections.unmodifiableSet(this.j6.Zo());
    }

    public Set<String> Zo() {
        return Collections.unmodifiableSet(this.j6.VH());
    }

    public Set<String> VH() {
        return Collections.unmodifiableSet(this.j6.gn());
    }
}
