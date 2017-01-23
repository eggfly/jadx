import java.util.Iterator;
import java.util.NoSuchElementException;

class awn$a implements Iterator<T> {
    private int DW;
    private int FH;
    private int Hw;
    final /* synthetic */ awn j6;
    private T[] v5;

    private awn$a(awn awn) {
        this.j6 = awn;
        this.v5 = awn.j6[0];
    }

    public boolean hasNext() {
        return this.DW < this.j6.DW;
    }

    public T next() {
        if (this.j6.DW <= this.DW) {
            throw new NoSuchElementException();
        }
        T t = this.v5[this.Hw];
        int i = this.Hw + 1;
        this.Hw = i;
        if (i == 1024) {
            i = this.FH + 1;
            this.FH = i;
            if (i < this.j6.j6.length) {
                this.v5 = this.j6.j6[this.FH];
            } else {
                this.v5 = null;
            }
            this.Hw = 0;
        }
        this.DW++;
        return t;
    }

    public void remove() {
        if (this.DW == 0) {
            throw new IllegalStateException();
        }
        awn awn = this.j6;
        int i = this.DW - 1;
        this.DW = i;
        awn.remove(i);
        this.FH = awn.FH(this.DW);
        this.Hw = awn.Hw(this.DW);
        this.v5 = this.j6.j6[this.FH];
    }
}
