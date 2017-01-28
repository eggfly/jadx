import java.util.concurrent.atomic.AtomicReferenceArray;

class asd$a {
    private final AtomicReferenceArray<ans> DW;
    private final int FH;
    final int j6;

    asd$a(int i) {
        this.DW = new AtomicReferenceArray(1 << i);
        this.FH = 32 - i;
        this.j6 = i;
    }

    boolean j6(anb anb) {
        int i = 0;
        int FH = FH(anb);
        while (i < 8) {
            anb anb2 = (ans) this.DW.get(FH);
            if (anb2 == null) {
                return false;
            }
            if (anb.j6(anb2, anb)) {
                return true;
            }
            int i2 = FH + 1;
            if (i2 == this.DW.length()) {
                i2 = 0;
            }
            i++;
            FH = i2;
        }
        return false;
    }

    boolean DW(anb anb) {
        int i = 0;
        int FH = FH(anb);
        while (i < 8) {
            anb anb2 = (ans) this.DW.get(FH);
            if (anb2 == null) {
                if (this.DW.compareAndSet(FH, null, anb.Hw())) {
                    return true;
                }
            } else if (anb.j6(anb2, anb)) {
                return true;
            } else {
                int i2 = FH + 1;
                if (i2 == this.DW.length()) {
                    i2 = 0;
                }
                i++;
                FH = i2;
            }
        }
        return false;
    }

    private int FH(anb anb) {
        return anb.hashCode() >>> this.FH;
    }
}
