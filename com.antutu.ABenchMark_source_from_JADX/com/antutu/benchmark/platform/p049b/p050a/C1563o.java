package com.antutu.benchmark.platform.p049b.p050a;

import java.util.HashMap;

/* renamed from: com.antutu.benchmark.platform.b.a.o */
public class C1563o<K, V> extends HashMap<K, V> {
    protected V f5438a;

    public C1563o(V v) {
        this.f5438a = v;
    }

    public V get(Object obj) {
        V v = super.get(obj);
        return v == null ? this.f5438a : v;
    }
}
