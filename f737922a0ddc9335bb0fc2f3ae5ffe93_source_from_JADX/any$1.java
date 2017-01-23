import java.util.Iterator;

class any$1 implements anc<T> {
    private T DW;
    private final /* synthetic */ Iterator FH;
    final /* synthetic */ any j6;

    any$1(any any, Iterator it) {
        this.j6 = any;
        this.FH = it;
    }

    public boolean j6() {
        if (!this.FH.hasNext()) {
            return false;
        }
        this.DW = (ans) this.FH.next();
        return true;
    }

    public ans DW() {
        return this.DW;
    }

    public anx FH() {
        return this.j6.FH(this.DW, -1);
    }

    public void v5() {
    }
}
