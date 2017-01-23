import java.util.AbstractList;

class yi$2 extends AbstractList<Integer> {
    final /* synthetic */ yi j6;

    yi$2(yi yiVar) {
        this.j6 = yiVar;
    }

    public /* synthetic */ Object get(int i) {
        return j6(i);
    }

    public Integer j6(int i) {
        yi.DW(i, this.j6.FH.FH.DW);
        return Integer.valueOf(this.j6.j6(this.j6.FH.FH.FH + (i * 4)).FH());
    }

    public int size() {
        return this.j6.FH.FH.DW;
    }
}
