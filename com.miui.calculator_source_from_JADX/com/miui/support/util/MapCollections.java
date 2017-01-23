package com.miui.support.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class MapCollections<K, V> {
    EntrySet f3603b;
    KeySet f3604c;
    ValuesCollection f3605d;

    final class ArrayIterator<T> implements Iterator<T> {
        final int f3681a;
        int f3682b;
        int f3683c;
        boolean f3684d;
        final /* synthetic */ MapCollections f3685e;

        ArrayIterator(MapCollections mapCollections, int i) {
            this.f3685e = mapCollections;
            this.f3684d = false;
            this.f3681a = i;
            this.f3682b = mapCollections.m5263a();
        }

        public boolean hasNext() {
            return this.f3683c < this.f3682b;
        }

        public T next() {
            T a = this.f3685e.m5265a(this.f3683c, this.f3681a);
            this.f3683c++;
            this.f3684d = true;
            return a;
        }

        public void remove() {
            if (this.f3684d) {
                this.f3683c--;
                this.f3682b--;
                this.f3684d = false;
                this.f3685e.m5267a(this.f3683c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class EntrySet implements Set<Entry<K, V>> {
        final /* synthetic */ MapCollections f3686a;

        EntrySet(MapCollections mapCollections) {
            this.f3686a = mapCollections;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m5394a((Entry) obj);
        }

        public boolean m5394a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f3686a.m5263a();
            for (Entry entry : collection) {
                this.f3686a.m5268a(entry.getKey(), entry.getValue());
            }
            return a != this.f3686a.m5263a();
        }

        public void clear() {
            this.f3686a.m5273c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f3686a.m5264a(entry.getKey());
            if (a >= 0) {
                return ContainerHelpers.m5326a(this.f3686a.m5265a(a, 1), entry.getValue());
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
            return this.f3686a.m5263a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new MapIterator(this.f3686a);
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
            return this.f3686a.m5263a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return MapCollections.m5260a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f3686a.m5263a() - 1;
            int i = 0;
            while (a >= 0) {
                int i2;
                Object a2 = this.f3686a.m5265a(a, 0);
                Object a3 = this.f3686a.m5265a(a, 1);
                int hashCode = a2 == null ? 0 : a2.hashCode();
                if (a3 == null) {
                    i2 = 0;
                } else {
                    i2 = a3.hashCode();
                }
                a--;
                i += i2 ^ hashCode;
            }
            return i;
        }
    }

    final class KeySet implements Set<K> {
        final /* synthetic */ MapCollections f3687a;

        KeySet(MapCollections mapCollections) {
            this.f3687a = mapCollections;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f3687a.m5273c();
        }

        public boolean contains(Object obj) {
            return this.f3687a.m5264a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return MapCollections.m5259a(this.f3687a.m5271b(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.f3687a.m5263a() == 0;
        }

        public Iterator<K> iterator() {
            return new ArrayIterator(this.f3687a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f3687a.m5264a(obj);
            if (a < 0) {
                return false;
            }
            this.f3687a.m5267a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return MapCollections.m5261b(this.f3687a.m5271b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return MapCollections.m5262c(this.f3687a.m5271b(), collection);
        }

        public int size() {
            return this.f3687a.m5263a();
        }

        public Object[] toArray() {
            return this.f3687a.m5272b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f3687a.m5269a((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return MapCollections.m5260a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f3687a.m5263a() - 1; a >= 0; a--) {
                Object a2 = this.f3687a.m5265a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    final class MapIterator implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f3688a;
        int f3689b;
        boolean f3690c;
        final /* synthetic */ MapCollections f3691d;

        public /* synthetic */ Object next() {
            return m5395a();
        }

        MapIterator(MapCollections mapCollections) {
            this.f3691d = mapCollections;
            this.f3690c = false;
            this.f3688a = mapCollections.m5263a() - 1;
            this.f3689b = -1;
        }

        public boolean hasNext() {
            return this.f3689b < this.f3688a;
        }

        public Entry<K, V> m5395a() {
            this.f3689b++;
            this.f3690c = true;
            return this;
        }

        public void remove() {
            if (this.f3690c) {
                this.f3689b--;
                this.f3688a--;
                this.f3690c = false;
                this.f3691d.m5267a(this.f3689b);
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f3690c) {
                return this.f3691d.m5265a(this.f3689b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f3690c) {
                return this.f3691d.m5265a(this.f3689b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f3690c) {
                return this.f3691d.m5266a(this.f3689b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f3690c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(ContainerHelpers.m5326a(entry.getKey(), this.f3691d.m5265a(this.f3689b, 0)) && ContainerHelpers.m5326a(entry.getValue(), this.f3691d.m5265a(this.f3689b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f3690c) {
                Object a = this.f3691d.m5265a(this.f3689b, 0);
                Object a2 = this.f3691d.m5265a(this.f3689b, 1);
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
        final /* synthetic */ MapCollections f3692a;

        ValuesCollection(MapCollections mapCollections) {
            this.f3692a = mapCollections;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f3692a.m5273c();
        }

        public boolean contains(Object obj) {
            return this.f3692a.m5270b(obj) >= 0;
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
            return this.f3692a.m5263a() == 0;
        }

        public Iterator<V> iterator() {
            return new ArrayIterator(this.f3692a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f3692a.m5270b(obj);
            if (b < 0) {
                return false;
            }
            this.f3692a.m5267a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f3692a.m5263a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f3692a.m5265a(i, 1))) {
                    this.f3692a.m5267a(i);
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
            int a = this.f3692a.m5263a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f3692a.m5265a(i, 1))) {
                    this.f3692a.m5267a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f3692a.m5263a();
        }

        public Object[] toArray() {
            return this.f3692a.m5272b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f3692a.m5269a((Object[]) tArr, 1);
        }
    }

    protected abstract int m5263a();

    protected abstract int m5264a(Object obj);

    protected abstract Object m5265a(int i, int i2);

    protected abstract V m5266a(int i, V v);

    protected abstract void m5267a(int i);

    protected abstract void m5268a(K k, V v);

    protected abstract int m5270b(Object obj);

    protected abstract Map<K, V> m5271b();

    protected abstract void m5273c();

    MapCollections() {
    }

    public static <K, V> boolean m5259a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m5261b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m5262c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] m5272b(int i) {
        int a = m5263a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m5265a(i2, i);
        }
        return objArr;
    }

    public <T> T[] m5269a(T[] tArr, int i) {
        T[] tArr2;
        int a = m5263a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = m5265a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m5260a(Set<T> set, Object obj) {
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

    public Set<Entry<K, V>> m5274d() {
        if (this.f3603b == null) {
            this.f3603b = new EntrySet(this);
        }
        return this.f3603b;
    }

    public Set<K> m5275e() {
        if (this.f3604c == null) {
            this.f3604c = new KeySet(this);
        }
        return this.f3604c;
    }

    public Collection<V> m5276f() {
        if (this.f3605d == null) {
            this.f3605d = new ValuesCollection(this);
        }
        return this.f3605d;
    }
}
