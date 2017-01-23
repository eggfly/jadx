import java.util.AbstractList;

class yi$1 extends AbstractList<String> {
    final /* synthetic */ yi j6;

    yi$1(yi yiVar) {
        this.j6 = yiVar;
    }

    public /* synthetic */ Object get(int i) {
        return j6(i);
    }

    public String j6(int i) {
        yi.DW(i, this.j6.FH.DW.DW);
        return this.j6.j6(this.j6.FH.DW.FH + (i * 4)).EQ();
    }

    public int size() {
        return this.j6.FH.DW.DW;
    }
}
