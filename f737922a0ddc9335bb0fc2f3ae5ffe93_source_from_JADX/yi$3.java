import java.util.AbstractList;

class yi$3 extends AbstractList<String> {
    final /* synthetic */ yi j6;

    yi$3(yi yiVar) {
        this.j6 = yiVar;
    }

    public /* synthetic */ Object get(int i) {
        return j6(i);
    }

    public String j6(int i) {
        yi.DW(i, this.j6.FH.FH.DW);
        return (String) this.j6.v5.get(((Integer) this.j6.Zo.get(i)).intValue());
    }

    public int size() {
        return this.j6.FH.FH.DW;
    }
}
