package com.mob.tools;

import android.os.Looper;
import android.os.Process;

public class MobHandlerThread extends Thread {
    private Looper mLooper;
    private int mPriority;
    private int mTid;

    public MobHandlerThread() {
        this.mTid = -1;
        this.mPriority = 0;
    }

    public MobHandlerThread(int i) {
        this.mTid = -1;
        this.mPriority = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Looper getLooper() {
        /*
        r1 = this;
        r0 = r1.isAlive();
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = 0;
    L_0x0007:
        return r0;
    L_0x0008:
        monitor-enter(r1);
    L_0x0009:
        r0 = r1.isAlive();	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0019;
    L_0x000f:
        r0 = r1.mLooper;	 Catch:{ all -> 0x001d }
        if (r0 != 0) goto L_0x0019;
    L_0x0013:
        r1.wait();	 Catch:{ InterruptedException -> 0x0017 }
        goto L_0x0009;
    L_0x0017:
        r0 = move-exception;
        goto L_0x0009;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        r0 = r1.mLooper;
        goto L_0x0007;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.MobHandlerThread.getLooper():android.os.Looper");
    }

    public int getThreadId() {
        return this.mTid;
    }

    protected void onLooperPrepared() {
    }

    public boolean quit() {
        Looper looper = getLooper();
        if (looper == null) {
            return false;
        }
        looper.quit();
        return true;
    }

    public void run() {
        this.mTid = Process.myTid();
        Looper.prepare();
        synchronized (this) {
            this.mLooper = Looper.myLooper();
            notifyAll();
        }
        Process.setThreadPriority(this.mPriority);
        onLooperPrepared();
        Looper.loop();
        this.mTid = -1;
    }
}
