import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

class axg$b implements Iterator<Entry<String, aoc>> {
    private int DW;
    private int FH;
    private int Hw;
    final /* synthetic */ axg j6;
    private Entry<String, aoc> v5;

    public /* synthetic */ Object next() {
        return j6();
    }

    axg$b(axg axg) {
        this.j6 = axg;
        if (axg.j6.length() > 0) {
            this.DW = -(axg.DW.j6(axg.j6) + 1);
            this.FH = -(axg.FH.j6(axg.j6) + 1);
            this.Hw = -(axg.Hw.j6(axg.j6) + 1);
        }
    }

    public boolean hasNext() {
        if (this.v5 == null) {
            this.v5 = DW();
        }
        return this.v5 != null;
    }

    public Entry<String, aoc> j6() {
        if (hasNext()) {
            Entry<String, aoc> entry = this.v5;
            this.v5 = DW();
            return entry;
        }
        throw new NoSuchElementException();
    }

    public Entry<String, aoc> DW() {
        if (this.DW < this.j6.DW.FH() && this.FH < this.j6.FH.FH()) {
            aoc j6 = this.j6.DW.j6(this.DW);
            aoc j62 = this.j6.FH.j6(this.FH);
            int DW = aod.DW(j6, j62);
            if (DW < 0) {
                this.DW++;
                return DW(j6);
            }
            if (DW == 0) {
                this.DW++;
            }
            this.FH++;
            return DW(j6(j62));
        } else if (this.FH < this.j6.FH.FH()) {
            r0 = this.j6.FH;
            r1 = this.FH;
            this.FH = r1 + 1;
            return DW(j6(r0.j6(r1)));
        } else if (this.DW >= this.j6.DW.FH()) {
            return null;
        } else {
            r0 = this.j6.DW;
            r1 = this.DW;
            this.DW = r1 + 1;
            return DW(r0.j6(r1));
        }
    }

    private aoc j6(aoc aoc) {
        if (this.Hw >= this.j6.Hw.FH()) {
            return aoc;
        }
        aoc j6 = this.j6.Hw.j6(this.Hw);
        int DW = aod.DW(aoc, j6);
        if (DW == 0) {
            this.Hw++;
            return j6;
        } else if (DW <= 0) {
            return aoc;
        } else {
            throw new IllegalStateException();
        }
    }

    private axg$a DW(aoc aoc) {
        if (aoc.j6().startsWith(this.j6.j6)) {
            return new axg$a(this.j6, aoc);
        }
        this.DW = this.j6.DW.FH();
        this.FH = this.j6.FH.FH();
        this.Hw = this.j6.Hw.FH();
        return null;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
