import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class q$c implements Set<K> {
    final /* synthetic */ q j6;

    q$c(q qVar) {
        this.j6 = qVar;
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.j6.FH();
    }

    public boolean contains(Object obj) {
        return this.j6.j6(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        return q.j6(this.j6.DW(), (Collection) collection);
    }

    public boolean isEmpty() {
        return this.j6.j6() == 0;
    }

    public Iterator<K> iterator() {
        return new q$a(this.j6, 0);
    }

    public boolean remove(Object obj) {
        int j6 = this.j6.j6(obj);
        if (j6 < 0) {
            return false;
        }
        this.j6.j6(j6);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return q.DW(this.j6.DW(), collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return q.FH(this.j6.DW(), collection);
    }

    public int size() {
        return this.j6.j6();
    }

    public Object[] toArray() {
        return this.j6.DW(0);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.j6.j6((Object[]) tArr, 0);
    }

    public boolean equals(Object obj) {
        return q.j6((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int j6 = this.j6.j6() - 1; j6 >= 0; j6--) {
            Object j62 = this.j6.j6(j6, 0);
            i += j62 == null ? 0 : j62.hashCode();
        }
        return i;
    }
}
