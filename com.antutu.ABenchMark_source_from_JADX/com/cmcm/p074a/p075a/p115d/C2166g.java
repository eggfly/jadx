package com.cmcm.p074a.p075a.p115d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.cmcm.a.a.d.g */
public class C2166g implements ServiceConnection {
    boolean f7530a;
    private final BlockingQueue f7531b;

    public C2166g() {
        this.f7530a = false;
        this.f7531b = new LinkedBlockingQueue();
    }

    public IBinder m8162a() {
        if (this.f7530a) {
            throw new IllegalStateException();
        }
        this.f7530a = true;
        return (IBinder) this.f7531b.take();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f7531b.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
