package com.google.android.gms.internal;

import android.os.Process;

class hk implements Runnable {
    private final int DW;
    private final Runnable j6;

    public hk(Runnable runnable, int i) {
        this.j6 = runnable;
        this.DW = i;
    }

    public void run() {
        Process.setThreadPriority(this.DW);
        this.j6.run();
    }
}
