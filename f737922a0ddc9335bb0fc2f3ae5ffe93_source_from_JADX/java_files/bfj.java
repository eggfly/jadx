import java.math.BigInteger;
import java.security.SecureRandom;

class bfj {
    private static final BigInteger DW;
    private static final BigInteger j6;

    static {
        j6 = BigInteger.valueOf(1);
        DW = BigInteger.valueOf(2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.math.BigInteger[] j6(int r6, int r7, java.security.SecureRandom r8) {
        /*
        r5 = 1;
        r4 = 2;
        r0 = r6 + -1;
    L_0x0004:
        r1 = new java.math.BigInteger;
        r1.<init>(r0, r4, r8);
        r2 = r1.shiftLeft(r5);
        r3 = j6;
        r2 = r2.add(r3);
        r3 = r2.isProbablePrime(r7);
        if (r3 == 0) goto L_0x0004;
    L_0x0019:
        if (r7 <= r4) goto L_0x0021;
    L_0x001b:
        r3 = r1.isProbablePrime(r7);
        if (r3 == 0) goto L_0x0004;
    L_0x0021:
        r0 = new java.math.BigInteger[r4];
        r3 = 0;
        r0[r3] = r2;
        r0[r5] = r1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: bfj.j6(int, int, java.security.SecureRandom):java.math.BigInteger[]");
    }

    static BigInteger j6(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger subtract = bigInteger.subtract(DW);
        do {
            modPow = bhg.j6(DW, subtract, secureRandom).modPow(DW, bigInteger);
        } while (modPow.equals(j6));
        return modPow;
    }
}
