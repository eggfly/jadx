import java.util.AbstractList;

class yi$6 extends AbstractList<yn> {
    final /* synthetic */ yi j6;

    yi$6(yi yiVar) {
        this.j6 = yiVar;
    }

    public /* synthetic */ Object get(int i) {
        return j6(i);
    }

    public yn j6(int i) {
        yi.DW(i, this.j6.FH.Zo.DW);
        return this.j6.j6(this.j6.FH.Zo.FH + (i * 8)).J0();
    }

    public int size() {
        return this.j6.FH.Zo.DW;
    }
}
