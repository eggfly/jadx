public class un$b implements Comparable<un$b> {
    private final un$a DW;
    private final zw FH;
    private final abf Hw;
    private final int j6;

    public /* synthetic */ int compareTo(Object obj) {
        return j6((un$b) obj);
    }

    public un$b(int i, un$a un_a, zw zwVar) {
        if (i < 0) {
            throw new IllegalArgumentException("address < 0");
        } else if (un_a == null) {
            throw new NullPointerException("disposition == null");
        } else {
            try {
                if (zwVar.u7() == null) {
                    throw new NullPointerException("spec.getLocalItem() == null");
                }
                this.j6 = i;
                this.DW = un_a;
                this.FH = zwVar;
                this.Hw = abf.DW(zwVar.j6());
            } catch (NullPointerException e) {
                throw new NullPointerException("spec == null");
            }
        }
    }

    public String toString() {
        return Integer.toHexString(this.j6) + " " + this.DW + " " + this.FH;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof un$b) && j6((un$b) obj) == 0) {
            return true;
        }
        return false;
    }

    public int j6(un$b un_b) {
        if (this.j6 < un_b.j6) {
            return -1;
        }
        if (this.j6 > un_b.j6) {
            return 1;
        }
        boolean FH = FH();
        if (FH == un_b.FH()) {
            return this.FH.FH(un_b.FH);
        }
        if (FH) {
            return 1;
        }
        return -1;
    }

    public int j6() {
        return this.j6;
    }

    public un$a DW() {
        return this.DW;
    }

    public boolean FH() {
        return this.DW == un$a.START;
    }

    public abe Hw() {
        return this.FH.u7().j6();
    }

    public abe v5() {
        return this.FH.u7().DW();
    }

    public abf Zo() {
        return this.Hw;
    }

    public int VH() {
        return this.FH.VH();
    }

    public zw gn() {
        return this.FH;
    }

    public boolean j6(zw zwVar) {
        return this.FH.j6(zwVar);
    }

    public boolean DW(un$b un_b) {
        return j6(un_b.FH);
    }

    public un$b j6(un$a un_a) {
        return un_a == this.DW ? this : new un$b(this.j6, un_a, this.FH);
    }
}
