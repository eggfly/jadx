import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aqf extends AbstractSet<aqe> {
    private final List<aqe> DW;
    int j6;

    public /* synthetic */ boolean add(Object obj) {
        return j6((aqe) obj);
    }

    public aqf() {
        this.DW = new ArrayList();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof aqe) || (this.j6 & ((aqe) obj).Hw) == 0) {
            return false;
        }
        return true;
    }

    public boolean containsAll(Collection<?> collection) {
        if (!(collection instanceof aqf)) {
            return super.containsAll(collection);
        }
        int i = ((aqf) collection).j6;
        return (this.j6 & i) == i;
    }

    public boolean j6(aqe aqe) {
        if ((this.j6 & aqe.Hw) != 0) {
            return false;
        }
        this.j6 |= aqe.Hw;
        int i = 0;
        while (i < this.DW.size() && ((aqe) this.DW.get(i)).Hw < aqe.Hw) {
            i++;
        }
        this.DW.add(i, aqe);
        return true;
    }

    public boolean remove(Object obj) {
        aqe aqe = (aqe) obj;
        if ((this.j6 & aqe.Hw) == 0) {
            return false;
        }
        this.j6 &= aqe.Hw ^ -1;
        for (int i = 0; i < this.DW.size(); i++) {
            if (((aqe) this.DW.get(i)).Hw == aqe.Hw) {
                this.DW.remove(i);
            }
        }
        return true;
    }

    public Iterator<aqe> iterator() {
        return new aqf$1(this, this.DW.iterator());
    }

    public int size() {
        return this.DW.size();
    }
}
