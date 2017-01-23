package com.cmcm.support.p118c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.cmcm.support.c.e */
abstract class C2209e<K, V> {
    C2216b f7605b;
    C2217c f7606c;
    C2219e f7607d;

    /* renamed from: com.cmcm.support.c.e.a */
    final class C2215a<T> implements Iterator<T> {
        final int f7630a;
        int f7631b;
        int f7632c;
        boolean f7633d;
        final /* synthetic */ C2209e f7634e;

        C2215a(C2209e c2209e, int i) {
            this.f7634e = c2209e;
            this.f7633d = false;
            this.f7630a = i;
            this.f7631b = c2209e.m8289a();
        }

        public boolean hasNext() {
            return this.f7632c < this.f7631b;
        }

        public T next() {
            T a = this.f7634e.m8291a(this.f7632c, this.f7630a);
            this.f7632c++;
            this.f7633d = true;
            return a;
        }

        public void remove() {
            if (this.f7633d) {
                this.f7632c--;
                this.f7631b--;
                this.f7633d = false;
                this.f7634e.m8293a(this.f7632c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.cmcm.support.c.e.b */
    final class C2216b implements Set<Entry<K, V>> {
        final /* synthetic */ C2209e f7635a;

        C2216b(C2209e c2209e) {
            this.f7635a = c2209e;
        }

        public boolean m8329a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ boolean add(Object obj) {
            return m8329a((Entry) obj);
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f7635a.m8289a();
            for (Entry entry : collection) {
                this.f7635a.m8294a(entry.getKey(), entry.getValue());
            }
            return a != this.f7635a.m8289a();
        }

        public void clear() {
            this.f7635a.m8299c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f7635a.m8290a(entry.getKey());
            return a >= 0 ? C2220f.m8331a(this.f7635a.m8291a(a, 1), entry.getValue()) : false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return C2209e.m8286a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f7635a.m8289a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f7635a.m8291a(a, 0);
                Object a3 = this.f7635a.m8291a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f7635a.m8289a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C2218d(this.f7635a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f7635a.m8289a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.cmcm.support.c.e.c */
    final class C2217c implements Set<K> {
        final /* synthetic */ C2209e f7636a;

        C2217c(C2209e c2209e) {
            this.f7636a = c2209e;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f7636a.m8299c();
        }

        public boolean contains(Object obj) {
            return this.f7636a.m8290a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C2209e.m8285a(this.f7636a.m8297b(), (Collection) collection);
        }

        public boolean equals(Object obj) {
            return C2209e.m8286a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f7636a.m8289a() - 1; a >= 0; a--) {
                Object a2 = this.f7636a.m8291a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f7636a.m8289a() == 0;
        }

        public Iterator<K> iterator() {
            return new C2215a(this.f7636a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f7636a.m8290a(obj);
            if (a < 0) {
                return false;
            }
            this.f7636a.m8293a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C2209e.m8287b(this.f7636a.m8297b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C2209e.m8288c(this.f7636a.m8297b(), collection);
        }

        public int size() {
            return this.f7636a.m8289a();
        }

        public Object[] toArray() {
            return this.f7636a.m8298b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f7636a.m8295a((Object[]) tArr, 0);
        }
    }

    /* renamed from: com.cmcm.support.c.e.d */
    final class C2218d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f7637a;
        int f7638b;
        boolean f7639c;
        final /* synthetic */ C2209e f7640d;

        C2218d(C2209e c2209e) {
            this.f7640d = c2209e;
            this.f7639c = false;
            this.f7637a = c2209e.m8289a() - 1;
            this.f7638b = -1;
        }

        public Entry<K, V> m8330a() {
            this.f7638b++;
            this.f7639c = true;
            return this;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f7639c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C2220f.m8331a(entry.getKey(), this.f7640d.m8291a(this.f7638b, 0)) && C2220f.m8331a(entry.getValue(), this.f7640d.m8291a(this.f7638b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            if (this.f7639c) {
                return this.f7640d.m8291a(this.f7638b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f7639c) {
                return this.f7640d.m8291a(this.f7638b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f7638b < this.f7637a;
        }

        public final int hashCode() {
            int i = 0;
            if (this.f7639c) {
                Object a = this.f7640d.m8291a(this.f7638b, 0);
                Object a2 = this.f7640d.m8291a(this.f7638b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public /* synthetic */ Object next() {
            return m8330a();
        }

        public void remove() {
            if (this.f7639c) {
                this.f7638b--;
                this.f7637a--;
                this.f7639c = false;
                this.f7640d.m8293a(this.f7638b);
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f7639c) {
                return this.f7640d.m8292a(this.f7638b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: com.cmcm.support.c.e.e */
    final class C2219e implements Collection<V> {
        final /* synthetic */ C2209e f7641a;

        C2219e(C2209e c2209e) {
            this.f7641a = c2209e;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f7641a.m8299c();
        }

        public boolean contains(Object obj) {
            return this.f7641a.m8296b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f7641a.m8289a() == 0;
        }

        public Iterator<V> iterator() {
            return new C2215a(this.f7641a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f7641a.m8296b(obj);
            if (b < 0) {
                return false;
            }
            this.f7641a.m8293a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f7641a.m8289a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f7641a.m8291a(i, 1))) {
                    this.f7641a.m8293a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f7641a.m8289a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f7641a.m8291a(i, 1))) {
                    this.f7641a.m8293a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f7641a.m8289a();
        }

        public Object[] toArray() {
            return this.f7641a.m8298b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f7641a.m8295a((Object[]) tArr, 1);
        }
    }

    C2209e() {
    }

    public static <K, V> boolean m8285a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean m8286a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <K, V> boolean m8287b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m8288c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int m8289a();

    protected abstract int m8290a(Object obj);

    protected abstract Object m8291a(int i, int i2);

    protected abstract V m8292a(int i, V v);

    protected abstract void m8293a(int i);

    protected abstract void m8294a(K k, V v);

    public <T> T[] m8295a(T[] tArr, int i) {
        int a = m8289a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = m8291a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    protected abstract int m8296b(Object obj);

    protected abstract Map<K, V> m8297b();

    public Object[] m8298b(int i) {
        int a = m8289a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m8291a(i2, i);
        }
        return objArr;
    }

    protected abstract void m8299c();

    public Set<Entry<K, V>> m8300d() {
        if (this.f7605b == null) {
            this.f7605b = new C2216b(this);
        }
        return this.f7605b;
    }

    public Set<K> m8301e() {
        if (this.f7606c == null) {
            this.f7606c = new C2217c(this);
        }
        return this.f7606c;
    }

    public Collection<V> m8302f() {
        if (this.f7607d == null) {
            this.f7607d = new C2219e(this);
        }
        return this.f7607d;
    }
}
