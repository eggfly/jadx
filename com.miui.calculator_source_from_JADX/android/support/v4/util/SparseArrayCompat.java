package android.support.v4.util;

public class SparseArrayCompat<E> implements Cloneable {
    private static final Object f743a;
    private boolean f744b;
    private int[] f745c;
    private Object[] f746d;
    private int f747e;

    public /* synthetic */ Object clone() {
        return m1107a();
    }

    static {
        f743a = new Object();
    }

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.f744b = false;
        if (i == 0) {
            this.f745c = ContainerHelpers.f716a;
            this.f746d = ContainerHelpers.f718c;
        } else {
            int a = ContainerHelpers.m1091a(i);
            this.f745c = new int[a];
            this.f746d = new Object[a];
        }
        this.f747e = 0;
    }

    public SparseArrayCompat<E> m1107a() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            try {
                sparseArrayCompat.f745c = (int[]) this.f745c.clone();
                sparseArrayCompat.f746d = (Object[]) this.f746d.clone();
                return sparseArrayCompat;
            } catch (CloneNotSupportedException e) {
                return sparseArrayCompat;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1108a(int i) {
        return m1109a(i, null);
    }

    public E m1109a(int i, E e) {
        int a = ContainerHelpers.m1092a(this.f745c, this.f747e, i);
        return (a < 0 || this.f746d[a] == f743a) ? e : this.f746d[a];
    }

    public void m1111b(int i) {
        int a = ContainerHelpers.m1092a(this.f745c, this.f747e, i);
        if (a >= 0 && this.f746d[a] != f743a) {
            this.f746d[a] = f743a;
            this.f744b = true;
        }
    }

    public void m1114c(int i) {
        m1111b(i);
    }

    private void m1106d() {
        int i = this.f747e;
        int[] iArr = this.f745c;
        Object[] objArr = this.f746d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f743a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f744b = false;
        this.f747e = i2;
    }

    public void m1112b(int i, E e) {
        int a = ContainerHelpers.m1092a(this.f745c, this.f747e, i);
        if (a >= 0) {
            this.f746d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f747e || this.f746d[a] != f743a) {
            if (this.f744b && this.f747e >= this.f745c.length) {
                m1106d();
                a = ContainerHelpers.m1092a(this.f745c, this.f747e, i) ^ -1;
            }
            if (this.f747e >= this.f745c.length) {
                int a2 = ContainerHelpers.m1091a(this.f747e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f745c, 0, obj, 0, this.f745c.length);
                System.arraycopy(this.f746d, 0, obj2, 0, this.f746d.length);
                this.f745c = obj;
                this.f746d = obj2;
            }
            if (this.f747e - a != 0) {
                System.arraycopy(this.f745c, a, this.f745c, a + 1, this.f747e - a);
                System.arraycopy(this.f746d, a, this.f746d, a + 1, this.f747e - a);
            }
            this.f745c[a] = i;
            this.f746d[a] = e;
            this.f747e++;
            return;
        }
        this.f745c[a] = i;
        this.f746d[a] = e;
    }

    public int m1110b() {
        if (this.f744b) {
            m1106d();
        }
        return this.f747e;
    }

    public int m1115d(int i) {
        if (this.f744b) {
            m1106d();
        }
        return this.f745c[i];
    }

    public E m1116e(int i) {
        if (this.f744b) {
            m1106d();
        }
        return this.f746d[i];
    }

    public void m1113c() {
        int i = this.f747e;
        Object[] objArr = this.f746d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f747e = 0;
        this.f744b = false;
    }

    public String toString() {
        if (m1110b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f747e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f747e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1115d(i));
            stringBuilder.append('=');
            SparseArrayCompat e = m1116e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
