package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRULimitedMemoryCache extends LimitedMemoryCache {
    private static final int INITIAL_CAPACITY = 10;
    private static final float LOAD_FACTOR = 1.1f;
    private final Map<String, Bitmap> lruCache;

    public LRULimitedMemoryCache(int i) {
        super(i);
        this.lruCache = Collections.synchronizedMap(new LinkedHashMap(INITIAL_CAPACITY, LOAD_FACTOR, true));
    }

    public void clear() {
        this.lruCache.clear();
        super.clear();
    }

    protected Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    public Bitmap get(String str) {
        this.lruCache.get(str);
        return super.get(str);
    }

    protected int getSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.lruCache.put(str, bitmap);
        return true;
    }

    public Bitmap remove(String str) {
        this.lruCache.remove(str);
        return super.remove(str);
    }

    protected Bitmap removeNext() {
        Bitmap bitmap = null;
        synchronized (this.lruCache) {
            Iterator it = this.lruCache.entrySet().iterator();
            if (it.hasNext()) {
                bitmap = (Bitmap) ((Entry) it.next()).getValue();
                it.remove();
            }
        }
        return bitmap;
    }
}
