package p023b.p024a;

/* renamed from: b.a.au */
public class au {
    public static final byte m3450a(byte b, int i, boolean z) {
        return (byte) au.m3451a((int) b, i, z);
    }

    public static final int m3451a(int i, int i2, boolean z) {
        return z ? (1 << i2) | i : au.m3454b(i, i2);
    }

    public static final boolean m3452a(byte b, int i) {
        return au.m3453a((int) b, i);
    }

    public static final boolean m3453a(int i, int i2) {
        return ((1 << i2) & i) != 0;
    }

    public static final int m3454b(int i, int i2) {
        return ((1 << i2) ^ -1) & i;
    }
}
