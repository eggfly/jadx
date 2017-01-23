package com.miui.support.util;

class ContainerHelpers {
    static final int[] f3629a;
    static final long[] f3630b;
    static final Object[] f3631c;

    static {
        f3629a = new int[0];
        f3630b = new long[0];
        f3631c = new Object[0];
    }

    protected ContainerHelpers() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static boolean m5326a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int m5325a(int[] iArr, int i, int i2) {
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
