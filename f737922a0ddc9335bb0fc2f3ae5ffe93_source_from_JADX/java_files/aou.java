import java.util.Iterator;
import java.util.List;

public class aou<S extends akh> implements Iterable<aor> {
    private static final aor$a[] Hw;
    private final awy DW;
    private boolean FH;
    private final List<S> j6;

    public aou(List<S> list) {
        this.DW = new awy();
        this.FH = false;
        this.j6 = list;
    }

    public void j6(int i, int i2, int i3, aor$a aor_a) {
        this.DW.DW(aor_a.ordinal());
        this.DW.DW(i);
        this.DW.DW(i2);
        this.DW.DW(i3);
        if (aor_a != aor$a.NO_CONFLICT) {
            this.FH = true;
        }
    }

    public List<S> j6() {
        return this.j6;
    }

    static {
        Hw = aor$a.values();
    }

    public Iterator<aor> iterator() {
        return new aou$1(this);
    }

    public boolean DW() {
        return this.FH;
    }
}
