package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap<K, V> {
    static Object[] f704b;
    static int f705c;
    static Object[] f706d;
    static int f707e;
    int[] f708f;
    Object[] f709g;
    int f710h;

    int m1082a(Object obj, int i) {
        int i2 = this.f710h;
        if (i2 == 0) {
            return -1;
        }
        int a = ContainerHelpers.m1092a(this.f708f, i2, i);
        if (a < 0 || obj.equals(this.f709g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f708f[i3] == i) {
            if (obj.equals(this.f709g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f708f[a] == i) {
            if (obj.equals(this.f709g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m1080a() {
        int i = this.f710h;
        if (i == 0) {
            return -1;
        }
        int a = ContainerHelpers.m1092a(this.f708f, i, 0);
        if (a < 0 || this.f709g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f708f[i2] == 0) {
            if (this.f709g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f708f[a] == 0) {
            if (this.f709g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m1079e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f706d != null) {
                    objArr = f706d;
                    this.f709g = objArr;
                    f706d = (Object[]) objArr[0];
                    this.f708f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f707e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f704b != null) {
                    objArr = f704b;
                    this.f709g = objArr;
                    f704b = (Object[]) objArr[0];
                    this.f708f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f705c--;
                    return;
                }
            }
        }
        this.f708f = new int[i];
        this.f709g = new Object[(i << 1)];
    }

    private static void m1078a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f707e < 10) {
                    objArr[0] = f706d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f706d = objArr;
                    f707e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f705c < 10) {
                    objArr[0] = f704b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f704b = objArr;
                    f705c++;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.f708f = ContainerHelpers.f716a;
        this.f709g = ContainerHelpers.f718c;
        this.f710h = 0;
    }

    public void clear() {
        if (this.f710h != 0) {
            m1078a(this.f708f, this.f709g, this.f710h);
            this.f708f = ContainerHelpers.f716a;
            this.f709g = ContainerHelpers.f718c;
            this.f710h = 0;
        }
    }

    public void m1084a(int i) {
        if (this.f708f.length < i) {
            Object obj = this.f708f;
            Object obj2 = this.f709g;
            m1079e(i);
            if (this.f710h > 0) {
                System.arraycopy(obj, 0, this.f708f, 0, this.f710h);
                System.arraycopy(obj2, 0, this.f709g, 0, this.f710h << 1);
            }
            m1078a(obj, obj2, this.f710h);
        }
    }

    public boolean containsKey(Object obj) {
        return m1081a(obj) >= 0;
    }

    public int m1081a(Object obj) {
        return obj == null ? m1080a() : m1082a(obj, obj.hashCode());
    }

    int m1085b(Object obj) {
        int i = 1;
        int i2 = this.f710h * 2;
        Object[] objArr = this.f709g;
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
        return m1085b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = m1081a(obj);
        return a >= 0 ? this.f709g[(a << 1) + 1] : null;
    }

    public K m1086b(int i) {
        return this.f709g[i << 1];
    }

    public V m1087c(int i) {
        return this.f709g[(i << 1) + 1];
    }

    public V m1083a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f709g[i2];
        this.f709g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f710h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m1080a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m1082a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f709g[i3];
            this.f709g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f710h >= this.f708f.length) {
            if (this.f710h >= 8) {
                i2 = this.f710h + (this.f710h >> 1);
            } else if (this.f710h < 4) {
                i2 = 4;
            }
            Object obj = this.f708f;
            Object obj2 = this.f709g;
            m1079e(i2);
            if (this.f708f.length > 0) {
                System.arraycopy(obj, 0, this.f708f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f709g, 0, obj2.length);
            }
            m1078a(obj, obj2, this.f710h);
        }
        if (a < this.f710h) {
            System.arraycopy(this.f708f, a, this.f708f, a + 1, this.f710h - a);
            System.arraycopy(this.f709g, a << 1, this.f709g, (a + 1) << 1, (this.f710h - a) << 1);
        }
        this.f708f[a] = i;
        this.f709g[a << 1] = k;
        this.f709g[(a << 1) + 1] = v;
        this.f710h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m1081a(obj);
        if (a >= 0) {
            return m1088d(a);
        }
        return null;
    }

    public V m1088d(int i) {
        int i2 = 8;
        V v = this.f709g[(i << 1) + 1];
        if (this.f710h <= 1) {
            m1078a(this.f708f, this.f709g, this.f710h);
            this.f708f = ContainerHelpers.f716a;
            this.f709g = ContainerHelpers.f718c;
            this.f710h = 0;
        } else if (this.f708f.length <= 8 || this.f710h >= this.f708f.length / 3) {
            this.f710h--;
            if (i < this.f710h) {
                System.arraycopy(this.f708f, i + 1, this.f708f, i, this.f710h - i);
                System.arraycopy(this.f709g, (i + 1) << 1, this.f709g, i << 1, (this.f710h - i) << 1);
            }
            this.f709g[this.f710h << 1] = null;
            this.f709g[(this.f710h << 1) + 1] = null;
        } else {
            if (this.f710h > 8) {
                i2 = this.f710h + (this.f710h >> 1);
            }
            Object obj = this.f708f;
            Object obj2 = this.f709g;
            m1079e(i2);
            this.f710h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f708f, 0, i);
                System.arraycopy(obj2, 0, this.f709g, 0, i << 1);
            }
            if (i < this.f710h) {
                System.arraycopy(obj, i + 1, this.f708f, i, this.f710h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f709g, i << 1, (this.f710h - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f710h;
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
        while (i < this.f710h) {
            try {
                Object b = m1086b(i);
                Object c = m1087c(i);
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
        int[] iArr = this.f708f;
        Object[] objArr = this.f709g;
        int i = this.f710h;
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
        StringBuilder stringBuilder = new StringBuilder(this.f710h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f710h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            SimpleArrayMap b = m1086b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1087c(i);
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
