package com.google.android.gms.p146b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.C3512u;

@gb
/* renamed from: com.google.android.gms.b.hp */
public class hp {
    private HandlerThread f11341a;
    private Handler f11342b;
    private int f11343c;
    private final Object f11344d;

    /* renamed from: com.google.android.gms.b.hp.1 */
    class C32751 implements Runnable {
        final /* synthetic */ hp f11340a;

        C32751(hp hpVar) {
            this.f11340a = hpVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.f11340a;
            r1 = r0.f11344d;
            monitor-enter(r1);
            r0 = "Suspending the looper thread";
            com.google.android.gms.p146b.hf.m12982e(r0);	 Catch:{ all -> 0x002a }
        L_0x000c:
            r0 = r2.f11340a;	 Catch:{ all -> 0x002a }
            r0 = r0.f11343c;	 Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x002d;
        L_0x0014:
            r0 = r2.f11340a;	 Catch:{ InterruptedException -> 0x0023 }
            r0 = r0.f11344d;	 Catch:{ InterruptedException -> 0x0023 }
            r0.wait();	 Catch:{ InterruptedException -> 0x0023 }
            r0 = "Looper thread resumed";
            com.google.android.gms.p146b.hf.m12982e(r0);	 Catch:{ InterruptedException -> 0x0023 }
            goto L_0x000c;
        L_0x0023:
            r0 = move-exception;
            r0 = "Looper thread interrupted.";
            com.google.android.gms.p146b.hf.m12982e(r0);	 Catch:{ all -> 0x002a }
            goto L_0x000c;
        L_0x002a:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x002a }
            throw r0;
        L_0x002d:
            monitor-exit(r1);	 Catch:{ all -> 0x002a }
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.hp.1.run():void");
        }
    }

    public hp() {
        this.f11341a = null;
        this.f11342b = null;
        this.f11343c = 0;
        this.f11344d = new Object();
    }

    public Looper m13153a() {
        Looper looper;
        synchronized (this.f11344d) {
            if (this.f11343c != 0) {
                C3512u.m14581a(this.f11341a, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.f11341a == null) {
                hf.m12982e("Starting the looper thread.");
                this.f11341a = new HandlerThread("LooperProvider");
                this.f11341a.start();
                this.f11342b = new Handler(this.f11341a.getLooper());
                hf.m12982e("Looper thread started.");
            } else {
                hf.m12982e("Resuming the looper thread");
                this.f11344d.notifyAll();
            }
            this.f11343c++;
            looper = this.f11341a.getLooper();
        }
        return looper;
    }

    public void m13154b() {
        synchronized (this.f11344d) {
            C3512u.m14589b(this.f11343c > 0, "Invalid state: release() called more times than expected.");
            int i = this.f11343c - 1;
            this.f11343c = i;
            if (i == 0) {
                this.f11342b.post(new C32751(this));
            }
        }
    }
}
