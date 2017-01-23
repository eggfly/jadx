package com.facebook.ads.internal.p121f.p132b;

import android.util.SparseArray;

/* renamed from: com.facebook.ads.internal.f.b.a */
public class C2424a {
    private final SparseArray<int[]> f8371a;

    public C2424a() {
        this.f8371a = new SparseArray();
    }

    public void m9277a(int i, int[] iArr) {
        this.f8371a.put(i, iArr);
    }

    public int[] m9278a(int i) {
        return (int[]) this.f8371a.get(i);
    }

    public boolean m9279b(int i) {
        return this.f8371a.indexOfKey(i) >= 0;
    }
}
