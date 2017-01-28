public class bfn extends bfk {
    private bfo DW;

    protected bfn(boolean z, bfo bfo) {
        super(z);
        this.DW = bfo;
    }

    public bfo DW() {
        return this.DW;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bfn)) {
            return false;
        }
        bfn bfn = (bfn) obj;
        if (this.DW != null) {
            return this.DW.equals(bfn.DW());
        }
        if (bfn.DW() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = j6() ? 0 : 1;
        if (this.DW != null) {
            return i ^ this.DW.hashCode();
        }
        return i;
    }
}
