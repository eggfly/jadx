package com.miui.support.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    static Object[] f3616a;
    static int f3617b;
    static Object[] f3618c;
    static int f3619d;
    int[] f3620e;
    Object[] f3621f;
    int f3622g;
    MapCollections<E, E> f3623h;

    /* renamed from: com.miui.support.util.ArraySet.1 */
    class C04251 extends MapCollections<E, E> {
        final /* synthetic */ ArraySet f3615a;

        C04251(ArraySet arraySet) {
            this.f3615a = arraySet;
        }

        protected int m5297a() {
            return this.f3615a.f3622g;
        }

        protected Object m5299a(int i, int i2) {
            return this.f3615a.f3621f[i];
        }

        protected int m5298a(Object obj) {
            return obj == null ? this.f3615a.m5306a() : this.f3615a.m5309a(obj, obj.hashCode());
        }

        protected int m5303b(Object obj) {
            return obj == null ? this.f3615a.m5306a() : this.f3615a.m5309a(obj, obj.hashCode());
        }

        protected Map<E, E> m5304b() {
            throw new UnsupportedOperationException("not a map");
        }

        protected void m5302a(E e, E e2) {
            this.f3615a.add(e);
        }

        protected E m5300a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        protected void m5301a(int i) {
            this.f3615a.m5315c(i);
        }

        protected void m5305c() {
            this.f3615a.clear();
        }
    }

    private int m5309a(Object obj, int i) {
        int i2 = this.f3622g;
        if (i2 == 0) {
            return -1;
        }
        int a = ContainerHelpers.m5325a(this.f3620e, i2, i);
        if (a < 0 || obj.equals(this.f3621f[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f3620e[i3] == i) {
            if (obj.equals(this.f3621f[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f3620e[a] == i) {
            if (obj.equals(this.f3621f[a])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int m5306a() {
        int i = this.f3622g;
        if (i == 0) {
            return -1;
        }
        int a = ContainerHelpers.m5325a(this.f3620e, i, 0);
        if (a < 0 || this.f3621f[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f3620e[i2] == 0) {
            if (this.f3621f[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f3620e[a] == 0) {
            if (this.f3621f[a] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m5312d(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (ArraySet.class) {
                if (f3618c != null) {
                    objArr = f3618c;
                    this.f3621f = objArr;
                    f3618c = (Object[]) objArr[0];
                    this.f3620e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3619d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                if (f3616a != null) {
                    objArr = f3616a;
                    this.f3621f = objArr;
                    f3616a = (Object[]) objArr[0];
                    this.f3620e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3617b--;
                    return;
                }
            }
        }
        this.f3620e = new int[i];
        this.f3621f = new Object[i];
    }

    private static void m5310a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f3619d < 10) {
                    objArr[0] = f3618c;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f3618c = objArr;
                    f3619d++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f3617b < 10) {
                    objArr[0] = f3616a;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f3616a = objArr;
                    f3617b++;
                }
            }
        }
    }

    public ArraySet() {
        this.f3620e = ContainerHelpers.f3629a;
        this.f3621f = ContainerHelpers.f3631c;
        this.f3622g = 0;
    }

    public void clear() {
        if (this.f3622g != 0) {
            m5310a(this.f3620e, this.f3621f, this.f3622g);
            this.f3620e = ContainerHelpers.f3629a;
            this.f3621f = ContainerHelpers.f3631c;
            this.f3622g = 0;
        }
    }

    public void m5313a(int i) {
        if (this.f3620e.length < i) {
            int[] iArr = this.f3620e;
            Object[] objArr = this.f3621f;
            m5312d(i);
            if (this.f3622g > 0) {
                System.arraycopy(iArr, 0, this.f3620e, 0, this.f3622g);
                System.arraycopy(objArr, 0, this.f3621f, 0, this.f3622g);
            }
            m5310a(iArr, objArr, this.f3622g);
        }
    }

    public boolean contains(Object obj) {
        return obj == null ? m5306a() >= 0 : m5309a(obj, obj.hashCode()) >= 0;
    }

    public E m5314b(int i) {
        return this.f3621f[i];
    }

    public boolean isEmpty() {
        return this.f3622g <= 0;
    }

    public boolean add(E e) {
        int a;
        int i;
        int i2 = 8;
        if (e == null) {
            a = m5306a();
            i = 0;
        } else {
            i = e.hashCode();
            a = m5309a(e, i);
        }
        if (a >= 0) {
            return false;
        }
        a ^= -1;
        if (this.f3622g >= this.f3620e.length) {
            if (this.f3622g >= 8) {
                i2 = this.f3622g + (this.f3622g >> 1);
            } else if (this.f3622g < 4) {
                i2 = 4;
            }
            int[] iArr = this.f3620e;
            Object[] objArr = this.f3621f;
            m5312d(i2);
            if (this.f3620e.length > 0) {
                System.arraycopy(iArr, 0, this.f3620e, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f3621f, 0, objArr.length);
            }
            m5310a(iArr, objArr, this.f3622g);
        }
        if (a < this.f3622g) {
            System.arraycopy(this.f3620e, a, this.f3620e, a + 1, this.f3622g - a);
            System.arraycopy(this.f3621f, a, this.f3621f, a + 1, this.f3622g - a);
        }
        this.f3620e[a] = i;
        this.f3621f[a] = e;
        this.f3622g++;
        return true;
    }

    public boolean remove(Object obj) {
        int a = obj == null ? m5306a() : m5309a(obj, obj.hashCode());
        if (a < 0) {
            return false;
        }
        m5315c(a);
        return true;
    }

    public E m5315c(int i) {
        int i2 = 8;
        E e = this.f3621f[i];
        if (this.f3622g <= 1) {
            m5310a(this.f3620e, this.f3621f, this.f3622g);
            this.f3620e = ContainerHelpers.f3629a;
            this.f3621f = ContainerHelpers.f3631c;
            this.f3622g = 0;
        } else if (this.f3620e.length <= 8 || this.f3622g >= this.f3620e.length / 3) {
            this.f3622g--;
            if (i < this.f3622g) {
                System.arraycopy(this.f3620e, i + 1, this.f3620e, i, this.f3622g - i);
                System.arraycopy(this.f3621f, i + 1, this.f3621f, i, this.f3622g - i);
            }
            this.f3621f[this.f3622g] = null;
        } else {
            if (this.f3622g > 8) {
                i2 = this.f3622g + (this.f3622g >> 1);
            }
            Object obj = this.f3620e;
            Object obj2 = this.f3621f;
            m5312d(i2);
            this.f3622g--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f3620e, 0, i);
                System.arraycopy(obj2, 0, this.f3621f, 0, i);
            }
            if (i < this.f3622g) {
                System.arraycopy(obj, i + 1, this.f3620e, i, this.f3622g - i);
                System.arraycopy(obj2, i + 1, this.f3621f, i, this.f3622g - i);
            }
        }
        return e;
    }

    public int size() {
        return this.f3622g;
    }

    public Object[] toArray() {
        Object obj = new Object[this.f3622g];
        System.arraycopy(this.f3621f, 0, obj, 0, this.f3622g);
        return obj;
    }

    public <T> T[] toArray(T[] tArr) {
        Object obj;
        if (tArr.length < this.f3622g) {
            obj = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f3622g);
        } else {
            obj = tArr;
        }
        System.arraycopy(this.f3621f, 0, obj, 0, this.f3622g);
        if (obj.length > this.f3622g) {
            obj[this.f3622g] = null;
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f3622g) {
            try {
                if (!set.contains(m5314b(i))) {
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
        int i = 0;
        int[] iArr = this.f3620e;
        int i2 = 0;
        while (i < this.f3622g) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f3622g * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.f3622g; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            ArraySet b = m5314b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private MapCollections<E, E> m5311b() {
        if (this.f3623h == null) {
            this.f3623h = new C04251(this);
        }
        return this.f3623h;
    }

    public Iterator<E> iterator() {
        return m5311b().m5275e().iterator();
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        m5313a(this.f3622g + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f3622g - 1; i >= 0; i--) {
            if (!collection.contains(this.f3621f[i])) {
                m5315c(i);
                z = true;
            }
        }
        return z;
    }
}
