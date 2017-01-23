package com.miui.support.util.cache;

import android.app.ActivityManager;
import com.miui.support.util.AppConstants;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

public class LruCache<K, V> implements Cache<K, V> {
    private static final int f3846a;
    private final ReentrantLock f3847b;
    private long f3848c;
    private long f3849d;
    private final LinkedHashMap<K, CacheItem<K, V>> f3850e;

    private static class CacheItem<K, T> {
        public K f3842a;
        public int f3843b;
        public T f3844c;
        public SoftReference<T> f3845d;

        private CacheItem() {
        }
    }

    static {
        f3846a = (((ActivityManager) AppConstants.m4227a().getSystemService("activity")).getMemoryClass() * 1024) * 1024;
    }

    public LruCache(int i) {
        if (i < 0) {
            i = f3846a / 8;
        }
        this.f3847b = new ReentrantLock();
        this.f3848c = (long) i;
        this.f3849d = 0;
        this.f3850e = new LinkedHashMap(0, 0.75f, true);
    }

    public void m5604a(K k, V v, int i) {
        if (k != null && v != null) {
            CacheItem cacheItem = new CacheItem();
            cacheItem.f3842a = k;
            cacheItem.f3844c = v;
            if (i < 0) {
                i = 0;
            }
            cacheItem.f3843b = i;
            this.f3847b.lock();
            try {
                this.f3850e.put(k, cacheItem);
                this.f3849d = ((long) cacheItem.f3843b) + this.f3849d;
                m5601b();
            } finally {
                this.f3847b.unlock();
            }
        }
    }

    public V m5602a(K k) {
        V v = null;
        this.f3847b.lock();
        try {
            m5601b();
            CacheItem cacheItem = (CacheItem) this.f3850e.get(k);
            if (cacheItem == null) {
                return v;
            }
            V v2;
            if (cacheItem.f3844c != null) {
                v2 = cacheItem.f3844c;
                this.f3847b.unlock();
                return v2;
            }
            if (cacheItem.f3845d != null) {
                cacheItem.f3844c = cacheItem.f3845d.get();
                if (cacheItem.f3844c != null) {
                    this.f3849d += (long) cacheItem.f3843b;
                    if (this.f3849d > this.f3848c) {
                        m5601b();
                    }
                    v2 = cacheItem.f3844c;
                    this.f3847b.unlock();
                    return v2;
                }
            }
            this.f3850e.remove(k);
            this.f3847b.unlock();
            return null;
        } finally {
            v = this.f3847b;
            v.unlock();
        }
    }

    public void m5603a() {
        this.f3847b.lock();
        try {
            for (Entry value : this.f3850e.entrySet()) {
                CacheItem cacheItem = (CacheItem) value.getValue();
                if (cacheItem.f3845d != null) {
                    cacheItem.f3845d.clear();
                }
            }
            this.f3850e.clear();
        } finally {
            this.f3847b.unlock();
        }
    }

    private void m5601b() {
        Iterator it = this.f3850e.entrySet().iterator();
        while (it.hasNext()) {
            CacheItem cacheItem = (CacheItem) ((Entry) it.next()).getValue();
            if (cacheItem.f3844c == null && (cacheItem.f3845d == null || cacheItem.f3845d.get() == null)) {
                it.remove();
            }
        }
        it = this.f3850e.entrySet().iterator();
        while (this.f3849d > this.f3848c && it.hasNext()) {
            cacheItem = (CacheItem) ((Entry) it.next()).getValue();
            if (cacheItem != null) {
                if (cacheItem.f3845d == null) {
                    cacheItem.f3845d = new SoftReference(cacheItem.f3844c);
                }
                this.f3849d -= (long) cacheItem.f3843b;
                cacheItem.f3844c = null;
            }
        }
    }
}
