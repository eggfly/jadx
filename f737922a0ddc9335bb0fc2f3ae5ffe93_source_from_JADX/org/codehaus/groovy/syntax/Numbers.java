package org.codehaus.groovy.syntax;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Numbers {
    private static final BigInteger DW;
    private static final BigInteger FH;
    private static final BigInteger Hw;
    private static final BigDecimal VH;
    private static final BigDecimal Zo;
    private static final BigDecimal gn;
    private static final BigInteger j6;
    private static final BigDecimal v5;

    static {
        j6 = BigInteger.valueOf(Long.MAX_VALUE);
        DW = BigInteger.valueOf(Long.MIN_VALUE);
        FH = BigInteger.valueOf(2147483647L);
        Hw = BigInteger.valueOf(-2147483648L);
        v5 = new BigDecimal(String.valueOf(Double.MAX_VALUE));
        Zo = v5.negate();
        VH = new BigDecimal(String.valueOf(Float.MAX_VALUE));
        gn = VH.negate();
    }
}
