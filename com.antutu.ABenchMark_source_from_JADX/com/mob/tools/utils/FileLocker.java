package com.mob.tools.utils;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class FileLocker {
    private FileOutputStream fos;
    private FileLock lock;

    public synchronized void lock(Runnable runnable, boolean z) {
        if (lock(z) && runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean lock(boolean r3) {
        /*
        r2 = this;
        r0 = 0;
        monitor-enter(r2);
        r1 = r2.fos;	 Catch:{ all -> 0x0037 }
        if (r1 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r2);
        return r0;
    L_0x0008:
        if (r3 == 0) goto L_0x001c;
    L_0x000a:
        r1 = r2.fos;	 Catch:{ Throwable -> 0x0029 }
        r1 = r1.getChannel();	 Catch:{ Throwable -> 0x0029 }
        r1 = r1.lock();	 Catch:{ Throwable -> 0x0029 }
        r2.lock = r1;	 Catch:{ Throwable -> 0x0029 }
    L_0x0016:
        r1 = r2.lock;	 Catch:{ all -> 0x0037 }
        if (r1 == 0) goto L_0x0006;
    L_0x001a:
        r0 = 1;
        goto L_0x0006;
    L_0x001c:
        r1 = r2.fos;	 Catch:{ Throwable -> 0x0029 }
        r1 = r1.getChannel();	 Catch:{ Throwable -> 0x0029 }
        r1 = r1.tryLock();	 Catch:{ Throwable -> 0x0029 }
        r2.lock = r1;	 Catch:{ Throwable -> 0x0029 }
        goto L_0x0016;
    L_0x0029:
        r1 = move-exception;
        r1 = r2.lock;	 Catch:{ all -> 0x0037 }
        if (r1 == 0) goto L_0x0016;
    L_0x002e:
        r1 = r2.lock;	 Catch:{ Throwable -> 0x003a }
        r1.release();	 Catch:{ Throwable -> 0x003a }
    L_0x0033:
        r1 = 0;
        r2.lock = r1;	 Catch:{ all -> 0x0037 }
        goto L_0x0016;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x003a:
        r1 = move-exception;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.FileLocker.lock(boolean):boolean");
    }

    public synchronized void release() {
        if (this.fos != null) {
            unlock();
            try {
                this.fos.close();
                this.fos = null;
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setLockFile(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x000a }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x000a }
        r1.fos = r0;	 Catch:{ Throwable -> 0x000a }
    L_0x0008:
        monitor-exit(r1);
        return;
    L_0x000a:
        r0 = move-exception;
        r0 = r1.fos;	 Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x0008;
    L_0x000f:
        r0 = r1.fos;	 Catch:{ Throwable -> 0x001b }
        r0.close();	 Catch:{ Throwable -> 0x001b }
    L_0x0014:
        r0 = 0;
        r1.fos = r0;	 Catch:{ all -> 0x0018 }
        goto L_0x0008;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x001b:
        r0 = move-exception;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.FileLocker.setLockFile(java.lang.String):void");
    }

    public synchronized void unlock() {
        if (this.lock != null) {
            try {
                this.lock.release();
                this.lock = null;
            } catch (Throwable th) {
            }
        }
    }
}
