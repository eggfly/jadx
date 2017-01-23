package com.cmcm.support.p118c;

/* renamed from: com.cmcm.support.c.c */
class C2212c {
    static final boolean[] f7619a;
    static final int[] f7620b;
    static final long[] f7621c;
    static final Object[] f7622d;

    static {
        f7619a = new boolean[0];
        f7620b = new int[0];
        f7621c = new long[0];
        f7622d = new Object[0];
    }

    static int m8323a(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = i - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i3 ^ -1;
    }
}
