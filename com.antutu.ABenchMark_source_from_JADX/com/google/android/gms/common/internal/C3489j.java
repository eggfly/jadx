package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.j */
public final class C3489j implements Callback {
    final ArrayList<C2921b> f12083a;
    private final C2925a f12084b;
    private final ArrayList<C2921b> f12085c;
    private final ArrayList<C2922c> f12086d;
    private volatile boolean f12087e;
    private final AtomicInteger f12088f;
    private boolean f12089g;
    private final Handler f12090h;
    private final Object f12091i;

    /* renamed from: com.google.android.gms.common.internal.j.a */
    public interface C2925a {
        boolean m11357e();

        Bundle e_();
    }

    public C3489j(Looper looper, C2925a c2925a) {
        this.f12085c = new ArrayList();
        this.f12083a = new ArrayList();
        this.f12086d = new ArrayList();
        this.f12087e = false;
        this.f12088f = new AtomicInteger(0);
        this.f12089g = false;
        this.f12091i = new Object();
        this.f12084b = c2925a;
        this.f12090h = new Handler(looper, this);
    }

    public void m14380a() {
        this.f12087e = false;
        this.f12088f.incrementAndGet();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m14381a(int r6) {
        /*
        r5 = this;
        r0 = 0;
        r1 = 1;
        r2 = android.os.Looper.myLooper();
        r3 = r5.f12090h;
        r3 = r3.getLooper();
        if (r2 != r3) goto L_0x000f;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r2 = "onUnintentionalDisconnection must only be called on the Handler thread";
        com.google.android.gms.common.internal.C3512u.m14585a(r0, r2);
        r0 = r5.f12090h;
        r0.removeMessages(r1);
        r1 = r5.f12091i;
        monitor-enter(r1);
        r0 = 1;
        r5.f12089g = r0;	 Catch:{ all -> 0x005e }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x005e }
        r2 = r5.f12085c;	 Catch:{ all -> 0x005e }
        r0.<init>(r2);	 Catch:{ all -> 0x005e }
        r2 = r5.f12088f;	 Catch:{ all -> 0x005e }
        r2 = r2.get();	 Catch:{ all -> 0x005e }
        r3 = r0.iterator();	 Catch:{ all -> 0x005e }
    L_0x0030:
        r0 = r3.hasNext();	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0048;
    L_0x0036:
        r0 = r3.next();	 Catch:{ all -> 0x005e }
        r0 = (com.google.android.gms.common.api.C3427c.C2921b) r0;	 Catch:{ all -> 0x005e }
        r4 = r5.f12087e;	 Catch:{ all -> 0x005e }
        if (r4 == 0) goto L_0x0048;
    L_0x0040:
        r4 = r5.f12088f;	 Catch:{ all -> 0x005e }
        r4 = r4.get();	 Catch:{ all -> 0x005e }
        if (r4 == r2) goto L_0x0052;
    L_0x0048:
        r0 = r5.f12083a;	 Catch:{ all -> 0x005e }
        r0.clear();	 Catch:{ all -> 0x005e }
        r0 = 0;
        r5.f12089g = r0;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        return;
    L_0x0052:
        r4 = r5.f12085c;	 Catch:{ all -> 0x005e }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x005e }
        if (r4 == 0) goto L_0x0030;
    L_0x005a:
        r0.m11337a(r6);	 Catch:{ all -> 0x005e }
        goto L_0x0030;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.j.a(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m14382a(android.os.Bundle r6) {
        /*
        r5 = this;
        r2 = 0;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r3 = r5.f12090h;
        r3 = r3.getLooper();
        if (r0 != r3) goto L_0x006e;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r3 = "onConnectionSuccess must only be called on the Handler thread";
        com.google.android.gms.common.internal.C3512u.m14585a(r0, r3);
        r3 = r5.f12091i;
        monitor-enter(r3);
        r0 = r5.f12089g;	 Catch:{ all -> 0x0080 }
        if (r0 != 0) goto L_0x0070;
    L_0x001b:
        r0 = r1;
    L_0x001c:
        com.google.android.gms.common.internal.C3512u.m14584a(r0);	 Catch:{ all -> 0x0080 }
        r0 = r5.f12090h;	 Catch:{ all -> 0x0080 }
        r4 = 1;
        r0.removeMessages(r4);	 Catch:{ all -> 0x0080 }
        r0 = 1;
        r5.f12089g = r0;	 Catch:{ all -> 0x0080 }
        r0 = r5.f12083a;	 Catch:{ all -> 0x0080 }
        r0 = r0.size();	 Catch:{ all -> 0x0080 }
        if (r0 != 0) goto L_0x0072;
    L_0x0030:
        com.google.android.gms.common.internal.C3512u.m14584a(r1);	 Catch:{ all -> 0x0080 }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0080 }
        r1 = r5.f12085c;	 Catch:{ all -> 0x0080 }
        r0.<init>(r1);	 Catch:{ all -> 0x0080 }
        r1 = r5.f12088f;	 Catch:{ all -> 0x0080 }
        r1 = r1.get();	 Catch:{ all -> 0x0080 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0080 }
    L_0x0044:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x0064;
    L_0x004a:
        r0 = r2.next();	 Catch:{ all -> 0x0080 }
        r0 = (com.google.android.gms.common.api.C3427c.C2921b) r0;	 Catch:{ all -> 0x0080 }
        r4 = r5.f12087e;	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x0064;
    L_0x0054:
        r4 = r5.f12084b;	 Catch:{ all -> 0x0080 }
        r4 = r4.m11357e();	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x0064;
    L_0x005c:
        r4 = r5.f12088f;	 Catch:{ all -> 0x0080 }
        r4 = r4.get();	 Catch:{ all -> 0x0080 }
        if (r4 == r1) goto L_0x0074;
    L_0x0064:
        r0 = r5.f12083a;	 Catch:{ all -> 0x0080 }
        r0.clear();	 Catch:{ all -> 0x0080 }
        r0 = 0;
        r5.f12089g = r0;	 Catch:{ all -> 0x0080 }
        monitor-exit(r3);	 Catch:{ all -> 0x0080 }
        return;
    L_0x006e:
        r0 = r2;
        goto L_0x000f;
    L_0x0070:
        r0 = r2;
        goto L_0x001c;
    L_0x0072:
        r1 = r2;
        goto L_0x0030;
    L_0x0074:
        r4 = r5.f12083a;	 Catch:{ all -> 0x0080 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0080 }
        if (r4 != 0) goto L_0x0044;
    L_0x007c:
        r0.m11338a(r6);	 Catch:{ all -> 0x0080 }
        goto L_0x0044;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0080 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.j.a(android.os.Bundle):void");
    }

    public void m14383a(ConnectionResult connectionResult) {
        C3512u.m14585a(Looper.myLooper() == this.f12090h.getLooper(), (Object) "onConnectionFailure must only be called on the Handler thread");
        this.f12090h.removeMessages(1);
        synchronized (this.f12091i) {
            ArrayList arrayList = new ArrayList(this.f12086d);
            int i = this.f12088f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C2922c c2922c = (C2922c) it.next();
                if (!this.f12087e || this.f12088f.get() != i) {
                    return;
                } else if (this.f12086d.contains(c2922c)) {
                    c2922c.m11339a(connectionResult);
                }
            }
        }
    }

    public void m14384a(C2921b c2921b) {
        C3512u.m14580a((Object) c2921b);
        synchronized (this.f12091i) {
            if (this.f12085c.contains(c2921b)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + c2921b + " is already registered");
            } else {
                this.f12085c.add(c2921b);
            }
        }
        if (this.f12084b.m11357e()) {
            this.f12090h.sendMessage(this.f12090h.obtainMessage(1, c2921b));
        }
    }

    public void m14385a(C2922c c2922c) {
        C3512u.m14580a((Object) c2922c);
        synchronized (this.f12091i) {
            if (this.f12086d.contains(c2922c)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + c2922c + " is already registered");
            } else {
                this.f12086d.add(c2922c);
            }
        }
    }

    public void m14386b() {
        this.f12087e = true;
    }

    public void m14387b(C2922c c2922c) {
        C3512u.m14580a((Object) c2922c);
        synchronized (this.f12091i) {
            if (!this.f12086d.remove(c2922c)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + c2922c + " not found");
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            C2921b c2921b = (C2921b) message.obj;
            synchronized (this.f12091i) {
                if (this.f12087e && this.f12084b.m11357e() && this.f12085c.contains(c2921b)) {
                    c2921b.m11338a(this.f12084b.e_());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
