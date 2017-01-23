package com.miui.support.text;

import com.miui.support.util.Pools;

public class ExtraTextUtils {
    private static final char[] f3571a;

    static {
        f3571a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    protected ExtraTextUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static void m5243a(byte[] bArr, Appendable appendable) {
        if (bArr != null) {
            try {
                for (int i : bArr) {
                    int i2;
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    appendable.append(f3571a[i2 >> 4]).append(f3571a[i2 & 15]);
                }
            } catch (Throwable e) {
                throw new RuntimeException("Exception throw during when append", e);
            }
        }
    }

    public static String m5242a(byte[] bArr) {
        StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
        m5243a(bArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Pools.m5430a().m5401b(stringBuilder);
        return stringBuilder2;
    }

    public static byte[] m5244a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("s is not a readable string: " + str);
        }
        byte[] bArr = new byte[(length >> 1)];
        for (int i = 0; i < length; i += 2) {
            int i2;
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i2 = charAt - 48;
            } else if (charAt >= 'a' && charAt <= 'f') {
                i2 = (charAt - 97) + 10;
            } else if (charAt < 'A' || charAt > 'F') {
                throw new IllegalArgumentException("s is not a readable string: " + str);
            } else {
                i2 = (charAt - 65) + 10;
            }
            i2 <<= 4;
            char charAt2 = str.charAt(i + 1);
            if (charAt2 >= '0' && charAt2 <= '9') {
                i2 += charAt2 - 48;
            } else if (charAt2 >= 'a' && charAt2 <= 'f') {
                i2 += (charAt2 - 97) + 10;
            } else if (charAt2 < 'A' || charAt2 > 'F') {
                throw new IllegalArgumentException("s is not a readable string: " + str);
            } else {
                i2 += (charAt2 - 65) + 10;
            }
            bArr[i >> 1] = (byte) i2;
        }
        return bArr;
    }
}
