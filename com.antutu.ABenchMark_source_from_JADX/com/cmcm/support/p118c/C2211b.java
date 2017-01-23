package com.cmcm.support.p118c;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.cmcm.support.c.b */
public final class C2211b<K, V> implements Map<K, V> {
    public static final C2211b f7609a;
    static Object[] f7610b;
    static int f7611c;
    static Object[] f7612d;
    static int f7613e;
    static final int[] f7614f;
    int[] f7615g;
    Object[] f7616h;
    int f7617i;
    C2209e<K, V> f7618j;

    /* renamed from: com.cmcm.support.c.b.1 */
    class C22101 extends C2209e<K, V> {
        final /* synthetic */ C2211b f7608a;

        C22101(C2211b c2211b) {
            this.f7608a = c2211b;
        }

        protected int m8303a() {
            return this.f7608a.f7617i;
        }

        protected int m8304a(Object obj) {
            return obj == null ? this.f7608a.m8315a() : this.f7608a.m8317a(obj, obj.hashCode());
        }

        protected Object m8305a(int i, int i2) {
            return this.f7608a.f7616h[(i << 1) + i2];
        }

        protected V m8306a(int i, V v) {
            return this.f7608a.m8318a(i, (Object) v);
        }

        protected void m8307a(int i) {
            this.f7608a.m8322d(i);
        }

        protected void m8308a(K k, V v) {
            this.f7608a.put(k, v);
        }

        protected int m8309b(Object obj) {
            return this.f7608a.m8316a(obj);
        }

        protected Map<K, V> m8310b() {
            return this.f7608a;
        }

        protected void m8311c() {
            this.f7608a.clear();
        }
    }

    static {
        f7609a = new C2211b(true);
        f7614f = new int[0];
    }

    public C2211b() {
        this.f7615g = C2212c.f7620b;
        this.f7616h = C2212c.f7622d;
        this.f7617i = 0;
    }

    private C2211b(boolean z) {
        this.f7615g = f7614f;
        this.f7616h = C2212c.f7622d;
        this.f7617i = 0;
    }

