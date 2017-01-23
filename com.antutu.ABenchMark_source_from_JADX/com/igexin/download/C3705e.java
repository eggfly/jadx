package com.igexin.download;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.lang.reflect.Method;

/* renamed from: com.igexin.download.e */
public class C3705e implements ServiceConnection {
    final /* synthetic */ DownloadService f12509a;

    public C3705e(DownloadService downloadService) {
        this.f12509a = downloadService;
    }

    public void m15186a() {
        synchronized (this.f12509a) {
            if (this.f12509a.f12489h != null) {
                this.f12509a.f12489h = null;
                try {
                    this.f12509a.unbindService(this);
                } catch (IllegalArgumentException e) {
                }
            }
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f12509a.f12488g = false;
        synchronized (this.f12509a) {
            try {
                Method method = Class.forName("android.media.IMediaScannerService").getField("Stub").getType().getMethod("asInterface", new Class[]{IBinder.class});
                this.f12509a.f12489h = method.invoke(null, new Object[]{iBinder});
                if (this.f12509a.f12489h != null) {
                    this.f12509a.m15153a();
                }
            } catch (Exception e) {
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f12509a) {
            this.f12509a.f12489h = null;
        }
    }
}
