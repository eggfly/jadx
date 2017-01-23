package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    MapCollections<K, V> f711a;

    /* renamed from: android.support.v4.util.ArrayMap.1 */
    class C00781 extends MapCollections<K, V> {
        final /* synthetic */ ArrayMap f703a;

        C00781(ArrayMap arrayMap) {
            this.f703a = arrayMap;
        }

        protected int m1069a() {
            return this.f703a.h;
        }

        protected Object m1071a(int i, int i2) {
            return this.f703a.g[(i << 1) + i2];
        }

        protected int m1070a(Object obj) {
            return this.f703a.m1081a(obj);
        }

        protected int m1075b(Object obj) {
            return this.f703a.m1085b(obj);
        }

        protected Map<K, V> m1076b() {
            return this.f703a;
        }

        protected void m1074a(K k, V v) {
            this.f703a.put(k, v);
        }

        protected V m1072a(int i, V v) {
            return this.f703a.m1083a(i, (Object) v);
        }

        protected void m1073a(int i) {
            this.f703a.m1088d(i);
        }

        protected void m1077c() {
            this.f703a.clear();
        }
    }

    private MapCollections<K, V> m1089b() {
        if (this.f711a == null) {
            this.f711a = new C00781(this);
        }
        return this.f711a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1084a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean m1090a(Collection<?> collection) {
        return MapCollections.m1054c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m1089b().m1066d();
    }

    public Set<K> keySet() {
        return m1089b().m1067e();
    }

    public Collection<V> values() {
        return m1089b().m1068f();
    }
}
