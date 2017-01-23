package android.support.v4.util;

class ContainerHelpers {
    static final int[] f716a;
    static final long[] f717b;
    static final Object[] f718c;

    ContainerHelpers() {
    }

    static {
        f716a = new int[0];
        f717b = new long[0];
        f718c = new Object[0];
    }

    public static int m1091a(int i) {
        return m1095c(i * 4) / 4;
    }

    public static int m1094b(int i) {
        return m1095c(i * 8) / 8;
    }

    public static int m1095c(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    public static boolean m1093a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int m1092a(int[] iArr, int i, int i2) {
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
