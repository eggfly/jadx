package com.p105c.p106a.p107a.p108a;

/* renamed from: com.c.a.a.a.e */
public class C2091e {
    public static boolean m7809a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int m7810b(String str) {
        int i = 0;
        if (str.length() <= 0) {
            return 0;
        }
        char[] toCharArray = str.toCharArray();
        int i2 = 0;
        while (i < toCharArray.length) {
            i2 = (i2 * 31) + toCharArray[i];
            i++;
        }
        return i2;
    }
}
