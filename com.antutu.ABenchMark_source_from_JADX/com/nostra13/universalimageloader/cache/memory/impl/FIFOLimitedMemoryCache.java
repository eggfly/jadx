package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FIFOLimitedMemoryCache extends LimitedMemoryCache {
    private final List<Bitmap> queue;

    public FIFOLimitedMemoryCache(int i) {
        super(i);
        this.queue = Collections.synchronizedList(new LinkedList());
    }

    public void clear() {
        this.queue.clear();
        super.clear();
    }

    protected Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    protected int getSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.queue.add(bitmap);
        return true;
    }

    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.queue.remove(bitmap);
        }
        return super.remove(str);
    }

    protected Bitmap removeNext() {
        return (Bitmap) this.queue.remove(0);
    }
}
