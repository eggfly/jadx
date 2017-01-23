package com.miui.support.util.cache;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache<K, T> implements Cache<K, T> {
    private ConcurrentHashMap<K, SoftReference<T>> f3851a;

    public SoftCache() {
        this.f3851a = new ConcurrentHashMap();
    }

    public void m5608a(K k, T t, int i) {
        m5605b();
        this.f3851a.put(k, new SoftReference(t));
    }

    public T m5606a(K k) {
        m5605b();
        SoftReference softReference = (SoftReference) this.f3851a.get(k);
        return softReference == null ? null : softReference.get();
    }

    public void m5607a() {
        for (Entry value : this.f3851a.entrySet()) {
            ((SoftReference) value.getValue()).clear();
        }
        this.f3851a.clear();
    }

    private void m5605b() {
        Iterator it = this.f3851a.entrySet().iterator();
        while (it.hasNext()) {
            if (((SoftReference) ((Entry) it.next()).getValue()).get() == null) {
                it.remove();
            }
        }
    }
}
