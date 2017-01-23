import java.util.AbstractList;

class yi$5 extends AbstractList<yl> {
    final /* synthetic */ yi j6;

    yi$5(yi yiVar) {
        this.j6 = yiVar;
    }

    public /* synthetic */ Object get(int i) {
        return j6(i);
    }

    public yl j6(int i) {
        yi.DW(i, this.j6.FH.v5.DW);
        return this.j6.j6(this.j6.FH.v5.FH + (i * 8)).we();
    }

    public int size() {
        return this.j6.FH.v5.DW;
    }
}
