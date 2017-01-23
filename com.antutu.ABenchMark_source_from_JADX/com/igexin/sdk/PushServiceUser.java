package com.igexin.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.sdk.aidl.C3945c;

public class PushServiceUser extends Service {
    private static String f13236a;
    private final C3945c f13237b;

    static {
        f13236a = "PushServiceUser";
    }

    public PushServiceUser() {
        this.f13237b = new C3949e(this);
    }

    public IBinder onBind(Intent intent) {
        return this.f13237b;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onLowMemory() {
        C3688a.m15097b(f13236a + " PushServiceUser Low Memory!");
        super.onLowMemory();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }
}
