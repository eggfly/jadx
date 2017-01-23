public class bfr {
    private int DW;
    private byte[] j6;

    public boolean equals(Object obj) {
        if (!(obj instanceof bfr)) {
            return false;
        }
        bfr bfr = (bfr) obj;
        if (bfr.DW == this.DW) {
            return bhf.j6(this.j6, bfr.j6);
        }
        return false;
    }

    public int hashCode() {
        return this.DW ^ bhf.j6(this.j6);
    }
}
