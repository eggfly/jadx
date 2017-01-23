package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.d */
public class C3455d implements ServiceConnection {
    boolean f11999a;
    private final BlockingQueue<IBinder> f12000b;

    public C3455d() {
        this.f11999a = false;
        this.f12000b = new LinkedBlockingQueue();
    }

    public IBinder m14265a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.f11999a) {
            throw new IllegalStateException();
        } else {
            this.f11999a = true;
            return (IBinder) this.f12000b.take();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f12000b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
