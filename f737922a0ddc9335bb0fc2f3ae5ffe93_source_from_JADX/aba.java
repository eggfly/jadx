public abstract class aba extends abh {
    private final abc DW;
    private final abf j6;

    aba(abf abf, abc abc) {
        if (abf == null) {
            throw new NullPointerException("definingClass == null");
        } else if (abc == null) {
            throw new NullPointerException("nat == null");
        } else {
            this.j6 = abf;
            this.DW = abc;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        aba aba = (aba) obj;
        if (this.j6.equals(aba.j6) && this.DW.equals(aba.DW)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.j6.hashCode() * 31) ^ this.DW.hashCode();
    }

    protected int DW(aah aah) {
        aba aba = (aba) aah;
        int j6 = this.j6.j6(aba.j6);
        return j6 != 0 ? j6 : this.DW.j6().j6(aba.DW.j6());
    }

    public final String toString() {
        return gn() + '{' + Hw() + '}';
    }

    public final boolean VH() {
        return false;
    }

    public final String Hw() {
        return this.j6.Hw() + '.' + this.DW.Hw();
    }

    public final abf J0() {
        return this.j6;
    }

    public final abc J8() {
        return this.DW;
    }
}
