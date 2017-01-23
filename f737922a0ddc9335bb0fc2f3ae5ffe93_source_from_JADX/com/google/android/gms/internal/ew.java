package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@eh
public class ew {
    private AtomicInteger DW;
    Map<Integer, Bitmap> j6;

    public ew() {
        this.j6 = new ConcurrentHashMap();
        this.DW = new AtomicInteger(0);
    }

    public Bitmap j6(Integer num) {
        return (Bitmap) this.j6.get(num);
    }
}
