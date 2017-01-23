import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class l<K, V> extends r<K, V> implements Map<K, V> {
    q<K, V> j6;

    public l(int i) {
        super(i);
    }

    private q<K, V> DW() {
        if (this.j6 == null) {
            this.j6 = new l$1(this);
        }
        return this.j6;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        j6(this.gn + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean j6(Collection<?> collection) {
        return q.FH(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return DW().Hw();
    }

    public Set<K> keySet() {
        return DW().v5();
    }

    public Collection<V> values() {
        return DW().Zo();
    }
}
