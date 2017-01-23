package com.igexin.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.igexin.p158b.p159a.p167c.C3688a;

/* renamed from: com.igexin.sdk.d */
class C3948d implements ServiceConnection {
    final /* synthetic */ PushService f13249a;

    C3948d(PushService pushService) {
        this.f13249a = pushService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C3688a.m15097b(PushService.f13230a + "|bind PushServiceUser success");
        this.f13249a.f13234e = true;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C3688a.m15097b(PushService.f13230a + "|PushServiceUser onServiceDisconnected");
        this.f13249a.f13234e = false;
        if (this.f13249a.f13233d) {
            C3688a.m15097b(PushService.f13230a + "|stop PushServiceUser by getui, onServiceDisconnected, stop");
            this.f13249a.f13233d = false;
            return;
        }
        C3688a.m15097b(PushService.f13230a + "|stop PushServiceUser by usr, restart #########");
        try {
            this.f13249a.bindService(new Intent(this.f13249a, PushServiceUser.class), this.f13249a.f13235f, 1);
        } catch (Throwable th) {
        }
    }
}
