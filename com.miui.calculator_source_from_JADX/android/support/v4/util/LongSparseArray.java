package android.support.v4.util;

public class LongSparseArray<E> implements Cloneable {
    private static final Object f721a;
    private boolean f722b;
    private long[] f723c;
    private Object[] f724d;
    private int f725e;

    public /* synthetic */ Object clone() {
        return m1100a();
    }

    static {
        f721a = new Object();
    }

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.f722b = false;
        if (i == 0) {
            this.f723c = ContainerHelpers.f717b;
            this.f724d = ContainerHelpers.f718c;
        } else {
            int b = ContainerHelpers.m1094b(i);
            this.f723c = new long[b];
            this.f724d = new Object[b];
        }
        this.f725e = 0;
    }

    public LongSparseArray<E> m1100a() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.f723c = (long[]) this.f723c.clone();
                longSparseArray.f724d = (Object[]) this.f724d.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    private void m1098c() {
        int i = this.f725e;
        long[] jArr = this.f723c;
        Object[] objArr = this.f724d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f721a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f722b = false;
        this.f725e = i2;
    }

    public int m1101b() {
        if (this.f722b) {
            m1098c();
        }
        return this.f725e;
    }

    public long m1099a(int i) {
        if (this.f722b) {
            m1098c();
        }
        return this.f723c[i];
    }

    public E m1102b(int i) {
        if (this.f722b) {
            m1098c();
        }
        return this.f724d[i];
    }

    public String toString() {
        if (m1101b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f725e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f725e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1099a(i));
            stringBuilder.append('=');
            LongSparseArray b = m1102b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
