import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class axg$1 extends AbstractSet<Entry<String, aoc>> {
    final /* synthetic */ axg j6;

    axg$1(axg axg) {
        this.j6 = axg;
    }

    public Iterator<Entry<String, aoc>> iterator() {
        return new axg$b(this.j6);
    }

    public int size() {
        if (!this.j6.Zo) {
            this.j6.v5 = 0;
            Iterator it = this.j6.entrySet().iterator();
            while (it.hasNext()) {
                axg axg = this.j6;
                axg.v5 = axg.v5 + 1;
                it.next();
            }
            this.j6.Zo = true;
        }
        return this.j6.v5;
    }

    public boolean isEmpty() {
        if (this.j6.Zo) {
            if (this.j6.v5 == 0) {
                return true;
            }
            return false;
        } else if (iterator().hasNext()) {
            return false;
        } else {
            return true;
        }
    }

    public void clear() {
        this.j6.DW = axf.j6();
        this.j6.FH = axf.j6();
        this.j6.Hw = axf.j6();
        this.j6.v5 = 0;
        this.j6.Zo = true;
    }
}
