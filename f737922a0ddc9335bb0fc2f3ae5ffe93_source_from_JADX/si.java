public final class si implements abm {
    private final int j6;

    public si(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("subroutineAddress < 0");
        }
        this.j6 = i;
    }

    public String toString() {
        return "<addr:" + add.FH(this.j6) + ">";
    }

    public String Hw() {
        return toString();
    }

    public abl j6() {
        return abl.EQ;
    }

    public abm DW() {
        return this;
    }

    public int FH() {
        return abl.EQ.FH();
    }

    public int v5() {
        return abl.EQ.v5();
    }

    public boolean Zo() {
        return false;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof si) && this.j6 == ((si) obj).j6) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.j6;
    }

    public int VH() {
        return this.j6;
    }
}
