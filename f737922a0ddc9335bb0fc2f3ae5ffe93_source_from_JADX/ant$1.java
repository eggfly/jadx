import java.util.Iterator;
import java.util.NoSuchElementException;

class ant$1 implements Iterator<V> {
    private int DW;
    private int FH;
    private int Hw;
    final /* synthetic */ ant j6;
    private V v5;

    ant$1(ant ant) {
        this.j6 = ant;
    }

    public /* synthetic */ Object next() {
        return j6();
    }

    public boolean hasNext() {
        return this.DW < this.j6.DW;
    }

    public V j6() {
        if (this.v5 != null) {
            return j6(this.v5);
        }
        while (true) {
            ant$a[] ant_aArr = this.j6.j6[this.FH];
            if (this.Hw == ant_aArr.length) {
                int i = this.FH + 1;
                this.FH = i;
                if (i >= (1 << this.j6.Hw)) {
                    break;
                }
                ant_aArr = this.j6.j6[this.FH];
                this.Hw = 0;
            }
            while (this.Hw < ant_aArr.length) {
                int i2 = this.Hw;
                this.Hw = i2 + 1;
                ant$a ant_a = ant_aArr[i2];
                if (ant_a != null) {
                    return j6(ant_a);
                }
            }
        }
        throw new NoSuchElementException();
    }

    private V j6(V v) {
        this.DW++;
        this.v5 = v.Zo;
        return v;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
