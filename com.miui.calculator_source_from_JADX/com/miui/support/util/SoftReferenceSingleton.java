package com.miui.support.util;

import java.lang.ref.SoftReference;

public abstract class SoftReferenceSingleton<T> {
    private SoftReference<T> mInstance;

    protected abstract T createInstance();

    public SoftReferenceSingleton() {
        this.mInstance = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mInstance;	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x000d;
    L_0x0005:
        r0 = r2.mInstance;	 Catch:{ all -> 0x001a }
        r0 = r0.get();	 Catch:{ all -> 0x001a }
        if (r0 != 0) goto L_0x0018;
    L_0x000d:
        r0 = r2.createInstance();	 Catch:{ all -> 0x001a }
        r1 = new java.lang.ref.SoftReference;	 Catch:{ all -> 0x001a }
        r1.<init>(r0);	 Catch:{ all -> 0x001a }
        r2.mInstance = r1;	 Catch:{ all -> 0x001a }
    L_0x0018:
        monitor-exit(r2);	 Catch:{ all -> 0x001a }
        return r0;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.util.SoftReferenceSingleton.get():T");
    }
}
