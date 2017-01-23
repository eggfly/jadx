package com.igexin.push.p178e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.igexin.push.core.C3849c;
import com.igexin.push.core.C3852d;
import com.igexin.push.core.C3854f;
import com.igexin.sdk.aidl.C3864a;

/* renamed from: com.igexin.push.e.f */
class C3905f implements ServiceConnection {
    final /* synthetic */ C3902c f13145a;

    C3905f(C3902c c3902c) {
        this.f13145a = c3902c;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f13145a.f13135b == C3852d.prepare) {
            this.f13145a.f13138e.m16007a(C3864a.m15908a(iBinder));
            C3900a c3900a = new C3900a();
            c3900a.m16004a(C3849c.connectASNL);
            this.f13145a.m16038a(c3900a);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f13145a.f13135b == C3852d.passive) {
            C3854f.m15859a().m15877g().m16064b(true);
            this.f13145a.m16024c();
        }
    }
}
