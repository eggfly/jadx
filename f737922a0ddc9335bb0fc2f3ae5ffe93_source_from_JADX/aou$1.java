import java.util.Iterator;

class aou$1 implements Iterator<aor> {
    final /* synthetic */ aou DW;
    int j6;

    aou$1(aou aou) {
        this.DW = aou;
    }

    public /* synthetic */ Object next() {
        return j6();
    }

    public boolean hasNext() {
        return this.j6 < this.DW.DW.j6();
    }

    public aor j6() {
        aor$a[] FH = aou.Hw;
        awy j6 = this.DW.DW;
        int i = this.j6;
        this.j6 = i + 1;
        aor$a aor_a = FH[j6.j6(i)];
        j6 = this.DW.DW;
        i = this.j6;
        this.j6 = i + 1;
        int j62 = j6.j6(i);
        awy j63 = this.DW.DW;
        int i2 = this.j6;
        this.j6 = i2 + 1;
        i = j63.j6(i2);
        awy j64 = this.DW.DW;
        int i3 = this.j6;
        this.j6 = i3 + 1;
        return new aor(j62, i, j64.j6(i3), aor_a);
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
