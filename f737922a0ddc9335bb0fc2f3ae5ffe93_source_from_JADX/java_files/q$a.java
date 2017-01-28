import java.util.Iterator;

final class q$a<T> implements Iterator<T> {
    int DW;
    int FH;
    boolean Hw;
    final int j6;
    final /* synthetic */ q v5;

    q$a(q qVar, int i) {
        this.v5 = qVar;
        this.Hw = false;
        this.j6 = i;
        this.DW = qVar.j6();
    }

    public boolean hasNext() {
        return this.FH < this.DW;
    }

    public T next() {
        T j6 = this.v5.j6(this.FH, this.j6);
        this.FH++;
        this.Hw = true;
        return j6;
    }

    public void remove() {
        if (this.Hw) {
            this.FH--;
            this.DW--;
            this.Hw = false;
            this.v5.j6(this.FH);
            return;
        }
        throw new IllegalStateException();
    }
}
