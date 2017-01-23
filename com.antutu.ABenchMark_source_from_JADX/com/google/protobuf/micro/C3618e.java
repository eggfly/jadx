package com.google.protobuf.micro;

/* renamed from: com.google.protobuf.micro.e */
public final class C3618e {
    static final int f12281a;
    static final int f12282b;
    static final int f12283c;
    static final int f12284d;

    static {
        f12281a = C3618e.m14882a(1, 3);
        f12282b = C3618e.m14882a(1, 4);
        f12283c = C3618e.m14882a(2, 0);
        f12284d = C3618e.m14882a(3, 2);
    }

    static int m14881a(int i) {
        return i & 7;
    }

    static int m14882a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static int m14883b(int i) {
        return i >>> 3;
    }
}
