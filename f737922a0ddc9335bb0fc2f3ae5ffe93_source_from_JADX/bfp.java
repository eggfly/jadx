import java.math.BigInteger;

public class bfp extends bfn {
    private BigInteger DW;

    public bfp(BigInteger bigInteger, bfo bfo) {
        super(true, bfo);
        this.DW = bigInteger;
    }

    public BigInteger FH() {
        return this.DW;
    }

    public int hashCode() {
        return this.DW.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof bfp) {
            return ((bfp) obj).FH().equals(this.DW) && super.equals(obj);
        } else {
            return false;
        }
    }
}
