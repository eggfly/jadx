public class ub$a implements Comparable<ub$a> {
    private final int DW;
    private final ua FH;
    private final int j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((ub$a) obj);
    }

    public ub$a(int i, int i2, ua uaVar) {
        if (i < 0) {
            throw new IllegalArgumentException("start < 0");
        } else if (i2 <= i) {
            throw new IllegalArgumentException("end <= start");
        } else if (uaVar.k_()) {
            throw new IllegalArgumentException("handlers.isMutable()");
        } else {
            this.j6 = i;
            this.DW = i2;
            this.FH = uaVar;
        }
    }

    public int hashCode() {
        return (((this.j6 * 31) + this.DW) * 31) + this.FH.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ub$a) && j6((ub$a) obj) == 0) {
            return true;
        }
        return false;
    }

    public int j6(ub$a ub_a) {
        if (this.j6 < ub_a.j6) {
            return -1;
        }
        if (this.j6 > ub_a.j6) {
            return 1;
        }
        if (this.DW < ub_a.DW) {
            return -1;
        }
        if (this.DW > ub_a.DW) {
            return 1;
        }
        return this.FH.j6(ub_a.FH);
    }

    public int j6() {
        return this.j6;
    }

    public int DW() {
        return this.DW;
    }

    public ua FH() {
        return this.FH;
    }
}
