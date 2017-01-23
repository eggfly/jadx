import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class afm<E> extends AbstractSet<E> {
    private final l<E, E> j6;

    public afm() {
        this.j6 = new l();
    }

    public afm(int i) {
        this.j6 = new l(i);
    }

    public afm(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean add(E e) {
        if (this.j6.containsKey(e)) {
            return false;
        }
        this.j6.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof afm ? j6((afm) collection) : super.addAll(collection);
    }

    public void clear() {
        this.j6.clear();
    }

    public boolean contains(Object obj) {
        return this.j6.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.j6.keySet().iterator();
    }

    public boolean j6(afm<? extends E> afm__extends_E) {
        int size = size();
        this.j6.j6(afm__extends_E.j6);
        return size() > size;
    }

    public boolean remove(Object obj) {
        if (!this.j6.containsKey(obj)) {
            return false;
        }
        this.j6.remove(obj);
        return true;
    }

    public int size() {
        return this.j6.size();
    }
}
