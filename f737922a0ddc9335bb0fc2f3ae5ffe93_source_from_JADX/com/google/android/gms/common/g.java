package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.b;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class g implements ServiceConnection {
    private final BlockingQueue<IBinder> DW;
    boolean j6;

    public g() {
        this.j6 = false;
        this.DW = new LinkedBlockingQueue();
    }

    public IBinder j6(long j, TimeUnit timeUnit) {
        b.FH("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.j6) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.j6 = true;
        IBinder iBinder = (IBinder) this.DW.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.DW.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
