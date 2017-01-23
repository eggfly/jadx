import java.util.Iterator;
import java.util.NoSuchElementException;

class axf$1 implements Iterator<aoc> {
    private int DW;
    final /* synthetic */ axf j6;

    axf$1(axf axf) {
        this.j6 = axf;
    }

    public /* synthetic */ Object next() {
        return j6();
    }

    public boolean hasNext() {
        return this.DW < this.j6.FH;
    }

    public aoc j6() {
        if (this.DW < this.j6.FH) {
            aoc[] DW = this.j6.DW;
            int i = this.DW;
            this.DW = i + 1;
            return DW[i];
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