    private static void m8312a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C2211b.class) {
                if (f7613e < 10) {
                    objArr[0] = f7612d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f7612d = objArr;
                    f7613e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C2211b.class) {
                if (f7611c < 10) {
                    objArr[0] = f7610b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f7610b = objArr;
                    f7611c++;
                }
            }
        }
    }

    private C2209e<K, V> m8313b() {
        if (this.f7618j == null) {
            this.f7618j = new C22101(this);
        }
        return this.f7618j;
    }

    private void m8314e(int i) {
        if (this.f7615g == f7614f) {
            throw new UnsupportedOperationException("ArrayMap is immutable");
        }
        Object[] objArr;
        if (i == 8) {
            synchronized (C2211b.class) {
                if (f7612d != null) {
                    objArr = f7612d;
                    this.f7616h = objArr;
                    f7612d = (Object[]) objArr[0];
                    this.f7615g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f7613e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C2211b.class) {
                if (f7610b != null) {
                    objArr = f7610b;
                    this.f7616h = objArr;
                    f7610b = (Object[]) objArr[0];
                    this.f7615g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f7611c--;
                    return;
                }
            }
        }
        this.f7615g = new int[i];
        this.f7616h = new Object[(i << 1)];
    }

    int m8315a() {
        int i = this.f7617i;
        if (i == 0) {
            return -1;
        }
        int a = C2212c.m8323a(this.f7615g, i, 0);
        if (a < 0 || this.f7616h[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f7615g[i2] == 0) {
            if (this.f7616h[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f7615g[a] == 0) {
            if (this.f7616h[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    int m8316a(Object obj) {
        int i = 1;
        int i2 = this.f7617i * 2;
        Object[] objArr = this.f7616h;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    int m8317a(Object obj, int i) {
        int i2 = this.f7617i;
        if (i2 == 0) {
            return -1;
        }
        int a = C2212c.m8323a(this.f7615g, i2, i);
        if (a < 0 || obj.equals(this.f7616h[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f7615g[i3] == i) {
            if (obj.equals(this.f7616h[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f7615g[a] == i) {
            if (obj.equals(this.f7616h[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public V m8318a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f7616h[i2];
        this.f7616h[i2] = v;
        return v2;
    }

    public void m8319a(int i) {
        if (this.f7615g.length < i) {
            Object obj = this.f7615g;
            Object obj2 = this.f7616h;
            m8314e(i);
            if (this.f7617i > 0) {
                System.arraycopy(obj, 0, this.f7615g, 0, this.f7617i);
                System.arraycopy(obj2, 0, this.f7616h, 0, this.f7617i << 1);
            }
            C2211b.m8312a(obj, obj2, this.f7617i);
        }
    }

    public K m8320b(int i) {
        return this.f7616h[i << 1];
    }

    public V m8321c(int i) {
        return this.f7616h[(i << 1) + 1];
    }

    public void clear() {
        if (this.f7617i > 0) {
            C2211b.m8312a(this.f7615g, this.f7616h, this.f7617i);
            this.f7615g = C2212c.f7620b;
            this.f7616h = C2212c.f7622d;
            this.f7617i = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return obj == null ? m8315a() >= 0 : m8317a(obj, obj.hashCode()) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m8316a(obj) >= 0;
    }

    public V m8322d(int i) {
        int i2 = 8;
        V v = this.f7616h[(i << 1) + 1];
        if (this.f7617i <= 1) {
            C2211b.m8312a(this.f7615g, this.f7616h, this.f7617i);
            this.f7615g = C2212c.f7620b;
            this.f7616h = C2212c.f7622d;
            this.f7617i = 0;
        } else if (this.f7615g.length <= 8 || this.f7617i >= this.f7615g.length / 3) {
            this.f7617i--;
            if (i < this.f7617i) {
                System.arraycopy(this.f7615g, i + 1, this.f7615g, i, this.f7617i - i);
                System.arraycopy(this.f7616h, (i + 1) << 1, this.f7616h, i << 1, (this.f7617i - i) << 1);
            }
            this.f7616h[this.f7617i << 1] = null;
            this.f7616h[(this.f7617i << 1) + 1] = null;
        } else {
            if (this.f7617i > 8) {
                i2 = this.f7617i + (this.f7617i >> 1);
            }
            Object obj = this.f7615g;
            Object obj2 = this.f7616h;
            m8314e(i2);
            this.f7617i--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f7615g, 0, i);
                System.arraycopy(obj2, 0, this.f7616h, 0, i << 1);
            }
            if (i < this.f7617i) {
                System.arraycopy(obj, i + 1, this.f7615g, i, this.f7617i - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f7616h, i << 1, (this.f7617i - i) << 1);
            }
        }
        return v;
    }

    public Set<Entry<K, V>> entrySet() {
        return m8313b().m8300d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f7617i) {
            try {
                Object b = m8320b(i);
                Object c = m8321c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        int a = obj == null ? m8315a() : m8317a(obj, obj.hashCode());
        return a >= 0 ? this.f7616h[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f7615g;
        Object[] objArr = this.f7616h;
        int i = this.f7617i;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f7617i <= 0;
    }

    public Set<K> keySet() {
        return m8313b().m8301e();
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m8315a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m8317a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f7616h[i3];
            this.f7616h[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f7617i >= this.f7615g.length) {
            if (this.f7617i >= 8) {
                i2 = this.f7617i + (this.f7617i >> 1);
            } else if (this.f7617i < 4) {
                i2 = 4;
            }
            Object obj = this.f7615g;
            Object obj2 = this.f7616h;
            m8314e(i2);
            if (this.f7615g.length > 0) {
                System.arraycopy(obj, 0, this.f7615g, 0, obj.length);
                System.arraycopy(obj2, 0, this.f7616h, 0, obj2.length);
            }
            C2211b.m8312a(obj, obj2, this.f7617i);
        }
        if (a < this.f7617i) {
            System.arraycopy(this.f7615g, a, this.f7615g, a + 1, this.f7617i - a);
            System.arraycopy(this.f7616h, a << 1, this.f7616h, (a + 1) << 1, (this.f7617i - a) << 1);
        }
        this.f7615g[a] = i;
        this.f7616h[a << 1] = k;
        this.f7616h[(a << 1) + 1] = v;
        this.f7617i++;
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m8319a(this.f7617i + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        int a = obj == null ? m8315a() : m8317a(obj, obj.hashCode());
        return a >= 0 ? m8322d(a) : null;
    }

    public int size() {
        return this.f7617i;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f7617i * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f7617i; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C2211b b = m8320b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m8321c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Collection<V> values() {
        return m8313b().m8302f();
    }
}
