package com.igexin.push.p178e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.igexin.push.core.C3852d;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.p182d.p185c.C3876e;
import com.igexin.push.p182d.p185c.C3889n;
import com.igexin.sdk.aidl.C3864a;
import java.util.List;

/* renamed from: com.igexin.push.e.g */
class C3906g implements ServiceConnection {
    final /* synthetic */ C3901b f13146a;
    final /* synthetic */ String f13147b;
    final /* synthetic */ C3902c f13148c;

    C3906g(C3902c c3902c, C3901b c3901b, String str) {
        this.f13148c = c3902c;
        this.f13146a = c3901b;
        this.f13147b = str;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f13148c.f13135b == C3852d.active) {
            try {
                this.f13146a.m16007a(C3864a.m15908a(iBinder));
                this.f13148c.f13140g.put(this.f13147b, this.f13146a);
                if (this.f13146a.m16011c().onASNLConnected(this.f13146a.m16005a(), this.f13146a.m16009b(), this.f13147b, 0) == -1) {
                    this.f13148c.f13140g.remove(this.f13147b);
                } else if (C3855g.f12976n) {
                    this.f13146a.m16011c().onASNLNetworkConnected();
                }
            } catch (Exception e) {
                this.f13148c.f13140g.remove(this.f13147b);
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f13148c.f13135b == C3852d.active) {
            C3901b c3901b = (C3901b) this.f13148c.f13140g.get(this.f13147b);
            this.f13148c.f13140g.remove(this.f13147b);
            List a = this.f13148c.m16023c(c3901b.m16014e());
            if (a.size() != 0) {
                for (int i = 0; i < a.size(); i++) {
                    String str = (String) a.get(i);
                    if (str.startsWith("S-")) {
                        C3876e c3889n = new C3889n();
                        c3889n.f13105a = Long.valueOf(str.substring(2)).longValue();
                        C3854f.m15859a().m15877g().m16058a("S-" + String.valueOf(c3889n.f13105a), c3889n, true);
                    }
                    this.f13148c.f13141h.remove(str);
                }
            }
        }
    }
}
