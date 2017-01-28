import java.math.BigInteger;

public class azw extends ayv {
    private static ayj[] DW;
    byte[] j6;

    public azw(byte[] bArr) {
        this.j6 = bArr;
    }

    public BigInteger FH() {
        return new BigInteger(this.j6);
    }

    boolean gn() {
        return false;
    }

    int u7() {
        return (bbg.j6(this.j6.length) + 1) + this.j6.length;
    }

    void j6(ayt ayt) {
        ayt.j6(10, this.j6);
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof azw)) {
            return false;
        }
        return bhf.j6(this.j6, ((azw) ayv).j6);
    }

    public int hashCode() {
        return bhf.j6(this.j6);
    }

    static {
        DW = new ayj[12];
    }

    static ayj DW(byte[] bArr) {
        if (bArr.length > 1) {
            return new ayj(bhf.DW(bArr));
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i = bArr[0] & 255;
        if (i >= DW.length) {
            return new ayj(bhf.DW(bArr));
        }
        ayj ayj = DW[i];
        if (ayj != null) {
            return ayj;
        }
        ayj[] ayjArr = DW;
        ayj = new ayj(bhf.DW(bArr));
        ayjArr[i] = ayj;
        return ayj;
    }
}
