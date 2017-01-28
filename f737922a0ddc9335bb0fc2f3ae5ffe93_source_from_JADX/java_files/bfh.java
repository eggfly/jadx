import java.math.BigInteger;
import java.security.SecureRandom;

class bfh {
    private static final BigInteger DW;
    private static final BigInteger FH;
    static final bfh j6;

    static {
        j6 = new bfh();
        DW = BigInteger.valueOf(1);
        FH = BigInteger.valueOf(2);
    }

    private bfh() {
    }

    BigInteger j6(bfo bfo, SecureRandom secureRandom) {
        BigInteger j6 = bfo.j6();
        int v5 = bfo.v5();
        if (v5 != 0) {
            return new BigInteger(v5, secureRandom).setBit(v5 - 1);
        }
        BigInteger bigInteger = FH;
        int Hw = bfo.Hw();
        if (Hw != 0) {
            bigInteger = DW.shiftLeft(Hw - 1);
        }
        j6 = j6.subtract(FH);
        BigInteger FH = bfo.FH();
        if (FH != null) {
            j6 = FH.subtract(FH);
        }
        return bhg.j6(bigInteger, j6, secureRandom);
    }

    BigInteger j6(bfo bfo, BigInteger bigInteger) {
        return bfo.DW().modPow(bigInteger, bfo.j6());
    }
}
