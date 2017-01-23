package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class MapCollections<K, V> {
    EntrySet f700b;
    KeySet f701c;
    ValuesCollection f702d;

    final class ArrayIterator<T> implements Iterator<T> {
        final int f729a;
        int f730b;
        int f731c;
        boolean f732d;
        final /* synthetic */ MapCollections f733e;

        ArrayIterator(MapCollections mapCollections, int i) {
            this.f733e = mapCollections;
            this.f732d = false;
            this.f729a = i;
            this.f730b = mapCollections.m1055a();
        }

        public boolean hasNext() {
            return this.f731c < this.f730b;
        }

        public T next() {
            T a = this.f733e.m1057a(this.f731c, this.f729a);
            this.f731c++;
            this.f732d = true;
            return a;
        }

        public void remove() {
            if (this.f732d) {
                this.f731c--;
                this.f730b--;
                this.f732d = false;
                this.f733e.m1059a(this.f731c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class EntrySet implements Set<Entry<K, V>> {
        final /* synthetic */ MapCollections f734a;

        EntrySet(MapCollections mapCollections) {
            this.f734a = mapCollections;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m1103a((Entry) obj);
        }

        public boolean m1103a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f734a.m1055a();
            for (Entry entry : collection) {
                this.f734a.m1060a(entry.getKey(), entry.getValue());
            }
            return a != this.f734a.m1055a();
        }

        public void clear() {
            this.f734a.m1065c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f734a.m1056a(entry.getKey());
            if (a >= 0) {
                return ContainerHelpers.m1093a(this.f734a.m1057a(a, 1), entry.getValue());
            }
            return false;
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
            return this.f734a.m1055a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new MapIterator(this.f734a);
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
            return this.f734a.m1055a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return MapCollections.m1052a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f734a.m1055a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f734a.m1057a(a, 0);
                Object a3 = this.f734a.m1057a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }
    }

    final class KeySet implements Set<K> {
        final /* synthetic */ MapCollections f735a;

        KeySet(MapCollections mapCollections) {
            this.f735a = mapCollections;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f735a.m1065c();
        }

        public boolean contains(Object obj) {
            return this.f735a.m1056a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return MapCollections.m1051a(this.f735a.m1063b(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.f735a.m1055a() == 0;
        }

        public Iterator<K> iterator() {
            return new ArrayIterator(this.f735a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f735a.m1056a(obj);
            if (a < 0) {
                return false;
            }
            this.f735a.m1059a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return MapCollections.m1053b(this.f735a.m1063b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return MapCollections.m1054c(this.f735a.m1063b(), collection);
        }

        public int size() {
            return this.f735a.m1055a();
        }

        public Object[] toArray() {
            return this.f735a.m1064b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f735a.m1061a((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return MapCollections.m1052a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f735a.m1055a() - 1; a >= 0; a--) {
                Object a2 = this.f735a.m1057a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    final class MapIterator implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f736a;
        int f737b;
        boolean f738c;
        final /* synthetic */ MapCollections f739d;

        public /* synthetic */ Object next() {
            return m1104a();
        }

        MapIterator(MapCollections mapCollections) {
            this.f739d = mapCollections;
            this.f738c = false;
            this.f736a = mapCollections.m1055a() - 1;
            this.f737b = -1;
        }

        public boolean hasNext() {
            return this.f737b < this.f736a;
        }

        public Entry<K, V> m1104a() {
            this.f737b++;
            this.f738c = true;
            return this;
        }

        public void remove() {
            if (this.f738c) {
                this.f739d.m1059a(this.f737b);
                this.f737b--;
                this.f736a--;
                this.f738c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f738c) {
                return this.f739d.m1057a(this.f737b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f738c) {
                return this.f739d.m1057a(this.f737b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f738c) {
                return this.f739d.m1058a(this.f737b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f738c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(ContainerHelpers.m1093a(entry.getKey(), this.f739d.m1057a(this.f737b, 0)) && ContainerHelpers.m1093a(entry.getValue(), this.f739d.m1057a(this.f737b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f738c) {
                Object a = this.f739d.m1057a(this.f737b, 0);
                Object a2 = this.f739d.m1057a(this.f737b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class ValuesCollection implements Collection<V> {
        final /* synthetic */ MapCollections f740a;

        ValuesCollection(MapCollections mapCollections) {
            this.f740a = mapCollections;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f740a.m1065c();
        }

        public boolean contains(Object obj) {
            return this.f740a.m1062b(obj) >= 0;
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
            return this.f740a.m1055a() == 0;
        }

        public Iterator<V> iterator() {
            return new ArrayIterator(this.f740a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f740a.m1062b(obj);
            if (b < 0) {
                return false;
            }
            this.f740a.m1059a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f740a.m1055a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f740a.m1057a(i, 1))) {
                    this.f740a.m1059a(i);
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
            int a = this.f740a.m1055a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f740a.m1057a(i, 1))) {
                    this.f740a.m1059a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f740a.m1055a();
        }

        public Object[] toArray() {
            return this.f740a.m1064b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f740a.m1061a((Object[]) tArr, 1);
        }
    }

    protected abstract int m1055a();

    protected abstract int m1056a(Object obj);

    protected abstract Object m1057a(int i, int i2);

    protected abstract V m1058a(int i, V v);

    protected abstract void m1059a(int i);

    protected abstract void m1060a(K k, V v);

    protected abstract int m1062b(Object obj);

    protected abstract Map<K, V> m1063b();

    protected abstract void m1065c();

    MapCollections() {
    }

    public static <K, V> boolean m1051a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m1053b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m1054c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] m1064b(int i) {
        int a = m1055a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m1057a(i2, i);
        }
        return objArr;
    }

    public <T> T[] m1061a(T[] tArr, int i) {
        T[] tArr2;
        int a = m1055a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = m1057a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m1052a(Set<T> set, Object obj) {
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

    public Set<Entry<K, V>> m1066d() {
        if (this.f700b == null) {
            this.f700b = new EntrySet(this);
        }
        return this.f700b;
    }

    public Set<K> m1067e() {
        if (this.f701c == null) {
            this.f701c = new KeySet(this);
        }
        return this.f701c;
    }

    public Collection<V> m1068f() {
        if (this.f702d == null) {
            this.f702d = new ValuesCollection(this);
        }
        return this.f702d;
    }
}
