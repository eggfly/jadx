public class amj {
    final amo DW;
    private final amk FH;
    final Class<? extends amo> j6;

    amj(amk amk, Class<? extends amo> cls, amo amo) {
        this.FH = amk;
        this.j6 = cls;
        this.DW = amo;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(this.j6.getSimpleName())).append("[").append(this.DW).append("]").toString();
    }
}
