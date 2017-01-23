import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class q<K, V> {
    q$b DW;
    q$c FH;
    q$e Hw;

    protected abstract int DW(Object obj);

    protected abstract Map<K, V> DW();

    protected abstract void FH();

    protected abstract int j6();

    protected abstract int j6(Object obj);

    protected abstract Object j6(int i, int i2);

    protected abstract V j6(int i, V v);

    protected abstract void j6(int i);

    protected abstract void j6(K k, V v);

    q() {
    }

    public static <K, V> boolean j6(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean DW(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean FH(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] DW(int i) {
        int j6 = j6();
        Object[] objArr = new Object[j6];
        for (int i2 = 0; i2 < j6; i2++) {
            objArr[i2] = j6(i2, i);
        }
        return objArr;
    }

    public <T> T[] j6(T[] tArr, int i) {
        T[] tArr2;
        int j6 = j6();
        if (tArr.length < j6) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), j6);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < j6; i2++) {
            tArr2[i2] = j6(i2, i);
        }
        if (tArr2.length > j6) {
            tArr2[j6] = null;
        }
        return tArr2;
    }

    public static <T> boolean j6(Set<T> set, Object obj) {
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

    public Set<Entry<K, V>> Hw() {
        if (this.DW == null) {
            this.DW = new q$b(this);
        }
        return this.DW;
    }

    public Set<K> v5() {
        if (this.FH == null) {
            this.FH = new q$c(this);
        }
        return this.FH;
    }

    public Collection<V> Zo() {
        if (this.Hw == null) {
            this.Hw = new q$e(this);
        }
        return this.Hw;
    }
}
