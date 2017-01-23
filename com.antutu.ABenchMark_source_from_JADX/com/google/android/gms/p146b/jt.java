package com.google.android.gms.p146b;

import android.os.Process;

/* renamed from: com.google.android.gms.b.jt */
class jt implements Runnable {
    private final Runnable f11570a;
    private final int f11571b;

    public jt(Runnable runnable, int i) {
        this.f11570a = runnable;
        this.f11571b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f11571b);
        this.f11570a.run();
    }
}
