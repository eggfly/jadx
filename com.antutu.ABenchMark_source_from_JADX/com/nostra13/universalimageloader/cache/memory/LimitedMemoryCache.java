package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.C4039L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LimitedMemoryCache extends BaseMemoryCache {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final AtomicInteger cacheSize;
    private final List<Bitmap> hardCache;
    private final int sizeLimit;

    public LimitedMemoryCache(int i) {
        this.hardCache = Collections.synchronizedList(new LinkedList());
        this.sizeLimit = i;
        this.cacheSize = new AtomicInteger();
        if (i > MAX_NORMAL_CACHE_SIZE) {
            C4039L.m16509w("You set too large memory cache size (more than %1$d Mb)", Integer.valueOf(MAX_NORMAL_CACHE_SIZE_IN_MB));
        }
    }

    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    protected abstract int getSize(Bitmap bitmap);

    protected int getSizeLimit() {
        return this.sizeLimit;
    }

    public boolean put(String str, Bitmap bitmap) {
        boolean z = false;
        int size = getSize(bitmap);
        int sizeLimit = getSizeLimit();
        int i = this.cacheSize.get();
        if (size < sizeLimit) {
            int i2 = i;
            while (i2 + size > sizeLimit) {
                Bitmap removeNext = removeNext();
                if (this.hardCache.remove(removeNext)) {
                    i2 = this.cacheSize.addAndGet(-getSize(removeNext));
                }
            }
            this.hardCache.add(bitmap);
            this.cacheSize.addAndGet(size);
            z = true;
        }
        super.put(str, bitmap);
        return z;
    }

    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null && this.hardCache.remove(bitmap)) {
            this.cacheSize.addAndGet(-getSize(bitmap));
        }
        return super.remove(str);
    }

    protected abstract Bitmap removeNext();
}
