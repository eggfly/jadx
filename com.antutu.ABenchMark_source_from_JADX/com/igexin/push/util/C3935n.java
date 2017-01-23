package com.igexin.push.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.igexin.push.util.n */
final class C3935n implements ServiceConnection {
    boolean f13215a;
    private final LinkedBlockingQueue f13216b;

    private C3935n() {
        this.f13215a = false;
        this.f13216b = new LinkedBlockingQueue(1);
    }

    public IBinder m16188a() {
        if (this.f13215a) {
            throw new IllegalStateException();
        }
        this.f13215a = true;
        return (IBinder) this.f13216b.take();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f13216b.put(iBinder);
        } catch (Exception e) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
