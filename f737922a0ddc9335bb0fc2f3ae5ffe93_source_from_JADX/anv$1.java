import java.util.Iterator;
import java.util.NoSuchElementException;

class anv$1 implements Iterator<V> {
    private int DW;
    private int FH;
    final /* synthetic */ anv j6;

    anv$1(anv anv) {
        this.j6 = anv;
    }

    public /* synthetic */ Object next() {
        return j6();
    }

    public boolean hasNext() {
        return this.DW < this.j6.j6;
    }

    public V j6() {
        while (this.FH < this.j6.Hw.length) {
            ans[] DW = this.j6.Hw;
            int i = this.FH;
            this.FH = i + 1;
            V v = DW[i];
            if (v != null) {
                this.DW++;
                return v;
            }
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
