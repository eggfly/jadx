package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LargestLimitedMemoryCache extends LimitedMemoryCache {
    private final Map<Bitmap, Integer> valueSizes;

    public LargestLimitedMemoryCache(int i) {
        super(i);
        this.valueSizes = Collections.synchronizedMap(new HashMap());
    }

    public void clear() {
        this.valueSizes.clear();
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
        this.valueSizes.put(bitmap, Integer.valueOf(getSize(bitmap)));
        return true;
    }

    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.valueSizes.remove(bitmap);
        }
        return super.remove(str);
    }

    protected Bitmap removeNext() {
        Bitmap bitmap = null;
        Set<Entry> entrySet = this.valueSizes.entrySet();
        synchronized (this.valueSizes) {
            Integer num = null;
            for (Entry entry : entrySet) {
                Bitmap bitmap2;
                Integer num2;
                if (bitmap == null) {
                    bitmap2 = (Bitmap) entry.getKey();
                    num2 = (Integer) entry.getValue();
                } else {
                    Integer num3 = (Integer) entry.getValue();
                    if (num3.intValue() > num.intValue()) {
                        Bitmap bitmap3 = (Bitmap) entry.getKey();
                        num2 = num3;
                        bitmap2 = bitmap3;
                    } else {
                        bitmap2 = bitmap;
                        num2 = num;
                    }
                }
                bitmap = bitmap2;
                num = num2;
            }
        }
        this.valueSizes.remove(bitmap);
        return bitmap;
    }
}
