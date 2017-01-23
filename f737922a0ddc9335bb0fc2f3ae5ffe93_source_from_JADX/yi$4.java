import java.util.AbstractList;

class yi$4 extends AbstractList<yq> {
    final /* synthetic */ yi j6;

    yi$4(yi yiVar) {
        this.j6 = yiVar;
    }

    public /* synthetic */ Object get(int i) {
        return j6(i);
    }

    public yq j6(int i) {
        yi.DW(i, r1.FH.Hw.DW);
        return this.j6.j6(this.j6.FH.Hw.FH + (i * 12)).J8();
    }

    public int size() {
        return this.j6.FH.Hw.DW;
    }
}
