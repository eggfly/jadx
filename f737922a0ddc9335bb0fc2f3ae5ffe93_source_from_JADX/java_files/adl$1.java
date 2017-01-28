import java.util.NoSuchElementException;

class adl$1 implements adf {
    private int DW;
    final /* synthetic */ adl j6;

    adl$1(adl adl) {
        this.j6 = adl;
        this.DW = 0;
    }

    public boolean j6() {
        return this.DW < this.j6.j6.DW();
    }

    public int DW() {
        if (j6()) {
            adg adg = this.j6.j6;
            int i = this.DW;
            this.DW = i + 1;
            return adg.DW(i);
        }
        throw new NoSuchElementException();
    }
}
