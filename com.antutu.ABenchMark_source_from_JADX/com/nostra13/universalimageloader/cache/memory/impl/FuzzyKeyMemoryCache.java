package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;

public class FuzzyKeyMemoryCache implements MemoryCache {
    private final MemoryCache cache;
    private final Comparator<String> keyComparator;

    public FuzzyKeyMemoryCache(MemoryCache memoryCache, Comparator<String> comparator) {
        this.cache = memoryCache;
        this.keyComparator = comparator;
    }

    public void clear() {
        this.cache.clear();
    }

    public Bitmap get(String str) {
        return this.cache.get(str);
    }

    public Collection<String> keys() {
        return this.cache.keys();
    }

    public boolean put(String str, Bitmap bitmap) {
        synchronized (this.cache) {
            for (String str2 : this.cache.keys()) {
                if (this.keyComparator.compare(str, str2) == 0) {
                    break;
                }
            }
            String str22 = null;
            if (str22 != null) {
                this.cache.remove(str22);
            }
        }
        return this.cache.put(str, bitmap);
    }

    public Bitmap remove(String str) {
        return this.cache.remove(str);
    }
}
