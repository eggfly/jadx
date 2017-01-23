import java.util.Collection;
import java.util.Iterator;

final class q$e implements Collection<V> {
    final /* synthetic */ q j6;

    q$e(q qVar) {
        this.j6 = qVar;
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.j6.FH();
    }

    public boolean contains(Object obj) {
        return this.j6.DW(obj) >= 0;
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

    public Iterator<V> iterator() {
        return new q$a(this.j6, 1);
    }

    public boolean remove(Object obj) {
        int DW = this.j6.DW(obj);
        if (DW < 0) {
            return false;
        }
        this.j6.j6(DW);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        int i = 0;
        int j6 = this.j6.j6();
        boolean z = false;
        while (i < j6) {
            if (collection.contains(this.j6.j6(i, 1))) {
                this.j6.j6(i);
                i--;
                j6--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        int i = 0;
        int j6 = this.j6.j6();
        boolean z = false;
        while (i < j6) {
            if (!collection.contains(this.j6.j6(i, 1))) {
                this.j6.j6(i);
                i--;
                j6--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.j6.j6();
    }

    public Object[] toArray() {
        return this.j6.DW(1);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.j6.j6((Object[]) tArr, 1);
    }
}
