import java.util.Iterator;

class any$2 implements and<T> {
    private T DW;
    private long FH;
    private final /* synthetic */ Iterator Hw;
    final /* synthetic */ any j6;

    any$2(any any, Iterator it) {
        this.j6 = any;
        this.Hw = it;
    }

    public boolean j6() {
        if (!this.Hw.hasNext()) {
            return false;
        }
        this.DW = (ans) this.Hw.next();
        this.FH = this.j6.Hw(this.DW, -1);
        return true;
    }

    public T DW() {
        return this.DW;
    }

    public ans FH() {
        return this.DW;
    }

    public long Hw() {
        return this.FH;
    }

    public void v5() {
    }
}
