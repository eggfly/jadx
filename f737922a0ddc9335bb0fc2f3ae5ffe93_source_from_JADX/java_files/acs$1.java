import java.util.NoSuchElementException;

class acs$1 implements adf {
    private int DW;
    final /* synthetic */ acs j6;

    acs$1(acs acs) {
        this.j6 = acs;
        this.DW = act.Hw(this.j6.j6, 0);
    }

    public boolean j6() {
        return this.DW >= 0;
    }

    public int DW() {
        if (j6()) {
            int i = this.DW;
            this.DW = act.Hw(this.j6.j6, this.DW + 1);
            return i;
        }
        throw new NoSuchElementException();
    }
}
