package com.google.android.gms.internal;

import com.google.android.gms.common.internal.b;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class hj implements ThreadFactory {
    private final int DW;
    private final AtomicInteger FH;
    private final ThreadFactory Hw;
    private final String j6;

    public hj(String str) {
        this(str, 0);
    }

    public hj(String str, int i) {
        this.FH = new AtomicInteger();
        this.Hw = Executors.defaultThreadFactory();
        this.j6 = (String) b.j6((Object) str, (Object) "Name must not be null");
        this.DW = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.Hw.newThread(new hk(runnable, this.DW));
        String str = this.j6;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.FH.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
