package com.miui.support.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ArrayMap<K, V> implements Map<K, V> {
    static Object[] f3607a;
    static int f3608b;
    static Object[] f3609c;
    static int f3610d;
    int[] f3611e;
    Object[] f3612f;
    int f3613g;
    MapCollections<K, V> f3614h;

    /* renamed from: com.miui.support.util.ArrayMap.1 */
    class C04241 extends MapCollections<K, V> {
        final /* synthetic */ ArrayMap f3606a;

        C04241(ArrayMap arrayMap) {
            this.f3606a = arrayMap;
        }

        protected int m5277a() {
            return this.f3606a.f3613g;
        }

        protected Object m5279a(int i, int i2) {
            return this.f3606a.f3612f[(i << 1) + i2];
        }

        protected int m5278a(Object obj) {
            return obj == null ? this.f3606a.m5289a() : this.f3606a.m5291a(obj, obj.hashCode());
        }

        protected int m5283b(Object obj) {
            return this.f3606a.m5290a(obj);
        }

        protected Map<K, V> m5284b() {
            return this.f3606a;
        }

        protected void m5282a(K k, V v) {
            this.f3606a.put(k, v);
        }

        protected V m5280a(int i, V v) {
            return this.f3606a.m5292a(i, (Object) v);
        }

        protected void m5281a(int i) {
            this.f3606a.m5296d(i);
        }

        protected void m5285c() {
            this.f3606a.clear();
        }
    }

    int m5291a(Object obj, int i) {
        int i2 = this.f3613g;
        if (i2 == 0) {
            return -1;
        }
        int a = ContainerHelpers.m5325a(this.f3611e, i2, i);
        if (a < 0 || obj.equals(this.f3612f[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f3611e[i3] == i) {
            if (obj.equals(this.f3612f[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f3611e[a] == i) {
            if (obj.equals(this.f3612f[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m5289a() {
        int i = this.f3613g;
        if (i == 0) {
            return -1;
        }
        int a = ContainerHelpers.m5325a(this.f3611e, i, 0);
        if (a < 0 || this.f3612f[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f3611e[i2] == 0) {
            if (this.f3612f[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f3611e[a] == 0) {
            if (this.f3612f[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m5288e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f3609c != null) {
                    objArr = f3609c;
                    this.f3612f = objArr;
                    f3609c = (Object[]) objArr[0];
                    this.f3611e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3610d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f3607a != null) {
                    objArr = f3607a;
                    this.f3612f = objArr;
                    f3607a = (Object[]) objArr[0];
                    this.f3611e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3608b--;
                    return;
                }
            }
        }
        this.f3611e = new int[i];
        this.f3612f = new Object[(i << 1)];
    }

    private static void m5286a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f3610d < 10) {
                    objArr[0] = f3609c;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f3609c = objArr;
                    f3610d++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f3608b < 10) {
                    objArr[0] = f3607a;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f3607a = objArr;
                    f3608b++;
                }
            }
        }
    }

    public ArrayMap() {
        this.f3611e = ContainerHelpers.f3629a;
        this.f3612f = ContainerHelpers.f3631c;
        this.f3613g = 0;
    }

    public void clear() {
        if (this.f3613g > 0) {
            m5286a(this.f3611e, this.f3612f, this.f3613g);
            this.f3611e = ContainerHelpers.f3629a;
            this.f3612f = ContainerHelpers.f3631c;
            this.f3613g = 0;
        }
    }

    public void m5293a(int i) {
        if (this.f3611e.length < i) {
            Object obj = this.f3611e;
            Object obj2 = this.f3612f;
            m5288e(i);
            if (this.f3613g > 0) {
                System.arraycopy(obj, 0, this.f3611e, 0, this.f3613g);
                System.arraycopy(obj2, 0, this.f3612f, 0, this.f3613g << 1);
            }
            m5286a(obj, obj2, this.f3613g);
        }
    }

    public boolean containsKey(Object obj) {
        return obj == null ? m5289a() >= 0 : m5291a(obj, obj.hashCode()) >= 0;
    }

    int m5290a(Object obj) {
        int i = 1;
        int i2 = this.f3613g * 2;
        Object[] objArr = this.f3612f;
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

    public boolean containsValue(Object obj) {
        return m5290a(obj) >= 0;
    }

    public V get(Object obj) {
        int a = obj == null ? m5289a() : m5291a(obj, obj.hashCode());
        return a >= 0 ? this.f3612f[(a << 1) + 1] : null;
    }

    public K m5294b(int i) {
        return this.f3612f[i << 1];
    }

    public V m5295c(int i) {
        return this.f3612f[(i << 1) + 1];
    }

    public V m5292a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f3612f[i2];
        this.f3612f[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f3613g <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m5289a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m5291a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f3612f[i3];
            this.f3612f[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f3613g >= this.f3611e.length) {
            if (this.f3613g >= 8) {
                i2 = this.f3613g + (this.f3613g >> 1);
            } else if (this.f3613g < 4) {
                i2 = 4;
            }
            Object obj = this.f3611e;
            Object obj2 = this.f3612f;
            m5288e(i2);
            if (this.f3611e.length > 0) {
                System.arraycopy(obj, 0, this.f3611e, 0, obj.length);
                System.arraycopy(obj2, 0, this.f3612f, 0, obj2.length);
            }
            m5286a(obj, obj2, this.f3613g);
        }
        if (a < this.f3613g) {
            System.arraycopy(this.f3611e, a, this.f3611e, a + 1, this.f3613g - a);
            System.arraycopy(this.f3612f, a << 1, this.f3612f, (a + 1) << 1, (this.f3613g - a) << 1);
        }
        this.f3611e[a] = i;
        this.f3612f[a << 1] = k;
        this.f3612f[(a << 1) + 1] = v;
        this.f3613g++;
        return null;
    }

    public V remove(Object obj) {
        int a = obj == null ? m5289a() : m5291a(obj, obj.hashCode());
        if (a >= 0) {
            return m5296d(a);
        }
        return null;
    }

    public V m5296d(int i) {
        int i2 = 8;
        V v = this.f3612f[(i << 1) + 1];
        if (this.f3613g <= 1) {
            m5286a(this.f3611e, this.f3612f, this.f3613g);
            this.f3611e = ContainerHelpers.f3629a;
            this.f3612f = ContainerHelpers.f3631c;
            this.f3613g = 0;
        } else if (this.f3611e.length <= 8 || this.f3613g >= this.f3611e.length / 3) {
            this.f3613g--;
            if (i < this.f3613g) {
                System.arraycopy(this.f3611e, i + 1, this.f3611e, i, this.f3613g - i);
                System.arraycopy(this.f3612f, (i + 1) << 1, this.f3612f, i << 1, (this.f3613g - i) << 1);
            }
            this.f3612f[this.f3613g << 1] = null;
            this.f3612f[(this.f3613g << 1) + 1] = null;
        } else {
            if (this.f3613g > 8) {
                i2 = this.f3613g + (this.f3613g >> 1);
            }
            Object obj = this.f3611e;
            Object obj2 = this.f3612f;
            m5288e(i2);
            this.f3613g--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f3611e, 0, i);
                System.arraycopy(obj2, 0, this.f3612f, 0, i << 1);
            }
            if (i < this.f3613g) {
                System.arraycopy(obj, i + 1, this.f3611e, i, this.f3613g - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f3612f, i << 1, (this.f3613g - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f3613g;
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
        while (i < this.f3613g) {
            try {
                Object b = m5294b(i);
                Object c = m5295c(i);
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

    public int hashCode() {
        int[] iArr = this.f3611e;
        Object[] objArr = this.f3612f;
        int i = this.f3613g;
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

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f3613g * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f3613g; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            ArrayMap b = m5294b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m5295c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private MapCollections<K, V> m5287b() {
        if (this.f3614h == null) {
            this.f3614h = new C04241(this);
        }
        return this.f3614h;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m5293a(this.f3613g + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        return m5287b().m5274d();
    }

    public Set<K> keySet() {
        return m5287b().m5275e();
    }

    public Collection<V> values() {
        return m5287b().m5276f();
    }
}
