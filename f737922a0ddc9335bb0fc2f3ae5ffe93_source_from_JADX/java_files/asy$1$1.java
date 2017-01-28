import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.NoSuchElementException;

class asy$1$1 implements Iterator<asy> {
    private final Iterator<WeakReference<asy>> DW;
    private asy FH;
    final /* synthetic */ asy$1 j6;

    asy$1$1(asy$1 asy_1) {
        this.j6 = asy_1;
        this.DW = asy.j6.keySet().iterator();
    }

    public /* synthetic */ Object next() {
        return j6();
    }

    public boolean hasNext() {
        if (this.FH != null) {
            return true;
        }
        while (this.DW.hasNext()) {
            this.FH = (asy) ((WeakReference) this.DW.next()).get();
            if (this.FH != null) {
                return true;
            }
            this.DW.remove();
        }
        return false;
    }

    public asy j6() {
        if (hasNext()) {
            asy asy = this.FH;
            this.FH = null;
            return asy;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
