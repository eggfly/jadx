import java.util.Iterator;

class aqf$1 implements Iterator<aqe> {
    private aqe DW;
    private final /* synthetic */ Iterator FH;
    final /* synthetic */ aqf j6;

    aqf$1(aqf aqf, Iterator it) {
        this.j6 = aqf;
        this.FH = it;
    }

    public /* synthetic */ Object next() {
        return j6();
    }

    public boolean hasNext() {
        return this.FH.hasNext();
    }

    public aqe j6() {
        aqe aqe = (aqe) this.FH.next();
        this.DW = aqe;
        return aqe;
    }

    public void remove() {
        aqf aqf = this.j6;
        aqf.j6 &= this.DW.Hw ^ -1;
        this.FH.remove();
    }
}
