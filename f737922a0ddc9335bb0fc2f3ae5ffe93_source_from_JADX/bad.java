import java.math.BigInteger;

public class bad extends ayv {
    byte[] j6;

    public static ayn j6(Object obj) {
        if (obj == null || (obj instanceof ayn)) {
            return (ayn) obj;
        }
        if (obj instanceof bad) {
            return new ayn(((bad) obj).FH());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ayn j6(azc azc, boolean z) {
        Object EQ = azc.EQ();
        if (z || (EQ instanceof bad)) {
            return j6(EQ);
        }
        return new ayn(ayr.j6(azc.EQ()).Hw());
    }

    public bad(int i) {
        this.j6 = BigInteger.valueOf((long) i).toByteArray();
    }

    public bad(BigInteger bigInteger) {
        this.j6 = bigInteger.toByteArray();
    }

    public bad(byte[] bArr) {
        this.j6 = bArr;
    }

    public BigInteger FH() {
        return new BigInteger(this.j6);
    }

    public BigInteger Hw() {
        return new BigInteger(1, this.j6);
    }

    boolean gn() {
        return false;
    }

    int u7() {
        return (bbg.j6(this.j6.length) + 1) + this.j6.length;
    }

    void j6(ayt ayt) {
        ayt.j6(2, this.j6);
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (i != this.j6.length) {
            i2 ^= (this.j6[i] & 255) << (i % 4);
            i++;
        }
        return i2;
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof bad)) {
            return false;
        }
        return bhf.j6(this.j6, ((bad) ayv).j6);
    }

    public String toString() {
        return FH().toString();
    }
}
