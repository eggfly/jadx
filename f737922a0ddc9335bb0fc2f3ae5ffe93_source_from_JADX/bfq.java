import java.math.BigInteger;

public class bfq extends bfn {
    private BigInteger DW;

    public bfq(BigInteger bigInteger, bfo bfo) {
        super(false, bfo);
        this.DW = bigInteger;
    }

    public BigInteger FH() {
        return this.DW;
    }

    public int hashCode() {
        return this.DW.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof bfq) {
            return ((bfq) obj).FH().equals(this.DW) && super.equals(obj);
        } else {
            return false;
        }
    }
}
