import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class q$b implements Set<Entry<K, V>> {
    final /* synthetic */ q j6;

    q$b(q qVar) {
        this.j6 = qVar;
    }

    public /* synthetic */ boolean add(Object obj) {
        return j6((Entry) obj);
    }

    public boolean j6(Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends Entry<K, V>> collection) {
        int j6 = this.j6.j6();
        for (Entry entry : collection) {
            this.j6.j6(entry.getKey(), entry.getValue());
        }
        return j6 != this.j6.j6();
    }

    public void clear() {
        this.j6.FH();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int j6 = this.j6.j6(entry.getKey());
        if (j6 >= 0) {
            return m.j6(this.j6.j6(j6, 1), entry.getValue());
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
        return this.j6.j6() == 0;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new q$d(this.j6);
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
        return this.j6.j6();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        return q.j6((Set) this, obj);
    }

    public int hashCode() {
        int j6 = this.j6.j6() - 1;
        int i = 0;
        while (j6 >= 0) {
            Object j62 = this.j6.j6(j6, 0);
            Object j63 = this.j6.j6(j6, 1);
            j6--;
            i += (j63 == null ? 0 : j63.hashCode()) ^ (j62 == null ? 0 : j62.hashCode());
        }
        return i;
    }
}
