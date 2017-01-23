import java.math.BigInteger;

public class bfo implements bel {
    private BigInteger DW;
    private BigInteger FH;
    private BigInteger Hw;
    private bfr VH;
    private int Zo;
    private BigInteger j6;
    private int v5;

    private static int j6(int i) {
        if (i == 0) {
            return 160;
        }
        if (i >= 160) {
            i = 160;
        }
        return i;
    }

    public bfo(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this(bigInteger, bigInteger2, bigInteger3, j6(i), i, null, null);
    }

    public bfo(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, bfr bfr) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, bfr);
    }

    public bfo(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, bfr bfr) {
        if (i2 != 0) {
            if (BigInteger.valueOf(2 ^ ((long) (i2 - 1))).compareTo(bigInteger) == 1) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            } else if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        this.j6 = bigInteger2;
        this.DW = bigInteger;
        this.FH = bigInteger3;
        this.v5 = i;
        this.Zo = i2;
        this.Hw = bigInteger4;
        this.VH = bfr;
    }

    public BigInteger j6() {
        return this.DW;
    }

    public BigInteger DW() {
        return this.j6;
    }

    public BigInteger FH() {
        return this.FH;
    }

    public int Hw() {
        return this.v5;
    }

    public int v5() {
        return this.Zo;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bfo)) {
            return false;
        }
        bfo bfo = (bfo) obj;
        if (FH() != null) {
            if (!FH().equals(bfo.FH())) {
                return false;
            }
        } else if (bfo.FH() != null) {
            return false;
        }
        if (bfo.j6().equals(this.DW) && bfo.DW().equals(this.j6)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (FH() != null ? FH().hashCode() : 0) ^ (DW().hashCode() ^ j6().hashCode());
    }
}
